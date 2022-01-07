package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.brain.sensor.VillagerHostilesSensor;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(VillagerHostilesSensor.class)
public class VillagerHostilesSensorMixin {

    @Inject(at = @At("HEAD"), method = "isHostile", cancellable = true)
    private void watchOut(LivingEntity entity, CallbackInfoReturnable<Boolean> cir){
        if (entity instanceof PlayerEntity player && BSMTransformations.isLich(player, false)) {
            cir.setReturnValue(true);
        }
    }



    @Inject(method = "isCloseEnoughForDanger", at = @At("HEAD"), cancellable = true)
    private void getNearestHostile(LivingEntity villager, LivingEntity target, CallbackInfoReturnable<Boolean> cir){
        if (target instanceof PlayerEntity player && BSMTransformations.isLich(player, false)) {
            cir.setReturnValue(target.squaredDistanceTo(villager) <= 12*12);
        }
    }
}
