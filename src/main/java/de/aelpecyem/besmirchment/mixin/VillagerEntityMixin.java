package de.aelpecyem.besmirchment.mixin;

import de.aelpecyem.besmirchment.common.Besmirchment;
import de.aelpecyem.besmirchment.common.entity.WerepyreEntity;
import de.aelpecyem.besmirchment.common.entity.interfaces.VillagerWerepyreAccessor;
import de.aelpecyem.besmirchment.common.registry.BSMEntityTypes;
import de.aelpecyem.besmirchment.common.registry.BSMStatusEffects;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.api.component.CursesComponent;
import moriyashiine.bewitchment.client.network.packet.SpawnSmokeParticlesPacket;
import moriyashiine.bewitchment.common.registry.BWSoundEvents;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityInteraction;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.VillageGossipType;
import net.minecraft.village.VillagerGossips;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends MerchantEntity implements VillagerWerepyreAccessor {
    @Shadow @Final private VillagerGossips gossip;
    @Unique private NbtCompound storedWerepyre;
    @Unique private int despawnTimer = 2400;

    public VillagerEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void setStoredWerepyre(NbtCompound storedWerepyre) {
        this.storedWerepyre = storedWerepyre;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo callbackInfo) {
        if (!world.isClient && storedWerepyre != null) {
            if (despawnTimer > 0) {
                despawnTimer--;
                if (despawnTimer == 0) {
                    remove(RemovalReason.DISCARDED);
                }
            }
            if (age % 20 == 0 && world.isNight() && BewitchmentAPI.getMoonPhase(world) == 0 && world.isSkyVisible(getBlockPos())) {
                WerepyreEntity entity = BSMEntityTypes.WEREPYRE.create(world);
                if (entity != null) {
                    PlayerLookup.tracking(this).forEach(player -> SpawnSmokeParticlesPacket.send(player, this));
                    world.playSound(null, getX(), getY(), getZ(), BWSoundEvents.ENTITY_GENERIC_TRANSFORM, getSoundCategory(), getSoundVolume(), getSoundPitch());
                    entity.readNbt(storedWerepyre);
                    entity.updatePositionAndAngles(getX(), getY(), getZ(), random.nextFloat() * 360, 0);
                    entity.setHealth(entity.getMaxHealth() * (getHealth() / getMaxHealth()));
                    entity.setFireTicks(getFireTicks());
                    entity.clearStatusEffects();
                    getStatusEffects().forEach(entity::addStatusEffect);
                    CursesComponent.get(entity).getCurses().clear();
                    CursesComponent.get(this).getCurses().forEach((CursesComponent.get(entity))::addCurse);
                    if (despawnTimer >= 0) {
                        despawnTimer = 2400;
                    }
                    entity.storedVillager = writeNbt(new NbtCompound());
                    world.spawnEntity(entity);
                    remove(RemovalReason.DISCARDED);
                }
            }
        }
    }

    @Inject(method = "interactMob", at = @At("HEAD"))
    private void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> callbackInfo) {
        despawnTimer = -1;
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readCustomDataFromTag(NbtCompound tag, CallbackInfo callbackInfo) {
        if (tag.contains("BSMStoredWerepyre")) {
            storedWerepyre = tag.getCompound("BSMStoredWerepyre");
        }
        if (tag.contains("BSMDespawnTimer")) {
            despawnTimer = tag.getInt("BSMDespawnTimer");
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeCustomDataToTag(NbtCompound tag, CallbackInfo callbackInfo) {
        if (storedWerepyre != null) {
            tag.put("BSMStoredWerepyre", storedWerepyre);
        }
        tag.putInt("BSMDespawnTimer", despawnTimer);
    }

    @Inject(method = "isReadyToBreed", at = @At("HEAD"), cancellable = true)
    private void isWillingToBreed(CallbackInfoReturnable<Boolean> cir){
        if (hasStatusEffect(BSMStatusEffects.LOVE) && getBreedingAge() > -1){
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "onInteractionWith", at = @At("HEAD"), cancellable = true)
    private void onInteraction(EntityInteraction interaction, Entity entity, CallbackInfo ci){
        if (entity instanceof PlayerEntity && BewitchmentAPI.getFamiliar((PlayerEntity) entity) == EntityType.VILLAGER){
            if (interaction == EntityInteraction.ZOMBIE_VILLAGER_CURED) {
                this.gossip.startGossip(entity.getUuid(), VillageGossipType.MAJOR_POSITIVE, 40);
                this.gossip.startGossip(entity.getUuid(), VillageGossipType.MINOR_POSITIVE, 50);
            } else if (interaction == EntityInteraction.TRADE) {
                this.gossip.startGossip(entity.getUuid(), VillageGossipType.TRADING, 5);
            } else if (interaction == EntityInteraction.VILLAGER_HURT) {
                this.gossip.startGossip(entity.getUuid(), VillageGossipType.MINOR_NEGATIVE, 10);
            } else if (interaction == EntityInteraction.VILLAGER_KILLED) {
                this.gossip.startGossip(entity.getUuid(), VillageGossipType.MAJOR_NEGATIVE, 5);
            }
            ci.cancel();
        }
    }
    @Inject(method = "getReputation", at = @At("RETURN"), cancellable = true)
    private void getReputation(PlayerEntity player, CallbackInfoReturnable<Integer> cir){
        if (cir.getReturnValue() < Besmirchment.config.universalFamiliars.villagerFamiliarReputationBase && BewitchmentAPI.getFamiliar(player) == EntityType.VILLAGER){
            cir.setReturnValue(Besmirchment.config.universalFamiliars.villagerFamiliarReputationBase);
        }
    }
}
