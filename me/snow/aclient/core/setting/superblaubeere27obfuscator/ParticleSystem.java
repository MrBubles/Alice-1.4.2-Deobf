

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.vecmath.Tuple2f
 *  javax.vecmath.Vector2f
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import javax.vecmath.Tuple2f;
import javax.vecmath.Vector2f;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Particle1;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;

public final class ParticleSystem {
    private final int Field3589 = 200;
    private final Particle1[] Field3590 = new Particle1[200];
    private ScaledResolution Field3591;

    public ParticleSystem(ScaledResolution scaledResolution) {
        this.Field3591 = scaledResolution;
        for (int j = 0; j < 200; ++j) {
            this.Field3590[j] = new Particle1(new Vector2f((float) (Math.random() * (double) scaledResolution.getScaledWidth()), (float) (Math.random() * (double) scaledResolution.getScaledHeight())));
        }
    }

    public static double Method2159944(double d, double d2, double d3, double d4, double d5) {
        d = (d - d2) / (d3 - d2);
        return d4 + d * (d5 - d4);
    }

    public void Method2159942() {
        for (int j = 0; j < 200; ++j) {
            Particle1 particle1 = this.Field3590[j];
            if (this.Field3591 != null) {
                boolean bl = particle1.Method2159931().x > (float) this.Field3591.getScaledWidth() || particle1.Method2159931().x < 0.0f;
                boolean bl2 = particle1.Method2159931().y > (float) this.Field3591.getScaledHeight() || particle1.Method2159931().y < 0.0f;
                boolean bl3 = bl2;
                if (bl || bl2) {
                    particle1.Method2159928(this.Field3591);
                }
            }
            particle1.Method2159929();
        }
    }

    public void Method2159943(int n2, int n3) {
        if (!ClickGui2.Method2150488().Field1740.getValue().booleanValue()) {
            return;
        }
        for (int j = 0; j < 200; ++j) {
            Particle1 particle1 = this.Field3590[j];
            for (int i2 = 1; i2 < 200; ++i2) {
                int n4;
                if (j == i2) continue;
                Particle1 particle12 = this.Field3590[i2];
                Vector2f vector2f = new Vector2f(particle1.Method2159931());
                vector2f.sub((Tuple2f) particle12.Method2159931());
                float f = vector2f.length();
                int n5 = ClickGui2.Method2150488().Field1741.getValue() / (this.Field3591.getScaleFactor() <= 1 ? 3 : this.Field3591.getScaleFactor());
                if (!(f < (float) n5) || (n4 = (int) ParticleSystem.Method2159944(f, n5, 0.0, 0.0, 127.0)) <= 8)
                    continue;
                RenderUtil.Method2163012(particle1.Method2159931().x + particle1.Method2159930() / 2.0f, particle1.Method2159931().y + particle1.Method2159930() / 2.0f, particle12.Method2159931().x + particle12.Method2159930() / 2.0f, particle12.Method2159931().y + particle12.Method2159930() / 2.0f, 1.0f, Particle1.Method2159935(ColorUtil.Method2163378(ClickGui2.Method2150488().Field1742.getValue(), ClickGui2.Method2150488().Field1743.getValue(), ClickGui2.Method2150488().Field1744.getValue()), n4));
            }
            particle1.Method2159920(n2, n3);
        }
    }

    public ScaledResolution Method2159945() {
        return this.Field3591;
    }

    public void Method2159946(ScaledResolution scaledResolution) {
        this.Field3591 = scaledResolution;
    }
}

