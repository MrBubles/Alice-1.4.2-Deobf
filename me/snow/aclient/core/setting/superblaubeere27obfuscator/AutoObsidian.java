

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Comparator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoObsidian
        extends Module {
    private final Setting<Integer> Field3315 = this.Method2150366(new Setting<Integer>("Range", 2, 1, 3));
    private Timer Field3316 = new Timer();
    private Timer Field3317 = new Timer();
    private InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field3318 = null;
    private BlockPos Field3319;

    public AutoObsidian() {
        super("AutoObsidian", "Automatically placed EChests and mines them", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    private static Double Method2161816(BlockPos blockPos) {
        return AutoObsidian.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5);
    }

    private static boolean Method2161817(BlockPos blockPos) {
        return AutoObsidian.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockEnderChest;
    }

    @Override
    public void Method2150372() {
        this.Field3318 = null;
        this.Field3317.Method2164750();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field3319 != null) {
            Color color = new Color(40, 200, 40, 0);
            RenderUtil.Method2163908(this.Field3319, color, false, color, 1.5f, true, true, 120, false);
        }
    }

    @SubscribeEvent
    public void Method2161813(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            this.Field3318 = null;
            if (updateWalkingPlayerEvent.isCanceled() || !InteractionUtil.Method2163748()) {
                return;
            }
            this.Field3319 = AliceAura.Method2150785(new BlockPos((Entity) AutoObsidian.Field2811.player), this.Field3315.getValue().intValue(), this.Field3315.getValue(), false, true, 0).stream().filter(AutoObsidian::Method2161817).min(Comparator.comparing(AutoObsidian::Method2161816)).orElse(null);
            if (this.Field3319 != null) {
                if (this.Field3317.Method2164755(4000L)) {
                    boolean bl;
                    boolean bl2 = bl = AutoObsidian.Field2811.player.getHeldItemMainhand().getItem() == Items.DIAMOND_PICKAXE;
                    if (!bl) {
                        for (int j = 0; j < 9; ++j) {
                            ItemStack itemStack = AutoObsidian.Field2811.player.inventory.getStackInSlot(j);
                            if (itemStack.isEmpty() || itemStack.getItem() != Items.DIAMOND_PICKAXE) continue;
                            bl = true;
                            AutoObsidian.Field2811.player.inventory.currentItem = j;
                            AutoObsidian.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(j));
                            break;
                        }
                    }
                    if (!bl) {
                        return;
                    }
                    EnumFacing enumFacing = AutoObsidian.Field2811.player.getHorizontalFacing().getOpposite();
                    BlockUtil.Method2162822((double) this.Field3319.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) this.Field3319.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) this.Field3319.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                    AutoObsidian.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                    AutoObsidian.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field3319, enumFacing));
                    AutoObsidian.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.Field3319, enumFacing));
                    this.Field3317.Method2164750();
                }
            } else if (this.Field3316.Method2164755(350L)) {
                Object object;
                this.Field3316.Method2164750();
                if (AutoObsidian.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemBlock ? (object = (ItemBlock) AutoObsidian.Field2811.player.getHeldItemMainhand().getItem()).getBlock() != Blocks.ENDER_CHEST && !this.Method2161815() : !this.Method2161815()) {
                    return;
                }
                for (BlockPos blockPos : AliceAura.Method2150785(new BlockPos((Entity) AutoObsidian.Field2811.player), this.Field3315.getValue().intValue(), this.Field3315.getValue(), false, true, 0)) {
                    InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163749(blockPos, true);
                    if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll == null)
                        continue;
                    this.Field3318 = iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161814(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1 && this.Field3318 != null) {
            InteractionUtil.Method2163754(this.Field3318, EnumHand.MAIN_HAND, false);
            this.Field3317.Method2164750();
        }
    }

    private boolean Method2161815() {
        for (int j = 0; j < 9; ++j) {
            ItemBlock itemBlock;
            ItemStack itemStack = AutoObsidian.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack.isEmpty() || !(itemStack.getItem() instanceof ItemBlock) || (itemBlock = (ItemBlock) itemStack.getItem()).getBlock() != Blocks.ENDER_CHEST)
                continue;
            AutoObsidian.Field2811.player.inventory.currentItem = j;
            AutoObsidian.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(j));
            return true;
        }
        return false;
    }
}

