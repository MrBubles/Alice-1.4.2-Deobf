

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhComponent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhItem;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class PhButton
        extends PhItem {
    private boolean Field559;

    public PhButton(String string) {
        super(string);
        this.Field1219 = 15;
    }

    @Override
    public void Method2159983(int n2, int n3, float f) {
        if (ClickGuiP.Method2150571().Field3254.getValue().booleanValue()) {
            int n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217 + this.Field1219, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue());
            RenderUtil.Method2163905(this.Field1216, this.Field1217, this.Field1218, (float) this.Field1219 - 0.5f, this.Method2159968() ? (!this.Method2159969(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)) : n4) : (!this.Method2159969(n2, n3) ? 0x11555555 : -2007673515), this.Method2159968() ? (!this.Method2159969(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217 + this.Field1219, 0, this.Field3872.Field2304)) : n5) : (!this.Method2159969(n2, n3) ? 0x11555555 : -2007673515));
        } else {
            RenderUtil.Method2163027(this.Field1216, this.Field1217, this.Field1216 + (float) this.Field1218, this.Field1217 + (float) this.Field1219 - 0.5f, this.Method2159968() ? (!this.Method2159969(n2, n3) ? AliceMain.Field783.Method2159075(AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue()) : AliceMain.Field783.Method2159075(AliceMain.Field756.Method2150180(ClickGuiP.class).Field3260.getValue())) : (!this.Method2159969(n2, n3) ? 0x11555555 : -2007673515));
        }
        AliceMain.Field766.Method2150317(this.Method2150361(), this.Field1216 + 2.3f, this.Field1217 - 2.0f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159968() ? -1 : -5592406);
    }

    @Override
    public void Method2159984(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159969(n2, n3)) {
            this.Method2159966();
        }
    }

    public void Method2159966() {
        this.Field559 = !this.Field559;
        this.Method2159967();
        Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
    }

    public void Method2159967() {
    }

    public boolean Method2159968() {
        return this.Field559;
    }

    @Override
    public int Method2159992() {
        return 14;
    }

    public boolean Method2159969(int n2, int n3) {
        for (PhComponent phComponent : PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!phComponent.Field1367) continue;
            return false;
        }
        return (float) n2 >= this.Method2159988() && (float) n2 <= this.Method2159988() + (float) this.Method2159980() && (float) n3 >= this.Method2159989() && (float) n3 <= this.Method2159989() + (float) this.Field1219;
    }
}

