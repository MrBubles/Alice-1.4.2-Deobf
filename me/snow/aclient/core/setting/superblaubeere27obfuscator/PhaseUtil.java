

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockHopper
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.IBlockAccess
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.MotionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockHopper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class PhaseUtil
        implements Util {
    private static final Minecraft Field3150 = Minecraft.getMinecraft();

    public static boolean Method2163915(Entity entity) {
        try {
            AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
            for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) axisAlignedBB.maxX) + 1; ++j) {
                for (int i2 = MathHelper.floor((double) axisAlignedBB.minY); i2 < MathHelper.floor((double) axisAlignedBB.maxY) + 1; ++i2) {
                    for (int i3 = MathHelper.floor((double) axisAlignedBB.minZ); i3 < MathHelper.floor((double) axisAlignedBB.maxZ) + 1; ++i3) {
                        Block block = PhaseUtil.Field3150.world.getBlockState(new BlockPos(j, i2, i3)).getBlock();
                        if (block == null || block instanceof BlockAir) continue;
                        AxisAlignedBB axisAlignedBB2 = block.getCollisionBoundingBox(PhaseUtil.Field3150.world.getBlockState(new BlockPos(j, i2, i3)), (IBlockAccess) PhaseUtil.Field3150.world, new BlockPos(j, i2, i3)).offset((double) j, (double) i2, (double) i3);
                        if (block instanceof BlockHopper) {
                            axisAlignedBB2 = new AxisAlignedBB((double) j, (double) i2, (double) i3, (double) (j + 1), (double) (i2 + 1), (double) (i3 + 1));
                        }
                        if (axisAlignedBB2 == null || !axisAlignedBB.intersects(axisAlignedBB2)) continue;
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception exception) {
            return false;
        }
    }

    public static CPacketPlayer Method2163916(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, boolean bl) {
        CPacketPlayer.PositionRotation positionRotation = new CPacketPlayer.PositionRotation(0.0, 0.0, 0.0, 0.0f, 0.0f, false);
        switch (1.F
        ield3588[iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ordinal()])
        {
            case 1: {
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX, PhaseUtil.Field3150.player.posY + 69420.0, PhaseUtil.Field3150.player.posZ, PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 2: {
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX, PhaseUtil.Field3150.player.posY - 69420.0, PhaseUtil.Field3150.player.posZ, PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 3: {
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX, 0.0, PhaseUtil.Field3150.player.posZ, PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 4: {
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX, PhaseUtil.Field3150.player.posY + 100.0, PhaseUtil.Field3150.player.posZ, PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 5: {
                if (PhaseUtil.Field3150.player.ticksExisted % 2 == 0) {
                    positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX, PhaseUtil.Field3150.player.posY + 69420.0, PhaseUtil.Field3150.player.posZ, PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                    break;
                }
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX, PhaseUtil.Field3150.player.posY - 69420.0, PhaseUtil.Field3150.player.posZ, PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 6: {
                double[] arrd = MotionUtil.Method2163889(67.0);
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX + arrd[0], PhaseUtil.Field3150.player.posY + 33.4, PhaseUtil.Field3150.player.posZ + arrd[1], PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 7: {
                double[] arrd = MotionUtil.Method2163889(100.0);
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX + arrd[0], PhaseUtil.Field3150.player.posY, PhaseUtil.Field3150.player.posZ + arrd[1], PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
                break;
            }
            case 8: {
                double[] arrd = MotionUtil.Method2163889(67.0);
                positionRotation = new CPacketPlayer.PositionRotation(PhaseUtil.Field3150.player.posX + arrd[0], PhaseUtil.Field3150.player.posY + (PhaseUtil.Field3150.player.posY > 64.0 ? -33.4 : 33.4), PhaseUtil.Field3150.player.posZ + arrd[1], PhaseUtil.Field3150.player.rotationYaw, PhaseUtil.Field3150.player.rotationPitch, false);
            }
        }
        PhaseUtil.Field3150.player.connection.sendPacket((Packet) positionRotation);
        return positionRotation;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Up,
        Alternate,
        Down,
        Zero,
        Min,
        Forward,
        Flat,
        LimitJitter,
        Constrict,
        None;

    }
}

