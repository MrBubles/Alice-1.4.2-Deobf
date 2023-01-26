

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
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

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockInteractionHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
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

public class AntiCity
        extends Module {
    private final Setting<Boolean> Field2770 = this.Method2150366(new Setting<Boolean>("Triggerable", true));
    private final Setting<Boolean> Field2771 = this.Method2150366(new Setting<Boolean>("Toggle Other Cauras", true));
    private final Setting<Integer> Field2772 = this.Method2150366(new Setting<Integer>("TimeoutTicks", 40, 1, 100));
    private final Setting<Integer> Field2773 = this.Method2150366(new Setting<Integer>("BlocksPerTick", 4, 1, 9));
    private final Setting<Integer> Field2774 = this.Method2150366(new Setting<Integer>("TickDelay", 0, 0, 10));
    private final Setting<Boolean> Field2775 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private final Setting<Boolean> Field2776 = this.Method2150366(new Setting<Boolean>("NoGlitchBlocks", true));
    double Field2784;
    int Field2785 = 0;
    String Field2786;
    boolean Field2787;
    boolean Field2788;
    private int Field2777 = -1;
    private int Field2778 = -1;
    private int Field2779 = 0;
    private int Field2780 = 0;
    private int Field2781 = 0;
    private boolean Field2782;
    private boolean Field2783 = false;

    public AntiCity() {
        super("AntiCityBoss", "AntiCity.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    @Override
    public void Method2150372() {
        if (AntiCity.Field2811.player == null) {
            this.Method2150380();
            return;
        }
        this.Field2788 = false;
        this.Field2784 = AntiCity.Field2811.player.posY;
        this.Field2782 = true;
        this.Field2777 = AntiCity.Field2811.player.inventory.currentItem;
        this.Field2778 = -1;
    }

    @Override
    public void Method2150373() {
        if (AntiCity.Field2811.player == null) {
            return;
        }
        if (this.Field2778 != this.Field2777 && this.Field2777 != -1) {
            AntiCity.Field2811.player.inventory.currentItem = this.Field2777;
        }
        if (this.Field2783) {
            AntiCity.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AntiCity.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            this.Field2783 = false;
        }
        this.Field2777 = -1;
        this.Field2778 = -1;
    }

    @Override
    public void Method2150379() {
        if (this.Field2785 > 0) {
            --this.Field2785;
        }
        if (this.Field2785 == 0 && this.Field2787) {
            ModuleManager.Method2150189(this.Field2786).Method2150391();
            this.Field2787 = false;
            this.Field2788 = true;
        }
        if (Util.Field2811.player == null || AliceMain.Field756.Method2150195("Freecam")) {
            return;
        }
        if (ModuleManager.Method2150189("AutoCrystal") != null) {
            if (ModuleManager.Method2150189("AutoCrystal").Method2150364() && this.Field2771.getValue().booleanValue() && !this.Field2788) {
                this.Field2786 = "AutoCrystal";
                this.Field2785 = 19;
                this.Field2787 = true;
                ModuleManager.Method2150189(this.Field2786).Method2150391();
            }
        }
        if (this.Field2770.getValue().booleanValue() && this.Field2781 >= this.Field2772.getValue()) {
            this.Field2781 = 0;
            this.Method2150380();
            return;
        }
        if (AntiCity.Field2811.player.posY != this.Field2784) {
            this.Method2150380();
            return;
        }
        if (!this.Field2782) {
            if (this.Field2780 < this.Field2774.getValue()) {
                ++this.Field2780;
                return;
            }
            this.Field2780 = 0;
        }
        if (this.Field2782) {
            this.Field2782 = false;
        }
        int n2 = 0;
        while (n2 < this.Field2773.getValue()) {
            Vec3d[] arrvec3d = new Vec3d[]{};
            int n3 = 0;
            arrvec3d = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Method2150912();
            n3 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Method2150912().length;
            if (this.Field2779 >= n3) {
                this.Field2779 = 0;
                break;
            }
            BlockPos blockPos = new BlockPos(arrvec3d[this.Field2779]);
            BlockPos blockPos2 = new BlockPos(Util.Field2811.player.getPositionVector()).add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            if (this.Method2150913(blockPos2)) {
                ++n2;
            }
            ++this.Field2779;
        }
        if (n2 > 0) {
            if (this.Field2778 != this.Field2777 && this.Field2777 != -1) {
                Util.Field2811.player.inventory.currentItem = this.Field2777;
                this.Field2778 = this.Field2777;
            }
            if (this.Field2783) {
                Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
                this.Field2783 = false;
            }
        }
        ++this.Field2781;
    }

    private boolean Method2150913(BlockPos blockPos) {
        Entity entity2;
        Block block = Util.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid)) {
            return false;
        }
        for (Entity entity2 : Util.Field2811.world.getEntitiesWithinAABBExcludingEntity((Entity) null, new AxisAlignedBB(blockPos))) {
            if (entity2 instanceof EntityItem || entity2 instanceof EntityXPOrb) continue;
            return false;
        }
        EnumFacing enumFacing = BlockInteractionHelper.Method2162786(blockPos);
        if (enumFacing == null) {
            return false;
        }
        entity2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        if (!BlockInteractionHelper.Method2162778((BlockPos) entity2)) {
            return false;
        }
        Vec3d vec3d = new Vec3d((Vec3i) entity2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block2 = AntiCity.Field2811.world.getBlockState((BlockPos) entity2).getBlock();
        int n2 = this.Method2150914();
        if (n2 == -1) {
            this.Method2150380();
        }
        if (this.Field2778 != n2) {
            Util.Field2811.player.inventory.currentItem = n2;
            this.Field2778 = n2;
        }
        if (!this.Field2783 && BlockInteractionHelper.Field3623.contains((Object) block2) || BlockInteractionHelper.Field3624.contains((Object) block2)) {
            Util.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) Util.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            this.Field2783 = true;
        }
        if (this.Field2775.getValue().booleanValue()) {
            BlockInteractionHelper.Method2162776(vec3d);
        }
        Util.Field2811.playerController.processRightClickBlock(Util.Field2811.player, Util.Field2811.world, (BlockPos) entity2, enumFacing2, vec3d, EnumHand.MAIN_HAND);
        Util.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        Util.Field2811.rightClickDelayTimer = 4;
        if (this.Field2776.getValue().booleanValue() && !Util.Field2811.playerController.getCurrentGameType().equals((Object) GameType.CREATIVE)) {
            Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, (BlockPos) entity2, enumFacing2));
        }
        return true;
    }

    private int Method2150914() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = Util.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        SURROUND,
        FULL;

    }

    private static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        private static final Vec3d[] Field3081 = new Vec3d[]{new Vec3d(2.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 2.0), new Vec3d(-2.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -2.0)};

        private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
        }

        static Vec3d[] Method2150912() {
            return Field3081;
        }
    }
}

