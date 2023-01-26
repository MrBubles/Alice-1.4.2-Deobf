

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class RectHelper {
    public static long Field2413 = 0L;

    public static void Method2163682(double d, double d2, double d3, double d4, float f, Color color) {
        float f2 = (float) (d + (double) (f / 2.0f + 0.5f));
        float f3 = (float) (d2 + (double) (f / 2.0f + 0.5f));
        float f4 = (float) (d3 - (double) (f / 2.0f + 0.5f));
        float f5 = (float) (d4 - (double) (f / 2.0f + 0.5f));
        RectHelper.Method2163686(f2, f3, f2 + f4, f3 + f5, color.getRGB());
        RectHelper.Method2163683(d, d2, f * 2.0f, 360.0, true, color);
        RectHelper.Method2163683(d + (double) f4 - (double) f + 1.2, d2, f * 2.0f, 360.0, true, color);
        RectHelper.Method2163683(d + (double) f4 - (double) f + 1.2, d2 + (double) f5 - (double) f + 1.0, f * 2.0f, 360.0, true, color);
        RectHelper.Method2163683(d, d2 + (double) f5 - (double) f + 1.0, f * 2.0f, 360.0, true, color);
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        RectHelper.Method2163686(f2 - f / 2.0f - 0.5f, f3 + f / 2.0f, f2 + f4, f3 + f5 - f / 2.0f, color.getRGB());
        RectHelper.Method2163686(f2, f3 + f / 2.0f, f2 + f4 + f / 2.0f + 0.5f, f3 + f5 - f / 2.0f, color.getRGB());
        RectHelper.Method2163686(f2 + f / 2.0f, f3 - f / 2.0f - 0.5f, f2 + f4 - f / 2.0f, d2 + (double) f5 - (double) (f / 2.0f), color.getRGB());
        RectHelper.Method2163686(f2 + f / 2.0f, f3, f2 + f4 - f / 2.0f, f3 + f5 + f / 2.0f + 0.5f, color.getRGB());
    }

    public static void Method2163683(double d, double d2, double d3, double d4, boolean bl, Color color) {
        d3 /= 2.0;
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2884);
        GlStateManager.disableAlpha();
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        if (!bl) {
            GL11.glLineWidth((float) 1.0f);
        }
        GL11.glEnable((int) 2848);
        GL11.glBegin((int) (bl ? 6 : 3));
        for (double d5 = 0.0; d5 <= d4; d5 += 1.0) {
            double d6 = d5 * (Math.PI * 2) / d4;
            GL11.glVertex2d((double) (d + d3 * Math.cos(d6) + d3), (double) (d2 + d3 * Math.sin(d6) + d3));
        }
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GlStateManager.enableAlpha();
        GL11.glEnable((int) 2884);
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
    }

    public static void Method2163684(double d, double d2, double d3, double d4, int n2) {
        RectHelper.Method2163686(d, d2, d + d3, d2 + d4, n2);
    }

    public static void Method2163685(float f, float f2, float f3, float f4, int n2) {
        RectHelper.Method2163687(f, f2, f + f3, f2 + f4, n2);
    }

    public static void Method2163686(double d, double d2, double d3, double d4, int n2) {
        double d5;
        if (d < d3) {
            d5 = d;
            d = d3;
            d3 = d5;
        }
        if (d2 < d4) {
            d5 = d2;
            d2 = d4;
            d4 = d5;
        }
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f2, (float) f3, (float) f4, (float) f);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).endVertex();
        bufferBuilder.pos(d, d2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163687(float f, float f2, float f3, float f4, int n2) {
        GL11.glEnable((int) 3042);
        GL11.glEnable((int) 2848);
        RectHelper.Method2163686(f, f2, f3, f4, n2);
        GL11.glScalef((float) 0.5f, (float) 0.5f, (float) 0.5f);
        RectHelper.Method2163686(f * 2.0f - 1.0f, f2 * 2.0f, f * 2.0f, f4 * 2.0f - 1.0f, n2);
        RectHelper.Method2163686(f * 2.0f, f2 * 2.0f - 1.0f, f3 * 2.0f, f2 * 2.0f, n2);
        RectHelper.Method2163686(f3 * 2.0f, f2 * 2.0f, f3 * 2.0f + 1.0f, f4 * 2.0f - 1.0f, n2);
        RectHelper.Method2163686(f * 2.0f, f4 * 2.0f - 1.0f, f3 * 2.0f, f4 * 2.0f, n2);
        GL11.glDisable((int) 2848);
        GL11.glDisable((int) 3042);
        GL11.glScalef((float) 2.0f, (float) 2.0f, (float) 2.0f);
    }

    public static void Method2163688(float f, float f2, float f3, float f4) {
        RectHelper.Method2163687(f - 41.0f, f2 - 61.0f, f3 + 41.0f, f4 + 61.0f, new Color(48, 48, 48, 255).getRGB());
        RectHelper.Method2163687(f - 40.0f, f2 - 60.0f, f3 + 40.0f, f4 + 60.0f, new Color(17, 17, 17, 255).getRGB());
    }

    public static void Method2163689(float f, float f2, float f3, float f4) {
        RectHelper.Method2163686(f - 46.5f, f2 - 66.5f, f3 + 46.5f, f4 + 66.5f, new Color(0, 0, 0, 255).getRGB());
        RectHelper.Method2163686(f - 46.0f, f2 - 66.0f, f3 + 46.0f, f4 + 66.0f, new Color(48, 48, 48, 255).getRGB());
        RectHelper.Method2163686(f - 44.5f, f2 - 64.5f, f3 + 44.5f, f4 + 64.5f, new Color(33, 33, 33, 255).getRGB());
        RectHelper.Method2163686(f - 43.5f, f2 - 63.5f, f3 + 43.5f, f4 + 63.5f, new Color(0, 0, 0, 255).getRGB());
        RectHelper.Method2163686(f - 43.0f, f2 - 63.0f, f3 + 43.0f, f4 + 63.0f, new Color(9, 9, 9, 255).getRGB());
        RectHelper.Method2163686(f - 40.5f, f2 - 60.5f, f3 + 40.5f, f4 + 60.5f, new Color(48, 48, 48, 255).getRGB());
        RectHelper.Method2163686(f - 40.0f, f2 - 60.0f, f3 + 40.0f, f4 + 60.0f, new Color(17, 17, 17, 255).getRGB());
    }

    public static void Method2163680(float f, float f2, float f3, float f4, float f5, int n2, int n3, boolean bl) {
        RectHelper.Method2163686(f - (!bl ? f5 : 0.0f), f2 - (!bl ? f5 : 0.0f), f3 + (!bl ? f5 : 0.0f), f4 + (!bl ? f5 : 0.0f), n3);
        RectHelper.Method2163686(f + (bl ? f5 : 0.0f), f2 + (bl ? f5 : 0.0f), f3 - (bl ? f5 : 0.0f), f4 - (bl ? f5 : 0.0f), n2);
    }

    public static void Method2163691(float f, float f2, float f3, float f4, float f5, int n2, int n3, boolean bl) {
        RectHelper.Method2163686(f - (!bl ? f5 : 0.0f), f2 - (!bl ? f5 : 0.0f), f3 + (!bl ? f5 : 0.0f), f4 + (!bl ? f5 : 0.0f), n3);
        RectHelper.Method2163686(f + (bl ? f5 : 0.0f), f2 + (bl ? f5 : 0.0f), f3 - (bl ? f5 : 0.0f), f4 - (bl ? f5 : 0.0f), n2);
    }

    public static void Method2163692(float f, float f2, float f3, float f4, Color color, Color color2) {
        RectHelper.Method2163686(f, f2, f + f3, f2 + f4, color.getRGB());
        int n2 = color2.getRGB();
        RectHelper.Method2163686(f - 1.0f, f2, f, f2 + f4, n2);
        RectHelper.Method2163686(f + f3, f2, f + f3 + 1.0f, f2 + f4, n2);
        RectHelper.Method2163686(f - 1.0f, f2 - 1.0f, f + f3 + 1.0f, f2, n2);
        RectHelper.Method2163686(f - 1.0f, f2 + f4, f + f3 + 1.0f, f2 + f4 + 1.0f, n2);
    }
}

