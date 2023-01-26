

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Component;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Item;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class Button
        extends Item {
    private boolean Field2940;

    public Button(String string) {
        super(string);
        this.Field1240 = 15;
    }

    @Override
    public void Method2159915(int n2, int n3, float f) {
        if (ClickGui2.Method2150488().Field1728.getValue().booleanValue()) {
            RenderUtil.Method2163047(this.Field1237, this.Field1238, this.Field1237 + (float) this.Field1239, this.Field1238 + (float) this.Field1240 - 0.9f, this.Method2159899() ? ColorUtil.Method2163379(ClickGui2.Method2150488().Field1729.getValue(), ClickGui2.Method2150488().Field1730.getValue(), ClickGui2.Method2150488().Field1731.getValue(), ClickGui2.Method2150488().Field1732.getValue()) : ColorUtil.Method2163379(ClickGui2.Method2150488().Field1729.getValue(), ClickGui2.Method2150488().Field1730.getValue(), ClickGui2.Method2150488().Field1731.getValue(), ClickGui2.Method2150488().Field1732.getValue()));
        }
        if (ClickGui2.Method2150488().Field1682.getValue().booleanValue()) {
            int n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238 + this.Field1240, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue());
            RenderUtil.Method2163905(this.Field1237, this.Field1238, this.Field1239, (float) this.Field1240 - 0.5f, this.Method2159899() ? (!this.Method2159890(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238, 0, this.Field3872.Field2304)) : n4) : (!this.Method2159890(n2, n3) ? 0x11555555 : -2007673515), this.Method2159899() ? (!this.Method2159890(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field1238 + this.Field1240, 0, this.Field3872.Field2304)) : n5) : (!this.Method2159890(n2, n3) ? ColorUtil.Method2163379(ClickGui2.Method2150488().Field1692.getValue(), ClickGui2.Method2150488().Field1693.getValue(), ClickGui2.Method2150488().Field1694.getValue(), ClickGui2.Method2150488().Field1695.getValue()) : -2007673515));
        } else {
            RenderUtil.Method2163027(this.Field1237, this.Field1238, this.Field1237 + (float) this.Field1239, this.Field1238 + (float) this.Field1240 - 0.5f, this.Method2159899() ? (!this.Method2159890(n2, n3) ? AliceMain.Field786.Method2159063(AliceMain.Field756.Method2150180(ClickGui2.class).Field1687.getValue()) : AliceMain.Field786.Method2159063(AliceMain.Field756.Method2150180(ClickGui2.class).Field1696.getValue())) : (!this.Method2159890(n2, n3) ? ColorUtil.Method2163379(ClickGui2.Method2150488().Field1692.getValue(), ClickGui2.Method2150488().Field1693.getValue(), ClickGui2.Method2150488().Field1694.getValue(), ClickGui2.Method2150488().Field1695.getValue()) : -2007673515));
        }
        AliceMain.Field766.Method2150317(this.Method2150361(), this.Field1237 + 2.3f, this.Field1238 - 2.0f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159899() ? ColorUtil.Method2163379(ClickGui2.Method2150488().Field1745.getValue(), ClickGui2.Method2150488().Field1746.getValue(), ClickGui2.Method2150488().Field1747.getValue(), ClickGui2.Method2150488().Field1748.getValue()) : ColorUtil.Method2163379(ClickGui2.Method2150488().Field1749.getValue(), ClickGui2.Method2150488().Field1750.getValue(), ClickGui2.Method2150488().Field1751.getValue(), ClickGui2.Method2150488().Field1752.getValue()));
    }

    @Override
    public void Method2159916(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159890(n2, n3)) {
            this.Method2159897();
        }
    }

    public void Method2159897() {
        this.Field2940 = !this.Field2940;
        this.Method2159898();
        Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
    }

    public void Method2159898() {
    }

    public boolean Method2159899() {
        return this.Field2940;
    }

    @Override
    public int Method2159924() {
        return 14;
    }

    public boolean Method2159890(int n2, int n3) {
        for (Component component : LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!component.Field4520) continue;
            return false;
        }
        return (float) n2 >= this.Method2159910() && (float) n2 <= this.Method2159910() + (float) this.Method2159922() && (float) n3 >= this.Method2159921() && (float) n3 <= this.Method2159921() + (float) this.Field1240;
    }
}

