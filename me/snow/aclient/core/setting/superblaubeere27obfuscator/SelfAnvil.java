

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFalling
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class SelfAnvil
        extends Module {
    private final Setting<Boolean> Field796 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private final Setting<Boolean> Field797 = this.Method2150366(new Setting<Boolean>("HoleOnly", false));
    private final Setting<Boolean> Field798 = this.Method2150366(new Setting<Boolean>("HelpingBlocks", true));
    private final Setting<Boolean> Field799 = this.Method2150366(new Setting<Boolean>("Chat Msgs", true));
    private final Setting<Boolean> Field800 = this.Method2150366(new Setting<Boolean>("Packet", false));
    private final Setting<Integer> Field801 = this.Method2150366(new Setting<Integer>("Blocks/Tick", 2, 1, 8));
    private BlockPos Field802;
    private BlockPos Field803;
    private int Field804;
    private int Field805;
    private int Field806;
    private int Field807;

    public SelfAnvil() {
        super("SelfAnvil", "funne falling block", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    @Override
    public void Method2150372() {
        this.Field803 = new BlockPos(SelfAnvil.Field2811.player.posX, SelfAnvil.Field2811.player.posY, SelfAnvil.Field2811.player.posZ);
        this.Field802 = this.Field803.offset(EnumFacing.UP, 2);
        this.Field804 = this.Method2161295();
        this.Field805 = InventoryUtil.Method2163778(BlockObsidian.class);
        this.Field806 = SelfAnvil.Field2811.player.inventory.currentItem;
        if (!this.Method2161296()) {
            this.Method2150380();
        }
    }

    @Override
    public void Method2150376() {
        this.Field807 = 0;
        this.Method2161293();
    }

    private void Method2161293() {
        if (this.Field798.getValue().booleanValue() && BlockUtil.Method2162816(this.Field802, false, true) == 2) {
            InventoryUtil.Method2163773(this.Field805, false);
            this.Method2161294();
        }
        if (this.Field807 < this.Field801.getValue() && BlockUtil.Method2162816(this.Field802, false, true) == 3) {
            InventoryUtil.Method2163773(this.Field804, false);
            BlockUtil.Method2162810(this.Field802, EnumHand.MAIN_HAND, this.Field796.getValue(), this.Field800.getValue(), false);
            InventoryUtil.Method2163773(this.Field806, false);
            SelfAnvil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) SelfAnvil.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.Method2150380();
        }
    }

    private void Method2161294() {
        if (this.Field807 >= this.Field801.getValue()) {
            return;
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.DOWN || BlockUtil.Method2162816(this.Field802.offset(enumFacing), false, true) != 3)
                continue;
            BlockUtil.Method2162810(this.Field802.offset(enumFacing), EnumHand.MAIN_HAND, this.Field796.getValue(), this.Field800.getValue(), false);
            ++this.Field807;
            return;
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.DOWN) continue;
            for (EnumFacing enumFacing2 : EnumFacing.values()) {
                if (BlockUtil.Method2162816(this.Field802.offset(enumFacing).offset(enumFacing2), false, true) != 3)
                    continue;
                BlockUtil.Method2162810(this.Field802.offset(enumFacing).offset(enumFacing2), EnumHand.MAIN_HAND, this.Field796.getValue(), this.Field800.getValue(), false);
                ++this.Field807;
                return;
            }
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            for (EnumFacing enumFacing2 : EnumFacing.values()) {
                for (EnumFacing enumFacing3 : EnumFacing.values()) {
                    if (BlockUtil.Method2162816(this.Field802.offset(enumFacing).offset(enumFacing2).offset(enumFacing3), false, true) != 3)
                        continue;
                    BlockUtil.Method2162810(this.Field802.offset(enumFacing).offset(enumFacing2).offset(enumFacing3), EnumHand.MAIN_HAND, this.Field796.getValue(), this.Field800.getValue(), false);
                    ++this.Field807;
                    return;
                }
            }
        }
    }

    private int Method2161295() {
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = SelfAnvil.Field2811.player.inventory.getStackInSlot(j);
            if (!(itemStack.getItem() instanceof ItemBlock) || !((block = Block.getBlockFromItem((Item) SelfAnvil.Field2811.player.inventory.getStackInSlot(j).getItem())) instanceof BlockFalling))
                continue;
            return j;
        }
        return -1;
    }

    private boolean Method2161296() {
        int n2 = BlockUtil.Method2162816(this.Field802, false, true);
        if (SelfAnvil.Method2150359() || !SelfAnvil.Field2811.world.isAirBlock(this.Field803)) {
            return false;
        }
        if (!BlockUtil.Method2162861(this.Field803) && this.Field797.getValue().booleanValue()) {
            return false;
        }
        if (this.Field804 == -1) {
            if (this.Field799.getValue().booleanValue()) {
                Command.Method2159696("<" + this.Method2150392() + "> \u00a7cNo Anvils in hotbar.");
            }
            return false;
        }
        if (n2 == 2) {
            if (!this.Field798.getValue().booleanValue()) {
                if (this.Field799.getValue().booleanValue()) {
                    Command.Method2159696("<" + this.Method2150392() + "> \u00a7cNowhere to place.");
                }
                return false;
            }
            if (this.Field805 == -1) {
                if (this.Field799.getValue().booleanValue()) {
                    Command.Method2159696("<" + this.Method2150392() + "> \u00a7cNo Obsidian in hotbar.");
                }
                return false;
            }
        } else if (n2 != 3) {
            if (this.Field799.getValue().booleanValue()) {
                Command.Method2159696("<" + this.Method2150392() + "> \u00a7cNot enough room.");
            }
            return false;
        }
        return true;
    }
}

