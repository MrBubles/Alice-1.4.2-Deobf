

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.EXTFramebufferObject
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Disk
 *  org.lwjgl.util.glu.GLU
 *  org.lwjgl.util.glu.Sphere
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GLUProjection;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Disk;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public class RenderUtil
        implements Util {
    static final boolean Field3126;
    private static final Frustum Field3110;
    private static final FloatBuffer Field3111;
    private static final IntBuffer Field3112;
    private static final FloatBuffer Field3113;
    private static final FloatBuffer Field3114;
    private static final BufferBuilder Field3125;
    public static RenderItem Field3115;
    public static ICamera Field3116;
    public static int Field3122;
    public static Tessellator Field3123;
    public static BufferBuilder Field3124;
    private static boolean Field3117;
    private static boolean Field3118;
    private static boolean Field3119;
    private static boolean Field3120;
    private static boolean Field3121;

    static {
        Field3126 = !RenderUtil.class.desiredAssertionStatus();
        Field3110 = new Frustum();
        Field3111 = BufferUtils.createFloatBuffer((int) 3);
        Field3112 = BufferUtils.createIntBuffer((int) 16);
        Field3113 = BufferUtils.createFloatBuffer((int) 16);
        Field3114 = BufferUtils.createFloatBuffer((int) 16);
        Field3115 = Field2811.getRenderItem();
        Field3116 = new Frustum();
        Field3117 = GL11.glIsEnabled((int) 2896);
        Field3118 = GL11.glIsEnabled((int) 3042);
        Field3119 = GL11.glIsEnabled((int) 3553);
        Field3120 = GL11.glIsEnabled((int) 2929);
        Field3121 = GL11.glIsEnabled((int) 2848);
        Field3123 = Tessellator.getInstance();
        Field3124 = Field3123.getBuffer();
        Field3125 = Tessellator.getInstance().getBuffer();
    }

    {
        public static final HashMap<EnumFacing, Integer> Field2015 = new HashMap();

        static {
        Field2015.put(EnumFacing.DOWN, 1);
        Field2015.put(EnumFacing.WEST, 16);
        Field2015.put(EnumFacing.NORTH, 4);
        Field2015.put(EnumFacing.SOUTH, 8);
        Field2015.put(EnumFacing.EAST, 32);
        Field2015.put(EnumFacing.UP, 2);
    }

        public static final class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
            public static final int Field3857 = 1;
            public static final int Field3858 = 2;
            public static final int Field3859 = 4;
            public static final int Field3860 = 8;
            public static final int Field3861 = 16;
            public static final int Field3862 = 32;
            public static final int Field3863 = 63;
        }

        public static final class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
            public static final int Field1242 = 17;
            public static final int Field1243 = 18;
            public static final int Field1244 = 33;
            public static final int Field1245 = 34;
            public static final int Field1246 = 5;
            public static final int Field1247 = 6;
            public static final int Field1248 = 9;
            public static final int Field1249 = 10;
            public static final int Field1250 = 20;
            public static final int Field1251 = 36;
            public static final int Field1252 = 24;
            public static final int Field1253 = 40;
            public static final int Field1254 = 63;
        }
    }

    public static void Method2163962(AxisAlignedBB axisAlignedBB, Color color, int n2) {
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        Field3116.setPosition(Objects.requireNonNull(RenderUtil.Field2811.getRenderViewEntity()).posX, RenderUtil.Field2811.getRenderViewEntity().posY, RenderUtil.Field2811.getRenderViewEntity().posZ);
        if (Field3116.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB2.minX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.minY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.minZ + RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB2.maxX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.maxY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.maxZ + RenderUtil.Field2811.getRenderManager().viewerPosZ))) {
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

    public static void Method2163963(BufferBuilder bufferBuilder, double d, double d2, double d3, Color color) {
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
    }

    public static void Method2163964() {
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.enableBlend();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glBlendFunc((int) 770, (int) 771);
    }

    public static void Method2163965(int n2, int n3, int n4, int n5, int n6, Color color) {
        Gui.drawRect((int) n2, (int) n3, (int) n4, (int) (n3 + n6), (int) color.getRGB());
        Gui.drawRect((int) n2, (int) n3, (int) (n2 + n6), (int) n5, (int) color.getRGB());
        Gui.drawRect((int) n4, (int) n3, (int) (n4 - n6), (int) n5, (int) color.getRGB());
        Gui.drawRect((int) n2, (int) n5, (int) n4, (int) (n5 - n6), (int) color.getRGB());
    }

    public static void Method2163966() {
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
        GL11.glEnable((int) 3553);
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static void Method2163967(double d, double d2, double d3, double d4, Color color, float f) {
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
        float f2 = (float) (color.getRGB() >> 24 & 0xFF) / 255.0f;
        float f3 = (float) (color.getRGB() >> 16 & 0xFF) / 255.0f;
        float f4 = (float) (color.getRGB() >> 8 & 0xFF) / 255.0f;
        float f5 = (float) (color.getRGB() & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GL11.glPolygonMode((int) 1032, (int) 6913);
        GL11.glLineWidth((float) f);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f3, (float) f4, (float) f5, (float) f2);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).endVertex();
        bufferBuilder.pos(d, d2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static Vec3d Method2163968(Vec3d vec3d) {
        return new Vec3d(vec3d.x - RenderUtil.Field2811.getRenderManager().viewerPosX, vec3d.y - RenderUtil.Field2811.getRenderManager().viewerPosY, vec3d.z - RenderUtil.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2163969(BlockPos blockPos, Color color, float f, boolean bl, boolean bl2, int n2, boolean bl3) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        Field3116.setPosition(Objects.requireNonNull(RenderUtil.Field2811.getRenderViewEntity()).posX, RenderUtil.Field2811.getRenderViewEntity().posY, RenderUtil.Field2811.getRenderViewEntity().posZ);
        if (Field3116.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil.Field2811.getRenderManager().viewerPosZ))) {
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) f);
            double d7 = RenderUtil.Field2811.playerController.curBlockDamageMP;
            if (bl3) {
                d6 = axisAlignedBB.minX + 0.5 - d7 / 2.0;
                d5 = axisAlignedBB.minY + 0.5 - d7 / 2.0;
                d4 = axisAlignedBB.minZ + 0.5 - d7 / 2.0;
                d3 = axisAlignedBB.maxX - 0.5 + d7 / 2.0;
                d2 = axisAlignedBB.maxY - 0.5 + d7 / 2.0;
                d = axisAlignedBB.maxZ - 0.5 + d7 / 2.0;
            }
            AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(d6, d5, d4, d3, d2, d);
            if (bl2) {
                RenderUtil.Method2163036(axisAlignedBB2, new Color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) n2 / 255.0f).getRGB());
            }
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163960(double d, double d2, double d3, double d4, float f) {
        double d5;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
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
    }

    public static void Method2163971(double d, double d2, double d3, double d4, int n2, int n3) {
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        float f5 = (float) (n3 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n3 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n3 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n3 & 0xFF) / 255.0f;
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glShadeModel((int) 7425);
        GL11.glPushMatrix();
        GL11.glBegin((int) 7);
        GL11.glColor4f((float) f2, (float) f3, (float) f4, (float) f);
        GL11.glVertex2d((double) d, (double) d2);
        GL11.glVertex2d((double) d, (double) d4);
        GL11.glColor4f((float) f6, (float) f7, (float) f8, (float) f5);
        GL11.glVertex2d((double) d3, (double) d4);
        GL11.glVertex2d((double) d3, (double) d2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
        GL11.glShadeModel((int) 7424);
    }

    public static void Method2163972(BlockPos blockPos, Color color, float f, boolean bl) {
        RenderUtil.Method2163973(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue()), f, bl);
    }

    public static void Method2163973(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtil.Field2811.world.getWorldBorder().contains(blockPos)) {
            if (!Field3126 && RenderUtil.Field2811.renderViewEntity == null) {
                throw new AssertionError();
            }
            Vec3d vec3d = EntityUtil.Method2163492(RenderUtil.Field2811.renderViewEntity, Field2811.getRenderPartialTicks());
            RenderUtil.Method2163974(iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    public static void Method2163974(AxisAlignedBB axisAlignedBB, Color color, float f) {
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
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163975(AxisAlignedBB axisAlignedBB, EnumFacing enumFacing, Color color, Color color2, double d) {
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
        switch (1.F ield2828[enumFacing.ordinal()]){
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

    public static void Method2163976(float f, float f2, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable((int) 2848);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 3042);
        GL11.glColor4f((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), (float) color.getAlpha());
        GL11.glLineWidth((float) 2.0f);
        GL11.glBegin((int) 1);
        GL11.glVertex2d((double) (f + 1.0f), (double) (f2 + 1.0f));
        GL11.glVertex2d((double) (f + 3.0f), (double) (f2 + 4.0f));
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex2d((double) (f + 3.0f), (double) (f2 + 4.0f));
        GL11.glVertex2d((double) (f + 6.0f), (double) (f2 - 2.0f));
        GL11.glEnd();
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 2848);
        GL11.glPopMatrix();
    }

    public static void Method2163977(double d, double d2, double d3, double d4, Color color, float f) {
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
        float f2 = (float) (color.getRGB() >> 24 & 0xFF) / 255.0f;
        float f3 = (float) (color.getRGB() >> 16 & 0xFF) / 255.0f;
        float f4 = (float) (color.getRGB() >> 8 & 0xFF) / 255.0f;
        float f5 = (float) (color.getRGB() & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GL11.glPolygonMode((int) 1032, (int) 6913);
        GL11.glLineWidth((float) f);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f3, (float) f4, (float) f5, (float) f2);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).endVertex();
        bufferBuilder.pos(d, d2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static Color Method2163978(int n2, int n3, float f, float f2, int n4) {
        float f3 = (System.currentTimeMillis() + (long) n3) % (long) n2;
        Color color = new Color(Color.getHSBColor(f3 / (float) n2, f, f2).getRGB());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n4);
    }

    public static void Method2163979(int n2, double d, int n3, double d2, int n4, int n5, int n6, boolean bl) {
        if (bl) {
            n5 = ColorUtil.Method2163375(n5, -20);
            n6 = ColorUtil.Method2163375(n6, -20);
        }
        RenderUtil.Method2163970(n2 + n4, d + (double) n4, n3 - n4, d2 - (double) n4, n5);
        RenderUtil.Method2163970(n2, d + (double) n4, n2 + n4, d2 - (double) n4, n6);
        RenderUtil.Method2163970(n3 - n4, d + (double) n4, n3, d2 - (double) n4, n6);
        RenderUtil.Method2163970(n2, d, n3, d + (double) n4, n6);
        RenderUtil.Method2163970(n2, d2 - (double) n4, n3, d2, n6);
    }

    public static void Method2163970(int n2, double d, double d2, double d3, int n3) {
        double d4;
        if ((double) n2 < d2) {
            d4 = n2;
            n2 = (int) d2;
            d2 = (int) d4;
        }
        if (d < d3) {
            d4 = d;
            d = d3;
            d3 = d4;
        }
        GlStateManager.enableBlend();
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 3008);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) ((float) (n3 >> 16 & 0xFF) / 255.0f), (float) ((float) (n3 >> 8 & 0xFF) / 255.0f), (float) ((float) (n3 & 0xFF) / 255.0f), (float) ((float) (n3 >> 24 & 0xFF) / 255.0f));
        Field3125.begin(7, DefaultVertexFormats.POSITION);
        Field3125.pos((double) n2, d3, 0.0).endVertex();
        Field3125.pos(d2, d3, 0.0).endVertex();
        Field3125.pos(d2, d, 0.0).endVertex();
        Field3125.pos((double) n2, d, 0.0).endVertex();
        Field3123.draw();
        GL11.glEnable((int) 3042);
        GL11.glEnable((int) 3008);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163981(int n2, int n3, int n4, int n5, int n6) {
        RenderUtil.Method2163982(n2, n3, n2 + n4, n3 + 1, n5, n6);
    }

    public static void Method2163982(int n2, int n3, int n4, int n5, int n6, int n7) {
        float f = (float) (n6 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n6 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n6 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n6 & 0xFF) / 255.0f;
        float f5 = (float) (n7 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n7 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n7 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n7 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int) 7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) n4, (double) n3, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos((double) n2, (double) n3, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) n2, (double) n5, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) n4, (double) n5, 0.0).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void Method2163983() {
        GL11.glBlendFunc((int) 770, (int) 771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float) Float.intBitsToFloat(Float.floatToIntBits(5.0675106f) ^ 0x7F22290C));
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color((float) Float.intBitsToFloat(Float.floatToIntBits(11.925059f) ^ 0x7EBECD0B), (float) Float.intBitsToFloat(Float.floatToIntBits(18.2283f) ^ 0x7E11D38F), (float) Float.intBitsToFloat(Float.floatToIntBits(9.73656f) ^ 0x7E9BC8F3));
    }

    public static void Method2163984() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
        GlStateManager.color((float) Float.intBitsToFloat(Float.floatToIntBits(12.552789f) ^ 0x7EC8D839), (float) Float.intBitsToFloat(Float.floatToIntBits(7.122752f) ^ 0x7F63ED96), (float) Float.intBitsToFloat(Float.floatToIntBits(5.4278784f) ^ 0x7F2DB12E));
        GL11.glColor4f((float) Float.intBitsToFloat(Float.floatToIntBits(10.5715685f) ^ 0x7EA92525), (float) Float.intBitsToFloat(Float.floatToIntBits(4.9474883f) ^ 0x7F1E51D3), (float) Float.intBitsToFloat(Float.floatToIntBits(4.9044757f) ^ 0x7F1CF177), (float) Float.intBitsToFloat(Float.floatToIntBits(9.482457f) ^ 0x7E97B825));
    }

    public static void Method2163985() {
        GL11.glGetFloat((int) 2982, (FloatBuffer) Field3113);
        GL11.glGetFloat((int) 2983, (FloatBuffer) Field3114);
        GL11.glGetInteger((int) 2978, (IntBuffer) Field3112);
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        GLUProjection.Method2163610().Method2163621(Field3112, Field3113, Field3114, (float) scaledResolution.getScaledWidth() / (float) Minecraft.getMinecraft().displayWidth, (float) scaledResolution.getScaledHeight() / (float) Minecraft.getMinecraft().displayHeight);
    }

    public static void Method2163986(int n2, int n3, int n4, int n5, int n6) {
        GL11.glLineWidth((float) 1.0f);
        Gui.drawRect((int) n2, (int) n3, (int) (n2 + n4), (int) (n3 + n5), (int) n6);
    }

    public static void Method2163987(BlockPos blockPos, GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll, Color color, String string, boolean bl, Color color2) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598(), (double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599(), (double) 0.0);
        String string2 = string + ": " + Math.round(RenderUtil.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ())) + "M";
        float f = AliceMain.Field766.Method2150310(string2);
        AliceMain.Field766.Method2150318(string2, -(f / 2.0f), -((float) AliceMain.Field766.Method2150321() / 2.0f) + (float) AliceMain.Field766.Method2150321() / 2.0f, color.getRGB(), false);
        GlStateManager.translate((double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598()), (double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599()), (double) 0.0);
        GlStateManager.popMatrix();
    }

    public static AxisAlignedBB Method2163988(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(axisAlignedBB.minX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtil.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2163989(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos((double) n2, (double) (n3 + n7), (double) n8).tex((double) ((float) n4 * 0.00390625f), (double) ((float) (n5 + n7) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double) (n2 + n6), (double) (n3 + n7), (double) n8).tex((double) ((float) (n4 + n6) * 0.00390625f), (double) ((float) (n5 + n7) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double) (n2 + n6), (double) n3, (double) n8).tex((double) ((float) (n4 + n6) * 0.00390625f), (double) ((float) n5 * 0.00390625f)).endVertex();
        bufferBuilder.pos((double) n2, (double) n3, (double) n8).tex((double) ((float) n4 * 0.00390625f), (double) ((float) n5 * 0.00390625f)).endVertex();
        tessellator.draw();
    }

    public static void Method2163980(BlockPos blockPos, Color color, Color color2, double d) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.UP) continue;
            RenderUtil.Method2163994(blockPos, enumFacing, color, color2, d);
        }
    }

    public static void Method2163991(BlockPos blockPos, Color color, Color color2, double d) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            RenderUtil.Method2163994(blockPos, enumFacing, color, color2, d);
        }
    }

    public static void Method2163992(BlockPos blockPos, Color color, Color color2, Color color3) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.UP) continue;
            RenderUtil.Method2163993(blockPos, enumFacing, color, color2, true, false);
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.DOWN) continue;
            RenderUtil.Method2163993(blockPos, enumFacing, color2, color3, true, true);
        }
    }

    public static void Method2163993(BlockPos blockPos, EnumFacing enumFacing, Color color, Color color2, boolean bl, boolean bl2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z);
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        float f5 = (float) color2.getRed() / 255.0f;
        float f6 = (float) color2.getGreen() / 255.0f;
        float f7 = (float) color2.getBlue() / 255.0f;
        float f8 = (float) color2.getAlpha() / 255.0f;
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        if (enumFacing == EnumFacing.DOWN) {
            d = axisAlignedBB.minX;
            d4 = axisAlignedBB.maxX;
            d2 = axisAlignedBB.minY + (bl2 ? 0.5 : 0.0);
            d5 = axisAlignedBB.minY + (bl2 ? 0.5 : 0.0);
            d3 = axisAlignedBB.minZ;
            d6 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.UP) {
            d = axisAlignedBB.minX;
            d4 = axisAlignedBB.maxX;
            d2 = axisAlignedBB.maxY / (double) (bl ? 2 : 1);
            d5 = axisAlignedBB.maxY / (double) (bl ? 2 : 1);
            d3 = axisAlignedBB.minZ;
            d6 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.EAST) {
            d = axisAlignedBB.maxX;
            d4 = axisAlignedBB.maxX;
            d2 = axisAlignedBB.minY + (bl2 ? 0.5 : 0.0);
            d5 = axisAlignedBB.maxY / (double) (bl ? 2 : 1);
            d3 = axisAlignedBB.minZ;
            d6 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.WEST) {
            d = axisAlignedBB.minX;
            d4 = axisAlignedBB.minX;
            d2 = axisAlignedBB.minY + (bl2 ? 0.5 : 0.0);
            d5 = axisAlignedBB.maxY / (double) (bl ? 2 : 1);
            d3 = axisAlignedBB.minZ;
            d6 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.SOUTH) {
            d = axisAlignedBB.minX;
            d4 = axisAlignedBB.maxX;
            d2 = axisAlignedBB.minY + (bl2 ? 0.5 : 0.0);
            d5 = axisAlignedBB.maxY / (double) (bl ? 2 : 1);
            d3 = axisAlignedBB.maxZ;
            d6 = axisAlignedBB.maxZ;
        } else if (enumFacing == EnumFacing.NORTH) {
            d = axisAlignedBB.minX;
            d4 = axisAlignedBB.maxX;
            d2 = axisAlignedBB.minY + (bl2 ? 0.5 : 0.0);
            d5 = axisAlignedBB.maxY / (double) (bl ? 2 : 1);
            d3 = axisAlignedBB.minZ;
            d6 = axisAlignedBB.minZ;
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.depthMask((boolean) false);
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        if (enumFacing == EnumFacing.EAST || enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.NORTH || enumFacing == EnumFacing.SOUTH) {
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.UP) {
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.DOWN) {
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
        }
        tessellator.draw();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
    }

    public static void Method2163994(BlockPos blockPos, EnumFacing enumFacing, Color color, Color color2, double d) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z).expand(0.0, d, 0.0);
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

    public static void Method2163995(int n2, int n3, int n4, int n5, int n6, int n7) {
        float f = (float) (n6 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n6 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n6 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n6 & 0xFF) / 255.0f;
        float f5 = (float) (n7 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n7 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n7 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n7 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int) 7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) n2 + (double) n4, (double) n3, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos((double) n2, (double) n3, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos((double) n2, (double) n3 + (double) n5, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) n2 + (double) n4, (double) n3 + (double) n5, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void Method2163996(BlockPos blockPos, Color color, Color color2, float f, double d) {
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtil.Method2163999(iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z).expand(0.0, d, 0.0), color, color2, f);
    }

    public static void Method2163997(BlockPos blockPos, Color color, Color color2, Color color3, float f) {
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtil.Method2163998(iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, color2, color3, f);
    }

    public static void Method2163998(AxisAlignedBB axisAlignedBB, Color color, Color color2, Color color3, float f) {
        float f2 = (float) color3.getRed() / 255.0f;
        float f3 = (float) color3.getGreen() / 255.0f;
        float f4 = (float) color3.getBlue() / 255.0f;
        float f5 = (float) color3.getAlpha() / 255.0f;
        float f6 = (float) color2.getRed() / 255.0f;
        float f7 = (float) color2.getGreen() / 255.0f;
        float f8 = (float) color2.getBlue() / 255.0f;
        float f9 = (float) color2.getAlpha() / 255.0f;
        float f10 = (float) color.getRed() / 255.0f;
        float f11 = (float) color.getGreen() / 255.0f;
        float f12 = (float) color.getBlue() / 255.0f;
        float f13 = (float) color.getAlpha() / 255.0f;
        double d = (axisAlignedBB.maxY - axisAlignedBB.minY) / 2.0;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        GL11.glBegin((int) 1);
        GL11.glColor4d((double) f2, (double) f3, (double) f4, (double) f5);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glColor4d((double) f6, (double) f7, (double) f8, (double) f9);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.minZ);
        GL11.glColor4f((float) f10, (float) f11, (float) f12, (float) f13);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glColor4d((double) f2, (double) f3, (double) f4, (double) f5);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glColor4d((double) f6, (double) f7, (double) f8, (double) f9);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.maxZ);
        GL11.glColor4d((double) f10, (double) f11, (double) f12, (double) f13);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glColor4d((double) f2, (double) f3, (double) f4, (double) f5);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glColor4d((double) f6, (double) f7, (double) f8, (double) f9);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.maxZ);
        GL11.glColor4d((double) f10, (double) f11, (double) f12, (double) f13);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glColor4d((double) f2, (double) f3, (double) f4, (double) f5);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glColor4d((double) f6, (double) f7, (double) f8, (double) f9);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) (axisAlignedBB.minY + d), (double) axisAlignedBB.minZ);
        GL11.glColor4d((double) f10, (double) f11, (double) f12, (double) f13);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glColor4d((double) f10, (double) f11, (double) f12, (double) f13);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163999(AxisAlignedBB axisAlignedBB, Color color, Color color2, float f) {
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

    public static void Method2163990(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        Minecraft minecraft = Minecraft.getMinecraft();
        double d = (double) blockPos.getX() - minecraft.getRenderManager().viewerPosX;
        double d2 = (double) blockPos.getY() - minecraft.getRenderManager().viewerPosY;
        double d3 = (double) blockPos.getZ() - minecraft.getRenderManager().viewerPosZ;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163901(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        Minecraft minecraft = Minecraft.getMinecraft();
        double d = (double) blockPos.getX() - minecraft.getRenderManager().viewerPosX;
        double d2 = (double) blockPos.getY() - minecraft.getRenderManager().viewerPosY;
        double d3 = (double) blockPos.getZ() - minecraft.getRenderManager().viewerPosZ;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163902(BlockPos blockPos, Color color, Color color2) {
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtil.Method2163904(iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, color2);
    }

    public static void Method2163903(float f, float f2, float f3, float f4, Color color) {
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

    public static void Method2163904(AxisAlignedBB axisAlignedBB, Color color, Color color2) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        float f = (float) color2.getAlpha() / 255.0f;
        float f2 = (float) color2.getRed() / 255.0f;
        float f3 = (float) color2.getGreen() / 255.0f;
        float f4 = (float) color2.getBlue() / 255.0f;
        float f5 = (float) color.getAlpha() / 255.0f;
        float f6 = (float) color.getRed() / 255.0f;
        float f7 = (float) color.getGreen() / 255.0f;
        float f8 = (float) color.getBlue() / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163905(float f, float f2, float f3, float f4, int n2, int n3) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        float f9 = (float) (n3 >> 24 & 0xFF) / 255.0f;
        float f10 = (float) (n3 >> 16 & 0xFF) / 255.0f;
        float f11 = (float) (n3 >> 8 & 0xFF) / 255.0f;
        float f12 = (float) (n3 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int) 7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f + (double) f3, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f2 + (double) f4, 0.0).color(f10, f11, f12, f9).endVertex();
        bufferBuilder.pos((double) f + (double) f3, (double) f2 + (double) f4, 0.0).color(f10, f11, f12, f9).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void Method2163906(double d, double d2, double d3, Color color, double d4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void Method2163907(BlockPos blockPos, Color color, double d, double d2) {
        RenderUtil.Method2163025(blockPos, color, d, d2);
    }

    public static void Method2163908(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n2, boolean bl4) {
        if (bl3) {
            RenderUtil.Method2163013(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n2));
        }
        if (bl2) {
            RenderUtil.Method2163018(blockPos, bl ? color2 : color, f, bl4);
        }
    }

    public static void Method2163909(AxisAlignedBB axisAlignedBB, Color color, Color color2, float f, boolean bl, boolean bl2, boolean bl3, float f2, float f3, float f4) {
        double d = 0.5 * (double) (1.0f - f3);
        AxisAlignedBB axisAlignedBB2 = RenderUtil.Method2163988(new AxisAlignedBB(axisAlignedBB.minX + d, axisAlignedBB.minY + d + (double) (1.0f - f4), axisAlignedBB.minZ + d, axisAlignedBB.maxX - d, axisAlignedBB.maxY - d, axisAlignedBB.maxZ - d));
        float f5 = (float) color.getRed() / 255.0f;
        float f6 = (float) color.getGreen() / 255.0f;
        float f7 = (float) color.getBlue() / 255.0f;
        float f8 = (float) color.getAlpha() / 255.0f;
        float f9 = (float) color2.getRed() / 255.0f;
        float f10 = (float) color2.getGreen() / 255.0f;
        float f11 = (float) color2.getBlue() / 255.0f;
        float f12 = (float) color2.getAlpha() / 255.0f;
        if (bl3) {
            f5 = (float) Colors.Field1782.Method2150586().getRed() / 255.0f;
            f6 = (float) Colors.Field1782.Method2150586().getGreen() / 255.0f;
            f7 = (float) Colors.Field1782.Method2150586().getBlue() / 255.0f;
            f9 = (float) Colors.Field1782.Method2150586().getRed() / 255.0f;
            f10 = (float) Colors.Field1782.Method2150586().getGreen() / 255.0f;
            f11 = (float) Colors.Field1782.Method2150586().getBlue() / 255.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        f8 *= f2;
        f12 *= f2;
        if (bl2) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB2, (float) f5, (float) f6, (float) f7, (float) f8);
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
        if (bl) {
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
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            bufferBuilder.pos(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.minZ).color(f9, f10, f11, f12).endVertex();
            tessellator.draw();
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163900(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n2, boolean bl4, double d, boolean bl5, boolean bl6, boolean bl7, boolean bl8, int n3) {
        if (bl3) {
            RenderUtil.Method2163017(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n2), d, bl5, bl7, n3);
        }
        if (bl2) {
            RenderUtil.Method2163019(blockPos, bl ? color2 : color, f, bl4, d, bl6, bl8, n3);
        }
    }

    public static void Method2163011(float f, float f2, float f3, float f4, ScaledResolution scaledResolution) {
        GL11.glScissor((int) ((int) (f * (float) scaledResolution.getScaleFactor())), (int) ((int) ((float) RenderUtil.Field2811.displayHeight - f4 * (float) scaledResolution.getScaleFactor())), (int) ((int) ((f3 - f) * (float) scaledResolution.getScaleFactor())), (int) ((int) ((f4 - f2) * (float) scaledResolution.getScaleFactor())));
    }

    public static void Method2163012(float f, float f2, float f3, float f4, float f5, int n2) {
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

    public static void Method2163013(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        Field3116.setPosition(Objects.requireNonNull(RenderUtil.Field2811.getRenderViewEntity()).posX, RenderUtil.Field2811.getRenderViewEntity().posY, RenderUtil.Field2811.getRenderViewEntity().posZ);
        if (Field3116.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil.Field2811.getRenderManager().viewerPosZ))) {
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

    public static void Method2163014(BlockPos blockPos, Color color, Color color2) {
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        float f5 = (float) color2.getRed() / 255.0f;
        float f6 = (float) color2.getGreen() / 255.0f;
        float f7 = (float) color2.getBlue() / 255.0f;
        float f8 = (float) color2.getAlpha() / 255.0f;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
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
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
    }

    public static void Method2163015(BlockPos blockPos, Color color, Color color2, Color color3) {
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        float f5 = (float) color3.getRed() / 255.0f;
        float f6 = (float) color3.getGreen() / 255.0f;
        float f7 = (float) color3.getBlue() / 255.0f;
        float f8 = (float) color3.getAlpha() / 255.0f;
        float f9 = (float) color2.getRed() / 255.0f;
        float f10 = (float) color2.getGreen() / 255.0f;
        float f11 = (float) color2.getBlue() / 255.0f;
        float f12 = (float) color2.getAlpha() / 255.0f;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        double d = (axisAlignedBB.maxY - axisAlignedBB.minY) / 2.0;
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
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.minZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.maxZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.maxZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + d, axisAlignedBB.maxZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.minZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.minZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.minZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.maxZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + d, axisAlignedBB.maxZ).color(f9, f10, f11, f12).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + d, axisAlignedBB.maxZ).color(f9, f10, f11, f12).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163016(BlockPos blockPos, Color color, Color color2, Color color3) {
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        float f5 = (float) color3.getRed() / 255.0f;
        float f6 = (float) color3.getGreen() / 255.0f;
        float f7 = (float) color3.getBlue() / 255.0f;
        float f8 = (float) color3.getAlpha() / 255.0f;
        float f9 = (float) color2.getRed() / 255.0f;
        float f10 = (float) color2.getGreen() / 255.0f;
        float f11 = (float) color2.getBlue() / 255.0f;
        float f12 = (float) color2.getAlpha() / 255.0f;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
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
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163017(BlockPos blockPos, Color color, double d, boolean bl, boolean bl2, int n2) {
        if (bl) {
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
            RenderUtil.Method2163980(blockPos, bl2 ? color2 : color, bl2 ? color : color2, d);
            return;
        }
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        Field3116.setPosition(Objects.requireNonNull(RenderUtil.Field2811.getRenderViewEntity()).posX, RenderUtil.Field2811.getRenderViewEntity().posY, RenderUtil.Field2811.getRenderViewEntity().posZ);
        if (Field3116.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil.Field2811.getRenderManager().viewerPosZ))) {
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

    public static void Method2163018(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtil.Field2811.world.getWorldBorder().contains(blockPos)) {
            Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
            RenderUtil.Method2163010(iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    public static void Method2163019(BlockPos blockPos, Color color, float f, boolean bl, double d, boolean bl2, boolean bl3, int n2) {
        if (bl2) {
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
            RenderUtil.Method2163996(blockPos, bl3 ? color2 : color, bl3 ? color : color2, f, d);
            return;
        }
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtil.Field2811.world.getWorldBorder().contains(blockPos)) {
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
            RenderUtil.Method2163010(axisAlignedBB.grow((double) 0.002f), color, f);
        }
    }

    public static void Method2163010(AxisAlignedBB axisAlignedBB, Color color, float f) {
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

    public static void Method2163021(BlockPos blockPos, Color color, float f, boolean bl, boolean bl2, int n2) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        Field3116.setPosition(Objects.requireNonNull(RenderUtil.Field2811.getRenderViewEntity()).posX, RenderUtil.Field2811.getRenderViewEntity().posY, RenderUtil.Field2811.getRenderViewEntity().posZ);
        if (Field3116.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) f);
            double d = RenderUtil.Field2811.player.getDistance((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() + 0.5f), (double) ((float) blockPos.getZ() + 0.5f)) * 0.75;
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

    public static void Method2163022(AxisAlignedBB axisAlignedBB, String string) {
        if (axisAlignedBB == null || string == null) {
            return;
        }
        GlStateManager.pushMatrix();
        RenderUtil.Method2163030((float) axisAlignedBB.minX + 0.5f, (float) axisAlignedBB.minY + 0.5f, (float) axisAlignedBB.minZ + 0.5f, (EntityPlayer) RenderUtil.Field2811.player, 1.0f);
        GlStateManager.disableDepth();
        GlStateManager.translate((double) (-((double) AliceMain.Field766.Method2150310(string) / 2.0)), (double) 0.0, (double) 0.0);
        AliceMain.Field766.Method2150317(string, 0.0f, 0.0f, -5592406);
        GlStateManager.popMatrix();
    }

    public static void Method2163023(AxisAlignedBB axisAlignedBB, String string) {
        if (axisAlignedBB == null || string == null) {
            return;
        }
        GlStateManager.pushMatrix();
        RenderUtil.Method2163030((float) axisAlignedBB.minX + 0.5f, (float) axisAlignedBB.minY + 0.5f, (float) axisAlignedBB.minZ + 0.5f, (EntityPlayer) RenderUtil.Field2811.player, 1.0f);
        GlStateManager.disableDepth();
        GlStateManager.translate((double) (-((double) AliceMain.Field766.Method2150310(string) / 2.0)), (double) 0.0, (double) 0.0);
        AliceMain.Field766.Method2150317(string, 0.0f, 0.0f, ColorUtil.Method2163379(255, 255, 255, 255));
        GlStateManager.popMatrix();
    }

    public static void Method2163024(BlockPos blockPos, Color color, float f) {
        IBlockState iBlockState = RenderUtil.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtil.Method2163038(iBlockState.getSelectedBoundingBox((World) RenderUtil.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), f, ColorUtil.Method2163384(color));
    }

    public static void Method2163025(BlockPos blockPos, Color color, double d, double d2) {
        double d3 = (double) blockPos.getX() - RenderUtil.Field2811.renderManager.renderPosX;
        double d4 = (double) blockPos.getY() - RenderUtil.Field2811.renderManager.renderPosY;
        double d5 = (double) blockPos.getZ() - RenderUtil.Field2811.renderManager.renderPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 3042);
        GL11.glLineWidth((float) 2.0f);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glColor4d((double) ((float) color.getRed() / 255.0f), (double) ((float) color.getGreen() / 255.0f), (double) ((float) color.getBlue() / 255.0f), (double) 0.25);
        RenderUtil.Method2163028(new AxisAlignedBB(d3, d4, d5, d3 + d2, d4 + 1.0, d5 + d), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double) 0.0, (double) 0.0, (double) 0.0, (double) 0.5);
        RenderUtil.Method2163029(new AxisAlignedBB(d3, d4, d5, d3 + d2, d4 + 1.0, d5 + d));
        GL11.glLineWidth((float) 2.0f);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
    }

    public static void Method2163026(float f, float f2, float f3, float f4, Color color) {
        RenderUtil.Method2163903(f - 1.0f, f2 - 1.0f, 1.0f, f4 + 2.0f, color);
        RenderUtil.Method2163903(f + f3, f2 - 1.0f, 1.0f, f4 + 2.0f, color);
        RenderUtil.Method2163903(f, f2 - 1.0f, f3, 1.0f, color);
        RenderUtil.Method2163903(f, f2 + f4, f3, 1.0f, color);
    }

    public static void Method2163027(float f, float f2, float f3, float f4, int n2) {
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

    public static void Method2163028(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
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

    public static void Method2163029(AxisAlignedBB axisAlignedBB) {
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

    public static void Method2163020() {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glLineWidth((float) 2.0f);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2884);
        GL11.glDisable((int) 2929);
        double d = RenderUtil.Field2811.getRenderManager().viewerPosX;
        double d2 = RenderUtil.Field2811.getRenderManager().viewerPosY;
        double d3 = RenderUtil.Field2811.getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glTranslated((double) (-d), (double) (-d2), (double) (-d3));
    }

    public static void Method2163031(float f, float f2, float f3, float f4) {
        RenderUtil.Method2163020();
        GL11.glColor4f((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static void Method2163032() {
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        GL11.glPopMatrix();
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
    }

    public static AxisAlignedBB Method2163033(BlockPos blockPos) {
        return RenderUtil.Field2811.world.getBlockState(blockPos).getBoundingBox((IBlockAccess) RenderUtil.Field2811.world, blockPos).offset(blockPos);
    }

    public static void Method2163034(AxisAlignedBB axisAlignedBB) {
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
    }

    public static void Method2163035(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil.Field2811.getRenderManager().viewerPosZ);
        int n2 = ColorUtil.Method2163384(color);
        RenderUtil.Method2163036(axisAlignedBB, n2);
    }

    public static void Method2163036(AxisAlignedBB axisAlignedBB, int n2) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static AxisAlignedBB Method2163037(AxisAlignedBB axisAlignedBB) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB;
        return new AxisAlignedBB(axisAlignedBB2.minX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.minY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.minZ - RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB2.maxX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.maxY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.maxZ - RenderUtil.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2163038(AxisAlignedBB axisAlignedBB, float f, int n2) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        float f2 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f5 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163039(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - RenderUtil.Field2811.getRenderManager().renderPosX), (double) ((double) f2 - RenderUtil.Field2811.getRenderManager().renderPosY), (double) ((double) f3 - RenderUtil.Field2811.getRenderManager().renderPosZ));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-RenderUtil.Field2811.player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) RenderUtil.Field2811.player.rotationPitch, (float) (RenderUtil.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2163030(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        RenderUtil.Method2163039(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    public static void Method2163041(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4, float f5) {
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2163042(double d, double d2, double d3, float f, int n2, int n3) {
        Sphere sphere = new Sphere();
        GL11.glPushMatrix();
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 3042);
        GL11.glLineWidth((float) 1.2f);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        sphere.setDrawStyle(100013);
        GL11.glTranslated((double) (d - RenderUtil.Field2811.renderManager.renderPosX), (double) (d2 - RenderUtil.Field2811.renderManager.renderPosY), (double) (d3 - RenderUtil.Field2811.renderManager.renderPosZ));
        sphere.draw(f, n2, n3);
        GL11.glLineWidth((float) 2.0f);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2163043(GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll, float f, float f2, float f3, Color color, Color color2) {
        if (illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163590() == GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSIDE) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598(), (double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599(), (double) 0.0);
            RenderUtil.Method2163047(-(f3 / 2.0f), -(f2 / 2.0f), f3, f2, color2.getRGB());
            RenderUtil.Method2163027(-(f3 / 2.0f), -(f2 / 2.0f), f, f2, color.getRGB());
            GlStateManager.translate((double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598()), (double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599()), (double) 0.0);
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163044(GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll, float f, float f2, String string, Color color, boolean bl) {
        if (illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163590() == GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSIDE) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598(), (double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599(), (double) 0.0);
            AliceMain.Field766.Method2150318(string, -((float) AliceMain.Field766.Method2150310(string) / 2.0f) + f, f2, color.getRGB(), bl);
            GlStateManager.translate((double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598()), (double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599()), (double) 0.0);
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163045(GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll, float f, float f2, ResourceLocation resourceLocation) {
        if (illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163590() == GLUProjection.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.INSIDE) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598(), (double) illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599(), (double) 0.0);
            Field2811.getTextureManager().bindTexture(resourceLocation);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            Field2811.getTextureManager().bindTexture(resourceLocation);
            RenderUtil.Method2163046(0.0f, 0.0f, f, f2);
            Field2811.getTextureManager().deleteTexture(resourceLocation);
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.translate((double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163598()), (double) (-illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2163599()), (double) 0.0);
            GlStateManager.popMatrix();
        }
    }

    public static void Method2163046(float f, float f2, float f3, float f4) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) f, (float) f2, (float) 0.0f);
        GL11.glBegin((int) 7);
        GL11.glTexCoord2f((float) 0.0f, (float) 0.0f);
        GL11.glVertex3f((float) 0.0f, (float) 0.0f, (float) 0.0f);
        GL11.glTexCoord2f((float) 0.0f, (float) 1.0f);
        GL11.glVertex3f((float) 0.0f, (float) f4, (float) 0.0f);
        GL11.glTexCoord2f((float) 1.0f, (float) 1.0f);
        GL11.glVertex3f((float) f3, (float) f4, (float) 0.0f);
        GL11.glTexCoord2f((float) 1.0f, (float) 0.0f);
        GL11.glVertex3f((float) f3, (float) 0.0f, (float) 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    public static void Method2163047(float f, float f2, float f3, float f4, int n2) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth((float) 1.0f);
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(2, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163048(float f, float f2, float f3, float f4, Color color, Color color2, float f5) {
        float f6 = (float) color.getAlpha() / 255.0f;
        float f7 = (float) color.getRed() / 255.0f;
        float f8 = (float) color.getGreen() / 255.0f;
        float f9 = (float) color.getBlue() / 255.0f;
        float f10 = (float) color2.getAlpha() / 255.0f;
        float f11 = (float) color2.getRed() / 255.0f;
        float f12 = (float) color2.getGreen() / 255.0f;
        float f13 = (float) color2.getBlue() / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth((float) f5);
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f7, f8, f9, f6).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163049(float f, float f2, float f3, int n2, int n3, float f4, boolean bl, Color color) {
        Disk disk = new Disk();
        int n4 = 180 + -(Calendar.getInstance().get(10) * 30 + Calendar.getInstance().get(12) / 2);
        int n5 = 180 + -(Calendar.getInstance().get(12) * 6 + Calendar.getInstance().get(13) / 10);
        int n6 = 180 + -(Calendar.getInstance().get(13) * 6);
        int n7 = Calendar.getInstance().get(12);
        int n8 = Calendar.getInstance().get(10);
        if (bl) {
            GL11.glPushMatrix();
            GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
            GL11.glBlendFunc((int) 770, (int) 771);
            GL11.glEnable((int) 3042);
            GL11.glLineWidth((float) f4);
            GL11.glDisable((int) 3553);
            disk.setOrientation(100020);
            disk.setDrawStyle(100012);
            GL11.glTranslated((double) f, (double) f2, (double) 0.0);
            disk.draw(0.0f, f3, n2, n3);
            GL11.glEnable((int) 3553);
            GL11.glDisable((int) 3042);
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
            GL11.glEnable((int) 3042);
            GL11.glLineWidth((float) f4);
            GL11.glDisable((int) 3553);
            GL11.glBegin((int) 3);
            ArrayList<Vec2f> arrayList = new ArrayList<Vec2f>();
            float f5 = (float) (System.currentTimeMillis() % 7200L) / 7200.0f;
            for (int j = 0; j <= 360; ++j) {
                Vec2f vec2f = new Vec2f(f + (float) Math.sin((double) j * Math.PI / 180.0) * f3, f2 + (float) Math.cos((double) j * Math.PI / 180.0) * f3);
                arrayList.add(vec2f);
            }
            Color color2 = new Color(Color.HSBtoRGB(f5, 1.0f, 1.0f));
            for (int j = 0; j < arrayList.size() - 1; ++j) {
                GL11.glColor4f((float) ((float) color2.getRed() / 255.0f), (float) ((float) color2.getGreen() / 255.0f), (float) ((float) color2.getBlue() / 255.0f), (float) ((float) color2.getAlpha() / 255.0f));
                GL11.glVertex3d((double) ((Vec2f) arrayList.get((int) j)).x, (double) ((Vec2f) arrayList.get((int) j)).y, (double) 0.0);
                GL11.glVertex3d((double) ((Vec2f) arrayList.get((int) (j + 1))).x, (double) ((Vec2f) arrayList.get((int) (j + 1))).y, (double) 0.0);
                color2 = new Color(Color.HSBtoRGB(f5 += 0.0027777778f, 1.0f, 1.0f));
            }
            GL11.glEnd();
            GL11.glEnable((int) 3553);
            GL11.glDisable((int) 3042);
            GL11.glPopMatrix();
        }
        RenderUtil.Method2163012(f, f2, f + (float) Math.sin((double) n4 * Math.PI / 180.0) * (f3 / 2.0f), f2 + (float) Math.cos((double) n4 * Math.PI / 180.0) * (f3 / 2.0f), 1.0f, Color.WHITE.getRGB());
        RenderUtil.Method2163012(f, f2, f + (float) Math.sin((double) n5 * Math.PI / 180.0) * (f3 - f3 / 10.0f), f2 + (float) Math.cos((double) n5 * Math.PI / 180.0) * (f3 - f3 / 10.0f), 1.0f, Color.WHITE.getRGB());
        RenderUtil.Method2163012(f, f2, f + (float) Math.sin((double) n6 * Math.PI / 180.0) * (f3 - f3 / 10.0f), f2 + (float) Math.cos((double) n6 * Math.PI / 180.0) * (f3 - f3 / 10.0f), 1.0f, Color.RED.getRGB());
    }

    public static void Method2163040(float f) {
        Field3117 = GL11.glIsEnabled((int) 2896);
        Field3118 = GL11.glIsEnabled((int) 3042);
        Field3119 = GL11.glIsEnabled((int) 3553);
        Field3120 = GL11.glIsEnabled((int) 2929);
        Field3121 = GL11.glIsEnabled((int) 2848);
        RenderUtil.Method2163052(Field3117, Field3118, Field3119, Field3120, Field3121, f);
    }

    public static void Method2163051() {
        RenderUtil.Method2163054(Field3117, Field3118, Field3119, Field3120, Field3121);
    }

    private static void Method2163052(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f) {
        if (bl) {
            GL11.glDisable((int) 2896);
        }
        if (!bl2) {
            GL11.glEnable((int) 3042);
        }
        GL11.glLineWidth((float) f);
        if (bl3) {
            GL11.glDisable((int) 3553);
        }
        if (bl4) {
            GL11.glDisable((int) 2929);
        }
        if (!bl5) {
            GL11.glEnable((int) 2848);
        }
        GlStateManager.blendFunc((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GL11.glHint((int) 3154, (int) 4354);
        GlStateManager.depthMask((boolean) false);
    }

    public static float[][] Method2163053(ModelBiped modelBiped) {
        float[][] arrarrf = new float[5][];
        float[] arrf = new float[]{modelBiped.bipedHead.rotateAngleX, modelBiped.bipedHead.rotateAngleY, modelBiped.bipedHead.rotateAngleZ};
        arrarrf[0] = arrf;
        float[] arrf2 = new float[]{modelBiped.bipedRightArm.rotateAngleX, modelBiped.bipedRightArm.rotateAngleY, modelBiped.bipedRightArm.rotateAngleZ};
        arrarrf[1] = arrf2;
        float[] arrf3 = new float[]{modelBiped.bipedLeftArm.rotateAngleX, modelBiped.bipedLeftArm.rotateAngleY, modelBiped.bipedLeftArm.rotateAngleZ};
        arrarrf[2] = arrf3;
        float[] arrf4 = new float[]{modelBiped.bipedRightLeg.rotateAngleX, modelBiped.bipedRightLeg.rotateAngleY, modelBiped.bipedRightLeg.rotateAngleZ};
        arrarrf[3] = arrf4;
        float[] arrf5 = new float[]{modelBiped.bipedLeftLeg.rotateAngleX, modelBiped.bipedLeftLeg.rotateAngleY, modelBiped.bipedLeftLeg.rotateAngleZ};
        arrarrf[4] = arrf5;
        return arrarrf;
    }

    private static void Method2163054(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        GlStateManager.depthMask((boolean) true);
        if (!bl5) {
            GL11.glDisable((int) 2848);
        }
        if (bl4) {
            GL11.glEnable((int) 2929);
        }
        if (bl3) {
            GL11.glEnable((int) 3553);
        }
        if (!bl2) {
            GL11.glDisable((int) 3042);
        }
        if (bl) {
            GL11.glEnable((int) 2896);
        }
    }

    public static void Method2163055(float f, float f2, float f3, float f4, float f5, int n2) {
        GL11.glBegin((int) 4);
        int n3 = (int) ((float) n2 / (360.0f / f4)) + 1;
        while ((float) n3 <= (float) n2 / (360.0f / f5)) {
            double d = Math.PI * 2 * (double) (n3 - 1) / (double) n2;
            double d2 = Math.PI * 2 * (double) n3 / (double) n2;
            GL11.glVertex2d((double) f, (double) f2);
            GL11.glVertex2d((double) ((double) f + Math.cos(d2) * (double) f3), (double) ((double) f2 + Math.sin(d2) * (double) f3));
            GL11.glVertex2d((double) ((double) f + Math.cos(d) * (double) f3), (double) ((double) f2 + Math.sin(d) * (double) f3));
            ++n3;
        }
        RenderUtil.Method2163032();
    }

    public static void Method2163056(float f, float f2, float f3, float f4, float f5, int n2) {
        GL11.glBegin((int) 2);
        int n3 = (int) ((float) n2 / (360.0f / f4)) + 1;
        while ((float) n3 <= (float) n2 / (360.0f / f5)) {
            double d = Math.PI * 2 * (double) n3 / (double) n2;
            GL11.glVertex2d((double) ((double) f + Math.cos(d) * (double) f3), (double) ((double) f2 + Math.sin(d) * (double) f3));
            ++n3;
        }
        RenderUtil.Method2163032();
    }

    public static void Method2163057(float f, float f2, float f3) {
        RenderUtil.Method2163058(f, f2, f3, 0, 360, 40);
    }

    public static void Method2163058(float f, float f2, float f3, int n2, int n3, int n4) {
        RenderUtil.Method2163056(f, f2, f3, n2, n3, n4);
    }

    public static void Method2163059(float f, float f2, float f3) {
        RenderUtil.Method2163050(f, f2, f3, 0, 360, 64);
    }

    public static void Method2163050(float f, float f2, float f3, int n2, int n3, int n4) {
        RenderUtil.Method2163055(f, f2, f3, n2, n3, n4);
    }

    public static void Method2163061(int n2, int n3, int n4, int n5, float f, float f2, float f3, float f4, float f5, float f6) {
        RenderUtil.Method2163072(n2, n3, n4, n5, f);
        GL11.glColor4f((float) f2, (float) f3, (float) f4, (float) f5);
        RenderUtil.Method2163072((float) n2 + f6, (float) n3 + f6, (float) n4 - f6 * 2.0f, (float) n5 - f6 * 2.0f, f);
    }

    public static void Method2163062(float f, float f2, float f3, float f4) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 2);
        GL11.glVertex2d((double) f3, (double) 0.0);
        GL11.glVertex2d((double) 0.0, (double) 0.0);
        GL11.glVertex2d((double) 0.0, (double) f4);
        GL11.glVertex2d((double) f3, (double) f4);
        RenderUtil.Method2163032();
    }

    public static void Method2163063(float f, float f2, float f3, float f4) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 2);
        GL11.glVertex2d((double) (f + f3), (double) f2);
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glVertex2d((double) f, (double) (f2 + f4));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f4));
        RenderUtil.Method2163032();
    }

    public static void Method2163064(float f, float f2, float f3, float f4) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 7);
        GL11.glVertex2d((double) (f + f3), (double) f2);
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glVertex2d((double) f, (double) (f2 + f4));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f4));
        RenderUtil.Method2163032();
    }

    public static AxisAlignedBB Method2163065(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(axisAlignedBB.minX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtil.Field2811.getRenderManager().viewerPosZ);
    }

    public static Vec3d Method2163066(double d, double d2, double d3) {
        GL11.glGetFloat((int) 2982, (FloatBuffer) Field3113);
        GL11.glGetFloat((int) 2983, (FloatBuffer) Field3114);
        GL11.glGetInteger((int) 2978, (IntBuffer) Field3112);
        boolean bl = GLU.gluProject((float) ((float) d), (float) ((float) d2), (float) ((float) d3), (FloatBuffer) Field3113, (FloatBuffer) Field3114, (IntBuffer) Field3112, (FloatBuffer) Field3111);
        if (bl) {
            return new Vec3d((double) Field3111.get(0), (double) ((float) Display.getHeight() - Field3111.get(1)), (double) Field3111.get(2));
        }
        return null;
    }

    public static void Method2163067(float f, float f2, float f3, float f4, float f5, boolean bl, float f6, int n2) {
        boolean bl2 = GL11.glIsEnabled((int) 3042);
        float f7 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glPushMatrix();
        RenderUtil.Method2163069(n2);
        GL11.glBegin((int) 7);
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glVertex2d((double) (f - f3 / f4), (double) (f2 + f3));
        GL11.glVertex2d((double) f, (double) (f2 + f3 / f5));
        GL11.glVertex2d((double) (f + f3 / f4), (double) (f2 + f3));
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glEnd();
        if (bl) {
            GL11.glLineWidth((float) f6);
            GL11.glColor4f((float) 0.0f, (float) 0.0f, (float) 0.0f, (float) f7);
            GL11.glBegin((int) 2);
            GL11.glVertex2d((double) f, (double) f2);
            GL11.glVertex2d((double) (f - f3 / f4), (double) (f2 + f3));
            GL11.glVertex2d((double) f, (double) (f2 + f3 / f5));
            GL11.glVertex2d((double) (f + f3 / f4), (double) (f2 + f3));
            GL11.glVertex2d((double) f, (double) f2);
            GL11.glEnd();
        }
        GL11.glPopMatrix();
        GL11.glEnable((int) 3553);
        if (!bl2) {
            GL11.glDisable((int) 3042);
        }
        GL11.glDisable((int) 2848);
    }

    public static int Method2163068(int n2, int n3, float f, float f2) {
        float f3 = (System.currentTimeMillis() + (long) n3) % (long) n2;
        return Color.getHSBColor(f3 / (float) n2, f, f2).getRGB();
    }

    public static void Method2163069(int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static boolean Method2163060(Entity entity) {
        return RenderUtil.Method2163071(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
    }

    public static boolean Method2163071(AxisAlignedBB axisAlignedBB) {
        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
        Field3110.setPosition(Objects.requireNonNull(entity).posX, entity.posY, entity.posZ);
        return Field3110.isBoundingBoxInFrustum(axisAlignedBB);
    }

    public static void Method2163072(float f, float f2, float f3, float f4, float f5) {
        GL11.glEnable((int) 3042);
        RenderUtil.Method2163055(f + f3 - f5, f2 + f4 - f5, f5, 0.0f, 90.0f, 16);
        RenderUtil.Method2163055(f + f5, f2 + f4 - f5, f5, 90.0f, 180.0f, 16);
        RenderUtil.Method2163055(f + f5, f2 + f5, f5, 180.0f, 270.0f, 16);
        RenderUtil.Method2163055(f + f3 - f5, f2 + f5, f5, 270.0f, 360.0f, 16);
        GL11.glBegin((int) 4);
        GL11.glVertex2d((double) (f + f3 - f5), (double) f2);
        GL11.glVertex2d((double) (f + f5), (double) f2);
        GL11.glVertex2d((double) (f + f3 - f5), (double) (f2 + f5));
        GL11.glVertex2d((double) (f + f3 - f5), (double) (f2 + f5));
        GL11.glVertex2d((double) (f + f5), (double) f2);
        GL11.glVertex2d((double) (f + f5), (double) (f2 + f5));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f5));
        GL11.glVertex2d((double) f, (double) (f2 + f5));
        GL11.glVertex2d((double) f, (double) (f2 + f4 - f5));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f5));
        GL11.glVertex2d((double) f, (double) (f2 + f4 - f5));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f4 - f5));
        GL11.glVertex2d((double) (f + f3 - f5), (double) (f2 + f4 - f5));
        GL11.glVertex2d((double) (f + f5), (double) (f2 + f4 - f5));
        GL11.glVertex2d((double) (f + f3 - f5), (double) (f2 + f4));
        GL11.glVertex2d((double) (f + f3 - f5), (double) (f2 + f4));
        GL11.glVertex2d((double) (f + f5), (double) (f2 + f4 - f5));
        GL11.glVertex2d((double) (f + f5), (double) (f2 + f4));
        RenderUtil.Method2163032();
    }

    public static void Method2163073(float f) {
        RenderUtil.Method2163070();
        GL11.glPushAttrib((int) 1048575);
        GL11.glDisable((int) 3008);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2896);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glLineWidth((float) f);
        GL11.glEnable((int) 2848);
        GL11.glEnable((int) 2960);
        GL11.glClear((int) 1024);
        GL11.glClearStencil((int) 15);
        GL11.glStencilFunc((int) 512, (int) 1, (int) 15);
        GL11.glStencilOp((int) 7681, (int) 7681, (int) 7681);
        GL11.glPolygonMode((int) 1032, (int) 6913);
    }

    public static void Method2163074() {
        GL11.glStencilFunc((int) 512, (int) 0, (int) 15);
        GL11.glStencilOp((int) 7681, (int) 7681, (int) 7681);
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static void Method2163075() {
        GL11.glStencilFunc((int) 514, (int) 1, (int) 15);
        GL11.glStencilOp((int) 7680, (int) 7680, (int) 7680);
        GL11.glPolygonMode((int) 1032, (int) 6913);
    }

    public static void Method2163076(Color color) {
        RenderUtil.Method2163079(color);
        GL11.glDepthMask((boolean) false);
        GL11.glDisable((int) 2929);
        GL11.glEnable((int) 10754);
        GL11.glPolygonOffset((float) 1.0f, (float) -2000000.0f);
        OpenGlHelper.setLightmapTextureCoords((int) OpenGlHelper.lightmapTexUnit, (float) 240.0f, (float) 240.0f);
    }

    public static void Method2163077() {
        GL11.glPolygonOffset((float) 1.0f, (float) 2000000.0f);
        GL11.glDisable((int) 10754);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 2960);
        GL11.glDisable((int) 2848);
        GL11.glHint((int) 3154, (int) 4352);
        GL11.glEnable((int) 3042);
        GL11.glEnable((int) 2896);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 3008);
        GL11.glPopAttrib();
    }

    public static void Method2163078(float f, float f2, float f3) {
        GlStateManager.rotate((float) f2, (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) f3, (float) 0.0f, (float) 0.0f, (float) 1.0f);
        GlStateManager.rotate((float) f, (float) 1.0f, (float) 0.0f, (float) 0.0f);
    }

    public static void Method2163079(Color color) {
        GL11.glColor4d((double) ((double) color.getRed() / 255.0), (double) ((double) color.getGreen() / 255.0), (double) ((double) color.getBlue() / 255.0), (double) ((double) color.getAlpha() / 255.0));
    }

    public static void Method2163070() {
        Framebuffer framebuffer = RenderUtil.Field2811.framebuffer;
        if (framebuffer != null && framebuffer.depthBuffer > -1) {
            RenderUtil.Method2163081(framebuffer);
            framebuffer.depthBuffer = -1;
        }
    }

    private static void Method2163081(Framebuffer framebuffer) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT((int) framebuffer.depthBuffer);
        int n2 = EXTFramebufferObject.glGenRenderbuffersEXT();
        EXTFramebufferObject.glBindRenderbufferEXT((int) 36161, (int) n2);
        EXTFramebufferObject.glRenderbufferStorageEXT((int) 36161, (int) 34041, (int) RenderUtil.Field2811.displayWidth, (int) RenderUtil.Field2811.displayHeight);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int) 36160, (int) 36128, (int) 36161, (int) n2);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int) 36160, (int) 36096, (int) 36161, (int) n2);
    }

    public static void Method2163082(double d, double d2, double d3, double d4, Color color, float f) {
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
        float f2 = (float) (color.getRGB() >> 24 & 0xFF) / 255.0f;
        float f3 = (float) (color.getRGB() >> 16 & 0xFF) / 255.0f;
        float f4 = (float) (color.getRGB() >> 8 & 0xFF) / 255.0f;
        float f5 = (float) (color.getRGB() & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GL11.glPolygonMode((int) 1032, (int) 6913);
        GL11.glLineWidth((float) f);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f3, (float) f4, (float) f5, (float) f2);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).endVertex();
        bufferBuilder.pos(d, d2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static final void Method2163083(float f, float f2, float f3, float f4, int n2) {
        GL11.glEnable((int) 3042);
        GL11.glEnable((int) 2848);
        RenderUtil.Method2163027(f, f2, f3, f4, n2);
        GL11.glScalef((float) 0.5f, (float) 0.5f, (float) 0.5f);
        RenderUtil.Method2163027(f * 2.0f - 1.0f, f2 * 2.0f, f * 2.0f, f4 * 2.0f - 1.0f, n2);
        RenderUtil.Method2163027(f * 2.0f, f2 * 2.0f - 1.0f, f3 * 2.0f, f2 * 2.0f, n2);
        RenderUtil.Method2163027(f3 * 2.0f, f2 * 2.0f, f3 * 2.0f + 1.0f, f4 * 2.0f - 1.0f, n2);
        RenderUtil.Method2163027(f * 2.0f, f4 * 2.0f - 1.0f, f3 * 2.0f, f4 * 2.0f, n2);
        GL11.glDisable((int) 3042);
        GL11.glScalef((float) 2.0f, (float) 2.0f, (float) 2.0f);
    }

    public static final void Method2163084(double d, double d2, double d3, double d4, int n2) {
        GL11.glEnable((int) 3042);
        GL11.glEnable((int) 2848);
        RenderUtil.Method2163085(d, d2, d3, d4, n2);
        GL11.glScalef((float) 0.5f, (float) 0.5f, (float) 0.5f);
        RenderUtil.Method2163085(d * 2.0 - 1.0, d2 * 2.0, d * 2.0, d4 * 2.0 - 1.0, n2);
        RenderUtil.Method2163085(d * 2.0, d2 * 2.0 - 1.0, d3 * 2.0, d2 * 2.0, n2);
        RenderUtil.Method2163085(d3 * 2.0, d2 * 2.0, d3 * 2.0 + 1.0, d4 * 2.0 - 1.0, n2);
        RenderUtil.Method2163085(d * 2.0, d4 * 2.0 - 1.0, d3 * 2.0, d4 * 2.0, n2);
        GL11.glDisable((int) 3042);
        GL11.glScalef((float) 2.0f, (float) 2.0f, (float) 2.0f);
    }

    public static void Method2163085(double d, double d2, double d3, double d4, int n2) {
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(d, d4, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(d, d2, 0.0).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2163086(AxisAlignedBB axisAlignedBB, Color color, Color color2, boolean bl) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            RenderUtil.Method2163087(axisAlignedBB.grow(Double.longBitsToDouble(Double.doubleToLongBits(2433.56417635812) ^ 0x7FC3616D3BB93E9BL)), enumFacing, color, color2, bl);
        }
    }

    public static void Method2163087(AxisAlignedBB axisAlignedBB, EnumFacing enumFacing, Color color, Color color2, boolean bl) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        float f = (float) color.getRed() / Float.intBitsToFloat(Float.floatToIntBits(0.27211377f) ^ 0x7DF4527F);
        float f2 = (float) color.getGreen() / Float.intBitsToFloat(Float.floatToIntBits(0.12230372f) ^ 0x7E857A5F);
        float f3 = (float) color.getBlue() / Float.intBitsToFloat(Float.floatToIntBits(0.008009558f) ^ 0x7F7C3A85);
        float f4 = (float) color.getAlpha() / Float.intBitsToFloat(Float.floatToIntBits(0.013573141f) ^ 0x7F2161E1);
        float f5 = (float) color2.getRed() / Float.intBitsToFloat(Float.floatToIntBits(0.015459908f) ^ 0x7F024B8E);
        float f6 = (float) color2.getGreen() / Float.intBitsToFloat(Float.floatToIntBits(0.007945256f) ^ 0x7F7D2CD2);
        float f7 = (float) color2.getBlue() / Float.intBitsToFloat(Float.floatToIntBits(0.009713325f) ^ 0x7F6024A3);
        float f8 = (float) color2.getAlpha() / Float.intBitsToFloat(Float.floatToIntBits(0.008760959f) ^ 0x7F708A20);
        double d = Double.longBitsToDouble(Double.doubleToLongBits(1.1084267949930563E308) ^ 0x7FE3BB0C007E4029L);
        double d2 = Double.longBitsToDouble(Double.doubleToLongBits(1.136153967114939E308) ^ 0x7FE43965F4022B39L);
        double d3 = Double.longBitsToDouble(Double.doubleToLongBits(4.3109616506545676E307) ^ 0x7FCEB1EFD5AC3A73L);
        double d4 = Double.longBitsToDouble(Double.doubleToLongBits(1.6087854571859715E308) ^ 0x7FECA3282BE4DCDFL);
        double d5 = Double.longBitsToDouble(Double.doubleToLongBits(1.3893593717110467E308) ^ 0x7FE8BB3E317C7857L);
        double d6 = Double.longBitsToDouble(Double.doubleToLongBits(1.5476281096126842E308) ^ 0x7FEB8C7743188780L);
        switch (1.F ield2828[enumFacing.ordinal()]){
            case 1: {
                d = axisAlignedBB.minX;
                d4 = axisAlignedBB.maxX;
                d2 = axisAlignedBB.minY;
                d5 = axisAlignedBB.minY;
                d3 = axisAlignedBB.minZ;
                d6 = axisAlignedBB.maxZ;
                break;
            }
            case 2: {
                d = axisAlignedBB.minX;
                d4 = axisAlignedBB.maxX;
                d2 = axisAlignedBB.maxY;
                d5 = axisAlignedBB.maxY;
                d3 = axisAlignedBB.minZ;
                d6 = axisAlignedBB.maxZ;
                break;
            }
            case 3: {
                d = axisAlignedBB.maxX;
                d4 = axisAlignedBB.maxX;
                d2 = axisAlignedBB.minY;
                d5 = axisAlignedBB.maxY;
                d3 = axisAlignedBB.minZ;
                d6 = axisAlignedBB.maxZ;
                break;
            }
            case 4: {
                d = axisAlignedBB.minX;
                d4 = axisAlignedBB.minX;
                d2 = axisAlignedBB.minY;
                d5 = axisAlignedBB.maxY;
                d3 = axisAlignedBB.minZ;
                d6 = axisAlignedBB.maxZ;
                break;
            }
            case 5: {
                d = axisAlignedBB.minX;
                d4 = axisAlignedBB.maxX;
                d2 = axisAlignedBB.minY;
                d5 = axisAlignedBB.maxY;
                d3 = axisAlignedBB.maxZ;
                d6 = axisAlignedBB.maxZ;
                break;
            }
            case 6: {
                d = axisAlignedBB.minX;
                d4 = axisAlignedBB.maxX;
                d2 = axisAlignedBB.minY;
                d5 = axisAlignedBB.maxY;
                d3 = axisAlignedBB.minZ;
                d6 = axisAlignedBB.minZ;
            }
        }
        if (enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP || enumFacing == EnumFacing.EAST || enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.SOUTH || enumFacing == EnumFacing.NORTH) {
            // empty if block
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        if (!bl) {
            GlStateManager.depthMask((boolean) false);
            GlStateManager.disableDepth();
        }
        bufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        if (enumFacing == EnumFacing.EAST || enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.NORTH || enumFacing == EnumFacing.SOUTH) {
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.UP) {
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f5, f6, f7, f8).endVertex();
        } else if (enumFacing == EnumFacing.DOWN) {
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d2, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d3).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
            bufferBuilder.pos(d4, d5, d6).color(f, f2, f3, f4).endVertex();
        }
        tessellator.draw();
        if (!bl) {
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
        }
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

        public static void Method2163088(AxisAlignedBB axisAlignedBB, Color color) {
        Field3116.setPosition(Objects.requireNonNull(RenderUtil.Field2811.getRenderViewEntity()).posX, RenderUtil.Field2811.getRenderViewEntity().posY, RenderUtil.Field2811.getRenderViewEntity().posZ);
        if (Field3116.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / Float.intBitsToFloat(Float.floatToIntBits(0.015003811f) ^ 0x7F0AD28B)), (float) ((float) color.getGreen() / Float.intBitsToFloat(Float.floatToIntBits(0.008765428f) ^ 0x7F709CDF)), (float) ((float) color.getBlue() / Float.intBitsToFloat(Float.floatToIntBits(0.088410296f) ^ 0x7ECA1075)), (float) ((float) color.getAlpha() / Float.intBitsToFloat(Float.floatToIntBits(0.012969875f) ^ 0x7F2B7F99)));
            GL11.glDisable((int) 2848);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil$IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll

