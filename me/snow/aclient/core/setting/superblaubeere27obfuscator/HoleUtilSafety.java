

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class HoleUtilSafety
        implements Util {
    private static final Vec3i[] Field730 = new Vec3i[]{new Vec3i(0, 0, 0), new Vec3i(1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(1, 0, 1)};
    private static final Block[] Field731 = new Block[]{Blocks.BEDROCK, Blocks.OBSIDIAN, Blocks.ANVIL, Blocks.ENDER_CHEST};
    public static BlockPos[] Field729 = new BlockPos[]{new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(0, 0, -1), new BlockPos(0, -1, 0)};

    public static boolean Method2164480(BlockPos blockPos) {
        boolean bl = false;
        int n2 = 0;
        for (BlockPos blockPos2 : Field729) {
            if (HoleUtilSafety.Field2811.world.getBlockState(blockPos.add((Vec3i) blockPos2)).getMaterial().isReplaceable())
                continue;
            ++n2;
        }
        if (n2 == 5) {
            bl = true;
        }
        return bl;
    }

    public static boolean Method2164491(BlockPos blockPos) {
        boolean bl = true;
        int n2 = 0;
        for (BlockPos blockPos2 : Field729) {
            Block block = HoleUtilSafety.Field2811.world.getBlockState(blockPos.add((Vec3i) blockPos2)).getBlock();
            if (!HoleUtilSafety.Method2164495(blockPos.add((Vec3i) blockPos2))) {
                bl = false;
                continue;
            }
            if (block != Blocks.OBSIDIAN && block != Blocks.ENDER_CHEST && block != Blocks.ANVIL) continue;
            ++n2;
        }
        if (HoleUtilSafety.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock() != Blocks.AIR || HoleUtilSafety.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock() != Blocks.AIR) {
            bl = false;
        }
        if (n2 < 1) {
            bl = false;
        }
        return bl;
    }

    public static boolean Method2164492(BlockPos blockPos) {
        boolean bl = true;
        for (BlockPos blockPos2 : Field729) {
            Block block = HoleUtilSafety.Field2811.world.getBlockState(blockPos.add((Vec3i) blockPos2)).getBlock();
            if (block == Blocks.BEDROCK) continue;
            bl = false;
        }
        if (HoleUtilSafety.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock() != Blocks.AIR || HoleUtilSafety.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock() != Blocks.AIR) {
            bl = false;
        }
        return bl;
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2164493(BlockPos blockPos) {
        if (HoleUtilSafety.Method2164494(blockPos, 1, 0)) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(false, true, blockPos, blockPos.add(1, 0, 0));
        }
        if (HoleUtilSafety.Method2164494(blockPos, 0, 1)) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(false, true, blockPos, blockPos.add(0, 0, 1));
        }
        return null;
    }

    public static boolean Method2164494(BlockPos blockPos, int n2, int n3) {
        return HoleUtilSafety.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.AIR && HoleUtilSafety.Field2811.world.getBlockState(blockPos.add(n2, 0, n3)).getBlock() == Blocks.AIR && HoleUtilSafety.Method2164495(blockPos.add(0, -1, 0)) && HoleUtilSafety.Method2164495(blockPos.add(n2, -1, n3)) && HoleUtilSafety.Method2164495(blockPos.add(n2 * 2, 0, n3 * 2)) && HoleUtilSafety.Method2164495(blockPos.add(-n2, 0, -n3)) && HoleUtilSafety.Method2164495(blockPos.add(n3, 0, n2)) && HoleUtilSafety.Method2164495(blockPos.add(-n3, 0, -n2)) && HoleUtilSafety.Method2164495(blockPos.add(n2, 0, n3).add(n3, 0, n2)) && HoleUtilSafety.Method2164495(blockPos.add(n2, 0, n3).add(-n3, 0, -n2));
    }

    static boolean Method2164495(BlockPos blockPos) {
        return HoleUtilSafety.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || HoleUtilSafety.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || HoleUtilSafety.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.ENDER_CHEST;
    }

    public static List<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Method2164496(double d, BlockPos blockPos, boolean bl) {
        ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> arrayList = new ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>();
        List<BlockPos> list = HoleUtilSafety.Method2164497(d, blockPos, true, false);
        for (BlockPos blockPos2 : list) {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
            if (HoleUtilSafety.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) continue;
            if (HoleUtilSafety.Method2164491(blockPos2)) {
                arrayList.add(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(false, false, blockPos2));
                continue;
            }
            if (HoleUtilSafety.Method2164492(blockPos2)) {
                arrayList.add(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(true, false, blockPos2));
                continue;
            }
            if (!bl || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = HoleUtilSafety.Method2164493(blockPos2)) == null || HoleUtilSafety.Field2811.world.getBlockState(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field38.add(0, 1, 0)).getBlock() != Blocks.AIR && HoleUtilSafety.Field2811.world.getBlockState(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field39.add(0, 1, 0)).getBlock() != Blocks.AIR)
                continue;
            arrayList.add(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
        }
        return arrayList;
    }

    public static List<BlockPos> Method2164497(double d, BlockPos blockPos, boolean bl, boolean bl2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = n2 - (int) d;
        while ((double) n5 <= (double) n2 + d) {
            int n6 = n4 - (int) d;
            block1:
            while ((double) n6 <= (double) n4 + d) {
                int n7 = bl ? n3 - (int) d : n3;
                while (true) {
                    double d2 = n7;
                    double d3 = bl ? (double) n3 + d : (double) n3 + d;
                    double d4 = d3;
                    if (!(d2 < d3)) {
                        ++n6;
                        continue block1;
                    }
                    double d5 = (n2 - n5) * (n2 - n5) + (n4 - n6) * (n4 - n6) + (bl ? (n3 - n7) * (n3 - n7) : 0);
                    if (!(!(d5 < d * d) || bl2 && d5 < (d - 1.0) * (d - 1.0))) {
                        BlockPos blockPos2 = new BlockPos(n5, n7, n6);
                        arrayList.add(blockPos2);
                    }
                    ++n7;
                }
            }
            ++n5;
        }
        return arrayList;
    }

    public static boolean[] Method2164498(BlockPos blockPos, boolean bl) {
        boolean[] arrbl = new boolean[]{false, true};
        if (!BlockUtil.Method2162794(blockPos) || !BlockUtil.Method2162794(blockPos.up()) || bl && !BlockUtil.Method2162794(blockPos.up(2))) {
            return arrbl;
        }
        return HoleUtilSafety.Method2164490(blockPos, arrbl);
    }

    public static boolean[] Method2164499(BlockPos blockPos) {
        return HoleUtilSafety.Method2164490(blockPos, new boolean[]{false, true});
    }

    public static boolean[] Method2164490(BlockPos blockPos, boolean[] arrbl) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2;
            IBlockState iBlockState;
            if (enumFacing == EnumFacing.UP || (iBlockState = HoleUtilSafety.Field2811.world.getBlockState(blockPos2 = blockPos.offset(enumFacing))).getBlock() == Blocks.BEDROCK)
                continue;
            if (Arrays.stream(Field731).noneMatch(arg_0 -> HoleUtilSafety.Method2164408(iBlockState, arg_0))) {
                return arrbl;
            }
            arrbl[1] = false;
        }
        arrbl[0] = true;
        return arrbl;
    }

    public static boolean Method2164401(BlockPos blockPos) {
        return HoleUtilSafety.Method2164402(blockPos, true);
    }

    public static boolean Method2164402(BlockPos blockPos, boolean bl) {
        if (bl) {
            if (!BlockUtil.Method2162794(blockPos)) {
                return false;
            }
            if (!BlockUtil.Method2162794(blockPos.up())) {
                return false;
            }
            if (BlockUtil.Method2162794(blockPos.down())) {
                return false;
            }
        }
        int n2 = 0;
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (BlockUtil.Method2162794(blockPos2)) {
                if (!BlockUtil.Method2162794(blockPos2.up())) {
                    return false;
                }
                if (BlockUtil.Method2162794(blockPos2.down())) {
                    return false;
                }
                for (EnumFacing enumFacing2 : EnumFacing.HORIZONTALS) {
                    if (enumFacing2 == enumFacing.getOpposite()) continue;
                    IBlockState iBlockState = HoleUtilSafety.Field2811.world.getBlockState(blockPos2.offset(enumFacing2));
                    if (!Arrays.stream(Field731).noneMatch(arg_0 -> HoleUtilSafety.Method2164407(iBlockState, arg_0)))
                        continue;
                    return false;
                }
                ++n2;
            }
            if (n2 <= 0) {
                continue;
            }
            return false;
        }
        return n2 == 0;
    }

    public static boolean Method2164403(BlockPos blockPos) {
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        for (Vec3i arrenumFacing : Field730) {
            hashSet.add(blockPos.add(arrenumFacing));
        }
        boolean bl = false;
        for (BlockPos blockPos2 : hashSet) {
            if (BlockUtil.Method2162794(blockPos2) && BlockUtil.Method2162794(blockPos2.up()) && !BlockUtil.Method2162794(blockPos2.down())) {
                if (BlockUtil.Method2162794(blockPos2.up(2))) {
                    bl = true;
                }
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    BlockPos blockPos3 = blockPos2.offset(enumFacing);
                    if (hashSet.contains((Object) blockPos3)) continue;
                    IBlockState iBlockState = HoleUtilSafety.Field2811.world.getBlockState(blockPos3);
                    if (!Arrays.stream(Field731).noneMatch(arg_0 -> HoleUtilSafety.Method2164406(iBlockState, arg_0)))
                        continue;
                    return false;
                }
                continue;
            }
            return false;
        }
        return bl;
    }

    public static boolean Method2164404(BlockPos blockPos) {
        return HoleUtilSafety.Method2164405(blockPos, true);
    }

    public static boolean Method2164405(BlockPos blockPos, boolean bl) {
        if (bl && !BlockUtil.Method2162794(blockPos)) {
            return false;
        }
        if (HoleUtilSafety.Method2164403(blockPos)) {
            return true;
        }
        BlockPos blockPos2 = blockPos.add(-1, 0, 0);
        boolean bl2 = BlockUtil.Method2162794(blockPos2);
        if (bl2 && HoleUtilSafety.Method2164403(blockPos2)) {
            return true;
        }
        BlockPos blockPos3 = blockPos.add(0, 0, -1);
        boolean bl3 = BlockUtil.Method2162794(blockPos3);
        if (bl3 && HoleUtilSafety.Method2164403(blockPos3)) {
            return true;
        }
        return (bl2 || bl3) && HoleUtilSafety.Method2164403(blockPos.add(-1, 0, -1));
    }

    private static boolean Method2164406(IBlockState iBlockState, Block block) {
        return block == iBlockState.getBlock();
    }

    private static boolean Method2164407(IBlockState iBlockState, Block block) {
        return block == iBlockState.getBlock();
    }

    private static boolean Method2164408(IBlockState iBlockState, Block block) {
        return block == iBlockState.getBlock();
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public boolean Field36;
        public boolean Field37;
        public BlockPos Field38;
        public BlockPos Field39;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(boolean bl, boolean bl2, BlockPos blockPos, BlockPos blockPos2) {
            this.Field36 = bl;
            this.Field37 = bl2;
            this.Field38 = blockPos;
            this.Field39 = blockPos2;
        }

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(boolean bl, boolean bl2, BlockPos blockPos) {
            this.Field36 = bl;
            this.Field37 = bl2;
            this.Field38 = blockPos;
        }
    }
}

