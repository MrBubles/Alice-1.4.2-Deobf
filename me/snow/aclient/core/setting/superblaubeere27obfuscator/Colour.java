

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import net.minecraft.client.renderer.GlStateManager;

public class Colour
        extends Color {
    public Colour(int n2, int n3, int n4) {
        super(n2, n3, n4);
    }

    public Colour(int n2) {
        super(n2);
    }

    public Colour(int n2, boolean bl) {
        super(n2, bl);
    }

    public Colour(int n2, int n3, int n4, int n5) {
        super(n2, n3, n4, n5);
    }

    public Colour(Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public Colour(Colour colour, int n2) {
        super(colour.getRed(), colour.getGreen(), colour.getBlue(), n2);
    }

    public static Colour Method2162067(float f, float f2, float f3) {
        return new Colour(Color.getHSBColor(f, f2, f3));
    }

    public float Method2162068() {
        return Colour.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[0];
    }

    public float Method2162069() {
        return Colour.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[1];
    }

    public float Method2162060() {
        return Colour.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null)[2];
    }

    public void Method2162071() {
        GlStateManager.color((float) ((float) this.getRed() / 255.0f), (float) ((float) this.getGreen() / 255.0f), (float) ((float) this.getBlue() / 255.0f), (float) ((float) this.getAlpha() / 255.0f));
    }
}

