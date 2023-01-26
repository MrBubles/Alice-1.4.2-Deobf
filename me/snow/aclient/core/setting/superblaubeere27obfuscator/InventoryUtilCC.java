

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Arrays;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryManagerCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryUtilCC
        implements Util {
    public static boolean Method2163282(Item item) {
        return InventoryUtilCC.Field2811.player.getHeldItemMainhand().getItem().equals((Object) item) || InventoryUtilCC.Field2811.player.getHeldItemOffhand().getItem().equals((Object) item);
    }

    public static boolean Method2163283(Block block) {
        return InventoryUtilCC.Field2811.player.getHeldItemMainhand().getItem().equals((Object) Item.getItemFromBlock((Block) block)) || InventoryUtilCC.Field2811.player.getHeldItemOffhand().getItem().equals((Object) Item.getItemFromBlock((Block) block));
    }

    public static boolean Method2163284(Item[] arritem) {
        return Arrays.stream(arritem).anyMatch(InventoryUtilCC::Method2163296) || Arrays.stream(arritem).anyMatch(InventoryUtilCC::Method2163295);
    }

    public static boolean Method2163285(Block[] arrblock) {
        return Arrays.stream(arrblock).anyMatch(InventoryUtilCC::Method2163294) || Arrays.stream(arrblock).anyMatch(InventoryUtilCC::Method2163293);
    }

    public static boolean Method2163286(Class<? extends Item> class_) {
        return class_.isInstance((Object) InventoryUtilCC.Field2811.player.getHeldItemMainhand().getItem()) || class_.isInstance((Object) InventoryUtilCC.Field2811.player.getHeldItemOffhand().getItem());
    }

    public static boolean Method2163287(Item item) {
        return AliceMain.Field781.Method2163277(item, InventoryManagerCC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.HOTBAR) != -1;
    }

    public static int Method2163288() {
        short s = 0;
        for (int j = 0; j < InventoryUtilCC.Field2811.player.getHeldItemMainhand().getEnchantmentTagList().tagCount(); ++j) {
            NBTTagCompound nBTTagCompound = InventoryUtilCC.Field2811.player.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(j);
            if (nBTTagCompound.getShort("lvl") <= s) continue;
            s = nBTTagCompound.getShort("lvl");
        }
        return s;
    }

    public static int Method2163289(Item item) {
        if (item instanceof ItemArmor) {
            return InventoryUtilCC.Field2811.player.inventory.armorInventory.stream().filter(arg_0 -> InventoryUtilCC.Method2163292(item, arg_0)).mapToInt(ItemStack::getCount).sum();
        }
        return InventoryUtilCC.Field2811.player.inventory.mainInventory.stream().filter(arg_0 -> InventoryUtilCC.Method2163291(item, arg_0)).mapToInt(ItemStack::getCount).sum() + InventoryUtilCC.Field2811.player.inventory.offHandInventory.stream().filter(arg_0 -> InventoryUtilCC.Method2163280(item, arg_0)).mapToInt(ItemStack::getCount).sum();
    }

    private static boolean Method2163280(Item item, ItemStack itemStack) {
        return itemStack.getItem().equals((Object) item);
    }

    private static boolean Method2163291(Item item, ItemStack itemStack) {
        return itemStack.getItem().equals((Object) item);
    }

    private static boolean Method2163292(Item item, ItemStack itemStack) {
        return itemStack.getItem().equals((Object) item);
    }

    private static boolean Method2163293(Block block) {
        return Item.getItemFromBlock((Block) block).equals((Object) InventoryUtilCC.Field2811.player.getHeldItemOffhand().getItem());
    }

    private static boolean Method2163294(Block block) {
        return Item.getItemFromBlock((Block) block).equals((Object) InventoryUtilCC.Field2811.player.getHeldItemMainhand().getItem());
    }

    private static boolean Method2163295(Item item) {
        return item.equals((Object) InventoryUtilCC.Field2811.player.getHeldItemOffhand().getItem());
    }

    private static boolean Method2163296(Item item) {
        return item.equals((Object) InventoryUtilCC.Field2811.player.getHeldItemMainhand().getItem());
    }
}

