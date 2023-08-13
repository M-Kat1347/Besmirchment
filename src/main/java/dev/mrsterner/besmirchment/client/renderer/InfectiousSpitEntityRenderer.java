package dev.mrsterner.besmirchment.client.renderer;

import dev.mrsterner.besmirchment.common.entity.InfectiousSpitEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.LlamaSpitEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class InfectiousSpitEntityRenderer extends EntityRenderer<InfectiousSpitEntity> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/llama/spit.png");
    private final LlamaSpitEntityModel<InfectiousSpitEntity> model;

    public InfectiousSpitEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new LlamaSpitEntityModel<>(ctx.getPart(EntityModelLayers.LLAMA_SPIT));
    }


    public void render(InfectiousSpitEntity llamaSpitEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0D, 0.15, 0.0D);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, llamaSpitEntity.prevYaw, llamaSpitEntity.getYaw()) - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, llamaSpitEntity.prevPitch, llamaSpitEntity.getPitch())));
        this.model.setAngles(llamaSpitEntity, g, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        Vec3d rgb = Vec3d.unpackRgb(llamaSpitEntity.getColor());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, (float) rgb.x, (float) rgb.y, (float) rgb.z, 1.0F);
        matrixStack.pop();
        super.render(llamaSpitEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(InfectiousSpitEntity llamaSpitEntity) {
        return TEXTURE;
    }
}