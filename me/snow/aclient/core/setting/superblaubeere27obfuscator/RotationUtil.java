

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Comparator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleUtilSafety;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class RotationUtil
        implements Util {
    private static float Field2729;
    private static float Field2730;

    public static Vec3d Method2163089() {
        return new Vec3d(RotationUtil.Field2811.player.posX, RotationUtil.Field2811.player.posY + (double) RotationUtil.Field2811.player.getEyeHeight(), RotationUtil.Field2811.player.posZ);
    }

    public static void Method2163080(float f, float f2) {
        RotationUtil.Field2811.player.rotationYaw = f;
        RotationUtil.Field2811.player.rotationYawHead = f;
        RotationUtil.Field2811.player.rotationPitch = f2;
    }

    public static void Method2163091() {
        RotationUtil.Field2811.player.rotationYaw = Field2729;
        RotationUtil.Field2811.player.rotationYawHead = Field2729;
        RotationUtil.Field2811.player.rotationPitch = Field2730;
    }

    public static float[] Method2163092(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static float[] Method2163093(BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        double d = (double) blockPos.getX() + 0.5 - Wrapper.Field2414.player.posX + (double) enumFacing.getXOffset() / 2.0;
        double d2 = (double) blockPos.getZ() + 0.5 - Wrapper.Field2414.player.posZ + (double) enumFacing.getZOffset() / 2.0;
        double d3 = (double) blockPos.getY() + 0.5;
        if (bl) {
            d3 += 0.5;
        }
        double d4 = Wrapper.Field2414.player.posY + (double) Wrapper.Field2414.player.getEyeHeight() - d3;
        double d5 = MathHelper.sqrt((double) (d * d + d2 * d2));
        float f = (float) (Math.atan2(d2, d) * 180.0 / Math.PI) - 90.0f;
        float f2 = (float) (Math.atan2(d4, d5) * 180.0 / Math.PI);
        if (f < 0.0f) {
            f += 360.0f;
        }
        return new float[]{f, f2};
    }

    public static Vec2f Method2163094(Vec3d vec3d, Vec3d vec3d2) {
        return RotationUtil.Method2163095(vec3d.subtract(vec3d2));
    }

    public static Vec2f Method2163095(Vec3d vec3d) {
        double d = Math.hypot(vec3d.x, vec3d.z);
        float f = (float) RotationUtil.Method2163096(Math.toDegrees(Math.atan2(vec3d.z, vec3d.x)) - 90.0);
        float f2 = (float) RotationUtil.Method2163096(Math.toDegrees(-Math.atan2(vec3d.y, d)));
        return new Vec2f(f, f2);
    }

    public static double Method2163096(Double d) {
        double d2 = 0.0;
        double d3 = d;
        d3 %= 360.0;
        if (d2 >= 180.0) {
            d3 -= 360.0;
        }
        if (d3 < -180.0) {
            d3 += 360.0;
        }
        return d3;
    }

    public static HoleUtilSafety.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163097(double d) {
        return HoleUtilSafety.Method2164496(d, RotationUtil.Method2163098(), false).stream().filter(arg_0 -> RotationUtil.Method2164110(d, arg_0)).min(Comparator.comparingDouble(RotationUtil::Method2164119)).orElse(null);
    }

    public static BlockPos Method2163098() {
        double d = RotationUtil.Field2811.player.posY - Math.floor(RotationUtil.Field2811.player.posY);
        return new BlockPos(RotationUtil.Field2811.player.posX, d > 0.8 ? Math.floor(RotationUtil.Field2811.player.posY) + 1.0 : Math.floor(RotationUtil.Field2811.player.posY), RotationUtil.Field2811.player.posZ);
    }

    public static float[] Method2163099(Vec3d vec3d) {
        Vec3d vec3d2 = RotationUtil.Method2163089();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{RotationUtil.Field2811.player.rotationYaw + MathHelper.wrapDegrees((float) (f - RotationUtil.Field2811.player.rotationYaw)), RotationUtil.Field2811.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - RotationUtil.Field2811.player.rotationPitch))};
    }

    public static float[] Method2163090(EnumFacing enumFacing) {
        switch (1.F ield3434[enumFacing.ordinal()]){
            case 1: {
                return new float[]{RotationUtil.Field2811.player.rotationYaw, 90.0f};
            }
            case 2: {
                return new float[]{RotationUtil.Field2811.player.rotationYaw, -90.0f};
            }
            case 3: {
                return new float[]{180.0f, 0.0f};
            }
            case 4: {
                return new float[]{0.0f, 0.0f};
            }
            case 5: {
                return new float[]{90.0f, 0.0f};
            }
        }
        return new float[]{270.0f, 0.0f};
    }

    public static void Method2163001(float f, float f2) {
        RotationUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(f, f2, RotationUtil.Field2811.player.onGround));
    }

    public static void Method2163002(Vec3d vec3d, boolean bl) {
        float[] arrf = RotationUtil.Method2163099(vec3d);
        RotationUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], bl ? (float) MathHelper.normalizeAngle((int) ((int) arrf[1]), (int) 360) : arrf[1], RotationUtil.Field2811.player.onGround));
    }

    public static void Method2163003(Entity entity) {
        float[] arrf = MathUtil.Method2163871(RotationUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionEyes(Field2811.getRenderPartialTicks()));
        RotationUtil.Method2163001(arrf[0], arrf[1]);
    }

    public static float[] Method2163004(Entity entity) {
        return MathUtil.Method2163871(RotationUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionEyes(Field2811.getRenderPartialTicks()));
    }

    public static float Method2163005() {
        float f = RotationUtil.Field2811.player.rotationYaw % 360.0f;
        if (RotationUtil.Field2811.player.rotationYaw > 0.0f) {
            if (f > 180.0f) {
                f = -180.0f + (f - 180.0f);
            }
        } else if (f < -180.0f) {
            f = 180.0f + (f + 180.0f);
        }
        if (f < 0.0f) {
            return 180.0f + f;
        }
        return -180.0f + f;
    }

    public static boolean Method2163006(BlockPos blockPos) {
        return blockPos == null || !(RotationUtil.Field2811.player.getDistanceSq(blockPos) < 4.0) && !(RotationUtil.Method2163008(blockPos) < (double) (RotationUtil.Method2164112() + 2.0f));
    }

    public static boolean Method2163007(Entity entity) {
        return entity == null || !(RotationUtil.Field2811.player.getDistanceSq(entity) < 4.0) && !(RotationUtil.Method2163009(entity) < (double) (RotationUtil.Method2164112() + 2.0f));
    }

    public static double Method2163008(BlockPos blockPos) {
        if (blockPos != null) {
            Vec3d vec3d = new Vec3d((Vec3i) blockPos).subtract(RotationUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()));
            double d = Math.abs((double) RotationUtil.Field2811.player.rotationYaw - (Math.toDegrees(Math.atan2(vec3d.z, vec3d.x)) - 90.0)) % 360.0;
            return d > 180.0 ? 360.0 - d : d;
        }
        return 0.0;
    }

    public static double Method2163009(Entity entity) {
        if (entity != null) {
            Vec3d vec3d = entity.getPositionVector().add(0.0, (double) (entity.getEyeHeight() / 2.0f), 0.0).subtract(RotationUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()));
            double d = Math.abs((double) RotationUtil.Field2811.player.rotationYaw - (Math.toDegrees(Math.atan2(vec3d.z, vec3d.x)) - 90.0)) % 360.0;
            return d > 180.0 ? 360.0 - d : d;
        }
        return 0.0;
    }

    public static boolean Method2163000(Vec3d vec3d, Vec3d vec3d2) {
        if (RotationUtil.Field2811.player.rotationPitch > 30.0f ? vec3d2.y > RotationUtil.Field2811.player.posY : RotationUtil.Field2811.player.rotationPitch < -30.0f && vec3d2.y < RotationUtil.Field2811.player.posY) {
            return true;
        }
        float f = MathUtil.Method2163872(vec3d, vec3d2)[0] - RotationUtil.Method2163005();
        if (f < -270.0f) {
            return true;
        }
        float f2 = (ClickGui.Method2150300().Field842.getValue() != false ? ClickGui.Method2150300().Field843.getValue().floatValue() : RotationUtil.Field2811.gameSettings.fovSetting) / 2.0f;
        return f < f2 + 10.0f && f > -f2 - 10.0f;
    }

    public static float Method2164111() {
        return ClickGui.Method2150300().Field842.getValue() != false ? ClickGui.Method2150300().Field843.getValue().floatValue() : RotationUtil.Field2811.gameSettings.fovSetting;
    }

    public static float Method2164112() {
        return RotationUtil.Method2164111() / 2.0f;
    }

    public static int Method2164113() {
        return MathHelper.floor((double) ((double) (RotationUtil.Field2811.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
    }

    public static String Method2164114(boolean bl) {
        int n2 = RotationUtil.Method2164113();
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

    public static void Method2164115(Vec3d vec3d) {
        float[] arrf = RotationUtil.Method2163099(vec3d);
        RotationUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], RotationUtil.Field2811.player.onGround));
    }

    public static void Method2164116() {
        Field2729 = RotationUtil.Field2811.player.rotationYaw;
        Field2730 = RotationUtil.Field2811.player.rotationPitch;
    }

    public static Vec3d Method2164117() {
        return RotationUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks());
    }

    public static Vec3d Method2164118() {
        return RotationUtil.Field2811.player.getLook(Field2811.getRenderPartialTicks());
    }

    private static double Method2164119(HoleUtilSafety.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        return RotationUtil.Field2811.player.getPositionVector().distanceTo(new Vec3d((double) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field38.getX() + 0.5, RotationUtil.Field2811.player.posY, (double) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field38.getZ() + 0.5));
    }

    private static boolean Method2164110(double d, HoleUtilSafety.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        return RotationUtil.Field2811.player.getPositionVector().distanceTo(new Vec3d((double) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field38.getX() + 0.5, RotationUtil.Field2811.player.posY, (double) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field38.getZ() + 0.5)) <= d;
    }
}

