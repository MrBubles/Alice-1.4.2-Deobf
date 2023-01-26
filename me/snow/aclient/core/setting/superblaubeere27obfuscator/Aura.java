

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Aura
        extends Module {
    public static Entity Field2488;
    private final Timer Field2489 = new Timer();
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2491 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Target", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CLOSEST));
    public Setting<Float> Field2490 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(5.5f), Float.valueOf(0.1f), Float.valueOf(7.0f)));
    public Setting<Float> Field2492 = this.Method2150366(new Setting<Object>("Health", Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(36.0f), this::Method2150923));
    public Setting<Boolean> Field2493 = this.Method2150366(new Setting<Boolean>("AutoSwitch", false));
    public Setting<Boolean> Field2494 = this.Method2150366(new Setting<Boolean>("Delay", true));
    public Setting<Boolean> Field2495 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    public Setting<Boolean> Field2496 = this.Method2150366(new Setting<Object>("Stay-Rotate", Boolean.TRUE, this::Method2150922));
    public Setting<Boolean> Field2497 = this.Method2150366(new Setting<Boolean>("ArmorBreak", false));
    public Setting<Boolean> Field2498 = this.Method2150366(new Setting<Boolean>("While-Eating", true));
    public Setting<Boolean> Field2499 = this.Method2150366(new Setting<Boolean>("Axe/Sword", true));
    public Setting<Boolean> Field2500 = this.Method2150366(new Setting<Boolean>("Teleport", false));
    public Setting<Float> Field2501 = this.Method2150366(new Setting<Object>("WallRange", Float.valueOf(4.0f), Float.valueOf(0.1f), Float.valueOf(7.0f), this::Method2150921, "Wall Range."));
    public Setting<Float> Field2502 = this.Method2150366(new Setting<Object>("TpRange", Float.valueOf(15.0f), Float.valueOf(0.1f), Float.valueOf(50.0f), this::Method2150910, "Teleport Range."));
    public Setting<Boolean> Field2503 = this.Method2150366(new Setting<Object>("LagBack", Boolean.TRUE, this::Method2150919));
    public Setting<Boolean> Field2504 = this.Method2150366(new Setting<Boolean>("Players", true));
    public Setting<Boolean> Field2505 = this.Method2150366(new Setting<Boolean>("Monsters", false));
    public Setting<Boolean> Field2506 = this.Method2150366(new Setting<Boolean>("Animals", false));
    public Setting<Boolean> Field2507 = this.Method2150366(new Setting<Boolean>("Entities", false));
    public Setting<Boolean> Field2508 = this.Method2150366(new Setting<Boolean>("Projectiles", false));
    public Setting<Boolean> Field2509 = this.Method2150366(new Setting<Boolean>("TPS-Sync", true));
    public Setting<Boolean> Field2510 = this.Method2150366(new Setting<Boolean>("Packet-Attack", false));
    public Setting<Boolean> Field2511 = this.Method2150366(new Setting<Boolean>("Sneak", false));
    public Setting<Boolean> Field2512 = this.Method2150366(new Setting<Boolean>("Render", Boolean.TRUE));
    public Setting<Boolean> Field2513 = this.Method2150366(new Setting<Boolean>("ColorSync", Boolean.TRUE));
    public Setting<Integer> Field2514 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    public Setting<Integer> Field2515 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    public Setting<Integer> Field2516 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    public Setting<Integer> Field2517 = this.Method2150366(new Setting<Integer>("Alpha", 100, 0, 255));

    public Aura() {
        super("Aura", "Kills aura.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static void Method2150915() {
        AliceMain.Field756.Method2150180(Aura.class).Field2490.setValue(Float.valueOf(5.5f));
        AliceMain.Field756.Method2150180(Aura.class).Field2501.setValue(Float.valueOf(4.0f));
        AliceMain.Field756.Method2150180(Aura.class).Field2494.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2495.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2496.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2498.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2499.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2504.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2509.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2512.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2513.setValue(true);
        AliceMain.Field756.Method2150180(Aura.class).Field2517.setValue(100);
    }

    @Override
    public String Method2150385() {
        return "Single";
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        Color color;
        Color color2 = color = this.Field2513.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2514.getValue(), this.Field2515.getValue(), this.Field2516.getValue(), this.Field2517.getValue());
        if (this.Field2512.getValue().booleanValue()) {
            if (Field2488 == null) {
                return;
            }
            RenderUtil.Method2163962(Field2488.getEntityBoundingBox(), color, this.Field2517.getValue());
        }
    }

    @Override
    public void Method2150376() {
        if (!this.Field2495.getValue().booleanValue()) {
            this.Method2150917();
        }
    }

    @SubscribeEvent
    public void Method2150916(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && this.Field2495.getValue().booleanValue()) {
            if (this.Field2496.getValue().booleanValue() && Field2488 != null) {
                AliceMain.Field760.Method2150283(Field2488);
            }
            this.Method2150917();
        }
    }

    private void Method2150917() {
        int n2;
        int n3;
        if (this.Field2499.getValue().booleanValue() && !EntityUtil.Method2163547((EntityPlayer) Aura.Field2811.player)) {
            Field2488 = null;
            return;
        }
        int n4 = this.Field2494.getValue() == false ? 0 : (n3 = (int) ((float) DamageUtil.Method2163464((EntityPlayer) Aura.Field2811.player) * (this.Field2509.getValue() != false ? AliceMain.Field768.Method2150202() : 1.0f)));
        if (!this.Field2489.Method2164755(n3) || !this.Field2498.getValue().booleanValue() && Aura.Field2811.player.isHandActive() && (!Aura.Field2811.player.getHeldItemOffhand().getItem().equals((Object) Items.SHIELD) || Aura.Field2811.player.getActiveHand() != EnumHand.OFF_HAND)) {
            return;
        }
        if (!(this.Field2491.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FOCUS && Field2488 != null && (Aura.Field2811.player.getDistanceSq(Field2488) < MathUtil.Method2163857(this.Field2490.getValue().floatValue()) || this.Field2500.getValue().booleanValue() && Aura.Field2811.player.getDistanceSq(Field2488) < MathUtil.Method2163857(this.Field2502.getValue().floatValue())) && (Aura.Field2811.player.canEntityBeSeen(Field2488) || EntityUtil.Method2163544(Field2488) || Aura.Field2811.player.getDistanceSq(Field2488) < MathUtil.Method2163857(this.Field2501.getValue().floatValue()) || this.Field2500.getValue().booleanValue()))) {
            Field2488 = this.Method2150918();
        }
        if (Field2488 == null) {
            return;
        }
        if (this.Field2493.getValue().booleanValue() && (n2 = InventoryUtil.Method2163778(ItemSword.class)) != -1) {
            InventoryUtil.Method2163773(n2, false);
        }
        if (this.Field2495.getValue().booleanValue()) {
            AliceMain.Field760.Method2150283(Field2488);
        }
        if (this.Field2500.getValue().booleanValue()) {
            AliceMain.Field758.Method2150253(Aura.Field2488.posX, EntityUtil.Method2163544(Field2488) ? Aura.Field2488.posY : Aura.Field2488.posY + (double) Field2488.getEyeHeight(), Aura.Field2488.posZ, true, true, this.Field2503.getValue() == false);
        }
        if (this.Field2497.getValue().booleanValue()) {
            Aura.Field2811.playerController.windowClick(Aura.Field2811.player.inventoryContainer.windowId, 9, Aura.Field2811.player.inventory.currentItem, ClickType.SWAP, (EntityPlayer) Aura.Field2811.player);
            EntityUtil.Method2163488(Field2488, this.Field2510.getValue(), true);
            Aura.Field2811.playerController.windowClick(Aura.Field2811.player.inventoryContainer.windowId, 9, Aura.Field2811.player.inventory.currentItem, ClickType.SWAP, (EntityPlayer) Aura.Field2811.player);
            EntityUtil.Method2163488(Field2488, this.Field2510.getValue(), true);
        } else {
            boolean bl = Aura.Field2811.player.isSneaking();
            boolean bl2 = Aura.Field2811.player.isSprinting();
            if (this.Field2511.getValue().booleanValue()) {
                if (bl) {
                    Aura.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Aura.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                if (bl2) {
                    Aura.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Aura.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
                }
            }
            EntityUtil.Method2163488(Field2488, this.Field2510.getValue(), true);
            if (this.Field2511.getValue().booleanValue()) {
                if (bl2) {
                    Aura.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Aura.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
                }
                if (bl) {
                    Aura.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Aura.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
                }
            }
        }
        this.Field2489.Method2164750();
    }

    private Entity Method2150918() {
        Entity entity = null;
        double d = this.Field2500.getValue() != false ? (double) this.Field2502.getValue().floatValue() : (double) this.Field2490.getValue().floatValue();
        double d2 = 36.0;
        for (Entity entity2 : Aura.Field2811.world.loadedEntityList) {
            if (!(this.Field2504.getValue() != false && entity2 instanceof EntityPlayer || this.Field2506.getValue() != false && EntityUtil.Method2163499(entity2) || this.Field2505.getValue() != false && EntityUtil.Method2163405(entity2) || this.Field2507.getValue() != false && EntityUtil.Method2163408(entity2)) && (!this.Field2508.getValue().booleanValue() || !EntityUtil.Method2163407(entity2)) || entity2 instanceof EntityLivingBase && EntityUtil.Method2163545(entity2, d) || !this.Field2500.getValue().booleanValue() && !Aura.Field2811.player.canEntityBeSeen(entity2) && !EntityUtil.Method2163544(entity2) && Aura.Field2811.player.getDistanceSq(entity2) > MathUtil.Method2163857(this.Field2501.getValue().floatValue()))
                continue;
            if (entity == null) {
                entity = entity2;
                d = Aura.Field2811.player.getDistanceSq(entity2);
                d2 = EntityUtil.Method2163530(entity2);
                continue;
            }
            if (entity2 instanceof EntityPlayer && DamageUtil.Method2163451((EntityPlayer) entity2, 18)) {
                entity = entity2;
                break;
            }
            if (this.Field2491.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SMART && EntityUtil.Method2163530(entity2) < this.Field2492.getValue().floatValue()) {
                entity = entity2;
                break;
            }
            if (this.Field2491.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.HEALTH && Aura.Field2811.player.getDistanceSq(entity2) < d) {
                entity = entity2;
                d = Aura.Field2811.player.getDistanceSq(entity2);
                d2 = EntityUtil.Method2163530(entity2);
            }
            if (this.Field2491.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.HEALTH || !((double) EntityUtil.Method2163530(entity2) < d2))
                continue;
            entity = entity2;
            d = Aura.Field2811.player.getDistanceSq(entity2);
            d2 = EntityUtil.Method2163530(entity2);
        }
        return entity;
    }

    private boolean Method2150919(Object object) {
        return this.Field2500.getValue();
    }

    private boolean Method2150910(Object object) {
        return this.Field2500.getValue();
    }

    private boolean Method2150921(Object object) {
        return this.Field2500.getValue() == false;
    }

    private boolean Method2150922(Object object) {
        return this.Field2495.getValue();
    }

    private boolean Method2150923(Object object) {
        return this.Field2491.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SMART;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        FOCUS,
        CLOSEST,
        HEALTH,
        SMART;

    }
}

