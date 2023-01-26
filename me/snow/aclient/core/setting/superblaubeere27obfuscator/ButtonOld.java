

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ComponentOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class ButtonOld
        extends ItemOld {
    private boolean Field3828;

    public ButtonOld(String string) {
        super(string);
        this.Field22 = 12;
    }

    @Override
    public void Method2159833(int n2, int n3, float f) {
        if (ClickGui.Method2150300().Field864.getValue().booleanValue()) {
            RenderUtil.Method2163047(this.Field19, this.Field20, this.Field19 + (float) this.Field21, this.Field20 + (float) this.Field22 - 0.2f, this.Method2159817() ? ColorUtil.Method2163379(ClickGui.Method2150300().Field865.getValue(), ClickGui.Method2150300().Field866.getValue(), ClickGui.Method2150300().Field867.getValue(), ClickGui.Method2150300().Field868.getValue()) : ColorUtil.Method2163379(ClickGui.Method2150300().Field865.getValue(), ClickGui.Method2150300().Field866.getValue(), ClickGui.Method2150300().Field867.getValue(), ClickGui.Method2150300().Field868.getValue()));
        }
        if (ClickGui.Method2150300().Field816.getValue().booleanValue()) {
            int n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20 + this.Field22, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue());
            RenderUtil.Method2163905(this.Field19, this.Field20, this.Field21, (float) this.Field22 - 0.5f, this.Method2159817() ? (!this.Method2159818(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)) : n4) : (!this.Method2159818(n2, n3) ? 0x11555555 : -2007673515), this.Method2159817() ? (!this.Method2159818(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20 + this.Field22, 0, this.Field3872.Field2304)) : n5) : (!this.Method2159818(n2, n3) ? ColorUtil.Method2163379(ClickGui.Method2150300().Field826.getValue(), ClickGui.Method2150300().Field827.getValue(), ClickGui.Method2150300().Field828.getValue(), ClickGui.Method2150300().Field829.getValue()) : -2007673515));
        } else {
            RenderUtil.Method2163027(this.Field19, this.Field20, this.Field19 + (float) this.Field21, this.Field20 + (float) this.Field22 - 0.5f, this.Method2159817() ? (!this.Method2159818(n2, n3) ? AliceMain.Field767.Method2159039(AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue()) : AliceMain.Field767.Method2159039(AliceMain.Field756.Method2150180(ClickGui.class).Field830.getValue())) : (!this.Method2159818(n2, n3) ? ColorUtil.Method2163379(ClickGui.Method2150300().Field826.getValue(), ClickGui.Method2150300().Field827.getValue(), ClickGui.Method2150300().Field828.getValue(), ClickGui.Method2150300().Field829.getValue()) : -2007673515));
        }
        AliceMain.Field766.Method2150317(this.Method2150361(), this.Field19 + 2.3f, this.Field20 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159817() ? ColorUtil.Method2163379(ClickGui.Method2150300().Field881.getValue(), ClickGui.Method2150300().Field882.getValue(), ClickGui.Method2150300().Field883.getValue(), ClickGui.Method2150300().Field884.getValue()) : ColorUtil.Method2163379(ClickGui.Method2150300().Field885.getValue(), ClickGui.Method2150300().Field886.getValue(), ClickGui.Method2150300().Field887.getValue(), ClickGui.Method2150300().Field888.getValue()));
    }

    @Override
    public void Method2159834(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159818(n2, n3)) {
            this.Method2159815();
        }
    }

    public void Method2159815() {
        this.Field3828 = !this.Field3828;
        this.Method2159816();
        Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
    }

    public void Method2159816() {
    }

    public boolean Method2159817() {
        return this.Field3828;
    }

    @Override
    public int Method2159842() {
        return 11;
    }

    public boolean Method2159818(int n2, int n3) {
        for (ComponentOld componentOld : LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) {
            if (!componentOld.Field4240) continue;
            return false;
        }
        return (float) n2 >= this.Method2159838() && (float) n2 <= this.Method2159838() + (float) this.Method2159830() && (float) n3 >= this.Method2159839() && (float) n3 <= this.Method2159839() + (float) this.Field22;
    }
}

