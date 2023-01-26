

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ComponentF
        extends Feature {
    private final ArrayList<ItemF> Field2074 = new ArrayList();
    private final ResourceLocation Field2075 = new ResourceLocation("textures/arrow.png");
    public boolean Field2076;
    private int Field2077;
    private int Field2078;
    private int Field2079;
    private int Field2080;
    private int Field2081;
    private int Field2082;
    private boolean Field2083;
    private boolean Field2084;

    public ComponentF(String string, int n2, int n3, boolean bl) {
        super(string);
        this.Field2077 = n2;
        this.Field2078 = n3;
        this.Field2081 = 88;
        this.Field2082 = 18;
        this.Field2083 = bl;
        this.Method2159607();
    }

    public static float Method2159728(float f) {
        float f2;
        f %= 360.0f;
        if (f2 >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    private static void Method2159729(char c, int n2, ItemF itemF) {
        itemF.Method2159756(c, n2);
    }

    private static void Method2159720(int n2, int n3, int n4, ItemF itemF) {
        itemF.Method2159754(n2, n3, n4);
    }

    private static void Method2159731(int n2, int n3, int n4, ItemF itemF) {
        itemF.Method2159753(n2, n3, n4);
    }

    private static void Method2159732(ComponentF componentF) {
        if (componentF.Field2076) {
            componentF.Field2076 = false;
        }
    }

    public void Method2159607() {
    }

    private void Method2159608(int n2, int n3) {
        if (!this.Field2076) {
            return;
        }
        this.Field2077 = this.Field2079 + n2;
        this.Field2078 = this.Field2080 + n3;
    }

    public void Method2159609(int n2, int n3, float f) {
        this.Method2159608(n2, n3);
        float f2 = this.Field2083 ? this.Method2159727() - 2.0f : 0.0f;
        int n4 = -7829368;
        if (this.Field2083) {
            RenderUtil.Method2163027(this.Field2077, (float) this.Field2078 + 14.0f, this.Field2077 + this.Field2081, (float) (this.Field2078 + this.Field2082) + f2, 0);
        }
        int n5 = n4 = AliceMain.Field785.Method2159099(AliceMain.Field756.Method2150180(ClickGuiF.class).Field3246.getValue());
        RenderUtil.Method2163027(this.Field2077, (float) this.Field2078 - 1.5f, this.Field2077 + this.Field2081, this.Field2078 + this.Field2082 - 6, n4);
        if (this.Field2083) {
            RenderUtil.Method2163027(this.Field2077, (float) this.Field2078 + 12.5f, this.Field2077 + this.Field2081, (float) (this.Field2078 + this.Field2082) + f2, 0x77000000);
        }
        if (this.Field2083) {
            RenderUtil.Method2163027(this.Field2077, (float) this.Field2078 + 12.5f, this.Field2077 + this.Field2081, (float) (this.Field2078 + this.Field2082) + f2, 0);
        }
        AliceMain.Field766.Method2150317(this.Method2150361(), (float) this.Field2077 + 3.0f, (float) this.Field2078 - 4.0f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
        if (this.Field2083) {
            Field2811.getTextureManager().bindTexture(this.Field2075);
            ModuleButtonF.Method2159737((float) this.Field2077 - 1.5f + (float) this.Field2081 - 12.0f, (float) this.Field2078 - 5.0f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), 12, 11);
            float f3 = (float) (this.Method2159716() + this.Method2159710()) - 3.0f;
            for (ItemF itemF : this.Method2159725()) {
                if (itemF.Method2159763()) continue;
                itemF.Method2159751((float) this.Field2077 + 2.0f, f3);
                itemF.Method2159750(this.Method2159718() - 4);
                itemF.Method2159752(n2, n3, f);
                f3 += (float) itemF.Method2159761() + 1.5f;
            }
        }
    }

    public void Method2159600(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159726(n2, n3)) {
            this.Field2079 = this.Field2077 - n2;
            this.Field2080 = this.Field2078 - n3;
            FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().forEach(ComponentF::Method2159732);
            this.Field2076 = true;
            return;
        }
        if (n4 == 1 && this.Method2159726(n2, n3)) {
            this.Field2083 = !this.Field2083;
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            return;
        }
        if (!this.Field2083) {
            return;
        }
        this.Method2159725().forEach(arg_0 -> ComponentF.Method2159731(n2, n3, n4, arg_0));
    }

    public void Method2159711(int n2, int n3, int n4) {
        if (n4 == 0) {
            this.Field2076 = false;
        }
        if (!this.Field2083) {
            return;
        }
        this.Method2159725().forEach(arg_0 -> ComponentF.Method2159720(n2, n3, n4, arg_0));
    }

    public void Method2159712(char c, int n2) {
        if (!this.Field2083) {
            return;
        }
        this.Method2159725().forEach(arg_0 -> ComponentF.Method2159729(c, n2, arg_0));
    }

    public void Method2159713(ButtonF buttonF) {
        this.Field2074.add(buttonF);
    }

    public int Method2159714() {
        return this.Field2077;
    }

    public void Method2159715(int n2) {
        this.Field2077 = n2;
    }

    public int Method2159716() {
        return this.Field2078;
    }

    public void Method2159717(int n2) {
        this.Field2078 = n2;
    }

    public int Method2159718() {
        return this.Field2081;
    }

    public void Method2159719(int n2) {
        this.Field2081 = n2;
    }

    public int Method2159710() {
        return this.Field2082;
    }

    public void Method2159721(int n2) {
        this.Field2082 = n2;
    }

    public boolean Method2159722() {
        return this.Field2084;
    }

    public void Method2159723(boolean bl) {
        this.Field2084 = bl;
    }

    public boolean Method2159724() {
        return this.Field2083;
    }

    public final ArrayList<ItemF> Method2159725() {
        return this.Field2074;
    }

    private boolean Method2159726(int n2, int n3) {
        return n2 >= this.Method2159714() && n2 <= this.Method2159714() + this.Method2159718() && n3 >= this.Method2159716() && n3 <= this.Method2159716() + this.Method2159710() - (this.Field2083 ? 2 : 0);
    }

    private float Method2159727() {
        float f = 0.0f;
        for (ItemF itemF : this.Method2159725()) {
            f += (float) itemF.Method2159761() + 1.5f;
        }
        return f;
    }
}

