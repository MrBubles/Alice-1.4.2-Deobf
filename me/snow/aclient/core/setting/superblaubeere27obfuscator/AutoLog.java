

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoReconnect;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoLog
        extends Module {
    private static AutoLog Field2085 = new AutoLog();
    private final Setting<Float> Field2086 = this.Method2150366(new Setting<Float>("Health", Float.valueOf(16.0f), Float.valueOf(0.1f), Float.valueOf(36.0f)));
    private final Setting<Boolean> Field2087 = this.Method2150366(new Setting<Boolean>("Beds", true));
    private final Setting<Float> Field2088 = this.Method2150366(new Setting<Object>("BedRange", Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(36.0f), this::Method2161709));
    private final Setting<Boolean> Field2089 = this.Method2150366(new Setting<Boolean>("LogoutOff", true));

    public AutoLog() {
        super("AutoLog", "Logs when in danger.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, false, false, false);
        this.Method2161707();
    }

    public static AutoLog Method2161706() {
        if (Field2085 == null) {
            Field2085 = new AutoLog();
        }
        return Field2085;
    }

    private void Method2161707() {
        Field2085 = this;
    }

    @Override
    public void Method2150376() {
        if (!AutoLog.Method2150358() && AutoLog.Field2811.player.getHealth() <= this.Field2086.getValue().floatValue()) {
            AliceMain.Field756.Method2150180(AutoReconnect.class).Method2150380();
            AutoLog.Field2811.player.connection.sendPacket((Packet) new SPacketDisconnect((ITextComponent) new TextComponentString("AutoLogged")));
            if (this.Field2089.getValue().booleanValue()) {
                this.Method2150380();
            }
        }
    }

    @SubscribeEvent
    public void Method2161708(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketBlockChange sPacketBlockChange;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketBlockChange && this.Field2087.getValue().booleanValue() && (sPacketBlockChange = (SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockState().getBlock() == Blocks.BED && AutoLog.Field2811.player.getDistanceSqToCenter(sPacketBlockChange.getBlockPosition()) <= MathUtil.Method2163857(this.Field2088.getValue().floatValue())) {
            AliceMain.Field756.Method2150180(AutoReconnect.class).Method2150380();
            AutoLog.Field2811.player.connection.sendPacket((Packet) new SPacketDisconnect((ITextComponent) new TextComponentString("AutoLogged")));
            if (this.Field2089.getValue().booleanValue()) {
                this.Method2150380();
            }
        }
    }

    @Override
    public void Method2150377() {
        if (this.Method2150364()) {
            this.Method2150380();
            this.Method2150389();
        }
    }

    private boolean Method2161709(Object object) {
        return this.Field2087.getValue();
    }
}

