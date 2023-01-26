/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class TpsSync
        extends Module {
    private static TpsSync Field2002 = new TpsSync();
    public Setting<Boolean> Field2003 = this.Method2150366(new Setting<Boolean>("Mining", true));
    public Setting<Boolean> Field2004 = this.Method2150366(new Setting<Boolean>("Attack", false));

    public TpsSync() {
        super("TpsSync", "Syncs your client with the TPS.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162311();
    }

    public static TpsSync Method2162200() {
        if (Field2002 == null) {
            Field2002 = new TpsSync();
        }
        return Field2002;
    }

    private void Method2162311() {
        Field2002 = this;
    }
}

