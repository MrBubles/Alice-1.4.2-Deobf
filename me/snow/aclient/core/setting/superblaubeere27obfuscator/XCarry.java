

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.Slot
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ReflectionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class XCarry
        extends Module {
    private static XCarry Field2529 = new XCarry();
    private final Setting<Boolean> Field2530 = this.Method2150366(new Setting<Boolean>("Simple", false));
    private final Setting<Bind> Field2531 = this.Method2150366(new Setting<Bind>("AutoDuel", new Bind(-1)));
    private final Setting<Integer> Field2532 = this.Method2150366(new Setting<Object>("ObbySlot", Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(9), this::Method2162329));
    private final Setting<Integer> Field2533 = this.Method2150366(new Setting<Object>("Slot1", Integer.valueOf(22), Integer.valueOf(9), Integer.valueOf(44), this::Method2162328));
    private final Setting<Integer> Field2534 = this.Method2150366(new Setting<Object>("Slot2", Integer.valueOf(23), Integer.valueOf(9), Integer.valueOf(44), this::Method2162327));
    private final Setting<Integer> Field2535 = this.Method2150366(new Setting<Object>("Slot3", Integer.valueOf(24), Integer.valueOf(9), Integer.valueOf(44), this::Method2162326));
    private final Setting<Integer> Field2536 = this.Method2150366(new Setting<Object>("Actions", Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(12), this::Method2162325));
    private final Setting<Boolean> Field2537 = this.Method2150366(new Setting<Boolean>("Store", false));
    private final Setting<Boolean> Field2538 = this.Method2150366(new Setting<Boolean>("ShiftClick", false));
    private final Setting<Boolean> Field2539 = this.Method2150366(new Setting<Object>("WithShift", Boolean.TRUE, this::Method2162324));
    private final Setting<Bind> Field2540 = this.Method2150366(new Setting<Object>("ShiftBind", new Bind(-1), this::Method2162323));
    private final AtomicBoolean Field2541 = new AtomicBoolean(false);
    private final Queue<InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field2542 = new ConcurrentLinkedQueue<InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>();
    private GuiInventory Field2543;
    private boolean Field2544;
    private boolean Field2545;
    private boolean Field2546;
    private boolean Field2547;
    private boolean Field2548;
    private boolean Field2549;
    private List<Integer> Field2550 = new ArrayList<Integer>();

    public XCarry() {
        super("XCarry", "Uses the crafting inventory for storage", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162314();
    }

    public static XCarry Method2162313() {
        if (Field2529 == null) {
            Field2529 = new XCarry();
        }
        return Field2529;
    }

    static AtomicBoolean Method2162320(XCarry xCarry) {
        return xCarry.Field2541;
    }

    static boolean Method2162331(XCarry xCarry) {
        return xCarry.Field2544;
    }

    private void Method2162314() {
        Field2529 = this;
    }

    @Override
    public void Method2150379() {
        if (this.Field2538.getValue().booleanValue() && XCarry.Field2811.currentScreen instanceof GuiInventory) {
            Slot slot;
            boolean bl;
            boolean bl2 = bl = this.Field2540.getValue().getKey() != -1 && Keyboard.isKeyDown((int) this.Field2540.getValue().getKey()) && !Keyboard.isKeyDown((int) 42);
            if ((Keyboard.isKeyDown((int) 42) && this.Field2539.getValue().booleanValue() || bl) && Mouse.isButtonDown((int) 0) && (slot = ((GuiInventory) XCarry.Field2811.currentScreen).getSlotUnderMouse()) != null && InventoryUtil.Method2163798() != -1) {
                int n2 = slot.slotNumber;
                if (n2 > 4 && bl) {
                    this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2));
                    this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(InventoryUtil.Method2163798()));
                } else if (n2 > 4 && this.Field2539.getValue().booleanValue()) {
                    boolean bl3 = true;
                    boolean bl4 = true;
                    for (int n3 : InventoryUtil.Method2163785(false)) {
                        if (n3 > 4 && n3 < 36) {
                            bl4 = false;
                            continue;
                        }
                        if (n3 <= 35 || n3 >= 45) continue;
                        bl3 = false;
                    }
                    if (n2 > 35 && n2 < 45) {
                        if (bl4) {
                            this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2));
                            this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(InventoryUtil.Method2163798()));
                        }
                    } else if (bl3) {
                        this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2));
                        this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(InventoryUtil.Method2163798()));
                    }
                }
            }
        }
        if (this.Field2545) {
            this.Field2550 = new ArrayList<Integer>();
            if (InventoryUtil.Method2163798() == -1 || this.Field2546 && this.Field2547 && this.Field2548 && this.Field2549) {
                this.Field2545 = false;
            }
            if (this.Field2545) {
                if (!this.Field2546 && !XCarry.Field2811.player.inventory.getStackInSlot((int) (this.Field2532.getValue().intValue() - 1)).isEmpty) {
                    this.Method2162315(36 + this.Field2532.getValue() - 1);
                }
                this.Field2546 = true;
                if (!this.Field2547 && !((Slot) XCarry.Field2811.player.inventoryContainer.inventorySlots.get((int) this.Field2533.getValue().intValue())).getStack().isEmpty) {
                    this.Method2162315(this.Field2533.getValue());
                }
                this.Field2547 = true;
                if (!this.Field2548 && !((Slot) XCarry.Field2811.player.inventoryContainer.inventorySlots.get((int) this.Field2534.getValue().intValue())).getStack().isEmpty) {
                    this.Method2162315(this.Field2534.getValue());
                }
                this.Field2548 = true;
                if (!this.Field2549 && !((Slot) XCarry.Field2811.player.inventoryContainer.inventorySlots.get((int) this.Field2535.getValue().intValue())).getStack().isEmpty) {
                    this.Method2162315(this.Field2535.getValue());
                }
                this.Field2549 = true;
            }
        } else {
            this.Field2546 = false;
            this.Field2547 = false;
            this.Field2548 = false;
            this.Field2549 = false;
        }
        if (!this.Field2542.isEmpty()) {
            for (int j = 0; j < this.Field2536.getValue(); ++j) {
                InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll = this.Field2542.poll();
                if (illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll == null)
                    continue;
                illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163765();
            }
        }
    }

    private void Method2162315(int n2) {
        if (InventoryUtil.Method2163798() != -1) {
            int n3 = InventoryUtil.Method2163798();
            if (!(!this.Field2550.contains(n3) && InventoryUtil.Method2163799(n3) || !this.Field2550.contains(++n3) && InventoryUtil.Method2163799(n3) || !this.Field2550.contains(++n3) && InventoryUtil.Method2163799(n3) || !this.Field2550.contains(++n3) && InventoryUtil.Method2163799(n3))) {
                return;
            }
            if (n3 > 4) {
                return;
            }
            this.Field2550.add(n3);
            this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n2));
            this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(n3));
            this.Field2542.add(new InventoryUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
        }
    }

    @Override
    public void Method2150373() {
        if (XCarry.Method2150359()) {
            return;
        }
        if (!this.Field2530.getValue().booleanValue()) {
            this.Method2162321();
            this.Method2162310();
        } else {
            XCarry.Field2811.player.connection.sendPacket((Packet) new CPacketCloseWindow(XCarry.Field2811.player.inventoryContainer.windowId));
        }
    }

    @Override
    public void Method2150378() {
        this.Method2150373();
    }

    @SubscribeEvent
    public void Method2162316(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (this.Field2530.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketCloseWindow) {
            CPacketCloseWindow cPacketCloseWindow = (CPacketCloseWindow) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (cPacketCloseWindow.windowId == XCarry.Field2811.player.inventoryContainer.windowId) {
                iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void Method2162317(GuiOpenEvent guiOpenEvent) {
        if (!this.Field2530.getValue().booleanValue()) {
            if (this.Field2544) {
                guiOpenEvent.setCanceled(true);
            } else if (guiOpenEvent.getGui() instanceof GuiInventory) {
                this.Field2543 = this.Method2162322((GuiInventory) guiOpenEvent.getGui());
                guiOpenEvent.setGui((GuiScreen) this.Field2543);
                this.Field2541.set(false);
            }
        }
    }

    @SubscribeEvent
    public void Method2162318(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() != null && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature() != null && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature().equals(this)) {
            Setting setting = clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
            String string = clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getName();
            if (setting.equals(this.Field2530) && setting.getPlannedValue() != setting.getValue()) {
                this.Method2150380();
            } else if (string.equalsIgnoreCase("Store")) {
                clientEvent.setCanceled(true);
                this.Field2545 = !this.Field2545;
                Command.Method2159696("<XCarry> \u00a7aAutostoring...");
            }
        }
    }

    @SubscribeEvent
    public void Method2162319(InputEvent.KeyInputEvent keyInputEvent) {
        if (Keyboard.getEventKeyState() && !(XCarry.Field2811.currentScreen instanceof LuigiGuiOld) && this.Field2531.getValue().getKey() == Keyboard.getEventKey()) {
            this.Field2545 = !this.Field2545;
            Command.Method2159696("<XCarry> \u00a7aAutostoring...");
        }
    }

    private void Method2162310() {
        this.Field2543 = null;
        this.Field2541.set(false);
        this.Field2544 = false;
    }

    private void Method2162321() {
        if (XCarry.Method2150359()) {
            return;
        }
        if (this.Field2541.compareAndSet(true, false) && !XCarry.Method2150359()) {
            this.Field2544 = true;
            XCarry.Field2811.player.closeScreen();
            if (this.Field2543 != null) {
                this.Field2543.onGuiClosed();
                this.Field2543 = null;
            }
            this.Field2544 = false;
        }
    }

    private GuiInventory Method2162322(GuiInventory guiInventory) {
        try {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this);
            ReflectionUtil.Method2163940(guiInventory, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
            return iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
        } catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
            return null;
        }
    }

    private boolean Method2162323(Object object) {
        return this.Field2538.getValue();
    }

    private boolean Method2162324(Object object) {
        return this.Field2538.getValue();
    }

    private boolean Method2162325(Object object) {
        return this.Field2531.getValue().getKey() != -1;
    }

    private boolean Method2162326(Object object) {
        return this.Field2531.getValue().getKey() != -1;
    }

    private boolean Method2162327(Object object) {
        return this.Field2531.getValue().getKey() != -1;
    }

    private boolean Method2162328(Object object) {
        return this.Field2531.getValue().getKey() != -1;
    }

    private boolean Method2162329(Object object) {
        return this.Field2531.getValue().getKey() != -1;
    }

    private class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends GuiInventory {
        final XCarry Field629;

        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(XCarry xCarry) {
            this.Field629 = xCarry;
            super((EntityPlayer) Util.Field2811.player);
        }

        protected void keyTyped(char c, int n2) throws IOException {
            if (this.Field629.Method2150364() && (n2 == 1 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(n2))) {
                XCarry.Method2162320(this.Field629).set(true);
                this.mc.displayGuiScreen(null);
            } else {
                super.keyTyped(c, n2);
            }
        }

        public void onGuiClosed() {
            if (XCarry.Method2162331(this.Field629) || !this.Field629.Method2150364()) {
                super.onGuiClosed();
            }
        }
    }
}

