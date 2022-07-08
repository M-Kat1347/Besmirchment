package dev.mrsterner.besmirchment.client.renderer;

import dev.mrsterner.besmirchment.client.BesmirchmentClient;
import dev.mrsterner.besmirchment.client.model.WerepyreEntityModel;
import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.entity.interfaces.DyeableEntity;
import dev.mrsterner.besmirchment.common.entity.WerepyreEntity;
import dev.mrsterner.besmirchment.common.item.WitchyDyeItem;
import moriyashiine.bewitchment.common.entity.living.util.BWHostileEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class WerepyreEntityRenderer extends MobEntityRenderer<WerepyreEntity, WerepyreEntityModel<WerepyreEntity>> {
    private static Identifier[] TEXTURES;
    private static final Identifier UNTINTED_TEXTURE = Besmirchment.id("textures/entity/werepyre/untinted.png");


    public WerepyreEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WerepyreEntityModel<>(context.getPart(BesmirchmentClient.WEREPYRE_MODEL_LAYER)), 1f);
        this.addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
        this.addFeature(new DyedWerepyreFeatureRenderer(this));
    }




    @Override
    public Identifier getTexture(WerepyreEntity entity) {
        if (((DyeableEntity) entity).getColor() >= 0 || ((DyeableEntity) entity).getColor() == WitchyDyeItem.FUNNI_NUMBER){
            return UNTINTED_TEXTURE;
        }
        if (TEXTURES == null) {
            int variants = entity.getVariants();
            TEXTURES = new Identifier[variants];
            for (int i = 0; i < variants; ++i) {
                TEXTURES[i] = Besmirchment.id("textures/entity/werepyre/" + i + ".png");
            }
        }
         return TEXTURES[entity.getDataTracker().get(BWHostileEntity.VARIANT)];
    }
}