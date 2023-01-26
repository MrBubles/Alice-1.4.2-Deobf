

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    public static Frustum Field4227 = new Frustum();

    public static void Method2163693(float f, float f2, float f3, double d) {
        ScaledResolution scaledResolution = new ScaledResolution(Util.Field2811);
        int n2 = scaledResolution.getScaleFactor();
        GL11.glScissor((int) ((int) (f * (float) n2)), (int) ((int) (((double) scaledResolution.getScaledHeight() - d) * (double) n2)), (int) ((int) ((f3 - f) * (float) n2)), (int) ((int) ((d - (double) f2) * (double) n2)));
    }

    public static boolean Method2163694(Entity entity) {
        return RenderHelper.Method2163695(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
    }

    private static boolean Method2163695(AxisAlignedBB axisAlignedBB) {
        Entity entity = Util.Field2811.getRenderViewEntity();
        if (entity != null) {
            Field4227.setPosition(entity.posX, entity.posY, entity.posZ);
        }
        return Field4227.isBoundingBoxInFrustum(axisAlignedBB);
    }

    public static int Method2163696(int n2, float f) {
        int n3 = (int) ((float) (n2 >> 16 & 0xFF) * f);
        int n4 = (int) ((float) (n2 >> 8 & 0xFF) * f);
        int n5 = (int) ((float) (n2 & 0xFF) * f);
        int n6 = n2 >> 24 & 0xFF;
        return (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF | (n6 & 0xFF) << 24;
    }

    public static void Method2163697(int n2) {
        GL11.glColor4ub((byte) ((byte) (n2 >> 16 & 0xFF)), (byte) ((byte) (n2 >> 8 & 0xFF)), (byte) ((byte) (n2 & 0xFF)), (byte) ((byte) (n2 >> 24 & 0xFF)));
    }

    public static void Method2163698(Color color, float f) {
        float f2 = (float) color.getRed() / 255.0f;
        float f3 = (float) color.getGreen() / 255.0f;
        float f4 = (float) color.getBlue() / 255.0f;
        GlStateManager.color((float) f2, (float) f3, (float) f4, (float) f);
    }

    public static void Method2163699(Entity entity, double d, float f, int n2, float f2, int n3) {
        GL11.glPushMatrix();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glDisable((int) 2929);
        GL11.glLineWidth((float) f2);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 2929);
        GL11.glBegin((int) 3);
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f - Util.Field2811.getRenderManager().renderPosX;
        double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f - Util.Field2811.getRenderManager().renderPosY;
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f - Util.Field2811.getRenderManager().renderPosZ;
        RenderHelper.Method2163697(n3);
        for (int j = 0; j <= n2; ++j) {
            GL11.glVertex3d((double) (d2 + d * Math.cos((double) j * 6.28 / (double) n2)), (double) d3, (double) (d4 + d * Math.sin((double) j * 6.28 / (double) n2)));
        }
        GL11.glEnd();
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 2929);
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 3553);
        GL11.glPopMatrix();
    }

    public static void Method2163690(Entity entity, double d, float f, int n2, float f2, int n3) {
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f - Util.Field2811.getRenderManager().renderPosX;
        double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f - Util.Field2811.getRenderManager().renderPosY;
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f - Util.Field2811.getRenderManager().renderPosZ;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        for (int j = 0; j <= n2; ++j) {
            bufferBuilder.pos(d2 + d * Math.cos((double) j * 6.28 / (double) n2), d3, d4 + d * Math.sin((double) j * 6.28 / (double) n2)).color(1.0f, 0.0f, 1.0f, 0.5f).endVertex();
        }
        tessellator.draw();
    }

    public static void Method2163601(float f, float f2, float f3, double d, float f4, int n2, float f5, int n3) {
        GL11.glPushMatrix();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glDisable((int) 2929);
        GL11.glLineWidth((float) f5);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 2929);
        GL11.glBegin((int) 3);
        RenderHelper.Method2163697(n3);
        for (int j = 0; j <= n2; ++j) {
            GL11.glVertex3d((double) ((double) f + d * Math.cos((double) j * 6.28 / (double) n2)), (double) f2, (double) ((double) f3 + d * Math.sin((double) j * 6.28 / (double) n2)));
        }
        GL11.glEnd();
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 2929);
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 3553);
        GL11.glPopMatrix();
    }

    public static void Method2163602(Entity entity, float f, double d, float f2, int n2, float f3, int n3) {
        GL11.glPushMatrix();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glDisable((int) 2929);
        GL11.glLineWidth((float) f3);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 2929);
        GL11.glBegin((int) 3);
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f2 - Util.Field2811.getRenderManager().renderPosX;
        double d3 = (double) f + (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f2 - Util.Field2811.getRenderManager().renderPosY);
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f2 - Util.Field2811.getRenderManager().renderPosZ;
        RenderHelper.Method2163697(n3);
        for (int j = 0; j <= n2; ++j) {
            GL11.glVertex3d((double) (d2 + d * Math.cos((double) j * 6.28 / (double) n2)), (double) d3, (double) (d4 + d * Math.sin((double) j * 6.28 / (double) n2)));
        }
        GL11.glEnd();
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 2929);
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 3553);
        GL11.glPopMatrix();
    }

    public static void Method2163603(Entity entity, Color color, boolean bl, float f) {
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 3042);
        GlStateManager.glLineWidth((float) 2.0f);
        GlStateManager.disableTexture2D();
        GL11.glDisable((int) 2929);
        GlStateManager.depthMask((boolean) false);
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) Util.Field2811.timer.renderPartialTicks - Util.Field2811.getRenderManager().renderPosX;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) Util.Field2811.timer.renderPartialTicks - Util.Field2811.getRenderManager().renderPosY;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) Util.Field2811.timer.renderPartialTicks - Util.Field2811.getRenderManager().renderPosZ;
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d - 0.05, axisAlignedBB.minY - entity.posY + d2, axisAlignedBB.minZ - entity.posZ + d3 - 0.05, axisAlignedBB.maxX - entity.posX + d + 0.05, axisAlignedBB.maxY - entity.posY + d2 + 0.15, axisAlignedBB.maxZ - entity.posZ + d3 + 0.05);
        GlStateManager.glLineWidth((float) 2.0f);
        GL11.glEnable((int) 2848);
        GlStateManager.color((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) f);
        if (bl) {
            RenderHelper.Method2163600(axisAlignedBB2, (float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, f);
            GlStateManager.color((float) 0.0f, (float) 0.0f, (float) 0.0f, (float) 0.5f);
        }
        RenderHelper.Method2163604(axisAlignedBB2);
        GlStateManager.glLineWidth((float) 2.0f);
        GlStateManager.enableTexture2D();
        GL11.glEnable((int) 2929);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163604(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
    }

    public static void Method2163605(float f, float f2, boolean bl, int n2) {
        GL11.glPushMatrix();
        GlStateManager.scale((double) 0.8, (double) 0.8, (double) 1.0);
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glDisable((int) 3553);
        RenderHelper.Method2163697(n2);
        GL11.glLineWidth((float) 2.0f);
        GL11.glBegin((int) 1);
        GL11.glVertex2d((double) f, (double) (f2 + (float) (bl ? 4 : 0)));
        GL11.glVertex2d((double) (f + 3.0f), (double) (f2 + (float) (bl ? 0 : 4)));
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex2d((double) (f + 3.0f), (double) (f2 + (float) (bl ? 0 : 4)));
        GL11.glVertex2d((double) (f + 6.0f), (double) (f2 + (float) (bl ? 4 : 0)));
        GL11.glEnd();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 2848);
        GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 1.0f);
        GL11.glPopMatrix();
    }

    public static void Method2163606(float f, float f2, int n2, float f3, float f4, float f5, boolean bl, Color color) {
        float f6;
        float f7;
        float f8;
        GlStateManager.color((float) 0.0f, (float) 0.0f, (float) 0.0f, (float) 0.0f);
        if (f3 > f4) {
            float f9 = f4;
            f4 = f3;
            f3 = f9;
        }
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        RenderHelper.Method2163697(color.getRGB());
        GL11.glEnable((int) 2848);
        GL11.glLineWidth((float) n2);
        GL11.glBegin((int) 3);
        for (f8 = f4; f8 >= f3; f8 -= 1.0f) {
            f7 = (float) (Math.cos((double) f8 * Math.PI / 180.0) * (double) f5 * 1.0);
            f6 = (float) (Math.sin((double) f8 * Math.PI / 180.0) * (double) f5 * 1.0);
            GL11.glVertex2f((float) (f + f7), (float) (f2 + f6));
        }
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 2848);
        GL11.glBegin((int) (bl ? 6 : 3));
        for (f8 = f4; f8 >= f3; f8 -= 1.0f) {
            f7 = (float) Math.cos((double) f8 * Math.PI / 180.0) * f5;
            f6 = (float) Math.sin((double) f8 * Math.PI / 180.0) * f5;
            GL11.glVertex2f((float) (f + f7), (float) (f2 + f6));
        }
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163607(float f, float f2, float f3, float f4, float f5, boolean bl, Color color) {
        float f6;
        float f7;
        float f8;
        GlStateManager.color((float) 0.0f, (float) 0.0f, (float) 0.0f, (float) 0.0f);
        if (f3 > f4) {
            float f9 = f4;
            f4 = f3;
            f3 = f9;
        }
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        RenderHelper.Method2163697(color.getRGB());
        GL11.glEnable((int) 2848);
        GL11.glLineWidth((float) 2.0f);
        GL11.glBegin((int) 3);
        for (f8 = f4; f8 >= f3; f8 -= 4.0f) {
            f7 = (float) (Math.cos((double) f8 * Math.PI / 180.0) * (double) f5 * 1.0);
            f6 = (float) (Math.sin((double) f8 * Math.PI / 180.0) * (double) f5 * 1.0);
            GL11.glVertex2f((float) (f + f7), (float) (f2 + f6));
        }
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 2848);
        GL11.glBegin((int) (bl ? 6 : 3));
        for (f8 = f4; f8 >= f3; f8 -= 4.0f) {
            f7 = (float) Math.cos((double) f8 * Math.PI / 180.0) * f5;
            f6 = (float) Math.sin((double) f8 * Math.PI / 180.0) * f5;
            GL11.glVertex2f((float) (f + f7), (float) (f2 + f6));
        }
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163608(float f, float f2, float f3, boolean bl, Color color) {
        RenderHelper.Method2163607(f, f2, 0.0f, 360.0f, f3, bl, color);
    }

    public static void Method2163609(int n2, float f, float f2, float f3, boolean bl, Color color) {
        RenderHelper.Method2163607(f, f2, 15 + n2, 75 + n2, f3, bl, color);
        RenderHelper.Method2163607(f, f2, 105 + n2, 165 + n2, f3, bl, color);
        RenderHelper.Method2163607(f, f2, 195 + n2, 255 + n2, f3, bl, color);
        RenderHelper.Method2163607(f, f2, 285 + n2, 345 + n2, f3, bl, color);
    }

    public static void Method2163600(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
    }
}

