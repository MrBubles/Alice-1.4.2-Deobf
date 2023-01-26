

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.EntityLivingBase
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.EntityLivingBase;

public class TickShift
        extends Module {
    public final Setting<Boolean> Field3344 = this.Method2150366(new Setting<Boolean>("Disable", false));
    public final Setting<Boolean> Field3345 = this.Method2150366(new Setting<Boolean>("MovementEnable", true));
    public final Setting<Integer> Field3346 = this.Method2150366(new Setting<Integer>("Anti DisableTicks Height", 20, 1, 100));
    public final Setting<Integer> Field3347 = this.Method2150366(new Setting<Integer>("EnableTicks", 30, 1, 100));
    public final Setting<Double> Field3348 = this.Method2150366(new Setting<Double>("Multiplayer", 3.0, 1.0, 10.0));
    private int Field3349 = 0;
    private int Field3350 = 0;
    private boolean Field3351;
    private boolean Field3352 = false;

    public TickShift() {
        super("TickShift", "placeholder", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    public static boolean Method2162140(EntityLivingBase entityLivingBase) {
        return entityLivingBase.moveForward != 0.0f || entityLivingBase.moveStrafing != 0.0f;
    }

    @Override
    public void Method2150376() {
        if (!this.Field3352) {
            if (TickShift.Method2162140((EntityLivingBase) TickShift.Field2811.player)) {
                if (this.Field3350 >= 1) {
                    --this.Field3350;
                }
            } else if (!TickShift.Method2162140((EntityLivingBase) TickShift.Field2811.player)) {
                ++this.Field3350;
            }
        }
        if (this.Field3350 >= this.Field3347.getValue()) {
            this.Field3352 = true;
            if (this.Field3345.getValue().booleanValue()) {
                if (TickShift.Field2811.gameSettings.keyBindJump.isKeyDown() || TickShift.Field2811.gameSettings.keyBindSneak.isKeyDown() || TickShift.Field2811.gameSettings.keyBindRight.isKeyDown() || TickShift.Field2811.gameSettings.keyBindLeft.isKeyDown() || TickShift.Field2811.gameSettings.keyBindForward.isKeyDown() || TickShift.Field2811.gameSettings.keyBindBack.isKeyDown()) {
                    TickShift.Field2811.timer.tickLength = (float) (50.0 / this.Field3348.getValue());
                    ++this.Field3349;
                }
            } else {
                TickShift.Field2811.timer.tickLength = (float) (50.0 / this.Field3348.getValue());
                ++this.Field3349;
            }
        }
        if (this.Field3349 >= this.Field3346.getValue()) {
            this.Field3349 = 0;
            if (this.Field3344.getValue().booleanValue()) {
                this.Method2150380();
            } else {
                this.Method2150369();
            }
        }
    }

    @Override
    public void Method2150373() {
        this.Field3352 = false;
        this.Field3350 = 0;
        TickShift.Field2811.timer.tickLength = 50.0f;
    }

    @Override
    public void Method2150369() {
        this.Field3352 = false;
        this.Field3350 = 0;
        TickShift.Field2811.timer.tickLength = 50.0f;
    }

    @Override
    public String Method2150385() {
        return (Object) ChatFormatting.WHITE + String.valueOf(this.Field3350);
    }
}

