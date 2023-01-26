

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RotationManager
        extends Feature {
    private float Field2068;
    private float Field2069;

    public static float[] Method2150291(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        float f = (float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0));
        float f2 = (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)));
        if (f2 > 90.0f) {
            f2 = 90.0f;
        } else if (f2 < -90.0f) {
            f2 = -90.0f;
        }
        return new float[]{f, f2};
    }

    public void Method2150276() {
        this.Field2068 = RotationManager.Field2811.player.rotationYaw;
        this.Field2069 = RotationManager.Field2811.player.rotationPitch;
    }

    public void Method2150277() {
        RotationManager.Field2811.player.rotationYaw = this.Field2068;
        RotationManager.Field2811.player.rotationYawHead = this.Field2068;
        RotationManager.Field2811.player.rotationPitch = this.Field2069;
    }

    public void Method2150278(float f, float f2) {
        RotationManager.Field2811.player.rotationYaw = f;
        RotationManager.Field2811.player.rotationYawHead = f;
        RotationManager.Field2811.player.rotationPitch = f2;
    }

    public void Method2150279(float f) {
        RotationManager.Field2811.player.rotationYaw = f;
        RotationManager.Field2811.player.rotationYawHead = f;
    }

    public void Method2150270(BlockPos blockPos) {
        float[] arrf = MathUtil.Method2163871(RotationManager.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() + 0.5f), (double) ((float) blockPos.getZ() + 0.5f)));
        this.Method2150278(arrf[0], arrf[1]);
    }

    public void Method2150281(Vec3d vec3d) {
        float[] arrf = MathUtil.Method2163871(RotationManager.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d(vec3d.x, vec3d.y, vec3d.z));
        this.Method2150278(arrf[0], arrf[1]);
    }

    public void Method2150282(double d, double d2, double d3) {
        Vec3d vec3d = new Vec3d(d, d2, d3);
        this.Method2150281(vec3d);
    }

    public void Method2150283(Entity entity) {
        float[] arrf = MathUtil.Method2163871(RotationManager.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionEyes(Field2811.getRenderPartialTicks()));
        this.Method2150278(arrf[0], arrf[1]);
    }

    public void Method2150284(float f) {
        RotationManager.Field2811.player.rotationPitch = f;
    }

    public float Method2150285() {
        return this.Field2068;
    }

    public void Method2150286(float f) {
        this.Field2068 = f;
    }

    public float Method2150287() {
        return this.Field2069;
    }

    public void Method2150288(float f) {
        this.Field2069 = f;
    }

    public int Method2150289() {
        return RotationUtil.Method2164113();
    }

    public String Method2150280(boolean bl) {
        return RotationUtil.Method2164114(bl);
    }

    public void Method2150292(double d, double d2, double d3) {
        Vec3d vec3d = new Vec3d(d, d2, d3);
        this.Method2150281(vec3d);
    }
}

