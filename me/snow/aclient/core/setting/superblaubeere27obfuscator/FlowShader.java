

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

public class FlowShader
        extends FramebufferShader {
    public static final FlowShader Field3091 = new FlowShader();
    public float Field3092;

    public FlowShader() {
        super("flow.frag");
    }

    @Override
    public void Method2164193() {
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("color");
        this.Method2164198("iterations");
        this.Method2164198("formuparam2");
        this.Method2164198("stepsize");
        this.Method2164198("volsteps");
        this.Method2164198("zoom");
        this.Method2164198("tile");
        this.Method2164198("distfading");
        this.Method2164198("saturation");
        this.Method2164198("fadeBol");
    }

    public void Method2164137(float f, float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int n3) {
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field3092);
        GL20.glUniform4f((int) this.Method2164199("color"), (float) f2, (float) f3, (float) f4, (float) f5);
        GL20.glUniform1i((int) this.Method2164199("iterations"), (int) n2);
        GL20.glUniform1f((int) this.Method2164199("formuparam2"), (float) f6);
        GL20.glUniform1i((int) this.Method2164199("volsteps"), (int) ((int) f8));
        GL20.glUniform1f((int) this.Method2164199("stepsize"), (float) f9);
        GL20.glUniform1f((int) this.Method2164199("zoom"), (float) f7);
        GL20.glUniform1f((int) this.Method2164199("tile"), (float) f10);
        GL20.glUniform1f((int) this.Method2164199("distfading"), (float) f11);
        GL20.glUniform1f((int) this.Method2164199("saturation"), (float) f12);
        GL20.glUniform1i((int) this.Method2164199("fadeBol"), (int) n3);
    }

    public void Method2164138(Color color, float f, float f2, float f3, float f4, float f5, float f6, float f7, int n2, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, int n3) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3340 = f;
        this.Field3341 = f2;
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164139(f3, f4, f5, f6, f7, n2, f8, f9, f10, f11, f12, f13, f14, f15, n3);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164139(float f, float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int n3) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164137(f, f2, f3, f4, f5, n2, f6, f7, f8, f9, f10, f11, f12, f13, n3);
    }

    public void Method2164130(double d) {
        this.Field3092 = (float) ((double) this.Field3092 + d);
    }
}

