/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class ItemPhysics
        extends Module {
    public static ItemPhysics Field2886 = new ItemPhysics();
    public final Setting<Float> Field2887 = this.Method2150366(new Setting<Float>("Scaling", Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(10.0f)));

    public ItemPhysics() {
        super("ItemPhysics", "Apply physics to items.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162545();
    }

    public static ItemPhysics Method2162544() {
        if (Field2886 == null) {
            Field2886 = new ItemPhysics();
        }
        return Field2886;
    }

    private void Method2162545() {
        Field2886 = this;
    }
}

