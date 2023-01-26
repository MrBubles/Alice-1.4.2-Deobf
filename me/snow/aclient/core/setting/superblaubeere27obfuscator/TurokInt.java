/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.TurokString;

public class TurokInt {
    private TurokString Field2812;
    private TurokString Field2813;
    private int Field2814;
    private int Field2815;
    private int Field2816;

    public TurokInt(TurokString turokString, TurokString turokString2, int n2, int n3, int n4) {
        this.Field2812 = turokString;
        this.Field2813 = turokString2;
        this.Field2814 = n2;
        this.Field2815 = n4;
        this.Field2816 = n3;
    }

    public void Method2164847(int n2) {
        this.Field2814 = n2;
    }

    public void Method2164848(int n2) {
        this.Field2814 = n2 >= this.Field2815 ? this.Field2815 : (n2 <= this.Field2816 ? this.Field2816 : n2);
    }

    public TurokString Method2164849() {
        return this.Field2812;
    }

    public TurokString Method2164840() {
        return this.Field2813;
    }

    public int Method2164851() {
        return this.Field2814;
    }
}

