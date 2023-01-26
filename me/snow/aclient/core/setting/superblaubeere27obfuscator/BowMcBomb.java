

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BowMcBomb
        extends Module {
    public Setting<Boolean> Field712 = this.Method2150366(new Setting<Boolean>("Bows", true));
    public Setting<Boolean> Field713 = this.Method2150366(new Setting<Boolean>("Pearls", false));
    public Setting<Boolean> Field714 = this.Method2150366(new Setting<Boolean>("Eggs", false));
    public Setting<Boolean> Field715 = this.Method2150366(new Setting<Boolean>("SnowBallz", false));
    public Setting<Integer> Field716 = this.Method2150366(new Setting<Integer>("Timeout", 100, 100, 20000));
    public Setting<Integer> Field717 = this.Method2150366(new Setting<Integer>("Spoofs", 50, 1, 300));
    public Setting<Boolean> Field718 = this.Method2150366(new Setting<Boolean>("Bypass", true));
    public Setting<Boolean> Field719 = this.Method2150366(new Setting<Boolean>("Debug", false));
    private boolean Field710;
    private long Field711;

    public BowMcBomb() {
        super("BowMcBomb", "Uno hitter w bows", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @Override
    public void Method2150372() {
        if (this.Method2150364()) {
            this.Field710 = false;
            this.Field711 = System.currentTimeMillis();
        }
    }

    @SubscribeEvent
    public void Method2161835(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        ItemStack itemStack;
        CPacketPlayerTryUseItem cPacketPlayerTryUseItem;
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0) {
            return;
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerDigging) {
            ItemStack itemStack2;
            CPacketPlayerDigging cPacketPlayerDigging = (CPacketPlayerDigging) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (cPacketPlayerDigging.getAction() == CPacketPlayerDigging.Action.RELEASE_USE_ITEM && !(itemStack2 = BowMcBomb.Field2811.player.getHeldItem(EnumHand.MAIN_HAND)).isEmpty() && itemStack2.getItem() != null && itemStack2.getItem() instanceof ItemBow && this.Field712.getValue().booleanValue()) {
                this.Method2161836();
                if (this.Field719.getValue().booleanValue()) {
                    Command.Method2159696("trying to spoof");
                }
            }
        } else if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerTryUseItem && (cPacketPlayerTryUseItem = (CPacketPlayerTryUseItem) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getHand() == EnumHand.MAIN_HAND && !(itemStack = BowMcBomb.Field2811.player.getHeldItem(EnumHand.MAIN_HAND)).isEmpty() && itemStack.getItem() != null) {
            if (itemStack.getItem() instanceof ItemEgg && this.Field714.getValue().booleanValue()) {
                this.Method2161836();
            } else if (itemStack.getItem() instanceof ItemEnderPearl && this.Field713.getValue().booleanValue()) {
                this.Method2161836();
            } else if (itemStack.getItem() instanceof ItemSnowball && this.Field715.getValue().booleanValue()) {
                this.Method2161836();
            }
        }
    }

    private void Method2161836() {
        if (System.currentTimeMillis() - this.Field711 >= (long) this.Field716.getValue().intValue()) {
            this.Field710 = true;
            this.Field711 = System.currentTimeMillis();
            BowMcBomb.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BowMcBomb.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            for (int j = 0; j < this.Field717.getValue(); ++j) {
                if (this.Field718.getValue().booleanValue()) {
                    BowMcBomb.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(BowMcBomb.Field2811.player.posX, BowMcBomb.Field2811.player.posY + 1.0E-10, BowMcBomb.Field2811.player.posZ, false));
                    BowMcBomb.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(BowMcBomb.Field2811.player.posX, BowMcBomb.Field2811.player.posY - 1.0E-10, BowMcBomb.Field2811.player.posZ, true));
                    continue;
                }
                BowMcBomb.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(BowMcBomb.Field2811.player.posX, BowMcBomb.Field2811.player.posY - 1.0E-10, BowMcBomb.Field2811.player.posZ, true));
                BowMcBomb.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(BowMcBomb.Field2811.player.posX, BowMcBomb.Field2811.player.posY + 1.0E-10, BowMcBomb.Field2811.player.posZ, false));
            }
            if (this.Field719.getValue().booleanValue()) {
                Command.Method2159696("Spoofed");
            }
            this.Field710 = false;
        }
    }
}

