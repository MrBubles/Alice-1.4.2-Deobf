

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    private static final Minecraft Field1118 = Minecraft.getMinecraft();

    public static void Method2162935(AxisAlignedBB axisAlignedBB, Float f, Float f2, Float f3, Float f4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        tessellator.draw();
    }

    public static void Method2162936(AxisAlignedBB axisAlignedBB, int n2, int n3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(n2, DefaultVertexFormats.POSITION_COLOR);
        float f = (float) (n3 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n3 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n3 & 0xFF) / 255.0f;
        float f4 = (float) (n3 >> 24 & 0xFF) / 255.0f;
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

    public static void Method2162937(Entity entity, int n2, Float f) {
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float) 1.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean) false);
        if (entity != RenderUtils.Field1118.player) {
            double d = RenderUtils.Field1118.player.lastTickPosX + (RenderUtils.Field1118.player.posX - RenderUtils.Field1118.player.lastTickPosX) * (double) f.floatValue();
            double d2 = RenderUtils.Field1118.player.lastTickPosY + (RenderUtils.Field1118.player.posY - RenderUtils.Field1118.player.lastTickPosY) * (double) f.floatValue();
            double d3 = RenderUtils.Field1118.player.lastTickPosZ + (RenderUtils.Field1118.player.posZ - RenderUtils.Field1118.player.lastTickPosZ) * (double) f.floatValue();
            RenderUtils.Method2162935(entity.getEntityBoundingBox().offset(-d, -d2, -d3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
        }
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method2162938(TileEntity tileEntity, int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        RenderUtils.Method2162949();
        GlStateManager.enableBlend();
        GlStateManager.glLineWidth((float) 3.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        BlockPos blockPos = tileEntity.getPos();
        IBlockState iBlockState = RenderUtils.Field1118.world.getBlockState(blockPos);
        AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World) RenderUtils.Field1118.world, blockPos).offset(-RenderUtils.Field1118.getRenderManager().viewerPosX, -RenderUtils.Field1118.getRenderManager().viewerPosY, -RenderUtils.Field1118.getRenderManager().viewerPosZ);
        RenderUtils.Method2162935(axisAlignedBB.grow((double) 0.002f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
        GlStateManager.resetColor();
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        RenderUtils.Method2162940();
        GlStateManager.popMatrix();
    }

    public static void Method2162939(float f, float f2, float f3, float f4, int n2) {
        RenderUtils.Method2162930(f, f2, f3, f4, n2, 7);
    }

    public static void Method2162930(float f, float f2, float f3, float f4, int n2, int n3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        RenderUtils.Method2162941(n2);
        bufferBuilder.begin(n3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double) f, (double) f4, 0.0).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2162941(int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float) f, (float) f2, (float) f3, (float) f4);
    }

    public static void Method2162942(float f, float f2, float f3, float f4, int n2) {
        RenderUtils.Method2162930(f, f2, f3, f4, n2, 2);
    }

    public static void Method2162943(BlockPos blockPos, Float f, Float f2, Float f3, Float f4, Float f5) {
        RenderUtils.Method2162944(new Vec3d((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()), f, f2, f3, f4, 1.0, 1.0, 1.0, f5);
    }

    public static void Method2162944(Vec3d vec3d, Float f, Float f2, Float f3, Float f4, double d, double d2, double d3, Float f5) {
        double d4 = RenderUtils.Field1118.player.lastTickPosX + (RenderUtils.Field1118.player.posX - RenderUtils.Field1118.player.lastTickPosX) * (double) f5.floatValue();
        double d5 = RenderUtils.Field1118.player.lastTickPosY + (RenderUtils.Field1118.player.posY - RenderUtils.Field1118.player.lastTickPosY) * (double) f5.floatValue();
        double d6 = RenderUtils.Field1118.player.lastTickPosZ + (RenderUtils.Field1118.player.posZ - RenderUtils.Field1118.player.lastTickPosZ) * (double) f5.floatValue();
        Vec3d vec3d2 = vec3d.add(-d4, -d5, -d6);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d2, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y + d2, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y + d2, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d2, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d2, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y + d2, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y + d2, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y, vec3d2.z + d3).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y + d2, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), f4.floatValue()).endVertex();
        bufferBuilder.pos(vec3d2.x + d, vec3d2.y, vec3d2.z).color(f.floatValue(), f2.floatValue(), f3.floatValue(), 0.0f).endVertex();
        tessellator.draw();
    }

    public static void Method2162945(BlockPos blockPos, int n2, int n3, int n4, int n5, double d, double d2, double d3, float f) {
        double d4 = (double) blockPos.getX() - (RenderUtils.Field1118.player.lastTickPosX + (RenderUtils.Field1118.player.posX - RenderUtils.Field1118.player.lastTickPosX) * (double) f);
        double d5 = (double) blockPos.getY() - (RenderUtils.Field1118.player.lastTickPosY + (RenderUtils.Field1118.player.posY - RenderUtils.Field1118.player.lastTickPosY) * (double) f);
        double d6 = (double) blockPos.getZ() - (RenderUtils.Field1118.player.lastTickPosZ + (RenderUtils.Field1118.player.posZ - RenderUtils.Field1118.player.lastTickPosZ) * (double) f);
        GlStateManager.color((float) ((float) n2 / 255.0f), (float) ((float) n3 / 255.0f), (float) ((float) n4 / 255.0f), (float) ((float) n5 / 255.0f));
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d4, d5, d6, d4 + d, d5 + d2, d6 + d3);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
    }

    public static void Method2162946(Vec3d vec3d, int n2, int n3, int n4, int n5, double d, double d2, double d3, float f) {
        double d4 = vec3d.x - (RenderUtils.Field1118.player.lastTickPosX + (RenderUtils.Field1118.player.posX - RenderUtils.Field1118.player.lastTickPosX) * (double) f);
        double d5 = vec3d.y - (RenderUtils.Field1118.player.lastTickPosY + (RenderUtils.Field1118.player.posY - RenderUtils.Field1118.player.lastTickPosY) * (double) f);
        double d6 = vec3d.z - (RenderUtils.Field1118.player.lastTickPosZ + (RenderUtils.Field1118.player.posZ - RenderUtils.Field1118.player.lastTickPosZ) * (double) f);
        GlStateManager.color((float) ((float) n2 / 255.0f), (float) ((float) n3 / 255.0f), (float) ((float) n4 / 255.0f), (float) ((float) n5 / 255.0f));
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d4, d5, d6, d4 + d, d5 + d2, d6 + d3);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
    }

    public static void Method2162947(float f, float f2, float f3, float f4, float f5, float f6, float f7, int n2) {
        Float[] arrfloat = RenderUtils.Method2162953(n2);
        GL11.glLineWidth((float) f7);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f2, (double) f3).color(arrfloat[0].floatValue(), arrfloat[1].floatValue(), arrfloat[2].floatValue(), arrfloat[3].floatValue()).endVertex();
        bufferBuilder.pos((double) f4, (double) f5, (double) f6).color(arrfloat[0].floatValue(), arrfloat[1].floatValue(), arrfloat[2].floatValue(), arrfloat[3].floatValue()).endVertex();
        bufferBuilder.pos((double) f4, (double) f5, (double) f6).color(arrfloat[0].floatValue(), arrfloat[1].floatValue(), arrfloat[2].floatValue(), arrfloat[3].floatValue()).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
    }

    public static Vec3d Method2162948(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f);
    }

    public static void Method2162949() {
        GL11.glBlendFunc((int) 770, (int) 771);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float) 10.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.resetColor();
    }

    public static void Method2162940() {
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.resetColor();
    }

    public static void Method2162951() {
        GlStateManager.blendFunc((int) 770, (int) 771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.resetColor();
    }

    public static void Method2162952() {
        GlStateManager.resetColor();
        GlStateManager.enableCull();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
    }

    public static Float[] Method2162953(int n2) {
        float f = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float) (n2 & 0xFF) / 255.0f;
        float f4 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        return new Float[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
    }

    public static Vec3d Method2162954(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(RenderUtils.Method2162957(entity, f));
    }

    public static Vec3d Method2162955(Entity entity, float f) {
        return RenderUtils.Method2162954(entity, f).subtract(((IRenderManager) Field1118.getRenderManager()).getRenderPosX(), ((IRenderManager) Field1118.getRenderManager()).getRenderPosY(), ((IRenderManager) Field1118.getRenderManager()).getRenderPosZ());
    }

    public static Vec3d Method2162956(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static Vec3d Method2162957(Entity entity, double d) {
        return RenderUtils.Method2162956(entity, d, d, d);
    }

    public static Vec3d Method2162958(Vec3d vec3d) {
        return new Vec3d(vec3d.x, vec3d.y, vec3d.z).subtract(((IRenderManager) Field1118.getRenderManager()).getRenderPosX(), ((IRenderManager) Field1118.getRenderManager()).getRenderPosY(), ((IRenderManager) Field1118.getRenderManager()).getRenderPosZ());
    }

    public static void Method2162959(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - ((IRenderManager) Field1118.getRenderManager()).getRenderPosX()), (double) ((double) f2 - ((IRenderManager) Field1118.getRenderManager()).getRenderPosY()), (double) ((double) f3 - ((IRenderManager) Field1118.getRenderManager()).getRenderPosZ()));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-Minecraft.getMinecraft().player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) Minecraft.getMinecraft().player.rotationPitch, (float) (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2162950(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        RenderUtils.Method2162959(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }
}

