

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemElytra
 *  net.minecraft.item.ItemStack
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;

public class ChestSwap
        extends Module {
    private Setting<Boolean> Field3592 = this.Method2150366(new Setting<Boolean>("PreferElytra", true));
    private Setting<Boolean> Field3593 = this.Method2150366(new Setting<Boolean>("Curse", false));

    public ChestSwap() {
        super("ElytraReplace", "Will attempt to instantly swap your chestplate with an elytra or vice versa, depending on what is already equipped", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    @Override
    public void Method2150372() {
        super.Method2150372();
        if (ChestSwap.Field2811.player == null) {
            return;
        }
        ItemStack itemStack = ChestSwap.Field2811.player.inventoryContainer.getSlot(6).getStack();
        if (itemStack.isEmpty()) {
            int n2 = this.Method2162224(this.Field3592.getValue());
            if (!this.Field3592.getValue().booleanValue() && n2 == -1) {
                n2 = this.Method2162224(true);
            }
            if (n2 != -1) {
                ChestSwap.Field2811.playerController.windowClick(ChestSwap.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) ChestSwap.Field2811.player);
                ChestSwap.Field2811.playerController.windowClick(ChestSwap.Field2811.player.inventoryContainer.windowId, 6, 0, ClickType.PICKUP, (EntityPlayer) ChestSwap.Field2811.player);
                ChestSwap.Field2811.playerController.windowClick(ChestSwap.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) ChestSwap.Field2811.player);
            }
            this.Method2150391();
            return;
        }
        int n3 = this.Method2162224(itemStack.getItem() instanceof ItemArmor);
        if (n3 != -1) {
            ChestSwap.Field2811.playerController.windowClick(ChestSwap.Field2811.player.inventoryContainer.windowId, n3, 0, ClickType.PICKUP, (EntityPlayer) ChestSwap.Field2811.player);
            ChestSwap.Field2811.playerController.windowClick(ChestSwap.Field2811.player.inventoryContainer.windowId, 6, 0, ClickType.PICKUP, (EntityPlayer) ChestSwap.Field2811.player);
            ChestSwap.Field2811.playerController.windowClick(ChestSwap.Field2811.player.inventoryContainer.windowId, n3, 0, ClickType.PICKUP, (EntityPlayer) ChestSwap.Field2811.player);
        }
        this.Method2150391();
    }

    private int Method2162224(boolean bl) {
        int n2 = -1;
        float f = 0.0f;
        for (int j = 0; j < ChestSwap.Field2811.player.inventoryContainer.getInventory().size(); ++j) {
            ItemStack itemStack;
            if (j == 0 || j == 5 || j == 6 || j == 7 || j == 8 || (itemStack = (ItemStack) ChestSwap.Field2811.player.inventoryContainer.getInventory().get(j)) == null || itemStack.getItem() == Items.AIR)
                continue;
            if (itemStack.getItem() instanceof ItemArmor) {
                boolean bl2;
                ItemArmor itemArmor = (ItemArmor) itemStack.getItem();
                if (itemArmor.armorType != EntityEquipmentSlot.CHEST) continue;
                float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.PROTECTION, (ItemStack) itemStack);
                boolean bl3 = bl2 = this.Field3593.getValue() != false ? EnchantmentHelper.hasBindingCurse((ItemStack) itemStack) : false;
                if (!(f2 > f) || bl2) continue;
                f = f2;
                n2 = j;
                continue;
            }
            if (!bl || !(itemStack.getItem() instanceof ItemElytra)) continue;
            return j;
        }
        return n2;
    }
}

