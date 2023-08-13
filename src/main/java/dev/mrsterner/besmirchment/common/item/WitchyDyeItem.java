package dev.mrsterner.besmirchment.common.item;

import dev.mrsterner.besmirchment.common.Besmirchment;
import dev.mrsterner.besmirchment.common.entity.WitchyDyeEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class WitchyDyeItem extends Item implements DyeableItem {
    public static final int FUNNI_NUMBER = -69;
    public WitchyDyeItem(Item.Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (MathHelper.nextFloat(world.random, 0,1) * 0.4F + 0.8F));
        if (!world.isClient) {
            ThrownItemEntity potion = new WitchyDyeEntity(world, user);
            potion.setItem(itemStack);
            potion.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.8F, 1.0F);
            world.spawnEntity(potion);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public int getColor(ItemStack stack){
        if (stack.hasNbt() && stack.getNbt().contains("Color")){
            return stack.getNbt().getInt("Color");
        }
        return 0xFFFFFF;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return stack.hasNbt() && stack.getNbt().contains("Color") ? super.getTranslationKey(stack) : "item." + Besmirchment.MODID + ".witchy_bleach";
    }

    @Override
    public void setColor(ItemStack stack, int color) {
        stack.getOrCreateNbt().putInt("Color", color);
    }

    @Override
    public boolean hasColor(ItemStack stack) {
        return stack.hasNbt() && stack.getNbt().contains("Color");
    }

    @Override
    public void removeColor(ItemStack stack) {
        if (stack.hasNbt() && stack.getNbt().contains("Color")) {
            stack.getNbt().remove("color");
        }
    }


    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        /*TODO
        if (isIn(group)) {
            stacks.add(new ItemStack(this));
            for (DyeColor value : DyeColor.values()) {
                ItemStack stack = new ItemStack(this);
                stacks.add(DyeableItem.blendAndSetColor(stack, Collections.singletonList(DyeItem.byColor(value))));
            }
            ItemStack stack = new ItemStack(this);
            setColor(stack, FUNNI_NUMBER);
            stacks.add(stack);

        }

         */
    }
}