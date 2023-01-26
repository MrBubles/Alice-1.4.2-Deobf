/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.gson.JsonParser
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.gson.JsonParser;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ConfigManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;

public class ModuleCommand
        extends Command {
    public ModuleCommand() {
        super("module", new String[]{"<module>", "<set/reset>", "<setting>", "<value>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        Setting setting;
        if (arrstring.length == 1) {
            ModuleCommand.Method2159696("Modules: ");
            for (Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll : AliceMain.Field756.Method2150190()) {
                StringBuilder stringBuilder = new StringBuilder(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() + ": ");
                for (Module module : AliceMain.Field756.Method2150199(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll)) {
                    stringBuilder.append(module.Method2150364() ? "\u00a7a" : "\u00a7c").append(module.Method2150361()).append("\u00a7r").append(", ");
                }
                ModuleCommand.Method2159696(stringBuilder.toString());
            }
            return;
        }
        Module module = AliceMain.Field756.Method2150197(arrstring[0]);
        if (module == null) {
            module = ModuleManager.Method2150189(arrstring[0]);
            if (module == null) {
                ModuleCommand.Method2159696("\u00a7cThis module doesnt exist.");
                return;
            }
            ModuleCommand.Method2159696("\u00a7c This is the original name of the module. Its current name is: " + module.Method2150392());
            return;
        }
        if (arrstring.length == 2) {
            ModuleCommand.Method2159696(module.Method2150392() + " : " + module.Method2150394());
            for (Setting setting2 : module.Method2150362()) {
                ModuleCommand.Method2159696(setting2.getName() + " : " + setting2.getValue() + ", " + setting2.getDescription());
            }
            return;
        }
        if (arrstring.length == 3) {
            if (arrstring[1].equalsIgnoreCase("set")) {
                ModuleCommand.Method2159696("\u00a7cPlease specify a setting.");
            } else if (arrstring[1].equalsIgnoreCase("reset")) {
                for (Setting setting3 : module.Method2150362()) {
                    setting3.setValue(setting3.getDefaultValue());
                }
            } else {
                ModuleCommand.Method2159696("\u00a7cThis command doesnt exist.");
            }
            return;
        }
        if (arrstring.length == 4) {
            ModuleCommand.Method2159696("\u00a7cPlease specify a value.");
            return;
        }
        if (arrstring.length == 5 && (setting = module.Method2150368(arrstring[2])) != null) {
            JsonParser jsonParser = new JsonParser();
            if (setting.getType().equalsIgnoreCase("String")) {
                setting.setValue(arrstring[3]);
                ModuleCommand.Method2159696("\u00a7a" + module.Method2150361() + " " + setting.getName() + " has been set to " + arrstring[3] + ".");
                return;
            }
            try {
                if (setting.getName().equalsIgnoreCase("Enabled")) {
                    if (arrstring[3].equalsIgnoreCase("true")) {
                        module.Method2150389();
                    }
                    if (arrstring[3].equalsIgnoreCase("false")) {
                        module.Method2150380();
                    }
                }
                ConfigManager.Method2150116(module, setting, jsonParser.parse(arrstring[3]));
            } catch (Exception exception) {
                ModuleCommand.Method2159696("\u00a7cBad Value! This setting requires a: " + setting.getType() + " value.");
                return;
            }
            ModuleCommand.Method2159696("\u00a7a" + module.Method2150361() + " " + setting.getName() + " has been set to " + arrstring[3] + ".");
        }
    }
}

