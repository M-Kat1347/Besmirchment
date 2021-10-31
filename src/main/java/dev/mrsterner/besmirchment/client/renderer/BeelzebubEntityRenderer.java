package dev.mrsterner.besmirchment.client.renderer;

import dev.mrsterner.besmirchment.client.BesmirchmentClient;
import dev.mrsterner.besmirchment.client.model.BeelzebubEntityModel;
import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.entity.BeelzebubEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BeelzebubEntityRenderer extends MobEntityRenderer<BeelzebubEntity, BeelzebubEntityModel<BeelzebubEntity>> {
    private static final Identifier TEXTURE = Besmirchment.id("textures/entity/beelzebub.png");

    public BeelzebubEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BeelzebubEntityModel<>(context.getPart(BesmirchmentClient.BEELZEBUB_MODEL_LAYER)), 0.5f);
    }


    @Override
    public void render(BeelzebubEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isSneaking()){
            matrixStack.translate(0, 0.1, 0);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(BeelzebubEntity entity) {
        return TEXTURE;
    }
}