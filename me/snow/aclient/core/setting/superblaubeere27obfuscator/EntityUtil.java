

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockSnow
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.EmptyChunk
 *  org.jetbrains.annotations.NotNull
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Aura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Blink;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import me.snow.aclient.mixin.mixins.accessors.IEntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.chunk.EmptyChunk;
import org.jetbrains.annotations.NotNull;

public class EntityUtil
        implements Util {
    public static final Vec3d[] Field2097 = new Vec3d[]{new Vec3d(0.0, -2.0, 0.0)};
    public static final Vec3d[] Field2098 = new Vec3d[]{new Vec3d(0.0, -1.0, 0.0), new Vec3d(0.0, -1.0, -1.0), new Vec3d(0.0, -1.0, 1.0), new Vec3d(-1.0, -1.0, 0.0), new Vec3d(1.0, -1.0, 0.0)};
    public static final Vec3d[] Field2099 = new Vec3d[]{new Vec3d(-1.0, 0.0, 0.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(0.0, 0.0, 1.0)};
    public static final Vec3d[] Field2100 = new Vec3d[]{new Vec3d(-1.0, 0.0, 0.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-2.0, 0.0, 0.0), new Vec3d(2.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -2.0), new Vec3d(0.0, 0.0, 2.0)};
    public static final Vec3d[] Field2101 = new Vec3d[]{new Vec3d(1.0, 1.0, 0.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(0.0, 2.0, 0.0)};
    public static final Vec3d[] Field2102 = new Vec3d[]{new Vec3d(0.0, 2.0, 0.0)};
    public static final Vec3d[] Field2103 = new Vec3d[]{new Vec3d(1.0, 1.0, 0.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(0.0, 1.0, -1.0)};
    public static final Vec3d[] Field2104 = new Vec3d[]{new Vec3d(-1.0, 2.0, 0.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(0.0, 2.0, -1.0)};
    public static final Vec3d[] Field2105 = new Vec3d[]{new Vec3d(0.0, 3.0, 0.0)};

    public static float Method2163467(EntityEnderCrystal entityEnderCrystal, EntityPlayer entityPlayer) {
        return EntityUtil.Method2163484(entityEnderCrystal.posX, entityEnderCrystal.posY, entityEnderCrystal.posZ, (Entity) entityPlayer);
    }

    public static Block Method2163468(BlockPos blockPos) {
        return EntityUtil.Field2811.world.getBlockState(blockPos).getBlock();
    }

    public static Boolean Method2163469(BlockPos blockPos, Block block) {
        return EntityUtil.Method2163468(blockPos).equals((Object) block);
    }

    public static double Method2163460() {
        double d = 0.272;
        if (Util.Field2811.player.isPotionActive(MobEffects.SPEED)) {
            int n2 = Objects.requireNonNull(Util.Field2811.player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier();
            d *= 1.0 + 0.2 * (double) n2;
        }
        return d;
    }

    public static List<EntityPlayer> Method2163471() {
        return EntityUtil.Field2811.world.playerEntities.stream().filter(EntityUtil::Method2163588).collect(Collectors.toList());
    }

    public static BlockPos Method2163472(double d) {
        return new BlockPos(Math.floor(EntityUtil.Field2811.player.posX), Math.floor(EntityUtil.Field2811.player.posY + d), Math.floor(EntityUtil.Field2811.player.posZ));
    }

    public static BlockPos Method2163473() {
        return new BlockPos(EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.posY, EntityUtil.Field2811.player.posZ);
    }

    public static boolean Method2163474(EntityLivingBase entityLivingBase) {
        return (double) entityLivingBase.moveForward != 0.0 || (double) entityLivingBase.moveStrafing != 0.0;
    }

    public static double[] Method2163475(double d) {
        float f = EntityUtil.Field2811.player.movementInput.moveForward;
        float f2 = EntityUtil.Field2811.player.movementInput.moveStrafe;
        float f3 = EntityUtil.Field2811.player.prevRotationYaw + (EntityUtil.Field2811.player.rotationYaw - EntityUtil.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double) f * d * d3 + (double) f2 * d * d2;
        double d5 = (double) f * d * d2 - (double) f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static List<EntityPlayer> Method2163476() {
        return EntityUtil.Method2163471().stream().filter(EntityUtil::Method2163587).collect(Collectors.toList());
    }

    public static float Method2163477(BlockPos blockPos, EntityPlayer entityPlayer) {
        return EntityUtil.Method2163484((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5, (Entity) entityPlayer);
    }

    public static double Method2163478(float f) {
        return MathHelper.sin((float) (-f * ((float) Math.PI / 180)));
    }

    public static double Method2163479(float f) {
        return MathHelper.cos((float) (f * ((float) Math.PI / 180)));
    }

    public static boolean Method2163470(EntityPlayer entityPlayer) {
        BlockPos blockPos = EntityUtil.Method2163403(entityPlayer);
        return !(EntityUtil.Field2811.world.getBlockState(blockPos.down()).getBlock() != Blocks.OBSIDIAN && EntityUtil.Field2811.world.getBlockState(blockPos.down()).getBlock() != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(blockPos.north()).getBlock() != Blocks.OBSIDIAN && EntityUtil.Field2811.world.getBlockState(blockPos.north()).getBlock() != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(blockPos.east()).getBlock() != Blocks.OBSIDIAN && EntityUtil.Field2811.world.getBlockState(blockPos.east()).getBlock() != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(blockPos.south()).getBlock() != Blocks.OBSIDIAN && EntityUtil.Field2811.world.getBlockState(blockPos.south()).getBlock() != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(blockPos.west()).getBlock() != Blocks.OBSIDIAN && EntityUtil.Field2811.world.getBlockState(blockPos.west()).getBlock() != Blocks.BEDROCK);
    }

    public static BlockPos Method2163481(Entity entity) {
        return new BlockPos(entity);
    }

    public static Vec3d Method2163482(double d, double d2, double d3) {
        double d4 = Math.floor(d) + 0.5;
        double d5 = Math.floor(d2);
        double d6 = Math.floor(d3) + 0.5;
        return new Vec3d(d4, d5, d6);
    }

    public static boolean Method2163483() {
        if (EntityUtil.Field2811.player != null) {
            if (EntityUtil.Field2811.player.isSneaking()) {
                Field2811.getConnection().sendPacket((Packet) new CPacketEntityAction((Entity) EntityUtil.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                Field2811.getConnection().sendPacket((Packet) new CPacketEntityAction((Entity) EntityUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            } else {
                Field2811.getConnection().sendPacket((Packet) new CPacketEntityAction((Entity) EntityUtil.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
        }
        return false;
    }

    public static float Method2163484(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        double d4 = entity.getDistance(d, d2, d3) / (double) f;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        double d5 = entity.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * (double) f + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = DamageUtil.Method2163459((EntityLivingBase) entity, EntityUtil.Method2163485(f2), new Explosion((World) EntityUtil.Field2811.world, null, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    private static float Method2163485(float f) {
        return f * (EntityUtil.Field2811.world.getDifficulty().getId() == 0 ? 0.0f : (EntityUtil.Field2811.world.getDifficulty().getId() == 2 ? 1.0f : (EntityUtil.Field2811.world.getDifficulty().getId() == 1 ? 0.5f : 1.5f)));
    }

    public static void Method2163486(boolean bl) {
        Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.Position(EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.posY + 0.4199999, EntityUtil.Field2811.player.posZ, bl));
        Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.Position(EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.posY + 0.7531999, EntityUtil.Field2811.player.posZ, bl));
        Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.Position(EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.posY + 1.0013359, EntityUtil.Field2811.player.posZ, bl));
        Field2811.getConnection().sendPacket((Packet) new CPacketPlayer.Position(EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.posY + 1.1661092, EntityUtil.Field2811.player.posZ, bl));
    }

    public static double Method2163487() {
        int n2;
        double d = 0.2873;
        if (Util.Field2811.player.isPotionActive(MobEffects.SPEED)) {
            n2 = Objects.requireNonNull(Util.Field2811.player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier();
            d *= 1.0 + 0.2 * (double) (n2 + 1);
        }
        if (Util.Field2811.player.isPotionActive(MobEffects.JUMP_BOOST)) {
            n2 = Objects.requireNonNull(Util.Field2811.player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier();
            d /= 1.0 + 0.2 * (double) (n2 + 1);
        }
        return d;
    }

    public static void Method2163488(Entity entity, boolean bl, boolean bl2) {
        if (bl) {
            EntityUtil.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtil.Field2811.playerController.attackEntity((EntityPlayer) EntityUtil.Field2811.player, entity);
        }
        if (bl2) {
            EntityUtil.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static float[] Method2163489(Vec3d vec3d) {
        Vec3d vec3d2 = RotationUtil.Method2163089();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{Util.Field2811.player.rotationYaw + MathHelper.wrapDegrees((float) (f - Util.Field2811.player.rotationYaw)), Util.Field2811.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - Util.Field2811.player.rotationPitch))};
    }

    public static boolean Method2163480(Vec3d vec3d, int n2, int n3) {
        Block block;
        Block block2;
        BlockPos blockPos;
        switch (n2) {
            case 1: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX() - 2, blockPos.getY(), blockPos.getZ()) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) (blockPos.getX() - 2), (double) blockPos.getY(), (double) blockPos.getZ())) > 3.0) {
                    return false;
                }
                Block block3 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 1, 0)).getBlock();
                if (block3 != Blocks.AIR && block3 != Blocks.FIRE || (block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 0, 0)).getBlock()) != Blocks.AIR && block2 != Blocks.FIRE || (block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, -1, 0)).getBlock()) != Blocks.OBSIDIAN && block != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 2: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX() + 2, blockPos.getY(), blockPos.getZ()) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) (blockPos.getX() + 2), (double) blockPos.getY(), (double) blockPos.getZ())) > 3.0) {
                    return false;
                }
                Block block4 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 1, 0)).getBlock();
                if (block4 != Blocks.AIR && block4 != Blocks.FIRE || (block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 0, 0)).getBlock()) != Blocks.AIR && block2 != Blocks.FIRE || (block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, -1, 0)).getBlock()) != Blocks.OBSIDIAN && block != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 3: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 2) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) blockPos.getX(), (double) blockPos.getY(), (double) (blockPos.getZ() - 2))) > 3.0) {
                    return false;
                }
                Block block5 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -2)).getBlock();
                if (block5 != Blocks.AIR && block5 != Blocks.FIRE || (block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -2)).getBlock()) != Blocks.AIR && block2 != Blocks.FIRE || (block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, -2)).getBlock()) != Blocks.OBSIDIAN && block != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 4: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 2) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) blockPos.getX(), (double) blockPos.getY(), (double) (blockPos.getZ() + 2))) > 3.0) {
                    return false;
                }
                Block block6 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 2)).getBlock();
                if (block6 != Blocks.AIR && block6 != Blocks.FIRE || (block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 2)).getBlock()) != Blocks.AIR && block2 != Blocks.FIRE || (block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, 2)).getBlock()) != Blocks.OBSIDIAN && block != Blocks.BEDROCK || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 5: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ()) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) (blockPos.getX() - 1), (double) blockPos.getY(), (double) blockPos.getZ())) > 3.0) {
                    return false;
                }
                Block block7 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 1, 0)).getBlock();
                if (block7 != Blocks.AIR && block7 != Blocks.FIRE || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 6: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ()) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) (blockPos.getX() + 1), (double) blockPos.getY(), (double) blockPos.getZ())) > 3.0) {
                    return false;
                }
                Block block8 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 1, 0)).getBlock();
                if (block8 != Blocks.AIR && block8 != Blocks.FIRE || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 7: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 1) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) blockPos.getX(), (double) blockPos.getY(), (double) (blockPos.getZ() - 1))) > 3.0) {
                    return false;
                }
                Block block9 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -1)).getBlock();
                if (block9 != Blocks.AIR && block9 != Blocks.FIRE || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 8: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 1) && Math.sqrt(EntityUtil.Field2811.player.getDistanceSq((double) blockPos.getX(), (double) blockPos.getY(), (double) (blockPos.getZ() + 1))) > 3.0) {
                    return false;
                }
                Block block10 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 1)).getBlock();
                if (block10 != Blocks.AIR && block10 != Blocks.FIRE || EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
        }
        switch (n3) {
            case 1: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 1, 0)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 0, 0)).getBlock();
                if (block2 != Blocks.AIR && block2 != Blocks.FIRE) {
                    return false;
                }
                block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, -1, 0)).getBlock();
                if (block != Blocks.OBSIDIAN && block != Blocks.BEDROCK) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() != Blocks.BEDROCK;
            }
            case 2: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 1, 0)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 0, 0)).getBlock();
                if (block2 != Blocks.AIR && block2 != Blocks.FIRE) {
                    return false;
                }
                block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, -1, 0)).getBlock();
                if (block != Blocks.OBSIDIAN && block != Blocks.BEDROCK) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() != Blocks.BEDROCK;
            }
            case 3: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -2)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -2)).getBlock();
                if (block2 != Blocks.AIR && block2 != Blocks.FIRE) {
                    return false;
                }
                block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, -2)).getBlock();
                if (block != Blocks.OBSIDIAN && block != Blocks.BEDROCK) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() != Blocks.BEDROCK;
            }
            case 4: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 2)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                block2 = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 2)).getBlock();
                if (block2 != Blocks.AIR && block2 != Blocks.FIRE) {
                    return false;
                }
                block = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, 2)).getBlock();
                if (block != Blocks.OBSIDIAN && block != Blocks.BEDROCK) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() != Blocks.BEDROCK;
            }
            case 5: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 1, 0)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() != Blocks.BEDROCK;
            }
            case 6: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 1, 0)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() != Blocks.BEDROCK;
            }
            case 7: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -1)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() != Blocks.BEDROCK;
            }
            case 8: {
                blockPos = EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 1)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE) {
                    return false;
                }
                return EntityUtil.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() != Blocks.BEDROCK;
            }
        }
        return false;
    }

    public static void Method2163491(Entity entity, boolean bl, boolean bl2) {
        if (bl) {
            EntityUtil.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtil.Field2811.playerController.attackEntity((EntityPlayer) EntityUtil.Field2811.player, entity);
        }
        if (bl2) {
            EntityUtil.Field2811.player.swingArm(EnumHand.OFF_HAND);
        }
    }

    public static Vec3d Method2163492(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f);
    }

    public static Vec3d Method2163493(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(EntityUtil.Method2163498(entity, f));
    }

    public static Vec3d Method2163494(Entity entity, float f) {
        return EntityUtil.Method2163493(entity, f).subtract(EntityUtil.Field2811.getRenderManager().renderPosX, EntityUtil.Field2811.getRenderManager().renderPosY, EntityUtil.Field2811.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2163495(Vec3d vec3d) {
        return new Vec3d(vec3d.x, vec3d.y, vec3d.z).subtract(EntityUtil.Field2811.getRenderManager().renderPosX, EntityUtil.Field2811.getRenderManager().renderPosY, EntityUtil.Field2811.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2163496(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static Vec3d Method2163497(Entity entity, Vec3d vec3d) {
        return EntityUtil.Method2163496(entity, vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vec3d Method2163498(Entity entity, float f) {
        return EntityUtil.Method2163496(entity, f, f, f);
    }

    public static boolean Method2163499(Entity entity) {
        return (!(entity instanceof EntityWolf) || !((EntityWolf) entity).isAngry()) && (entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid || entity instanceof EntityIronGolem && ((EntityIronGolem) entity).getRevengeTarget() == null);
    }

    public static boolean Method2163490(Entity entity, int n2, boolean bl, boolean bl2) {
        return EntityUtil.Method2163404(entity, n2, bl, bl2).size() == 0;
    }

    public static boolean Method2163401(boolean bl) {
        if (bl && EntityUtil.Field2811.player != null) {
            EntityUtil.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) EntityUtil.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public static boolean Method2163402(Entity entity) {
        return EntityUtil.Method2163490(entity, 0, false, true);
    }

    public static BlockPos Method2163403(EntityPlayer entityPlayer) {
        return new BlockPos(Math.floor(entityPlayer.posX), Math.floor(entityPlayer.posY), Math.floor(entityPlayer.posZ));
    }

    public static List<Vec3d> Method2163404(Entity entity, int n2, boolean bl, boolean bl2) {
        return EntityUtil.Method2163511(entity.getPositionVector().add(0.0, 0.125, 0.0), n2, bl, bl2);
    }

    public static boolean Method2163405(Entity entity) {
        if (entity instanceof EntityPigZombie) {
            if (((EntityPigZombie) entity).isArmsRaised() || ((EntityPigZombie) entity).isAngry()) {
                return true;
            }
        } else {
            if (entity instanceof EntityWolf) {
                return ((EntityWolf) entity).isAngry() && !EntityUtil.Field2811.player.equals((Object) ((EntityWolf) entity).getOwner());
            }
            if (entity instanceof EntityEnderman) {
                return ((EntityEnderman) entity).isScreaming();
            }
        }
        return EntityUtil.Method2163400(entity);
    }

    public static boolean Method2163406(Entity entity) {
        return entity instanceof EntityPigZombie || entity instanceof EntityWolf || entity instanceof EntityEnderman;
    }

    public static boolean Method2163407(Entity entity) {
        return entity instanceof EntityShulkerBullet || entity instanceof EntityFireball;
    }

    public static boolean Method2163408(Entity entity) {
        return entity instanceof EntityBoat || entity instanceof EntityMinecart;
    }

    public static boolean Method2163409(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.CREATURE, false) && !EntityUtil.Method2163406(entity) || entity.isCreatureType(EnumCreatureType.AMBIENT, false) || entity instanceof EntityVillager || entity instanceof EntityIronGolem || EntityUtil.Method2163406(entity) && !EntityUtil.Method2163405(entity);
    }

    public static boolean Method2163400(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.MONSTER, false) && !EntityUtil.Method2163406(entity);
    }

    public static List<Vec3d> Method2163511(Vec3d vec3d, int n2, boolean bl, boolean bl2) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (Vec3d vec3d2 : EntityUtil.Method2163532(n2, bl, bl2)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = EntityUtil.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static boolean Method2163512(Entity entity) {
        return EntityUtil.Method2163513(new BlockPos(entity.posX, entity.posY, entity.posZ));
    }

    public static boolean Method2163513(BlockPos blockPos) {
        return EntityUtil.Method2163516(blockPos) || EntityUtil.Method2163515(blockPos) || EntityUtil.Method2163517(blockPos);
    }

    public static boolean Method2163514(EntityEnderCrystal entityEnderCrystal, double d) {
        for (EntityPlayer entityPlayer : EntityUtil.Field2811.world.playerEntities) {
            if (EntityUtil.Field2811.player.getDistanceSq((Entity) entityPlayer) > d * d || AliceMain.Field765.Method2150169(entityPlayer))
                continue;
            for (Vec3d vec3d : Field2100) {
                if (new BlockPos(entityPlayer.getPositionVector()).add(vec3d.x, vec3d.y, vec3d.z) != entityEnderCrystal.getPosition())
                    continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method2163515(BlockPos blockPos) {
        BlockPos[] arrblockPos;
        for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.OBSIDIAN) continue;
            return false;
        }
        return true;
    }

    public static boolean Method2163516(BlockPos blockPos) {
        BlockPos[] arrblockPos;
        for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }

    public static boolean Method2163517(BlockPos blockPos) {
        BlockPos[] arrblockPos;
        for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtil.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN))
                continue;
            return false;
        }
        return true;
    }

    public static Vec3d[] Method2163518(Entity entity, int n2, boolean bl, boolean bl2) {
        List<Vec3d> list = EntityUtil.Method2163404(entity, n2, bl, bl2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2163519(Vec3d vec3d, int n2, boolean bl, boolean bl2) {
        List<Vec3d> list = EntityUtil.Method2163511(vec3d, n2, bl, bl2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static double Method2163510(Vec3d vec3d) {
        return EntityUtil.Field2811.player.getPositionVector().distanceTo(vec3d);
    }

    public static boolean Method2163521(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        return EntityUtil.Method2163523(entityPlayer, bl, bl2, bl3, bl4, bl5, bl6).size() == 0;
    }

    public static boolean Method2163522(int n2, EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        return EntityUtil.Method2163529(n2, entityPlayer, bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8).size() == 0;
    }

    public static List<Vec3d> Method2163523(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (!bl2 && EntityUtil.Method2163404((Entity) entityPlayer, 2, false, bl6).size() == 4) {
            arrayList.addAll(EntityUtil.Method2163404((Entity) entityPlayer, 2, false, bl6));
        }
        for (int j = 0; j < EntityUtil.Method2163533(bl, bl2, bl3, bl4, bl5, bl6).length; ++j) {
            Vec3d vec3d = EntityUtil.Method2163533(bl, bl2, bl3, bl4, bl5, bl6)[j];
            BlockPos blockPos = new BlockPos(entityPlayer.getPositionVector()).add(vec3d.x, vec3d.y, vec3d.z);
            Block block = EntityUtil.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d);
        }
        return arrayList;
    }

    public static boolean Method2163524(Entity entity) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY + 0.01;
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, (int) d, i2);
                if (!(EntityUtil.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method2163525(Entity entity) {
        return EntityUtil.Field2811.player != null && entity != null && entity.equals((Object) EntityUtil.Field2811.player.getRidingEntity());
    }

    public static boolean Method2163526(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    public static boolean Method2163527(Entity entity) {
        return EntityUtil.Method2163528(entity, false);
    }

    public static boolean Method2163528(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY - (bl ? 0.03 : (EntityUtil.Method2163526(entity) ? 0.2 : 0.5));
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, MathHelper.floor((double) d), i2);
                if (!(EntityUtil.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static List<Vec3d> Method2163529(int n2, EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (n2 == 1) {
            arrayList.addAll(EntityUtil.Method2163520(entityPlayer.getPositionVector(), bl, bl2, bl3, bl4, bl5, bl6, bl8));
        } else {
            int n3 = 1;
            for (Vec3d vec3d : MathUtil.Method2163868((Entity) entityPlayer)) {
                if (n3 > n2) break;
                arrayList.addAll(EntityUtil.Method2163520(vec3d, !bl7, bl2, bl3, bl4, bl5, bl6, bl8));
                ++n3;
            }
        }
        ArrayList<Vec3d> arrayList2 = new ArrayList<Vec3d>();
        for (Vec3d vec3d : arrayList) {
            BlockPos blockPos = new BlockPos(vec3d);
            if (BlockUtil.Method2162815(blockPos, bl6) != -1) continue;
            arrayList2.add(vec3d);
        }
        for (Vec3d vec3d : arrayList2) {
            arrayList.remove((Object) vec3d);
        }
        return arrayList;
    }

    public static List<Vec3d> Method2163520(Vec3d vec3d, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        List<Vec3d> list;
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (bl5) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2097));
        }
        if (bl4) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2098));
        }
        if (bl3) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2099));
        }
        Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2101));
        if (bl2) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2104));
        } else {
            list = EntityUtil.Method2163511(vec3d, 2, false, bl7);
            if (list.size() == 4) {
                block4:
                for (Vec3d vec3d2 : list) {
                    BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
                    switch (BlockUtil.Method2162815(blockPos, bl6)) {
                        case -1:
                        case 1:
                        case 2: {
                            continue block4;
                        }
                        case 3: {
                            arrayList.add(vec3d.add(vec3d2));
                        }
                    }
                }
            }
        }
        if (bl) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2105));
        }
        if (!bl7) {
            list = new ArrayList<Vec3d>();
            list.add(new Vec3d(1.0, 1.0, 0.0));
            list.add(new Vec3d(0.0, 1.0, -1.0));
            list.add(new Vec3d(0.0, 1.0, 1.0));
            Vec3d[] arrvec3d = new Vec3d[list.size()];
            arrayList.removeAll(Arrays.asList(BlockUtil.Method2162848(vec3d, list.toArray((T[]) arrvec3d))));
        }
        return arrayList;
    }

    public static List<Vec3d> Method2163531(int n2, boolean bl, boolean bl2) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (bl2) {
            arrayList.add(new Vec3d(-1.0, (double) n2, 0.0));
            arrayList.add(new Vec3d(1.0, (double) n2, 0.0));
            arrayList.add(new Vec3d(0.0, (double) n2, -1.0));
            arrayList.add(new Vec3d(0.0, (double) n2, 1.0));
        } else {
            arrayList.add(new Vec3d(-1.0, (double) n2, 0.0));
        }
        if (bl) {
            arrayList.add(new Vec3d(0.0, (double) (n2 - 1), 0.0));
        }
        return arrayList;
    }

    public static Vec3d[] Method2163532(int n2, boolean bl, boolean bl2) {
        List<Vec3d> list = EntityUtil.Method2163531(n2, bl, bl2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2163533(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        List<Vec3d> list = EntityUtil.Method2163534(bl, bl2, bl3, bl4, bl5, bl6);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2163534(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(EntityUtil.Method2163531(1, false, bl6));
        arrayList.add(new Vec3d(0.0, 2.0, 0.0));
        if (bl) {
            arrayList.add(new Vec3d(0.0, 3.0, 0.0));
        }
        if (bl2) {
            arrayList.addAll(EntityUtil.Method2163531(2, false, bl6));
        }
        if (bl3) {
            arrayList.addAll(EntityUtil.Method2163531(0, false, bl6));
        }
        if (bl4) {
            arrayList.addAll(EntityUtil.Method2163531(-1, false, bl6));
            arrayList.add(new Vec3d(0.0, -1.0, 0.0));
        }
        if (bl5) {
            arrayList.add(new Vec3d(0.0, -2.0, 0.0));
        }
        return arrayList;
    }

    public static Vec3d[] Method2163535(int n2, int n3) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (int j = n2; j <= n3; ++j) {
            arrayList.add(new Vec3d(0.0, (double) j, 0.0));
        }
        Vec3d[] arrvec3d = new Vec3d[arrayList.size()];
        return arrayList.toArray((T[]) arrvec3d);
    }

    public static BlockPos Method2163536(Entity entity) {
        return new BlockPos(MathUtil.Method2163840(entity.getPositionVector(), 0));
    }

    public static boolean Method2163537(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    public static boolean Method2163538(Entity entity) {
        return EntityUtil.Method2163537(entity) && !entity.isDead && ((EntityLivingBase) entity).getHealth() > 0.0f;
    }

    public static boolean Method2163539(Entity entity) {
        return !EntityUtil.Method2163538(entity);
    }

    public static float Method2163530(Entity entity) {
        if (EntityUtil.Method2163537(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            return entityLivingBase.getHealth() + entityLivingBase.getAbsorptionAmount();
        }
        return 0.0f;
    }

    public static List<EntityPlayer> Method2163541(double d) {
        if (EntityUtil.Field2811.world.getLoadedEntityList().size() == 0) {
            return null;
        }
        List<EntityPlayer> list = EntityUtil.Field2811.world.playerEntities.stream().filter(EntityUtil::Method2163586).filter(arg_0 -> EntityUtil.Method2163585(d, arg_0)).filter(EntityUtil::Method2163584).collect(Collectors.toList());
        list.removeIf(EntityUtil::Method2163583);
        return list;
    }

    public static BlockPos Method2163542(Entity entity, @Nullable BlockPos blockPos) {
        Vec3d vec3d = entity.getPositionVector();
        if (blockPos == null) {
            return new BlockPos(vec3d.x, vec3d.y, vec3d.z);
        }
        return new BlockPos(vec3d.x, vec3d.y, vec3d.z).add((Vec3i) blockPos);
    }

    public static float Method2163543(Entity entity, boolean bl) {
        if (EntityUtil.Method2163537(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            return entityLivingBase.getHealth() + (bl ? entityLivingBase.getAbsorptionAmount() : 0.0f);
        }
        return 0.0f;
    }

    public static boolean Method2163544(Entity entity) {
        return EntityUtil.Field2811.world.rayTraceBlocks(new Vec3d(EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.posX + (double) EntityUtil.Field2811.player.getEyeHeight(), EntityUtil.Field2811.player.posZ), new Vec3d(entity.posX, entity.posY, entity.posZ), false, true, false) == null;
    }

    public static boolean Method2163545(Entity entity, double d) {
        return entity == null || EntityUtil.Method2163539(entity) || entity.equals((Object) EntityUtil.Field2811.player) || entity instanceof EntityPlayer && AliceMain.Field765.Method2150168(entity.getName()) || EntityUtil.Field2811.player.getDistanceSq(entity) > MathUtil.Method2163856(d);
    }

    public static boolean Method2163546(Entity entity, double d) {
        return !EntityUtil.Method2163545(entity, d);
    }

    public static boolean Method2163547(EntityPlayer entityPlayer) {
        return entityPlayer.getHeldItemMainhand().getItem() instanceof ItemSword || entityPlayer.getHeldItemMainhand().getItem() instanceof ItemAxe;
    }

    public static double Method2163548() {
        double d = 0.2873;
        if (EntityUtil.Field2811.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById((int) 1)))) {
            d *= 1.0 + 0.2 * (double) (Objects.requireNonNull(EntityUtil.Field2811.player.getActivePotionEffect(Objects.requireNonNull(Potion.getPotionById((int) 1)))).getAmplifier() + 1);
        }
        return d;
    }

    public static void Method2163549(Entity entity, double d) {
        if (entity != null) {
            entity.motionX *= d;
            entity.motionZ *= d;
        }
    }

    public static boolean Method2163540(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            return EntityUtil.Field2811.gameSettings.keyBindForward.isKeyDown() || EntityUtil.Field2811.gameSettings.keyBindBack.isKeyDown() || EntityUtil.Field2811.gameSettings.keyBindLeft.isKeyDown() || EntityUtil.Field2811.gameSettings.keyBindRight.isKeyDown();
        }
        return entity.motionX != 0.0 || entity.motionY != 0.0 || entity.motionZ != 0.0;
    }

    public static boolean Method2163551() {
        return EntityUtil.Field2811.player.movementInput.forwardKeyDown || EntityUtil.Field2811.player.movementInput.rightKeyDown || EntityUtil.Field2811.player.movementInput.leftKeyDown || EntityUtil.Field2811.player.movementInput.backKeyDown || EntityUtil.Field2811.player.movementInput.jump || EntityUtil.Field2811.player.movementInput.sneak;
    }

    public static double Method2163552(Entity entity) {
        if (entity != null) {
            double d = entity.posX - entity.prevPosX;
            double d2 = entity.posZ - entity.prevPosZ;
            double d3 = MathHelper.sqrt((double) (d * d + d2 * d2));
            return d3 * 20.0;
        }
        return 0.0;
    }

    public static boolean Method2163553(EntityPlayer entityPlayer) {
        return EntityUtil.Method2163554(entityPlayer.getHeldItemMainhand());
    }

    public static boolean Method2163554(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.getTagCompound() == null) {
            return false;
        }
        NBTTagList nBTTagList = (NBTTagList) itemStack.getTagCompound().getTag("ench");
        for (int j = 0; j < nBTTagList.tagCount(); ++j) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(j);
            if (nBTTagCompound.getInteger("id") != 16) continue;
            int n2 = nBTTagCompound.getInteger("lvl");
            if (n2 < 42) break;
            return true;
        }
        return false;
    }

    public static boolean Method2163555(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.SHARPNESS, (ItemStack) itemStack) >= 1000;
    }

    public static void Method2163556(double d, Entity entity) {
        if (entity != null) {
            MovementInput movementInput = EntityUtil.Field2811.player.movementInput;
            double d2 = movementInput.moveForward;
            double d3 = movementInput.moveStrafe;
            float f = EntityUtil.Field2811.player.rotationYaw;
            if (d2 == 0.0 && d3 == 0.0) {
                entity.motionX = 0.0;
                entity.motionZ = 0.0;
            } else {
                if (d2 != 0.0) {
                    if (d3 > 0.0) {
                        f += (float) (d2 > 0.0 ? -45 : 45);
                    } else if (d3 < 0.0) {
                        f += (float) (d2 > 0.0 ? 45 : -45);
                    }
                    d3 = 0.0;
                    if (d2 > 0.0) {
                        d2 = 1.0;
                    } else if (d2 < 0.0) {
                        d2 = -1.0;
                    }
                }
                entity.motionX = d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f));
                entity.motionZ = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f));
            }
        }
    }

    public static boolean Method2163557(Entity entity, boolean bl) {
        return !bl || EntityUtil.Field2811.player.canEntityBeSeen(entity);
    }

    public static Color Method2163558(Entity entity, int n2, int n3, int n4, int n5, boolean bl) {
        Color color = new Color((float) n2 / 255.0f, (float) n3 / 255.0f, (float) n4 / 255.0f, (float) n5 / 255.0f);
        if (entity instanceof EntityPlayer) {
            if (bl && AliceMain.Field765.Method2150169((EntityPlayer) entity)) {
                color = new Color(0.33333334f, 1.0f, 1.0f, (float) n5 / 255.0f);
            }
            Aura aura = AliceMain.Field756.Method2150180(Aura.class);
            if (Aura.Field2488 != null && Aura.Field2488.equals((Object) entity)) {
                color = new Color(1.0f, 0.0f, 0.0f, (float) n5 / 255.0f);
            }
        }
        return color;
    }

    public static boolean Method2163559(EntityPlayer entityPlayer) {
        Freecam freecam = Freecam.Method2162238();
        Blink blink = Blink.Method2162107();
        int n2 = entityPlayer.getEntityId();
        if (freecam.Method2150386() && n2 == 69420) {
            return true;
        }
        return blink.Method2150386() && n2 == 6942069;
    }

    public static boolean Method2163550() {
        return (double) EntityUtil.Field2811.player.moveForward != 0.0 || (double) EntityUtil.Field2811.player.moveStrafing != 0.0;
    }

    public static EntityPlayer Method2163561(double d) {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : EntityUtil.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d)) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (EntityUtil.Field2811.player.getDistanceSq((Entity) entityPlayer2) >= EntityUtil.Field2811.player.getDistanceSq((Entity) entityPlayer))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static boolean Method2163562() {
        return !EntityUtil.Field2811.player.isSneaking() && (EntityUtil.Field2811.player.getRidingEntity() == null || EntityUtil.Field2811.player.getRidingEntity().fallDistance < 3.0f) && EntityUtil.Field2811.player.fallDistance < 3.0f;
    }

    public static boolean Method2163563() {
        if (EntityUtil.Field2811.player.fallDistance >= 3.0f) {
            return false;
        }
        boolean bl = false;
        AxisAlignedBB axisAlignedBB = EntityUtil.Field2811.player.getRidingEntity() != null ? EntityUtil.Field2811.player.getRidingEntity().getEntityBoundingBox() : EntityUtil.Field2811.player.getEntityBoundingBox();
        int n2 = (int) axisAlignedBB.minY;
        for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) axisAlignedBB.maxX) + 1; ++j) {
            for (int i2 = MathHelper.floor((double) axisAlignedBB.minZ); i2 < MathHelper.floor((double) axisAlignedBB.maxZ) + 1; ++i2) {
                Block block = EntityUtil.Field2811.world.getBlockState(new BlockPos(j, n2, i2)).getBlock();
                if (block instanceof BlockAir) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    public static boolean Method2163564(double d) {
        if (EntityUtil.Field2811.player.fallDistance >= 3.0f) {
            return false;
        }
        AxisAlignedBB axisAlignedBB = EntityUtil.Field2811.player.getRidingEntity() != null ? EntityUtil.Field2811.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, -d, 0.0) : EntityUtil.Field2811.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, -d, 0.0);
        boolean bl = false;
        int n2 = (int) axisAlignedBB.minY;
        for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) (axisAlignedBB.maxX + 1.0)); ++j) {
            for (int i2 = MathHelper.floor((double) axisAlignedBB.minZ); i2 < MathHelper.floor((double) (axisAlignedBB.maxZ + 1.0)); ++i2) {
                Block block = EntityUtil.Field2811.world.getBlockState(new BlockPos(j, n2, i2)).getBlock();
                if (block == Blocks.AIR) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    public static boolean Method2163565(Entity entity) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY + 0.01;
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                if (!(EntityUtil.Field2811.world.getBlockState(new BlockPos(j, (int) d, i2)).getBlock() instanceof BlockLiquid))
                    continue;
                return true;
            }
        }
        return false;
    }

    public static BlockPos Method2163566() {
        return new BlockPos(EntityUtil.Field2811.player.getRidingEntity() != null ? EntityUtil.Field2811.player.getRidingEntity().posX : EntityUtil.Field2811.player.posX, EntityUtil.Field2811.player.getRidingEntity() != null ? EntityUtil.Field2811.player.getRidingEntity().posY : EntityUtil.Field2811.player.posY, EntityUtil.Field2811.player.getRidingEntity() != null ? EntityUtil.Field2811.player.getRidingEntity().posZ : EntityUtil.Field2811.player.posZ);
    }

    public static boolean Method2163567(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY;
        double d2 = bl ? 0.03 : (entity instanceof EntityPlayer ? 0.2 : 0.5);
        double d3 = d - d2;
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                if (!(EntityUtil.Field2811.world.getBlockState(new BlockPos(j, MathHelper.floor((double) d3), i2)).getBlock() instanceof BlockLiquid))
                    continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method2163568() {
        double d = EntityUtil.Field2811.player.posY - 0.03;
        for (int j = MathHelper.floor((double) EntityUtil.Field2811.player.posX); j < MathHelper.ceil((double) EntityUtil.Field2811.player.posX); ++j) {
            for (int i2 = MathHelper.floor((double) EntityUtil.Field2811.player.posZ); i2 < MathHelper.ceil((double) EntityUtil.Field2811.player.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, MathHelper.floor((double) d), i2);
                if (!(EntityUtil.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static double[] Method2163569(double d) {
        float f = EntityUtil.Field2811.player.movementInput.moveForward;
        float f2 = EntityUtil.Field2811.player.movementInput.moveStrafe;
        float f3 = EntityUtil.Field2811.player.prevRotationYaw + (EntityUtil.Field2811.player.rotationYaw - EntityUtil.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double) f * d * d3 + (double) f2 * d * d2;
        double d5 = (double) f * d * d2 - (double) f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static Map<String, Integer> Method2163560() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        DecimalFormat decimalFormat2 = new DecimalFormat("#.#");
        decimalFormat2.setRoundingMode(RoundingMode.CEILING);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (EntityPlayer entityPlayer : EntityUtil.Field2811.world.playerEntities) {
            if (entityPlayer.isInvisible() && !Global.Method2150598().Field1138.getValue().booleanValue() || entityPlayer.getName().equals(EntityUtil.Field2811.player.getName()))
                continue;
            int n2 = (int) EntityUtil.Method2163530((Entity) entityPlayer);
            String string = decimalFormat.format(n2);
            stringBuilder.append("\u00a7");
            if (n2 >= 20) {
                stringBuilder.append("a");
            } else if (n2 >= 10) {
                stringBuilder.append("e");
            } else if (n2 >= 5) {
                stringBuilder.append("6");
            } else {
                stringBuilder.append("c");
            }
            stringBuilder.append(string);
            int n3 = (int) EntityUtil.Field2811.player.getDistance((Entity) entityPlayer);
            String string2 = decimalFormat2.format(n3);
            stringBuilder2.append("\u00a7");
            if (n3 >= 25) {
                stringBuilder2.append("a");
            } else if (n3 > 10) {
                stringBuilder2.append("6");
            } else {
                stringBuilder2.append("c");
            }
            stringBuilder2.append(string2);
            map.put(stringBuilder + " " + (AliceMain.Field765.Method2150169(entityPlayer) ? "\u00a7b" : "\u00a7r") + entityPlayer.getName() + " " + stringBuilder2 + " \u00a7f" + AliceMain.Field774.Method2150340(entityPlayer) + AliceMain.Field769.Method2150272(entityPlayer), (int) EntityUtil.Field2811.player.getDistance((Entity) entityPlayer));
            stringBuilder.setLength(0);
            stringBuilder2.setLength(0);
        }
        if (!map.isEmpty()) {
            map = MathUtil.Method2163862(map, false);
        }
        return map;
    }

    public static void Method2163571(EnumHand enumHand, EntityLivingBase entityLivingBase) {
        ItemStack itemStack = entityLivingBase.getHeldItem(enumHand);
        if (!itemStack.isEmpty() && itemStack.getItem().onEntitySwing(entityLivingBase, itemStack)) {
            return;
        }
        if (!entityLivingBase.isSwingInProgress || entityLivingBase.swingProgressInt >= ((IEntityLivingBase) entityLivingBase).getArmSwingAnimationEnd() / 2 || entityLivingBase.swingProgressInt < 0) {
            entityLivingBase.swingProgressInt = -1;
            entityLivingBase.isSwingInProgress = true;
            entityLivingBase.swingingHand = enumHand;
        }
    }

    public static boolean Method2163572(Entity entity, Double d, Double d2) {
        return Util.Field2811.world.getChunk((int) (entity.posX + d) / 16, (int) (entity.posZ + d2) / 16) instanceof EmptyChunk;
    }

    public static boolean Method2163573(Entity entity, BlockPos blockPos) {
        return entity.posY >= (double) blockPos.getY();
    }

    public static void Method2163574() {
        Minecraft.getMinecraft().timer.tickLength = 50.0f;
    }

    public static void Method2163575(float f) {
        Minecraft.getMinecraft().timer.tickLength = 50.0f / f;
    }

    public static void Method2163576(double d) {
        if (EntityUtil.Field2811.player != null) {
            if (EntityUtil.Field2811.player.isRiding()) {
                EntityUtil.Field2811.player.ridingEntity.motionX = d;
                EntityUtil.Field2811.player.ridingEntity.motionZ = d;
            } else {
                EntityUtil.Field2811.player.motionX = d;
                EntityUtil.Field2811.player.motionZ = d;
            }
        }
    }

    public static Vec3d[] Method2163577(int n2, int n3, int n4) {
        List<Vec3d> list = EntityUtil.Method2163578(n2, n3, n4);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2163578(int n2, int n3, int n4) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        arrayList.add(new Vec3d((double) n2, (double) n3, (double) n4));
        return arrayList;
    }

    public static void Method2163579(Entity entity, boolean bl) {
        if (bl) {
            EntityUtil.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtil.Field2811.playerController.attackEntity((EntityPlayer) EntityUtil.Field2811.player, entity);
        }
    }

    public static final BlockPos Method2163570(Entity entity) {
        return new BlockPos(EntityUtil.Method2163581(entity.posX), EntityUtil.Method2163581(entity.posY), EntityUtil.Method2163581(entity.posZ));
    }

    public static final int Method2163581(double d) {
        return (int) Math.floor(d);
    }

    public static final boolean Method2163582(@NotNull Entity entity) {
        if (entity.isDead) {
            return false;
        }
        if (!(entity instanceof EntityLivingBase)) {
            return true;
        }
        float f = ((EntityLivingBase) entity).getHealth();
        boolean bl = false;
        if (Float.isNaN(f)) {
            return true;
        }
        return ((EntityLivingBase) entity).getHealth() > 0.0f;
    }

    private static boolean Method2163583(EntityPlayer entityPlayer) {
        return AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2163584(EntityPlayer entityPlayer) {
        return !(EntityUtil.Method2163530((Entity) entityPlayer) < 0.0f);
    }

    private static boolean Method2163585(double d, EntityPlayer entityPlayer) {
        return (double) EntityUtil.Field2811.player.getDistance((Entity) entityPlayer) <= d;
    }

    private static boolean Method2163586(EntityPlayer entityPlayer) {
        return EntityUtil.Field2811.player != entityPlayer;
    }

    private static boolean Method2163587(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150169(entityPlayer);
    }

    private static boolean Method2163588(EntityPlayer entityPlayer) {
        return entityPlayer.entityId != EntityUtil.Field2811.player.entityId;
    }
}

