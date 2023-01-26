/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class PrefixCommand
        extends Command {
    public PrefixCommand() {
        super("prefix", new String[]{"<char>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 1) {
            Command.Method2159696("\u00a7cSpecify a new prefix.");
            return;
        }
        AliceMain.Field756.Method2150180(ClickGui.class).Field813.setValue(arrstring[0]);
        Command.Method2159696("Prefix set to \u00a7a" + AliceMain.Field761.Method2150114());
    }
}

