/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

public class TimerCa {
    private long Field2326 = -1L;

    public boolean Method2163255(double d) {
        return this.Method2163258((long) d * 1000L);
    }

    public boolean Method2163256(double d) {
        return this.Method2163258((long) d * 10L);
    }

    public boolean Method2163257(double d) {
        return this.Method2163258((long) d * 100L);
    }

    public boolean Method2163258(long l2) {
        return this.Method2163250(this.Method2163264(l2));
    }

    public void Method2163259(long l2) {
        this.Field2326 = System.nanoTime() - this.Method2163264(l2);
    }

    public boolean Method2163250(long l2) {
        return System.nanoTime() - this.Field2326 >= l2;
    }

    public long Method2163261() {
        return this.Method2163263(System.nanoTime() - this.Field2326);
    }

    public TimerCa Method2163262() {
        this.Field2326 = System.nanoTime();
        return this;
    }

    public long Method2163263(long l2) {
        return l2 / 1000000L;
    }

    public long Method2163264(long l2) {
        return l2 * 1000000L;
    }
}

