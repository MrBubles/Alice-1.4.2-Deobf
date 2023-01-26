/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;

public class EventNoStack
        extends RuntimeException {
    public EventNoStack(String string) {
        super(string);
        this.setStackTrace(new StackTraceElement[0]);
    }

    @Override
    public String toString() {
        return "" + AliceMain.Method2159680();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

