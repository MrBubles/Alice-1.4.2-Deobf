

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class TessellatorUtil {
    private static final Minecraft Field4517 = Minecraft.getMinecraft();

    public static void Method2162015(BlockPos blockPos, double d, float f, Color color) {
        TessellatorUtil.Method2162017(TessellatorUtil.Method2162033(blockPos, 1.0, d, 1.0), f, color, color.getAlpha());
    }

    public static void Method2162016(AxisAlignedBB axisAlignedBB, double d, Color color) {
        TessellatorUtil.Method2162017(axisAlignedBB, d, color, color.getAlpha());
    }

    public static void Method2162017(AxisAlignedBB axisAlignedBB, double d, Color color, int n2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float) ((float) d));
        GlStateManager.color((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
        TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
        tessellator.draw();
    }

    public static void Method2162018(BlockPos blockPos, int n2, Color color, int n3) {
        TessellatorUtil.Method2162021(TessellatorUtil.Method2162033(blockPos, 1.0, 1.0, 1.0), n2, color, color.getAlpha(), n3);
    }

    public static void Method2162019(BlockPos blockPos, int n2, Color color, int n3, int n4) {
        TessellatorUtil.Method2162021(TessellatorUtil.Method2162033(blockPos, 1.0, 1.0, 1.0), n2, color, n3, n4);
    }

    public static void Method2162010(AxisAlignedBB axisAlignedBB, int n2, Color color, int n3) {
        TessellatorUtil.Method2162021(axisAlignedBB, n2, color, color.getAlpha(), n3);
    }

    public static void Method2162021(AxisAlignedBB axisAlignedBB, int n2, Color color, int n3, int n4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float) n2);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        TessellatorUtil.Method2162034(axisAlignedBB, color, n3, bufferBuilder, n4, true);
        tessellator.draw();
    }

    public static void Method2162022(BlockPos blockPos, double d, Color color, int n2) {
        TessellatorUtil.Method2162027(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0, d, 1.0, color, color.getAlpha(), n2);
    }

    public static void Method2162023(AxisAlignedBB axisAlignedBB, Color color) {
        TessellatorUtil.Method2162026(axisAlignedBB, true, 1.0, color, color.getAlpha(), 63);
    }

    public static void Method2162024(AxisAlignedBB axisAlignedBB, double d, Color color, int n2) {
        TessellatorUtil.Method2162026(axisAlignedBB, false, d, color, color.getAlpha(), n2);
    }

    public static void Method2162025(AxisAlignedBB axisAlignedBB, boolean bl, double d, Color color, int n2) {
        TessellatorUtil.Method2162026(axisAlignedBB, bl, d, color, color.getAlpha(), n2);
    }

    public static void Method2162026(AxisAlignedBB axisAlignedBB, boolean bl, double d, Color color, int n2, int n3) {
        if (bl) {
            TessellatorUtil.Method2162027(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, axisAlignedBB.maxY - axisAlignedBB.minY, axisAlignedBB.maxZ - axisAlignedBB.minZ, color, n2, n3);
        } else {
            TessellatorUtil.Method2162027(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, d, axisAlignedBB.maxZ - axisAlignedBB.minZ, color, n2, n3);
        }
    }

    public static void Method2162027(double d, double d2, double d3, double d4, double d5, double d6, Color color, int n2, int n3) {
        GlStateManager.disableAlpha();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        color.getRGB();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        TessellatorUtil.Method2162034(new AxisAlignedBB(d, d2, d3, d + d4, d2 + d5, d3 + d6), color, n2, bufferBuilder, n3, false);
        tessellator.draw();
        GlStateManager.enableAlpha();
    }

    public static void Method2162028(double d, double d2, double d3, double d4, double d5, double d6, Color color) {
        TessellatorUtil.Method2162029(d, d2, d3, d4, d5, d6, color, 1.0f);
    }

    public static void Method2162029(double d, double d2, double d3, double d4, double d5, double d6, Color color, float f) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float) f);
        color.getRGB();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        TessellatorUtil.Method2162031(d, d2, d3, bufferBuilder);
        TessellatorUtil.Method2162031(d4, d5, d6, bufferBuilder);
        tessellator.draw();
    }

    public static void Method2162020(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, Color color, float f) {
        int n2;
        for (n2 = 0; n2 < 4; ++n2) {
            TessellatorUtil.Method2162029(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[0], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field2467, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[1], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014((n2 + 1) % 4)[0], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field2467, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014((n2 + 1) % 4)[1], color, f);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            TessellatorUtil.Method2162029(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[0], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field2468, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[1], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014((n2 + 1) % 4)[0], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field2468, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014((n2 + 1) % 4)[1], color, f);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            TessellatorUtil.Method2162029(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[0], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field2467, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[1], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[0], iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field2468, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162014(n2)[1], color, f);
        }
    }

    private static void Method2162031(double d, double d2, double d3, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d - TessellatorUtil.Field4517.getRenderManager().viewerPosX, d2 - TessellatorUtil.Field4517.getRenderManager().viewerPosY, d3 - TessellatorUtil.Field4517.getRenderManager().viewerPosZ).endVertex();
    }

    private static void Method2162032(double d, double d2, double d3, Color color, int n2, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d - TessellatorUtil.Field4517.getRenderManager().viewerPosX, d2 - TessellatorUtil.Field4517.getRenderManager().viewerPosY, d3 - TessellatorUtil.Field4517.getRenderManager().viewerPosZ).color(color.getRed(), color.getGreen(), color.getBlue(), n2).endVertex();
    }

    private static AxisAlignedBB Method2162033(BlockPos blockPos, double d, double d2, double d3) {
        double d4 = blockPos.getX();
        double d5 = blockPos.getY();
        double d6 = blockPos.getZ();
        return new AxisAlignedBB(d4, d5, d6, d4 + d, d5 + d2, d6 + d3);
    }

    private static void Method2162034(AxisAlignedBB axisAlignedBB, Color color, int n2, BufferBuilder bufferBuilder, int n3, boolean bl) {
        if ((n3 & 0x20) != 0) {
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
            if (bl) {
                TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n3 & 0x10) != 0) {
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            if (bl) {
                TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n3 & 4) != 0) {
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            if (bl) {
                TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n3 & 8) != 0) {
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
            if (bl) {
                TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n3 & 2) != 0) {
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n2, bufferBuilder);
            if (bl) {
                TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n2, bufferBuilder);
            }
        }
        if ((n3 & 1) != 0) {
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            TessellatorUtil.Method2162032(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            if (bl) {
                TessellatorUtil.Method2162032(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            }
        }
    }

    public static void Method2162035() {
        GL11.glPushAttrib((int) 1048575);
        GL11.glHint((int) 3154, (int) 4354);
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.shadeModel((int) 7425);
        GlStateManager.depthMask((boolean) false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GL11.glEnable((int) 2848);
        GL11.glEnable((int) 34383);
    }

    public static void Method2162036() {
        GL11.glDisable((int) 34383);
        GL11.glDisable((int) 2848);
        GlStateManager.enableAlpha();
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.glLineWidth((float) 1.0f);
        GlStateManager.shadeModel((int) 7424);
        GL11.glHint((int) 3154, (int) 4352);
        GL11.glPopAttrib();
    }

    private static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public final double Field2467;
        public final double Field2468;
        private final double Field2465;
        private final double Field2466;
        private final float Field2469;
        double[][] Field2463 = new double[10][2];
        private int Field2464 = 0;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(double d, double d2, double d3, double d4, float f) {
            this.Field2467 = d;
            this.Field2468 = d2;
            this.Field2465 = d3;
            this.Field2466 = d4;
            this.Field2469 = f;
        }

        public void Method2162013(double d, double d2) {
            double d3 = (d -= this.Field2465) * Math.cos(this.Field2469) - (d2 -= this.Field2466) * Math.sin(this.Field2469);
            double d4 = d * Math.sin(this.Field2469) + d2 * Math.cos(this.Field2469);
            this.Field2463[this.Field2464++] = new double[]{d3 += this.Field2465, d4 += this.Field2466};
        }

        public double[] Method2162014(int n2) {
            return this.Field2463[n2];
        }
    }
}

