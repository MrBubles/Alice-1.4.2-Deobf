

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;

public class Timer {
    long Field3238 = System.currentTimeMillis();
    long Field3239 = 0L;
    boolean Field3240 = false;
    private long Field3235 = -1L;
    private long Field3236 = -1L;
    private long Field3237 = 0L;

    public static void Method2164767(float f) {
        Util.Field2811.timer.tickLength = 50.0f / f;
    }

    public static void Method2164771() {
        Util.Field2811.timer.tickLength = 50.0f;
    }

    public void Method2164749() {
        this.Field3238 = System.currentTimeMillis();
    }

    public boolean Method2164740(double d) {
        return (double) (System.currentTimeMillis() - this.Field3235) >= d;
    }

    public boolean Method2164751(double d) {
        return this.Method2164755((long) d * 1000L);
    }

    public boolean Method2164752(double d) {
        return this.Method2164755((long) d * 10L);
    }

    public boolean Method2164753(double d) {
        return this.Method2164755((long) d * 100L);
    }

    public boolean Method2164754(double d) {
        return this.Method2164762(System.nanoTime() - this.Field3235) >= (long) (d * 3.0);
    }

    public boolean Method2164755(long l2) {
        return this.Method2164758(this.Method2164763(l2));
    }

    public void Method2164756(long l2) {
        this.Field3235 = System.nanoTime() - this.Method2164763(l2);
    }

    public void Method2164757(long l2) {
        this.Field3235 = System.nanoTime() - l2 * 1000000L;
    }

    public boolean Method2164758(long l2) {
        return System.nanoTime() - this.Field3235 >= l2;
    }

    public long Method2164759() {
        return this.Method2164762(System.nanoTime() - this.Field3235);
    }

    public Timer Method2164750() {
        this.Field3235 = System.nanoTime();
        return this;
    }

    public void Method2164761() {
        this.Field3236 = System.currentTimeMillis();
    }

    public long Method2164762(long l2) {
        return l2 / 1000000L;
    }

    public long Method2164763(long l2) {
        return l2 * 1000000L;
    }

    public boolean Method2164764(long l2) {
        if (System.nanoTime() / 1000000L - l2 >= l2) {
            this.Method2164750();
            return true;
        }
        return false;
    }

    public boolean Method2164765(long l2) {
        return System.currentTimeMillis() - this.Field3236 >= l2;
    }

    public boolean Method2164766(double d) {
        return (double) (System.currentTimeMillis() - this.Field3236) >= d;
    }

    public boolean Method2164768() {
        return !this.Field3240 && System.currentTimeMillis() - this.Field3238 >= this.Field3239;
    }

    public boolean Method2164769() {
        return this.Field3240;
    }

    public void Method2164760(long l2) {
        this.Field3239 = l2;
    }

    public void Method2164772(boolean bl) {
        this.Field3240 = bl;
    }

    public boolean Method2164773(double d) {
        return this.Method2164762(System.nanoTime() - this.Field3235) >= (long) (d * 3.0);
    }
}

