

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.settings.IKeyConflictContext
 *  net.minecraftforge.client.settings.KeyConflictContext
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickItem
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.function.Predicate;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickWindowEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventHandler;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GuiScreenEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class NoSlowDown
        extends Module {
    private static final KeyBinding[] Field1582 = new KeyBinding[]{NoSlowDown.Field2811.gameSettings.keyBindForward, NoSlowDown.Field2811.gameSettings.keyBindRight, NoSlowDown.Field2811.gameSettings.keyBindBack, NoSlowDown.Field2811.gameSettings.keyBindLeft, NoSlowDown.Field2811.gameSettings.keyBindJump, NoSlowDown.Field2811.gameSettings.keyBindSprint};
    private static NoSlowDown Field1583 = new NoSlowDown();
    public Setting<Boolean> Field1584 = this.Method2150366(new Setting<Boolean>("NoSlow", true));
    public Setting<Boolean> Field1585 = this.Method2150366(new Setting<Boolean>("SoulSand", true));
    public Setting<Boolean> Field1586 = this.Method2150366(new Setting<Boolean>("GUIMove", true));
    public Setting<Boolean> Field1587 = this.Method2150366(new Setting<Boolean>("StrictGUIMove", Boolean.valueOf(true), this::Method2162117));
    public Setting<Boolean> Field1588 = this.Method2150366(new Setting<Boolean>("SneakPacket", false));
    public Setting<Boolean> Field1589 = this.Method2150366(new Setting<Boolean>("EndPortal", false));
    public Setting<Boolean> Field1590 = this.Method2150366(new Setting<Boolean>("2b2t", false));
    public Setting<Boolean> Field1591 = this.Method2150366(new Setting<Boolean>("AntiWeb", false));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1592 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("AntiWeb", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Vanilla, this::Method2162116));
    private final Setting<Float> Field1593 = this.Method2150366(new Setting<Float>("Horizontal Speed", Float.valueOf(0.1f), Float.valueOf(0.1f), Float.valueOf(2.0f), this::Method2162115));
    private final Setting<Float> Field1594 = this.Method2150366(new Setting<Float>("Vertical Speed", Float.valueOf(0.1f), Float.valueOf(0.1f), Float.valueOf(2.0f), this::Method2162114));
    private final Setting<Float> Field1595 = this.Method2150366(new Setting<Float>("Timer", Float.valueOf(0.1f), Float.valueOf(0.1f), Float.valueOf(10.0f), this::Method2162113));
    public Setting<Boolean> Field1596 = this.Method2150366(new Setting<Boolean>("OnlySnaking", Boolean.valueOf(false), this::Method2162112));
    public boolean Field1598;
    @EventHandler
    public Listener<GuiScreenEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field1599 = new Listener<GuiScreenEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>(this::Method2162111, new Predicate[0]);
    private boolean Field1597;

    public NoSlowDown() {
        super("NoSlowDown", "Prevents you from getting slowed down.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
        this.Method2161005();
    }

    public static NoSlowDown Method2161004() {
        if (Field1583 == null) {
            Field1583 = new NoSlowDown();
        }
        return Field1583;
    }

    private void Method2161005() {
        Field1583 = this;
    }

    @Override
    public void Method2150379() {
        if (this.Field1586.getValue().booleanValue()) {
            if (NoSlowDown.Field2811.currentScreen == null) {
                return;
            }
            if (NoSlowDown.Field2811.currentScreen instanceof GuiChat) {
                return;
            }
            NoSlowDown.Field2811.player.rotationYaw += Keyboard.isKeyDown((int) 205) ? 4.0f : (Keyboard.isKeyDown((int) 203) ? -4.0f : 0.0f);
            NoSlowDown.Field2811.player.rotationPitch = (float) ((double) NoSlowDown.Field2811.player.rotationPitch + (double) (Keyboard.isKeyDown((int) 208) ? 4 : (Keyboard.isKeyDown((int) 200) ? -4 : 0)) * 0.75);
            NoSlowDown.Field2811.player.rotationPitch = MathHelper.clamp((float) NoSlowDown.Field2811.player.rotationPitch, (float) -90.0f, (float) 90.0f);
            this.Method2161009();
        }
        NoSlowDown.Field2811.player.getActiveItemStack().getItem();
        if (this.Field1597 && !NoSlowDown.Field2811.player.isHandActive() && this.Field1588.getValue().booleanValue()) {
            NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) NoSlowDown.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.Field1597 = false;
        }
    }

    @Override
    public void Method2150376() {
        if (this.Field1591.getValue().booleanValue()) {
            if (!NoSlowDown.Field2811.player.isInWeb) {
                if (this.Field1598) {
                    NoSlowDown.Field2811.timer.tickLength = 50.0f;
                    this.Field1598 = false;
                }
                return;
            }
            switch (1.F ield892[this.Field1592.getValue().ordinal()]){
                case 1: {
                    NoSlowDown.Field2811.player.isInWeb = false;
                    break;
                }
                case 2: {
                    NoSlowDown.Field2811.player.motionX *= (double) (1.0f + this.Field1593.getValue().floatValue());
                    NoSlowDown.Field2811.player.motionY = -this.Field1594.getValue().floatValue();
                    NoSlowDown.Field2811.player.motionZ *= (double) (1.0f + this.Field1593.getValue().floatValue());
                    break;
                }
                case 3: {
                    if (this.Field1596.getValue().booleanValue() && NoSlowDown.Field2811.player.isSneaking()) {
                        NoSlowDown.Field2811.timer.tickLength = 50.0f / this.Field1595.getValue().floatValue();
                        this.Field1598 = true;
                    }
                    if (this.Field1596.getValue().booleanValue()) break;
                    NoSlowDown.Field2811.timer.tickLength = 50.0f / this.Field1595.getValue().floatValue();
                    this.Field1598 = true;
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161006(PlayerInteractEvent.RightClickItem rightClickItem) {
        Item item = NoSlowDown.Field2811.player.getHeldItem(rightClickItem.getHand()).getItem();
        if ((item instanceof ItemFood || item instanceof ItemBow || item instanceof ItemPotion && this.Field1588.getValue().booleanValue()) && !this.Field1597) {
            NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) NoSlowDown.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            this.Field1597 = true;
        }
    }

    @SubscribeEvent
    public void Method2161007(InputUpdateEvent inputUpdateEvent) {
        if (this.Field1584.getValue().booleanValue() && NoSlowDown.Field2811.player.isHandActive() && !NoSlowDown.Field2811.player.isRiding()) {
            inputUpdateEvent.getMovementInput().moveStrafe *= 5.0f;
            inputUpdateEvent.getMovementInput().moveForward *= 5.0f;
        }
    }

    @SubscribeEvent
    public void Method2161008(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerTryUseItem || iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerTryUseItemOnBlock) {
            Item item = NoSlowDown.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem();
            if (this.Field1590.getValue().booleanValue() && (item instanceof ItemFood || item instanceof ItemBow || item instanceof ItemPotion)) {
                NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(NoSlowDown.Field2811.player.inventory.currentItem));
            }
        }
        if (this.Field1586.getValue().booleanValue() && this.Field1587.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketClickWindow) {
            if (NoSlowDown.Field2811.player.isActiveItemStackBlocking()) {
                NoSlowDown.Field2811.playerController.onStoppedUsingItem((EntityPlayer) NoSlowDown.Field2811.player);
            }
            if (NoSlowDown.Field2811.player.isSneaking()) {
                NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) NoSlowDown.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (NoSlowDown.Field2811.player.isSprinting()) {
                NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) NoSlowDown.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
        }
    }

    private void Method2161009() {
        for (KeyBinding keyBinding : Field1582) {
            if (Keyboard.isKeyDown((int) keyBinding.getKeyCode())) {
                if (keyBinding.getKeyConflictContext() != KeyConflictContext.UNIVERSAL) {
                    keyBinding.setKeyConflictContext((IKeyConflictContext) KeyConflictContext.UNIVERSAL);
                }
                KeyBinding.setKeyBindState((int) keyBinding.getKeyCode(), (boolean) true);
                continue;
            }
            KeyBinding.setKeyBindState((int) keyBinding.getKeyCode(), (boolean) false);
        }
    }

    @SubscribeEvent
    public void Method2161000(ClickWindowEvent clickWindowEvent) {
        if (this.Field1586.getValue().booleanValue()) {
            if (!this.Field1587.getValue().booleanValue()) {
                return;
            }
            if (NoSlowDown.Field2811.player.isSneaking()) {
                NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) NoSlowDown.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (NoSlowDown.Field2811.player.isSprinting()) {
                NoSlowDown.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) NoSlowDown.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            }
        }
    }

    private void Method2162111(GuiScreenEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (this.Field1586.getValue().booleanValue()) {
            if (NoSlowDown.Field2811.currentScreen == null) {
                return;
            }
            if (NoSlowDown.Field2811.currentScreen instanceof GuiChat) {
                return;
            }
            this.Method2161009();
        }
    }

    private boolean Method2162112(Boolean bl) {
        return this.Field1592.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Timer && this.Field1591.getValue() != false;
    }

    private boolean Method2162113(Float f) {
        return this.Field1592.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Timer && this.Field1591.getValue() != false;
    }

    private boolean Method2162114(Float f) {
        return this.Field1592.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Motion && this.Field1591.getValue() != false;
    }

    private boolean Method2162115(Float f) {
        return this.Field1592.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Motion && this.Field1591.getValue() != false;
    }

    private boolean Method2162116(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        return this.Field1591.getValue();
    }

    private boolean Method2162117(Boolean bl) {
        return this.Field1586.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Vanilla,
        Motion,
        Timer;

    }
}

