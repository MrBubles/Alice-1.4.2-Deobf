/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.TurokString;

public class TurokFloat {
    private TurokString Field2194;
    private TurokString Field2195;
    private float Field2196;
    private float Field2197;
    private float Field2198;

    public TurokFloat(TurokString turokString, TurokString turokString2, float f, float f2, float f3) {
        this.Field2194 = turokString;
        this.Field2195 = turokString2;
        this.Field2197 = f3;
        this.Field2198 = f2;
    }

    public void Method2164830(float f) {
        this.Field2196 = f;
    }

    public void Method2164841(float f) {
        this.Field2196 = f >= this.Field2197 ? this.Field2197 : (f <= this.Field2198 ? this.Field2198 : f);
    }

    public TurokString Method2164842() {
        return this.Field2194;
    }

    public TurokString Method2164843() {
        return this.Field2195;
    }

    public float Method2164844() {
        return this.Field2196;
    }
}

