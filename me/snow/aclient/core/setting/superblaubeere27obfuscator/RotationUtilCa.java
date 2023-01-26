

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TimerCa;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RotationUtilCa
        implements Util {
    public static TimerCa Field1342 = new TimerCa();
    public static boolean Field1345;
    private static float Field1343;
    private static float Field1344;

    public static int Method2163243() {
        return MathHelper.floor((double) ((double) (RotationUtilCa.Field2811.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
    }

    public static String Method2163244(boolean bl) {
        int n2 = RotationUtilCa.Method2163243();
        if (n2 == 0) {
            return "South (+Z)";
        }
        if (n2 == 1) {
            return "West (-X)";
        }
        if (n2 == 2) {
            return (bl ? "\u00a7c" : "") + "North (-Z)";
        }
        if (n2 == 3) {
            return "East (+X)";
        }
        return "Loading...";
    }

    public static void Method2163245() {
        try {
            Field1343 = RotationUtilCa.Field2811.player.rotationYaw;
            Field1344 = RotationUtilCa.Field2811.player.rotationPitch;
            RotationUtilCa.Field2811.player.rotationYawHead = RotationUtilCa.Field2811.player.rotationYaw;
            Field1342.Method2163262();
        } catch (Exception exception) {
            AliceMain.Field745.info("Failed to reset rotations...");
        }
    }

    public static void Method2163246(double d, double d2, double d3, EntityPlayer entityPlayer) {
        double[] arrd = RotationUtilCa.Method2163249(d, d2, d3, entityPlayer);
        RotationUtilCa.Field2811.player.setRotationYawHead((float) arrd[0]);
        RotationUtilCa.Method2163252((float) arrd[0], (float) arrd[1]);
    }

    public static void Method2163247(Vec3d vec3d, boolean bl) {
        float[] arrf = RotationUtilCa.Method2163251(vec3d);
        RotationUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], bl ? (float) MathHelper.normalizeAngle((int) ((int) arrf[1]), (int) 360) : arrf[1], RotationUtilCa.Field2811.player.onGround));
        RotationUtilCa.Method2163252(arrf[0], arrf[1]);
    }

    public static void Method2163248(Vec3d vec3d) {
        float[] arrf = RotationUtilCa.Method2163251(vec3d);
        RotationUtilCa.Method2163252(arrf[0], arrf[1]);
    }

    public static double[] Method2163249(double d, double d2, double d3, EntityPlayer entityPlayer) {
        double d4 = entityPlayer.posX - d;
        double d5 = entityPlayer.posY - d2;
        double d6 = entityPlayer.posZ - d3;
        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
        double d8 = Math.asin(d5 /= d7);
        double d9 = Math.atan2(d6 /= d7, d4 /= d7);
        d8 = d8 * 180.0 / Math.PI;
        d9 = d9 * 180.0 / Math.PI;
        return new double[]{d9 += 90.0, d8};
    }

    public static Vec3d Method2163240() {
        return new Vec3d(RotationUtilCa.Field2811.player.posX, RotationUtilCa.Field2811.player.posY + (double) RotationUtilCa.Field2811.player.getEyeHeight(), RotationUtilCa.Field2811.player.posZ);
    }

    public static float[] Method2163251(Vec3d vec3d) {
        Vec3d vec3d2 = RotationUtilCa.Method2163240();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{RotationUtilCa.Field2811.player.rotationYaw + MathHelper.wrapDegrees((float) (f - RotationUtilCa.Field2811.player.rotationYaw)), RotationUtilCa.Field2811.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - RotationUtilCa.Field2811.player.rotationPitch))};
    }

    public static void Method2163252(float f, float f2) {
        Field1343 = f;
        Field1344 = f2;
        Field1345 = true;
    }

    public static void Method2163253(float f, float f2) {
        RotationUtilCa.Field2811.player.rotationYaw = f;
        RotationUtilCa.Field2811.player.rotationYawHead = f;
        RotationUtilCa.Field2811.player.rotationPitch = f2;
    }

    public static void Method2163254() {
        if (Field1345) {
            Field1343 = RotationUtilCa.Field2811.player.rotationYaw;
            Field1344 = RotationUtilCa.Field2811.player.rotationPitch;
            Field1345 = false;
        }
    }
}

