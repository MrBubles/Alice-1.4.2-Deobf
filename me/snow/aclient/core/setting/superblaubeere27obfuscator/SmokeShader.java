

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

public class SmokeShader
        extends FramebufferShader {
    public static final SmokeShader Field3658 = new SmokeShader();
    public float Field3659;

    public SmokeShader() {
        super("smoke.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("first");
        this.Method2164198("second");
        this.Method2164198("third");
        this.Method2164198("oct");
    }

    public void Method2164153(float f, Color color, Color color2, Color color3, int n2) {
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field3659);
        GL20.glUniform4f((int) this.Method2164199("first"), (float) ((float) color.getRed() / 255.0f * 5.0f), (float) ((float) color.getGreen() / 255.0f * 5.0f), (float) ((float) color.getBlue() / 255.0f * 5.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL20.glUniform3f((int) this.Method2164199("second"), (float) ((float) color2.getRed() / 255.0f * 5.0f), (float) ((float) color2.getGreen() / 255.0f * 5.0f), (float) ((float) color2.getBlue() / 255.0f * 5.0f));
        GL20.glUniform3f((int) this.Method2164199("third"), (float) ((float) color3.getRed() / 255.0f * 5.0f), (float) ((float) color3.getGreen() / 255.0f * 5.0f), (float) ((float) color3.getBlue() / 255.0f * 5.0f));
        GL20.glUniform1i((int) this.Method2164199("oct"), (int) n2);
    }

    public void Method2164154(Color color, float f, float f2, float f3, Color color2, Color color3, Color color4, int n2) {
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
        this.Method2164155(f3, color2, color3, color4, n2);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164155(float f, Color color, Color color2, Color color3, int n2) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164153(f, color, color2, color3, n2);
    }

    public void Method2164156(double d) {
        this.Field3659 = (float) ((double) this.Field3659 + d);
    }
}

