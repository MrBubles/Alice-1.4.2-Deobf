

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.MobEffects
 *  net.minecraft.util.MovementInput
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Objects;
import java.util.Random;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MotionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Step;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.util.MovementInput;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GroundSpeed
        extends Module {
    private static GroundSpeed Field4250 = new GroundSpeed();
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field4251 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSTANT));
    private final Setting<Double> Field4253 = this.Method2150366(new Setting<Double>("YportSpeed", Double.valueOf(0.1), Double.valueOf(0.0), Double.valueOf(1.0), this::Method2161037));
    public Setting<Boolean> Field4252 = this.Method2150366(new Setting<Boolean>("YportUseTimer", Boolean.valueOf(true), this::Method2161038));
    public Setting<Boolean> Field4254 = this.Method2150366(new Setting<Boolean>("YportStep", Boolean.valueOf(true), this::Method2161036));
    public Setting<Boolean> Field4255 = this.Method2150366(new Setting<Object>("Jump", Boolean.FALSE, this::Method2161035));
    public Setting<Boolean> Field4256 = this.Method2150366(new Setting<Object>("NoShake", Boolean.TRUE, this::Method2161034));
    public Setting<Boolean> Field4257 = this.Method2150366(new Setting<Object>("UseTimer", Boolean.FALSE, this::Method2161033));
    public Setting<Double> Field4258 = this.Method2150366(new Setting<Object>("0-Speed", Double.valueOf(0.0), Double.valueOf(0.0), Double.valueOf(100.0), this::Method2161032));
    public Setting<Double> Field4259 = this.Method2150366(new Setting<Object>("Speed", Double.valueOf(10.0), Double.valueOf(0.1), Double.valueOf(100.0), this::Method2161031));
    public Setting<Double> Field4260 = this.Method2150366(new Setting<Object>("Blocked", Double.valueOf(10.0), Double.valueOf(0.0), Double.valueOf(100.0), this::Method2161020));
    public Setting<Double> Field4261 = this.Method2150366(new Setting<Object>("Unblocked", Double.valueOf(10.0), Double.valueOf(0.0), Double.valueOf(100.0), this::Method2161029));
    public double Field4262;
    public boolean Field4263;
    public double Field4264;
    public boolean Field4265;
    private double Field4266;
    private double Field4267;
    private boolean Field4268;
    private double Field4269 = 0.4;
    private float Field4270 = 0.26f;
    private int Field4271;
    private Timer Field4272 = new Timer();
    private float Field4273 = 2.0f;

    public GroundSpeed() {
        super("GroundSpeed", "Makes you faster", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
        this.Method2161017();
    }

    public static GroundSpeed Method2161016() {
        if (Field4250 == null) {
            Field4250 = new GroundSpeed();
        }
        return Field4250;
    }

    private void Method2161017() {
        Field4250 = this;
    }

    private boolean Method2161018() {
        return AliceMain.Field756.Method2150195("Freecam") || AliceMain.Field756.Method2150195("Phase") || AliceMain.Field756.Method2150195("ElytraFlight") || AliceMain.Field756.Method2150195("Strafe") || AliceMain.Field756.Method2150195("Flight");
    }

    @Override
    public void Method2150379() {
        if (this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.YPORT) {
            if (GroundSpeed.Field2811.player.isSneaking() || GroundSpeed.Field2811.player.isInWater() || GroundSpeed.Field2811.player.isInLava() || GroundSpeed.Field2811.player.isOnLadder() || AliceMain.Field756.Method2150195("Strafe")) {
                return;
            }
            if (GroundSpeed.Field2811.player == null || GroundSpeed.Field2811.world == null) {
                this.Method2150380();
                return;
            }
            this.Method2161019();
            if ((!GroundSpeed.Field2811.player.isOnLadder() || GroundSpeed.Field2811.player.isInWater() || GroundSpeed.Field2811.player.isInLava()) && this.Field4254.getValue().booleanValue()) {
                Step.Field2811.player.stepHeight = this.Field4273;
                return;
            }
        }
        if (this.Method2161018() || GroundSpeed.Field2811.player.isSneaking() || GroundSpeed.Field2811.player.isInWater() || GroundSpeed.Field2811.player.isInLava()) {
            return;
        }
        switch (1.F ield2461[this.Field4251.getValue().ordinal()]){
            case 1: {
                this.Method2161023();
                break;
            }
            case 2: {
                this.Method2161024();
                break;
            }
            case 3: {
                this.Method2161025();
            }
        }
    }

    @Override
    public void Method2150374() {
        if (this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.YPORT) {
            Step.Field2811.player.stepHeight = 0.6f;
            GroundSpeed.Field2811.player.motionY = -3.0;
        }
    }

    private void Method2161019() {
        if (!MotionUtil.Method2163884((EntityLivingBase) GroundSpeed.Field2811.player) || GroundSpeed.Field2811.player.isInWater() && GroundSpeed.Field2811.player.isInLava() || GroundSpeed.Field2811.player.collidedHorizontally) {
            return;
        }
        if (GroundSpeed.Field2811.player.onGround) {
            if (this.Field4252.getValue().booleanValue()) {
                EntityUtil.Method2163575(1.15f);
            }
            GroundSpeed.Field2811.player.jump();
            MotionUtil.Method2163887((EntityLivingBase) GroundSpeed.Field2811.player, MotionUtil.Method2163888() + this.Field4253.getValue());
        } else {
            GroundSpeed.Field2811.player.motionY = -1.0;
            EntityUtil.Method2163574();
        }
    }

    @SubscribeEvent
    public void Method2161010(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (this.Field4251.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VANILLA || GroundSpeed.Method2150358()) {
            return;
        }
        switch (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll()) {
            case 0: {
                int n2 = this.Field4271 = this.Method2161022() ? (this.Field4271 = this.Field4271 + 1) : 0;
                if (this.Field4271 != 4) break;
                this.Field4265 = true;
                this.Field4264 = GroundSpeed.Field2811.player.getEntityBoundingBox().minY + (GroundSpeed.Field2811.world.getBlockState(GroundSpeed.Field2811.player.getPosition()).getMaterial().blocksMovement() ? -this.Field4260.getValue().doubleValue() / 10.0 : this.Field4261.getValue() / 10.0) + this.Method2161021();
                return;
            }
            case 1: {
                if (this.Field4271 == 3) {
                    GroundSpeed.Field2811.player.motionX *= this.Field4258.getValue() / 10.0;
                    GroundSpeed.Field2811.player.motionZ *= this.Field4258.getValue() / 10.0;
                    break;
                }
                if (this.Field4271 != 4) break;
                GroundSpeed.Field2811.player.motionX /= this.Field4259.getValue() / 10.0;
                GroundSpeed.Field2811.player.motionZ /= this.Field4259.getValue() / 10.0;
                this.Field4271 = 2;
            }
        }
    }

    private double Method2161021() {
        double d = 0.0;
        if (GroundSpeed.Field2811.player.isPotionActive(MobEffects.JUMP_BOOST)) {
            int n2 = Objects.requireNonNull(GroundSpeed.Field2811.player.getActivePotionEffect(MobEffects.JUMP_BOOST)).getAmplifier();
            d *= 1.0 + 0.2 * (double) n2;
        }
        return d;
    }

    private boolean Method2161022() {
        return GroundSpeed.Field2811.player.onGround;
    }

    private void Method2161023() {
        this.Field4269 = 0.4;
        this.Field4270 = 0.26f;
        if (GroundSpeed.Field2811.player.onGround) {
            this.Field4262 = GroundSpeed.Field2811.player.posY;
        }
        if (EntityUtil.Method2163552((Entity) GroundSpeed.Field2811.player) <= 1.0) {
            this.Field4267 = 1.0;
            this.Field4266 = 1.0;
        }
        if (EntityUtil.Method2163540((Entity) GroundSpeed.Field2811.player) && !GroundSpeed.Field2811.player.collidedHorizontally && !BlockUtil.Method2162836((Entity) GroundSpeed.Field2811.player) && BlockUtil.Method2162844((Entity) GroundSpeed.Field2811.player)) {
            this.Field4268 = true;
            this.Field4263 = this.Field4256.getValue() != false && GroundSpeed.Field2811.player.getRidingEntity() == null;
            Random random = new Random();
            boolean bl = random.nextBoolean();
            if (GroundSpeed.Field2811.player.posY >= this.Field4262 + this.Field4269) {
                GroundSpeed.Field2811.player.motionY = -this.Field4269;
                this.Field4267 += 1.0;
                if (this.Field4267 == 1.0) {
                    this.Field4270 = 0.075f;
                }
                if (this.Field4267 == 2.0) {
                    this.Field4270 = 0.15f;
                }
                if (this.Field4267 == 3.0) {
                    this.Field4270 = 0.175f;
                }
                if (this.Field4267 == 4.0) {
                    this.Field4270 = 0.2f;
                }
                if (this.Field4267 == 5.0) {
                    this.Field4270 = 0.225f;
                }
                if (this.Field4267 == 6.0) {
                    this.Field4270 = 0.25f;
                }
                if (this.Field4267 >= 7.0) {
                    this.Field4270 = 0.27895f;
                }
                if (this.Field4257.getValue().booleanValue()) {
                    AliceMain.Field771.Method2150334(1.0f);
                }
            }
            if (GroundSpeed.Field2811.player.posY == this.Field4262) {
                GroundSpeed.Field2811.player.motionY = this.Field4269;
                this.Field4266 += 1.0;
                if (this.Field4266 == 1.0) {
                    this.Field4270 = 0.075f;
                }
                if (this.Field4266 == 2.0) {
                    this.Field4270 = 0.175f;
                }
                if (this.Field4266 == 3.0) {
                    this.Field4270 = 0.325f;
                }
                if (this.Field4266 == 4.0) {
                    this.Field4270 = 0.375f;
                }
                if (this.Field4266 == 5.0) {
                    this.Field4270 = 0.4f;
                }
                if (this.Field4266 >= 6.0) {
                    this.Field4270 = 0.43395f;
                }
                if (this.Field4257.getValue().booleanValue()) {
                    if (bl) {
                        AliceMain.Field771.Method2150334(1.3f);
                    } else {
                        AliceMain.Field771.Method2150334(1.0f);
                    }
                }
            }
            EntityUtil.Method2163556(this.Field4270, (Entity) GroundSpeed.Field2811.player);
        } else {
            if (this.Field4268) {
                GroundSpeed.Field2811.player.motionY = -0.1;
                this.Field4268 = false;
            }
            this.Field4266 = 0.0;
            this.Field4267 = 0.0;
            this.Field4263 = false;
            this.Method2161028();
        }
    }

    private void Method2161024() {
        this.Field4269 = 0.4;
        this.Field4270 = 0.26f;
        if (GroundSpeed.Field2811.player.onGround) {
            this.Field4262 = GroundSpeed.Field2811.player.posY;
        }
        if (EntityUtil.Method2163552((Entity) GroundSpeed.Field2811.player) <= 1.0) {
            this.Field4267 = 1.0;
            this.Field4266 = 1.0;
        }
        if (EntityUtil.Method2163540((Entity) GroundSpeed.Field2811.player) && !GroundSpeed.Field2811.player.collidedHorizontally && !BlockUtil.Method2162836((Entity) GroundSpeed.Field2811.player) && BlockUtil.Method2162844((Entity) GroundSpeed.Field2811.player)) {
            this.Field4268 = true;
            this.Field4263 = this.Field4256.getValue() != false && GroundSpeed.Field2811.player.getRidingEntity() == null;
            Random random = new Random();
            boolean bl = random.nextBoolean();
            if (GroundSpeed.Field2811.player.posY >= this.Field4262 + this.Field4269) {
                GroundSpeed.Field2811.player.motionY = -this.Field4269;
                this.Field4267 += 1.0;
                if (this.Field4267 == 1.0) {
                    this.Field4270 = 0.075f;
                }
                if (this.Field4267 == 2.0) {
                    this.Field4270 = 0.175f;
                }
                if (this.Field4267 == 3.0) {
                    this.Field4270 = 0.275f;
                }
                if (this.Field4267 == 4.0) {
                    this.Field4270 = 0.35f;
                }
                if (this.Field4267 == 5.0) {
                    this.Field4270 = 0.375f;
                }
                if (this.Field4267 == 6.0) {
                    this.Field4270 = 0.4f;
                }
                if (this.Field4267 == 7.0) {
                    this.Field4270 = 0.425f;
                }
                if (this.Field4267 == 8.0) {
                    this.Field4270 = 0.45f;
                }
                if (this.Field4267 == 9.0) {
                    this.Field4270 = 0.475f;
                }
                if (this.Field4267 == 10.0) {
                    this.Field4270 = 0.5f;
                }
                if (this.Field4267 == 11.0) {
                    this.Field4270 = 0.5f;
                }
                if (this.Field4267 == 12.0) {
                    this.Field4270 = 0.525f;
                }
                if (this.Field4267 == 13.0) {
                    this.Field4270 = 0.525f;
                }
                if (this.Field4267 == 14.0) {
                    this.Field4270 = 0.535f;
                }
                if (this.Field4267 == 15.0) {
                    this.Field4270 = 0.535f;
                }
                if (this.Field4267 == 16.0) {
                    this.Field4270 = 0.545f;
                }
                if (this.Field4267 >= 17.0) {
                    this.Field4270 = 0.545f;
                }
                if (this.Field4257.getValue().booleanValue()) {
                    AliceMain.Field771.Method2150334(1.0f);
                }
            }
            if (GroundSpeed.Field2811.player.posY == this.Field4262) {
                GroundSpeed.Field2811.player.motionY = this.Field4269;
                this.Field4266 += 1.0;
                if (this.Field4266 == 1.0) {
                    this.Field4270 = 0.075f;
                }
                if (this.Field4266 == 2.0) {
                    this.Field4270 = 0.175f;
                }
                if (this.Field4266 == 3.0) {
                    this.Field4270 = 0.375f;
                }
                if (this.Field4266 == 4.0) {
                    this.Field4270 = 0.6f;
                }
                if (this.Field4266 == 5.0) {
                    this.Field4270 = 0.775f;
                }
                if (this.Field4266 == 6.0) {
                    this.Field4270 = 0.825f;
                }
                if (this.Field4266 == 7.0) {
                    this.Field4270 = 0.875f;
                }
                if (this.Field4266 == 8.0) {
                    this.Field4270 = 0.925f;
                }
                if (this.Field4266 == 9.0) {
                    this.Field4270 = 0.975f;
                }
                if (this.Field4266 == 10.0) {
                    this.Field4270 = 1.05f;
                }
                if (this.Field4266 == 11.0) {
                    this.Field4270 = 1.1f;
                }
                if (this.Field4266 == 12.0) {
                    this.Field4270 = 1.1f;
                }
                if (this.Field4266 == 13.0) {
                    this.Field4270 = 1.15f;
                }
                if (this.Field4266 == 14.0) {
                    this.Field4270 = 1.15f;
                }
                if (this.Field4266 == 15.0) {
                    this.Field4270 = 1.175f;
                }
                if (this.Field4266 == 16.0) {
                    this.Field4270 = 1.175f;
                }
                if (this.Field4266 >= 17.0) {
                    this.Field4270 = 1.175f;
                }
                if (this.Field4257.getValue().booleanValue()) {
                    if (bl) {
                        AliceMain.Field771.Method2150334(1.3f);
                    } else {
                        AliceMain.Field771.Method2150334(1.0f);
                    }
                }
            }
            EntityUtil.Method2163556(this.Field4270, (Entity) GroundSpeed.Field2811.player);
        } else {
            if (this.Field4268) {
                GroundSpeed.Field2811.player.motionY = -0.1;
                this.Field4268 = false;
            }
            this.Field4263 = false;
            this.Field4266 = 0.0;
            this.Field4267 = 0.0;
            this.Method2161028();
        }
    }

    private void Method2161025() {
        this.Field4269 = 0.4;
        this.Field4270 = 0.26f;
        if (GroundSpeed.Field2811.player.onGround) {
            this.Field4262 = GroundSpeed.Field2811.player.posY;
        }
        if (EntityUtil.Method2163552((Entity) GroundSpeed.Field2811.player) <= 1.0) {
            this.Field4267 = 1.0;
            this.Field4266 = 1.0;
        }
        if (EntityUtil.Method2163540((Entity) GroundSpeed.Field2811.player) && !GroundSpeed.Field2811.player.collidedHorizontally && !BlockUtil.Method2162836((Entity) GroundSpeed.Field2811.player) && BlockUtil.Method2162844((Entity) GroundSpeed.Field2811.player)) {
            this.Field4268 = true;
            this.Field4263 = this.Field4256.getValue() != false && GroundSpeed.Field2811.player.getRidingEntity() == null;
            Random random = new Random();
            boolean bl = random.nextBoolean();
            if (GroundSpeed.Field2811.player.posY >= this.Field4262 + this.Field4269) {
                GroundSpeed.Field2811.player.motionY = -this.Field4269;
                this.Field4267 += 1.0;
                if (this.Field4267 == 1.0) {
                    this.Field4270 = 0.075f;
                }
                if (this.Field4267 == 2.0) {
                    this.Field4270 = 0.175f;
                }
                if (this.Field4267 == 3.0) {
                    this.Field4270 = 0.275f;
                }
                if (this.Field4267 == 4.0) {
                    this.Field4270 = 0.35f;
                }
                if (this.Field4267 == 5.0) {
                    this.Field4270 = 0.375f;
                }
                if (this.Field4267 == 6.0) {
                    this.Field4270 = 0.4f;
                }
                if (this.Field4267 == 7.0) {
                    this.Field4270 = 0.425f;
                }
                if (this.Field4267 == 8.0) {
                    this.Field4270 = 0.45f;
                }
                if (this.Field4267 == 9.0) {
                    this.Field4270 = 0.475f;
                }
                if (this.Field4267 == 10.0) {
                    this.Field4270 = 0.5f;
                }
                if (this.Field4267 == 11.0) {
                    this.Field4270 = 0.5f;
                }
                if (this.Field4267 == 12.0) {
                    this.Field4270 = 0.525f;
                }
                if (this.Field4267 == 13.0) {
                    this.Field4270 = 0.525f;
                }
                if (this.Field4267 == 14.0) {
                    this.Field4270 = 0.535f;
                }
                if (this.Field4267 == 15.0) {
                    this.Field4270 = 0.535f;
                }
                if (this.Field4267 == 16.0) {
                    this.Field4270 = 0.545f;
                }
                if (this.Field4267 >= 17.0) {
                    this.Field4270 = 0.545f;
                }
                if (this.Field4257.getValue().booleanValue()) {
                    AliceMain.Field771.Method2150334(1.0f);
                }
            }
            if (GroundSpeed.Field2811.player.posY == this.Field4262) {
                GroundSpeed.Field2811.player.motionY = this.Field4269;
                this.Field4266 += 1.0;
                if (this.Field4266 == 1.0) {
                    this.Field4270 = 0.075f;
                }
                if (this.Field4266 == 2.0) {
                    this.Field4270 = 0.175f;
                }
                if (this.Field4266 == 3.0) {
                    this.Field4270 = 0.375f;
                }
                if (this.Field4266 == 4.0) {
                    this.Field4270 = 0.6f;
                }
                if (this.Field4266 == 5.0) {
                    this.Field4270 = 0.775f;
                }
                if (this.Field4266 == 6.0) {
                    this.Field4270 = 0.825f;
                }
                if (this.Field4266 == 7.0) {
                    this.Field4270 = 0.875f;
                }
                if (this.Field4266 == 8.0) {
                    this.Field4270 = 0.925f;
                }
                if (this.Field4266 == 9.0) {
                    this.Field4270 = 0.975f;
                }
                if (this.Field4266 == 10.0) {
                    this.Field4270 = 1.05f;
                }
                if (this.Field4266 == 11.0) {
                    this.Field4270 = 1.1f;
                }
                if (this.Field4266 == 12.0) {
                    this.Field4270 = 1.1f;
                }
                if (this.Field4266 == 13.0) {
                    this.Field4270 = 1.15f;
                }
                if (this.Field4266 == 14.0) {
                    this.Field4270 = 1.15f;
                }
                if (this.Field4266 == 15.0) {
                    this.Field4270 = 1.175f;
                }
                if (this.Field4266 == 16.0) {
                    this.Field4270 = 1.175f;
                }
                if (this.Field4266 >= 17.0) {
                    this.Field4270 = 1.2f;
                }
                if (this.Field4257.getValue().booleanValue()) {
                    if (bl) {
                        AliceMain.Field771.Method2150334(1.3f);
                    } else {
                        AliceMain.Field771.Method2150334(1.0f);
                    }
                }
            }
            EntityUtil.Method2163556(this.Field4270, (Entity) GroundSpeed.Field2811.player);
        } else {
            if (this.Field4268) {
                GroundSpeed.Field2811.player.motionY = -0.1;
                this.Field4268 = false;
            }
            this.Field4263 = false;
            this.Field4266 = 0.0;
            this.Field4267 = 0.0;
            this.Method2161028();
        }
    }

    @Override
    public void Method2150373() {
        if (this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ONGROUND || this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOOST) {
            GroundSpeed.Field2811.player.motionY = -0.1;
        }
        this.Field4265 = false;
        AliceMain.Field771.Method2150334(1.0f);
        this.Field4266 = 0.0;
        this.Field4267 = 0.0;
        this.Field4263 = false;
        if (this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.YPORT) {
            this.Field4272.Method2164750();
            EntityUtil.Method2163574();
        }
    }

    @SubscribeEvent
    public void Method2161026(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().equals(this.Field4251) && this.Field4251.getPlannedValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSTANT) {
            GroundSpeed.Field2811.player.motionY = -0.1;
        }
    }

    @Override
    public String Method2150385() {
        return this.Field4251.currentEnumName();
    }

    @SubscribeEvent
    public void Method2161027(MoveEvent moveEvent) {
        if (!(this.Method2161018() || moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0 || this.Field4251.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSTANT || GroundSpeed.Method2150358() || GroundSpeed.Field2811.player.isSneaking() || GroundSpeed.Field2811.player.isInWater() || GroundSpeed.Field2811.player.isInLava() || GroundSpeed.Field2811.player.movementInput.moveForward == 0.0f && GroundSpeed.Field2811.player.movementInput.moveStrafe == 0.0f)) {
            if (GroundSpeed.Field2811.player.onGround && this.Field4255.getValue().booleanValue()) {
                GroundSpeed.Field2811.player.motionY = 0.4;
                moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(0.4);
            }
            MovementInput movementInput = GroundSpeed.Field2811.player.movementInput;
            float f = movementInput.moveForward;
            float f2 = movementInput.moveStrafe;
            float f3 = GroundSpeed.Field2811.player.rotationYaw;
            if ((double) f == 0.0 && (double) f2 == 0.0) {
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
            } else {
                if ((double) f != 0.0) {
                    if ((double) f2 > 0.0) {
                        f3 += (float) ((double) f > 0.0 ? -45 : 45);
                    } else if ((double) f2 < 0.0) {
                        f3 += (float) ((double) f > 0.0 ? 45 : -45);
                    }
                    f2 = 0.0f;
                }
                f2 = f2 == 0.0f ? f2 : ((double) f2 > 0.0 ? 1.0f : -1.0f);
                double d = Math.cos(Math.toRadians(f3 + 90.0f));
                double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * EntityUtil.Method2163548() * d + (double) f2 * EntityUtil.Method2163548() * d2);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * EntityUtil.Method2163548() * d2 - (double) f2 * EntityUtil.Method2163548() * d);
            }
        }
    }

    private void Method2161028() {
        float f = (float) Math.toRadians(GroundSpeed.Field2811.player.rotationYaw);
        if (BlockUtil.Method2162836((Entity) GroundSpeed.Field2811.player)) {
            if (GroundSpeed.Field2811.gameSettings.keyBindForward.isKeyDown() && !GroundSpeed.Field2811.gameSettings.keyBindSneak.isKeyDown() && GroundSpeed.Field2811.player.onGround) {
                GroundSpeed.Field2811.player.motionX -= (double) MathUtil.Method2163846(f) * 0.15;
                GroundSpeed.Field2811.player.motionZ += (double) MathUtil.Method2163847(f) * 0.15;
            }
        } else if (GroundSpeed.Field2811.player.collidedHorizontally) {
            if (GroundSpeed.Field2811.gameSettings.keyBindForward.isKeyDown() && !GroundSpeed.Field2811.gameSettings.keyBindSneak.isKeyDown() && GroundSpeed.Field2811.player.onGround) {
                GroundSpeed.Field2811.player.motionX -= (double) MathUtil.Method2163846(f) * 0.03;
                GroundSpeed.Field2811.player.motionZ += (double) MathUtil.Method2163847(f) * 0.03;
            }
        } else if (!BlockUtil.Method2162844((Entity) GroundSpeed.Field2811.player)) {
            if (GroundSpeed.Field2811.gameSettings.keyBindForward.isKeyDown() && !GroundSpeed.Field2811.gameSettings.keyBindSneak.isKeyDown() && GroundSpeed.Field2811.player.onGround) {
                GroundSpeed.Field2811.player.motionX -= (double) MathUtil.Method2163846(f) * 0.03;
                GroundSpeed.Field2811.player.motionZ += (double) MathUtil.Method2163847(f) * 0.03;
            }
        } else {
            GroundSpeed.Field2811.player.motionX = 0.0;
            GroundSpeed.Field2811.player.motionZ = 0.0;
        }
    }

    private boolean Method2161029(Object object) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VANILLA;
    }

    private boolean Method2161020(Object object) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VANILLA;
    }

    private boolean Method2161031(Object object) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VANILLA;
    }

    private boolean Method2161032(Object object) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VANILLA;
    }

    private boolean Method2161033(Object object) {
        return this.Field4251.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSTANT;
    }

    private boolean Method2161034(Object object) {
        return this.Field4251.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSTANT;
    }

    private boolean Method2161035(Object object) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSTANT;
    }

    private boolean Method2161036(Boolean bl) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.YPORT;
    }

    private boolean Method2161037(Double d) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.YPORT;
    }

    private boolean Method2161038(Boolean bl) {
        return this.Field4251.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.YPORT;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        INSTANT,
        ONGROUND,
        ACCEL,
        BOOST,
        VANILLA,
        YPORT;

    }
}

