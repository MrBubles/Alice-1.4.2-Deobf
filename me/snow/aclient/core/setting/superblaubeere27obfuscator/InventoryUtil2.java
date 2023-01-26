

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.Minecraft
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class InventoryUtil2
        implements Util {
    public static short Field3093 = 0;
    private static int Field3094;

    public static int Method2164511() {
        return InventoryUtil2.Field2811.player.inventory.currentItem;
    }

    public static void Method2164512(int n2) {
        if (n2 > 8 || n2 < 0) {
            return;
        }
        InventoryUtil2.Field2811.player.inventory.currentItem = n2;
    }

    public static int Method2164513(Item item) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem() != item) {
                continue;
            }
            n2 = j;
            break;
        }
        return n2;
    }

    public static int Method2164514(int n2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int j = 0; j < 9; ++j) {
            if (Item.getIdFromItem((Item) ((ItemStack) InventoryUtil2.Field2811.player.inventory.mainInventory.get(j)).getItem()) != n2)
                continue;
            arrayList.add(InventoryUtil2.Field2811.player.inventory.mainInventory.get(j));
        }
        if (arrayList.size() >= 1) {
            return InventoryUtil2.Field2811.player.inventory.mainInventory.indexOf(arrayList.get(0));
        }
        return -1;
    }

    public static int Method2164515(int n2, boolean bl) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int j = 0; j < (bl ? InventoryUtil2.Field2811.player.inventory.mainInventory.size() : 9); ++j) {
            if (Item.getIdFromItem((Item) ((ItemStack) InventoryUtil2.Field2811.player.inventory.mainInventory.get(j)).getItem()) != n2)
                continue;
            arrayList.add(InventoryUtil2.Field2811.player.inventory.mainInventory.get(j));
        }
        if (arrayList.size() >= 1) {
            return InventoryUtil2.Field2811.player.inventory.mainInventory.indexOf(arrayList.get(0));
        }
        return -1;
    }

    public static int Method2164516(Class<? extends Item> class_) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (!InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem().getClass().equals(class_)) {
                continue;
            }
            n2 = j;
            break;
        }
        return n2;
    }

    public static void Method2164517(int n2) {
        InventoryUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
    }

    public static int Method2164518(Item item) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (!InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem().equals((Object) item)) {
                continue;
            }
            n2 = j;
            break;
        }
        return n2;
    }

    public static int Method2164519(Item item) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem() != item) {
                continue;
            }
            n2 = j;
            break;
        }
        return n2;
    }

    public static int Method2164510(Class<? extends Item> class_) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (!InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem().getClass().equals(class_))
                continue;
            n2 = j;
        }
        return n2;
    }

    public static int Method2164521(Item item) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem() != item) {
                continue;
            }
            n2 = j;
            break;
        }
        return n2;
    }

    public static boolean Method2164522(Item item) {
        int n2 = InventoryUtil2.Method2164565(item);
        if (n2 == -1) {
            return false;
        }
        InventoryUtil2.Field2811.player.inventory.currentItem = n2;
        InventoryUtil2.Field2811.playerController.updateController();
        return true;
    }

    public static int Method2164523(Item item) {
        for (int j = 0; j < 36; ++j) {
            Item item2 = Minecraft.getMinecraft().player.inventory.getStackInSlot(j).getItem();
            if (item2 != item) {
                continue;
            }
            if (j < 9) {
                j += 36;
            }
            return j;
        }
        return -1;
    }

    public static void Method2164524(int n2) {
        if (n2 != -1 && InventoryUtil2.Field2811.player.inventory.currentItem != n2) {
            InventoryUtil2.Field2811.player.inventory.currentItem = n2;
            InventoryUtil2.Field2811.playerController.updateController();
        }
    }

    public static int Method2164525(Item item) {
        return InventoryUtil2.Method2164526(item, true);
    }

    public static int Method2164526(Item item, boolean bl) {
        int n2 = 0;
        for (int j = 44; j > 35; --j) {
            ItemStack itemStack = InventoryUtil2.Field2811.player.inventoryContainer.getSlot(j).getStack();
            if (itemStack.getItem() != item) continue;
            n2 += itemStack.getCount();
        }
        if (InventoryUtil2.Field2811.player.getHeldItemOffhand().getItem() == item && bl) {
            n2 += InventoryUtil2.Field2811.player.getHeldItemOffhand().getCount();
        }
        return n2;
    }

    public static int Method2164527(Block block) {
        return InventoryUtil2.Method2164525(new ItemStack(block).getItem());
    }

    public static int Method2164528(Block block, boolean bl) {
        return InventoryUtil2.Method2164526(new ItemStack(block).getItem(), bl);
    }

    public static void Method2164529(int n2, int n3) {
        InventoryUtil2.Field2811.playerController.windowClick(InventoryUtil2.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) InventoryUtil2.Field2811.player);
        InventoryUtil2.Field2811.playerController.windowClick(InventoryUtil2.Field2811.player.inventoryContainer.windowId, n3, 0, ClickType.PICKUP, (EntityPlayer) InventoryUtil2.Field2811.player);
        InventoryUtil2.Field2811.playerController.windowClick(InventoryUtil2.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) InventoryUtil2.Field2811.player);
    }

    public static void Method2164520(int n2, ClickType clickType) {
    }

    public static void Method2164531() {
        Field3094 = InventoryUtil2.Field2811.player.inventory.currentItem;
    }

    public static void Method2164532() {
        InventoryUtil2.Field2811.player.inventory.currentItem = Field3094;
    }

    public static void Method2164533(int n2, boolean bl) {
        if (InventoryUtil2.Field2811.player.inventory.currentItem == n2 || n2 < 0) {
            return;
        }
        if (bl) {
            InventoryUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            InventoryUtil2.Field2811.playerController.updateController();
        } else {
            InventoryUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            InventoryUtil2.Field2811.player.inventory.currentItem = n2;
            InventoryUtil2.Field2811.playerController.updateController();
        }
    }

    public static void Method2164534(Class class_, boolean bl) {
        int n2 = InventoryUtil2.Method2164539(class_);
        if (n2 > -1) {
            InventoryUtil2.Method2164533(n2, bl);
        }
    }

    public static List<Integer> Method2164535(Item item) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int j = 9; j < 36; ++j) {
            Item item2 = InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem();
            if (!(item instanceof ItemBlock) || !((ItemBlock) item).getBlock().equals((Object) item)) continue;
            arrayList.add(j);
        }
        if (arrayList.size() == 0) {
            arrayList.add(-1);
        }
        return arrayList;
    }

    public static int Method2164536(boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil2.Method2164549().entrySet()) {
            if (!(entry.getValue().getItem() instanceof ItemBlock)) continue;
            ItemBlock itemBlock = (ItemBlock) entry.getValue().getItem();
            if (itemBlock.getBlock().material != Material.CLOTH || entry.getKey() == 45 && !bl) continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static boolean Method2164537(ItemStack itemStack) {
        return itemStack == null || itemStack.getItem() instanceof ItemAir;
    }

    public static void Method2164538(Block block) {
        if (InventoryUtil2.Method2164555(block) != -1 && InventoryUtil2.Field2811.player.inventory.currentItem != InventoryUtil2.Method2164555(block)) {
            InventoryUtil2.Field2811.player.inventory.currentItem = InventoryUtil2.Method2164555(block);
        }
    }

    public static int Method2164539(Class class_) {
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = InventoryUtil2.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY) continue;
            if (class_.isInstance((Object) itemStack.getItem())) {
                return j;
            }
            if (!(itemStack.getItem() instanceof ItemBlock) || !class_.isInstance((Object) (block = ((ItemBlock) itemStack.getItem()).getBlock())))
                continue;
            return j;
        }
        return -1;
    }

    public static int Method2164530(Block block) {
        for (int j = 0; j < 9; ++j) {
            Block block2;
            ItemStack itemStack = InventoryUtil2.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || (block2 = ((ItemBlock) itemStack.getItem()).getBlock()) != block)
                continue;
            return j;
        }
        return -1;
    }

    public static int Method2164541(Item item) {
        for (int j = 0; j < 9; ++j) {
            Item item2 = InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem();
            if (Item.getIdFromItem((Item) item2) != Item.getIdFromItem((Item) item)) {
                continue;
            }
            return j;
        }
        return -1;
    }

    public static int Method2164542(Item item) {
        return InventoryUtil2.Method2164543(item, false);
    }

    public static int Method2164543(Item item, boolean bl) {
        int n2;
        int n3 = n2 = 0;
        int n4 = n2 = bl ? 0 : 9;
        while (n2 < 36) {
            Item item2 = InventoryUtil2.Field2811.player.inventory.getStackInSlot(n2).getItem();
            if (Item.getIdFromItem((Item) item) != Item.getIdFromItem((Item) item2)) {
                ++n2;
                continue;
            }
            return n2 + (n2 < 9 ? 36 : 0);
        }
        return -1;
    }

    public static int Method2164544(Item item, boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil2.Method2164549().entrySet()) {
            if (entry.getValue().getItem() != item || entry.getKey() == 45 && !bl) continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static List<Integer> Method2164545(boolean bl) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry<Integer, ItemStack> slot : InventoryUtil2.Method2164549().entrySet()) {
            if (!slot.getValue().isEmpty && slot.getValue().getItem() != Items.AIR) continue;
            arrayList.add(slot.getKey());
        }
        if (bl) {
            for (int j = 1; j < 5; ++j) {
                Slot slot = (Slot) InventoryUtil2.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) continue;
                arrayList.add(j);
            }
        }
        return arrayList;
    }

    public static int Method2164546(Class class_, boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil2.Method2164549().entrySet()) {
            if (!InventoryUtil2.Method2164547(entry.getValue().getItem(), class_) || entry.getKey() == 45 && !bl)
                continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static boolean Method2164547(Item item, Class class_) {
        if (item instanceof ItemBlock) {
            Block block = ((ItemBlock) item).getBlock();
            return class_.isInstance((Object) block);
        }
        return false;
    }

    public static void Method2164548(int n2) {
        InventoryUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        InventoryUtil2.Field2811.player.inventory.currentItem = n2;
        InventoryUtil2.Field2811.playerController.updateController();
    }

    public static Map<Integer, ItemStack> Method2164549() {
        return InventoryUtil2.Method2164540(9, 44);
    }

    private static Map<Integer, ItemStack> Method2164540(int n2, int n3) {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        for (int j = n2; j <= n3; ++j) {
            hashMap.put(j, (ItemStack) InventoryUtil2.Field2811.player.inventoryContainer.getInventory().get(j));
        }
        return hashMap;
    }

    public static boolean[] Method2164551(boolean bl, int n2, boolean bl2, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, Class class_) {
        boolean[] arrbl = new boolean[]{bl2, false};
        switch (1.F
        ield2325[iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ordinal()])
        {
            case 1: {
                if (!bl && !bl2) {
                    InventoryUtil2.Method2164533(InventoryUtil2.Method2164539(class_), false);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    InventoryUtil2.Method2164533(n2, false);
                    arrbl[0] = false;
                }
                arrbl[1] = true;
                break;
            }
            case 2: {
                if (!bl && !bl2) {
                    InventoryUtil2.Method2164533(InventoryUtil2.Method2164539(class_), true);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    arrbl[0] = false;
                    AliceMain.Field770.Method2150185(n2);
                }
                arrbl[1] = true;
                break;
            }
            case 3: {
                arrbl[1] = bl || InventoryUtil2.Field2811.player.inventory.currentItem == InventoryUtil2.Method2164539(class_);
            }
        }
        return arrbl;
    }

    public static boolean[] Method2164552(boolean bl, int n2, boolean bl2, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, Item item) {
        boolean[] arrbl = new boolean[]{bl2, false};
        switch (1.F
        ield2325[iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ordinal()])
        {
            case 1: {
                if (!bl && !bl2) {
                    InventoryUtil2.Method2164533(InventoryUtil2.Method2164541(item), false);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    InventoryUtil2.Method2164533(n2, false);
                    arrbl[0] = false;
                }
                arrbl[1] = true;
                break;
            }
            case 2: {
                if (!bl && !bl2) {
                    InventoryUtil2.Method2164533(InventoryUtil2.Method2164541(item), true);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    arrbl[0] = false;
                    AliceMain.Field770.Method2150185(n2);
                }
                arrbl[1] = true;
                break;
            }
            case 3: {
                arrbl[1] = bl || InventoryUtil2.Field2811.player.inventory.currentItem == InventoryUtil2.Method2164541(item);
            }
        }
        return arrbl;
    }

    public static boolean Method2164553(Class class_) {
        boolean bl = false;
        ItemStack itemStack = InventoryUtil2.Field2811.player.getHeldItemMainhand();
        bl = InventoryUtil2.Method2164554(itemStack, class_);
        if (!bl) {
            ItemStack itemStack2 = InventoryUtil2.Field2811.player.getHeldItemOffhand();
            bl = InventoryUtil2.Method2164554(itemStack, class_);
        }
        return bl;
    }

    public static boolean Method2164554(ItemStack itemStack, Class class_) {
        if (itemStack == null) {
            return false;
        }
        Item item = itemStack.getItem();
        if (class_.isInstance((Object) item)) {
            return true;
        }
        if (item instanceof ItemBlock) {
            Block block = Block.getBlockFromItem((Item) item);
            return class_.isInstance((Object) block);
        }
        return false;
    }

    public static int Method2164555(Block block) {
        for (int j = 0; j < 9; ++j) {
            Item item = InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem();
            if (!(item instanceof ItemBlock) || !((ItemBlock) item).getBlock().equals((Object) block)) continue;
            return j;
        }
        return -1;
    }

    public static int Method2164556() {
        for (int j = 1; j < 5; ++j) {
            Slot slot = (Slot) InventoryUtil2.Field2811.player.inventoryContainer.inventorySlots.get(j);
            ItemStack itemStack = slot.getStack();
            if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) {
                continue;
            }
            return j;
        }
        return -1;
    }

    public static boolean Method2164557(int n2) {
        Slot slot = (Slot) InventoryUtil2.Field2811.player.inventoryContainer.inventorySlots.get(n2);
        ItemStack itemStack = slot.getStack();
        return itemStack.isEmpty();
    }

    public static int Method2164558(int n2) {
        return 36 + n2;
    }

    public static boolean Method2164559(ItemStack itemStack, ItemStack itemStack2) {
        if (!itemStack.getItem().equals((Object) itemStack2.getItem())) {
            return false;
        }
        if (itemStack.getItem() instanceof ItemBlock && itemStack2.getItem() instanceof ItemBlock) {
            Block block = ((ItemBlock) itemStack.getItem()).getBlock();
            Block block2 = ((ItemBlock) itemStack2.getItem()).getBlock();
            if (!block.material.equals((Object) block2.material)) {
                return false;
            }
        }
        if (!itemStack.getDisplayName().equals(itemStack2.getDisplayName())) {
            return false;
        }
        return itemStack.getItemDamage() == itemStack2.getItemDamage();
    }

    public static EntityEquipmentSlot Method2164550(int n2) {
        if (n2 == 5) {
            return EntityEquipmentSlot.HEAD;
        }
        if (n2 == 6) {
            return EntityEquipmentSlot.CHEST;
        }
        if (n2 == 7) {
            return EntityEquipmentSlot.LEGS;
        }
        return EntityEquipmentSlot.FEET;
    }

    public static int Method2164561(EntityEquipmentSlot entityEquipmentSlot, boolean bl) {
        int n2 = -1;
        float f = 0.0f;
        for (int j = 9; j < 45; ++j) {
            boolean bl2;
            ItemArmor itemArmor;
            ItemStack itemStack = Minecraft.getMinecraft().player.inventoryContainer.getSlot(j).getStack();
            if (itemStack.getItem() == Items.AIR || !(itemStack.getItem() instanceof ItemArmor) || (itemArmor = (ItemArmor) itemStack.getItem()).getEquipmentSlot() != entityEquipmentSlot)
                continue;
            float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.PROTECTION, (ItemStack) itemStack);
            boolean bl3 = bl2 = bl && EnchantmentHelper.hasBindingCurse((ItemStack) itemStack);
            if (!(f2 > f) || bl2) continue;
            f = f2;
            n2 = j;
        }
        return n2;
    }

    public static int Method2164562(EntityEquipmentSlot entityEquipmentSlot, boolean bl, boolean bl2) {
        int n2 = InventoryUtil2.Method2164561(entityEquipmentSlot, bl);
        if (n2 == -1 && bl2) {
            float f = 0.0f;
            for (int j = 1; j < 5; ++j) {
                boolean bl3;
                ItemArmor itemArmor;
                Slot slot = (Slot) InventoryUtil2.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR || !(itemStack.getItem() instanceof ItemArmor) || (itemArmor = (ItemArmor) itemStack.getItem()).getEquipmentSlot() != entityEquipmentSlot)
                    continue;
                float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.PROTECTION, (ItemStack) itemStack);
                boolean bl4 = bl3 = bl && EnchantmentHelper.hasBindingCurse((ItemStack) itemStack);
                if (!(f2 > f) || bl3) continue;
                f = f2;
                n2 = j;
            }
        }
        return n2;
    }

    public static int Method2164563(Item item, boolean bl, boolean bl2) {
        int n2 = InventoryUtil2.Method2164544(item, bl);
        if (n2 == -1 && bl2) {
            for (int j = 1; j < 5; ++j) {
                Item item2;
                Slot slot = (Slot) InventoryUtil2.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR || (item2 = itemStack.getItem()) != item) continue;
                n2 = j;
            }
        }
        return n2;
    }

    public static int Method2164564(Class class_, boolean bl, boolean bl2) {
        int n2 = InventoryUtil2.Method2164546(class_, bl);
        if (n2 == -1 && bl2) {
            for (int j = 1; j < 5; ++j) {
                Block block;
                Slot slot = (Slot) InventoryUtil2.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR) continue;
                Item item = itemStack.getItem();
                if (class_.isInstance((Object) item)) {
                    n2 = j;
                    continue;
                }
                if (!(item instanceof ItemBlock) || !class_.isInstance((Object) (block = ((ItemBlock) item).getBlock())))
                    continue;
                n2 = j;
            }
        }
        return n2;
    }

    public static int Method2164565(Item item) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (InventoryUtil2.Field2811.player.inventory.getStackInSlot(j).getItem() != item) continue;
            n2 = j;
        }
        return n2;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NORMAL,
        SILENT,
        NONE;

    }

    public static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        private final int Field3962;
        private final boolean Field3963;
        private final boolean Field3964;

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
            this.Field3963 = true;
            this.Field3962 = -1;
            this.Field3964 = false;
        }

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(int n2) {
            this.Field3962 = n2;
            this.Field3964 = false;
            this.Field3963 = false;
        }

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(int n2, boolean bl) {
            this.Field3962 = n2;
            this.Field3964 = bl;
            this.Field3963 = false;
        }

        public void Method2164409() {
            if (this.Field3963) {
                Util.Field2811.playerController.updateController();
            }
            if (this.Field3962 != -1) {
                Util.Field2811.playerController.windowClick(0, this.Field3962, 0, this.Field3964 ? ClickType.QUICK_MOVE : ClickType.PICKUP, (EntityPlayer) Util.Field2811.player);
            }
        }

        public boolean Method2164400() {
            return !this.Field3963;
        }
    }
}

