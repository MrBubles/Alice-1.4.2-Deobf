

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.audio.SoundHandler
 *  net.minecraft.client.audio.SoundManager
 *  net.minecraftforge.fml.common.ObfuscationReflectionHelper
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ReloadSoundCommand
        extends Command {
    public ReloadSoundCommand() {
        super("reloadsound", new String[0]);
    }

    @Override
    public void Method2159602(String[] arrstring) {
        try {
            SoundManager soundManager = (SoundManager) ObfuscationReflectionHelper.getPrivateValue(SoundHandler.class, (Object) Field2811.getSoundHandler(), (String[]) new String[]{"sndManager", "sndManager"});
            soundManager.reloadSoundSystem();
            ReloadSoundCommand.Method2159696("\u00a7aReloaded Sound System.");
        } catch (Exception exception) {
            System.out.println("Could not restart sound manager: " + exception);
            exception.printStackTrace();
            ReloadSoundCommand.Method2159696("\u00a7cCouldn't Reload Sound System!");
        }
    }
}

