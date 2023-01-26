

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.IBlockAccess
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;

public class BlockUtilsCr {
    protected static Minecraft Field3389 = Minecraft.getMinecraft();
    public BlockPos Field3390;
    public double Field3391;
    public double Field3392;
    public double Field3393;
    public EnumFacing Field3394;
    public int Field3395;

    public BlockUtilsCr(BlockPos blockPos, int n2, EnumFacing enumFacing, double d) {
        this.Field3390 = blockPos;
        this.Field3395 = n2;
        this.Field3394 = enumFacing;
        this.Field3393 = d;
    }

    public static boolean Method2164190(BlockPos blockPos) {
        Block block = BlockUtilsCr.Field3389.world.getBlockState(blockPos).getBlock();
        return block.isReplaceable((IBlockAccess) BlockUtilsCr.Field3389.world, blockPos) && !(block instanceof BlockAir);
    }

    public static double Method2164101(double d, double d2) {
        double d3;
        if (d2 == 0.0) {
            d3 = d > 0.0 ? 90.0 : -90.0;
        } else {
            d3 = Math.atan(d / d2) * 57.2957796;
            if (d2 < 0.0) {
                d3 = d > 0.0 ? (d3 = d3 + 180.0) : (d < 0.0 ? (d3 = d3 - 180.0) : 180.0);
            }
        }
        return d3;
    }

    public static boolean Method2164102(BlockUtilsCr blockUtilsCr, boolean bl) {
        if (blockUtilsCr == null) {
            return false;
        }
        return blockUtilsCr.Method2164107(bl);
    }

    public static BlockUtilsCr Method2164103(BlockPos blockPos, double d, boolean bl) {
        BlockUtilsCr blockUtilsCr = new BlockUtilsCr(blockPos, 0, null, d);
        if (!BlockUtilsCr.Method2164104(blockPos)) {
            return null;
        }
        if (!(BlockUtilsCr.Field3389.player.inventory.getCurrentItem().getItem() instanceof ItemBlock)) {
            return null;
        }
        AxisAlignedBB axisAlignedBB = ((ItemBlock) BlockUtilsCr.Field3389.player.inventory.getCurrentItem().getItem()).getBlock().getDefaultState().getCollisionBoundingBox((IBlockAccess) BlockUtilsCr.Field3389.world, blockPos);
        if (!BlockUtilsCr.Method2164104(blockPos) && BlockUtilsCr.Field3389.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid) {
            Block block = BlockUtilsCr.Field3389.world.getBlockState(blockPos.offset(EnumFacing.UP)).getBlock();
            if (block instanceof BlockLiquid) {
                blockUtilsCr.Field3394 = EnumFacing.DOWN;
                blockUtilsCr.Field3390.offset(EnumFacing.UP);
                return blockUtilsCr;
            }
            blockUtilsCr.Field3394 = EnumFacing.UP;
            blockUtilsCr.Field3390.offset(EnumFacing.DOWN);
            return blockUtilsCr;
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (BlockUtilsCr.Method2164104(new BlockPos(blockPos.getX() - enumFacing.getDirectionVec().getX(), blockPos.getY() - enumFacing.getDirectionVec().getY(), blockPos.getZ() - enumFacing.getDirectionVec().getZ()))) {
                continue;
            }
            blockUtilsCr.Field3394 = enumFacing;
            if (bl && axisAlignedBB != Block.NULL_AABB && !BlockUtilsCr.Field3389.world.checkNoEntityCollision(axisAlignedBB.offset(blockPos), null)) {
                return null;
            }
            return blockUtilsCr;
        }
        if (BlockUtilsCr.Method2164190(blockPos)) {
            blockUtilsCr.Field3394 = EnumFacing.UP;
            blockUtilsCr.Field3390.offset(EnumFacing.UP);
            blockPos.offset(EnumFacing.DOWN);
            if (bl && axisAlignedBB != Block.NULL_AABB && !BlockUtilsCr.Field3389.world.checkNoEntityCollision(axisAlignedBB.offset(blockPos), null)) {
                return null;
            }
            return blockUtilsCr;
        }
        return null;
    }

