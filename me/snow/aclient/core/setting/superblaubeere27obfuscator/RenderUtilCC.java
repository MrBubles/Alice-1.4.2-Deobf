

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderBuilderCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class RenderUtilCC
        implements Util {
    public static Tessellator Field684 = Tessellator.getInstance();
    public static BufferBuilder Field685 = Field684.getBuffer();
    private static ScaledResolution Field686 = new ScaledResolution(Field2811);

    public static void Method2163310(RenderBuilderCC renderBuilderCC) {
        if (Field2811.getRenderViewEntity() != null) {
            AxisAlignedBB axisAlignedBB = renderBuilderCC.Method2163314().offset(-RenderUtilCC.Field2811.getRenderManager().viewerPosX, -RenderUtilCC.Field2811.getRenderManager().viewerPosY, -RenderUtilCC.Field2811.getRenderManager().viewerPosZ);
            switch (1.F ield2604[renderBuilderCC.Method2163319().ordinal()]){
                case 1: {
                    RenderUtilCC.Method2163321(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), renderBuilderCC.Method2163318());
                    break;
                }
                case 2: {
                    RenderUtilCC.Method2163323(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), new Color(renderBuilderCC.Method2163318().getRed(), renderBuilderCC.Method2163318().getGreen(), renderBuilderCC.Method2163318().getBlue(), 144));
                    break;
                }
                case 3: {
                    RenderUtilCC.Method2163321(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), renderBuilderCC.Method2163318());
                    RenderUtilCC.Method2163323(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), new Color(renderBuilderCC.Method2163318().getRed(), renderBuilderCC.Method2163318().getGreen(), renderBuilderCC.Method2163318().getBlue(), 144));
                    break;
                }
                case 4: {
                    RenderUtilCC.Method2163325(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), renderBuilderCC.Method2163318(), new Color(renderBuilderCC.Method2163318().getRed(), renderBuilderCC.Method2163318().getGreen(), renderBuilderCC.Method2163318().getBlue(), 0));
                    break;
                }
                case 5: {
                    RenderUtilCC.Method2163325(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), new Color(renderBuilderCC.Method2163318().getRed(), renderBuilderCC.Method2163318().getGreen(), renderBuilderCC.Method2163318().getBlue(), 0), renderBuilderCC.Method2163318());
                    break;
                }
                case 6: {
                    RenderUtilCC.Method2163327(axisAlignedBB, renderBuilderCC.Method2163315(), renderBuilderCC.Method2163317(), renderBuilderCC.Method2163316(), new Color(renderBuilderCC.Method2163318().getRed(), renderBuilderCC.Method2163318().getGreen(), renderBuilderCC.Method2163318().getBlue(), 255));
                }
            }
            renderBuilderCC.Method2163205();
        }
    }

    public static void Method2163321(AxisAlignedBB axisAlignedBB, double d, double d2, double d3, Color color) {
        Field685.begin(5, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCC.Method2163322(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX + d2, axisAlignedBB.maxY + d, axisAlignedBB.maxZ + d3, color);
        Field684.draw();
    }

    public static void Method2163322(double d, double d2, double d3, double d4, double d5, double d6, Color color) {
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
    }

    public static void Method2163323(AxisAlignedBB axisAlignedBB, double d, double d2, double d3, Color color) {
        Field685.begin(3, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCC.Method2163324(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX + d2, axisAlignedBB.maxY + d, axisAlignedBB.maxZ + d3, color);
        Field684.draw();
    }

    public static void Method2163324(double d, double d2, double d3, double d4, double d5, double d6, Color color) {
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
    }

    public static void Method2163325(AxisAlignedBB axisAlignedBB, double d, double d2, double d3, Color color, Color color2) {
        Field685.begin(7, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCC.Method2163326(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX + d2, axisAlignedBB.maxY + d, axisAlignedBB.maxZ + d3, color, color2);
        Field684.draw();
    }

    public static void Method2163326(double d, double d2, double d3, double d4, double d5, double d6, Color color, Color color2) {
        Field685.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d4, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        Field685.pos(d, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
    }

    public static void Method2163327(AxisAlignedBB axisAlignedBB, double d, double d2, double d3, Color color) {
        Field685.begin(3, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCC.Method2163328(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX + d2, axisAlignedBB.maxY + d, axisAlignedBB.maxZ + d3, color);
        Field684.draw();
    }

    public static void Method2163328(double d, double d2, double d3, double d4, double d5, double d6, Color color) {
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d2, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d2, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d2, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d2, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4 - 0.8, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4 - 0.8, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d + 0.8, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d + 0.8, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d2 + 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d2 + 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d2 + 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d2 + 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d5, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d5, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d5, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d5, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4 - 0.8, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4 - 0.8, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d + 0.8, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d + 0.8, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d5 - 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d, d5 - 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d5 - 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field685.pos(d4, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), 0).endVertex();
        Field685.pos(d4, d5 - 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
    }

    public static void Method2163329(RenderBuilderCC renderBuilderCC, Vec3d vec3d, double d, double d2, Color color) {
        RenderUtilCC.Method2163320(Field685, vec3d, d, d2, color);
        renderBuilderCC.Method2163205();
    }

    public static void Method2163320(BufferBuilder bufferBuilder, Vec3d vec3d, double d, double d2, Color color) {
        GlStateManager.disableCull();
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel((int) 7425);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int j = 0; j < 361; ++j) {
            bufferBuilder.pos(vec3d.x + Math.sin(Math.toRadians(j)) * d - RenderUtilCC.Field2811.getRenderManager().viewerPosX, vec3d.y + d2 - RenderUtilCC.Field2811.getRenderManager().viewerPosY, vec3d.z + Math.cos(Math.toRadians(j)) * d - RenderUtilCC.Field2811.getRenderManager().viewerPosZ).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, 1.0f).endVertex();
        }
        Field684.draw();
        GlStateManager.enableCull();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int) 7424);
    }

    public static void Method2163331(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        RenderUtilCC.Method2163332(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    public static void Method2163332(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - RenderUtilCC.Field2811.getRenderManager().viewerPosX), (double) ((double) f2 - RenderUtilCC.Field2811.getRenderManager().viewerPosY), (double) ((double) f3 - RenderUtilCC.Field2811.getRenderManager().viewerPosZ));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-RenderUtilCC.Field2811.player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) RenderUtilCC.Field2811.player.rotationPitch, (float) (RenderUtilCC.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2163333(Vec3d vec3d, Vec3d vec3d2, Color color, double d) {
        GL11.glDepthMask((boolean) false);
        GL11.glDisable((int) 2929);
        GL11.glDisable((int) 3008);
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) 0.1f);
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL11.glLineWidth((float) ((float) d));
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) vec3d.x, (double) vec3d.y, (double) vec3d.z);
        GL11.glVertex3d((double) vec3d2.x, (double) vec3d2.y, (double) vec3d2.z);
        GL11.glEnd();
        GL11.glDepthMask((boolean) true);
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 3008);
        GL11.glDisable((int) 2848);
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
    }

    public static void Method2163334(float f, float f2, float f3, float f4, int n2) {
        Color color = new Color(n2, true);
        GL11.glPushMatrix();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glShadeModel((int) 7425);
        GL11.glBegin((int) 7);
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL11.glVertex2f((float) f, (float) f2);
        GL11.glVertex2f((float) f, (float) (f2 + f4));
        GL11.glVertex2f((float) (f + f3), (float) (f2 + f4));
        GL11.glVertex2f((float) (f + f3), (float) f2);
        GL11.glColor4f((float) 0.0f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
        GL11.glEnd();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2163335(float f, float f2, float f3, float f4, Color color) {
        GL11.glPushMatrix();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glShadeModel((int) 7425);
        GL11.glBegin((int) 7);
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL11.glVertex2f((float) f, (float) f2);
        GL11.glVertex2f((float) f, (float) (f2 + f4));
        GL11.glVertex2f((float) (f + f3), (float) (f2 + f4));
        GL11.glVertex2f((float) (f + f3), (float) f2);
        GL11.glColor4f((float) 0.0f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
        GL11.glEnd();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2163336(float f, float f2, float f3, float f4, Color color) {
        RenderUtilCC.Method2163335(f - 0.5f, f2 - 0.5f, 0.5f, f4 + 1.0f, color);
        RenderUtilCC.Method2163335(f + f3, f2 - 0.5f, 0.5f, f4 + 1.0f, color);
        RenderUtilCC.Method2163335(f, f2 - 0.5f, f3, 0.5f, color);
        RenderUtilCC.Method2163335(f, f2 + f4, f3, 0.5f, color);
    }

    public static void Method2163337(double d, double d2, double d3, double d4, double d5, Color color) {
        int n2;
        GL11.glPushAttrib((int) 0);
        GL11.glScaled((double) 0.5, (double) 0.5, (double) 0.5);
        d3 *= 2.0;
        d4 *= 2.0;
        d3 += (d *= 2.0);
        d4 += (d2 *= 2.0);
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL11.glEnable((int) 2848);
        GL11.glBegin((int) 9);
        for (n2 = 0; n2 <= 90; ++n2) {
            GL11.glVertex2d((double) (d + d5 + Math.sin((double) n2 * Math.PI / 180.0) * d5 * -1.0), (double) (d2 + d5 + Math.cos((double) n2 * Math.PI / 180.0) * d5 * -1.0));
        }
        for (n2 = 90; n2 <= 180; ++n2) {
            GL11.glVertex2d((double) (d + d5 + Math.sin((double) n2 * Math.PI / 180.0) * d5 * -1.0), (double) (d4 - d5 + Math.cos((double) n2 * Math.PI / 180.0) * d5 * -1.0));
        }
        for (n2 = 0; n2 <= 90; ++n2) {
            GL11.glVertex2d((double) (d3 - d5 + Math.sin((double) n2 * Math.PI / 180.0) * d5), (double) (d4 - d5 + Math.cos((double) n2 * Math.PI / 180.0) * d5));
        }
        for (n2 = 90; n2 <= 180; ++n2) {
            GL11.glVertex2d((double) (d3 - d5 + Math.sin((double) n2 * Math.PI / 180.0) * d5), (double) (d2 + d5 + Math.cos((double) n2 * Math.PI / 180.0) * d5));
        }
        GL11.glEnd();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 3553);
        GL11.glScaled((double) 2.0, (double) 2.0, (double) 2.0);
        GL11.glPopAttrib();
    }

    public static void Method2163338(double d, double d2, float f, int n2, Color color) {
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        Field685.begin(6, DefaultVertexFormats.POSITION);
        Field685.pos(d, d2, 0.0).endVertex();
        double d3 = Math.PI * 2;
        for (int j = 0; j <= n2; ++j) {
            double d4 = d3 * (double) j / (double) n2 + Math.toRadians(180.0);
            Field685.pos(d + Math.sin(d4) * (double) f, d2 + Math.cos(d4) * (double) f, 0.0).endVertex();
        }
        Field684.draw();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
    }

    public static double Method2163339() {
        return Field686.getScaledWidth_double();
    }

    public static double Method2163330() {
        return Field686.getScaledHeight_double();
    }
}

