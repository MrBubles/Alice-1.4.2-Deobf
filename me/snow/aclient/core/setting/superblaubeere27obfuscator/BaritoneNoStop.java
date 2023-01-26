/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class BaritoneNoStop
        extends Command {
    public BaritoneNoStop() {
        super("noStop", new String[]{"<prefix>", "<x>", "<y>", "<z>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 5) {
            int n2;
            int n3;
            int n4;
            AliceMain.Field779.Method2150226(arrstring[0]);
            try {
                n4 = Integer.parseInt(arrstring[1]);
                n3 = Integer.parseInt(arrstring[2]);
                n2 = Integer.parseInt(arrstring[3]);
            } catch (NumberFormatException numberFormatException) {
                BaritoneNoStop.Method2159696("Invalid Input for x, y or z!");
                AliceMain.Field779.Method2150225();
                return;
            }
            AliceMain.Field779.Method2150224(n4, n3, n2);
            return;
        }
        BaritoneNoStop.Method2159696("Stoping Baritone-Nostop.");
        AliceMain.Field779.Method2150225();
    }
}

