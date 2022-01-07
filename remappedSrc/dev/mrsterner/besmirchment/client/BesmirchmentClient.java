package dev.mrsterner.besmirchment.client;

import dev.mrsterner.besmirchment.client.model.BeelzebubEntityModel;
import dev.mrsterner.besmirchment.client.model.WerepyreEntityModel;
import dev.mrsterner.besmirchment.client.packet.FamiliarAbilityPacket;
import dev.mrsterner.besmirchment.client.packet.WerepyreJumpPacket;
import dev.mrsterner.besmirchment.client.renderer.*;
import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.item.WitchyDyeItem;
import dev.mrsterner.besmirchment.common.packet.LichRevivePacket;
import dev.mrsterner.besmirchment.common.packet.SparklePacket;
import dev.mrsterner.besmirchment.common.registry.*;
import dev.mrsterner.besmirchment.common.transformation.WerepyreAccessor;
import moriyashiine.bewitchment.common.item.TaglockItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.client.keybinding.KeyBindingRegistryImpl;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class BesmirchmentClient implements ClientModInitializer {
    public static final KeyBinding FAMILIAR_ABILITY = new KeyBinding("key." + Besmirchment.MODID +".familiar_ability", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, "itemGroup.besmirchment.group");
    public int abilityCooldown = 20;
    public static int fogTicks = 0;

    public static final EntityModelLayer WEREPYRE_MODEL_LAYER = new EntityModelLayer(new Identifier(Besmirchment.MODID, "werepyre"), "main");
    public static final EntityModelLayer BEELZEBUB_MODEL_LAYER = new EntityModelLayer(new Identifier(Besmirchment.MODID, "beelzebub"), "main");

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BSMObjects.PHYLACTERY);

        EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.FINAL_BROOM, FinalBroomEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.WITCHY_DYE, FlyingItemEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(WEREPYRE_MODEL_LAYER, WerepyreEntityModel::getTexturedModelData);
        EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.WEREPYRE, WerepyreEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(BEELZEBUB_MODEL_LAYER, BeelzebubEntityModel::getTexturedModelData);
        EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.BEELZEBUB, BeelzebubEntityRenderer::new);


        //EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.WEREPYRE, WerepyreEntityRenderer::new);
        //EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.BEELZEBUB, (dispatcher, context) -> new BeelzebubEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BSMEntityTypes.INFECTIOUS_SPIT, InfectiousSpitEntityRenderer::new);


        BlockEntityRendererRegistry.INSTANCE.register(BSMBlockEntityTypes.PHYLACTERY, ctx -> new PhylacteryBlockEntityRenderer());

        FabricModelPredicateProviderRegistry.register(BSMObjects.DEMONIC_DEED,
        Besmirchment.id("variant"), (stack, world, entity, seed) -> TaglockItem.hasTaglock(stack) ? 1 : 0);


        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 1 ? BSMObjects.WITCHY_DYE.getColor(stack) == WitchyDyeItem.FUNNI_NUMBER ? BSMUtil.HSBtoRGB(
                ((MinecraftClient.getInstance().world.getTime() + MinecraftClient.getInstance().getTickDelta()) % 100) / 100F,
                1, 1) : BSMObjects.WITCHY_DYE.getColor(stack) : 0xFFFFFF, BSMObjects.WITCHY_DYE);

        KeyBindingRegistryImpl.registerKeyBinding(FAMILIAR_ABILITY);
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (minecraftClient.player != null){
                if (BSMTransformations.isLich(minecraftClient.player, true)){
                    if (shouldObscureVision(minecraftClient.player)){
                        fogTicks = 10;
                    }
                    if (minecraftClient.options.keySprint.isPressed()){
                        minecraftClient.player.setSprinting(true);
                    }
                    minecraftClient.player.setVelocity(minecraftClient.player.getRotationVector().multiply(minecraftClient.player.isSprinting() ? 0.8F : 0.5F));
                }
                if (minecraftClient.player.input != null && minecraftClient.player.input.jumping && BSMTransformations.isWerepyre(minecraftClient.player, false) && !minecraftClient.player.isOnGround() && ((WerepyreAccessor) minecraftClient.player).getLastJumpTicks() > 5) {
                    minecraftClient.player.jump();
                    WerepyreJumpPacket.send();
                }
            }
            if (FAMILIAR_ABILITY.wasPressed() && abilityCooldown <= 0){
                FamiliarAbilityPacket.send();
                abilityCooldown = 20;
            }else if (abilityCooldown > 0){
                abilityCooldown--;
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(SparklePacket.ID, SparklePacket::handle);
        ClientPlayNetworking.registerGlobalReceiver(LichRevivePacket.ID, LichRevivePacket::handle);
    }

    public static int getFogTicks(){
        return fogTicks;
    }

    public static boolean shouldObscureVision(PlayerEntity player){
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int i = 0; i < 8; ++i) {
            double x = player.getX() + (double)(((float)(i % 2) - 0.5F) * player.getWidth() * 0.8F);
            double y = player.getEyeY() + (double)(((float)((i >> 1) % 2) - 0.5F) * 0.1F);
            double z = player.getZ() + (double)(((float)((i >> 2) % 2) - 0.5F) * player.getWidth() * 0.8F);
            mutable.set(x, y, z);
            BlockState blockState = player.world.getBlockState(mutable);
            if (blockState.getRenderType() != BlockRenderType.INVISIBLE && blockState.shouldBlockVision(player.world, mutable)) {
                return true;
            }
        }
        return false;
    }
}
