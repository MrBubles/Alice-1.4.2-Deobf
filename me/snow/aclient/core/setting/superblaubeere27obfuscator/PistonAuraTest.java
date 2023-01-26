

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

public class PistonAuraTest
        extends Module {
    private static PistonAuraTest Field2380 = new PistonAuraTest();
    public BlockPos Field2392;
    public EnumFacing Field2393;
    public BlockPos Field2394;
    public BlockPos Field2395;
    public EnumFacing Field2396;
    boolean Field2410 = false;
    boolean Field2411 = false;
    private Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2376 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE));
    private Setting<Boolean> Field2377 = this.Method2150366(new Setting<Boolean>("Smart", Boolean.TRUE, this::Method2161503));
    private Setting<Boolean> Field2378 = this.Method2150366(new Setting<Boolean>("DisablePush", Boolean.TRUE, this::Method2161502));
    private Setting<Boolean> Field2379 = this.Method2150366(new Setting<Boolean>("DisableNone", Boolean.FALSE, this::Method2161501));
    private Setting<Integer> Field2381 = this.Method2150366(new Setting<Integer>("TargetRange", 3, 1, 6));
    private Setting<Integer> Field2382 = this.Method2150366(new Setting<Integer>("Delay", 25, 0, 100));
    private Setting<Integer> Field2383 = this.Method2150366(new Setting<Integer>("ActionShift", 3, 1, 8));
    private Setting<Integer> Field2384 = this.Method2150366(new Setting<Integer>("ActionInterval", 0, 0, 10));
    private Setting<Boolean> Field2385 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private Setting<Boolean> Field2386 = this.Method2150366(new Setting<Boolean>("RayTrace", false));
    private Setting<Boolean> Field2387 = this.Method2150366(new Setting<Boolean>("AntiSuicide", false));
    private Setting<Boolean> Field2388 = this.Method2150366(new Setting<Boolean>("Mine", false));
    private Setting<Boolean> Field2389 = this.Method2150366(new Setting<Boolean>("AutoTrap", false));
    private Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll> Field2390 = this.Method2150366(new Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll>("RotateMode", IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Test));
    private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
    private BlockPos Field2397;
    private Timer Field2398 = new Timer();
    private boolean Field2399;
    private boolean Field2400 = false;
    private Timer Field2401 = new Timer();
    private Timer Field2402 = new Timer();
    private int Field2403;
    private Timer Field2404 = new Timer();
    private Runnable Field2405 = null;
    private int Field2406 = 0;
    private BlockPos Field2407 = null;
    private Timer Field2408 = new Timer();
    private Timer Field2409 = new Timer();

    public PistonAuraTest() {
        super("PistonAura", "Good PistonAura", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        this.Method2161568();
    }

    public static PistonAuraTest Method2161567() {
        if (Field2380 == null) {
            Field2380 = new PistonAuraTest();
        }
        return Field2380;
    }

    public static boolean Method2161579(BlockPos blockPos) {
        if (PistonAuraTest.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && PistonAuraTest.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (PistonAuraTest.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR && PistonAuraTest.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.PISTON_HEAD) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (PistonAuraTest.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
            return false;
        }
        return PistonAuraTest.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).isEmpty();
    }

    public static int Method2161584() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PistonAuraTest.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockPistonBase))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private static Float Method2161587(EntityPlayer entityPlayer) {
        return Float.valueOf(PistonAuraTest.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161589(EntityPlayer entityPlayer) {
        return entityPlayer != PistonAuraTest.Field2811.player;
    }

    private static boolean Method2161580(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static Float Method2161594(Entity entity) {
        return Float.valueOf(PistonAuraTest.Field2811.player.getDistance(entity));
    }

    private static boolean Method2161596(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    private void Method2161568() {
        Field2380 = this;
    }

    @Override
    public void Method2150372() {
        if (PistonAuraTest.Field2811.player == null || PistonAuraTest.Field2811.world == null) {
            return;
        }
        this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
        this.Field2392 = null;
        this.Field2393 = null;
        this.Field2394 = null;
        this.Field2395 = null;
        this.Field2396 = null;
        this.Field2403 = 0;
        this.Field2406 = 0;
        this.Field2405 = null;
        this.Field2397 = null;
        this.Field2399 = false;
        this.Field2407 = null;
    }

    private void Method2161569(boolean bl) {
        block52:
        {
            block51:
            {
                if (this.Field2409.Method2164755(1000L) && this.Field2379.getValue().booleanValue()) {
                    this.Method2150391();
                }
                if (!this.Field2401.Method2164755(this.Field2403)) {
                    return;
                }
                if (this.Field2385.getValue().booleanValue() && Math.sqrt(PistonAuraTest.Field2811.player.motionX * PistonAuraTest.Field2811.player.motionX + PistonAuraTest.Field2811.player.motionZ * PistonAuraTest.Field2811.player.motionZ) > 9.0E-4) {
                    return;
                }
                if (this.Field2376.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE)
                    break block51;
                switch (1.F ield2334[this.Field2391.ordinal()]){
                case 1: {
                    List<EntityPlayer> list = this.Method2161583();
                    for (EntityPlayer entityPlayer : list) {
                        if (!this.Method2161574(entityPlayer)) continue;
                        if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY + 2.0, entityPlayer.posZ)).getBlock().equals((Object) Blocks.AIR) && this.Field2389.getValue().booleanValue()) {
                            this.Method2161576((Entity) entityPlayer);
                            return;
                        }
                        int n2 = PistonAuraTest.Method2161584();
                        if (n2 == -1) {
                            Command.Method2159696("No pistons found!");
                            this.Method2150391();
                            return;
                        }
                        if (this.Field2399) {
                            this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CRYSTAL;
                            this.Field2399 = false;
                            return;
                        }
                        boolean bl2 = PistonAuraTest.Field2811.player.inventory.currentItem != n2;
                        boolean bl3 = PistonAuraTest.Field2811.player.isSprinting();
                        boolean bl4 = BlockUtilSC.Method2162891(this.Field2395);
                        Vec3d vec3d = new Vec3d((Vec3i) this.Field2395).add(0.5, 0.5, 0.5).add(new Vec3d(this.Field2396.getDirectionVec()).scale(0.5));
                        if (bl) {
                            float[] arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                            RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                        } else {
                            float[] arrf;
                            if (this.Field2390.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.New) {
                                BlockUtil.Method2162822(vec3d.x, vec3d.y, vec3d.z);
                            }
                            if (this.Field2390.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Oyvey) {
                                AliceMain.Field760.Method2150281(vec3d);
                            }
                            if (this.Field2390.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Test) {
                                arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                            }
                            if (this.Field2390.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Silent) {
                                arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                SilentRotaionUtil.Method2162907(arrf[0], arrf[1]);
                            }
                            if (this.Field2390.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Silent2) {
                                arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                SilentRotaionUtil.Method2162012(arrf[0], arrf[1]);
                            }
                            if (this.Field2390.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Client) {
                                arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                SilentRotaionUtil.Method2162907(arrf[0], arrf[1]);
                                PistonAuraTest.Field2811.player.rotationYaw = arrf[0];
                                PistonAuraTest.Field2811.player.rotationPitch = arrf[1];
                            }
                        }
                        this.Field2405 = () -> this.Method2161590(bl2, n2, bl3, bl4, vec3d);
                        return;
                    }
                    break block52;
                }
                case 2: {
                    if (this.Field2397 != null && PistonAuraTest.Field2811.world.getBlockState(this.Field2397).getBlock() == Blocks.AIR) {
                        this.Field2397 = null;
                    }
                    if (this.Field2397 != null) {
                        if (this.Field2398.Method2164755(1000L)) {
                            RayTraceResult rayTraceResult = PistonAuraTest.Field2811.world.rayTraceBlocks(new Vec3d(PistonAuraTest.Field2811.player.posX, PistonAuraTest.Field2811.player.posY + (double) PistonAuraTest.Field2811.player.getEyeHeight(), PistonAuraTest.Field2811.player.posZ), new Vec3d((double) this.Field2397.getX() + 0.5, (double) this.Field2397.getY() + 0.5, (double) this.Field2397.getZ() + 0.5));
                            EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
                            Vec3d vec3d = new Vec3d((Vec3i) this.Field2397).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                            if (bl) {
                                float[] arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), vec3d);
                                RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                            } else {
                                AliceMain.Field760.Method2150281(vec3d);
                            }
                            this.Field2405 = () -> this.Method2161599(enumFacing);
                        }
                        return;
                    }
                    if (!this.Method2161573()) {
                        int n3 = CrystalUtilSC.Method2162806();
                        if (n3 == -1) {
                            Command.Method2159696("No crystals found!");
                            this.Method2150391();
                            return;
                        }
                        if (PistonAuraTest.Field2811.player.inventory.currentItem != n3) {
                            PistonAuraTest.Field2811.player.inventory.currentItem = n3;
                            PistonAuraTest.Field2811.playerController.updateController();
                        }
                    }
                    if (this.Field2394 == null) {
                        this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
                        return;
                    }
                    if (bl) {
                        float[] arrf = SilentRotaionUtil.Method2162011(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) this.Field2394.getX() + 0.5, (double) this.Field2394.getY() + 0.5, (double) this.Field2394.getZ() + 0.5));
                        SilentRotaionUtil.Method2162012(arrf[0], arrf[1]);
                    } else {
                        SilentRotaionUtil.Method2162904(new Vec3d((double) this.Field2394.getX() + 0.5, (double) this.Field2394.getY() + 0.5, (double) this.Field2394.getZ() + 0.5));
                    }
                    this.Field2405 = this::Method2161598;
                    return;
                }
                case 3: {
                    if (this.Field2392 == null) {
                        this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
                        return;
                    }
                    int n4 = this.Method2161585();
                    if (n4 == -1) {
                        Command.Method2159696("No redstone found!");
                        this.Method2150391();
                        return;
                    }
                    Optional<BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> optional = BlockUtilSC.Method2162887(this.Field2392.offset(this.Field2393, 3), false, ((ItemBlock) PistonAuraTest.Field2811.player.inventory.getStackInSlot(this.Method2161585()).getItem()).getBlock() == Blocks.REDSTONE_TORCH);
                    if (!optional.isPresent() && ((ItemBlock) PistonAuraTest.Field2811.player.inventory.getStackInSlot(this.Method2161585()).getItem()).getBlock() == Blocks.REDSTONE_TORCH) {
                        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                            if (!enumFacing.equals((Object) this.Field2393) && !enumFacing.equals((Object) this.Field2393.getOpposite()) && (optional = BlockUtilSC.Method2162887(this.Field2392.offset(this.Field2393, 2).offset(enumFacing), false, ((ItemBlock) PistonAuraTest.Field2811.player.inventory.getStackInSlot(this.Method2161585()).getItem()).getBlock() == Blocks.REDSTONE_TORCH)).isPresent())
                                break;
                        }
                    }
                    if (optional.isPresent()) {
                        Object object;
                        EnumFacing enumFacing;
                        boolean bl5 = PistonAuraTest.Field2811.player.inventory.currentItem != n4;
                        int n5 = PistonAuraTest.Field2811.player.isSprinting();
                        int n6 = BlockUtilSC.Method2162891(optional.get().Field2369) ? 1 : 0;
                        enumFacing = new Vec3d((Vec3i) optional.get().Field2369).add(0.5, 0.5, 0.5).add(new Vec3d(optional.get().Field2370.getDirectionVec()).scale(0.5));
                        if (bl) {
                            object = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), (Vec3d) enumFacing);
                            RotationUtilSC.Method2162902((float) object[0], (float) object[1]);
                        } else {
                            AliceMain.Field760.Method2150281((Vec3d) enumFacing);
                        }
                        object = optional;
                        this.Field2405 = () -> this.Method2161597(bl5, n4, n5 != 0, n6 != 0, (Optional) object, (Vec3d) enumFacing);
                        return;
                    }
                    this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAKING;
                    return;
                }
                case 4: {
                    Entity entity = PistonAuraTest.Field2811.world.loadedEntityList.stream().filter(PistonAuraTest::Method2161596).filter(this::Method2161595).min(Comparator.comparing(PistonAuraTest::Method2161594)).orElse(null);
                    if (entity != null) {
                        if (this.Field2387.getValue().booleanValue() && PistonAuraTest.Field2811.player.getHealth() < 7.0f) {
                            return;
                        }
                        this.Field2401.Method2164750();
                        this.Field2404.Method2164750();
                        this.Field2403 = this.Field2382.getValue() * 10;
                        if (bl) {
                            float[] arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionVector());
                            RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                        } else {
                            AliceMain.Field760.Method2150281(entity.getPositionVector());
                        }
                        this.Field2405 = () -> this.Method2161593(entity);
                        break;
                    }
                    if (bl) {
                        float[] arrf = RotationManager.Method2150291(PistonAuraTest.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) this.Field2392.getX() + 0.5, (double) this.Field2392.getY(), (double) this.Field2392.getZ() + 0.5));
                        RotationUtilSC.Method2162902(arrf[0], arrf[1]);
                        break;
                    }
                    AliceMain.Field760.Method2150292((double) this.Field2392.getX() + 0.5, this.Field2392.getY(), (double) this.Field2392.getZ() + 0.5);
                }
            }
                break block52;
            }
            this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
            int n7 = PistonAuraTest.Method2161584();
            if (n7 == -1) {
                Command.Method2159696("No pistons found!");
                this.Method2150391();
                return;
            }
            int n8 = this.Method2161585();
            if (n8 == -1) {
                Command.Method2159696("No redstone found!");
                this.Method2150391();
                return;
            }
            List<EntityPlayer> list = this.Method2161583();
            block8:
            for (EntityPlayer entityPlayer : list) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                Object object;
                if (this.Field2377.getValue().booleanValue() && !BlockUtilSC.Method2162896(new BlockPos((Entity) entityPlayer)) && PistonAuraTest.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.AIR)
                    continue;
                BlockPos blockPos = new BlockPos((Entity) entityPlayer).up();
                if (this.Field2387.getValue().booleanValue() && blockPos.equals((Object) new BlockPos((Entity) PistonAuraTest.Field2811.player)))
                    continue;
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    if (!(PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockPistonBase) && (this.Field2408.Method2164755(CrystalUtilSC.Method2162805() + 150) || !blockPos.offset(enumFacing).equals((Object) this.Field2407)) || PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockPistonBase && !(object = (EnumFacing) PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing)).getValue((IProperty) BlockDirectional.FACING)).equals((Object) enumFacing.getOpposite()))
                        continue;
                    if (PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.REDSTONE_BLOCK || PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.REDSTONE_TORCH || !InteractionUtil.Method2163757(blockPos.offset(enumFacing, 2), this.Field2386.getValue()) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163752(blockPos.offset(enumFacing, 2), true, bl, this.Field2386.getValue())) == null)
                        break block8;
                    this.Field2405 = () -> this.Method2161592(n8, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
                    return;
                }
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    if (!InteractionUtil.Method2163757(blockPos.offset(enumFacing), this.Field2386.getValue()))
                        continue;
                    if (this.Field2386.getValue().booleanValue()) {
                        if (!InteractionUtil.Method2163757(blockPos.offset(enumFacing, 2), true)) continue;
                    } else if (PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() != Blocks.AIR)
                        continue;
                    object = SilentRotaionUtil.Method2162011(PistonAuraTest.Field2811.player.getPositionEyes(1.0f), new Vec3d((double) blockPos.offset(enumFacing).getX() + 0.5, (double) blockPos.offset(enumFacing).getY() + 1.0, (double) blockPos.offset(enumFacing).getZ() + 0.5));
                    EnumFacing enumFacing2 = EnumFacing.fromAngle((double) ((double) object[0]));
                    if (Math.abs((float) object[1]) > 55.0f || enumFacing2 != enumFacing || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163752(blockPos.offset(enumFacing), true, bl, this.Field2386.getValue())) == null)
                        continue;
                    this.Field2405 = () -> this.Method2161591(n7, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, blockPos, enumFacing);
                    return;
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161560(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            if (this.Field2406 < this.Field2384.getValue()) {
                ++this.Field2406;
            }
            if (updateWalkingPlayerEvent.isCanceled() || !InteractionUtil.Method2163748()) {
                return;
            }
            if (this.Field2391 == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAKING) {
                SilentRotaionUtil.Method2162906((float) this.Field2392.getX() + 0.5f, this.Field2392.getY(), (float) this.Field2392.getZ() + 0.5f);
            }
            if (this.Field2406 < this.Field2384.getValue()) {
                return;
            }
            this.Method2161569(false);
        }
    }

    @SubscribeEvent
    public void Method2161571(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (this.Field2405 != null) {
            this.Field2409.Method2164750();
            this.Field2406 = 0;
            this.Field2405.run();
            this.Field2405 = null;
            for (int j = 0; j < this.Field2383.getValue() - 1; ++j) {
                this.Method2161569(true);
                if (this.Field2405 == null) {
                    return;
                }
                this.Field2405.run();
                this.Field2405 = null;
            }
        }
        this.Field2405 = null;
    }

    @SubscribeEvent
    public void Method2161572(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect) {
            SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (this.Field2394 == null) {
                return;
            }
            if (sPacketSoundEffect.getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE && this.Field2394.up().getDistance((int) sPacketSoundEffect.getX(), (int) sPacketSoundEffect.getY(), (int) sPacketSoundEffect.getZ()) <= 2.0) {
                this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SEARCHING;
                this.Field2403 = 0;
            }
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketBlockChange && this.Field2397 != null && ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockPosition().equals((Object) this.Field2397) && ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockState().getBlock() instanceof BlockAir) {
            this.Field2397 = null;
        }
    }

    public boolean Method2161573() {
        return PistonAuraTest.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    private boolean Method2161574(EntityPlayer entityPlayer) {
        if (this.Method2161585() == -1) {
            Command.Method2159696("No redstone found!");
            this.Method2150391();
            return false;
        }
        BlockPos blockPos = new BlockPos((Entity) entityPlayer).up();
        if (this.Method2161570(blockPos)) {
            return true;
        }
        blockPos = new BlockPos((Entity) entityPlayer).up().up();
        return this.Method2161570(blockPos);
    }

    public void Method2161575(Entity entity) {
        if (this.Field2389.getValue().booleanValue() && PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.AIR)) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161586()));
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161577(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161577(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161577(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK) && this.Method2161577(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
        }
    }

    public void Method2161576(Entity entity) {
        if (this.Field2389.getValue().booleanValue() && PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.AIR)) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161586()));
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161578(entity);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161578(entity);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161578(entity);
                return;
            }
            if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161578(entity);
                return;
            }
            if (this.Method2161577(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX + 1.0, entity.posY + 1.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161575(entity);
                return;
            }
            if (this.Method2161577(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX - 1.0, entity.posY + 1.0, entity.posZ), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161575(entity);
                return;
            }
            if (this.Method2161577(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161575(entity);
                return;
            }
            if (this.Method2161577(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0))) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ - 1.0), true, true);
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
                this.Method2161575(entity);
                return;
            }
        }
    }

    public boolean Method2161577(BlockPos blockPos) {
        return PistonAuraTest.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()) > 2.0;
    }

    public void Method2161578(Entity entity) {
        InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
        PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161586()));
        if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX + 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
        if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX - 1.0, entity.posY + 2.0, entity.posZ)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
        if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
        if (PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.OBSIDIAN) || PistonAuraTest.Field2811.world.getBlockState(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ - 1.0)).getBlock().equals((Object) Blocks.BEDROCK)) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), true, true);
            InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        }
    }

    public boolean Method2161570(BlockPos blockPos) {
        if (!this.Method2161582(blockPos) && !this.Field2388.getValue().booleanValue()) {
            return false;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            Optional<BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> optional;
            this.Field2397 = null;
            this.Field2399 = false;
            if (!PistonAuraTest.Method2161579(blockPos.offset(enumFacing).down())) continue;
            if (this.Method2161585() == -1) {
                return false;
            }
            ItemStack itemStack = PistonAuraTest.Field2811.player.inventory.getStackInSlot(this.Method2161585());
            Block block = ((ItemBlock) itemStack.getItem()).getBlock();
            if (block == Blocks.REDSTONE_BLOCK) {
                if (!this.Method2161582(blockPos.offset(enumFacing, 3))) {
                    if (!this.Field2388.getValue().booleanValue() || PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() != Blocks.REDSTONE_TORCH && PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() != Blocks.REDSTONE_BLOCK)
                        continue;
                    this.Field2397 = blockPos.offset(enumFacing, 3);
                }
            } else {
                optional = BlockUtilSC.Method2162887(blockPos.offset(enumFacing, 3), false, true);
                if (!optional.isPresent() && this.Field2388.getValue().booleanValue() && (PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() == Blocks.REDSTONE_TORCH || PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() == Blocks.REDSTONE_BLOCK)) {
                    this.Field2397 = blockPos.offset(enumFacing, 3);
                }
                if (!optional.isPresent() && this.Field2397 == null && ((ItemBlock) PistonAuraTest.Field2811.player.inventory.getStackInSlot(this.Method2161585()).getItem()).getBlock() == Blocks.REDSTONE_TORCH) {
                    for (Object object : EnumFacing.HORIZONTALS) {
                        if (object.equals((Object) enumFacing) || object.equals((Object) enumFacing.getOpposite()))
                            continue;
                        optional = BlockUtilSC.Method2162887(blockPos.offset(enumFacing, 2).offset(object), false, true);
                        if (optional.isPresent()) break;
                        if (!this.Field2388.getValue().booleanValue() || PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2).offset(object)).getBlock() != Blocks.REDSTONE_TORCH)
                            continue;
                        this.Field2397 = blockPos.offset(enumFacing, 2).offset(object);
                        break;
                    }
                }
                if (!optional.isPresent() && this.Field2397 == null) continue;
            }
            optional = BlockUtilSC.Method2162885(blockPos.offset(enumFacing, 2));
            this.Field2399 = this.Field2388.getValue() != false && PistonAuraTest.Field2811.world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() instanceof BlockPistonBase;
            boolean bl = this.Field2399;
            if (!optional.isPresent() && !this.Field2399) continue;
            if (!this.Field2399) {
                Object object;
                BlockPos blockPos2 = optional.get().Field2369;
                EnumFacing enumFacing2 = optional.get().Field2370;
                object = BlockUtilSC.Method2162880(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), enumFacing2, (EntityPlayer) PistonAuraTest.Field2811.player);
                EnumFacing enumFacing3 = EnumFacing.fromAngle((double) object[0]);
                if (Math.abs((double) object[1]) > 55.0 || enumFacing3 != enumFacing || this.Field2386.getValue().booleanValue() && !this.Method2161581(optional.get().Field2369))
                    continue;
                this.Field2395 = blockPos2;
                this.Field2396 = enumFacing2;
            }
            this.Field2392 = blockPos;
            this.Field2393 = enumFacing;
            this.Field2394 = blockPos.offset(enumFacing).down();
            return true;
        }
        return false;
    }

    private boolean Method2161581(BlockPos blockPos) {
        for (double d = 0.1; d < 0.9; d += 0.1) {
            for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                    Vec3d vec3d = new Vec3d(PistonAuraTest.Field2811.player.posX, PistonAuraTest.Field2811.player.getEntityBoundingBox().minY + (double) PistonAuraTest.Field2811.player.getEyeHeight(), PistonAuraTest.Field2811.player.posZ);
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
                    RayTraceResult rayTraceResult = PistonAuraTest.Field2811.world.rayTraceBlocks(vec3d, vec3d4, false, false, false);
                    if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                        continue;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Method2161582(BlockPos blockPos) {
        return PistonAuraTest.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockAir;
    }

    private List<EntityPlayer> Method2161583() {
        return PistonAuraTest.Field2811.world.playerEntities.stream().filter(PistonAuraTest::Method2161580).filter(PistonAuraTest::Method2161589).filter(this::Method2161588).sorted(Comparator.comparing(PistonAuraTest::Method2161587)).collect(Collectors.toList());
    }

    private int Method2161585() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PistonAuraTest.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || (block = ((ItemBlock) itemStack.getItem()).getBlock()) != Blocks.REDSTONE_BLOCK && block != Blocks.REDSTONE_TORCH)
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private int Method2161586() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PistonAuraTest.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private boolean Method2161588(EntityPlayer entityPlayer) {
        return PistonAuraTest.Field2811.player.getDistance((Entity) entityPlayer) < (float) this.Field2381.getValue().intValue();
    }

    private void Method2161591(int n2, InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, BlockPos blockPos, EnumFacing enumFacing) {
        boolean bl = PistonAuraTest.Field2811.player.inventory.currentItem != n2;
        int n3 = PistonAuraTest.Field2811.player.inventory.currentItem;
        if (bl) {
            PistonAuraTest.Field2811.player.inventory.currentItem = n2;
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        InteractionUtil.Method2163754(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        this.Field2407 = blockPos.offset(enumFacing);
        this.Field2408.Method2164750();
        if (bl) {
            PistonAuraTest.Field2811.player.inventory.currentItem = n3;
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
    }

    private void Method2161592(int n2, InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        boolean bl = PistonAuraTest.Field2811.player.inventory.currentItem != n2;
        int n3 = PistonAuraTest.Field2811.player.inventory.currentItem;
        if (bl) {
            PistonAuraTest.Field2811.player.inventory.currentItem = n2;
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        InteractionUtil.Method2163754(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, true);
        this.Field2401.Method2164750();
        this.Field2403 = CrystalUtilSC.Method2162805() + 150;
        if (bl) {
            PistonAuraTest.Field2811.player.inventory.currentItem = n3;
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n3));
        }
        if (this.Field2378.getValue().booleanValue()) {
            this.Method2150391();
        }
    }

    private void Method2161593(Entity entity) {
        PistonAuraTest.Field2811.playerController.attackEntity((EntityPlayer) PistonAuraTest.Field2811.player, entity);
        PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161573() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
    }

    private boolean Method2161595(Entity entity) {
        return PistonAuraTest.Field2811.player.getDistance(entity) <= (float) (this.Field2381.getValue() + 4);
    }

    private void Method2161597(boolean bl, int n2, boolean bl2, boolean bl3, Optional optional, Vec3d vec3d) {
        this.Field2401.Method2164750();
        this.Field2404.Method2164750();
        this.Field2403 = this.Field2382.getValue() * 10;
        if (bl) {
            PistonAuraTest.Field2811.player.inventory.currentItem = n2;
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl2) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        }
        PistonAuraTest.Field2811.playerController.processRightClickBlock(PistonAuraTest.Field2811.player, PistonAuraTest.Field2811.world, ((BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) optional.get()).Field2369, ((BlockUtilSC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) optional.get()).Field2370, vec3d, EnumHand.MAIN_HAND);
        PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        if (bl3) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
        }
        this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAKING;
    }

    private void Method2161598() {
        this.Field2404.Method2164750();
        RayTraceResult rayTraceResult = PistonAuraTest.Field2811.world.rayTraceBlocks(new Vec3d(PistonAuraTest.Field2811.player.posX, PistonAuraTest.Field2811.player.posY + (double) PistonAuraTest.Field2811.player.getEyeHeight(), PistonAuraTest.Field2811.player.posZ), new Vec3d((double) this.Field2394.getX() + 0.5, (double) this.Field2394.getY() - 0.5, (double) this.Field2394.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        BlockUtilSC.Method2162870(this.Field2394, PistonAuraTest.Field2811.player.getPositionVector().add(0.0, (double) PistonAuraTest.Field2811.player.getEyeHeight(), 0.0), this.Method2161573() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
        this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.REDSTONE;
        this.Field2398.Method2164750();
    }

    private void Method2161599(EnumFacing enumFacing) {
        PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field2397, enumFacing));
        PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.Field2397, enumFacing));
        this.Field2398.Method2164750();
    }

    private void Method2161590(boolean bl, int n2, boolean bl2, boolean bl3, Vec3d vec3d) {
        this.Field2404.Method2164750();
        if (bl) {
            PistonAuraTest.Field2811.player.inventory.currentItem = n2;
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        if (bl2) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        }
        PistonAuraTest.Field2811.playerController.processRightClickBlock(PistonAuraTest.Field2811.player, PistonAuraTest.Field2811.world, this.Field2395, this.Field2396, vec3d, EnumHand.MAIN_HAND);
        PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        if (bl3) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            PistonAuraTest.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PistonAuraTest.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
        }
        this.Field2391 = IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CRYSTAL;
    }

    private boolean Method2161501(Boolean bl) {
        return this.Field2376.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE;
    }

    private boolean Method2161502(Boolean bl) {
        return this.Field2376.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PUSH;
    }

    private boolean Method2161503(Boolean bl) {
        return this.Field2376.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PUSH;
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

