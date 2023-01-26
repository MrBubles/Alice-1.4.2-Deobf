

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

public final class RainbowCubeOutlineShader
        extends FramebufferShader {
    public static final RainbowCubeOutlineShader Field2995 = new RainbowCubeOutlineShader();
    public float Field2996 = 0.0f;

    public RainbowCubeOutlineShader() {
        super("rainbowCubeOutline.frag");
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
        this.Method2164198("resolution");
        this.Method2164198("time");
        this.Method2164198("WAVELENGTH");
        this.Method2164198("R");
        this.Method2164198("G");
        this.Method2164198("B");
        this.Method2164198("RSTART");
        this.Method2164198("GSTART");
        this.Method2164198("BSTART");
        this.Method2164198("alpha");
    }

    public void Method2164170(Color color, float f, float f2, boolean bl, int n2, float f3, Color color2, int n3, int n4, int n5, int n6) {
        GL20.glUniform1i((int) this.Method2164199("texture"), (int) 0);
        GL20.glUniform2f((int) this.Method2164199("texelSize"), (float) (1.0f / (float) this.Field3343.displayWidth * (f * f2)), (float) (1.0f / (float) this.Field3343.displayHeight * (f * f2)));
        GL20.glUniform1f((int) this.Method2164199("divider"), (float) 140.0f);
        GL20.glUniform1f((int) this.Method2164199("radius"), (float) f);
        GL20.glUniform1f((int) this.Method2164199("maxSample"), (float) 10.0f);
        GL20.glUniform1f((int) this.Method2164199("alpha0"), (float) (bl ? -1.0f : (float) n2 / 255.0f));
        GL20.glUniform2f((int) this.Method2164199("resolution"), (float) ((float) new ScaledResolution(this.Field3343).getScaledWidth() / f3), (float) ((float) new ScaledResolution(this.Field3343).getScaledHeight() / f3));
        GL20.glUniform1f((int) this.Method2164199("time"), (float) this.Field2996);
        GL20.glUniform1f((int) this.Method2164199("alpha"), (float) ((float) color2.getAlpha() / 255.0f));
        GL20.glUniform1f((int) this.Method2164199("WAVELENGTH"), (float) n3);
        GL20.glUniform1i((int) this.Method2164199("R"), (int) color2.getRed());
        GL20.glUniform1i((int) this.Method2164199("G"), (int) color2.getGreen());
        GL20.glUniform1i((int) this.Method2164199("B"), (int) color2.getBlue());
        GL20.glUniform1i((int) this.Method2164199("RSTART"), (int) n4);
        GL20.glUniform1i((int) this.Method2164199("GSTART"), (int) n5);
        GL20.glUniform1i((int) this.Method2164199("BSTART"), (int) n6);
    }

    public void Method2164181(Color color, float f, float f2, boolean bl, int n2, float f3, Color color2, int n3, int n4, int n5, int n6) {
        this.Field3343.gameSettings.entityShadows = this.Field3342;
        this.Field3335.unbindFramebuffer();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        this.Field3343.getFramebuffer().bindFramebuffer(true);
        this.Field3343.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        this.Method2164182(color, f, f2, bl, n2, f3, color2, n3, n4, n5, n6);
        this.Field3343.entityRenderer.setupOverlayRendering();
        this.Method2164124(this.Field3335);
        this.Method2164192();
        this.Field3343.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void Method2164182(Color color, float f, float f2, boolean bl, int n2, float f3, Color color2, int n3, int n4, int n5, int n6) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap();
            this.Method2164193();
        }
        this.Method2164170(color, f, f2, bl, n2, f3, color2, n3, n4, n5, n6);
    }

    public void Method2164183(double d) {
        this.Field2996 = (float) ((double) this.Field2996 + d);
    }
}

