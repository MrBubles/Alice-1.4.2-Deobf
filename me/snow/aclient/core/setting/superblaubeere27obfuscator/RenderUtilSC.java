

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.EXTFramebufferObject
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Sphere
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Collection;
import java.util.Collections;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

public class RenderUtilSC {
    private static final Minecraft Field3646 = Minecraft.getMinecraft();
    private static final Frustum Field3647 = new Frustum();

    public static void Method2162969(Vec3d vec3d, Vec3d vec3d2, Color color) {
        double d = ((IRenderManager) Field3646.getRenderManager()).getRenderPosX();
        double d2 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosY();
        double d3 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosZ();
        Vec3d vec3d3 = vec3d.add(-d, -d2, -d3);
        Vec3d vec3d4 = vec3d2.add(-d, -d2, -d3);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(vec3d3.x, vec3d3.y, vec3d3.z).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        bufferBuilder.pos(vec3d4.x, vec3d4.y, vec3d4.z).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        tessellator.draw();
    }

    public static void Method2162960(double d, double d2, double d3, double d4, Color color) {
        double d5 = d - ((IRenderManager) Field3646.getRenderManager()).getRenderPosX();
        double d6 = d2 - ((IRenderManager) Field3646.getRenderManager()).getRenderPosY();
        double d7 = d3 - ((IRenderManager) Field3646.getRenderManager()).getRenderPosZ();
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL11.glBegin((int) 1);
        for (int j = 0; j <= 360; ++j) {
            GL11.glVertex3d((double) (d5 + Math.sin((double) j * Math.PI / 180.0) * d4), (double) d6, (double) (d7 + Math.cos((double) j * Math.PI / 180.0) * d4));
        }
        GL11.glEnd();
    }

