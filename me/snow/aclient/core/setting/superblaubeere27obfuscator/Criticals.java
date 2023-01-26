

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Criticals
        extends Module {
    private static Criticals Field984;
    public final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field975 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PACKET));
    private final Setting<Integer> Field976 = this.Method2150366(new Setting<Object>("DesyncDelay", 10, 0, 500, this::Method2161189, "Amount of packets you want to send."));
    private final Timer Field977 = new Timer();
    private final Timer Field978 = new Timer();
    public Setting<Boolean> Field979 = this.Method2150366(new Setting<Boolean>("NoDesync", true));
    public Setting<Boolean> Field980 = this.Method2150366(new Setting<Boolean>("CancelFirst32k", true));
    public Setting<Integer> Field981 = this.Method2150366(new Setting<Object>("32kDelay", Integer.valueOf(25), Integer.valueOf(0), Integer.valueOf(500), this::Method2161188));
    private boolean Field982;
    private boolean Field983;

    public Criticals() {
        super("Criticals", "Scores criticals for you", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static Criticals Method2161184() {
        if (Field984 == null) {
            Field984 = new Criticals();
        }
        return Field984;
    }

    public static void Method2161186() {
        AliceMain.Field756.Method2150180(Criticals.class).Field975.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PACKET);
    }

    public static void Method2161187() {
        AliceMain.Field756.Method2150180(Criticals.class).Field975.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NCPStrict);
    }

    @SubscribeEvent
    public void Method2161185(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        CPacketUseEntity cPacketUseEntity;
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction() == CPacketUseEntity.Action.ATTACK) {
            if (this.Field982) {
                this.Field978.Method2164750();
                this.Field983 = true;
                this.Field977.Method2164756(this.Field976.getValue() + 1);
                this.Field982 = false;
                return;
            }
            if (this.Field983 && !this.Field978.Method2164755(this.Field981.getValue().intValue())) {
                return;
            }
            if (this.Field983 && this.Field978.Method2164755(this.Field981.getValue().intValue())) {
                this.Field983 = false;
            }
            if (!this.Field977.Method2164755(this.Field976.getValue().intValue())) {
                return;
            }
            if (!(!Criticals.Field2811.player.onGround || Criticals.Field2811.gameSettings.keyBindJump.isKeyDown() || !(cPacketUseEntity.getEntityFromWorld((World) Criticals.Field2811.world) instanceof EntityLivingBase) && this.Field979.getValue().booleanValue() || Criticals.Field2811.player.isInWater() || Criticals.Field2811.player.isInLava())) {
                if (this.Field975.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PACKET) {
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY + 0.0625101, Criticals.Field2811.player.posZ, false));
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY, Criticals.Field2811.player.posZ, false));
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY + 1.1E-5, Criticals.Field2811.player.posZ, false));
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY, Criticals.Field2811.player.posZ, false));
                }
                if (this.Field975.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NCPStrict) {
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY + 0.062600301692775, Criticals.Field2811.player.posZ, false));
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY + 0.07260029960661, Criticals.Field2811.player.posZ, false));
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY, Criticals.Field2811.player.posZ, false));
                    Criticals.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Criticals.Field2811.player.posX, Criticals.Field2811.player.posY, Criticals.Field2811.player.posZ, false));
                }
                if (this.Field975.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.JUMP) {
                    Criticals.Field2811.player.jump();
                }
                if (this.Field975.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MINIJUMP) {
                    Criticals.Field2811.player.motionY /= 2.0;
                }
                this.Field977.Method2164750();
            }
        }
    }

    @Override
    public String Method2150385() {
        switch (1.F ield3151[this.Field975.getValue().ordinal()]){
            case 1: {
                return "Jump";
            }
            case 2: {
                return "MiniJump";
            }
            case 3: {
                return "Packet";
            }
            case 4: {
                return "NCPStrict";
            }
        }
        return null;
    }

    private boolean Method2161188(Object object) {
        return this.Field980.getValue();
    }

    private boolean Method2161189(Object object) {
        return this.Field975.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PACKET;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        JUMP,
        MINIJUMP,
        PACKET,
        NCPStrict;

    }
}

