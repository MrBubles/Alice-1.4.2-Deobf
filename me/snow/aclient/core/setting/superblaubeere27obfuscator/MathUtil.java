

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MathUtil
        implements Util {
    private static final Random Field3129 = new Random();

    public static int Method2163838(int n2, int n3) {
        return n2 + Field3129.nextInt(n3 - n2 + 1);
    }

    public static double Method2163839(double d, double d2) {
        return MathHelper.clamp((double) (d + Field3129.nextDouble() * d2), (double) d, (double) d2);
    }

    public static Vec3d Method2163830(Entity entity, float f) {
        return MathUtil.Method2163841(entity, f).subtract(Minecraft.getMinecraft().getRenderManager().renderPosX, Minecraft.getMinecraft().getRenderManager().renderPosY, Minecraft.getMinecraft().getRenderManager().renderPosZ);
    }

    public static Vec3d Method2163841(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f);
    }

    public static float Method2163842(float f, float f2) {
        return MathHelper.clamp((float) (f + Field3129.nextFloat() * f2), (float) f, (float) f2);
    }

    public static int Method2163843(int n2, int n3, int n4) {
        return n2 < n3 ? n3 : Math.min(n2, n4);
    }

    public static float Method2163844(float f, float f2, float f3) {
        return f < f2 ? f2 : Math.min(f, f3);
    }

    public static double Method2163845(double d, double d2, double d3) {
        return d < d2 ? d2 : Math.min(d, d3);
    }

    public static float Method2163846(float f) {
        return MathHelper.sin((float) f);
    }

    public static float Method2163847(float f) {
        return MathHelper.cos((float) f);
    }

    public static float Method2163848(float f) {
        return MathHelper.wrapDegrees((float) f);
    }

    public static double Method2163849(double d) {
        return MathHelper.wrapDegrees((double) d);
    }

    public static Vec3d Method2163840(Vec3d vec3d, int n2) {
        return new Vec3d(MathUtil.Method2163858(vec3d.x, n2), MathUtil.Method2163858(vec3d.y, n2), MathUtil.Method2163858(vec3d.z, n2));
    }

    public static double Method2163851(Vec3d vec3d, Vec3d vec3d2) {
        double d = Math.atan2(vec3d.x - vec3d2.x, vec3d.z - vec3d2.z);
        d = -(d / Math.PI) * 360.0 / 2.0 + 180.0;
        return d;
    }

    public static double Method2163852(Vec3d vec3d) {
        return MathUtil.Method2163856(vec3d.x) + MathUtil.Method2163856(vec3d.y) + MathUtil.Method2163856(vec3d.z);
    }

    public static double Method2163853(Vec3d vec3d) {
        return Math.sqrt(MathUtil.Method2163852(vec3d));
    }

    public static float Method2163854(double d, int n2) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.FLOOR);
        return bigDecimal.floatValue();
    }

    public static double Method2163855(Vec3d vec3d, Vec3d vec3d2) {
        return vec3d.x * vec3d2.x + vec3d.y * vec3d2.y + vec3d.z * vec3d2.z;
    }

    public static double Method2163856(double d) {
        return d * d;
    }

    public static double Method2163857(float f) {
        return f * f;
    }

    public static double Method2163858(double d, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.FLOOR);
        return bigDecimal.doubleValue();
    }

    public static float Method2163859(float f) {
        float f2 = f % 360.0f;
        if (f2 >= 180.0f) {
            f2 -= 360.0f;
        }
        if (f2 < -180.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    public static Vec3d Method2163850(float f) {
        return new Vec3d(Math.cos(MathUtil.Method2163865(f + 90.0f)), 0.0, Math.sin(MathUtil.Method2163865(f + 90.0f)));
    }

    public static float Method2163861(float f, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(f);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.FLOOR);
        return bigDecimal.floatValue();
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> Method2163862(Map<K, V> map, boolean bl) {
        LinkedList<Map.Entry<K, V>> linkedList = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        if (bl) {
            linkedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        } else {
            linkedList.sort(Map.Entry.comparingByValue());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static String Method2163863() {
        Calendar calendar = Calendar.getInstance();
        int n2 = calendar.get(11);
        if (n2 < 12) {
            return "Good Morning ";
        }
        if (n2 < 16) {
            return "Good Afternoon ";
        }
        if (n2 < 21) {
            return "Good Evening ";
        }
        return "Good Night ";
    }

    public static double Method2163864(double d) {
        return d * (double) 57.29578f;
    }

    public static double Method2163865(double d) {
        return d * 0.01745329238474369;
    }

    public static double Method2163866(double d, double d2) {
        double d3 = 1.0 / d2;
        return (double) Math.round(d * d3) / d3;
    }

    public static double[] Method2163867(double d) {
        float f = MathUtil.Field2811.player.movementInput.moveForward;
        float f2 = MathUtil.Field2811.player.movementInput.moveStrafe;
        float f3 = MathUtil.Field2811.player.prevRotationYaw + (MathUtil.Field2811.player.rotationYaw - MathUtil.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
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

    public static List<Vec3d> Method2163868(Entity entity) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        double d = entity.posY;
        double d2 = MathUtil.Method2163858(axisAlignedBB.minX, 0);
        double d3 = MathUtil.Method2163858(axisAlignedBB.minZ, 0);
        double d4 = MathUtil.Method2163858(axisAlignedBB.maxX, 0);
        double d5 = MathUtil.Method2163858(axisAlignedBB.maxZ, 0);
        if (d2 != d4) {
            Vec3d vec3d = new Vec3d(d2, d, d3);
            Vec3d vec3d2 = new Vec3d(d4, d, d3);
            BlockPos blockPos = new BlockPos(vec3d);
            BlockPos blockPos2 = new BlockPos(vec3d2);
            if (BlockUtil.Method2162846(blockPos) && BlockUtil.Method2162846(blockPos2)) {
                arrayList.add(vec3d);
                arrayList.add(vec3d2);
            }
            if (d3 != d5) {
                Vec3d vec3d3 = new Vec3d(d2, d, d5);
                Vec3d vec3d4 = new Vec3d(d4, d, d5);
                BlockPos blockPos3 = new BlockPos(vec3d);
                BlockPos blockPos4 = new BlockPos(vec3d2);
                if (BlockUtil.Method2162846(blockPos3) && BlockUtil.Method2162846(blockPos4)) {
                    arrayList.add(vec3d3);
                    arrayList.add(vec3d4);
                    return arrayList;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(entity.getPositionVector());
            }
            return arrayList;
        }
        if (d3 != d5) {
            Vec3d vec3d = new Vec3d(d2, d, d3);
            Vec3d vec3d5 = new Vec3d(d2, d, d5);
            BlockPos blockPos = new BlockPos(vec3d);
            BlockPos blockPos5 = new BlockPos(vec3d5);
            if (BlockUtil.Method2162846(blockPos) && BlockUtil.Method2162846(blockPos5)) {
                arrayList.add(vec3d);
                arrayList.add(vec3d5);
            }
            if (arrayList.isEmpty()) {
                arrayList.add(entity.getPositionVector());
            }
            return arrayList;
        }
        arrayList.add(entity.getPositionVector());
        return arrayList;
    }

    public static boolean Method2163869(Vec3d vec3d, Vec3d vec3d2) {
        return MathUtil.Method2163860(vec3d, vec3d2);
    }

    public static boolean Method2163860(Vec3d vec3d, Vec3d vec3d2) {
        BlockPos blockPos = new BlockPos(vec3d);
        BlockPos blockPos2 = new BlockPos(vec3d2.x, vec3d.y, vec3d2.z);
        return blockPos.equals((Object) blockPos2);
    }

    public static float[] Method2163871(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static float[] Method2163872(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.z - vec3d.z;
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d2, d)) - 90.0))};
    }

    public static Vec3d Method2163873(Vec3d vec3d, Vec3d vec3d2, double d) {
        double d2 = Math.sqrt(MathUtil.Method2163874(vec3d2.x - vec3d.x) + MathUtil.Method2163874(vec3d2.y - vec3d.y) + MathUtil.Method2163874(vec3d2.z - vec3d.z));
        double d3 = (vec3d2.x - vec3d.x) / d2;
        double d4 = (vec3d2.y - vec3d.y) / d2;
        double d5 = (vec3d2.z - vec3d.z) / d2;
        double d6 = vec3d.x + d3 * d;
        double d7 = vec3d.y + d4 * d;
        double d8 = vec3d.z + d5 * d;
        return new Vec3d(d6, d7, d8);
    }

    public static double Method2163874(double d) {
        return d * d;
    }

    public static Vec3d Method2163875(EntityPlayer entityPlayer, int n2) {
        Vec3d vec3d = new Vec3d(entityPlayer.lastTickPosX, entityPlayer.lastTickPosY, entityPlayer.lastTickPosZ);
        Vec3d vec3d2 = new Vec3d(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
        double d = MathUtil.Method2163874(entityPlayer.motionX) + MathUtil.Method2163874(entityPlayer.motionY) + MathUtil.Method2163874(entityPlayer.motionZ);
        Vec3d vec3d3 = MathUtil.Method2163873(vec3d, vec3d2, d * (double) n2);
        return new Vec3d(vec3d3.x, entityPlayer.posY, vec3d3.z);
    }

    public static double[] Method2163876(double d) {
        Minecraft minecraft = Minecraft.getMinecraft();
        float f = minecraft.player.movementInput.moveForward;
        float f2 = minecraft.player.movementInput.moveStrafe;
        float f3 = minecraft.player.prevRotationYaw + (minecraft.player.rotationYaw - minecraft.player.prevRotationYaw) * minecraft.getRenderPartialTicks();
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

    public static String Method2163877(double d, double d2) {
        double d3 = Math.toDegrees(Math.atan2(-(MathUtil.Field2811.player.posX - d), -(MathUtil.Field2811.player.posZ - d2)));
        double d4 = d3 + (double) MathUtil.Field2811.player.rotationYaw;
        if (d4 < 0.0) {
            d4 += 360.0;
        }
        if (d4 > 315.0 || d4 <= 45.0) {
            return "in front of you";
        }
        if (d4 > 45.0 && d4 <= 135.0) {
            return "to your left";
        }
        if (d4 > 135.0 && d4 <= 225.0) {
            return "behind you";
        }
        if (d4 > 225.0 && d4 <= 315.0) {
            return "to your right";
        }
        return (Object) ChatFormatting.OBFUSCATED + "living in your walls";
    }

    public static float Method2163878(float f) {
        return (float) ((double) f * Math.PI / 180.0);
    }

    public static double Method2163879(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d.length() * vec3d2.length();
        if (d < 1.0E-4) {
            return 0.0;
        }
        double d2 = vec3d.dotProduct(vec3d2);
        double d3 = d2 / d;
        if (d3 > 1.0) {
            return 0.0;
        }
        if (d3 < -1.0) {
            return 180.0;
        }
        return Math.acos(d3) * 180.0 / Math.PI;
    }

    public static Vec3d Method2163870(Vec3d vec3d, double d, double d2, double d3) {
        return MathUtil.Method2163882(vec3d.x, vec3d.y, vec3d.z, d, d2, d3);
    }

    public static Vec3d Method2163881(double d, double d2, double d3, Vec3d vec3d) {
        return MathUtil.Method2163882(d, d2, d3, vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vec3d Method2163882(double d, double d2, double d3, double d4, double d5, double d6) {
        return new Vec3d(d4 - d, d5 - d2, d6 - d3);
    }

    public static double Method2163883(double d, int n2) {
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}

