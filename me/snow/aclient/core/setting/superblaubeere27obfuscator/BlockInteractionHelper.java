

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Wrapper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class BlockInteractionHelper {
    public static final List Field3623 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER});
    public static final List Field3624 = Arrays.asList(new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
    private static final Minecraft Field3625 = Minecraft.getMinecraft();

    public static boolean Method2162762(ItemStack itemStack) {
        return itemStack != ItemStack.EMPTY;
    }

    public static boolean Method2162763(ItemStack itemStack) {
        return itemStack.getItem() instanceof ItemBlock;
    }

    public static void Method2162764(float f, float f2) {
        Minecraft.getMinecraft().player.rotationYaw = f;
        Minecraft.getMinecraft().player.rotationPitch = f2;
    }

    public static List<BlockPos> Method2162765(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static void Method2162766(double[] arrd) {
        Minecraft.getMinecraft().player.rotationYaw = (float) arrd[0];
        Minecraft.getMinecraft().player.rotationPitch = (float) arrd[1];
    }

    public static boolean Method2162767(BlockPos blockPos) {
        for (Entity entity : BlockInteractionHelper.Field3625.world.loadedEntityList) {
            if (entity.equals((Object) BlockInteractionHelper.Field3625.player) || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    public static boolean Method2162768(BlockPos blockPos) {
        for (Entity entity : BlockInteractionHelper.Field3625.world.loadedEntityList) {
            if (!new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox())) continue;
            return true;
        }
        return false;
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2162769(BlockPos blockPos) {
        if (BlockInteractionHelper.Field3625.world.isAirBlock(blockPos)) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Blank;
        }
        if (!(BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().getBlockHardness(BlockInteractionHelper.Field3625.world.getBlockState(blockPos), (World) BlockInteractionHelper.Field3625.world, blockPos) == -1.0f || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.OBSIDIAN) || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ANVIL) || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENCHANTING_TABLE) || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENDER_CHEST))) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Breakable;
        }
        if (BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.OBSIDIAN) || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ANVIL) || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENCHANTING_TABLE) || BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENDER_CHEST)) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Resistant;
        }
        if (BlockInteractionHelper.Field3625.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.BEDROCK)) {
            return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Unbreakable;
        }
        return null;
    }

    public static void Method2162760(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (BlockInteractionHelper.Method2162769(blockPos.offset(enumFacing)) == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Blank || BlockInteractionHelper.Method2162768(blockPos))
                continue;
            Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
            float[] arrf = new float[]{BlockInteractionHelper.Field3625.player.rotationYaw, BlockInteractionHelper.Field3625.player.rotationPitch};
            if (bl) {
                BlockInteractionHelper.Field3625.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation((float) Math.toDegrees(Math.atan2(vec3d.z - BlockInteractionHelper.Field3625.player.posZ, vec3d.x - BlockInteractionHelper.Field3625.player.posX)) - 90.0f, (float) (-Math.toDegrees(Math.atan2(vec3d.y - (BlockInteractionHelper.Field3625.player.posY + (double) BlockInteractionHelper.Field3625.player.getEyeHeight()), Math.sqrt((vec3d.x - BlockInteractionHelper.Field3625.player.posX) * (vec3d.x - BlockInteractionHelper.Field3625.player.posX) + (vec3d.z - BlockInteractionHelper.Field3625.player.posZ) * (vec3d.z - BlockInteractionHelper.Field3625.player.posZ))))), BlockInteractionHelper.Field3625.player.onGround));
            }
            BlockInteractionHelper.Field3625.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockInteractionHelper.Field3625.player, CPacketEntityAction.Action.START_SNEAKING));
            if (bl3) {
                BlockInteractionHelper.Field3625.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, bl2 ? enumFacing : EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            } else {
                BlockInteractionHelper.Field3625.playerController.processRightClickBlock(BlockInteractionHelper.Field3625.player, BlockInteractionHelper.Field3625.world, blockPos.offset(enumFacing), bl2 ? enumFacing.getOpposite() : EnumFacing.UP, new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
            }
            if (bl4) {
                BlockInteractionHelper.Field3625.player.swingArm(EnumHand.MAIN_HAND);
            }
            BlockInteractionHelper.Field3625.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BlockInteractionHelper.Field3625.player, CPacketEntityAction.Action.STOP_SNEAKING));
            if (bl) {
                BlockInteractionHelper.Field3625.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], BlockInteractionHelper.Field3625.player.onGround));
            }
            if (bl5) {
                BlockInteractionHelper.Field3625.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos.offset(enumFacing), enumFacing.getOpposite()));
            }
            return;
        }
    }

    public static double[] Method2162771(double d, double d2, double d3, EntityPlayer entityPlayer) {
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

    public static void Method2162772(BlockPos blockPos) {
        BlockInteractionHelper.Method2162766(BlockInteractionHelper.Method2162771(blockPos.getX(), blockPos.getY(), blockPos.getZ(), (EntityPlayer) Minecraft.getMinecraft().player));
    }

    public static void Method2162773(BlockPos blockPos) {
        Vec3d vec3d = new Vec3d(Wrapper.Method2164705().posX, Wrapper.Method2164705().posY + (double) Wrapper.Method2164705().getEyeHeight(), Wrapper.Method2164705().posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d2;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!BlockInteractionHelper.Method2162778(blockPos2) || !(vec3d.squareDistanceTo(vec3d2 = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).rotatePitch(0.5f))) <= 18.0625))
                continue;
            BlockInteractionHelper.Method2162776(vec3d2);
            BlockInteractionHelper.Method2162777(blockPos2, enumFacing2, vec3d2);
            Wrapper.Method2164705().swingArm(EnumHand.MAIN_HAND);
            BlockInteractionHelper.Field3625.rightClickDelayTimer = 4;
            return;
        }
    }

    public static float[] Method2162774(Vec3d vec3d) {
        Vec3d vec3d2 = BlockInteractionHelper.Method2162775();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{Wrapper.Method2164705().rotationYaw + MathHelper.wrapDegrees((float) (f - Wrapper.Method2164705().rotationYaw)), Wrapper.Method2164705().rotationPitch + MathHelper.wrapDegrees((float) (f2 - Wrapper.Method2164705().rotationPitch))};
    }

    private static Vec3d Method2162775() {
        return new Vec3d(Wrapper.Method2164705().posX, Wrapper.Method2164705().posY + (double) Wrapper.Method2164705().getEyeHeight(), Wrapper.Method2164705().posZ);
    }

    public static void Method2162776(Vec3d vec3d) {
        float[] arrf = BlockInteractionHelper.Method2162774(vec3d);
        Wrapper.Method2164705().connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], Wrapper.Method2164705().onGround));
    }

    private static void Method2162777(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d) {
        BlockInteractionHelper.Method2162770().processRightClickBlock(Wrapper.Method2164705(), BlockInteractionHelper.Field3625.world, blockPos, enumFacing, vec3d, EnumHand.MAIN_HAND);
    }

    public static boolean Method2162778(BlockPos blockPos) {
        return BlockInteractionHelper.Method2162779(blockPos).canCollideCheck(BlockInteractionHelper.Method2162781(blockPos), false);
    }

    private static Block Method2162779(BlockPos blockPos) {
        return BlockInteractionHelper.Method2162781(blockPos).getBlock();
    }

    private static PlayerControllerMP Method2162770() {
        return Minecraft.getMinecraft().playerController;
    }

    private static IBlockState Method2162781(BlockPos blockPos) {
        return Wrapper.Method2164706().getBlockState(blockPos);
    }

    public static boolean Method2162782(BlockPos blockPos) {
        if (!BlockInteractionHelper.Method2162785(blockPos)) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (!BlockInteractionHelper.Method2162785(blockPos2)) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    public static List<BlockPos> Method2162783(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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
                    if (d < (double) (f * f) && (!bl || d >= (double) ((f - 1.0f) * (f - 1.0f)))) {
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

    public static List<BlockPos> Method2162784(BlockPos blockPos, int n2, float f, boolean bl) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getZ();
        int n5 = n3 - (int) f;
        while ((float) n5 <= (float) n3 + f) {
            int n6 = n4 - (int) f;
            while ((float) n6 <= (float) n4 + f) {
                double d = (n3 - n5) * (n3 - n5) + (n4 - n6) * (n4 - n6);
                if (d < (double) (f * f) && (!bl || d >= (double) ((f - 1.0f) * (f - 1.0f)))) {
                    BlockPos blockPos2 = new BlockPos(n5, n2, n6);
                    arrayList.add(blockPos2);
                }
                ++n6;
            }
            ++n5;
        }
        return arrayList;
    }

    private static boolean Method2162785(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (Wrapper.Method2164706().getBlockState(blockPos2).getMaterial().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static EnumFacing Method2162786(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!BlockInteractionHelper.Field3625.world.getBlockState(blockPos2).getBlock().canCollideCheck(BlockInteractionHelper.Field3625.world.getBlockState(blockPos2), false) || (iBlockState = BlockInteractionHelper.Field3625.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static float[] Method2162787(int n2, int n3, int n4, EnumFacing enumFacing) {
        EntityEgg entityEgg = new EntityEgg((World) BlockInteractionHelper.Field3625.world);
        entityEgg.posX = (double) n2 + 0.5;
        entityEgg.posY = (double) n3 + 0.5;
        entityEgg.posZ = (double) n4 + 0.5;
        EntityEgg entityEgg2 = entityEgg;
        entityEgg2.posX += (double) enumFacing.getDirectionVec().getX() * 0.25;
        EntityEgg entityEgg3 = entityEgg;
        entityEgg3.posY += (double) enumFacing.getDirectionVec().getY() * 0.25;
        EntityEgg entityEgg4 = entityEgg;
        entityEgg4.posZ += (double) enumFacing.getDirectionVec().getZ() * 0.25;
        return BlockInteractionHelper.Method2162788((Entity) entityEgg);
    }

    private static float[] Method2162788(Entity entity) {
        return new float[]{BlockInteractionHelper.Method2162780(entity) + BlockInteractionHelper.Field3625.player.rotationYaw, BlockInteractionHelper.Method2162792(entity) + BlockInteractionHelper.Field3625.player.rotationPitch};
    }

    public static float[] Method2162789(EntityPlayer entityPlayer, BlockPos blockPos) {
        double d = (double) blockPos.getX() - entityPlayer.posX;
        double d2 = (double) blockPos.getY() + 0.5 - (entityPlayer.posY + (double) entityPlayer.getEyeHeight());
        double d3 = (double) blockPos.getZ() - entityPlayer.posZ;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) (Math.atan2(d3, d) * 180.0 / Math.PI) - 90.0f;
        float f2 = (float) (-(Math.atan2(d2, d4) * 180.0 / Math.PI));
        return new float[]{f, f2};
    }

    public static float Method2162780(Entity entity) {
        double d = entity.posX - BlockInteractionHelper.Field3625.player.posX;
        double d2 = entity.posZ - BlockInteractionHelper.Field3625.player.posZ;
        double d3 = d2 < 0.0 && d < 0.0 ? 90.0 + Math.toDegrees(Math.atan(d2 / d)) : (d2 < 0.0 && d > 0.0 ? -90.0 + Math.toDegrees(Math.atan(d2 / d)) : Math.toDegrees(-Math.atan(d / d2)));
        return MathHelper.wrapDegrees((float) (-(BlockInteractionHelper.Field3625.player.rotationYaw - (float) d3)));
    }

    private static float Method2162791(float f) {
        f %= 360.0f;
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        while (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static float Method2162792(Entity entity) {
        double d = entity.posX - BlockInteractionHelper.Field3625.player.posX;
        double d2 = entity.posZ - BlockInteractionHelper.Field3625.player.posZ;
        double d3 = entity.posY - 1.6 + (double) entity.getEyeHeight() - BlockInteractionHelper.Field3625.player.posY;
        double d4 = MathHelper.sqrt((double) (d * d + d2 * d2));
        double d5 = -Math.toDegrees(Math.atan(d3 / d4));
        return -MathHelper.wrapDegrees((float) (BlockInteractionHelper.Field3625.player.rotationPitch - (float) d5));
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Blank,
        Breakable,
        Resistant,
        Unbreakable;

    }
}

