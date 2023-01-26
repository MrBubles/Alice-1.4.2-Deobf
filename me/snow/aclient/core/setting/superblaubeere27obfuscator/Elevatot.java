

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
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemSkull
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  org.apache.logging.log4j.LogManager
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleUtilEle;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PistonCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.apache.logging.log4j.LogManager;

public class Elevatot
        extends Module {
    public final Setting<Double> Field636 = this.Method2150366(new Setting<Double>("Range", 4.9, 0.0, 6.0));
    public final Setting<Integer> Field637 = this.Method2150366(new Setting<Integer>("Support Delay", 0, 0, 8));
    public final Setting<Integer> Field638 = this.Method2150366(new Setting<Integer>("Piston Delay", 0, 0, 8));
    public final Setting<Integer> Field639 = this.Method2150366(new Setting<Integer>("Redstone Delay", 0, 0, 8));
    public final Setting<Integer> Field640 = this.Method2150366(new Setting<Integer>("Blocks per Tick", 4, 1, 8));
    public final Setting<Integer> Field641 = this.Method2150366(new Setting<Integer>("Tick Break Redstone", 2, 0, 10));
    public final Setting<Boolean> Field642 = this.Method2150366(new Setting<Boolean>("Client Insta Break", false));
    public final Setting<Boolean> Field643 = this.Method2150366(new Setting<Boolean>("Client Insta Place", false));
    public final Setting<Boolean> Field644 = this.Method2150366(new Setting<Boolean>("Pause After Support", false));
    public final Setting<Boolean> Field645 = this.Method2150366(new Setting<Boolean>("Debug Mode", false));
    public final Setting<Boolean> Field646 = this.Method2150366(new Setting<Boolean>("Trap Before", false));
    public final Setting<Boolean> Field647 = this.Method2150366(new Setting<Boolean>("Double Trap", false));
    public final Setting<Boolean> Field648 = this.Method2150366(new Setting<Boolean>("StopCa", false));
    public final Setting<Boolean> Field649 = this.Method2150366(new Setting<Boolean>("Rotate", false));
    public final Setting<Boolean> Field650 = this.Method2150366(new Setting<Boolean>("Force Burrow", false));
    public final Setting<Boolean> Field651 = this.Method2150366(new Setting<Boolean>("No Glitch Piston", false));
    public final Setting<Boolean> Field652 = this.Method2150366(new Setting<Boolean>("Fill hole", false));
    public final Setting<Boolean> Field653 = this.Method2150366(new Setting<Boolean>("Add Roof", false));
    public final Setting<Boolean> Field654 = this.Method2150366(new Setting<Boolean>("Silent Switch", false));
    public final Setting<Boolean> Field655 = this.Method2150366(new Setting<Boolean>("Check Push", false));
    public final Setting<Boolean> Field656 = this.Method2150366(new Setting<Boolean>("Check Above", false));
    public final Setting<Boolean> Field657 = this.Method2150366(new Setting<Boolean>("Check Surround", false));
    public final Setting<Boolean> Field658 = this.Method2150366(new Setting<Boolean>("Check Burrow", false));
    public final Setting<Boolean> Field659 = this.Method2150366(new Setting<Boolean>("Stop Out", true));
    public final Setting<Integer> Field660 = this.Method2150366(new Setting<Integer>("Tick Out Hole", 0, 0, 10));
    public final Setting<Boolean> Field661 = this.Method2150366(new Setting<Boolean>("Wait Rotate", false));
    final ArrayList<EnumFacing> Field683 = new ArrayList<EnumFacing>(this) {
        final Elevatot Field1089;

        {
            this.Field1089 = elevatot;
            this.add(EnumFacing.DOWN);
        }
    };
    EntityPlayer Field662;
    double[][] Field663;
    double[] Field664;
    int[][] Field665 = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};
    int[] Field666;
    int[] Field667;
    int[] Field668;
    int Field669;
    int Field670;
    int Field671;
    int Field672;
    boolean Field673;
    boolean Field674;
    boolean Field675;
    boolean Field676;
    boolean Field677;
    boolean Field678;
    boolean Field679;
    String Field680;
    IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field681;
    Vec3d Field682 = null;

    public Elevatot() {
        super("Elevatot", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static Block Method2161420(BlockPos blockPos) {
        return Elevatot.Method2161432(blockPos).getBlock();
    }

    public static Block Method2161431(double d, double d2, double d3) {
        return Elevatot.Field2811.world.getBlockState(new BlockPos(d, d2, d3)).getBlock();
    }

    public static IBlockState Method2161432(BlockPos blockPos) {
        return Elevatot.Field2811.world.getBlockState(blockPos);
    }

    public static EnumFacing Method2161434(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!Elevatot.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(Elevatot.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = Elevatot.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static EnumFacing Method2161438(BlockPos blockPos, ArrayList<EnumFacing> arrayList) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2;
            if (arrayList.contains((Object) enumFacing) || !Elevatot.Field2811.world.getBlockState(blockPos2 = blockPos.offset(enumFacing)).getBlock().canCollideCheck(Elevatot.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = Elevatot.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    public static BlockPos Method2161448(Entity entity) {
        return new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
    }

    private void Method2161433(BlockPos blockPos) {
        EnumFacing enumFacing = Elevatot.Method2161434(blockPos);
        if (enumFacing != null) {
            if (this.Field649.getValue().booleanValue()) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                EnumFacing enumFacing2 = enumFacing.getOpposite();
                Vec3d vec3d = new Vec3d((Vec3i) blockPos2).add(0.5, 0.0, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
                RotationUtil.Method2164115(vec3d);
                this.Field682 = vec3d;
            }
            Elevatot.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, enumFacing));
            Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, enumFacing));
            if (this.Field642.getValue().booleanValue()) {
                Elevatot.Field2811.world.setBlockToAir(blockPos);
            }
        }
    }

    @Override
    public void Method2150372() {
        if (Elevatot.Field2811.player == null || Elevatot.Field2811.world == null) {
            this.Method2150380();
            return;
        }
        this.Method2161443();
        if (!this.Method2161445()) {
            return;
        }
        this.Method2161446();
    }

    @Override
    public void Method2150373() {
        if (Elevatot.Field2811.player == null || Elevatot.Field2811.world == null) {
            return;
        }
        if (this.Field678) {
            Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Elevatot.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.Field678 = false;
        }
        String string = "";
        String string2 = "";
        if (this.Field662 == null) {
            string = "No target found...";
        } else if (!this.Field675) {
            string = "The enemy is not in a hole...";
        } else if (!this.Field674) {
            string = "Not enough space...";
        } else if (this.Field676) {
            string = "No materials detected...";
            string2 = this.Method2161435();
        }
        Command.Method2159696(string + "Elevatot turned OFF!");
        if (!string2.equals("")) {
            Command.Method2159696("Materials missing:" + string2);
        }
    }

    String Method2161435() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.Field666[0] == -1) {
            stringBuilder.append(" Obsidian");
        }
        if (this.Field666[1] == -1) {
            stringBuilder.append(" Piston");
        }
        if (this.Field666[2] == -1) {
            stringBuilder.append(" Redstone");
        }
        if (this.Field666[3] == -1 && this.Field673) {
            stringBuilder.append(" Pick");
        }
        if (this.Field666[4] == -1 && this.Field650.getValue().booleanValue()) {
            stringBuilder.append(" Skull");
        }
        return stringBuilder.toString();
    }

    @Override
    public void Method2150379() {
        int n2;
        if (Elevatot.Field2811.player == null || Elevatot.Field2811.world == null) {
            this.Method2150380();
            return;
        }
        if (this.Field662 == null) {
            if (!this.Method2161445()) {
                return;
            }
            this.Method2161446();
        }
        switch (this.Field669) {
            case 0: {
                n2 = this.Field637.getValue();
                break;
            }
            case 1: {
                n2 = this.Field638.getValue();
                break;
            }
            case 2: {
                n2 = this.Field639.getValue();
                break;
            }
            case 3: {
                n2 = this.Field641.getValue();
                break;
            }
            default: {
                n2 = 0;
            }
        }
        if (this.Field671 < n2) {
            ++this.Field671;
            return;
        }
        if (this.Field664 == null) {
            this.Method2150380();
            return;
        }
        boolean bl = false;
        BlockPos blockPos = new BlockPos(0, -100, 0);
        for (int j = 0; j < Elevatot.Field2811.world.playerEntities.size(); ++j) {
            if (!((EntityPlayer) Elevatot.Field2811.world.playerEntities.get(j)).getGameProfile().getId().toString().equals(this.Field680))
                continue;
            blockPos = ((EntityPlayer) Elevatot.Field2811.world.playerEntities.get(j)).getPosition();
            break;
        }
        if (blockPos.getY() == -100) {
            this.Method2150380();
            return;
        }
        if (this.Method2161442()) {
            return;
        }
        if (this.Field659.getValue().booleanValue() && blockPos.getY() != this.Field667[1] && (blockPos.getX() != this.Field667[0] || blockPos.getZ() != this.Field667[2])) {
            if (this.Field672++ >= this.Field660.getValue()) {
                Command.Method2159695("Enemy pushed out of the hole.", false);
                if (this.Field646.getValue().booleanValue()) {
                    Command.Method2159695("Finished trapping him", false);
                    this.Method2161439(new BlockPos(this.Field664[0], this.Field664[1] + 2.0, this.Field664[2]), 0.0, 0.0, 0.0, false, false, this.Field666[0], -1);
                }
                if (this.Field652.getValue().booleanValue()) {
                    Command.Method2159695("Filling the hole", false);
                    this.Method2161439(new BlockPos(this.Field664[0], this.Field664[1], this.Field664[2]), 0.0, 0.0, 0.0, false, false, this.Field666[0], -1);
                }
                this.Method2161433(this.Method2161441(2));
                this.Method2150380();
                return;
            }
        } else if (this.Field672 != 0) {
            this.Field672 = 0;
        }
        this.Field670 = 0;
        if (this.Method2161437()) {
            BlockPos blockPos2 = this.Method2161441(1);
            if (Elevatot.Method2161420(blockPos2) instanceof BlockAir) {
                this.Method2161439(blockPos2, this.Field681.Field1664, this.Field681.Field1665, this.Field681.Field1666, false, true, this.Field666[1], this.Field681.Field1667);
                if (this.Field651.getValue().booleanValue()) {
                    Elevatot.Field2811.world.setBlockToAir(blockPos2);
                }
                if (this.Method2161436()) {
                    this.Field669 = 1;
                }
            }
            if (Elevatot.Method2161420(blockPos2 = this.Method2161441(2)) instanceof BlockAir) {
                this.Method2161439(blockPos2, 0.0, 0.0, 0.0, true, false, this.Field666[2], -1);
                this.Field669 = 3;
                return;
            }
            this.Method2161433(this.Method2161441(2));
            this.Field669 = 2;
            return;
        }
    }

    boolean Method2161436() {
        return ++this.Field670 == this.Field640.getValue();
    }

    boolean Method2161437() {
        if (this.Field681.Field1662 > 0) {
            for (int j = 0; j < this.Field681.Field1662; ++j) {
                boolean bl;
                BlockPos blockPos = this.Method2161430(j);
                if (!(Elevatot.Method2161420(blockPos) instanceof BlockAir)) continue;
                if (this.Field650.getValue().booleanValue() && j == 0) {
                    boolean bl2 = this.Field677;
                    this.Field677 = true;
                    bl = this.Method2161439(blockPos, 0.0, 0.0, 0.0, true, false, this.Field666[4], -1);
                    this.Field677 = bl2;
                } else {
                    bl = this.Method2161439(blockPos, 0.0, 0.0, 0.0, false, false, this.Field666[0], -1);
                }
                if (!bl || !this.Method2161436()) continue;
                this.Field669 = 0;
                return false;
            }
        }
        return this.Field670 <= 0 || this.Field644.getValue() == false;
    }

    boolean Method2161439(BlockPos blockPos, double d, double d2, double d3, boolean bl, boolean bl2, int n2, int n3) {
        int n4;
        Block block;
        Vec3d vec3d;
        EnumFacing enumFacing;
        BlockPos blockPos2;
        block24:
        {
            block25:
            {
                Block block2 = Elevatot.Field2811.world.getBlockState(blockPos).getBlock();
                EnumFacing enumFacing2 = bl && this.Field677 ? Elevatot.Method2161438(blockPos, this.Field683) : Elevatot.Method2161434(blockPos);
                if (!(block2 instanceof BlockAir) && !(block2 instanceof BlockLiquid)) {
                    return false;
                }
                if (enumFacing2 == null) {
                    return false;
                }
                blockPos2 = blockPos.offset(enumFacing2);
                enumFacing = enumFacing2.getOpposite();
                if (!BlockUtil.Method2162833(blockPos2)) {
                    return false;
                }
                vec3d = new Vec3d((Vec3i) blockPos2).add(0.5 + d, 0.5, 0.5 + d3).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                if (this.Field649.getValue().booleanValue()) {
                    BlockUtil.Method2162822(vec3d.x, vec3d.y, vec3d.z);
                    boolean bl3 = this.Field682 != vec3d && this.Field682 != null && Math.abs(this.Field682.x - vec3d.x) > 0.7 && Math.abs(this.Field682.z - vec3d.z) > 0.7;
                    this.Field682 = vec3d;
                    if (this.Field661.getValue().booleanValue() && bl3) {
                        return false;
                    }
                }
                block = Elevatot.Field2811.world.getBlockState(blockPos2).getBlock();
                n4 = Elevatot.Field2811.player.inventory.currentItem;
                if (Elevatot.Field2811.player.inventory.getStackInSlot(n2) == ItemStack.EMPTY || Elevatot.Field2811.player.inventory.currentItem == n2)
                    break block24;
                if (n2 != -1) break block25;
                this.Field676 = true;
                return false;
            }
            try {
                if (this.Field654.getValue().booleanValue()) {
                    Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                } else {
                    Elevatot.Field2811.player.inventory.currentItem = n2;
                }
            } catch (Exception exception) {
                Command.Method2159696("Fatal Error during the creation of the structure. Please, report this bug in the discor's server");
                Logger logger = (Logger) LogManager.getLogger((String) "GameSense");
                logger.info("[Elevatot] error during the creation of the structure.");
                if (exception.getMessage() != null) {
                    logger.info("[Elevatot] error message: " + exception.getClass().getName() + " " + exception.getMessage());
                } else {
                    logger.info("[Elevatot] cannot find the cause");
                }
                boolean bl4 = false;
                if (exception.getStackTrace().length != 0) {
                    logger.info("[Elevatot] StackTrace Start");
                    for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                        logger.info("[Elevatot] " + stackTraceElement.toString());
                    }
                    logger.info("[Elevatot] StackTrace End");
                }
                this.Method2150380();
            }
        }
        if (!this.Field678 && BlockUtil.Field576.contains((Object) block) || BlockUtil.Field577.contains((Object) block)) {
            Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Elevatot.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            this.Field678 = true;
        } else if (bl2) {
            switch (n3) {
                case 0: {
                    Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(0.0f, 0.0f, Elevatot.Field2811.player.onGround));
                    break;
                }
                case 1: {
                    Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(180.0f, 0.0f, Elevatot.Field2811.player.onGround));
                    break;
                }
                case 2: {
                    Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(-90.0f, 0.0f, Elevatot.Field2811.player.onGround));
                    break;
                }
                default: {
                    Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(90.0f, 0.0f, Elevatot.Field2811.player.onGround));
                }
            }
        }
        Elevatot.Field2811.playerController.processRightClickBlock(Elevatot.Field2811.player, Elevatot.Field2811.world, blockPos2, enumFacing, vec3d, EnumHand.MAIN_HAND);
        if (this.Field654.getValue().booleanValue()) {
            Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
            Elevatot.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n4));
        } else {
            Elevatot.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
        return true;
    }

    BlockPos Method2161430(int n2) {
        BlockPos blockPos = new BlockPos(this.Field681.Field1663.get(n2));
        return new BlockPos(this.Field664[0] + (double) blockPos.getX(), this.Field664[1] + (double) blockPos.getY(), this.Field664[2] + (double) blockPos.getZ());
    }

    public BlockPos Method2161441(int n2) {
        try {
            BlockPos blockPos = new BlockPos(this.Field681.Field1663.get(this.Field681.Field1662 + n2 - 1));
            return new BlockPos(this.Field664[0] + (double) blockPos.getX(), this.Field664[1] + (double) blockPos.getY(), this.Field664[2] + (double) blockPos.getZ());
        } catch (NullPointerException nullPointerException) {
            Command.Method2159696("Crash!");
            this.Method2150380();
            return new BlockPos(this.Field664[0], this.Field664[1], this.Field664[2]);
        }
    }

    boolean Method2161442() {
        if (this.Field676 || !this.Field675 || !this.Field674) {
            this.Method2150380();
            return true;
        }
        return false;
    }

    void Method2161443() {
        this.Field682 = null;
        this.Field663 = new double[4][3];
        this.Field666 = new int[]{-1, -1, -1, -1, -1};
        this.Field664 = new double[3];
        this.Field681 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0, 0, null, -1);
        this.Field679 = false;
        this.Field676 = false;
        this.Field673 = false;
        this.Field675 = true;
        this.Field662 = null;
        this.Field669 = -1;
        this.Field672 = 0;
        this.Field671 = 0;
    }

    boolean Method2161444() {
        int n2;
        for (n2 = 0; n2 < 9; ++n2) {
            ItemStack object = Elevatot.Field2811.player.inventory.getStackInSlot(n2);
            if (object == ItemStack.EMPTY) continue;
            if (this.Field650.getValue().booleanValue() && object.getItem() instanceof ItemSkull) {
                this.Field666[4] = n2;
            }
            if (!(object.getItem() instanceof ItemBlock)) continue;
            Block block = ((ItemBlock) object.getItem()).getBlock();
            if (block instanceof BlockObsidian) {
                this.Field666[0] = n2;
                continue;
            }
            if (block instanceof BlockPistonBase) {
                this.Field666[1] = n2;
                continue;
            }
            if (!(block instanceof BlockRedstoneTorch)) continue;
            this.Field666[2] = n2;
            this.Field673 = false;
        }
        n2 = 0;
        for (int n3 : this.Field666) {
            if (n3 == -1) continue;
            ++n2;
        }
        if (this.Field645.getValue().booleanValue()) {
            Command.Method2159695(String.format("%d %d %d %d", this.Field666[0], this.Field666[1], this.Field666[2], this.Field666[3]), false);
        }
        return n2 >= 3 + (this.Field650.getValue() != false ? 1 : 0);
    }

    boolean Method2161445() {
        this.Field662 = (EntityPlayer) EntityUtil2.Method2164302(true, false, false, false, false, this.Field636.getValue().floatValue(), EntityUtil2.Method2164390("Closest"));
        if (this.Field662 == null) {
            this.Method2150380();
        } else {
            this.Field680 = this.Field662.getGameProfile().getId().toString();
        }
        return this.Field662 != null;
    }

    void Method2161446() {
        if (this.Method2161444()) {
            if (this.Method2161447()) {
                this.Field664 = new double[]{this.Field662.posX, this.Field662.posY, this.Field662.posZ};
                this.Field667 = new int[]{(int) this.Field662.posX, this.Field662.getPosition().getY(), (int) this.Field662.posZ};
                this.Field668 = new int[]{(int) Elevatot.Field2811.player.posX, (int) Elevatot.Field2811.player.posY, (int) Elevatot.Field2811.player.posZ};
                this.Field674 = this.Method2161449();
            } else {
                this.Field675 = false;
            }
        } else {
            this.Field676 = true;
        }
    }

    boolean Method2161447() {
        this.Field663 = new double[][]{{this.Field662.posX + 1.0, this.Field662.posY, this.Field662.posZ}, {this.Field662.posX - 1.0, this.Field662.posY, this.Field662.posZ}, {this.Field662.posX, this.Field662.posY, this.Field662.posZ + 1.0}, {this.Field662.posX, this.Field662.posY, this.Field662.posZ - 1.0}};
        return !(this.Field657.getValue() != false && HoleUtilEle.Method2161424(Elevatot.Method2161448((Entity) this.Field662), true, true).Method2161419() == HoleUtilEle.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE || this.Field658.getValue() != false && Elevatot.Method2161420(Elevatot.Method2161448((Entity) this.Field662)) instanceof BlockAir);
    }

    boolean Method2161449() {
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
        block42:
        {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Double.MAX_VALUE, 0, null, -1);
            if (!this.Field656.getValue().booleanValue() || Elevatot.Method2161431(this.Field664[0], this.Field664[1] + 1.0, this.Field664[2]) instanceof BlockAir)
                break block42;
            return false;
        }
        for (int j = 0; j < 4; ++j) {
            try {
                float f;
                float f2;
                Object[] arrobject;
                double[] object = new double[]{this.Field663[j][0], this.Field663[j][1] + 1.0, this.Field663[j][2]};
                int[] arrn = new int[]{this.Field665[j][0], this.Field665[j][1] + 1, this.Field665[j][2]};
                double d = Elevatot.Field2811.player.getDistance(object[0], object[1], object[2]);
                if (!(d < iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field1661) || !(Elevatot.Method2161431(object[0], object[1], object[2]) instanceof BlockAir) && !(Elevatot.Method2161431(object[0], object[1], object[2]) instanceof BlockPistonBase) || this.Method2161440(object[0], object[1], object[2]))
                    continue;
                BlockPos blockPos = new BlockPos(object[0] - (double) (this.Field665[j][0] * 2), object[1], object[2] - (double) (this.Field665[j][2] * 2));
                if (this.Field655.getValue().booleanValue() && (!(Elevatot.Method2161420(blockPos) instanceof BlockAir) || !(Elevatot.Method2161431(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ()) instanceof BlockAir)))
                    continue;
                if (this.Field649.getValue().booleanValue()) {
                    arrobject = new int[]{(int) object[0], (int) object[1], (int) object[2]};
                    boolean bl = false;
                    if (Math.abs(this.Field668[0] - this.Field667[0]) != 1 || Math.abs(this.Field668[2] - this.Field667[2]) != 1) {
                        bl = true;
                        if (this.Field668[0] == this.Field667[0] && this.Field667[0] == arrobject[0]) {
                            if (this.Field668[2] > this.Field667[2] == this.Field667[2] > arrobject[2]) {
                                bl = false;
                            }
                        } else if (this.Field668[2] == this.Field667[2] && this.Field667[2] == arrobject[2] && this.Field668[0] > this.Field667[0] == this.Field667[0] > arrobject[0]) {
                            bl = false;
                        }
                    }
                    if (bl) continue;
                }
                arrobject = new double[3];
                int[] arrn2 = new int[3];
                double d2 = 1000.0;
                boolean bl = false;
                for (int[] arrn3 : this.Field665) {
                    double d3;
                    double[] arrd = new double[]{object[0] + (double) arrn3[0], object[1], object[2] + (double) arrn3[2]};
                    double d4 = Elevatot.Field2811.player.getDistance(arrd[0], arrd[1], arrd[2]);
                    if (d3 > d2 || this.Method2161440(arrd[0], arrd[1], arrd[2]) || !(Elevatot.Method2161431(arrd[0], arrd[1], arrd[2]) instanceof BlockRedstoneTorch) && !(Elevatot.Method2161431(arrd[0], arrd[1], arrd[2]) instanceof BlockAir))
                        continue;
                    arrobject = new double[]{arrd[0], arrd[1], arrd[2]};
                    arrn2 = new int[]{arrn[0] + arrn3[0], arrn[1], arrn[2] + arrn3[2]};
                    bl = true;
                    d2 = d4;
                }
                this.Field677 = false;
                if (!bl) {
                    if (!this.Field673 && Elevatot.Method2161431(object[0], object[1] + 1.0, object[2]) instanceof BlockAir) {
                        arrobject = new double[]{object[0], object[1] + 1.0, object[2]};
                        arrn2 = new int[]{arrn[0], arrn[1] + 1, arrn[2]};
                        this.Field677 = true;
                    }
                    if (!this.Field677) continue;
                }
                Object object2 = new ArrayList();
                int n2 = 0;
                if (this.Field650.getValue().booleanValue()) {
                    object2.add(new Vec3d(0.0, 0.0, 0.0));
                    ++n2;
                }
                if (!this.Field673) {
                    if (this.Field677) {
                        for (int i2 = -1; i2 < 2; ++i2) {
                            if (this.Method2161440(object[0] + (double) arrn[0], object[1], object[2] + (double) arrn[0]) || !(Elevatot.Method2161431(object[0] + (double) arrn[0], object[1] + (double) i2, arrn[2] + arrn[2]) instanceof BlockAir))
                                continue;
                            object2.add(new Vec3d((double) (arrn[0] * 2), (double) (arrn[1] + i2), (double) (arrn[2] * 2)));
                            ++n2;
                        }
                    } else if (Elevatot.Method2161431(arrobject[0], arrobject[1] - 1.0, arrobject[2]) instanceof BlockAir) {
                        object2.add(new Vec3d((double) arrn2[0], (double) (arrn2[1] - 1), (double) arrn2[2]));
                        ++n2;
                    }
                }
                if (this.Field646.getValue().booleanValue() && !this.Field647.getValue().booleanValue()) {
                    for (Vec3d vec3d : new Vec3d[]{new Vec3d(0.0, 0.0, 1.0), new Vec3d(1.0, 0.0, 1.0), new Vec3d(1.0, 1.0, 1.0), new Vec3d(1.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(1.0, 2.0, 1.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, -1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, -1.0)}) {
                        if ((int) vec3d.x == this.Field665[j][0] && (int) vec3d.z == this.Field665[j][2]) continue;
                        object2.add(new Vec3d((double) ((int) vec3d.x - this.Field665[j][0]), vec3d.y, (double) ((int) vec3d.z - this.Field665[j][2])));
                        ++n2;
                    }
                    if (this.Field653.getValue().booleanValue()) {
                        for (Vec3d vec3d : new Vec3d[]{new Vec3d(0.0, 3.0, -1.0), new Vec3d(1.0, 3.0, -1.0)}) {
                            object2.add(new Vec3d((double) ((int) vec3d.x - this.Field665[j][0]), vec3d.y, (double) ((int) vec3d.z - this.Field665[j][2])));
                            ++n2;
                        }
                    }
                } else if (this.Field647.getValue().booleanValue()) {
                    for (Vec3d vec3d : new Vec3d[]{new Vec3d(0.0, 0.0, 1.0), new Vec3d(1.0, 0.0, 1.0), new Vec3d(1.0, 1.0, 1.0), new Vec3d(1.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(1.0, 2.0, 1.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, -1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, -1.0)}) {
                        if ((int) vec3d.x != this.Field665[j][0] || (int) vec3d.z != this.Field665[j][2]) {
                            object2.add(new Vec3d((double) ((int) vec3d.x - this.Field665[j][0]), vec3d.y, (double) ((int) vec3d.z - this.Field665[j][2])));
                            ++n2;
                            continue;
                        }
                        Vec3d vec3d2 = vec3d;
                    }
                    object2.add(new Vec3d((double) this.Field665[j][0], 2.0, (double) this.Field665[j][2]));
                    ++n2;
                    if (this.Field653.getValue().booleanValue()) {
                        for (Vec3d vec3d : new Vec3d[]{new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0)}) {
                            object2.add(new Vec3d((double) ((int) vec3d.x - this.Field665[j][0]), vec3d.y, (double) ((int) vec3d.z - this.Field665[j][2])));
                            ++n2;
                        }
                        object2.add(new Vec3d(0.0, 3.0, 0.0));
                        ++n2;
                    }
                }
                object2.add(new Vec3d((double) arrn[0], (double) arrn[1], (double) arrn[2]));
                object2.add(new Vec3d((double) arrn2[0], (double) arrn2[1], (double) arrn2[2]));
                int n3 = this.Field665[j][0] == 0 ? (this.Field665[j][2] == 1 ? 0 : 1) : (this.Field665[j][0] == 1 ? 2 : 3);
                if (this.Field665[j][0] != 0) {
                    f2 = (float) this.Field665[j][0] / 2.0f;
                    f = Elevatot.Field2811.player.getDistanceSq(object[0], object[1], object[2] + 0.5) > Elevatot.Field2811.player.getDistanceSq(object[0], object[1], object[2] - 0.5) ? -0.5f : 0.5f;
                } else {
                    f = (float) this.Field665[j][2] / 2.0f;
                    f2 = Elevatot.Field2811.player.getDistanceSq(object[0] + 0.5, object[1], object[2]) > Elevatot.Field2811.player.getDistanceSq(object[0] - 0.5, object[1], object[2]) ? -0.5f : 0.5f;
                }
                float f3 = this.Field668[1] - this.Field667[1] == -1 ? 0.0f : 1.0f;
                iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161429(d, n2, (List<Vec3d>) object2, f2, f, f3, n3, blockPos);
                this.Field681 = iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                continue;
            } catch (Exception exception) {
                Command.Method2159696("Fatal Error during the creation of the structure. Please, report this bug in the discord's server");
                Logger logger = (Logger) LogManager.getLogger((String) "GameSense");
                logger.info("[Elevator] error during the creation of the structure.");
                if (exception.getMessage() != null) {
                    logger.info("[Elevator] error message: " + exception.getClass().getName() + " " + exception.getMessage());
                } else {
                    logger.info("[Elevator] cannot find the cause");
                }
                int n4 = 0;
                if (exception.getStackTrace().length != 0) {
                    logger.info("[Elevator] StackTrace Start");
                    for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                        logger.info("[Elevator] " + stackTraceElement.toString());
                    }
                    logger.info("[Elevator] StackTrace End");
                }
                if (this.Field662 != null) {
                    logger.info("[Elevator] closest target is not null");
                } else {
                    logger.info("[Elevator] closest target is null somehow");
                }
                for (StackTraceElement stackTraceElement : (BlockPos) this.Field663) {
                    if (stackTraceElement != null) {
                        logger.info("[Elevator] " + n4 + " is not null");
                    } else {
                        logger.info("[Elevator] " + n4 + " is null");
                    }
                    ++n4;
                }
            }
        }
        if (this.Field645.getValue().booleanValue() && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field1663 != null) {
            Command.Method2159696("Skeleton structure:");
            for (Vec3d vec3d : iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field1663) {
                Command.Method2159695(String.format("%f %f %f", vec3d.x, vec3d.y, vec3d.z), false);
            }
            Command.Method2159696(String.format("X: %f Y: %f Z: %f", Float.valueOf(this.Field681.Field1664), Float.valueOf(this.Field681.Field1665), Float.valueOf(this.Field681.Field1666)));
        }
        return iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field1663 != null;
    }

    private boolean Method2161440(double d, double d2, double d3) {
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

    @Override
    public String Method2150385() {
        if (this.Field662 != null) {
            return this.Field662.getName() + "";
        }
        return "";
    }

    static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public double Field1661;
        public int Field1662;
        public List<Vec3d> Field1663;
        public float Field1664;
        public float Field1665;
        public float Field1666;
        public int Field1667;
        BlockPos Field1668;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(double d, int n2, List<Vec3d> list, int n3) {
            this.Field1661 = d;
            this.Field1662 = n2;
            this.Field1663 = list;
            this.Field1667 = n3;
        }

        public void Method2161429(double d, int n2, List<Vec3d> list, float f, float f2, float f3, int n3, BlockPos blockPos) {
            this.Field1661 = d;
            this.Field1662 = n2;
            this.Field1663 = list;
            this.Field1664 = f;
            this.Field1666 = f2;
            this.Field1665 = f3;
            this.Field1667 = n3;
            this.Field1668 = blockPos;
        }
    }
}

