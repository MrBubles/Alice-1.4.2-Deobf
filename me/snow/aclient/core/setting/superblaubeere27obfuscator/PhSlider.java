/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhComponent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import org.lwjgl.input.Mouse;

public class PhSlider
        extends PhButton {
    private final Number Field2924;
    private final Number Field2925;
    private final int Field2926;
    public Setting Field2927;

    public PhSlider(Setting setting) {
        super(setting.getName());
        this.Field2927 = setting;
        this.Field2924 = (Number) setting.getMin();
        this.Field2925 = (Number) setting.getMax();
        this.Field2926 = this.Field2925.intValue() - this.Field2924.intValue();
        this.Field1218 = 15;
    }

    @Override
    public void Method2159983(int n2, int n3, float f) {
        this.Method2159972(n2, n3);
        RenderUtil.Method2163027(this.Field1216, this.Field1217, this.Field1216 + (float) this.Field1218 + 7.4f, this.Field1217 + (float) this.Field1219 - 0.5f, !this.Method2159969(n2, n3) ? 0x11555555 : -2007673515);
        if (ClickGuiP.Method2150571().Field3254.getValue().booleanValue()) {
            int n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217 + this.Field1219, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue());
            RenderUtil.Method2163905(this.Field1216, this.Field1217, ((Number) this.Field2927.getValue()).floatValue() <= this.Field2924.floatValue() ? 0.0f : ((float) this.Field1218 + 7.4f) * this.Method2159976(), (float) this.Field1219 - 0.5f, !this.Method2159969(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)) : n4, !this.Method2159969(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)) : n5);
        } else {
            RenderUtil.Method2163027(this.Field1216, this.Field1217, ((Number) this.Field2927.getValue()).floatValue() <= this.Field2924.floatValue() ? this.Field1216 : this.Field1216 + ((float) this.Field1218 + 7.4f) * this.Method2159976(), this.Field1217 + (float) this.Field1219 - 0.5f, !this.Method2159969(n2, n3) ? AliceMain.Field783.Method2159075(AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue()) : AliceMain.Field783.Method2159075(AliceMain.Field756.Method2150180(ClickGuiP.class).Field3260.getValue()));
        }
        AliceMain.Field766.Method2150317(this.Method2150361() + " \u00a77" + (this.Field2927.getValue() instanceof Float ? (Number) ((Number) this.Field2927.getValue()) : (Number) ((Number) this.Field2927.getValue()).doubleValue()), this.Field1216 + 2.3f, this.Field1217 - 1.7f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
    }

    @Override
    public void Method2159984(int n2, int n3, int n4) {
        super.Method2159984(n2, n3, n4);
        if (this.Method2159969(n2, n3)) {
            this.Method2159973(n2);
        }
    }

    @Override
    public boolean Method2159969(int n2, int n3) {
        for (PhComponent phComponent : PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!phComponent.Field1367) continue;
            return false;
        }
        return (float) n2 >= this.Method2159988() && (float) n2 <= this.Method2159988() + (float) this.Method2159980() + 8.0f && (float) n3 >= this.Method2159989() && (float) n3 <= this.Method2159989() + (float) this.Field1219;
    }

    @Override
    public void Method2159986() {
        this.Method2159995(this.Field2927.isVisible());
    }

    private void Method2159972(int n2, int n3) {
        if (this.Method2159969(n2, n3) && Mouse.isButtonDown((int) 0)) {
            this.Method2159973(n2);
        }
    }

    @Override
    public int Method2159992() {
        return 14;
    }

    private void Method2159973(int n2) {
        float f = ((float) n2 - this.Field1216) / ((float) this.Field1218 + 7.4f);
        if (this.Field2927.getValue() instanceof Double) {
            double d = (Double) this.Field2927.getMin() + (double) ((float) this.Field2926 * f);
            this.Field2927.setValue((double) Math.round(10.0 * d) / 10.0);
        } else if (this.Field2927.getValue() instanceof Float) {
            float f2 = ((Float) this.Field2927.getMin()).floatValue() + (float) this.Field2926 * f;
            this.Field2927.setValue(Float.valueOf((float) Math.round(10.0f * f2) / 10.0f));
        } else if (this.Field2927.getValue() instanceof Integer) {
            this.Field2927.setValue((Integer) this.Field2927.getMin() + (int) ((float) this.Field2926 * f));
        }
    }

    private float Method2159974() {
        return this.Field2925.floatValue() - this.Field2924.floatValue();
    }

    private float Method2159975() {
        return ((Number) this.Field2927.getValue()).floatValue() - this.Field2924.floatValue();
    }

    private float Method2159976() {
        return this.Method2159975() / this.Method2159974();
    }
}

