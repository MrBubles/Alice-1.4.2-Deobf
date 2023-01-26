

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class BindButtonOld
        extends ButtonOld {
    private final Setting Field2763;
    public boolean Field2764;

    public BindButtonOld(Setting setting) {
        super(setting.getName());
        this.Field2763 = setting;
        this.Field21 = 15;
    }

    @Override
    public void Method2159833(int n2, int n3, float f) {
        if (ClickGui.Method2150300().Field816.getValue().booleanValue()) {
            int n4 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue());
            int n5 = ColorUtil.Method2163386(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20 + this.Field22, 0, this.Field3872.Field2304)), AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue());
            RenderUtil.Method2163905(this.Field19, this.Field20, (float) this.Field21 + 7.4f, (float) this.Field22 - 0.5f, this.Method2159817() ? (!this.Method2159818(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20, 0, this.Field3872.Field2304)) : n4) : (!this.Method2159818(n2, n3) ? 0x11555555 : -2007673515), this.Method2159817() ? (!this.Method2159818(n2, n3) ? HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) this.Field20 + this.Field22, 0, this.Field3872.Field2304)) : n5) : (!this.Method2159818(n2, n3) ? 0x11555555 : -2007673515));
        } else {
            RenderUtil.Method2163027(this.Field19, this.Field20, this.Field19 + (float) this.Field21 + 7.4f, this.Field20 + (float) this.Field22 - 0.5f, this.Method2159817() ? (!this.Method2159818(n2, n3) ? AliceMain.Field767.Method2159039(AliceMain.Field756.Method2150180(ClickGui.class).Field821.getValue()) : AliceMain.Field767.Method2159039(AliceMain.Field756.Method2150180(ClickGui.class).Field830.getValue())) : (!this.Method2159818(n2, n3) ? 0x11555555 : -2007673515));
            if (ClickGui.Method2150300().Field847.getValue().booleanValue()) {
                int n6 = ColorUtil.Method2163370(ClickGui.Method2150300().Field848.getValue(), ClickGui.Method2150300().Field849.getValue(), ClickGui.Method2150300().Field850.getValue(), ClickGui.Method2150300().Field851.getValue());
                RenderUtil.Method2163027(this.Field19, this.Field20, this.Field19 + 1.0f, this.Field20 + (float) this.Field22 + 1.0f, n6);
            }
        }
        if (this.Field2764) {
            AliceMain.Field766.Method2150317("Press a key...", this.Field19 + 2.3f, this.Field20 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159817() ? -1 : -5592406);
        } else {
            AliceMain.Field766.Method2150317(this.Field2763.getName() + " \u00a77" + this.Field2763.getValue().toString(), this.Field19 + 2.3f, this.Field20 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159817() ? -1 : -5592406);
        }
    }

    @Override
    public void Method2159836() {
        this.Method2159845(this.Field2763.isVisible());
    }

    @Override
    public void Method2159834(int n2, int n3, int n4) {
        super.Method2159834(n2, n3, n4);
        if (this.Method2159818(n2, n3)) {
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
        }
    }

    @Override
    public void Method2159837(char c, int n2) {
        if (this.Field2764) {
            Bind bind = new Bind(n2);
            if (bind.toString().equalsIgnoreCase("Escape")) {
                return;
            }
            if (bind.toString().equalsIgnoreCase("Delete")) {
                bind = new Bind(-1);
            }
            this.Field2763.setValue(bind);
            super.Method2159815();
        }
    }

    @Override
    public int Method2159842() {
        return 11;
    }

    @Override
    public void Method2159816() {
        this.Field2764 = !this.Field2764;
    }

    @Override
    public boolean Method2159817() {
        return !this.Field2764;
    }
}

