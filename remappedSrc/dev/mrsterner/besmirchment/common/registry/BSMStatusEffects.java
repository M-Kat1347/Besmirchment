package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.statuseffect.LoveStatusEffect;
import moriyashiine.bewitchment.common.statuseffect.EmptyStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.registry.Registry;

public class BSMStatusEffects {
    public static final StatusEffect LOVE = new LoveStatusEffect();
    public static final StatusEffect SUNSCREEN = new EmptyStatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFF8F);

    public static void init(){
        BSMUtil.register(Registry.STATUS_EFFECT,"love", LOVE);
        BSMUtil.register(Registry.STATUS_EFFECT,"sunscreen", SUNSCREEN);
    }
}
