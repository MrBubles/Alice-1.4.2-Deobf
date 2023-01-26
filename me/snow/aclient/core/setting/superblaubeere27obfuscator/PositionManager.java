

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class PositionManager
        extends Feature {
    private double Field4493;
    private double Field4494;
    private double Field4495;
    private boolean Field4496;

    public void Method2150249() {
        this.Field4493 = PositionManager.Field2811.player.posX;
        this.Field4494 = PositionManager.Field2811.player.posY;
        this.Field4495 = PositionManager.Field2811.player.posZ;
        this.Field4496 = PositionManager.Field2811.player.onGround;
    }

    public void Method2150240() {
        PositionManager.Field2811.player.posX = this.Field4493;
        PositionManager.Field2811.player.posY = this.Field4494;
        PositionManager.Field2811.player.posZ = this.Field4495;
        PositionManager.Field2811.player.onGround = this.Field4496;
    }

    public void Method2150251(double d, double d2, double d3) {
        PositionManager.Field2811.player.posX = d;
        PositionManager.Field2811.player.posY = d2;
        PositionManager.Field2811.player.posZ = d3;
    }

    public void Method2150252(double d, double d2, double d3, boolean bl) {
        PositionManager.Field2811.player.posX = d;
        PositionManager.Field2811.player.posY = d2;
        PositionManager.Field2811.player.posZ = d3;
        PositionManager.Field2811.player.onGround = bl;
    }

    public void Method2150253(double d, double d2, double d3, boolean bl, boolean bl2, boolean bl3) {
        PositionManager.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, d2, d3, bl));
        if (bl2) {
            PositionManager.Field2811.player.setPosition(d, d2, d3);
            if (bl3) {
                this.Method2150249();
            }
        }
    }

    public double Method2150254() {
        return this.Field4493;
    }

    public void Method2150255(double d) {
        this.Field4493 = d;
    }

    public double Method2150256() {
        return this.Field4494;
    }

    public void Method2150257(double d) {
        this.Field4494 = d;
    }

    public double Method2150258() {
        return this.Field4495;
    }

    public void Method2150259(double d) {
        this.Field4495 = d;
    }
}

