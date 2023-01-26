

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.SoundEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class BooleanButtonF
        extends ButtonF {
    private final Setting Field2977;

    public BooleanButtonF(Setting setting) {
        super(setting.getName());
        this.Field2977 = setting;
        this.Field1551 = 13;
    }

    @Override
    public void Method2159752(int n2, int n3, float f) {
        RenderUtil.Method2163027(this.Field1549, this.Field1550, this.Field1549 + (float) this.Field1551 + 7.4f, this.Field1550 + (float) this.Field1552 - 0.5f, this.Method2159735() ? (!this.Method2159736(n2, n3) ? AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3246.getValue()) : AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3247.getValue())) : (!this.Method2159736(n2, n3) ? 0x11555555 : -2007673515));
        AliceMain.Field766.Method2150317(this.Method2150361(), this.Field1549 + 2.3f, this.Field1550 - 1.7f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159735() ? -1 : -5592406);
    }

    @Override
    public void Method2159755() {
        this.Method2159764(this.Field2977.isVisible());
    }

    @Override
    public void Method2159753(int n2, int n3, int n4) {
        super.Method2159753(n2, n3, n4);
        if (this.Method2159736(n2, n3)) {
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
        }
    }

    @Override
    public int Method2159761() {
        return 14;
    }

    @Override
    public void Method2159734() {
        this.Field2977.setValue((Boolean) this.Field2977.getValue() == false);
    }

    @Override
    public boolean Method2159735() {
        return (Boolean) this.Field2977.getValue();
    }
}

