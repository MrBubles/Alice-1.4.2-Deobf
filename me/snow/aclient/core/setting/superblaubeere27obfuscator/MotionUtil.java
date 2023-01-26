

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.potion.Potion
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class MotionUtil
        implements Util {
    public static boolean Method2163884(EntityLivingBase entityLivingBase) {
        return entityLivingBase.moveForward != 0.0f || entityLivingBase.moveStrafing != 0.0f;
    }

    public static boolean Method2163885() {
        return MotionUtil.Field2811.player.moveForward != 0.0f || MotionUtil.Field2811.player.moveStrafing != 0.0f;
    }

    public static boolean Method2163886() {
        return (double) Minecraft.getMinecraft().player.moveForward != 0.0 || (double) Minecraft.getMinecraft().player.moveStrafing != 0.0;
    }

    public static void Method2163887(EntityLivingBase entityLivingBase, double d) {
        double[] arrd = MotionUtil.Method2163889(d);
        entityLivingBase.motionX = arrd[0];
        entityLivingBase.motionZ = arrd[1];
    }

    public static double Method2163888() {
        double d = 0.2873;
        if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById((int) 1))) {
            int n2 = Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById((int) 1)).getAmplifier();
            d *= 1.0 + 0.2 * (double) (n2 + 1);
        }
        return d;
    }

    public static double[] Method2163889(double d) {
        float f = Minecraft.getMinecraft().player.movementInput.moveForward;
        float f2 = Minecraft.getMinecraft().player.movementInput.moveStrafe;
        float f3 = Minecraft.getMinecraft().player.prevRotationYaw + (Minecraft.getMinecraft().player.rotationYaw - Minecraft.getMinecraft().player.prevRotationYaw) * Minecraft.getMinecraft().getRenderPartialTicks();
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

    public static double[] Method2163880(double d) {
        float f = MotionUtil.Field2811.player.movementInput.moveForward;
        float f2 = MotionUtil.Field2811.player.movementInput.moveStrafe;
        float f3 = MotionUtil.Field2811.player.rotationYaw;
        if (f != 0.0f) {
            if (f2 >= 1.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
                f2 = 0.0f;
            } else if (f2 <= -1.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
                f2 = 0.0f;
            }
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
        if (!MotionUtil.Method2163891()) {
            d4 = 0.0;
            d5 = 0.0;
        }
        return new double[]{d4, d5};
    }

    public static boolean Method2163891() {
        return (double) MotionUtil.Field2811.player.moveForward != 0.0 || (double) MotionUtil.Field2811.player.moveStrafing != 0.0;
    }

    public static double[] Method2163892(double d, float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        double d2 = Math.sin(Math.toRadians(f + 90.0f));
        double d3 = Math.cos(Math.toRadians(f + 90.0f));
        double d4 = (double) f2 * d * d3 + (double) f3 * d * d2;
        double d5 = (double) f2 * d * d2 - (double) f3 * d * d3;
        return new double[]{d4, d5};
    }
}

