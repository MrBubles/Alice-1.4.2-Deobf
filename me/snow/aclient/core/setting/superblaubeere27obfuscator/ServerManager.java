

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;

public class ServerManager
        extends Feature {
    private final float[] Field3272 = new float[10];
    private final DecimalFormat Field3273 = new DecimalFormat("##.00#");
    private final Timer Field3274 = new Timer();
    private float Field3275 = 20.0f;
    private long Field3276 = -1L;
    private String Field3277 = "";

    public void Method2150298() {
        this.Field3274.Method2164750();
    }

    public boolean Method2150299() {
        return this.Field3274.Method2164755(Global.Method2150598().Field1134.getValue().intValue());
    }

    public long Method2150290() {
        return this.Field3274.Method2164759();
    }

    public void Method2150201() {
        double d;
        float f;
        long l2 = System.currentTimeMillis();
        if (this.Field3276 == -1L) {
            this.Field3276 = l2;
            return;
        }
        long l3 = l2 - this.Field3276;
        float f2 = (float) l3 / 20.0f;
        if (f2 == 0.0f) {
            f2 = 50.0f;
        }
        float f3 = 1000.0f / f2;
        if (f > 20.0f) {
            f3 = 20.0f;
        }
        System.arraycopy(this.Field3272, 0, this.Field3272, 1, this.Field3272.length - 1);
        this.Field3272[0] = f3;
        double d2 = 0.0;
        for (float f4 : this.Field3272) {
            d2 += (double) f4;
        }
        d2 /= (double) this.Field3272.length;
        if (d > 20.0) {
            d2 = 20.0;
        }
        this.Field3275 = Float.parseFloat(this.Field3273.format(d2));
        this.Field3276 = l2;
    }

    @Override
    public void Method2150369() {
        Arrays.fill(this.Field3272, 20.0f);
        this.Field3275 = 20.0f;
    }

    public float Method2150202() {
        return 20.0f / this.Field3275;
    }

    public float Method2150203() {
        return this.Field3275;
    }

    public String Method2150204() {
        return this.Field3277;
    }

    public void Method2150205(String string) {
        this.Field3277 = string;
    }

    public int Method2150206() {
        if (ServerManager.Method2150359()) {
            return 0;
        }
        try {
            return Objects.requireNonNull(Field2811.getConnection()).getPlayerInfo(Field2811.getConnection().getGameProfile().getId()).getResponseTime();
        } catch (Exception exception) {
            return 0;
        }
    }
}

