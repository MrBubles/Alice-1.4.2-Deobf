/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ICancellable;

public class Cancellable
        implements ICancellable {
    private boolean Field2888;

    @Override
    public void Method2164887() {
        this.Field2888 = true;
    }

    @Override
    public boolean Method2164888() {
        return this.Field2888;
    }
}

