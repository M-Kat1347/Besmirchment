package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.Besmirchment;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class BSMTags {
    public static TagKey<EntityType<?>> ILLEGAL_FAMILIARS = TagKey.of(RegistryKeys.ENTITY_TYPE, Besmirchment.id("illegal_familiars"));
    public static TagKey<EntityType<?>> PURE_SOULS = TagKey.of(RegistryKeys.ENTITY_TYPE, Besmirchment.id("pure_souls"));

    public static TagKey<Block> GHOST_IMPASSABLE = TagKey.of(RegistryKeys.BLOCK, Besmirchment.id("ghost_impassable"));

    public static TagKey<Block> GHOST_WHITELIST = TagKey.of(RegistryKeys.BLOCK, Besmirchment.id("ghost_whitelist"));


}
