

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.item.ItemBow
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.item.ItemBow;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.math.BlockPos;

public class BowSpam
        extends Module {
    private final Setting<Integer> Field18 = this.Method2150366(new Setting<Integer>("Draw Length", 3, 3, 21));

    public BowSpam() {
        super("BowSpam", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    @Override
    public void Method2150379() {
        if (BowSpam.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemBow && BowSpam.Field2811.player.isHandActive() && BowSpam.Field2811.player.getItemInUseMaxCount() >= this.Field18.getValue()) {
            BowSpam.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, BowSpam.Field2811.player.getHorizontalFacing()));
            BowSpam.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItem(BowSpam.Field2811.player.getActiveHand()));
            BowSpam.Field2811.player.stopActiveHand();
        }
    }
}

