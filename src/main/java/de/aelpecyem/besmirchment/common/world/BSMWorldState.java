package de.aelpecyem.besmirchment.common.world;

import de.aelpecyem.besmirchment.common.Besmirchment;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BSMWorldState extends PersistentState {
    public static final Map<UUID, BlockPos> phylacteries = new HashMap<>();


    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        NbtList phylacteryList = new NbtList();
        phylacteries.forEach(((uuid, blockPos) -> {
            NbtCompound phylacteryTag = new NbtCompound();
            phylacteryTag.putUuid("Player", uuid);
            phylacteryTag.put("Pos", NbtHelper.fromBlockPos(blockPos));
            phylacteryList.add(phylacteryTag);
        }));
        tag.put("Phylacteries", phylacteryList);
        return tag;
    }

    public void addPhylactery(UUID uuid, BlockPos pos){
        phylacteries.put(uuid, pos);
        markDirty();
    }

    public void removePhylactery(UUID uuid){
        phylacteries.remove(uuid);
        markDirty();
    }

    public static BSMWorldState readNbt(NbtCompound tag) {
        BSMWorldState worldState = new BSMWorldState();
        NbtList phylacteryList = tag.getList("Phylacteries", 10);
        for (NbtElement nbt : phylacteryList) {
            NbtCompound phylacteryTag = (NbtCompound) nbt;
            phylacteries.put(phylacteryTag.getUuid("Player"), NbtHelper.toBlockPos(phylacteryTag.getCompound("Pos")));
        }
        return worldState;
    }

    public static BSMWorldState get(World world) {
        return ((ServerWorld) world).getPersistentStateManager().getOrCreate(BSMWorldState::readNbt, BSMWorldState::new, Besmirchment.MODID + "_universal");
    }
}