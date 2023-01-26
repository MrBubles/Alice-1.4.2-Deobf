/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.TurokString;

public class TurokDouble {
    private TurokString Field2108;
    private TurokString Field2109;
    private double Field2110;
    private double Field2111;
    private double Field2112;

    public TurokDouble(TurokString turokString, TurokString turokString2, double d, double d2, double d3) {
        this.Field2108 = turokString;
        this.Field2109 = turokString2;
        this.Field2110 = d;
        this.Field2111 = d3;
        this.Field2112 = d2;
    }

    public static double Method2164837(double d) {
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static double Method2164838(double d, double d2) {
        d = Math.floor(d);
        d2 = Math.floor(d2);
        if (d == 0.0 || d2 == 0.0) {
            return d + d2;
        }
        return TurokDouble.Method2164838(d, d % d2);
    }

    public static double Method2164839(double d, double d2) {
        double d3 = TurokDouble.Method2164838(d, d2);
        if (d3 > d2) {
            d3 = d2 / 20.0;
        }
        if (d2 > 10.0) {
            d3 = Math.round(d3);
        }
        if (d3 == 0.0) {
            d3 = d2;
        }
        return d3;
    }

    public void Method2164832(double d) {
        this.Field2110 = d;
    }

    public void Method2164833(double d) {
        this.Field2110 = d >= this.Field2111 ? this.Field2111 : (d <= this.Field2112 ? this.Field2112 : d);
    }

    public TurokString Method2164834() {
        return this.Field2108;
    }

    public TurokString Method2164835() {
        return this.Field2109;
    }

    public double Method2164836() {
        return this.Field2110;
    }
}

