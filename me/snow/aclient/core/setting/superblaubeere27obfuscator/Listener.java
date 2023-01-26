/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.function.Predicate;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventHook;
import net.jodah.typetools.TypeResolver;

public class Listener<T>
        implements EventHook<T> {
    private final Class<T> Field2621;
    private final EventHook<T> Field2622;
    private final Predicate<T>[] Field2623;
    private final int Field2624;

    @SafeVarargs
    public Listener(EventHook<T> eventHook, Predicate<T>... arrpredicate) {
        this(eventHook, 0, arrpredicate);
    }

    @SafeVarargs
    public Listener(EventHook<T> eventHook, int n2, Predicate<T>... arrpredicate) {
        this.Field2622 = eventHook;
        this.Field2624 = n2;
        this.Field2621 = TypeResolver.resolveRawArgument(EventHook.class, eventHook.getClass());
        this.Field2623 = arrpredicate;
    }

    public Class<T> Method2164880() {
        return this.Field2621;
    }

    public int Method2164891() {
        return this.Field2624;
    }

    @Override
    public void Method2164889(T t) {
        if (this.Field2623.length > 0) {
            for (Predicate<T> predicate : this.Field2623) {
                if (predicate.test(t)) continue;
                return;
            }
        }
        this.Field2622.Method2164889(t);
    }
}

