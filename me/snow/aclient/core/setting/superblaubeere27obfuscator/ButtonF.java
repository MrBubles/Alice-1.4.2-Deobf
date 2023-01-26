

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

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ComponentF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class ButtonF
        extends ItemF {
    private boolean Field923;

    public ButtonF(String string) {
        super(string);
        this.Field1552 = 15;
    }

    @Override
    public void Method2159752(int n2, int n3, float f) {
        RenderUtil.Method2163027(this.Field1549, this.Field1550, this.Field1549 + (float) this.Field1551, this.Field1550 + (float) this.Field1552 - 0.5f, this.Method2159735() ? (!this.Method2159736(n2, n3) ? AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3246.getValue()) : AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3247.getValue())) : (!this.Method2159736(n2, n3) ? ColorUtil.Method2163379(100, 100, 100, 43) : -2007673515));
        AliceMain.Field766.Method2150317(this.Method2150361(), this.Field1549 + 2.3f, this.Field1550 - 2.0f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159735() ? ColorUtil.Method2163379(255, 255, 255, 255) : ColorUtil.Method2163379(160, 160, 160, 255));
    }

    @Override
    public void Method2159753(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159736(n2, n3)) {
            this.Method2159733();
        }
    }

    public void Method2159733() {
        this.Field923 = !this.Field923;
        this.Method2159734();
        Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
    }

    public void Method2159734() {
    }

    public boolean Method2159735() {
        return this.Field923;
    }

    @Override
    public int Method2159761() {
        return 14;
    }

    public boolean Method2159736(int n2, int n3) {
        for (ComponentF componentF : FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!componentF.Field2076) continue;
            return false;
        }
        return (float) n2 >= this.Method2159757() && (float) n2 <= this.Method2159757() + (float) this.Method2159759() && (float) n3 >= this.Method2159758() && (float) n3 <= this.Method2159758() + (float) this.Field1552;
    }
}

