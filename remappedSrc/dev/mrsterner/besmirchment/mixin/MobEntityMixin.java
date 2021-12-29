package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.entity.interfaces.TameableDemon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class MobEntityMixin {
    @Environment(EnvType.CLIENT)
    @Inject(method = "handleStatus", at = @At("HEAD"))
    public void handleStatus(byte status, CallbackInfo ci) {
        if (this instanceof TameableDemon) {
            if (status == 7) {
                ((TameableDemon) this).showEmoteParticle(true);
            } else if (status == 6) {
                ((TameableDemon) this).showEmoteParticle(false);
            }
        }
    }
/*
    @Inject(method = "canTarget", at = @At("HEAD"), cancellable = true)
    public void canTarget(EntityType<?> type, CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof TameableDemon && ((TameableDemon) this).isOwner(type.PLAYER)){
            cir.setReturnValue(false);
        }
    }

 */
}
