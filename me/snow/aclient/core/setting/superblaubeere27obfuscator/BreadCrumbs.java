

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class BreadCrumbs
        extends Module {
    public static Setting<Integer> Field231;
    public static Setting<Float> Field232;
    public static Setting<Boolean> Field233;
    public static Setting<Integer> Field234;
    public static Setting<Integer> Field235;
    public static Setting<Integer> Field236;
    public static Setting<Integer> Field237;
    public static ArrayList<double[]> Field238;
    public Color Field239;

    public BreadCrumbs() {
        super("BreadCrumbs", "Draws a small line behind you", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
        Field231 = this.Method2150366(new Setting<Integer>("Length", 4, 1, 40));
        Field232 = this.Method2150366(new Setting<Float>("Width", Float.valueOf(Float.intBitsToFloat(Float.floatToIntBits(15.599429f) ^ 0x7EB99743)), Float.valueOf(Float.intBitsToFloat(Float.floatToIntBits(2.076195f) ^ 0x7F04E061)), Float.valueOf(Float.intBitsToFloat(Float.floatToIntBits(1.3190416f) ^ 0x7F08D65B))));
        Field233 = this.Method2150366(new Setting<Boolean>("Sync", false));
        Field234 = this.Method2150366(new Setting<Integer>("Red", 30, 0, 255));
        Field235 = this.Method2150366(new Setting<Integer>("Green", 167, 0, 255));
        Field236 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
        Field237 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));
        Field238 = new ArrayList();
    }

    public static double Method2162337(double d) {
        if (d == Double.longBitsToDouble(Double.doubleToLongBits(1.7931000183463725E308) ^ 0x7FEFEB11C3AAD037L)) {
            return d;
        }
        if (d < Double.longBitsToDouble(Double.doubleToLongBits(1.1859585260803721E308) ^ 0x7FE51C5AEE8AD07FL)) {
            return d * Double.longBitsToDouble(Double.doubleToLongBits(-12.527781766526259) ^ 0x7FD90E3969654F8FL);
        }
        return d;
    }

    public Color Method2162336() {
        return new Color(Field234.getValue(), Field235.getValue(), Field236.getValue(), Field237.getValue());
    }

    @Override
    public void Method2150379() {
        this.Field239 = Field233.getValue() != false ? Colors.Field1782.Method2150586() : this.Method2162336();
        try {
            double d = BreadCrumbs.Field2811.getRenderManager().renderPosX;
            double d2 = BreadCrumbs.Field2811.getRenderManager().renderPosY;
            double d3 = BreadCrumbs.Field2811.getRenderManager().renderPosZ;
            if (this.Method2150364()) {
                for (EntityPlayer entityPlayer : BreadCrumbs.Field2811.world.playerEntities) {
                    if (!(entityPlayer instanceof EntityPlayer)) continue;
                    EntityPlayer entityPlayer2 = entityPlayer;
                    boolean bl = entityPlayer2 == BreadCrumbs.Field2811.player;
                    double d4 = d2 + Double.longBitsToDouble(Double.doubleToLongBits(0.48965838138858014) ^ 0x7FDF56901B91AE07L);
                    if (BreadCrumbs.Field2811.player.isElytraFlying()) {
                        d4 -= Double.longBitsToDouble(Double.doubleToLongBits(29.56900080933637) ^ 0x7FC591AA097B7F4BL);
                    }
                    if (!bl) continue;
                    Field238.add(new double[]{d, d4 - (double) entityPlayer2.height, d3});
                }
            }
        } catch (Exception exception) {
            // empty catch block
        }
        if (Field238.size() > Field231.getValue()) {
            Field238.remove(0);
        }
    }

    @Override
    public void Method2150373() {
        Field238.removeAll(Field238);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        try {
            double d = BreadCrumbs.Field2811.getRenderManager().renderPosX;
            double d2 = BreadCrumbs.Field2811.getRenderManager().renderPosY;
            double d3 = BreadCrumbs.Field2811.getRenderManager().renderPosZ;
            float f = (float) this.Field239.getRed() / Float.intBitsToFloat(Float.floatToIntBits(0.49987957f) ^ 0x7D80F037);
            float f2 = (float) this.Field239.getGreen() / Float.intBitsToFloat(Float.floatToIntBits(0.4340212f) ^ 0x7DA13807);
            float f3 = (float) this.Field239.getBlue() / Float.intBitsToFloat(Float.floatToIntBits(0.0131841665f) ^ 0x7F270267);
            if (this.Method2150364()) {
                Iterator<double[]> iterator;
                RenderUtil.Method2163983();
                GL11.glPushMatrix();
                GL11.glEnable((int) 2848);
                GL11.glLineWidth((float) Field232.getValue().floatValue());
                GL11.glBlendFunc((int) 770, (int) 771);
                GL11.glLineWidth((float) Field232.getValue().floatValue());
                GL11.glDepthMask((boolean) false);
                GL11.glBegin((int) 3);
                Iterator<double[]> iterator2 = iterator = Field238.iterator();
                while (iterator.hasNext()) {
                    double d4 = 0.0;
                    double[] arrd = iterator2.next();
                    double d5 = BreadCrumbs.Method2162337(Math.hypot(arrd[0] - BreadCrumbs.Field2811.player.posX, arrd[1] - BreadCrumbs.Field2811.player.posY));
                    if (d4 > (double) Field231.getValue().intValue()) {
                        iterator = iterator2;
                        continue;
                    }
                    GL11.glColor4f((float) f, (float) f2, (float) f3, (float) (Float.intBitsToFloat(Float.floatToIntBits(14.099797f) ^ 0x7EE198C5) - (float) (d5 / (double) Field231.getValue().intValue())));
                    iterator = iterator2;
                    GL11.glVertex3d((double) (arrd[0] - d), (double) (arrd[1] - d2), (double) (arrd[2] - d3));
                }
                GL11.glEnd();
                GL11.glDepthMask((boolean) true);
                GL11.glPopMatrix();
                RenderUtil.Method2163984();
            }
        } catch (Exception exception) {
            // empty catch block
        }
    }
}

