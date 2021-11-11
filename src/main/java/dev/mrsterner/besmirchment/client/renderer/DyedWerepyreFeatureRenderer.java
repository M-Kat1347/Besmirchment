package dev.mrsterner.besmirchment.client.renderer;

import dev.mrsterner.besmirchment.client.model.WerepyreEntityModel;
import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.entity.interfaces.DyeableEntity;
import dev.mrsterner.besmirchment.common.entity.WerepyreEntity;
import dev.mrsterner.besmirchment.common.item.WitchyDyeItem;
import dev.mrsterner.besmirchment.common.registry.BSMUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class DyedWerepyreFeatureRenderer extends FeatureRenderer<WerepyreEntity, WerepyreEntityModel<WerepyreEntity>> {
    private static final Identifier TINTED_TEXTURE = Besmirchment.id("textures/entity/werepyre/tinted.png");

    public DyedWerepyreFeatureRenderer(FeatureRendererContext<WerepyreEntity, WerepyreEntityModel<WerepyreEntity>> context) {
        super(context);
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, WerepyreEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        int color = ((DyeableEntity) entity).getColor();
        if (color > -1) {
            Vec3f rgb = new Vec3f(Vec3d.unpackRgb(color));
            render(this.getContextModel(), this.getContextModel(), TINTED_TEXTURE, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, tickDelta, rgb.getX(), rgb.getY(), rgb.getZ());
        }else if(color == WitchyDyeItem.FUNNI_NUMBER){
            Vec3f rgb = new Vec3f(Vec3d.unpackRgb(BSMUtil.HSBtoRGB((animationProgress % 100) / 100F, 1,1)));
            render(this.getContextModel(), this.getContextModel(), TINTED_TEXTURE, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, tickDelta, rgb.getX(), rgb.getY(), rgb.getZ());
        }
    }
}
