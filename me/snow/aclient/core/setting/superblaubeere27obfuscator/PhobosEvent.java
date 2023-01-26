/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumStages;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ICancellable1;

public class PhobosEvent
        implements ICancellable1 {
    private final EnumStages Field2956;
    private boolean Field2957;

    public PhobosEvent(EnumStages enumStages) {
        this.Field2956 = enumStages;
    }

    public EnumStages Method2159033() {
        return this.Field2956;
    }

    @Override
    public void Method2159031() {
        this.Field2957 = true;
    }

    public void Method2159034() {
        this.Field2957 = false;
    }

    @Override
    public boolean Method2159032() {
        return this.Field2957;
    }
}

