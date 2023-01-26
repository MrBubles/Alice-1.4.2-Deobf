

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

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class PhBindButton
        extends PhButton {
    private final Setting Field3189;
    public boolean Field3190;

    public PhBindButton(Setting setting) {
        super(setting.getName());
        this.Field3189 = setting;
        this.Field1218 = 15;
    }

    @Override
    public void Method2159983(int n2, int n3, float f) {
        if (ClickGuiP.Method2150571().Field3254.getValue().booleanValue()) {
            int n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217 + this.Field1219, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue());
            RenderUtil.Method2163905(this.Field1216, this.Field1217, (float) this.Field1218 + 7.4f, (float) this.Field1219 - 0.5f, this.Method2159968() ? (!this.Method2159969(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217, 0, this.Field3872.Field2304)) : n4) : (!this.Method2159969(n2, n3) ? 0x11555555 : -2007673515), this.Method2159968() ? (!this.Method2159969(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1217 + this.Field1219, 0, this.Field3872.Field2304)) : n5) : (!this.Method2159969(n2, n3) ? 0x11555555 : -2007673515));
        } else {
            RenderUtil.Method2163027(this.Field1216, this.Field1217, this.Field1216 + (float) this.Field1218 + 7.4f, this.Field1217 + (float) this.Field1219 - 0.5f, this.Method2159968() ? (!this.Method2159969(n2, n3) ? AliceMain.Field783.Method2159075(AliceMain.Field756.Method2150180(ClickGuiP.class).Field3259.getValue()) : AliceMain.Field783.Method2159075(AliceMain.Field756.Method2150180(ClickGuiP.class).Field3260.getValue())) : (!this.Method2159969(n2, n3) ? 0x11555555 : -2007673515));
        }
        if (this.Field3190) {
            AliceMain.Field766.Method2150317("Listening...", this.Field1216 + 2.3f, this.Field1217 - 1.7f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159968() ? -1 : -5592406);
        } else {
            AliceMain.Field766.Method2150317(this.Field3189.getName() + " \u00a77" + this.Field3189.getValue().toString(), this.Field1216 + 2.3f, this.Field1217 - 1.7f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159968() ? -1 : -5592406);
        }
    }

    @Override
    public void Method2159986() {
        this.Method2159995(this.Field3189.isVisible());
    }

    @Override
    public void Method2159984(int n2, int n3, int n4) {
        super.Method2159984(n2, n3, n4);
        if (this.Method2159969(n2, n3)) {
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
        }
    }

    @Override
    public void Method2159987(char c, int n2) {
        if (this.Field3190) {
            Bind bind = new Bind(n2);
            if (bind.toString().equalsIgnoreCase("Escape")) {
                return;
            }
            if (bind.toString().equalsIgnoreCase("Delete")) {
                bind = new Bind(-1);
            }
            this.Field3189.setValue(bind);
            super.Method2159966();
        }
    }

    @Override
    public int Method2159992() {
        return 14;
    }

    @Override
    public void Method2159967() {
        this.Field3190 = !this.Field3190;
    }

    @Override
    public boolean Method2159968() {
        return !this.Field3190;
    }
}

