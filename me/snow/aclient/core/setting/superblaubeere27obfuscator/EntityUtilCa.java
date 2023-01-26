

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
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathsUtilCa;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class EntityUtilCa
        implements Util {
    public static boolean Method2162095(Entity entity) {
        return EntityUtilCa.Field2811.world.rayTraceBlocks(new Vec3d(EntityUtilCa.Field2811.player.posX, EntityUtilCa.Field2811.player.posX + (double) EntityUtilCa.Field2811.player.getEyeHeight(), EntityUtilCa.Field2811.player.posZ), new Vec3d(entity.posX, entity.posY, entity.posZ), false, true, false) == null;
    }

    public static boolean Method2162096(Entity entity, int n2, boolean bl) {
        return EntityUtilCa.Method2162097(entity, n2, bl).size() == 0;
    }

    public static List<Vec3d> Method2162097(Entity entity, int n2, boolean bl) {
        return EntityUtilCa.Method2162099(entity.getPositionVector(), n2, bl);
    }

    public static boolean Method2162098(Entity entity, BlockPos blockPos) {
        return entity.posY >= (double) blockPos.getY();
    }

    public static List<Vec3d> Method2162099(Vec3d vec3d, int n2, boolean bl) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (Vec3d vec3d2 : EntityUtilCa.Method2163111(n2, bl)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = EntityUtilCa.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static boolean Method2162090(Entity entity) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY + 0.01;
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                if (!(EntityUtilCa.Field2811.world.getBlockState(new BlockPos(j, (int) d, i2)).getBlock() instanceof BlockLiquid))
                    continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method2162001(Entity entity) {
        if (entity instanceof EntityWolf && ((EntityWolf) entity).isAngry()) {
            return false;
        }
        if (entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid) {
            return true;
        }
        return entity instanceof EntityIronGolem && ((EntityIronGolem) entity).getRevengeTarget() == null;
    }

    public static boolean Method2162002(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.MONSTER, false) && !EntityUtilCa.Method2162003(entity) || entity instanceof EntitySpider;
    }

    public static boolean Method2162003(Entity entity) {
        return entity instanceof EntityPigZombie || entity instanceof EntityWolf || entity instanceof EntityEnderman;
    }

    public static boolean Method2162004(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY;
        double d2 = bl ? 0.03 : (entity instanceof EntityPlayer ? 0.2 : 0.5);
        double d3 = d - d2;
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                if (!(EntityUtilCa.Field2811.world.getBlockState(new BlockPos(j, MathHelper.floor((double) d3), i2)).getBlock() instanceof BlockLiquid))
                    continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method2162005() {
        return !EntityUtilCa.Field2811.player.isSneaking() && (EntityUtilCa.Field2811.player.getRidingEntity() == null || EntityUtilCa.Field2811.player.getRidingEntity().fallDistance < 3.0f) && EntityUtilCa.Field2811.player.fallDistance < 3.0f;
    }

    public static boolean Method2162006(double d) {
        if (EntityUtilCa.Field2811.player.fallDistance >= 3.0f) {
            return false;
        }
        AxisAlignedBB axisAlignedBB = EntityUtilCa.Field2811.player.getRidingEntity() != null ? EntityUtilCa.Field2811.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, -d, 0.0) : EntityUtilCa.Field2811.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, -d, 0.0);
        boolean bl = false;
        int n2 = (int) axisAlignedBB.minY;
        for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) (axisAlignedBB.maxX + 1.0)); ++j) {
            for (int i2 = MathHelper.floor((double) axisAlignedBB.minZ); i2 < MathHelper.floor((double) (axisAlignedBB.maxZ + 1.0)); ++i2) {
                Block block = EntityUtilCa.Field2811.world.getBlockState(new BlockPos(j, n2, i2)).getBlock();
                if (block == Blocks.AIR) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    public static BlockPos Method2162007(Entity entity) {
        return new BlockPos(MathsUtilCa.Method2163150(entity.getPositionVector(), 0));
    }

    public static boolean Method2162008(boolean bl) {
        if (bl && EntityUtilCa.Field2811.player != null) {
            EntityUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) EntityUtilCa.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public static Vec3d[] Method2162009(Vec3d vec3d, int n2, boolean bl) {
        List<Vec3d> list = EntityUtilCa.Method2162099(vec3d, n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2162000(Entity entity, int n2, boolean bl) {
        List<Vec3d> list = EntityUtilCa.Method2162097(entity, n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2163111(int n2, boolean bl) {
        List<Vec3d> list = EntityUtilCa.Method2163112(n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2163112(int n2, boolean bl) {
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

    public static void Method2163113(Entity entity, boolean bl, boolean bl2) {
        if (bl) {
            EntityUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtilCa.Field2811.playerController.attackEntity((EntityPlayer) EntityUtilCa.Field2811.player, entity);
        }
        if (bl2) {
            EntityUtilCa.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static void Method2163114(Entity entity, boolean bl) {
        if (bl) {
            EntityUtilCa.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtilCa.Field2811.playerController.attackEntity((EntityPlayer) EntityUtilCa.Field2811.player, entity);
        }
    }

    public static BlockPos Method2163115(Entity entity) {
        return new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
    }

    public static boolean Method2163116(Entity entity) {
        return EntityUtilCa.Method2163117(new BlockPos(entity.posX, entity.posY, entity.posZ));
    }

    public static boolean Method2163117(BlockPos blockPos) {
        return EntityUtilCa.Method2163119(blockPos) || EntityUtilCa.Method2163118(blockPos) || EntityUtilCa.Method2163110(blockPos);
    }

    public static boolean Method2163118(BlockPos blockPos) {
        for (BlockPos blockPos2 : new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtilCa.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.OBSIDIAN) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2163119(BlockPos blockPos) {
        for (BlockPos blockPos2 : new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtilCa.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2163110(BlockPos blockPos) {
        for (BlockPos blockPos2 : new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtilCa.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN))
                continue;
            return false;
        }
        return true;
    }

    public static Vec3d Method2163121(Entity entity, float f) {
        return EntityUtilCa.Method2163122(entity, f).subtract(EntityUtilCa.Field2811.getRenderManager().renderPosX, EntityUtilCa.Field2811.getRenderManager().renderPosY, EntityUtilCa.Field2811.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2163122(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(EntityUtilCa.Method2163123(entity, f));
    }

    public static Vec3d Method2163123(Entity entity, float f) {
        return EntityUtilCa.Method2163124(entity, f, f, f);
    }

    public static Vec3d Method2163124(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static boolean Method2163125(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    public static BlockPos Method2163126() {
        return new BlockPos(EntityUtilCa.Field2811.player.getRidingEntity() != null ? EntityUtilCa.Field2811.player.getRidingEntity().posX : EntityUtilCa.Field2811.player.posX, EntityUtilCa.Field2811.player.getRidingEntity() != null ? EntityUtilCa.Field2811.player.getRidingEntity().posY : EntityUtilCa.Field2811.player.posY, EntityUtilCa.Field2811.player.getRidingEntity() != null ? EntityUtilCa.Field2811.player.getRidingEntity().posZ : EntityUtilCa.Field2811.player.posZ);
    }

    public static Vec3d Method2163127(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f);
    }

    public static List<BlockPos> Method2163128(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n4 = blockPos.getX();
        int n5 = blockPos.getY();
        int n6 = blockPos.getZ();
        int n7 = n4 - (int) f;
        while ((float) n7 <= (float) n4 + f) {
            int n8 = n6 - (int) f;
            while ((float) n8 <= (float) n6 + f) {
                int n9 = bl2 ? n5 - (int) f : n5;
                while (true) {
                    float f2 = n9;
                    float f3 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    if (!(f2 < f3)) break;
                    double d = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n7, n9 + n3, n8);
                        arrayList.add(blockPos2);
                    }
                    ++n9;
                }
                ++n8;
            }
            ++n7;
        }
        return arrayList;
    }

    public static List<BlockPos> Method2163129(BlockPos blockPos, float f, float f2, boolean bl, boolean bl2, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        int n6 = n3 - (int) f;
        while ((float) n6 <= (float) n3 + f) {
            int n7 = n5 - (int) f;
            while ((float) n7 <= (float) n5 + f) {
                int n8 = bl2 ? n4 - (int) f : n4;
                while (true) {
                    float f3 = n8;
                    float f4 = bl2 ? (float) n4 + f : (float) n4 + f2;
                    if (!(f3 < f4)) break;
                    double d = (n3 - n6) * (n3 - n6) + (n5 - n7) * (n5 - n7) + (bl2 ? (n4 - n8) * (n4 - n8) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n6, n8 + n2, n7);
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

    public static boolean Method2163120(EntityPlayer entityPlayer) {
        return EntityUtilCa.Method2163131(entityPlayer.getHeldItemMainhand());
    }

    public static boolean Method2163131(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.getTagCompound() == null) {
            return false;
        }
        NBTTagList nBTTagList = (NBTTagList) itemStack.getTagCompound().getTag("ench");
        if (nBTTagList == null) {
            return false;
        }
        for (int j = 0; j < nBTTagList.tagCount(); ++j) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(j);
            if (nBTTagCompound.getInteger("id") != 16) continue;
            int n2 = nBTTagCompound.getInteger("lvl");
            if (n2 < 42) break;
            return true;
        }
        return false;
    }

    public static float Method2163132(Entity entity) {
        if (entity.isEntityAlive()) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            return entityLivingBase.getHealth() + entityLivingBase.getAbsorptionAmount();
        }
        return 0.0f;
    }

    public static boolean Method2163133(Entity entity, double d) {
        return entity == null || !entity.isEntityAlive() || entity.equals((Object) EntityUtilCa.Field2811.player) || entity instanceof EntityPlayer && AliceMain.Field765.Method2150168(entity.getName()) || EntityUtilCa.Field2811.player.getDistanceSq(entity) > d * d;
    }

    public static Color Method2163134(Entity entity, int n2, int n3, int n4, int n5, boolean bl) {
        Color color = new Color((float) n2 / 255.0f, (float) n3 / 255.0f, (float) n4 / 255.0f, (float) n5 / 255.0f);
        if (entity instanceof EntityPlayer) {
            if (bl && AliceMain.Field765.Method2150168(entity.getName())) {
                color = new Color(0.33f, 1.0f, 1.0f, (float) n5 / 255.0f);
            }
            if (bl && !AliceMain.Field765.Method2150168(entity.getName())) {
                color = new Color(1.0f, 0.33f, 1.0f, (float) n5 / 255.0f);
            }
        }
        return color;
    }

    public static void Method2163135(float f) {
        EntityUtilCa.Field2811.timer.tickLength = 50.0f / f;
    }

    public static void Method2163136() {
        EntityUtilCa.Field2811.timer.tickLength = 50.0f;
    }

    public static Block Method2163137(double d, double d2, double d3) {
        Block block = null;
        if (EntityUtilCa.Field2811.player != null) {
            AxisAlignedBB axisAlignedBB = EntityUtilCa.Field2811.player.getRidingEntity() != null ? EntityUtilCa.Field2811.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(d, d2, d3) : EntityUtilCa.Field2811.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(d, d2, d3);
            int n2 = (int) axisAlignedBB.minY;
            for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) axisAlignedBB.maxX) + 1; ++j) {
                for (int i2 = MathHelper.floor((double) axisAlignedBB.minZ); i2 < MathHelper.floor((double) axisAlignedBB.maxZ) + 1; ++i2) {
                    block = EntityUtilCa.Field2811.world.getBlockState(new BlockPos(j, n2, i2)).getBlock();
                }
            }
        }
        return block;
    }

    public static boolean Method2163138() {
        if (EntityUtilCa.Field2811.player != null) {
            if (EntityUtilCa.Field2811.player.fallDistance >= 3.0f) {
                return false;
            }
            boolean bl = false;
            AxisAlignedBB axisAlignedBB = EntityUtilCa.Field2811.player.getRidingEntity() != null ? EntityUtilCa.Field2811.player.getRidingEntity().getEntityBoundingBox() : EntityUtilCa.Field2811.player.getEntityBoundingBox();
            int n2 = (int) axisAlignedBB.minY;
            for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) axisAlignedBB.maxX) + 1; ++j) {
                for (int i2 = MathHelper.floor((double) axisAlignedBB.minZ); i2 < MathHelper.floor((double) axisAlignedBB.maxZ) + 1; ++i2) {
                    Block block = EntityUtilCa.Field2811.world.getBlockState(new BlockPos(j, n2, i2)).getBlock();
                    if (block instanceof BlockAir) continue;
                    if (!(block instanceof BlockLiquid)) {
                        return false;
                    }
                    bl = true;
                }
            }
            return bl;
        }
        return false;
    }

    public static double Method2163139(double d) {
        return 1.0 / (1.0 + Math.pow(Math.E, -1.0 * d));
    }

    public static double Method2163130(double d, double d2) {
        double d3 = Math.abs(d);
        d3 -= d2;
        d3 = EntityUtilCa.Method2163139(d3);
        return d3;
    }
}

