package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.BSMConfig;
import dev.mrsterner.besmirchment.common.block.NoClipContext;
import dev.mrsterner.besmirchment.common.registry.BSMTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {
    @Inject(method = "getCollisionShape(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;", at = @At("HEAD"), cancellable = true)
    private void getCollisionShape(BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir){
        if (context instanceof NoClipContext && ((NoClipContext) context).bsm_isNoClipping()
        && !world.getBlockState(pos).isIn(BSMTags.GHOST_IMPASSABLE))
        {

            if(BSMConfig.enablePhasingWhitelist)
            {
                if(world.getBlockState(pos).isIn(BSMTags.GHOST_WHITELIST)) {
                    cir.setReturnValue(VoxelShapes.empty());
                }
            } else {
                cir.setReturnValue(VoxelShapes.empty());
            }

        }
    }
}
