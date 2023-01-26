

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class OffhandModule
        extends Module {
    private final Queue<Integer> Field967 = new LinkedList<Integer>();
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field948 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Offhand", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.TOTEM));
    public Setting<Boolean> Field949 = this.Method2150366(new Setting<Boolean>("ACCheck", false));
    public Setting<Integer> Field950 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 100));
    public Setting<Boolean> Field951 = this.Method2150366(new Setting<Boolean>("HotbarTotem", false));
    public Setting<Float> Field952 = this.Method2150366(new Setting<Float>("TotemHealth", Float.valueOf(14.0f), Float.valueOf(0.0f), Float.valueOf(36.0f)));
    public Setting<Boolean> Field953 = this.Method2150366(new Setting<Boolean>("RightClickGap", true));
    public Setting<Boolean> Field954 = this.Method2150366(new Setting<Boolean>("Auto2bJbDelay", true));
    public Setting<Boolean> Field955 = this.Method2150366(new Setting<Boolean>("FixDrawn", true));
    public Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field956 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("HUDInfo", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.AutoTotem));
    public Setting<Boolean> Field957 = this.Method2150366(new Setting<Boolean>("NoMove", false));
    public Setting<Boolean> Field958 = this.Method2150366(new Setting<Boolean>("CancelActions", false));
    public Setting<Boolean> Field959 = this.Method2150366(new Setting<Boolean>("CancelActive", false));
    public Setting<Boolean> Field960 = this.Method2150366(new Setting<Boolean>("TotemOnElytra", true));
    public Setting<Boolean> Field961 = this.Method2150366(new Setting<Boolean>("FallCheck", true));
    public Setting<Float> Field962 = this.Method2150366(new Setting<Float>("FallDist", Float.valueOf(15.0f), Float.valueOf(0.0f), Float.valueOf(50.0f)));
    public Setting<Boolean> Field963 = this.Method2150366(new Setting<Boolean>("ExtraSafe", false));
    public Setting<Boolean> Field964 = this.Method2150366(new Setting<Boolean>("ClearAfter", true));
    public Setting<Boolean> Field965 = this.Method2150366(new Setting<Boolean>("HardCheck", true));
    public Setting<Boolean> Field966 = this.Method2150366(new Setting<Boolean>("NotFromHotbar", true));
    public boolean Field969 = false;
    protected boolean Field970;
    protected boolean Field971;
    private Timer Field968 = new Timer();
    private int Field972 = 0;
    private int Field973 = 0;
    private int Field974 = 0;

    public OffhandModule() {
        super("Offhand", "Totem", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static int Method2161221() {
        return OffhandModule.Field2811.player.inventory.mainInventory.stream().filter(OffhandModule::Method2161229).mapToInt(ItemStack::getCount).sum() + OffhandModule.Field2811.player.inventory.offHandInventory.stream().filter(OffhandModule::Method2161228).mapToInt(ItemStack::getCount).sum();
    }

    public static int Method2161222() {
        return OffhandModule.Field2811.player.inventory.mainInventory.stream().filter(OffhandModule::Method2161227).mapToInt(ItemStack::getCount).sum() + OffhandModule.Field2811.player.inventory.offHandInventory.stream().filter(OffhandModule::Method2161226).mapToInt(ItemStack::getCount).sum();
    }

    public static int Method2161223() {
        return OffhandModule.Field2811.player.inventory.mainInventory.stream().filter(OffhandModule::Method2161225).mapToInt(ItemStack::getCount).sum() + OffhandModule.Field2811.player.inventory.offHandInventory.stream().filter(OffhandModule::Method2161224).mapToInt(ItemStack::getCount).sum();
    }

    private static boolean Method2161224(ItemStack itemStack) {
        return itemStack.getItem().equals((Object) Items.GOLDEN_APPLE);
    }

    private static boolean Method2161225(ItemStack itemStack) {
        return itemStack.getItem().equals((Object) Items.GOLDEN_APPLE);
    }

    private static boolean Method2161226(ItemStack itemStack) {
        return itemStack.getItem().equals((Object) Items.END_CRYSTAL);
    }

    private static boolean Method2161227(ItemStack itemStack) {
        return itemStack.getItem().equals((Object) Items.END_CRYSTAL);
    }

    private static boolean Method2161228(ItemStack itemStack) {
        return itemStack.getItem().equals((Object) Items.TOTEM_OF_UNDYING);
    }

    private static boolean Method2161229(ItemStack itemStack) {
        return itemStack.getItem().equals((Object) Items.TOTEM_OF_UNDYING);
    }

    private static boolean Method2161220(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    private static boolean Method2161231(Entity entity) {
        return OffhandModule.Field2811.player.getDistance(entity) <= 12.0f;
    }

    private static boolean Method2161232(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    @Override
    public void Method2150378() {
        if (this.Field969 && this.Field954.getValue().booleanValue()) {
            this.Field950.setValue(0);
        }
    }

    @Override
    public void Method2150377() {
        if (Objects.requireNonNull(OffhandModule.Field2811.getCurrentServerData()).serverIP.toLowerCase().equals("2b2tjb.jp") || Objects.requireNonNull(OffhandModule.Field2811.getCurrentServerData()).serverIP.toLowerCase().equals("2b2t-jp.ddns.net") || Objects.requireNonNull(OffhandModule.Field2811.getCurrentServerData()).serverIP.toLowerCase().equals("2b2t.eu.org") || Objects.requireNonNull(OffhandModule.Field2811.getCurrentServerData()).serverIP.toLowerCase().equals("2b2t.jp.net")) {
            this.Field969 = true;
            if (this.Field954.getValue().booleanValue()) {
                this.Field950.setValue(50);
            }
        } else {
            this.Field969 = false;
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field956.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Phobos) {
            if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
                return this.Field973 + "";
            }
            if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
                return this.Field972 + "";
            }
            if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
                return this.Field974 + "";
            }
            return this.Field972 + "";
        }
        if (this.Field956.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.AutoTotem) {
            return this.Field972 + "";
        }
        if (this.Field956.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Offhand) {
            return this.Field948.currentEnumName() + "";
        }
        return this.Field972 + "";
    }

    @Override
    public String Method2150392() {
        if (this.Field956.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Phobos) {
            if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
                return "OffhandCrystal";
            }
            if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
                return "AutoTotem";
            }
            if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
                return "OffhandGapple";
            }
            return "AutoTotem";
        }
        if (this.Field956.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.AutoTotem) {
            return "AutoTotem";
        }
        if (this.Field956.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Offhand) {
            return "Offhand";
        }
        return "AutoTotem";
    }

    @Override
    public void Method2150372() {
        if (OffhandModule.Method2150359()) {
            return;
        }
        if (this.Field955.getValue().booleanValue()) {
            this.Field3711.setValue(true);
        }
        this.Field969 = false;
    }

    @Override
    public void Method2150373() {
        if (this.Field955.getValue().booleanValue()) {
            this.Field3711.setValue(false);
        }
        this.Field969 = false;
    }

    @Override
    public void Method2150379() {
        if (OffhandModule.Field2811.player == null || OffhandModule.Field2811.world == null) {
            return;
        }
        this.Field972 = OffhandModule.Method2161221();
        this.Field973 = OffhandModule.Method2161222();
        this.Field974 = OffhandModule.Method2161223();
        if (!(OffhandModule.Field2811.currentScreen instanceof GuiContainer) && !(OffhandModule.Field2811.currentScreen instanceof GuiInventory)) {
            if (!this.Field967.isEmpty()) {
                if (!this.Field968.Method2164755(this.Field950.getValue().intValue())) {
                    return;
                }
                int n2 = this.Field967.poll();
                try {
                    this.Field968.Method2164750();
                    OffhandModule.Field2811.playerController.windowClick(OffhandModule.Field2811.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) OffhandModule.Field2811.player);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                if (!OffhandModule.Field2811.player.inventory.getItemStack().isEmpty()) {
                    for (int j = 44; j >= 9; --j) {
                        if (!OffhandModule.Field2811.player.inventoryContainer.getSlot(j).getStack().isEmpty()) {
                            continue;
                        }
                        OffhandModule.Field2811.playerController.windowClick(0, j, 0, ClickType.PICKUP, (EntityPlayer) OffhandModule.Field2811.player);
                        return;
                    }
                }
                if (OffhandModule.Field2811.player.getHealth() + OffhandModule.Field2811.player.getAbsorptionAmount() <= this.Field952.getValue().floatValue() || this.Field960.getValue() != false && OffhandModule.Field2811.player.isElytraFlying() || this.Field961.getValue().booleanValue() && OffhandModule.Field2811.player.fallDistance >= this.Field962.getValue().floatValue() && !OffhandModule.Field2811.player.isElytraFlying()) {
                    this.Method2161216(Items.TOTEM_OF_UNDYING);
                    return;
                }
                float f = 0.0f;
                List list = OffhandModule.Field2811.world.loadedEntityList.stream().filter(OffhandModule::Method2161232).filter(OffhandModule::Method2161231).collect(Collectors.toList());
                for (Entity entity : list) {
                    f += CrystalUtilSC.Method2162915((EntityEnderCrystal) entity, (Entity) OffhandModule.Field2811.player);
                }
                if (OffhandModule.Field2811.player.getHealth() + OffhandModule.Field2811.player.getAbsorptionAmount() <= f) {
                    this.Method2161216(Items.TOTEM_OF_UNDYING);
                    return;
                }
                if (this.Field963.getValue().booleanValue() && this.Method2161217()) {
                    this.Method2161216(Items.TOTEM_OF_UNDYING);
                    return;
                }
                if (this.Method2161214(OffhandModule.Field2811.player.getHeldItemMainhand().getItem())) {
                    if (this.Field953.getValue().booleanValue() && !OffhandModule.Field2811.gameSettings.keyBindUseItem.isKeyDown()) {
                        if (this.Field964.getValue().booleanValue()) {
                            this.Method2161216(this.Field948.getValue().Field4225);
                        }
                        return;
                    }
                    this.Method2161216(Items.GOLDEN_APPLE);
                    return;
                }
                if (AliceMain.Field756.Method2150180(AliceAura.class).Method2150364() && this.Field949.getValue().booleanValue()) {
                    this.Method2161216(Items.END_CRYSTAL);
                    return;
                }
                if (this.Field964.getValue().booleanValue()) {
                    this.Method2161216(this.Field948.getValue().Field4225);
                    return;
                }
                if (this.Field965.getValue().booleanValue()) {
                    this.Method2161216(this.Field948.getValue().Field4225);
                }
            }
        }
    }

    private boolean Method2161214(Item item) {
        return item == Items.DIAMOND_SWORD || item == Items.IRON_SWORD || item == Items.GOLDEN_SWORD || item == Items.STONE_SWORD || item == Items.WOODEN_SWORD;
    }

    private int Method2161215(Item item) {
        int n2;
        int n3 = -1;
        int n4 = n2;
        for (n2 = this.Field966.getValue() != false ? 9 : 0; n2 < 36; ++n2) {
            ItemStack itemStack = OffhandModule.Field2811.player.inventory.getStackInSlot(n2);
            if (itemStack == null || itemStack.getItem() != item) continue;
            n3 = n2;
            break;
        }
        return n3;
    }

    private void Method2161216(Item item) {
        if (OffhandModule.Field2811.player.getHeldItemOffhand().getItem() == item) {
            return;
        }
        int n2 = this.Method2161215(item);
        if (this.Field951.getValue().booleanValue() && item == Items.TOTEM_OF_UNDYING) {
            for (int j = 0; j < 9; ++j) {
                ItemStack itemStack = (ItemStack) OffhandModule.Field2811.player.inventory.mainInventory.get(j);
                if (itemStack.getItem() != Items.TOTEM_OF_UNDYING) {
                    continue;
                }
                if (OffhandModule.Field2811.player.inventory.currentItem != j) {
                    OffhandModule.Field2811.player.inventory.currentItem = j;
                }
                return;
            }
        }
        if (n2 != -1) {
            if ((float) this.Field950.getValue().intValue() > 0.0f) {
                if (this.Field968.Method2164755(this.Field950.getValue().intValue())) {
                    this.Method2161219();
                    OffhandModule.Field2811.playerController.windowClick(OffhandModule.Field2811.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer) OffhandModule.Field2811.player);
                    this.Method2161210();
                    this.Field968.Method2164750();
                } else {
                    this.Field967.add(n2 < 9 ? n2 + 36 : n2);
                }
                this.Field967.add(45);
                this.Field967.add(n2 < 9 ? n2 + 36 : n2);
            } else {
                this.Method2161219();
                this.Field968.Method2164750();
                OffhandModule.Field2811.playerController.windowClick(OffhandModule.Field2811.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer) OffhandModule.Field2811.player);
                try {
                    OffhandModule.Field2811.playerController.windowClick(OffhandModule.Field2811.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, (EntityPlayer) OffhandModule.Field2811.player);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                OffhandModule.Field2811.playerController.windowClick(OffhandModule.Field2811.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer) OffhandModule.Field2811.player);
                this.Method2161210();
            }
        }
    }

    private boolean Method2161217() {
        float f = 0.0f;
        ArrayList<Float> arrayList = new ArrayList<Float>();
        arrayList.add(Float.valueOf(this.Method2161218(OffhandModule.Field2811.player.getPosition().add(1, 0, 0))));
        arrayList.add(Float.valueOf(this.Method2161218(OffhandModule.Field2811.player.getPosition().add(-1, 0, 0))));
        arrayList.add(Float.valueOf(this.Method2161218(OffhandModule.Field2811.player.getPosition().add(0, 0, 1))));
        arrayList.add(Float.valueOf(this.Method2161218(OffhandModule.Field2811.player.getPosition().add(0, 0, -1))));
        arrayList.add(Float.valueOf(this.Method2161218(OffhandModule.Field2811.player.getPosition())));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            float f2 = ((Float) iterator.next()).floatValue();
            f += f2;
            if (!(OffhandModule.Field2811.player.getHealth() + OffhandModule.Field2811.player.getAbsorptionAmount() - f2 <= this.Field952.getValue().floatValue()))
                continue;
            return true;
        }
        return OffhandModule.Field2811.player.getHealth() + OffhandModule.Field2811.player.getAbsorptionAmount() - f <= this.Field952.getValue().floatValue();
    }

    private float Method2161218(BlockPos blockPos) {
        List list = OffhandModule.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos)).stream().filter(OffhandModule::Method2161220).collect(Collectors.toList());
        float f = 0.0f;
        for (Entity entity : list) {
            f += CrystalUtilSC.Method2162914(entity.posX, entity.posY, entity.posZ, (Entity) OffhandModule.Field2811.player);
        }
        return f;
    }

    public void Method2161219() {
        if (this.Field957.getValue().booleanValue() && OffhandModule.Field2811.player.onGround) {
            OffhandModule.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(OffhandModule.Field2811.player.posX, OffhandModule.Field2811.player.posY, OffhandModule.Field2811.player.posZ, OffhandModule.Field2811.player.onGround));
        }
        this.Field970 = OffhandModule.Field2811.player.isSneaking();
        this.Field971 = OffhandModule.Field2811.player.isSprinting();
        if (this.Field958.getValue().booleanValue()) {
            if (this.Field970) {
                OffhandModule.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) OffhandModule.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (this.Field971) {
                OffhandModule.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) OffhandModule.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
        }
        if (this.Field959.getValue().booleanValue()) {
            AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(OffhandModule.Field2811.player.inventory.currentItem));
        }
    }

    public void Method2161210() {
        if (this.Field958.getValue().booleanValue()) {
            if (this.Field970) {
                OffhandModule.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) OffhandModule.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (this.Field971) {
                OffhandModule.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) OffhandModule.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            }
        }
    }

    private static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        TOTEM(Items.TOTEM_OF_UNDYING),
        CRYSTAL(Items.END_CRYSTAL),
        GAPPLE(Items.GOLDEN_APPLE),
        AIR(Items.AIR);

        public Item Field4225;

        private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(Item item) {
            this.Field4225 = item;
        }
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        DAMAGE,
        NEW;

    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        AutoTotem,
        Offhand,
        Phobos;

    }
}

