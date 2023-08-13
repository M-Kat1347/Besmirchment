package dev.mrsterner.besmirchment.mixin.client;

import dev.mrsterner.besmirchment.client.renderer.TamedDemonEntityRenderer;
import moriyashiine.bewitchment.client.model.entity.living.DemonEntityModel;
import moriyashiine.bewitchment.client.render.entity.living.DemonEntityRenderer;
import moriyashiine.bewitchment.common.entity.living.DemonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(value = DemonEntityRenderer.class, remap = false)
public abstract class DemonEntityRendererMixin extends MobEntityRenderer<DemonEntity, DemonEntityModel<DemonEntity>> {
    public DemonEntityRendererMixin(EntityRendererFactory.Context context, DemonEntityModel<DemonEntity> entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectConstructor(EntityRendererFactory.Context context, CallbackInfo ci) {
        this.addFeature(new TamedDemonEntityRenderer((DemonEntityRenderer) (Object) this));
    }
}
