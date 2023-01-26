/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class AntiAntiBurrow
        extends Module {
    public static BlockPos Field2824;
    private final Setting<Boolean> Field2822 = this.Method2150366(new Setting<Boolean>("ToggleOnInstantMine", true));
    private final Setting<Double> Field2823 = this.Method2150366(new Setting<Double>("Range", 6.0, 1.0, 8.0));
    int Field2825 = 0;
    EntityPlayer Field2826;

    public AntiAntiBurrow() {
        super("AntiAntiBurrow", "Fuck you ab", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    @Override
    public void Method2150372() {
    }

    @Override
    public void Method2150376() {
        if (AntiAntiBurrow.Method2150359()) {
            return;
        }
    }
}

