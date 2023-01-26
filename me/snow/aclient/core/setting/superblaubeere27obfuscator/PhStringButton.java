

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.ChatAllowedCharacters
 *  net.minecraft.util.SoundEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

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
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.SoundEvent;
import org.lwjgl.input.Keyboard;

public class PhStringButton
        extends PhButton {
    private final Setting Field2519;
    public boolean Field2520;
    private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field2521 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll("");

    public PhStringButton(Setting setting) {
        super(setting.getName());
        this.Field2519 = setting;
        this.Field1218 = 15;
    }

    public static String Method2159978(String string) {
        String string2 = "";
        if (string != null && string.length() > 0) {
            string2 = string.substring(0, string.length() - 1);
        }
        return string2;
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
        if (this.Field2520) {
            AliceMain.Field766.Method2150317(this.Field2521.Method2159977() + AliceMain.Field766.Method2150325(), this.Field1216 + 2.3f, this.Field1217 - 1.7f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159968() ? -1 : -5592406);
        } else {
            AliceMain.Field766.Method2150317((this.Field2519.shouldRenderName() ? this.Field2519.getName() + " \u00a77" : "") + this.Field2519.getValue(), this.Field1216 + 2.3f, this.Field1217 - 1.7f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159968() ? -1 : -5592406);
        }
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
        if (this.Field2520) {
            if (n2 == 1) {
                return;
            }
            if (n2 == 28) {
                this.Method2159979();
            } else if (n2 == 14) {
                this.Method2159970(PhStringButton.Method2159978(this.Field2521.Method2159977()));
            } else if (n2 == 47 && (Keyboard.isKeyDown((int) 157) || Keyboard.isKeyDown((int) 29))) {
                try {
                    this.Method2159970(this.Field2521.Method2159977() + Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else if (ChatAllowedCharacters.isAllowedCharacter((char) c)) {
                this.Method2159970(this.Field2521.Method2159977() + c);
            }
        }
    }

    @Override
    public void Method2159986() {
        this.Method2159995(this.Field2519.isVisible());
    }

    private void Method2159979() {
        if (this.Field2521.Method2159977().isEmpty()) {
            this.Field2519.setValue(this.Field2519.getDefaultValue());
        } else {
            this.Field2519.setValue(this.Field2521.Method2159977());
        }
        this.Method2159970("");
        super.Method2159966();
    }

    @Override
    public int Method2159992() {
        return 14;
    }

    @Override
    public void Method2159967() {
        this.Field2520 = !this.Field2520;
    }

    @Override
    public boolean Method2159968() {
        return !this.Field2520;
    }

    public void Method2159970(String string) {
        this.Field2521 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(string);
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private final String Field1088;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string) {
            this.Field1088 = string;
        }

        public String Method2159977() {
            return this.Field1088;
        }
    }
}

