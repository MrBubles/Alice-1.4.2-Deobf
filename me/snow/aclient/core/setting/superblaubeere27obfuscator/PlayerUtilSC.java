

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockAir
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.text.DecimalFormat;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.SurroundRewrite;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class PlayerUtilSC {
    private static final Minecraft Field3232 = Minecraft.getMinecraft();
    public static double[] Field3233 = null;

    public static boolean Method2162917() {
        return PlayerUtilSC.Field3232.gameSettings.keyBindForward.isKeyDown() || PlayerUtilSC.Field3232.gameSettings.keyBindBack.isKeyDown() || PlayerUtilSC.Field3232.gameSettings.keyBindRight.isKeyDown() || PlayerUtilSC.Field3232.gameSettings.keyBindLeft.isKeyDown();
    }

    public static boolean Method2162918() {
        return PlayerUtilSC.Field3232.gameSettings.keyBindForward.isKeyDown() && !PlayerUtilSC.Field3232.player.isSneaking();
    }

    public static float[] Method2162919(Vec3d vec3d) {
        Vec3d vec3d2 = PlayerUtilSC.Method2162910();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        float[] arrf = new float[]{PlayerUtilSC.Field3232.player.rotationYaw + MathHelper.wrapDegrees((float) (f - PlayerUtilSC.Field3232.player.rotationYaw)), PlayerUtilSC.Field3232.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - PlayerUtilSC.Field3232.player.rotationPitch))};
        return arrf;
    }

    private static Vec3d Method2162910() {
        return new Vec3d(PlayerUtilSC.Field3232.player.posX, PlayerUtilSC.Field3232.player.posY + (double) PlayerUtilSC.Field3232.player.getEyeHeight(), PlayerUtilSC.Field3232.player.posZ);
    }

    public static Vec3d Method2162921(Vec3d vec3d) {
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        double d = Double.parseDouble(decimalFormat.format(vec3d.x));
        double d2 = Double.parseDouble(decimalFormat.format(vec3d.y));
        double d3 = Double.parseDouble(decimalFormat.format(vec3d.z));
        return new Vec3d(d, d2, d3);
    }

    public static double Method2162922(float f) {
        return (double) f * (Math.PI / 180);
    }

    public static double[] Method2162923(float f) {
        double d = PlayerUtilSC.Method2162922(f);
        double d2 = Math.sin(d);
        double d3 = Math.cos(d);
        return new double[]{d2, d3};
    }

    public static double[] Method2162924(double d) {
        float f = PlayerUtilSC.Field3232.player.movementInput.moveForward;
        float f2 = PlayerUtilSC.Field3232.player.movementInput.moveStrafe;
        float f3 = PlayerUtilSC.Field3232.player.prevRotationYaw + (PlayerUtilSC.Field3232.player.rotationYaw - PlayerUtilSC.Field3232.player.prevRotationYaw) * Field3232.getRenderPartialTicks();
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

    public static double[] Method2162925(double d, EntityPlayerSP entityPlayerSP) {
        Minecraft minecraft = Minecraft.getMinecraft();
        float f = entityPlayerSP.movementInput.moveForward;
        float f2 = entityPlayerSP.movementInput.moveStrafe;
        float f3 = entityPlayerSP.prevRotationYaw + (entityPlayerSP.rotationYaw - entityPlayerSP.prevRotationYaw) * minecraft.getRenderPartialTicks();
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

    public static boolean Method2162926() {
        boolean bl = false;
        if (PlayerUtilSC.Field3232.player.posY <= 0.0) {
            return true;
        }
        int n2 = 1;
        while ((double) n2 < PlayerUtilSC.Field3232.player.posY) {
            BlockPos blockPos = new BlockPos(PlayerUtilSC.Field3232.player.posX, (double) n2, PlayerUtilSC.Field3232.player.posZ);
            if (!(PlayerUtilSC.Field3232.world.getBlockState(blockPos).getBlock() instanceof BlockAir)) {
                bl = false;
                break;
            }
            bl = true;
            ++n2;
        }
        return bl;
    }

    public static float[] Method2162927(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static double[] Method2162928(double d, double d2, double d3, EntityPlayer entityPlayer) {
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

    public static void Method2162929() {
        double d = Math.floor(PlayerUtilSC.Field3232.player.posX) + 0.5;
        double d2 = Math.floor(PlayerUtilSC.Field3232.player.posZ) + 0.5;
        PlayerUtilSC.Field3232.player.setPosition(d, PlayerUtilSC.Field3232.player.posY, d2);
        PlayerUtilSC.Field3232.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, PlayerUtilSC.Field3232.player.posY, d2, PlayerUtilSC.Field3232.player.onGround));
    }

    public static void Method2162920(boolean bl) {
        double d = Math.floor(PlayerUtilSC.Field3232.player.posX) + 0.5;
        double d2 = Math.floor(PlayerUtilSC.Field3232.player.posZ) + 0.5;
        if (bl) {
            PlayerUtilSC.Method2162931((d - SurroundRewrite.Field2811.player.posX) / 2.0, SurroundRewrite.Field2811.player.motionY, (d2 - SurroundRewrite.Field2811.player.posZ) / 2.0);
            PlayerUtilSC.Field3232.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, PlayerUtilSC.Field3232.player.posY, d2, PlayerUtilSC.Field3232.player.onGround));
        } else {
            PlayerUtilSC.Field3232.player.setPosition(d, PlayerUtilSC.Field3232.player.posY, d2);
            PlayerUtilSC.Field3232.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, PlayerUtilSC.Field3232.player.posY, d2, PlayerUtilSC.Field3232.player.onGround));
        }
    }

    public static void Method2162931(double d, double d2, double d3) {
        if (PlayerUtilSC.Field3232.player != null) {
            if (PlayerUtilSC.Field3232.player.isRiding()) {
                PlayerUtilSC.Field3232.player.ridingEntity.motionX = d;
                PlayerUtilSC.Field3232.player.ridingEntity.motionY = d2;
                PlayerUtilSC.Field3232.player.ridingEntity.motionZ = d;
            } else {
                PlayerUtilSC.Field3232.player.motionX = d;
                PlayerUtilSC.Field3232.player.motionY = d2;
                PlayerUtilSC.Field3232.player.motionZ = d3;
            }
        }
    }

    public static boolean Method2162932(int n2) {
        if (n2 != 0 && n2 < 256) {
            return n2 < 0 ? Mouse.isButtonDown((int) (n2 + 100)) : Keyboard.isKeyDown((int) n2);
        }
        return false;
    }

    public static void Method2162933(Vec3d vec3d) {
        float[] arrf = PlayerUtilSC.Method2162934(vec3d);
        PlayerUtilSC.Field3232.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], (float) MathHelper.normalizeAngle((int) ((int) arrf[1]), (int) 360), PlayerUtilSC.Field3232.player.onGround));
        ((IEntityPlayerSP) PlayerUtilSC.Field3232.player).setLastReportedYaw(arrf[0]);
        ((IEntityPlayerSP) PlayerUtilSC.Field3232.player).setLastReportedPitch(MathHelper.normalizeAngle((int) ((int) arrf[1]), (int) 360));
    }

    public static float[] Method2162934(Vec3d vec3d) {
        Vec3d vec3d2 = PlayerUtilSC.Method2162910();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        float[] arrf = new float[]{PlayerUtilSC.Field3232.player.rotationYaw + MathHelper.wrapDegrees((float) (f - PlayerUtilSC.Field3232.player.rotationYaw)), PlayerUtilSC.Field3232.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - PlayerUtilSC.Field3232.player.rotationPitch))};
        return arrf;
    }
}

