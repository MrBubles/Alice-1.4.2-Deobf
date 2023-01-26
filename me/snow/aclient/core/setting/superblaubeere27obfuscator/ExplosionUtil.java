

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
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

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ExplosionUtil
        implements Util {
    public static float Method2163589(Entity entity, Vec3d vec3d, boolean bl) {
        return ExplosionUtil.Method2163580(entity, vec3d, 6.0f, bl);
    }

    public static float Method2163580(Entity entity, Vec3d vec3d, float f, boolean bl) {
        PotionEffect potionEffect;
        double d = (double) f * 2.0;
        double d2 = entity.getDistance(vec3d.x, vec3d.y, vec3d.z) / d;
        if (d2 > 1.0) {
            return 0.0f;
        }
        double d3 = (1.0 - d2) * ExplosionUtil.Method2163591(bl, vec3d, entity.getEntityBoundingBox());
        float f2 = CombatRules.getDamageAfterAbsorb((float) ExplosionUtil.Method2163593((float) ((d3 * d3 + d3) / 2.0 * 7.0 * d + 1.0)), (float) ((EntityLivingBase) entity).getTotalArmorValue(), (float) ((float) ((EntityLivingBase) entity).getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion) new Explosion(entity.world, entity, vec3d.x, vec3d.y, vec3d.z, (float) d, false, true));
        int n2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable) entity.getArmorInventoryList(), (DamageSource) damageSource);
        if (n2 > 0) {
            f2 = CombatRules.getDamageAfterMagicAbsorb((float) f2, (float) n2);
        }
        if (((EntityLivingBase) entity).isPotionActive(MobEffects.RESISTANCE) && (potionEffect = ((EntityLivingBase) entity).getActivePotionEffect(MobEffects.RESISTANCE)) != null) {
            f2 = f2 * (25.0f - (float) ((potionEffect.getAmplifier() + 1) * 5)) / 25.0f;
        }
        return Math.max(f2, 0.0f);
    }

    public static double Method2163591(boolean bl, Vec3d vec3d, AxisAlignedBB axisAlignedBB) {
        double d = 1.0 / ((axisAlignedBB.maxX - axisAlignedBB.minX) * 2.0 + 1.0);
        double d2 = 1.0 / ((axisAlignedBB.maxY - axisAlignedBB.minY) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB.maxZ - axisAlignedBB.minZ) * 2.0 + 1.0);
        double d4 = (1.0 - Math.floor(1.0 / d) * d) / 2.0;
        double d5 = (1.0 - Math.floor(1.0 / d3) * d3) / 2.0;
        if (d >= 0.0 && d2 >= 0.0 && d3 >= 0.0) {
            float f = 0.0f;
            float f2 = 0.0f;
            for (double d6 = 0.0; d6 <= 1.0; d6 += d) {
                for (double d7 = 0.0; d7 <= 1.0; d7 += d2) {
                    for (double d8 = 0.0; d8 <= 1.0; d8 += d3) {
                        double d9 = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d6;
                        double d10 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d7;
                        double d11 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d8;
                        if (!ExplosionUtil.Method2163592(new Vec3d(d9 + d4, d10, d11 + d5), vec3d, bl)) {
                            f += 1.0f;
                        }
                        f2 += 1.0f;
                    }
                }
            }
            return f / f2;
        }
        return 0.0;
    }

    public static boolean Method2163592(Vec3d vec3d, Vec3d vec3d2, boolean bl) {
        if (!(Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z) || Double.isNaN(vec3d2.x) || Double.isNaN(vec3d2.y) || Double.isNaN(vec3d2.z))) {
            RayTraceResult rayTraceResult;
            int n2 = MathHelper.floor((double) vec3d.x);
            int n3 = MathHelper.floor((double) vec3d.y);
            int n4 = MathHelper.floor((double) vec3d.z);
            int n5 = MathHelper.floor((double) vec3d2.x);
            int n6 = MathHelper.floor((double) vec3d2.y);
            int n7 = MathHelper.floor((double) vec3d2.z);
            BlockPos blockPos = new BlockPos(n2, n3, n4);
            IBlockState iBlockState = ExplosionUtil.Field2811.world.getBlockState(blockPos);
            Block block = iBlockState.getBlock();
            if (iBlockState.getCollisionBoundingBox((IBlockAccess) ExplosionUtil.Field2811.world, blockPos) != Block.NULL_AABB && block.canCollideCheck(iBlockState, false) && (BlockUtil.Field580.contains((Object) block) || BlockUtil.Field581.contains((Object) block) || !bl) && (rayTraceResult = iBlockState.collisionRayTrace((World) ExplosionUtil.Field2811.world, blockPos, vec3d, vec3d2)) != null) {
                return true;
            }
            double d = vec3d2.x - vec3d.x;
            double d2 = vec3d2.y - vec3d.y;
            double d3 = vec3d2.z - vec3d.z;
            int n8 = 200;
            while (n8-- >= 0) {
                RayTraceResult rayTraceResult2;
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
                    d4 = n2 + 1;
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
                if (!(block = (iBlockState = ExplosionUtil.Field2811.world.getBlockState(blockPos = new BlockPos(n2 = MathHelper.floor((double) vec3d.x) - (enumFacing == EnumFacing.EAST ? 1 : 0), n3 = MathHelper.floor((double) vec3d.y) - (enumFacing == EnumFacing.UP ? 1 : 0), n4 = MathHelper.floor((double) vec3d.z) - (enumFacing == EnumFacing.SOUTH ? 1 : 0)))).getBlock()).canCollideCheck(iBlockState, false) || !BlockUtil.Field580.contains((Object) block) && !BlockUtil.Field581.contains((Object) block) && bl || (rayTraceResult2 = iBlockState.collisionRayTrace((World) ExplosionUtil.Field2811.world, blockPos, vec3d, vec3d2)) == null)
                    continue;
                return true;
            }
        }
        return false;
    }

    public static float Method2163593(float f) {
        WorldClient worldClient = ExplosionUtil.Field2811.world;
        if (worldClient == null) {
            return f;
        }
        switch (1.F ield3677[ExplosionUtil.Field2811.world.getDifficulty().ordinal()]){
            case 1: {
                return 0.0f;
            }
            case 2: {
                return Math.min(f / 2.0f + 1.0f, f);
            }
            default: {
                return f;
            }
            case 4:
        }
        return f * 3.0f / 2.0f;
    }
}

