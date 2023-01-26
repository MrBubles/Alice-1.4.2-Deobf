/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class ConfigCommand
        extends Command {
    public ConfigCommand() {
        super("config", new String[]{"<save/load>"});
    }

    private static boolean Method2159606(File file) {
        return !file.getName().equals("util");
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 1) {
            ConfigCommand.Method2159696("You`ll find the config files in your gameProfile directory under Alice/config");
            return;
        }
        if (arrstring.length == 2) {
            if ("list".equals(arrstring[0])) {
                String string = "Configs: ";
                File file = new File("Alice/");
                List list = Arrays.stream((Object[]) Objects.requireNonNull(file.listFiles())).filter(File::isDirectory).filter(ConfigCommand::Method2159606).collect(Collectors.toList());
                StringBuilder stringBuilder = new StringBuilder(string);
                for (File file2 : list) {
                    stringBuilder.append(file2.getName()).append(", ");
                }
                string = stringBuilder.toString();
                ConfigCommand.Method2159696("\u00a7a" + string);
            } else {
                ConfigCommand.Method2159696("\u00a7cNot a valid command... Possible usage: <list>");
            }
        }
        if (arrstring.length >= 3) {
            switch (arrstring[0]) {
                case "save": {
                    AliceMain.Field763.Method2150119(arrstring[1]);
                    ConfigCommand.Method2159696("\u00a7aConfig has been saved.");
                    break;
                }
                case "load": {
                    AliceMain.Field756.Method2150100();
                    AliceMain.Field763.Method2150118(arrstring[1]);
                    AliceMain.Field756.Method2150101();
                    ConfigCommand.Method2159696("\u00a7aConfig has been loaded.");
                    break;
                }
                default: {
                    ConfigCommand.Method2159696("\u00a7cNot a valid command... Possible usage: <save/load>");
                }
            }
        }
    }
}

