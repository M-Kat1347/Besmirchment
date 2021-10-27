package de.aelpecyem.besmirchment.common.world;

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
    public final Map<UUID, BlockPos> phylacteries = new HashMap<>();

    public BSMWorldState(String key) {
        super(key);
    }

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

    public void fromNbt(NbtCompound tag) {
        NbtList phylacteryList = tag.getList("Phylacteries", 10);
        for (NbtElement nbt : phylacteryList) {
            NbtCompound phylacteryTag = (NbtCompound) nbt;
            phylacteries.put(phylacteryTag.getUuid("Player"), NbtHelper.toBlockPos(phylacteryTag.getCompound("Pos")));
        }
    }

    public static BSMWorldState get(World world) {
        return ((ServerWorld) world).getPersistentStateManager().getOrCreate(() -> new BSMWorldState("bsm_data"), "bsm_data");
    }
}