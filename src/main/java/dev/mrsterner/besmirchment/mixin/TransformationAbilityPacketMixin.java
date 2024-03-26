package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.registry.BSMEntityTypes;
import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import dev.mrsterner.besmirchment.common.transformation.LichAccessor;
import dev.mrsterner.besmirchment.common.transformation.LichLogic;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import moriyashiine.bewitchment.client.packet.SpawnSmokeParticlesPacket;
import moriyashiine.bewitchment.common.packet.TransformationAbilityPacket;
import moriyashiine.bewitchment.common.registry.BWComponents;
import moriyashiine.bewitchment.common.registry.BWScaleTypes;
import moriyashiine.bewitchment.common.registry.BWSoundEvents;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import virtuoel.pehkui.api.ScaleData;

@Mixin(value = TransformationAbilityPacket.class, remap = false)
public class TransformationAbilityPacketMixin {
    private static final float WEREPYRE_WIDTH = BSMEntityTypes.WEREPYRE.getWidth() / EntityType.PLAYER.getWidth();
    private static final float WEREPYRE_HEIGHT = BSMEntityTypes.WEREPYRE.getHeight() / EntityType.PLAYER.getHeight();

    @Inject(method = "canUseAbility", at = @At("HEAD"), cancellable = true)
    private static void canUseAbility(PlayerEntity player, CallbackInfoReturnable<Boolean> cir){
        if (BSMTransformations.isWerepyre(player, true)){
            cir.setReturnValue(true);
        }
        if (BSMTransformations.isLich(player, false)) {
            if (BWComponents.TRANSFORMATION_COMPONENT.get(player).isAlternateForm()) {
                cir.setReturnValue(true);
            } else {
                ((LichAccessor) player).updateCachedSouls();
                cir.setReturnValue(((LichAccessor) player).getCachedSouls() >= LichLogic.STAGE_TWO_SOULS);
            }
        }
    }

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "useAbility", at = @At(value = "HEAD"), cancellable = true)
    private static void useAbility(PlayerEntity player, boolean forced, CallbackInfo ci){
        if (BWComponents.TRANSFORMATION_COMPONENT.get(player).getTransformation() == BSMTransformations.LICH){
            World world = player.getWorld();
            boolean isInAlternateForm = BWComponents.TRANSFORMATION_COMPONENT.get(player).isAlternateForm();
            if (isInAlternateForm || BewitchmentAPI.drainMagic(player, 10, true)) {
                world.playSound(null, player.getBlockPos(), BWSoundEvents.ENTITY_GENERIC_TRANSFORM, player.getSoundCategory(), 1.0F, 1.0F);
                BWComponents.TRANSFORMATION_COMPONENT.get(player).setAlternateForm(!isInAlternateForm);
                ci.cancel();
            }
        }
        if (BWComponents.TRANSFORMATION_COMPONENT.get(player).getTransformation() == BSMTransformations.WEREPYRE && (forced || BSMTransformations.hasWerepyrePledge(player))){
            World world = player.getWorld();
            boolean isInAlternateForm = BWComponents.TRANSFORMATION_COMPONENT.get(player).isAlternateForm();
            ScaleData width = BWScaleTypes.MODIFY_WIDTH_TYPE.getScaleData(player);
            ScaleData height = BWScaleTypes.MODIFY_HEIGHT_TYPE.getScaleData(player);
            if (player instanceof ServerPlayerEntity serverPlayerEntity) {
                PlayerLookup.tracking(player).forEach(foundPlayer -> SpawnSmokeParticlesPacket.send(foundPlayer, player));
                SpawnSmokeParticlesPacket.send(serverPlayerEntity, player);
            }
            world.playSound(null, player.getBlockPos(), BWSoundEvents.ENTITY_GENERIC_TRANSFORM, player.getSoundCategory(), 1.0F, 1.0F);
            BWComponents.TRANSFORMATION_COMPONENT.get(player).setAlternateForm(!isInAlternateForm);
            if (isInAlternateForm) {
                width.setScale(width.getScale() / WEREPYRE_WIDTH);
                height.setScale(height.getScale() / WEREPYRE_HEIGHT);
                if (player.hasStatusEffect(StatusEffects.NIGHT_VISION) && player.getStatusEffect(StatusEffects.NIGHT_VISION).isAmbient()) {
                    player.removeStatusEffect(StatusEffects.NIGHT_VISION);
                }
            } else {
                width.setScale(width.getScale() * WEREPYRE_WIDTH);
                height.setScale(height.getScale() * WEREPYRE_HEIGHT);
            }
            ci.cancel();
        }
    }
}
