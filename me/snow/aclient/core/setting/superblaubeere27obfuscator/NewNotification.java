

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Notification2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NotificationType;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RectHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ScreenHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NewNotification
        extends Module {
    private static final List<Notification2> Field3147 = new CopyOnWriteArrayList<Notification2>();
    public static HashMap<String, Integer> Field3138 = new HashMap();
    private static NewNotification Field3137 = new NewNotification();
    public int Field3139;
    public int Field3140;
    public Setting<Integer> Field3141 = this.Method2150366(new Setting<Integer>("test", 100, 0, 2048));
    public Setting<Integer> Field3142 = this.Method2150366(new Setting<Integer>("test2", 500, 0, 2048));
    public Setting<Integer> Field3143 = this.Method2150366(new Setting<Integer>("time", 1000, 0, 5000));
    public Setting<Boolean> Field3144 = this.Method2150366(new Setting<Boolean>("ModuleToggle", false));
    public Setting<Boolean> Field3145 = this.Method2150366(new Setting<Boolean>("TotemNotifi", true));
    public Setting<Integer> Field3146 = this.Method2150366(new Setting<Integer>("Max", 7, 1, 20));

    public NewNotification() {
        super("HudNotifications", "original??", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2162749();
    }

    public static NewNotification Method2162740() {
        if (Field3137 == null) {
            Field3137 = new NewNotification();
        }
        return Field3137;
    }

    public static void Method2162751(String string, String string2, int n2, NotificationType notificationType) {
        FontRenderer fontRenderer = Util.Field2811.fontRenderer;
        Field3147.add(new Notification2(string, string2, notificationType, n2, fontRenderer));
    }

    private void Method2162749() {
        Field3137 = this;
    }

    @Override
    @SubscribeEvent
    public void Method2150370(Render2DEvent render2DEvent) {
        if (Field3147.size() > this.Field3146.getValue()) {
            Field3147.remove(0);
        }
        if (!Field3147.isEmpty()) {
            ScaledResolution scaledResolution = new ScaledResolution(Field2811);
            int n2 = scaledResolution.getScaledHeight();
            int n3 = scaledResolution.getScaledWidth();
            int n4 = n2 - 60;
            for (Notification2 notification2 : Field3147) {
                ScreenHelper screenHelper = notification2.Method2162761();
                int n5 = notification2.Method2162755() + 40 + Util.Field2811.fontRenderer.getStringWidth(notification2.Method2162757()) / 2;
                if (!notification2.Method2162750().Method2163732(notification2.Method2162758() - this.Field3141.getValue())) {
                    try {
                        screenHelper.Method2163726(n3 - n5, n4, 0.8f, 5.0f);
                    } catch (Exception exception) {
                    }
                } else {
                    try {
                        screenHelper.Method2163726(n3, notification2.Method2162761().Method2163729(), 0.8f, 5.0f);
                    } catch (Exception exception) {
                        // empty catch block
                    }
                    if (Util.Field2811.player != null && Util.Field2811.world != null && notification2.Method2162750().Method2163734() > (long) (notification2.Method2162758() + this.Field3142.getValue())) {
                        Field3147.remove(notification2);
                    }
                }
                Color color = Colors.Method2150583().Method2150586();
                Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), 255);
                float f = screenHelper.Method2163727();
                float f2 = screenHelper.Method2163729();
                GlStateManager.pushMatrix();
                GlStateManager.disableBlend();
                RectHelper.Method2163686(f, f2, f - 2.0f, f2 + 28.0f, color2.getRGB());
                RectHelper.Method2163686(f, f2, n3, f2 + 28.0f, new Color(35, 34, 34).getRGB());
                AliceMain.Field766.Method2150317(notification2.Method2162756(), f + 5.0f, f2 + 4.0f, -1);
                AliceMain.Field766.Method2150317(notification2.Method2162757(), f + 5.0f, f2 + 15.0f, new Color(245, 245, 245).getRGB());
                GlStateManager.popMatrix();
                if (Field3147.size() <= 1) continue;
                n4 -= 35;
            }
        }
    }

    public void Method2162752(EntityPlayer entityPlayer) {
        if (AliceMain.Field756.Method2150180(NewNotification.class).Method2150364() && this.Field3145.getValue().booleanValue()) {
            if (Feature.Method2150359()) {
                return;
            }
            if (NewNotification.Field2811.player.equals((Object) entityPlayer)) {
                return;
            }
            int n2 = 1;
            if (Field3138.containsKey(entityPlayer.getName())) {
                n2 = Field3138.get(entityPlayer.getName());
                Field3138.put(entityPlayer.getName(), ++n2);
            } else {
                Field3138.put(entityPlayer.getName(), n2);
            }
            if (n2 == 1) {
                NewNotification.Method2162751((Object) TextFormatting.BOLD + "TotemPop", entityPlayer.getName() + " popped " + String.valueOf(n2) + " totem.", NewNotification.Method2162740().Field3143.getValue(), NotificationType.INFO);
            } else {
                NewNotification.Method2162751((Object) TextFormatting.BOLD + "TotemPop", entityPlayer.getName() + " popped " + String.valueOf(n2) + " totems.", NewNotification.Method2162740().Field3143.getValue(), NotificationType.INFO);
            }
        }
    }

    public void Method2162753(EntityPlayer entityPlayer) {
        if (AliceMain.Field756.Method2150180(NewNotification.class).Method2150364() && this.Field3145.getValue().booleanValue() && Field3138.containsKey(entityPlayer.getName())) {
            int n2 = Field3138.get(entityPlayer.getName());
            Field3138.remove(entityPlayer.getName());
            if (n2 == 1) {
                NewNotification.Method2162751((Object) TextFormatting.BOLD + "TotemPop", entityPlayer.getName() + " died after popping " + String.valueOf(n2) + " totem.", this.Field3143.getValue(), NotificationType.INFO);
            } else {
                NewNotification.Method2162751((Object) TextFormatting.BOLD + "TotemPop", entityPlayer.getName() + " died after popping " + String.valueOf(n2) + " totems.", this.Field3143.getValue(), NotificationType.INFO);
            }
        }
    }

    @Override
    public void Method2150378() {
        Field3138.clear();
    }

    @Override
    public void Method2150372() {
        Field3138.clear();
    }
}

