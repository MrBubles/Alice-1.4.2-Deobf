

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.init.PotionTypes
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemTippedArrow
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.potion.PotionUtils
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTippedArrow;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.BlockPos;

public class Quiver
        extends Module {
    private final Setting<Integer> Field3320 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 500));
    private final Setting<Integer> Field3321 = this.Method2150366(new Setting<Integer>("Hold Length", 240, 100, 1000));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3322 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Main", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SPEED));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3323 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Secondary", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STRENGTH));
    private final Timer Field3324 = new Timer();
    private final Timer Field3325 = new Timer();
    private int Field3326;
    private ArrayList<Integer> Field3327;
    private int Field3328 = -1;
    private int Field3329 = -1;
    private int Field3330 = 1;

    public Quiver() {
        super("Quiver", "Automatically shoots yourself with good effects.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    @Override
    public void Method2150372() {
        if (Quiver.Method2150358()) {
            return;
        }
        InventoryUtil.Method2163775(ItemBow.class, false);
        this.Method2161292();
        this.Field3330 = Quiver.Field2811.player.inventory.currentItem;
        Quiver.Field2811.gameSettings.keyBindUseItem.pressed = false;
    }

    @Override
    public void Method2150373() {
        if (Quiver.Method2150358()) {
            return;
        }
        InventoryUtil.Method2163773(this.Field3330, false);
        Quiver.Field2811.gameSettings.keyBindUseItem.pressed = false;
        this.Method2161292();
    }

    @Override
    public void Method2150379() {
        int n2;
        Object object;
        if (Quiver.Method2150358()) {
            return;
        }
        if (Quiver.Field2811.currentScreen != null) {
            return;
        }
        if (InventoryUtil.Method2163784((Item) Items.BOW, true) == -1) {
            Command.Method2159696("Couldn't find bow in inventory! Toggling!");
            this.Method2150391();
        }
        RotationUtil.Method2163002(EntityUtil.Method2163493((Entity) Quiver.Field2811.player, Quiver.Field2811.timer.elapsedPartialTicks).add(0.0, 3.0, 0.0), false);
        if (this.Field3326 == 0) {
            this.Field3327 = this.Method2161289();
            object = this.Field3327.iterator();
            while (object.hasNext()) {
                n2 = object.next();
                ItemStack itemStack = (ItemStack) Quiver.Field2811.player.inventoryContainer.getInventory().get(n2);
                if ((PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRENGTH) || PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRONG_STRENGTH) || PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.LONG_STRENGTH)) && this.Field3328 == -1) {
                    this.Field3328 = n2;
                }
                if (!PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.SWIFTNESS) && !PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.LONG_SWIFTNESS) && !PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRONG_SWIFTNESS) || this.Field3329 != -1)
                    continue;
                this.Field3329 = n2;
            }
            ++this.Field3326;
        } else if (this.Field3326 == 1) {
            if (!this.Field3324.Method2164755(this.Field3320.getValue().intValue())) {
                return;
            }
            this.Field3324.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 2) {
            this.Method2161288(this.Field3322.getValue());
            ++this.Field3326;
        } else if (this.Field3326 == 3) {
            if (!this.Field3324.Method2164755(this.Field3320.getValue().intValue())) {
                return;
            }
            this.Field3324.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 4) {
            Quiver.Field2811.gameSettings.keyBindUseItem.pressed = true;
            this.Field3325.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 5) {
            if (!this.Field3325.Method2164755(this.Field3321.getValue().intValue())) {
                return;
            }
            this.Field3325.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 6) {
            Quiver.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, Quiver.Field2811.player.getHorizontalFacing()));
            Quiver.Field2811.player.resetActiveHand();
            Quiver.Field2811.gameSettings.keyBindUseItem.pressed = false;
            ++this.Field3326;
        } else if (this.Field3326 == 7) {
            if (!this.Field3324.Method2164755(this.Field3320.getValue().intValue())) {
                return;
            }
            this.Field3324.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 8) {
            this.Field3327 = this.Method2161289();
            this.Field3328 = -1;
            this.Field3329 = -1;
            object = this.Field3327.iterator();
            while (object.hasNext()) {
                n2 = object.next();
                ItemStack itemStack = (ItemStack) Quiver.Field2811.player.inventoryContainer.getInventory().get(n2);
                if ((PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRENGTH) || PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRONG_STRENGTH) || PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.LONG_STRENGTH)) && this.Field3328 == -1) {
                    this.Field3328 = n2;
                }
                if (!PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.SWIFTNESS) && !PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.LONG_SWIFTNESS) && !PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRONG_SWIFTNESS) || this.Field3329 != -1)
                    continue;
                this.Field3329 = n2;
            }
            ++this.Field3326;
        }
        if (this.Field3326 == 9) {
            this.Method2161288(this.Field3323.getValue());
            ++this.Field3326;
        } else if (this.Field3326 == 10) {
            if (!this.Field3324.Method2164755(this.Field3320.getValue().intValue())) {
                return;
            }
            ++this.Field3326;
        } else if (this.Field3326 == 11) {
            Quiver.Field2811.gameSettings.keyBindUseItem.pressed = true;
            this.Field3325.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 12) {
            if (!this.Field3325.Method2164755(this.Field3321.getValue().intValue())) {
                return;
            }
            this.Field3325.Method2164750();
            ++this.Field3326;
        } else if (this.Field3326 == 13) {
            Quiver.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, Quiver.Field2811.player.getHorizontalFacing()));
            Quiver.Field2811.player.resetActiveHand();
            Quiver.Field2811.gameSettings.keyBindUseItem.pressed = false;
            ++this.Field3326;
        } else if (this.Field3326 == 14) {
            object = this.Method2161280();
            if (!((ArrayList) object).isEmpty()) {
                n2 = (Integer) ((ArrayList) object).get(0);
                Quiver.Field2811.playerController.windowClick(Quiver.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) Quiver.Field2811.player);
            }
            ++this.Field3326;
        } else if (this.Field3326 == 15) {
            this.Method2150388(false);
        }
    }

    private void Method2161288(Enum<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> enum_) {
        if (enum_.toString().equalsIgnoreCase("STRENGTH") && this.Field3328 != -1) {
            this.Method2161291(this.Field3328);
        }
        if (enum_.toString().equalsIgnoreCase("SPEED") && this.Field3329 != -1) {
            this.Method2161291(this.Field3329);
        }
    }

    private ArrayList<Integer> Method2161289() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int j = 9; j < 45; ++j) {
            if (!(((ItemStack) Quiver.Field2811.player.inventoryContainer.getInventory().get(j)).getItem() instanceof ItemTippedArrow))
                continue;
            ItemStack itemStack = (ItemStack) Quiver.Field2811.player.inventoryContainer.getInventory().get(j);
            if (PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRENGTH) || PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRONG_STRENGTH) || PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.LONG_STRENGTH)) {
                arrayList.add(j);
            }
            if (!PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.SWIFTNESS) && !PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.LONG_SWIFTNESS) && !PotionUtils.getPotionFromItem((ItemStack) itemStack).equals((Object) PotionTypes.STRONG_SWIFTNESS))
                continue;
            arrayList.add(j);
        }
        return arrayList;
    }

    private ArrayList<Integer> Method2161280() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int j = 9; j < 45; ++j) {
            if (!(((ItemStack) Quiver.Field2811.player.inventoryContainer.getInventory().get(j)).getItem() instanceof ItemAir) && Quiver.Field2811.player.inventoryContainer.getInventory().get(j) != ItemStack.EMPTY)
                continue;
            arrayList.add(j);
        }
        return arrayList;
    }

    private void Method2161291(int n2) {
        if (n2 == 9) {
            return;
        }
        Quiver.Field2811.playerController.windowClick(Quiver.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) Quiver.Field2811.player);
        Quiver.Field2811.playerController.windowClick(Quiver.Field2811.player.inventoryContainer.windowId, 9, 0, ClickType.PICKUP, (EntityPlayer) Quiver.Field2811.player);
        Quiver.Field2811.playerController.windowClick(Quiver.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) Quiver.Field2811.player);
        Quiver.Field2811.playerController.updateController();
    }

    private void Method2161292() {
        this.Field3325.Method2164750();
        this.Field3324.Method2164750();
        this.Field3327 = null;
        this.Field3329 = -1;
        this.Field3328 = -1;
        this.Field3326 = 0;
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        STRENGTH,
        SPEED;

    }
}

