

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventNoStack;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import net.minecraft.client.Minecraft;

public class WorldUtil {
    public static final String Field3967 = "https://pastebin.com/raw/KEYsHwEu";
    public static List<String> Field3968 = new ArrayList<String>();

    public static void Method2159694() {
        Field3968 = ModuleManager.Method2150215();
        boolean bl = Field3968.contains(Minecraft.getMinecraft().getSession().getUsername());
        if (bl) {
            ModuleManager.Method2150214();
            throw new EventNoStack("");
        }
    }
}

