

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

public class GradientShader
        extends FramebufferShader {
    public static final GradientShader Field2332 = new GradientShader();
    public float Field2333;

    public GradientShader() {
        super("gradient.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("moreGradient");
        this.Method2164198("Creepy");
        this.Method2164198("alpha");
        this.Method2164198("NUM_OCTAVES");
    }

    public void Method2164141(float f, float f2, float f3, float f4, int n2) {
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field2333);
        GL20.glUniform1f((int) this.Method2164199("moreGradient"), (float) f2);
        GL20.glUniform1f((int) this.Method2164199("Creepy"), (float) f3);
        GL20.glUniform1f((int) this.Method2164199("alpha"), (float) f4);
        GL20.glUniform1i((int) this.Method2164199("NUM_OCTAVES"), (int) n2);
    }

    public void Method2164142(Color color, float f, float f2, float f3, float f4, float f5, float f6, int n2) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3336 = (float) color.getRed() / 255.0f;
        this.Field3337 = (float) color.getGreen() / 255.0f;
        this.Field3338 = (float) color.getBlue() / 255.0f;
        this.Field3340 = f;
        this.Field3341 = f2;
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164143(f3, f4, f5, f6, n2);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164143(float f, float f2, float f3, float f4, int n2) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164141(f, f2, f3, f4, n2);
    }

    public void Method2164144(double d) {
        this.Field2333 = (float) ((double) this.Field2333 + d);
    }
}

