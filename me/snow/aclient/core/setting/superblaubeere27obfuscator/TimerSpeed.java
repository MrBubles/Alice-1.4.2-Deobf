

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class TimerSpeed
        extends Module {
    public Setting<Float> Field2266 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f)));

    public TimerSpeed() {
        super("Timer", "Will speed up the game.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, false, false, false);
    }

    @Override
    public void Method2150376() {
        TimerSpeed.Field2811.timer.tickLength = 50.0f / this.Field2266.getValue().floatValue();
    }

    @Override
    public void Method2150372() {
        TimerSpeed.Field2811.timer.tickLength = 50.0f;
    }

    @Override
    public void Method2150373() {
        TimerSpeed.Field2811.timer.tickLength = 50.0f;
    }
}

