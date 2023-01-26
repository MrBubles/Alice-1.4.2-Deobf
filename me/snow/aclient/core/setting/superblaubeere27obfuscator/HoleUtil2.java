

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class HoleUtil2
        implements Util {
    public static boolean Method2162462(BlockPos blockPos) {
        boolean bl = false;
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up()).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up().up()).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.BEDROCK) && HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.BEDROCK) && HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.BEDROCK) && HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.BEDROCK) && HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.BEDROCK)) {
            bl = true;
        }
        return bl;
    }

    public static boolean Method2162463(BlockPos blockPos) {
        boolean bl = false;
        int n2 = 0;
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up()).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up().up()).getBlock().equals((Object) Blocks.AIR) && (HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.OBSIDIAN))) {
            if (HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                ++n2;
            }
            if (HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                if (HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                    ++n2;
                }
                if (HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                    if (HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                        ++n2;
                    }
                    if (HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                        if (HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                            ++n2;
                        }
                        if (HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                            if (HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                                ++n2;
                            }
                            if (n2 >= 1) {
                                bl = true;
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    public static boolean Method2162464(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            int n2;
            int n3 = enumFacing.getXOffset();
            if (HoleUtil2.Field2811.world.getBlockState(blockPos.add(n3, 0, n2 = enumFacing.getZOffset())).getBlock() != Blocks.OBSIDIAN && HoleUtil2.Field2811.world.getBlockState(blockPos.add(n3, 0, n2)).getBlock() != Blocks.BEDROCK || HoleUtil2.Field2811.world.getBlockState(blockPos.add(n3 * -2, 0, n2 * -2)).getBlock() != Blocks.OBSIDIAN && HoleUtil2.Field2811.world.getBlockState(blockPos.add(n3 * -2, 0, n2 * -2)).getBlock() != Blocks.BEDROCK || HoleUtil2.Field2811.world.getBlockState(blockPos.add(n3 * -1, 0, n2 * -1)).getBlock() != Blocks.AIR || !HoleUtil2.Method2162467(blockPos.add(0, -1, 0)) || !HoleUtil2.Method2162467(blockPos.add(n3 * -1, -1, n2 * -1)))
                continue;
            if (n2 == 0 && HoleUtil2.Method2162467(blockPos.add(0, 0, 1)) && HoleUtil2.Method2162467(blockPos.add(0, 0, -1)) && HoleUtil2.Method2162467(blockPos.add(n3 * -1, 0, 1)) && HoleUtil2.Method2162467(blockPos.add(n3 * -1, 0, -1))) {
                return true;
            }
            if (n3 != 0 || !HoleUtil2.Method2162467(blockPos.add(1, 0, 0)) || !HoleUtil2.Method2162467(blockPos.add(-1, 0, 0)) || !HoleUtil2.Method2162467(blockPos.add(1, 0, n2 * -1)) || !HoleUtil2.Method2162467(blockPos.add(-1, 0, n2 * -1)))
                continue;
            return true;
        }
        return false;
    }

    public static boolean Method2162465(BlockPos blockPos) {
        boolean bl = false;
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up()).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up().up()).getBlock().equals((Object) Blocks.AIR) && (HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.OBSIDIAN))) {
            if (!HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.BEDROCK) && !HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                return bl;
            }
            if ((HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.OBSIDIAN)) && (HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.OBSIDIAN)) && (HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.OBSIDIAN))) {
                bl = true;
            }
        }
        return bl;
    }

    public static boolean Method2162466() {
        boolean bl = false;
        BlockPos blockPos = new BlockPos(HoleUtil2.Field2811.player.posX, HoleUtil2.Field2811.player.posY, HoleUtil2.Field2811.player.posZ);
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.up()).getBlock().equals((Object) Blocks.AIR) && (HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock().equals((Object) Blocks.OBSIDIAN))) {
            if (!HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.BEDROCK) && !HoleUtil2.Field2811.world.getBlockState(blockPos.east()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                return bl;
            }
            if (HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.west()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                if (!HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.BEDROCK) && !HoleUtil2.Field2811.world.getBlockState(blockPos.south()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                    return bl;
                }
                if (HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.BEDROCK) || HoleUtil2.Field2811.world.getBlockState(blockPos.north()).getBlock().equals((Object) Blocks.OBSIDIAN)) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public static boolean Method2162467(BlockPos blockPos) {
        return HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK;
    }

    public static Vec3d Method2162468(double d, double d2, double d3) {
        return new Vec3d(Math.floor(d) + Double.longBitsToDouble(Double.doubleToLongBits(2.483631649651979) ^ 0x7FE3DE7A453486B7L), Math.floor(d2), Math.floor(d3) + Double.longBitsToDouble(Double.doubleToLongBits(3.847580551695734) ^ 0x7FEEC7D84FF2120EL));
    }

    public static boolean Method2162469(BlockPos blockPos) {
        if (!HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) || !HoleUtil2.Field2811.world.getBlockState(blockPos.add(1, 0, 0)).getBlock().equals((Object) Blocks.AIR) || !HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) && !HoleUtil2.Field2811.world.getBlockState(blockPos.add(1, 1, 0)).getBlock().equals((Object) Blocks.AIR) || !HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR) && !HoleUtil2.Field2811.world.getBlockState(blockPos.add(1, 2, 0)).getBlock().equals((Object) Blocks.AIR)) {
            return false;
        }
        for (BlockPos blockPos2 : new BlockPos[]{blockPos.add(2, 0, 0), blockPos.add(1, 0, 1), blockPos.add(1, 0, -1), blockPos.add(-1, 0, 0), blockPos.add(0, 0, 1), blockPos.add(0, 0, -1), blockPos.add(0, -1, 0), blockPos.add(1, -1, 0)}) {
            IBlockState iBlockState = HoleUtil2.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2162460(BlockPos blockPos) {
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 0, 1)).getBlock().equals((Object) Blocks.AIR)) {
            if (!HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) && !HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 1, 1)).getBlock().equals((Object) Blocks.AIR)) {
                return false;
            }
            if (HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR) || HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 2, 1)).getBlock().equals((Object) Blocks.AIR)) {
                for (BlockPos blockPos2 : new BlockPos[]{blockPos.add(0, 0, 2), blockPos.add(1, 0, 1), blockPos.add(-1, 0, 1), blockPos.add(0, 0, -1), blockPos.add(1, 0, 0), blockPos.add(-1, 0, 0), blockPos.add(0, -1, 0), blockPos.add(0, -1, 1)}) {
                    IBlockState iBlockState = HoleUtil2.Field2811.world.getBlockState(blockPos2);
                    if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) {
                        continue;
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean Method2162471(BlockPos blockPos) {
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.add(1, 0, 0)).getBlock().equals((Object) Blocks.AIR)) {
            if (!HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) && !HoleUtil2.Field2811.world.getBlockState(blockPos.add(1, 1, 0)).getBlock().equals((Object) Blocks.AIR)) {
                return false;
            }
            if (HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR) || HoleUtil2.Field2811.world.getBlockState(blockPos.add(1, 2, 0)).getBlock().equals((Object) Blocks.AIR)) {
                for (BlockPos blockPos2 : new BlockPos[]{blockPos.add(2, 0, 0), blockPos.add(1, 0, 1), blockPos.add(1, 0, -1), blockPos.add(-1, 0, 0), blockPos.add(0, 0, 1), blockPos.add(0, 0, -1), blockPos.add(0, -1, 0), blockPos.add(1, -1, 0)}) {
                    if (BlockUtil.Method2162860(blockPos2) == BlockUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Resistant || BlockUtil.Method2162860(blockPos2) == BlockUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Unbreakable)
                        continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean Method2162472(BlockPos blockPos) {
        if (HoleUtil2.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.AIR) && HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 0, 1)).getBlock().equals((Object) Blocks.AIR) && (HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) || HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 1, 1)).getBlock().equals((Object) Blocks.AIR))) {
            if (!HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR) && !HoleUtil2.Field2811.world.getBlockState(blockPos.add(0, 2, 1)).getBlock().equals((Object) Blocks.AIR)) {
                return false;
            }
            for (BlockPos blockPos2 : new BlockPos[]{blockPos.add(0, 0, 2), blockPos.add(1, 0, 1), blockPos.add(-1, 0, 1), blockPos.add(0, 0, -1), blockPos.add(1, 0, 0), blockPos.add(-1, 0, 0), blockPos.add(0, -1, 0), blockPos.add(0, -1, 1)}) {
                if (BlockUtil.Method2162860(blockPos2) == BlockUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Resistant || BlockUtil.Method2162860(blockPos2) == BlockUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Unbreakable)
                    continue;
                return false;
            }
            return true;
        }
        return false;
    }
}

