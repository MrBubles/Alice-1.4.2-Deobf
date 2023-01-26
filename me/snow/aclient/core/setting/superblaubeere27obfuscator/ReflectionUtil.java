/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.Objects;

public class ReflectionUtil {
    public static <F, T extends F> void Method2163949(F f, T t, boolean bl) throws NoSuchFieldException, IllegalAccessException {
        Objects.requireNonNull(f);
        Objects.requireNonNull(t);
        Class<?> class_ = f.getClass();
        for (Field field : class_.getDeclaredFields()) {
            ReflectionUtil.Method2163954(field);
            if (ReflectionUtil.Method2163951(field) || bl && ReflectionUtil.Method2163952(field)) continue;
            ReflectionUtil.Method2163956(field);
            field.set(t, field.get(f));
        }
    }

    public static <F, T extends F> void Method2163940(F f, T t) throws NoSuchFieldException, IllegalAccessException {
        ReflectionUtil.Method2163949(f, t, false);
    }

    public static boolean Method2163951(Member member) {
        return (member.getModifiers() & 8) != 0;
    }

    public static boolean Method2163952(Member member) {
        return (member.getModifiers() & 0x10) != 0;
    }

    public static void Method2163953(AccessibleObject accessibleObject, boolean bl) {
        Objects.requireNonNull(accessibleObject);
        accessibleObject.setAccessible(bl);
    }

    public static void Method2163954(AccessibleObject accessibleObject) {
        ReflectionUtil.Method2163953(accessibleObject, true);
    }

    public static void Method2163955(AccessibleObject accessibleObject) {
        ReflectionUtil.Method2163953(accessibleObject, false);
    }

    public static void Method2163956(Member member) throws NoSuchFieldException, IllegalAccessException {
        Objects.requireNonNull(member);
        Field field = Field.class.getDeclaredField("modifiers");
        ReflectionUtil.Method2163954(field);
        field.setInt(member, member.getModifiers() & 0xFFFFFFEF);
    }

    public static void Method2163957(Member member) throws NoSuchFieldException, IllegalAccessException {
        Objects.requireNonNull(member);
        Field field = Field.class.getDeclaredField("modifiers");
        ReflectionUtil.Method2163954(field);
        field.setInt(member, member.getModifiers() & 0x10);
    }
}

