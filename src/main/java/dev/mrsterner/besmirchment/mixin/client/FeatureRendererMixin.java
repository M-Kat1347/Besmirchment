package dev.mrsterner.besmirchment.mixin.client;

import dev.mrsterner.besmirchment.client.model.WerepyreEntityModel;
import dev.mrsterner.besmirchment.client.renderer.DyedWerewolfFeatureRenderer;
import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.entity.WerepyreEntity;
import dev.mrsterner.besmirchment.common.entity.interfaces.DyeableEntity;
import dev.mrsterner.besmirchment.common.item.WitchyDyeItem;
import moriyashiine.bewitchment.client.model.entity.living.WerewolfEntityModel;
import moriyashiine.bewitchment.client.renderer.entity.living.WerewolfEntityRenderer;
import moriyashiine.bewitchment.common.entity.living.WerewolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(value = FeatureRenderer.class, remap = false)
public abstract class FeatureRendererMixin<T extends Entity, M extends EntityModel<T>> {


    @Inject(method = "renderModel", at = @At("HEAD"), cancellable = true)
    private static <T extends LivingEntity> void renderModel(EntityModel<T> model, Identifier texture, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float red, float green, float blue, CallbackInfo ci){
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(texture));
        if(model instanceof WerepyreEntityModel werepyreEntityModel){
            matrices.translate(0F,0.85F,0F);
            werepyreEntityModel.neck.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(entity, 0.0F), red, green, blue, 1.0F);
            werepyreEntityModel.lArm01.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(entity, 0.0F), red, green, blue, 1.0F);
            werepyreEntityModel.rArm01.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(entity, 0.0F), red, green, blue, 1.0F);
            matrices.translate(0,-0.85F,0);
            werepyreEntityModel.body.render(matrices, vertexConsumer, light, LivingEntityRenderer.getOverlay(entity, 0.0F), red, green, blue, 1.0F);
            ci.cancel();
        }

    }
}
