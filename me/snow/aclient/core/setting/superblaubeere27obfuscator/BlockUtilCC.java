

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class BlockUtilCC
        implements Util {
    public static final List<Block> Field2748 = Arrays.asList(new Block[]{Blocks.OBSIDIAN, Blocks.ANVIL, Blocks.ENCHANTING_TABLE, Blocks.ENDER_CHEST, Blocks.BEACON});
    public static final List<Block> Field2749 = Arrays.asList(new Block[]{Blocks.BEDROCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.END_PORTAL_FRAME, Blocks.BARRIER, Blocks.PORTAL});

    public static boolean Method2163265(BlockPos blockPos) {
        return !BlockUtilCC.Method2163267(blockPos).equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.UNBREAKABLE);
    }

    public static boolean Method2163266(BlockPos blockPos) {
        return BlockUtilCC.Field2811.world.getBlockState(blockPos).getMaterial().isReplaceable();
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163267(BlockPos blockPos) {
        Block block = BlockUtilCC.Field2811.world.getBlockState(blockPos).getBlock();
        if (block != null) {
            if (Field2748.contains((Object) block)) {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RESISTANT;
            }
            if (Field2749.contains((Object) block)) {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.UNBREAKABLE;
            }
            if (block.getDefaultState().getMaterial().isReplaceable()) {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.REPLACEABLE;
            }
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAKABLE;
        }
        return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE;
    }

    public static double Method2163268(EntityPlayer entityPlayer, BlockPos blockPos) {
        double d = (double) blockPos.getX() + 0.5 - entityPlayer.posX;
        double d2 = (double) blockPos.getY() + 0.5 - entityPlayer.posY;
        double d3 = (double) blockPos.getZ() + 0.5 - entityPlayer.posZ;
        return StrictMath.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    public static List<BlockPos> Method2163269(EntityPlayer entityPlayer, AxisAlignedBB axisAlignedBB) {
        if (entityPlayer != null) {
            ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
            for (double d = StrictMath.floor(axisAlignedBB.minX); d <= StrictMath.ceil(axisAlignedBB.maxX); d += 1.0) {
                for (double d2 = StrictMath.floor(axisAlignedBB.minY); d2 <= StrictMath.ceil(axisAlignedBB.maxY); d2 += 1.0) {
                    for (double d3 = StrictMath.floor(axisAlignedBB.minZ); d3 <= StrictMath.ceil(axisAlignedBB.maxZ); d3 += 1.0) {
                        BlockPos blockPos = entityPlayer.getPosition().add(d, d2, d3);
                        if (BlockUtilCC.Method2163268(entityPlayer, blockPos) >= axisAlignedBB.maxX) continue;
                        arrayList.add(blockPos);
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList<BlockPos>();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        REPLACEABLE,
        BREAKABLE,
        RESISTANT,
        UNBREAKABLE,
        NONE;

    }
}

