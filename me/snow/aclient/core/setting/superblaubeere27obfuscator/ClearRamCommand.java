/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class ClearRamCommand
        extends Command {
    public ClearRamCommand() {
        super("clearram");
    }

    @Override
    public void Method2159602(String[] arrstring) {
        System.gc();
        Command.Method2159695("Finished clearing the ram.", false);
    }
}

