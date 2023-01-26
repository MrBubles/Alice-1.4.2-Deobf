

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.GameType
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.GameType;

public class AutoTrapReal
        extends Module {
    public static final List Field3549 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER});
    public static final List Field3550 = Arrays.asList(new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
    private final Setting<Float> Field3551 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(4.5f), Float.valueOf(3.5f), Float.valueOf(32.0f)));
    private final Setting<Integer> Field3552 = this.Method2150366(new Setting<Integer>("BlocksPerTick", 2, 1, 23));
    private final Setting<Integer> Field3553 = this.Method2150366(new Setting<Integer>("TickDelay", 1, 0, 10));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3554 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Cage", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.TRAP));
    private final Setting<Boolean> Field3555 = this.Method2150366(new Setting<Boolean>("Rotate", false));
    private final Setting<Boolean> Field3556 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private final Setting<Boolean> Field3557 = this.Method2150366(new Setting<Boolean>("NoGlitchBlocks", true));
    private final Setting<Boolean> Field3558 = this.Method2150366(new Setting<Boolean>("ActiveInFreecam", true));
    private final Setting<Boolean> Field3559 = this.Method2150366(new Setting<Boolean>("Toggle Off", false));
    private final Setting<Boolean> Field3560 = this.Method2150366(new Setting<Boolean>("Disable", true));
    private final Setting<Integer> Field3561 = this.Method2150366(new Setting<Integer>("Sc/Disable", 2, 1, 10));
    private final Setting<Boolean> Field3562 = this.Method2150366(new Setting<Boolean>("Render", false));
    private final Setting<Boolean> Field3563 = this.Method2150366(new Setting<Boolean>("Csync", false));
    private final Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field3564 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Esp Mode", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Full));
    private final Setting<Integer> Field3565 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    private final Setting<Integer> Field3566 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private final Setting<Integer> Field3567 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    private final Setting<Integer> Field3568 = this.Method2150366(new Setting<Integer>("Alpha", 70, 0, 255));
    private final Setting<Integer> Field3569 = this.Method2150366(new Setting<Integer>("BoxAlpha", 70, 0, 255));
    private final Set<BlockPos> Field3583 = new HashSet<BlockPos>();
    private final Timer Field3584 = new Timer();
    int Field3570 = 0;
    String Field3571;
    boolean Field3572;
    boolean Field3573;
    private EntityPlayer Field3574;
    private String Field3575 = "";
    private int Field3576 = -1;
    private int Field3577 = -1;
    private int Field3578 = 0;
    private boolean Field3579 = false;
    private int Field3580 = 0;
    private boolean Field3581;
    private int Field3582;

    public AutoTrapReal() {
        super("AutoTrap", "Automatically traps player", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static EnumFacing Method2161305(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!AutoTrapReal.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(AutoTrapReal.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = AutoTrapReal.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable())
                continue;
            return enumFacing;
        }
        return null;
    }

    private static Block Method2161306(BlockPos blockPos) {
        return AutoTrapReal.Method2161307(blockPos).getBlock();
    }

    private static IBlockState Method2161307(BlockPos blockPos) {
        return AutoTrapReal.Field2811.world.getBlockState(blockPos);
    }

    public static boolean Method2161308(BlockPos blockPos) {
        return AutoTrapReal.Method2161306(blockPos).canCollideCheck(AutoTrapReal.Method2161307(blockPos), false);
    }

    @Override
    public void Method2150372() {
        this.Field3582 = 0;
        if (AutoTrapReal.Field2811.player == null) {
            this.Method2150380();
            return;
        }
        this.Field3573 = false;
        this.Field3581 = true;
        this.Field3576 = AutoTrapReal.Field2811.player.inventory.currentItem;
        this.Field3577 = -1;
        this.Field3584.Method2164750();
    }

    @Override
    public void Method2150373() {
        if (AutoTrapReal.Field2811.player == null) {
            return;
        }
        if (this.Field3577 != this.Field3576 && this.Field3576 != -1) {
            AutoTrapReal.Field2811.player.inventory.currentItem = this.Field3576;
        }
        if (this.Field3579) {
            Field2811.getConnection().sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapReal.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.Field3579 = false;
        }
        this.Field3576 = -1;
        this.Field3577 = -1;
        this.Field3583.clear();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field3562.getValue().booleanValue()) {
            for (BlockPos blockPos : this.Field3583) {
                if (this.Field3564.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Solid) {
                    RenderUtil.Method2163908(blockPos, this.Field3563.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3565.getValue(), this.Field3566.getValue(), this.Field3567.getValue(), this.Field3568.getValue()), true, this.Field3563.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3565.getValue(), this.Field3566.getValue(), this.Field3567.getValue(), this.Field3568.getValue()), 1.2f, false, true, this.Field3569.getValue(), true);
                    continue;
                }
                if (this.Field3564.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Outline) {
                    RenderUtil.Method2163908(blockPos, this.Field3563.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3565.getValue(), this.Field3566.getValue(), this.Field3567.getValue(), this.Field3568.getValue()), true, this.Field3563.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3565.getValue(), this.Field3566.getValue(), this.Field3567.getValue(), this.Field3568.getValue()), 1.2f, true, false, this.Field3569.getValue(), true);
                    continue;
                }
                if (this.Field3564.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Full)
                    continue;
                RenderUtil.Method2163908(blockPos, this.Field3563.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3565.getValue(), this.Field3566.getValue(), this.Field3567.getValue(), this.Field3568.getValue()), true, this.Field3563.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3565.getValue(), this.Field3566.getValue(), this.Field3567.getValue(), this.Field3568.getValue()), 1.2f, true, true, this.Field3569.getValue(), true);
            }
        }
    }

    @Override
    public void Method2150379() {
        if (AutoTrapReal.Method2150359()) {
            return;
        }
        if (this.Field3560.getValue().booleanValue() && this.Field3584.Method2164755(this.Field3561.getValue() * 1000)) {
            Command.Method2159696("<AutoTrap> Disable");
            this.Method2150380();
        }
        if (!(!this.Field3556.getValue().booleanValue() || AutoTrapReal.Field2811.player.onGround && AutoTrapReal.Field2811.player.collidedVertically)) {
            return;
        }
        if (this.Field3570 > 0) {
            --this.Field3570;
        }
        if (this.Field3570 == 0 && this.Field3572) {
            if (ModuleManager.Method2150189(this.Field3571) != null) {
                ModuleManager.Method2150189(this.Field3571).Method2150391();
                this.Field3572 = false;
                this.Field3573 = true;
            }
        }
        if (this.Field3559.getValue().booleanValue()) {
            ++this.Field3582;
            if (this.Field3582 == 20) {
                super.Method2150391();
            }
        }
        if (!this.Field3558.getValue().booleanValue() && AliceMain.Field756.Method2150180(Freecam.class).Method2150364()) {
            return;
        }
        if (!this.Field3581) {
            if (this.Field3578 < this.Field3553.getValue()) {
                ++this.Field3578;
                return;
            }
            this.Field3578 = 0;
        }
        this.Method2161411();
        if (this.Field3574 == null) {
            if (this.Field3581) {
                this.Field3581 = false;
            }
            return;
        }
        if (this.Field3581) {
            this.Field3581 = false;
            this.Field3575 = this.Field3574.getName();
        } else if (!this.Field3575.equals(this.Field3574.getName())) {
            this.Field3575 = this.Field3574.getName();
            this.Field3580 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (this.Field3554.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.TRAP) {
            Collections.addAll(arrayList, IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161301());
        }
        if (this.Field3554.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.TRAPNOSTEP) {
            Collections.addAll(arrayList, IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161302());
        }
        if (this.Field3554.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.TRAPFULLROOF) {
            Collections.addAll(arrayList, IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161303());
        }
        if (this.Field3554.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CRYSTAL) {
            Collections.addAll(arrayList, IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161304());
        }
        int n2 = 0;
        while (n2 < this.Field3552.getValue()) {
            if (this.Field3580 >= arrayList.size()) {
                this.Field3580 = 0;
                break;
            }
            BlockPos blockPos = new BlockPos((Vec3d) arrayList.get(this.Field3580));
            BlockPos blockPos2 = new BlockPos(this.Field3574.getPositionVector()).down().add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            this.Field3583.add(blockPos2);
            if (this.Method2161309(blockPos2, this.Field3551.getValue().floatValue())) {
                ++n2;
            }
            ++this.Field3580;
        }
        if (n2 > 0) {
            if (this.Field3577 != this.Field3576 && this.Field3576 != -1) {
                AutoTrapReal.Field2811.player.inventory.currentItem = this.Field3576;
                this.Field3577 = this.Field3576;
            }
            if (this.Field3579) {
                AutoTrapReal.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapReal.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                this.Field3579 = false;
            }
        }
    }

    private boolean Method2161309(BlockPos blockPos, double d) {
        Entity entity2;
        Block block = AutoTrapReal.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            this.Field3583.remove((Object) blockPos);
            return false;
        }
        for (Entity entity2 : AutoTrapReal.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
            if (entity2 instanceof EntityItem || entity2 instanceof EntityXPOrb) continue;
            return false;
        }
        EnumFacing enumFacing = AutoTrapReal.Method2161305(blockPos);
        if (enumFacing == null) {
            return false;
        }
        entity2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        if (!AutoTrapReal.Method2161308((BlockPos) entity2)) {
            return false;
        }
        Vec3d vec3d = new Vec3d((Vec3i) entity2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block2 = AutoTrapReal.Field2811.world.getBlockState((BlockPos) entity2).getBlock();
        if (AutoTrapReal.Field2811.player.getPositionVector().distanceTo(vec3d) > d) {
            return false;
        }
        int n2 = this.Method2161300();
        if (n2 == -1) {
            this.Method2150380();
        }
        if (this.Field3577 != n2) {
            AutoTrapReal.Field2811.player.inventory.currentItem = n2;
            this.Field3577 = n2;
        }
        if (!this.Field3579 && Field3549.contains((Object) block2) || Field3550.contains((Object) block2)) {
            AutoTrapReal.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapReal.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            this.Field3579 = true;
        }
        if (this.Field3555.getValue().booleanValue()) {
            BlockUtil.Method2162822(vec3d.x, vec3d.y, vec3d.z);
        }
        AutoTrapReal.Field2811.playerController.processRightClickBlock(AutoTrapReal.Field2811.player, AutoTrapReal.Field2811.world, (BlockPos) entity2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
        AutoTrapReal.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        AutoTrapReal.Field2811.rightClickDelayTimer = 4;
        if (this.Field3557.getValue().booleanValue() && !AutoTrapReal.Field2811.playerController.getCurrentGameType().equals((Object) GameType.CREATIVE)) {
            AutoTrapReal.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, (BlockPos) entity2, enumFacing2));
        }
        return true;
    }

    private int Method2161300() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = AutoTrapReal.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private void Method2161411() {
        List list = AutoTrapReal.Field2811.world.playerEntities;
        this.Field3574 = null;
        for (EntityPlayer entityPlayer : AutoTrapReal.Field2811.world.playerEntities) {
            if (entityPlayer == AutoTrapReal.Field2811.player || AliceMain.Field765.Method2150168(entityPlayer.getName()) || !EntityUtil.Method2163537((Entity) entityPlayer) || entityPlayer.getDistance((Entity) AutoTrapReal.Field2811.player) > 7.0f || entityPlayer.getHealth() <= 0.0f)
                continue;
            if (this.Field3574 == null) {
                this.Field3574 = entityPlayer;
                continue;
            }
            if (AutoTrapReal.Field2811.player.getDistance((Entity) entityPlayer) >= AutoTrapReal.Field2811.player.getDistance((Entity) this.Field3574))
                continue;
            this.Field3574 = entityPlayer;
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field3574 != null) {
            return this.Field3574.getName().toUpperCase();
        }
        return null;
    }

    private static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        Solid,
        Outline,
        Full,
        None;

    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        TRAP,
        TRAPNOSTEP,
        TRAPFULLROOF,
        CRYSTAL;

    }

    private static class IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        private static final Vec3d[] Field1675 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0)};
        private static final Vec3d[] Field1676 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0), new Vec3d(0.0, 4.0, 0.0)};
        private static final Vec3d[] Field1677 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(1.0, 3.0, 0.0), new Vec3d(0.0, 3.0, 1.0), new Vec3d(-1.0, 3.0, 0.0), new Vec3d(0.0, 3.0, 0.0)};
        private static final Vec3d[] Field1678 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(-1.0, 0.0, 1.0), new Vec3d(1.0, 0.0, -1.0), new Vec3d(-1.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 1.0), new Vec3d(-1.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 1.0), new Vec3d(1.0, 1.0, -1.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(-1.0, 2.0, 1.0), new Vec3d(1.0, 2.0, -1.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0)};

        private IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        }

        static Vec3d[] Method2161301() {
            return Field1675;
        }

        static Vec3d[] Method2161302() {
            return Field1676;
        }

        static Vec3d[] Method2161303() {
            return Field1677;
        }

        static Vec3d[] Method2161304() {
            return Field1678;
        }
    }
}

