/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Notification;

public class NotificationManager {
    private final ArrayList<Notification> Field3482 = new ArrayList();

    public void Method2150227(int n2) {
        for (int j = 0; j < this.Method2150229().size(); ++j) {
            this.Method2150229().get(j).Method2162754(n2);
            n2 -= AliceMain.Field756.Method2150180(HUD.class).Field3872.Method2150321() + 5;
        }
    }

    public void Method2150228(String string, long l2) {
        this.Method2150229().add(new Notification(string, l2));
    }

    public ArrayList<Notification> Method2150229() {
        return this.Field3482;
    }
}

