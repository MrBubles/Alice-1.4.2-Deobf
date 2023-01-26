

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Objects;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.BlockPos;

public class MovementUtil
        implements Util {
    public static boolean Method2163893() {
        return (double) MovementUtil.Field2811.player.moveForward != 0.0 || (double) MovementUtil.Field2811.player.moveStrafing != 0.0;
    }

    public static boolean Method2163894() {
        return MovementUtil.Field2811.player.movementInput.forwardKeyDown || MovementUtil.Field2811.player.movementInput.backKeyDown || MovementUtil.Field2811.player.movementInput.leftKeyDown || MovementUtil.Field2811.player.movementInput.rightKeyDown || MovementUtil.Field2811.player.movementInput.jump || MovementUtil.Field2811.player.movementInput.sneak;
    }

    public static void Method2163895(double d) {
        double d2 = MovementUtil.Field2811.player.movementInput.moveForward;
        double d3 = MovementUtil.Field2811.player.movementInput.moveStrafe;
        float f = MovementUtil.Field2811.player.rotationYaw;
        if (d2 == 0.0 && d3 == 0.0) {
            MovementUtil.Field2811.player.motionX = 0.0;
            MovementUtil.Field2811.player.motionZ = 0.0;
        } else {
            if (d2 != 0.0) {
                if (d3 > 0.0) {
                    f += (float) (d2 > 0.0 ? -45 : 45);
                } else if (d3 < 0.0) {
                    f += (float) (d2 > 0.0 ? 45 : -45);
                }
                d3 = 0.0;
                if (d2 > 0.0) {
                    d2 = 1.0;
                } else if (d2 < 0.0) {
                    d2 = -1.0;
                }
            }
            MovementUtil.Field2811.player.motionX = d2 * d * -Math.sin(Math.toRadians(f)) + d3 * d * Math.cos(Math.toRadians(f));
            MovementUtil.Field2811.player.motionZ = d2 * d * Math.cos(Math.toRadians(f)) - d3 * d * -Math.sin(Math.toRadians(f));
        }
    }

    public static void Method2163896(MoveEvent moveEvent, double d) {
        if (MovementUtil.Method2163893()) {
            double[] arrd = MovementUtil.Method2163897(d);
            moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(arrd[0]);
            moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(arrd[1]);
        } else {
            moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
            moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
        }
    }

    public static double[] Method2163897(double d) {
        return MovementUtil.Method2163898((Entity) MovementUtil.Field2811.player, d);
    }

    public static double[] Method2163898(Entity entity, double d) {
        return MovementUtil.Method2163899(entity, MovementUtil.Field2811.player.movementInput, d);
    }

    public static double[] Method2163899(Entity entity, MovementInput movementInput, double d) {
        float f = movementInput.moveForward;
        float f2 = movementInput.moveStrafe;
        float f3 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * Field2811.getRenderPartialTicks();
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
        double d2 = (double) f * d * -Math.sin(Math.toRadians(f3)) + (double) f2 * d * Math.cos(Math.toRadians(f3));
        double d3 = (double) f * d * Math.cos(Math.toRadians(f3)) - (double) f2 * d * -Math.sin(Math.toRadians(f3));
        return new double[]{d2, d3};
    }

    public static MovementInput Method2163890(Entity entity, double d) {
        MovementInput movementInput = new MovementInput();
        movementInput.sneak = entity.isSneaking();
        block0:
        for (float f = -1.0f; f <= 1.0f; f += 1.0f) {
            for (float f2 = -1.0f; f2 <= 1.0f; f2 += 1.0f) {
                MovementInput movementInput2 = new MovementInput();
                movementInput2.moveForward = f;
                movementInput2.moveStrafe = f2;
                movementInput2.sneak = entity.isSneaking();
                double[] arrd = MovementUtil.Method2163899(entity, movementInput2, d);
                if (entity.isSneaking()) {
                    arrd[0] = arrd[0] * (double) 0.3f;
                    arrd[1] = arrd[1] * (double) 0.3f;
                }
                double d2 = arrd[0];
                double d3 = arrd[1];
                if (!(d2 < 0.0 ? entity.motionX <= d2 : entity.motionX >= d2) || !(d3 < 0.0 ? entity.motionZ <= d3 : entity.motionZ >= d3))
                    continue;
                movementInput.moveForward = f;
                movementInput.moveStrafe = f2;
                continue block0;
            }
        }
        return movementInput;
    }

    public static double Method2163801() {
        double d = MovementUtil.Field2811.player.posX - MovementUtil.Field2811.player.prevPosX;
        double d2 = MovementUtil.Field2811.player.posZ - MovementUtil.Field2811.player.prevPosZ;
        return Math.sqrt(d * d + d2 * d2);
    }

    public static double Method2163802() {
        double d = MovementUtil.Field2811.player.posX - MovementUtil.Field2811.player.prevPosX;
        double d2 = MovementUtil.Field2811.player.posY - MovementUtil.Field2811.player.prevPosY;
        double d3 = MovementUtil.Field2811.player.posZ - MovementUtil.Field2811.player.prevPosZ;
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    public static double Method2163803() {
        return MovementUtil.Method2163804(false);
    }

    public static double Method2163804(boolean bl) {
        int n2;
        double d = 0.2873;
        if (MovementUtil.Field2811.player.isPotionActive(MobEffects.SPEED)) {
            n2 = Objects.requireNonNull(MovementUtil.Field2811.player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier();
            d *= 1.0 + 0.2 * (double) (n2 + 1);
        }
        if (bl && MovementUtil.Field2811.player.isPotionActive(MobEffects.SLOWNESS)) {
            n2 = Objects.requireNonNull(MovementUtil.Field2811.player.getActivePotionEffect(MobEffects.SLOWNESS)).getAmplifier();
            d /= 1.0 + 0.2 * (double) (n2 + 1);
        }
        return d;
    }

    public static double Method2163805() {
        double d = 0.0;
        if (MovementUtil.Field2811.player.isPotionActive(MobEffects.JUMP_BOOST)) {
            int n2 = MovementUtil.Field2811.player.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier();
            d += (double) (n2 + 1) * 0.1;
        }
        return d;
    }

    public static boolean Method2163806(double d, double d2, double d3) {
        if (MovementUtil.Field2811.player.motionX != 0.0 || MovementUtil.Field2811.player.motionZ != 0.0) {
            BlockPos blockPos = new BlockPos((Entity) MovementUtil.Field2811.player).add(MovementUtil.Field2811.player.motionX * 10000.0, 0.0, MovementUtil.Field2811.player.motionZ * 10000.0);
            BlockPos blockPos2 = new BlockPos((Entity) MovementUtil.Field2811.player).add(MovementUtil.Field2811.player.motionX * -10000.0, 0.0, MovementUtil.Field2811.player.motionY * -10000.0);
            return blockPos.distanceSq(d, d2, d3) < blockPos2.distanceSq(d, d2, d3);
        }
        return true;
    }

    public static boolean Method2163807() {
        return MovementUtil.Field2811.gameSettings.keyBindForward.isKeyDown() || MovementUtil.Field2811.gameSettings.keyBindBack.isKeyDown() || MovementUtil.Field2811.gameSettings.keyBindLeft.isKeyDown() || MovementUtil.Field2811.gameSettings.keyBindRight.isKeyDown();
    }

    public static void Method2163808(float f) {
        if (MovementUtil.Field2811.player.isOnLadder()) {
            return;
        }
        MovementUtil.Field2811.player.stepHeight = f;
    }

    public static void Method2163809(double d, double d2, double d3) {
        if (MovementUtil.Field2811.player != null) {
            if (MovementUtil.Field2811.player.isRiding()) {
                MovementUtil.Field2811.player.ridingEntity.motionX = d;
                MovementUtil.Field2811.player.ridingEntity.motionY = d2;
                MovementUtil.Field2811.player.ridingEntity.motionZ = d;
            } else {
                MovementUtil.Field2811.player.motionX = d;
                MovementUtil.Field2811.player.motionY = d2;
                MovementUtil.Field2811.player.motionZ = d3;
            }
        }
    }

    public static double Method2163800(double d) {
        int n2;
        double d2 = d;
        if (MovementUtil.Field2811.player.isPotionActive(MobEffects.SPEED)) {
            n2 = MovementUtil.Field2811.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d2 *= 1.0 + 0.2 * (double) (n2 + 1);
        }
        if (MovementUtil.Field2811.player.isPotionActive(MobEffects.SLOWNESS)) {
            n2 = MovementUtil.Field2811.player.getActivePotionEffect(MobEffects.SLOWNESS).getAmplifier();
            d2 /= 1.0 + 0.2 * (double) (n2 + 1);
        }
        return d2;
    }
}

