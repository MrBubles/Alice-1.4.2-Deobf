

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEmptyDrops
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEmptyDrops;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CrystalUtil
        implements Util {
    public static final AxisAlignedBB Field1455 = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 2.0, 1.0);

    public static boolean Method2164319(BlockPos blockPos) {
        if (!(CrystalUtil.Field2811.world.getBlockState(blockPos.offset(EnumFacing.DOWN)).getBlock() instanceof BlockEmptyDrops)) {
            return false;
        }
        if (!(CrystalUtil.Field2811.world.getBlockState(blockPos.offset(EnumFacing.DOWN)).getBlock() instanceof BlockObsidian)) {
            return false;
        }
        return CrystalUtil.Field2811.world.checkNoEntityCollision(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 2.0, 1.0).offset(blockPos), (Entity) null);
    }

    public static double Method2164310(Vec3d vec3d, double d, double d2, double d3) {
        double d4 = vec3d.x - d;
        double d5 = vec3d.y - d2;
        double d6 = vec3d.z - d3;
        return Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public static List<BlockPos> Method2164321(Vec3d vec3d, double d, double d2, boolean bl, boolean bl2, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = (int) vec3d.x;
        int n4 = (int) vec3d.y;
        int n5 = (int) vec3d.z;
        int n6 = n3 - (int) d;
        while ((double) n6 <= (double) n3 + d) {
            int n7 = n5 - (int) d;
            block1:
            while ((double) n7 <= (double) n5 + d) {
                int n8 = bl2 ? n4 - (int) d : n4;
                while (true) {
                    double d3;
                    double d4 = n8;
                    double d5 = d3 = bl2 ? (double) n4 + d : (double) n4 + d2;
                    if (!(d4 < d3)) {
                        ++n7;
                        continue block1;
                    }
                    double d6 = (n3 - n6) * (n3 - n6) + (n5 - n7) * (n5 - n7) + (bl2 ? (n4 - n8) * (n4 - n8) : 0);
                    if (!(!(d6 < d * d) || bl && d6 < (d - 1.0) * (d - 1.0))) {
                        BlockPos blockPos = new BlockPos(n6, n8 + n2, n7);
                        arrayList.add(blockPos);
                    }
                    ++n8;
                }
            }
            ++n6;
        }
        return arrayList;
    }

    public static float Method2164322(double d, double d2, double d3, Entity entity, Vec3d vec3d) {
        float f = 12.0f;
        double d4 = CrystalUtil.Method2164310(vec3d, d, d2, d3) / (double) f;
        Vec3d vec3d2 = new Vec3d(d, d2, d3);
        double d5 = entity.world.getBlockDensity(vec3d2, entity.getEntityBoundingBox());
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * (double) f + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = CrystalUtil.Method2164341((EntityLivingBase) entity, CrystalUtil.Method2164342(f2), new Explosion((World) CrystalUtil.Field2811.world, null, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    public static float Method2164323(double d, double d2, double d3, Entity entity) {
        Vec3d vec3d = new Vec3d(entity.posX, entity.posY, entity.posZ);
        return CrystalUtil.Method2164322(d, d2, d3, entity, vec3d);
    }

    public static void Method2164324(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        int n2 = BlockUtil.Field2811.player.inventory.currentItem;
        int n3 = InventoryUtil2.Method2164541(Items.END_CRYSTAL);
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

    public static void Method2164325(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2) {
        RayTraceResult rayTraceResult = BlockUtil.Field2811.world.rayTraceBlocks(new Vec3d(BlockUtil.Field2811.player.posX, BlockUtil.Field2811.player.posY + (double) BlockUtil.Field2811.player.getEyeHeight(), BlockUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        int n2 = BlockUtil.Field2811.player.inventory.currentItem;
        int n3 = InventoryUtil2.Method2164541(Items.END_CRYSTAL);
        BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
        if (bl) {
            BlockUtil.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(bl2 ? enumHand : EnumHand.MAIN_HAND));
        }
    }

    public static List<BlockPos> Method2164326(float f, boolean bl, boolean bl2) {
        float f2 = f;
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n2 = CrystalUtil.Field2811.player.getPosition().getX() - (int) f2;
        while ((float) n2 <= (float) CrystalUtil.Field2811.player.getPosition().getX() + f2) {
            int n3 = CrystalUtil.Field2811.player.getPosition().getZ() - (int) f2;
            while ((float) n3 <= (float) CrystalUtil.Field2811.player.getPosition().getZ() + f2) {
                int n4;
                boolean bl3 = bl;
                int n5 = n4 = bl3 ? CrystalUtil.Field2811.player.getPosition().getY() - (int) f2 : CrystalUtil.Field2811.player.getPosition().getY();
                while ((float) n4 < (float) CrystalUtil.Field2811.player.getPosition().getY() + f2) {
                    boolean bl4 = bl2;
                    double d = (CrystalUtil.Field2811.player.getPosition().getX() - n2) * (CrystalUtil.Field2811.player.getPosition().getX() - n2) + (CrystalUtil.Field2811.player.getPosition().getZ() - n3) * (CrystalUtil.Field2811.player.getPosition().getZ() - n3) + (bl3 ? (CrystalUtil.Field2811.player.getPosition().getY() - n4) * (CrystalUtil.Field2811.player.getPosition().getY() - n4) : 0);
                    if (d < (double) (f2 * f2) && (!bl4 || d >= ((double) f2 - Double.longBitsToDouble(Double.doubleToLongBits(638.4060856917202) ^ 0x7F73F33FA9DAEA7FL)) * ((double) f2 - Double.longBitsToDouble(Double.doubleToLongBits(13.015128470890444) ^ 0x7FDA07BEEB3F6D07L)))) {
                        arrayList.add(new BlockPos(n2, n4, n3));
                    }
                    ++n4;
                }
                ++n3;
            }
            ++n2;
        }
        return arrayList;
    }

    public static EntityPlayer Method2164327(float f) {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : new ArrayList(CrystalUtil.Field2811.world.playerEntities)) {
            if (CrystalUtil.Field2811.player.getDistanceSq((Entity) entityPlayer2) > MathUtil.Method2163857(f) || entityPlayer2 == CrystalUtil.Field2811.player || AliceMain.Field765.Method2150168(entityPlayer2.getName()) || entityPlayer2.isDead || entityPlayer2.getHealth() <= Float.intBitsToFloat(Float.floatToIntBits(1.2784752E38f) ^ 0x7EC05D13))
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (CrystalUtil.Field2811.player.getDistanceSq((Entity) entityPlayer2) >= CrystalUtil.Field2811.player.getDistanceSq((Entity) entityPlayer))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static EnumActionResult Method2164328(BlockPos blockPos) {
        double d = (double) blockPos.getX() + 0.5 - CrystalUtil.Field2811.player.posX;
        double d2 = (double) (blockPos.getY() - 1) + 0.5 - CrystalUtil.Field2811.player.posY - 0.5 - (double) CrystalUtil.Field2811.player.getEyeHeight();
        double d3 = (double) blockPos.getZ() + 0.5 - CrystalUtil.Field2811.player.posZ;
        double d4 = CrystalUtil.Method2164329(d3, d);
        double d5 = CrystalUtil.Method2164329(d2, Math.sqrt(d * d + d3 * d3));
        Vec3d vec3d = CrystalUtil.Method2164320(-d5, d4 - 90.0);
        return CrystalUtil.Field2811.playerController.processRightClickBlock(CrystalUtil.Field2811.player, CrystalUtil.Field2811.world, blockPos.offset(EnumFacing.DOWN), EnumFacing.UP, vec3d, CrystalUtil.Field2811.player.getActiveHand());
    }

    protected static final double Method2164329(double d, double d2) {
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

    protected static final Vec3d Method2164320(double d, double d2) {
        float f = MathHelper.cos((float) ((float) (-d2 * 0.01745329238474369 - 3.1415927410125732)));
        float f2 = MathHelper.sin((float) ((float) (-d2 * 0.01745329238474369 - 3.1415927410125732)));
        float f3 = -MathHelper.cos((float) ((float) (-d * 0.01745329238474369)));
        float f4 = MathHelper.sin((float) ((float) (-d * 0.01745329238474369)));
        return new Vec3d((double) (f2 * f3), (double) f4, (double) (f * f3));
    }

    public static EnumActionResult Method2164331(BlockPos blockPos) {
        blockPos.offset(EnumFacing.DOWN);
        double d = (double) blockPos.getX() + 0.5 - CrystalUtil.Field2811.player.posX;
        double d2 = (double) blockPos.getY() + 0.5 - CrystalUtil.Field2811.player.posY - 0.5 - (double) CrystalUtil.Field2811.player.getEyeHeight();
        double d3 = (double) blockPos.getZ() + 0.5 - CrystalUtil.Field2811.player.posZ;
        double d4 = CrystalUtil.Method2164329(d3, d);
        double d5 = CrystalUtil.Method2164329(d2, Math.sqrt(d * d + d3 * d3));
        Vec3d vec3d = CrystalUtil.Method2164320(-d5, d4 - 90.0);
        if (((ItemStack) CrystalUtil.Field2811.player.inventory.offHandInventory.get(0)).getItem().getClass().equals(Item.getItemById((int) 426).getClass())) {
            return CrystalUtil.Field2811.playerController.processRightClickBlock(CrystalUtil.Field2811.player, CrystalUtil.Field2811.world, blockPos.offset(EnumFacing.DOWN), EnumFacing.UP, vec3d, EnumHand.OFF_HAND);
        }
        if (InventoryUtil2.Method2164515(426, false) != -1) {
            InventoryUtil2.Method2164512(InventoryUtil2.Method2164515(426, false));
            return CrystalUtil.Field2811.playerController.processRightClickBlock(CrystalUtil.Field2811.player, CrystalUtil.Field2811.world, blockPos.offset(EnumFacing.DOWN), EnumFacing.UP, vec3d, EnumHand.MAIN_HAND);
        }
        return EnumActionResult.FAIL;
    }

    public static boolean Method2164332(BlockPos blockPos) {
        blockPos.offset(EnumFacing.DOWN);
        double d = (double) blockPos.getX() + 0.5 - CrystalUtil.Field2811.player.posX;
        double d2 = (double) blockPos.getY() + 0.5 - CrystalUtil.Field2811.player.posY - 0.5 - (double) CrystalUtil.Field2811.player.getEyeHeight();
        double d3 = (double) blockPos.getZ() + 0.5 - CrystalUtil.Field2811.player.posZ;
        double d4 = CrystalUtil.Method2164329(d3, d);
        double d5 = CrystalUtil.Method2164329(d2, Math.sqrt(d * d + d3 * d3));
        int n2 = InventoryUtil2.Method2164515(426, false);
        if (n2 == -1 && ((ItemStack) CrystalUtil.Field2811.player.inventory.offHandInventory.get(0)).getItem() != Items.END_CRYSTAL) {
            return false;
        }
        Vec3d vec3d = CrystalUtil.Method2164320(-d5, d4 - 90.0);
        if (((ItemStack) CrystalUtil.Field2811.player.inventory.offHandInventory.get(0)).getItem() == Items.END_CRYSTAL) {
            Field2811.getConnection().sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos.offset(EnumFacing.DOWN), EnumFacing.UP, EnumHand.OFF_HAND, 0.0f, 0.0f, 0.0f));
        } else if (InventoryUtil2.Method2164515(426, false) != -1) {
            Field2811.getConnection().sendPacket((Packet) new CPacketHeldItemChange(n2));
            Field2811.getConnection().sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos.offset(EnumFacing.DOWN), EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
        }
        return true;
    }

    public static double Method2164333(Vec3d vec3d, @Nullable Entity entity) {
        Entity entity2 = entity == null ? CrystalUtil.Field2811.player : entity;
        float f = 6.0f;
        float f2 = f * 2.0f;
        Vec3d vec3d2 = vec3d;
        if (!entity2.isImmuneToExplosions()) {
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            double d6 = entity2.getDistance(vec3d.x, vec3d.y, vec3d.z) / (double) f2;
            if (d5 <= 1.0 && (d4 = (double) MathHelper.sqrt((double) ((d3 = entity2.posX - vec3d.x) * d3 + (d2 = entity2.posY + (double) entity2.getEyeHeight() - vec3d.y) * d2 + (d = entity2.posZ - vec3d.z) * d))) != 0.0) {
                d3 /= d4;
                d2 /= d4;
                d /= d4;
                double d7 = CrystalUtil.Field2811.world.getBlockDensity(vec3d, entity2.getEntityBoundingBox());
                double d8 = (1.0 - d6) * d7;
                return (int) ((d8 * d8 + d8) / 2.0 * 7.0 * (double) f2 + 1.0);
            }
        }
        return 0.0;
    }

    public static Boolean Method2164334(EntityPlayer entityPlayer, float f) {
        for (ItemStack itemStack : entityPlayer.getArmorInventoryList()) {
            if (itemStack == null || itemStack.getItem() == Items.AIR) {
                return true;
            }
            float f2 = (float) (itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float) itemStack.getMaxDamage() * 100.0f;
            if (!(f >= f2) || itemStack.stackSize >= 2) continue;
            return true;
        }
        return false;
    }

    public static boolean Method2164335(Vec3d vec3d, Vec3d vec3d2, boolean bl) {
        if (!(Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z) || Double.isNaN(vec3d2.x) || Double.isNaN(vec3d2.y) || Double.isNaN(vec3d2.z))) {
            int n2 = MathHelper.floor((double) vec3d.x);
            int n3 = MathHelper.floor((double) vec3d.y);
            int n4 = MathHelper.floor((double) vec3d.z);
            int n5 = MathHelper.floor((double) vec3d2.x);
            int n6 = MathHelper.floor((double) vec3d2.y);
            int n7 = MathHelper.floor((double) vec3d2.z);
            BlockPos blockPos = new BlockPos(n2, n3, n4);
            IBlockState iBlockState = CrystalUtil.Field2811.world.getBlockState(blockPos);
            Block block = iBlockState.getBlock();
            if (iBlockState.getCollisionBoundingBox((IBlockAccess) CrystalUtil.Field2811.world, blockPos) != Block.NULL_AABB && block.canCollideCheck(iBlockState, false) && (CrystalUtil.Method2164330().contains((Object) block) || !bl)) {
                return true;
            }
            double d = vec3d2.x - vec3d.x;
            double d2 = vec3d2.y - vec3d.y;
            double d3 = vec3d2.z - vec3d.z;
            int n8 = 200;
            while (n8-- >= 0) {
                EnumFacing enumFacing;
                if (Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z)) {
                    return false;
                }
                if (n2 == n5 && n3 == n6 && n4 == n7) {
                    return false;
                }
                boolean bl2 = true;
                boolean bl3 = true;
                boolean bl4 = true;
                double d4 = 999.0;
                double d5 = 999.0;
                double d6 = 999.0;
                double d7 = 999.0;
                double d8 = 999.0;
                double d9 = 999.0;
                if (n5 > n2) {
                    d4 = (double) n2 + 1.0;
                } else if (n5 < n2) {
                    d4 = n2;
                } else {
                    bl2 = false;
                }
                if (n6 > n3) {
                    d5 = (double) n3 + 1.0;
                } else if (n6 < n3) {
                    d5 = n3;
                } else {
                    bl3 = false;
                }
                if (n7 > n4) {
                    d6 = (double) n4 + 1.0;
                } else if (n7 < n4) {
                    d6 = n4;
                } else {
                    bl4 = false;
                }
                if (bl2) {
                    d7 = (d4 - vec3d.x) / d;
                }
                if (bl3) {
                    d8 = (d5 - vec3d.y) / d2;
                }
                if (bl4) {
                    d9 = (d6 - vec3d.z) / d3;
                }
                if (d7 == 0.0) {
                    d7 = -1.0E-4;
                }
                if (d8 == 0.0) {
                    d8 = -1.0E-4;
                }
                if (d9 == 0.0) {
                    d9 = -1.0E-4;
                }
                if (d7 < d8 && d7 < d9) {
                    enumFacing = n5 > n2 ? EnumFacing.WEST : EnumFacing.EAST;
                    vec3d = new Vec3d(d4, vec3d.y + d2 * d7, vec3d.z + d3 * d7);
                } else if (d8 < d9) {
                    enumFacing = n6 > n3 ? EnumFacing.DOWN : EnumFacing.UP;
                    vec3d = new Vec3d(vec3d.x + d * d8, d5, vec3d.z + d3 * d8);
                } else {
                    enumFacing = n7 > n4 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                    vec3d = new Vec3d(vec3d.x + d * d9, vec3d.y + d2 * d9, d6);
                }
                n2 = MathHelper.floor((double) vec3d.x) - (enumFacing == EnumFacing.EAST ? 1 : 0);
                n3 = MathHelper.floor((double) vec3d.y) - (enumFacing == EnumFacing.UP ? 1 : 0);
                n4 = MathHelper.floor((double) vec3d.z) - (enumFacing == EnumFacing.SOUTH ? 1 : 0);
                blockPos = new BlockPos(n2, n3, n4);
                iBlockState = CrystalUtil.Field2811.world.getBlockState(blockPos);
                block = iBlockState.getBlock();
                if (!block.canCollideCheck(iBlockState, false) || !CrystalUtil.Method2164330().contains((Object) block) && bl)
                    continue;
                return true;
            }
        }
        return false;
    }

    public static float Method2164336(float f) {
        switch (1.F ield558[CrystalUtil.Field2811.world.getDifficulty().ordinal()]){
            case 1: {
                return 0.0f;
            }
            case 2: {
                return Math.min(f / 2.0f + 1.0f, f);
            }
            case 3: {
                return f * 3.0f / 2.0f;
            }
        }
        return f;
    }

    public static float Method2164337(BlockPos blockPos, Entity entity, boolean bl) {
        return CrystalUtil.Method2164339(entity, new Vec3d((double) blockPos.getX() + 0.5, (double) (blockPos.getY() + 1), (double) blockPos.getZ() + 0.5), 6.0f, bl);
    }

    public static float Method2164338(Entity entity, Entity entity2, boolean bl) {
        return CrystalUtil.Method2164339(entity2, new Vec3d(entity.posX, entity.posY, entity.posZ), 6.0f, bl);
    }

    public static float Method2164339(Entity entity, Vec3d vec3d, float f, boolean bl) {
        Vec3d vec3d2 = new Vec3d(entity.posX, entity.posY, entity.posZ);
        if (entity.isImmuneToExplosions()) {
            return 0.0f;
        }
        double d = vec3d2.distanceTo(vec3d) / (double) (f *= 2.0f);
        double d2 = 0.0;
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().offset(entity.getPositionVector().subtract(vec3d2));
        Vec3d vec3d3 = new Vec3d(1.0 / ((axisAlignedBB.maxX - axisAlignedBB.minX) * 2.0 + 1.0), 1.0 / ((axisAlignedBB.maxY - axisAlignedBB.minY) * 2.0 + 1.0), 1.0 / ((axisAlignedBB.maxZ - axisAlignedBB.minZ) * 2.0 + 1.0));
        double d3 = (1.0 - Math.floor(1.0 / vec3d3.x) * vec3d3.x) / 2.0;
        double d4 = (1.0 - Math.floor(1.0 / vec3d3.z) * vec3d3.z) / 2.0;
        if (vec3d3.x >= 0.0 && vec3d3.y >= 0.0 && vec3d3.z >= 0.0) {
            int n2 = 0;
            int n3 = 0;
            for (double d5 = 0.0; d5 <= 1.0; d5 += vec3d3.x) {
                for (double d6 = 0.0; d6 <= 1.0; d6 += vec3d3.y) {
                    for (double d7 = 0.0; d7 <= 1.0; d7 += vec3d3.z) {
                        Vec3d vec3d4 = new Vec3d(d3 + axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d5, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d6, d4 + axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d7);
                        if (!CrystalUtil.Method2164335(vec3d4, vec3d, bl)) {
                            ++n2;
                        }
                        ++n3;
                    }
                }
            }
            d2 = (double) n2 / (double) n3;
        }
        double d8 = (1.0 - d) * d2;
        float f2 = (int) ((d8 * d8 + d8) / 2.0 * 7.0 * (double) f + 1.0);
        if (entity instanceof EntityLivingBase) {
            f2 = CrystalUtil.Method2164341((EntityLivingBase) entity, CrystalUtil.Method2164336(f2), new Explosion((World) CrystalUtil.Field2811.world, null, vec3d.x, vec3d.y, vec3d.z, f / 2.0f, false, true));
        }
        return f2;
    }

    public static List<Block> Method2164330() {
        return Arrays.asList(new Block[]{Blocks.OBSIDIAN, Blocks.BEDROCK, Blocks.COMMAND_BLOCK, Blocks.BARRIER, Blocks.ENCHANTING_TABLE, Blocks.ENDER_CHEST, Blocks.END_PORTAL_FRAME, Blocks.BEACON, Blocks.ANVIL});
    }

    public static float Method2164341(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
        f = CombatRules.getDamageAfterAbsorb((float) f, (float) entityLivingBase.getTotalArmorValue(), (float) ((float) entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        float f2 = 0.0f;
        try {
            f2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable) entityLivingBase.getArmorInventoryList(), (DamageSource) DamageSource.causeExplosionDamage((Explosion) explosion));
        } catch (Exception exception) {
            // empty catch block
        }
        f2 = MathHelper.clamp((float) f2, (float) 0.0f, (float) 20.0f);
        f *= 1.0f - f2 / 25.0f;
        PotionEffect potionEffect = entityLivingBase.getActivePotionEffect(MobEffects.RESISTANCE);
        if (entityLivingBase.isPotionActive(MobEffects.RESISTANCE) && potionEffect != null) {
            f = f * (25.0f - (float) (potionEffect.getAmplifier() + 1) * 5.0f) / 25.0f;
        }
        f = Math.max(f, 0.0f);
        return f;
    }

    public static float Method2164342(float f) {
        int n2 = CrystalUtil.Field2811.world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static List<BlockPos> Method2164343(float f, boolean bl, boolean bl2) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) CrystalUtil.Method2164344(PlayerUtil.Method2163942(), f, (int) f, false, true, 0).stream().filter(CrystalUtil::Method2164353).filter(arg_0 -> CrystalUtil.Method2164352(bl, bl2, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List<BlockPos> Method2164344(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static boolean Method2164345(BlockPos blockPos) {
        return CrystalUtil.Field2811.world.rayTraceBlocks(new Vec3d(CrystalUtil.Field2811.player.posX, CrystalUtil.Field2811.player.posY + (double) CrystalUtil.Field2811.player.getEyeHeight(), CrystalUtil.Field2811.player.posZ), new Vec3d((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2164346(BlockPos blockPos, boolean bl, boolean bl2) {
        block18:
        {
            BlockPos blockPos2;
            block20:
            {
                block19:
                {
                    blockPos2 = blockPos.add(0, 1, 0);
                    BlockPos blockPos3 = blockPos.add(0, 2, 0);
                    if (!bl2) {
                        block17:
                        {
                            block16:
                            {
                                if (CrystalUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || CrystalUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                                    break block16;
                                return false;
                            }
                            if (CrystalUtil.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR || CrystalUtil.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
                                return false;
                            }
                            if (bl) break block17;
                            return CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
                        }
                        for (Entity entity : CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                        for (Entity entity : CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                        break block18;
                    }
                    if (CrystalUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || CrystalUtil.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                        break block19;
                    return false;
                }
                if (CrystalUtil.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                    return false;
                }
                if (bl) break block20;
                return CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty();
            }
            try {
                for (Entity entity : CrystalUtil.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                    if (entity instanceof EntityEnderCrystal) continue;
                    return false;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static Entity Method2164347(Entity entity, double d) {
        if (d == 0.0) {
            return entity;
        }
        EntityPlayer entityPlayer = null;
        double d2 = entity.posX - entity.lastTickPosX;
        double d3 = entity.posY - entity.lastTickPosY;
        double d4 = entity.posZ - entity.lastTickPosZ;
        boolean bl = false;
        boolean bl2 = false;
        double d5 = Math.sqrt(Math.pow(d2, 2.0) + Math.pow(d4, 2.0) + Math.pow(d3, 2.0));
        if (d5 > 0.1) {
            bl = true;
        }
        if (!bl) {
            return entity;
        }
        if (d5 > 0.31) {
            bl2 = true;
        }
        int n2 = 0;
        while ((double) n2 < d) {
            if (entityPlayer == null) {
                if (CrystalUtil.Method2164348(0.0, 0.0, 0.0, entity)) {
                    d3 = bl2 ? 0.4 : -0.07840015258789;
                } else {
                    d3 -= 0.08;
                    d3 *= (double) 0.98f;
                }
                entityPlayer = CrystalUtil.Method2164349(d2, d3, d4, (EntityPlayer) entity);
            } else {
                if (CrystalUtil.Method2164348(0.0, 0.0, 0.0, entityPlayer)) {
                    d3 = bl2 ? 0.4 : -0.07840015258789;
                } else {
                    d3 -= 0.08;
                    d3 *= (double) 0.98f;
                }
                entityPlayer = CrystalUtil.Method2164349(d2, d3, d4, entityPlayer);
            }
            ++n2;
        }
        return entityPlayer;
    }

    public static boolean Method2164348(double d, double d2, double d3, Entity entity) {
        double d4 = d2;
        try {
            List list = CrystalUtil.Field2811.world.getCollisionBoxes(entity, entity.getEntityBoundingBox().expand(d, d2, d3));
            if (d2 != 0.0) {
                int n2 = list.size();
                for (int j = 0; j < n2; ++j) {
                    d2 = ((AxisAlignedBB) list.get(j)).calculateYOffset(entity.getEntityBoundingBox(), d2);
                }
            }
            return d4 != d2 && d4 < 0.0;
        } catch (Exception exception) {
            return false;
        }
    }

    public static EntityPlayer Method2164349(double d, double d2, double d3, EntityPlayer entityPlayer) {
        int n2;
        int n3;
        List list = CrystalUtil.Field2811.world.getCollisionBoxes((Entity) entityPlayer, entityPlayer.getEntityBoundingBox().expand(d, d2, d3));
        if (d2 != 0.0) {
            n3 = list.size();
            for (n2 = 0; n2 < n3; ++n2) {
                d2 = ((AxisAlignedBB) list.get(n2)).calculateYOffset(entityPlayer.getEntityBoundingBox(), d2);
            }
            if (d2 != 0.0) {
                entityPlayer.setEntityBoundingBox(entityPlayer.getEntityBoundingBox().offset(0.0, d2, 0.0));
            }
        }
        if (d != 0.0) {
            n3 = list.size();
            for (n2 = 0; n2 < n3; ++n2) {
                d = CrystalUtil.Method2164340(entityPlayer.getEntityBoundingBox(), d, (AxisAlignedBB) list.get(n2));
            }
            if (d != 0.0) {
                entityPlayer.setEntityBoundingBox(entityPlayer.getEntityBoundingBox().offset(d, 0.0, 0.0));
            }
        }
        if (d3 != 0.0) {
            n3 = list.size();
            for (n2 = 0; n2 < n3; ++n2) {
                d3 = CrystalUtil.Method2164351(entityPlayer.getEntityBoundingBox(), d3, (AxisAlignedBB) list.get(n2));
            }
            if (d3 != 0.0) {
                entityPlayer.setEntityBoundingBox(entityPlayer.getEntityBoundingBox().offset(0.0, 0.0, d3));
            }
        }
        return entityPlayer;
    }

    public static double Method2164340(AxisAlignedBB axisAlignedBB, double d, AxisAlignedBB axisAlignedBB2) {
        if (axisAlignedBB.maxY > axisAlignedBB2.minY && axisAlignedBB.minY < axisAlignedBB2.maxY && axisAlignedBB.maxZ > axisAlignedBB2.minZ && axisAlignedBB.minZ < axisAlignedBB2.maxZ) {
            if (d > 0.0 && axisAlignedBB.maxX <= axisAlignedBB2.minX) {
                double d2 = axisAlignedBB2.minX - 0.3 - axisAlignedBB.maxX;
                if (d2 < d) {
                    d = d2;
                }
            } else if (d < 0.0 && axisAlignedBB.minX >= axisAlignedBB2.maxX) {
                double d3;
                double d4 = axisAlignedBB2.maxX + 0.3 - axisAlignedBB.minX;
                if (d3 > d) {
                    d = d4;
                }
            }
        }
        return d;
    }

    public static double Method2164351(AxisAlignedBB axisAlignedBB, double d, AxisAlignedBB axisAlignedBB2) {
        if (axisAlignedBB.maxX > axisAlignedBB2.minX && axisAlignedBB.minX < axisAlignedBB2.maxX && axisAlignedBB.maxY > axisAlignedBB2.minY && axisAlignedBB.minY < axisAlignedBB2.maxY) {
            if (d > 0.0 && axisAlignedBB.maxZ <= axisAlignedBB2.minZ) {
                double d2 = axisAlignedBB2.minZ - 0.3 - axisAlignedBB.maxZ;
                if (d2 < d) {
                    d = d2;
                }
            } else if (d < 0.0 && axisAlignedBB.minZ >= axisAlignedBB2.maxZ) {
                double d3;
                double d4 = axisAlignedBB2.maxZ + 0.3 - axisAlignedBB.minZ;
                if (d3 > d) {
                    d = d4;
                }
            }
        }
        return d;
    }

    private static boolean Method2164352(boolean bl, boolean bl2, BlockPos blockPos) {
        return CrystalUtil.Method2164346(blockPos, bl, bl2);
    }

    private static boolean Method2164353(BlockPos blockPos) {
        return CrystalUtil.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.AIR;
    }
}

