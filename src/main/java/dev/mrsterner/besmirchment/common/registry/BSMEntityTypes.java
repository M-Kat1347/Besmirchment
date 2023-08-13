package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.BSMConfig;
import dev.mrsterner.besmirchment.common.entity.*;
import moriyashiine.bewitchment.common.entity.living.WerewolfEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.Registries;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

import java.util.function.Predicate;


@SuppressWarnings("ConstantConditions")
public class BSMEntityTypes {
    public static final EntityType<FinalBroomEntity> FINAL_BROOM = FabricEntityTypeBuilder.create(SpawnGroup.MISC, FinalBroomEntity::new).dimensions(EntityType.ARROW.getDimensions()).build();
    public static final EntityType<WitchyDyeEntity> WITCHY_DYE = FabricEntityTypeBuilder.<WitchyDyeEntity>create(SpawnGroup.MISC, WitchyDyeEntity::new).dimensions(EntityType.POTION.getDimensions()).trackable(4, 10).build();
    public static final EntityType<InfectiousSpitEntity> INFECTIOUS_SPIT = FabricEntityTypeBuilder.<InfectiousSpitEntity>create(SpawnGroup.MISC, InfectiousSpitEntity::new).dimensions(EntityType.LLAMA_SPIT.getDimensions()).trackable(4, 10).build();
    public static final EntityType<WerepyreEntity> WEREPYRE = FabricEntityTypeBuilder.<WerepyreEntity>create(SpawnGroup.MONSTER, WerepyreEntity::new).dimensions(EntityDimensions.fixed(0.8F, 2.8F)).build();
    public static final EntityType<BeelzebubEntity> BEELZEBUB = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BeelzebubEntity::new).dimensions(EntityDimensions.fixed(1F, 4.2F)).build();

    public static final String BEELZEBUB_PLEDGE = "pledge.besmirchment.beelzebub";
    public static void init(){
        BSMUtil.register(Registries.ENTITY_TYPE, "final_broom", FINAL_BROOM);
        BSMUtil.register(Registries.ENTITY_TYPE, "witchy_dye", WITCHY_DYE);
        BSMUtil.register(Registries.ENTITY_TYPE, "infectious_spit", INFECTIOUS_SPIT);
        BSMUtil.register(Registries.ENTITY_TYPE, "werepyre", WEREPYRE);
        FabricDefaultAttributeRegistry.register(WEREPYRE, WerewolfEntity.createAttributes());
        BSMUtil.register(Registries.ENTITY_TYPE, "beelzebub", BEELZEBUB);
        FabricDefaultAttributeRegistry.register(BEELZEBUB, BeelzebubEntity.createAttributes());
        if (BSMConfig.werepyreWeight > 0) {
            if (registerEntitySpawn(BSMEntityTypes.WEREPYRE, BiomeSelectors.foundInOverworld().and(
                    context -> !context.getBiome().getSpawnSettings().getSpawnEntries(BSMEntityTypes.WEREPYRE.getSpawnGroup()).isEmpty()).and(BiomeSelectors.tag(ConventionalBiomeTags.TAIGA).or(BiomeSelectors.tag(ConventionalBiomeTags.FOREST))), BSMConfig.werepyreWeight, BSMConfig.werepyreMinGroupCount, BSMConfig.werepyreMaxGroupCount)) {
                SpawnRestriction.register(BSMEntityTypes.WEREPYRE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WerepyreEntity::canSpawn);
            }
        }
    }

    private static boolean registerEntitySpawn(EntityType<?> type, Predicate<BiomeSelectionContext> predicate, int weight, int minGroupSize, int maxGroupSize) {
        if (weight < 0) {
            throw new UnsupportedOperationException("Could not register entity type " + type.getTranslationKey() + ": weight " + weight + " cannot be negative.");
        } else if (minGroupSize < 0) {
            throw new UnsupportedOperationException("Could not register entity type " + type.getTranslationKey() + ": minGroupSize " + minGroupSize + " cannot be negative.");
        } else if (maxGroupSize < 0) {
            throw new UnsupportedOperationException("Could not register entity type " + type.getTranslationKey() + ": maxGroupSize " + maxGroupSize + " cannot be negative.");
        } else if (minGroupSize > maxGroupSize) {
            throw new UnsupportedOperationException("Could not register entity type " + type.getTranslationKey() + ": minGroupSize " + minGroupSize + " cannot be greater than maxGroupSize " + maxGroupSize + ".");
        } else if (weight == 0 || minGroupSize == 0) {
            return false;
        }
        BiomeModifications.addSpawn(predicate, type.getSpawnGroup(), type, weight, minGroupSize, maxGroupSize);
        return true;
    }
}
