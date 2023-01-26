

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Random;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;

public class Snow {
    private int Field4610;
    private int Field4611;
    private int Field4612;
    private int Field4613;

    public Snow(int n2, int n3, int n4, int n5) {
        this.Field4610 = n2;
        this.Field4611 = n3;
        this.Field4612 = n4;
        this.Field4613 = n5;
    }

    public int Method2159947() {
        return this.Field4610;
    }

    public void Method2159948(int n2) {
        this.Field4610 = n2;
    }

    public int Method2159949() {
        return this.Field4611;
    }

    public void Method2159940(int n2) {
        this.Field4611 = n2;
    }

    public void Method2159951(ScaledResolution scaledResolution) {
        RenderUtil.Method2163027(this.Method2159947(), this.Method2159949(), this.Method2159947() + this.Field4613, this.Method2159949() + this.Field4613, -1714829883);
        this.Method2159940(this.Method2159949() + this.Field4612);
        if (this.Method2159949() > scaledResolution.getScaledHeight() + 10 || this.Method2159949() < -10) {
            this.Method2159940(-10);
            Random random = new Random();
            this.Field4612 = random.nextInt(5) + 1;
            this.Field4613 = random.nextInt(4) + 1;
        }
    }
}

