

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.MovementInput
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ElytraFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Flight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpeedRewrite;
import net.minecraft.util.MovementInput;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AirStrafe
        extends Module {
    private static AirStrafe Field2789 = new AirStrafe();
    public Setting<Boolean> Field2790 = this.Method2150366(new Setting<Boolean>("OnlySpeedModuleOff", Boolean.FALSE));
    public Setting<Boolean> Field2791 = this.Method2150366(new Setting<Boolean>("Jump", Boolean.FALSE));
    public boolean Field2792 = false;
    public double Field2793 = 0.0;
    public boolean Field2794 = false;

    public AirStrafe() {
        super("AirStrafe", "Makes you faster", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
        this.Method2161966();
    }

    public static AirStrafe Method2161965() {
        if (Field2789 == null) {
            Field2789 = new AirStrafe();
        }
        return Field2789;
    }

    private void Method2161966() {
        Field2789 = this;
    }

    private boolean Method2161967() {
        return AliceMain.Field756.Method2150180(Freecam.class).Method2150364() || AliceMain.Field756.Method2150180(PacketFlight.class).Method2150364() || AliceMain.Field756.Method2150180(ElytraFlight.class).Method2150364() || AliceMain.Field756.Method2150180(Flight.class).Method2150364();
    }

    @Override
    public void Method2150379() {
        if (this.Method2161967() || AirStrafe.Field2811.player.isSneaking() || AirStrafe.Field2811.player.isInWater() || AirStrafe.Field2811.player.isInLava() || this.Field2790.getValue().booleanValue() && AliceMain.Field756.Method2150180(SpeedRewrite.class).Method2150364()) {
            return;
        }
    }

    @Override
    public void Method2150373() {
        this.Field2794 = false;
        AliceMain.Field771.Method2150334(1.0f);
        this.Field2792 = false;
    }

    @SubscribeEvent
    public void Method2161968(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2) {
            AirStrafe.Field2811.player.motionY = -0.1;
        }
    }

    @SubscribeEvent
    public void Method2161969(MoveEvent moveEvent) {
        if (!(this.Method2161967() || moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0 || AirStrafe.Method2150358() || AirStrafe.Field2811.player.isSneaking() || AirStrafe.Field2811.player.isInWater() || AirStrafe.Field2811.player.isInLava() || AirStrafe.Field2811.player.movementInput.moveForward == 0.0f && AirStrafe.Field2811.player.movementInput.moveStrafe == 0.0f)) {
            if (AirStrafe.Field2811.player.onGround && this.Field2791.getValue().booleanValue()) {
                AirStrafe.Field2811.player.motionY = 0.4;
                moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(0.4);
            }
            MovementInput movementInput = AirStrafe.Field2811.player.movementInput;
            float f = movementInput.moveForward;
            float f2 = movementInput.moveStrafe;
            float f3 = AirStrafe.Field2811.player.rotationYaw;
            if ((double) f == 0.0 && (double) f2 == 0.0) {
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0.0);
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(0.0);
            } else {
                if ((double) f != 0.0) {
                    float f4;
                    if ((double) f2 > 0.0) {
                        f3 += (float) ((double) f > 0.0 ? -45 : 45);
                    } else if ((double) f2 < 0.0) {
                        f3 += (float) ((double) f > 0.0 ? 45 : -45);
                    }
                    f2 = 0.0f;
                    float f5 = f == 0.0f ? f : (f4 = (f = (double) f > 0.0 ? 1.0f : -1.0f));
                }
                f2 = f2 == 0.0f ? f2 : ((double) f2 > 0.0 ? 1.0f : -1.0f);
                moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((double) f * EntityUtil.Method2163548() * Math.cos(Math.toRadians(f3 + 90.0f)) + (double) f2 * EntityUtil.Method2163548() * Math.sin(Math.toRadians(f3 + 90.0f)));
                moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll((double) f * EntityUtil.Method2163548() * Math.sin(Math.toRadians(f3 + 90.0f)) - (double) f2 * EntityUtil.Method2163548() * Math.cos(Math.toRadians(f3 + 90.0f)));
            }
        }
    }
}

