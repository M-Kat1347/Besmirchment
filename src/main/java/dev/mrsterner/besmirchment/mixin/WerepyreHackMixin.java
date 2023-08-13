package dev.mrsterner.besmirchment.mixin;

import dev.mrsterner.besmirchment.common.registry.BSMTransformations;
import moriyashiine.bewitchment.common.registry.BWDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({Entity.class, LivingEntity.class, PlayerEntity.class, ServerPlayerEntity.class})
public class WerepyreHackMixin {
	@ModifyVariable(method = "damage", at = @At("HEAD"))
	private DamageSource modifyDamage(DamageSource source) {
		Entity entity = Entity.class.cast(this);
		if (source.isIn(DamageTypeTags.IS_FIRE) && BSMTransformations.isWerepyre(entity, true)) {
			return BWDamageSources.create(entity.getWorld(), BWDamageSources.SUN);
		}
		return source;
	}
}
