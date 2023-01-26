/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;

public class ColorUtil2 {
    public ColorUtil2(int n2, int n3, int n4, int n5) {
    }

    public static Color Method2164208(Color color) {
        int n2;
        int n3;
        int n4 = color.getAlpha();
        int n5 = 255 - color.getRed();
        if (n5 + (n3 = 255 - color.getGreen()) + (n2 = 255 - color.getBlue()) > 740 || n5 + n3 + n2 < 20) {
            return new Color(255, 255, 40, n4);
        }
        return new Color(n5, n3, n2, n4);
    }

    public static int Method2164209(int n2, int n3, int n4, int n5) {
        return new Color(n2, n3, n4, n5).getRGB();
    }

    public static int Method2164200(int n2, int n3, int n4) {
        return ColorUtil2.Method2164311(n2, n3, n4, 255);
    }

    public static int Method2164311(int n2, int n3, int n4, int n5) {
        return (n2 << 16) + (n3 << 8) + n4 + (n5 << 24);
    }

    public static int Method2164312(float f, float f2, float f3, float f4) {
        return ColorUtil2.Method2164311((int) (f * 255.0f), (int) (f2 * 255.0f), (int) (f3 * 255.0f), (int) (f4 * 255.0f));
    }

    public static Color Method2164313(int n2) {
        double d = Math.ceil((double) (System.currentTimeMillis() + (long) n2) / 20.0);
        return Color.getHSBColor((float) ((d %= 360.0) / 360.0), Global.Method2150598().Field1142.getValue().floatValue() / 255.0f, Global.Method2150598().Field1141.getValue().floatValue() / 255.0f);
    }

    public static Color Method2164314(int n2) {
        double d = Math.ceil((double) (System.currentTimeMillis() + (long) n2) / 20.0);
        return Color.getHSBColor((float) ((d %= 360.0) / 360.0), AutoCrystal.Method2150936().Field107.getValue().floatValue() / 255.0f, AutoCrystal.Method2150936().Field106.getValue().floatValue() / 255.0f);
    }

    public static Color Method2164315(int n2) {
        double d = Math.ceil((double) (System.currentTimeMillis() + (long) n2) / 20.0);
        return Color.getHSBColor((float) ((d %= 360.0) / 360.0), AliceAura.Method2150751().Field4107.getValue().floatValue() / 255.0f, AliceAura.Method2150751().Field4106.getValue().floatValue() / 255.0f);
    }

    public static int Method2164316(float[] arrf) {
        if (arrf.length != 4) {
            throw new IllegalArgumentException("colors[] must have a length of 4!");
        }
        return ColorUtil2.Method2164312(arrf[0], arrf[1], arrf[2], arrf[3]);
    }

    public static int Method2164317(double[] arrd) {
        if (arrd.length != 4) {
            throw new IllegalArgumentException("colors[] must have a length of 4!");
        }
        return ColorUtil2.Method2164312((float) arrd[0], (float) arrd[1], (float) arrd[2], (float) arrd[3]);
    }

    public static int Method2164318(Color color) {
        return ColorUtil2.Method2164311(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}

