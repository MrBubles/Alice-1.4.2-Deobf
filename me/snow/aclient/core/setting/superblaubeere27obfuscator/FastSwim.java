

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MotionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TickShift;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FastSwim
        extends Module {
    private final Timer Field3822 = new Timer();
    public Setting<Double> Field3812 = this.Method2150366(new Setting<Double>("Timer Speed", 1.0, 1.0, 2.0));
    public Setting<Double> Field3813 = this.Method2150366(new Setting<Double>("XZ Water", 1.8, 1.0, 5.0));
    public Setting<Double> Field3814 = this.Method2150366(new Setting<Double>("Y+ Water", 1.0, 1.0, 5.0));
    public Setting<Double> Field3815 = this.Method2150366(new Setting<Double>("Y- Water", 1.0, 0.0, 10.0));
    public Setting<Double> Field3816 = this.Method2150366(new Setting<Double>("XZ Lava", 1.8, 1.0, 5.0));
    public Setting<Double> Field3817 = this.Method2150366(new Setting<Double>("Y+ Lava", 1.0, 1.0, 5.0));
    public Setting<Double> Field3818 = this.Method2150366(new Setting<Double>("Y- Lava", 1.0, 0.0, 10.0));
    public Setting<Boolean> Field3819 = this.Method2150366(new Setting<Boolean>("Ground Ignore", true));
    boolean Field3823 = true;
    private boolean Field3820;
    private double Field3821;

    public FastSwim() {
        super("FastSwim", "Liquid Speed", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @Override
    public void Method2150372() {
        this.Field3821 = MotionUtil.Method2163888();
    }

    @Override
    public void Method2150373() {
        this.Field3822.Method2164750();
        EntityUtil.Method2163574();
    }

    @SubscribeEvent
    public void Method2161013(MoveEvent moveEvent) {
        Double d;
        if (FastSwim.Field2811.player == null || FastSwim.Field2811.world == null) {
            return;
        }
        Boolean bl = FastSwim.Field2811.gameSettings.keyBindJump.isKeyDown();
        Boolean bl2 = FastSwim.Field2811.gameSettings.keyBindSneak.isKeyDown();
        Double d2 = moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
        Double d3 = d = Double.valueOf(moveEvent.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll());
        Double d4 = moveEvent.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll();
        if (this.Field3819.getValue().booleanValue() || !FastSwim.Field2811.player.onGround) {
            if (FastSwim.Field2811.player.isInWater()) {
                if (!AliceMain.Field756.Method2150180(TickShift.class).Method2150364() && this.Field3812.getValue() != 1.0) {
                    EntityUtil.Method2163575(this.Field3812.getValue().floatValue());
                }
                d2 = d2 * this.Field3813.getValue();
                d = d * (bl != false ? this.Field3814.getValue() : this.Field3815.getValue());
                d4 = d4 * this.Field3813.getValue();
            }
            if (FastSwim.Field2811.player.isInLava()) {
                if (!AliceMain.Field756.Method2150180(TickShift.class).Method2150364() && this.Field3812.getValue() != 1.0) {
                    EntityUtil.Method2163575(this.Field3812.getValue().floatValue());
                }
                d2 = d2 * this.Field3816.getValue();
                d = d * (bl != false ? this.Field3817.getValue() : this.Field3818.getValue());
                d4 = d4 * this.Field3816.getValue();
            }
        }
        moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(d2);
        moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(d);
        moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(d4);
    }

    double Method2161014(int n2) {
        return 1.0 / Math.pow(10.0, n2 / 2);
    }
}