    public static boolean Method2164104(BlockPos blockPos) {
        Block block = BlockUtilsCr.Field3389.world.getBlockState(blockPos).getBlock();
        return block instanceof BlockAir;
    }

    public static boolean Method2164105(BlockPos blockPos, EnumFacing enumFacing) {
        return BlockUtilsCr.Field3389.playerController.clickBlock(blockPos, enumFacing);
    }

    public void Method2164106() {
        BlockUtilsCr.Field3389.playerController.onPlayerDamageBlock(new BlockPos(this.Field3390.getX() - this.Field3394.getDirectionVec().getX(), this.Field3390.getY() - this.Field3394.getDirectionVec().getY(), this.Field3390.getZ() - this.Field3394.getDirectionVec().getZ()), this.Field3394);
    }

    public boolean Method2164107(boolean bl) {
        double d = (double) this.Field3390.getX() + 0.5 - BlockUtilsCr.Field3389.player.posX - (double) this.Field3394.getDirectionVec().getX() / 2.0;
        double d2 = (double) this.Field3390.getY() + 0.5 - BlockUtilsCr.Field3389.player.posY - (double) this.Field3394.getDirectionVec().getY() / 2.0 - (double) BlockUtilsCr.Field3389.player.getEyeHeight();
        double d3 = (double) this.Field3390.getZ() + 0.5 - BlockUtilsCr.Field3389.player.posZ - (double) this.Field3394.getDirectionVec().getZ() / 2.0;
        double d4 = BlockUtilsCr.Method2164101(d3, d);
        double d5 = BlockUtilsCr.Method2164101(d2, Math.sqrt(d * d + d3 * d3));
        Vec3d vec3d = this.Method2164109(-d5, d4 - 90.0);
        this.Field3392 = -d5;
        this.Field3391 = d4 - 90.0;
        EnumActionResult enumActionResult = BlockUtilsCr.Field3389.playerController.processRightClickBlock(BlockUtilsCr.Field3389.player, BlockUtilsCr.Field3389.world, new BlockPos(this.Field3390.getX() - this.Field3394.getDirectionVec().getX(), this.Field3390.getY() - this.Field3394.getDirectionVec().getY(), this.Field3390.getZ() - this.Field3394.getDirectionVec().getZ()), this.Field3394, vec3d, EnumHand.MAIN_HAND);
        if (enumActionResult == EnumActionResult.SUCCESS) {
            if (bl) {
                BlockUtilsCr.Field3389.player.swingArm(EnumHand.MAIN_HAND);
            }
            return true;
        }
        return false;
    }

    protected final Vec3d Method2164108(float f, float f2) {
        float f3 = MathHelper.cos((float) (-f2 * ((float) Math.PI / 180) - (float) Math.PI));
        float f4 = MathHelper.sin((float) (-f2 * ((float) Math.PI / 180) - (float) Math.PI));
        float f5 = -MathHelper.cos((float) (-f * ((float) Math.PI / 180)));
        float f6 = MathHelper.sin((float) (-f * ((float) Math.PI / 180)));
        return new Vec3d((double) (f4 * f5), (double) f6, (double) (f3 * f5));
    }

    protected final Vec3d Method2164109(double d, double d2) {
        float f = MathHelper.cos((float) ((float) (-d2 * 0.01745329238474369 - 3.1415927410125732)));
        float f2 = MathHelper.sin((float) ((float) (-d2 * 0.01745329238474369 - 3.1415927410125732)));
        float f3 = -MathHelper.cos((float) ((float) (-d * 0.01745329238474369)));
        float f4 = MathHelper.sin((float) ((float) (-d * 0.01745329238474369)));
        return new Vec3d((double) (f2 * f3), (double) f4, (double) (f * f3));
    }
}

