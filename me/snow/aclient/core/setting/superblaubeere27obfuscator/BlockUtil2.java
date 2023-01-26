

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.util.concurrent.AtomicDouble
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.BlockSnow
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.DestroyBlockProgress
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.ReflectionHelper
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.util.concurrent.AtomicDouble;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TestUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class BlockUtil2
        implements Util {
    public static final List<Block> Field723 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE});
    public static final List<Block> Field724 = Arrays.asList(new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
    public static final List<Block> Field725 = Arrays.asList(new Block[]{Blocks.OBSIDIAN, Blocks.BEDROCK, Blocks.ENDER_CHEST, Blocks.ANVIL});
    public static List<Block> Field722 = Arrays.asList(new Block[]{Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.ANVIL, Blocks.WOODEN_BUTTON, Blocks.STONE_BUTTON, Blocks.UNPOWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.POWERED_COMPARATOR, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.JUKEBOX, Blocks.BEACON, Blocks.BED, Blocks.FURNACE, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CAKE, Blocks.ENCHANTING_TABLE, Blocks.DRAGON_EGG, Blocks.HOPPER, Blocks.REPEATING_COMMAND_BLOCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.CRAFTING_TABLE});
    public static List<Block> Field726 = Arrays.asList(new Block[]{Blocks.FLOWING_LAVA, Blocks.FLOWER_POT, Blocks.SNOW, Blocks.CARPET, Blocks.END_ROD, Blocks.SKULL, Blocks.FLOWER_POT, Blocks.TRIPWIRE, Blocks.TRIPWIRE_HOOK, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.STONE_BUTTON, Blocks.LADDER, Blocks.UNPOWERED_COMPARATOR, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.UNLIT_REDSTONE_TORCH, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WIRE, Blocks.AIR, Blocks.PORTAL, Blocks.END_PORTAL, Blocks.WATER, Blocks.FLOWING_WATER, Blocks.LAVA, Blocks.FLOWING_LAVA, Blocks.SAPLING, Blocks.RED_FLOWER, Blocks.YELLOW_FLOWER, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.REEDS, Blocks.PUMPKIN_STEM, Blocks.MELON_STEM, Blocks.WATERLILY, Blocks.NETHER_WART, Blocks.COCOA, Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT, Blocks.TALLGRASS, Blocks.DEADBUSH, Blocks.VINE, Blocks.FIRE, Blocks.RAIL, Blocks.ACTIVATOR_RAIL, Blocks.DETECTOR_RAIL, Blocks.GOLDEN_RAIL, Blocks.TORCH});
    public static List<Block> Field727 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE});

    public static List<BlockPos> Method2164214(float f, Class class_) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil2.Method2164253(EntityUtil.Method2163403((EntityPlayer) BlockUtil2.Field2811.player), f, (int) f, false, true, 0).stream().filter(arg_0 -> BlockUtil2.Method2164207(class_, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static boolean Method2164215(BlockPos blockPos) {
        Block block = BlockUtil2.Method2164265(blockPos);
        return block instanceof BlockAir || block instanceof BlockLiquid;
    }

    public static boolean Method2164216(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3, boolean bl4, EnumHand enumHand2) {
        boolean bl5 = false;
        EnumFacing enumFacing = BlockUtil2.Method2164231(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = Util.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!Util.Field2811.player.isSneaking() && (Field723.contains((Object) block) || Field724.contains((Object) block))) {
            Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            Util.Field2811.player.setSneaking(true);
            bl5 = true;
        }
        if (bl) {
            PlayerUtil.Method2163929(vec3d, true);
        }
        BlockUtil2.Method2164238(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        if (bl4) {
            Util.Field2811.player.swingArm(enumHand2);
        }
        Util.Field2811.rightClickDelayTimer = 4;
        return bl5 || bl3;
    }

    public static boolean Method2164217(double d, double d2, double d3) {
        return BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d(d, d2 + 1.7, d3), false, true, false) == null;
    }

    public static BlockPos Method2164218(BlockPos blockPos, boolean bl) {
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return null;
        }
        EnumFacing enumFacing = BlockUtil2.Method2164276(blockPos);
        if (enumFacing == null) {
            return null;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        if (bl) {
            BlockUtil2.Method2164228(blockPos2, vec3d, EnumHand.MAIN_HAND, enumFacing2);
        } else {
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
            BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
        return blockPos2;
    }

    public static boolean Method2164219(BlockPos blockPos) {
        return BlockUtil2.Method2164210(blockPos) && !Field723.contains((Object) BlockUtil2.Method2164265(blockPos));
    }

    public static boolean Method2164210(BlockPos blockPos) {
        Block block = BlockUtil2.Method2164265(blockPos);
        if (block instanceof BlockAir) {
            return false;
        }
        return !(block instanceof BlockLiquid);
    }

    public static EnumFacing Method2164221(BlockPos blockPos) {
        RayTraceResult rayTraceResult = BlockUtil2.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil2.Field2811.player.posX, BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.eyeHeight, BlockUtil2.Field2811.player.posZ), new Vec3d((Vec3i) blockPos));
        if (rayTraceResult == null) {
            return EnumFacing.UP;
        }
        return rayTraceResult.sideHit;
    }

    public static List<Vec3d> Method2164222(int n2, boolean bl) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        arrayList.add(new Vec3d(-1.0, (double) n2, 0.0));
        arrayList.add(new Vec3d(1.0, (double) n2, 0.0));
        arrayList.add(new Vec3d(0.0, (double) n2, -1.0));
        arrayList.add(new Vec3d(0.0, (double) n2, 1.0));
        if (bl) {
            arrayList.add(new Vec3d(0.0, (double) (n2 - 1), 0.0));
        }
        return arrayList;
    }

    public static Vec3d[] Method2164223(int n2, boolean bl) {
        List<Vec3d> list = BlockUtil2.Method2164222(n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) new Vec3d[0]);
    }

    public static List<BlockPos> Method2164224(float f, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = new BlockPos(BlockUtil.Field2811.player.getPositionVector());
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = (int) f;
        int n6 = n2 - n5;
        while ((float) n6 <= (float) n2 + f) {
            int n7 = n4 - n5;
            while ((float) n7 <= (float) n4 + f) {
                int n8 = n3 - n5;
                while ((float) n8 < (float) n3 + f) {
                    BlockPos blockPos2;
                    double d = (n2 - n6) * (n2 - n6) + (n4 - n7) * (n4 - n7) + (n3 - n8) * (n3 - n8);
                    if (d < (double) (f * f) && (BlockUtil.Field2811.world.getBlockState(blockPos2 = new BlockPos(n6, n8, n7)).getBlock() != Blocks.AIR || !bl)) {
                        arrayList.add(blockPos2);
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    public static BlockPos Method2164225(BlockPos blockPos, boolean bl) {
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return null;
        }
        EnumFacing enumFacing = BlockUtil2.Method2164276(blockPos);
        if (enumFacing == null) {
            return null;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        if (bl) {
            BlockUtil2.Method2164228(blockPos2, vec3d, EnumHand.MAIN_HAND, enumFacing2);
        } else {
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
            BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
        return blockPos2;
    }

    public static void Method2164226(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, boolean bl) {
        Vec3d vec3d2 = new Vec3d((Vec3i) blockPos).add(vec3d).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
        if (bl) {
            BlockUtil2.Method2164228(blockPos, vec3d2, EnumHand.MAIN_HAND, enumFacing);
        } else {
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos, enumFacing, vec3d2, EnumHand.MAIN_HAND);
            BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static void Method2164227(BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        Vec3d vec3d = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
        if (bl) {
            BlockUtil2.Method2164228(blockPos, vec3d, EnumHand.MAIN_HAND, enumFacing);
        } else {
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos, enumFacing, vec3d, EnumHand.MAIN_HAND);
            BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static void Method2164228(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing) {
        float f = (float) (vec3d.x - (double) blockPos.getX());
        float f2 = (float) (vec3d.y - (double) blockPos.getY());
        float f3 = (float) (vec3d.z - (double) blockPos.getZ());
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(enumHand));
        BlockUtil2.Field2811.rightClickDelayTimer = 4;
    }

    public static void Method2164229(BlockPos blockPos, EnumHand enumHand, EnumFacing enumFacing, float f, float f2, float f3) {
        ItemStack itemStack = BlockUtil2.Field2811.player.getHeldItemMainhand();
        if (itemStack.getItem() instanceof ItemBlock) {
            int n2;
            IBlockState iBlockState;
            ItemBlock itemBlock = (ItemBlock) itemStack.getItem();
            Block block = itemBlock.getBlock();
            IBlockState iBlockState2 = BlockUtil2.Field2811.world.getBlockState(blockPos);
            Block block2 = iBlockState2.getBlock();
            if (!block2.isReplaceable((IBlockAccess) BlockUtil2.Field2811.world, blockPos)) {
                blockPos = blockPos.offset(enumFacing);
            }
            if (!itemStack.isEmpty() && BlockUtil2.Field2811.player.canPlayerEdit(blockPos, enumFacing, itemStack) && BlockUtil2.Field2811.world.mayPlace(block, blockPos, false, enumFacing, null) && itemBlock.placeBlockAt(itemStack, (EntityPlayer) BlockUtil2.Field2811.player, (World) BlockUtil2.Field2811.world, blockPos, enumFacing, f, f2, f3, iBlockState = block.getStateForPlacement((World) BlockUtil2.Field2811.world, blockPos, enumFacing, f, f2, f3, n2 = itemBlock.getMetadata(itemStack.getMetadata()), (EntityLivingBase) BlockUtil2.Field2811.player, enumHand))) {
                iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos);
                SoundType soundType = iBlockState.getBlock().getSoundType(iBlockState, (World) BlockUtil2.Field2811.world, blockPos, (Entity) BlockUtil2.Field2811.player);
                BlockUtil2.Field2811.world.playSound((EntityPlayer) BlockUtil2.Field2811.player, blockPos, soundType.getPlaceSound(), SoundCategory.BLOCKS, (soundType.getVolume() + 1.0f) / 2.0f, soundType.getPitch() * 0.8f);
                if (!BlockUtil2.Field2811.player.isCreative()) {
                    itemStack.shrink(1);
                }
            }
        }
    }

    public static List<EnumFacing> Method2164220(BlockPos blockPos) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(BlockUtil2.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    public static EnumFacing Method2164231(BlockPos blockPos) {
        Iterator<EnumFacing> iterator = BlockUtil2.Method2164220(blockPos).iterator();
        if (iterator.hasNext()) {
            EnumFacing enumFacing = iterator.next();
            return enumFacing;
        }
        return null;
    }

    public static EnumFacing Method2164232(BlockPos blockPos) {
        RayTraceResult rayTraceResult = BlockUtil2.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil2.Field2811.player.posX, BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight(), BlockUtil2.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getX() - 0.5, (double) blockPos.getX() + 0.5));
        if (rayTraceResult == null || rayTraceResult.sideHit == null) {
            return EnumFacing.UP;
        }
        return rayTraceResult.sideHit;
    }

    public static boolean Method2164233(BlockPos blockPos) {
        if (Field727.contains((Object) BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock())) {
            Entity entity;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
            Iterator iterator = BlockUtil2.Field2811.world.loadedEntityList.iterator();
            do {
                if (iterator.hasNext()) continue;
                return true;
            } while (!((entity = (Entity) iterator.next()) instanceof EntityLivingBase) || !axisAlignedBB.intersects(entity.getEntityBoundingBox()));
        }
        return false;
    }

    public static float Method2164234(BlockPos blockPos) {
        try {
            Field field = ReflectionHelper.findField(RenderGlobal.class, (String[]) new String[]{"damagedBlocks", "damagedBlocks"});
            field.setAccessible(true);
            HashMap hashMap = (HashMap) field.get((Object) Minecraft.getMinecraft().renderGlobal);
            for (DestroyBlockProgress destroyBlockProgress : hashMap.values()) {
                if (!destroyBlockProgress.getPosition().equals((Object) blockPos) || destroyBlockProgress.getPartialBlockDamage() < 0 || destroyBlockProgress.getPartialBlockDamage() > 10)
                    continue;
                return (float) destroyBlockProgress.getPartialBlockDamage() / 10.0f;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0.0f;
    }

    public static void Method2164235(double d, double d2, double d3) {
        double d4 = d - BlockUtil2.Field2811.player.posX;
        double d5 = d2 - (BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight());
        double d6 = d3 - BlockUtil2.Field2811.player.posZ;
        double d7 = Math.sqrt(d4 * d4 + d6 * d6);
        float f = (float) Math.toDegrees(Math.atan2(d6, d4)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d5, d7)));
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(f, f2, BlockUtil2.Field2811.player.onGround));
    }

    public static int Method2164236(BlockPos blockPos, boolean bl) {
        return BlockUtil2.Method2164237(blockPos, bl, true);
    }

    public static int Method2164237(BlockPos blockPos, boolean bl, boolean bl2) {
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
            return 0;
        }
        if (!BlockUtil2.Method2164288(blockPos, bl, 0.0f)) {
            return -1;
        }
        if (bl2) {
            for (EnumFacing enumFacing : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (enumFacing instanceof EntityItem || enumFacing instanceof EntityXPOrb) continue;
                return 1;
            }
        }
        for (EnumFacing enumFacing : BlockUtil2.Method2164220(blockPos)) {
            if (!BlockUtil2.Method2164264(blockPos.offset(enumFacing))) continue;
            return 3;
        }
        return 2;
    }

    public static void Method2164238(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl) {
        if (bl) {
            float f = (float) (vec3d.x - (double) blockPos.getX());
            float f2 = (float) (vec3d.y - (double) blockPos.getY());
            float f3 = (float) (vec3d.z - (double) blockPos.getZ());
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos, enumFacing, vec3d, enumHand);
        }
        BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil2.Field2811.rightClickDelayTimer = 4;
    }

    public static void Method2164239(BlockPos blockPos, float f, boolean bl, EnumHand enumHand, AtomicDouble atomicDouble, AtomicDouble atomicDouble2, AtomicBoolean atomicBoolean) {
        Vec3d vec3d = RotationUtil.Method2163089();
        Vec3d vec3d2 = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5);
        double d = vec3d.squareDistanceTo(vec3d2);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d3 = vec3d2.add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
            double d2 = vec3d.squareDistanceTo(vec3d3);
            if (!(d2 <= MathUtil.Method2163857(f)) || !(d2 < d) || BlockUtil2.Field2811.world.rayTraceBlocks(vec3d, vec3d3, false, true, false) != null)
                continue;
            if (bl) {
                float[] arrf = RotationUtil.Method2163099(vec3d3);
                atomicDouble.set((double) arrf[0]);
                atomicDouble2.set((double) arrf[1]);
                atomicBoolean.set(true);
            }
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos, enumFacing, vec3d3, enumHand);
            BlockUtil2.Field2811.player.swingArm(enumHand);
            BlockUtil2.Field2811.rightClickDelayTimer = 4;
            break;
        }
    }

    public static boolean Method2164230(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock();
        boolean bl4 = false;
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return false;
        }
        EnumFacing enumFacing = BlockUtil2.Method2164276(blockPos);
        if (enumFacing == null) {
            return false;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(new Vec3d(0.5, 0.5, 0.5)).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block2 = BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil2.Field2811.player.isSneaking() && (Field723.contains((Object) block2) || Field724.contains((Object) block2))) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil2.Field2811.player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            RotationUtil.Method2164115(vec3d);
        }
        BlockUtil2.Method2164238(blockPos, vec3d, enumHand, enumFacing, bl2);
        BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        return bl4 || bl3;
    }

    public static void Method2164241(BlockPos blockPos, EnumFacing enumFacing, EnumHand enumHand, boolean bl) {
        if (bl) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos.offset(enumFacing), enumFacing.getOpposite(), enumHand, Float.intBitsToFloat(Float.floatToIntBits(17.0f)), Float.intBitsToFloat(Float.floatToIntBits(26.0f)), Float.intBitsToFloat(Float.floatToIntBits(3.0f))));
        } else {
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), enumHand);
        }
    }

    public static boolean Method2164242(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5 = false;
        EnumFacing enumFacing = BlockUtil2.Method2164244(blockPos);
        if (enumFacing == null) {
            return bl4;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock();
        float f = (float) (vec3d.x - (double) blockPos.getX());
        float f2 = (float) (vec3d.y - (double) blockPos.getY());
        float f3 = (float) (vec3d.z - (double) blockPos.getZ());
        if (!BlockUtil2.Field2811.player.isSneaking() && (Field723.contains((Object) block) || Field724.contains((Object) block))) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil2.Field2811.player.setSneaking(true);
            bl5 = true;
        }
        if (bl) {
            RotationUtil.Method2163002(vec3d, true);
        }
        if (bl3) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos2, enumFacing2, enumHand, f, f2, f3));
        }
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        if (TestUtil.Method2164736(blockPos)) {
            BlockUtil2.Method2164229(blockPos2, enumHand, enumFacing2, (float) vec3d.x, (float) vec3d.y, (float) vec3d.z);
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
            EnumActionResult enumActionResult = BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
            enumActionResult = EnumActionResult.SUCCESS;
            BlockUtil2.Method2164238(blockPos2, vec3d, enumHand, enumFacing2, bl2);
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
        } else {
            BlockUtil2.Method2164229(blockPos2, enumHand, enumFacing2, (float) vec3d.x, (float) vec3d.y, (float) vec3d.z);
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
            EnumActionResult enumActionResult = BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
            enumActionResult = EnumActionResult.SUCCESS;
            BlockUtil2.Method2164238(blockPos2, vec3d, enumHand, enumFacing2, bl2);
            BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
        }
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        return bl5 || bl4;
    }

    public static boolean Method2164243(BlockPos blockPos, EntityPlayer entityPlayer) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
        return entityPlayer.getEntityBoundingBox().expand(-0.0625, -0.0625, -0.0625).intersects(axisAlignedBB);
    }

    public static EnumFacing Method2164244(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos.offset(enumFacing));
            boolean bl = iBlockState.getBlock().onBlockActivated((World) BlockUtil2.Field2811.world, blockPos, iBlockState, (EntityPlayer) BlockUtil2.Field2811.player, EnumHand.MAIN_HAND, enumFacing, 0.0f, 0.0f, 0.0f);
            if (bl) {
                Field2811.getConnection().sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (!iBlockState.getBlock().canCollideCheck(iBlockState, false) || iBlockState.getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static boolean Method2164245(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = BlockUtil2.Method2164231(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil2.Field2811.player.isSneaking() && (Field723.contains((Object) block) || Field724.contains((Object) block))) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil2.Field2811.player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            RotationUtil.Method2163002(vec3d, true);
        }
        BlockUtil2.Method2164238(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil2.Field2811.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    public static boolean Method2164246(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = BlockUtil2.Method2164231(blockPos);
        Command.Method2159696(enumFacing.toString());
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil2.Field2811.player.isSneaking() && (Field723.contains((Object) block) || Field724.contains((Object) block))) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            bl4 = true;
        }
        if (bl) {
            AliceMain.Field760.Method2150281(vec3d);
        }
        BlockUtil2.Method2164238(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil2.Field2811.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    public static void Method2164247(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = BlockUtil2.Method2164246(blockPos, enumHand, bl, bl2, bl3);
        if (!bl3 && bl4) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
    }

    public static boolean Method2164248(BlockPos blockPos) {
        for (BlockPos blockPos2 : BlockUtil2.Method2164249(blockPos)) {
            IBlockState iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN))
                continue;
            return false;
        }
        return true;
    }

    public static BlockPos[] Method2164249(BlockPos blockPos) {
        return new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()};
    }

    public static List<BlockPos> Method2164240(float f, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = new BlockPos(BlockUtil2.Field2811.player.getPositionVector());
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = (int) f;
        int n6 = n2 - n5;
        while ((float) n6 <= (float) n2 + f) {
            int n7 = n4 - n5;
            while ((float) n7 <= (float) n4 + f) {
                int n8 = n3 - n5;
                while ((float) n8 < (float) n3 + f) {
                    if ((float) ((n2 - n6) * (n2 - n6) + (n4 - n7) * (n4 - n7) + (n3 - n8) * (n3 - n8)) < f * f) {
                        BlockPos blockPos2 = new BlockPos(n6, n8, n7);
                        if (!bl || BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                            arrayList.add(blockPos2);
                        }
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    public static Vec3d[] Method2164251(Vec3d vec3d) {
        return new Vec3d[]{new Vec3d(vec3d.x, vec3d.y - 1.0, vec3d.z), new Vec3d(vec3d.x != 0.0 ? vec3d.x * 2.0 : vec3d.x, vec3d.y, vec3d.x != 0.0 ? vec3d.z : vec3d.z * 2.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x + 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z + 1.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x - 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z - 1.0), new Vec3d(vec3d.x, vec3d.y + 1.0, vec3d.z)};
    }

    public static List<BlockPos> Method2164252(float f) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil2.Method2164253(EntityUtil.Method2163403((EntityPlayer) BlockUtil2.Field2811.player), f, (int) f, false, true, 0).stream().filter(BlockUtil2::Method2164254).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List<BlockPos> Method2164253(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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
                    float f2 = n9;
                    float f3 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    float f4 = f3;
                    if (!(f2 < f3)) {
                        ++n8;
                        continue block1;
                    }
                    double d = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (d < (double) (f * f) && (!bl || d >= (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n7, n9 + n3, n8);
                        arrayList.add(blockPos2);
                    }
                    ++n9;
                }
            }
            ++n7;
        }
        return arrayList;
    }

    public static boolean Method2164254(BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            return (BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN) && BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && BlockUtil2.Field2811.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
        } catch (Exception exception) {
            return false;
        }
    }

    public static List<BlockPos> Method2164255(float f, boolean bl) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil2.Method2164253(EntityUtil.Method2163403((EntityPlayer) BlockUtil2.Field2811.player), f, (int) f, false, true, 0).stream().filter(arg_0 -> BlockUtil2.Method2164206(bl, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static boolean Method2164256(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = BlockUtil2.Method2164231(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        if (!BlockUtil2.Field2811.player.isSneaking() && bl3) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil2.Field2811.player.setSneaking(true);
            bl4 = true;
        }
        BlockUtil2.Method2164238(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil2.Field2811.rightClickDelayTimer = 4;
        if (!BlockUtil2.Field2811.player.isSneaking() && bl3) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            BlockUtil2.Field2811.player.setSneaking(false);
            bl4 = false;
        }
        return bl4 || bl3;
    }

    public static boolean Method2164257(BlockPos blockPos) {
        for (Entity entity : BlockUtil2.Field2811.world.loadedEntityList) {
            if (entity.equals((Object) BlockUtil2.Field2811.player) || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    public static List<BlockPos> Method2164258(float f, boolean bl, boolean bl2) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil2.Method2164253(EntityUtil.Method2163403((EntityPlayer) BlockUtil2.Field2811.player), f, (int) f, false, true, 0).stream().filter(arg_0 -> BlockUtil2.Method2164205(bl, bl2, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static boolean Method2164259(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = bl;
        boolean bl5 = bl2;
        BlockPos blockPos2 = blockPos;
        if (CrystalUtil.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.BEDROCK && CrystalUtil.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        if (CrystalUtil.Field2811.world.getBlockState(blockPos2.add(0, 1, 0)).getBlock() != Blocks.AIR || !bl5 && CrystalUtil.Field2811.world.getBlockState(blockPos2.add(0, 2, 0)).getBlock() != Blocks.AIR) {
            return false;
        }
        if (bl4) {
            return CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2.add(0, 1, 0))).isEmpty() && !bl5 && CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2.add(0, 2, 0))).isEmpty();
        }
        for (Entity entity : CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2.add(0, 1, 0)))) {
            if (entity instanceof EntityEnderCrystal) continue;
            return false;
        }
        if (!bl5) {
            for (Entity entity : CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2.add(0, 2, 0)))) {
                boolean bl6 = bl5;
                if (entity instanceof EntityEnderCrystal || bl6 && entity instanceof EntityPlayer) continue;
                return false;
            }
        }
        return true;
    }

    public static void Method2164250(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        RayTraceResult rayTraceResult = BlockUtil2.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil2.Field2811.player.posX, BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight(), BlockUtil2.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        int n2 = BlockUtil2.Field2811.player.inventory.currentItem;
        int n3 = InventoryUtil.Method2163781(Items.END_CRYSTAL);
        if (enumHand == EnumHand.MAIN_HAND && bl3 && n3 != -1 && n3 != BlockUtil2.Field2811.player.inventory.currentItem) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
        if (enumHand == EnumHand.MAIN_HAND && bl3 && n3 != -1 && n3 != BlockUtil2.Field2811.player.inventory.currentItem) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl) {
            BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(bl2 ? enumHand : EnumHand.MAIN_HAND));
        }
    }

    public static List<BlockPos> Method2164261(float f, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = new BlockPos(BlockUtil2.Field2811.player.getPositionVector());
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = (int) f;
        int n6 = n2 - n5;
        while ((float) n6 <= (float) n2 + f) {
            int n7 = n4 - n5;
            while ((float) n7 <= (float) n4 + f) {
                int n8 = n3 - n5;
                while ((float) n8 < (float) n3 + f) {
                    if ((float) ((n2 - n6) * (n2 - n6) + (n4 - n7) * (n4 - n7) + (n3 - n8) * (n3 - n8)) < f * f) {
                        BlockPos blockPos2 = new BlockPos(n6, n8, n7);
                        if (!bl || BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                            arrayList.add(blockPos2);
                        }
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Method2164262(BlockPos blockPos, boolean bl, boolean bl2) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            if (BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
                return false;
            }
            if (!bl2 && BlockUtil2.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR || BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                return false;
            }
            for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                if (entity.isDead || bl && entity instanceof EntityEnderCrystal) continue;
                return false;
            }
            if (!bl2) {
                for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                    if (entity.isDead || bl && entity instanceof EntityEnderCrystal) continue;
                    return false;
                }
            }
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static boolean Method2164263(BlockPos blockPos, boolean bl) {
        BlockPos blockPos2;
        BlockPos blockPos3;
        block10:
        {
            block9:
            {
                blockPos3 = blockPos.add(0, 1, 0);
                blockPos2 = blockPos.add(0, 2, 0);
                if (BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                    break block9;
                return false;
            }
            if (BlockUtil2.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR || BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                return false;
            }
            if (!bl) break block10;
            for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                if (entity instanceof EntityEnderCrystal) continue;
                return false;
            }
            try {
                for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                    if (entity instanceof EntityEnderCrystal) continue;
                    return false;
                }
                return true;
            } catch (Exception exception) {
                return false;
            }
        }
        return BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty() && BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty();
    }

    public static boolean Method2164264(BlockPos blockPos) {
        return BlockUtil2.Method2164265(blockPos).canCollideCheck(BlockUtil2.Method2164266(blockPos), false);
    }

    public static Block Method2164265(BlockPos blockPos) {
        return BlockUtil2.Method2164266(blockPos).getBlock();
    }

    private static IBlockState Method2164266(BlockPos blockPos) {
        return BlockUtil2.Field2811.world.getBlockState(blockPos);
    }

    public static boolean Method2164267(Entity entity) {
        if (entity != null) {
            BlockPos blockPos = new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ);
            return BlockUtil2.Method2164279(blockPos);
        }
        return false;
    }

    public static void Method2164268(String string, BlockPos blockPos) {
        Command.Method2159696(string + blockPos.getX() + "x, " + blockPos.getY() + "y, " + blockPos.getZ() + "z");
    }

    public static void Method2164269(BlockPos blockPos, EnumHand enumHand) {
        RayTraceResult rayTraceResult = BlockUtil2.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil2.Field2811.player.posX, BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight(), BlockUtil2.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
    }

    public static BlockPos[] Method2164260(Vec3d[] arrvec3d) {
        BlockPos[] arrblockPos = new BlockPos[arrvec3d.length];
        for (int j = 0; j < arrvec3d.length; ++j) {
            arrblockPos[j] = new BlockPos(arrvec3d[j]);
        }
        return arrblockPos;
    }

    public static Vec3d Method2164271(BlockPos blockPos) {
        return new Vec3d((Vec3i) blockPos);
    }

    public static BlockPos Method2164272(Vec3d vec3d) {
        return new BlockPos(vec3d);
    }

    public static void Method2164273(Vec3d vec3d) {
        float[] arrf = BlockUtil2.Method2164275(vec3d);
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], BlockUtil2.Field2811.player.onGround));
    }

    public static Vec3d Method2164274() {
        return new Vec3d(BlockUtil2.Field2811.player.posX, BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight(), BlockUtil2.Field2811.player.posZ);
    }

    private static float[] Method2164275(Vec3d vec3d) {
        Vec3d vec3d2 = BlockUtil2.Method2164274();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{BlockUtil2.Field2811.player.rotationYaw + MathHelper.wrapDegrees((float) (f - BlockUtil2.Field2811.player.rotationYaw)), BlockUtil2.Field2811.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - BlockUtil2.Field2811.player.rotationPitch))};
    }

    public static EnumFacing Method2164276(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(BlockUtil2.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static Boolean Method2164277(BlockPos blockPos) {
        int n2 = RotationUtil.Method2164113();
        if (n2 == 0 && (double) blockPos.getZ() - BlockUtil2.Field2811.player.getPositionVector().z < 0.0) {
            return false;
        }
        if (n2 == 1 && (double) blockPos.getX() - BlockUtil2.Field2811.player.getPositionVector().x > 0.0) {
            return false;
        }
        if (n2 == 2 && (double) blockPos.getZ() - BlockUtil2.Field2811.player.getPositionVector().z > 0.0) {
            return false;
        }
        return n2 != 3 || (double) blockPos.getX() - BlockUtil2.Field2811.player.getPositionVector().x >= 0.0;
    }

    public static boolean Method2164278(Entity entity) {
        if (entity != null) {
            BlockPos blockPos = new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ);
            return BlockUtil2.Method2164279(blockPos);
        }
        return false;
    }

    public static boolean Method2164279(BlockPos blockPos) {
        return !BlockUtil2.Method2164270(blockPos);
    }

    public static boolean Method2164270(BlockPos blockPos) {
        return BlockUtil2.Method2164281(BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock());
    }

    public static boolean Method2164281(Block block) {
        return Field726.contains((Object) block);
    }

    public static boolean Method2164282(Block block) {
        return Field725.contains((Object) block);
    }

    public static Vec3d[] Method2164283(Vec3d vec3d, Vec3d[] arrvec3d) {
        Vec3d[] arrvec3d2 = new Vec3d[arrvec3d.length];
        for (int j = 0; j < arrvec3d.length; ++j) {
            arrvec3d2[j] = vec3d.add(arrvec3d[j]);
        }
        return arrvec3d2;
    }

    public static Vec3d[] Method2164284(EntityPlayer entityPlayer, Vec3d[] arrvec3d) {
        return BlockUtil2.Method2164283(entityPlayer.getPositionVector(), arrvec3d);
    }

    public static boolean Method2164285(BlockPos blockPos) {
        IBlockState iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getBlockHardness(iBlockState, (World) BlockUtil2.Field2811.world, blockPos) != -1.0f;
    }

    public static boolean Method2164286(BlockPos blockPos) {
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockLiquid) && block.getMaterial(null) != Material.AIR;
    }

    public static boolean Method2164287(BlockPos blockPos) {
        return BlockUtil2.Field2811.world.isAirBlock(blockPos) || BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.SNOW_LAYER || BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.TALLGRASS || BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid;
    }

    public static boolean Method2164288(BlockPos blockPos, boolean bl, float f) {
        return !bl || BlockUtil2.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil2.Field2811.player.posX, BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight(), BlockUtil2.Field2811.player.posZ), new Vec3d((double) blockPos.getX(), (double) ((float) blockPos.getY() + f), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2164289(BlockPos blockPos, boolean bl) {
        return BlockUtil2.Method2164288(blockPos, bl, 1.0f);
    }

    public static boolean Method2164280(BlockPos blockPos) {
        return BlockUtil2.Method2164289(blockPos, true);
    }

    public static BlockPos Method2164291() {
        return new BlockPos(Math.floor(BlockUtil2.Field2811.player.posX), Math.floor(BlockUtil2.Field2811.player.posY), Math.floor(BlockUtil2.Field2811.player.posZ));
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2164292(BlockPos blockPos) {
        if (!BlockUtil2.Field2811.world.checkNoEntityCollision(new AxisAlignedBB(blockPos))) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoEntityCollision;
        }
        if (!BlockUtil2.Method2164297(blockPos)) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoNeighbors;
        }
        IBlockState iBlockState = BlockUtil2.Field2811.world.getBlockState(blockPos);
        if (iBlockState.getBlock() == Blocks.AIR) {
            BlockPos[] arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.up(), blockPos.down()};
            for (BlockPos blockPos2 : arrblockPos) {
                IBlockState iBlockState2 = BlockUtil2.Field2811.world.getBlockState(blockPos2);
                if (iBlockState2.getBlock() == Blocks.AIR) continue;
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    BlockPos blockPos3 = blockPos.offset(enumFacing);
                    if (!BlockUtil2.Field2811.world.getBlockState(blockPos3).getBlock().canCollideCheck(BlockUtil2.Field2811.world.getBlockState(blockPos3), false)) {
                        continue;
                    }
                    return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Ok;
                }
            }
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoNeighbors;
        }
        return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AlreadyBlockThere;
    }

    public static List<BlockPos> Method2164293(double d, BlockPos blockPos, boolean bl, boolean bl2) {
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
                    double d2;
                    double d3 = n7;
                    double d4 = d2 = bl ? (double) n3 + d : (double) n3 + d;
                    if (!(d3 < d2)) {
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

    public static boolean Method2164294(BlockPos blockPos, boolean bl, boolean bl2) {
        if (!BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock().isReplaceable((IBlockAccess) BlockUtil2.Field2811.world, blockPos)) {
            return false;
        }
        if (bl) {
            for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (entity instanceof EntityItem || entity instanceof EntityXPOrb) continue;
                return false;
            }
        }
        return !bl2 || BlockUtil2.Method2164276(blockPos) != null;
    }

    public static boolean Method2164295(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        if (!BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock().isReplaceable((IBlockAccess) BlockUtil2.Field2811.world, blockPos)) {
            return false;
        }
        if (bl) {
            for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityEnderCrystal && bl3)
                    continue;
                return false;
            }
        }
        return !bl2 || BlockUtil2.Method2164276(blockPos) != null;
    }

    public static boolean Method2164296(BlockPos blockPos, boolean bl, double d) {
        Block block = BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
            return false;
        }
        if (bl) {
            for (Entity entity : BlockUtil2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if ((double) BlockUtil2.Field2811.player.getDistance(entity) > d || entity instanceof EntityItem || entity instanceof EntityXPOrb)
                    continue;
                return false;
            }
        }
        return true;
    }

    public static boolean Method2164297(BlockPos blockPos) {
        if (!BlockUtil2.Method2164298(blockPos)) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (!BlockUtil2.Method2164298(blockPos2)) {
                    continue;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean Method2164298(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (BlockUtil2.Field2811.world.getBlockState(blockPos2).getMaterial().isReplaceable()) {
                continue;
            }
            return true;
        }
        return false;
    }

    public static void Method2164299(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            boolean bl4 = bl;
            boolean bl5 = bl2;
            boolean bl6 = bl3;
            BlockPos blockPos2 = blockPos;
            if (BlockUtil2.Field2811.world.getBlockState(blockPos2.offset(enumFacing)).getBlock().equals((Object) Blocks.AIR) || BlockUtil2.Method2164202(blockPos2))
                continue;
            if (bl5) {
                BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos2.offset(enumFacing), enumFacing.getOpposite(), EnumHand.MAIN_HAND, Float.intBitsToFloat(Float.floatToIntBits(2.7f)), Float.intBitsToFloat(Float.floatToIntBits(3.8f)), Float.intBitsToFloat(Float.floatToIntBits(30.0f))));
            } else {
                BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos2.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos2), EnumHand.MAIN_HAND);
            }
            if (bl4) {
                BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            }
            if (bl6) {
                RotationUtil.Method2163002(new Vec3d((Vec3i) blockPos2), true);
            }
            return;
        }
    }

    public static boolean Method2164290(BlockPos blockPos, int n2, boolean bl, boolean bl2, boolean bl3) {
        if (TestUtil.Method2164736(blockPos)) {
            EnumFacing[] arrenumFacing;
            int n3 = -1;
            if (n2 != BlockUtil2.Field2811.player.inventory.currentItem) {
                n3 = BlockUtil2.Field2811.player.inventory.currentItem;
                BlockUtil2.Field2811.player.inventory.currentItem = n2;
            }
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                Block block = BlockUtil2.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (Field727.contains((Object) block) || !(BlockUtil2.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                float[] arrf = new float[]{BlockUtil2.Field2811.player.rotationYaw, BlockUtil2.Field2811.player.rotationPitch};
                if (bl) {
                    BlockUtil2.Method2164235(vec3d.x, vec3d.y, vec3d.z);
                }
                if (Field722.contains((Object) block)) {
                    BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                BlockUtil2.Field2811.playerController.processRightClickBlock(BlockUtil2.Field2811.player, BlockUtil2.Field2811.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
                if (Field722.contains((Object) block)) {
                    BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                if (bl2) {
                    BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], BlockUtil2.Field2811.player.onGround));
                }
                if (bl3) {
                    BlockUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                }
                if (n3 != -1) {
                    BlockUtil2.Field2811.player.inventory.currentItem = n3;
                }
                return true;
            }
            if (n3 != -1) {
                BlockUtil2.Field2811.player.inventory.currentItem = n3;
            }
        }
        return false;
    }

    public static void Method2164201(BlockPos blockPos, EnumHand enumHand, boolean bl) {
        boolean bl2 = bl;
        EnumHand enumHand2 = enumHand;
        BlockPos blockPos2 = blockPos;
        if (!BlockUtil2.Field2811.world.getBlockState(blockPos2).getBlock().isReplaceable((IBlockAccess) BlockUtil2.Field2811.world, blockPos2)) {
            return;
        }
        if (BlockUtil2.Method2164276(blockPos2) == null) {
            return;
        }
        BlockUtil2.Method2164241(blockPos2, BlockUtil2.Method2164276(blockPos2), enumHand2, bl2);
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(enumHand2));
    }

    public static boolean Method2164202(BlockPos blockPos) {
        for (Entity entity : BlockUtil2.Field2811.world.loadedEntityList) {
            BlockPos blockPos2 = blockPos;
            if (entity instanceof EntityItem || entity instanceof EntityEnderCrystal || !new AxisAlignedBB(blockPos2).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    public static int Method2164203() {
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = BlockUtil2.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock)) continue;
            Block block = ((ItemBlock) itemStack.getItem()).getBlock();
            if (block instanceof BlockEnderChest) {
                return j;
            }
            if (!(block instanceof BlockObsidian)) continue;
            return j;
        }
        return -1;
    }

    public static BlockPos Method2164204() {
        return new BlockPos(Math.floor(BlockUtil2.Field2811.player.posX), Math.floor(BlockUtil2.Field2811.player.posY), Math.floor(BlockUtil2.Field2811.player.posZ));
    }

    private static boolean Method2164205(boolean bl, boolean bl2, BlockPos blockPos) {
        return BlockUtil2.Method2164262(blockPos, bl, bl2);
    }

    private static boolean Method2164206(boolean bl, BlockPos blockPos) {
        return BlockUtil2.Method2164263(blockPos, bl);
    }

    private static boolean Method2164207(Class class_, BlockPos blockPos) {
        return class_.isInstance((Object) BlockUtil2.Field2811.world.getBlockState(blockPos).getBlock());
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NoEntityCollision,
        AlreadyBlockThere,
        NoNeighbors,
        Ok;

    }
}

