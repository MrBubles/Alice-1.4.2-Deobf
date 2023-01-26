/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;

public class ColorManager {
    private float Field3173 = 1.0f;
    private float Field3174 = 1.0f;
    private float Field3175 = 1.0f;
    private float Field3176 = 1.0f;
    private Color Field3177 = new Color(this.Field3173, this.Field3174, this.Field3175, this.Field3176);
    private float Field3178 = 1.0f;
    private float Field3179 = 1.0f;
    private float Field3180 = 1.0f;
    private float Field3181 = 1.0f;
    private Color Field3182 = new Color(this.Field3178, this.Field3179, this.Field3180, this.Field3181);

    public Color Method2159035() {
        return this.Field3177;
    }

    public void Method2159036(Color color) {
        this.Field3177 = color;
    }

    public int Method2159037() {
        return ColorUtil.Method2163384(this.Field3177);
    }

    public int Method2159038() {
        return ColorUtil.Method2163384(new Color(this.Field3177.getRed(), this.Field3177.getGreen(), this.Field3177.getBlue(), 255));
    }

    public int Method2159039(int n2) {
        return ColorUtil.Method2163384(new Color(this.Field3173, this.Field3174, this.Field3175, (float) n2 / 255.0f));
    }

    public void Method2159030(float f, float f2, float f3, float f4) {
        this.Field3173 = f;
        this.Field3174 = f2;
        this.Field3175 = f3;
        this.Field3176 = f4;
        this.Method2159041();
    }

    public void Method2159041() {
        this.Method2159036(new Color(this.Field3173, this.Field3174, this.Field3175, this.Field3176));
    }

    public void Method2159042(int n2, int n3, int n4, int n5) {
        this.Field3173 = (float) n2 / 255.0f;
        this.Field3174 = (float) n3 / 255.0f;
        this.Field3175 = (float) n4 / 255.0f;
        this.Field3176 = (float) n5 / 255.0f;
        this.Method2159041();
    }

    public void Method2159043(float f) {
        this.Field3173 = f;
        this.Method2159041();
    }

    public void Method2159044(float f) {
        this.Field3174 = f;
        this.Method2159041();
    }

    public void Method2159045(float f) {
        this.Field3175 = f;
        this.Method2159041();
    }

    public void Method2159046(float f) {
        this.Field3176 = f;
        this.Method2159041();
    }

    public Color Method2159047() {
        return this.Field3182;
    }

    public void Method2159048(Color color) {
        this.Field3182 = color;
    }

    public int Method2159049() {
        return ColorUtil.Method2163384(this.Field3182);
    }

    public int Method2159040() {
        return ColorUtil.Method2163384(new Color(this.Field3182.getRed(), this.Field3182.getGreen(), this.Field3182.getBlue(), 255));
    }

    public int Method2159051(int n2) {
        return ColorUtil.Method2163384(new Color(this.Field3178, this.Field3179, this.Field3180, (float) n2 / 255.0f));
    }

    public void Method2159052(float f, float f2, float f3, float f4) {
        this.Field3178 = f;
        this.Field3179 = f2;
        this.Field3180 = f3;
        this.Field3181 = f4;
        this.Method2159053();
    }

    public void Method2159053() {
        this.Method2159048(new Color(this.Field3178, this.Field3179, this.Field3180, this.Field3181));
    }

    public void Method2159054(int n2, int n3, int n4, int n5) {
        this.Field3178 = (float) n2 / 255.0f;
        this.Field3179 = (float) n3 / 255.0f;
        this.Field3180 = (float) n4 / 255.0f;
        this.Field3181 = (float) n5 / 255.0f;
        this.Method2159053();
    }

    public void Method2159055(float f) {
        this.Field3178 = f;
        this.Method2159053();
    }

    public void Method2159056(float f) {
        this.Field3179 = f;
        this.Method2159053();
    }

    public void Method2159057(float f) {
        this.Field3180 = f;
        this.Method2159053();
    }

    public void Method2159058(float f) {
        this.Field3181 = f;
        this.Method2159053();
    }
}

