/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class ViewClip
        extends Module {
    private static ViewClip Field44 = new ViewClip();
    public Setting<Boolean> Field45 = this.Method2150366(new Setting<Boolean>("Extend", true));
    public Setting<Double> Field46 = this.Method2150366(new Setting<Object>("Distance", 3.2, 0.0, 50.0, this::Method2162748, "By how much you want to extend the distance."));

    public ViewClip() {
        super("ViewClip", "Makes your Camera clip.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162747();
    }

    public static ViewClip Method2162746() {
        if (Field44 == null) {
            Field44 = new ViewClip();
        }
        return Field44;
    }

    private void Method2162747() {
        Field44 = this;
    }

    private boolean Method2162748(Object object) {
        return this.Field45.getValue();
    }
}

