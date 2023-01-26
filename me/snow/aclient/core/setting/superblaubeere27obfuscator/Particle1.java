

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.vecmath.Tuple2f
 *  javax.vecmath.Vector2f
 *  net.minecraft.client.gui.ScaledResolution
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.concurrent.ThreadLocalRandom;
import javax.vecmath.Tuple2f;
import javax.vecmath.Vector2f;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class Particle1 {
    private final int Field899;
    private Vector2f Field895;
    private Vector2f Field896;
    private Vector2f Field897;
    private int Field898;
    private float Field900;

    public Particle1(Vector2f vector2f) {
        this.Field895 = vector2f;
        int n2 = -1;
        int n3 = 1;
        float f = (float) n2 + ThreadLocalRandom.current().nextFloat() * (float) (n3 - n2);
        float f2 = (float) n2 + ThreadLocalRandom.current().nextFloat() * (float) (n3 - n2);
        this.Field896 = new Vector2f(f, f2);
        this.Field897 = new Vector2f(0.0f, 0.35f);
        this.Field898 = 0;
        this.Field899 = ThreadLocalRandom.current().nextInt(32, 192);
        this.Field900 = 0.5f + ThreadLocalRandom.current().nextFloat() * 1.5f;
    }

    public static int Method2159935(int n2, int n3) {
        return n3 << 24 | (n2 &= 0xFFFFFF);
    }

    public void Method2159928(ScaledResolution scaledResolution) {
        this.Field895 = new Vector2f((float) (Math.random() * (double) scaledResolution.getScaledWidth()), (float) (Math.random() * (double) scaledResolution.getScaledHeight()));
    }

    public void Method2159929() {
        if (this.Field898 < this.Field899) {
            this.Field898 += 8;
        }
        if (this.Field897.getX() > 0.35f) {
            this.Field897.setX(this.Field897.getX() * 0.975f);
        } else if (this.Field897.getX() < -0.35f) {
            this.Field897.setX(this.Field897.getX() * 0.975f);
        }
        if (this.Field897.getY() > 0.35f) {
            this.Field897.setY(this.Field897.getY() * 0.975f);
        } else if (this.Field897.getY() < -0.35f) {
            this.Field897.setY(this.Field897.getY() * 0.975f);
        }
        this.Field895.add((Tuple2f) this.Field897);
        this.Field895.add((Tuple2f) this.Field896);
    }

    public void Method2159920(int n2, int n3) {
        if (Mouse.isButtonDown((int) 0)) {
            float f = (float) n2 - this.Field895.getX();
            float f2 = (float) n3 - this.Field895.getY();
            if (Math.abs(f) < 50.0f && Math.abs(f2) < 50.0f) {
                this.Field897.setX(this.Field897.getX() + f * 0.0015f);
                this.Field897.setY(this.Field897.getY() + f2 * 0.0015f);
            }
        }
        RenderUtil.Method2163027(this.Field895.x, this.Field895.y, this.Field895.x + this.Field900, this.Field895.y + this.Field900, Particle1.Method2159935(ColorUtil.Method2163378(ClickGui2.Method2150488().Field1742.getValue(), ClickGui2.Method2150488().Field1743.getValue(), ClickGui2.Method2150488().Field1744.getValue()), this.Field898));
    }

    public Vector2f Method2159931() {
        return this.Field895;
    }

    public void Method2159932(Vector2f vector2f) {
        this.Field895 = vector2f;
    }

    public Vector2f Method2159933() {
        return this.Field896;
    }

    public void Method2159934(Vector2f vector2f) {
        this.Field896 = vector2f;
    }

    public Vector2f Method2159936() {
        return this.Field897;
    }

    public void Method2159937(Vector2f vector2f) {
        this.Field897 = vector2f;
    }

    public int Method2159938() {
        return this.Field898;
    }

    public void Method2159939(int n2) {
        this.Field898 = n2;
    }

    public float Method2159930() {
        return this.Field900;
    }

    public void Method2159941(float f) {
        this.Field900 = f;
    }
}

