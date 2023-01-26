/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ComponentOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import org.lwjgl.input.Mouse;

public class SliderOld
        extends ButtonOld {
    private final Number Field1577;
    private final Number Field1578;
    private final int Field1579;
    public Setting Field1580;

    public SliderOld(Setting setting) {
        super(setting.getName());
        this.Field1580 = setting;
        this.Field1577 = (Number) setting.getMin();
        this.Field1578 = (Number) setting.getMax();
        this.Field1579 = this.Field1578.intValue() - this.Field1577.intValue();
        this.Field21 = 15;
    }

    @Override
    public void Method2159833(int n2, int n3, float f) {
        int n4;
        this.Method2159822(n2, n3);
        RenderUtil.Method2163027(this.Field19, this.Field20, this.Field19 + (float) this.Field21 + 7.4f, this.Field20 + (float) this.Field22 - 0.5f, !this.Method2159818(n2, n3) ? 0x11555555 : -2007673515);
        if (ClickGui.Method2150300().Field816.getValue().booleanValue()) {
            n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20 + this.Field22, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue());
            RenderUtil.Method2163905(this.Field19, this.Field20, ((Number) this.Field1580.getValue()).floatValue() <= this.Field1577.floatValue() ? 0.0f : ((float) this.Field21 + 7.4f) * this.Method2159826(), (float) this.Field22 - 0.5f, !this.Method2159818(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)) : n4, !this.Method2159818(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)) : n5);
        } else {
            RenderUtil.Method2163027(this.Field19, this.Field20, ((Number) this.Field1580.getValue()).floatValue() <= this.Field1577.floatValue() ? this.Field19 : this.Field19 + ((float) this.Field21 + 7.4f) * this.Method2159826(), this.Field20 + (float) this.Field22 - 0.5f, !this.Method2159818(n2, n3) ? AliceMain.Field767.Method2159039(AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue()) : AliceMain.Field767.Method2159039(AliceMain.Field756.Method2150180(ClickGui.class).Field830.getValue()));
        }
        if (ClickGui.Method2150300().Field847.getValue().booleanValue()) {
            n4 = ColorUtil.Method2163370(ClickGui.Method2150300().Field848.getValue(), ClickGui.Method2150300().Field849.getValue(), ClickGui.Method2150300().Field850.getValue(), ClickGui.Method2150300().Field851.getValue());
            RenderUtil.Method2163027(this.Field19, this.Field20, this.Field19 + 1.0f, this.Field20 + (float) this.Field22 + 1.0f, n4);
        }
        AliceMain.Field766.Method2150317(this.Method2150361() + " \u00a77" + (this.Field1580.getValue() instanceof Float ? (Number) ((Number) this.Field1580.getValue()) : (Number) ((Number) this.Field1580.getValue()).doubleValue()), this.Field19 + 2.3f, this.Field20 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
    }

    @Override
    public void Method2159834(int n2, int n3, int n4) {
        super.Method2159834(n2, n3, n4);
        if (this.Method2159818(n2, n3)) {
            this.Method2159823(n2);
        }
    }

    @Override
    public boolean Method2159818(int n2, int n3) {
        for (ComponentOld componentOld : LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!componentOld.Field4240) continue;
            return false;
        }
        return (float) n2 >= this.Method2159838() && (float) n2 <= this.Method2159838() + (float) this.Method2159830() + 8.0f && (float) n3 >= this.Method2159839() && (float) n3 <= this.Method2159839() + (float) this.Field22;
    }

    @Override
    public void Method2159836() {
        this.Method2159845(this.Field1580.isVisible());
    }

    private void Method2159822(int n2, int n3) {
        if (this.Method2159818(n2, n3) && Mouse.isButtonDown((int) 0)) {
            this.Method2159823(n2);
        }
    }

    @Override
    public int Method2159842() {
        return 11;
    }

    private void Method2159823(int n2) {
        float f = ((float) n2 - this.Field19) / ((float) this.Field21 + 7.4f);
        if (this.Field1580.getValue() instanceof Double) {
            double d = (Double) this.Field1580.getMin() + (double) ((float) this.Field1579 * f);
            this.Field1580.setValue((double) Math.round(10.0 * d) / 10.0);
        } else if (this.Field1580.getValue() instanceof Float) {
            float f2 = ((Float) this.Field1580.getMin()).floatValue() + (float) this.Field1579 * f;
            this.Field1580.setValue(Float.valueOf((float) Math.round(10.0f * f2) / 10.0f));
        } else if (this.Field1580.getValue() instanceof Integer) {
            this.Field1580.setValue((Integer) this.Field1580.getMin() + (int) ((float) this.Field1579 * f));
        }
    }

    private float Method2159824() {
        return this.Field1578.floatValue() - this.Field1577.floatValue();
    }

    private float Method2159825() {
        return ((Number) this.Field1580.getValue()).floatValue() - this.Field1577.floatValue();
    }

    private float Method2159826() {
        return this.Method2159825() / this.Method2159824();
    }
}

