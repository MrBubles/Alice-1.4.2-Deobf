/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.TurokGeneric;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TurokString;

public class TurokBoolean {
    private TurokString Field3929;
    private TurokString Field3930;
    private TurokGeneric<Boolean> Field3931;

    public TurokBoolean(TurokString turokString, TurokString turokString2, boolean bl) {
        this.Field3929 = turokString;
        this.Field3930 = turokString2;
        this.Field3931 = new TurokGeneric<Boolean>(bl);
    }

    public void Method2164828(boolean bl) {
        this.Field3931.Method2164845(bl);
    }

    public TurokString Method2164829() {
        return this.Field3929;
    }

    public TurokString Method2164820() {
        return this.Field3930;
    }

    public boolean Method2164831() {
        return this.Field3931.Method2164846();
    }
}

