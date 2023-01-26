/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class HelpCommand
        extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public void Method2159602(String[] arrstring) {
        HelpCommand.Method2159696("You can use following commands: ");
        for (Command command : AliceMain.Field761.Method2150111()) {
            HelpCommand.Method2159696(AliceMain.Field761.Method2150114() + command.Method2150361());
        }
    }
}

