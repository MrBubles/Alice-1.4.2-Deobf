

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpeedRewrite;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LongJump
        extends Module {
    private final Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field2625 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Mode", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NCP));
    private final Setting<Double> Field2626 = this.Method2150366(new Setting<Double>("Speed", 3.0, 0.1, 20.0));
    private final Setting<Double> Field2627 = this.Method2150366(new Setting<Double>("Modifier", 3.0, 0.1, 10.0));
    private final Setting<Double> Field2628 = this.Method2150366(new Setting<Double>("Glide", 1.0, 0.1, 10.0));
    private final Setting<Boolean> Field2629 = this.Method2150366(new Setting<Boolean>("DisableStrafe", true));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2630 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("GroundCheck", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL));
    private final Setting<Boolean> Field2631 = this.Method2150366(new Setting<Boolean>("LagOff", false));
    private final Setting<Boolean> Field2632 = this.Method2150366(new Setting<Boolean>("ShortJump", false));
    private Timer Field2633 = new Timer();
    private boolean Field2634;
    private boolean Field2635;
    private int Field2636 = 0;
    private double Field2637;
    private double Field2638;
    private int Field2639;
    private int Field2640;
    private double Field2641;
    private boolean Field2642;
    private boolean Field2643 = false;

    public LongJump() {
        super("LongJump", "Jumps long", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    public static double Method2161093() {
        double d = 0.2873;
        if (LongJump.Field2811.player.isPotionActive(MobEffects.SPEED)) {
            int n2 = LongJump.Field2811.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d *= 1.0 + 0.2 * (double) (n2 + 1);
        }
        return d;
    }

    @SubscribeEvent
    public void Method2161080(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (this.Field2642) {
            if (this.Field2630.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL) {
                if (LongJump.Field2811.player.onGround) {
                    this.Field2642 = false;
                }
            } else if (this.Field2630.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.EDGEJUMP && LongJump.Field2811.player.onGround && !LongJump.Field2811.player.isSneaking() && LongJump.Field2811.world.getCollisionBoxes((Entity) LongJump.Field2811.player, LongJump.Field2811.player.getEntityBoundingBox().offset(0.0, 0.0, 0.0).shrink(0.001)).isEmpty()) {
                this.Field2642 = false;
            }
        } else if (this.Field2625.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NORMAL) {
            this.Field2637 = LongJump.Field2811.player.posX - LongJump.Field2811.player.prevPosX;
            double d = LongJump.Field2811.player.posZ - LongJump.Field2811.player.prevPosZ;
            this.Field2638 = Math.sqrt(this.Field2637 * this.Field2637 + d * d);
        } else {
            double d = LongJump.Field2811.player.posX - LongJump.Field2811.player.prevPosX;
            double d2 = LongJump.Field2811.player.posZ - LongJump.Field2811.player.prevPosZ;
            this.Field2638 = Math.sqrt(d * d + d2 * d2);
            if (!this.Field2635) {
                return;
            }
            LongJump.Field2811.player.motionY = 0.005;
        }
    }

    @SubscribeEvent
    public void Method2161091(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (this.Field2631.getValue().booleanValue() && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook) {
            this.Method2150380();
        }
    }

    @SubscribeEvent
    public void Method2161092(MoveEvent moveEvent) {
        if (this.Field2642) {
            return;
        }
        if (LongJump.Field2811.player != Field2811.getRenderViewEntity()) {
            return;
        }
        switch (1.F ield3748[this.Field2625.getValue().ordinal()]){
            case 1: {
                if (LongJump.Field2811.player.moveStrafing <= 0.0f && LongJump.Field2811.player.moveForward <= 0.0f) {
                    this.Field2640 = 1;
                }
                if (this.Method2161094(LongJump.Field2811.player.posY - (double) ((int) LongJump.Field2811.player.posY), 3) == 0.943) {
                    LongJump.Field2811.player.motionX = 0.0;
                    LongJump.Field2811.player.motionZ = 0.0;
                }
                if (this.Field2640 == 1 && (LongJump.Field2811.player.moveForward != 0.0f || LongJump.Field2811.player.moveStrafing != 0.0f)) {
                    this.Field2640 = 2;
                    this.Field2641 = this.Field2626.getValue() * LongJump.Method2161093() - 0.01;
                } else if (this.Field2640 == 2) {
                    LongJump.Field2811.player.motionY = 0.0848 * this.Field2627.getValue();
                    moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(0.0848 * this.Field2627.getValue());
                    this.Field2640 = 3;
                    this.Field2641 *= 2.149802;
                } else if (this.Field2640 == 3) {
                    this.Field2640 = 4;
                    this.Field2637 = 0.66 * this.Field2638;
                    this.Field2641 = this.Field2638 - this.Field2637;
                } else {
                    if (LongJump.Field2811.world.getCollisionBoxes((Entity) LongJump.Field2811.player, LongJump.Field2811.player.getEntityBoundingBox().offset(0.0, LongJump.Field2811.player.motionY, 0.0)).size() > 0 || LongJump.Field2811.player.collidedVertically) {
                        this.Field2640 = 1;
                    }
                    this.Field2641 = this.Field2638 - this.Field2638 / 159.0;
                }
                this.Field2641 = Math.max(this.Field2641, LongJump.Method2161093());
                float f = LongJump.Field2811.player.movementInput.moveForward;
                float f2 = LongJump.Field2811.player.movementInput.moveStrafe;
                float f3 = LongJump.Field2811.player.rotationYaw;
                if (f == 0.0f && f2 == 0.0f) {
                    moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                    moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                } else if (f != 0.0f) {
                    if (f2 >= 1.0f) {
                        f3 += (float) (f > 0.0f ? -45 : 45);
                        f2 = 0.0f;
                    } else if (f2 <= -1.0f) {
                        f3 += (float) (f > 0.0f ? 45 : -45);
                        f2 = 0.0f;
                    }
                    if (f > 0.0f) {
                        f = 1.0f;
                    } else if (f < 0.0f) {
                        f = -1.0f;
                    }
                }
                double d = Math.cos(Math.toRadians(f3 + 90.0f));
                double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * this.Field2641 * d + (double) f2 * this.Field2641 * d2);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * this.Field2641 * d2 - (double) f2 * this.Field2641 * d);
                this.Field2643 = true;
                return;
            }
            case 2: {
                if (this.Field2634) {
                    if (LongJump.Field2811.player.onGround) {
                        this.Field2633.Method2164750();
                    }
                    if (this.Method2161094(LongJump.Field2811.player.posY - (double) ((int) LongJump.Field2811.player.posY), 3) == 0.41) {
                        LongJump.Field2811.player.motionY = 0.0;
                    }
                    if (LongJump.Field2811.player.moveStrafing <= 0.0f && LongJump.Field2811.player.moveForward <= 0.0f) {
                        this.Field2639 = 1;
                    }
                    if (this.Method2161094(LongJump.Field2811.player.posY - (double) ((int) LongJump.Field2811.player.posY), 3) == 0.943) {
                        LongJump.Field2811.player.motionY = 0.0;
                    }
                    if (this.Field2639 == 1) {
                        if (LongJump.Field2811.player.moveForward != 0.0f || LongJump.Field2811.player.moveStrafing != 0.0f) {
                            this.Field2639 = 2;
                            this.Field2641 = this.Field2626.getValue() * LongJump.Method2161093() - 0.01;
                        }
                    } else if (this.Field2639 == 2) {
                        this.Field2639 = 3;
                        if (!this.Field2632.getValue().booleanValue()) {
                            LongJump.Field2811.player.motionY = 0.424;
                        }
                        moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(0.424);
                        this.Field2641 *= 2.149802;
                    } else if (this.Field2639 == 3) {
                        this.Field2639 = 4;
                        double d = 0.66 * (this.Field2638 - LongJump.Method2161093());
                        this.Field2641 = this.Field2638 - d;
                    } else {
                        if (LongJump.Field2811.world.getCollisionBoxes((Entity) LongJump.Field2811.player, LongJump.Field2811.player.getEntityBoundingBox().offset(0.0, LongJump.Field2811.player.motionY, 0.0)).size() > 0 || LongJump.Field2811.player.collidedVertically) {
                            this.Field2639 = 1;
                        }
                        this.Field2641 = this.Field2638 - this.Field2638 / 159.0;
                    }
                    this.Field2641 = Math.max(this.Field2641, LongJump.Method2161093());
                    float f = LongJump.Field2811.player.movementInput.moveForward;
                    float f4 = LongJump.Field2811.player.movementInput.moveStrafe;
                    float f5 = LongJump.Field2811.player.rotationYaw;
                    if (f == 0.0f || f4 == 0.0f) {
                        moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                        moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                    } else {
                        if (f4 >= 1.0f) {
                            f5 += (float) (f > 0.0f ? -45 : 45);
                            f4 = 0.0f;
                        } else if (f4 <= -1.0f) {
                            f5 += (float) (f > 0.0f ? 45 : -45);
                            f4 = 0.0f;
                        }
                        if (f > 0.0f) {
                            f = 1.0f;
                        } else if (f < 0.0f) {
                            f = -1.0f;
                        }
                    }
                    double d = Math.cos(Math.toRadians(f5 + 90.0f));
                    double d3 = Math.sin(Math.toRadians(f5 + 90.0f));
                    moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * this.Field2641 * d + (double) f4 * this.Field2641 * d3);
                    moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * this.Field2641 * d3 - (double) f4 * this.Field2641 * d);
                    if (f == 0.0f && f4 == 0.0f) {
                        moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                        moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
                    }
                }
                this.Field2643 = true;
                if (LongJump.Field2811.player.onGround) {
                    ++this.Field2636;
                } else if (!LongJump.Field2811.player.onGround && this.Field2636 != 0) {
                    --this.Field2636;
                }
                if (this.Field2632.getValue().booleanValue()) {
                    if (this.Field2633.Method2164740(35.0)) {
                        this.Field2635 = true;
                    }
                    if (this.Field2633.Method2164740(2490.0)) {
                        this.Field2635 = false;
                        this.Field2634 = false;
                        LongJump.Field2811.player.motionX *= 0.0;
                        LongJump.Field2811.player.motionZ *= 0.0;
                    }
                    if (!this.Field2633.Method2164740(2820.0)) {
                        return;
                    }
                    this.Field2634 = true;
                    LongJump.Field2811.player.motionX *= 0.0;
                    LongJump.Field2811.player.motionZ *= 0.0;
                    this.Field2633.Method2164750();
                    break;
                }
                if (this.Field2633.Method2164740(480.0)) {
                    LongJump.Field2811.player.motionX *= 0.0;
                    LongJump.Field2811.player.motionZ *= 0.0;
                    this.Field2634 = false;
                }
                if (!this.Field2633.Method2164740(780.0)) break;
                LongJump.Field2811.player.motionX *= 0.0;
                LongJump.Field2811.player.motionZ *= 0.0;
                this.Field2634 = true;
                this.Field2633.Method2164750();
            }
        }
    }

    @Override
    public void Method2150372() {
        if (LongJump.Field2811.player != null && LongJump.Field2811.world != null) {
            this.Field2641 = LongJump.Method2161093();
            LongJump.Field2811.player.onGround = true;
        }
        this.Field2642 = this.Field2630.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE;
        this.Field2635 = false;
        this.Field2634 = true;
        this.Field2638 = 0.0;
        this.Field2640 = 1;
        this.Field2643 = false;
        if (SpeedRewrite.Method2162134().Method2150386() && this.Field2629.getValue().booleanValue()) {
            Command.Method2159696("<LongJump> Disable Speed");
            SpeedRewrite.Method2162134().Method2150380();
        }
    }

    @Override
    public void Method2150373() {
        if (LongJump.Field2811.player != null && LongJump.Field2811.world != null && this.Field2625.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NCP) {
            LongJump.Field2811.player.onGround = false;
            LongJump.Field2811.player.capabilities.isFlying = false;
        }
    }

    public double Method2161094(double d, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        NORMAL,
        EDGEJUMP;

    }

    private static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        NORMAL,
        NCP;

    }
}

