

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockSnow
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class BlockUtilCa
        implements Util {
    public static List<Block> Field2731 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE});
    public static List<Block> Field2732 = Arrays.asList(new Block[]{Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.ANVIL, Blocks.WOODEN_BUTTON, Blocks.STONE_BUTTON, Blocks.UNPOWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.POWERED_COMPARATOR, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.JUKEBOX, Blocks.BEACON, Blocks.BED, Blocks.FURNACE, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CAKE, Blocks.ENCHANTING_TABLE, Blocks.DRAGON_EGG, Blocks.HOPPER, Blocks.REPEATING_COMMAND_BLOCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.CRAFTING_TABLE});

    public static EnumFacing Method2162039(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!BlockUtilCa.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(BlockUtilCa.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = BlockUtilCa.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static Vec3d[] Method2162030(Vec3d vec3d) {
        return new Vec3d[]{new Vec3d(vec3d.x, vec3d.y - 1.0, vec3d.z), new Vec3d(vec3d.x != 0.0 ? vec3d.x * 2.0 : vec3d.x, vec3d.y, vec3d.x != 0.0 ? vec3d.z : vec3d.z * 2.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x + 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z + 1.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x - 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z - 1.0), new Vec3d(vec3d.x, vec3d.y + 1.0, vec3d.z)};
    }

    public static List<BlockPos> Method2162041(BlockPos blockPos, int n2, float f, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getZ();
        int n5 = n3 - (int) f;
        while ((float) n5 <= (float) n3 + f) {
            int n6 = n4 - (int) f;
            while ((float) n6 <= (float) n4 + f) {
                double d = (n3 - n5) * (n3 - n5) + (n4 - n6) * (n4 - n6);
                if (d < (double) (f * f) && (!bl || d >= (double) ((f - 1.0f) * (f - 1.0f)))) {
                    BlockPos blockPos2 = new BlockPos(n5, n2, n6);
                    arrayList.add(blockPos2);
                }
                ++n6;
            }
            ++n5;
        }
        return arrayList;
    }

    private static boolean Method2162042(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (BlockUtilCa.Field2811.world.getBlockState(blockPos2).getMaterial().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static boolean Method2162043(BlockPos blockPos) {
        if (!BlockUtilCa.Method2162042(blockPos)) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (!BlockUtilCa.Method2162042(blockPos2)) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2162044(BlockPos blockPos) {
        if (!BlockUtilCa.Field2811.world.checkNoEntityCollision(new AxisAlignedBB(blockPos))) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoEntityCollision;
        }
        if (!BlockUtilCa.Method2162043(blockPos)) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoNeighbors;
        }
        IBlockState iBlockState = BlockUtilCa.Field2811.world.getBlockState(blockPos);
        if (iBlockState.getBlock() == Blocks.AIR) {
            BlockPos[] arrblockPos;
            for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.up(), blockPos.down()}) {
                IBlockState iBlockState2 = BlockUtilCa.Field2811.world.getBlockState(blockPos2);
                if (iBlockState2.getBlock() == Blocks.AIR) continue;
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    BlockPos blockPos3 = blockPos.offset(enumFacing);
                    if (!BlockUtilCa.Field2811.world.getBlockState(blockPos3).getBlock().canCollideCheck(BlockUtilCa.Field2811.world.getBlockState(blockPos3), false))
                        continue;
                    return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Ok;
                }
            }
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoNeighbors;
        }
        return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AlreadyBlockThere;
    }

    public static boolean Method2162045(BlockPos blockPos, boolean bl, float f) {
        return !bl || BlockUtilCa.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtilCa.Field2811.player.posX, BlockUtilCa.Field2811.player.posY + (double) BlockUtilCa.Field2811.player.getEyeHeight(), BlockUtilCa.Field2811.player.posZ), new Vec3d((double) blockPos.getX(), (double) ((float) blockPos.getY() + f), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static void Method2162046(BlockPos blockPos, EnumHand enumHand, boolean bl) {
        RayTraceResult rayTraceResult = BlockUtilCa.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtilCa.Field2811.player.posX, BlockUtilCa.Field2811.player.posY + (double) BlockUtilCa.Field2811.player.getEyeHeight(), BlockUtilCa.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
        if (bl) {
            BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(enumHand));
        }
    }

    public static boolean Method2162047(BlockPos blockPos) {
        for (Entity entity : BlockUtilCa.Field2811.world.loadedEntityList) {
            if (entity.equals((Object) BlockUtilCa.Field2811.player) || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    public static boolean Method2162048(BlockPos blockPos) {
        Block block = BlockUtilCa.Field2811.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockLiquid) && block.getMaterial(null) != Material.AIR;
    }

    public static boolean Method2162049(BlockPos blockPos) {
        return BlockUtilCa.Field2811.world.isAirBlock(blockPos) || BlockUtilCa.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.SNOW_LAYER || BlockUtilCa.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.TALLGRASS || BlockUtilCa.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid;
    }

    public static boolean Method2162040(BlockPos blockPos) {
        IBlockState iBlockState = BlockUtilCa.Field2811.world.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getBlockHardness(iBlockState, (World) BlockUtilCa.Field2811.world, blockPos) != -1.0f;
    }

    public static int Method2162051(BlockPos blockPos, boolean bl) {
        return BlockUtilCa.Method2162052(blockPos, bl, true);
    }

    public static int Method2162052(BlockPos blockPos, boolean bl, boolean bl2) {
        Block block = BlockUtilCa.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
            return 0;
        }
        if (!BlockUtilCa.Method2162045(blockPos, bl, 0.0f)) {
            return -1;
        }
        if (bl2) {
            for (EnumFacing enumFacing : BlockUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (enumFacing instanceof EntityItem || enumFacing instanceof EntityXPOrb) continue;
                return 1;
            }
        }
        for (EnumFacing enumFacing : BlockUtilCa.Method2162057(blockPos)) {
            if (!BlockUtilCa.Method2162053(blockPos.offset(enumFacing))) continue;
            return 3;
        }
        return 2;
    }

    public static boolean Method2162053(BlockPos blockPos) {
        return BlockUtilCa.Method2162054(blockPos).canCollideCheck(BlockUtilCa.Method2162055(blockPos), false);
    }

    private static Block Method2162054(BlockPos blockPos) {
        return BlockUtilCa.Method2162055(blockPos).getBlock();
    }

    private static IBlockState Method2162055(BlockPos blockPos) {
        return BlockUtilCa.Field2811.world.getBlockState(blockPos);
    }

    public static boolean Method2162056(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        EnumFacing enumFacing = BlockUtilCa.Method2162058(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        if (!BlockUtilCa.Field2811.player.isSneaking()) {
            BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtilCa.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtilCa.Field2811.player.setSneaking(true);
        }
        if (bl) {
            BlockUtilCa.Method2162061(vec3d, true);
        }
        BlockUtilCa.Method2162062(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtilCa.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtilCa.Field2811.rightClickDelayTimer = 4;
        return true;
    }

    public static List<EnumFacing> Method2162057(BlockPos blockPos) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (BlockUtilCa.Field2811.world.getBlockState(blockPos2) == null) {
                return arrayList;
            }
            if (BlockUtilCa.Field2811.world.getBlockState(blockPos2).getBlock() == null) {
                return arrayList;
            }
            if (!BlockUtilCa.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(BlockUtilCa.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = BlockUtilCa.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    public static EnumFacing Method2162058(BlockPos blockPos) {
        Iterator<EnumFacing> iterator = BlockUtilCa.Method2162057(blockPos).iterator();
        if (iterator.hasNext()) {
            EnumFacing enumFacing = iterator.next();
            return enumFacing;
        }
        return null;
    }

    public static Vec3d Method2162059() {
        return new Vec3d(BlockUtilCa.Field2811.player.posX, BlockUtilCa.Field2811.player.posY + (double) BlockUtilCa.Field2811.player.getEyeHeight(), BlockUtilCa.Field2811.player.posZ);
    }

    public static float[] Method2162050(Vec3d vec3d) {
        Vec3d vec3d2 = BlockUtilCa.Method2162059();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{BlockUtilCa.Field2811.player.rotationYaw + MathHelper.wrapDegrees((float) (f - BlockUtilCa.Field2811.player.rotationYaw)), BlockUtilCa.Field2811.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - BlockUtilCa.Field2811.player.rotationPitch))};
    }

    public static void Method2162061(Vec3d vec3d, boolean bl) {
        float[] arrf = BlockUtilCa.Method2162050(vec3d);
        BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], bl ? (float) MathHelper.normalizeAngle((int) ((int) arrf[1]), (int) 360) : arrf[1], BlockUtilCa.Field2811.player.onGround));
    }

    public static void Method2162062(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl) {
        if (bl) {
            float f = (float) (vec3d.x - (double) blockPos.getX());
            float f2 = (float) (vec3d.y - (double) blockPos.getY());
            float f3 = (float) (vec3d.z - (double) blockPos.getZ());
            BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            BlockUtilCa.Field2811.playerController.processRightClickBlock(BlockUtilCa.Field2811.player, BlockUtilCa.Field2811.world, blockPos, enumFacing, vec3d, enumHand);
        }
    }

    public static boolean Method2162063(BlockPos blockPos, int n2, boolean bl, boolean bl2) {
        if (BlockUtilCa.Method2162064(blockPos)) {
            EnumFacing[] arrenumFacing;
            int n3 = -1;
            if (n2 != BlockUtilCa.Field2811.player.inventory.currentItem) {
                n3 = BlockUtilCa.Field2811.player.inventory.currentItem;
                BlockUtilCa.Field2811.player.inventory.currentItem = n2;
            }
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                Block block = BlockUtilCa.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (Field2731.contains((Object) block) || !(BlockUtilCa.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                float[] arrf = new float[]{BlockUtilCa.Field2811.player.rotationYaw, BlockUtilCa.Field2811.player.rotationPitch};
                if (bl) {
                    BlockUtilCa.Method2162066(vec3d.x, vec3d.y, vec3d.z);
                }
                if (Field2732.contains((Object) block)) {
                    BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtilCa.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                BlockUtilCa.Field2811.playerController.processRightClickBlock(BlockUtilCa.Field2811.player, BlockUtilCa.Field2811.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
                if (Field2732.contains((Object) block)) {
                    BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtilCa.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                if (bl2) {
                    BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], BlockUtilCa.Field2811.player.onGround));
                }
                if (n3 != -1) {
                    BlockUtilCa.Field2811.player.inventory.currentItem = n3;
                }
                return true;
            }
            if (n3 != -1) {
                BlockUtilCa.Field2811.player.inventory.currentItem = n3;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Method2162064(BlockPos blockPos) {
        try {
            Entity entity;
            if (!Field2731.contains((Object) BlockUtilCa.Field2811.world.getBlockState(blockPos).getBlock()))
                return false;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
            Iterator iterator = BlockUtilCa.Field2811.world.loadedEntityList.iterator();
            do {
                if (iterator.hasNext()) continue;
                return true;
            } while (!((entity = (Entity) iterator.next()) instanceof EntityLivingBase) || !axisAlignedBB.intersects(entity.getEntityBoundingBox()));
            return false;
        } catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public static boolean Method2162065(BlockPos blockPos) {
        if (BlockUtilCa.Method2162064(blockPos)) {
            EnumFacing[] arrenumFacing;
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                if (Field2731.contains((Object) BlockUtilCa.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock()))
                    continue;
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (!(BlockUtilCa.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                return true;
            }
        }
        return false;
    }

    public static void Method2162066(double d, double d2, double d3) {
        double d4 = d - BlockUtilCa.Field2811.player.posX;
        double d5 = d2 - (BlockUtilCa.Field2811.player.posY + (double) BlockUtilCa.Field2811.player.getEyeHeight());
        double d6 = d3 - BlockUtilCa.Field2811.player.posZ;
        double d7 = Math.sqrt(d4 * d4 + d6 * d6);
        float f = (float) Math.toDegrees(Math.atan2(d6, d4)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d5, d7)));
        BlockUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(f, f2, BlockUtilCa.Field2811.player.onGround));
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NoEntityCollision,
        AlreadyBlockThere,
        NoNeighbors,
        Ok;

    }
}

