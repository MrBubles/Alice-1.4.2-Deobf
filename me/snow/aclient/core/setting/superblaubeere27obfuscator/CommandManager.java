/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.LinkedList;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BaritoneNoStop;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BindCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BookCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClearRamCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ConfigCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CoordsCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrashCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FriendCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HelpCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HistoryCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.OpenFolderCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PeekCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PrefixCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.QueueCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ReloadCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ReloadSoundCommand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UnloadCommand;

public class CommandManager
        extends Feature {
    private final ArrayList<Command> Field3595 = new ArrayList();
    private String Field3596 = "<AliceClient.jp>";
    private String Field3597 = ".";

    public CommandManager() {
        super("Command");
        this.Field3595.add(new BindCommand());
        this.Field3595.add(new ModuleCommand());
        this.Field3595.add(new OpenFolderCommand());
        this.Field3595.add(new PrefixCommand());
        this.Field3595.add(new ConfigCommand());
        this.Field3595.add(new CoordsCommand());
        this.Field3595.add(new FriendCommand());
        this.Field3595.add(new HelpCommand());
        this.Field3595.add(new ReloadCommand());
        this.Field3595.add(new UnloadCommand());
        this.Field3595.add(new ReloadSoundCommand());
        this.Field3595.add(new PeekCommand());
        this.Field3595.add(new BookCommand());
        this.Field3595.add(new ClearRamCommand());
        this.Field3595.add(new CrashCommand());
        this.Field3595.add(new HistoryCommand());
        this.Field3595.add(new BaritoneNoStop());
        this.Field3595.add(new QueueCommand());
    }

    public static String[] Method2159007(String[] arrstring, int n2) {
        LinkedList<String> linkedList = new LinkedList<String>();
        for (int j = 0; j < arrstring.length; ++j) {
            if (j == n2) continue;
            linkedList.add(arrstring[j]);
        }
        return linkedList.toArray(arrstring);
    }

    private static String Method2159008(String string) {
        if (string.startsWith("\"") && string.endsWith("\"")) {
            return string.substring("\"".length(), string.length() - "\"".length());
        }
        return string;
    }

    public void Method2159009(String string) {
        String[] arrstring = string.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        String string2 = arrstring[0].substring(1);
        String[] arrstring2 = CommandManager.Method2159007(arrstring, 0);
        for (int j = 0; j < arrstring2.length; ++j) {
            if (arrstring2[j] == null) continue;
            arrstring2[j] = CommandManager.Method2159008(arrstring2[j]);
        }
        for (Command command : this.Field3595) {
            if (!command.Method2150361().equalsIgnoreCase(string2)) continue;
            command.Method2159602(arrstring);
            return;
        }
        Command.Method2159696("Unknown command. try 'help' for a list of commands.");
    }

    public Command Method2159000(String string) {
        for (Command command : this.Field3595) {
            if (!command.Method2150361().equals(string)) continue;
            return command;
        }
        return null;
    }

    public ArrayList<Command> Method2150111() {
        return this.Field3595;
    }

    public String Method2150112() {
        return this.Field3596;
    }

    public void Method2150113(String string) {
        this.Field3596 = string;
    }

    public String Method2150114() {
        return this.Field3597;
    }

    public void Method2150115(String string) {
        this.Field3597 = string;
    }
}