    public static void Method2162971(float f, float f2, float f3, float f4, float f5, boolean bl, float f6, int n2) {
        boolean bl2 = GL11.glIsEnabled((int) 3042);
        float f7 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glPushMatrix();
        RenderUtilSC.Method2162973(n2);
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

    public static void Method2162972(double d, double d2, double d3, float f, int n2, int n3) {
        Sphere sphere = new Sphere();
        GL11.glPushMatrix();
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 3042);
        GL11.glLineWidth((float) 1.2f);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        sphere.setDrawStyle(100013);
        double d4 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosX();
        double d5 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosY();
        double d6 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosZ();
        GL11.glTranslated((double) (d - d4), (double) (d2 - d5), (double) (d3 - d6));
        sphere.draw(f, n2, n3);
        GL11.glLineWidth((float) 2.0f);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2162973(int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GL11.glColor4f((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static void Method2162974(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
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

    public static boolean Method2162975(Entity entity) {
        return RenderUtilSC.Method2162976(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
    }

    public static boolean Method2162976(AxisAlignedBB axisAlignedBB) {
        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
        Field3647.setPosition(entity.posX, entity.posY, entity.posZ);
        return Field3647.isBoundingBoxInFrustum(axisAlignedBB);
    }

    public static void Method2162977(Collection<BlockPos> collection, float f, float f2, float f3, float f4, double d, double d2) {
        RenderUtilSC.Method2162996();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean) false);
        double d3 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosX();
        double d4 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosY();
        double d5 = ((IRenderManager) Field3646.getRenderManager()).getRenderPosZ();
        GL11.glColor4d((double) f, (double) f2, (double) f3, (double) f4);
        for (BlockPos blockPos : collection) {
            GlStateManager.pushMatrix();
            double d6 = (double) blockPos.getX() - d3;
            double d7 = (double) blockPos.getY() - d4;
            double d8 = (double) blockPos.getZ() - d5;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d6, d7, d8, d6 + d2, d7 + 1.0, d8 + d);
            RenderUtilSC.Method2162974(axisAlignedBB, f, f2, f3, f4);
            GlStateManager.popMatrix();
        }
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableAlpha();
        RenderUtilSC.Method2162997();
    }

    public static void Method2162978(BlockPos blockPos, int n2, double d, double d2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        RenderUtilSC.Method2162977(Collections.singleton(blockPos), f, f2, f3, f4, d, d2);
    }

    public static void Method2162979(RayTraceResult rayTraceResult, int n2, float f) {
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
            float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
            float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
            float f4 = (float) (n2 & 0xFF) / 255.0f;
            float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
            RenderUtilSC.Method2162996();
            GlStateManager.glLineWidth((float) 2.0f);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            BlockPos blockPos = rayTraceResult.getBlockPos();
            IBlockState iBlockState = RenderUtilSC.Field3646.world.getBlockState(blockPos);
            if (iBlockState.getMaterial() != Material.AIR && RenderUtilSC.Field3646.world.getWorldBorder().contains(blockPos)) {
                double d = RenderUtilSC.Field3646.player.lastTickPosX + (RenderUtilSC.Field3646.player.posX - RenderUtilSC.Field3646.player.lastTickPosX) * (double) f;
                double d2 = RenderUtilSC.Field3646.player.lastTickPosY + (RenderUtilSC.Field3646.player.posY - RenderUtilSC.Field3646.player.lastTickPosY) * (double) f;
                double d3 = RenderUtilSC.Field3646.player.lastTickPosZ + (RenderUtilSC.Field3646.player.posZ - RenderUtilSC.Field3646.player.lastTickPosZ) * (double) f;
                RenderUtilSC.Method2162983(iBlockState.getSelectedBoundingBox((World) RenderUtilSC.Field3646.world, blockPos).grow((double) 0.002f).offset(-d, -d2, -d3), f2, f3, f4, f5);
            }
            RenderUtilSC.Method2162997();
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableTexture2D();
        }
    }

    public static void Method2162970(Entity entity, int n2, float f) {
        IRenderManager iRenderManager = (IRenderManager) Field3646.getRenderManager();
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f - iRenderManager.getRenderPosX();
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f - iRenderManager.getRenderPosY();
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f - iRenderManager.getRenderPosZ();
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d, axisAlignedBB.minY - entity.posY + d2, axisAlignedBB.minZ - entity.posZ + d3, axisAlignedBB.maxX - entity.posX + d, axisAlignedBB.maxY - entity.posY + d2, axisAlignedBB.maxZ - entity.posZ + d3);
        if (entity != RenderUtilSC.Field3646.player) {
            float[] arrf = ColorUtil.Method2163393(n2);
            RenderUtilSC.Method2162983(axisAlignedBB2.grow((double) 0.002f), arrf[0], arrf[1], arrf[2], arrf[3]);
        }
    }

    public static void Method2162981(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
    }

    public static void Method2162982(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ - 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ + 0.8 * (axisAlignedBB.maxZ - axisAlignedBB.minZ)).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX - 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX + 0.8 * (axisAlignedBB.maxX - axisAlignedBB.minX), axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 0.2 * (axisAlignedBB.maxY - axisAlignedBB.minY), axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
    }

