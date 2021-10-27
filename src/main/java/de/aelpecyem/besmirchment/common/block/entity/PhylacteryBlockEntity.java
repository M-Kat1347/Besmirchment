package de.aelpecyem.besmirchment.common.block.entity;

import de.aelpecyem.besmirchment.common.registry.BSMBlockEntityTypes;
import de.aelpecyem.besmirchment.common.transformation.LichAccessor;
import de.aelpecyem.besmirchment.common.transformation.LichLogic;
import de.aelpecyem.besmirchment.common.world.BSMWorldState;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.UUID;


public class PhylacteryBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
    public static final int MAX_SOULS = 8;
    public int souls;
    public PhylacteryBlockEntity(BlockPos pos, BlockState state) {
        super(BSMBlockEntityTypes.PHYLACTERY, pos, state);
    }


    @Override
    public void fromClientTag(NbtCompound compoundTag) {
        souls = compoundTag.getInt("Souls");
    }

    @Override
    public NbtCompound toClientTag(NbtCompound compoundTag) {
        compoundTag.putInt("Souls", souls);
        return compoundTag;
    }



    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        toClientTag(tag);
        return super.writeNbt(tag);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        fromClientTag(nbt);
    }


    public int addSouls(int amount){
        int cachedAmount = souls;
        this.souls = MathHelper.clamp(souls + amount, 0, MAX_SOULS);
        updatePlayerCache();
        markDirty();
        return souls - cachedAmount;
    }

    public boolean drainSoul(int amount){
        if ((souls - amount) >= 0){
            souls -= amount;
            updatePlayerCache();
            markDirty();
            return true;
        }
        return false;
    }

    public void updatePlayerCache(){
        if (world instanceof ServerWorld) {
            BSMWorldState worldState = BSMWorldState.get(world);
            UUID foundUUID = LichLogic.getPlayerForPhylactery(worldState, pos);
            if (foundUUID != null) {
                for (ServerPlayerEntity player : PlayerLookup.all(world.getServer())) {
                    if (player.getUuid().equals(foundUUID)) {
                        ((LichAccessor) player).updateCachedSouls();
                    }
                }
            }
        }
    }
}
