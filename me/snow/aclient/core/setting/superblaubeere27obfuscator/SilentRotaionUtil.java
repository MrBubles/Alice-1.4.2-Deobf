

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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class SilentRotaionUtil {
    private float Field4296;

    public static void Method2162904(Vec3d vec3d) {
        float[] arrf = SilentRotaionUtil.Method2162900(Util.Field2811.player.getPositionEyes(Util.Field2811.getRenderPartialTicks()), vec3d);
        SilentRotaionUtil.Method2162909(arrf[0], arrf[1]);
        Util.Field2811.player.rotationYawHead = arrf[0];
    }

    public static void Method2162905(Entity entity) {
        float[] arrf = SilentRotaionUtil.Method2162900(Util.Field2811.player.getPositionEyes(Util.Field2811.getRenderPartialTicks()), entity.getPositionEyes(Util.Field2811.getRenderPartialTicks()));
        SilentRotaionUtil.Method2162907(arrf[0], arrf[1]);
    }

    public static void Method2162906(float f, float f2, float f3) {
        Vec3d vec3d = new Vec3d((double) f, (double) f2, (double) f3);
        float[] arrf = SilentRotaionUtil.Method2162900(Util.Field2811.player.getPositionEyes(Util.Field2811.getRenderPartialTicks()), vec3d);
        SilentRotaionUtil.Method2162909(arrf[0], arrf[1]);
        Util.Field2811.player.rotationYawHead = arrf[0];
    }

    public static void Method2162907(float f, float f2) {
        SilentRotaionUtil.Method2162909(f, f2);
        Util.Field2811.player.rotationYawHead = f;
    }

    public static void Method2162908(BlockPos blockPos) {
        float[] arrf = SilentRotaionUtil.Method2162900(Util.Field2811.player.getPositionEyes(Util.Field2811.getRenderPartialTicks()), new Vec3d((Vec3i) blockPos));
        SilentRotaionUtil.Method2162909(arrf[0], arrf[1]);
        Util.Field2811.player.renderYawOffset = arrf[0];
        Util.Field2811.player.rotationYawHead = arrf[0];
    }

    public static void Method2162909(float f, float f2) {
        Util.Field2811.player.rotationYaw = f;
        Util.Field2811.player.rotationYawHead = f;
        Util.Field2811.player.rotationPitch = f2;
    }

    public static float[] Method2162900(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static float[] Method2162011(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        float f = (float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0));
        float f2 = (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)));
        if (f2 > 90.0f) {
            f2 = 90.0f;
        } else if (f2 < -90.0f) {
            f2 = -90.0f;
        }
        return new float[]{f, f2};
    }

    public static void Method2162012(float f, float f2) {
        boolean bl;
        boolean bl2 = Util.Field2811.player.isSprinting();
        if (bl2 != ((IEntityPlayerSP) Util.Field2811.player).getServerSprintState()) {
            if (bl2) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            } else {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            ((IEntityPlayerSP) Util.Field2811.player).setServerSprintState(bl2);
        }
        if ((bl = Util.Field2811.player.isSneaking()) != ((IEntityPlayerSP) Util.Field2811.player).getServerSneakState()) {
            if (bl) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            } else {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            ((IEntityPlayerSP) Util.Field2811.player).setServerSneakState(bl);
        }
        if (Util.Field2811.player == Util.Field2811.getRenderViewEntity()) {
            AxisAlignedBB axisAlignedBB = Util.Field2811.player.getEntityBoundingBox();
            double d = Util.Field2811.player.posX - ((IEntityPlayerSP) Util.Field2811.player).getLastReportedPosX();
            double d2 = axisAlignedBB.minY - ((IEntityPlayerSP) Util.Field2811.player).getLastReportedPosY();
            double d3 = Util.Field2811.player.posZ - ((IEntityPlayerSP) Util.Field2811.player).getLastReportedPosZ();
            double d4 = f - ((IEntityPlayerSP) Util.Field2811.player).getLastReportedYaw();
            double d5 = f2 - ((IEntityPlayerSP) Util.Field2811.player).getLastReportedPitch();
            ((IEntityPlayerSP) Util.Field2811.player).setPositionUpdateTicks(((IEntityPlayerSP) Util.Field2811.player).getPositionUpdateTicks() + 1);
            boolean bl3 = d * d + d2 * d2 + d3 * d3 > 9.0E-4 || ((IEntityPlayerSP) Util.Field2811.player).getPositionUpdateTicks() >= 20;
            boolean bl4 = d4 != 0.0 || d5 != 0.0;
            boolean bl5 = bl4;
            if (Util.Field2811.player.isRiding()) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(Util.Field2811.player.motionX, -999.0, Util.Field2811.player.motionZ, f, f2, Util.Field2811.player.onGround));
                bl3 = false;
            } else if (bl3 && bl4) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(Util.Field2811.player.posX, axisAlignedBB.minY, Util.Field2811.player.posZ, f, f2, Util.Field2811.player.onGround));
            } else if (bl3) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Util.Field2811.player.posX, axisAlignedBB.minY, Util.Field2811.player.posZ, Util.Field2811.player.onGround));
            } else if (bl4) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(f, f2, Util.Field2811.player.onGround));
            } else if (((IEntityPlayerSP) Util.Field2811.player).getPrevOnGround() != Util.Field2811.player.onGround) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer(Util.Field2811.player.onGround));
            }
            if (bl3) {
                ((IEntityPlayerSP) Util.Field2811.player).setLastReportedPosX(Util.Field2811.player.posX);
                ((IEntityPlayerSP) Util.Field2811.player).setLastReportedPosY(axisAlignedBB.minY);
                ((IEntityPlayerSP) Util.Field2811.player).setLastReportedPosZ(Util.Field2811.player.posZ);
                ((IEntityPlayerSP) Util.Field2811.player).setPositionUpdateTicks(0);
            }
            if (bl4) {
                ((IEntityPlayerSP) Util.Field2811.player).setLastReportedYaw(f);
                ((IEntityPlayerSP) Util.Field2811.player).setLastReportedPitch(f2);
            }
            ((IEntityPlayerSP) Util.Field2811.player).setPrevOnGround(Util.Field2811.player.onGround);
            ((IEntityPlayerSP) Util.Field2811.player).setAutoJumpEnabled(Util.Field2811.gameSettings.autoJump);
        }
    }

    public void Method2162903(float f) {
        this.Field4296 = f;
        Minecraft.getMinecraft();
        Util.Field2811.player.rotationYawHead = f;
        Minecraft.getMinecraft();
        Util.Field2811.player.rotationYawHead = f;
    }
}

