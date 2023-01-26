

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NordTessellator;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PopChams;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class TotemPopCham {
    private static final Minecraft Field3750 = Minecraft.getMinecraft();
    EntityOtherPlayerMP Field3751;
    ModelPlayer Field3752;
    Long Field3753;
    double Field3754;
    double Field3755;

    public TotemPopCham(EntityOtherPlayerMP entityOtherPlayerMP, ModelPlayer modelPlayer, Long l2, double d, double d2) {
        MinecraftForge.EVENT_BUS.register((Object) this);
        this.Field3751 = entityOtherPlayerMP;
        this.Field3752 = modelPlayer;
        this.Field3753 = l2;
        this.Field3754 = d;
        this.Field3755 = d;
    }

    public static void Method2164776(EntityLivingBase entityLivingBase, ModelBase modelBase, float f, float f2, float f3, float f4, float f5, float f6) {
        if (Field3750.getRenderManager() == null) {
            return;
        }
        float f7 = Field3750.getRenderPartialTicks();
        double d = entityLivingBase.posX - TotemPopCham.Field3750.getRenderManager().viewerPosX;
        double d2 = entityLivingBase.posY - TotemPopCham.Field3750.getRenderManager().viewerPosY;
        double d3 = entityLivingBase.posZ - TotemPopCham.Field3750.getRenderManager().viewerPosZ;
        GlStateManager.pushMatrix();
        if (entityLivingBase.isSneaking()) {
            d2 -= 0.125;
        }
        float f8 = TotemPopCham.Method2164781(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f7);
        float f9 = TotemPopCham.Method2164781(entityLivingBase.prevRotationYawHead, entityLivingBase.rotationYawHead, f7);
        float f10 = f9 - f8;
        float f11 = entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f7;
        TotemPopCham.Method2164778(d, d2, d3);
        float f12 = TotemPopCham.Method2164784(entityLivingBase, f7);
        TotemPopCham.Method2164770(entityLivingBase);
        float f13 = TotemPopCham.Method2164779(entityLivingBase, f6);
        GlStateManager.enableAlpha();
        modelBase.setLivingAnimations(entityLivingBase, f, f2, f7);
        modelBase.setRotationAngles(f, f2, f12, entityLivingBase.rotationYawHead, entityLivingBase.rotationPitch, f13, (Entity) entityLivingBase);
        modelBase.render((Entity) entityLivingBase, f, f2, f12, entityLivingBase.rotationYawHead, entityLivingBase.rotationPitch, f13);
        GlStateManager.popMatrix();
    }

    public static void Method2164777(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        TotemPopCham.Method2164778(d - TotemPopCham.Field3750.getRenderManager().viewerPosX, d2 - TotemPopCham.Field3750.getRenderManager().viewerPosY, d3 - TotemPopCham.Field3750.getRenderManager().viewerPosZ);
    }

    public static void Method2164778(double d, double d2, double d3) {
        GlStateManager.translate((float) ((float) d), (float) ((float) d2), (float) ((float) d3));
    }

    public static float Method2164779(EntityLivingBase entityLivingBase, float f) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale((float) -1.0f, (float) -1.0f, (float) 1.0f);
        double d = entityLivingBase.getRenderBoundingBox().maxX - entityLivingBase.getRenderBoundingBox().minX;
        double d2 = entityLivingBase.getRenderBoundingBox().maxZ - entityLivingBase.getRenderBoundingBox().minZ;
        GlStateManager.scale((double) ((double) f + d), (double) (f * entityLivingBase.height), (double) ((double) f + d2));
        float f2 = 0.0625f;
        GlStateManager.translate((float) 0.0f, (float) -1.501f, (float) 0.0f);
        return 0.0625f;
    }

    public static void Method2164770(EntityLivingBase entityLivingBase) {
        GlStateManager.rotate((float) (180.0f - entityLivingBase.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
    }

    public static float Method2164781(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public static Color Method2164782(Color color, int n2) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
    }

    public static void Method2164783(Color color) {
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
    }

    public static float Method2164784(EntityLivingBase entityLivingBase, float f) {
        return 0.0f;
    }

    @SubscribeEvent
    public void Method2164774(RenderWorldLastEvent renderWorldLastEvent) {
        if (this.Field3751 == null || TotemPopCham.Field3750.world == null || TotemPopCham.Field3750.player == null) {
            return;
        }
        GL11.glLineWidth((float) 1.0f);
        Color color = PopChams.Field3829.Field3831.getValue() != false ? Colors.Field1782.Method2150586() : new Color(PopChams.Field3829.Field3832.getValue(), PopChams.Field3829.Field3833.getValue(), PopChams.Field3829.Field3834.getValue(), PopChams.Field3829.Field3842.getValue());
        Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), PopChams.Field3829.Field3842.getValue());
        Color color3 = PopChams.Field3829.Field3831.getValue() != false ? Colors.Field1782.Method2150586() : new Color(PopChams.Field3829.Field3835.getValue(), PopChams.Field3829.Field3836.getValue(), PopChams.Field3829.Field3837.getValue(), PopChams.Field3829.Field3841.getValue());
        Color color4 = new Color(color3.getRed(), color3.getGreen(), color3.getBlue(), PopChams.Field3829.Field3841.getValue());
        int n2 = color2.getAlpha();
        int n3 = color4.getAlpha();
        long l2 = System.currentTimeMillis() - this.Field3753 - ((Number) PopChams.Field3829.Field3839.getValue()).longValue();
        if (System.currentTimeMillis() - this.Field3753 > ((Number) PopChams.Field3829.Field3839.getValue()).longValue()) {
            double d = this.Method2164775(l2, 0.0, ((Number) PopChams.Field3829.Field3840.getValue()).doubleValue());
            d = MathHelper.clamp((double) d, (double) 0.0, (double) 1.0);
            d = -d + 1.0;
            n2 *= (int) d;
            n3 *= (int) d;
        }
        Color color5 = TotemPopCham.Method2164782(color2, n2);
        Color color6 = TotemPopCham.Method2164782(color4, n3);
        if (this.Field3751 != null && this.Field3752 != null) {
            NordTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
            GL11.glPushAttrib((int) 1048575);
            GL11.glEnable((int) 2881);
            GL11.glEnable((int) 2848);
            if (this.Field3754 > 1.0) {
                this.Field3754 -= PopChams.Field3829.Field3840.getValue().doubleValue();
            }
            Color color7 = new Color(color6.getRed(), color6.getGreen(), color6.getBlue(), (int) this.Field3754);
            if (this.Field3755 > 1.0) {
                this.Field3755 -= PopChams.Field3829.Field3840.getValue().doubleValue();
            }
            Color color8 = new Color(color5.getRed(), color5.getGreen(), color5.getBlue(), (int) this.Field3755);
            TotemPopCham.Method2164783(color7);
            GL11.glPolygonMode((int) 1032, (int) 6914);
            TotemPopCham.Method2164776((EntityLivingBase) this.Field3751, (ModelBase) this.Field3752, this.Field3751.limbSwing, this.Field3751.limbSwingAmount, this.Field3751.ticksExisted, this.Field3751.rotationYawHead, this.Field3751.rotationPitch, 1.0f);
            TotemPopCham.Method2164783(color8);
            GL11.glPolygonMode((int) 1032, (int) 6913);
            TotemPopCham.Method2164776((EntityLivingBase) this.Field3751, (ModelBase) this.Field3752, this.Field3751.limbSwing, this.Field3751.limbSwingAmount, this.Field3751.ticksExisted, this.Field3751.rotationYawHead, this.Field3751.rotationPitch, 1.0f);
            GL11.glPolygonMode((int) 1032, (int) 6914);
            GL11.glPopAttrib();
            NordTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
        }
    }

    double Method2164775(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }
}

