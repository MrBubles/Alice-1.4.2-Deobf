/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class OpenFolderCommand
        extends Command {
    public OpenFolderCommand() {
        super("openfolder", new String[0]);
    }

    @Override
    public void Method2159602(String[] arrstring) {
        try {
            Desktop.getDesktop().open(new File("Alice/"));
            Command.Method2159695("Opened config folder!", false);
        } catch (IOException iOException) {
            Command.Method2159695("Could not open config folder!", false);
            iOException.printStackTrace();
        }
    }
}

