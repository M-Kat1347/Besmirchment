package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.block.entity.PhylacteryBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;

public class BSMBlockEntityTypes {
    public static final BlockEntityType<PhylacteryBlockEntity> PHYLACTERY = FabricBlockEntityTypeBuilder.create(PhylacteryBlockEntity::new, BSMObjects.PHYLACTERY).build(null);
    public static void init(){
        BSMUtil.register(Registries.BLOCK_ENTITY_TYPE, "phylactery", PHYLACTERY);
    }
}
