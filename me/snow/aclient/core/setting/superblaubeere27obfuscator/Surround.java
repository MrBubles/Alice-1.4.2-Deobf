

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import me.snow.aclient.mixin.mixins.accessors.IMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Surround
        extends Module {
    public static boolean Field3466 = false;
    public static float Field3478;
    public static float Field3479;
    private final Setting<Boolean> Field3451 = this.Method2150366(new Setting<Boolean>("Packet", true));
    private final Setting<Boolean> Field3452 = this.Method2150366(new Setting<Boolean>("TPCenter", true));
    private final Setting<Boolean> Field3453 = this.Method2150366(new Setting<Boolean>("NCPCenter", Boolean.valueOf(true), this::Method2161317));
    private final Setting<Boolean> Field3454 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private final Setting<Integer> Field3455 = this.Method2150366(new Setting<Integer>("Blocks/Tick", 3, 1, 8));
    private final Setting<Float> Field3456 = this.Method2150366(new Setting<Float>("Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    private final Setting<Boolean> Field3457 = this.Method2150366(new Setting<Boolean>("Swing", true));
    private final Setting<Boolean> Field3458 = this.Method2150366(new Setting<Boolean>("ForcePlace", false));
    private final Setting<Boolean> Field3459 = this.Method2150366(new Setting<Boolean>("StrictDirection", false));
    private final Setting<Boolean> Field3460 = this.Method2150366(new Setting<Boolean>("Toggle", true));
    private final Setting<Boolean> Field3461 = this.Method2150366(new Setting<Boolean>("AllowEChests", true));
    private final Setting<Boolean> Field3462 = this.Method2150366(new Setting<Boolean>("Clear", false));
    private final Setting<Boolean> Field3463 = this.Method2150366(new Setting<Boolean>("Queue", true));
    private final Setting<Boolean> Field3464 = this.Method2150366(new Setting<Boolean>("Full", true));
    private final Setting<Boolean> Field3465 = this.Method2150366(new Setting<Boolean>("Test", true));
    public Timer Field3467 = new Timer();
    public BlockPos Field3468;
    public int Field3469;
    public boolean Field3470;
    public int Field3471 = 0;
    public int Field3472 = -1;
    public boolean Field3473 = false;
    public List<Vec3d> Field3474 = new ArrayList<Vec3d>();
    public ConcurrentHashMap<BlockPos, Long> Field3475 = new ConcurrentHashMap();
    public BlockPos Field3476;
    public Timer Field3477 = new Timer();

    public Surround() {
        super("Surround", "awa surround", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static void Method2161299() {
        AliceMain.Field756.Method2150180(Surround.class).Field3451.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3452.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3453.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3454.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3455.setValue(2);
        AliceMain.Field756.Method2150180(Surround.class).Field3456.setValue(Float.valueOf(6.0f));
        AliceMain.Field756.Method2150180(Surround.class).Field3457.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3458.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3459.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3460.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3461.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3462.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3463.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3464.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3465.setValue(true);
    }

    public static void Method2161290() {
        AliceMain.Field756.Method2150180(Surround.class).Field3451.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3452.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3453.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3454.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3455.setValue(5);
        AliceMain.Field756.Method2150180(Surround.class).Field3456.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(Surround.class).Field3457.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3458.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3459.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3460.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3461.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3462.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3463.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3464.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3465.setValue(true);
    }

    public static void Method2161201() {
        AliceMain.Field756.Method2150180(Surround.class).Field3451.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3452.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3453.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3454.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3455.setValue(5);
        AliceMain.Field756.Method2150180(Surround.class).Field3456.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(Surround.class).Field3457.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3458.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3459.setValue(false);
        AliceMain.Field756.Method2150180(Surround.class).Field3460.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3461.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3462.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3463.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3464.setValue(true);
        AliceMain.Field756.Method2150180(Surround.class).Field3465.setValue(true);
    }

    @Override
    public String Method2150385() {
        String string = this.Field3477.Method2164759() > 1600L ? (Object) ChatFormatting.GREEN + "" : (this.Field3477.Method2164759() > 1100L ? (Object) ChatFormatting.YELLOW + "" : (this.Field3477.Method2164759() > 600L ? (Object) ChatFormatting.GOLD + "" : (Object) ChatFormatting.RED + ""));
        Field3478 = this.Field3477.Method2164759() / 100L;
        Field3479 = Field3478 / 10.0f;
        return string + (Math.floor(Field3479) == (double) Field3479 ? Integer.valueOf((int) Field3479) + ".0" : String.format("%.1f", Float.valueOf(Field3479))) + "";
    }

    public int Method2161202() {
        Block block;
        ItemStack itemStack;
        int n2;
        int n3 = -1;
        int n4 = InventoryUtil.Method2163778(BlockObsidian.class);
        if (this.Field3461.getValue().booleanValue() && n4 == -1) {
            for (n2 = 0; n2 < 9; ++n2) {
                itemStack = Surround.Field2811.player.inventory.getStackInSlot(n2);
                if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockEnderChest))
                    continue;
                n3 = n2;
                return n3;
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            itemStack = Surround.Field2811.player.inventory.getStackInSlot(n2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n3 = n2;
            break;
        }
        return n3;
    }

    public void Method2161203() {
        if (this.Method2161311()) {
            return;
        }
        this.Field3476 = null;
        this.Field3474 = new ArrayList<Vec3d>();
        if (this.Method2161206()) {
            if (this.Field3464.getValue().booleanValue()) {
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(1.0, 0.0, 0.0));
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(-1.0, 0.0, 0.0));
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, 0.0, 1.0));
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, 0.0, -1.0));
            }
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(1.0, 1.0, 0.0));
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(-1.0, 1.0, 0.0));
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, 1.0, 1.0));
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, 1.0, -1.0));
        } else {
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, -1.0, 0.0));
            if (this.Field3464.getValue().booleanValue()) {
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(1.0, -1.0, 0.0));
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(-1.0, -1.0, 0.0));
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, -1.0, 1.0));
                this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, -1.0, -1.0));
            }
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(1.0, 0.0, 0.0));
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(-1.0, 0.0, 0.0));
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, 0.0, 1.0));
            this.Field3474.add(Surround.Field2811.player.getPositionVector().add(0.0, 0.0, -1.0));
        }
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        Iterator<Vec3d> iterator = this.Field3474.iterator();
        while (iterator.hasNext()) {
            BlockPos blockPos = new BlockPos(iterator.next());
            if (Surround.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.AIR) continue;
            arrayList.add(blockPos);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (BlockPos blockPos : arrayList) {
            if (this.Field3471 > this.Field3455.getValue()) {
                return;
            }
            if (this.Field3475.containsKey((Object) blockPos) || this.Method2161208(blockPos)) continue;
            if (this.Method2161316(blockPos)) {
                if (!this.Field3462.getValue().booleanValue()) continue;
                Entity entity = null;
                for (Entity entity2 : Surround.Field2811.world.loadedEntityList) {
                    if (entity2 == null || (double) Surround.Field2811.player.getDistance(entity2) > 2.4 || !(entity2 instanceof EntityEnderCrystal) || entity2.isDead)
                        continue;
                    entity = entity2;
                }
                if (entity != null) {
                    if (this.Field3454.getValue().booleanValue()) {
                        Object object = RotationManager.Method2150291(Surround.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), ((EntityEnderCrystal) entity).getPositionEyes(Field2811.getRenderPartialTicks()));
                        Surround.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation((float) object[0], (float) MathHelper.normalizeAngle((int) ((int) object[1]), (int) 360), Surround.Field2811.player.onGround));
                        ((IEntityPlayerSP) Surround.Field2811.player).setLastReportedYaw((float) object[0]);
                        ((IEntityPlayerSP) Surround.Field2811.player).setLastReportedPitch(MathHelper.normalizeAngle((int) ((int) object[1]), (int) 360));
                    }
                    Field2811.getConnection().sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
                    Field2811.getConnection().sendPacket((Packet) new CPacketUseEntity(entity));
                }
            }
            this.Field3476 = blockPos;
            this.Method2161315(this.Field3476);
            ++this.Field3471;
        }
    }

    public void Method2161204() {
        this.Method2161203();
    }

    @SubscribeEvent
    public void Method2161205(PacketEvent packetEvent) {
        if (Surround.Field2811.world == null || Surround.Field2811.player == null) {
            return;
        }
        if (packetEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketBlockChange && this.Field3463.getValue().booleanValue()) {
            SPacketBlockChange sPacketBlockChange = (SPacketBlockChange) packetEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketBlockChange.blockState.getBlock() == Blocks.AIR && Surround.Field2811.player.getDistance((double) sPacketBlockChange.getBlockPosition().getX(), (double) sPacketBlockChange.getBlockPosition().getY(), (double) sPacketBlockChange.getBlockPosition().getZ()) < 1.75) {
                Field2811.addScheduledTask(this::Method2161207);
            }
        }
    }

    public boolean Method2161206() {
        return !this.Method2161200() && this.Method2161314((Entity) Surround.Field2811.player);
    }

    @Override
    public void Method2150373() {
        if (Surround.Field2811.player == null || Surround.Field2811.world == null) {
            return;
        }
        this.Field3476 = null;
        Field3466 = false;
        this.Field3470 = this.Method2161312(this.Field3470);
    }

    public void Method2161207() {
        this.Method2161203();
    }

    public boolean Method2161208(BlockPos blockPos) {
        for (Entity entity : Surround.Field2811.world.loadedEntityList) {
            if (entity instanceof EntityEnderCrystal || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    public void Method2161209(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long) (CrystalUtilSC.Method2162805() + 40)) {
            this.Field3475.remove((Object) blockPos);
        }
    }

    public boolean Method2161200() {
        Block block = Surround.Field2811.world.getBlockState(new BlockPos(Surround.Field2811.player.getPositionVector().add(0.0, 0.2, 0.0))).getBlock();
        return block == Blocks.OBSIDIAN || block == Blocks.ENDER_CHEST;
    }

    public boolean Method2161311() {
        if (Surround.Field2811.player == null || Surround.Field2811.world == null) {
            return true;
        }
        Field3466 = false;
        this.Field3471 = 0;
        this.Field3472 = this.Method2161202();
        if (!this.Method2150364()) {
            return true;
        }
        if (this.Field3472 == -1) {
            this.Method2150391();
            return true;
        }
        this.Field3470 = this.Method2161312(this.Field3470);
        if (Surround.Field2811.player.inventory.currentItem != this.Field3469 && Surround.Field2811.player.inventory.currentItem != this.Field3472) {
            this.Field3469 = Surround.Field2811.player.inventory.currentItem;
        }
        if (this.Field3460.getValue().booleanValue() && !this.Field3468.equals((Object) new BlockPos((Entity) Surround.Field2811.player))) {
            this.Method2150391();
            return true;
        }
        return !this.Field3467.Method2164755((long) (this.Field3456.getValue().floatValue() * 10.0f));
    }

    @Override
    public void Method2150372() {
        if (Surround.Field2811.player == null || Surround.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        this.Field3469 = Surround.Field2811.player.inventory.currentItem;
        this.Field3468 = new BlockPos((Entity) Surround.Field2811.player);
        if (this.Field3452.getValue().booleanValue()) {
            PlayerUtilSC.Method2162920(this.Field3453.getValue());
        }
        this.Field3475.clear();
        if (this.Field3465.getValue().booleanValue()) {
            this.Field3467.Method2164750();
        }
        this.Field3477.Method2164750();
    }

    @Override
    public void Method2150376() {
        if (Surround.Field2811.player == null || Surround.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        this.Field3475.forEach((arg_0, arg_1) -> this.Method2161209(arg_0, arg_1));
        Field2811.addScheduledTask(this::Method2161204);
    }

    public boolean Method2161312(boolean bl) {
        if (bl && Surround.Field2811.player != null) {
            Surround.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Surround.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public boolean Method2161313(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        EnumFacing enumFacing3;
        boolean bl4 = false;
        EnumFacing enumFacing2 = null;
        double d = 69420.0;
        for (EnumFacing enumFacing3 : InteractionUtil.Method2163762(blockPos, this.Field3459.getValue(), false)) {
            Vec3d vec3d = new Vec3d((Vec3i) blockPos.offset(enumFacing3));
            Vec3d vec3d2 = new Vec3d(enumFacing3.getDirectionVec());
            if (!(Surround.Field2811.player.getPositionVector().add(0.0, (double) Surround.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d.add(0.5, 0.5, 0.5).add(vec3d2.scale(0.5))) < 69420.0))
                continue;
            enumFacing2 = enumFacing3;
        }
        if (enumFacing2 == null) {
            enumFacing2 = EnumFacing.DOWN;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing2);
        enumFacing3 = enumFacing2.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
        if (!Surround.Field2811.player.isSneaking() && BlockUtilSC.Method2162891(blockPos2)) {
            Surround.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Surround.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            Surround.Field2811.player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            PlayerUtilSC.Method2162933(vec3d);
        }
        InteractionUtil.Method2163756(blockPos2, vec3d, enumHand, enumFacing3, bl2, this.Field3457.getValue());
        Surround.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        if (!this.Field3458.getValue().booleanValue()) {
            this.Field3475.put(blockPos, System.currentTimeMillis());
        }
        ((IMinecraft) Field2811).setRightClickDelayTimer(0);
        return bl4 || bl3;
    }

    public boolean Method2161314(Entity entity) {
        BlockPos blockPos = new BlockPos(entity.posX, entity.posY, entity.posZ);
        return Surround.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.OBSIDIAN) || Surround.Field2811.world.getBlockState(blockPos).getBlock().equals((Object) Blocks.ENDER_CHEST);
    }

    public void Method2161315(BlockPos blockPos) {
        int n2 = Surround.Field2811.player.inventory.currentItem;
        if (this.Field3472 == -1) {
            this.Method2150391();
            return;
        }
        Field3466 = true;
        try {
            Surround.Field2811.player.inventory.currentItem = this.Field3472;
            Surround.Field2811.playerController.updateController();
            this.Field3470 = this.Method2161313(blockPos, this.Field3473 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field3454.getValue(), this.Field3451.getValue(), this.Field3470);
            Surround.Field2811.player.inventory.currentItem = n2;
            Surround.Field2811.playerController.updateController();
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public boolean Method2161316(BlockPos blockPos) {
        for (Entity entity : Surround.Field2811.world.loadedEntityList) {
            if (!(entity instanceof EntityEnderCrystal) || entity.equals((Object) Surround.Field2811.player) || entity instanceof EntityItem || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox()))
                continue;
            return true;
        }
        return false;
    }

    private boolean Method2161317(Boolean bl) {
        return this.Field3452.getValue();
    }
}

