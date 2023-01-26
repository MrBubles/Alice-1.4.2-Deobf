

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockShulkerBox
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiCrafting
 *  net.minecraft.client.gui.inventory.GuiInventory
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
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiInventory;
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

public class InventoryUtil
        implements Util {
    public static int Field1406;

    public static boolean Method2163767(Item item, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        switch (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
            case Main: {
                if (InventoryUtil.Field2811.player.getHeldItemMainhand().getItem() != item) break;
                return true;
            }
            case Off: {
                if (InventoryUtil.Field2811.player.getHeldItemOffhand().getItem() != item) break;
                return true;
            }
            case Both: {
                if (InventoryUtil.Field2811.player.getHeldItemOffhand().getItem() != item && InventoryUtil.Field2811.player.getHeldItemMainhand().getItem() != item)
                    break;
                return true;
            }
        }
        return false;
    }

    public static int Method2163768(int n2, boolean bl) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int j = 0; j < (bl ? InventoryUtil.Field2811.player.inventory.mainInventory.size() : 9); ++j) {
            if (Item.getIdFromItem((Item) ((ItemStack) InventoryUtil.Field2811.player.inventory.mainInventory.get(j)).getItem()) != n2)
                continue;
            arrayList.add(InventoryUtil.Field2811.player.inventory.mainInventory.get(j));
        }
        if (arrayList.size() >= 1) {
            return InventoryUtil.Field2811.player.inventory.mainInventory.indexOf(arrayList.get(0));
        }
        return -1;
    }

    public static void Method2163769(int n2) {
        if (n2 > 8 || n2 < 0) {
            return;
        }
        InventoryUtil.Field2811.player.inventory.currentItem = n2;
    }

    public static void Method2163760() {
        Field1406 = InventoryUtil.Field2811.player.inventory.currentItem;
    }

    public static void Method2163771() {
        InventoryUtil.Field2811.player.inventory.currentItem = Field1406;
    }

    public static int Method2163772(Block block) {
        for (int j = 0; j < 9; ++j) {
            Block block2;
            ItemStack itemStack = InventoryUtil.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || (block2 = ((ItemBlock) itemStack.getItem()).getBlock()) != block)
                continue;
            return j;
        }
        return -1;
    }

    public static void Method2163773(int n2, boolean bl) {
        if (InventoryUtil.Field2811.player.inventory.currentItem == n2 || n2 < 0) {
            return;
        }
        if (bl) {
            InventoryUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            InventoryUtil.Field2811.playerController.updateController();
        } else {
            InventoryUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            InventoryUtil.Field2811.player.inventory.currentItem = n2;
            InventoryUtil.Field2811.playerController.updateController();
        }
    }

    public static int Method2163774(Block block) {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            if (InventoryUtil.Field2811.player.inventory.getStackInSlot(j).getItem() != Item.getItemFromBlock((Block) block))
                continue;
            n2 = j;
        }
        return n2;
    }

    public static void Method2163775(Class class_, boolean bl) {
        int n2 = InventoryUtil.Method2163778(class_);
        if (n2 > -1) {
            InventoryUtil.Method2163773(n2, bl);
        }
    }

    public static void Method2163776(int n2) {
        if (InventoryUtil.Field2811.player.inventory.currentItem == n2 || n2 == -1) {
            return;
        }
        InventoryUtil.Field2811.player.inventory.currentItem = n2;
        InventoryUtil.Field2811.playerController.updateController();
    }

    public static boolean Method2163777(ItemStack itemStack) {
        return itemStack == null || itemStack.getItem() instanceof ItemAir;
    }

    public static int Method2163778(Class class_) {
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = InventoryUtil.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY) continue;
            if (class_.isInstance((Object) itemStack.getItem())) {
                return j;
            }
            if (!(itemStack.getItem() instanceof ItemBlock) || !class_.isInstance((Object) ((ItemBlock) itemStack.getItem()).getBlock()))
                continue;
            return j;
        }
        return -1;
    }

    public static int Method2163779() {
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = InventoryUtil.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock)) continue;
            return j;
        }
        return -1;
    }

    public static int Method2163770(Block block) {
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = InventoryUtil.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || ((ItemBlock) itemStack.getItem()).getBlock() != block)
                continue;
            return j;
        }
        return -1;
    }

    public static int Method2163781(Item item) {
        for (int j = 0; j < 9; ++j) {
            Item item2 = InventoryUtil.Field2811.player.inventory.getStackInSlot(j).getItem();
            if (Item.getIdFromItem((Item) item2) != Item.getIdFromItem((Item) item)) {
                continue;
            }
            return j;
        }
        return -1;
    }

    public static int Method2163782(Item item) {
        return InventoryUtil.Method2163783(item, false);
    }

    public static int Method2163783(Item item, boolean bl) {
        int n2;
        int n3 = n2 = bl ? 0 : 9;
        while (n2 < 36) {
            Item item2 = InventoryUtil.Field2811.player.inventory.getStackInSlot(n2).getItem();
            if (Item.getIdFromItem((Item) item) == Item.getIdFromItem((Item) item2)) {
                return n2 + (n2 < 9 ? 36 : 0);
            }
            ++n2;
        }
        return -1;
    }

    public static int Method2163784(Item item, boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil.Method2163791().entrySet()) {
            if (entry.getValue().getItem() != item || entry.getKey() == 45 && !bl) continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static List<Integer> Method2163785(boolean bl) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry<Integer, ItemStack> slot : InventoryUtil.Method2163791().entrySet()) {
            if (!slot.getValue().isEmpty && slot.getValue().getItem() != Items.AIR) continue;
            arrayList.add(slot.getKey());
        }
        if (bl) {
            for (int j = 1; j < 5; ++j) {
                Slot slot = (Slot) InventoryUtil.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) continue;
                arrayList.add(j);
            }
        }
        return arrayList;
    }

    public static int Method2163786(Class class_, boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil.Method2163791().entrySet()) {
            if (!InventoryUtil.Method2163789(entry.getValue().getItem(), class_) || entry.getKey() == 45 && !bl)
                continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static int Method2163787(boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil.Method2163791().entrySet()) {
            if (!(entry.getValue().getItem() instanceof ItemBlock)) continue;
            ItemBlock itemBlock = (ItemBlock) entry.getValue().getItem();
            if (itemBlock.getBlock().material != Material.CLOTH || entry.getKey() == 45 && !bl) continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static int Method2163788() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry<Integer, ItemStack> entry : InventoryUtil.Method2163791().entrySet()) {
            if (!entry.getValue().isEmpty()) continue;
            atomicInteger.set(entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static boolean Method2163789(Item item, Class class_) {
        if (item instanceof ItemBlock) {
            Block block = ((ItemBlock) item).getBlock();
            return class_.isInstance((Object) block);
        }
        return false;
    }

    public static void Method2163780(int n2) {
        InventoryUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        InventoryUtil.Field2811.player.inventory.currentItem = n2;
        InventoryUtil.Field2811.playerController.updateController();
    }

    public static Map<Integer, ItemStack> Method2163791() {
        if (InventoryUtil.Field2811.currentScreen instanceof GuiCrafting) {
            return InventoryUtil.Method2163793(10, 45);
        }
        return InventoryUtil.Method2163792(9, 44);
    }

    private static Map<Integer, ItemStack> Method2163792(int n2, int n3) {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        for (int j = n2; j <= n3; ++j) {
            hashMap.put(j, (ItemStack) InventoryUtil.Field2811.player.inventoryContainer.getInventory().get(j));
        }
        return hashMap;
    }

    private static Map<Integer, ItemStack> Method2163793(int n2, int n3) {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        for (int j = n2; j <= n3; ++j) {
            hashMap.put(j, (ItemStack) InventoryUtil.Field2811.player.openContainer.getInventory().get(j));
        }
        return hashMap;
    }

    public static boolean[] Method2163794(boolean bl, int n2, boolean bl2, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, Class class_) {
        boolean[] arrbl = new boolean[]{bl2, false};
        switch (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
            case NORMAL: {
                if (!bl && !bl2) {
                    InventoryUtil.Method2163773(InventoryUtil.Method2163778(class_), false);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    InventoryUtil.Method2163773(n2, false);
                    arrbl[0] = false;
                }
                arrbl[1] = true;
                break;
            }
            case SILENT: {
                if (!bl && !bl2) {
                    InventoryUtil.Method2163773(InventoryUtil.Method2163778(class_), true);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    arrbl[0] = false;
                    AliceMain.Field770.Method2150185(n2);
                }
                arrbl[1] = true;
                break;
            }
            case NONE: {
                arrbl[1] = bl || InventoryUtil.Field2811.player.inventory.currentItem == InventoryUtil.Method2163778(class_);
            }
        }
        return arrbl;
    }

    public static boolean[] Method2163795(boolean bl, int n2, boolean bl2, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, Item item) {
        boolean[] arrbl = new boolean[]{bl2, false};
        switch (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
            case NORMAL: {
                if (!bl && !bl2) {
                    InventoryUtil.Method2163773(InventoryUtil.Method2163781(item), false);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    InventoryUtil.Method2163773(n2, false);
                    arrbl[0] = false;
                }
                arrbl[1] = true;
                break;
            }
            case SILENT: {
                if (!bl && !bl2) {
                    InventoryUtil.Method2163773(InventoryUtil.Method2163781(item), true);
                    arrbl[0] = true;
                } else if (bl && bl2) {
                    arrbl[0] = false;
                    AliceMain.Field770.Method2150185(n2);
                }
                arrbl[1] = true;
                break;
            }
            case NONE: {
                arrbl[1] = bl || InventoryUtil.Field2811.player.inventory.currentItem == InventoryUtil.Method2163781(item);
            }
        }
        return arrbl;
    }

    public static boolean Method2163796(Class class_) {
        ItemStack itemStack = InventoryUtil.Field2811.player.getHeldItemMainhand();
        boolean bl = InventoryUtil.Method2163797(itemStack, class_);
        if (!bl) {
            InventoryUtil.Field2811.player.getHeldItemOffhand();
            bl = InventoryUtil.Method2163797(itemStack, class_);
        }
        return bl;
    }

    public static boolean Method2163797(ItemStack itemStack, Class class_) {
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

    public static int Method2163798() {
        for (int j = 1; j < 5; ++j) {
            Slot slot = (Slot) InventoryUtil.Field2811.player.inventoryContainer.inventorySlots.get(j);
            ItemStack itemStack = slot.getStack();
            if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) {
                continue;
            }
            return j;
        }
        return -1;
    }

    public static boolean Method2163799(int n2) {
        Slot slot = (Slot) InventoryUtil.Field2811.player.inventoryContainer.inventorySlots.get(n2);
        ItemStack itemStack = slot.getStack();
        return itemStack.isEmpty();
    }

    public static int Method2163790(int n2) {
        return 36 + n2;
    }

    public static boolean Method2163701(ItemStack itemStack, ItemStack itemStack2) {
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

    public static EntityEquipmentSlot Method2163702(int n2) {
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

    public static int Method2163703(EntityEquipmentSlot entityEquipmentSlot, boolean bl) {
        int n2 = -1;
        float f = 0.0f;
        for (int j = 9; j < 45; ++j) {
            boolean bl2;
            ItemStack itemStack = Minecraft.getMinecraft().player.inventoryContainer.getSlot(j).getStack();
            if (itemStack.getItem() == Items.AIR || !(itemStack.getItem() instanceof ItemArmor)) continue;
            ItemArmor itemArmor = (ItemArmor) itemStack.getItem();
            if (itemArmor.armorType != entityEquipmentSlot) continue;
            float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.PROTECTION, (ItemStack) itemStack);
            boolean bl3 = bl2 = bl && EnchantmentHelper.hasBindingCurse((ItemStack) itemStack);
            if (!(f2 > f) || bl2) continue;
            f = f2;
            n2 = j;
        }
        return n2;
    }

    public static int Method2163704(EntityEquipmentSlot entityEquipmentSlot, boolean bl, boolean bl2) {
        int n2 = InventoryUtil.Method2163703(entityEquipmentSlot, bl);
        if (n2 == -1 && bl2) {
            float f = 0.0f;
            for (int j = 1; j < 5; ++j) {
                boolean bl3;
                Slot slot = (Slot) InventoryUtil.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR || !(itemStack.getItem() instanceof ItemArmor)) continue;
                ItemArmor itemArmor = (ItemArmor) itemStack.getItem();
                if (itemArmor.armorType != entityEquipmentSlot) continue;
                float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.PROTECTION, (ItemStack) itemStack);
                boolean bl4 = bl3 = bl && EnchantmentHelper.hasBindingCurse((ItemStack) itemStack);
                if (!(f2 > f) || bl3) continue;
                f = f2;
                n2 = j;
            }
        }
        return n2;
    }

    public static int Method2163705(Item item, boolean bl, boolean bl2) {
        int n2 = InventoryUtil.Method2163784(item, bl);
        if (n2 == -1 && bl2) {
            for (int j = 1; j < 5; ++j) {
                Slot slot = (Slot) InventoryUtil.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR || itemStack.getItem() != item) continue;
                n2 = j;
            }
        }
        return n2;
    }

    public static int Method2163706(Class<BlockShulkerBox> class_, boolean bl, boolean bl2) {
        int n2 = InventoryUtil.Method2163786(class_, bl);
        if (n2 == -1 && bl2) {
            for (int j = 1; j < 5; ++j) {
                Slot slot = (Slot) InventoryUtil.Field2811.player.inventoryContainer.inventorySlots.get(j);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR) continue;
                Item item = itemStack.getItem();
                if (class_.isInstance((Object) item)) {
                    n2 = j;
                    continue;
                }
                if (!(item instanceof ItemBlock) || !class_.isInstance((Object) ((ItemBlock) item).getBlock()))
                    continue;
                n2 = j;
            }
        }
        return n2;
    }

    public static boolean Method2163707() {
        return !(InventoryUtil.Field2811.currentScreen instanceof GuiContainer) || InventoryUtil.Field2811.currentScreen instanceof GuiInventory;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Main,
        Off,
        Both;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        NORMAL,
        SILENT,
        NONE;

    }

    public static class IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        private final int Field3095;
        private final boolean Field3096;
        private final boolean Field3097;

        public IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
            this.Field3096 = true;
            this.Field3095 = -1;
            this.Field3097 = false;
        }

        public IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(int n2) {
            this.Field3095 = n2;
            this.Field3097 = false;
            this.Field3096 = false;
        }

        public IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(int n2, boolean bl) {
            this.Field3095 = n2;
            this.Field3097 = bl;
            this.Field3096 = false;
        }

        public void Method2163765() {
            if (this.Field3096) {
                Util.Field2811.playerController.updateController();
            }
            if (this.Field3095 != -1) {
                Util.Field2811.playerController.windowClick(Util.Field2811.player.inventoryContainer.windowId, this.Field3095, 0, this.Field3097 ? ClickType.QUICK_MOVE : ClickType.PICKUP, (EntityPlayer) Util.Field2811.player);
            }
        }

        public boolean Method2163766() {
            return !this.Field3096;
        }
    }
}

