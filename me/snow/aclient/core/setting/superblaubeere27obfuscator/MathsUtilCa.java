

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MathsUtilCa
        implements Util {
    Random Field630 = new Random();

    public static int Method2163153(int n2, int n3, int n4) {
        return n2 < n3 ? n3 : Math.min(n2, n4);
    }

    public static float Method2163154(float f, float f2, float f3) {
        return f < f2 ? f2 : Math.min(f, f3);
    }

    public static double Method2163155(double d, double d2, double d3) {
        return d < d2 ? d2 : Math.min(d, d3);
    }

    public static float[] Method2163156(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static float Method2163157(float f) {
        if ((f %= 360.0f) >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static double Method2163158(double d, int n2) {
        double d2 = Math.pow(10.0, n2);
        return (double) Math.round(d * d2) / d2;
    }

    public static double Method2163159(double d, double d2) {
        return Math.floor(d) + (double) Math.round((d - Math.floor(d)) * (1.0 / d2)) / (1.0 / d2);
    }

    public static Vec3d Method2163150(Vec3d vec3d, int n2) {
        return new Vec3d(MathsUtilCa.Method2163161(vec3d.x, n2), MathsUtilCa.Method2163161(vec3d.y, n2), MathsUtilCa.Method2163161(vec3d.z, n2));
    }

    public static double Method2163161(double d, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.FLOOR);
        return bigDecimal.doubleValue();
    }

    public static int Method2163163(double d) {
        int n2 = (int) d;
        return d < (double) n2 ? n2 - 1 : n2;
    }

    public static Vec3d Method2163164(EntityPlayer entityPlayer, int n2) {
        Vec3d vec3d = new Vec3d(entityPlayer.lastTickPosX, entityPlayer.lastTickPosY, entityPlayer.lastTickPosZ);
        Vec3d vec3d2 = new Vec3d(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
        double d = MathsUtilCa.Method2163166((float) entityPlayer.motionX) + MathsUtilCa.Method2163166((float) entityPlayer.motionY) + MathsUtilCa.Method2163166((float) entityPlayer.motionZ);
        Vec3d vec3d3 = MathsUtilCa.Method2163165(vec3d, vec3d2, d * (double) n2);
        return new Vec3d(vec3d3.x, entityPlayer.posY, vec3d3.z);
    }

    public static Vec3d Method2163165(Vec3d vec3d, Vec3d vec3d2, double d) {
        double d2 = Math.sqrt(MathsUtilCa.Method2163166((float) (vec3d2.x - vec3d.x)) + MathsUtilCa.Method2163166((float) (vec3d2.y - vec3d.y)) + MathsUtilCa.Method2163166((float) (vec3d2.z - vec3d.z)));
        double d3 = (vec3d2.x - vec3d.x) / d2;
        double d4 = (vec3d2.y - vec3d.y) / d2;
        double d5 = (vec3d2.z - vec3d.z) / d2;
        double d6 = vec3d.x + d3 * d;
        double d7 = vec3d.y + d4 * d;
        double d8 = vec3d.z + d5 * d;
        return new Vec3d(d6, d7, d8);
    }

    public static double Method2163166(float f) {
        return f * f;
    }

    public static double[] Method2163167(double d) {
        float f = MathsUtilCa.Field2811.player.movementInput.moveForward;
        float f2 = MathsUtilCa.Field2811.player.movementInput.moveStrafe;
        float f3 = MathsUtilCa.Field2811.player.prevRotationYaw + (MathsUtilCa.Field2811.player.rotationYaw - MathsUtilCa.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double) f * d * d3 + (double) f2 * d * d2;
        double d5 = (double) f * d * d2 - (double) f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static double Method2163168(double d) {
        return d * 0.01745329238474369;
    }

    public int Method2163162(int n2, int n3) {
        return this.Field630.nextInt(n3 - n2) + n2;
    }
}

