

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.minecraft.util.math.MathHelper;

public class MathematicHelper {
    public static BigDecimal Method2163666(float f, int n2) {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(n2, RoundingMode.HALF_UP);
        return bigDecimal;
    }

    public static int Method2163667(int n2, int n3) {
        return (n2 + n3) / 2;
    }

    public static double Method2163668(double d, double d2) {
        double d3 = (double) Math.round(d / d2) * d2;
        BigDecimal bigDecimal = new BigDecimal(d3);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static float Method2163669(float f, float f2, float f3) {
        float f4 = MathHelper.wrapDegrees((float) (f - f2));
        if (f4 < -f3) {
            f4 = -f3;
        }
        if (f4 >= f3) {
            f4 = f3;
        }
        return f - f4;
    }

    public static float Method2163660(float f, float f2, float f3) {
        if (f <= f2) {
            f = f2;
        }
        if (f >= f3) {
            f = f3;
        }
        return f;
    }

    public static float Method2163671(float f, float f2) {
        return (float) ((double) f + (double) (f2 - f) * Math.random());
    }
}

