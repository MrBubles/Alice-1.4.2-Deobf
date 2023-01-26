/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.List;
import java.util.UUID;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;

public class HistoryCommand
        extends Command {
    public HistoryCommand() {
        super("history", new String[]{"<player>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        List<String> list;
        UUID uUID;
        if (arrstring.length == 1 || arrstring.length == 0) {
            HistoryCommand.Method2159696("\u00a7cPlease specify a player.");
        }
        try {
            uUID = PlayerUtil.Method2163934(arrstring[0]);
        } catch (Exception exception) {
            HistoryCommand.Method2159696("An error occured.");
            return;
        }
        try {
            list = PlayerUtil.Method2163937(uUID);
        } catch (Exception exception) {
            HistoryCommand.Method2159696("An error occured.");
            return;
        }
        if (list != null) {
            HistoryCommand.Method2159696(arrstring[0] + "\u00b4s name history:");
            for (String string : list) {
                HistoryCommand.Method2159696(string);
            }
        } else {
            HistoryCommand.Method2159696("No names found.");
        }
    }
}

