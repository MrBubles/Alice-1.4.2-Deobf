/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Map;
import java.util.UUID;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class FriendCommand
        extends Command {
    public FriendCommand() {
        super("friend", new String[]{"<add/del/name/clear>", "<name>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 1) {
            if (AliceMain.Field765.Method2150174().isEmpty()) {
                FriendCommand.Method2159696("You currently don't have any friends added.");
            } else {
                FriendCommand.Method2159696("Friends: ");
                for (Map.Entry<String, UUID> entry : AliceMain.Field765.Method2150174().entrySet()) {
                    FriendCommand.Method2159696(entry.getKey());
                }
            }
            return;
        }
        if (arrstring.length == 2) {
            if ("reset".equals(arrstring[0])) {
                AliceMain.Field765.Method2150172();
                FriendCommand.Method2159696("Friends got reset.");
            } else {
                FriendCommand.Method2159696(arrstring[0] + (AliceMain.Field765.Method2150168(arrstring[0]) ? " is friended." : " isnt friended."));
            }
            return;
        }
        if (arrstring.length >= 2) {
            switch (arrstring[0]) {
                case "add": {
                    AliceMain.Field765.Method2150160(arrstring[1]);
                    FriendCommand.Method2159696("\u00a7b" + arrstring[1] + " has been friended");
                    break;
                }
                case "del": {
                    AliceMain.Field765.Method2150171(arrstring[1]);
                    FriendCommand.Method2159696("\u00a7c" + arrstring[1] + " has been unfriended");
                    break;
                }
                default: {
                    FriendCommand.Method2159696("\u00a7cBad Command, try: friend <add/del/name> <name>.");
                }
            }
        }
    }
}

