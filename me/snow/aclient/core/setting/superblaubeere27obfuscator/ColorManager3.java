/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;

public class ColorManager3 {
    private float Field3728 = 1.0f;
    private float Field3729 = 1.0f;
    private float Field3730 = 1.0f;
    private float Field3731 = 1.0f;
    private Color Field3732 = new Color(this.Field3728, this.Field3729, this.Field3730, this.Field3731);
    private float Field3733 = 1.0f;
    private float Field3734 = 1.0f;
    private float Field3735 = 1.0f;
    private float Field3736 = 1.0f;
    private Color Field3737 = new Color(this.Field3733, this.Field3734, this.Field3735, this.Field3736);

    public Color Method2159071() {
        return this.Field3732;
    }

    public void Method2159072(Color color) {
        this.Field3732 = color;
    }

    public int Method2159073() {
        return ColorUtil.Method2163384(this.Field3732);
    }

    public int Method2159074() {
        return ColorUtil.Method2163384(new Color(this.Field3732.getRed(), this.Field3732.getGreen(), this.Field3732.getBlue(), 255));
    }

    public int Method2159075(int n2) {
        return ColorUtil.Method2163384(new Color(this.Field3728, this.Field3729, this.Field3730, (float) n2 / 255.0f));
    }

    public void Method2159076(float f, float f2, float f3, float f4) {
        this.Field3728 = f;
        this.Field3729 = f2;
        this.Field3730 = f3;
        this.Field3731 = f4;
        this.Method2159077();
    }

    public void Method2159077() {
        this.Method2159072(new Color(this.Field3728, this.Field3729, this.Field3730, this.Field3731));
    }

    public void Method2159078(int n2, int n3, int n4, int n5) {
        this.Field3728 = (float) n2 / 255.0f;
        this.Field3729 = (float) n3 / 255.0f;
        this.Field3730 = (float) n4 / 255.0f;
        this.Field3731 = (float) n5 / 255.0f;
        this.Method2159077();
    }

    public void Method2159079(float f) {
        this.Field3728 = f;
        this.Method2159077();
    }

    public void Method2159070(float f) {
        this.Field3729 = f;
        this.Method2159077();
    }

    public void Method2159081(float f) {
        this.Field3730 = f;
        this.Method2159077();
    }

    public void Method2159082(float f) {
        this.Field3731 = f;
        this.Method2159077();
    }

    public Color Method2159083() {
        return this.Field3737;
    }

    public void Method2159084(Color color) {
        this.Field3737 = color;
    }

    public int Method2159085() {
        return ColorUtil.Method2163384(this.Field3737);
    }

    public int Method2159086() {
        return ColorUtil.Method2163384(new Color(this.Field3737.getRed(), this.Field3737.getGreen(), this.Field3737.getBlue(), 255));
    }

    public int Method2159087(int n2) {
        return ColorUtil.Method2163384(new Color(this.Field3733, this.Field3734, this.Field3735, (float) n2 / 255.0f));
    }

    public void Method2159088(float f, float f2, float f3, float f4) {
        this.Field3733 = f;
        this.Field3734 = f2;
        this.Field3735 = f3;
        this.Field3736 = f4;
        this.Method2159089();
    }

    public void Method2159089() {
        this.Method2159084(new Color(this.Field3733, this.Field3734, this.Field3735, this.Field3736));
    }

    public void Method2159080(int n2, int n3, int n4, int n5) {
        this.Field3733 = (float) n2 / 255.0f;
        this.Field3734 = (float) n3 / 255.0f;
        this.Field3735 = (float) n4 / 255.0f;
        this.Field3736 = (float) n5 / 255.0f;
        this.Method2159089();
    }

    public void Method2159091(float f) {
        this.Field3733 = f;
        this.Method2159089();
    }

    public void Method2159092(float f) {
        this.Field3734 = f;
        this.Method2159089();
    }

    public void Method2159093(float f) {
        this.Field3735 = f;
        this.Method2159089();
    }

    public void Method2159094(float f) {
        this.Field3736 = f;
        this.Method2159089();
    }
}

