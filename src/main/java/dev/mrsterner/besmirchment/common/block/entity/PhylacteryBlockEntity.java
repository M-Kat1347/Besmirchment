package dev.mrsterner.besmirchment.common.block.entity;

import dev.mrsterner.besmirchment.common.registry.BSMBlockEntityTypes;
import dev.mrsterner.besmirchment.common.transformation.LichAccessor;
import dev.mrsterner.besmirchment.common.transformation.LichLogic;
import dev.mrsterner.besmirchment.common.world.BSMWorldState;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.UUID;


public class PhylacteryBlockEntity extends BlockEntity   {
    public static final int MAX_SOULS = 8;
    public int souls;
    public PhylacteryBlockEntity(BlockPos pos, BlockState state) {
        super(BSMBlockEntityTypes.PHYLACTERY, pos, state);
    }


    public void sync(World world, BlockPos pos) {
        if (world != null && !world.isClient) {
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }


    @Override
    public void writeNbt(NbtCompound tag) {
        tag.putInt("Souls", souls);
        super.writeNbt(tag);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        souls = nbt.getInt("Souls");
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
