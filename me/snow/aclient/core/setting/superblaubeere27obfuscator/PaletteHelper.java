/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

public class PaletteHelper {
    public static int Method2163672(float f, float f2) {
        return Color.HSBtoRGB(Math.max(0.0f, Math.min(f, f2) / f2) / 3.0f, 1.0f, 0.8f) | 0xFF000000;
    }

    public static int Method2163673(Color color) {
        return PaletteHelper.Method2163675(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public static int Method2163674(int n2) {
        return PaletteHelper.Method2163675(n2, n2, n2, 255);
    }

    public static int Method2163675(int n2, int n3, int n4, int n5) {
        int n6 = 0;
        n6 |= n5 << 24;
        n6 |= n2 << 16;
        n6 |= n3 << 8;
        return n6 |= n4;
    }

    public static Color Method2163676(boolean bl, int n2) {
        float f;
        float f2 = bl ? 3500.0f : 3000.0f;
        float f3 = System.currentTimeMillis() % (long) ((int) f2) + (long) n2;
        if (f3 > f2) {
            f3 -= f2;
        }
        f3 /= f2;
        if (f > 0.5f) {
            f3 = 0.5f - (f3 - 0.5f);
        }
        return Color.getHSBColor(f3 += 0.5f, 0.4f, 1.0f);
    }

    public static Color Method2163677() {
        float f;
        float f2 = 3000.0f;
        float f3 = System.currentTimeMillis() % (long) ((int) f2) + 1L;
        if (f3 > f2) {
            f3 -= f2;
        }
        f3 /= f2;
        if (f > 0.5f) {
            f3 = 0.5f - (f3 - 0.5f);
        }
        return new Color(Color.getHSBColor(f3 += 0.5f, 0.4f, 1.0f).getRed(), Color.getHSBColor(f3, 0.4f, 1.0f).getGreen(), Color.getHSBColor(f3, 0.4f, 1.0f).getBlue(), 100);
    }

    public static int Method2163678(int n2, int n3) {
        return PaletteHelper.Method2163675(n2, n2, n2, n3);
    }

    public static Color Method2163679(int n2, float f, float f2) {
        double d = Math.ceil((System.currentTimeMillis() + (long) n2) / 16L);
        return Color.getHSBColor((float) ((d %= 360.0) / 360.0), f, f2);
    }

    public static int Method2163670(int n2, int n3, float f) {
        if (f > 1.0f) {
            f = 1.0f - f % 1.0f;
        }
        return PaletteHelper.Method2163681(n2, n3, f);
    }

    public static int Method2163681(int n2, int n3, float f) {
        float f2 = 1.0f - f;
        int n4 = (int) ((float) (n2 >> 16 & 0xFF) * f2 + (float) (n3 >> 16 & 0xFF) * f);
        int n5 = (int) ((float) (n2 >> 8 & 0xFF) * f2 + (float) (n3 >> 8 & 0xFF) * f);
        int n6 = (int) ((float) (n2 & 0xFF) * f2 + (float) (n3 & 0xFF) * f);
        int n7 = (int) ((float) (n2 >> 24 & 0xFF) * f2 + (float) (n3 >> 24 & 0xFF) * f);
        return (n7 & 0xFF) << 24 | (n4 & 0xFF) << 16 | (n5 & 0xFF) << 8 | n6 & 0xFF;
    }
}

