/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import org.lwjgl.input.Keyboard;

public class BindCommand
        extends Command {
    public BindCommand() {
        super("bind", new String[]{"<module>", "<bind>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 1) {
            BindCommand.Method2159696("Please specify a module.");
            return;
        }
        String string = arrstring[1];
        String string2 = arrstring[0];
        Module module = ModuleManager.Method2150189(string2);
        if (module == null) {
            BindCommand.Method2159696("Unknown module '" + module + "'!");
            return;
        }
        if (string == null) {
            BindCommand.Method2159696(module.Method2150361() + " is bound to &b" + module.Method2150390().toString());
            return;
        }
        int n2 = Keyboard.getKeyIndex((String) string.toUpperCase());
        if (string.equalsIgnoreCase("none")) {
            n2 = -1;
        }
        if (n2 == 0) {
            BindCommand.Method2159696("Unknown key '" + string + "'!");
            return;
        }
        module.Field3712.setValue(new Bind(n2));
        BindCommand.Method2159696("Bind for &b" + module.Method2150361() + "&r set to &b" + string.toUpperCase());
    }
}

