/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class EntityESP
        extends Module {
    private static EntityESP Field25 = new EntityESP();
    public final Setting<Boolean> Field26 = this.Method2150366(new Setting<Boolean>("Sync", false));
    public final Setting<Boolean> Field27 = this.Method2150366(new Setting<Boolean>("Players", true));
    public final Setting<Boolean> Field28 = this.Method2150366(new Setting<Boolean>("TargetColor", false));
    public final Setting<Boolean> Field29 = this.Method2150366(new Setting<Boolean>("Friends", Boolean.TRUE, this::Method2162382));
    public final Setting<Boolean> Field30 = this.Method2150366(new Setting<Boolean>("Animals", false));
    public final Setting<Boolean> Field31 = this.Method2150366(new Setting<Boolean>("Mobs", false));
    public final Setting<Integer> Field32 = this.Method2150366(new Setting<Integer>("Red", 255, 0, 255));
    public final Setting<Integer> Field33 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    public final Setting<Integer> Field34 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    public final Setting<Float> Field35 = this.Method2150366(new Setting<Float>("LineWidth", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));

    public EntityESP() {
        super("EntityESP", "Renders a nice ESP.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162381();
    }

    public static EntityESP Method2162370() {
        if (Field25 == null) {
            Field25 = new EntityESP();
        }
        return Field25;
    }

    private void Method2162381() {
        Field25 = this;
    }

    private boolean Method2162382(Boolean bl) {
        return this.Field27.getValue();
    }
}

