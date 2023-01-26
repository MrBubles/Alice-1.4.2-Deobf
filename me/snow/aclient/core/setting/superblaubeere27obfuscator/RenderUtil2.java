

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
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.EXTFramebufferObject
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.GLU
 *  org.lwjgl.util.glu.Sphere
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public class RenderUtil2
        implements Util {
    static final boolean Field1079;
    private static final Frustum Field1063;
    private static final FloatBuffer Field1064;
    private static final IntBuffer Field1065;
    private static final FloatBuffer Field1066;
    private static final FloatBuffer Field1067;
    private static final BufferBuilder Field1077;
    public static RenderItem Field1068;
    public static ICamera Field1069;
    public static Tessellator Field1075;
    public static BufferBuilder Field1076;
    public static int Field1078;
    private static boolean Field1070;
    private static boolean Field1071;
    private static boolean Field1072;
    private static boolean Field1073;
    private static boolean Field1074;

    static {
        Field1079 = !RenderUtil2.class.desiredAssertionStatus();
        Field1063 = new Frustum();
        Field1064 = BufferUtils.createFloatBuffer((int) 3);
        Field1065 = BufferUtils.createIntBuffer((int) 16);
        Field1066 = BufferUtils.createFloatBuffer((int) 16);
        Field1067 = BufferUtils.createFloatBuffer((int) 16);
        Field1068 = RenderUtil2.Field2811.getItemRenderer().itemRenderer;
        Field1069 = new Frustum();
        Field1070 = GL11.glIsEnabled((int) 2896);
        Field1071 = GL11.glIsEnabled((int) 3042);
        Field1072 = GL11.glIsEnabled((int) 3553);
        Field1073 = GL11.glIsEnabled((int) 2929);
        Field1074 = GL11.glIsEnabled((int) 2848);
        Field1075 = Tessellator.getInstance();
        Field1077 = Field1075.getBuffer();
        Field1068 = Field2811.getRenderItem();
        Field1069 = new Frustum();
        Field1070 = GL11.glIsEnabled((int) 2896);
        Field1071 = GL11.glIsEnabled((int) 3042);
        Field1072 = GL11.glIsEnabled((int) 3553);
        Field1073 = GL11.glIsEnabled((int) 2929);
        Field1074 = GL11.glIsEnabled((int) 2848);
        Field1076 = Field1075.getBuffer();
    }

    {
        public static final HashMap Field1635 = new HashMap();

        static {
        Field1635.put(EnumFacing.DOWN, 1);
        Field1635.put(EnumFacing.WEST, 16);
        Field1635.put(EnumFacing.NORTH, 4);
        Field1635.put(EnumFacing.SOUTH, 8);
        Field1635.put(EnumFacing.EAST, 32);
        Field1635.put(EnumFacing.UP, 2);
    }

        public static final class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
            public static final int Field1456 = 1;
            public static final int Field1457 = 2;
            public static final int Field1458 = 4;
            public static final int Field1459 = 8;
            public static final int Field1460 = 16;
            public static final int Field1461 = 32;
            public static final int Field1462 = 63;
        }

        public static final class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
            public static final int Field2735 = 17;
            public static final int Field2736 = 18;
            public static final int Field2737 = 33;
            public static final int Field2738 = 34;
            public static final int Field2739 = 5;
            public static final int Field2740 = 6;
            public static final int Field2741 = 9;
            public static final int Field2742 = 10;
            public static final int Field2743 = 20;
            public static final int Field2744 = 36;
            public static final int Field2745 = 24;
            public static final int Field2746 = 40;
            public static final int Field2747 = 63;
        }
    }

    public static void Method2164566(BlockPos blockPos, Color color, float f, boolean bl, boolean bl2, int n2, boolean bl3) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
        Field1069.setPosition(Objects.requireNonNull(RenderUtil2.Field2811.getRenderViewEntity()).posX, RenderUtil2.Field2811.getRenderViewEntity().posY, RenderUtil2.Field2811.getRenderViewEntity().posZ);
        if (Field1069.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) f);
            double d = RenderUtil2.Field2811.player.getDistance((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() + 0.5f), (double) ((float) blockPos.getZ() + 0.5f)) * 0.75;
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method2164567(int n2, int n3, int n4, int n5, int n6) {
        GL11.glLineWidth((float) 1.0f);
        Gui.drawRect((int) n2, (int) n3, (int) (n2 + n4), (int) (n3 + n5), (int) n6);
    }

    public static AxisAlignedBB Method2164568(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(axisAlignedBB.minX - RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
    }

    public static boolean Method2164569(Entity entity) {
        return RenderUtil2.Method2164560(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
    }

    public static boolean Method2164560(AxisAlignedBB axisAlignedBB) {
        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
        Field1063.setPosition(entity.posX, entity.posY, entity.posZ);
        return Field1063.isBoundingBoxInFrustum(axisAlignedBB);
    }

    public static Vec3d Method2164571(double d, double d2, double d3) {
        GL11.glGetFloat((int) 2982, (FloatBuffer) Field1066);
        GL11.glGetFloat((int) 2983, (FloatBuffer) Field1067);
        GL11.glGetInteger((int) 2978, (IntBuffer) Field1065);
        boolean bl = GLU.gluProject((float) ((float) d), (float) ((float) d2), (float) ((float) d3), (FloatBuffer) Field1066, (FloatBuffer) Field1067, (IntBuffer) Field1065, (FloatBuffer) Field1064);
        if (bl) {
            return new Vec3d((double) Field1064.get(0), (double) ((float) Display.getHeight() - Field1064.get(1)), (double) Field1064.get(2));
        }
        return null;
    }

    public static void Method2164572(float f, float f2, float f3, float f4, float f5, boolean bl, float f6, int n2) {
        boolean bl2 = GL11.glIsEnabled((int) 3042);
        float f7 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glPushMatrix();
        RenderUtil2.Method2164573(n2);
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

    public static void Method2164573(int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static void Method2164574(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos((double) (n2 + 0), (double) (n3 + n7), (double) n8).tex((double) ((float) (n4 + 0) * 0.00390625f), (double) ((float) (n5 + n7) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double) (n2 + n6), (double) (n3 + n7), (double) n8).tex((double) ((float) (n4 + n6) * 0.00390625f), (double) ((float) (n5 + n7) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double) (n2 + n6), (double) (n3 + 0), (double) n8).tex((double) ((float) (n4 + n6) * 0.00390625f), (double) ((float) (n5 + 0) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double) (n2 + 0), (double) (n3 + 0), (double) n8).tex((double) ((float) (n4 + 0) * 0.00390625f), (double) ((float) (n5 + 0) * 0.00390625f)).endVertex();
        tessellator.draw();
    }

    public static void Method2164575(BlockPos blockPos, Color color, double d, double d2) {
        RenderUtil2.Method2164672(blockPos, color, d, d2);
    }

    public static void Method2164576(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n2, boolean bl4) {
        if (bl3) {
            RenderUtil2.Method2164579(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n2));
        }
        if (bl2) {
            RenderUtil2.Method2164570(blockPos, bl ? color2 : color, f, bl4);
        }
    }

    public static void Method2164577(float f, float f2, float f3, float f4, ScaledResolution scaledResolution) {
        GL11.glScissor((int) ((int) (f * (float) scaledResolution.getScaleFactor())), (int) ((int) ((float) RenderUtil2.Field2811.displayHeight - f4 * (float) scaledResolution.getScaleFactor())), (int) ((int) ((f3 - f) * (float) scaledResolution.getScaleFactor())), (int) ((int) ((f4 - f2) * (float) scaledResolution.getScaleFactor())));
    }

    public static void Method2164578(float f, float f2, float f3, float f4, float f5, int n2) {
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

    public static void Method2164579(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
        Field1069.setPosition(Objects.requireNonNull(RenderUtil2.Field2811.getRenderViewEntity()).posX, RenderUtil2.Field2811.getRenderViewEntity().posY, RenderUtil2.Field2811.getRenderViewEntity().posZ);
        if (Field1069.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ))) {
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

    public static void Method2164570(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = RenderUtil2.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtil2.Field2811.world.getWorldBorder().contains(blockPos)) {
            if (!Field1079 && RenderUtil2.Field2811.renderViewEntity == null) {
                throw new AssertionError();
            }
            Vec3d vec3d = EntityUtil.Method2163492(RenderUtil2.Field2811.renderViewEntity, Field2811.getRenderPartialTicks());
            RenderUtil2.Method2164581(iBlockState.getSelectedBoundingBox((World) RenderUtil2.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    public static void Method2164581(AxisAlignedBB axisAlignedBB, Color color, float f) {
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

    public static double Method2164582() {
        return ((IRenderManager) Field2811.getRenderManager()).getRenderPosX();
    }

    public static double Method2164583() {
        return ((IRenderManager) Field2811.getRenderManager()).getRenderPosY();
    }

    public static double Method2164584() {
        return ((IRenderManager) Field2811.getRenderManager()).getRenderPosZ();
    }

    public static void Method2164585(BlockPos blockPos, Color color, float f, boolean bl, boolean bl2, int n2) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
        Field1069.setPosition(Objects.requireNonNull(RenderUtil2.Field2811.getRenderViewEntity()).posX, RenderUtil2.Field2811.getRenderViewEntity().posY, RenderUtil2.Field2811.getRenderViewEntity().posZ);
        if (Field1069.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) f);
            double d = RenderUtil2.Field2811.player.getDistance((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() + 0.5f), (double) ((float) blockPos.getZ() + 0.5f)) * 0.75;
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

    public static void Method2164586(float f, float f2, float f3, float f4, int n2) {
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

    public static void Method2164587() {
        GlStateManager.pushMatrix();
        RenderUtil2.Method2164593(1.0f);
        GL11.glEnable((int) 2848);
        GL11.glEnable((int) 34383);
        GL11.glHint((int) 3154, (int) 4354);
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel((int) 7425);
        GlStateManager.disableCull();
        GlStateManager.enableBlend();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
    }

    public static void Method2164588() {
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.enableAlpha();
        GlStateManager.depthMask((boolean) true);
        GL11.glDisable((int) 34383);
        GL11.glDisable((int) 2848);
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
        RenderUtil2.Method2164593(1.0f);
        GlStateManager.popMatrix();
    }

    private static void Method2164589(double d, double d2, double d3, int n2, int n3, int n4, int n5) {
        Field1076.pos(d - RenderUtil2.Field2811.getRenderManager().viewerPosX, d2 - RenderUtil2.Field2811.getRenderManager().viewerPosY, d3 - RenderUtil2.Field2811.getRenderManager().viewerPosZ).color(n2, n3, n4, n5).endVertex();
    }

    private static void Method2164580(int n2, int n3, int n4, int n5) {
        Field1076.pos(0.0, (double) RenderUtil2.Field2811.player.getEyeHeight(), 0.0).color(n2, n3, n4, n5).endVertex();
    }

    private static BufferBuilder Method2164591(double d, double d2, double d3) {
        return Field1076.pos(d - RenderUtil2.Field2811.getRenderManager().viewerPosX, d2 - RenderUtil2.Field2811.getRenderManager().viewerPosY, d3 - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2164592() {
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
    }

    private static void Method2164593(float f) {
        GlStateManager.glLineWidth((float) f);
    }

    public static void Method2164594(AxisAlignedBB axisAlignedBB, float f, float f2, Color color) {
        GlStateManager.pushMatrix();
        RenderUtil2.Method2164592();
        RenderUtil2.Method2164593(f);
        double d = axisAlignedBB.minX;
        double d2 = axisAlignedBB.minY;
        double d3 = axisAlignedBB.minZ;
        double d4 = axisAlignedBB.maxX;
        double d5 = axisAlignedBB.maxY;
        double d6 = axisAlignedBB.maxZ;
        Field1076.begin(3, DefaultVertexFormats.POSITION_COLOR);
        RenderUtil2.Method2164591(d, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d2, d3 + (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d2, d6 - (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3 + (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6 - (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d + (double) f2, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d + (double) f2, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4 - (double) f2, d2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4 - (double) f2, d2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d2 + (double) f2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d2 + (double) f2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d2 + (double) f2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d2 + (double) f2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d5, d3 + (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d5, d6 - (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3 + (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6 - (double) f2).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d + (double) f2, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d + (double) f2, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4 - (double) f2, d5, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4 - (double) f2, d5, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d5 - (double) f2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d, d5 - (double) f2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d5 - (double) f2, d3).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), 0.0f).endVertex();
        RenderUtil2.Method2164591(d4, d5 - (double) f2, d6).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        Field1075.draw();
        RenderUtil2.Method2164590();
        GlStateManager.popMatrix();
    }

    public static void Method2164595(AxisAlignedBB axisAlignedBB, Color color) {
        GlStateManager.pushMatrix();
        RenderUtil2.Method2164592();
        RenderUtil2.Method2164593(1.0f);
        int n2 = color.getRed();
        int n3 = color.getBlue();
        int n4 = color.getGreen();
        int n5 = color.getAlpha();
        Field1076.begin(5, DefaultVertexFormats.POSITION_COLOR);
        double d = axisAlignedBB.minX;
        double d2 = axisAlignedBB.minY;
        double d3 = axisAlignedBB.minZ;
        double d4 = axisAlignedBB.maxX;
        double d5 = axisAlignedBB.maxY;
        double d6 = axisAlignedBB.maxZ;
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(n2, n4, n3, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(n2, n4, n3, n5).endVertex();
        Field1075.draw();
        RenderUtil2.Method2164590();
        GlStateManager.popMatrix();
    }

    public static void Method2164596(AxisAlignedBB axisAlignedBB, float f, Color color) {
        int n2 = color.getRed();
        int n3 = color.getGreen();
        int n4 = color.getBlue();
        int n5 = color.getAlpha();
        double d = axisAlignedBB.minX;
        double d2 = axisAlignedBB.minY;
        double d3 = axisAlignedBB.minZ;
        double d4 = axisAlignedBB.maxX;
        double d5 = axisAlignedBB.maxY + (double) f;
        double d6 = axisAlignedBB.maxZ;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GL11.glDisable((int) 2929);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.disableCull();
        GlStateManager.shadeModel((int) 7425);
        Field1076.begin(7, DefaultVertexFormats.POSITION_COLOR);
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d3).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d3).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d4, d2, d6).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d4, d5, d6).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d, d2, d3).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d, d2, d6).color(n2, n3, n4, n5).endVertex();
        RenderUtil2.Method2164591(d, d5, d6).color(0, 0, 0, 0).endVertex();
        RenderUtil2.Method2164591(d, d5, d3).color(0, 0, 0, 0).endVertex();
        Field1075.draw();
        GL11.glEnable((int) 2929);
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public static void Method2164597(AxisAlignedBB axisAlignedBB, float f, Color color) {
        RenderUtil2.Method2164599(f);
        int n2 = color.getRed();
        int n3 = color.getBlue();
        int n4 = color.getGreen();
        int n5 = color.getAlpha();
        Field1076.begin(3, DefaultVertexFormats.POSITION_COLOR);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, n2, n4, n3, n5);
        RenderUtil2.Method2164589(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, n2, n4, n3, n5);
        Field1075.draw();
        RenderUtil2.Method2164598();
    }

    public static void Method2164598() {
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 2884);
        GlStateManager.popMatrix();
    }

    public static void Method2164599(float f) {
        GlStateManager.pushMatrix();
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDisable((int) 2884);
        GL11.glDepthMask((boolean) false);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        RenderUtil2.Method2164593(f);
    }

    public static void Method2164590() {
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2164501() {
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

    public static void Method2164502() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public static void Method2164503(BlockPos blockPos, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        RenderUtil2.Method2164506(blockPos, n5, n6, n7, n4, n3);
    }

    public static void Method2164504(double d, double d2, double d3, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        RenderUtil2.Method2164508(Field1075.getBuffer(), d, d2, d3, 1.0f, 1.0f, 1.0f, n5, n6, n7, n4, n3);
    }

    public static void Method2164505(double d, double d2, double d3, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        RenderUtil2.Method2164508(Field1075.getBuffer(), d, d2, d3, 0.25f, 0.25f, 0.25f, n5, n6, n7, n4, n3);
    }

    public static void Method2164506(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
        RenderUtil2.Method2164508(Field1075.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
    }

    public static BufferBuilder Method2164507() {
        return Field1075.getBuffer();
    }

    public static void Method2164508(BufferBuilder bufferBuilder, double d, double d2, double d3, float f, float f2, float f3, int n2, int n3, int n4, int n5, int n6) {
        if ((n6 & 1) != 0) {
            bufferBuilder.pos(d + (double) f, d2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2, d3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 2) != 0) {
            bufferBuilder.pos(d + (double) f, d2 + (double) f2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2 + (double) f2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2 + (double) f2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2 + (double) f2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 4) != 0) {
            bufferBuilder.pos(d + (double) f, d2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2 + (double) f2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2 + (double) f2, d3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 8) != 0) {
            bufferBuilder.pos(d, d2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2 + (double) f2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2 + (double) f2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 0x10) != 0) {
            bufferBuilder.pos(d, d2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2 + (double) f2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d, d2 + (double) f2, d3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 0x20) != 0) {
            bufferBuilder.pos(d + (double) f, d2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2 + (double) f2, d3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(d + (double) f, d2 + (double) f2, d3 + (double) f3).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void Method2164509(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
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

    public static void Method2164500(float f, float f2, float f3, float f4, int n2) {
        float f5 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f7 = (float) (n2 & 0xFF) / 255.0f;
        float f8 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f5, f6, f7, f8).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2164611(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164612(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164613(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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

    public static void Method2164614(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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

    public static void Method2164615(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164616(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164617(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164618(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5 / 2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164619(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d, d2, d3, d + 1.0, d2 + 0.5, d3 + 1.0);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164610(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d, d2, d3, d + 1.0, d2 + 0.0, d3 + 1.0);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164621(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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
        double d = (double) blockPos.getX() + 0.06 - minecraft.getRenderManager().viewerPosX;
        double d2 = (double) blockPos.getY() - minecraft.getRenderManager().viewerPosY;
        double d3 = (double) blockPos.getZ() + 0.06 - minecraft.getRenderManager().viewerPosZ;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d, d2, d3, d + 0.881, d2 + 0.875, d3 + 0.881);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164622(double d, double d2, double d3, float f, int n2, int n3, int n4, int n5) {
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
        double d4 = d - 0.2 - minecraft.getRenderManager().viewerPosX;
        double d5 = d2 - minecraft.getRenderManager().viewerPosY;
        double d6 = d3 - 0.2 - minecraft.getRenderManager().viewerPosZ;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d4, d5, d6, d4 + 0.4, d5 + 0.4, d6 + 0.4);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164623(AxisAlignedBB axisAlignedBB, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164624(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, int n2, int n3, int n4, int n5) {
        bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f5)).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f5)).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
    }

    public static void Method2164625(int n2) {
        RenderUtil2.Method2164501();
        RenderUtil2.Method2164648(n2);
    }

    public static void Method2164626(String string) {
        int n2 = 0;
        if (string.equalsIgnoreCase("quads")) {
            n2 = 7;
        } else if (string.equalsIgnoreCase("lines")) {
            n2 = 1;
        }
        RenderUtil2.Method2164627();
        RenderUtil2.Method2164648(n2);
    }

    public static void Method2164627() {
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
        GL11.glLineWidth((float) 2.0f);
    }

    public static void Method2164628(BlockPos blockPos, Color color, float f, boolean bl, double d, boolean bl2, boolean bl3, int n2) {
        if (bl2) {
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
            RenderUtil2.Method2164629(blockPos, bl3 ? color2 : color, bl3 ? color : color2, f, d);
            return;
        }
        IBlockState iBlockState = RenderUtil2.Field2811.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && RenderUtil2.Field2811.world.getWorldBorder().contains(blockPos)) {
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
            RenderUtil2.Method2164581(axisAlignedBB.grow((double) 0.002f), color, f);
        }
    }

    public static void Method2164629(BlockPos blockPos, Color color, Color color2, float f, double d) {
        IBlockState iBlockState = RenderUtil2.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil2.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtil2.Method2164620(iBlockState.getSelectedBoundingBox((World) RenderUtil2.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z).expand(0.0, d, 0.0), color, color2, f);
    }

    public static void Method2164620(AxisAlignedBB axisAlignedBB, Color color, Color color2, float f) {
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

    public static void Method2164631(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n2, boolean bl4, double d, boolean bl5, boolean bl6, boolean bl7, boolean bl8, int n3) {
        if (bl3) {
            RenderUtil2.Method2164635(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n2), d, bl5, bl7, n3);
        }
        if (bl2) {
            RenderUtil2.Method2164628(blockPos, bl ? color2 : color, f, bl4, d, bl6, bl8, n3);
        }
    }

    public static void Method2164632(BlockPos blockPos, Color color, Color color2, double d) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.UP) continue;
            RenderUtil2.Method2164633(blockPos, enumFacing, color, color2, d);
        }
    }

    public static void Method2164633(BlockPos blockPos, EnumFacing enumFacing, Color color, Color color2, double d) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        IBlockState iBlockState = RenderUtil2.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil2.Field2811.player, Field2811.getRenderPartialTicks());
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtil2.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z).expand(0.0, d, 0.0);
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

    public static void Method2164634(BlockPos blockPos, EnumFacing enumFacing, Color color, Color color2, boolean bl, boolean bl2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        IBlockState iBlockState = RenderUtil2.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil2.Field2811.player, Field2811.getRenderPartialTicks());
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtil2.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z);
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

    public static void Method2164635(BlockPos blockPos, Color color, double d, boolean bl, boolean bl2, int n2) {
        if (bl) {
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
            RenderUtil2.Method2164632(blockPos, bl2 ? color2 : color, bl2 ? color : color2, d);
            return;
        }
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY + d, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
        Field1069.setPosition(Objects.requireNonNull(RenderUtil2.Field2811.getRenderViewEntity()).posX, RenderUtil2.Field2811.getRenderViewEntity().posY, RenderUtil2.Field2811.getRenderViewEntity().posZ);
        if (Field1069.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ))) {
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

    public static void Method2164636() {
        Field1075.draw();
    }

    public static void Method2164637() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public static void Method2164638(BlockPos blockPos, int n2, String string) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        RenderUtil2.Method2164630(blockPos, n4, n5, n6, n3, string);
    }

    public static void Method2164639(float f, float f2, float f3, int n2, String string) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        RenderUtil2.Method2164646(Field1075.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n4, n5, n6, n3, string);
    }

    public static void Method2164630(BlockPos blockPos, int n2, int n3, int n4, int n5, String string) {
        RenderUtil2.Method2164646(Field1075.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, string);
    }

    public static void Method2164641(BlockPos blockPos, int n2, String string) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        RenderUtil2.Method2164644(blockPos, n4, n5, n6, n3, string);
    }

    public static void Method2164642(float f, float f2, float f3, int n2, String string) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        RenderUtil2.Method2164647(Field1075.getBuffer(), f, f2, f3, 1.0f, 0.5645f, 1.0f, n4, n5, n6, n3, string);
    }

    public static void Method2164643(float f, float f2, float f3, float f4, float f5, int n2, int n3) {
        float f6 = 0.0f;
        if (f5 < 1.0f) {
            f6 = 1.0f;
        }
        RenderUtil2.Method2164673(f + f5, f2 + f5, f3 - f5, f4 - f5, n2);
        RenderUtil2.Method2164673(f, f2 + 1.0f - f6, f + f5, f4, n3);
        RenderUtil2.Method2164673(f, f2, f3 - 1.0f + f6, f2 + f5, n3);
        RenderUtil2.Method2164673(f3 - f5, f2, f3, f4 - 1.0f + f6, n3);
        RenderUtil2.Method2164673(f + 1.0f - f6, f4 - f5, f3, f4, n3);
    }

    public static void Method2164644(BlockPos blockPos, int n2, int n3, int n4, int n5, String string) {
        RenderUtil2.Method2164647(Field1075.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, string);
    }

    public static BufferBuilder Method2164645() {
        return Field1075.getBuffer();
    }

    public static void Method2164646(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, String string) {
        if (Arrays.asList(string.split("-")).contains("down") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("up") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("north") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("south") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("south") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("south") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void Method2164647(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, String string) {
        if (Arrays.asList(string.split("-")).contains("downwest") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("upwest") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("downeast") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("upeast") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("downnorth") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("upnorth") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("downsouth") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("upsouth") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("nortwest") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("norteast") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("southweast") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if (Arrays.asList(string.split("-")).contains("southeast") || string.equalsIgnoreCase("all")) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void Method2164648(int n2) {
        Field1075.getBuffer().begin(n2, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void Method2164649(BlockPos blockPos, int n2, int n3, int n4, int n5) {
        RenderUtil2.Method2164625(7);
        RenderUtil2.Method2164624(Field1075.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, n2, n3, n4, n5);
        RenderUtil2.Method2164665();
    }

    public static void Method2164640(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
        if ((n6 & 1) != 0) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static Vec3d Method2164651(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(RenderUtil2.Method2164652(entity, f));
    }

    public static Vec3d Method2164652(Entity entity, double d) {
        return RenderUtil2.Method2164653(entity, d, d, d);
    }

    public static Vec3d Method2164653(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static void Method2164654(double d, double d2, double d3, double d4, double d5, int n2, int n3) {
        RenderUtil2.Method2164657();
        RenderUtil2.Method2164656(d + d5, d2 + d5, d3 - d5, d4 - d5, n2);
        RenderUtil2.Method2164656(d + d5, d2, d3 - d5, d2 + d5, n3);
        RenderUtil2.Method2164656(d, d2, d + d5, d4, n3);
        RenderUtil2.Method2164656(d3 - d5, d2, d3, d4, n3);
        RenderUtil2.Method2164656(d + d5, d4 - d5, d3 - d5, d4, n3);
        RenderUtil2.Method2164658();
    }

    public static AxisAlignedBB Method2164655(AxisAlignedBB axisAlignedBB) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB;
        return new AxisAlignedBB(axisAlignedBB2.minX - RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.minY - RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.minZ - RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB2.maxX - RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB2.maxY - RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB2.maxZ - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2164656(double d, double d2, double d3, double d4, int n2) {
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

    private static void Method2164657() {
        GL11.glDisable((int) 2929);
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDepthMask((boolean) true);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glHint((int) 3155, (int) 4354);
    }

    private static void Method2164658() {
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
        GL11.glHint((int) 3154, (int) 4352);
        GL11.glHint((int) 3155, (int) 4352);
    }

    public static void Method2164659(int n2, AxisAlignedBB axisAlignedBB, Color color, Color color2) {
        GL11.glShadeModel((int) 7425);
        axisAlignedBB = RenderUtil2.Method2164662(axisAlignedBB);
        RenderUtil2.Method2164664();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        Field1076 = Field1075.getBuffer();
        Field1076.begin(n2, DefaultVertexFormats.POSITION_COLOR);
        RenderUtil2.Method2164666(Field1076, axisAlignedBB, color, color2);
        Field1075.draw();
        RenderUtil2.Method2164665();
        GL11.glShadeModel((int) 7424);
    }

    public static void Method2164650(AxisAlignedBB axisAlignedBB, Color color, Color color2) {
        GL11.glShadeModel((int) 7425);
        axisAlignedBB = RenderUtil2.Method2164662(axisAlignedBB);
        RenderUtil2.Method2164664();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        Field1076 = Field1075.getBuffer();
        Field1076.begin(4, DefaultVertexFormats.POSITION_COLOR);
        RenderUtil2.Method2164661(Field1076, axisAlignedBB, color, color2);
        Field1075.draw();
        RenderUtil2.Method2164665();
        GL11.glShadeModel((int) 7424);
    }

    public static void Method2164661(BufferBuilder bufferBuilder, AxisAlignedBB axisAlignedBB, Color color, Color color2) {
        double d = (axisAlignedBB.maxX - axisAlignedBB.minX) / 2.0;
        double d2 = (axisAlignedBB.maxY - axisAlignedBB.minY) / 2.0;
        double d3 = (axisAlignedBB.maxZ - axisAlignedBB.minZ) / 2.0;
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX + d, axisAlignedBB.maxY, axisAlignedBB.minZ + d3, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX + d, axisAlignedBB.maxY, axisAlignedBB.minZ + d3, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX + d, axisAlignedBB.maxY, axisAlignedBB.minZ + d3, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX + d, axisAlignedBB.maxY, axisAlignedBB.minZ + d3, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
    }

    public static AxisAlignedBB Method2164662(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(axisAlignedBB.minX - RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY - RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ - RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX - RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY - RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2164663(BufferBuilder bufferBuilder, double d, double d2, double d3, Color color) {
        bufferBuilder.pos(d, d2, d3).color((float) color.getRed() / 255.0f, (float) color.getGreen() / 255.0f, (float) color.getBlue() / 255.0f, (float) color.getAlpha() / 255.0f).endVertex();
    }

    public static void Method2164664() {
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.enableBlend();
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GL11.glShadeModel((int) 7425);
    }

    public static void Method2164665() {
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
        GL11.glEnable((int) 3553);
        GL11.glShadeModel((int) 7424);
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static void Method2164666(BufferBuilder bufferBuilder, AxisAlignedBB axisAlignedBB, Color color, Color color2) {
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color2);
        RenderUtil2.Method2164663(bufferBuilder, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color2);
    }

    public static float Method2164667(float f, float f2, float f3) {
        return f2 * f3 / f;
    }

    public static void Method2164668(BlockPos blockPos, String string) {
        GlStateManager.pushMatrix();
        RenderUtil2.Method2164685((float) blockPos.getX() + 0.5f, (float) blockPos.getY() + 0.5f, (float) blockPos.getZ() + 0.5f, (EntityPlayer) RenderUtil2.Field2811.player, 1.0f);
        GlStateManager.disableDepth();
        GlStateManager.translate((double) (-((double) AliceMain.Field766.Method2150310(string) / 2.0)), (double) 0.0, (double) 0.0);
        AliceMain.Field766.Method2150317(string, 0.0f, 0.0f, -5592406);
        GlStateManager.popMatrix();
    }

    public static void Method2164669(AxisAlignedBB axisAlignedBB, Color color, Color color2, float f, boolean bl, boolean bl2, boolean bl3, float f2, float f3, float f4) {
        double d = 0.5 * (double) (1.0f - f3);
        AxisAlignedBB axisAlignedBB2 = RenderUtil2.Method2164568(new AxisAlignedBB(axisAlignedBB.minX + d, axisAlignedBB.minY + d + (double) (1.0f - f4), axisAlignedBB.minZ + d, axisAlignedBB.maxX - d, axisAlignedBB.maxY - d, axisAlignedBB.maxZ - d));
        float f5 = (float) color.getRed() / 255.0f;
        float f6 = (float) color.getGreen() / 255.0f;
        float f7 = (float) color.getBlue() / 255.0f;
        float f8 = (float) color.getAlpha() / 255.0f;
        float f9 = (float) color2.getRed() / 255.0f;
        float f10 = (float) color2.getGreen() / 255.0f;
        float f11 = (float) color2.getBlue() / 255.0f;
        float f12 = (float) color2.getAlpha() / 255.0f;
        if (bl3) {
            // empty if block
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

    public static void Method2164660(AxisAlignedBB axisAlignedBB, String string) {
        if (axisAlignedBB == null || string == null) {
            return;
        }
        GlStateManager.pushMatrix();
        RenderUtil2.Method2164685((float) axisAlignedBB.minX + 0.5f, (float) axisAlignedBB.minY + 0.5f, (float) axisAlignedBB.minZ + 0.5f, (EntityPlayer) RenderUtil2.Field2811.player, 1.0f);
        GlStateManager.disableDepth();
        GlStateManager.translate((double) (-((double) AliceMain.Field766.Method2150310(string) / 2.0)), (double) 0.0, (double) 0.0);
        AliceMain.Field766.Method2150317(string, 0.0f, 0.0f, -5592406);
        GlStateManager.popMatrix();
    }

    public static void Method2164671(BlockPos blockPos, Color color, float f) {
        IBlockState iBlockState = RenderUtil2.Field2811.world.getBlockState(blockPos);
        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil2.Field2811.player, Field2811.getRenderPartialTicks());
        RenderUtil2.Method2164683(iBlockState.getSelectedBoundingBox((World) RenderUtil2.Field2811.world, blockPos).grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), f, ColorUtil.Method2163384(color));
    }

    public static void Method2164672(BlockPos blockPos, Color color, double d, double d2) {
        double d3 = (double) blockPos.getX() - RenderUtil2.Field2811.renderManager.renderPosX;
        double d4 = (double) blockPos.getY() - RenderUtil2.Field2811.renderManager.renderPosY;
        double d5 = (double) blockPos.getZ() - RenderUtil2.Field2811.renderManager.renderPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 3042);
        GL11.glLineWidth((float) 2.0f);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glColor4d((double) ((float) color.getRed() / 255.0f), (double) ((float) color.getGreen() / 255.0f), (double) ((float) color.getBlue() / 255.0f), (double) 0.25);
        RenderUtil2.Method2164674(new AxisAlignedBB(d3, d4, d5, d3 + d2, d4 + 1.0, d5 + d), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double) 0.0, (double) 0.0, (double) 0.0, (double) 0.5);
        RenderUtil2.Method2164675(new AxisAlignedBB(d3, d4, d5, d3 + d2, d4 + 1.0, d5 + d));
        GL11.glLineWidth((float) 2.0f);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
    }

    public static void Method2164673(float f, float f2, float f3, float f4, int n2) {
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

    public static void Method2164674(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
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

    public static void Method2164675(AxisAlignedBB axisAlignedBB) {
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

    public static void Method2164676() {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glLineWidth((float) 2.0f);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2884);
        GL11.glDisable((int) 2929);
        double d = RenderUtil2.Field2811.getRenderManager().viewerPosX;
        double d2 = RenderUtil2.Field2811.getRenderManager().viewerPosY;
        double d3 = RenderUtil2.Field2811.getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glTranslated((double) (-d), (double) (-d2), (double) (-d3));
    }

    public static void Method2164677(float f, float f2, float f3, float f4) {
        RenderUtil2.Method2164676();
        GL11.glColor4f((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static void Method2164678() {
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        GL11.glPopMatrix();
        GL11.glEnable((int) 2929);
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
    }

    public static AxisAlignedBB Method2164679(BlockPos blockPos) {
        return RenderUtil2.Field2811.world.getBlockState(blockPos).getBoundingBox((IBlockAccess) RenderUtil2.Field2811.world, blockPos).offset(blockPos);
    }

    public static void Method2164670(AxisAlignedBB axisAlignedBB) {
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

    public static void Method2164681(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
        int n2 = ColorUtil.Method2163384(color);
        RenderUtil2.Method2164682(axisAlignedBB, n2);
    }

    public static void Method2164682(AxisAlignedBB axisAlignedBB, int n2) {
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

    public static void Method2164683(AxisAlignedBB axisAlignedBB, float f, int n2) {
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

    public static void Method2164684(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - RenderUtil2.Field2811.getRenderManager().renderPosX), (double) ((double) f2 - RenderUtil2.Field2811.getRenderManager().renderPosY), (double) ((double) f3 - RenderUtil2.Field2811.getRenderManager().renderPosZ));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-RenderUtil2.Field2811.player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) RenderUtil2.Field2811.player.rotationPitch, (float) (RenderUtil2.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2164685(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        RenderUtil2.Method2164684(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    public static void Method2164686(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4, float f5) {
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

    public static void Method2164687(double d, double d2, double d3, float f, int n2, int n3) {
        Sphere sphere = new Sphere();
        GL11.glPushMatrix();
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 3042);
        GL11.glLineWidth((float) 1.2f);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        sphere.setDrawStyle(100013);
        GL11.glTranslated((double) (d - RenderUtil2.Field2811.renderManager.renderPosX), (double) (d2 - RenderUtil2.Field2811.renderManager.renderPosY), (double) (d3 - RenderUtil2.Field2811.renderManager.renderPosZ));
        sphere.draw(f, n2, n3);
        GL11.glLineWidth((float) 2.0f);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2164688(float f) {
        Field1070 = GL11.glIsEnabled((int) 2896);
        Field1071 = GL11.glIsEnabled((int) 3042);
        Field1072 = GL11.glIsEnabled((int) 3553);
        Field1073 = GL11.glIsEnabled((int) 2929);
        Field1074 = GL11.glIsEnabled((int) 2848);
        RenderUtil2.Method2164680(Field1070, Field1071, Field1072, Field1073, Field1074, f);
    }

    public static void Method2164689() {
        RenderUtil2.Method2164692(Field1070, Field1071, Field1072, Field1073, Field1074);
    }

    private static void Method2164680(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f) {
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

    public static float[][] Method2164691(ModelBiped modelBiped) {
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

    private static void Method2164692(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
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

    public static void Method2164693(float f, float f2, float f3, float f4, float f5, int n2) {
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
        RenderUtil2.Method2164678();
    }

    public static void Method2164694(float f, float f2, float f3, float f4, float f5, int n2) {
        GL11.glBegin((int) 2);
        int n3 = (int) ((float) n2 / (360.0f / f4)) + 1;
        while ((float) n3 <= (float) n2 / (360.0f / f5)) {
            double d = Math.PI * 2 * (double) n3 / (double) n2;
            GL11.glVertex2d((double) ((double) f + Math.cos(d) * (double) f3), (double) ((double) f2 + Math.sin(d) * (double) f3));
            ++n3;
        }
        RenderUtil2.Method2164678();
    }

    public static Vec3d Method2164695(Vec3d vec3d) {
        return new Vec3d(vec3d.x - RenderUtil2.Field2811.getRenderManager().viewerPosX, vec3d.y - RenderUtil2.Field2811.getRenderManager().viewerPosY, vec3d.z - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2164696(float f, float f2, float f3) {
        RenderUtil2.Method2164697(f, f2, f3, 0, 360, 40);
    }

    public static void Method2164697(float f, float f2, float f3, int n2, int n3, int n4) {
        RenderUtil2.Method2164694(f, f2, f3, n2, n3, n4);
    }

    public static void Method2164698(float f, float f2, float f3) {
        RenderUtil2.Method2164699(f, f2, f3, 0, 360, 64);
    }

    public static void Method2164699(float f, float f2, float f3, int n2, int n3, int n4) {
        RenderUtil2.Method2164693(f, f2, f3, n2, n3, n4);
    }

    public static void Method2164690(int n2, int n3, int n4, int n5, float f, float f2, float f3, float f4, float f5, float f6) {
        RenderUtil2.Method2164607(n2, n3, n4, n5, f);
        GL11.glColor4f((float) f2, (float) f3, (float) f4, (float) f5);
        RenderUtil2.Method2164607((float) n2 + f6, (float) n3 + f6, (float) n4 - f6 * 2.0f, (float) n5 - f6 * 2.0f, f);
    }

    public static void Method2164601(float f, float f2, float f3, float f4) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 2);
        GL11.glVertex2d((double) f3, (double) 0.0);
        GL11.glVertex2d((double) 0.0, (double) 0.0);
        GL11.glVertex2d((double) 0.0, (double) f4);
        GL11.glVertex2d((double) f3, (double) f4);
        RenderUtil2.Method2164678();
    }

    public static void Method2164602(float f, float f2, float f3, float f4, Color color) {
        BlockPos blockPos = new BlockPos((double) f, (double) f2, (double) f3);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - RenderUtil2.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosX, (double) (blockPos.getY() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosY, (double) (blockPos.getZ() + 1) - RenderUtil2.Field2811.getRenderManager().viewerPosZ);
        Field1069.setPosition(Objects.requireNonNull(RenderUtil2.Field2811.getRenderViewEntity()).posX, RenderUtil2.Field2811.getRenderViewEntity().posY, RenderUtil2.Field2811.getRenderViewEntity().posZ);
        if (Field1069.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.minY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.minZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ, axisAlignedBB.maxX + RenderUtil2.Field2811.getRenderManager().viewerPosX, axisAlignedBB.maxY + RenderUtil2.Field2811.getRenderManager().viewerPosY, axisAlignedBB.maxZ + RenderUtil2.Field2811.getRenderManager().viewerPosZ))) {
            RenderUtil2.Method2164603(axisAlignedBB, f4, color);
        }
    }

    public static void Method2164603(AxisAlignedBB axisAlignedBB, float f, Color color) {
        float f2 = (float) color.getRed() / 255.0f;
        float f3 = (float) color.getGreen() / 255.0f;
        float f4 = (float) color.getBlue() / 255.0f;
        float f5 = (float) color.getAlpha() / 255.0f;
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

    public static void Method2164604(float f, float f2, float f3, float f4) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 2);
        GL11.glVertex2d((double) (f + f3), (double) f2);
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glVertex2d((double) f, (double) (f2 + f4));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f4));
        RenderUtil2.Method2164678();
    }

    public static void Method2164605(float f, float f2, float f3, float f4) {
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glBegin((int) 7);
        GL11.glVertex2d((double) (f + f3), (double) f2);
        GL11.glVertex2d((double) f, (double) f2);
        GL11.glVertex2d((double) f, (double) (f2 + f4));
        GL11.glVertex2d((double) (f + f3), (double) (f2 + f4));
        RenderUtil2.Method2164678();
    }

    public static void Method2164606(float f, float f2, float f3, int n2) {
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f5 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f7 = (float) (n2 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GL11.glColor4f((float) f5, (float) f6, (float) f7, (float) f4);
        GL11.glBegin((int) 9);
        for (int j = 0; j <= 360; ++j) {
            GL11.glVertex2d((double) ((double) f + Math.sin((double) j * 3.141526 / 180.0) * (double) f3), (double) ((double) f2 + Math.cos((double) j * 3.141526 / 180.0) * (double) f3));
        }
        GL11.glEnd();
        GlStateManager.resetColor();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2164607(float f, float f2, float f3, float f4, float f5) {
        GL11.glEnable((int) 3042);
        RenderUtil2.Method2164693(f + f3 - f5, f2 + f4 - f5, f5, 0.0f, 90.0f, 16);
        RenderUtil2.Method2164693(f + f5, f2 + f4 - f5, f5, 90.0f, 180.0f, 16);
        RenderUtil2.Method2164693(f + f5, f2 + f5, f5, 180.0f, 270.0f, 16);
        RenderUtil2.Method2164693(f + f3 - f5, f2 + f5, f5, 270.0f, 360.0f, 16);
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
        RenderUtil2.Method2164678();
        GL11.glDisable((int) 3042);
    }

    public static void Method2164608(float f) {
        RenderUtil2.Method2164714();
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

    public static void Method2164609() {
        GL11.glStencilFunc((int) 512, (int) 0, (int) 15);
        GL11.glStencilOp((int) 7681, (int) 7681, (int) 7681);
        GL11.glPolygonMode((int) 1032, (int) 6914);
    }

    public static void Method2164600() {
        GL11.glStencilFunc((int) 514, (int) 1, (int) 15);
        GL11.glStencilOp((int) 7680, (int) 7680, (int) 7680);
        GL11.glPolygonMode((int) 1032, (int) 6913);
    }

    public static void Method2164711(Color color) {
        RenderUtil2.Method2164713(color);
        GL11.glDepthMask((boolean) false);
        GL11.glDisable((int) 2929);
        GL11.glEnable((int) 10754);
        GL11.glPolygonOffset((float) 1.0f, (float) -2000000.0f);
        OpenGlHelper.setLightmapTextureCoords((int) OpenGlHelper.lightmapTexUnit, (float) 240.0f, (float) 240.0f);
    }

    public static void Method2164712() {
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

    public static void Method2164713(Color color) {
        GL11.glColor4d((double) ((double) color.getRed() / 255.0), (double) ((double) color.getGreen() / 255.0), (double) ((double) color.getBlue() / 255.0), (double) ((double) color.getAlpha() / 255.0));
    }

    public static void Method2164714() {
        Framebuffer framebuffer = RenderUtil2.Field2811.framebuffer;
        if (framebuffer != null && framebuffer.depthBuffer > -1) {
            RenderUtil2.Method2164715(framebuffer);
            framebuffer.depthBuffer = -1;
        }
    }

    private static void Method2164715(Framebuffer framebuffer) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT((int) framebuffer.depthBuffer);
        int n2 = EXTFramebufferObject.glGenRenderbuffersEXT();
        EXTFramebufferObject.glBindRenderbufferEXT((int) 36161, (int) n2);
        EXTFramebufferObject.glRenderbufferStorageEXT((int) 36161, (int) 34041, (int) RenderUtil2.Field2811.displayWidth, (int) RenderUtil2.Field2811.displayHeight);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int) 36160, (int) 36128, (int) 36161, (int) n2);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int) 36160, (int) 36096, (int) 36161, (int) n2);
    }

    public static void Method2164716(String string, int n2, int n3, int n4, double d) {
        RenderUtil2.Field2811.fontRenderer.drawStringWithShadow(string, (float) n2, (float) n3, n4);
    }

    public static int Method2164717(String string, double d) {
        return (int) ((double) RenderUtil2.Field2811.fontRenderer.getStringWidth(string) * d);
    }

        public static int Method2164718(double d) {
        return (int) ((double) RenderUtil2.Field2811.fontRenderer.FONT_HEIGHT * d);
    }.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil2$IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll

public static final class me

    public static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
            extends Tessellator {
        public static IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field902 = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();

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
            Field902.getBuffer().begin(n2, DefaultVertexFormats.POSITION_COLOR);
        }

        public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
        }

        public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
            Field902.draw();
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
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field902.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n5, n6, n7, n4, n3);
        }

        public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field902.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
        }

        public static BufferBuilder IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll() {
            return Field902.getBuffer();
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
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field902.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 0.5f, 1.0f, n2, n3, n4, n5, n6);
        }
    }
}

