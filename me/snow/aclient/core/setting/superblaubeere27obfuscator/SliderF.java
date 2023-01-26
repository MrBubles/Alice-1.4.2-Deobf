/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ComponentF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import org.lwjgl.input.Mouse;

public class SliderF
        extends ButtonF {
    private final Number Field1618;
    private final Number Field1619;
    private final int Field1620;
    public Setting Field1621;

    public SliderF(Setting setting) {
        super(setting.getName());
        this.Field1621 = setting;
        this.Field1618 = (Number) setting.getMin();
        this.Field1619 = (Number) setting.getMax();
        this.Field1620 = this.Field1619.intValue() - this.Field1618.intValue();
        this.Field1551 = 15;
    }

    @Override
    public void Method2159752(int n2, int n3, float f) {
        this.Method2159741(n2, n3);
        RenderUtil.Method2163027(this.Field1549, this.Field1550, this.Field1549 + (float) this.Field1551 + 7.4f, this.Field1550 + (float) this.Field1552 - 0.5f, !this.Method2159736(n2, n3) ? 0x11555555 : -2007673515);
        RenderUtil.Method2163027(this.Field1549, this.Field1550, ((Number) this.Field1621.getValue()).floatValue() <= this.Field1618.floatValue() ? this.Field1549 : this.Field1549 + ((float) this.Field1551 + 7.4f) * this.Method2159745(), this.Field1550 + (float) this.Field1552 - 0.5f, !this.Method2159736(n2, n3) ? AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3246.getValue()) : AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3247.getValue()));
        AliceMain.Field766.Method2150317(this.Method2150361() + " \u00a77" + (this.Field1621.getValue() instanceof Float ? (Number) ((Number) this.Field1621.getValue()) : (Number) ((Number) this.Field1621.getValue()).doubleValue()), this.Field1549 + 2.3f, this.Field1550 - 1.7f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
    }

    @Override
    public void Method2159753(int n2, int n3, int n4) {
        super.Method2159753(n2, n3, n4);
        if (this.Method2159736(n2, n3)) {
            this.Method2159742(n2);
        }
    }

    @Override
    public boolean Method2159736(int n2, int n3) {
        for (ComponentF componentF : FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!componentF.Field2076) continue;
            return false;
        }
        return (float) n2 >= this.Method2159757() && (float) n2 <= this.Method2159757() + (float) this.Method2159759() + 8.0f && (float) n3 >= this.Method2159758() && (float) n3 <= this.Method2159758() + (float) this.Field1552;
    }

    @Override
    public void Method2159755() {
        this.Method2159764(this.Field1621.isVisible());
    }

    private void Method2159741(int n2, int n3) {
        if (this.Method2159736(n2, n3) && Mouse.isButtonDown((int) 0)) {
            this.Method2159742(n2);
        }
    }

    @Override
    public int Method2159761() {
        return 14;
    }

    private void Method2159742(int n2) {
        float f = ((float) n2 - this.Field1549) / ((float) this.Field1551 + 7.4f);
        if (this.Field1621.getValue() instanceof Double) {
            double d = (Double) this.Field1621.getMin() + (double) ((float) this.Field1620 * f);
            this.Field1621.setValue((double) Math.round(10.0 * d) / 10.0);
        } else if (this.Field1621.getValue() instanceof Float) {
            float f2 = ((Float) this.Field1621.getMin()).floatValue() + (float) this.Field1620 * f;
            this.Field1621.setValue(Float.valueOf((float) Math.round(10.0f * f2) / 10.0f));
        } else if (this.Field1621.getValue() instanceof Integer) {
            this.Field1621.setValue((Integer) this.Field1621.getMin() + (int) ((float) this.Field1620 * f));
        }
    }

    private float Method2159743() {
        return this.Field1619.floatValue() - this.Field1618.floatValue();
    }

    private float Method2159744() {
        return ((Number) this.Field1621.getValue()).floatValue() - this.Field1618.floatValue();
    }

    private float Method2159745() {
        return this.Method2159744() / this.Method2159743();
    }
}

