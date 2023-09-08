package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.entity.interfaces.TameableDemon;
import dev.mrsterner.besmirchment.common.registry.BSMTags;
import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Shadow
    private EntityDimensions dimensions;

    @Inject(method = "isInsideWall", at = @At("HEAD"), cancellable = true)
    private void isLichInsideWall(CallbackInfoReturnable<Boolean> cir){
        Entity entity = Entity.class.cast(this);
        if (entity instanceof LivingEntity livingEntity) {
            boolean bl = BSMTransformations.isLich(livingEntity, true);
            boolean bl2 = getState(livingEntity, this.dimensions.width * 0.8F);
            if (bl && bl2) {
                cir.setReturnValue(false);
            }
        }
    }

    private boolean getState(LivingEntity livingEntity, float width){
        Box box = Box.of(livingEntity.getEyePos(), width, 1.0E-6, width);

        return BlockPos.stream(box).anyMatch((pos) -> {
            BlockState blockState = livingEntity.getWorld().getBlockState(pos);
            if (blockState.isIn(BSMTags.GHOST_IMPASSABLE)) {
                return false;
            }

            return !blockState.isAir() &&
                    blockState.shouldSuffocate(livingEntity.getWorld(), pos) &&
                    VoxelShapes.matchesAnywhere(blockState.getCollisionShape(livingEntity.getWorld(), pos).offset(pos.getX(), pos.getY(), pos.getZ()), VoxelShapes.cuboid(box), BooleanBiFunction.AND) &&
                    blockState.isIn(BSMTags.GHOST_WHITELIST)
                    ;
        });
    }

    @Inject(method = "getScoreboardTeam", at = @At("HEAD"), cancellable = true)
    public void getScoreboardTeam(CallbackInfoReturnable<AbstractTeam> cir) {
        if (this instanceof TameableDemon && ((TameableDemon) this).isTamed()) {
            LivingEntity livingEntity = ((TameableDemon) this).getOwner();
            if (livingEntity != null) {
                cir.setReturnValue(livingEntity.getScoreboardTeam());
            }
        }
    }

    @Inject(method = "isTeammate", at = @At("HEAD"), cancellable = true)
    public void isTeammate(Entity other, CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof TameableDemon && ((TameableDemon) this).isTamed()) {
            LivingEntity livingEntity = ((TameableDemon) this).getOwner();
            if (other == livingEntity) {
                cir.setReturnValue(true);
            } else if (livingEntity != null) {
                cir.setReturnValue(livingEntity.isTeammate(other));
            }
        }
    }

    @ModifyVariable(method = "setPose", at = @At("HEAD"))
    private EntityPose setPose(EntityPose pose) {
        if (((Object) this) instanceof PlayerEntity) {
            if (BSMTransformations.isWerepyre((Entity) (Object) this, false)) {
                if (pose == EntityPose.FALL_FLYING || pose == EntityPose.SWIMMING) {
                    return EntityPose.STANDING;
                }
            }
        }
        return pose;
    }

    @Inject(method = "isFireImmune", at = @At("RETURN"), cancellable = true)
    private void isFireImmune(CallbackInfoReturnable<Boolean> callbackInfo) {
        if (callbackInfo.getReturnValue() && BSMTransformations.isWerepyre((Entity) (Object) this, true)) {
            callbackInfo.setReturnValue(false);
        }
    }
}
