/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

public class Rect {
    private String Field3640;
    private int Field3641;
    private int Field3642;
    private int Field3643;
    private int Field3644;

    public Rect(String string, int n2, int n3) {
        this.Field3640 = string;
        this.Field3643 = n2;
        this.Field3644 = n3;
    }

    public void Method2164815(int n2, int n3) {
        this.Field3641 = n2;
        this.Field3642 = n3;
    }

    public void Method2164816(int n2, int n3, int n4, int n5) {
        this.Field3641 = n2;
        this.Field3642 = n3;
        this.Field3643 = n4;
        this.Field3644 = n5;
    }

    public boolean Method2164817(int n2, int n3) {
        return n2 >= this.Method2164819() && n3 >= this.Method2164810() && n2 <= this.Method2164823() && n3 <= this.Method2164824();
    }

    public String Method2164818() {
        return this.Field3640;
    }

    public int Method2164819() {
        return this.Field3641;
    }

    public int Method2164810() {
        return this.Field3642;
    }

    public int Method2164821() {
        return this.Field3643;
    }

    public int Method2164822() {
        return this.Field3644;
    }

    public int Method2164823() {
        return this.Field3641 + this.Field3643;
    }

    public int Method2164824() {
        return this.Field3642 + this.Field3644;
    }
}

