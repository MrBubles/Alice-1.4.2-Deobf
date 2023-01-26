

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Button;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class EnumButton
        extends Button {
    public Setting Field3248;

    public EnumButton(Setting setting) {
        super(setting.getName());
        this.Field3248 = setting;
        this.Field1239 = 13;
    }

    @Override
    public void Method2159915(int n2, int n3, float f) {
        int n4;
        if (ClickGui2.Method2150488().Field1682.getValue().booleanValue()) {
            n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238 + this.Field1240, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue());
            RenderUtil.Method2163905(this.Field1237, this.Field1238, (float) this.Field1239 + 7.4f, (float) this.Field1240 - 0.5f, this.Method2159899() ? (!this.Method2159890(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)) : n4) : (!this.Method2159890(n2, n3) ? 0x11555555 : -2007673515), this.Method2159899() ? (!this.Method2159890(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238 + this.Field1240, 0, this.Field3872.Field2304)) : n5) : (!this.Method2159890(n2, n3) ? 0x11555555 : -2007673515));
        } else {
            RenderUtil.Method2163027(this.Field1237, this.Field1238, this.Field1237 + (float) this.Field1239 + 7.4f, this.Field1238 + (float) this.Field1240 - 0.5f, this.Method2159899() ? (!this.Method2159890(n2, n3) ? AliceMain.Field786.Method2159063(AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue()) : AliceMain.Field786.Method2159063(AliceMain.Field756.Method2150180(ClickGui2.class).Field1696.getValue())) : (!this.Method2159890(n2, n3) ? 0x11555555 : -2007673515));
        }
        if (ClickGui2.Method2150488().Field1711.getValue().booleanValue()) {
            n4 = ColorUtil.Method2163370(ClickGui2.Method2150488().Field1712.getValue(), ClickGui2.Method2150488().Field1713.getValue(), ClickGui2.Method2150488().Field1714.getValue(), ClickGui2.Method2150488().Field1715.getValue());
            RenderUtil.Method2163027(this.Field1237, this.Field1238, this.Field1237 + 1.0f, this.Field1238 + (float) this.Field1240 + 0.5f, n4);
        }
        AliceMain.Field766.Method2150317(this.Field3248.getName() + " \u00a77" + this.Field3248.currentEnumName(), this.Field1237 + 2.3f, this.Field1238 - 1.7f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159899() ? -1 : -5592406);
    }

    @Override
    public void Method2159918() {
        this.Method2159927(this.Field3248.isVisible());
    }

    @Override
    public void Method2159916(int n2, int n3, int n4) {
        super.Method2159916(n2, n3, n4);
        if (this.Method2159890(n2, n3)) {
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
        }
    }

    @Override
    public int Method2159924() {
        return 14;
    }

    @Override
    public void Method2159898() {
        this.Field3248.increaseEnum();
    }

    @Override
    public boolean Method2159899() {
        return true;
    }
}

