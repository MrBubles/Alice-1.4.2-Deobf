/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class Colors
        extends Module {
    public static Colors Field1782;
    public Setting<Boolean> Field1783 = this.Method2150366(new Setting<Boolean>("Rainbow", Boolean.FALSE, "Rainbow colors."));
    public Setting<Integer> Field1784 = this.Method2150366(new Setting<Object>("Speed", Integer.valueOf(20), Integer.valueOf(0), Integer.valueOf(100), this::Method2150593));
    public Setting<Integer> Field1785 = this.Method2150366(new Setting<Object>("Saturation", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150592));
    public Setting<Integer> Field1786 = this.Method2150366(new Setting<Object>("Brightness", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150591));
    public Setting<Integer> Field1787 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150580));
    public Setting<Integer> Field1788 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(255), this::Method2150589));
    public Setting<Integer> Field1789 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(50), Integer.valueOf(0), Integer.valueOf(255), this::Method2150588));
    public Setting<Integer> Field1790 = this.Method2150366(new Setting<Object>("Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150587));
    public float Field1791;
    public Map<Integer, Integer> Field1792 = new HashMap<Integer, Integer>();

    public Colors() {
        super("Colors", "Universal colors.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, true);
        Field1782 = this;
    }

    public static Colors Method2150583() {
        if (Field1782 == null) {
            Field1782 = new Colors();
        }
        return Field1782;
    }

    private void Method2150584() {
        Field1782 = this;
    }

    @Override
    public void Method2150376() {
        int n2 = 101 - this.Field1784.getValue();
        float f = this.Field1791 = (float) (System.currentTimeMillis() % (360L * (long) n2)) / (360.0f * (float) n2);
        for (int j = 0; j <= 510; ++j) {
            this.Field1792.put(j, Color.HSBtoRGB(f, (float) this.Field1785.getValue().intValue() / 255.0f, (float) this.Field1786.getValue().intValue() / 255.0f));
            f += 0.0013071896f;
        }
        if (ClickGui.Method2150300().Field814.getValue().booleanValue()) {
            AliceMain.Field767.Method2159042(Field1782.Method2150586().getRed(), Field1782.Method2150586().getGreen(), Field1782.Method2150586().getBlue(), ClickGui.Method2150300().Field821.getValue());
        }
        if (ClickGuiP.Method2150571().Field3252.getValue().booleanValue()) {
            AliceMain.Field783.Method2159078(Field1782.Method2150586().getRed(), Field1782.Method2150586().getGreen(), Field1782.Method2150586().getBlue(), ClickGuiP.Method2150571().Field3259.getValue());
        }
        if (ClickGuiF.Method2150568().Field3242.getValue().booleanValue()) {
            AliceMain.Field785.Method2159002(Field1782.Method2150586().getRed(), Field1782.Method2150586().getGreen(), Field1782.Method2150586().getBlue(), ClickGuiF.Method2150568().Field3246.getValue());
        }
        if (ClickGui2.Method2150488().Field1681.getValue().booleanValue()) {
            AliceMain.Field786.Method2159066(Field1782.Method2150586().getRed(), Field1782.Method2150586().getGreen(), Field1782.Method2150586().getBlue(), ClickGui2.Method2150488().Field1687.getValue());
        }
    }

    public int Method2150585() {
        if (this.Field1783.getValue().booleanValue()) {
            return Color.HSBtoRGB(this.Field1791, (float) this.Field1785.getValue().intValue() / 255.0f, (float) this.Field1786.getValue().intValue() / 255.0f);
        }
        return ColorUtil.Method2163370(this.Field1787.getValue(), this.Field1788.getValue(), this.Field1789.getValue(), this.Field1790.getValue());
    }

    public Color Method2150586() {
        if (this.Field1783.getValue().booleanValue()) {
            return Color.getHSBColor(this.Field1791, (float) this.Field1785.getValue().intValue() / 255.0f, (float) this.Field1786.getValue().intValue() / 255.0f);
        }
        return new Color(this.Field1787.getValue(), this.Field1788.getValue(), this.Field1789.getValue(), this.Field1790.getValue());
    }

    private boolean Method2150587(Object object) {
        return this.Field1783.getValue() == false;
    }

    private boolean Method2150588(Object object) {
        return this.Field1783.getValue() == false;
    }

    private boolean Method2150589(Object object) {
        return this.Field1783.getValue() == false;
    }

    private boolean Method2150580(Object object) {
        return this.Field1783.getValue() == false;
    }

    private boolean Method2150591(Object object) {
        return this.Field1783.getValue();
    }

    private boolean Method2150592(Object object) {
        return this.Field1783.getValue();
    }

    private boolean Method2150593(Object object) {
        return this.Field1783.getValue();
    }
}

