/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Arrays;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listenable;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;

public interface EventBus {
    public void Method2164861(Listenable var1);

    public void Method2164862(Listener var1);

    default public void Method2164863(Listenable... arrlistenable) {
        Arrays.stream(arrlistenable).forEach(this::Method2164861);
    }

    default public void Method2164864(Iterable<Listenable> iterable) {
        iterable.forEach(this::Method2164861);
    }

    default public void Method2164865(Listener... arrlistener) {
        Arrays.stream(arrlistener).forEach(this::Method2164862);
    }

    public void Method2164866(Listenable var1);

    public void Method2164867(Listener var1);

    default public void Method2164868(Listenable... arrlistenable) {
        Arrays.stream(arrlistenable).forEach(this::Method2164866);
    }

    default public void Method2164869(Iterable<Listenable> iterable) {
        iterable.forEach(this::Method2164866);
    }

    default public void Method2164860(Listener... arrlistener) {
        Arrays.stream(arrlistener).forEach(this::Method2164867);
    }

    public void Method2164871(Object var1);
}

