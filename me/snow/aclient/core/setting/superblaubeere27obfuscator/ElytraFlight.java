

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemElytra
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Random;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ElytraEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class ElytraFlight
        extends Module {
    public static ElytraFlight Field2657 = new ElytraFlight();
    private static boolean Field2682 = false;
    private final Random Field2687 = new Random();
    public Setting<Boolean> Field2665 = this.Method2150366(new Setting<Boolean>("CruiseControl", false));
    public Setting<Float> Field2668 = this.Method2150366(new Setting<Float>("Factor", Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(50.0f)));
    public Setting<Float> Field2670 = this.Method2150366(new Setting<Float>("UpFactor", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Float> Field2671 = this.Method2150366(new Setting<Float>("DownFactor", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public double Field2685;
    private Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2658 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST));
    public Setting<Boolean> Field2663 = this.Method2150366(new Setting<Boolean>("StopMotion", Boolean.TRUE, this::Method2161997));
    public Setting<Boolean> Field2664 = this.Method2150366(new Setting<Boolean>("Freeze", Boolean.FALSE, this::Method2161996));
    public Setting<Float> Field2666 = this.Method2150366(new Setting<Float>("MinUpSpeed", Float.valueOf(0.5f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2161995));
    public Setting<Boolean> Field2672 = this.Method2150366(new Setting<Boolean>("ForceHeight", Boolean.FALSE, this::Method2161992));
    private Setting<Integer> Field2673 = this.Method2150366(new Setting<Integer>("TargetY", Integer.valueOf(120), Integer.valueOf(1), Integer.valueOf(256), this::Method2161991));
    public Setting<Float> Field2675 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f), this::Method2161989));
    public Setting<Boolean> Field2679 = this.Method2150366(new Setting<Boolean>("SpeedLimit", Boolean.TRUE, this::Method2161986));
    public Setting<Float> Field2680 = this.Method2150366(new Setting<Float>("MaxSpeed", Float.valueOf(2.5f), Float.valueOf(0.1f), Float.valueOf(10.0f), this::Method2161985));
    public Setting<Boolean> Field2681 = new Setting<Boolean>("NoDrag", Boolean.FALSE, this::Method2161984);
    private Setting<Boolean> Field2659 = this.Method2150366(new Setting<Boolean>("GroundSafety", Boolean.FALSE, this::Method2161901));
    private Setting<Float> Field2674 = this.Method2150366(new Setting<Float>("TriggerHeight", Float.valueOf(0.3f), Float.valueOf(0.05f), Float.valueOf(1.0f), this::Method2161980));
    private Setting<Float> Field2660 = this.Method2150366(new Setting<Float>("Limit", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2161990));
    private Setting<Float> Field2661 = this.Method2150366(new Setting<Float>("Delay", Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(20.0f), this::Method2161999));
    private Setting<Float> Field2662 = this.Method2150366(new Setting<Float>("Timeout", Float.valueOf(0.5f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2161998));
    private Setting<Boolean> Field2667 = this.Method2150366(new Setting<Boolean>("AutoSwitch", Boolean.FALSE, this::Method2161994));
    private Setting<Integer> Field2669 = this.Method2150366(new Setting<Integer>("MinSpeed", Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(50), this::Method2161993));
    private Setting<Float> Field2676 = this.Method2150366(new Setting<Float>("DownSpeed", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f), this::Method2161988));
    private Setting<Boolean> Field2677 = this.Method2150366(new Setting<Boolean>("InstantFly", true));
    private Setting<Boolean> Field2678 = this.Method2150366(new Setting<Boolean>("Timer", Boolean.TRUE, this::Method2161987));
    private boolean Field2683;
    private double Field2684;
    private double Field2686;
    private Timer Field2688 = new Timer();
    private Timer Field2689 = new Timer();
    private Timer Field2690 = new Timer();
    private Timer Field2691 = new Timer();
    private boolean Field2692 = false;
    private boolean Field2693 = false;

    public ElytraFlight() {
        super("ElytraFlight", "Makes Elytra Flight better", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    public static boolean Method2161970() {
        return Field2682;
    }

    public static double[] Method2161983(double d) {
        float f = ElytraFlight.Field2811.player.movementInput.moveForward;
        float f2 = ElytraFlight.Field2811.player.movementInput.moveStrafe;
        float f3 = ElytraFlight.Field2811.player.prevRotationYaw + (ElytraFlight.Field2811.player.rotationYaw - ElytraFlight.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double) f * d * d3 + (double) f2 * d * d2;
        double d5 = (double) f * d * d2 - (double) f2 * d * d3;
        return new double[]{d4, d5};
    }

    @Override
    public String Method2150385() {
        return this.Field2658.currentEnumName();
    }

    @Override
    public void Method2150372() {
        this.Field2683 = false;
        this.Field2684 = 0.0;
        if (ElytraFlight.Field2811.player != null) {
            this.Field2686 = ElytraFlight.Field2811.player.posY;
            if (!ElytraFlight.Field2811.player.isCreative()) {
                ElytraFlight.Field2811.player.capabilities.allowFlying = false;
            }
            ElytraFlight.Field2811.player.capabilities.isFlying = false;
        }
        this.Field2692 = false;
        Field2682 = false;
    }

    @Override
    public void Method2150373() {
        if (ElytraFlight.Field2811.player != null) {
            if (!ElytraFlight.Field2811.player.isCreative()) {
                ElytraFlight.Field2811.player.capabilities.allowFlying = false;
            }
            ElytraFlight.Field2811.player.capabilities.isFlying = false;
        }
        ElytraFlight.Field2811.timer.tickLength = 50.0f;
        Field2682 = false;
    }

    @Override
    public void Method2150376() {
        double d;
        if (ElytraFlight.Field2811.world == null || ElytraFlight.Field2811.player == null) {
            return;
        }
        if (ElytraFlight.Field2811.player.onGround) {
            this.Field2693 = true;
        }
        if (!this.Field2665.getValue().booleanValue()) {
            this.Field2686 = ElytraFlight.Field2811.player.posY;
        }
        for (ItemStack itemStack : ElytraFlight.Field2811.player.getArmorInventoryList()) {
            if (itemStack.getItem() instanceof ItemElytra) {
                Field2682 = true;
                break;
            }
            Field2682 = false;
        }
        if (this.Field2691.Method2164755(1500L) && !this.Field2691.Method2164755(2000L)) {
            ElytraFlight.Field2811.timer.tickLength = 50.0f;
        }
        if (!ElytraFlight.Field2811.player.isElytraFlying()) {
            if (this.Field2693 && this.Field2678.getValue().booleanValue() && !ElytraFlight.Field2811.player.onGround) {
                ElytraFlight.Field2811.timer.tickLength = 166.66667f;
            }
            if (!ElytraFlight.Field2811.player.onGround && this.Field2677.getValue().booleanValue() && ElytraFlight.Field2811.player.motionY < 0.0) {
                if (!this.Field2688.Method2164755((long) (1000.0f * this.Field2662.getValue().floatValue()))) {
                    return;
                }
                this.Field2688.Method2164750();
                ElytraFlight.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) ElytraFlight.Field2811.player, CPacketEntityAction.Action.START_FALL_FLYING));
                this.Field2693 = false;
                this.Field2691.Method2164750();
            }
            return;
        }
        if (ElytraFlight.Field2811.player == null) {
            return;
        }
        if (this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK) {
            return;
        }
        if (ElytraFlight.Field2811.gameSettings.keyBindJump.isKeyDown()) {
            this.Field2686 += (double) this.Field2670.getValue().floatValue() * 0.5;
        } else if (ElytraFlight.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
            this.Field2686 -= (double) this.Field2671.getValue().floatValue() * 0.5;
        }
        if (this.Field2672.getValue().booleanValue()) {
            this.Field2686 = this.Field2673.getValue().intValue();
        }
        Vec3d vec3d = new Vec3d(ElytraFlight.Field2811.player.motionX, ElytraFlight.Field2811.player.motionY, ElytraFlight.Field2811.player.motionZ);
        double d2 = vec3d.length() * 20.0;
        double d3 = Math.sqrt(ElytraFlight.Field2811.player.motionX * ElytraFlight.Field2811.player.motionX + ElytraFlight.Field2811.player.motionZ * ElytraFlight.Field2811.player.motionZ);
        double d4 = MathHelper.clamp((double) (d3 / 1.7), (double) 0.0, (double) 1.0);
        double d5 = 1.0 - Math.sqrt(d4);
        double d6 = 0.6;
        if (d4 >= 0.5 || ElytraFlight.Field2811.player.posY > this.Field2686 + 1.0) {
            double d7 = -((45.0 - d6) * d5 + d6);
            d = (this.Field2686 + 1.0 - ElytraFlight.Field2811.player.posY) * 2.0;
            double d8 = MathHelper.clamp((double) Math.abs(d), (double) 0.0, (double) 1.0);
            double d9 = -Math.toDegrees(Math.atan2(Math.abs(d), d3 * 30.0)) * Math.signum(d);
            double d10 = (d9 - d7) * d8;
            ElytraFlight.Field2811.player.rotationPitch = (float) d7;
            ElytraFlight.Field2811.player.rotationPitch += (float) d10;
            ElytraFlight.Field2811.player.prevRotationPitch = ElytraFlight.Field2811.player.rotationPitch;
        }
        if (this.Field2690.Method2164755((long) (1000.0f * this.Field2668.getValue().floatValue()))) {
            Block block;
            d = this.Field2686 - ElytraFlight.Field2811.player.posY;
            boolean bl = d > 0.25 && d < 1.0 || d2 < (double) this.Field2669.getValue().intValue();
            boolean bl2 = bl;
            if (this.Field2659.getValue().booleanValue() && (block = ElytraFlight.Field2811.world.getBlockState(new BlockPos((Entity) ElytraFlight.Field2811.player).down()).getBlock()) != Blocks.AIR && !(block instanceof BlockLiquid) && ElytraFlight.Field2811.player.getEntityBoundingBox().minY - Math.floor(ElytraFlight.Field2811.player.getEntityBoundingBox().minY) > (double) this.Field2674.getValue().floatValue()) {
                bl = true;
            }
            if (this.Field2667.getValue().booleanValue() && bl && ElytraFlight.Field2811.player.getHeldItemMainhand().getItem() != Items.FIREWORKS) {
                for (int j = 0; j < 9; ++j) {
                    if (ElytraFlight.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.FIREWORKS) {
                        continue;
                    }
                    ElytraFlight.Field2811.player.inventory.currentItem = j;
                    ElytraFlight.Field2811.playerController.updateController();
                    break;
                }
            }
            if (ElytraFlight.Field2811.player.getHeldItemMainhand().getItem() == Items.FIREWORKS && bl) {
                ElytraFlight.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                this.Field2690.Method2164750();
            }
        }
    }

    private boolean Method2161981(int n2) {
        for (int j = MathHelper.floor((double) ElytraFlight.Field2811.player.getEntityBoundingBox().minX); j < MathHelper.ceil((double) ElytraFlight.Field2811.player.getEntityBoundingBox().maxX); ++j) {
            for (int i2 = MathHelper.floor((double) ElytraFlight.Field2811.player.getEntityBoundingBox().minZ); i2 < MathHelper.ceil((double) ElytraFlight.Field2811.player.getEntityBoundingBox().maxZ); ++i2) {
                IBlockState iBlockState = ElytraFlight.Field2811.world.getBlockState(new BlockPos(j, n2, i2));
                if (iBlockState.getBlock() == Blocks.AIR) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    @SubscribeEvent
    public void Method2161982(ElytraEvent elytraEvent) {
        if (ElytraFlight.Field2811.world == null || ElytraFlight.Field2811.player == null || !Field2682 || !ElytraFlight.Field2811.player.isElytraFlying()) {
            return;
        }
        if (this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK) {
            return;
        }
        if (elytraEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() == ElytraFlight.Field2811.player && ElytraFlight.Field2811.player.isServerWorld() || ElytraFlight.Field2811.player.canPassengerSteer() && !ElytraFlight.Field2811.player.isInWater() || ElytraFlight.Field2811.player != null && ElytraFlight.Field2811.player.capabilities.isFlying && !ElytraFlight.Field2811.player.isInLava() || ElytraFlight.Field2811.player.capabilities.isFlying && ElytraFlight.Field2811.player.isElytraFlying()) {
            elytraEvent.setCanceled(true);
            if (this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST) {
                double d;
                Vec3d vec3d = ElytraFlight.Field2811.player.getLookVec();
                float f = ElytraFlight.Field2811.player.rotationPitch * ((float) Math.PI / 180);
                double d2 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
                double d3 = Math.sqrt(ElytraFlight.Field2811.player.motionX * ElytraFlight.Field2811.player.motionX + ElytraFlight.Field2811.player.motionZ * ElytraFlight.Field2811.player.motionZ);
                double d4 = vec3d.length();
                float f2 = MathHelper.cos((float) f);
                f2 = (float) ((double) f2 * (double) f2 * Math.min(1.0, d4 / 0.4));
                if (this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL) {
                    ElytraFlight.Field2811.player.motionY += -0.08 + (double) f2 * (0.06 / (double) this.Field2671.getValue().floatValue());
                }
                if (this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL) {
                    if (ElytraFlight.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        ElytraFlight.Field2811.player.motionY = -this.Field2676.getValue().floatValue();
                    } else if (!ElytraFlight.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                        ElytraFlight.Field2811.player.motionY = -3.0E-14 * (double) this.Field2671.getValue().floatValue();
                    }
                } else if (this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL && ElytraFlight.Field2811.player.motionY < 0.0 && d2 > 0.0) {
                    d = ElytraFlight.Field2811.player.motionY * -0.1 * (double) f2;
                    ElytraFlight.Field2811.player.motionY += d;
                    ElytraFlight.Field2811.player.motionX += vec3d.x * d / d2 * (double) this.Field2668.getValue().floatValue();
                    ElytraFlight.Field2811.player.motionZ += vec3d.z * d / d2 * (double) this.Field2668.getValue().floatValue();
                }
                if (f < 0.0f && this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL) {
                    double d5 = d3 * (double) (-MathHelper.sin((float) f)) * 0.04;
                    ElytraFlight.Field2811.player.motionY += d5 * 3.2 * (double) this.Field2670.getValue().floatValue();
                    ElytraFlight.Field2811.player.motionX -= vec3d.x * d5 / d2;
                    ElytraFlight.Field2811.player.motionZ -= vec3d.z * d5 / d2;
                } else if (this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL && ElytraFlight.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                    if (d3 > (double) (this.Field2670.getValue().floatValue() / this.Field2670.getMax().floatValue())) {
                        double d6 = d3 * 0.01325;
                        ElytraFlight.Field2811.player.motionY += d6 * 3.2;
                        ElytraFlight.Field2811.player.motionX -= vec3d.x * d6 / d2;
                        ElytraFlight.Field2811.player.motionZ -= vec3d.z * d6 / d2;
                    } else {
                        double[] arrd = ElytraFlight.Method2161983(this.Field2675.getValue().floatValue());
                        ElytraFlight.Field2811.player.motionX = arrd[0];
                        ElytraFlight.Field2811.player.motionZ = arrd[1];
                    }
                }
                if (d2 > 0.0) {
                    ElytraFlight.Field2811.player.motionX += (vec3d.x / d2 * d3 - ElytraFlight.Field2811.player.motionX) * 0.1;
                    ElytraFlight.Field2811.player.motionZ += (vec3d.z / d2 * d3 - ElytraFlight.Field2811.player.motionZ) * 0.1;
                }
                if (this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL && !ElytraFlight.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                    double[] arrd = ElytraFlight.Method2161983(this.Field2675.getValue().floatValue());
                    ElytraFlight.Field2811.player.motionX = arrd[0];
                    ElytraFlight.Field2811.player.motionZ = arrd[1];
                }
                if (!this.Field2681.getValue().booleanValue()) {
                    ElytraFlight.Field2811.player.motionX *= (double) 0.99f;
                    ElytraFlight.Field2811.player.motionY *= (double) 0.98f;
                    ElytraFlight.Field2811.player.motionZ *= (double) 0.99f;
                }
                d = Math.sqrt(ElytraFlight.Field2811.player.motionX * ElytraFlight.Field2811.player.motionX + ElytraFlight.Field2811.player.motionZ * ElytraFlight.Field2811.player.motionZ);
                if (this.Field2679.getValue().booleanValue() && d > (double) this.Field2680.getValue().floatValue()) {
                    ElytraFlight.Field2811.player.motionX *= (double) this.Field2680.getValue().floatValue() / d;
                    ElytraFlight.Field2811.player.motionZ *= (double) this.Field2680.getValue().floatValue() / d;
                }
                ElytraFlight.Field2811.player.move(MoverType.SELF, ElytraFlight.Field2811.player.motionX, ElytraFlight.Field2811.player.motionY, ElytraFlight.Field2811.player.motionZ);
            } else {
                double d;
                double d7;
                double d8;
                double d9;
                double d10;
                boolean bl = false;
                float f = ElytraFlight.Field2811.player.movementInput.moveForward;
                if (this.Field2665.getValue().booleanValue()) {
                    if (ElytraFlight.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                        this.Field2686 += (double) this.Field2670.getValue().floatValue() * 0.5;
                    } else if (ElytraFlight.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        this.Field2686 -= (double) this.Field2671.getValue().floatValue() * 0.5;
                    }
                    if (this.Field2672.getValue().booleanValue()) {
                        this.Field2686 = this.Field2673.getValue().intValue();
                    }
                    double d11 = Math.sqrt(ElytraFlight.Field2811.player.motionX * ElytraFlight.Field2811.player.motionX + ElytraFlight.Field2811.player.motionZ * ElytraFlight.Field2811.player.motionZ);
                    d10 = MathHelper.clamp((double) (d11 / 1.7), (double) 0.0, (double) 1.0);
                    d9 = 1.0 - Math.sqrt(d10);
                    d8 = 0.6;
                    if (d11 >= (double) this.Field2666.getValue().floatValue() && this.Field2688.Method2164755((long) (2000.0f * this.Field2660.getValue().floatValue()))) {
                        double d12 = -((45.0 - d8) * d9 + d8);
                        d7 = (this.Field2686 + 1.0 - ElytraFlight.Field2811.player.posY) * 2.0;
                        double d13 = MathHelper.clamp((double) Math.abs(d7), (double) 0.0, (double) 1.0);
                        double d14 = -Math.toDegrees(Math.atan2(Math.abs(d7), d11 * 30.0)) * Math.signum(d7);
                        double d15 = (d14 - d12) * d13;
                        ElytraFlight.Field2811.player.rotationPitch = (float) d12;
                        ElytraFlight.Field2811.player.rotationPitch += (float) d15;
                        ElytraFlight.Field2811.player.prevRotationPitch = ElytraFlight.Field2811.player.rotationPitch;
                    } else {
                        ElytraFlight.Field2811.player.rotationPitch = 0.25f;
                        ElytraFlight.Field2811.player.prevRotationPitch = 0.25f;
                        f = 1.0f;
                    }
                }
                Vec3d vec3d = ElytraFlight.Field2811.player.getLookVec();
                float f3 = ElytraFlight.Field2811.player.rotationPitch * ((float) Math.PI / 180);
                d10 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
                d9 = Math.sqrt(ElytraFlight.Field2811.player.motionX * ElytraFlight.Field2811.player.motionX + ElytraFlight.Field2811.player.motionZ * ElytraFlight.Field2811.player.motionZ);
                d8 = vec3d.length();
                float f4 = MathHelper.cos((float) f3);
                f4 = (float) ((double) f4 * (double) f4 * Math.min(1.0, d8 / 0.4));
                ElytraFlight.Field2811.player.motionY += -0.08 + (double) f4 * 0.06;
                if (ElytraFlight.Field2811.player.motionY < 0.0 && d10 > 0.0) {
                    d = ElytraFlight.Field2811.player.motionY * -0.1 * (double) f4;
                    ElytraFlight.Field2811.player.motionY += d;
                    ElytraFlight.Field2811.player.motionX += vec3d.x * d / d10;
                    ElytraFlight.Field2811.player.motionZ += vec3d.z * d / d10;
                }
                if (f3 < 0.0f) {
                    d = d9 * (double) (-MathHelper.sin((float) f3)) * 0.04;
                    ElytraFlight.Field2811.player.motionY += d * 3.2;
                    ElytraFlight.Field2811.player.motionX -= vec3d.x * d / d10;
                    ElytraFlight.Field2811.player.motionZ -= vec3d.z * d / d10;
                }
                if (d10 > 0.0) {
                    ElytraFlight.Field2811.player.motionX += (vec3d.x / d10 * d9 - ElytraFlight.Field2811.player.motionX) * 0.1;
                    ElytraFlight.Field2811.player.motionZ += (vec3d.z / d10 * d9 - ElytraFlight.Field2811.player.motionZ) * 0.1;
                }
                if (!this.Field2681.getValue().booleanValue()) {
                    ElytraFlight.Field2811.player.motionX *= (double) 0.99f;
                    ElytraFlight.Field2811.player.motionY *= (double) 0.98f;
                    ElytraFlight.Field2811.player.motionZ *= (double) 0.99f;
                }
                float f5 = ElytraFlight.Field2811.player.rotationYaw * ((float) Math.PI / 180);
                if (f3 > 0.0f && (ElytraFlight.Field2811.player.motionY < 0.0 || bl)) {
                    if (f != 0.0f && this.Field2688.Method2164755((long) (2000.0f * this.Field2660.getValue().floatValue())) && this.Field2689.Method2164755((long) (1000.0f * this.Field2661.getValue().floatValue()))) {
                        if (this.Field2663.getValue().booleanValue()) {
                            ElytraFlight.Field2811.player.motionX = 0.0;
                            ElytraFlight.Field2811.player.motionZ = 0.0;
                        }
                        this.Field2688.Method2164750();
                        ElytraFlight.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) ElytraFlight.Field2811.player, CPacketEntityAction.Action.START_FALL_FLYING));
                    } else if (!this.Field2688.Method2164755((long) (2000.0f * this.Field2660.getValue().floatValue()))) {
                        ElytraFlight.Field2811.player.motionX -= (double) f * Math.sin(f5) * (double) this.Field2668.getValue().floatValue() / 20.0;
                        ElytraFlight.Field2811.player.motionZ += (double) f * Math.cos(f5) * (double) this.Field2668.getValue().floatValue() / 20.0;
                        this.Field2689.Method2164750();
                    }
                }
                d7 = Math.sqrt(ElytraFlight.Field2811.player.motionX * ElytraFlight.Field2811.player.motionX + ElytraFlight.Field2811.player.motionZ * ElytraFlight.Field2811.player.motionZ);
                if (this.Field2679.getValue().booleanValue() && d7 > (double) this.Field2680.getValue().floatValue()) {
                    ElytraFlight.Field2811.player.motionX *= (double) this.Field2680.getValue().floatValue() / d7;
                    ElytraFlight.Field2811.player.motionZ *= (double) this.Field2680.getValue().floatValue() / d7;
                }
                if (this.Field2664.getValue().booleanValue() && Keyboard.isKeyDown((int) 56)) {
                    ElytraFlight.Field2811.player.setVelocity(0.0, 0.0, 0.0);
                }
                ElytraFlight.Field2811.player.move(MoverType.SELF, ElytraFlight.Field2811.player.motionX, ElytraFlight.Field2811.player.motionY, ElytraFlight.Field2811.player.motionZ);
            }
        }
    }

    private boolean Method2161984(Boolean bl) {
        return this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK;
    }

    private boolean Method2161985(Float f) {
        return this.Field2679.getValue() != false && this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK;
    }

    private boolean Method2161986(Boolean bl) {
        return this.Field2658.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK;
    }

    private boolean Method2161987(Boolean bl) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST;
    }

    private boolean Method2161988(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL;
    }

    private boolean Method2161989(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CONTROL;
    }

    private boolean Method2161980(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK && this.Field2659.getValue() != false;
    }

    private boolean Method2161991(Integer n2) {
        return (this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK || this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST && this.Field2665.getValue() != false) && this.Field2672.getValue() != false;
    }

    private boolean Method2161992(Boolean bl) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK || this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST && this.Field2665.getValue() != false;
    }

    private boolean Method2161993(Integer n2) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK;
    }

    private boolean Method2161994(Boolean bl) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK;
    }

    private boolean Method2161995(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST && this.Field2665.getValue() != false;
    }

    private boolean Method2161996(Boolean bl) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST;
    }

    private boolean Method2161997(Boolean bl) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST;
    }

    private boolean Method2161998(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST;
    }

    private boolean Method2161999(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST;
    }

    private boolean Method2161990(Float f) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST;
    }

    private boolean Method2161901(Boolean bl) {
        return this.Field2658.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FIREWORK;
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        BOOST,
        CONTROL,
        FIREWORK;

    }
}

