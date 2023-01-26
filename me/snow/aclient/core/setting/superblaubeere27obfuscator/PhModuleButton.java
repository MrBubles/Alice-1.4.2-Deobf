

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

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhBindButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhBooleanButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhEnumButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhItem;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhSlider;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhStringButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhUnlimitedSlider;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class PhModuleButton
        extends PhButton {
    private final Module Field3634;
    private List<PhItem> Field3635 = new ArrayList<PhItem>();
    private boolean Field3636;

    public PhModuleButton(Module module) {
        super(module.Method2150361());
        this.Field3634 = module;
        this.Method2159960();
    }

    public void Method2159960() {
        ArrayList<PhItem> arrayList = new ArrayList<PhItem>();
        if (!this.Field3634.Method2150362().isEmpty()) {
            for (Setting setting : this.Field3634.Method2150362()) {
                if (setting.getValue() instanceof Boolean && !setting.getName().equals("Enabled")) {
                    arrayList.add(new PhBooleanButton(setting));
                }
                if (setting.getValue() instanceof Bind && !this.Field3634.Method2150361().equalsIgnoreCase("Hud")) {
                    arrayList.add(new PhBindButton(setting));
                }
                if (setting.getValue() instanceof String || setting.getValue() instanceof Character) {
                    arrayList.add(new PhStringButton(setting));
                }
                if (setting.isNumberSetting()) {
                    if (setting.hasRestriction()) {
                        arrayList.add(new PhSlider(setting));
                        continue;
                    }
                    arrayList.add(new PhUnlimitedSlider(setting));
                }
                if (!setting.isEnumSetting()) continue;
                arrayList.add(new PhEnumButton(setting));
            }
        }
        this.Field3635 = arrayList;
    }

    @Override
    public void Method2159983(int n2, int n3, float f) {
        super.Method2159983(n2, n3, f);
        if (!this.Field3635.isEmpty()) {
            ClickGuiP clickGuiP = AliceMain.Field756.Method2150180(ClickGuiP.class);
            AliceMain.Field766.Method2150317(clickGuiP.Field3263.getValue().booleanValue() ? (this.Field3636 ? clickGuiP.Field3265.getValue() : clickGuiP.Field3264.getValue()) : clickGuiP.Field3266.getValue(), this.Field1216 - 1.5f + (float) this.Field1218 - 7.4f, this.Field1217 - 2.0f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
            if (this.Field3636) {
                float f2 = 1.0f;
                for (PhItem phItem : this.Field3635) {
                    if (!phItem.Method2159994()) {
                        phItem.Method2159982(this.Field1216 + 1.0f, this.Field1217 + (f2 += 15.0f));
                        phItem.Method2159993(15);
                        phItem.Method2159991(this.Field1218 - 9);
                        phItem.Method2159983(n2, n3, f);
                    }
                    phItem.Method2159986();
                }
            }
        }
    }

    @Override
    public void Method2159984(int n2, int n3, int n4) {
        super.Method2159984(n2, n3, n4);
        if (!this.Field3635.isEmpty()) {
            if (n4 == 1 && this.Method2159969(n2, n3)) {
                this.Field3636 = !this.Field3636;
                Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            }
            if (this.Field3636) {
                for (PhItem phItem : this.Field3635) {
                    if (phItem.Method2159994()) continue;
                    phItem.Method2159984(n2, n3, n4);
                }
            }
        }
    }

    @Override
    public void Method2159987(char c, int n2) {
        super.Method2159987(c, n2);
        if (!this.Field3635.isEmpty() && this.Field3636) {
            for (PhItem phItem : this.Field3635) {
                if (phItem.Method2159994()) continue;
                phItem.Method2159987(c, n2);
            }
        }
    }

    @Override
    public int Method2159992() {
        if (this.Field3636) {
            int n2 = 14;
            for (PhItem phItem : this.Field3635) {
                if (phItem.Method2159994()) continue;
                n2 += phItem.Method2159992() + 1;
            }
            return n2 + 2;
        }
        return 14;
    }

    public Module Method2159971() {
        return this.Field3634;
    }

    @Override
    public void Method2159967() {
        this.Field3634.Method2150391();
    }

    @Override
    public boolean Method2159968() {
        return this.Field3634.Method2150364();
    }
}

