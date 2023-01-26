/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AttachableEventBus;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventBus;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listenable;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;

public class AttachableEventManager
        extends EventManager
        implements AttachableEventBus {
    private final List<EventBus> Field3685 = new ArrayList<EventBus>();

    private static void Method2164882(Object object, EventBus eventBus) {
        eventBus.Method2164871(object);
    }

    private static void Method2164883(Listener listener, EventBus eventBus) {
        eventBus.Method2164867(listener);
    }

    private static void Method2164884(Listenable listenable, EventBus eventBus) {
        eventBus.Method2164866(listenable);
    }

    private static void Method2164885(Listener listener, EventBus eventBus) {
        eventBus.Method2164862(listener);
    }

    private static void Method2164886(Listenable listenable, EventBus eventBus) {
        eventBus.Method2164861(listenable);
    }

    @Override
    public void Method2164861(Listenable listenable) {
        super.Method2164861(listenable);
        if (!this.Field3685.isEmpty()) {
            this.Field3685.forEach(arg_0 -> AttachableEventManager.Method2164886(listenable, arg_0));
        }
    }

    @Override
    public void Method2164862(Listener listener) {
        super.Method2164862(listener);
        if (!this.Field3685.isEmpty()) {
            this.Field3685.forEach(arg_0 -> AttachableEventManager.Method2164885(listener, arg_0));
        }
    }

    @Override
    public void Method2164866(Listenable listenable) {
        super.Method2164866(listenable);
        if (!this.Field3685.isEmpty()) {
            this.Field3685.forEach(arg_0 -> AttachableEventManager.Method2164884(listenable, arg_0));
        }
    }

    @Override
    public void Method2164867(Listener listener) {
        super.Method2164867(listener);
        if (!this.Field3685.isEmpty()) {
            this.Field3685.forEach(arg_0 -> AttachableEventManager.Method2164883(listener, arg_0));
        }
    }

    @Override
    public void Method2164871(Object object) {
        super.Method2164871(object);
        if (!this.Field3685.isEmpty()) {
            this.Field3685.forEach(arg_0 -> AttachableEventManager.Method2164882(object, arg_0));
        }
    }

    @Override
    public void Method2164870(EventBus eventBus) {
        if (!this.Field3685.contains(eventBus)) {
            this.Field3685.add(eventBus);
        }
    }

    @Override
    public void Method2164881(EventBus eventBus) {
        this.Field3685.remove(eventBus);
    }
}

