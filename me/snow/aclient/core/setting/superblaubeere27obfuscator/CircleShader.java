

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.FramebufferShader;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class CircleShader
        extends FramebufferShader {
    public static final CircleShader Field732 = new CircleShader();
    public float Field733;

    public CircleShader() {
        super("circle.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("colors");
        this.Method2164198("PI");
        this.Method2164198("rad");
    }

    public void Method2164129(float f, Color color, Float f2, Float f3) {
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field733);
        GL20.glUniform1f((int) this.Method2164199("PI"), (float) f2.floatValue());
        GL20.glUniform1f((int) this.Method2164199("rad"), (float) f3.floatValue());
        GL20.glUniform4f((int) this.Method2164199("colors"), (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
    }

    public void Method2164120(float f, Color color, Float f2, Float f3) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164131(f, color, f2, f3);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164131(float f, Color color, Float f2, Float f3) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164129(f, color, f2, f3);
    }

    public void Method2164132(double d) {
        this.Field733 = (float) ((double) this.Field733 + d);
    }
}

