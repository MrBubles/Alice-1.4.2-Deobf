

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class Notification {
    private final Timer Field324 = new Timer();
    private String Field321;
    private long Field322;
    private float Field323;

    public Notification(String string, long l2) {
        this.Field321 = string;
        this.Field322 = l2;
        this.Field323 = AliceMain.Field756.Method2150180(HUD.class).Field3872.Method2150310(string);
        this.Field324.Method2164750();
    }

    public void Method2162754(int n2) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        if (this.Field324.Method2164755(this.Field322)) {
            AliceMain.Field776.Method2150229().remove(this);
        }
        RenderUtil.Method2163027((float) (scaledResolution.getScaledWidth() - 4) - this.Field323, n2, scaledResolution.getScaledWidth() - 2, n2 + AliceMain.Field756.Method2150180(HUD.class).Field3872.Method2150321() + 3, 0x75000000);
        AliceMain.Field756.Method2150180(HUD.class).Field3872.Method2150318(this.Field321, (float) scaledResolution.getScaledWidth() - this.Field323 - 3.0f, n2 + 2, -1, true);
    }
}

