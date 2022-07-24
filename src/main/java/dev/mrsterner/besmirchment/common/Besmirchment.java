package dev.mrsterner.besmirchment.common;

import dev.mrsterner.besmirchment.client.packet.FamiliarAbilityPacket;
import dev.mrsterner.besmirchment.client.packet.WerepyreJumpPacket;
import dev.mrsterner.besmirchment.common.entity.WerepyreEntity;
import dev.mrsterner.besmirchment.common.entity.interfaces.DyeableEntity;
import dev.mrsterner.besmirchment.common.packet.SparklePacket;
import dev.mrsterner.besmirchment.common.registry.*;
import dev.mrsterner.besmirchment.common.transformation.LichAccessor;
import dev.mrsterner.besmirchment.common.transformation.WerepyreAccessor;
import eu.midnightdust.lib.config.MidnightConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.api.component.BloodComponent;
import moriyashiine.bewitchment.api.component.CursesComponent;
import moriyashiine.bewitchment.api.component.TransformationComponent;
import moriyashiine.bewitchment.api.event.AllowVampireBurn;
import moriyashiine.bewitchment.api.event.BloodSuckEvents;
import moriyashiine.bewitchment.api.event.ReviveEvents;
import moriyashiine.bewitchment.api.registry.Transformation;
import moriyashiine.bewitchment.client.network.packet.SpawnSmokeParticlesPacket;
import moriyashiine.bewitchment.common.BWConfig;
import moriyashiine.bewitchment.common.Bewitchment;
import moriyashiine.bewitchment.common.entity.living.VampireEntity;
import moriyashiine.bewitchment.common.entity.living.util.BWHostileEntity;
import moriyashiine.bewitchment.common.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

public class Besmirchment implements ModInitializer {
    public static final String MODID = "besmirchment";
    public static final ItemGroup BESMIRCHMENT = FabricItemGroupBuilder.create(Besmirchment.id("group")).icon(() -> new ItemStack(BSMObjects.FINAL_BROOM)).build();

    @Override
    public void onInitialize() {
        MidnightConfig.init(MODID, BSMConfig.class);
        BSMConditions.init();
        BSMContracts.init();
        BSMEntityTypes.init();
        BSMObjects.init();
        BSMBlockEntityTypes.init();
        BSMStatusEffects.init();
        BSMTransformations.init();
        BSMSounds.init();
        BSMRitualFunctions.init();
        ServerPlayNetworking.registerGlobalReceiver(FamiliarAbilityPacket.ID, FamiliarAbilityPacket::handle);
        ServerPlayNetworking.registerGlobalReceiver(WerepyreJumpPacket.ID, WerepyreJumpPacket::handle);
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            if (handler.player instanceof LichAccessor) {
                ((LichAccessor) handler.player).updateCachedSouls();
            }
        });

        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, b) -> {
            ((LichAccessor) newPlayer).updateCachedSouls();
            ((WerepyreAccessor) newPlayer).setWerepyreVariant(((WerepyreAccessor) oldPlayer).getWerepyreVariant());
            ((DyeableEntity) newPlayer).setColor(((DyeableEntity) oldPlayer).getColor());
        });

        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof LivingEntity && hand == Hand.MAIN_HAND && player.isSneaking() && entity.isAlive() && BSMTransformations.isWerepyre(player, true) && player.getStackInHand(hand).isEmpty()) {
                int toGive = entity.getType().isIn(BWTags.HAS_BLOOD) ? 5 : entity instanceof AnimalEntity ? 1 : 0;
                toGive = BloodSuckEvents.BLOOD_AMOUNT.invoker().onBloodSuck(player, (LivingEntity) entity, toGive);
                if (toGive > 0) {
                    BloodComponent playerBlood = BWComponents.BLOOD_COMPONENT.get(player);
                    BloodComponent entityBlood = BWComponents.BLOOD_COMPONENT.get((LivingEntity) entity);
                    if (playerBlood.fillBlood(toGive, true) && entityBlood.drainBlood(10, true)) {
                        if (!world.isClient && ((LivingEntity) entity).hurtTime == 0) {
                            BloodSuckEvents.ON_BLOOD_SUCK.invoker().onBloodSuck(player, (LivingEntity) entity, toGive);
                            world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_HONEY_BOTTLE_DRINK, player.getSoundCategory(), 1, 0.5f);
                            if (!((LivingEntity) entity).isSleeping() || entityBlood.getBlood() < entityBlood.MAX_BLOOD / 2) {
                                entity.damage(BWDamageSources.VAMPIRE, 2);
                            }
                            playerBlood.fillBlood(toGive, false);
                            entityBlood.drainBlood(10, false);
                        }
                        return ActionResult.success(world.isClient);
                    }
                }
            }
            return ActionResult.PASS;
        });
        AllowVampireBurn.EVENT.register(playerEntity -> {
            if(playerEntity.hasStatusEffect(BSMStatusEffects.SUNSCREEN)){
                if (playerEntity.age % 20 == 0) {
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1, true, true));
                    SparklePacket.send(playerEntity);
                }
                return false;
            }
            return true;
        });
        ReviveEvents.ON_REVIVE.register((playerEntity, source, itemStack) -> {
            if ((BWComponents.CURSES_COMPONENT.get(playerEntity).hasCurse(BWCurses.SUSCEPTIBILITY) || !BWConfig.enableCurses)) {
                TransformationComponent transformationComponent = BWComponents.TRANSFORMATION_COMPONENT.get(playerEntity);
                Transformation transformation = transformationComponent.getTransformation();
                if (transformation == BWTransformations.WEREWOLF || transformation == BWTransformations.HUMAN) { //no vampires
                    boolean sourceVampire = source.getSource() instanceof VampireEntity || (BewitchmentAPI.isVampire(source.getSource(), true) && source.getSource() instanceof PlayerEntity && BewitchmentAPI.isPledged((PlayerEntity) source.getSource(), BWPledges.LILITH));
                    boolean sourceWerepyre = source.getSource() instanceof WerepyreEntity || (BSMTransformations.isWerepyre(source.getSource(), true) && BSMTransformations.hasWerepyrePledge((PlayerEntity) source.getSource()));
                    if ((transformation == BWTransformations.WEREWOLF && sourceVampire) || (transformation == BWTransformations.HUMAN && sourceWerepyre)) {
                        transformationComponent.getTransformation().onRemoved(playerEntity);
                        transformationComponent.setTransformation(BSMTransformations.WEREPYRE);
                        transformationComponent.getTransformation().onAdded(playerEntity);
                        PlayerLookup.tracking(playerEntity).forEach(foundPlayer -> SpawnSmokeParticlesPacket.send(foundPlayer, playerEntity));
                        SpawnSmokeParticlesPacket.send(playerEntity, playerEntity);
                        playerEntity.world.playSound(null, playerEntity.getBlockPos(), BWSoundEvents.ENTITY_GENERIC_CURSE, playerEntity.getSoundCategory(), 1, 1);
                        int variant = -1;
                        if (source.getSource() instanceof WerepyreEntity) {
                            variant = source.getSource().getDataTracker().get(BWHostileEntity.VARIANT);
                        } else if (source.getSource() instanceof WerepyreAccessor && BSMTransformations.hasWerepyrePledge((PlayerEntity) source.getSource())) {
                            variant = ((WerepyreAccessor) source.getSource()).getWerepyreVariant();
                        }
                        if (variant > -1) {
                            ((WerepyreAccessor) playerEntity).setWerepyreVariant(variant);
                        }
                    }
                }
            }
        });
    }

    public static Identifier id(String path) {
        return new Identifier(MODID, path);
    }
}
