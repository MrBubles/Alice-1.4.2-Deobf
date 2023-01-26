

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class HoleManager
        extends Feature {
    private static final BlockPos[] Field4231 = BlockUtil.Method2162830(EntityUtil2.Method2164440(0, true));
    private final List<BlockPos> Field4232 = new ArrayList<BlockPos>();
    private List<BlockPos> Field4233 = new ArrayList<BlockPos>();

    private static double Method2150183(BlockPos blockPos) {
        return HoleManager.Field2811.player.getDistanceSq(blockPos);
    }

    public void Method2150177() {
        if (!HoleManager.Method2150359()) {
            this.Field4233 = this.Method2150181();
        }
    }

    public List<BlockPos> Method2150178() {
        return this.Field4233;
    }

    public List<BlockPos> Method2150179() {
        return this.Field4232;
    }

    public List<BlockPos> Method2150170() {
        this.Field4233.sort(Comparator.comparingDouble(HoleManager::Method2150183));
        return this.Method2150178();
    }

    public List<BlockPos> Method2150181() {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        this.Field4232.clear();
        List<BlockPos> list = BlockUtil.Method2162829(EntityUtil.Method2163403((EntityPlayer) HoleManager.Field2811.player), 6.0f, 6, false, true, 0);
        for (BlockPos blockPos : list) {
            if (!HoleManager.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) || !HoleManager.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) || !HoleManager.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR))
                continue;
            boolean bl = true;
            boolean bl2 = true;
            for (BlockPos blockPos2 : Field4231) {
                Block block = HoleManager.Field2811.world.getBlockState(blockPos.add((Vec3i) blockPos2)).getBlock();
                if (BlockUtil.Method2162847(block)) {
                    bl2 = false;
                }
                if (block == Blocks.BEDROCK || block == Blocks.OBSIDIAN || block == Blocks.ENDER_CHEST || block == Blocks.ANVIL)
                    continue;
                bl = false;
            }
            if (bl) {
                arrayList.add(blockPos);
            }
            if (!bl2) continue;
            this.Field4232.add(blockPos);
        }
        return arrayList;
    }

    public boolean Method2150182(BlockPos blockPos) {
        boolean bl = true;
        for (BlockPos blockPos2 : Field4231) {
            Block block = HoleManager.Field2811.world.getBlockState(blockPos.add((Vec3i) blockPos2)).getBlock();
            if (block == Blocks.BEDROCK) {
                continue;
            }
            bl = false;
            break;
        }
        return bl;
    }
}

