

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

public class PhobosShader
        extends FramebufferShader {
    public static final PhobosShader Field3396 = new PhobosShader();
    public float Field3397;

    public PhobosShader() {
        super("phobos.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("color");
        this.Method2164198("texelSize");
        this.Method2164198("texture");
    }

    public void Method2164145(float f, Color color, int n2, double d) {
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f));
        GL20.glUniform1i((int) this.Method2164199("texture"), (int) 0);
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field3397);
        GL20.glUniform4f((int) this.Method2164199("color"), (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GL20.glUniform2f((int) this.Method2164199("texelSize"), (float) (1.0f / (float) this.Field3343.displayWidth * (this.Field3340 * this.Field3341)), (float) (1.0f / (float) this.Field3343.displayHeight * (this.Field3340 * this.Field3341)));
    }

    public void Method2164146(Color color, float f, float f2, float f3, int n2, double d) {
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
        this.Method2164147(f3, color, n2, d);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164147(float f, Color color, int n2, double d) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164145(f, color, n2, d);
    }

    public void Method2164148(double d) {
        this.Field3397 = (float) ((double) this.Field3397 + d);
    }
}

