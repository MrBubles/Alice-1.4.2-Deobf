/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.concurrent.TimeUnit;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;

public class StopWatchModule
        extends Module {
    private Timer Field4696 = new Timer();

    public StopWatchModule() {
        super("Stopwatch", "Counts a stopwatch starting from 0 when toggled", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
    }

    @Override
    public String Method2150385() {
        return (Object) ChatFormatting.GRAY + "Seconds " + (Object) ChatFormatting.WHITE + TimeUnit.MILLISECONDS.toSeconds(this.Field4696.Method2164759()) + "";
    }

    @Override
    public void Method2150372() {
        this.Field3711.setValue(true);
        this.Field4696.Method2164750();
    }

    @Override
    public void Method2150373() {
        this.Field3711.setValue(false);
    }
}

