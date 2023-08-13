package dev.mrsterner.besmirchment.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import moriyashiine.bewitchment.api.component.BloodComponent;
import moriyashiine.bewitchment.common.Bewitchment;
import moriyashiine.bewitchment.common.registry.BWComponents;
import moriyashiine.bewitchment.common.registry.BWTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(value = InGameHud.class, priority = 1001)
public abstract class InGameHudMixin {

    private static final Identifier BEWITCHMENT_GUI_ICONS_TEXTURE = new Identifier(Bewitchment.MOD_ID, "textures/gui/icons.png");
    private static final Identifier EMPTY_TEXTURE = new Identifier(Bewitchment.MOD_ID, "textures/gui/empty.png");

    @Shadow
    protected abstract PlayerEntity getCameraPlayer();

    @Shadow
    private int scaledHeight;

    @Shadow
    private int scaledWidth;

    @Unique
    private static boolean hidden = false;

    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "renderStatusBars", at = @At(value = "INVOKE", shift = At.Shift.AFTER, ordinal = 2, target = "Lnet/minecraft/client/MinecraftClient;getProfiler()Lnet/minecraft/util/profiler/Profiler;"))
    private void bsm$renderPre(DrawContext context, CallbackInfo ci) {
        PlayerEntity player = getCameraPlayer();
        if (BSMTransformations.isWerepyre(player, true)) {
            hidden = true;
            drawBlood(context, client.player, (int) (context.getScaledWindowWidth() / 2F + 82), context.getScaledWindowHeight() - 39, 10);
            if (client.player.isSneaking() && client.player.isPartOfGame()) {
                if (client.targetedEntity instanceof LivingEntity living && living.getType().isIn(BWTags.HAS_BLOOD)) {
                    drawBlood(context, living, (int) (context.getScaledWindowWidth() / 2F + 12), (int) (context.getScaledWindowHeight() / 2F + 9), 5);
                }
            }
        }
    }

    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V", ordinal = 3))
    private Identifier bsm$vampireHideFood0(Identifier value) {
        if (hidden) {
            return EMPTY_TEXTURE;
        }
        return value;
    }

    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V", ordinal = 4))
    private Identifier bsm$vampireHideFood1(Identifier value) {
        if (hidden) {
            return EMPTY_TEXTURE;
        }
        return value;
    }

    @ModifyArg(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V", ordinal = 5))
    private Identifier bsm$vampireHideFood2(Identifier value) {
        if (hidden) {
            return EMPTY_TEXTURE;
        }
        return value;
    }

    @Inject(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;getProfiler()Lnet/minecraft/util/profiler/Profiler;", ordinal = 3, shift = At.Shift.BEFORE))
    private void bsm$vampireShowHunger(DrawContext context, CallbackInfo ci) {
        hidden = false;
    }

    @Unique
    private static void drawBlood(DrawContext context, LivingEntity living, int xPos, int yPos, int droplets) {
        int v = living.hasStatusEffect(StatusEffects.HUNGER) ? 9 : 0;
        float blood = ((float) BWComponents.BLOOD_COMPONENT.get(living).getBlood() / BloodComponent.MAX_BLOOD * droplets);
        int full = (int) blood;
        for (int i = 0; i < full; i++) {
            context.drawTexture(BEWITCHMENT_GUI_ICONS_TEXTURE, xPos - i * 8, yPos, 39, v, 9, 9);
        }
        if (full < droplets) {
            float remaining = blood - full;
            context.drawTexture(BEWITCHMENT_GUI_ICONS_TEXTURE, xPos - full * 8, yPos, remaining > 5 / 6f ? 48 : remaining > 4 / 6f ? 57 : remaining > 3 / 6f ? 66 : remaining > 2 / 6f ? 75 : remaining > 1 / 6f ? 84 : remaining > 0 ? 93 : 102, v, 9, 9);
        }
        for (int i = (full + 1); i < droplets; i++) {
            context.drawTexture(BEWITCHMENT_GUI_ICONS_TEXTURE, xPos - i * 8, yPos, 102, v, 9, 9);
        }
    }
}