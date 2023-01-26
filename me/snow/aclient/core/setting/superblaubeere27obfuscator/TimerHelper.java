/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

public class TimerHelper {
    private long Field4230 = this.Method2163731();

    private long Method2163731() {
        return System.currentTimeMillis();
    }

    public boolean Method2163732(float f) {
        return (float) (this.Method2163731() - this.Field4230) > f;
    }

    public void Method2163733() {
        this.Field4230 = this.Method2163731();
    }

    public long Method2163734() {
        return this.Method2163731() - this.Field4230;
    }
}

