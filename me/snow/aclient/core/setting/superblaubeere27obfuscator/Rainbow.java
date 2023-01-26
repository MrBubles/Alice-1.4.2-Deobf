/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

public class Rainbow {
    public static int Method2163945(float f, float f2, float f3) {
        float f4 = (float) (System.currentTimeMillis() % 11520L) / 11520.0f * f;
        return Color.HSBtoRGB(f4, f2, f3);
    }

    public static Color Method2163946(float f, float f2, float f3) {
        return new Color(Rainbow.Method2163945(f, f2, f3));
    }

    public static Color Method2163947(float f, float f2, float f3, long l2) {
        return new Color(Rainbow.Method2163948(f, f2, f3, l2));
    }

    public static int Method2163948(float f, float f2, float f3, long l2) {
        float f4 = (float) ((System.currentTimeMillis() + l2) % 11520L) / 11520.0f * f;
        return Color.HSBtoRGB(f4, f2, f3);
    }
}

