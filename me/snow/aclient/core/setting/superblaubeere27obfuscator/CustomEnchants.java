/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class CustomEnchants
        extends Module {
    private static CustomEnchants Field3633 = new CustomEnchants();
    public Setting<Boolean> Field3628 = this.Method2150366(new Setting<Boolean>("ColorSync", false));
    public Setting<Integer> Field3629 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    public Setting<Integer> Field3630 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    public Setting<Integer> Field3631 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    public Setting<Integer> Field3632 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));

    public CustomEnchants() {
        super("CustomEnchants", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162379();
    }

    public static CustomEnchants Method2162378() {
        if (Field3633 == null) {
            Field3633 = new CustomEnchants();
        }
        return Field3633;
    }

    private void Method2162379() {
        Field3633 = this;
    }
}

