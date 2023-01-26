

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.util.concurrent.AtomicDouble
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.BlockSnow
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.block.BlockWorkbench
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUtil
        implements Util {
    public static final List<Block> Field576 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE});
    public static final List<Block> Field577 = Arrays.asList(new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
    public static final List<Block> Field580 = Arrays.asList(new Block[]{Blocks.OBSIDIAN, Blocks.ANVIL, Blocks.ENCHANTING_TABLE, Blocks.ENDER_CHEST, Blocks.BEACON});
    public static final List<Block> Field581 = Arrays.asList(new Block[]{Blocks.BEDROCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.END_PORTAL_FRAME, Blocks.BARRIER, Blocks.PORTAL});
    public static List<Block> Field578 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE});
    public static List<Block> Field579 = Arrays.asList(new Block[]{Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.ANVIL, Blocks.WOODEN_BUTTON, Blocks.STONE_BUTTON, Blocks.UNPOWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.POWERED_COMPARATOR, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.JUKEBOX, Blocks.BEACON, Blocks.BED, Blocks.FURNACE, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CAKE, Blocks.ENCHANTING_TABLE, Blocks.DRAGON_EGG, Blocks.HOPPER, Blocks.REPEATING_COMMAND_BLOCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.CRAFTING_TABLE});
    public static List<Block> Field582 = Arrays.asList(new Block[]{Blocks.FLOWING_LAVA, Blocks.FLOWER_POT, Blocks.SNOW, Blocks.CARPET, Blocks.END_ROD, Blocks.SKULL, Blocks.FLOWER_POT, Blocks.TRIPWIRE, Blocks.TRIPWIRE_HOOK, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.STONE_BUTTON, Blocks.LADDER, Blocks.UNPOWERED_COMPARATOR, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.UNLIT_REDSTONE_TORCH, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WIRE, Blocks.AIR, Blocks.PORTAL, Blocks.END_PORTAL, Blocks.WATER, Blocks.FLOWING_WATER, Blocks.LAVA, Blocks.FLOWING_LAVA, Blocks.SAPLING, Blocks.RED_FLOWER, Blocks.YELLOW_FLOWER, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.REEDS, Blocks.PUMPKIN_STEM, Blocks.MELON_STEM, Blocks.WATERLILY, Blocks.NETHER_WART, Blocks.COCOA, Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT, Blocks.TALLGRASS, Blocks.DEADBUSH, Blocks.VINE, Blocks.FIRE, Blocks.RAIL, Blocks.ACTIVATOR_RAIL, Blocks.DETECTOR_RAIL, Blocks.GOLDEN_RAIL, Blocks.TORCH});
    private static BlockPos Field583;
    private static boolean Field584;

    public static List<BlockPos> Method2162793(float f, Class<BlockWorkbench> class_) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil.Method2162829(EntityUtil.Method2163403((EntityPlayer) BlockUtil.Field2811.player), f, (int) f, false, true, 0).stream().filter(arg_0 -> BlockUtil.Method2162874(class_, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static boolean Method2162794(BlockPos blockPos) {
        return BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.AIR;
    }

    public static List<BlockPos> Method2162795(float f, boolean bl, boolean bl2, boolean bl3) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil.Method2162829(EntityUtil.Method2163403((EntityPlayer) BlockUtil.Field2811.player), f, (int) f, false, true, 0).stream().filter(arg_0 -> BlockUtil.Method2162873(bl, bl2, bl3, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List<BlockPos> Method2162796(float f, boolean bl, boolean bl2) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil.Method2162829(EntityUtil.Method2163403((EntityPlayer) BlockUtil.Field2811.player), f, (int) f, false, true, 0).stream().filter(arg_0 -> BlockUtil.Method2162872(bl, bl2, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Method2162797(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            if (BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
                return false;
            }
            if (!bl2 && BlockUtil.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR || BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                return false;
            }
            for (Entity entity : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                if (entity.isDead || bl && entity instanceof EntityEnderCrystal) continue;
                return false;
            }
            if (!bl2 && !bl3) {
                for (Entity entity : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                    if (entity.isDead || bl && entity instanceof EntityEnderCrystal) continue;
                    return false;
                }
            }
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static boolean Method2162798(BlockPos blockPos) {
        for (Entity entity : BlockUtil.Field2811.world.loadedEntityList) {
            if (!(entity instanceof EntityEnderCrystal) || entity == BlockUtil.Field2811.player || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    public static boolean Method2162799(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(Math.floor(entityPlayer.posX), Math.floor(entityPlayer.posY), Math.floor(entityPlayer.posZ));
        return !(BlockUtil.Field2811.world.getBlockState(blockPos.down()).getBlock() != Blocks.OBSIDIAN && BlockUtil.Field2811.world.getBlockState(blockPos.down()).getBlock() != Blocks.BEDROCK || BlockUtil.Field2811.world.getBlockState(blockPos.north()).getBlock() != Blocks.OBSIDIAN && BlockUtil.Field2811.world.getBlockState(blockPos.north()).getBlock() != Blocks.BEDROCK || BlockUtil.Field2811.world.getBlockState(blockPos.east()).getBlock() != Blocks.OBSIDIAN && BlockUtil.Field2811.world.getBlockState(blockPos.east()).getBlock() != Blocks.BEDROCK || BlockUtil.Field2811.world.getBlockState(blockPos.south()).getBlock() != Blocks.OBSIDIAN && BlockUtil.Field2811.world.getBlockState(blockPos.south()).getBlock() != Blocks.BEDROCK || BlockUtil.Field2811.world.getBlockState(blockPos.west()).getBlock() != Blocks.OBSIDIAN && BlockUtil.Field2811.world.getBlockState(blockPos.west()).getBlock() != Blocks.BEDROCK);
    }

    public static void Method2162790(BlockPos blockPos, double d) {
        if (!BlockUtil.Method2162702(blockPos)) {
            return;
        }
        if (BlockUtil.Method2162798(blockPos)) {
            EntityEnderCrystal entityEnderCrystal = null;
            for (Entity entity : BlockUtil.Field2811.world.loadedEntityList) {
                double d2 = BlockUtil.Method2162701(entityEnderCrystal.posX, entityEnderCrystal.posY, entityEnderCrystal.posZ, (Entity) BlockUtil.Field2811.player);
                if (entity == null || d2 < d || (double) BlockUtil.Field2811.player.getDistance(entity) > 2.4 || !(entity instanceof EntityEnderCrystal) || entity.isDead)
                    continue;
                entityEnderCrystal = (EntityEnderCrystal) entity;
            }
            if (entityEnderCrystal != null) {
                Field2811.getConnection().sendPacket((Packet) new CPacketUseEntity(entityEnderCrystal));
                BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
    }

    public static float Method2162701(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        double d4 = entity.getDistance(d, d2, d3) / (double) f;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        double d5 = 0.0;
        try {
            d5 = BlockUtil.Method2162707(vec3d, entity.getEntityBoundingBox());
        } catch (Exception exception) {
            // empty catch block
        }
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * (double) f + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            try {
                d7 = BlockUtil.Method2162703((EntityLivingBase) entity, BlockUtil.Method2162706(f2), new Explosion((World) BlockUtil.Field2811.world, null, d, d2, d3, 6.0f, false, true));
            } catch (Exception exception) {
                // empty catch block
            }
        }
        return (float) d7;
    }

    public static boolean Method2162702(BlockPos blockPos) {
        for (Entity entity : BlockUtil.Field2811.world.loadedEntityList) {
            if (entity instanceof EntityEnderCrystal || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    private static float Method2162703(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
        float f2 = f;
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion) explosion);
            f2 = CombatRules.getDamageAfterAbsorb((float) f2, (float) entityPlayer.getTotalArmorValue(), (float) ((float) entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n2 = 0;
            try {
                n2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable) entityPlayer.getArmorInventoryList(), (DamageSource) damageSource);
            } catch (Exception exception) {
                // empty catch block
            }
            float f3 = MathHelper.clamp((float) n2, (float) 0.0f, (float) 20.0f);
            f2 *= 1.0f - f3 / 25.0f;
            if (entityLivingBase.isPotionActive(MobEffects.RESISTANCE)) {
                f2 -= f2 / 4.0f;
            }
            f2 = Math.max(f2, 0.0f);
            return f2;
        }
        f2 = CombatRules.getDamageAfterAbsorb((float) f2, (float) entityLivingBase.getTotalArmorValue(), (float) ((float) entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f2;
    }

    public static boolean Method2162704(BlockPos blockPos) {
        if (BlockUtil.Method2162705(blockPos)) {
            EnumFacing[] arrenumFacing;
            EnumFacing[] arrenumFacing2 = arrenumFacing = EnumFacing.values();
            for (EnumFacing enumFacing : arrenumFacing) {
                Block block = BlockUtil.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (Field578.contains((Object) block) || !(BlockUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                float[] arrf = new float[]{BlockUtil.Field2811.player.rotationYaw, BlockUtil.Field2811.player.rotationPitch};
                if (Field579.contains((Object) block)) {
                    BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                BlockUtil.Field2811.playerController.processRightClickBlock(BlockUtil.Field2811.player, BlockUtil.Field2811.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
                if (Field579.contains((Object) block)) {
                    BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                return true;
            }
        }
        return false;
    }

    public static boolean Method2162705(BlockPos blockPos) {
        block3:
        {
            try {
                if (!Field578.contains((Object) BlockUtil.Field2811.world.getBlockState(blockPos).getBlock()))
                    break block3;
                AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
                for (Entity entity : BlockUtil.Field2811.world.loadedEntityList) {
                    if (!(entity instanceof EntityLivingBase) || !axisAlignedBB.intersects(entity.getEntityBoundingBox()))
                        continue;
                    return false;
                }
                return true;
            } catch (Exception exception) {
                // empty catch block
            }
        }
        return false;
    }

    private static float Method2162706(float f) {
        int n2 = BlockUtil.Field2811.world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    private static float Method2162707(Vec3d vec3d, AxisAlignedBB axisAlignedBB) {
        double d = 1.0 / ((axisAlignedBB.maxX - axisAlignedBB.minX) * 2.0 + 1.0);
        double d2 = 1.0 / ((axisAlignedBB.maxY - axisAlignedBB.minY) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB.maxZ - axisAlignedBB.minZ) * 2.0 + 1.0);
        double d4 = (1.0 - Math.floor(1.0 / d) * d) / 2.0;
        double d5 = (1.0 - Math.floor(1.0 / d3) * d3) / 2.0;
        if (d >= 0.0 && d2 >= 0.0 && d3 >= 0.0) {
            int n2 = 0;
            int n3 = 0;
            for (float f = 0.0f; f <= 1.0f; f += (float) d) {
                for (float f2 = 0.0f; f2 <= 1.0f; f2 += (float) d2) {
                    for (float f3 = 0.0f; f3 <= 1.0f; f3 += (float) d3) {
                        double d6 = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (double) f;
                        double d7 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (double) f2;
                        double d8 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (double) f3;
                        if (BlockUtil.Method2162708(new Vec3d(d6 + d4, d7, d8 + d5), vec3d, false, false, false, true) == null) {
                            ++n2;
                        }
                        ++n3;
                    }
                }
            }
            return (float) n2 / (float) n3;
        }
        return 0.0f;
    }

    private static RayTraceResult Method2162708(Vec3d vec3d, Vec3d vec3d2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z)) {
            return null;
        }
        if (!(Double.isNaN(vec3d2.x) || Double.isNaN(vec3d2.y) || Double.isNaN(vec3d2.z))) {
            RayTraceResult rayTraceResult;
            int n2 = MathHelper.floor((double) vec3d.x);
            int n3 = MathHelper.floor((double) vec3d.y);
            int n4 = MathHelper.floor((double) vec3d.z);
            int n5 = MathHelper.floor((double) vec3d2.x);
            int n6 = MathHelper.floor((double) vec3d2.y);
            int n7 = MathHelper.floor((double) vec3d2.z);
            BlockPos blockPos = new BlockPos(n2, n3, n4);
            IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos);
            Block block = iBlockState.getBlock();
            if (!(bl2 && iBlockState.getCollisionBoundingBox((IBlockAccess) BlockUtil.Field2811.world, blockPos) == Block.NULL_AABB || !block.canCollideCheck(iBlockState, bl) || bl4 && block instanceof BlockWeb || (rayTraceResult = iBlockState.collisionRayTrace((World) BlockUtil.Field2811.world, blockPos, vec3d, vec3d2)) == null)) {
                return rayTraceResult;
            }
            RayTraceResult rayTraceResult2 = null;
            int n8 = 200;
            while (n8-- >= 0) {
                EnumFacing enumFacing;
                if (Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z)) {
                    return null;
                }
                if (n2 == n5 && n3 == n6 && n4 == n7) {
                    return bl3 ? rayTraceResult2 : null;
                }
                boolean bl5 = true;
                boolean bl6 = true;
                boolean bl7 = true;
                double d = 999.0;
                double d2 = 999.0;
                double d3 = 999.0;
                if (n5 > n2) {
                    d = (double) n2 + 1.0;
                } else if (n5 < n2) {
                    d = (double) n2 + 0.0;
                } else {
                    bl5 = false;
                }
                if (n6 > n3) {
                    d2 = (double) n3 + 1.0;
                } else if (n6 < n3) {
                    d2 = (double) n3 + 0.0;
                } else {
                    bl6 = false;
                }
                if (n7 > n4) {
                    d3 = (double) n4 + 1.0;
                } else if (n7 < n4) {
                    d3 = (double) n4 + 0.0;
                } else {
                    bl7 = false;
                }
                double d4 = 999.0;
                double d5 = 999.0;
                double d6 = 999.0;
                double d7 = vec3d2.x - vec3d.x;
                double d8 = vec3d2.y - vec3d.y;
                double d9 = vec3d2.z - vec3d.z;
                if (bl5) {
                    d4 = (d - vec3d.x) / d7;
                }
                if (bl6) {
                    d5 = (d2 - vec3d.y) / d8;
                }
                if (bl7) {
                    d6 = (d3 - vec3d.z) / d9;
                }
                if (d4 == -0.0) {
                    d4 = -1.0E-4;
                }
                if (d5 == -0.0) {
                    d5 = -1.0E-4;
                }
                if (d6 == -0.0) {
                    d6 = -1.0E-4;
                }
                if (d4 < d5 && d4 < d6) {
                    enumFacing = n5 > n2 ? EnumFacing.WEST : EnumFacing.EAST;
                    vec3d = new Vec3d(d, vec3d.y + d8 * d4, vec3d.z + d9 * d4);
                } else if (d5 < d6) {
                    enumFacing = n6 > n3 ? EnumFacing.DOWN : EnumFacing.UP;
                    vec3d = new Vec3d(vec3d.x + d7 * d5, d2, vec3d.z + d9 * d5);
                } else {
                    enumFacing = n7 > n4 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                    vec3d = new Vec3d(vec3d.x + d7 * d6, vec3d.y + d8 * d6, d3);
                }
                n2 = MathHelper.floor((double) vec3d.x) - (enumFacing == EnumFacing.EAST ? 1 : 0);
                n3 = MathHelper.floor((double) vec3d.y) - (enumFacing == EnumFacing.UP ? 1 : 0);
                n4 = MathHelper.floor((double) vec3d.z) - (enumFacing == EnumFacing.SOUTH ? 1 : 0);
                blockPos = new BlockPos(n2, n3, n4);
                IBlockState iBlockState2 = BlockUtil.Field2811.world.getBlockState(blockPos);
                Block block2 = iBlockState2.getBlock();
                if (bl2 && iBlockState2.getMaterial() != Material.PORTAL && iBlockState2.getCollisionBoundingBox((IBlockAccess) BlockUtil.Field2811.world, blockPos) == Block.NULL_AABB)
                    continue;
                if (!(!block2.canCollideCheck(iBlockState2, bl) || bl4 && block2 instanceof BlockWeb)) {
                    RayTraceResult rayTraceResult3 = iBlockState2.collisionRayTrace((World) BlockUtil.Field2811.world, blockPos, vec3d, vec3d2);
                    if (rayTraceResult3 == null) continue;
                    return rayTraceResult3;
                }
                rayTraceResult2 = new RayTraceResult(RayTraceResult.Type.MISS, vec3d, enumFacing, blockPos);
            }
            return bl3 ? rayTraceResult2 : null;
        }
        return null;
    }

    public static boolean Method2162709(BlockPos blockPos, boolean bl) {
        if (BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        if (BlockUtil.Field2811.world.getBlockState(blockPos.up()).getBlock() != Blocks.AIR || !bl && BlockUtil.Field2811.world.getBlockState(blockPos.up().up()).getBlock() != Blocks.AIR) {
            return false;
        }
        for (Entity entity : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos.up()))) {
            if (entity.isDead || entity instanceof EntityEnderCrystal) continue;
            return false;
        }
        for (Entity entity : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos.up().up()))) {
            if (entity.isDead || entity instanceof EntityEnderCrystal) continue;
            return false;
        }
        return true;
    }

    public static List<BlockPos> Method2162700(double d, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = new BlockPos(Math.floor(BlockUtil.Field2811.player.posX), Math.floor(BlockUtil.Field2811.player.posY), Math.floor(BlockUtil.Field2811.player.posZ));
        int n2 = blockPos.getX() - (int) d;
        while ((double) n2 <= (double) blockPos.getX() + d) {
            int n3 = blockPos.getY() - (int) d;
            while ((double) n3 < (double) blockPos.getY() + d) {
                int n4 = blockPos.getZ() - (int) d;
                while ((double) n4 <= (double) blockPos.getZ() + d) {
                    double d2 = (blockPos.getX() - n2) * (blockPos.getX() - n2) + (blockPos.getZ() - n4) * (blockPos.getZ() - n4) + (blockPos.getY() - n3) * (blockPos.getY() - n3);
                    BlockPos blockPos2 = new BlockPos(n2, n3, n4);
                    if (d2 < d * d && bl && !BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock().equals((Object) Blocks.AIR)) {
                        arrayList.add(blockPos2);
                    }
                    ++n4;
                }
                ++n3;
            }
            ++n2;
        }
        return arrayList;
    }

    public static EnumFacing Method2162811(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() / 2.0, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() / 2.0, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() / 2.0), false, true, false);
            if (rayTraceResult != null && (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object) blockPos)))
                continue;
            return enumFacing;
        }
        if ((double) blockPos.getY() > BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight()) {
            return EnumFacing.DOWN;
        }
        return EnumFacing.UP;
    }

    public static List<EnumFacing> Method2162812(BlockPos blockPos) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        if (BlockUtil.Field2811.world == null || blockPos == null) {
            return arrayList;
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos2);
            if (!iBlockState.getBlock().canCollideCheck(iBlockState, false) || iBlockState.getMaterial().isReplaceable())
                continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    public static EnumFacing Method2162813(BlockPos blockPos) {
        Iterator<EnumFacing> iterator = BlockUtil.Method2162812(blockPos).iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    public static EnumFacing Method2162814(BlockPos blockPos) {
        RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getX() - 0.5, (double) blockPos.getX() + 0.5));
        if (rayTraceResult == null || rayTraceResult.sideHit == null) {
            return EnumFacing.UP;
        }
        return rayTraceResult.sideHit;
    }

    public static int Method2162815(BlockPos blockPos, boolean bl) {
        return BlockUtil.Method2162816(blockPos, bl, true);
    }

    public static int Method2162816(BlockPos blockPos, boolean bl, boolean bl2) {
        Block block = BlockUtil.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
            return 0;
        }
        if (!BlockUtil.Method2162853(blockPos, bl, 0.0f)) {
            return -1;
        }
        if (bl2) {
            for (EnumFacing enumFacing : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (enumFacing instanceof EntityItem || enumFacing instanceof EntityXPOrb || enumFacing instanceof EntityArrow || enumFacing instanceof EntityExpBottle)
                    continue;
                return 1;
            }
        }
        for (EnumFacing enumFacing : BlockUtil.Method2162812(blockPos)) {
            if (!BlockUtil.Method2162833(blockPos.offset(enumFacing))) continue;
            return 3;
        }
        return 2;
    }

    public static void Method2162817(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl) {
        if (bl) {
            float f = (float) (vec3d.x - (double) blockPos.getX());
            float f2 = (float) (vec3d.y - (double) blockPos.getY());
            float f3 = (float) (vec3d.z - (double) blockPos.getZ());
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            BlockUtil.Field2811.playerController.processRightClickBlock(BlockUtil.Field2811.player, BlockUtil.Field2811.world, blockPos, enumFacing, vec3d, enumHand);
        }
        BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil.Field2811.rightClickDelayTimer = 4;
    }

    public static void Method2162818(BlockPos blockPos, float f, boolean bl, EnumHand enumHand, AtomicDouble atomicDouble, AtomicDouble atomicDouble2, AtomicBoolean atomicBoolean, boolean bl2) {
        Vec3d vec3d = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5);
        RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), vec3d);
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        RotationUtil.Method2163089();
        if (bl) {
            float[] arrf = RotationUtil.Method2163099(vec3d);
            atomicDouble.set((double) arrf[0]);
            atomicDouble2.set((double) arrf[1]);
            atomicBoolean.set(true);
        }
        BlockUtil.Method2162817(blockPos, vec3d, enumHand, enumFacing, bl2);
        BlockUtil.Field2811.player.swingArm(enumHand);
        BlockUtil.Field2811.rightClickDelayTimer = 4;
    }

    public static void Method2162819(BlockPos blockPos, float f, boolean bl, EnumHand enumHand, AtomicDouble atomicDouble, AtomicDouble atomicDouble2, AtomicBoolean atomicBoolean, boolean bl2) {
        Vec3d vec3d = RotationUtil.Method2163089();
        Vec3d vec3d2 = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5);
        double d = vec3d.squareDistanceTo(vec3d2);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d3 = vec3d2.add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
            double d2 = vec3d.squareDistanceTo(vec3d3);
            if (d2 > MathUtil.Method2163857(f) || d2 >= d || BlockUtil.Field2811.world.rayTraceBlocks(vec3d, vec3d3, false, true, false) != null)
                continue;
            if (bl) {
                float[] arrf = RotationUtil.Method2163099(vec3d3);
                atomicDouble.set((double) arrf[0]);
                atomicDouble2.set((double) arrf[1]);
                atomicBoolean.set(true);
            }
            BlockUtil.Method2162817(blockPos, vec3d3, enumHand, enumFacing, bl2);
            BlockUtil.Field2811.player.swingArm(enumHand);
            BlockUtil.Field2811.rightClickDelayTimer = 4;
            break;
        }
    }

    public static boolean Method2162810(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = BlockUtil.Method2162813(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil.Field2811.player.isSneaking() && (Field576.contains((Object) block) || Field577.contains((Object) block))) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil.Field2811.player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            RotationUtil.Method2163002(vec3d, true);
        }
        BlockUtil.Method2162817(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil.Field2811.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    public static boolean Method2162821(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = BlockUtil.Method2162813(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil.Field2811.player.isSneaking() && (Field576.contains((Object) block) || Field577.contains((Object) block))) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil.Field2811.player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            BlockUtil.Method2162822(vec3d.x, vec3d.y, vec3d.z);
        }
        BlockUtil.Method2162817(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil.Field2811.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    public static void Method2162822(double d, double d2, double d3) {
        double d4 = d - BlockUtil2.Field2811.player.posX;
        double d5 = d2 - (BlockUtil2.Field2811.player.posY + (double) BlockUtil2.Field2811.player.getEyeHeight());
        double d6 = d3 - BlockUtil2.Field2811.player.posZ;
        double d7 = Math.sqrt(d4 * d4 + d6 * d6);
        float f = (float) Math.toDegrees(Math.atan2(d6, d4)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d5, d7)));
        BlockUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(f, f2, BlockUtil2.Field2811.player.onGround));
    }

    public static boolean Method2162823(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        EnumFacing enumFacing = BlockUtil.Method2162813(blockPos);
        if (enumFacing == null) {
            return false;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil.Field2811.player.isSneaking() && (Field576.contains((Object) block) || Field577.contains((Object) block))) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            BlockUtil.Field2811.player.setSneaking(true);
        }
        if (bl) {
            RotationUtil.Method2163002(bl3 ? new Vec3d((Vec3i) blockPos) : vec3d, true);
        }
        BlockUtil.Method2162817(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        return true;
    }

    public static boolean Method2162824(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = BlockUtil.Method2162813(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock();
        if (!BlockUtil.Field2811.player.isSneaking() && (Field576.contains((Object) block) || Field577.contains((Object) block))) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            bl4 = true;
        }
        if (bl) {
            AliceMain.Field760.Method2150281(vec3d);
        }
        BlockUtil.Method2162817(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil.Field2811.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    public static void Method2162825(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = BlockUtil.Method2162824(blockPos, enumHand, bl, bl2, bl3);
        if (!bl3 && bl4) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockUtil.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
    }

    public static Vec3d[] Method2162826(Vec3d vec3d) {
        return new Vec3d[]{new Vec3d(vec3d.x, vec3d.y - 1.0, vec3d.z), new Vec3d(vec3d.x != 0.0 ? vec3d.x * 2.0 : vec3d.x, vec3d.y, vec3d.x != 0.0 ? vec3d.z : vec3d.z * 2.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x + 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z + 1.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x - 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z - 1.0), new Vec3d(vec3d.x, vec3d.y + 1.0, vec3d.z)};
    }

    public static List<BlockPos> Method2162827(float f) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) BlockUtil.Method2162829(EntityUtil.Method2163403((EntityPlayer) BlockUtil.Field2811.player), f, (int) f, false, true, 0).stream().filter(BlockUtil::Method2162831).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List<BlockPos> Method2162828(double d, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EntityPlayer entityPlayer) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = new BlockPos(entityPlayer.getPositionVector());
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = (int) d;
        int n6 = n2 - n5;
        while ((double) n6 <= (double) n2 + d) {
            int n7 = n4 - n5;
            while ((double) n7 <= (double) n4 + d) {
                int n8 = n3 - n5;
                while ((double) n8 < (double) n3 + d) {
                    BlockPos blockPos2;
                    double d2 = (n2 - n6) * (n2 - n6) + (n4 - n7) * (n4 - n7) + (n3 - n8) * (n3 - n8);
                    if (!(!(d2 < d * d) || BlockUtil.Field2811.world.getBlockState(blockPos2 = new BlockPos(n6, n8, n7)).getBlock().equals((Object) Blocks.AIR) && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IgnoreAir) || !BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock().equals((Object) Blocks.AIR) && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OnlyAir))) {
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

    public static List<BlockPos> Method2162829(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static List<BlockPos> Method2162820(BlockPos blockPos, float f) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = n2 - (int) f;
        while ((float) n5 <= (float) n2 + f) {
            int n6 = n4 - (int) f;
            while ((float) n6 <= (float) n4 + f) {
                double d = (n2 - n5) * (n2 - n5) + (n4 - n6) * (n4 - n6);
                if (d < (double) (f * f)) {
                    BlockPos blockPos2 = new BlockPos(n5, n3, n6);
                    arrayList.add(blockPos2);
                }
                ++n6;
            }
            ++n5;
        }
        return arrayList;
    }

    public static boolean Method2162831(BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            return (BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN) && BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && BlockUtil.Field2811.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
        } catch (Exception exception) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Method2162832(BlockPos blockPos, boolean bl, boolean bl2) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            if (BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
                return false;
            }
            if (!bl2 && BlockUtil.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR || BlockUtil.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                return false;
            }
            for (Entity entity : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                if (entity.isDead || bl && entity instanceof EntityEnderCrystal) continue;
                return false;
            }
            if (!bl2) {
                for (Entity entity : BlockUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                    if (entity.isDead || bl && entity instanceof EntityEnderCrystal) continue;
                    return false;
                }
            }
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static boolean Method2162833(BlockPos blockPos) {
        return BlockUtil.Method2162834(blockPos).canCollideCheck(BlockUtil.Method2162835(blockPos), false);
    }

    private static Block Method2162834(BlockPos blockPos) {
        return BlockUtil.Method2162835(blockPos).getBlock();
    }

    private static IBlockState Method2162835(BlockPos blockPos) {
        return BlockUtil.Field2811.world.getBlockState(blockPos);
    }

    public static boolean Method2162836(Entity entity) {
        if (entity != null) {
            BlockPos blockPos = new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ);
            return BlockUtil.Method2162845(blockPos);
        }
        return false;
    }

    public static void Method2162837(String string, BlockPos blockPos) {
        Command.Method2159696(string + blockPos.getX() + "x, " + blockPos.getY() + "y, " + blockPos.getZ() + "z");
    }

    public static void Method2162838(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        int n2 = BlockUtil.Field2811.player.inventory.currentItem;
        int n3 = InventoryUtil.Method2163781(Items.END_CRYSTAL);
        if (enumHand == EnumHand.MAIN_HAND && bl3 && n3 != -1 && n3 != BlockUtil.Field2811.player.inventory.currentItem) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
        BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
        if (enumHand == EnumHand.MAIN_HAND && bl3 && n3 != -1 && n3 != BlockUtil.Field2811.player.inventory.currentItem) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(bl2 ? enumHand : EnumHand.MAIN_HAND));
        }
    }

    public static void Method2162839(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        int n2 = BlockUtil.Field2811.player.inventory.currentItem;
        int n3 = InventoryUtil.Method2163781(Items.END_CRYSTAL);
        if (enumHand == EnumHand.MAIN_HAND && bl4 && n3 != -1 && n3 != BlockUtil.Field2811.player.inventory.currentItem) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
        BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
        if (enumHand == EnumHand.MAIN_HAND && bl4 && n3 != -1 && n3 != BlockUtil.Field2811.player.inventory.currentItem) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl) {
            if (bl3) {
                BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(bl2 ? enumHand : EnumHand.MAIN_HAND));
            } else {
                BlockUtil.Field2811.player.swingArm(bl2 ? enumHand : EnumHand.MAIN_HAND);
            }
        }
    }

    public static BlockPos[] Method2162830(Vec3d[] arrvec3d) {
        BlockPos[] arrblockPos = new BlockPos[arrvec3d.length];
        for (int j = 0; j < arrvec3d.length; ++j) {
            arrblockPos[j] = new BlockPos(arrvec3d[j]);
        }
        return arrblockPos;
    }

    public static Vec3d Method2162841(BlockPos blockPos) {
        return new Vec3d((Vec3i) blockPos);
    }

    public static BlockPos Method2162842(Vec3d vec3d) {
        return new BlockPos(vec3d);
    }

    public static Boolean Method2162843(BlockPos blockPos) {
        int n2 = RotationUtil.Method2164113();
        if (n2 == 0 && (double) blockPos.getZ() - BlockUtil.Field2811.player.getPositionVector().z < 0.0) {
            return false;
        }
        if (n2 == 1 && (double) blockPos.getX() - BlockUtil.Field2811.player.getPositionVector().x > 0.0) {
            return false;
        }
        if (n2 == 2 && (double) blockPos.getZ() - BlockUtil.Field2811.player.getPositionVector().z > 0.0) {
            return false;
        }
        return n2 != 3 || !((double) blockPos.getX() - BlockUtil.Field2811.player.getPositionVector().x < 0.0);
    }

    public static boolean Method2162844(Entity entity) {
        if (entity != null) {
            BlockPos blockPos = new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ);
            return BlockUtil.Method2162845(blockPos);
        }
        return false;
    }

    public static boolean Method2162845(BlockPos blockPos) {
        return !BlockUtil.Method2162846(blockPos);
    }

    public static boolean Method2162846(BlockPos blockPos) {
        return BlockUtil.Method2162847(BlockUtil.Field2811.world.getBlockState(blockPos).getBlock());
    }

    public static boolean Method2162847(Block block) {
        return Field582.contains((Object) block);
    }

    public static Vec3d[] Method2162848(Vec3d vec3d, Vec3d[] arrvec3d) {
        Vec3d[] arrvec3d2 = new Vec3d[arrvec3d.length];
        for (int j = 0; j < arrvec3d.length; ++j) {
            arrvec3d2[j] = vec3d.add(arrvec3d[j]);
        }
        return arrvec3d2;
    }

    public static Vec3d[] Method2162849(EntityPlayer entityPlayer, Vec3d[] arrvec3d) {
        return BlockUtil.Method2162848(entityPlayer.getPositionVector(), arrvec3d);
    }

    public static boolean Method2162840(BlockPos blockPos) {
        IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getBlockHardness(iBlockState, (World) BlockUtil.Field2811.world, blockPos) != -1.0f;
    }

    public static boolean Method2162851(BlockPos blockPos) {
        Block block = BlockUtil.Field2811.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockLiquid) && block.getMaterial(null) != Material.AIR;
    }

    public static boolean Method2162852(BlockPos blockPos) {
        return BlockUtil.Field2811.world.isAirBlock(blockPos) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.SNOW_LAYER || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.TALLGRASS || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid;
    }

    public static boolean Method2162853(BlockPos blockPos, boolean bl, float f) {
        return !bl || BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX(), (double) ((float) blockPos.getY() + f), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2162854(BlockPos blockPos, boolean bl) {
        return BlockUtil.Method2162853(blockPos, bl, 1.0f);
    }

    public static boolean Method2162855(BlockPos blockPos) {
        return BlockUtil.Method2162854(blockPos, true);
    }

    public static boolean Method2162856() {
        BlockPos blockPos = new BlockPos(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY, BlockUtil.Field2811.player.posZ);
        IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos);
        return BlockUtil.Method2162858(iBlockState, blockPos);
    }

    public static double Method2162857() {
        for (double d = BlockUtil.Field2811.player.posY; d > 0.0; d -= 0.001) {
            if (BlockUtil.Field2811.world.getBlockState(new BlockPos(BlockUtil.Field2811.player.posX, d, BlockUtil.Field2811.player.posZ)).getBlock() instanceof BlockSlab || BlockUtil.Field2811.world.getBlockState(new BlockPos(BlockUtil.Field2811.player.posX, d, BlockUtil.Field2811.player.posZ)).getBlock().getDefaultState().getCollisionBoundingBox((IBlockAccess) BlockUtil.Field2811.world, new BlockPos(0, 0, 0)) == null)
                continue;
            return d;
        }
        return -1.0;
    }

    public static boolean Method2162858(IBlockState iBlockState, BlockPos blockPos) {
        if (iBlockState.getBlock() != Blocks.AIR) {
            return false;
        }
        if (BlockUtil.Field2811.player.getDistanceSq(blockPos) < 1.0) {
            return false;
        }
        if (BlockUtil.Field2811.world.getBlockState(blockPos.up()).getBlock() != Blocks.AIR) {
            return false;
        }
        if (BlockUtil.Field2811.world.getBlockState(blockPos.up(2)).getBlock() != Blocks.AIR) {
            return false;
        }
        return BlockUtil.Method2162850(blockPos) || BlockUtil.Method2162859(blockPos) || BlockUtil.Method2162861(blockPos) || BlockUtil.Method2162862(blockPos);
    }

    public static boolean Method2162859(BlockPos blockPos) {
        for (BlockPos blockPos2 : BlockUtil.Method2162863(blockPos)) {
            IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.OBSIDIAN) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2162850(BlockPos blockPos) {
        for (BlockPos blockPos2 : BlockUtil.Method2162863(blockPos)) {
            IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2162861(BlockPos blockPos) {
        for (BlockPos blockPos2 : BlockUtil.Method2162863(blockPos)) {
            IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN))
                continue;
            return false;
        }
        return true;
    }

    public static boolean Method2162862(BlockPos blockPos) {
        for (BlockPos blockPos2 : BlockUtil.Method2162863(blockPos)) {
            IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.isFullBlock()) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static BlockPos[] Method2162863(BlockPos blockPos) {
        return new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()};
    }

    public static void Method2162864(BlockPos blockPos) {
        Field583 = blockPos;
        Field584 = false;
    }

    public static BlockPos Method2162865() {
        return Field583;
    }

    public static boolean Method2162866() {
        return Field583 != null && BlockUtil.Method2162867(BlockUtil.Field2811.world.getBlockState(Field583));
    }

    private static boolean Method2162867(IBlockState iBlockState) {
        return iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.AIR || iBlockState.getBlock() instanceof BlockLiquid;
    }

    public static boolean Method2162868(float f, boolean bl) {
        if (Field583 == null) {
            return false;
        }
        IBlockState iBlockState = BlockUtil.Field2811.world.getBlockState(Field583);
        if (!BlockUtil.Method2162867(iBlockState) && !(BlockUtil.Field2811.player.getDistanceSq(Field583) > Math.pow(f, f))) {
            RayTraceResult rayTraceResult;
            BlockUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            EnumFacing enumFacing = EnumFacing.UP;
            if (bl && (rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) Field583.getX() + 0.5, (double) Field583.getY() - 0.5, (double) Field583.getZ() + 0.5))) != null && rayTraceResult.sideHit != null) {
                enumFacing = rayTraceResult.sideHit;
            }
            if (!Field584) {
                Field584 = true;
                BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, Field583, enumFacing));
                BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, Field583, enumFacing));
            } else {
                BlockUtil.Field2811.playerController.onPlayerDamageBlock(Field583, enumFacing);
            }
            return true;
        }
        Field583 = null;
        return false;
    }

    public static void Method2162869(BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        if (!Util.Field2811.player.isSneaking()) {
            Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        }
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        if (bl) {
            Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, EnumHand.MAIN_HAND, (float) vec3d.x - (float) blockPos.getX(), (float) vec3d.y - (float) blockPos.getY(), (float) vec3d.z - (float) blockPos.getZ()));
        } else {
            Util.Field2811.playerController.processRightClickBlock(Util.Field2811.player, Util.Field2811.world, blockPos2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
        }
        Util.Field2811.player.swingArm(EnumHand.MAIN_HAND);
    }

    public static IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Method2162860(BlockPos blockPos) {
        if (BlockUtil.Field2811.world.isAirBlock(blockPos)) {
            return IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Blank;
        }
        if (!(BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().getBlockHardness(BlockUtil.Field2811.world.getBlockState(blockPos), (World) BlockUtil.Field2811.world, blockPos) == Float.intBitsToFloat(Float.floatToIntBits(-6.673269f) ^ 0x7F558B6B) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.OBSIDIAN) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ANVIL) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENCHANTING_TABLE) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENDER_CHEST))) {
            return IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Breakable;
        }
        if (!(BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.OBSIDIAN) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ANVIL) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENCHANTING_TABLE) || BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENDER_CHEST))) {
            if (BlockUtil.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.BEDROCK)) {
                return IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Unbreakable;
            }
            return null;
        }
        return IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Resistant;
    }

    public static List<BlockPos> Method2162871(EntityPlayer entityPlayer, double d, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n2 = (int) MathUtil.Method2163883(d, 0);
        if (bl) {
            entityPlayer.getPosition().add(new Vec3i(entityPlayer.motionX, entityPlayer.motionY, entityPlayer.motionZ));
        }
        for (int j = -n2; j <= n2; ++j) {
            for (int i2 = -n2; i2 <= n2 - n2 / 2; ++i2) {
                for (int i3 = -n2; i3 <= n2; ++i3) {
                    arrayList.add(entityPlayer.getPosition().add(j, i2, i3));
                }
            }
        }
        return arrayList;
    }

    private static boolean Method2162872(boolean bl, boolean bl2, BlockPos blockPos) {
        return BlockUtil.Method2162832(blockPos, bl, bl2);
    }

    private static boolean Method2162873(boolean bl, boolean bl2, boolean bl3, BlockPos blockPos) {
        return BlockUtil.Method2162797(blockPos, bl, bl2, bl3);
    }

    private static boolean Method2162874(Class class_, BlockPos blockPos) {
        return class_.isInstance((Object) BlockUtil.Field2811.world.getBlockState(blockPos).getBlock());
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        Blank,
        Breakable,
        Resistant,
        Unbreakable;

        public static IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll[] Field3202;

        static {
            Field3202 = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll[]{Blank, Breakable, Resistant, Unbreakable};
        }
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        OnlyAir,
        IgnoreAir,
        None;

    }
}

