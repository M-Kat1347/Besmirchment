package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import moriyashiine.bewitchment.api.component.BloodComponent;
import moriyashiine.bewitchment.common.item.BottleOfBloodItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BottleOfBloodItem.class)
public class BottleOfBloodItemMixin {
    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir){
        if (BSMTransformations.isWerepyre(user, true)) {
            BloodComponent.get(user).fillBlood(20, false);
            cir.setReturnValue(Items.POTION.finishUsing(stack, world, user));
        }
    }
}
