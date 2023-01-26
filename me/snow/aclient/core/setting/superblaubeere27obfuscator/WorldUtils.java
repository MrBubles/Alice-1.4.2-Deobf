

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.TestUtil1;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class WorldUtils
        implements Util {
    public static final ArrayList<Block> Field3919 = new ArrayList<Block>(Arrays.asList(new Block[]{Blocks.AIR, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE, Blocks.LAVA, Blocks.FLOWING_LAVA, Blocks.FLOWING_WATER, Blocks.WATER}));
    public static final List<Block> Field3920 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE});
    public static List<Block> Field3921 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE});

    public static Block Method2164792(BlockPos blockPos) {
        return WorldUtils.Field2811.world.getBlockState(blockPos).getBlock();
    }

    public static List<BlockPos> Method2164793(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n4 = blockPos.getX();
        int n5 = blockPos.getY();
        int n6 = blockPos.getZ();
        int n7 = n4 - (int) f;
        while ((float) n7 <= (float) n4 + f) {
            int n8 = n6 - (int) f;
            block1:
            while ((float) n8 <= (float) n6 + f) {
                int n9 = bl2 ? n5 - (int) f : n5;
                while (true) {
                    float f2;
                    float f3 = n9;
                    float f4 = f2 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    if (!(f3 < f2)) {
                        ++n8;
                        continue block1;
                    }
                    double d = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        arrayList.add(new BlockPos(n7, n9 + n3, n8));
                    }
                    ++n9;
                }
            }
            ++n7;
        }
        return arrayList;
    }

    public static EnumFacing Method2164794(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!WorldUtils.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(WorldUtils.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = WorldUtils.Field2811.world.getBlockState(blockPos2)).getBlock().getMaterial(iBlockState).isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static double Method2164795(Vec3d vec3d) {
        return WorldUtils.Field2811.player.getPositionVector().add(0.0, (double) WorldUtils.Field2811.player.eyeHeight, 0.0).distanceTo(vec3d);
    }

    public static EnumFacing Method2164796(boolean bl, BlockPos blockPos) {
        RayTraceResult rayTraceResult = WorldUtils.Field2811.world.rayTraceBlocks(new Vec3d(WorldUtils.Field2811.player.posX, WorldUtils.Field2811.player.posY + (double) WorldUtils.Field2811.player.getEyeHeight(), WorldUtils.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        if (blockPos.getY() == 255) {
            return EnumFacing.DOWN;
        }
        if (bl) {
            return rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        }
        return EnumFacing.UP;
    }

    public static boolean Method2164797(BlockPos blockPos) {
        return WorldUtils.Field2811.world.getBlockState(blockPos).getBlock().canCollideCheck(WorldUtils.Field2811.world.getBlockState(blockPos), false);
    }

    public static boolean Method2164798(double d, Vec3d vec3d, Vec3d vec3d2) {
        return vec3d.squareDistanceTo(vec3d2) <= d * d;
    }

    public static boolean Method2164799(double d, Vec3d vec3d, Vec3d vec3d2) {
        return vec3d.squareDistanceTo(vec3d2) > d * d;
    }

    public static void Method2164701(BlockPos blockPos, int n2) {
        if (n2 == -1) {
            return;
        }
        int n3 = WorldUtils.Field2811.player.inventory.currentItem;
        WorldUtils.Field2811.player.inventory.currentItem = n2;
        WorldUtils.Method2164703(blockPos);
        WorldUtils.Field2811.player.inventory.currentItem = n3;
    }

    public static void Method2164702(BlockPos blockPos) {
        EnumFacing[] arrenumFacing;
        for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
            Block block = WorldUtils.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
            if (!Field3921.contains((Object) block)) {
                continue;
            }
            WorldUtils.Field2811.playerController.processRightClickBlock(WorldUtils.Field2811.player, WorldUtils.Field2811.world, blockPos, enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
            return;
        }
    }

    public static boolean Method2164703(BlockPos blockPos) {
        if (TestUtil1.Method2164744(blockPos)) {
            EnumFacing[] arrenumFacing;
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                Block block = Util.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (Field3921.contains((Object) block) || !(Util.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                float[] arrf = new float[]{Util.Field2811.player.rotationYaw, Util.Field2811.player.rotationPitch};
                if (TestUtil1.Field1062.contains((Object) block)) {
                    Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                Util.Field2811.playerController.processRightClickBlock(Util.Field2811.player, Util.Field2811.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
                if (TestUtil1.Field1062.contains((Object) block)) {
                    Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                Util.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                return true;
            }
        }
        return false;
    }

    private boolean Method2164790(BlockPos blockPos) {
        boolean bl = WorldUtils.Field2811.player.isSneaking();
        Block block = WorldUtils.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockFire)) {
            return false;
        }
        EnumFacing enumFacing = WorldUtils.Method2164794(blockPos);
        if (enumFacing == null) {
            return false;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        if (!WorldUtils.Method2164797(blockPos2)) {
            return false;
        }
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block2 = WorldUtils.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!bl && Field3920.contains((Object) block2)) {
            WorldUtils.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) WorldUtils.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            bl = true;
        }
        WorldUtils.Field2811.playerController.processRightClickBlock(WorldUtils.Field2811.player, WorldUtils.Field2811.world, blockPos2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
        WorldUtils.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        return true;
    }
}

