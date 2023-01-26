

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class ItemUtil
        implements Util {
    public static void Method2163708(int n2) {
        if (n2 != -1) {
            Field2811.getConnection().sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
    }

    public static void Method2163709(int n2) {
        Field2811.getConnection().sendPacket((Packet) new CPacketHeldItemChange(n2));
        ItemUtil.Field2811.playerController.updateController();
    }

    public static void Method2163700(int n2) {
        if (n2 != -1) {
            ItemUtil.Field2811.playerController.pickItem(n2);
        }
    }

    public static void Method2163811(int n2) {
        if (n2 != -1 && ItemUtil.Field2811.player.inventory.currentItem != n2) {
            ItemUtil.Field2811.player.inventory.currentItem = n2;
            ItemUtil.Field2811.playerController.updateController();
        }
    }

    public static int Method2163812(Item item) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = ItemUtil.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack.getItem() != item) continue;
            n2 = j;
        }
        return n2;
    }

    public static int Method2163813(Block block) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (ItemUtil.Field2811.player.inventory.getStackInSlot(j).getItem() != Item.getItemFromBlock((Block) block))
                continue;
            n2 = j;
        }
        return n2;
    }

    public static boolean Method2163814() {
        return ItemUtil.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && !(ItemUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword) && !(ItemUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemAxe) && !(ItemUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe);
    }
}

