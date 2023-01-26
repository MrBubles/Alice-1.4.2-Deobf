

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ElytraFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Flight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MotionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoSlowDown;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Step;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import me.snow.aclient.mixin.mixins.accessors.ICPacketPlayer;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpeedRewrite
        extends Module {
    public static SpeedRewrite Field2958;
    public final Setting<Boolean> Field2964 = this.Method2150366(new Setting<Boolean>("NoWeb", true));
    public final Setting<Boolean> Field2965 = this.Method2150366(new Setting<Boolean>("NoSpeedInWater", true));
    private final Setting<Boolean> Field2961 = this.Method2150366(new Setting<Boolean>("PotionCheck", true));
    private final Setting<Boolean> Field2963 = this.Method2150366(new Setting<Boolean>("TimerBoost", false));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field2959 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Mode", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRAFE));
    private final Setting<Boolean> Field2962 = this.Method2150366(new Setting<Boolean>("StrictMotion", Boolean.valueOf(false), this::Method2162141));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2960 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Speed", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL));
    private int Field2966 = 4;
    private int Field2967 = 2;
    private double Field2968;
    private double Field2969;
    private double Field2970;
    private boolean Field2971;
    private int Field2972;
    private int Field2973;
    private boolean Field2974;

    public SpeedRewrite() {
        super("Speed", "AirControl etc.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
        Field2958 = this;
    }

    public static void Method2162132() {
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2959.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRAFE);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2960.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2961.setValue(true);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2962.setValue(false);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2964.setValue(true);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2965.setValue(true);
    }

    public static void Method2162133() {
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2959.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRAFESTRICT);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2960.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2961.setValue(true);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2962.setValue(false);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2964.setValue(true);
        AliceMain.Field756.Method2150180(SpeedRewrite.class).Field2965.setValue(true);
    }

    public static SpeedRewrite Method2162134() {
        if (Field2958 == null) {
            Field2958 = new SpeedRewrite();
        }
        return Field2958;
    }

    @Override
    public void Method2150372() {
        AliceMain.Field771.Method2150369();
        this.Field2966 = 4;
        this.Field2967 = 2;
    }

    @Override
    public void Method2150373() {
        this.Method2162130();
        AliceMain.Field771.Method2150369();
    }

    @SubscribeEvent
    public void Method2162135(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            this.Field2969 = Math.sqrt(StrictMath.pow(SpeedRewrite.Field2811.player.posX - SpeedRewrite.Field2811.player.prevPosX, 2.0) + StrictMath.pow(SpeedRewrite.Field2811.player.posZ - SpeedRewrite.Field2811.player.prevPosZ, 2.0));
        }
    }

    @SubscribeEvent
    public void Method2162136(MoveEvent moveEvent) {
        double d;
        if (this.Field2965.getValue().booleanValue() && (Step.Field2811.player.isInWater() || Step.Field2811.player.isInLava())) {
            this.Method2162130();
            return;
        }
        if (this.Field2964.getValue().booleanValue() && NoSlowDown.Field2811.player.isInWeb) {
            this.Method2162130();
            return;
        }
        if (SpeedRewrite.Field2811.player.isOnLadder() || SpeedRewrite.Field2811.player.capabilities.isFlying || SpeedRewrite.Field2811.player.isElytraFlying() || SpeedRewrite.Field2811.player.fallDistance > 2.0f) {
            this.Method2162130();
            return;
        }
        if (this.Field2965.getValue().booleanValue() && (Step.Field2811.player.isInWater() || Step.Field2811.player.isInLava())) {
            return;
        }
        if (moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0 || this.Method2162139()) {
            return;
        }
        if (SpeedRewrite.Field2811.player.isSneaking()) {
            return;
        }
        AliceMain.Field771.Method2150369();
        double d2 = 0.2873;
        if (this.Field2960.getValue().equals((Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OLD)) {
            d2 = 0.272;
        }
        if (this.Field2961.getValue().booleanValue()) {
            if (SpeedRewrite.Field2811.player.isPotionActive(MobEffects.SPEED)) {
                d = SpeedRewrite.Field2811.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
                d2 *= 1.0 + 0.2 * (d + 1.0);
            }
            if (SpeedRewrite.Field2811.player.isPotionActive(MobEffects.SLOWNESS)) {
                d = SpeedRewrite.Field2811.player.getActivePotionEffect(MobEffects.SLOWNESS).getAmplifier();
                d2 /= 1.0 + 0.2 * (d + 1.0);
            }
        }
        if (!(!this.Field2962.getValue().booleanValue() || SpeedRewrite.Field2811.player.isSprinting() && ((IEntityPlayerSP) SpeedRewrite.Field2811.player).getServerSprintState() || Field2811.getConnection() == null)) {
            Field2811.getConnection().getNetworkManager().sendPacket((Packet) new CPacketEntityAction((Entity) SpeedRewrite.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
        }
        switch (1.F ield2318[this.Field2959.getValue().ordinal()]){
            case 1: {
                if (SpeedRewrite.Field2811.player.onGround && MotionUtil.Method2163885()) {
                    if (this.Field2967 == 2) {
                        this.Field2974 = true;
                        d = 2.149;
                        this.Field2968 *= d;
                        this.Field2967 = 3;
                    } else if (this.Field2967 == 3) {
                        d = 0.66 * (this.Field2969 - d2);
                        this.Field2968 = this.Field2969 - d;
                        this.Field2967 = 2;
                    }
                    if (SpeedRewrite.Field2811.world.getCollisionBoxes((Entity) SpeedRewrite.Field2811.player, SpeedRewrite.Field2811.player.getEntityBoundingBox().offset(0.0, 0.21, 0.0)).size() > 0 || SpeedRewrite.Field2811.player.collidedVertically) {
                        this.Field2967 = 1;
                    }
                }
                this.Field2968 = Math.max(this.Field2968, d2);
                float f = SpeedRewrite.Field2811.player.movementInput.moveForward;
                float f2 = SpeedRewrite.Field2811.player.movementInput.moveStrafe;
                float f3 = SpeedRewrite.Field2811.player.prevRotationYaw + (SpeedRewrite.Field2811.player.rotationYaw - SpeedRewrite.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
                if (!MotionUtil.Method2163885()) {
                    moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                    moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                } else if (f != 0.0f) {
                    if (f2 > 0.0f) {
                        f3 += f > 0.0f ? -45.0f : 45.0f;
                    } else if (f2 < 0.0f) {
                        f3 += f > 0.0f ? 45.0f : -45.0f;
                    }
                    f2 = 0.0f;
                    if (f > 0.0f) {
                        f = 1.0f;
                    } else if (f < 0.0f) {
                        f = -1.0f;
                    }
                }
                double d3 = Math.cos(Math.toRadians(f3));
                double d4 = -Math.sin(Math.toRadians(f3));
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * this.Field2968 * d4 + (double) f2 * this.Field2968 * d3);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * this.Field2968 * d3 - (double) f2 * this.Field2968 * d4);
                break;
            }
            case 2: {
                if (!MotionUtil.Method2163885()) break;
                if (this.Field2963.getValue().booleanValue()) {
                    AliceMain.Field771.Method2150334(1.088f);
                }
                if (this.Field2966 == 1) {
                    this.Field2968 = 1.35 * d2 - 0.01;
                } else if (this.Field2966 == 2) {
                    double d5;
                    d = 0.3999999463558197;
                    if (this.Field2961.getValue().booleanValue() && SpeedRewrite.Field2811.player.isPotionActive(MobEffects.JUMP_BOOST)) {
                        d5 = SpeedRewrite.Field2811.player.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier();
                        d += (d5 + 1.0) * 0.1;
                    }
                    SpeedRewrite.Field2811.player.motionY = d;
                    moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(d);
                    d5 = 1.395;
                    if (this.Field2971) {
                        d5 = 1.6835;
                    }
                    this.Field2968 *= d5;
                } else if (this.Field2966 == 3) {
                    d = 0.66 * (this.Field2969 - d2);
                    this.Field2968 = this.Field2969 - d;
                    this.Field2971 = !this.Field2971;
                } else {
                    if ((SpeedRewrite.Field2811.world.getCollisionBoxes((Entity) SpeedRewrite.Field2811.player, SpeedRewrite.Field2811.player.getEntityBoundingBox().offset(0.0, SpeedRewrite.Field2811.player.motionY, 0.0)).size() > 0 || SpeedRewrite.Field2811.player.collidedVertically) && this.Field2966 > 0) {
                        this.Field2966 = MotionUtil.Method2163885() ? 1 : 0;
                    }
                    this.Field2968 = this.Field2969 - this.Field2969 / 159.0;
                }
                this.Field2968 = Math.max(this.Field2968, d2);
                float f = SpeedRewrite.Field2811.player.movementInput.moveForward;
                float f4 = SpeedRewrite.Field2811.player.movementInput.moveStrafe;
                float f5 = SpeedRewrite.Field2811.player.prevRotationYaw + (SpeedRewrite.Field2811.player.rotationYaw - SpeedRewrite.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
                if (!MotionUtil.Method2163885()) {
                    moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                    moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                } else if (f != 0.0f) {
                    if (f4 > 0.0f) {
                        f5 += f > 0.0f ? -45.0f : 45.0f;
                    } else if (f4 < 0.0f) {
                        f5 += f > 0.0f ? 45.0f : -45.0f;
                    }
                    f4 = 0.0f;
                    if (f > 0.0f) {
                        f = 1.0f;
                    } else if (f < 0.0f) {
                        f = -1.0f;
                    }
                }
                double d6 = Math.cos(Math.toRadians(f5));
                double d7 = -Math.sin(Math.toRadians(f5));
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * this.Field2968 * d7 + (double) f4 * this.Field2968 * d6);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * this.Field2968 * d6 - (double) f4 * this.Field2968 * d7);
                ++this.Field2966;
                break;
            }
            case 3: {
                double d8;
                if (!MotionUtil.Method2163885()) break;
                if (this.Field2963.getValue().booleanValue()) {
                    AliceMain.Field771.Method2150334(1.088f);
                }
                if (this.Field2966 == 1) {
                    this.Field2968 = 1.35 * d2 - 0.01;
                } else if (this.Field2966 == 2) {
                    d = 0.3999999463558197;
                    if (this.Field2962.getValue().booleanValue()) {
                        d = 0.42f;
                    }
                    if (this.Field2961.getValue().booleanValue() && SpeedRewrite.Field2811.player.isPotionActive(MobEffects.JUMP_BOOST)) {
                        d8 = SpeedRewrite.Field2811.player.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier();
                        d += (d8 + 1.0) * 0.1;
                    }
                    SpeedRewrite.Field2811.player.motionY = d;
                    moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(d);
                    d8 = 2.149;
                    this.Field2968 *= d8;
                } else if (this.Field2966 == 3) {
                    d = 0.66 * (this.Field2969 - d2);
                    this.Field2968 = this.Field2969 - d;
                } else {
                    if ((SpeedRewrite.Field2811.world.getCollisionBoxes((Entity) SpeedRewrite.Field2811.player, SpeedRewrite.Field2811.player.getEntityBoundingBox().offset(0.0, SpeedRewrite.Field2811.player.motionY, 0.0)).size() > 0 || SpeedRewrite.Field2811.player.collidedVertically) && this.Field2966 > 0) {
                        this.Field2966 = MotionUtil.Method2163885() ? 1 : 0;
                    }
                    this.Field2968 = this.Field2969 - this.Field2969 / 159.0;
                }
                this.Field2968 = Math.max(this.Field2968, d2);
                d = 0.465;
                d8 = 0.44;
                if (this.Field2961.getValue().booleanValue()) {
                    double d9;
                    if (SpeedRewrite.Field2811.player.isPotionActive(MobEffects.SPEED)) {
                        d9 = SpeedRewrite.Field2811.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
                        d *= 1.0 + 0.2 * (d9 + 1.0);
                        d8 *= 1.0 + 0.2 * (d9 + 1.0);
                    }
                    if (SpeedRewrite.Field2811.player.isPotionActive(MobEffects.SLOWNESS)) {
                        d9 = SpeedRewrite.Field2811.player.getActivePotionEffect(MobEffects.SLOWNESS).getAmplifier();
                        d /= 1.0 + 0.2 * (d9 + 1.0);
                        d8 /= 1.0 + 0.2 * (d9 + 1.0);
                    }
                }
                this.Field2968 = Math.min(this.Field2968, this.Field2972 > 25 ? d : d8);
                ++this.Field2972;
                if (this.Field2972 > 50) {
                    this.Field2972 = 0;
                }
                float f = SpeedRewrite.Field2811.player.movementInput.moveForward;
                float f6 = SpeedRewrite.Field2811.player.movementInput.moveStrafe;
                float f7 = SpeedRewrite.Field2811.player.prevRotationYaw + (SpeedRewrite.Field2811.player.rotationYaw - SpeedRewrite.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
                if (!MotionUtil.Method2163885()) {
                    moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                    moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                } else if (f != 0.0f) {
                    if (f6 >= 1.0f) {
                        f7 += (float) (f > 0.0f ? -45 : 45);
                        f6 = 0.0f;
                    } else if (f6 <= -1.0f) {
                        f7 += (float) (f > 0.0f ? 45 : -45);
                        f6 = 0.0f;
                    }
                    if (f > 0.0f) {
                        f = 1.0f;
                    } else if (f < 0.0f) {
                        f = -1.0f;
                    }
                }
                double d10 = Math.cos(Math.toRadians(f7));
                double d11 = -Math.sin(Math.toRadians(f7));
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * this.Field2968 * d11 + (double) f6 * this.Field2968 * d10);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * this.Field2968 * d10 - (double) f6 * this.Field2968 * d11);
                ++this.Field2966;
                break;
            }
            case 4: {
                this.Field2968 = d2;
                if (!SpeedRewrite.Field2811.player.isSprinting()) {
                    this.Field2968 *= 0.7692307692;
                } else if (SpeedRewrite.Field2811.player.isSneaking()) {
                    this.Field2968 *= 0.3;
                }
                float f = SpeedRewrite.Field2811.player.movementInput.moveForward;
                float f8 = SpeedRewrite.Field2811.player.movementInput.moveStrafe;
                float f9 = SpeedRewrite.Field2811.player.prevRotationYaw + (SpeedRewrite.Field2811.player.rotationYaw - SpeedRewrite.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
                if (!MotionUtil.Method2163885()) {
                    moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                    moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                }
                if (f != 0.0f) {
                    if (f8 > 0.0f) {
                        f9 += (float) (f > 0.0f ? -45 : 45);
                    } else if (f8 < 0.0f) {
                        f9 += (float) (f > 0.0f ? 45 : -45);
                    }
                    f8 = 0.0f;
                    if (f > 0.0f) {
                        f = 1.0f;
                    } else if (f < 0.0f) {
                        f = -1.0f;
                    }
                }
                double d12 = Math.cos(Math.toRadians(f9));
                double d13 = -Math.sin(Math.toRadians(f9));
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * this.Field2968 * d13 + (double) f8 * this.Field2968 * d12);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * this.Field2968 * d12 - (double) f8 * this.Field2968 * d13);
            }
        }
    }

    @SubscribeEvent
    public void Method2162137(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketEntityAction && (((CPacketEntityAction) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction().equals((Object) CPacketEntityAction.Action.STOP_SPRINTING) || ((CPacketEntityAction) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction().equals((Object) CPacketEntityAction.Action.START_SNEAKING)) && this.Field2962.getValue().booleanValue()) {
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayer && ((ICPacketPlayer) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).isMoving() && this.Field2974) {
            ((ICPacketPlayer) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).setY(((CPacketPlayer) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getY(0.0) + (double) (SpeedRewrite.Field2811.world.getCollisionBoxes((Entity) SpeedRewrite.Field2811.player, SpeedRewrite.Field2811.player.getEntityBoundingBox().offset(0.0, 0.21, 0.0)).size() > 0 ? 2 : 4));
            this.Field2974 = false;
        }
    }

    @SubscribeEvent
    public void Method2162138(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        double d;
        double d2;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook) {
            this.Method2162130();
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketExplosion) {
            d2 = StrictMath.pow(((SPacketExplosion) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getMotionX() / 8000.0f, 2.0);
            d = StrictMath.pow(((SPacketExplosion) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getMotionX() / 8000.0f, 2.0);
            this.Field2970 = Math.sqrt(d2 + d);
            this.Field2973 = 0;
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getEntityID() == SpeedRewrite.Field2811.player.getEntityId()) {
            d2 = StrictMath.pow((float) ((SPacketEntityVelocity) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getMotionX() / 8000.0f, 2.0);
            d = StrictMath.pow((float) ((SPacketEntityVelocity) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getMotionX() / 8000.0f, 2.0);
            this.Field2970 = Math.sqrt(d2 + d);
            this.Field2973 = 0;
        }
    }

    private boolean Method2162139() {
        return AliceMain.Field756.Method2150196(Freecam.class) || AliceMain.Field756.Method2150196(ElytraFlight.class) || AliceMain.Field756.Method2150196(Flight.class) || AliceMain.Field756.Method2150196(PacketFlight.class);
    }

    public void Method2162130() {
        this.Field2966 = 4;
        this.Field2967 = 2;
        this.Field2968 = 0.0;
        this.Field2969 = 0.0;
        this.Field2970 = 0.0;
        this.Field2972 = 0;
        this.Field2973 = 0;
        this.Field2971 = false;
        this.Field2974 = false;
        AliceMain.Field771.Method2150369();
    }

    @Override
    public String Method2150385() {
        switch (1.F ield2318[this.Field2959.getValue().ordinal()]){
            case 2: {
                return "Strafe";
            }
            case 3: {
                return "StrafeStrict";
            }
            case 4: {
                return "GroundStrafe";
            }
            case 1: {
                return "OnGround";
            }
        }
        return null;
    }

    private boolean Method2162141(Boolean bl) {
        return this.Field2959.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRAFESTRICT;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NORMAL,
        OLD;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        STRAFE,
        STRAFESTRICT,
        GROUNDSTRAFE,
        ONGROUND;

    }
}

