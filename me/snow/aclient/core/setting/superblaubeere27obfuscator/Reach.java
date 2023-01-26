/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class Reach
        extends Module {
    private static Reach Field2321 = new Reach();
    public Setting<Boolean> Field2322 = this.Method2150366(new Setting<Boolean>("Override", false));
    public Setting<Float> Field2323 = this.Method2150366(new Setting<Object>("Add", Float.valueOf(3.0f), this::Method2162279));
    public Setting<Float> Field2324 = this.Method2150366(new Setting<Object>("Reach", Float.valueOf(6.0f), this::Method2162278));

    public Reach() {
        super("Reach", "Extends your block reach", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162277();
    }

    public static Reach Method2162276() {
        if (Field2321 == null) {
            Field2321 = new Reach();
        }
        return Field2321;
    }

    private void Method2162277() {
        Field2321 = this;
    }

    @Override
    public String Method2150385() {
        return this.Field2322.getValue() != false ? this.Field2324.getValue().toString() : this.Field2323.getValue().toString();
    }

    private boolean Method2162278(Object object) {
        return this.Field2322.getValue();
    }

    private boolean Method2162279(Object object) {
        return this.Field2322.getValue() == false;
    }
}

