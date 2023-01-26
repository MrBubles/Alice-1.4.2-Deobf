

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colour;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtilCa;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderBuilder;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderUtilCa
        implements Util {
    private static final Map<Integer, Boolean> Field608 = new HashMap<Integer, Boolean>();
    public static ICamera Field609 = new Frustum();
    static Random Field607 = new Random();

    public static String Method2163191() {
        String[] arrstring = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.ENGLISH);
        return arrstring[Field607.nextInt(arrstring.length)];
    }

    public static Color Method2163192(Color color) {
        double d = (299.0f * (float) color.getRed() + 587.0f * (float) color.getGreen() + 114.0f * (float) color.getBlue()) / 1000.0f;
        return d >= 128.0 ? Color.black : Color.white;
    }

    public static void Method2163193(float f, float f2, float f3, float f4, float f5, float f6, int n2) {
        boolean bl = GL11.glIsEnabled((int) 3042);
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glPushMatrix();
        GL11.glLineWidth((float) f6);
        RenderUtilCa.Method2163194(n2);
        GL11.glBegin((int) 2);
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glVertex2d((double) (f - f3 / f4), (double) (f2 - f3));
        GL11.glVertex2d((double) f, (double) (f2 - f3 / f5));
        GL11.glVertex2d((double) (f + f3 / f4), (double) (f2 - f3));
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int) 3553);
        if (!bl) {
            GL11.glDisable((int) 3042);
        }
        GL11.glDisable((int) 2848);
    }

    public static void Method2163194(int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static void Method2163195(float f, float f2, float f3, float f4, float f5, int n2) {
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        float f9 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        GlStateManager.shadeModel((int) 7425);
        GL11.glLineWidth((float) f5);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f6, f7, f8, f9).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int) 7424);
        GL11.glDisable((int) 2848);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public static void Method2163196(double d, double d2, double d3, double d4, double d5, int n2) {
        double d6;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) ((float) d5));
        if (d < d3) {
            d6 = d;
            d = d3;
            d3 = d6;
        }
        if (d2 < d4) {
            d6 = d2;
            d2 = d4;
            d4 = d6;
        }
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(d, d4, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d, d2, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d, d4, 0.0).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163197(BlockPos blockPos, double d, Colour colour, int n2) {
        RenderUtilCa.Method2163222(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0, d, 1.0, colour, colour.getAlpha(), n2);
    }

    public static void Method2163198(AxisAlignedBB axisAlignedBB, boolean bl, double d, Colour colour, int n2) {
        RenderUtilCa.Method2163199(axisAlignedBB, bl, d, colour, colour.getAlpha(), n2);
    }

    public static void Method2163199(AxisAlignedBB axisAlignedBB, boolean bl, double d, Colour colour, int n2, int n3) {
        if (bl) {
            RenderUtilCa.Method2163222(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, axisAlignedBB.maxY - axisAlignedBB.minY, axisAlignedBB.maxZ - axisAlignedBB.minZ, colour, n2, n3);
        } else {
            RenderUtilCa.Method2163222(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, d, axisAlignedBB.maxZ - axisAlignedBB.minZ, colour, n2, n3);
        }
    }

    public static void Method2163190(BlockPos blockPos, Color color, Color color2, float f, boolean bl, boolean bl2, boolean bl3) {
        if (bl2) {
            RenderUtilCa.Method2163107(blockPos, color, bl3);
        }
        if (bl) {
            RenderUtilCa.Method2163105(blockPos, color2, f, bl3);
        }
    }

    public static AxisAlignedBB Method2163101(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(axisAlignedBB.minX - RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2163102(float f, float f2, float f3, float f4, int n2) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163103(BlockPos blockPos, Color color, float f, boolean bl, boolean bl2, int n2, Double d) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
        if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) f);
            if (bl2) {
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) n2 / 255.0f));
            }
            if (bl) {
                RenderGlobal.drawBoundingBox((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ, (double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
            }
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163104(BlockPos blockPos, Color color, Color color2, double d, boolean bl, boolean bl2, Float f) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY + (double) f.floatValue(), (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
        if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) ((float) d));
            if (bl2) {
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
            }
            if (bl) {
                RenderGlobal.drawBoundingBox((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ, (double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ, (float) ((float) color2.getRed() / 255.0f), (float) ((float) color2.getGreen() / 255.0f), (float) ((float) color2.getBlue() / 255.0f), (float) ((float) color2.getAlpha() / 255.0f));
            }
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163105(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = RenderUtilCa.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtilCa.Field2811.world.getWorldBorder().contains(blockPos)) {
            Vec3d vec3d = EntityUtilCa.Method2163127((Entity) RenderUtilCa.Field2811.player, Field2811.getRenderPartialTicks());
            RenderUtilCa.Method2163109(iBlockState.getSelectedBoundingBox((World) RenderUtilCa.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    public static void Method2163106(AxisAlignedBB axisAlignedBB, Color color, float f) {
        Vec3d vec3d = EntityUtilCa.Method2163127((Entity) RenderUtilCa.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtilCa.Method2163109(axisAlignedBB.grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
    }

    public static void Method2163107(BlockPos blockPos, Color color, boolean bl) {
        IBlockState iBlockState = RenderUtilCa.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtilCa.Field2811.world.getWorldBorder().contains(blockPos)) {
            Vec3d vec3d = EntityUtilCa.Method2163127((Entity) RenderUtilCa.Field2811.player, Field2811.getRenderPartialTicks());
            AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtilCa.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z);
            Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
            if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.disableDepth();
                GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean) false);
                GL11.glEnable((int) 2848);
                GL11.glHint((int) 3154, (int) 4354);
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                GL11.glDisable((int) 2848);
                GlStateManager.depthMask((boolean) true);
                GlStateManager.enableDepth();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
    }

    public static void Method2163108(AxisAlignedBB axisAlignedBB, Color color, Color color2, float f) {
        float f2 = (float) color.getRed() / 255.0f;
        float f3 = (float) color.getGreen() / 255.0f;
        float f4 = (float) color.getBlue() / 255.0f;
        float f5 = (float) color.getAlpha() / 255.0f;
        float f6 = (float) color2.getRed() / 255.0f;
        float f7 = (float) color2.getGreen() / 255.0f;
        float f8 = (float) color2.getBlue() / 255.0f;
        float f9 = (float) color2.getAlpha() / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163109(AxisAlignedBB axisAlignedBB, Color color, float f) {
        float f2 = (float) color.getRed() / 255.0f;
        float f3 = (float) color.getGreen() / 255.0f;
        float f4 = (float) color.getBlue() / 255.0f;
        float f5 = (float) color.getAlpha() / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163100(BlockPos blockPos, Color color, Color color2, float f, double d) {
        IBlockState iBlockState = RenderUtilCa.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtilCa.Method2163127((Entity) RenderUtilCa.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtilCa.Method2163108(iBlockState.getSelectedBoundingBox((World) RenderUtilCa.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z).expand(0.0, d, 0.0), color, color2, f);
    }

    public static void Method2163211(BlockPos blockPos, Color color, float f, boolean bl, double d, boolean bl2, boolean bl3) {
        if (bl2) {
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
            RenderUtilCa.Method2163100(blockPos, bl3 ? color2 : color, bl3 ? color : color2, f, d);
            return;
        }
        IBlockState iBlockState = RenderUtilCa.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtilCa.Field2811.world.getWorldBorder().contains(blockPos)) {
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
            RenderUtilCa.Method2163109(axisAlignedBB.grow((double) 0.002f), color, f);
        }
    }

    public static void Method2163212(BlockPos blockPos, Color color, Color color2, float f, boolean bl, boolean bl2, boolean bl3, double d, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n2) {
        if (bl2) {
            RenderUtilCa.Method2163217(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()), d, bl4, bl6, n2);
        }
        if (bl) {
            RenderUtilCa.Method2163211(blockPos, color2, f, bl3, d, bl5, bl7);
        }
    }

    public static void Method2163213(BlockPos blockPos, EnumFacing enumFacing, Color color, Color color2, double d) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        IBlockState iBlockState = RenderUtilCa.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtilCa.Method2163127((Entity) RenderUtilCa.Field2811.player, Field2811.getRenderPartialTicks());
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtilCa.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z).expand(0.0, d, 0.0);
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        float f5 = (float) color2.getRed() / 255.0f;
        float f6 = (float) color2.getGreen() / 255.0f;
        float f7 = (float) color2.getBlue() / 255.0f;
        float f8 = (float) color2.getAlpha() / 255.0f;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        if (enumFacing == EnumFacing.DOWN) {
            d2 = axisAlignedBB.minX;
            d5 = axisAlignedBB.maxX;
            d3 = axisAlignedBB.minY;
            d6 = axisAlignedBB.minY;
            d4 = axisAlignedBB.minZ;
            d7 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.UP) {
            d2 = axisAlignedBB.minX;
            d5 = axisAlignedBB.maxX;
            d3 = axisAlignedBB.maxY;
            d6 = axisAlignedBB.maxY;
            d4 = axisAlignedBB.minZ;
            d7 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.EAST) {
            d2 = axisAlignedBB.maxX;
            d5 = axisAlignedBB.maxX;
            d3 = axisAlignedBB.minY;
            d6 = axisAlignedBB.maxY;
            d4 = axisAlignedBB.minZ;
            d7 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.WEST) {
            d2 = axisAlignedBB.minX;
            d5 = axisAlignedBB.minX;
            d3 = axisAlignedBB.minY;
            d6 = axisAlignedBB.maxY;
            d4 = axisAlignedBB.minZ;
            d7 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.SOUTH) {
            d2 = axisAlignedBB.minX;
            d5 = axisAlignedBB.maxX;
            d3 = axisAlignedBB.minY;
            d6 = axisAlignedBB.maxY;
            d4 = axisAlignedBB.maxZ;
            d7 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.NORTH) {
            d2 = axisAlignedBB.minX;
            d5 = axisAlignedBB.maxX;
            d3 = axisAlignedBB.minY;
            d6 = axisAlignedBB.maxY;
            d4 = axisAlignedBB.minZ;
            d7 = axisAlignedBB.minZ;
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.depthMask((boolean) false);
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        if (enumFacing == EnumFacing.EAST || enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.NORTH || enumFacing == EnumFacing.SOUTH) {
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.UP) {
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.DOWN) {
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
        }
        tessellator.draw();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
    }

    public static void Method2163214(AxisAlignedBB axisAlignedBB, EnumFacing enumFacing, Color color, Color color2, double d) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        float f5 = (float) color2.getRed() / 255.0f;
        float f6 = (float) color2.getGreen() / 255.0f;
        float f7 = (float) color2.getBlue() / 255.0f;
        float f8 = (float) color2.getAlpha() / 255.0f;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = 0.0;
        switch (1.F ield2328[enumFacing.ordinal()]){
            case 1: {
                d2 = axisAlignedBB.minX;
                d5 = axisAlignedBB.maxX;
                d3 = axisAlignedBB.minY;
                d6 = axisAlignedBB.minY;
                d4 = axisAlignedBB.minZ;
                d7 = axisAlignedBB.maxZ;
                break;
            }
            case 2: {
                d2 = axisAlignedBB.minX;
                d5 = axisAlignedBB.maxX;
                d3 = axisAlignedBB.maxY;
                d6 = axisAlignedBB.maxY;
                d4 = axisAlignedBB.minZ;
                d7 = axisAlignedBB.maxZ;
                break;
            }
            case 3: {
                d2 = axisAlignedBB.maxX;
                d5 = axisAlignedBB.maxX;
                d3 = axisAlignedBB.minY;
                d6 = axisAlignedBB.maxY;
                d4 = axisAlignedBB.minZ;
                d7 = axisAlignedBB.maxZ;
                break;
            }
            case 4: {
                d2 = axisAlignedBB.minX;
                d5 = axisAlignedBB.minX;
                d3 = axisAlignedBB.minY;
                d6 = axisAlignedBB.maxY;
                d4 = axisAlignedBB.minZ;
                d7 = axisAlignedBB.maxZ;
                break;
            }
            case 5: {
                d2 = axisAlignedBB.minX;
                d5 = axisAlignedBB.maxX;
                d3 = axisAlignedBB.minY;
                d6 = axisAlignedBB.maxY;
                d4 = axisAlignedBB.maxZ;
                d7 = axisAlignedBB.maxZ;
                break;
            }
            case 6: {
                d2 = axisAlignedBB.minX;
                d5 = axisAlignedBB.maxX;
                d3 = axisAlignedBB.minY;
                d6 = axisAlignedBB.maxY;
                d4 = axisAlignedBB.minZ;
                d7 = axisAlignedBB.minZ;
            }
        }
        if (enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP || enumFacing == EnumFacing.EAST || enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.SOUTH || enumFacing == EnumFacing.NORTH) {
            // empty if block
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.depthMask((boolean) false);
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        if (enumFacing == EnumFacing.EAST || enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.NORTH || enumFacing == EnumFacing.SOUTH) {
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.UP) {
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.DOWN) {
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d3, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d2, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d4).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d5, d6, d7).color(f, f2, f3, f4).endVertex();
        }
        tessellator.draw();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
    }

    public static void Method2163215(AxisAlignedBB axisAlignedBB, Color color, Color color2, double d) {
        Vec3d vec3d = EntityUtilCa.Method2163127((Entity) RenderUtilCa.Field2811.player, Field2811.getRenderPartialTicks());
        for (EnumFacing enumFacing : EnumFacing.values()) {
            RenderUtilCa.Method2163214(axisAlignedBB.grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), enumFacing, color, color2, d);
        }
    }

    public static void Method2163216(BlockPos blockPos, Color color, Color color2, double d) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.UP) continue;
            RenderUtilCa.Method2163213(blockPos, enumFacing, color, color2, d);
        }
    }

    public static void Method2163217(BlockPos blockPos, Color color, double d, boolean bl, boolean bl2, int n2) {
        if (bl) {
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
            RenderUtilCa.Method2163216(blockPos, bl2 ? color2 : color, bl2 ? color : color2, d);
            return;
        }
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
        if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163218(AxisAlignedBB axisAlignedBB, Color color, int n2) {
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
        if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB2.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB2.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB2, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) n2 / 255.0f));
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163219(AxisAlignedBB axisAlignedBB, Colour colour, int n2) {
    }

    public static void Method2163222(double d, double d2, double d3, double d4, double d5, double d6, Colour colour, int n2, int n3) {
        GlStateManager.disableAlpha();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        colour.Method2162071();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCa.Method2163227(new AxisAlignedBB(d, d2, d3, d + d4, d2 + d5, d3 + d6), colour, n2, bufferBuilder, n3, false);
        tessellator.draw();
        GlStateManager.enableAlpha();
    }

    private static AxisAlignedBB Method2163223(BlockPos blockPos, double d, double d2, double d3) {
        double d4 = blockPos.getX();
        double d5 = blockPos.getY();
        double d6 = blockPos.getZ();
        return new AxisAlignedBB(d4, d5, d6, d4 + d, d5 + d2, d6 + d3);
    }

    public static AxisAlignedBB Method2163224(BlockPos blockPos) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        return axisAlignedBB;
    }

    public static void Method2163225(AxisAlignedBB axisAlignedBB, double d, Colour colour, int n2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float) ((float) d));
        colour.Method2162071();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, colour.getAlpha(), bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
        RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
        tessellator.draw();
    }

    private static void Method2163226(double d, double d2, double d3, Colour colour, int n2, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d - RenderUtilCa.Field2811.getRenderManager().viewerPosX, d2 - RenderUtilCa.Field2811.getRenderManager().viewerPosY, d3 - RenderUtilCa.Field2811.getRenderManager().viewerPosZ).color(colour.getRed(), colour.getGreen(), colour.getBlue(), n2).endVertex();
    }

    private static void Method2163227(AxisAlignedBB axisAlignedBB, Colour colour, int n2, BufferBuilder bufferBuilder, int n3, boolean bl) {
        if ((n3 & 0x20) != 0 || n3 == -1) {
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            if (bl) {
                RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            }
        }
        if ((n3 & 0x10) != 0 || n3 == -1) {
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            if (bl) {
                RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            }
        }
        if ((n3 & 4) != 0 || n3 == -1) {
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            if (bl) {
                RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            }
        }
        if ((n3 & 8) != 0 || n3 == -1) {
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            if (bl) {
                RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            }
        }
        if ((n3 & 2) != 0 || n3 == -1) {
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            if (bl) {
                RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            }
        }
        if ((n3 & 1) != 0 || n3 == -1) {
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, colour, n2, bufferBuilder);
            RenderUtilCa.Method2163226(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            if (bl) {
                RenderUtilCa.Method2163226(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, colour, n2, bufferBuilder);
            }
        }
    }

    public static void Method2163228(BlockPos blockPos, int n2, Colour colour, int n3) {
        RenderUtilCa.Method2163231(RenderUtilCa.Method2163223(blockPos, 1.0, 1.0, 1.0), n2, colour, colour.getAlpha(), n3);
    }

    public static void Method2163229(BlockPos blockPos, int n2, Colour colour, int n3, int n4) {
        RenderUtilCa.Method2163231(RenderUtilCa.Method2163223(blockPos, 1.0, 1.0, 1.0), n2, colour, n3, n4);
    }

    public static void Method2163220(AxisAlignedBB axisAlignedBB, int n2, Colour colour, int n3) {
        RenderUtilCa.Method2163231(axisAlignedBB, n2, colour, colour.getAlpha(), n3);
    }

    public static void Method2163231(AxisAlignedBB axisAlignedBB, int n2, Colour colour, int n3, int n4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float) n2);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCa.Method2163227(axisAlignedBB, colour, n3, bufferBuilder, n4, true);
        tessellator.draw();
    }

    public static void Method2163232(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        RenderUtilCa.Method2163233(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    public static void Method2163233(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - RenderUtilCa.Field2811.getRenderManager().renderPosX), (double) ((double) f2 - RenderUtilCa.Field2811.getRenderManager().renderPosY), (double) ((double) f3 - RenderUtilCa.Field2811.getRenderManager().renderPosZ));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-RenderUtilCa.Field2811.player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) RenderUtilCa.Field2811.player.rotationPitch, (float) (RenderUtilCa.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2163234(BlockPos blockPos, double d, Float f, Color color, Color color2) {
        RenderUtilCa.Method2163103(blockPos, color2, f.floatValue(), true, false, color2.getAlpha(), -1.0);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        RenderBuilder.Method2163958();
        RenderBuilder.Method2163950();
        RenderUtilCa.Method2163235(axisAlignedBB, d, new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()), new Color(color.getRed(), color.getGreen(), color.getBlue(), 0));
        RenderBuilder.Method2163961();
        RenderBuilder.Method2163959();
    }

    public static void Method2163235(AxisAlignedBB axisAlignedBB, double d, Color color, Color color2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        RenderUtilCa.Method2163236(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY + d, axisAlignedBB.maxZ, color, color2);
        tessellator.draw();
    }

    public static void Method2163236(double d, double d2, double d3, double d4, double d5, double d6, Color color, Color color2) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d4, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d2, d6).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d5, d6).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
        bufferBuilder.pos(d, d5, d3).color((float) color2.getRed() / 255.0f, (float) color2.getGreen() / 255.0f, (float) color2.getBlue() / 255.0f, (float) color2.getAlpha() / 255.0f).endVertex();
    }

    public static void Method2163237(BlockPos blockPos, double d, double d2, double d3, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
        if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferBuilder = tessellator.getBuffer();
            bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            RenderUtilCa.Method2163239(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX + d2, axisAlignedBB.maxY + d, axisAlignedBB.maxZ + d3, color);
            tessellator.draw();
        }
    }

    public static void Method2163238(BlockPos blockPos, double d, double d2, double d3, Color color) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        AxisAlignedBB axisAlignedBB = RenderUtilCa.Method2163224(blockPos);
        RenderUtilCa.Method2163239(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX + d2, axisAlignedBB.maxY + d, axisAlignedBB.maxZ + d3, color);
        tessellator.draw();
    }

    public static void Method2163239(double d, double d2, double d3, double d4, double d5, double d6, Color color) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d2, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d2, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d2, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d2, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4 - 0.8, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4 - 0.8, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d + 0.8, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d + 0.8, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d2 + 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d2 + 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d2 + 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d2 + 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d5, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d5, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d5, d6 - 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d5, d3 + 0.8).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4 - 0.8, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4 - 0.8, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d + 0.8, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d + 0.8, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d5 - 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d, d5 - 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d5 - 0.2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(d4, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        bufferBuilder.pos(d4, d5 - 0.2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
    }

    public static void Method2163230(float f, float f2, float f3, float f4, Colour colour) {
        BlockPos blockPos = new BlockPos((double) f, (double) f2, (double) f3);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        RenderUtilCa.Method2163242(axisAlignedBB, f4, colour);
    }

    public static void Method2163241(float f, float f2, float f3, float f4, Colour colour, int n2, double d) {
        double d2 = d / (double) n2;
        float f5 = f4 / (float) n2 * (float) d;
        BlockPos blockPos = new BlockPos((double) f, (double) f2, (double) f3);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtilCa.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtilCa.Field2811.getRenderManager().viewerPosZ);
        Field609.setPosition(Objects.requireNonNull(RenderUtilCa.Field2811.getRenderViewEntity()).posX, RenderUtilCa.Field2811.getRenderViewEntity().posY, RenderUtilCa.Field2811.getRenderViewEntity().posZ);
        if (Field609.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtilCa.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtilCa.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtilCa.Field2811.getRenderManager().viewerPosZ))) {
            for (int j = 0; j <= n2; ++j) {
                axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY + d2 * (double) j, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY + d2 * (double) j, axisAlignedBB.maxZ);
                RenderUtilCa.Method2163242(axisAlignedBB, f5 * (float) j, colour);
            }
        }
    }

    public static void Method2163242(AxisAlignedBB axisAlignedBB, float f, Colour colour) {
        float f2 = (float) colour.getRed() / 255.0f;
        float f3 = (float) colour.getGreen() / 255.0f;
        float f4 = (float) colour.getBlue() / 255.0f;
        float f5 = (float) colour.getAlpha() / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) 1.0f);
        for (int j = 0; j < 360; ++j) {
            bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferBuilder.pos(axisAlignedBB.getCenter().x + Math.sin((double) j * 3.1415926 / 180.0) * (double) f, axisAlignedBB.minY, axisAlignedBB.getCenter().z + Math.cos((double) j * 3.1415926 / 180.0) * (double) f).color(f2, f3, f4, f5).endVertex();
            bufferBuilder.pos(axisAlignedBB.getCenter().x + Math.sin((double) (j + 1) * 3.1415926 / 180.0) * (double) f, axisAlignedBB.minY, axisAlignedBB.getCenter().z + Math.cos((double) (j + 1) * 3.1415926 / 180.0) * (double) f).color(f2, f3, f4, f5).endVertex();
            tessellator.draw();
        }
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public void Method2163210() {
        Field608.forEach((arg_0, arg_1) -> this.Method2163221(arg_0, arg_1));
    }

    public void Method2163221(int n2, boolean bl) {
        if (bl) {
            GL11.glEnable((int) n2);
        } else {
            GL11.glDisable((int) n2);
        }
    }
}

