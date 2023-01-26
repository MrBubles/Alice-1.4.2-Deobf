

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

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import javax.vecmath.Tuple2f;
import javax.vecmath.Vector2f;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class Particle {
    private final int Field1085;
    private Vector2f Field1081;
    private Vector2f Field1082;
    private Vector2f Field1083;
    private int Field1084;
    private float Field1086;

    public Particle(Vector2f vector2f) {
        this.Field1081 = vector2f;
        int n2 = -1;
        int n3 = 1;
        float f = (float) n2 + ThreadLocalRandom.current().nextFloat() * (float) (n3 - n2);
        float f2 = (float) n2 + ThreadLocalRandom.current().nextFloat() * (float) (n3 - n2);
        this.Field1082 = new Vector2f(f, f2);
        this.Field1083 = new Vector2f(0.0f, 0.35f);
        this.Field1084 = 0;
        this.Field1085 = ThreadLocalRandom.current().nextInt(32, 192);
        this.Field1086 = 0.5f + ThreadLocalRandom.current().nextFloat() * 1.5f;
    }

    public static int Method2159853(int n2, int n3) {
        return n3 << 24 | (n2 &= 0xFFFFFF);
    }

    public void Method2159846(ScaledResolution scaledResolution) {
        this.Field1081 = new Vector2f((float) (Math.random() * (double) scaledResolution.getScaledWidth()), (float) (Math.random() * (double) scaledResolution.getScaledHeight()));
    }

    public void Method2159847() {
        if (this.Field1084 < this.Field1085) {
            this.Field1084 += 8;
        }
        if (this.Field1083.getX() > 0.35f) {
            this.Field1083.setX(this.Field1083.getX() * 0.975f);
        } else if (this.Field1083.getX() < -0.35f) {
            this.Field1083.setX(this.Field1083.getX() * 0.975f);
        }
        if (this.Field1083.getY() > 0.35f) {
            this.Field1083.setY(this.Field1083.getY() * 0.975f);
        } else if (this.Field1083.getY() < -0.35f) {
            this.Field1083.setY(this.Field1083.getY() * 0.975f);
        }
        this.Field1081.add((Tuple2f) this.Field1083);
        this.Field1081.add((Tuple2f) this.Field1082);
    }

    public void Method2159848(int n2, int n3) {
        if (Mouse.isButtonDown((int) 0)) {
            float f = (float) n2 - this.Field1081.getX();
            float f2 = (float) n3 - this.Field1081.getY();
            if (Math.abs(f) < 50.0f && Math.abs(f2) < 50.0f) {
                this.Field1083.setX(this.Field1083.getX() + f * 0.0015f);
                this.Field1083.setY(this.Field1083.getY() + f2 * 0.0015f);
            }
        }
        Color color = ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150586() : new Color(ClickGui.Method2150300().Field878.getValue(), ClickGui.Method2150300().Field879.getValue(), ClickGui.Method2150300().Field880.getValue(), ClickGui.Method2150300().Field830.getValue());
        RenderUtil.Method2163027(this.Field1081.x, this.Field1081.y, this.Field1081.x + this.Field1086, this.Field1081.y + this.Field1086, Particle.Method2159853(ColorUtil.Method2163378(color.getRed(), color.getGreen(), color.getBlue()), this.Field1084));
    }

    public Vector2f Method2159849() {
        return this.Field1081;
    }

    public void Method2159840(Vector2f vector2f) {
        this.Field1081 = vector2f;
    }

    public Vector2f Method2159851() {
        return this.Field1082;
    }

    public void Method2159852(Vector2f vector2f) {
        this.Field1082 = vector2f;
    }

    public Vector2f Method2159854() {
        return this.Field1083;
    }

    public void Method2159855(Vector2f vector2f) {
        this.Field1083 = vector2f;
    }

    public int Method2159856() {
        return this.Field1084;
    }

    public void Method2159857(int n2) {
        this.Field1084 = n2;
    }

    public float Method2159858() {
        return this.Field1086;
    }

    public void Method2159859(float f) {
        this.Field1086 = f;
    }
}

