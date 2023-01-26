

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemExpBottle
 *  net.minecraft.item.ItemMinecart
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemMinecart;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class FastUse
        extends Module {
    private Setting<Boolean> Field4385 = this.Method2150366(new Setting<Boolean>("All", false));
    private Setting<Boolean> Field4386 = this.Method2150366(new Setting<Object>("Obsidian", Boolean.FALSE, this::Method2162237));
    private Setting<Boolean> Field4387 = this.Method2150366(new Setting<Object>("EnderChest", Boolean.FALSE, this::Method2162236));
    private Setting<Boolean> Field4388 = this.Method2150366(new Setting<Object>("Crystals", Boolean.FALSE, this::Method2162235));
    private Setting<Boolean> Field4389 = this.Method2150366(new Setting<Object>("Experience", Boolean.TRUE, this::Method2162234));
    private Setting<Boolean> Field4390 = this.Method2150366(new Setting<Object>("Minecarts", Boolean.FALSE, this::Method2162233));
    private Setting<Boolean> Field4391 = this.Method2150366(new Setting<Boolean>("PacketCrystal", false));
    private Setting<Boolean> Field4392 = this.Method2150366(new Setting<Boolean>("Strict", true));
    private BlockPos Field4393 = null;

    public FastUse() {
        super("FastUse", "Allows you to use items faster", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    @Override
    public void Method2150379() {
        if (this.Field4392.getValue().booleanValue() && FastUse.Field2811.player.ticksExisted % 2 == 0) {
            return;
        }
        if (FastUse.Method2150359()) {
            return;
        }
        if (InventoryUtil.Method2163796(ItemExpBottle.class) && this.Field4389.getValue().booleanValue()) {
            FastUse.Field2811.rightClickDelayTimer = 0;
        }
        if (InventoryUtil.Method2163796(BlockObsidian.class) && this.Field4386.getValue().booleanValue()) {
            FastUse.Field2811.rightClickDelayTimer = 0;
        }
        if (InventoryUtil.Method2163796(BlockEnderChest.class) && this.Field4387.getValue().booleanValue()) {
            FastUse.Field2811.rightClickDelayTimer = 0;
        }
        if (InventoryUtil.Method2163796(ItemMinecart.class) && this.Field4390.getValue().booleanValue()) {
            FastUse.Field2811.rightClickDelayTimer = 0;
        }
        if (this.Field4385.getValue().booleanValue()) {
            FastUse.Field2811.rightClickDelayTimer = 0;
        }
        if (InventoryUtil.Method2163796(ItemEndCrystal.class) && (this.Field4388.getValue().booleanValue() || this.Field4385.getValue().booleanValue())) {
            FastUse.Field2811.rightClickDelayTimer = 0;
        }
        if (this.Field4391.getValue().booleanValue() && FastUse.Field2811.gameSettings.keyBindUseItem.isKeyDown()) {
            boolean bl = FastUse.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
            boolean bl2 = bl;
            if (bl || FastUse.Field2811.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL) {
                RayTraceResult rayTraceResult = FastUse.Field2811.objectMouseOver;
                if (rayTraceResult == null) {
                    return;
                }
                switch (1.F ield1341[rayTraceResult.typeOfHit.ordinal()]){
                    case 1: {
                        this.Field4393 = null;
                        break;
                    }
                    case 2: {
                        this.Field4393 = FastUse.Field2811.objectMouseOver.getBlockPos();
                        break;
                    }
                    case 3: {
                        Entity entity;
                        if (this.Field4393 == null || (entity = rayTraceResult.entityHit) == null || !this.Field4393.equals((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ)))
                            break;
                        FastUse.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(this.Field4393, EnumFacing.DOWN, bl ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                    }
                }
            }
        }
    }

    private boolean Method2162233(Object object) {
        return this.Field4385.getValue() == false;
    }

    private boolean Method2162234(Object object) {
        return this.Field4385.getValue() == false;
    }

    private boolean Method2162235(Object object) {
        return this.Field4385.getValue() == false;
    }

    private boolean Method2162236(Object object) {
        return this.Field4385.getValue() == false;
    }

    private boolean Method2162237(Object object) {
        return this.Field4385.getValue() == false;
    }
}

