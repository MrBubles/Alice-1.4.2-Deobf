

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MovementUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhysicsUtil;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Clip
        extends Module {
    public Setting<Float> Field1297 = this.Method2150366(new Setting<Float>("Factor", Float.valueOf(1.2f), Float.valueOf(0.1f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field1298 = this.Method2150366(new Setting<Boolean>("AutoWalk", true));
    public Setting<Boolean> Field1299 = this.Method2150366(new Setting<Boolean>("OnEdge", false));
    public Setting<Boolean> Field1300 = this.Method2150366(new Setting<Boolean>("Clip", false));
    public Setting<Boolean> Field1301 = this.Method2150366(new Setting<Boolean>("Teleport", false));
    public Setting<Float> Field1302 = this.Method2150366(new Setting<Object>("Blocks", Float.valueOf(0.3f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2161415));
    public Setting<Boolean> Field1303 = this.Method2150366(new Setting<Boolean>("TickShift", false));
    public Setting<Integer> Field1304 = this.Method2150366(new Setting<Object>("Ticks", Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(100), this::Method2161414));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field1305 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Timer", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Strict));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1306 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Rubberband", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None));
    int Field1307 = 0;

    public Clip() {
        super("Clip", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @Override
    public void Method2150374() {
        if (this.Field1305.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.None) {
            AliceMain.Field771.Method2150369();
        }
        this.Field1307 = 0;
    }

    @Override
    public void Method2150379() {
        if (Clip.Method2150359()) {
            return;
        }
        if (!this.Method2161413() && this.Field1299.getValue().booleanValue()) {
            return;
        }
        if (!EntityUtil.Method2163550() && !this.Field1298.getValue().booleanValue()) {
            return;
        }
        if (this.Field1305.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.None) {
            AliceMain.Field771.Method2150334(this.Field1305.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Fast ? 1.15f : 1.0888f);
        }
        if (this.Field1303.getValue().booleanValue()) {
            if (this.Field1307 < this.Field1304.getValue()) {
                ++this.Field1307;
                PhysicsUtil.Method2163917();
            } else {
                this.Field1307 = 0;
            }
        }
        double d = Math.cos(Math.toRadians(Clip.Field2811.player.rotationYaw + 90.0f));
        double d2 = Math.sin(Math.toRadians(Clip.Field2811.player.rotationYaw + 90.0f));
        Clip.Field2811.player.setVelocity(0.0, 0.0, 0.0);
        MovementUtil.Method2163809(0.0, 0.0, 0.0);
        if (this.Field1300.getValue().booleanValue()) {
            Clip.Field2811.player.noClip = true;
            Clip.Field2811.player.onGround = true;
            Clip.Field2811.player.collidedHorizontally = false;
            Clip.Field2811.player.capabilities.isFlying = false;
            Clip.Field2811.player.collidedVertically = false;
        }
        if (this.Field1301.getValue().booleanValue()) {
            for (double d3 = 0.0625; d3 < (double) this.Field1302.getValue().floatValue(); d3 += 0.262) {
                double[] arrd = MathUtil.Method2163867(d3);
                Clip.Field2811.player.setLocationAndAngles(Clip.Field2811.player.posX + arrd[0], Clip.Field2811.player.posY, Clip.Field2811.player.posZ + arrd[1], Clip.Field2811.player.rotationYaw, Clip.Field2811.player.rotationPitch);
                Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.Position(Clip.Field2811.player.posX + arrd[0], Clip.Field2811.player.posY, Clip.Field2811.player.posZ + arrd[1], Clip.Field2811.player.onGround));
            }
        }
        Clip.Field2811.player.setEntityBoundingBox(Clip.Field2811.player.getEntityBoundingBox().offset((double) this.Field1297.getValue().floatValue() / 10.0 * d, 0.0, (double) this.Field1297.getValue().floatValue() / 10.0 * d2));
    }

    @SubscribeEvent
    public void Method2161412(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (this.Method2150365()) {
            return;
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook) {
            SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            switch (1.F ield810[this.Field1306.getValue().ordinal()]){
                case 1: {
                    Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.PositionRotation(Clip.Field2811.player.posX, Clip.Field2811.player.posY, Clip.Field2811.player.posZ, Clip.Field2811.player.rotationYaw, Clip.Field2811.player.rotationPitch, Clip.Field2811.player.onGround));
                    Clip.Field2811.player.setLocationAndAngles(Clip.Field2811.player.posX, Clip.Field2811.player.posY, Clip.Field2811.player.posZ, Clip.Field2811.player.rotationYaw, Clip.Field2811.player.rotationPitch);
                    break;
                }
                case 2: {
                    iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.setCanceled(true);
                    break;
                }
                case 3: {
                    Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.PositionRotation(sPacketPlayerPosLook.getX(), sPacketPlayerPosLook.getY(), sPacketPlayerPosLook.getZ(), Clip.Field2811.player.rotationYaw, Clip.Field2811.player.rotationPitch, Clip.Field2811.player.onGround));
                    Clip.Field2811.player.setLocationAndAngles(sPacketPlayerPosLook.getX(), sPacketPlayerPosLook.getY(), sPacketPlayerPosLook.getZ(), Clip.Field2811.player.rotationYaw, Clip.Field2811.player.rotationPitch);
                }
            }
        }
    }

    @Override
    public void Method2150378() {
        if (this.Method2150364()) {
            this.Method2150380();
        }
    }

    public boolean Method2161413() {
        return !Clip.Field2811.world.getCollisionBoxes((Entity) Clip.Field2811.player, Clip.Field2811.player.getEntityBoundingBox().expand(-0.0625, 0.0, -0.0625)).isEmpty();
    }

    private boolean Method2161414(Object object) {
        return this.Field1303.getValue();
    }

    private boolean Method2161415(Object object) {
        return this.Field1301.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        None,
        Desync,
        Cancel,
        Accept;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        Strict,
        Fast,
        None;

    }
}

