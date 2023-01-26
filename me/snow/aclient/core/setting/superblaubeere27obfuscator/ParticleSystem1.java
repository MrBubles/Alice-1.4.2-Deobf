

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.vecmath.Tuple2f
 *  javax.vecmath.Vector2f
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import javax.vecmath.Tuple2f;
import javax.vecmath.Vector2f;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Particle;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;

public final class ParticleSystem1 {
    private final int Field2472 = 200;
    private final Particle[] Field2473 = new Particle[200];
    private ScaledResolution Field2474;

    public ParticleSystem1(ScaledResolution scaledResolution) {
        this.Field2474 = scaledResolution;
        for (int j = 0; j < 200; ++j) {
            this.Field2473[j] = new Particle(new Vector2f((float) (Math.random() * (double) scaledResolution.getScaledWidth()), (float) (Math.random() * (double) scaledResolution.getScaledHeight())));
        }
    }

    public static double Method2159862(double d, double d2, double d3, double d4, double d5) {
        d = (d - d2) / (d3 - d2);
        return d4 + d * (d5 - d4);
    }

    public void Method2159850() {
        for (int j = 0; j < 200; ++j) {
            Particle particle = this.Field2473[j];
            if (this.Field2474 != null) {
                boolean bl = particle.Method2159849().x > (float) this.Field2474.getScaledWidth() || particle.Method2159849().x < 0.0f;
                boolean bl2 = particle.Method2159849().y > (float) this.Field2474.getScaledHeight() || particle.Method2159849().y < 0.0f;
                boolean bl3 = bl2;
                if (bl || bl2) {
                    particle.Method2159846(this.Field2474);
                }
            }
            particle.Method2159847();
        }
    }

    public void Method2159861(int n2, int n3) {
        if (!ClickGui.Method2150300().Field876.getValue().booleanValue()) {
            return;
        }
        for (int j = 0; j < 200; ++j) {
            Particle particle = this.Field2473[j];
            for (int i2 = 1; i2 < 200; ++i2) {
                int n4;
                if (j == i2) continue;
                Particle particle2 = this.Field2473[i2];
                Vector2f vector2f = new Vector2f(particle.Method2159849());
                vector2f.sub((Tuple2f) particle2.Method2159849());
                float f = vector2f.length();
                Color color = ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150586() : new Color(ClickGui.Method2150300().Field878.getValue(), ClickGui.Method2150300().Field879.getValue(), ClickGui.Method2150300().Field880.getValue(), ClickGui.Method2150300().Field830.getValue());
                int n5 = ClickGui.Method2150300().Field877.getValue() / (this.Field2474.getScaleFactor() <= 1 ? 3 : this.Field2474.getScaleFactor());
                if (!(f < (float) n5) || (n4 = (int) ParticleSystem1.Method2159862(f, n5, 0.0, 0.0, 127.0)) <= 8)
                    continue;
                RenderUtil.Method2163012(particle.Method2159849().x + particle.Method2159858() / 2.0f, particle.Method2159849().y + particle.Method2159858() / 2.0f, particle2.Method2159849().x + particle2.Method2159858() / 2.0f, particle2.Method2159849().y + particle2.Method2159858() / 2.0f, 1.0f, Particle.Method2159853(ColorUtil.Method2163378(color.getRed(), color.getGreen(), color.getBlue()), n4));
            }
            particle.Method2159848(n2, n3);
        }
    }

    public ScaledResolution Method2159863() {
        return this.Field2474;
    }

    public void Method2159864(ScaledResolution scaledResolution) {
        this.Field2474 = scaledResolution;
    }
}

