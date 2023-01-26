

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StepEvent;
import net.minecraft.block.material.Material;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VanillaSpeed
        extends Module {
    public Setting<Double> Field4497 = this.Method2150366(new Setting<Double>("Speed", 1.0, 1.0, 20.0));
    public Setting<Boolean> Field4498 = this.Method2150366(new Setting<Boolean>("Step", false));
    public Setting<Boolean> Field4499 = this.Method2150366(new Setting<Boolean>("Vanilla", Boolean.valueOf(false), this::Method2162156));
    public Setting<Integer> Field4500 = this.Method2150366(new Setting<Integer>("Height", Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(5), this::Method2162155));
    public Setting<Boolean> Field4501 = this.Method2150366(new Setting<Boolean>("Disable", Boolean.valueOf(false), this::Method2162154));

    public VanillaSpeed() {
        super("VanillaSpeed", "ec.me", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @Override
    public void Method2150379() {
        if (VanillaSpeed.Field2811.player == null || VanillaSpeed.Field2811.world == null) {
            return;
        }
        double[] arrd = MathUtil.Method2163867(this.Field4497.getValue() / 10.0);
        VanillaSpeed.Field2811.player.motionX = arrd[0];
        VanillaSpeed.Field2811.player.motionZ = arrd[1];
    }

    @SubscribeEvent
    public void Method2162152(StepEvent stepEvent) {
        if (Feature.Method2150359()) {
            this.Method2150380();
            return;
        }
        if (VanillaSpeed.Field2811.player.onGround && !VanillaSpeed.Field2811.player.isInsideOfMaterial(Material.WATER) && !VanillaSpeed.Field2811.player.isInsideOfMaterial(Material.LAVA) && VanillaSpeed.Field2811.player.collidedVertically && VanillaSpeed.Field2811.player.fallDistance == 0.0f && !VanillaSpeed.Field2811.gameSettings.keyBindJump.pressed && !VanillaSpeed.Field2811.player.isOnLadder() && this.Field4498.getValue().booleanValue()) {
            stepEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((float) this.Field4500.getValue().intValue());
            double d = VanillaSpeed.Field2811.player.getEntityBoundingBox().minY - VanillaSpeed.Field2811.player.posY;
            if (d >= 0.625) {
                if (!this.Field4499.getValue().booleanValue()) {
                    this.Method2162153(d);
                }
                if (this.Field4501.getValue().booleanValue()) {
                    this.Method2150380();
                }
            }
        } else {
            stepEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.6f);
        }
    }

    private void Method2162153(double d) {
        block12:
        {
            double d2;
            double d3;
            double d4;
            block11:
            {
                d4 = VanillaSpeed.Field2811.player.posX;
                d3 = VanillaSpeed.Field2811.player.posZ;
                d2 = VanillaSpeed.Field2811.player.posY;
                if (!(d < 1.1)) break block11;
                double d5 = 0.42;
                double d6 = 0.75;
                if (d != 1.0) {
                    d5 *= d;
                    d6 *= d;
                    if (d5 > 0.425) {
                        d5 = 0.425;
                    }
                    if (d6 > 0.78) {
                        d6 = 0.78;
                    }
                    if (d6 < 0.49) {
                        d6 = 0.49;
                    }
                }
                VanillaSpeed.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d4, d2 + d5, d3, false));
                if (!(d2 + d6 < d2 + d)) break block12;
                VanillaSpeed.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d4, d2 + d6, d3, false));
                break block12;
            }
            if (d < 1.6) {
                for (double d7 : new double[]{0.42, 0.33, 0.24, 0.083, -0.078}) {
                    VanillaSpeed.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d4, d2 += d7, d3, false));
                }
            } else if (d < 2.1) {
                for (double d8 : new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869}) {
                    VanillaSpeed.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d4, d2 + d8, d3, false));
                }
            } else {
                for (double d9 : new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907}) {
                    VanillaSpeed.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d4, d2 + d9, d3, false));
                }
            }
        }
    }

    private boolean Method2162154(Boolean bl) {
        return this.Field4498.getValue();
    }

    private boolean Method2162155(Integer n2) {
        return this.Field4498.getValue();
    }

    private boolean Method2162156(Boolean bl) {
        return this.Field4498.getValue();
    }
}

