

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.model.ModelPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class Skeleton
        extends Module {
    private static final HashMap<EntityPlayer, float[][]> Field1143 = new HashMap();
    private final Setting<Float> Field1144 = this.Method2150366(new Setting<Float>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    private final Setting<Boolean> Field1145 = this.Method2150366(new Setting<Boolean>("Invisibles", false));
    private final Setting<Integer> Field1146 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));

    public Skeleton() {
        super("Skeleton", "Draws a skeleton inside the player.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
    }

    public static void Method2162713(EntityPlayer entityPlayer, ModelPlayer modelPlayer) {
        Field1143.put(entityPlayer, new float[][]{{modelPlayer.bipedHead.rotateAngleX, modelPlayer.bipedHead.rotateAngleY, modelPlayer.bipedHead.rotateAngleZ}, {modelPlayer.bipedRightArm.rotateAngleX, modelPlayer.bipedRightArm.rotateAngleY, modelPlayer.bipedRightArm.rotateAngleZ}, {modelPlayer.bipedLeftArm.rotateAngleX, modelPlayer.bipedLeftArm.rotateAngleY, modelPlayer.bipedLeftArm.rotateAngleZ}, {modelPlayer.bipedRightLeg.rotateAngleX, modelPlayer.bipedRightLeg.rotateAngleY, modelPlayer.bipedRightLeg.rotateAngleZ}, {modelPlayer.bipedLeftLeg.rotateAngleX, modelPlayer.bipedLeftLeg.rotateAngleY, modelPlayer.bipedLeftLeg.rotateAngleZ}});
    }

    private Vec3d Method2162714(Render3DEvent render3DEvent, EntityPlayer entityPlayer) {
        float f = render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        double d = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double) f;
        double d2 = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double) f;
        double d3 = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double) f;
        return new Vec3d(d, d2, d3);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (Skeleton.Method2150359()) {
            return;
        }
        this.Method2162716(true);
        GL11.glEnable((int) 2903);
        GL11.glDisable((int) 2848);
        Field1143.keySet().removeIf(this::Method2162717);
        Skeleton.Field2811.world.playerEntities.forEach(arg_0 -> this.Method2162718(render3DEvent, arg_0));
        Gui.drawRect((int) 0, (int) 0, (int) 0, (int) 0, (int) 0);
        this.Method2162716(false);
    }

    private void Method2162715(Render3DEvent render3DEvent, EntityPlayer entityPlayer) {
        if (!BlockUtil.Method2162843(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ)).booleanValue()) {
            return;
        }
        if (entityPlayer.isInvisible() && !this.Field1145.getValue().booleanValue()) {
            return;
        }
        float[][] arrf = Field1143.get((Object) entityPlayer);
        if (arrf != null && entityPlayer.isEntityAlive() && !entityPlayer.isDead && entityPlayer != Skeleton.Field2811.player && !entityPlayer.isPlayerSleeping()) {
            Color color;
            GL11.glPushMatrix();
            GL11.glEnable((int) 2848);
            GL11.glLineWidth((float) this.Field1144.getValue().floatValue());
            if (AliceMain.Field765.Method2150168(entityPlayer.getName())) {
                GlStateManager.color((float) 0.0f, (float) 191.0f, (float) 230.0f, (float) this.Field1146.getValue().intValue());
            } else {
                color = Colors.Field1782.Method2150586();
                GlStateManager.color((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) this.Field1146.getValue().intValue());
            }
            color = this.Method2162714(render3DEvent, entityPlayer);
            double d = ((Vec3d) color).x - Skeleton.Field2811.getRenderManager().renderPosX;
            double d2 = ((Vec3d) color).y - Skeleton.Field2811.getRenderManager().renderPosY;
            double d3 = ((Vec3d) color).z - Skeleton.Field2811.getRenderManager().renderPosZ;
            GL11.glTranslated((double) d, (double) d2, (double) d3);
            float f = entityPlayer.prevRenderYawOffset + (entityPlayer.renderYawOffset - entityPlayer.prevRenderYawOffset) * render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            GL11.glRotatef((float) (-f), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            GL11.glTranslated((double) 0.0, (double) 0.0, (double) (entityPlayer.isSneaking() ? -0.235 : 0.0));
            float f2 = entityPlayer.isSneaking() ? 0.6f : 0.75f;
            GL11.glPushMatrix();
            GL11.glTranslated((double) -0.125, (double) f2, (double) 0.0);
            if (arrf[3][0] != 0.0f) {
                GL11.glRotatef((float) (arrf[3][0] * 57.295776f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            }
            if (arrf[3][1] != 0.0f) {
                GL11.glRotatef((float) (arrf[3][1] * 57.295776f), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            }
            if (arrf[3][2] != 0.0f) {
                GL11.glRotatef((float) (arrf[3][2] * 57.295776f), (float) 0.0f, (float) 0.0f, (float) 1.0f);
            }
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) 0.0, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.0, (double) (-f2), (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.125, (double) f2, (double) 0.0);
            if (arrf[4][0] != 0.0f) {
                GL11.glRotatef((float) (arrf[4][0] * 57.295776f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            }
            if (arrf[4][1] != 0.0f) {
                GL11.glRotatef((float) (arrf[4][1] * 57.295776f), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            }
            if (arrf[4][2] != 0.0f) {
                GL11.glRotatef((float) (arrf[4][2] * 57.295776f), (float) 0.0f, (float) 0.0f, (float) 1.0f);
            }
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) 0.0, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.0, (double) (-f2), (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glTranslated((double) 0.0, (double) 0.0, (double) (entityPlayer.isSneaking() ? 0.25 : 0.0));
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.0, (double) (entityPlayer.isSneaking() ? -0.05 : 0.0), (double) (entityPlayer.isSneaking() ? -0.01725 : 0.0));
            GL11.glPushMatrix();
            GL11.glTranslated((double) -0.375, (double) ((double) f2 + 0.55), (double) 0.0);
            if (arrf[1][0] != 0.0f) {
                GL11.glRotatef((float) (arrf[1][0] * 57.295776f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            }
            if (arrf[1][1] != 0.0f) {
                GL11.glRotatef((float) (arrf[1][1] * 57.295776f), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            }
            if (arrf[1][2] != 0.0f) {
                GL11.glRotatef((float) (-arrf[1][2] * 57.295776f), (float) 0.0f, (float) 0.0f, (float) 1.0f);
            }
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) 0.0, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.0, (double) -0.5, (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.375, (double) ((double) f2 + 0.55), (double) 0.0);
            if (arrf[2][0] != 0.0f) {
                GL11.glRotatef((float) (arrf[2][0] * 57.295776f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            }
            if (arrf[2][1] != 0.0f) {
                GL11.glRotatef((float) (arrf[2][1] * 57.295776f), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            }
            if (arrf[2][2] != 0.0f) {
                GL11.glRotatef((float) (-arrf[2][2] * 57.295776f), (float) 0.0f, (float) 0.0f, (float) 1.0f);
            }
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) 0.0, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.0, (double) -0.5, (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glRotatef((float) (f - entityPlayer.rotationYawHead), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.0, (double) ((double) f2 + 0.55), (double) 0.0);
            if (arrf[0][0] != 0.0f) {
                GL11.glRotatef((float) (arrf[0][0] * 57.295776f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            }
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) 0.0, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.0, (double) 0.3, (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glRotatef((float) (entityPlayer.isSneaking() ? 25.0f : 0.0f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            GL11.glTranslated((double) 0.0, (double) (entityPlayer.isSneaking() ? -0.16175 : 0.0), (double) (entityPlayer.isSneaking() ? -0.48025 : 0.0));
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.0, (double) f2, (double) 0.0);
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) -0.125, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.125, (double) 0.0, (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.0, (double) f2, (double) 0.0);
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) 0.0, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.0, (double) 0.55, (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated((double) 0.0, (double) ((double) f2 + 0.55), (double) 0.0);
            GL11.glBegin((int) 3);
            GL11.glVertex3d((double) -0.375, (double) 0.0, (double) 0.0);
            GL11.glVertex3d((double) 0.375, (double) 0.0, (double) 0.0);
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
    }

    private void Method2162716(boolean bl) {
        if (bl) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GL11.glEnable((int) 2848);
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            GL11.glHint((int) 3154, (int) 4354);
        } else {
            GlStateManager.disableBlend();
            GlStateManager.enableTexture2D();
            GL11.glDisable((int) 2848);
            GlStateManager.enableDepth();
            GlStateManager.popMatrix();
        }
        GlStateManager.depthMask((!bl ? 1 : 0) != 0);
    }

    private boolean Method2162717(EntityPlayer entityPlayer) {
        return !Skeleton.Field2811.world.playerEntities.contains((Object) entityPlayer);
    }

    private void Method2162718(Render3DEvent render3DEvent, EntityPlayer entityPlayer) {
        this.Method2162715(render3DEvent, entityPlayer);
    }
}

