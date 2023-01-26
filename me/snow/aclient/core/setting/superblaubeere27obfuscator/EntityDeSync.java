

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraftforge.event.entity.EntityJoinWorldEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityDeSync
        extends Module {
    static EntityDeSync Field3506;
    private Entity Field3507 = null;

    public EntityDeSync() {
        super("EntityDeSync", "Forces shit with entites", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    public void Method2161861() {
        Field3506 = this;
    }

    @Override
    public void Method2150372() {
        if (EntityDeSync.Field2811.player == null) {
            this.Field3507 = null;
            this.Method2150391();
            return;
        }
        if (!EntityDeSync.Field2811.player.isRiding()) {
            Command.Method2159696("You are not riding an entity.");
            this.Field3507 = null;
            this.Method2150391();
            return;
        }
        Command.Method2159696("Vanished");
        this.Field3507 = EntityDeSync.Field2811.player.getRidingEntity();
        EntityDeSync.Field2811.player.dismountRidingEntity();
        EntityDeSync.Field2811.world.removeEntity(this.Field3507);
    }

    @Override
    public void Method2150373() {
        if (this.Field3507 != null) {
            this.Field3507.isDead = false;
            if (!EntityDeSync.Field2811.player.isRiding()) {
                EntityDeSync.Field2811.world.spawnEntity(this.Field3507);
                EntityDeSync.Field2811.player.startRiding(this.Field3507, true);
            }
            this.Field3507 = null;
            Command.Method2159696("Forced a remount");
        }
    }

    @Override
    public void Method2150379() {
        if (this.Field3507 == null) {
            return;
        }
        if (EntityDeSync.Field2811.player.isRiding()) {
            return;
        }
        EntityDeSync.Field2811.player.onGround = true;
        this.Field3507.setPosition(EntityDeSync.Field2811.player.posX, EntityDeSync.Field2811.player.posY, EntityDeSync.Field2811.player.posZ);
        EntityDeSync.Field2811.player.connection.sendPacket((Packet) new CPacketVehicleMove(this.Field3507));
    }

    @SubscribeEvent
    public void Method2161862(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSetPassengers) {
            if (this.Field3507 == null) {
                return;
            }
            SPacketSetPassengers sPacketSetPassengers = (SPacketSetPassengers) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            Entity entity = EntityDeSync.Field2811.world.getEntityByID(sPacketSetPassengers.getEntityId());
            if (entity == this.Field3507) {
                for (int n2 : sPacketSetPassengers.getPassengerIds()) {
                    Entity entity2 = EntityDeSync.Field2811.world.getEntityByID(n2);
                    if (entity2 != EntityDeSync.Field2811.player) {
                        continue;
                    }
                    return;
                }
                Command.Method2159696("You dismounted. RIP");
                this.Method2150391();
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketDestroyEntities) {
            SPacketDestroyEntities sPacketDestroyEntities = (SPacketDestroyEntities) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            for (int n3 : sPacketDestroyEntities.getEntityIDs()) {
                if (n3 != this.Field3507.getEntityId()) {
                    continue;
                }
                Command.Method2159696("Entity is now null SPacketDestroyEntities");
                return;
            }
        }
    }

    @SubscribeEvent
    public void Method2161863(EntityJoinWorldEvent entityJoinWorldEvent) {
        if (entityJoinWorldEvent.getEntity() == EntityDeSync.Field2811.player) {
            Command.Method2159696("Player " + entityJoinWorldEvent.getEntity().getName() + " joined the world!");
        }
    }
}

