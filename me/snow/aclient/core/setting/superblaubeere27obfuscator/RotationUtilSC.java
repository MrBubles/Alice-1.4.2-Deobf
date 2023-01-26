

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.math.AxisAlignedBB
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class RotationUtilSC {
    public static Minecraft Field4295 = Minecraft.getMinecraft();

    public static void Method2162902(float f, float f2) {
        boolean bl;
        boolean bl2 = RotationUtilSC.Field4295.player.isSprinting();
        if (bl2 != ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getServerSprintState()) {
            if (bl2) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) RotationUtilSC.Field4295.player, CPacketEntityAction.Action.START_SPRINTING));
            } else {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) RotationUtilSC.Field4295.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setServerSprintState(bl2);
        }
        if ((bl = RotationUtilSC.Field4295.player.isSneaking()) != ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getServerSneakState()) {
            if (bl) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) RotationUtilSC.Field4295.player, CPacketEntityAction.Action.START_SNEAKING));
            } else {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) RotationUtilSC.Field4295.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setServerSneakState(bl);
        }
        if (RotationUtilSC.Field4295.player == Field4295.getRenderViewEntity()) {
            AxisAlignedBB axisAlignedBB = RotationUtilSC.Field4295.player.getEntityBoundingBox();
            double d = RotationUtilSC.Field4295.player.posX - ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getLastReportedPosX();
            double d2 = axisAlignedBB.minY - ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getLastReportedPosY();
            double d3 = RotationUtilSC.Field4295.player.posZ - ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getLastReportedPosZ();
            double d4 = f - ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getLastReportedYaw();
            double d5 = f2 - ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getLastReportedPitch();
            ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setPositionUpdateTicks(((IEntityPlayerSP) RotationUtilSC.Field4295.player).getPositionUpdateTicks() + 1);
            boolean bl3 = d * d + d2 * d2 + d3 * d3 > 9.0E-4 || ((IEntityPlayerSP) RotationUtilSC.Field4295.player).getPositionUpdateTicks() >= 20;
            boolean bl4 = d4 != 0.0 || d5 != 0.0;
            boolean bl5 = bl4;
            if (RotationUtilSC.Field4295.player.isRiding()) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(RotationUtilSC.Field4295.player.motionX, -999.0, RotationUtilSC.Field4295.player.motionZ, f, f2, RotationUtilSC.Field4295.player.onGround));
                bl3 = false;
            } else if (bl3 && bl4) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(RotationUtilSC.Field4295.player.posX, axisAlignedBB.minY, RotationUtilSC.Field4295.player.posZ, f, f2, RotationUtilSC.Field4295.player.onGround));
            } else if (bl3) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketPlayer.Position(RotationUtilSC.Field4295.player.posX, axisAlignedBB.minY, RotationUtilSC.Field4295.player.posZ, RotationUtilSC.Field4295.player.onGround));
            } else if (bl4) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(f, f2, RotationUtilSC.Field4295.player.onGround));
            } else if (((IEntityPlayerSP) RotationUtilSC.Field4295.player).getPrevOnGround() != RotationUtilSC.Field4295.player.onGround) {
                RotationUtilSC.Field4295.player.connection.sendPacket((Packet) new CPacketPlayer(RotationUtilSC.Field4295.player.onGround));
            }
            if (bl3) {
                ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setLastReportedPosX(RotationUtilSC.Field4295.player.posX);
                ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setLastReportedPosY(axisAlignedBB.minY);
                ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setLastReportedPosZ(RotationUtilSC.Field4295.player.posZ);
                ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setPositionUpdateTicks(0);
            }
            if (bl4) {
                ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setLastReportedYaw(f);
                ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setLastReportedPitch(f2);
            }
            ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setPrevOnGround(RotationUtilSC.Field4295.player.onGround);
            ((IEntityPlayerSP) RotationUtilSC.Field4295.player).setAutoJumpEnabled(RotationUtilSC.Field4295.gameSettings.autoJump);
        }
    }
}

