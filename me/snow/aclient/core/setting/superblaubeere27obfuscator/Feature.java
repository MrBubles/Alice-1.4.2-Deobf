

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;

public class Feature
        implements Util {
    public List<Setting> Field3871 = new ArrayList<Setting>();
    public TextManager Field3872 = AliceMain.Field766;
    private String Field3873;

    public Feature() {
    }

    public Feature(String string) {
        this.Field3873 = string;
    }

    public static boolean Method2150358() {
        return Feature.Field2811.player == null;
    }

    public static boolean Method2150359() {
        return Feature.Field2811.player == null || Feature.Field2811.world == null;
    }

    public boolean Method2150350() {
        return Feature.Field2811.player == null || Feature.Field2811.world == null || this.Method2150365();
    }

    public String Method2150361() {
        return this.Field3873;
    }

    public List<Setting> Method2150362() {
        return this.Field3871;
    }

    public boolean Method2150363() {
        return !this.Field3871.isEmpty();
    }

    public boolean Method2150364() {
        if (this instanceof Module) {
            return ((Module) this).Method2150386();
        }
        return false;
    }

    public boolean Method2150365() {
        return !this.Method2150364();
    }

    public Setting Method2150366(Setting setting) {
        setting.setFeature(this);
        this.Field3871.add(setting);
        if (this instanceof Module && Feature.Field2811.currentScreen instanceof LuigiGuiOld) {
            LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll().IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((Module) this);
        }
        return setting;
    }

    public void Method2150367(Setting setting) {
        ArrayList<Setting> arrayList = new ArrayList<Setting>();
        for (Setting setting2 : this.Field3871) {
            if (!setting2.equals(setting)) continue;
            arrayList.add(setting2);
        }
        if (!arrayList.isEmpty()) {
            this.Field3871.removeAll(arrayList);
        }
        if (this instanceof Module && Feature.Field2811.currentScreen instanceof LuigiGuiOld) {
            LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll().IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((Module) this);
        }
    }

    public Setting Method2150368(String string) {
        for (Setting setting : this.Field3871) {
            if (!setting.getName().equalsIgnoreCase(string)) continue;
            return setting;
        }
        return null;
    }

    public void Method2150369() {
        for (Setting setting : this.Field3871) {
            setting.setValue(setting.getDefaultValue());
        }
    }

    public void Method2150360() {
        this.Field3871 = new ArrayList<Setting>();
    }
}

