

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.text.DecimalFormat;
import java.text.Format;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MotionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TickShift;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class Step
        extends Module {
    private static Step Field3104;
    public final Setting<Double> Field3098 = this.Method2150366(new Setting<Double>("Height", 2.0, 1.0, 10.0));
    public final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3099 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Vanilla));
    public final Setting<Boolean> Field3100 = this.Method2150366(new Setting<Boolean>("Timer", true));
    public final Setting<Boolean> Field3101 = this.Method2150366(new Setting<Boolean>("Strict", true));
    public final Setting<Boolean> Field3102 = this.Method2150366(new Setting<Boolean>("No Liquids", true));
    private int Field3103 = 0;

    public Step() {
        super("Step", "Allows you to walk up blocks as if they were stairs", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    public static Step Method2162145() {
        if (Field3104 == null) {
            Field3104 = new Step();
        }
        return Field3104;
    }

    public static double[] Method2162146(double d) {
        float f = Step.Field2811.player.movementInput.moveForward;
        float f2 = Step.Field2811.player.movementInput.moveStrafe;
        float f3 = Step.Field2811.player.prevRotationYaw + (Step.Field2811.player.rotationYaw - Step.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
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

    public static void Method2162147() {
        AliceMain.Field756.Method2150180(Step.class).Field3099.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Normal);
        AliceMain.Field756.Method2150180(Step.class).Field3098.setValue(2.0);
        AliceMain.Field756.Method2150180(Step.class).Field3100.setValue(false);
        AliceMain.Field756.Method2150180(Step.class).Field3101.setValue(false);
    }

    public static void Method2162148() {
        AliceMain.Field756.Method2150180(Step.class).Field3099.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Normal);
        AliceMain.Field756.Method2150180(Step.class).Field3098.setValue(1.0);
        AliceMain.Field756.Method2150180(Step.class).Field3100.setValue(true);
        AliceMain.Field756.Method2150180(Step.class).Field3101.setValue(true);
    }

    public static void Method2162149() {
        AliceMain.Field756.Method2150180(Step.class).Field3099.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Vanilla);
        AliceMain.Field756.Method2150180(Step.class).Field3098.setValue(2.0);
        AliceMain.Field756.Method2150180(Step.class).Field3100.setValue(false);
        AliceMain.Field756.Method2150180(Step.class).Field3101.setValue(false);
    }

    @Override
    public void Method2150376() {
        Object object;
        if (Step.Field2811.world == null || Step.Field2811.player == null) {
            return;
        }
        if (this.Field3102.getValue().booleanValue() && (Step.Field2811.player.isInWater() || Step.Field2811.player.isInLava())) {
            return;
        }
        if (this.Field3099.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Normal) {
            if (this.Field3103 == 0 && !AliceMain.Field756.Method2150180(TickShift.class).Method2150364()) {
                EntityUtil.Method2163574();
            } else {
                --this.Field3103;
            }
            object = MotionUtil.Method2163889(0.1);
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            if (Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 2.6, (double) object[1])).isEmpty() && !Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 2.4, (double) object[1])).isEmpty()) {
                bl = true;
            }
            if (Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 2.1, (double) object[1])).isEmpty() && !Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 1.9, (double) object[1])).isEmpty()) {
                bl2 = true;
            }
            if (Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 1.6, (double) object[1])).isEmpty() && !Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 1.4, (double) object[1])).isEmpty()) {
                bl3 = true;
            }
            if (Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 1.0, (double) object[1])).isEmpty() && !Step.Field2811.world.getCollisionBoxes((Entity) Step.Field2811.player, Step.Field2811.player.getEntityBoundingBox().offset((double) object[0], 0.6, (double) object[1])).isEmpty()) {
                bl4 = true;
            }
            if (Step.Field2811.player.collidedHorizontally && (Step.Field2811.player.moveForward != 0.0f || Step.Field2811.player.moveStrafing != 0.0f) && Step.Field2811.player.onGround) {
                int n2;
                double[] arrd;
                if (bl4 && this.Field3098.getValue() >= 1.0) {
                    if (this.Field3101.getValue().booleanValue()) {
                        arrd = new double[]{0.42, 0.753, 1.0};
                        for (n2 = 0; n2 < arrd.length; ++n2) {
                            Step.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Step.Field2811.player.posX, Step.Field2811.player.posY + arrd[n2], Step.Field2811.player.posZ, Step.Field2811.player.onGround));
                        }
                    } else {
                        arrd = new double[]{0.42, 0.753};
                        for (n2 = 0; n2 < arrd.length; ++n2) {
                            Step.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Step.Field2811.player.posX, Step.Field2811.player.posY + arrd[n2], Step.Field2811.player.posZ, Step.Field2811.player.onGround));
                        }
                    }
                    if (this.Field3100.getValue().booleanValue() && !AliceMain.Field756.Method2150180(TickShift.class).Method2150364()) {
                        EntityUtil.Method2163575(0.38f);
                    }
                    Step.Field2811.player.setPosition(Step.Field2811.player.posX, Step.Field2811.player.posY + 1.0, Step.Field2811.player.posZ);
                    this.Field3103 = 1;
                }
                if (bl3 && this.Field3098.getValue() >= 1.5) {
                    arrd = new double[]{0.42, 0.75, 1.0, 1.16, 1.23, 1.2};
                    for (n2 = 0; n2 < arrd.length; ++n2) {
                        Step.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Step.Field2811.player.posX, Step.Field2811.player.posY + arrd[n2], Step.Field2811.player.posZ, Step.Field2811.player.onGround));
                    }
                    if (this.Field3100.getValue().booleanValue() && !AliceMain.Field756.Method2150180(TickShift.class).Method2150364()) {
                        EntityUtil.Method2163575(0.38f);
                    }
                    Step.Field2811.player.setPosition(Step.Field2811.player.posX, Step.Field2811.player.posY + 1.5, Step.Field2811.player.posZ);
                    this.Field3103 = 1;
                }
                if (bl2 && this.Field3098.getValue() >= 2.0) {
                    arrd = new double[]{0.42, 0.78, 0.63, 0.51, 0.9, 1.21, 1.45, 1.43};
                    for (n2 = 0; n2 < arrd.length; ++n2) {
                        Step.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Step.Field2811.player.posX, Step.Field2811.player.posY + arrd[n2], Step.Field2811.player.posZ, Step.Field2811.player.onGround));
                    }
                    if (this.Field3100.getValue().booleanValue() && !AliceMain.Field756.Method2150180(TickShift.class).Method2150364()) {
                        EntityUtil.Method2163575(0.38f);
                    }
                    Step.Field2811.player.setPosition(Step.Field2811.player.posX, Step.Field2811.player.posY + 2.0, Step.Field2811.player.posZ);
                    this.Field3103 = 2;
                }
                if (bl && this.Field3098.getValue() >= 2.5) {
                    arrd = new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907};
                    for (n2 = 0; n2 < arrd.length; ++n2) {
                        Step.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Step.Field2811.player.posX, Step.Field2811.player.posY + arrd[n2], Step.Field2811.player.posZ, Step.Field2811.player.onGround));
                    }
                    if (this.Field3100.getValue().booleanValue() && !AliceMain.Field756.Method2150180(TickShift.class).Method2150364()) {
                        EntityUtil.Method2163575(0.2f);
                    }
                    Step.Field2811.player.setPosition(Step.Field2811.player.posX, Step.Field2811.player.posY + 2.5, Step.Field2811.player.posZ);
                    this.Field3103 = 2;
                }
            }
        }
        if (this.Field3099.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Vanilla) {
            object = new DecimalFormat("#");
            Step.Field2811.player.stepHeight = Float.parseFloat(((Format) object).format(this.Field3098.getValue()));
        }
    }

    @Override
    public String Method2150385() {
        return this.Field3099.currentEnumName();
    }

    @Override
    public void Method2150373() {
        Step.Field2811.player.stepHeight = 0.6f;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Vanilla,
        Normal;

    }
}

