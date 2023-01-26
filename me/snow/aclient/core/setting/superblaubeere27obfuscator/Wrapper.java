

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.world.World
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class Wrapper {
    public static final Minecraft Field2414 = Minecraft.getMinecraft();

    public static Minecraft Method2164704() {
        return Minecraft.getMinecraft();
    }

    public static EntityPlayerSP Method2164705() {
        return Wrapper.Method2164704().player;
    }

    public static World Method2164706() {
        return Wrapper.Method2164704().world;
    }

    public static int Method2164707(String string) {
        return Keyboard.getKeyIndex((String) string.toUpperCase());
    }
}

