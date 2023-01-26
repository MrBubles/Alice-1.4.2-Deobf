

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class AutoEat
        extends Module {
    int Field3878 = -1;
    boolean Field3879 = true;
    boolean Field3880 = false;
    private Setting<Float> Field3874 = this.Method2150366(new Setting<Double>("Health", 10.0, 0.0, 36.0));
    private Setting<Float> Field3875 = this.Method2150366(new Setting<Double>("Hunger", 15.0, 0.0, 20.0));
    private Setting<Boolean> Field3876 = this.Method2150366(new Setting<Boolean>("AutoSwitch", true));
    private Setting<Boolean> Field3877 = this.Method2150366(new Setting<Boolean>("PreferGaps", false));

    public AutoEat() {
        super("AutoEat", "AutoFood", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @Override
    public void Method2150379() {
        if (AutoEat.Field2811.player == null || AutoEat.Field2811.world == null) {
            return;
        }
        if (AutoEat.Field2811.player.isCreative()) {
            return;
        }
        if (AutoEat.Field2811.player.getHealth() + AutoEat.Field2811.player.getAbsorptionAmount() <= this.Field3874.getValue().floatValue() || (float) AutoEat.Field2811.player.getFoodStats().getFoodLevel() <= this.Field3875.getValue().floatValue()) {
            if (this.Field3876.getValue().booleanValue()) {
                int n2 = this.Method2161797();
                if (this.Field3879) {
                    this.Field3878 = AutoEat.Field2811.player.inventory.currentItem;
                    this.Field3879 = false;
                }
                if (n2 != -1) {
                    AutoEat.Field2811.player.inventory.currentItem = n2;
                    AutoEat.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                }
            }
            if (AutoEat.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemFood) {
                if (AutoEat.Field2811.currentScreen == null || AutoEat.Field2811.currentScreen instanceof GuiInventory) {
                    KeyBinding.setKeyBindState((int) AutoEat.Field2811.gameSettings.keyBindUseItem.getKeyCode(), (boolean) true);
                    this.Field3880 = true;
                } else {
                    AutoEat.Field2811.playerController.processRightClick((EntityPlayer) AutoEat.Field2811.player, (World) AutoEat.Field2811.world, EnumHand.MAIN_HAND);
                }
            } else if (AutoEat.Field2811.currentScreen == null || AutoEat.Field2811.currentScreen instanceof GuiInventory) {
                KeyBinding.setKeyBindState((int) AutoEat.Field2811.gameSettings.keyBindUseItem.getKeyCode(), (boolean) GameSettings.isKeyDown((KeyBinding) AutoEat.Field2811.gameSettings.keyBindUseItem));
            }
        } else {
            if (this.Field3880) {
                KeyBinding.setKeyBindState((int) AutoEat.Field2811.gameSettings.keyBindUseItem.getKeyCode(), (boolean) GameSettings.isKeyDown((KeyBinding) AutoEat.Field2811.gameSettings.keyBindUseItem));
                this.Field3880 = false;
            }
            if (this.Field3878 != -1) {
                AutoEat.Field2811.player.inventory.currentItem = this.Field3878;
                AutoEat.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field3878));
                this.Field3878 = -1;
                this.Field3879 = true;
            }
        }
    }

    private int Method2161797() {
        int n2 = -1;
        float f = 0.0f;
        if (n2 == -1) {
            for (int j = 0; j < 9; ++j) {
                ItemStack itemStack = AutoEat.Field2811.player.inventory.getStackInSlot(j);
                if (!(itemStack.getItem() instanceof ItemFood)) continue;
                if (this.Field3877.getValue().booleanValue() && itemStack.getItem() == Items.GOLDEN_APPLE) {
                    n2 = j;
                    break;
                }
                float f2 = ((ItemFood) itemStack.getItem()).getHealAmount(itemStack);
                if (!(f2 > f)) continue;
                f = f2;
                n2 = j;
            }
        }
        return n2;
    }
}

