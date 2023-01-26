

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.NotificationType;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ScreenHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TimerHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class Notification2 {
    private final ScreenHelper Field4307;
    private final FontRenderer Field4308;
    private final String Field4309;
    private final String Field4310;
    private final int Field4311;
    private final NotificationType Field4312;
    private final TimerHelper Field4313;

    public Notification2(String string, String string2, NotificationType notificationType, int n2, FontRenderer fontRenderer) {
        this.Field4309 = string;
        this.Field4310 = string2;
        this.Field4311 = n2;
        this.Field4312 = notificationType;
        this.Field4313 = new TimerHelper();
        this.Field4308 = fontRenderer;
        ScaledResolution scaledResolution = new ScaledResolution(Util.Field2811);
        this.Field4307 = new ScreenHelper(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight() - 60);
    }

    public int Method2162755() {
        return Math.max(100, Math.max(this.Field4308.getStringWidth(this.Field4309), this.Field4308.getStringWidth(this.Field4310)) + 40);
    }

    public String Method2162756() {
        return this.Field4309;
    }

    public String Method2162757() {
        return this.Field4310;
    }

    public int Method2162758() {
        return this.Field4311;
    }

    public NotificationType Method2162759() {
        return this.Field4312;
    }

    public TimerHelper Method2162750() {
        return this.Field4313;
    }

    public ScreenHelper Method2162761() {
        return this.Field4307;
    }
}

