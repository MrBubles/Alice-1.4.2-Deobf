/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;

public class ColorManagerF {
    private float Field3776 = 1.0f;
    private float Field3777 = 1.0f;
    private float Field3778 = 1.0f;
    private float Field3779 = 1.0f;
    private Color Field3780 = new Color(this.Field3776, this.Field3777, this.Field3778, this.Field3779);

    public Color Method2159095() {
        return this.Field3780;
    }

    public void Method2159096(Color color) {
        this.Field3780 = color;
    }

    public int Method2159097() {
        return ColorUtil.Method2163384(this.Field3780);
    }

    public int Method2159098() {
        return ColorUtil.Method2163384(new Color(this.Field3780.getRed(), this.Field3780.getGreen(), this.Field3780.getBlue(), 255));
    }

    public int Method2159099(int n2) {
        return ColorUtil.Method2163384(new Color(this.Field3776, this.Field3777, this.Field3778, (float) n2 / 255.0f));
    }

    public void Method2159090(float f, float f2, float f3, float f4) {
        this.Field3776 = f;
        this.Field3777 = f2;
        this.Field3778 = f3;
        this.Field3779 = f4;
        this.Method2159001();
    }

    public void Method2159001() {
        this.Method2159096(new Color(this.Field3776, this.Field3777, this.Field3778, this.Field3779));
    }

    public void Method2159002(int n2, int n3, int n4, int n5) {
        this.Field3776 = (float) n2 / 255.0f;
        this.Field3777 = (float) n3 / 255.0f;
        this.Field3778 = (float) n4 / 255.0f;
        this.Field3779 = (float) n5 / 255.0f;
        this.Method2159001();
    }

    public void Method2159003(float f) {
        this.Field3776 = f;
        this.Method2159001();
    }

    public void Method2159004(float f) {
        this.Field3777 = f;
        this.Method2159001();
    }

    public void Method2159005(float f) {
        this.Field3778 = f;
        this.Method2159001();
    }

    public void Method2159006(float f) {
        this.Field3779 = f;
        this.Method2159001();
    }
}

