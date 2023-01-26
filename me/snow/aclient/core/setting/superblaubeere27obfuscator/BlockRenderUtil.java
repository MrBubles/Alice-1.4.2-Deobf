

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class BlockRenderUtil {
    public static void Method2162875() {
        GL11.glPushMatrix();
    }

    public static void Method2162876() {
        GL11.glPopMatrix();
    }

    public static void Method2162877(AxisAlignedBB axisAlignedBB, int n2, float f) {
        GL11.glPushMatrix();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 2896);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glLineWidth((float) f);
        GL11.glColor4f((float) ((float) (n2 >> 16 & 0xFF) / 255.0f), (float) ((float) (n2 >> 8 & 0xFF) / 255.0f), (float) ((float) (n2 & 0xFF) / 255.0f), (float) ((float) (n2 >> 24 & 0xFF) / 255.0f));
        if (axisAlignedBB == null) {
            return;
        }
        GL11.glBegin((int) 3);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 3);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glLineWidth((float) 1.0f);
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2896);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2162878(AxisAlignedBB axisAlignedBB, int n2, float f) {
        GL11.glPushMatrix();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 2896);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glLineWidth((float) f);
        GL11.glColor4f((float) ((float) (n2 >> 16 & 0xFF) / 255.0f), (float) ((float) (n2 >> 8 & 0xFF) / 255.0f), (float) ((float) (n2 & 0xFF) / 255.0f), (float) ((float) (n2 >> 24 & 0xFF) / 255.0f));
        if (axisAlignedBB == null) {
            return;
        }
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 1);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glLineWidth((float) 1.0f);
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2896);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }

    public static void Method2162879(AxisAlignedBB axisAlignedBB, int n2) {
        GL11.glPushMatrix();
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 2896);
        GL11.glDisable((int) 3553);
        GL11.glEnable((int) 2848);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glColor4f((float) ((float) (n2 >> 16 & 0xFF) / 255.0f), (float) ((float) (n2 >> 8 & 0xFF) / 255.0f), (float) ((float) (n2 & 0xFF) / 255.0f), (float) ((float) (n2 >> 24 & 0xFF) / 255.0f));
        if (axisAlignedBB == null) {
            return;
        }
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.minX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.minZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.maxY, (double) axisAlignedBB.maxZ);
        GL11.glVertex3d((double) axisAlignedBB.maxX, (double) axisAlignedBB.minY, (double) axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glDisable((int) 2848);
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2896);
        GL11.glEnable((int) 2929);
        GL11.glDepthMask((boolean) true);
        GL11.glDisable((int) 3042);
        GL11.glPopMatrix();
    }
}

