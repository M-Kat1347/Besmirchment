package dev.mrsterner.besmirchment.client.compat;

import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import moriyashiine.bewitchment.api.BewitchmentAPI;
import net.minecraft.client.MinecraftClient;
import squeek.appleskin.api.AppleSkinApi;
import squeek.appleskin.api.event.HUDOverlayEvent;

public class BSMAppleskin implements AppleSkinApi {
    @Override
    public void registerEvents() {
        HUDOverlayEvent.Saturation.EVENT.register(saturation -> {
            if (BSMTransformations.isWerepyre(MinecraftClient.getInstance().player, true)) {
                saturation.isCanceled = true;
            }
        });
        HUDOverlayEvent.Exhaustion.EVENT.register(exhaustion -> {
            if (BSMTransformations.isWerepyre(MinecraftClient.getInstance().player, true)) {
                exhaustion.isCanceled = true;
            }
        });
        HUDOverlayEvent.Saturation.EVENT.register(saturation -> {
            if (BewitchmentAPI.isVampire(MinecraftClient.getInstance().player, true)) {
                saturation.isCanceled = true;
            }
        });
        HUDOverlayEvent.Exhaustion.EVENT.register(exhaustion -> {
            if (BewitchmentAPI.isVampire(MinecraftClient.getInstance().player, true)) {
                exhaustion.isCanceled = true;
            }
        });
    }
}
