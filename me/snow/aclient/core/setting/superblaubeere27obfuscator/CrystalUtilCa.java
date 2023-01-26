

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
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

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilCa;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
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
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CrystalUtilCa
        implements Util {
    public static Boolean Method2162072(EntityPlayer entityPlayer, float f) {
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

    public static boolean Method2162073(Vec3d vec3d, Vec3d vec3d2, boolean bl) {
        if (!(Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z) || Double.isNaN(vec3d2.x) || Double.isNaN(vec3d2.y) || Double.isNaN(vec3d2.z))) {
            int n2 = MathHelper.floor((double) vec3d.x);
            int n3 = MathHelper.floor((double) vec3d.y);
            int n4 = MathHelper.floor((double) vec3d.z);
            int n5 = MathHelper.floor((double) vec3d2.x);
            int n6 = MathHelper.floor((double) vec3d2.y);
            int n7 = MathHelper.floor((double) vec3d2.z);
            BlockPos blockPos = new BlockPos(n2, n3, n4);
            IBlockState iBlockState = CrystalUtilCa.Field2811.world.getBlockState(blockPos);
            Block block = iBlockState.getBlock();
            if (iBlockState.getCollisionBoundingBox((IBlockAccess) CrystalUtilCa.Field2811.world, blockPos) != Block.NULL_AABB && block.canCollideCheck(iBlockState, false) && (CrystalUtilCa.Method2162078().contains((Object) block) || !bl)) {
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
                if (!(block = (iBlockState = CrystalUtilCa.Field2811.world.getBlockState(blockPos = new BlockPos(n2 = MathHelper.floor((double) vec3d.x) - (enumFacing == EnumFacing.EAST ? 1 : 0), n3 = MathHelper.floor((double) vec3d.y) - (enumFacing == EnumFacing.UP ? 1 : 0), n4 = MathHelper.floor((double) vec3d.z) - (enumFacing == EnumFacing.SOUTH ? 1 : 0)))).getBlock()).canCollideCheck(iBlockState, false) || !CrystalUtilCa.Method2162078().contains((Object) block) && bl)
                    continue;
                return true;
            }
        }
        return false;
    }

    public static float Method2162074(float f) {
        switch (1.F ield1312[CrystalUtilCa.Field2811.world.getDifficulty().ordinal()]){
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

    public static float Method2162075(BlockPos blockPos, Entity entity, boolean bl) {
        return CrystalUtilCa.Method2162077(entity, new Vec3d((double) blockPos.getX() + 0.5, (double) (blockPos.getY() + 1), (double) blockPos.getZ() + 0.5), 6.0f, bl);
    }

    public static float Method2162076(Entity entity, Entity entity2, boolean bl) {
        return CrystalUtilCa.Method2162077(entity2, new Vec3d(entity.posX, entity.posY, entity.posZ), 6.0f, bl);
    }

    public static float Method2162077(Entity entity, Vec3d vec3d, float f, boolean bl) {
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
                        if (!CrystalUtilCa.Method2162073(vec3d4, vec3d, bl)) {
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
            f2 = CrystalUtilCa.Method2162079((EntityLivingBase) entity, CrystalUtilCa.Method2162074(f2), new Explosion((World) CrystalUtilCa.Field2811.world, null, vec3d.x, vec3d.y, vec3d.z, f / 2.0f, false, true));
        }
        return f2;
    }

    public static List<Block> Method2162078() {
        return Arrays.asList(new Block[]{Blocks.OBSIDIAN, Blocks.BEDROCK, Blocks.COMMAND_BLOCK, Blocks.BARRIER, Blocks.ENCHANTING_TABLE, Blocks.ENDER_CHEST, Blocks.END_PORTAL_FRAME, Blocks.BEACON, Blocks.ANVIL});
    }

    public static float Method2162079(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
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

    public static float Method2162070(float f) {
        int n2 = DamageUtil.Field2811.world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static List<BlockPos> Method2162081(float f, boolean bl, boolean bl2) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) CrystalUtilCa.Method2162082(PlayerUtilCa.Method2163174(), f, (int) f, false, true, 0).stream().filter(CrystalUtilCa::Method2162094).filter(arg_0 -> CrystalUtilCa.Method2162093(bl, bl2, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List<BlockPos> Method2162082(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static boolean Method2162083(BlockPos blockPos) {
        return CrystalUtilCa.Field2811.world.rayTraceBlocks(new Vec3d(CrystalUtilCa.Field2811.player.posX, CrystalUtilCa.Field2811.player.posY + (double) CrystalUtilCa.Field2811.player.getEyeHeight(), CrystalUtilCa.Field2811.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) (blockPos.getY() + 1), (double) blockPos.getZ() + 0.5), false, true, false) == null;
    }

    public static boolean Method2162084(int n2, int n3, double d) {
        return (double) n3 + d < (double) n2 - d && (double) n2 - d < (double) n3;
    }

    public static boolean Method2162085(BlockPos blockPos, BlockPos blockPos2, double d) {
        return CrystalUtilCa.Method2162084(blockPos.getX(), blockPos2.getX(), d) && CrystalUtilCa.Method2162084(blockPos.getY(), blockPos2.getY(), d) && CrystalUtilCa.Method2162084(blockPos.getZ(), blockPos2.getZ(), d);
    }

    public static EntityEnderCrystal Method2162086(BlockPos blockPos) {
        for (Entity entity : CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
            if (CrystalUtilCa.Method2162085(blockPos, entity.getPosition(), 0.5)) {
                Command.Method2159696("shit too close");
                continue;
            }
            if (!(entity instanceof EntityEnderCrystal)) continue;
            return (EntityEnderCrystal) entity;
        }
        return null;
    }

    public static boolean Method2162087(BlockPos blockPos, boolean bl, boolean bl2) {
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
                                if (CrystalUtilCa.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || CrystalUtilCa.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                                    break block16;
                                return false;
                            }
                            if (CrystalUtilCa.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR || CrystalUtilCa.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
                                return false;
                            }
                            if (bl) break block17;
                            return CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
                        }
                        for (Entity entity : CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                        for (Entity entity : CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                        break block18;
                    }
                    if (CrystalUtilCa.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || CrystalUtilCa.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                        break block19;
                    return false;
                }
                if (CrystalUtilCa.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                    return false;
                }
                if (bl) break block20;
                return CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty();
            }
            try {
                for (Entity entity : CrystalUtilCa.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
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

    public static Entity Method2162088(Entity entity, double d) {
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
                if (CrystalUtilCa.Method2162089(0.0, 0.0, 0.0, entity)) {
                    d3 = bl2 ? 0.4 : -0.07840015258789;
                } else {
                    d3 -= 0.08;
                    d3 *= (double) 0.98f;
                }
                entityPlayer = CrystalUtilCa.Method2162080(d2, d3, d4, (EntityPlayer) entity);
            } else {
                if (CrystalUtilCa.Method2162089(0.0, 0.0, 0.0, entityPlayer)) {
                    d3 = bl2 ? 0.4 : -0.07840015258789;
                } else {
                    d3 -= 0.08;
                    d3 *= (double) 0.98f;
                }
                entityPlayer = CrystalUtilCa.Method2162080(d2, d3, d4, entityPlayer);
            }
            ++n2;
        }
        return entityPlayer;
    }

    public static boolean Method2162089(double d, double d2, double d3, Entity entity) {
        double d4 = d2;
        try {
            List list = CrystalUtilCa.Field2811.world.getCollisionBoxes(entity, entity.getEntityBoundingBox().expand(d, d2, d3));
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

    public static EntityPlayer Method2162080(double d, double d2, double d3, EntityPlayer entityPlayer) {
        int n2;
        int n3;
        List list = CrystalUtilCa.Field2811.world.getCollisionBoxes((Entity) entityPlayer, entityPlayer.getEntityBoundingBox().expand(d, d2, d3));
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
                d = CrystalUtilCa.Method2162091(entityPlayer.getEntityBoundingBox(), d, (AxisAlignedBB) list.get(n2));
            }
            if (d != 0.0) {
                entityPlayer.setEntityBoundingBox(entityPlayer.getEntityBoundingBox().offset(d, 0.0, 0.0));
            }
        }
        if (d3 != 0.0) {
            n3 = list.size();
            for (n2 = 0; n2 < n3; ++n2) {
                d3 = CrystalUtilCa.Method2162092(entityPlayer.getEntityBoundingBox(), d3, (AxisAlignedBB) list.get(n2));
            }
            if (d3 != 0.0) {
                entityPlayer.setEntityBoundingBox(entityPlayer.getEntityBoundingBox().offset(0.0, 0.0, d3));
            }
        }
        return entityPlayer;
    }

    public static double Method2162091(AxisAlignedBB axisAlignedBB, double d, AxisAlignedBB axisAlignedBB2) {
        if (axisAlignedBB.maxY > axisAlignedBB2.minY && axisAlignedBB.minY < axisAlignedBB2.maxY && axisAlignedBB.maxZ > axisAlignedBB2.minZ && axisAlignedBB.minZ < axisAlignedBB2.maxZ) {
            double d2;
            if (d > 0.0 && axisAlignedBB.maxX <= axisAlignedBB2.minX) {
                double d3 = axisAlignedBB2.minX - 0.3 - axisAlignedBB.maxX;
                if (d3 < d) {
                    d = d3;
                }
            } else if (d < 0.0 && axisAlignedBB.minX >= axisAlignedBB2.maxX && (d2 = axisAlignedBB2.maxX + 0.3 - axisAlignedBB.minX) > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double Method2162092(AxisAlignedBB axisAlignedBB, double d, AxisAlignedBB axisAlignedBB2) {
        if (axisAlignedBB.maxX > axisAlignedBB2.minX && axisAlignedBB.minX < axisAlignedBB2.maxX && axisAlignedBB.maxY > axisAlignedBB2.minY && axisAlignedBB.minY < axisAlignedBB2.maxY) {
            double d2;
            if (d > 0.0 && axisAlignedBB.maxZ <= axisAlignedBB2.minZ) {
                double d3 = axisAlignedBB2.minZ - 0.3 - axisAlignedBB.maxZ;
                if (d3 < d) {
                    d = d3;
                }
            } else if (d < 0.0 && axisAlignedBB.minZ >= axisAlignedBB2.maxZ && (d2 = axisAlignedBB2.maxZ + 0.3 - axisAlignedBB.minZ) > d) {
                d = d2;
            }
        }
        return d;
    }

    private static boolean Method2162093(boolean bl, boolean bl2, BlockPos blockPos) {
        return CrystalUtilCa.Method2162087(blockPos, bl, bl2);
    }

    private static boolean Method2162094(BlockPos blockPos) {
        return CrystalUtilCa.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.AIR;
    }
}

