

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

public class Snow1 {
    private int Field3398;
    private int Field3399;
    private int Field3400;
    private int Field3401;

    public Snow1(int n2, int n3, int n4, int n5) {
        this.Field3398 = n2;
        this.Field3399 = n3;
        this.Field3400 = n4;
        this.Field3401 = n5;
    }

    public int Method2159865() {
        return this.Field3398;
    }

    public void Method2159866(int n2) {
        this.Field3398 = n2;
    }

    public int Method2159867() {
        return this.Field3399;
    }

    public void Method2159868(int n2) {
        this.Field3399 = n2;
    }

    public void Method2159869(ScaledResolution scaledResolution) {
        RenderUtil.Method2163027(this.Method2159865(), this.Method2159867(), this.Method2159865() + this.Field3401, this.Method2159867() + this.Field3401, -1714829883);
        this.Method2159868(this.Method2159867() + this.Field3400);
        if (this.Method2159867() > scaledResolution.getScaledHeight() + 10 || this.Method2159867() < -10) {
            this.Method2159868(-10);
            Random random = new Random();
            this.Field3400 = random.nextInt(5) + 1;
            this.Field3401 = random.nextInt(4) + 1;
        }
    }
}

