

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PairUtil;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Replenish
        extends Module {
    private Setting<Boolean> Field2034 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private Setting<Integer> Field2035 = this.Method2150366(new Setting<Integer>("Threshold", 32, 1, 63));
    private Setting<Integer> Field2036 = this.Method2150366(new Setting<Integer>("Tick Delay", 2, 1, 10));
    private int Field2037 = 0;

    public Replenish() {
        super("Replenish", "Replenishes your hotbar", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, false, false, false);
    }

    public static List<Integer> Method2162283(Class<? extends Block> class_) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        NonNullList nonNullList = Replenish.Field2811.player.inventory.mainInventory;
        for (int j = 0; j < 36; ++j) {
            ItemStack itemStack = (ItemStack) nonNullList.get(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !class_.isInstance((Object) ((ItemBlock) itemStack.getItem()).getBlock()))
                continue;
            arrayList.add(j);
        }
        return arrayList;
    }

    public static List<Integer> Method2162284(Class<? extends Item> class_) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        NonNullList nonNullList = Replenish.Field2811.player.inventory.mainInventory;
        for (int j = 0; j < 36; ++j) {
            ItemStack itemStack = (ItemStack) nonNullList.get(j);
            if (itemStack == ItemStack.EMPTY || !class_.isInstance((Object) itemStack.getItem())) continue;
            arrayList.add(j);
        }
        return arrayList;
    }

    private static int Method2162285(Integer n2) {
        return -n2.intValue();
    }

    private static boolean Method2162286(Integer n2) {
        return n2 > 8 && n2 < 36;
    }

    @Override
    public void Method2150379() {
        if (Replenish.Field2811.player == null) {
            return;
        }
        if (Replenish.Field2811.currentScreen instanceof GuiContainer) {
            return;
        }
        if (this.Field2037 < this.Field2036.getValue()) {
            ++this.Field2037;
            return;
        }
        this.Field2037 = 0;
        PairUtil<Integer, Integer> pairUtil = this.Method2162270();
        if (pairUtil == null) {
            return;
        }
        int n2 = pairUtil.Method2163911();
        int n3 = pairUtil.Method2163912();
        if (!Replenish.Field2811.player.isHandActive() && Replenish.Field2811.player.moveForward == 0.0f || !this.Field2034.getValue().booleanValue()) {
            Replenish.Field2811.playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer) Replenish.Field2811.player);
            Replenish.Field2811.playerController.windowClick(0, n3 + 36, 0, ClickType.PICKUP, (EntityPlayer) Replenish.Field2811.player);
            Replenish.Field2811.playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer) Replenish.Field2811.player);
        }
    }

    private PairUtil<Integer, Integer> Method2162270() {
        NonNullList nonNullList = Replenish.Field2811.player.inventory.mainInventory;
        for (int j = 0; j < 9; ++j) {
            int n2;
            ItemStack itemStack = (ItemStack) nonNullList.get(j);
            if (!itemStack.isStackable() || itemStack.isEmpty || itemStack.getItem() == Items.AIR || itemStack.stackSize >= itemStack.getMaxStackSize() || itemStack.stackSize > this.Field2035.getValue() || (n2 = this.Method2162281(itemStack)) == -1)
                continue;
            return new PairUtil<Integer, Integer>(n2, j);
        }
        return null;
    }

    private int Method2162281(ItemStack itemStack) {
        Item item = itemStack.getItem();
        List<Integer> list = item instanceof ItemBlock ? Replenish.Method2162283(((ItemBlock) item).getBlock().getClass()) : Replenish.Method2162284(item.getClass());
        list = list.stream().filter(Replenish::Method2162286).sorted(Comparator.comparingInt(Replenish::Method2162285)).collect(Collectors.toList());
        for (int n2 : list) {
            if (!this.Method2162282(itemStack, Replenish.Field2811.player.inventory.getStackInSlot(n2))) continue;
            return n2;
        }
        return -1;
    }

    private boolean Method2162282(ItemStack itemStack, ItemStack itemStack2) {
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
}

