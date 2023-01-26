

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class RenderBuilderCC {
    private boolean Field3906;
    private boolean Field3907;
    private boolean Field3908;
    private boolean Field3909;
    private boolean Field3910;
    private boolean Field3911;
    private boolean Field3912;
    private AxisAlignedBB Field3913 = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field3914 = IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FILL;
    private double Field3915;
    private double Field3916;
    private double Field3917;
    private Color Field3918 = Color.WHITE;

    public RenderBuilderCC Method2163297() {
        GlStateManager.pushMatrix();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        this.Field3906 = true;
        return this;
    }

    public RenderBuilderCC Method2163298(boolean bl) {
        if (bl) {
            GlStateManager.disableDepth();
            GlStateManager.depthMask((boolean) false);
        }
        this.Field3907 = bl;
        return this;
    }

    public RenderBuilderCC Method2163299() {
        GlStateManager.enableBlend();
        this.Field3908 = true;
        return this;
    }

    public RenderBuilderCC Method2163290() {
        GlStateManager.disableTexture2D();
        this.Field3909 = true;
        return this;
    }

    public RenderBuilderCC Method2163201(float f) {
        GlStateManager.glLineWidth((float) f);
        return this;
    }

    public RenderBuilderCC Method2163202(boolean bl) {
        if (this.Field3910) {
            GlStateManager.disableCull();
        }
        this.Field3910 = bl;
        return this;
    }

    public RenderBuilderCC Method2163203(boolean bl) {
        if (this.Field3911) {
            GlStateManager.disableAlpha();
        }
        this.Field3911 = bl;
        return this;
    }

    public RenderBuilderCC Method2163204(boolean bl) {
        if (bl) {
            GlStateManager.shadeModel((int) 7425);
        }
        this.Field3912 = bl;
        return this;
    }

    public RenderBuilderCC Method2163205() {
        if (this.Field3907) {
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
        }
        if (this.Field3909) {
            GlStateManager.enableTexture2D();
        }
        if (this.Field3908) {
            GlStateManager.disableBlend();
        }
        if (this.Field3910) {
            GlStateManager.enableCull();
        }
        if (this.Field3911) {
            GlStateManager.enableAlpha();
        }
        if (this.Field3912) {
            GlStateManager.shadeModel((int) 7424);
        }
        if (this.Field3906) {
            GL11.glDisable((int) 2848);
            GlStateManager.popMatrix();
        }
        return this;
    }

    public RenderBuilderCC Method2163206(BlockPos blockPos) {
        this.Method2163208(new AxisAlignedBB((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ(), (double) (blockPos.getX() + 1), (double) (blockPos.getY() + 1), (double) (blockPos.getZ() + 1)));
        return this;
    }

    public RenderBuilderCC Method2163207(Vec3d vec3d) {
        this.Method2163208(new AxisAlignedBB(vec3d.x, vec3d.y, vec3d.z, vec3d.x + 1.0, vec3d.y + 1.0, vec3d.z + 1.0));
        return this;
    }

    public RenderBuilderCC Method2163208(AxisAlignedBB axisAlignedBB) {
        this.Field3913 = axisAlignedBB;
        return this;
    }

    public RenderBuilderCC Method2163209(double d) {
        this.Field3915 = d;
        return this;
    }

    public RenderBuilderCC Method2163200(double d) {
        this.Field3917 = d;
        return this;
    }

    public RenderBuilderCC Method2163311(double d) {
        this.Field3916 = d;
        return this;
    }

    public RenderBuilderCC Method2163312(Color color) {
        this.Field3918 = color;
        return this;
    }

    public RenderBuilderCC Method2163313(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        this.Field3914 = iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
        return this;
    }

    public AxisAlignedBB Method2163314() {
        return this.Field3913;
    }

    public double Method2163315() {
        return this.Field3915;
    }

    public double Method2163316() {
        return this.Field3917;
    }

    public double Method2163317() {
        return this.Field3916;
    }

    public Color Method2163318() {
        return this.Field3918;
    }

    public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163319() {
        return this.Field3914;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        FILL,
        OUTLINE,
        BOTH,
        GLOW,
        REVERSE,
        CLAW,
        NONE;

    }
}

