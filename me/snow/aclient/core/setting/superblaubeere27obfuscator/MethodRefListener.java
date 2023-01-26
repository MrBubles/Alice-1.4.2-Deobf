/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.function.Predicate;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventHook;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;

public class MethodRefListener<T>
        extends Listener<T> {
    private Class<T> Field2752;

    @SafeVarargs
    public MethodRefListener(Class<T> class_, EventHook<T> eventHook, Predicate<T>... arrpredicate) {
        super(eventHook, arrpredicate);
        this.Field2752 = class_;
    }

    @SafeVarargs
    public MethodRefListener(Class<T> class_, EventHook<T> eventHook, int n2, Predicate<T>... arrpredicate) {
        super(eventHook, n2, arrpredicate);
        this.Field2752 = class_;
    }

    @Override
    public Class<T> Method2164880() {
        return this.Field2752;
    }
}

