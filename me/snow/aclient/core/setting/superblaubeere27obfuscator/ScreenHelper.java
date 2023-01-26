

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AnimationHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathematicHelper;
import net.minecraft.client.Minecraft;

public class ScreenHelper {
    private float Field1624;
    private float Field1625;
    private long Field1626;

    public ScreenHelper(float f, float f2) {
        this.Field1624 = f;
        this.Field1625 = f2;
        this.Field1626 = System.currentTimeMillis();
    }

    public static double Method2163722(double d, double d2, double d3) {
        boolean bl = d > d2;
        boolean bl2 = bl;
        if (d3 < 0.0) {
            d3 = 0.0;
        } else if (d3 > 1.0) {
            d3 = 1.0;
        }
        double d4 = Math.max(d, d2) - Math.min(d, d2);
        double d5 = d4 * d3;
        if (d5 < 0.1) {
            d5 = 0.1;
        }
        d2 = bl ? (d2 = d2 + d5) : (d2 = d2 - d5);
        return d2;
    }

    public static double Method2163723(double d, double d2, double d3) {
        double d4 = Math.abs(d - d2);
        int n2 = Minecraft.getDebugFPS();
        if (d4 > 0.0) {
            double d5 = MathematicHelper.Method2163668(Math.min(10.0, Math.max(0.05, 144.0 / (double) n2 * (d4 / 10.0) * d3)), 0.05);
            if (d4 < d5) {
                d5 = d4;
            }
            if (d < d2) {
                return d + d5;
            }
            if (d > d2) {
                return d - d5;
            }
        }
        return d;
    }

    public static double Method2163724(double d, double d2, double d3) {
        double d4 = Math.abs(d - d2);
        int n2 = Minecraft.getDebugFPS();
        if (d4 > 0.0) {
            double d5 = MathematicHelper.Method2163668(Math.min(10.0, Math.max(0.005, 144.0 / (double) n2 * d3)), 0.005);
            if (d4 != 0.0 && d4 < d5) {
                d5 = d4;
            }
            if (d < d2) {
                return d + d5;
            }
            if (d > d2) {
                return d - d5;
            }
        }
        return d;
    }

    public void Method2163725(float f, float f2, double d) {
        long l2 = System.currentTimeMillis();
        long l3 = l2 - this.Field1626;
        this.Field1626 = l2;
        double d2 = 0.0;
        double d3 = 0.0;
        if (d != 0.0) {
            d2 = (double) (Math.abs(f - this.Field1624) * 0.35f) / (10.0 / d);
            d3 = (double) (Math.abs(f2 - this.Field1625) * 0.35f) / (10.0 / d);
        }
        this.Field1624 = AnimationHelper.Method2163665(f, this.Field1624, l3, d2);
        this.Field1625 = AnimationHelper.Method2163665(f2, this.Field1625, l3, d3);
    }

    public void Method2163726(float f, float f2, float f3, float f4) {
        int n2 = (int) (Math.abs(f - this.Field1624) * f3);
        int n3 = (int) (Math.abs(f2 - this.Field1625) * f4);
        this.Field1624 = AnimationHelper.Method2163665(f, this.Field1624, 1L / (long) Minecraft.getDebugFPS(), n2);
        this.Field1625 = AnimationHelper.Method2163665(f2, this.Field1625, 1L / (long) Minecraft.getDebugFPS(), n3);
    }

    public float Method2163727() {
        return this.Field1624;
    }

    public void Method2163728(float f) {
        this.Field1624 = f;
    }

    public float Method2163729() {
        return this.Field1625;
    }

    public void Method2163720(float f) {
        this.Field1625 = f;
    }
}

