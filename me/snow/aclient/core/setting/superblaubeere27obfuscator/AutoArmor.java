

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemExpBottle
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentAutoXP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.XCarry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class AutoArmor
        extends Module {
    public final Setting<Boolean> Field694 = this.Method2150366(new Setting<Boolean>("AutoMend", true));
    private final Setting<Boolean> Field692 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private final Setting<Integer> Field693 = this.Method2150366(new Setting<Integer>("Delay", 200, 0, 500));
    private final Setting<Integer> Field695 = this.Method2150366(new Setting<Object>("Enemy", Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(20), this::Method2150929));
    private final Setting<Integer> Field696 = this.Method2150366(new Setting<Object>("Percent%", Integer.valueOf(100), Integer.valueOf(1), Integer.valueOf(100), this::Method2150928));
    private final Setting<Boolean> Field697 = this.Method2150366(new Setting<Boolean>("CurseOfBinding", false));
    private final Setting<Integer> Field698 = this.Method2150366(new Setting<Integer>("Actions", 3, 1, 12));
    private final Setting<Bind> Field699 = this.Method2150366(new Setting<Bind>("Elytra", new Bind(-1)));
    private final Setting<Boolean> Field700 = this.Method2150366(new Setting<Boolean>("TpsSync", true));
    private final Setting<Boolean> Field701 = this.Method2150366(new Setting<Boolean>("Update", true));
    private final Setting<Boolean> Field702 = this.Method2150366(new Setting<Boolean>("ShiftClick", false));
    private final Timer Field703 = new Timer();
    private final Timer Field704 = new Timer();
    private final Queue<InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field705 = new ConcurrentLinkedQueue<InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>();
    private final List<Integer> Field706 = new ArrayList<Integer>();
    private boolean Field707;

    public AutoArmor() {
        super("AutoArmor", "Puts Armor on for you.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    @SubscribeEvent
    public void Method2150924(InputEvent.KeyInputEvent keyInputEvent) {
        if (Keyboard.getEventKeyState() && !(AutoArmor.Field2811.currentScreen instanceof LuigiGuiOld) && this.Field699.getValue().getKey() == Keyboard.getEventKey()) {
            this.Field707 = !this.Field707;
        }
    }

    @Override
    public void Method2150377() {
        this.Field703.Method2164750();
        this.Field704.Method2164750();
    }

    @Override
    public void Method2150373() {
        this.Field705.clear();
        this.Field706.clear();
        this.Field707 = false;
    }

    @Override
    public void Method2150378() {
        this.Field705.clear();
        this.Field706.clear();
    }

    @Override
    public void Method2150376() {
        int n2;
        if (AutoArmor.Method2150359() || AutoArmor.Field2811.currentScreen instanceof GuiContainer && !(AutoArmor.Field2811.currentScreen instanceof GuiInventory)) {
            return;
        }
        if (this.Field692.getValue().booleanValue() && (AutoArmor.Field2811.player.motionX != 0.0 || AutoArmor.Field2811.player.motionZ != 0.0)) {
            return;
        }
        if (this.Field705.isEmpty()) {
            int n3;
            int n4;
            ItemStack itemStack;
            int n5;
            if (this.Field694.getValue().booleanValue() && (InventoryUtil.Method2163796(ItemExpBottle.class) && AutoArmor.Field2811.gameSettings.keyBindUseItem.isKeyDown() || AliceMain.Field756.Method2150180(SilentAutoXP.class).Method2150364() && SilentAutoXP.Method2162298().Field2936.getValue().isDown()) && (this.Method2150927() || EntityUtil.Method2163490((Entity) AutoArmor.Field2811.player, 1, false, true))) {
                ItemStack itemStack2 = AutoArmor.Field2811.player.inventoryContainer.getSlot(5).getStack();
                if (!itemStack2.isEmpty && DamageUtil.Method2163455(itemStack2) >= this.Field696.getValue()) {
                    this.Method2150925(5);
                }
                ItemStack itemStack3 = AutoArmor.Field2811.player.inventoryContainer.getSlot(6).getStack();
                if (!itemStack3.isEmpty && DamageUtil.Method2163455(itemStack3) >= this.Field696.getValue()) {
                    this.Method2150925(6);
                }
                ItemStack itemStack4 = AutoArmor.Field2811.player.inventoryContainer.getSlot(7).getStack();
                if (!itemStack4.isEmpty && DamageUtil.Method2163455(itemStack4) >= this.Field696.getValue()) {
                    this.Method2150925(7);
                }
                ItemStack itemStack5 = AutoArmor.Field2811.player.inventoryContainer.getSlot(8).getStack();
                if (!itemStack5.isEmpty && DamageUtil.Method2163455(itemStack5) >= this.Field696.getValue()) {
                    this.Method2150925(8);
                }
                return;
            }
            ItemStack itemStack6 = AutoArmor.Field2811.player.inventoryContainer.getSlot(5).getStack();
            if (itemStack6.getItem() == Items.AIR && (n5 = InventoryUtil.Method2163704(EntityEquipmentSlot.HEAD, this.Field697.getValue(), XCarry.Method2162313().Method2150386())) != -1) {
                this.Method2150926(5, n5);
            }
            if ((itemStack = AutoArmor.Field2811.player.inventoryContainer.getSlot(6).getStack()).getItem() == Items.AIR) {
                if (this.Field705.isEmpty()) {
                    if (this.Field707 && this.Field704.Method2164755(500L)) {
                        int n6 = InventoryUtil.Method2163705(Items.ELYTRA, false, XCarry.Method2162313().Method2150386());
                        if (n6 != -1) {
                            if (n6 < 5 && n6 > 1 || !this.Field702.getValue().booleanValue()) {
                                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n6));
                                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(6));
                            } else {
                                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n6, true));
                            }
                            if (this.Field701.getValue().booleanValue()) {
                                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
                            }
                            this.Field704.Method2164750();
                        }
                    } else if (!this.Field707 && (n4 = InventoryUtil.Method2163704(EntityEquipmentSlot.CHEST, this.Field697.getValue(), XCarry.Method2162313().Method2150386())) != -1) {
                        this.Method2150926(6, n4);
                    }
                }
            } else if (this.Field707 && itemStack.getItem() != Items.ELYTRA && this.Field704.Method2164755(500L)) {
                if (this.Field705.isEmpty()) {
                    n4 = InventoryUtil.Method2163705(Items.ELYTRA, false, XCarry.Method2162313().Method2150386());
                    if (n4 != -1) {
                        this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n4));
                        this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(6));
                        this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n4));
                        if (this.Field701.getValue().booleanValue()) {
                            this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
                        }
                    }
                    this.Field704.Method2164750();
                }
            } else if (!this.Field707 && itemStack.getItem() == Items.ELYTRA && this.Field704.Method2164755(500L) && this.Field705.isEmpty()) {
                n4 = InventoryUtil.Method2163705((Item) Items.DIAMOND_CHESTPLATE, false, XCarry.Method2162313().Method2150386());
                if (n4 == -1 && (n4 = InventoryUtil.Method2163705((Item) Items.IRON_CHESTPLATE, false, XCarry.Method2162313().Method2150386())) == -1 && (n4 = InventoryUtil.Method2163705((Item) Items.GOLDEN_CHESTPLATE, false, XCarry.Method2162313().Method2150386())) == -1 && (n4 = InventoryUtil.Method2163705((Item) Items.CHAINMAIL_CHESTPLATE, false, XCarry.Method2162313().Method2150386())) == -1) {
                    n4 = InventoryUtil.Method2163705((Item) Items.LEATHER_CHESTPLATE, false, XCarry.Method2162313().Method2150386());
                }
                if (n4 != -1) {
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n4));
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(6));
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n4));
                    if (this.Field701.getValue().booleanValue()) {
                        this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
                    }
                }
                this.Field704.Method2164750();
            }
            if (AutoArmor.Field2811.player.inventoryContainer.getSlot(7).getStack().getItem() == Items.AIR && (n3 = InventoryUtil.Method2163704(EntityEquipmentSlot.LEGS, this.Field697.getValue(), XCarry.Method2162313().Method2150386())) != -1) {
                this.Method2150926(7, n3);
            }
            if (AutoArmor.Field2811.player.inventoryContainer.getSlot(8).getStack().getItem() == Items.AIR && (n2 = InventoryUtil.Method2163704(EntityEquipmentSlot.FEET, this.Field697.getValue(), XCarry.Method2162313().Method2150386())) != -1) {
                this.Method2150926(8, n2);
            }
        }
        if (this.Field703.Method2164755((int) ((float) this.Field693.getValue().intValue() * (this.Field700.getValue() != false ? AliceMain.Field768.Method2150202() : 1.0f)))) {
            if (!this.Field705.isEmpty()) {
                for (n2 = 0; n2 < this.Field698.getValue(); ++n2) {
                    InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll = this.Field705.poll();
                    if (illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll == null)
                        continue;
                    illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163765();
                }
            }
            this.Field703.Method2164750();
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field707) {
            return "Elytra";
        }
        return null;
    }

    private void Method2150925(int n2) {
        if (this.Field705.isEmpty()) {
            int n3 = -1;
            for (int n4 : InventoryUtil.Method2163785(XCarry.Method2162313().Method2150386())) {
                if (this.Field706.contains(n3)) continue;
                n3 = n4;
                this.Field706.add(n4);
            }
            if (n3 != -1) {
                if (n3 < 5 && n3 > 0 || !this.Field702.getValue().booleanValue()) {
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2));
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n3));
                } else {
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2, true));
                }
                if (this.Field701.getValue().booleanValue()) {
                    this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
                }
            }
        }
    }

    private void Method2150926(int n2, int n3) {
        if (this.Field705.isEmpty()) {
            this.Field706.remove((Object) n3);
            if (n3 < 5 && n3 > 0 || !this.Field702.getValue().booleanValue()) {
                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n3));
                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2));
            } else {
                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n3, true));
            }
            if (this.Field701.getValue().booleanValue()) {
                this.Field705.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
            }
        }
    }

    private boolean Method2150927() {
        EntityPlayer entityPlayer = EntityUtil.Method2163561(this.Field695.getValue().intValue());
        if (entityPlayer == null) {
            return true;
        }
        return AutoArmor.Field2811.player.getDistanceSq((Entity) entityPlayer) >= MathUtil.Method2163857(this.Field695.getValue().intValue());
    }

    private boolean Method2150928(Object object) {
        return this.Field694.getValue();
    }

    private boolean Method2150929(Object object) {
        return this.Field694.getValue();
    }
}

