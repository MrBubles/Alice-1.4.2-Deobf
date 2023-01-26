

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.player.EntityPlayer;

public class RotationTest {
    public float Field632;
    public float Field633;

    public RotationTest(float f, float f2) {
        this.Field632 = f;
        this.Field633 = f2;
    }

    public static RotationTest Method2163715(RotationTest rotationTest, float f, float f2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f = rotationTest.Field632;
        }
        if ((n2 & 2) != 0) {
            f2 = rotationTest.Field633;
        }
        return rotationTest.Method2163713(f, f2);
    }

    public float Method2163711() {
        return this.Field633;
    }

    public void Method2163712(float f) {
        this.Field632 = f;
    }

    public RotationTest Method2163713(float f, float f2) {
        return new RotationTest(f, f2);
    }

    public float Method2163714() {
        return this.Field633;
    }

    public float Method2163716() {
        return this.Field632;
    }

    public void Method2163717(float f) {
        this.Field633 = f;
    }

    public boolean Method2163718(RotationTest rotationTest) {
        return rotationTest.Field632 == this.Field632 && rotationTest.Field633 == this.Field633;
    }

    public void Method2163719(EntityPlayer entityPlayer) {
        float f = this.Field632;
        boolean bl = false;
        if (!Float.isNaN(f)) {
            f = this.Field633;
            bl = false;
            if (!Float.isNaN(f)) {
                this.Method2163721(Util.Field2811.gameSettings.mouseSensitivity);
                entityPlayer.rotationYaw = this.Field632;
                entityPlayer.rotationPitch = this.Field633;
                return;
            }
        }
    }

    public int hashCode() {
        return Float.hashCode(this.Field632) * 31 + Float.hashCode(this.Field633);
    }

    public float Method2163710() {
        return this.Field632;
    }

    public String toString() {
        return "Rotation(yaw=" + this.Field632 + ", pitch=" + this.Field633 + ")";
    }

    public void Method2163721(float f) {
        float f2 = f * 0.6f + 0.2f;
        float f3 = f2 * f2 * f2 * 1.2f;
        this.Field632 -= this.Field632 % f3;
        this.Field633 -= this.Field633 % f3;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof RotationTest) {
                RotationTest rotationTest = (RotationTest) object;
                if (Float.compare(this.Field632, rotationTest.Field632) == 0 && Float.compare(this.Field633, rotationTest.Field633) == 0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

