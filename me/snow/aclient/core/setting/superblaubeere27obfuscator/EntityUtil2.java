

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockSnow
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
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
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.awt.Color;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
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
import net.minecraft.client.entity.EntityPlayerSP;
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
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class EntityUtil2
        implements Util {
    public static final Vec3d[] Field2421 = new Vec3d[]{new Vec3d(0.0, -2.0, 0.0)};
    public static final Vec3d[] Field2422 = new Vec3d[]{new Vec3d(0.0, -1.0, 0.0), new Vec3d(0.0, -1.0, -1.0), new Vec3d(0.0, -1.0, 1.0), new Vec3d(-1.0, -1.0, 0.0), new Vec3d(1.0, -1.0, 0.0)};
    public static final Vec3d[] Field2423 = new Vec3d[]{new Vec3d(-1.0, 0.0, 0.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(0.0, 0.0, 1.0)};
    public static final Vec3d[] Field2424 = new Vec3d[]{new Vec3d(-1.0, 0.0, 0.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-2.0, 0.0, 0.0), new Vec3d(2.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -2.0), new Vec3d(0.0, 0.0, 2.0)};
    public static final Vec3d[] Field2425 = new Vec3d[]{new Vec3d(1.0, 1.0, 0.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(0.0, 2.0, 0.0)};
    public static final Vec3d[] Field2426 = new Vec3d[]{new Vec3d(0.0, 2.0, 0.0)};
    public static final Vec3d[] Field2427 = new Vec3d[]{new Vec3d(1.0, 1.0, 0.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(0.0, 1.0, -1.0)};
    public static final Vec3d[] Field2428 = new Vec3d[]{new Vec3d(-1.0, 2.0, 0.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(0.0, 2.0, -1.0)};
    public static final Vec3d[] Field2429 = new Vec3d[]{new Vec3d(0.0, 3.0, 0.0)};
    private static final BlockPos[] Field2430 = new BlockPos[]{new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};

    public static EntityPlayer Method2164374(double d) {
        EntityPlayer entityPlayer = null;
        int n2 = EntityUtil2.Field2811.world.playerEntities.size();
        for (int j = 0; j < n2; ++j) {
            EntityPlayer entityPlayer2 = (EntityPlayer) EntityUtil2.Field2811.world.playerEntities.get(j);
            if (EntityUtil2.Method2164462((Entity) entityPlayer2, d)) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(EntityUtil2.Field2811.player.getDistanceSq((Entity) entityPlayer2) < EntityUtil2.Field2811.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static BlockPos Method2164375() {
        return new BlockPos(Math.floor(EntityUtil2.Field2811.player.posX), Math.floor(EntityUtil2.Field2811.player.posY), Math.floor(EntityUtil2.Field2811.player.posZ));
    }

    public static boolean Method2164376() {
        return EntityUtil2.Field2811.player.movementInput.moveForward != 0.0f || EntityUtil2.Field2811.player.movementInput.moveStrafe != 0.0f;
    }

    public static double Method2164378() {
        float f;
        float f2 = 0.0f;
        EntityPlayerSP entityPlayerSP = EntityUtil2.Field2811.player;
        float f3 = entityPlayerSP.rotationYaw;
        if (entityPlayerSP.moveForward < 0.0f) {
            f3 += 180.0f;
        }
        float f4 = entityPlayerSP.moveForward < 0.0f ? -0.5f : (f = (f2 = entityPlayerSP.moveForward > 0.0f ? 0.5f : 1.0f));
        if (entityPlayerSP.moveStrafing > 0.0f) {
            f3 -= 90.0f * f2;
        } else if (entityPlayerSP.moveStrafing < 0.0f) {
            f3 += 90.0f * f2;
        }
        return f3 * ((float) Math.PI / 180);
    }

    public static double Method2164379() {
        if (!EntityUtil2.Field2811.player.isPotionActive(MobEffects.SPEED)) {
            return EntityUtil2.Method2164370();
        }
        return EntityUtil2.Method2164370() * 1.0 + 0.06 * (double) (Objects.requireNonNull(EntityUtil2.Field2811.player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier() + 1);
    }

    public static double Method2164370() {
        if (EntityUtil2.Field2811.player.isSneaking()) {
            return 0.064755;
        }
        return EntityUtil2.Field2811.player.isSprinting() ? 0.2806 : 0.21585;
    }

    public static boolean Method2164381(Vec3d vec3d, int n2, int n3) {
        BlockPos blockPos;
        Block block;
        BlockPos blockPos2;
        switch (n2) {
            case 1: {
                blockPos2 = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos2.getX() - 2, blockPos2.getY(), blockPos2.getZ()) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) (blockPos2.getX() - 2), (double) blockPos2.getY(), (double) blockPos2.getZ())) > 3.0) {
                    return false;
                }
                Block block2 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 1, 0)).getBlock();
                if (block2 != Blocks.AIR && block2 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 0, 0)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, -1, 0)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 2: {
                blockPos2 = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos2.getX() + 2, blockPos2.getY(), blockPos2.getZ()) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) (blockPos2.getX() + 2), (double) blockPos2.getY(), (double) blockPos2.getZ())) > 3.0) {
                    return false;
                }
                Block block3 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 1, 0)).getBlock();
                if (block3 != Blocks.AIR && block3 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 0, 0)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, -1, 0)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 3: {
                blockPos2 = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ() - 2) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) blockPos2.getX(), (double) blockPos2.getY(), (double) (blockPos2.getZ() - 2))) > 3.0) {
                    return false;
                }
                Block block4 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -2)).getBlock();
                if (block4 != Blocks.AIR && block4 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -2)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, -2)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 4: {
                blockPos2 = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ() + 2) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) blockPos2.getX(), (double) blockPos2.getY(), (double) (blockPos2.getZ() + 2))) > 3.0) {
                    return false;
                }
                Block block5 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 2)).getBlock();
                if (block5 != Blocks.AIR && block5 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 2)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, 2)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 5: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ()) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) (blockPos.getX() - 1), (double) blockPos.getY(), (double) blockPos.getZ())) > 3.0) {
                    return false;
                }
                block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 1, 0)).getBlock();
                if (block != Blocks.AIR && block != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 6: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ()) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) (blockPos.getX() + 1), (double) blockPos.getY(), (double) blockPos.getZ())) > 3.0) {
                    return false;
                }
                block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 1, 0)).getBlock();
                if (block != Blocks.AIR && block != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 7: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 1) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) blockPos.getX(), (double) blockPos.getY(), (double) (blockPos.getZ() - 1))) > 3.0) {
                    return false;
                }
                block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -1)).getBlock();
                if (block != Blocks.AIR && block != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 8: {
                blockPos = new BlockPos(vec3d);
                if (!BlockUtil2.Method2164217(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 1) && Math.sqrt(EntityUtil2.Field2811.player.getDistanceSq((double) blockPos.getX(), (double) blockPos.getY(), (double) (blockPos.getZ() + 1))) > 3.0) {
                    return false;
                }
                block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 1)).getBlock();
                if (block != Blocks.AIR && block != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
        }
        switch (n3) {
            case 1: {
                blockPos2 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 1, 0)).getBlock();
                if (blockPos2 != Blocks.AIR && blockPos2 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, 0, 0)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-2, -1, 0)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 2: {
                blockPos2 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 1, 0)).getBlock();
                if (blockPos2 != Blocks.AIR && blockPos2 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, 0, 0)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(2, -1, 0)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 3: {
                blockPos2 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -2)).getBlock();
                if (blockPos2 != Blocks.AIR && blockPos2 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -2)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, -2)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 4: {
                blockPos2 = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 2)).getBlock();
                if (blockPos2 != Blocks.AIR && blockPos2 != Blocks.FIRE || (block = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 2)).getBlock()) != Blocks.AIR && block != Blocks.FIRE || (blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, -1, 2)).getBlock()) != Blocks.OBSIDIAN && blockPos != Blocks.BEDROCK || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 5: {
                blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 1, 0)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(-1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 6: {
                blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 1, 0)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(1, 0, 0)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 7: {
                blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, -1)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, -1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
            case 8: {
                blockPos = EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 1, 1)).getBlock();
                if (blockPos != Blocks.AIR && blockPos != Blocks.FIRE || EntityUtil2.Field2811.world.getBlockState(new BlockPos(vec3d).add(0, 0, 1)).getBlock() == Blocks.BEDROCK)
                    break;
                return true;
            }
        }
        return false;
    }

    public static boolean Method2164382() {
        BlockPos blockPos = EntityUtil2.Method2164375();
        IBlockState iBlockState = EntityUtil2.Field2811.world.getBlockState(blockPos);
        if (iBlockState.getBlock() != Blocks.AIR) {
            return false;
        }
        if (EntityUtil2.Field2811.world.getBlockState(blockPos.up()).getBlock() != Blocks.AIR) {
            return false;
        }
        if (EntityUtil2.Field2811.world.getBlockState(blockPos.down()).getBlock() == Blocks.AIR) {
            return false;
        }
        BlockPos[] arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west()};
        int n2 = 0;
        for (BlockPos blockPos2 : arrblockPos) {
            IBlockState iBlockState2 = EntityUtil2.Field2811.world.getBlockState(blockPos2);
            if (iBlockState2.getBlock() == Blocks.AIR || !iBlockState2.isFullBlock()) continue;
            ++n2;
        }
        return n2 >= 4;
    }

    public static Boolean Method2164383(BlockPos blockPos, Block block) {
        return EntityUtil2.Method2164384(blockPos).equals((Object) block);
    }

    public static Block Method2164384(BlockPos blockPos) {
        return EntityUtil2.Field2811.world.getBlockState(blockPos).getBlock();
    }

    public static BlockPos Method2164385(Entity entity, @Nullable BlockPos blockPos) {
        Vec3d vec3d = entity.getPositionVector();
        if (blockPos == null) {
            return new BlockPos(vec3d.x, vec3d.y, vec3d.z);
        }
        return new BlockPos(vec3d.x, vec3d.y, vec3d.z).add((Vec3i) blockPos);
    }

    public static List<Vec3d> Method2164386(Entity entity, int n2, boolean bl, boolean bl2) {
        return EntityUtil2.Method2164387(entity.getPositionVector().add(0.0, 0.125, 0.0), n2, bl, bl2);
    }

    public static List<Vec3d> Method2164387(Vec3d vec3d, int n2, boolean bl, boolean bl2) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (Vec3d vec3d2 : EntityUtil2.Method2164380(n2, bl, bl2)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = EntityUtil2.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static Vec3d[] Method2164388(Entity entity, int n2, boolean bl, boolean bl2) {
        List<Vec3d> list = EntityUtil2.Method2164386(entity, n2, bl, bl2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2164389(Vec3d vec3d, int n2, boolean bl, boolean bl2) {
        List<Vec3d> list = EntityUtil2.Method2164387(vec3d, n2, bl, bl2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2164380(int n2, boolean bl, boolean bl2) {
        List<Vec3d> list = EntityUtil2.Method2164392(n2, bl, bl2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static int Method2164391(EntityPlayer entityPlayer) {
        int n2 = 0;
        try {
            n2 = MathUtil.Method2163843(Objects.requireNonNull(Field2811.getConnection()).getPlayerInfo(entityPlayer.getUniqueID()).getResponseTime(), 1, 99999);
        } catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return n2;
    }

    public static List<Vec3d> Method2164392(int n2, boolean bl, boolean bl2) {
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

    public static boolean Method2164393(Entity entity, int n2, boolean bl, boolean bl2) {
        return EntityUtil2.Method2164386(entity, n2, bl, bl2).size() == 0;
    }

    public static void Method2164394(Entity entity, boolean bl, boolean bl2) {
        if (bl) {
            EntityUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtil2.Field2811.playerController.attackEntity((EntityPlayer) EntityUtil2.Field2811.player, entity);
        }
        if (bl2) {
            EntityUtil2.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static void Method2164395(Entity entity) {
        EntityUtil2.Field2811.playerController.attackEntity((EntityPlayer) EntityUtil2.Field2811.player, entity);
    }

    public static double Method2164396(Entity entity, BlockPos blockPos) {
        return EntityUtil2.Method2164304(entity.posX, entity.posY, entity.posZ, blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    private static boolean Method2164397(Entity entity, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, double d) {
        if (entity.isDead) {
            return false;
        }
        if (entity instanceof EntityLivingBase && entity != EntityUtil2.Field2811.player && entity.getDistanceSq((Entity) EntityUtil2.Field2811.player) <= d * d) {
            if (entity instanceof EntityPlayer && bl) {
                if (!bl3) {
                    return !AliceMain.Field765.Method2150169((EntityPlayer) entity);
                }
                return true;
            }
            if (EntityUtil2.Method2164424(entity) && bl4) {
                return true;
            }
            if (EntityUtil2.Method2164410(entity) && bl2) {
                return true;
            }
            return EntityUtil2.Method2164413(entity) && bl5;
        }
        return false;
    }

    public static BlockPos Method2164398(Entity entity) {
        return new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
    }

    public static ArrayList<BlockPos> Method2164399(double d, double d2, double d3, Entity entity) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        if (entity != null) {
            AxisAlignedBB axisAlignedBB = entity.ridingEntity != null ? entity.ridingEntity.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(d, d2, d3) : entity.getEntityBoundingBox().contract(0.01, 1.0, 0.01).offset(d, d2, d3);
            int n2 = (int) axisAlignedBB.minY;
            int n3 = (int) Math.floor(axisAlignedBB.minX);
            while ((double) n3 < Math.floor(axisAlignedBB.maxX) + 1.0) {
                int n4 = (int) Math.floor(axisAlignedBB.minZ);
                while ((double) n4 < Math.floor(axisAlignedBB.maxZ) + 1.0) {
                    arrayList.add(new BlockPos(n3, n2, n4));
                    ++n4;
                }
                ++n3;
            }
        }
        return arrayList;
    }

    public static int Method2164390(String string) {
        if (string.equalsIgnoreCase("Closest")) {
            return 0;
        }
        if (string.equalsIgnoreCase("Lowest Health")) {
            return 1;
        }
        if (string.equalsIgnoreCase("Highest Health")) {
            return 2;
        }
        throw new IllegalArgumentException(string);
    }

    public static double Method2164301(Entity entity) {
        return EntityUtil2.Field2811.player.getPositionVector().add(0.0, (double) EntityUtil2.Field2811.player.eyeHeight, 0.0).distanceTo(entity.getPositionVector().add(0.0, (double) entity.height / 2.0, 0.0));
    }

    public static EntityLivingBase Method2164302(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, double d, int n2) {
        EntityLivingBase entityLivingBase = null;
        if (n2 == 0) {
            entityLivingBase = EntityUtil2.Field2811.world.loadedEntityList.stream().filter(arg_0 -> EntityUtil2.Method2164489(bl, bl2, bl3, bl4, bl5, d, arg_0)).min(Comparator.comparing(EntityUtil2::Method2164488)).orElse(null);
        } else if (n2 == 1) {
            entityLivingBase = EntityUtil2.Field2811.world.loadedEntityList.stream().filter(arg_0 -> EntityUtil2.Method2164487(bl, bl2, bl3, bl4, bl5, d, arg_0)).map(EntityUtil2::Method2164486).min(Comparator.comparing(EntityLivingBase::getHealth)).orElse(null);
        } else if (n2 == 2) {
            entityLivingBase = EntityUtil2.Field2811.world.loadedEntityList.stream().filter(arg_0 -> EntityUtil2.Method2164485(bl, bl2, bl3, bl4, bl5, d, arg_0)).map(EntityUtil2::Method2164484).max(Comparator.comparing(EntityLivingBase::getHealth)).orElse(null);
        }
        return entityLivingBase;
    }

    public static EntityPlayer Method2164303(float f) {
        EntityPlayer entityPlayer = null;
        int n2 = EntityUtil.Field2811.world.playerEntities.size();
        for (int j = 0; j < n2; ++j) {
            EntityPlayer entityPlayer2 = (EntityPlayer) EntityUtil.Field2811.world.playerEntities.get(j);
            if (EntityUtil.Method2163545((Entity) entityPlayer2, f)) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(EntityUtil.Field2811.player.getDistanceSq((Entity) entityPlayer2) < EntityUtil.Field2811.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static double Method2164304(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        return MathHelper.sqrt((double) (d7 * d7 + d8 * d8 + d9 * d9));
    }

    public static List<BlockPos> Method2164305(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static Vec3d Method2164306(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f);
    }

    public static Vec3d Method2164307(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(EntityUtil2.Method2164412(entity, f));
    }

    public static Vec3d Method2164308(Entity entity, float f) {
        return EntityUtil2.Method2164307(entity, f).subtract(EntityUtil2.Field2811.getRenderManager().renderPosX, EntityUtil2.Field2811.getRenderManager().renderPosY, EntityUtil2.Field2811.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2164309(Vec3d vec3d) {
        return new Vec3d(vec3d.x, vec3d.y, vec3d.z).subtract(EntityUtil2.Field2811.getRenderManager().renderPosX, EntityUtil2.Field2811.getRenderManager().renderPosY, EntityUtil2.Field2811.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2164300(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static Vec3d Method2164411(Entity entity, Vec3d vec3d) {
        return EntityUtil2.Method2164300(entity, vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vec3d Method2164412(Entity entity, float f) {
        return EntityUtil2.Method2164300(entity, f, f, f);
    }

    public static boolean Method2164413(Entity entity) {
        if (entity instanceof EntityWolf && ((EntityWolf) entity).isAngry()) {
            return false;
        }
        if (entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid) {
            return true;
        }
        return entity instanceof EntityIronGolem && ((EntityIronGolem) entity).getRevengeTarget() == null;
    }

    public static boolean Method2164414(Entity entity, int n2, boolean bl) {
        return EntityUtil2.Method2164418(entity, n2, bl).size() == 0;
    }

    public static boolean Method2164415(boolean bl) {
        if (bl && EntityUtil2.Field2811.player != null) {
            EntityUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) EntityUtil2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public static boolean Method2164416(Entity entity) {
        return EntityUtil2.Method2164414(entity, 0, false);
    }

    public static BlockPos Method2164417(EntityPlayer entityPlayer) {
        return new BlockPos(Math.floor(entityPlayer.posX), Math.floor(entityPlayer.posY), Math.floor(entityPlayer.posZ));
    }

    public static List<Vec3d> Method2164418(Entity entity, int n2, boolean bl) {
        return EntityUtil2.Method2164429(entity.getPositionVector(), n2, bl);
    }

    public static boolean Method2164419(Entity entity) {
        if (entity instanceof EntityPigZombie) {
            if (((EntityPigZombie) entity).isArmsRaised() || ((EntityPigZombie) entity).isAngry()) {
                return true;
            }
        } else {
            if (entity instanceof EntityWolf) {
                return ((EntityWolf) entity).isAngry() && !EntityUtil2.Field2811.player.equals((Object) ((EntityWolf) entity).getOwner());
            }
            if (entity instanceof EntityEnderman) {
                return ((EntityEnderman) entity).isScreaming();
            }
        }
        return EntityUtil2.Method2164424(entity);
    }

    public static boolean Method2164410(Entity entity) {
        return entity instanceof EntityPigZombie || entity instanceof EntityWolf || entity instanceof EntityEnderman;
    }

    public static boolean Method2164421(Entity entity) {
        return entity instanceof EntityShulkerBullet || entity instanceof EntityFireball;
    }

    public static boolean Method2164422(Entity entity) {
        return entity instanceof EntityBoat || entity instanceof EntityMinecart;
    }

    public static boolean Method2164423(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.CREATURE, false) && !EntityUtil2.Method2164410(entity) || entity.isCreatureType(EnumCreatureType.AMBIENT, false) || entity instanceof EntityVillager || entity instanceof EntityIronGolem || EntityUtil2.Method2164410(entity) && !EntityUtil2.Method2164419(entity);
    }

    public static boolean Method2164424(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.MONSTER, false) && !EntityUtil2.Method2164410(entity);
    }

    public static double[] Method2164425(double d, double d2, double d3, EntityPlayer entityPlayer) {
        double d4 = entityPlayer.posX - d;
        double d5 = entityPlayer.posY - d2;
        double d6 = entityPlayer.posZ - d3;
        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
        double d8 = Math.asin(d5 /= d7);
        double d9 = Math.atan2(d6 /= d7, d4 /= d7);
        d8 = d8 * 180.0 / Math.PI;
        d9 = d9 * 180.0 / Math.PI;
        return new double[]{d9 += 90.0, d8};
    }

    public static void Method2164426(EnumHand enumHand, EntityLivingBase entityLivingBase) {
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

    public static void Method2164427(Entity entity, boolean bl, boolean bl2) {
        if (bl) {
            EntityUtil2.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
        } else {
            EntityUtil2.Field2811.playerController.attackEntity((EntityPlayer) EntityUtil2.Field2811.player, entity);
        }
        if (bl2) {
            EntityUtil2.Field2811.player.swingArm(EnumHand.OFF_HAND);
        }
    }

    public static boolean Method2164428(EntityEnderCrystal entityEnderCrystal, double d) {
        for (EntityPlayer entityPlayer : EntityUtil2.Field2811.world.playerEntities) {
            if (EntityUtil2.Field2811.player.getDistanceSq((Entity) entityPlayer) > d * d || AliceMain.Field765.Method2150169(entityPlayer))
                continue;
            for (Vec3d vec3d : Field2424) {
                if (new BlockPos(entityPlayer.getPositionVector()).add(vec3d.x, vec3d.y, vec3d.z) != entityEnderCrystal.getPosition()) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public static List<Vec3d> Method2164429(Vec3d vec3d, int n2, boolean bl) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (Vec3d vec3d2 : EntityUtil2.Method2164440(n2, bl)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = EntityUtil2.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static boolean Method2164420(Entity entity) {
        return EntityUtil2.Method2164431(new BlockPos(entity.posX, entity.posY, entity.posZ));
    }

    public static boolean Method2164431(BlockPos blockPos) {
        return EntityUtil2.Method2164433(blockPos) || EntityUtil2.Method2164432(blockPos) || EntityUtil2.Method2164434(blockPos);
    }

    public static boolean Method2164432(BlockPos blockPos) {
        BlockPos[] arrblockPos;
        for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtil2.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.OBSIDIAN) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2164433(BlockPos blockPos) {
        BlockPos[] arrblockPos;
        for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtil2.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2164434(BlockPos blockPos) {
        BlockPos[] arrblockPos;
        for (BlockPos blockPos2 : arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = EntityUtil2.Field2811.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN))
                continue;
            return false;
        }
        return true;
    }

    public static Vec3d[] Method2164435(Entity entity, int n2, boolean bl) {
        List<Vec3d> list = EntityUtil2.Method2164418(entity, n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2164436(Vec3d vec3d, int n2, boolean bl) {
        List<Vec3d> list = EntityUtil2.Method2164429(vec3d, n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static double Method2164437(Vec3d vec3d) {
        return EntityUtil2.Field2811.player.getPositionVector().distanceTo(vec3d);
    }

    public static boolean Method2164438(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return EntityUtil2.Method2164441(entityPlayer, bl, bl2, bl3, bl4, bl5).size() == 0;
    }

    public static boolean Method2164439(int n2, EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        return EntityUtil2.Method2164447(n2, entityPlayer, bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8).size() == 0;
    }

    public static boolean Method2164430(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        return EntityUtil2.Method2164441(entityPlayer, bl, bl2, bl3, bl4, bl5).size() == 0;
    }

    public static List<Vec3d> Method2164441(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (!bl2 && EntityUtil2.Method2164418((Entity) entityPlayer, 2, false).size() == 4) {
            arrayList.addAll(EntityUtil2.Method2164418((Entity) entityPlayer, 2, false));
        }
        for (int j = 0; j < EntityUtil2.Method2164451(bl, bl2, bl3, bl4, bl5).length; ++j) {
            Vec3d vec3d = EntityUtil2.Method2164451(bl, bl2, bl3, bl4, bl5)[j];
            BlockPos blockPos = new BlockPos(entityPlayer.getPositionVector()).add(vec3d.x, vec3d.y, vec3d.z);
            Block block = EntityUtil2.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d);
        }
        return arrayList;
    }

    public static boolean Method2164442(Entity entity) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY + 0.01;
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, (int) d, i2);
                if (!(EntityUtil2.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean Method2164443(Entity entity) {
        return EntityUtil2.Field2811.player != null && entity != null && entity.equals((Object) EntityUtil2.Field2811.player.getRidingEntity());
    }

    public static boolean Method2164444(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    public static boolean Method2164445(Entity entity) {
        return EntityUtil2.Method2164446(entity, false);
    }

    public static boolean Method2164446(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY - (bl ? 0.03 : (EntityUtil2.Method2164444(entity) ? 0.2 : 0.5));
        for (int j = MathHelper.floor((double) entity.posX); j < MathHelper.ceil((double) entity.posX); ++j) {
            for (int i2 = MathHelper.floor((double) entity.posZ); i2 < MathHelper.ceil((double) entity.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, MathHelper.floor((double) d), i2);
                if (!(EntityUtil2.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public static List<Vec3d> Method2164447(int n2, EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (n2 == 1) {
            arrayList.addAll(EntityUtil2.Method2164448(entityPlayer.getPositionVector(), bl, bl2, bl3, bl4, bl5, bl6));
        } else {
            int n3 = 1;
            for (Vec3d vec3d : MathUtil.Method2163868((Entity) entityPlayer)) {
                if (n3 > n2) break;
                arrayList.addAll(EntityUtil2.Method2164448(vec3d, !bl7, bl2, bl3, bl4, bl5, bl6));
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

    public static List<Vec3d> Method2164448(Vec3d vec3d, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (bl5) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2421));
        }
        if (bl4) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2422));
        }
        if (bl3) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2423));
        }
        Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2425));
        if (bl2) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2428));
        } else {
            List<Vec3d> list = EntityUtil2.Method2164429(vec3d, 2, false);
            if (list.size() == 4) {
                block5:
                for (Vec3d vec3d2 : list) {
                    BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
                    switch (BlockUtil.Method2162815(blockPos, bl6)) {
                        case 0: {
                            break;
                        }
                        case -1:
                        case 1:
                        case 2: {
                            continue block5;
                        }
                        case 3: {
                            arrayList.add(vec3d.add(vec3d2));
                        }
                    }
                    if (bl) {
                        Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2429));
                    }
                    return arrayList;
                }
            }
        }
        if (bl) {
            Collections.addAll(arrayList, BlockUtil.Method2162848(vec3d, Field2429));
        }
        return arrayList;
    }

    public static List<Vec3d> Method2164449(int n2, boolean bl) {
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

    public static Vec3d[] Method2164440(int n2, boolean bl) {
        List<Vec3d> list = EntityUtil2.Method2164449(n2, bl);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static Vec3d[] Method2164451(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        List<Vec3d> list = EntityUtil2.Method2164452(bl, bl2, bl3, bl4, bl5);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2164452(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(EntityUtil2.Method2164449(1, false));
        arrayList.add(new Vec3d(0.0, 2.0, 0.0));
        if (bl) {
            arrayList.add(new Vec3d(0.0, 3.0, 0.0));
        }
        if (bl2) {
            arrayList.addAll(EntityUtil2.Method2164449(2, false));
        }
        if (bl3) {
            arrayList.addAll(EntityUtil2.Method2164449(0, false));
        }
        if (bl4) {
            arrayList.addAll(EntityUtil2.Method2164449(-1, false));
            arrayList.add(new Vec3d(0.0, -1.0, 0.0));
        }
        if (bl5) {
            arrayList.add(new Vec3d(0.0, -2.0, 0.0));
        }
        return arrayList;
    }

    public static Vec3d[] Method2164453(int n2, int n3) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (int j = n2; j <= n3; ++j) {
            arrayList.add(new Vec3d(0.0, (double) j, 0.0));
        }
        Vec3d[] arrvec3d = new Vec3d[arrayList.size()];
        return arrayList.toArray((T[]) arrvec3d);
    }

    public static BlockPos Method2164454(Entity entity) {
        return new BlockPos(MathUtil.Method2163840(entity.getPositionVector(), 0));
    }

    public static boolean Method2164455(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    public static boolean Method2164456(Entity entity) {
        return EntityUtil2.Method2164455(entity) && !entity.isDead && ((EntityLivingBase) entity).getHealth() > 0.0f;
    }

    public static boolean Method2164457(Entity entity) {
        return !EntityUtil2.Method2164456(entity);
    }

    public static float Method2164458(Entity entity) {
        if (EntityUtil2.Method2164455(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            return entityLivingBase.getHealth() + entityLivingBase.getAbsorptionAmount();
        }
        return 0.0f;
    }

    public static float Method2164459(Entity entity, boolean bl) {
        if (EntityUtil2.Method2164455(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            return entityLivingBase.getHealth() + (bl ? entityLivingBase.getAbsorptionAmount() : 0.0f);
        }
        return 0.0f;
    }

    public static boolean Method2164450(Entity entity) {
        return EntityUtil2.Field2811.world.rayTraceBlocks(new Vec3d(EntityUtil2.Field2811.player.posX, EntityUtil2.Field2811.player.posX + (double) EntityUtil2.Field2811.player.getEyeHeight(), EntityUtil2.Field2811.player.posZ), new Vec3d(entity.posX, entity.posY, entity.posZ), false, true, false) == null;
    }

    public static List<EntityPlayer> Method2164461(double d) {
        if (EntityUtil2.Field2811.world.getLoadedEntityList().size() == 0) {
            return null;
        }
        List<EntityPlayer> list = EntityUtil2.Field2811.world.playerEntities.stream().filter(EntityUtil2::Method2164483).filter(arg_0 -> EntityUtil2.Method2164482(d, arg_0)).filter(EntityUtil2::Method2164481).collect(Collectors.toList());
        list.removeIf(EntityUtil2::Method2164470);
        return list;
    }

    public static boolean Method2164462(Entity entity, double d) {
        return entity == null || EntityUtil2.Method2164457(entity) || entity.equals((Object) EntityUtil2.Field2811.player) || entity instanceof EntityPlayer && AliceMain.Field765.Method2150168(entity.getName()) || EntityUtil2.Field2811.player.getDistanceSq(entity) > MathUtil.Method2163856(d);
    }

    public static boolean Method2164463(Entity entity, double d) {
        return !EntityUtil2.Method2164462(entity, d);
    }

    public static boolean Method2164464(EntityPlayer entityPlayer) {
        return entityPlayer.getHeldItemMainhand().getItem() instanceof ItemSword || entityPlayer.getHeldItemMainhand().getItem() instanceof ItemAxe;
    }

    public static double Method2164465() {
        double d = 0.2873;
        if (EntityUtil2.Field2811.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById((int) 1)))) {
            d *= 1.0 + 0.2 * (double) (Objects.requireNonNull(EntityUtil2.Field2811.player.getActivePotionEffect(Objects.requireNonNull(Potion.getPotionById((int) 1)))).getAmplifier() + 1);
        }
        return d;
    }

    public static void Method2164466(Entity entity, double d) {
        if (entity != null) {
            entity.motionX *= d;
            entity.motionZ *= d;
        }
    }

    public static boolean Method2164467(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            return EntityUtil2.Field2811.gameSettings.keyBindForward.isKeyDown() || EntityUtil2.Field2811.gameSettings.keyBindBack.isKeyDown() || EntityUtil2.Field2811.gameSettings.keyBindLeft.isKeyDown() || EntityUtil2.Field2811.gameSettings.keyBindRight.isKeyDown();
        }
        return entity.motionX != 0.0 || entity.motionY != 0.0 || entity.motionZ != 0.0;
    }

    public static double Method2164468(Entity entity) {
        if (entity != null) {
            double d = entity.posX - entity.prevPosX;
            double d2 = entity.posZ - entity.prevPosZ;
            double d3 = MathHelper.sqrt((double) (d * d + d2 * d2));
            return d3 * 20.0;
        }
        return 0.0;
    }

    public static boolean Method2164469(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.SHARPNESS, (ItemStack) itemStack) >= 1000;
    }

    public static void Method2164460(double d, Entity entity) {
        if (entity != null) {
            MovementInput movementInput = EntityUtil2.Field2811.player.movementInput;
            double d2 = movementInput.moveForward;
            double d3 = movementInput.moveStrafe;
            float f = EntityUtil2.Field2811.player.rotationYaw;
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

    public static boolean Method2164471(Entity entity, boolean bl) {
        return !bl || EntityUtil2.Field2811.player.canEntityBeSeen(entity);
    }

    public static Color Method2164472(Entity entity, int n2, int n3, int n4, int n5, boolean bl) {
        Color color = new Color((float) n2 / 255.0f, (float) n3 / 255.0f, (float) n4 / 255.0f, (float) n5 / 255.0f);
        if (entity instanceof EntityPlayer && bl && AliceMain.Field765.Method2150169((EntityPlayer) entity)) {
            color = new Color(0.33333334f, 1.0f, 1.0f, (float) n5 / 255.0f);
        }
        return color;
    }

    public static boolean Method2164473(EntityPlayerSP entityPlayerSP) {
        return (double) EntityUtil2.Field2811.player.moveForward != 0.0 || (double) EntityUtil2.Field2811.player.moveStrafing != 0.0;
    }

    public static EntityPlayer Method2164474(double d) {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : EntityUtil2.Field2811.world.playerEntities) {
            if (EntityUtil2.Method2164462((Entity) entityPlayer2, d)) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(EntityUtil2.Field2811.player.getDistanceSq((Entity) entityPlayer2) < EntityUtil2.Field2811.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static boolean Method2164475() {
        if (EntityUtil2.Field2811.player.isSneaking()) {
            return false;
        }
        if (EntityUtil2.Field2811.player.getRidingEntity() != null && EntityUtil2.Field2811.player.getRidingEntity().fallDistance >= 3.0f) {
            return false;
        }
        return EntityUtil2.Field2811.player.fallDistance < 3.0f;
    }

    public static BlockPos Method2164476() {
        return new BlockPos(EntityUtil2.Field2811.player.getRidingEntity() != null ? EntityUtil2.Field2811.player.getRidingEntity().posX : EntityUtil2.Field2811.player.posX, EntityUtil2.Field2811.player.getRidingEntity() != null ? EntityUtil2.Field2811.player.getRidingEntity().posY : EntityUtil2.Field2811.player.posY, EntityUtil2.Field2811.player.getRidingEntity() != null ? EntityUtil2.Field2811.player.getRidingEntity().posZ : EntityUtil2.Field2811.player.posZ);
    }

    public static double[] Method2164477(double d) {
        float f = EntityUtil2.Field2811.player.movementInput.moveForward;
        float f2 = EntityUtil2.Field2811.player.movementInput.moveStrafe;
        float f3 = EntityUtil2.Field2811.player.prevRotationYaw + (EntityUtil2.Field2811.player.rotationYaw - EntityUtil2.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
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

    public static Map<String, Integer> Method2164478() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        DecimalFormat decimalFormat2 = new DecimalFormat("#.#");
        decimalFormat2.setRoundingMode(RoundingMode.CEILING);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (EntityPlayer entityPlayer : EntityUtil2.Field2811.world.playerEntities) {
            if (entityPlayer.isInvisible() || entityPlayer.getName().equals(EntityUtil2.Field2811.player.getName()))
                continue;
            int n2 = (int) EntityUtil2.Method2164458((Entity) entityPlayer);
            String string = decimalFormat.format(n2);
            stringBuilder.append("\u00c2\u00a7");
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
            int n3 = (int) EntityUtil2.Field2811.player.getDistance((Entity) entityPlayer);
            String string2 = decimalFormat2.format(n3);
            stringBuilder2.append("\u00c2\u00a7");
            if (n3 >= 25) {
                stringBuilder2.append("a");
            } else if (n3 > 10) {
                stringBuilder2.append("6");
            } else {
                stringBuilder2.append("c");
            }
            stringBuilder2.append(string2);
            map.put(stringBuilder.toString() + " " + (Object) (AliceMain.Field765.Method2150169(entityPlayer) ? ChatFormatting.AQUA : ChatFormatting.RED) + entityPlayer.getName() + " " + stringBuilder2.toString() + " \u00c2\u00a7f0", (int) EntityUtil2.Field2811.player.getDistance((Entity) entityPlayer));
            stringBuilder.setLength(0);
            stringBuilder2.setLength(0);
        }
        if (!map.isEmpty()) {
            map = MathUtil.Method2163862(map, false);
        }
        return map;
    }

    public static boolean Method2164479(Entity entity, BlockPos blockPos) {
        return entity.posY >= (double) blockPos.getY();
    }

    private static boolean Method2164470(EntityPlayer entityPlayer) {
        return AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2164481(EntityPlayer entityPlayer) {
        return !(EntityUtil2.Method2164458((Entity) entityPlayer) < 0.0f);
    }

    private static boolean Method2164482(double d, EntityPlayer entityPlayer) {
        return (double) EntityUtil2.Field2811.player.getDistance((Entity) entityPlayer) <= d;
    }

    private static boolean Method2164483(EntityPlayer entityPlayer) {
        return EntityUtil2.Field2811.player != entityPlayer;
    }

    private static EntityLivingBase Method2164484(Entity entity) {
        return (EntityLivingBase) entity;
    }

    private static boolean Method2164485(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, double d, Entity entity) {
        return EntityUtil2.Method2164397(entity, bl, bl2, bl3, bl4, bl5, d);
    }

    private static EntityLivingBase Method2164486(Entity entity) {
        return (EntityLivingBase) entity;
    }

    private static boolean Method2164487(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, double d, Entity entity) {
        return EntityUtil2.Method2164397(entity, bl, bl2, bl3, bl4, bl5, d);
    }

    private static Double Method2164488(Entity entity) {
        return EntityUtil2.Field2811.player.getPositionVector().squareDistanceTo(entity.getPositionVector());
    }

    private static boolean Method2164489(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, double d, Entity entity) {
        return EntityUtil2.Method2164397(entity, bl, bl2, bl3, bl4, bl5, d);
    }

    public void Method2164377(double d) {
        EntityPlayerSP entityPlayerSP = EntityUtil2.Field2811.player;
        entityPlayerSP.motionX = -(Math.sin(EntityUtil2.Method2164378()) * d);
        entityPlayerSP.motionZ = Math.cos(EntityUtil2.Method2164378()) * d;
    }
}

