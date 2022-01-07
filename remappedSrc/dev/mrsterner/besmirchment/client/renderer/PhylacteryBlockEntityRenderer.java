package dev.mrsterner.besmirchment.client.renderer;

import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.block.entity.PhylacteryBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PhylacteryBlockEntityRenderer implements BlockEntityRenderer<PhylacteryBlockEntity> {
    private static final Identifier PHYLACTERY_TEXTURE = Besmirchment.id("textures/block/phylactery.png");


    @Override
    public void render(PhylacteryBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //matrices.translate(0.5, 0, 0.5);
        ///ORBS.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(PHYLACTERY_TEXTURE)), light, overlay, 1, 1, 1, 1);
    }
}
