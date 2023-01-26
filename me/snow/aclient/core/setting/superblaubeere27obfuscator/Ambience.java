/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class Ambience
        extends Module {
    public final Setting<Integer> Field1109 = this.Method2150366(new Setting<Integer>("Red", 30, 0, 255));
    public final Setting<Integer> Field1110 = this.Method2150366(new Setting<Integer>("Green", 30, 0, 255));
    public final Setting<Integer> Field1111 = this.Method2150366(new Setting<Integer>("Blue", 30, 0, 255));
    public final Setting<Integer> Field1112 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));

    public Ambience() {
        super("Ambience", "Allows you to change the ambience of your world", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }
}

