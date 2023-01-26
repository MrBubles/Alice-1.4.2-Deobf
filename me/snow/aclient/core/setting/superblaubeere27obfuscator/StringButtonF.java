

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.SoundEvent;
import org.lwjgl.input.Keyboard;

public class StringButtonF
        extends ButtonF {
    private final Setting Field1966;
    public boolean Field1967;
    private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field1968 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll("");

    public StringButtonF(Setting setting) {
        super(setting.getName());
        this.Field1966 = setting;
        this.Field1551 = 13;
    }

    public static String Method2159747(String string) {
        String string2 = "";
        if (string != null && string.length() > 0) {
            string2 = string.substring(0, string.length() - 1);
        }
        return string2;
    }

    @Override
    public void Method2159752(int n2, int n3, float f) {
        RenderUtil.Method2163027(this.Field1549, this.Field1550, this.Field1549 + (float) this.Field1551 + 7.4f, this.Field1550 + (float) this.Field1552 - 0.5f, this.Method2159735() ? (!this.Method2159736(n2, n3) ? AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3246.getValue()) : AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3247.getValue())) : (!this.Method2159736(n2, n3) ? 0x11555555 : -2007673515));
        if (this.Field1967) {
            AliceMain.Field766.Method2150317(this.Field1968.Method2159746() + AliceMain.Field766.Method2150325(), this.Field1549 + 2.3f, this.Field1550 - 1.7f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159735() ? -1 : -5592406);
        } else {
            AliceMain.Field766.Method2150317((this.Field1966.shouldRenderName() ? this.Field1966.getName() + " \u00a77" : "") + this.Field1966.getValue(), this.Field1549 + 2.3f, this.Field1550 - 1.7f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), this.Method2159735() ? -1 : -5592406);
        }
    }

    @Override
    public void Method2159753(int n2, int n3, int n4) {
        super.Method2159753(n2, n3, n4);
        if (this.Method2159736(n2, n3)) {
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
        }
    }

    @Override
    public void Method2159756(char c, int n2) {
        if (this.Field1967) {
            if (n2 == 1) {
                return;
            }
            if (n2 == 28) {
                this.Method2159748();
            } else if (n2 == 14) {
                this.Method2159749(StringButtonF.Method2159747(this.Field1968.Method2159746()));
            } else if (n2 == 47 && (Keyboard.isKeyDown((int) 157) || Keyboard.isKeyDown((int) 29))) {
                try {
                    this.Method2159749(this.Field1968.Method2159746() + Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else if (ChatAllowedCharacters.isAllowedCharacter((char) c)) {
                this.Method2159749(this.Field1968.Method2159746() + c);
            }
        }
    }

    @Override
    public void Method2159755() {
        this.Method2159764(this.Field1966.isVisible());
    }

    private void Method2159748() {
        if (this.Field1968.Method2159746().isEmpty()) {
            this.Field1966.setValue(this.Field1966.getDefaultValue());
        } else {
            this.Field1966.setValue(this.Field1968.Method2159746());
        }
        this.Method2159749("");
        super.Method2159733();
    }

    @Override
    public int Method2159761() {
        return 14;
    }

    @Override
    public void Method2159734() {
        this.Field1967 = !this.Field1967;
    }

    @Override
    public boolean Method2159735() {
        return !this.Field1967;
    }

    public void Method2159749(String string) {
        this.Field1968 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(string);
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private final String Field3704;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string) {
            this.Field3704 = string;
        }

        public String Method2159746() {
            return this.Field3704;
        }
    }
}

