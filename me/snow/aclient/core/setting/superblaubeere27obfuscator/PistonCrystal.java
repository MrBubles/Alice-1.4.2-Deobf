

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.BlockPistonBase
 *  net.minecraft.block.BlockRedstoneTorch
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PistonCrystal
        extends Module {
    public static ModuleManager Field3382;
    private static PistonCrystal Field3383;
    private static boolean Field3386;
    private static double Field3387;
    private static double Field3388;
    public Setting<Boolean> Field3353 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    public Setting<Boolean> Field3354 = this.Method2150366(new Setting<Boolean>("TrapPlayer", false));
    public Setting<Boolean> Field3355 = this.Method2150366(new Setting<Boolean>("AntiWeakness", false));
    public Setting<Double> Field3356 = this.Method2150366(new Setting<Double>("Range", 6.0, 0.0, 6.0));
    public Setting<Integer> Field3357 = this.Method2150366(new Setting<Integer>("BlocksPerTick", 4, 0, 20));
    public Setting<Integer> Field3358 = this.Method2150366(new Setting<Integer>("StartDelay", 0, 0, 20));
    public Setting<Integer> Field3359 = this.Method2150366(new Setting<Integer>("TrapDelay", 1, 0, 20));
    public Setting<Integer> Field3360 = this.Method2150366(new Setting<Integer>("PistonDelay", 1, 0, 20));
    public Setting<Integer> Field3361 = this.Method2150366(new Setting<Integer>("CrystalDelay", 2, 0, 20));
    public Setting<Integer> Field3362 = this.Method2150366(new Setting<Integer>("HitDelay", 6, 0, 20));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3363 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Break Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.swing));
    int[][] Field3376 = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};
    Double[][] Field3377;
    boolean Field3379;
    boolean Field3380;
    boolean Field3381;
    double[] Field3385;
    private boolean Field3364 = false;
    private boolean Field3365 = false;
    private boolean Field3366 = false;
    private boolean Field3367 = false;
    private boolean Field3368 = true;
    private boolean Field3369 = true;
    private int Field3370 = -1;
    private int[] Field3371;
    private int[] Field3372;
    private int Field3373;
    private int Field3374;
    private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field3375;
    private int Field3378 = 0;
    private EntityPlayer Field3384;

    public PistonCrystal() {
        super("PistonCrystal", "Use Pistons and Crystals to pvp.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        Field3383 = this;
    }

    public static PistonCrystal Method2161234() {
        if (Field3383 == null) {
            Field3383 = new PistonCrystal();
        }
        return Field3383;
    }

    public static double[] Method2161246(double d, double d2, double d3, EntityPlayer entityPlayer) {
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

    private static void Method2161247(float f, float f2) {
        Field3387 = f;
        Field3388 = f2;
        Field3386 = true;
    }

    private static void Method2161240() {
        if (Field3386) {
            Field3387 = PistonCrystal.Field2811.player.rotationYaw;
            Field3388 = PistonCrystal.Field2811.player.rotationPitch;
            Field3386 = false;
        }
    }

    @Override
    public void Method2150372() {
        this.Field3385 = new double[3];
        this.Field3372 = new int[]{this.Field3358.getValue(), this.Field3359.getValue(), this.Field3360.getValue(), this.Field3361.getValue(), this.Field3362.getValue()};
        this.Field3375 = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(0.0, 0, null);
        boolean bl = true;
        this.Field3365 = true;
        this.Field3368 = true;
        boolean bl2 = false;
        this.Field3381 = false;
        this.Field3380 = false;
        this.Field3379 = false;
        this.Field3367 = false;
        this.Field3371 = new int[]{-1, -1, -1, -1, -1};
        boolean bl3 = false;
        this.Field3378 = 0;
        this.Field3374 = 0;
        this.Field3373 = 0;
        if (PistonCrystal.Field2811.player == null) {
            this.Method2150380();
            return;
        }
        this.Field3370 = PistonCrystal.Field2811.player.inventory.currentItem;
    }

    @Override
    public void Method2150373() {
        if (PistonCrystal.Field2811.player == null) {
            return;
        }
        if (this.Field3364) {
            PistonCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonCrystal.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.Field3364 = false;
        }
        if (this.Field3370 != PistonCrystal.Field2811.player.inventory.currentItem && this.Field3370 != -1) {
            PistonCrystal.Field2811.player.inventory.currentItem = this.Field3370;
            this.Field3370 = -1;
        }
        this.Field3366 = false;
        this.Field3365 = true;
    }

    @Override
    public void Method2150379() {
        if (PistonCrystal.Field2811.player == null) {
            this.Method2150380();
            return;
        }
        if (this.Field3365) {
            this.Field3384 = EntityUtil2.Method2164374(this.Field3356.getValue());
            if (this.Field3384 == null) {
                return;
            }
            this.Field3365 = false;
            if (this.Method2161230()) {
                if (this.Method2161241()) {
                    this.Field3369 = this.Method2161242();
                } else {
                    this.Field3368 = false;
                }
            } else {
                this.Field3366 = true;
            }
        } else {
            if (this.Field3372 == null) {
                return;
            }
            if (this.Field3374 < this.Field3372[this.Field3373]) {
                ++this.Field3374;
                return;
            }
            this.Field3374 = 0;
        }
        if (this.Field3366 || !this.Field3368 || !this.Field3369 || this.Field3367) {
            this.Method2150380();
            return;
        }
        if (this.Method2161238()) {
            if (this.Field3373 == 1) {
                BlockPos blockPos = this.Method2161236(this.Field3373);
                this.Method2161239(blockPos, this.Field3373, this.Field3375.Field595, this.Field3375.Field596);
                ++this.Field3373;
            } else if (this.Field3373 == 2) {
                BlockPos blockPos = this.Method2161236(this.Field3373 - 1);
                if (!(this.Method2161244(blockPos.getX(), blockPos.getY(), blockPos.getZ()) instanceof BlockPistonBase)) {
                    --this.Field3373;
                } else {
                    BlockPos blockPos2 = this.Method2161236(this.Field3373);
                    if (this.Method2161239(blockPos2, this.Field3373, this.Field3375.Field595, this.Field3375.Field596)) {
                        ++this.Field3373;
                    }
                }
            } else if (this.Field3373 == 3) {
                for (Entity entity : PistonCrystal.Field2811.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || (int) entity.posX != (int) this.Field3375.Field593.get((int) (this.Field3375.Field592 + 1)).x || (int) entity.posZ != (int) this.Field3375.Field593.get((int) (this.Field3375.Field592 + 1)).z)
                        continue;
                    --this.Field3373;
                    break;
                }
                if (this.Field3373 == 3) {
                    BlockPos blockPos = this.Method2161236(this.Field3373);
                    this.Method2161239(blockPos, this.Field3373, this.Field3375.Field595, this.Field3375.Field596);
                    ++this.Field3373;
                }
            } else if (this.Field3373 == 4) {
                this.Method2161235();
            }
        }
    }

    public void Method2161235() {
        Object object = null;
        for (Object object2 : PistonCrystal.Field2811.world.loadedEntityList) {
            if (!(object2 instanceof EntityEnderCrystal) || (((Entity) object2).posX != (double) ((int) ((Entity) object2).posX) && (int) ((Entity) object2).posX != (int) this.Field3384.posX || (int) ((double) ((int) ((Entity) object2).posX) - 0.1) != (int) this.Field3384.posX && (int) ((double) ((int) ((Entity) object2).posX) + 0.1) != (int) this.Field3384.posX || (int) ((Entity) object2).posZ != (int) this.Field3384.posZ) && (((Entity) object2).posZ != (double) ((int) ((Entity) object2).posZ) && (int) ((Entity) object2).posZ != (int) this.Field3384.posZ || (int) ((double) ((int) ((Entity) object2).posZ) - 0.1) != (int) this.Field3384.posZ && (int) ((double) ((int) ((Entity) object2).posZ) + 0.1) != (int) this.Field3384.posZ || (int) ((Entity) object2).posX != (int) this.Field3384.posX))
                continue;
            object = object2;
        }
        if (this.Field3379 && object == null) {
            boolean bl = false;
            this.Field3378 = 0;
            this.Field3373 = 0;
            this.Field3379 = false;
        }
        if (object != null) {
            this.Method2161237((Entity) object);
            this.Field3379 = true;
        } else if (++this.Field3378 >= 35) {
            boolean bl = false;
            for (Object object3 : PistonCrystal.Field2811.world.loadedEntityList) {
                if (!(object3 instanceof EntityEnderCrystal) || (int) ((Entity) object3).posX != (int) this.Field3375.Field593.get((int) (this.Field3375.Field592 + 1)).x || (int) ((Entity) object3).posZ != (int) this.Field3375.Field593.get((int) (this.Field3375.Field592 + 1)).z)
                    continue;
                bl = true;
                break;
            }
            if (!bl) {
                Object object3;
                Object object2;
                object2 = new BlockPos(this.Field3375.Field593.get(this.Field3375.Field592 + 2));
                object3 = new BlockPos(this.Field3384.getPositionVector()).add(object2.getX(), object2.getY(), object2.getZ());
                if (this.Field3381 && this.Method2161244(object3.getX(), object3.getY(), object3.getZ()) instanceof BlockAir) {
                    this.Field3373 = 1;
                    this.Field3381 = false;
                } else {
                    EnumFacing enumFacing = BlockUtil2.Method2164276((BlockPos) object3);
                    if (enumFacing != null) {
                        if (this.Field3353.getValue().booleanValue()) {
                            BlockPos blockPos = object3.offset(enumFacing);
                            EnumFacing enumFacing2 = enumFacing.getOpposite();
                            Vec3d vec3d = new Vec3d((Vec3i) blockPos).add(0.5, 1.0, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
                            BlockUtil2.Method2164273(vec3d);
                        }
                        PistonCrystal.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                        PistonCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, (BlockPos) object3, enumFacing));
                        PistonCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, (BlockPos) object3, enumFacing));
                        this.Field3381 = true;
                    }
                }
            } else {
                boolean bl2 = false;
                for (Entity entity : PistonCrystal.Field2811.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || (int) entity.posX != (int) this.Field3375.Field593.get((int) (this.Field3375.Field592 + 1)).x || (int) entity.posZ != (int) this.Field3375.Field593.get((int) (this.Field3375.Field592 + 1)).z)
                        continue;
                    bl2 = true;
                    break;
                }
                boolean bl3 = false;
                this.Field3378 = 0;
                this.Field3373 = 0;
                this.Field3380 = false;
                if (bl2) {
                    this.Method2161237(null);
                    this.Field3380 = true;
                }
            }
        }
    }

    public BlockPos Method2161236(int n2) {
        BlockPos blockPos = new BlockPos(this.Field3375.Field593.get(this.Field3375.Field592 + n2 - 1));
        return new BlockPos(this.Field3384.getPositionVector()).add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    private void Method2161237(Entity entity) {
        if (this.Field3355.getValue().booleanValue()) {
            PistonCrystal.Field2811.player.inventory.currentItem = this.Field3371[4];
        }
        if (this.Field3353.getValue().booleanValue()) {
            this.Method2161245(entity.posX, entity.posY, entity.posZ, (EntityPlayer) PistonCrystal.Field2811.player);
        }
        if (this.Field3363.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.swing)) {
            this.Method2161248(entity);
            PistonCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
            PistonCrystal.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
        if (this.Field3353.getValue().booleanValue()) {
            PistonCrystal.Method2161240();
        }
    }

    private boolean Method2161238() {
        int n2 = 0;
        int n3 = 0;
        if (this.Field3375.Field593.size() <= 0 || this.Field3375.Field592 <= 0) {
            this.Field3373 = this.Field3373 == 0 ? 1 : this.Field3373;
            return true;
        }
        do {
            BlockPos blockPos = new BlockPos(this.Field3375.Field593.get(n2));
            BlockPos blockPos2 = new BlockPos(this.Field3384.getPositionVector()).add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            if (this.Method2161239(blockPos2, 0, 0.0, 0.0)) {
                ++n3;
            }
            if (n3 == this.Field3357.getValue()) break;
        } while (++n2 < this.Field3375.Field592);
        return false;
        this.Field3373 = this.Field3373 == 0 ? 1 : this.Field3373;
        return true;
    }

    private boolean Method2161239(BlockPos blockPos, int n2, double d, double d2) {
        Block block = PistonCrystal.Field2811.world.getBlockState(blockPos).getBlock();
        EnumFacing enumFacing = BlockUtil2.Method2164276(blockPos);
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return false;
        }
        if (enumFacing == null) {
            return false;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        if (!BlockUtil.Method2162833(blockPos2)) {
            return false;
        }
        Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5 + d, 1.0, 0.5 + d2).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block2 = PistonCrystal.Field2811.world.getBlockState(blockPos2).getBlock();
        if (PistonCrystal.Field2811.player.inventory.getStackInSlot(this.Field3371[n2]) != ItemStack.EMPTY) {
            if (PistonCrystal.Field2811.player.inventory.currentItem != this.Field3371[n2]) {
                int n3 = PistonCrystal.Field2811.player.inventory.currentItem = this.Field3371[n2] == 11 ? PistonCrystal.Field2811.player.inventory.currentItem : this.Field3371[n2];
            }
            if (!this.Field3364 && BlockUtil.Field576.contains((Object) block2) || BlockUtil.Field577.contains((Object) block2)) {
                PistonCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonCrystal.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
                this.Field3364 = true;
            }
            if (this.Field3353.getValue().booleanValue() || n2 == 1) {
                Vec3d vec3d2 = vec3d;
                if (!this.Field3353.getValue().booleanValue() && n2 == 1) {
                    vec3d2 = new Vec3d(PistonCrystal.Field2811.player.posX + d, PistonCrystal.Field2811.player.posY, PistonCrystal.Field2811.player.posZ + d2);
                }
                BlockUtil2.Method2164273(vec3d2);
            }
            EnumHand enumHand = EnumHand.MAIN_HAND;
            if (this.Field3371[n2] == 11) {
                enumHand = EnumHand.OFF_HAND;
            }
            PistonCrystal.Field2811.playerController.processRightClickBlock(PistonCrystal.Field2811.player, PistonCrystal.Field2811.world, blockPos2, enumFacing2, vec3d, enumHand);
            PistonCrystal.Field2811.player.swingArm(enumHand);
            return true;
        }
        return false;
    }

    private boolean Method2161230() {
        int n2;
        if (PistonCrystal.Field2811.player.getHeldItemOffhand().getItem() instanceof ItemEndCrystal) {
            this.Field3371[2] = 11;
        }
        for (n2 = 0; n2 < 9; ++n2) {
            ItemStack object = PistonCrystal.Field2811.player.inventory.getStackInSlot(n2);
            if (object == ItemStack.EMPTY) continue;
            if (object.getItem() instanceof ItemEndCrystal) {
                this.Field3371[2] = n2;
                continue;
            }
            if (this.Field3355.getValue().booleanValue() && object.getItem() instanceof ItemSword) {
                this.Field3371[4] = n2;
                continue;
            }
            if (!(object.getItem() instanceof ItemBlock)) continue;
            Block block = ((ItemBlock) object.getItem()).getBlock();
            if (block instanceof BlockObsidian) {
                this.Field3371[0] = n2;
                continue;
            }
            if (block instanceof BlockPistonBase) {
                this.Field3371[1] = n2;
                continue;
            }
            if (!(block instanceof BlockRedstoneTorch) && !block.translationKey.equals("blockRedstone")) continue;
            this.Field3371[3] = n2;
        }
        n2 = 0;
        for (int n3 : this.Field3371) {
            if (n3 == -1) continue;
            ++n2;
        }
        return n2 == 4 + (this.Field3355.getValue() != false ? 1 : 0);
    }

    private boolean Method2161241() {
        this.Field3377 = new Double[][]{{this.Field3384.posX + 1.0, this.Field3384.posY, this.Field3384.posZ}, {this.Field3384.posX - 1.0, this.Field3384.posY, this.Field3384.posZ}, {this.Field3384.posX, this.Field3384.posY, this.Field3384.posZ + 1.0}, {this.Field3384.posX, this.Field3384.posY, this.Field3384.posZ - 1.0}};
        return !(this.Method2161244(this.Field3377[0][0], this.Field3377[0][1], this.Field3377[0][2]) instanceof BlockAir) && !(this.Method2161244(this.Field3377[1][0], this.Field3377[1][1], this.Field3377[1][2]) instanceof BlockAir) && !(this.Method2161244(this.Field3377[2][0], this.Field3377[2][1], this.Field3377[2][2]) instanceof BlockAir) && !(this.Method2161244(this.Field3377[3][0], this.Field3377[3][1], this.Field3377[3][2]) instanceof BlockAir);
    }

    private boolean Method2161242() {
        IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(Double.MAX_VALUE, 0, null);
        int n2 = 0;
        int[] arrn = new int[]{(int) PistonCrystal.Field2811.player.posX, (int) PistonCrystal.Field2811.player.posY, (int) PistonCrystal.Field2811.player.posZ};
        int[] arrn2 = arrn;
        int[] arrn3 = arrn2;
        int[] arrn4 = arrn3;
        if ((double) arrn4[1] - this.Field3384.posY > -1.0) {
            for (Double[] arrdouble : this.Field3377) {
                double d = 0.0;
                double[] arrd = new double[]{arrdouble[0], arrdouble[1] + 1.0, arrdouble[2]};
                BlockPos blockPos = new BlockPos(arrd[0], arrd[1], arrd[2]);
                double d2 = PistonCrystal.Field2811.player.getDistance(arrd[0], arrd[1], arrd[2]);
                if (d < iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field591 && (blockPos.getY() != arrn4[1] || arrn4[0] != blockPos.getX() || Math.abs(arrn4[2] - blockPos.getZ()) > 3 && arrn4[2] != blockPos.getZ() || Math.abs(arrn4[0] - blockPos.getX()) > 3)) {
                    arrdouble[1] = arrdouble[1] + 1.0;
                    if (this.Method2161244(arrd[0], arrd[1], arrd[2]) instanceof BlockAir) {
                        double[] arrd2 = new double[]{arrd[0] + (double) this.Field3376[n2][0], arrd[1], arrd[2] + (double) this.Field3376[n2][2]};
                        Block block = this.Method2161244(arrd2[0], arrd2[1], arrd2[2]);
                        if ((block instanceof BlockAir || block instanceof BlockPistonBase) && this.Method2161243(arrd2[0], arrd2[1], arrd2[2])) {
                            boolean bl;
                            boolean bl2 = false;
                            if (!this.Field3353.getValue().booleanValue() || ((int) arrd2[0] == arrn4[0] ? this.Field3384.posZ > PistonCrystal.Field2811.player.posZ != this.Field3384.posZ > arrd2[2] || Math.abs((int) this.Field3384.posZ - (int) PistonCrystal.Field2811.player.posZ) == 1 : (int) arrd2[2] != arrn4[2] || (this.Field3384.posX > PistonCrystal.Field2811.player.posX != this.Field3384.posX > arrd2[0] || Math.abs((int) this.Field3384.posX - (int) PistonCrystal.Field2811.player.posX) == 1) && (Math.abs((int) this.Field3384.posX - (int) PistonCrystal.Field2811.player.posX) <= 1 || arrd2[0] > this.Field3384.posX != (double) arrn4[0] > this.Field3384.posX))) {
                                bl2 = true;
                            }
                            if (bl = bl2) {
                                boolean bl3;
                                boolean bl4 = false;
                                if (!this.Field3353.getValue().booleanValue() || (arrn4[0] == (int) this.Field3384.posX || arrn4[2] == (int) this.Field3384.posZ ? PistonCrystal.Field2811.player.getDistance(arrd[0], arrd[1], arrd[2]) <= 3.5 || arrn4[0] == (int) arrd[0] || arrn4[2] == (int) arrd[2] : arrn4[0] != (int) arrd2[0] || Math.abs((int) this.Field3384.posZ - (int) PistonCrystal.Field2811.player.posZ) == 1 || arrn4[2] == (int) arrd2[2] && Math.abs((int) this.Field3384.posZ - (int) PistonCrystal.Field2811.player.posZ) != 1)) {
                                    bl4 = true;
                                }
                                if (bl3 = bl4) {
                                    int[] object = null;
                                    for (int[] arrn5 : this.Field3376) {
                                        double[] arrd3 = new double[]{arrdouble[0] + (double) this.Field3376[n2][0] + (double) arrn5[0], arrdouble[1], arrdouble[2] + (double) this.Field3376[n2][2] + (double) arrn5[2]};
                                        int[] arrn6 = new int[]{(int) arrd3[0], (int) arrd3[1], (int) arrd3[2]};
                                        int[] arrn7 = new int[]{(int) arrd[0], (int) arrd[1], (int) arrd[2]};
                                        if (!(this.Method2161244(arrd3[0], arrd3[1], arrd3[2]) instanceof BlockAir) || arrn6[0] == arrn7[0] && arrn6[1] == arrn7[1] && arrn7[2] == arrn6[2] || !this.Method2161243(arrd3[0], arrd3[1], arrd3[2]))
                                            continue;
                                        object = arrn5;
                                        break;
                                    }
                                    if (object != null) {
                                        float f;
                                        float f2;
                                        float f3;
                                        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
                                        int n3 = 0;
                                        if (this.Method2161244(arrdouble[0] + (double) this.Field3376[n2][0], arrdouble[1] - 1.0, arrdouble[2] + (double) this.Field3376[n2][2]) instanceof BlockAir) {
                                            arrayList.add(new Vec3d((double) (this.Field3376[n2][0] * 2), (double) this.Field3376[n2][1], (double) (this.Field3376[n2][2] * 2)));
                                            ++n3;
                                        }
                                        if (this.Method2161244(arrdouble[0] + (double) this.Field3376[n2][0] + (double) object[0], arrdouble[1] - 1.0, arrdouble[2] + (double) this.Field3376[n2][2] + (double) object[2]) instanceof BlockAir) {
                                            arrayList.add(new Vec3d((double) (this.Field3376[n2][0] * 2 + object[0]), (double) this.Field3376[n2][1], (double) (this.Field3376[n2][2] * 2 + object[2])));
                                            ++n3;
                                        }
                                        arrayList.add(new Vec3d((double) (this.Field3376[n2][0] * 2), (double) (this.Field3376[n2][1] + 1), (double) (this.Field3376[n2][2] * 2)));
                                        arrayList.add(new Vec3d((double) this.Field3376[n2][0], (double) (this.Field3376[n2][1] + 1), (double) this.Field3376[n2][2]));
                                        arrayList.add(new Vec3d((double) (this.Field3376[n2][0] * 2 + object[0]), (double) (this.Field3376[n2][1] + 1), (double) (this.Field3376[n2][2] * 2 + object[2])));
                                        if (this.Field3376[n2][0] != 0) {
                                            f2 = f3 = this.Field3353.getValue() != false ? (float) this.Field3376[n2][0] / 2.0f : (float) this.Field3376[n2][0];
                                            f = this.Field3353.getValue().booleanValue() ? (PistonCrystal.Field2811.player.getDistanceSq(arrd2[0], arrd2[1], arrd2[2] + 0.5) > PistonCrystal.Field2811.player.getDistanceSq(arrd2[0], arrd2[1], arrd2[2] - 0.5) ? -0.5f : 0.5f) : (float) this.Field3376[n2][2];
                                        } else {
                                            f2 = f = this.Field3353.getValue() != false ? (float) this.Field3376[n2][2] / 2.0f : (float) this.Field3376[n2][2];
                                            f3 = this.Field3353.getValue().booleanValue() ? (PistonCrystal.Field2811.player.getDistanceSq(arrd2[0] + 0.5, arrd2[1], arrd2[2]) > PistonCrystal.Field2811.player.getDistanceSq(arrd2[0] - 0.5, arrd2[1], arrd2[2]) ? -0.5f : 0.5f) : (float) this.Field3376[n2][0];
                                        }
                                        iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Method2161233(d2, n3, arrayList, -1, f3, f);
                                    }
                                }
                            }
                        }
                    }
                }
                ++n2;
            }
            if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field593 != null) {
                if (this.Field3354.getValue().booleanValue()) {
                    Vec3d vec3d = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field593.get(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field592 + 1);
                    int[] arrn7 = new int[]{(int) (-vec3d.x), (int) vec3d.y, (int) (-vec3d.z)};
                    iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field593.add(0, new Vec3d(0.0, 2.0, 0.0));
                    iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field593.add(0, new Vec3d((double) arrn7[0], (double) (arrn7[1] + 1), (double) arrn7[2]));
                    iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field593.add(0, new Vec3d((double) arrn7[0], (double) arrn7[1], (double) arrn7[2]));
                    iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field592 += 3;
                }
                this.Field3375 = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll;
                return true;
            }
        }
        return false;
    }

    private boolean Method2161243(double d, double d2, double d3) {
        int n2 = (int) d;
        int n3 = (int) d2;
        int n4 = (int) d3;
        for (EntityPlayer entityPlayer : PistonCrystal.Field2811.world.playerEntities) {
            if ((int) entityPlayer.posX != n2 || (int) entityPlayer.posZ != n4 || (int) entityPlayer.posY < n3 - 1 || (int) entityPlayer.posY > n3 + 1)
                continue;
            return false;
        }
        return true;
    }

    private Block Method2161244(double d, double d2, double d3) {
        return PistonCrystal.Field2811.world.getBlockState(new BlockPos(d, d2, d3)).getBlock();
    }

    private void Method2161245(double d, double d2, double d3, EntityPlayer entityPlayer) {
        double[] arrd = PistonCrystal.Method2161246(d, d2, d3, entityPlayer);
        PistonCrystal.Method2161247((float) arrd[0], (float) arrd[1]);
    }

    private void Method2161248(Entity entity) {
        PistonCrystal.Field2811.playerController.attackEntity((EntityPlayer) PistonCrystal.Field2811.player, entity);
        PistonCrystal.Field2811.player.swingArm(EnumHand.MAIN_HAND);
    }

    @SubscribeEvent
    public void Method2161249(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        Object t = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        if (t instanceof CPacketPlayer && Field3386) {
            ((CPacketPlayer) t).yaw = (float) Field3387;
            ((CPacketPlayer) t).pitch = (float) Field3388;
        }
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        packet,
        swing;

    }

    static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        public double Field591;
        public int Field592;
        public List<Vec3d> Field593;
        public int Field594;
        public float Field595;
        public float Field596;

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(double d, int n2, List<Vec3d> list) {
            this.Field591 = d;
            this.Field592 = n2;
            this.Field593 = list;
            this.Field594 = -1;
        }

        public void Method2161233(double d, int n2, List<Vec3d> list, int n3, float f, float f2) {
            this.Field591 = d;
            this.Field592 = n2;
            this.Field593 = list;
            this.Field594 = n3;
            this.Field595 = f;
            this.Field596 = f2;
        }
    }
}

