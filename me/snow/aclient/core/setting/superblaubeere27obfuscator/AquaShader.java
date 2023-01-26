

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

public class AquaShader
        extends FramebufferShader {
    public static final AquaShader Field1798 = new AquaShader();
    public float Field1799;

    public AquaShader() {
        super("aqua.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("rgba");
        this.Method2164198("lines");
        this.Method2164198("tau");
    }

    public void Method2164125(float f, Color color, int n2, double d) {
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field1799);
        GL20.glUniform4f((int) this.Method2164199("rgba"), (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL20.glUniform1i((int) this.Method2164199("lines"), (int) n2);
        GL20.glUniform1f((int) this.Method2164199("tau"), (float) ((float) d));
    }

    public void Method2164126(Color color, float f, float f2, float f3, int n2, double d) {
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
        this.Method2164127(f3, color, n2, d);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164127(float f, Color color, int n2, double d) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164125(f, color, n2, d);
    }

    public void Method2164128(double d) {
        this.Field1799 = (float) ((double) this.Field1799 + d);
    }
}

