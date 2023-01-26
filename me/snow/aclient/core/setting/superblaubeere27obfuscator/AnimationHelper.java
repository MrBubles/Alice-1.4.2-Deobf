

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import net.minecraft.client.Minecraft;

public class AnimationHelper {
    public static float Method2163664(float f, float f2, float f3) {
        float f4 = (f2 - f) / Math.max((float) Minecraft.getDebugFPS(), 5.0f) * 15.0f;
        if (f4 > 0.0f) {
            f4 = Math.max(f3, f4);
            f4 = Math.min(f2 - f, f4);
        } else if (f4 < 0.0f) {
            f4 = Math.min(-f3, f4);
            f4 = Math.max(f2 - f, f4);
        }
        return f + f4;
    }

    public static float Method2163665(float f, float f2, long l2, double d) {
        float f3 = f2 - f;
        if (l2 < 1L) {
            l2 = 1L;
        }
        if (l2 > 1000L) {
            l2 = 16L;
        }
        double d2 = Math.max(d * (double) l2 / 16.66666603088379, 0.5);
        if ((double) f3 > d) {
            float f4;
            f2 = (float) ((double) f2 - d2);
            if (f4 < f) {
                f2 = f;
            }
        } else if ((double) f3 < -d) {
            float f5;
            f2 = (float) ((double) f2 + d2);
            if (f5 > f) {
                f2 = f;
            }
        } else {
            f2 = f;
        }
        return f2;
    }
}

