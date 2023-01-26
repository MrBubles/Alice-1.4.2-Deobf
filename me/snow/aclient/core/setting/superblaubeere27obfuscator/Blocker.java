

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class Blocker
        extends Module {
    public static final List<Block> Field2903 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE});
    public Setting<Float> Field2897 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(5.0f), Float.valueOf(0.5f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field2898 = this.Method2150366(new Setting<Boolean>("CevBreaker", true));
    public Setting<Boolean> Field2899 = this.Method2150366(new Setting<Boolean>("Packet Place", true));
    private Setting<Boolean> Field2896 = this.Method2150366(new Setting<Boolean>("Piston", true));
    private ArrayList<BlockPos> Field2900 = new ArrayList();
    private BlockPos Field2901 = null;
    private List<BlockPos> Field2902 = new ArrayList<BlockPos>();

    public Blocker() {
        super("Blocker", "Block gs attack lmao", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static Block Method2161150(BlockPos blockPos) {
        return Blocker.Method2161161(blockPos).getBlock();
    }

    public static IBlockState Method2161161(BlockPos blockPos) {
        return Blocker.Field2811.world.getBlockState(blockPos);
    }

    public static boolean Method2161164(BlockPos blockPos, boolean bl) {
        Block block = Blocker.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return false;
        }
        EnumFacing enumFacing = Blocker.Method2161168(blockPos);
        if (enumFacing == null) {
            return false;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        if (bl) {
            Blocker.Method2161166(blockPos2, vec3d, EnumHand.MAIN_HAND, enumFacing2);
        } else {
            Blocker.Field2811.playerController.processRightClickBlock(Blocker.Field2811.player, Blocker.Field2811.world, blockPos2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
            Blocker.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
        return true;
    }

    public static void Method2161165(BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        Vec3d vec3d = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
        if (bl) {
            Blocker.Method2161166(blockPos, vec3d, EnumHand.MAIN_HAND, enumFacing);
        } else {
            Blocker.Field2811.playerController.processRightClickBlock(Blocker.Field2811.player, Blocker.Field2811.world, blockPos, enumFacing, vec3d, EnumHand.MAIN_HAND);
            Blocker.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static void Method2161166(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing) {
        float f = (float) (vec3d.x - (double) blockPos.getX());
        float f2 = (float) (vec3d.y - (double) blockPos.getY());
        float f3 = (float) (vec3d.z - (double) blockPos.getZ());
        Blocker.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        Blocker.Field2811.rightClickDelayTimer = 4;
    }

    public static void Method2161167(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, boolean bl) {
        Vec3d vec3d2 = new Vec3d((Vec3i) blockPos).add(vec3d).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
        if (bl) {
            Blocker.Method2161166(blockPos, vec3d2, EnumHand.MAIN_HAND, enumFacing);
        } else {
            Blocker.Field2811.playerController.processRightClickBlock(Blocker.Field2811.player, Blocker.Field2811.world, blockPos, enumFacing, vec3d2, EnumHand.MAIN_HAND);
            Blocker.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static EnumFacing Method2161168(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!Blocker.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(Blocker.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = Blocker.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable() || Field2903.contains((Object) Blocker.Method2161150(blockPos2)))
                continue;
            return enumFacing;
        }
        return null;
    }

    private static boolean Method2161169(BlockPos blockPos, Entity entity) {
        return EntityUtil.Method2163481(entity).add(0, -1, 0).equals((Object) blockPos);
    }

    private static boolean Method2161160(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    @Override
    public void Method2150373() {
        this.Field2902 = new ArrayList<BlockPos>();
    }

    @Override
    public void Method2150376() {
        int n2;
        if (this.Field2898.getValue().booleanValue()) {
            this.Method2161162();
        }
        if ((n2 = InventoryUtil.Method2163772(Blocks.OBSIDIAN)) == -1) {
            return;
        }
        BlockPos blockPos = PlayerUtil.Method2163942();
        if (this.Field2896.getValue().booleanValue()) {
            int n3;
            BlockPos[] arrblockPos = new BlockPos[]{new BlockPos(2, 1, 0), new BlockPos(-2, 1, 0), new BlockPos(0, 1, 2), new BlockPos(0, 1, -2)};
            BlockPos blockPos2 = new BlockPos(Blocker.Field2811.player.posX, Blocker.Field2811.player.posY, Blocker.Field2811.player.posZ);
            for (n3 = 0; n3 < 4; ++n3) {
                for (int j = 0; j < arrblockPos.length; ++j) {
                    BlockPos blockPos3 = blockPos2.add((Vec3i) arrblockPos[j].add(0, n3, 0));
                    if (Blocker.Method2161150(blockPos3) != Blocks.PISTON && Blocker.Method2161150(blockPos3) != Blocks.STICKY_PISTON)
                        continue;
                    this.Field2901 = blockPos3;
                }
            }
            if (this.Field2901 != null) {
                if (Blocker.Method2161150(this.Field2901) == Blocks.AIR) {
                    if (Blocker.Field2811.player.getDistance((double) this.Field2901.getX(), (double) this.Field2901.getY(), (double) this.Field2901.getZ()) > (double) this.Field2897.getValue().floatValue()) {
                        return;
                    }
                    n3 = Blocker.Field2811.player.inventory.currentItem;
                    Blocker.Field2811.player.inventory.currentItem = n2;
                    Blocker.Field2811.playerController.updateController();
                    BlockUtil.Method2162810(this.Field2901, EnumHand.MAIN_HAND, true, this.Field2899.getValue(), false);
                    Blocker.Field2811.player.inventory.currentItem = n3;
                    Blocker.Field2811.playerController.updateController();
                }
                if (Blocker.Method2161150(this.Field2901) == Blocks.OBSIDIAN || Blocker.Field2811.player.getDistance((double) this.Field2901.getX(), (double) this.Field2901.getY(), (double) this.Field2901.getZ()) > (double) this.Field2897.getValue().floatValue()) {
                    this.Field2901 = null;
                }
            }
        }
    }

    public void Method2161162() {
        BlockPos blockPos = EntityUtil.Method2163481((Entity) Blocker.Field2811.player);
        BlockPos[] arrblockPos = new BlockPos[]{new BlockPos(0, 2, 0), new BlockPos(1, 1, 0), new BlockPos(-1, 1, 0), new BlockPos(0, 1, 1), new BlockPos(0, 1, -1), new BlockPos(1, 1, 1), new BlockPos(1, 1, -1), new BlockPos(-1, 1, 1), new BlockPos(-1, 1, -1)};
        for (BlockPos blockPos2 : arrblockPos) {
            BlockPos blockPos3;
            BlockPos blockPos4 = blockPos.add((Vec3i) blockPos2);
            Entity entity = this.Method2161163(blockPos4);
            if (Objects.isNull((Object) entity) || !Blocker.Method2161150(blockPos3 = EntityUtil.Method2163481(entity).add(0, -1, 0)).equals((Object) Blocks.AIR) && !Blocker.Method2161150(blockPos3).equals((Object) Blocks.OBSIDIAN))
                continue;
            if (!Blocker.Method2161150(blockPos.add(0, 2, 0)).equals((Object) Blocks.AIR)) {
                Blocker.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(Blocker.Field2811.player.posX, (double) blockPos.getY() + 0.21, Blocker.Field2811.player.posZ, false));
            }
            Blocker.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
            if (this.Field2902.contains((Object) blockPos3)) continue;
            this.Field2902.add(blockPos3);
        }
        Iterator<BlockPos> iterator = this.Field2902.iterator();
        while (iterator.hasNext()) {
            int n2;
            BlockPos blockPos5 = (BlockPos) iterator.next();
            if (!Objects.isNull((Object) this.Method2161163(blockPos5)) || (n2 = InventoryUtil.Method2163772(Blocks.OBSIDIAN)) == -1)
                continue;
            InventoryUtil.Method2163760();
            Blocker.Field2811.player.inventory.currentItem = n2;
            Blocker.Field2811.playerController.updateController();
            if (Blocker.Method2161150(blockPos5).equals((Object) Blocks.AIR)) {
                Blocker.Method2161164(blockPos5, this.Field2899.getValue());
                Blocker.Method2161165(blockPos5, EnumFacing.UP, this.Field2899.getValue());
            } else {
                Blocker.Method2161164(blockPos5.add(0, 1, 0), this.Field2899.getValue());
                InventoryUtil.Method2163771();
            }
            iterator.remove();
        }
    }

    private Entity Method2161163(BlockPos blockPos) {
        return Blocker.Field2811.world.loadedEntityList.stream().filter(Blocker::Method2161160).filter(arg_0 -> Blocker.Method2161169(blockPos, arg_0)).min(Comparator.comparing(PlayerUtil::Method2163925)).orElse(null);
    }
}

