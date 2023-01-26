

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDirectional
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.BlockPistonBase
 *  net.minecraft.block.properties.IProperty
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentRotaionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PistonPush
        extends Module {
    private static PistonPush Field1804 = new PistonPush();
    public BlockPos Field1816;
    public EnumFacing Field1817;
    public BlockPos Field1818;
    public BlockPos Field1819;
    public EnumFacing Field1820;
    boolean Field1834 = false;
    boolean Field1835 = false;
    private Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1800 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE));
    private Setting<Boolean> Field1801 = this.Method2150366(new Setting<Boolean>("Smart", Boolean.TRUE, this::Method2161287));
    private Setting<Boolean> Field1802 = this.Method2150366(new Setting<Boolean>("DisablePush", Boolean.TRUE, this::Method2161286));
    private Setting<Boolean> Field1803 = this.Method2150366(new Setting<Boolean>("DisableNone", Boolean.FALSE, this::Method2161285));
    private Setting<Integer> Field1805 = this.Method2150366(new Setting<Integer>("TargetRange", 3, 1, 6));
    private Setting<Integer> Field1806 = this.Method2150366(new Setting<Integer>("Delay", 25, 0, 100));
    private Setting<Integer> Field1807 = this.Method2150366(new Setting<Integer>("ActionShift", 3, 1, 8));
    private Setting<Integer> Field1808 = this.Method2150366(new Setting<Integer>("ActionInterval", 0, 0, 10));
    private Setting<Boolean> Field1809 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private Setting<Boolean> Field1810 = this.Method2150366(new Setting<Boolean>("RayTrace", false));
    private Setting<Boolean> Field1811 = this.Method2150366(new Setting<Boolean>("AntiSuicide", false));
    private Setting<Boolean> Field1812 = this.Method2150366(new Setting<Boolean>("Mine", false));
    private Setting<Boolean> Field1813 = this.Method2150366(new Setting<Boolean>("AutoTrap", false));
    private Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll> Field1814 = this.Method2150366(new Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll>("RotateMode", IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Oyvey));
    private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
    private BlockPos Field1821;
    private Timer Field1822 = new Timer();
    private boolean Field1823;
    private boolean Field1824 = false;
    private Timer Field1825 = new Timer();
    private Timer Field1826 = new Timer();
    private int Field1827;
    private Timer Field1828 = new Timer();
    private Runnable Field1829 = null;
    private int Field1830 = 0;
    private BlockPos Field1831 = null;
    private Timer Field1832 = new Timer();
    private Timer Field1833 = new Timer();

    public PistonPush() {
        super("PistonPush", "Good PistonAura", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        this.Method2161252();
    }

    public static PistonPush Method2161251() {
        if (Field1804 == null) {
            Field1804 = new PistonPush();
        }
        return Field1804;
    }

    public static boolean Method2161263(BlockPos blockPos) {
        if (PistonPush.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && PistonPush.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (PistonPush.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR && PistonPush.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.PISTON_HEAD) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (PistonPush.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
            return false;
        }
        return PistonPush.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).isEmpty();
    }

    public static int Method2161268() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PistonPush.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockPistonBase))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private static Float Method2161271(EntityPlayer entityPlayer) {
        return Float.valueOf(PistonPush.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161273(EntityPlayer entityPlayer) {
        return entityPlayer != PistonPush.Field2811.player;
    }

    private static boolean Method2161274(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static Float Method2161278(Entity entity) {
        return Float.valueOf(PistonPush.Field2811.player.getDistance(entity));
    }

    private static boolean Method2161270(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    private void Method2161252() {
        Field1804 = this;
    }

    @Override
    public void Method2150372() {
        if (PistonPush.Field2811.player == null || PistonPush.Field2811.world == null) {
            return;
        }
        this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
        this.Field1816 = null;
        this.Field1817 = null;
        this.Field1818 = null;
        this.Field1819 = null;
        this.Field1820 = null;
        this.Field1827 = 0;
        this.Field1830 = 0;
        this.Field1829 = null;
        this.Field1821 = null;
        this.Field1823 = false;
        this.Field1831 = null;
    }

    private void Method2161253(boolean bl) {
        block52:
        {
            block51:
            {
                if (this.Field1833.Method2164755(1000L) && this.Field1803.getValue().booleanValue()) {
                    this.Method2150391();
                }
                if (!this.Field1825.Method2164755(this.Field1827)) {
                    return;
                }
                if (this.Field1809.getValue().booleanValue() && Math.sqrt(PistonPush.Field2811.player.motionX * PistonPush.Field2811.player.motionX + PistonPush.Field2811.player.motionZ * PistonPush.Field2811.player.motionZ) > 9.0E-4) {
                    return;
                }
                if (this.Field1800.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE)
                    break block51;
                switch (1.F ield1314[this.Field1815.ordinal()]){
                case 1: {
                    List<EntityPlayer> list = this.Method2161267();
                    for (EntityPlayer entityPlayer : list) {
                        if (!this.Method2161258(entityPlayer)) continue;
                        if (PistonPush.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY + 2.0, entityPlayer.posZ)).getBlock().equals((Object) Blocks.AIR) && this.Field1813.getValue().booleanValue()) {
                            this.Method2161250((Entity) entityPlayer);
                            return;
                        }
                        int n2 = PistonPush.Method2161268();
                        if (n2 == -1) {
                            Command.Method2159696("No pistons found!");
                            this.Method2150391();
                            return;
                        }
                        if (this.Field1823) {
                            this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CRYSTAL;
                            this.Field1823 = false;
                            return;
                        }
                        boolean bl2 = PistonPush.Field2811.player.inventory.currentItem != n2;
                        boolean bl3 = PistonPush.Field2811.player.isSprinting();
                        boolean bl4 = BlockUtilSC.Method2162891(this.Field1819);
                        Vec3d vec3d = new Vec3d((Vec3i) this.Field1819).add(0.5, 0.5, 0.5).add(new Vec3d(this.Field1820.getDirectionVec()).scale(0.5));
                        if (bl) {
                            float[] arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                            RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                        } else {
                            float[] arrf;
                            if (this.Field1814.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.New) {
                                BlockUtil.Method2162822(vec3d.x, vec3d.y, vec3d.z);
                            }
                            if (this.Field1814.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Oyvey) {
                                AliceMain.Field760.Method2150281(vec3d);
                            }
                            if (this.Field1814.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Test) {
                                arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                            }
                            if (this.Field1814.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Silent) {
                                arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                SilentRotaionUtil.Method2162907(arrf[0], arrf[1]);
                            }
                            if (this.Field1814.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Silent2) {
                                arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                SilentRotaionUtil.Method2162012(arrf[0], arrf[1]);
                            }
                            if (this.Field1814.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Client) {
                                arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                SilentRotaionUtil.Method2162907(arrf[0], arrf[1]);
                                PistonPush.Field2811.player.rotationYaw = arrf[0];
                                PistonPush.Field2811.player.rotationPitch = arrf[1];
                            }
                        }
                        this.Field1829 = () -> this.Method2161284(bl2, n2, bl3, bl4, vec3d);
                        return;
                    }
                    break block52;
                }
                case 2: {
                    if (this.Field1821 != null && PistonPush.Field2811.world.getBlockState(this.Field1821).getBlock() == Blocks.AIR) {
                        this.Field1821 = null;
                    }
                    if (this.Field1821 != null) {
                        if (this.Field1822.Method2164755(1000L)) {
                            RayTraceResult rayTraceResult = PistonPush.Field2811.world.rayTraceBlocks(new Vec3d(PistonPush.Field2811.player.posX, PistonPush.Field2811.player.posY + (double) PistonPush.Field2811.player.getEyeHeight(), PistonPush.Field2811.player.posZ), new Vec3d((double) this.Field1821.getX() + 0.5, (double) this.Field1821.getY() + 0.5, (double) this.Field1821.getZ() + 0.5));
                            EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
                            Vec3d vec3d = new Vec3d((Vec3i) this.Field1821).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                            if (bl) {
                                float[] arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                            } else {
                                AliceMain.Field760.Method2150281(vec3d);
                            }
                            this.Field1829 = () -> this.Method2161283(enumFacing);
                        }
                        return;
                    }
                    if (!this.Method2161257()) {
                        int n3 = CrystalUtilSC.Method2162806();
                        if (n3 == -1) {
                            Command.Method2159696("No crystals found!");
                            this.Method2150391();
                            return;
                        }
                        if (PistonPush.Field2811.player.inventory.currentItem != n3) {
                            PistonPush.Field2811.player.inventory.currentItem = n3;
                            PistonPush.Field2811.playerController.updateController();
                        }
                    }
                    if (this.Field1818 == null) {
                        this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
                        return;
                    }
                    if (bl) {
                        float[] arrf = SilentRotaionUtil.Method2162011(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) this.Field1818.getX() + 0.5, (double) this.Field1818.getY() + 0.5, (double) this.Field1818.getZ() + 0.5));
                        SilentRotaionUtil.Method2162012(arrf[0], arrf[1]);
                    } else {
                        SilentRotaionUtil.Method2162904(new Vec3d((double) this.Field1818.getX() + 0.5, (double) this.Field1818.getY() + 0.5, (double) this.Field1818.getZ() + 0.5));
                    }
                    this.Field1829 = this::Method2161282;
                    return;
                }
                case 3: {
                    if (this.Field1816 == null) {
                        this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
                        return;
                    }
                    int n4 = this.Method2161269();
                    if (n4 == -1) {
                        Command.Method2159696("No redstone found!");
                        this.Method2150391();
                        return;
                    }
                    Optional<BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> optional = BlockUtilSC.Method2162887(this.Field1816.offset(this.Field1817, 3), false, ((ItemBlock) PistonPush.Field2811.player.inventory.getStackInSlot(this.Method2161269()).getItem()).getBlock() == Blocks.REDSTONE_TORCH);
                    if (!optional.isPresent() && ((ItemBlock) PistonPush.Field2811.player.inventory.getStackInSlot(this.Method2161269()).getItem()).getBlock() == Blocks.REDSTONE_TORCH) {
                        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                            if (!enumFacing.equals((Object) this.Field1817) && !enumFacing.equals((Object) this.Field1817.getOpposite()) && (optional = BlockUtilSC.Method2162887(this.Field1816.offset(this.Field1817, 2).offset(enumFacing), false, ((ItemBlock) PistonPush.Field2811.player.inventory.getStackInSlot(this.Method2161269()).getItem()).getBlock() == Blocks.REDSTONE_TORCH)).isPresent())
                                break;
                        }
                    }
                    if (optional.isPresent()) {
                        Object object;
                        EnumFacing enumFacing;
                        boolean bl5 = PistonPush.Field2811.player.inventory.currentItem != n4;
                        int n5 = PistonPush.Field2811.player.isSprinting();
                        int n6 = BlockUtilSC.Method2162891(optional.get().Field2369) ? 1 : 0;
                        enumFacing = new Vec3d((Vec3i) optional.get().Field2369).add(0.5, 0.5, 0.5).add(new Vec3d(optional.get().Field2370.getDirectionVec()).scale(0.5));
                        if (bl) {
                            object = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), (Vec3d) enumFacing);
                            RotationUtilSC.Method2162902((float) object[0], (float) object[1]);
                        } else {
                            AliceMain.Field760.Method2150281((Vec3d) enumFacing);
                        }
                        object = optional;
                        this.Field1829 = () -> this.Method2161281(bl5, n4, n5 != 0, n6 != 0, (Optional) object, (Vec3d) enumFacing);
                        return;
                    }
                    this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAKING;
                    return;
                }
                case 4: {
                    Entity entity = PistonPush.Field2811.world.loadedEntityList.stream().filter(PistonPush::Method2161270).filter(this::Method2161279).min(Comparator.comparing(PistonPush::Method2161278)).orElse(null);
                    if (entity != null) {
                        if (this.Field1811.getValue().booleanValue() && PistonPush.Field2811.player.getHealth() < 7.0f) {
                            return;
                        }
                        this.Field1825.Method2164750();
                        this.Field1828.Method2164750();
                        this.Field1827 = this.Field1806.getValue() * 10;
                        if (bl) {
                            float[] arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionVector());
                            RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                        } else {
                            AliceMain.Field760.Method2150281(entity.getPositionVector());
                        }
                        this.Field1829 = () -> this.Method2161277(entity);
                        break;
                    }
                    if (bl) {
                        float[] arrf = RotationManager.Method2150291(PistonPush.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) this.Field1816.getX() + 0.5, (double) this.Field1816.getY(), (double) this.Field1816.getZ() + 0.5));
                        RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                        break;
                    }
                    AliceMain.Field760.Method2150292((double) this.Field1816.getX() + 0.5, this.Field1816.getY(), (double) this.Field1816.getZ() + 0.5);
                }
            }
                break block52;
            }
            this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
            int n7 = PistonPush.Method2161268();
            if (n7 == -1) {
                Command.Method2159696("No pistons found!");
                this.Method2150391();
                return;
            }
            int n8 = this.Method2161269();
            if (n8 == -1) {
                Command.Method2159696("No redstone found!");
                this.Method2150391();
                return;
            }
            List<EntityPlayer> list = this.Method2161267();
            block8:
            for (EntityPlayer entityPlayer : list) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                Object object;
                if (this.Field1801.getValue().booleanValue() && !BlockUtilSC.Method2162896(new BlockPos((Entity) entityPlayer)) && PistonPush.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.AIR)
                    continue;
                BlockPos blockPos = new BlockPos((Entity) entityPlayer).up();
                if (this.Field1811.getValue().booleanValue() && blockPos.equals((Object) new BlockPos((Entity) PistonPush.Field2811.player)))
                    continue;
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    if (!(PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockPistonBase) && (this.Field1832.Method2164755(CrystalUtilSC.Method2162805() + 150) || !blockPos.offset(enumFacing).equals((Object) this.Field1831)) || PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockPistonBase && !(object = (EnumFacing) PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getValue((IProperty) BlockDirectional.FACING)).equals((Object) enumFacing.getOpposite()))
                        continue;
                    if (PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.REDSTONE_BLOCK || PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.REDSTONE_TORCH || !InteractionUtil.Method2163757(blockPos.offset(enumFacing, 2), this.Field1810.getValue()) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163752(blockPos.offset(enumFacing, 2), true, bl, this.Field1810.getValue())) == null)
                        break block8;
                    this.Field1829 = () -> this.Method2161276(n8, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
                    return;
                }
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    if (!InteractionUtil.Method2163757(blockPos.offset(enumFacing), this.Field1810.getValue()))
                        continue;
                    if (this.Field1810.getValue().booleanValue()) {
                        if (!InteractionUtil.Method2163757(blockPos.offset(enumFacing, 2), true)) continue;
                    } else if (PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() != Blocks.AIR)
                        continue;
                    object = SilentRotaionUtil.Method2162011(PistonPush.Field2811.player.getPositionEyes(1.0f), new Vec3d((double) blockPos.offset(enumFacing).getX() + 0.5, (double) blockPos.offset(enumFacing).getY() + 1.0, (double) blockPos.offset(enumFacing).getZ() + 0.5));
                    EnumFacing enumFacing2 = EnumFacing.fromAngle((double) ((double) object[0]));
                    if (Math.abs((float) object[1]) > 55.0f || enumFacing2 != enumFacing || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163752(blockPos.offset(enumFacing), true, bl, this.Field1810.getValue())) == null)
                        continue;
                    this.Field1829 = () -> this.Method2161275(n7, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, blockPos, enumFacing);
                    return;
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161254(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            if (this.Field1830 < this.Field1808.getValue()) {
                ++this.Field1830;
            }
            if (updateWalkingPlayerEvent.isCanceled() || !InteractionUtil.Method2163748()) {
                return;
            }
            if (this.Field1815 == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAKING) {
                SilentRotaionUtil.Method2162906((float) this.Field1816.getX() + 0.5f, this.Field1816.getY(), (float) this.Field1816.getZ() + 0.5f);
            }
            if (this.Field1830 < this.Field1808.getValue()) {
                return;
            }
            this.Method2161253(false);
        }
    }

    @SubscribeEvent
    public void Method2161255(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (this.Field1829 != null) {
            this.Field1833.Method2164750();
            this.Field1830 = 0;
            this.Field1829.run();
            this.Field1829 = null;
            for (int j = 0; j < this.Field1807.getValue() - 1; ++j) {
                this.Method2161253(true);
                if (this.Field1829 == null) {
                    return;
                }
                this.Field1829.run();
                this.Field1829 = null;
            }
        }
        this.Field1829 = null;
    }

    @SubscribeEvent
    public void Method2161256(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect) {
            SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (this.Field1818 == null) {
                return;
            }
            if (sPacketSoundEffect.getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE && this.Field1818.up().getDistance((int) sPacketSoundEffect.getX(), (int) sPacketSoundEffect.getY(), (int) sPacketSoundEffect.getZ()) <= 2.0) {
                this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
                this.Field1827 = 0;
            }
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketBlockChange && this.Field1821 != null && ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockPosition().equals((Object) this.Field1821) && ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockState().getBlock() instanceof BlockAir) {
            this.Field1821 = null;
        }
    }

    public boolean Method2161257() {
        return PistonPush.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    private boolean Method2161258(EntityPlayer entityPlayer) {
        if (this.Method2161269() == -1) {
            Command.Method2159696("No redstone found!");
            this.Method2150391();
            return false;
        }
        BlockPos blockPos = new BlockPos((Entity) entityPlayer).up();
        if (this.Method2161264(blockPos)) {
            return true;
        }
        blockPos = new BlockPos((Entity) entityPlayer).up().up();
        return this.Method2161264(blockPos);
    }

    public void Method2161259(Entity entity) {
        if (this.Field1813.getValue().booleanValue() && PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.AIR)) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161260()));
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161261(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161261(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161261(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161261(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
        }
    }

    public void Method2161250(Entity entity) {
        if (this.Field1813.getValue().booleanValue() && PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.AIR)) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161260()));
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161262(entity);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161262(entity);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161262(entity);
                return;
            }
            if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161262(entity);
                return;
            }
            if (this.Method2161261(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161259(entity);
                return;
            }
            if (this.Method2161261(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161259(entity);
                return;
            }
            if (this.Method2161261(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161259(entity);
                return;
            }
            if (this.Method2161261(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161259(entity);
                return;
            }
        }
    }

    public boolean Method2161261(BlockPos blockPos) {
        return PistonPush.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()) > 2.0;
    }

    public void Method2161262(Entity entity) {
        InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
        PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161260()));
        if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
        if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
        if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
        if (PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonPush.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
    }

    public boolean Method2161264(BlockPos blockPos) {
        if (!this.Method2161266(blockPos) && !this.Field1812.getValue().booleanValue()) {
            return false;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            Optional<BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> optional;
            this.Field1821 = null;
            this.Field1823 = false;
            if (!PistonPush.Method2161263(blockPos.offset(enumFacing).down())) continue;
            if (this.Method2161269() == -1) {
                return false;
            }
            ItemStack itemStack = PistonPush.Field2811.player.inventory.getStackInSlot(this.Method2161269());
            Block block = ((ItemBlock) itemStack.getItem()).getBlock();
            if (block == Blocks.REDSTONE_BLOCK) {
                if (!this.Method2161266(blockPos.offset(enumFacing, 3))) {
                    if (!this.Field1812.getValue().booleanValue() || PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() != Blocks.REDSTONE_TORCH && PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() != Blocks.REDSTONE_BLOCK)
                        continue;
                    this.Field1821 = blockPos.offset(enumFacing, 3);
                }
            } else {
                optional = BlockUtilSC.Method2162887(blockPos.offset(enumFacing, 3), false, true);
                if (!optional.isPresent() && this.Field1812.getValue().booleanValue() && (PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() == Blocks.REDSTONE_TORCH || PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() == Blocks.REDSTONE_BLOCK)) {
                    this.Field1821 = blockPos.offset(enumFacing, 3);
                }
                if (!optional.isPresent() && this.Field1821 == null && ((ItemBlock) PistonPush.Field2811.player.inventory.getStackInSlot(this.Method2161269()).getItem()).getBlock() == Blocks.REDSTONE_TORCH) {
                    for (Object object : EnumFacing.HORIZONTALS) {
                        if (object.equals((Object) enumFacing) || object.equals((Object) enumFacing.getOpposite()))
                            continue;
                        optional = BlockUtilSC.Method2162887(blockPos.offset(enumFacing, 2).offset(object), false, true);
                        if (optional.isPresent()) break;
                        if (!this.Field1812.getValue().booleanValue() || PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2).offset(object)).getBlock() != Blocks.REDSTONE_TORCH)
                            continue;
                        this.Field1821 = blockPos.offset(enumFacing, 2).offset(object);
                        break;
                    }
                }
                if (!optional.isPresent() && this.Field1821 == null) continue;
            }
            optional = BlockUtilSC.Method2162885(blockPos.offset(enumFacing, 2));
            this.Field1823 = this.Field1812.getValue() != false && PistonPush.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() instanceof BlockPistonBase;
            boolean bl = this.Field1823;
            if (!optional.isPresent() && !this.Field1823) continue;
            if (!this.Field1823) {
                Object object;
                BlockPos blockPos2 = optional.get().Field2369;
                EnumFacing enumFacing2 = optional.get().Field2370;
                object = BlockUtilSC.Method2162880(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), enumFacing2, (EntityPlayer) PistonPush.Field2811.player);
                EnumFacing enumFacing3 = EnumFacing.fromAngle((double) object[0]);
                if (Math.abs((double) object[1]) > 55.0 || enumFacing3 != enumFacing || this.Field1810.getValue().booleanValue() && !this.Method2161265(optional.get().Field2369))
                    continue;
                this.Field1819 = blockPos2;
                this.Field1820 = enumFacing2;
            }
            this.Field1816 = blockPos;
            this.Field1817 = enumFacing;
            this.Field1818 = blockPos.offset(enumFacing).down();
            return true;
        }
        return false;
    }

    private boolean Method2161265(BlockPos blockPos) {
        for (double d = 0.1; d < 0.9; d += 0.1) {
            for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                    Vec3d vec3d = new Vec3d(PistonPush.Field2811.player.posX, PistonPush.Field2811.player.getEntityBoundingBox().minY + (double) PistonPush.Field2811.player.getEyeHeight(), PistonPush.Field2811.player.posZ);
                    Vec3d vec3d2 = new Vec3d((Vec3i) blockPos).add(d, d2, d3);
                    double d4 = vec3d.distanceTo(vec3d2);
                    double d5 = vec3d2.x - vec3d.x;
                    double d6 = vec3d2.y - vec3d.y;
                    double d7 = vec3d2.z - vec3d.z;
                    double d8 = MathHelper.sqrt((double) (d5 * d5 + d7 * d7));
                    double[] arrd = new double[]{MathHelper.wrapDegrees((float) ((float) Math.toDegrees(Math.atan2(d7, d5)) - 90.0f)), MathHelper.wrapDegrees((float) ((float) (-Math.toDegrees(Math.atan2(d6, d8)))))};
                    float f = MathHelper.cos((float) ((float) (-arrd[0] * 0.01745329238474369 - 3.1415927410125732)));
                    float f2 = MathHelper.sin((float) ((float) (-arrd[0] * 0.01745329238474369 - 3.1415927410125732)));
                    float f3 = -MathHelper.cos((float) ((float) (-arrd[1] * 0.01745329238474369)));
                    float f4 = MathHelper.sin((float) ((float) (-arrd[1] * 0.01745329238474369)));
                    Vec3d vec3d3 = new Vec3d((double) (f2 * f3), (double) f4, (double) (f * f3));
                    Vec3d vec3d4 = vec3d.add(vec3d3.x * d4, vec3d3.y * d4, vec3d3.z * d4);
                    RayTraceResult rayTraceResult = PistonPush.Field2811.world.rayTraceBlocks(vec3d, vec3d4, false, false, false);
                    if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                        continue;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Method2161266(BlockPos blockPos) {
        return PistonPush.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockAir;
    }

    private List<EntityPlayer> Method2161267() {
        return PistonPush.Field2811.world.playerEntities.stream().filter(PistonPush::Method2161274).filter(PistonPush::Method2161273).filter(this::Method2161272).sorted(Comparator.comparing(PistonPush::Method2161271)).collect(Collectors.toList());
    }

    private int Method2161269() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PistonPush.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || (block = ((ItemBlock) itemStack.getItem()).getBlock()) != Blocks.REDSTONE_BLOCK && block != Blocks.REDSTONE_TORCH)
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private int Method2161260() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PistonPush.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private boolean Method2161272(EntityPlayer entityPlayer) {
        return PistonPush.Field2811.player.getDistance((Entity) entityPlayer) < (float) this.Field1805.getValue().intValue();
    }

    private void Method2161275(int n2, InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, BlockPos blockPos, EnumFacing enumFacing) {
        boolean bl = PistonPush.Field2811.player.inventory.currentItem != n2;
        int n3 = PistonPush.Field2811.player.inventory.currentItem;
        if (bl) {
            PistonPush.Field2811.player.inventory.currentItem = n2;
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        InteractionUtil.Method2163754(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        this.Field1831 = blockPos.offset(enumFacing);
        this.Field1832.Method2164750();
        if (bl) {
            PistonPush.Field2811.player.inventory.currentItem = n3;
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
    }

    private void Method2161276(int n2, InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        boolean bl = PistonPush.Field2811.player.inventory.currentItem != n2;
        int n3 = PistonPush.Field2811.player.inventory.currentItem;
        if (bl) {
            PistonPush.Field2811.player.inventory.currentItem = n2;
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        InteractionUtil.Method2163754(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        this.Field1825.Method2164750();
        this.Field1827 = CrystalUtilSC.Method2162805() + 150;
        if (bl) {
            PistonPush.Field2811.player.inventory.currentItem = n3;
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
        if (this.Field1802.getValue().booleanValue()) {
            this.Method2150391();
        }
    }

    private void Method2161277(Entity entity) {
        PistonPush.Field2811.playerController.attackEntity((EntityPlayer) PistonPush.Field2811.player, entity);
        PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161257() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
    }

    private boolean Method2161279(Entity entity) {
        return PistonPush.Field2811.player.getDistance(entity) <= (float) (this.Field1805.getValue() + 4);
    }

    private void Method2161281(boolean bl, int n2, boolean bl2, boolean bl3, Optional optional, Vec3d vec3d) {
        this.Field1825.Method2164750();
        this.Field1828.Method2164750();
        this.Field1827 = this.Field1806.getValue() * 10;
        if (bl) {
            PistonPush.Field2811.player.inventory.currentItem = n2;
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl2) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        }
        PistonPush.Field2811.playerController.processRightClickBlock(PistonPush.Field2811.player, PistonPush.Field2811.world, ((BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) optional.get()).Field2369, ((BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) optional.get()).Field2370, vec3d, EnumHand.MAIN_HAND);
        PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        if (bl3) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
        }
        this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAKING;
    }

    private void Method2161282() {
        this.Field1828.Method2164750();
        RayTraceResult rayTraceResult = PistonPush.Field2811.world.rayTraceBlocks(new Vec3d(PistonPush.Field2811.player.posX, PistonPush.Field2811.player.posY + (double) PistonPush.Field2811.player.getEyeHeight(), PistonPush.Field2811.player.posZ), new Vec3d((double) this.Field1818.getX() + 0.5, (double) this.Field1818.getY() - 0.5, (double) this.Field1818.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        BlockUtilSC.Method2162870(this.Field1818, PistonPush.Field2811.player.getPositionVector().add(0.0, (double) PistonPush.Field2811.player.getEyeHeight(), 0.0), this.Method2161257() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
        this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.REDSTONE;
        this.Field1822.Method2164750();
    }

    private void Method2161283(EnumFacing enumFacing) {
        PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field1821, enumFacing));
        PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.Field1821, enumFacing));
        this.Field1822.Method2164750();
    }

    private void Method2161284(boolean bl, int n2, boolean bl2, boolean bl3, Vec3d vec3d) {
        this.Field1828.Method2164750();
        if (bl) {
            PistonPush.Field2811.player.inventory.currentItem = n2;
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl2) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        }
        PistonPush.Field2811.playerController.processRightClickBlock(PistonPush.Field2811.player, PistonPush.Field2811.world, this.Field1819, this.Field1820, vec3d, EnumHand.MAIN_HAND);
        PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        if (bl3) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            PistonPush.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonPush.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
        }
        this.Field1815 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CRYSTAL;
    }

    private boolean Method2161285(Boolean bl) {
        return this.Field1800.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE;
    }

    private boolean Method2161286(Boolean bl) {
        return this.Field1800.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PUSH;
    }

    private boolean Method2161287(Boolean bl) {
        return this.Field1800.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PUSH;
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        DAMAGE,
        PUSH;

    }

    private static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        Packet,
        Normal,
        Sequential;

    }

    private static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        SEARCHING,
        CRYSTAL,
        REDSTONE,
        BREAKING,
        EXPLOSION;

    }

    private static enum IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
        New,
        Test,
        Silent,
        Silent2,
        Client,
        Oyvey;

    }
}

