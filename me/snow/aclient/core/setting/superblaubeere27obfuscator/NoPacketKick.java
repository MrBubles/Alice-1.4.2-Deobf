/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import org.jetbrains.annotations.NotNull;

public class NoPacketKick
        extends Module {
    private static NoPacketKick Field721;

    public NoPacketKick() {
        super("NoPacketKick", "Suppress network exceptions and prevent getting kicked", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    public static NoPacketKick Method2162272() {
        if (Field721 == null) {
            Field721 = new NoPacketKick();
        }
        return Field721;
    }

    @JvmStatic
    public static final void Method2162273(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object) throwable, (String) "");
        Command.Method2159696(" Caught exception - \"" + throwable + "\" check log for more info.");
        throwable.printStackTrace();
    }
}

