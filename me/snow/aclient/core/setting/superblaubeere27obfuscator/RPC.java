/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DiscordPresence;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class RPC
        extends Module {
    public static RPC Field1558;
    public Setting<Boolean> Field1559 = this.Method2150366(new Setting<Boolean>("CatMode", false));
    public Setting<Boolean> Field1560 = this.Method2150366(new Setting<Boolean>("ShowIP", Boolean.TRUE, "Shows the server IP in your discord presence."));
    public String Field1561 = "LuigiHack Continued 1.4.2";

    public RPC() {
        super("RPC", "Discord rich presence", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, false, false, false);
        Field1558 = this;
    }

    @Override
    public void Method2150372() {
        DiscordPresence.Method2159022();
    }

    @Override
    public void Method2150373() {
        DiscordPresence.Method2159023();
    }
}

