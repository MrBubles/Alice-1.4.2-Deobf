

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
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class InteractionUtil {
    private static Minecraft Field2976 = Minecraft.getMinecraft();

    public static boolean Method2163748() {
        return true;
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163749(BlockPos blockPos, boolean bl) {
        return InteractionUtil.Method2163751(blockPos, bl, false);
    }

    public static boolean Method2163740(boolean bl) {
        if (!bl) {
            return true;
        }
        return true;
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163751(BlockPos blockPos, boolean bl, boolean bl2) {
        return InteractionUtil.Method2163752(blockPos, bl, bl2, false);
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163752(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        return InteractionUtil.Method2163753(blockPos, bl, bl2, bl3, false);
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163753(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object;
        EnumFacing enumFacing3;
        EnumFacing enumFacing2 = null;
        Vec3d vec3d = null;
        double d = 69420.0;
        for (EnumFacing enumFacing3 : InteractionUtil.Method2163762(blockPos, bl3, bl4)) {
            object = blockPos.offset(enumFacing3);
            Vec3d vec3d2 = new Vec3d((Vec3i) object).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
            if (!(InteractionUtil.Field2976.player.getPositionVector().add(0.0, (double) InteractionUtil.Field2976.player.getEyeHeight(), 0.0).distanceTo(vec3d2) < d))
                continue;
            enumFacing2 = enumFacing3;
            vec3d = vec3d2;
        }
        if (enumFacing2 == null) {
            return null;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing2);
        enumFacing3 = enumFacing2.getOpposite();
        object = RotationManager.Method2150291(InteractionUtil.Field2976.player.getPositionEyes(Field2976.getRenderPartialTicks()), vec3d);
        if (bl) {
            if (bl2) {
                InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation((float) object[0], (float) object[1], InteractionUtil.Field2976.player.onGround));
                ((IEntityPlayerSP) InteractionUtil.Field2976.player).setLastReportedYaw((float) object[0]);
                ((IEntityPlayerSP) InteractionUtil.Field2976.player).setLastReportedPitch((float) object[1]);
            } else {
                InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation((float) object[0], (float) object[1], InteractionUtil.Field2976.player.onGround));
                ((IEntityPlayerSP) InteractionUtil.Field2976.player).setLastReportedYaw((float) object[0]);
                ((IEntityPlayerSP) InteractionUtil.Field2976.player).setLastReportedPitch((float) object[1]);
            }
        }
        return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(blockPos2, enumFacing3, vec3d, (float) object[0], (float) object[1]);
    }

    public static void Method2163754(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand enumHand, boolean bl) {
        boolean bl2 = InteractionUtil.Field2976.player.isSprinting();
        boolean bl3 = BlockUtilSC.Method2162891(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163743());
        if (bl2) {
            InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) InteractionUtil.Field2976.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) InteractionUtil.Field2976.player, CPacketEntityAction.Action.START_SNEAKING));
        }
        InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, enumHand, bl);
        if (bl3) {
            InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) InteractionUtil.Field2976.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) InteractionUtil.Field2976.player, CPacketEntityAction.Action.START_SPRINTING));
        }
    }

    public static void Method2163755(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand enumHand, boolean bl) {
        InteractionUtil.Method2163756(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163743(), iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163745(), enumHand, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163744(), bl, true);
    }

    public static void Method2163756(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl, boolean bl2) {
        if (bl) {
            float f = (float) (vec3d.x - (double) blockPos.getX());
            float f2 = (float) (vec3d.y - (double) blockPos.getY());
            float f3 = (float) (vec3d.z - (double) blockPos.getZ());
            InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            InteractionUtil.Field2976.playerController.processRightClickBlock(InteractionUtil.Field2976.player, InteractionUtil.Field2976.world, blockPos, enumFacing, vec3d, enumHand);
        }
        if (bl2) {
            InteractionUtil.Field2976.player.connection.sendPacket((Packet) new CPacketAnimation(enumHand));
        }
    }

    public static boolean Method2163757(BlockPos blockPos, boolean bl) {
        return InteractionUtil.Method2163759(blockPos, bl, true);
    }

    public static boolean Method2163758(BlockPos blockPos) {
        return InteractionUtil.Field2976.world.rayTraceBlocks(new Vec3d(InteractionUtil.Field2976.player.posX, InteractionUtil.Field2976.player.posY + (double) InteractionUtil.Field2976.player.getEyeHeight(), InteractionUtil.Field2976.player.posZ), new Vec3d((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2163759(BlockPos blockPos, boolean bl, boolean bl2) {
        return InteractionUtil.Method2163750(blockPos, bl, false, bl2);
    }

    public static boolean Method2163750(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        Block block = InteractionUtil.Field2976.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
            return false;
        }
        if (bl3) {
            for (EnumFacing enumFacing : InteractionUtil.Field2976.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (enumFacing instanceof EntityItem || enumFacing instanceof EntityXPOrb) continue;
                return false;
            }
        }
        for (EnumFacing enumFacing : InteractionUtil.Method2163762(blockPos, bl, bl2)) {
            if (!InteractionUtil.Method2163761(blockPos.offset(enumFacing))) continue;
            return true;
        }
        return false;
    }

    public static boolean Method2163761(BlockPos blockPos) {
        return InteractionUtil.Field2976.world.getBlockState(blockPos).getBlock().canCollideCheck(InteractionUtil.Field2976.world.getBlockState(blockPos), false);
    }

    public static List<EnumFacing> Method2163762(BlockPos blockPos, boolean bl, boolean bl2) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            Vec3d vec3d;
            BlockPos blockPos2;
            if (bl2) {
                blockPos2 = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                vec3d = InteractionUtil.Field2976.world.rayTraceBlocks(InteractionUtil.Field2976.player.getPositionEyes(1.0f), (Vec3d) blockPos2);
                if (vec3d != null && vec3d.typeOfHit != RayTraceResult.Type.MISS) {
                    System.out.println("weary");
                    continue;
                }
            }
            blockPos2 = blockPos.offset(enumFacing);
            if (bl) {
                vec3d = InteractionUtil.Field2976.player.getPositionEyes(1.0f);
                Vec3d vec3d2 = new Vec3d((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5);
                IBlockState iBlockState2 = InteractionUtil.Field2976.world.getBlockState(blockPos2);
                boolean bl3 = iBlockState2.getBlock() == Blocks.AIR || iBlockState2.isFullBlock();
                ArrayList<EnumFacing> arrayList2 = new ArrayList<EnumFacing>();
                arrayList2.addAll(InteractionUtil.Method2163763(vec3d.x - vec3d2.x, EnumFacing.WEST, EnumFacing.EAST, !bl3));
                arrayList2.addAll(InteractionUtil.Method2163763(vec3d.y - vec3d2.y, EnumFacing.DOWN, EnumFacing.UP, true));
                arrayList2.addAll(InteractionUtil.Method2163763(vec3d.z - vec3d2.z, EnumFacing.NORTH, EnumFacing.SOUTH, !bl3));
                if (!arrayList2.contains((Object) enumFacing.getOpposite())) continue;
            }
            if ((iBlockState = InteractionUtil.Field2976.world.getBlockState(blockPos2)) == null || !iBlockState.getBlock().canCollideCheck(iBlockState, false) || iBlockState.getMaterial().isReplaceable())
                continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    public static ArrayList<EnumFacing> Method2163763(double d, EnumFacing enumFacing, EnumFacing enumFacing2, boolean bl) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        if (d < -0.5) {
            arrayList.add(enumFacing);
        }
        if (d > 0.5) {
            arrayList.add(enumFacing2);
        }
        if (bl) {
            if (!arrayList.contains((Object) enumFacing)) {
                arrayList.add(enumFacing);
            }
            if (!arrayList.contains((Object) enumFacing2)) {
                arrayList.add(enumFacing2);
            }
        }
        return arrayList;
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private final BlockPos Field2416;
        private final EnumFacing Field2417;
        private final Vec3d Field2418;
        private final float Field2419;
        private final float Field2420;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, float f, float f2) {
            this.Field2416 = blockPos;
            this.Field2417 = enumFacing;
            this.Field2418 = vec3d;
            this.Field2419 = f;
            this.Field2420 = f2;
        }

        public BlockPos Method2163743() {
            return this.Field2416;
        }

        public EnumFacing Method2163744() {
            return this.Field2417;
        }

        public Vec3d Method2163745() {
            return this.Field2418;
        }

        public float Method2163746() {
            return this.Field2419;
        }

        public float Method2163747() {
            return this.Field2420;
        }
    }
}

