

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.FramebufferShader;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public final class GlowShader
        extends FramebufferShader {
    public static final GlowShader Field305 = new GlowShader();
    public float Field306 = 0.0f;

    public GlowShader() {
        super("glow.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("texture");
        this.Method2164198("texelSize");
        this.Method2164198("color");
        this.Method2164198("divider");
        this.Method2164198("radius");
        this.Method2164198("maxSample");
        this.Method2164198("alpha0");
    }

    public void Method2164173(Color color, float f, float f2, boolean bl, int n2) {
        GL20.glUniform1i((int) this.Method2164199("texture"), (int) 0);
        GL20.glUniform2f((int) this.Method2164199("texelSize"), (float) (1.0f / (float) this.Field3343.displayWidth * (f * f2)), (float) (1.0f / (float) this.Field3343.displayHeight * (f * f2)));
        GL20.glUniform3f((int) this.Method2164199("color"), (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f));
        GL20.glUniform1f((int) this.Method2164199("divider"), (float) 140.0f);
        GL20.glUniform1f((int) this.Method2164199("radius"), (float) f);
        GL20.glUniform1f((int) this.Method2164199("maxSample"), (float) 10.0f);
        GL20.glUniform1f((int) this.Method2164199("alpha0"), (float) (bl ? -1.0f : (float) n2 / 255.0f));
    }

    public void Method2164174(Color color, float f, float f2, boolean bl, int n2) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164175(color, f, f2, bl, n2);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164175(Color color, float f, float f2, boolean bl, int n2) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164173(color, f, f2, bl, n2);
    }
}

