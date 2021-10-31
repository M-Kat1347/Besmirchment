package dev.mrsterner.besmirchment.mixin;

import net.minecraft.entity.ai.brain.sensor.VillagerHostilesSensor;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VillagerHostilesSensor.class)
public class VillagerHostilesSensorMixin {
    /*
    @Inject(method = "getNearestHostile", at = @At("RETURN"), cancellable = true)
    private void getNearestHostile(LivingEntity entity, CallbackInfoReturnable<Optional<LivingEntity>> cir){
        if (!cir.getReturnValue().isPresent()){
            PlayerEntity fleePlayer = entity.world.getClosestPlayer(new TargetPredicate().setBaseMaxDistance(12).setPredicate(player -> BSMTransformations.isLich(player, false)), entity);
            if (fleePlayer != null){
                cir.setReturnValue(Optional.of(fleePlayer));
            }
        }
    }

     */
}
