

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class WaypointManager
        extends Feature {
    public static final ResourceLocation Field3746 = new ResourceLocation("textures/waypoint.png");
    public Map<String, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3747 = new HashMap<String, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>();

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public String Field1176;
        public String Field1177;
        public int Field1178;
        public int Field1179;
        public int Field1180;
        public int Field1181;
        public int Field1182;
        public int Field1183;
        public int Field1184;
        public int Field1185;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string, String string2, int n2, int n3, int n4, int n5, Color color) {
            this.Field1176 = string;
            this.Field1177 = string2;
            this.Field1178 = n2;
            this.Field1179 = n3;
            this.Field1180 = n4;
            this.Field1181 = n5;
            this.Field1182 = color.getRed();
            this.Field1183 = color.getGreen();
            this.Field1184 = color.getBlue();
            this.Field1185 = color.getAlpha();
        }

        public void Method2150356() {
            GL11.glPushMatrix();
            GL11.glDisable((int) 2896);
            GL11.glDisable((int) 2929);
            GL11.glEnable((int) 3042);
            GL11.glBlendFunc((int) 770, (int) 771);
            GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
            RenderUtil.Method2163018(new BlockPos(this.Field1179, this.Field1180, this.Field1181), new Color(this.Field1182, this.Field1183, this.Field1184, this.Field1185), 1.0f, true);
            GlStateManager.enableTexture2D();
            GL11.glDisable((int) 3042);
            GL11.glEnable((int) 2896);
            GL11.glEnable((int) 2929);
            GL11.glPopMatrix();
        }

        public void Method2150357() {
            double d = (double) this.Field1179 - Util.Field2811.getRenderManager().renderPosX + 0.5;
            double d2 = (double) this.Field1180 - Util.Field2811.getRenderManager().renderPosY - 0.5;
            double d3 = (double) this.Field1181 - Util.Field2811.getRenderManager().renderPosZ + 0.5;
            float f = (float) (Util.Field2811.player.getDistance(d + Util.Field2811.getRenderManager().renderPosX, d2 + Util.Field2811.getRenderManager().renderPosY, d3 + Util.Field2811.getRenderManager().renderPosZ) / 4.0);
            if (f < 1.6f) {
                f = 1.6f;
            }
            GL11.glPushMatrix();
            GL11.glTranslatef((float) ((float) d), (float) ((float) d2 + 1.4f), (float) ((float) d3));
            GL11.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
            GL11.glRotatef((float) (-Util.Field2811.getRenderManager().playerViewY), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            GL11.glRotatef((float) Util.Field2811.getRenderManager().playerViewX, (float) 1.0f, (float) 0.0f, (float) 0.0f);
            GL11.glScalef((float) (-(f /= 25.0f)), (float) (-f), (float) f);
            GL11.glDisable((int) 2896);
            GL11.glDisable((int) 2929);
            GL11.glEnable((int) 3042);
            GL11.glBlendFunc((int) 770, (int) 771);
            int n2 = Util.Field2811.fontRenderer.getStringWidth(this.Field1176) / 2;
            GL11.glPushMatrix();
            GL11.glPopMatrix();
            GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
            GL11.glScalef((float) 0.5f, (float) 0.5f, (float) 0.5f);
            Util.Field2811.fontRenderer.drawStringWithShadow(this.Field1176, (float) (-n2), (float) (-(Util.Field2811.fontRenderer.FONT_HEIGHT + 7)), new Color(this.Field1182, this.Field1183, this.Field1184, this.Field1185).getRGB());
            GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 1.0f);
            GlStateManager.enableTexture2D();
            GL11.glDisable((int) 3042);
            GL11.glEnable((int) 2896);
            GL11.glEnable((int) 2929);
            GL11.glPopMatrix();
            GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        }
    }
}

