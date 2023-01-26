

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class Particles {
    public double Field1326;
    public double Field1327;
    public double Field1328;
    public double Field1329;
    public double Field1330;
    public double Field1331;
    public Color Field1332;

    public static void Method2163643(double d, double d2) {
        GL11.glVertex2d((double) d, (double) d2);
    }

    public static void Method2163644(double d, double d2, double d3, double d4) {
        GL11.glColor4d((double) d, (double) d2, (double) d3, (double) d4);
    }

    public static void Method2163645(double d, double d2, double d3, double d4, double d5, Color color) {
        double d6;
        double d7;
        double d8 = d5 / 2.0;
        d3 -= d8;
        d4 -= d8;
        float f = (float) d5;
        f /= 2.0f;
        Particles.Method2163659();
        if (color != null) {
            Particles.Method2163653(color);
        }
        Particles.Method2163656(6);
        for (d7 = 180.0; d7 <= 270.0; d7 += 1.0) {
            d6 = d7 * (Math.PI * 2) / 360.0;
            Particles.Method2163643(d + (double) f * Math.cos(d6) + (double) f, d2 + (double) f * Math.sin(d6) + (double) f);
        }
        Particles.Method2163643(d + (double) f, d2 + (double) f);
        Particles.Method2163657();
        Particles.Method2163650();
        f = (float) d5;
        f /= 2.0f;
        Particles.Method2163659();
        if (color != null) {
            Particles.Method2163653(color);
        }
        GL11.glEnable((int) 2848);
        Particles.Method2163656(6);
        for (d7 = 0.0; d7 <= 90.0; d7 += 1.0) {
            d6 = d7 * (Math.PI * 2) / 360.0;
            Particles.Method2163643(d + d3 + (double) f * Math.cos(d6), d2 + d4 + (double) f * Math.sin(d6));
        }
        Particles.Method2163643(d + d3, d2 + d4);
        Particles.Method2163657();
        GL11.glDisable((int) 2848);
        Particles.Method2163650();
        f = (float) d5;
        f /= 2.0f;
        Particles.Method2163659();
        if (color != null) {
            Particles.Method2163653(color);
        }
        GL11.glEnable((int) 2848);
        Particles.Method2163656(6);
        for (d7 = 270.0; d7 <= 360.0; d7 += 1.0) {
            d6 = d7 * (Math.PI * 2) / 360.0;
            Particles.Method2163643(d + d3 + (double) f * Math.cos(d6), d2 + (double) f * Math.sin(d6) + (double) f);
        }
        Particles.Method2163643(d + d3, d2 + (double) f);
        Particles.Method2163657();
        GL11.glDisable((int) 2848);
        Particles.Method2163650();
        f = (float) d5;
        f /= 2.0f;
        Particles.Method2163659();
        if (color != null) {
            Particles.Method2163653(color);
        }
        GL11.glEnable((int) 2848);
        Particles.Method2163656(6);
        for (d7 = 90.0; d7 <= 180.0; d7 += 1.0) {
            d6 = d7 * (Math.PI * 2) / 360.0;
            Particles.Method2163643(d + (double) f * Math.cos(d6) + (double) f, d2 + d4 + (double) f * Math.sin(d6));
        }
        Particles.Method2163643(d + (double) f, d2 + d4);
        Particles.Method2163657();
        GL11.glDisable((int) 2848);
        Particles.Method2163650();
        Particles.Method2163648(d + d8, d2 + d8, d3 - d8, d4 - d8, color);
        Particles.Method2163648(d, d2 + d8, d5 / 2.0, d4 - d8, color);
        Particles.Method2163648(d + d3, d2 + d8, d5 / 2.0, d4 - d8, color);
        Particles.Method2163648(d + d8, d2, d3 - d8, d8, color);
        Particles.Method2163648(d + d8, d2 + d4, d3 - d8, d8, color);
    }

    public static Color Method2163646(Color color, Color color2, double d) {
        double d2 = 1.0 - d;
        int n2 = (int) ((double) color.getRed() * d + (double) color2.getRed() * d2);
        int n3 = (int) ((double) color.getGreen() * d + (double) color2.getGreen() * d2);
        int n4 = (int) ((double) color.getBlue() * d + (double) color2.getBlue() * d2);
        return new Color(n2, n3, n4);
    }

    public static void Method2163648(double d, double d2, double d3, double d4, Color color) {
        Particles.Method2163640(d, d2, d3, d4, true, color);
    }

    public static void Method2163640(double d, double d2, double d3, double d4, boolean bl, Color color) {
        Particles.Method2163659();
        if (color != null) {
            Particles.Method2163653(color);
        }
        Particles.Method2163656(bl ? 6 : 1);
        Particles.Method2163643(d, d2);
        Particles.Method2163643(d + d3, d2);
        Particles.Method2163643(d + d3, d2 + d4);
        Particles.Method2163643(d, d2 + d4);
        if (!bl) {
            Particles.Method2163643(d, d2);
            Particles.Method2163643(d, d2 + d4);
            Particles.Method2163643(d + d3, d2);
            Particles.Method2163643(d + d3, d2 + d4);
        }
        Particles.Method2163657();
        Particles.Method2163650();
    }

    public static void Method2163651(double d, double d2, double d3, double d4) {
        ScaledResolution scaledResolution = new ScaledResolution(Util.Field2811);
        double d5 = scaledResolution.getScaleFactor();
        d2 = (double) scaledResolution.getScaledHeight() - d2;
        GL11.glScissor((int) ((int) (d *= d5)), (int) ((int) ((d2 *= d5) - (d4 *= d5))), (int) ((int) (d3 *= d5)), (int) ((int) d4));
    }

    public static void Method2163653(Color color) {
        if (color == null) {
            color = Color.white;
        }
        Particles.Method2163644((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f);
    }

    public static void Method2163655(int n2) {
        GL11.glEnable((int) n2);
    }

    public static void Method2163656(int n2) {
        GL11.glBegin((int) n2);
    }

    public static void Method2163657() {
        GL11.glEnd();
    }

    public static void Method2163658(int n2) {
        GL11.glDisable((int) n2);
    }

    public static void Method2163659() {
        Particles.Method2163655(3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        Particles.Method2163658(3553);
        Particles.Method2163658(2884);
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
    }

    public static void Method2163650() {
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        Particles.Method2163655(2884);
        Particles.Method2163655(3553);
        Particles.Method2163658(3042);
        Particles.Method2163653(Color.white);
    }

    public void Method2163635() {
        this.Method2163630(this.Field1326, this.Field1327, this.Field1330, new Color(this.Field1332.getRed(), this.Field1332.getGreen(), this.Field1332.getBlue(), (int) this.Field1331));
    }

    public void Method2163636() {
        this.Field1326 += this.Field1328 * 2.0;
        this.Field1327 += this.Field1329 * 2.0;
        this.Field1329 *= 0.95;
        this.Field1328 *= 0.95;
        this.Field1331 -= 2.0;
        if (this.Field1331 < 1.0) {
            this.Field1331 = 1.0;
        }
    }

    public void Method2163637(double d, double d2, double d3, double d4, double d5, Color color) {
        this.Field1326 = d;
        this.Field1327 = d2;
        this.Field1328 = d3;
        this.Field1329 = d4;
        this.Field1330 = d5;
        this.Field1331 = 254.0;
        this.Field1332 = color;
    }

    public void Method2163638(double d, double d2, double d3, boolean bl, Color color) {
        this.Method2163642(d, d2, d3, 360.0, bl, color);
    }

    public void Method2163639(double d, double d2, double d3, boolean bl) {
        this.Method2163661(d, d2, d3, 360, bl);
    }

    public void Method2163630(double d, double d2, double d3, Color color) {
        this.Method2163662(d, d2, d3, 360, color);
    }

    public void Method2163641(double d, double d2, double d3) {
        this.Method2163663(d, d2, d3, 360);
    }

    public void Method2163642(double d, double d2, double d3, double d4, boolean bl, Color color) {
        d3 /= 2.0;
        Particles.Method2163659();
        if (color != null) {
            Particles.Method2163653(color);
        }
        if (!bl) {
            GL11.glLineWidth((float) 2.0f);
        }
        GL11.glEnable((int) 2848);
        Particles.Method2163656(bl ? 6 : 3);
        for (double d5 = 0.0; d5 <= d4 / 4.0; d5 += 1.0) {
            double d6 = d5 * 4.0 * (Math.PI * 2) / 360.0;
            Particles.Method2163643(d + d3 * Math.cos(d6) + d3, d2 + d3 * Math.sin(d6) + d3);
        }
        Particles.Method2163657();
        GL11.glDisable((int) 2848);
        Particles.Method2163650();
    }

    public void Method2163647(double d, double d2, double d3, double d4, boolean bl) {
        Particles.Method2163640(d, d2, d3, d4, bl, null);
    }

    public void Method2163649(double d, double d2, double d3, double d4) {
        Particles.Method2163640(d, d2, d3, d4, true, null);
    }

    public void Method2163652(double d, double d2, double d3) {
        Particles.Method2163644(d, d2, d3, 1.0);
    }

    public void Method2163654(Color color, int n2) {
        if (color == null) {
            color = Color.white;
        }
        Particles.Method2163644((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, 0.5);
    }

    public void Method2163661(double d, double d2, double d3, int n2, boolean bl) {
        this.Method2163642(d, d2, d3, n2, bl, null);
    }

    public void Method2163662(double d, double d2, double d3, int n2, Color color) {
        this.Method2163642(d, d2, d3, n2, true, color);
    }

    public void Method2163663(double d, double d2, double d3, int n2) {
        this.Method2163642(d, d2, d3, n2, true, null);
    }
}

