

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockAnvil
 *  net.minecraft.block.BlockBed
 *  net.minecraft.block.BlockButton
 *  net.minecraft.block.BlockCake
 *  net.minecraft.block.BlockContainer
 *  net.minecraft.block.BlockDoor
 *  net.minecraft.block.BlockFenceGate
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockRedstoneDiode
 *  net.minecraft.block.BlockTrapDoor
 *  net.minecraft.block.BlockWorkbench
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilSC;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class BlockUtilSC {
    private static final Minecraft Field2008 = Minecraft.getMinecraft();

    public static void Method2162870(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl) {
        if (bl) {
            float f = (float) (vec3d.x - (double) blockPos.getX());
            float f2 = (float) (vec3d.y - (double) blockPos.getY());
            float f3 = (float) (vec3d.z - (double) blockPos.getZ());
            BlockUtilSC.Field2008.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
            BlockUtilSC.Field2008.player.connection.sendPacket((Packet) new CPacketAnimation(enumHand));
        } else {
            BlockUtilSC.Field2008.playerController.processRightClickBlock(BlockUtilSC.Field2008.player, BlockUtilSC.Field2008.world, blockPos, enumFacing, vec3d, enumHand);
            BlockUtilSC.Field2008.player.swingArm(enumHand);
        }
    }

    public static Vec3d Method2162881(BlockPos blockPos) {
        return new Vec3d((Vec3i) blockPos);
    }

    public static BlockPos Method2162882(Vec3d vec3d) {
        return new BlockPos(vec3d);
    }

    public static List<BlockPos> Method2162883(BlockPos blockPos, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        for (int j = n3 - n2; j <= n3 + n2; ++j) {
            for (int i2 = n5 - n2; i2 <= n5 + n2; ++i2) {
                for (int i3 = n4 - n2; i3 < n4 + n2; ++i3) {
                    double d = (n3 - j) * (n3 - j) + (n5 - i2) * (n5 - i2) + (n4 - i3) * (n4 - i3);
                    if (!(d < (double) (n2 * n2))) continue;
                    arrayList.add(new BlockPos(j, i3, i2));
                }
            }
        }
        return arrayList;
    }

    public static boolean Method2162884(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (BlockUtilSC.Field2008.world.getBlockState(blockPos2).getMaterial().isReplaceable()) {
                continue;
            }
            return true;
        }
        return false;
    }

    public static Optional<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Method2162885(BlockPos blockPos) {
        return BlockUtilSC.Method2162887(blockPos, false, false);
    }

    public static Optional<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Method2162886(BlockPos blockPos, boolean bl) {
        return BlockUtilSC.Method2162887(blockPos, bl, false);
    }

    public static Optional<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Method2162887(BlockPos blockPos, boolean bl, boolean bl2) {
        return BlockUtilSC.Method2162888(blockPos, bl, false, false);
    }

    public static Optional<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Method2162888(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        Entity entity2;
        Block block = BlockUtilSC.Field2008.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return Optional.empty();
        }
        if (!bl) {
            for (Entity entity2 : BlockUtilSC.Field2008.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
                if (bl3 && entity2 instanceof EntityEnderCrystal || entity2 instanceof EntityItem || entity2 instanceof EntityXPOrb || entity2 instanceof EntityArrow)
                    continue;
                return Optional.empty();
            }
        }
        EnumFacing enumFacing = null;
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing2);
            if (bl2 && BlockUtilSC.Field2008.world.getBlockState(blockPos2).getBlock() == Blocks.PISTON || !BlockUtilSC.Field2008.world.getBlockState(blockPos2).getBlock().canCollideCheck(BlockUtilSC.Field2008.world.getBlockState(blockPos2), false) || (iBlockState = BlockUtilSC.Field2008.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            enumFacing = enumFacing2;
            break;
        }
        if (enumFacing == null) {
            return Optional.empty();
        }
        entity2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing3 = enumFacing.getOpposite();
        if (!BlockUtilSC.Field2008.world.getBlockState((BlockPos) entity2).getBlock().canCollideCheck(BlockUtilSC.Field2008.world.getBlockState((BlockPos) entity2), false)) {
            return Optional.empty();
        }
        return Optional.of(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((BlockPos) entity2, enumFacing3));
    }

    public static double[] Method2162889(BlockPos blockPos, EnumFacing enumFacing, EntityPlayer entityPlayer) {
        return PlayerUtilSC.Method2162928((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5, entityPlayer);
    }

    public static double[] Method2162880(double d, double d2, double d3, EnumFacing enumFacing, EntityPlayer entityPlayer) {
        return PlayerUtilSC.Method2162928(d + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, d2 + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, d3 + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5, entityPlayer);
    }

    public static boolean Method2162891(BlockPos blockPos) {
        Block block = BlockUtilSC.Field2008.world.getBlockState(blockPos).getBlock();
        TileEntity tileEntity = null;
        for (TileEntity tileEntity2 : BlockUtilSC.Field2008.world.loadedTileEntityList) {
            if (!tileEntity2.getPos().equals((Object) blockPos)) continue;
            tileEntity = tileEntity2;
            break;
        }
        return tileEntity != null || block instanceof BlockBed || block instanceof BlockContainer || block instanceof BlockDoor || block instanceof BlockTrapDoor || block instanceof BlockFenceGate || block instanceof BlockButton || block instanceof BlockAnvil || block instanceof BlockWorkbench || block instanceof BlockCake || block instanceof BlockRedstoneDiode;
    }

    public static boolean Method2162892(BlockPos blockPos) {
        return !(BlockUtilSC.Method2162893(blockPos) || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 1, 0)).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 2, 0)).getMaterial() != Material.AIR);
    }

    public static boolean Method2162893(BlockPos blockPos) {
        return BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 1, 0)).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.add(0, 2, 0)).getMaterial() == Material.AIR;
    }

    public static BlockPos Method2162894(BlockPos blockPos) {
        if (!(BlockUtilSC.Field2008.world.getBlockState(blockPos.down()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.down()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.west()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.west()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.south()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.south()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.north()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.north()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.up()).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.up(2)).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.east().down()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().down()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.east(2)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.east(2)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.east().south()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().south()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.east().north()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().north()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.east()).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.east().up()).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.east().up(2)).getMaterial() != Material.AIR)) {
            return BlockUtilSC.Method2162895(blockPos) == null ? new BlockPos(1, 0, 0) : null;
        }
        if (!(BlockUtilSC.Field2008.world.getBlockState(blockPos.down()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.down()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.west()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.west()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.east()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.east()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.north()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.north()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.up()).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.up(2)).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.south().down()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().down()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.south(2)).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.south(2)).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.south().east()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().east()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.south().west()).getBlock() != Blocks.OBSIDIAN && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().west()).getBlock() != Blocks.BEDROCK || BlockUtilSC.Field2008.world.getBlockState(blockPos.south()).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.south().up()).getMaterial() != Material.AIR || BlockUtilSC.Field2008.world.getBlockState(blockPos.south().up(2)).getMaterial() != Material.AIR)) {
            return BlockUtilSC.Method2162895(blockPos) == null ? new BlockPos(0, 0, 1) : null;
        }
        return null;
    }

    public static BlockPos Method2162895(BlockPos blockPos) {
        if (BlockUtilSC.Field2008.world.getBlockState(blockPos.down()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.west()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.south()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.north()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.up()).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.up(2)).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().down()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.east(2)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().south()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().north()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.east()).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().up()).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.east().up(2)).getMaterial() == Material.AIR) {
            return new BlockPos(1, 0, 0);
        }
        if (BlockUtilSC.Field2008.world.getBlockState(blockPos.down()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.west()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.east()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.north()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.up()).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.up(2)).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().down()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.south(2)).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().east()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().west()).getBlock() == Blocks.BEDROCK && BlockUtilSC.Field2008.world.getBlockState(blockPos.south()).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().up()).getMaterial() == Material.AIR && BlockUtilSC.Field2008.world.getBlockState(blockPos.south().up(2)).getMaterial() == Material.AIR) {
            return new BlockPos(0, 0, 1);
        }
        return null;
    }

    public static boolean Method2162896(BlockPos blockPos) {
        return BlockUtilSC.Method2162892(blockPos) || BlockUtilSC.Method2162893(blockPos);
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public final BlockPos Field2369;
        public final EnumFacing Field2370;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, EnumFacing enumFacing) {
            this.Field2369 = blockPos;
            this.Field2370 = enumFacing;
        }
    }
}

