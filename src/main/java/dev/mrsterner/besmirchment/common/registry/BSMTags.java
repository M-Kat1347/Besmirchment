package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.Besmirchment;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class BSMTags {
    public static TagKey<EntityType<?>> ILLEGAL_FAMILIARS = TagKey.of(Registry.ENTITY_TYPE_KEY, Besmirchment.id("illegal_familiars"));
    public static TagKey<EntityType<?>> PURE_SOULS = TagKey.of(Registry.ENTITY_TYPE_KEY, Besmirchment.id("pure_souls"));
    public static TagKey<Block> GHOST_IMPASSABLE = TagKey.of(Registry.BLOCK_KEY, Besmirchment.id("ghost_impassable"));

}
