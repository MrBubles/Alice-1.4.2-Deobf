

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.shader.Framebuffer
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Shader;
import me.snow.aclient.mixin.mixins.accessors.IEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class FramebufferShader
        extends Shader {
    protected Framebuffer Field3335;
    protected float Field3336;
    protected float Field3337;
    protected float Field3338;
    protected float Field3339 = 1.0f;
    protected float Field3340 = 2.0f;
    protected float Field3341 = 1.0f;
    protected boolean Field3342;
    protected Minecraft Field3343 = Minecraft.getMinecraft();

    public FramebufferShader(String string) {
        super(string);
    }

    public void Method2164121(float f) {
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        this.Field3335 = this.Method2164123(this.Field3335);
        this.Field3335.framebufferClear();
        this.Field3335.bindFramebuffer(true);
        this.Field3342 = this.Field3343.gameSettings.entityShadows;
        this.Field3343.gameSettings.entityShadows = false;
        ((IEntityRenderer) this.Field3343.entityRenderer).invokeSetupCameraTransform(f, 0);
    }

    public void Method2164122(Color color, float f, float f2, float f3) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3336 = (float) color.getRed() / 255.0f;
        this.Field3337 = (float) color.getGreen() / 255.0f;
        this.Field3338 = (float) color.getBlue() / 255.0f;
        this.Field3339 = (float) color.getAlpha() / 255.0f;
        this.Field3340 = f;
        this.Field3341 = f2;
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164191(f3);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public Framebuffer Method2164123(Framebuffer framebuffer) {
        if (framebuffer == null) {
            return new Framebuffer(this.Field3343.displayWidth, this.Field3343.displayHeight, true);
        }
        if (framebuffer.framebufferWidth != this.Field3343.displayWidth || framebuffer.framebufferHeight != this.Field3343.displayHeight) {
            framebuffer.deleteFramebuffer();
            framebuffer = new Framebuffer(this.Field3343.displayWidth, this.Field3343.displayHeight, true);
        }
        return framebuffer;
    }

    public void Method2164124(Framebuffer framebuffer) {
        ScaledResolution scaledResolution = new ScaledResolution(this.Field3343);
        GL11.glBindTexture((int) 3553, (int) framebuffer.framebufferTexture);
        GL11.glBegin((int) 7);
        GL11.glTexCoord2d((double) 0.0, (double) 1.0);
        GL11.glVertex2d((double) 0.0, (double) 0.0);
        GL11.glTexCoord2d((double) 0.0, (double) 0.0);
        GL11.glVertex2d((double) 0.0, (double) scaledResolution.getScaledHeight());
        GL11.glTexCoord2d((double) 1.0, (double) 0.0);
        GL11.glVertex2d((double) scaledResolution.getScaledWidth(), (double) scaledResolution.getScaledHeight());
        GL11.glTexCoord2d((double) 1.0, (double) 1.0);
        GL11.glVertex2d((double) scaledResolution.getScaledWidth(), (double) 0.0);
        GL11.glEnd();
        GL20.glUseProgram((int) 0);
    }
}

