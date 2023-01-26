

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
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.SoundEvent;
import org.lwjgl.input.Keyboard;

public class StringButton
        extends Button {
    private final Setting Field1656;
    public boolean Field1657;
    private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field1658 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll("");

    public StringButton(Setting setting) {
        super(setting.getName());
        this.Field1656 = setting;
        this.Field1239 = 13;
    }

    public static String Method2159800(String string) {
        String string2 = "";
        if (string != null && string.length() > 0) {
            string2 = string.substring(0, string.length() - 1);
        }
        return string2;
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
        if (this.Field1657) {
            AliceMain.Field766.Method2150317(this.Field1658.Method2159809() + AliceMain.Field766.Method2150325(), this.Field1237 + 2.3f, this.Field1238 - 1.7f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159899() ? -1 : -5592406);
        } else {
            AliceMain.Field766.Method2150317((this.Field1656.shouldRenderName() ? this.Field1656.getName() + " \u00a77" : "") + this.Field1656.getValue(), this.Field1237 + 2.3f, this.Field1238 - 1.7f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159899() ? -1 : -5592406);
        }
    }

    @Override
    public void Method2159916(int n2, int n3, int n4) {
        super.Method2159916(n2, n3, n4);
        if (this.Method2159890(n2, n3)) {
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
        }
    }

    @Override
    public void Method2159919(char c, int n2) {
        if (this.Field1657) {
            if (n2 == 1) {
                return;
            }
            if (n2 == 28) {
                this.Method2159911();
            } else if (n2 == 14) {
                this.Method2159912(StringButton.Method2159800(this.Field1658.Method2159809()));
            } else if (n2 == 47 && (Keyboard.isKeyDown((int) 157) || Keyboard.isKeyDown((int) 29))) {
                try {
                    this.Method2159912(this.Field1658.Method2159809() + Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else if (ChatAllowedCharacters.isAllowedCharacter((char) c)) {
                this.Method2159912(this.Field1658.Method2159809() + c);
            }
        }
    }

    @Override
    public void Method2159918() {
        this.Method2159927(this.Field1656.isVisible());
    }

    private void Method2159911() {
        if (this.Field1658.Method2159809().isEmpty()) {
            this.Field1656.setValue(this.Field1656.getDefaultValue());
        } else {
            this.Field1656.setValue(this.Field1658.Method2159809());
        }
        this.Method2159912("");
        super.Method2159897();
    }

    @Override
    public int Method2159924() {
        return 14;
    }

    @Override
    public void Method2159898() {
        this.Field1657 = !this.Field1657;
    }

    @Override
    public boolean Method2159899() {
        return !this.Field1657;
    }

    public void Method2159912(String string) {
        this.Field1658 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(string);
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private final String Field2767;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string) {
            this.Field2767 = string;
        }

        public String Method2159809() {
            return this.Field2767;
        }
    }
}

