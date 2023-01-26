

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class TestUtil1 {
    private static final Minecraft Field1060 = Minecraft.getMinecraft();
    public static List<Block> Field1061 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE});
    public static List<Block> Field1062 = Arrays.asList(new Block[]{Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.ANVIL, Blocks.WOODEN_BUTTON, Blocks.STONE_BUTTON, Blocks.UNPOWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.POWERED_COMPARATOR, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.JUKEBOX, Blocks.BEACON, Blocks.BED, Blocks.FURNACE, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CAKE, Blocks.ENCHANTING_TABLE, Blocks.DRAGON_EGG, Blocks.HOPPER, Blocks.REPEATING_COMMAND_BLOCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.CRAFTING_TABLE});

    public static boolean Method2164738(BlockPos blockPos) {
        return TestUtil1.Field1060.player != null && TestUtil1.Field1060.world.rayTraceBlocks(new Vec3d(TestUtil1.Field1060.player.posX, TestUtil1.Field1060.player.posY + (double) TestUtil1.Field1060.player.getEyeHeight(), TestUtil1.Field1060.player.posZ), new Vec3d((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static void Method2164739(BlockPos blockPos, EnumHand enumHand) {
        RayTraceResult rayTraceResult = TestUtil1.Field1060.world.rayTraceBlocks(new Vec3d(TestUtil1.Field1060.player.posX, TestUtil1.Field1060.player.posY + (double) TestUtil1.Field1060.player.getEyeHeight(), TestUtil1.Field1060.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        TestUtil1.Field1060.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
    }

    public static boolean Method2164730(BlockPos blockPos, boolean bl, float f) {
        return !bl || TestUtil1.Field1060.world.rayTraceBlocks(new Vec3d(TestUtil1.Field1060.player.posX, TestUtil1.Field1060.player.posY + (double) TestUtil1.Field1060.player.getEyeHeight(), TestUtil1.Field1060.player.posZ), new Vec3d((double) blockPos.getX(), (double) ((float) blockPos.getY() + f), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2164741(BlockPos blockPos, boolean bl) {
        return TestUtil1.Method2164730(blockPos, bl, 1.0f);
    }

    public static void Method2164742(BlockPos blockPos) {
        EnumFacing[] arrenumFacing;
        for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
            Block block = TestUtil1.Field1060.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
            if (!Field1061.contains((Object) block)) {
                continue;
            }
            TestUtil1.Field1060.playerController.processRightClickBlock(TestUtil1.Field1060.player, TestUtil1.Field1060.world, blockPos, enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
            return;
        }
    }

    public static boolean Method2164743(BlockPos blockPos) {
        if (TestUtil1.Method2164744(blockPos)) {
            EnumFacing[] arrenumFacing;
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                Block block = TestUtil1.Field1060.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (Field1061.contains((Object) block) || !(TestUtil1.Field1060.player.getPositionEyes(Field1060.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                float[] arrf = new float[]{TestUtil1.Field1060.player.rotationYaw, TestUtil1.Field1060.player.rotationPitch};
                if (Field1062.contains((Object) block)) {
                    TestUtil1.Field1060.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) TestUtil1.Field1060.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                TestUtil1.Field1060.playerController.processRightClickBlock(TestUtil1.Field1060.player, TestUtil1.Field1060.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
                if (Field1062.contains((Object) block)) {
                    TestUtil1.Field1060.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) TestUtil1.Field1060.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                TestUtil1.Field1060.player.swingArm(EnumHand.MAIN_HAND);
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Method2164744(BlockPos blockPos) {
        try {
            Entity entity;
            if (!Field1061.contains((Object) TestUtil1.Field1060.world.getBlockState(blockPos).getBlock()))
                return false;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
            Iterator iterator = TestUtil1.Field1060.world.loadedEntityList.iterator();
            do {
                if (!iterator.hasNext()) return true;
            } while (!((entity = (Entity) iterator.next()) instanceof EntityLivingBase) || !axisAlignedBB.intersects(entity.getEntityBoundingBox()));
            return false;
        } catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public static boolean Method2164745(BlockPos blockPos) {
        if (TestUtil1.Method2164744(blockPos)) {
            EnumFacing[] arrenumFacing;
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                if (Field1061.contains((Object) TestUtil1.Field1060.world.getBlockState(blockPos.offset(enumFacing)).getBlock()))
                    continue;
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (!(TestUtil1.Field1060.player.getPositionEyes(Field1060.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                return true;
            }
        }
        return false;
    }
}

