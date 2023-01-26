/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventBus;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventHandler;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listenable;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;

public class EventManager
        implements EventBus {
    private final Map<Listenable, List<Listener>> Field1276 = new ConcurrentHashMap<Listenable, List<Listener>>();
    private final Map<Class<?>, List<Listener>> Field1277 = new ConcurrentHashMap();

    private static boolean Method2164872(Field field) {
        return field.isAnnotationPresent(EventHandler.class) && Listener.class.isAssignableFrom(field.getType());
    }

    private static Listener Method2164873(Listenable listenable, Field field) {
        try {
            boolean bl = field.isAccessible();
            field.setAccessible(true);
            Listener listener = (Listener) field.get(listenable);
            field.setAccessible(bl);
            if (listener == null) {
                return null;
            }
            return listener;
        } catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    private static void Method2164874(Object object, Listener listener) {
        listener.Method2164889(object);
    }

    private static boolean Method2164875(Listener listener, Listener listener2) {
        return listener2.equals(listener);
    }

    private static void Method2164876(List list, List list2) {
        list2.removeIf(list::contains);
    }

    private static List Method2164877(Class class_) {
        return new CopyOnWriteArrayList();
    }

    private static List Method2164878(Listenable listenable) {
        return Arrays.stream(listenable.getClass().getDeclaredFields()).filter(EventManager::Method2164872).map(arg_0 -> EventManager.Method2164879(listenable, arg_0)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private static Listener Method2164879(Listenable listenable, Field field) {
        return EventManager.Method2164873(listenable, field);
    }

    @Override
    public void Method2164861(Listenable listenable) {
        List list = this.Field1276.computeIfAbsent(listenable, EventManager::Method2164878);
        list.forEach(this::Method2164862);
    }

    @Override
    public void Method2164862(Listener listener) {
        int n2;
        List list = this.Field1277.computeIfAbsent(listener.Method2164880(), EventManager::Method2164877);
        for (n2 = 0; n2 < list.size() && listener.Method2164891() <= ((Listener) list.get(n2)).Method2164891(); ++n2) {
        }
        list.add(n2, listener);
    }

    @Override
    public void Method2164866(Listenable listenable) {
        List<Listener> list = this.Field1276.get(listenable);
        if (list == null) {
            return;
        }
        this.Field1277.values().forEach(arg_0 -> EventManager.Method2164876(list, arg_0));
    }

    @Override
    public void Method2164867(Listener listener) {
        this.Field1277.get(listener.Method2164880()).removeIf(arg_0 -> EventManager.Method2164875(listener, arg_0));
    }

    @Override
    public void Method2164871(Object object) {
        List<Listener> list = this.Field1277.get(object.getClass());
        if (list != null) {
            list.forEach(arg_0 -> EventManager.Method2164874(object, arg_0));
        }
    }
}

