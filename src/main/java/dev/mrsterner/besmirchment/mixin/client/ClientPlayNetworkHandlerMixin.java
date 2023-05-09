package dev.mrsterner.besmirchment.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReceiver;
import dev.mrsterner.besmirchment.common.entity.FinalBroomEntity;
import dev.mrsterner.besmirchment.common.entity.InfectiousSpitEntity;
import dev.mrsterner.besmirchment.common.entity.WitchyDyeEntity;
import dev.mrsterner.besmirchment.common.registry.BSMEntityTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Shadow
    private ClientWorld world;

    @ModifyReceiver(method = "onEntitySpawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/s2c/play/EntitySpawnS2CPacket;getEntityTypeId()Lnet/minecraft/entity/EntityType;"))
    private EntitySpawnS2CPacket onEntitySpawn(EntitySpawnS2CPacket packet, EntitySpawnS2CPacket packet2) {
        double x = packet.getX();
        double y = packet.getY();
        double z = packet.getZ();

        Entity entity = null;
        if (packet2.getEntityTypeId() == BSMEntityTypes.FINAL_BROOM) {
            entity = new FinalBroomEntity(BSMEntityTypes.FINAL_BROOM, world);
        }else if (packet2.getEntityTypeId() == BSMEntityTypes.WITCHY_DYE){
            entity = new WitchyDyeEntity(BSMEntityTypes.WITCHY_DYE, world);
        }else if (packet2.getEntityTypeId() == BSMEntityTypes.INFECTIOUS_SPIT){
            entity = new InfectiousSpitEntity(world, x, y, z, packet.getVelocityX(), packet.getVelocityY(), packet.getVelocityZ());
        }
        if (entity != null) {
            int id = packet.getId();
            entity.updateTrackedPosition(x, y, z);
            entity.refreshPositionAfterTeleport(x, y, z);
            entity.setPitch((packet.getPitch() * 360F) / 256F);
            entity.setYaw((packet.getYaw() * 360F) / 256F);
            entity.setId(id);
            entity.setUuid(packet.getUuid());
            world.addEntity(id, entity);
        }
        return packet;
    }
}
