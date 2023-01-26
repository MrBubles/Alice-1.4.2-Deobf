

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.DecimalFormat;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class CoordsCommand
        extends Command {
    public CoordsCommand() {
        super("coords", new String[0]);
    }

    @Override
    public void Method2159602(String[] arrstring) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        StringSelection stringSelection = new StringSelection(decimalFormat.format(CoordsCommand.Field2811.player.posX) + ", " + decimalFormat.format(CoordsCommand.Field2811.player.posY) + ", " + decimalFormat.format(CoordsCommand.Field2811.player.posZ));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Command.Method2159695("Saved Coordinates To Clipboard.", false);
    }
}

