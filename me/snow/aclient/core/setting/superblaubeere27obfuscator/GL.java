/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import org.lwjgl.opengl.GL11;

public class GL {
    public static void Method2164708(float f, float f2, float f3, float f4) {
        GL11.glColor4f((float) (f / 255.0f), (float) (f2 / 255.0f), (float) (f3 / 255.0f), (float) (f4 / 255.0f));
    }

    public static void Method2164709() {
        GL11.glDisable((int) 3553);
    }

    public static void Method2164700() {
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 3042);
    }

    public static void Method2164811(int n2, int n3, int n4, int n5) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 7);
        GL11.glVertex2d((double) (n2 + n4), (double) n3);
        GL11.glVertex2d((double) n2, (double) n3);
        GL11.glVertex2d((double) n2, (double) (n3 + n5));
        GL11.glVertex2d((double) (n2 + n4), (double) (n3 + n5));
        GL11.glEnd();
    }

    public static void Method2164812(int n2, int n3, float f) {
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 3042);
        GL11.glTranslatef((float) n2, (float) n3, (float) 0.0f);
        GL11.glScalef((float) f, (float) f, (float) 1.0f);
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
    }

    public static void Method2164813(int n2, int n3, float f, String string) {
        GL11.glScalef((float) (1.0f / f), (float) (1.0f / f), (float) 1.0f);
        GL11.glTranslatef((float) (-n2), (float) (-n3), (float) 0.0f);
        GL11.glDisable((int) 3553);
    }
}

