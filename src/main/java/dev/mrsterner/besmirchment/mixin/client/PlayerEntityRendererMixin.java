package dev.mrsterner.besmirchment.mixin.client;

import dev.mrsterner.besmirchment.client.renderer.LichRollAccessor;
import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Environment(EnvType.CLIENT)
@Mixin(value = PlayerEntityRenderer.class, priority = 999)
public class PlayerEntityRendererMixin {
    @ModifyArgs(method = "setupTransforms", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerp(FFF)F"))
    private void setupGhostSwimg(Args args, AbstractClientPlayerEntity abstractClientPlayerEntity, MatrixStack matrixStack, float f, float g, float h) {
        if (BSMTransformations.isLich(abstractClientPlayerEntity, true)){
            args.set(2, -90.0F - abstractClientPlayerEntity.getPitch());
        }
    }

    @Inject(method = "setupTransforms", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;multiply(Lorg/joml/Quaternionf;)V", ordinal = 2, shift = At.Shift.AFTER))
    private void ghostRollLetsGoooo(AbstractClientPlayerEntity abstractClientPlayerEntity, MatrixStack matrixStack, float f, float g, float h, CallbackInfo ci) {
        if (BSMTransformations.isLich(abstractClientPlayerEntity, true) && ((LichRollAccessor) abstractClientPlayerEntity).getLastRollTicks() < 20){
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotation((float) ((((LichRollAccessor) abstractClientPlayerEntity).getLastRollTicks() + h) / 20 * Math.PI * 2)));
        }
    }
}