    public static void Method2162983(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, 0.0f).endVertex();
        tessellator.draw();
    }

    public static void Method2162984(AxisAlignedBB axisAlignedBB, Color color) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-RenderUtilSC.Field3646.getRenderManager().viewerPosX, -RenderUtilSC.Field3646.getRenderManager().viewerPosY, -RenderUtilSC.Field3646.getRenderManager().viewerPosZ);
        RenderUtilSC.Method2162983(axisAlignedBB2.grow((double) 0.002f), color.getRed() * 255, color.getGreen() * 255, color.getBlue() * 255, color.getAlpha() * 255);
    }

    public static void Method2162985(AxisAlignedBB axisAlignedBB, int n2) {
        RenderUtilSC.Method2162984(axisAlignedBB, new Color(n2));
    }

    public static void Method2162986(AxisAlignedBB axisAlignedBB, Color color) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-RenderUtilSC.Field3646.getRenderManager().viewerPosX, -RenderUtilSC.Field3646.getRenderManager().viewerPosY, -RenderUtilSC.Field3646.getRenderManager().viewerPosZ);
        RenderUtilSC.Method2162982(axisAlignedBB2.grow((double) 0.002f), color.getRed() * 255, color.getGreen() * 255, color.getBlue() * 255, color.getAlpha() * 255);
    }

    public static void Method2162987(AxisAlignedBB axisAlignedBB, int n2) {
        RenderUtilSC.Method2162986(axisAlignedBB, new Color(n2));
    }

    public static void Method2162988(AxisAlignedBB axisAlignedBB, Color color) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-RenderUtilSC.Field3646.getRenderManager().viewerPosX, -RenderUtilSC.Field3646.getRenderManager().viewerPosY, -RenderUtilSC.Field3646.getRenderManager().viewerPosZ);
        RenderUtilSC.Method2162991(color);
        RenderUtilSC.Method2162993(axisAlignedBB2);
    }

    public static void Method2162989(AxisAlignedBB axisAlignedBB, int n2) {
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(-RenderUtilSC.Field3646.getRenderManager().viewerPosX, -RenderUtilSC.Field3646.getRenderManager().viewerPosY, -RenderUtilSC.Field3646.getRenderManager().viewerPosZ);
        RenderUtilSC.Method2162992(n2);
        RenderUtilSC.Method2162993(axisAlignedBB2);
    }

    public static void Method2162980(Entity entity, int n2, double d) {
        IRenderManager iRenderManager = (IRenderManager) Field3646.getRenderManager();
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * d - iRenderManager.getRenderPosX();
        double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * d - iRenderManager.getRenderPosY();
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * d - iRenderManager.getRenderPosZ();
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d2, axisAlignedBB.minY - entity.posY + d3, axisAlignedBB.minZ - entity.posZ + d4, axisAlignedBB.maxX - entity.posX + d2, axisAlignedBB.maxY - entity.posY + d3, axisAlignedBB.maxZ - entity.posZ + d4);
        GL11.glBlendFunc((int) 770, (int) 771);
        float[] arrf = ColorUtil.Method2163393(n2);
        GL11.glColor4f((float) arrf[0], (float) arrf[1], (float) arrf[2], (float) arrf[3]);
        RenderUtilSC.Method2162993(axisAlignedBB2);
    }

    public static void Method2162991(Color color) {
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        GlStateManager.color((float) f, (float) f2, (float) f3, (float) f4);
    }

    private static void Method2162992(int n2) {
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        GlStateManager.color((float) f2, (float) f3, (float) f4, (float) f);
    }

    public static void Method2162993(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
    }

    public static float Method2162994(EntityLivingBase entityLivingBase) {
        return RenderUtilSC.Method2162995(entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
    }

    public static float Method2162995(double d, double d2, double d3) {
        ScaledResolution scaledResolution = new ScaledResolution(Field3646);
        double d4 = (double) scaledResolution.getScaleFactor() / Math.pow(scaledResolution.getScaleFactor(), 2.0);
        return (float) d4 + (float) RenderUtilSC.Field3646.player.getDistance(d, d2, d3) / 7.0f;
    }

    public static void Method2162996() {
        GL11.glBlendFunc((int) 770, (int) 771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
    }

    public static void Method2162997() {
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
    }

    public static void Method2162998(float f, float f2, float f3, float f4, int n2, int n3) {
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
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f10, f11, f12, f9).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f10, f11, f12, f9).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void Method2162999(float f, float f2, float f3, float f4, int n2, int n3, int n4, int n5) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        float f9 = (float) (n4 >> 24 & 0xFF) / 255.0f;
        float f10 = (float) (n4 >> 16 & 0xFF) / 255.0f;
        float f11 = (float) (n4 >> 8 & 0xFF) / 255.0f;
        float f12 = (float) (n4 & 0xFF) / 255.0f;
        float f13 = (float) (n3 >> 24 & 0xFF) / 255.0f;
        float f14 = (float) (n3 >> 16 & 0xFF) / 255.0f;
        float f15 = (float) (n3 >> 8 & 0xFF) / 255.0f;
        float f16 = (float) (n3 & 0xFF) / 255.0f;
        float f17 = (float) (n5 >> 24 & 0xFF) / 255.0f;
        float f18 = (float) (n5 >> 16 & 0xFF) / 255.0f;
        float f19 = (float) (n5 >> 8 & 0xFF) / 255.0f;
        float f20 = (float) (n5 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int) 7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f18, f19, f20, f17).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f14, f15, f16, f13).endVertex();
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f10, f11, f12, f9).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void Method2162990(int n2, int n3, int n4, int n5, float f, int n6) {
        int n7;
        if (n2 < n4) {
            n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        if (n3 < n5) {
            n7 = n3;
            n3 = n5;
            n5 = n7;
        }
        float f2 = (float) (n6 >> 24 & 0xFF) / 255.0f;
        float f3 = (float) (n6 >> 16 & 0xFF) / 255.0f;
        float f4 = (float) (n6 >> 8 & 0xFF) / 255.0f;
        float f5 = (float) (n6 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f3, (float) f4, (float) f5, (float) f2);
        GL11.glEnable((int) 2848);
        GlStateManager.glLineWidth((float) f);
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double) n2, (double) n3, 0.0).endVertex();
        bufferBuilder.pos((double) n4, (double) n3, 0.0).endVertex();
        bufferBuilder.pos((double) n4, (double) n3, 0.0).endVertex();
        bufferBuilder.pos((double) n4, (double) n5, 0.0).endVertex();
        bufferBuilder.pos((double) n4, (double) n5, 0.0).endVertex();
        bufferBuilder.pos((double) n2, (double) n5, 0.0).endVertex();
        bufferBuilder.pos((double) n2, (double) n5, 0.0).endVertex();
        bufferBuilder.pos((double) n2, (double) n3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glDisable((int) 2848);
    }

    static Minecraft Method2162901() {
        return Field3646;
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public static void Method2162961(int n2) {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162967();
            GL11.glPushAttrib((int) 1048575);
            GL11.glDisable((int) 3008);
            GL11.glDisable((int) 3553);
            GL11.glDisable((int) 2896);
            GL11.glEnable((int) 3042);
            GL11.glBlendFunc((int) 770, (int) 771);
            GL11.glLineWidth((float) n2);
            GL11.glEnable((int) 2848);
            GL11.glEnable((int) 2960);
            GL11.glClear((int) 1024);
            GL11.glClearStencil((int) 15);
            GL11.glStencilFunc((int) 512, (int) 1, (int) 15);
            GL11.glStencilOp((int) 7681, (int) 7681, (int) 7681);
            GL11.glPolygonMode((int) 1032, (int) 6913);
        }

        public static void Method2162962() {
            GL11.glStencilFunc((int) 512, (int) 0, (int) 15);
            GL11.glStencilOp((int) 7681, (int) 7681, (int) 7681);
            GL11.glPolygonMode((int) 1032, (int) 6914);
        }

        public static void Method2162963() {
            GL11.glStencilFunc((int) 514, (int) 1, (int) 15);
            GL11.glStencilOp((int) 7680, (int) 7680, (int) 7680);
            GL11.glPolygonMode((int) 1032, (int) 6913);
        }

        public static void Method2162964(int n2, float f) {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162966(new Color(n2));
            GL11.glDepthMask((boolean) false);
            GL11.glDisable((int) 2929);
            GL11.glEnable((int) 10754);
            GL11.glPolygonOffset((float) f, (float) -2000000.0f);
            OpenGlHelper.setLightmapTextureCoords((int) OpenGlHelper.lightmapTexUnit, (float) 240.0f, (float) 240.0f);
        }

        public static void Method2162965(float f) {
            GL11.glPolygonOffset((float) (-f), (float) 2000000.0f);
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

        public static void Method2162966(Color color) {
            GL11.glColor4d((double) ((float) color.getRed() / 255.0f), (double) ((float) color.getGreen() / 255.0f), (double) ((float) color.getBlue() / 255.0f), (double) ((float) color.getAlpha() / 255.0f));
        }

        public static void Method2162967() {
            Framebuffer framebuffer = RenderUtilSC.Method2162901().getFramebuffer();
            if (framebuffer.depthBuffer > -1) {
                IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162968(framebuffer);
                framebuffer.depthBuffer = -1;
            }
        }

        public static void Method2162968(Framebuffer framebuffer) {
            EXTFramebufferObject.glDeleteRenderbuffersEXT((int) framebuffer.depthBuffer);
            int n2 = EXTFramebufferObject.glGenRenderbuffersEXT();
            EXTFramebufferObject.glBindRenderbufferEXT((int) 36161, (int) n2);
            EXTFramebufferObject.glRenderbufferStorageEXT((int) 36161, (int) 34041, (int) RenderUtilSC.Method2162901().displayWidth, (int) RenderUtilSC.Method2162901().displayHeight);
            EXTFramebufferObject.glFramebufferRenderbufferEXT((int) 36160, (int) 36128, (int) 36161, (int) n2);
            EXTFramebufferObject.glFramebufferRenderbufferEXT((int) 36160, (int) 36096, (int) 36161, (int) n2);
        }
    }
}

