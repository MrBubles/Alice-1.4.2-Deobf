

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

public final class AstralOutlineShader
        extends FramebufferShader {
    public static final AstralOutlineShader Field634 = new AstralOutlineShader();
    public float Field635 = 0.0f;

    public AstralOutlineShader() {
        super("astralOutline.frag");
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
        this.Method2164198("time");
        this.Method2164198("iterations");
        this.Method2164198("formuparam2");
        this.Method2164198("stepsize");
        this.Method2164198("volsteps");
        this.Method2164198("zoom");
        this.Method2164198("tile");
        this.Method2164198("distfading");
        this.Method2164198("saturation");
        this.Method2164198("fadeBol");
        this.Method2164198("resolution");
    }

    public void Method2164161(Color color, float f, float f2, boolean bl, int n2, float f3, float f4, float f5, float f6, float f7, int n3, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, int n4) {
        GL20.glUniform1i((int) this.Method2164199("texture"), (int) 0);
        GL20.glUniform2f((int) this.Method2164199("texelSize"), (float) (1.0f / (float) this.Field3343.displayWidth * (f * f2)), (float) (1.0f / (float) this.Field3343.displayHeight * (f * f2)));
        GL20.glUniform1f((int) this.Method2164199("divider"), (float) 140.0f);
        GL20.glUniform1f((int) this.Method2164199("radius"), (float) f);
        GL20.glUniform1f((int) this.Method2164199("maxSample"), (float) 10.0f);
        GL20.glUniform1f((int) this.Method2164199("alpha0"), (float) (bl ? -1.0f : (float) n2 / 255.0f));
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f3), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f3));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field635);
        GL20.glUniform4f((int) this.Method2164199("color"), (float) f4, (float) f5, (float) f6, (float) f7);
        GL20.glUniform1i((int) this.Method2164199("iterations"), (int) n3);
        GL20.glUniform1f((int) this.Method2164199("formuparam2"), (float) f8);
        GL20.glUniform1i((int) this.Method2164199("volsteps"), (int) ((int) f10));
        GL20.glUniform1f((int) this.Method2164199("stepsize"), (float) f11);
        GL20.glUniform1f((int) this.Method2164199("zoom"), (float) f9);
        GL20.glUniform1f((int) this.Method2164199("tile"), (float) f12);
        GL20.glUniform1f((int) this.Method2164199("distfading"), (float) f13);
        GL20.glUniform1f((int) this.Method2164199("saturation"), (float) f14);
        GL20.glUniform1i((int) this.Method2164199("fadeBol"), (int) n4);
    }

    public void Method2164162(Color color, float f, float f2, boolean bl, int n2, float f3, float f4, float f5, float f6, float f7, int n3, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, int n4) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164163(color, f, f2, bl, n2, f3, f4, f5, f6, f7, n3, f8, f9, f10, f11, f12, f13, f14, f15, n4);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164163(Color color, float f, float f2, boolean bl, int n2, float f3, float f4, float f5, float f6, float f7, int n3, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, int n4) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164161(color, f, f2, bl, n2, f3, f4, f5, f6, f7, n3, f8, f9, f10, f11, f12, f13, f14, f15, n4);
    }

    public void Method2164164(double d) {
        this.Field635 = (float) ((double) this.Field635 + d);
    }
}

