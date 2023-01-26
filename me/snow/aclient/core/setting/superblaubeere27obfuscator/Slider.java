/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Button;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Component;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import org.lwjgl.input.Mouse;

public class Slider
        extends Button {
    private final Number Field1463;
    private final Number Field1464;
    private final int Field1465;
    public Setting Field1466;

    public Slider(Setting setting) {
        super(setting.getName());
        this.Field1466 = setting;
        this.Field1463 = (Number) setting.getMin();
        this.Field1464 = (Number) setting.getMax();
        this.Field1465 = this.Field1464.intValue() - this.Field1463.intValue();
        this.Field1239 = 15;
    }

    @Override
    public void Method2159915(int n2, int n3, float f) {
        int n4;
        this.Method2159804(n2, n3);
        RenderUtil.Method2163027(this.Field1237, this.Field1238, this.Field1237 + (float) this.Field1239 + 7.4f, this.Field1238 + (float) this.Field1240 - 0.5f, !this.Method2159890(n2, n3) ? 0x11555555 : -2007673515);
        if (ClickGui2.Method2150488().Field1682.getValue().booleanValue()) {
            n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238 + this.Field1240, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue());
            RenderUtil.Method2163905(this.Field1237, this.Field1238, ((Number) this.Field1466.getValue()).floatValue() <= this.Field1463.floatValue() ? 0.0f : ((float) this.Field1239 + 7.4f) * this.Method2159808(), (float) this.Field1240 - 0.5f, !this.Method2159890(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)) : n4, !this.Method2159890(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)) : n5);
        } else {
            RenderUtil.Method2163027(this.Field1237, this.Field1238, ((Number) this.Field1466.getValue()).floatValue() <= this.Field1463.floatValue() ? this.Field1237 : this.Field1237 + ((float) this.Field1239 + 7.4f) * this.Method2159808(), this.Field1238 + (float) this.Field1240 - 0.5f, !this.Method2159890(n2, n3) ? AliceMain.Field786.Method2159063(AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue()) : AliceMain.Field786.Method2159063(AliceMain.Field756.Method2150180(ClickGui2.class).Field1696.getValue()));
        }
        if (ClickGui2.Method2150488().Field1711.getValue().booleanValue()) {
            n4 = ColorUtil.Method2163370(ClickGui2.Method2150488().Field1712.getValue(), ClickGui2.Method2150488().Field1713.getValue(), ClickGui2.Method2150488().Field1714.getValue(), ClickGui2.Method2150488().Field1715.getValue());
            RenderUtil.Method2163027(this.Field1237, this.Field1238, this.Field1237 + 1.0f, this.Field1238 + (float) this.Field1240 + 0.5f, n4);
        }
        AliceMain.Field766.Method2150317(this.Method2150361() + " \u00a77" + (this.Field1466.getValue() instanceof Float ? (Number) ((Number) this.Field1466.getValue()) : (Number) ((Number) this.Field1466.getValue()).doubleValue()), this.Field1237 + 2.3f, this.Field1238 - 1.7f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
    }

    @Override
    public void Method2159916(int n2, int n3, int n4) {
        super.Method2159916(n2, n3, n4);
        if (this.Method2159890(n2, n3)) {
            this.Method2159805(n2);
        }
    }

    @Override
    public boolean Method2159890(int n2, int n3) {
        for (Component component : LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!component.Field4520) continue;
            return false;
        }
        return (float) n2 >= this.Method2159910() && (float) n2 <= this.Method2159910() + (float) this.Method2159922() + 8.0f && (float) n3 >= this.Method2159921() && (float) n3 <= this.Method2159921() + (float) this.Field1240;
    }

    @Override
    public void Method2159918() {
        this.Method2159927(this.Field1466.isVisible());
    }

    private void Method2159804(int n2, int n3) {
        if (this.Method2159890(n2, n3) && Mouse.isButtonDown((int) 0)) {
            this.Method2159805(n2);
        }
    }

    @Override
    public int Method2159924() {
        return 14;
    }

    private void Method2159805(int n2) {
        float f = ((float) n2 - this.Field1237) / ((float) this.Field1239 + 7.4f);
        if (this.Field1466.getValue() instanceof Double) {
            double d = (Double) this.Field1466.getMin() + (double) ((float) this.Field1465 * f);
            this.Field1466.setValue((double) Math.round(10.0 * d) / 10.0);
        } else if (this.Field1466.getValue() instanceof Float) {
            float f2 = ((Float) this.Field1466.getMin()).floatValue() + (float) this.Field1465 * f;
            this.Field1466.setValue(Float.valueOf((float) Math.round(10.0f * f2) / 10.0f));
        } else if (this.Field1466.getValue() instanceof Integer) {
            this.Field1466.setValue((Integer) this.Field1466.getMin() + (int) ((float) this.Field1465 * f));
        }
    }

    private float Method2159806() {
        return this.Field1464.floatValue() - this.Field1463.floatValue();
    }

    private float Method2159807() {
        return ((Number) this.Field1466.getValue()).floatValue() - this.Field1463.floatValue();
    }

    private float Method2159808() {
        return this.Method2159807() / this.Method2159806();
    }
}

