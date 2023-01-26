/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;

public class ColorManager2 {
    private float Field3738 = 1.0f;
    private float Field3739 = 1.0f;
    private float Field3740 = 1.0f;
    private float Field3741 = 1.0f;
    private Color Field3742 = new Color(this.Field3738, this.Field3739, this.Field3740, this.Field3741);

    public Color Method2159059() {
        return this.Field3742;
    }

    public void Method2159050(Color color) {
        this.Field3742 = color;
    }

    public int Method2159061() {
        return ColorUtil.Method2163384(this.Field3742);
    }

    public int Method2159062() {
        return ColorUtil.Method2163384(new Color(this.Field3742.getRed(), this.Field3742.getGreen(), this.Field3742.getBlue(), 255));
    }

    public int Method2159063(int n2) {
        return ColorUtil.Method2163384(new Color(this.Field3738, this.Field3739, this.Field3740, (float) n2 / 255.0f));
    }

    public void Method2159064(float f, float f2, float f3, float f4) {
        this.Field3738 = f;
        this.Field3739 = f2;
        this.Field3740 = f3;
        this.Field3741 = f4;
        this.Method2159065();
    }

    public void Method2159065() {
        this.Method2159050(new Color(this.Field3738, this.Field3739, this.Field3740, this.Field3741));
    }

    public void Method2159066(int n2, int n3, int n4, int n5) {
        this.Field3738 = (float) n2 / 255.0f;
        this.Field3739 = (float) n3 / 255.0f;
        this.Field3740 = (float) n4 / 255.0f;
        this.Field3741 = (float) n5 / 255.0f;
        this.Method2159065();
    }

    public void Method2159067(float f) {
        this.Field3738 = f;
        this.Method2159065();
    }

    public void Method2159068(float f) {
        this.Field3739 = f;
        this.Method2159065();
    }

    public void Method2159069(float f) {
        this.Field3740 = f;
        this.Method2159065();
    }

    public void Method2159060(float f) {
        this.Field3741 = f;
        this.Method2159065();
    }
}

