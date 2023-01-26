

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class LuigiTessellator
        extends Tessellator {
    public static LuigiTessellator Field3657 = new LuigiTessellator();

    public LuigiTessellator() {
        super(0x200000);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(int n2) {
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(n2);
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
        Field3657.getBuffer().begin(n2, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
        LuigiTessellator.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
        LuigiTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
    }

    public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        Field3657.draw();
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
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(blockPos, n5, n6, n7, n4, n3);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(float f, float f2, float f3, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field3657.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n5, n6, n7, n4, n3);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Field3657.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
    }

    public static BufferBuilder IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll() {
        return Field3657.getBuffer();
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
        BufferBuilder bufferBuilder2 = Field3657.getBuffer();
        if ((n6 & 1) != 0) {
            bufferBuilder2.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 2) != 0) {
            bufferBuilder2.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 4) != 0) {
            bufferBuilder2.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 8) != 0) {
            bufferBuilder2.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 0x10) != 0) {
            bufferBuilder2.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) f, (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 0x20) != 0) {
            bufferBuilder2.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) (f2 + f5), (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder2.pos((double) (f + f4), (double) (f2 + f5), (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(BlockPos blockPos, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(blockPos, n5, n6, n7, n4, n3);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(Field3657.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
        if ((n6 & 1) != 0) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
        LuigiTessellator.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(Field3657.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
    }

    public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
        if ((n6 & 1) != 0) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3 + 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3 + 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f + 0.02, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f + 0.02, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6) - 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6) - 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4) - 0.02, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4) - 0.02, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(BlockPos blockPos, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        LuigiTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(blockPos, n5, n6, n7, n4, n3);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(float f, float f2, float f3, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        LuigiTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(Field3657.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n5, n6, n7, n4, n3);
    }

    public static void IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
        LuigiTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(Field3657.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
    }

    public static void IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
        if ((n6 & 1) != 0) {
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3 + 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3 + 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f + 0.02, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f + 0.02, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6) - 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) f, (double) f2, (double) (f3 + f6) - 0.02).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4), (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4) - 0.02, (double) f2, (double) (f3 + f6)).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos((double) (f + f4) - 0.02, (double) f2, (double) f3).color(n2, n3, n4, n5).endVertex();
        }
    }

    public static void IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(BlockPos blockPos, int n2, int n3) {
        int n4 = n2 >>> 24 & 0xFF;
        int n5 = n2 >>> 16 & 0xFF;
        int n6 = n2 >>> 8 & 0xFF;
        int n7 = n2 & 0xFF;
        LuigiTessellator.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(blockPos, n5, n6, n7, n4, n3);
    }

    public static void IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(BlockPos blockPos, int n2, int n3, int n4, int n5, int n6) {
        LuigiTessellator.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(Field3657.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n2, n3, n4, n5, n6);
    }

    public static void IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n2, int n3, int n4, int n5, int n6) {
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
        Tessellator.getInstance().draw();
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - Minecraft.getMinecraft().getRenderManager().renderPosX), (double) ((double) f2 - Minecraft.getMinecraft().getRenderManager().renderPosY), (double) ((double) f3 - Minecraft.getMinecraft().getRenderManager().renderPosZ));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-Minecraft.getMinecraft().player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) Minecraft.getMinecraft().player.rotationPitch, (float) (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, int n2, int n3, int n4, int n5, int n6) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        if ((n6 & 1) != 0) {
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 2) != 0) {
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 4) != 0) {
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 8) != 0) {
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 0x10) != 0) {
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        }
        if ((n6 & 0x20) != 0) {
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
            bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        }
        tessellator.draw();
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n2) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(axisAlignedBB, blockPos, f, n4, n5, n6, n3);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(7);
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(axisAlignedBB, n2, n3, n4, n5, 63);
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(axisAlignedBB, f, n2, n3, n4, 255);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n2) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(axisAlignedBB, blockPos, f, n4, n5, n6, n3);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(7);
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(blockPos, n2, n3, n4, n5, 63);
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(axisAlignedBB, f, n2, n3, n4, 255);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, float f, int n2) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        LuigiTessellator.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(axisAlignedBB, f, n4, n5, n6, n3);
    }

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(AxisAlignedBB axisAlignedBB, float f, int n2) {
        int n3 = n2 >>> 24 & 0xFF;
        int n4 = n2 >>> 16 & 0xFF;
        int n5 = n2 >>> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(axisAlignedBB, f, n4, n5, n6, n3);
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AxisAlignedBB axisAlignedBB, float f, int n2, int n3, int n4, int n5) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.glLineWidth((float) f);
        BufferBuilder bufferBuilder = Field3657.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        LuigiTessellator.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(BlockPos blockPos, float f, int n2, int n3, int n4, int n5) {
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

    public static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(AxisAlignedBB axisAlignedBB, float f, int n2, int n3, int n4, int n5) {
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(n2, n3, n4, n5).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(AxisAlignedBB axisAlignedBB, float f, int n2, int n3, int n4, int n5) {
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
}

