

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class InventoryUtilsCr {
    protected static Minecraft Field2320 = Minecraft.getMinecraft();

    public static int Method2164100() {
        return InventoryUtilsCr.Field2320.player.inventory.currentItem;
    }

    public static void Method2164211(int n2) {
        if (n2 > 8 || n2 < 0) {
            return;
        }
        InventoryUtilsCr.Field2320.player.inventory.currentItem = n2;
    }

    public static int Method2164212() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int j = 0; j < 9; ++j) {
            if (!(((ItemStack) InventoryUtilsCr.Field2320.player.inventory.mainInventory.get(j)).getItem() instanceof ItemBlock))
                continue;
            arrayList.add(InventoryUtilsCr.Field2320.player.inventory.mainInventory.get(j));
        }
        return -1;
    }

    public static int Method2164213(int n2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int j = 0; j < 9; ++j) {
            if (Item.getIdFromItem((Item) ((ItemStack) InventoryUtilsCr.Field2320.player.inventory.mainInventory.get(j)).getItem()) != n2)
                continue;
            arrayList.add(InventoryUtilsCr.Field2320.player.inventory.mainInventory.get(j));
        }
        if (arrayList.size() >= 1) {
            return InventoryUtilsCr.Field2320.player.inventory.mainInventory.indexOf(arrayList.get(0));
        }
        return -1;
    }
}

