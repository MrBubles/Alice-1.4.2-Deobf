

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.ActiveRenderInfo
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.vector.Matrix4f
 *  org.lwjgl.util.vector.Vector4f
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.nio.FloatBuffer;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

public class VectorUtils {
    Vec3d Field369 = new Vec3d(0.0, 0.0, 0.0);
    private Minecraft Field365 = Minecraft.getMinecraft();
    private Matrix4f Field366 = new Matrix4f();
    private Matrix4f Field367 = new Matrix4f();
    private ScaledResolution Field368 = new ScaledResolution(this.Field365);

    @SubscribeEvent
    public void Method2164785(Render3DEvent render3DEvent) {
        if (this.Field365.getRenderViewEntity() == null) {
            return;
        }
        Vec3d vec3d = ActiveRenderInfo.projectViewFromEntity((Entity) this.Field365.getRenderViewEntity(), (double) this.Field365.getRenderPartialTicks());
        Vec3d vec3d2 = ActiveRenderInfo.getCameraPosition();
        this.Method2164786(this.Field366, 2982);
        this.Method2164786(this.Field367, 2983);
        this.Field369 = vec3d.add(vec3d2);
        this.Field368 = new ScaledResolution(this.Field365);
    }

    public void Method2164786(Matrix4f matrix4f, int n2) {
        FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer((int) 16);
        GL11.glGetFloat((int) n2, (FloatBuffer) floatBuffer);
        matrix4f.load(floatBuffer);
    }

    public Vec3d Method2164787(Vec3d vec3d) {
        Vector4f vector4f = this.Method2164789(vec3d);
        ScaledResolution scaledResolution = new ScaledResolution(this.Field365);
        int n2 = scaledResolution.getScaledWidth();
        int n3 = scaledResolution.getScaledHeight();
        vector4f.x = (float) n2 / 2.0f + (0.5f * vector4f.x * (float) n2 + 0.5f);
        vector4f.y = (float) n3 / 2.0f - (0.5f * vector4f.y * (float) n3 + 0.5f);
        double d = this.Method2164791(vector4f, n2, n3) ? 0.0 : -1.0;
        return new Vec3d((double) vector4f.x, (double) vector4f.y, d);
    }

    public Vec3d Method2164788(Vec3d vec3d) {
        Vector4f vector4f = this.Method2164789(vec3d);
        int n2 = this.Field365.displayWidth;
        int n3 = this.Field365.displayHeight;
        vector4f.x = (float) n2 / 2.0f + (0.5f * vector4f.x * (float) n2 + 0.5f);
        vector4f.y = (float) n3 / 2.0f - (0.5f * vector4f.y * (float) n3 + 0.5f);
        double d = this.Method2164791(vector4f, n2, n3) ? 0.0 : -1.0;
        return new Vec3d((double) vector4f.x, (double) vector4f.y, d);
    }

    public Vector4f Method2164789(Vec3d vec3d) {
        Vec3d vec3d2 = this.Field369.subtract(vec3d);
        Vector4f vector4f = new Vector4f((float) vec3d2.x, (float) vec3d2.y, (float) vec3d2.z, 1.0f);
        this.Method2164780(vector4f, this.Field366);
        this.Method2164780(vector4f, this.Field367);
        if (vector4f.w > 0.0f) {
            vector4f.x *= -100000.0f;
            vector4f.y *= -100000.0f;
        } else {
            float f = 1.0f / vector4f.w;
            vector4f.x *= f;
            vector4f.y *= f;
        }
        return vector4f;
    }

    public void Method2164780(Vector4f vector4f, Matrix4f matrix4f) {
        float f = vector4f.x;
        float f2 = vector4f.y;
        float f3 = vector4f.z;
        vector4f.x = f * matrix4f.m00 + f2 * matrix4f.m10 + f3 * matrix4f.m20 + matrix4f.m30;
        vector4f.y = f * matrix4f.m01 + f2 * matrix4f.m11 + f3 * matrix4f.m21 + matrix4f.m31;
        vector4f.z = f * matrix4f.m02 + f2 * matrix4f.m12 + f3 * matrix4f.m22 + matrix4f.m32;
        vector4f.w = f * matrix4f.m03 + f2 * matrix4f.m13 + f3 * matrix4f.m23 + matrix4f.m33;
    }

    public boolean Method2164791(Vector4f vector4f, int n2, int n3) {
        return 0.0 <= (double) vector4f.x && (double) vector4f.x <= (double) n2 && 0.0 <= (double) vector4f.y && (double) vector4f.y <= (double) n3;
    }
}