public static final class me

    public static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
            extends Tessellator {
        public static IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field0 = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
            super(0x200000);
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(int n2) {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(n2);
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
            GL11.glBlendFunc((int) 770, (int) 771);
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth((float) 1.5f);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
        }

        public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(int n2) {
            Field0.getBuffer().begin(n2, DefaultVertexFormats.POSITION_COLOR);
        }

        public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
        }

        public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
            Field0.draw();
        }

        public static void IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll() {
            GlStateManager.enableCull();
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, int n2, int n3) {
            int n4 = n2 >>> 24 & 0xFF;
            int n5 = n2 >>> 16 & 0xFF;
            int n6 = n2 >>> 8 & 0xFF;
            int n7 = n2 & 0xFF;
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(blockPos, n5, n6, n7, n4, n3);
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(float f, float f2, float f3, int n2, int n3) {
            int n4 = n2 >>> 24 & 0xFF;
            int n5 = n2 >>> 16 & 0xFF;
            int n6 = n2 >>> 8 & 0xFF;
            int n7 = n2 & 0xFF;
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field0.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n5, n6, n7, n4, n3);
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field0.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
        }

        public static BufferBuilder IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll() {
            return Field0.getBuffer();
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
            if ((n6 & 1) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 2) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 4) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 8) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x10) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x20) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
        }

        public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
            if ((n6 & 0x11) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x12) != 0) {
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x21) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x22) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 5) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 6) != 0) {
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 9) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0xA) != 0) {
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x14) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x24) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x18) != 0) {
                bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
            if ((n6 & 0x28) != 0) {
                bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
                bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            }
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4, float f5) {
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

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n2, int n3) {
            int n4 = n2 >>> 24 & 0xFF;
            int n5 = n2 >>> 16 & 0xFF;
            int n6 = n2 >>> 8 & 0xFF;
            int n7 = n2 & 0xFF;
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(axisAlignedBB, blockPos, f, n5, n6, n7, n4, n3);
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n2, int n3, int n4, int n5, int n6) {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(7);
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(blockPos, n2, n3, n4, n5, 63);
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(axisAlignedBB, f, (float) n2, (float) n3, (float) n4, (float) n6);
        }

        public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(BlockPos blockPos, int n2, int n3) {
            int n4 = n2 >>> 24 & 0xFF;
            int n5 = n2 >>> 16 & 0xFF;
            int n6 = n2 >>> 8 & 0xFF;
            int n7 = n2 & 0xFF;
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(blockPos, n5, n6, n7, n4, n3);
        }

        public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field0.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 0.5f, 1.0f, n2, n3, n4, n5, n6);
        }
    }
}

