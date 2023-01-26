

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
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

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CrystalUtilSC {
    public static Minecraft Field2028 = Minecraft.getMinecraft();
    private static List<Block> Field2029 = Arrays.asList(new Block[]{Blocks.OBSIDIAN, Blocks.BEDROCK, Blocks.ENDER_CHEST, Blocks.ANVIL});

    public static void Method2162897(Entity entity) {
        CrystalUtilSC.Field2028.playerController.attackEntity((EntityPlayer) CrystalUtilSC.Field2028.player, entity);
        CrystalUtilSC.Field2028.player.swingArm(EnumHand.MAIN_HAND);
    }

    public static void Method2162898(Entity entity) {
        CrystalUtilSC.Field2028.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        CrystalUtilSC.Field2028.player.swingArm(EnumHand.MAIN_HAND);
    }

    public static boolean Method2162899(double d, double d2, double d3) {
        if (CrystalUtilSC.Field2028.world.rayTraceBlocks(new Vec3d(CrystalUtilSC.Field2028.player.posX, CrystalUtilSC.Field2028.player.posY + (double) CrystalUtilSC.Field2028.player.getEyeHeight(), CrystalUtilSC.Field2028.player.posZ), new Vec3d(d, d2 + 1.8, d3), false, true, false) == null) {
            return true;
        }
        if (CrystalUtilSC.Field2028.world.rayTraceBlocks(new Vec3d(CrystalUtilSC.Field2028.player.posX, CrystalUtilSC.Field2028.player.posY + (double) CrystalUtilSC.Field2028.player.getEyeHeight(), CrystalUtilSC.Field2028.player.posZ), new Vec3d(d, d2 + 1.5, d3), false, true, false) == null) {
            return true;
        }
        return CrystalUtilSC.Field2028.world.rayTraceBlocks(new Vec3d(CrystalUtilSC.Field2028.player.posX, CrystalUtilSC.Field2028.player.posY + (double) CrystalUtilSC.Field2028.player.getEyeHeight(), CrystalUtilSC.Field2028.player.posZ), new Vec3d(d, d2, d3), false, true, false) == null;
    }

    public static boolean Method2162890(Vec3d vec3d) {
        Vec3d vec3d2 = new Vec3d(CrystalUtilSC.Field2028.player.posX, CrystalUtilSC.Field2028.player.getEntityBoundingBox().minY + (double) CrystalUtilSC.Field2028.player.getEyeHeight(), CrystalUtilSC.Field2028.player.posZ);
        return CrystalUtilSC.Field2028.world.rayTraceBlocks(vec3d2, vec3d) == null;
    }

    public static float Method2162801(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
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

    public static float Method2162802(float f) {
        int n2 = CrystalUtilSC.Field2028.world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static Vec3d Method2162803(Entity entity, int n2) {
        return entity.getPositionVector().add(CrystalUtilSC.Method2162804(entity, n2));
    }

    public static Vec3d Method2162804(Entity entity, int n2) {
        double d = entity.posX - entity.prevPosX;
        double d2 = entity.posZ - entity.prevPosZ;
        double d3 = 0.0;
        double d4 = 0.0;
        if (AliceAura.Method2150751().Field4089.getValue().booleanValue()) {
            for (int j = 1; j <= n2 && CrystalUtilSC.Field2028.world.getBlockState(new BlockPos(entity.posX + d * (double) j, entity.posY, entity.posZ + d2 * (double) j)).getBlock() instanceof BlockAir; ++j) {
                d3 = d * (double) j;
                d4 = d2 * (double) j;
            }
        } else {
            d3 = d * (double) n2;
            d4 = d2 * (double) n2;
        }
        return new Vec3d(d3, 0.0, d4);
    }

    public static int Method2162805() {
        if (Field2028.getConnection() == null) {
            return 50;
        }
        if (CrystalUtilSC.Field2028.player == null) {
            return 50;
        }
        try {
            return Field2028.getConnection().getPlayerInfo(CrystalUtilSC.Field2028.player.getUniqueID()).getResponseTime();
        } catch (NullPointerException nullPointerException) {
            return 50;
        }
    }

    public static int Method2162806() {
        int n2 = -1;
        if (Util.Field2811.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL) {
            n2 = Util.Field2811.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int j = 0; j < 9; ++j) {
                if (Util.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.END_CRYSTAL) {
                    continue;
                }
                n2 = j;
                break;
            }
        }
        return n2;
    }

    public static int Method2162807() {
        int n2 = -1;
        if (Util.Field2811.player.getHeldItemMainhand().getItem() == Items.DIAMOND_SWORD) {
            n2 = Util.Field2811.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int j = 0; j < 9; ++j) {
                if (Util.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.DIAMOND_SWORD) {
                    continue;
                }
                n2 = j;
                break;
            }
        }
        return n2;
    }

    public static boolean Method2162808(BlockPos blockPos) {
        BlockPos blockPos2;
        BlockPos blockPos3;
        block8:
        {
            block7:
            {
                blockPos3 = blockPos.add(0, 1, 0);
                blockPos2 = blockPos.add(0, 2, 0);
                if (CrystalUtilSC.Field2028.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || CrystalUtilSC.Field2028.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                    break block7;
                return false;
            }
            if (CrystalUtilSC.Field2028.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && CrystalUtilSC.Field2028.world.getBlockState(blockPos2).getBlock() == Blocks.AIR)
                break block8;
            return false;
        }
        for (Entity entity : CrystalUtilSC.Field2028.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
            if (entity instanceof EntityEnderCrystal) continue;
            return false;
        }
        try {
            for (Entity entity : CrystalUtilSC.Field2028.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                if (entity instanceof EntityEnderCrystal) continue;
                return false;
            }
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static float Method2162809(Vec3d vec3d, AxisAlignedBB axisAlignedBB) {
        double d = 1.0 / ((axisAlignedBB.maxX - axisAlignedBB.minX) * 2.0 + 1.0);
        double d2 = 1.0 / ((axisAlignedBB.maxY - axisAlignedBB.minY) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB.maxZ - axisAlignedBB.minZ) * 2.0 + 1.0);
        double d4 = (1.0 - Math.floor(1.0 / d) * d) / 2.0;
        double d5 = (1.0 - Math.floor(1.0 / d3) * d3) / 2.0;
        if (d >= 0.0 && d2 >= 0.0 && d3 >= 0.0) {
            int n2 = 0;
            int n3 = 0;
            float f = 0.0f;
            while (f <= 1.0f) {
                float f2 = 0.0f;
                while (f2 <= 1.0f) {
                    float f3 = 0.0f;
                    while (f3 <= 1.0f) {
                        double d6 = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (double) f;
                        double d7 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (double) f2;
                        double d8 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (double) f3;
                        if (CrystalUtilSC.Method2162800(new Vec3d(d6 + d4, d7, d8 + d5), vec3d) == null) {
                            ++n2;
                        }
                        ++n3;
                        f3 = (float) ((double) f3 + d3);
                    }
                    f2 = (float) ((double) f2 + d2);
                }
                f = (float) ((double) f + d);
            }
            return (float) n2 / (float) n3;
        }
        return 0.0f;
    }

    @Nullable
    public static RayTraceResult Method2162800(Vec3d vec3d, Vec3d vec3d2) {
        return CrystalUtilSC.Method2162911(vec3d, vec3d2, false, false, false);
    }

    @Nullable
    public static RayTraceResult Method2162911(Vec3d vec3d, Vec3d vec3d2, boolean bl, boolean bl2, boolean bl3) {
        if (!(Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z))) {
            if (!(Double.isNaN(vec3d2.x) || Double.isNaN(vec3d2.y) || Double.isNaN(vec3d2.z))) {
                RayTraceResult rayTraceResult;
                int n2;
                int n3;
                int n4 = MathHelper.floor((double) vec3d2.x);
                int n5 = MathHelper.floor((double) vec3d2.y);
                int n6 = MathHelper.floor((double) vec3d2.z);
                int n7 = MathHelper.floor((double) vec3d.x);
                BlockPos blockPos = new BlockPos(n7, n3 = MathHelper.floor((double) vec3d.y), n2 = MathHelper.floor((double) vec3d.z));
                IBlockState iBlockState = CrystalUtilSC.Field2028.world.getBlockState(blockPos);
                Block block = iBlockState.getBlock();
                if (!Field2029.contains((Object) block)) {
                    block = Blocks.AIR;
                    iBlockState = Blocks.AIR.getBlockState().getBaseState();
                }
                if ((!bl2 || iBlockState.getCollisionBoundingBox((IBlockAccess) CrystalUtilSC.Field2028.world, blockPos) != Block.NULL_AABB) && block.canCollideCheck(iBlockState, bl) && (rayTraceResult = iBlockState.collisionRayTrace((World) CrystalUtilSC.Field2028.world, blockPos, vec3d, vec3d2)) != null) {
                    return rayTraceResult;
                }
                RayTraceResult rayTraceResult2 = null;
                int n8 = 200;
                while (n8-- >= 0) {
                    EnumFacing enumFacing;
                    if (Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z)) {
                        return null;
                    }
                    if (n7 == n4 && n3 == n5 && n2 == n6) {
                        return bl3 ? rayTraceResult2 : null;
                    }
                    boolean bl4 = true;
                    boolean bl5 = true;
                    boolean bl6 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n4 > n7) {
                        d = (double) n7 + 1.0;
                    } else if (n4 < n7) {
                        d = (double) n7 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n5 > n3) {
                        d2 = (double) n3 + 1.0;
                    } else if (n5 < n3) {
                        d2 = (double) n3 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    if (n6 > n2) {
                        d3 = (double) n2 + 1.0;
                    } else if (n6 < n2) {
                        d3 = (double) n2 + 0.0;
                    } else {
                        bl6 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = vec3d2.x - vec3d.x;
                    double d8 = vec3d2.y - vec3d.y;
                    double d9 = vec3d2.z - vec3d.z;
                    if (bl4) {
                        d4 = (d - vec3d.x) / d7;
                    }
                    if (bl5) {
                        d5 = (d2 - vec3d.y) / d8;
                    }
                    if (bl6) {
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
                        enumFacing = n4 > n7 ? EnumFacing.WEST : EnumFacing.EAST;
                        vec3d = new Vec3d(d, vec3d.y + d8 * d4, vec3d.z + d9 * d4);
                    } else if (d5 < d6) {
                        enumFacing = n5 > n3 ? EnumFacing.DOWN : EnumFacing.UP;
                        vec3d = new Vec3d(vec3d.x + d7 * d5, d2, vec3d.z + d9 * d5);
                    } else {
                        enumFacing = n6 > n2 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                        vec3d = new Vec3d(vec3d.x + d7 * d6, vec3d.y + d8 * d6, d3);
                    }
                    n7 = MathHelper.floor((double) vec3d.x) - (enumFacing == EnumFacing.EAST ? 1 : 0);
                    n3 = MathHelper.floor((double) vec3d.y) - (enumFacing == EnumFacing.UP ? 1 : 0);
                    n2 = MathHelper.floor((double) vec3d.z) - (enumFacing == EnumFacing.SOUTH ? 1 : 0);
                    blockPos = new BlockPos(n7, n3, n2);
                    IBlockState iBlockState2 = CrystalUtilSC.Field2028.world.getBlockState(blockPos);
                    Block block2 = iBlockState2.getBlock();
                    if (!Field2029.contains((Object) block2)) {
                        block2 = Blocks.AIR;
                        iBlockState2 = Blocks.AIR.getBlockState().getBaseState();
                    }
                    if (bl2 && iBlockState2.getMaterial() != Material.PORTAL && iBlockState2.getCollisionBoundingBox((IBlockAccess) CrystalUtilSC.Field2028.world, blockPos) == Block.NULL_AABB)
                        continue;
                    if (block2.canCollideCheck(iBlockState2, bl)) {
                        RayTraceResult rayTraceResult3 = iBlockState2.collisionRayTrace((World) CrystalUtilSC.Field2028.world, blockPos, vec3d, vec3d2);
                        if (rayTraceResult3 == null) continue;
                        return rayTraceResult3;
                    }
                    rayTraceResult2 = new RayTraceResult(RayTraceResult.Type.MISS, vec3d, enumFacing, blockPos);
                }
                return bl3 ? rayTraceResult2 : null;
            }
            return null;
        }
        return null;
    }

    public static float Method2162912(BlockPos blockPos, Entity entity) {
        return CrystalUtilSC.Method2162914(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), entity);
    }

    public static float Method2162913(BlockPos blockPos, Entity entity) {
        return CrystalUtilSC.Method2162914((double) blockPos.getX() + 0.5, blockPos.getY() + 1, (double) blockPos.getZ() + 0.5, entity);
    }

    public static float Method2162914(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        Vec3d vec3d = CrystalUtilSC.Method2162803(entity, AliceAura.Method2150751().Field4090.getValue() > 0 ? AliceAura.Method2150751().Field4090.getValue() : 0);
        double d4 = vec3d.distanceTo(new Vec3d(d, d2, d3)) / (double) f;
        Vec3d vec3d2 = new Vec3d(d, d2, d3);
        double d5 = 0.0;
        try {
            d5 = AliceAura.Method2150751().Field4091.getValue() != false ? (double) CrystalUtilSC.Method2162809(vec3d2, AliceAura.Method2150751().Field4090.getValue() > 0 ? entity.getEntityBoundingBox().offset(CrystalUtilSC.Method2162804(entity, AliceAura.Method2150751().Field4090.getValue())) : entity.getEntityBoundingBox()) : (double) entity.world.getBlockDensity(vec3d2, AliceAura.Method2150751().Field4090.getValue() > 0 ? entity.getEntityBoundingBox().offset(CrystalUtilSC.Method2162804(entity, AliceAura.Method2150751().Field4090.getValue())) : entity.getEntityBoundingBox());
        } catch (Exception exception) {
            // empty catch block
        }
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * (double) f + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = CrystalUtilSC.Method2162801((EntityLivingBase) entity, CrystalUtilSC.Method2162802(f2), new Explosion((World) CrystalUtilSC.Field2028.world, (Entity) CrystalUtilSC.Field2028.player, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    public static float Method2162915(EntityEnderCrystal entityEnderCrystal, Entity entity) {
        return CrystalUtilSC.Method2162914(entityEnderCrystal.posX, entityEnderCrystal.posY, entityEnderCrystal.posZ, entity);
    }

    public static boolean Method2162916(BlockPos blockPos) {
        if (AliceAura.Method2150751().Field4080.getValue() != AliceAura.IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.VANILLA) {
            double d = 0.45;
            double d2 = 0.05;
            double d3 = 0.95;
            Vec3d vec3d = new Vec3d(CrystalUtilSC.Field2028.player.posX, CrystalUtilSC.Field2028.player.getEntityBoundingBox().minY + (double) CrystalUtilSC.Field2028.player.getEyeHeight(), CrystalUtilSC.Field2028.player.posZ);
            for (double d4 = d2; d4 <= d3; d4 += d) {
                for (double d5 = d2; d5 <= d3; d5 += d) {
                    for (double d6 = d2; d6 <= d3; d6 += d) {
                        Vec3d vec3d2 = new Vec3d((Vec3i) blockPos).add(d4, d5, d6);
                        double d7 = vec3d.distanceTo(vec3d2);
                        if (AliceAura.Method2150751().Field4067.getValue().booleanValue() && d7 > (double) AliceAura.Method2150751().Field4074.getValue().floatValue())
                            continue;
                        double d8 = vec3d2.x - vec3d.x;
                        double d9 = vec3d2.y - vec3d.y;
                        double d10 = vec3d2.z - vec3d.z;
                        double d11 = MathHelper.sqrt((double) (d8 * d8 + d10 * d10));
                        double[] arrd = new double[]{MathHelper.wrapDegrees((float) ((float) Math.toDegrees(Math.atan2(d10, d8)) - 90.0f)), MathHelper.wrapDegrees((float) ((float) (-Math.toDegrees(Math.atan2(d9, d11)))))};
                        float f = MathHelper.cos((float) ((float) (-arrd[0] * 0.01745329238474369 - 3.1415927410125732)));
                        float f2 = MathHelper.sin((float) ((float) (-arrd[0] * 0.01745329238474369 - 3.1415927410125732)));
                        float f3 = -MathHelper.cos((float) ((float) (-arrd[1] * 0.01745329238474369)));
                        float f4 = MathHelper.sin((float) ((float) (-arrd[1] * 0.01745329238474369)));
                        Vec3d vec3d3 = new Vec3d((double) (f2 * f3), (double) f4, (double) (f * f3));
                        Vec3d vec3d4 = vec3d.add(vec3d3.x * d7, vec3d3.y * d7, vec3d3.z * d7);
                        RayTraceResult rayTraceResult = CrystalUtilSC.Field2028.world.rayTraceBlocks(vec3d, vec3d4, false, false, false);
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                            continue;
                        return true;
                    }
                }
            }
            return false;
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            RayTraceResult rayTraceResult;
            Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
            if (AliceAura.Method2150751().Field4067.getValue().booleanValue() && CrystalUtilSC.Field2028.player.getPositionVector().add(0.0, (double) CrystalUtilSC.Field2028.player.getEyeHeight(), 0.0).distanceTo(vec3d) > (double) AliceAura.Method2150751().Field4074.getValue().floatValue() || (rayTraceResult = CrystalUtilSC.Field2028.world.rayTraceBlocks(new Vec3d(CrystalUtilSC.Field2028.player.posX, CrystalUtilSC.Field2028.player.posY + (double) CrystalUtilSC.Field2028.player.getEyeHeight(), CrystalUtilSC.Field2028.player.posZ), vec3d, false, true, false)) == null || !rayTraceResult.typeOfHit.equals((Object) RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                continue;
            return true;
        }
        return false;
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends RuntimeException {
        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
            this.setStackTrace(new StackTraceElement[0]);
        }

        @Override
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }
}

