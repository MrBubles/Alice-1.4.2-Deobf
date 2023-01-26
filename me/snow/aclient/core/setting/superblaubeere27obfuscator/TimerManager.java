

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;

public class TimerManager
        extends Feature {
    private float Field2799 = 1.0f;

    public void Method2150332() {
        this.Field2799 = 1.0f;
        TimerManager.Field2811.timer.tickLength = 50.0f;
    }

    public void Method2150333() {
        TimerManager.Field2811.timer.tickLength = 50.0f / (this.Field2799 <= 0.0f ? 0.1f : this.Field2799);
    }

    public void Method2150334(float f) {
        if (f > 0.0f) {
            this.Field2799 = f;
        }
    }

    public float Method2150335() {
        return this.Field2799;
    }

    @Override
    public void Method2150369() {
        this.Field2799 = 1.0f;
    }
}

