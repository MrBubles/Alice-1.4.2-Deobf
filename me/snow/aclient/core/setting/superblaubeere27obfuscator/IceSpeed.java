

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.init.Blocks;

public class IceSpeed
        extends Module {
    private static IceSpeed Field1174 = new IceSpeed();
    private final Setting<Float> Field1175 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(0.4f), Float.valueOf(0.1f), Float.valueOf(1.5f)));

    public IceSpeed() {
        super("IceSpeed", "Speeds you up on ice.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, false, false, false);
        Field1174 = this;
    }

    public static IceSpeed Method2161081() {
        if (Field1174 == null) {
            Field1174 = new IceSpeed();
        }
        return Field1174;
    }

    @Override
    public void Method2150379() {
        Blocks.ICE.slipperiness = this.Field1175.getValue().floatValue();
        Blocks.PACKED_ICE.slipperiness = this.Field1175.getValue().floatValue();
        Blocks.FROSTED_ICE.slipperiness = this.Field1175.getValue().floatValue();
    }

    @Override
    public void Method2150373() {
        Blocks.ICE.slipperiness = 0.98f;
        Blocks.PACKED_ICE.slipperiness = 0.98f;
        Blocks.FROSTED_ICE.slipperiness = 0.98f;
    }
}

