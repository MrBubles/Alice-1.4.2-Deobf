/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class NoGlitchBlocks
        extends Module {
    private static NoGlitchBlocks Field2148 = new NoGlitchBlocks();
    public Setting<Boolean> Field2149 = this.Method2150366(new Setting<Boolean>("Place", true));
    public Setting<Boolean> Field2150 = this.Method2150366(new Setting<Boolean>("Break", true));

    public NoGlitchBlocks() {
        super("NoGlitchBlocks", "Prevents ghost blocks", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162260();
    }

    public static NoGlitchBlocks Method2162269() {
        if (Field2148 == null) {
            Field2148 = new NoGlitchBlocks();
        }
        return Field2148;
    }

    private void Method2162260() {
        Field2148 = this;
    }
}

