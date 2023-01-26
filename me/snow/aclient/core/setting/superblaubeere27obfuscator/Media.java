

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class Media
        extends Module {
    private static Media Field1554;
    public final Setting<Boolean> Field1555 = this.Method2150366(new Setting<Boolean>("MyName", true));
    public final Setting<String> Field1556 = this.Method2150366(new Setting<Object>("Name here...", "Name here...", this::Method2150697));
    private StringBuffer Field1557;

    public Media() {
        super("NameProtect", "Helps with creating Media", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, false, false, false);
        Field1554 = this;
    }

    public static Media Method2150694() {
        if (Field1554 == null) {
            Field1554 = new Media();
        }
        return Field1554;
    }

    public static String Method2150695() {
        if (Media.Method2150359()) {
            return Field2811.getSession().getUsername();
        }
        String string = Media.Method2150694().Method2150696();
        if (string == null || string.isEmpty()) {
            return Field2811.getSession().getUsername();
        }
        return string;
    }

    @Override
    public void Method2150372() {
        Command.Method2159696((Object) ChatFormatting.GRAY + "Success! Name succesfully changed to " + (Object) ChatFormatting.GREEN + this.Field1556.getValue());
    }

    public String Method2150696() {
        if (this.Field1557 == null) {
            return null;
        }
        return this.Field1557.toString();
    }

    private boolean Method2150697(Object object) {
        return this.Field1555.getValue();
    }
}

