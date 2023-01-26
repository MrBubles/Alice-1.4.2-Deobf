

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BindButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BooleanButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SliderF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StringButtonF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UnlimitedSliderF;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

public class ModuleButtonF
        extends ButtonF {
    private final Module Field1614;
    private final ResourceLocation Field1615 = new ResourceLocation("textures/gear.png");
    private List<ItemF> Field1616 = new ArrayList<ItemF>();
    private boolean Field1617;

    public ModuleButtonF(Module module) {
        super(module.Method2150361());
        this.Field1614 = module;
        this.Method2159738();
    }

    public static void Method2159737(float f, float f2, int n2, int n3) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) f, (float) f2, (float) 0.0f);
        GL11.glBegin((int) 7);
        GL11.glTexCoord2f((float) 0.0f, (float) 0.0f);
        GL11.glVertex3f((float) 0.0f, (float) 0.0f, (float) 0.0f);
        GL11.glTexCoord2f((float) 0.0f, (float) 1.0f);
        GL11.glVertex3f((float) 0.0f, (float) n3, (float) 0.0f);
        GL11.glTexCoord2f((float) 1.0f, (float) 1.0f);
        GL11.glVertex3f((float) n2, (float) n3, (float) 0.0f);
        GL11.glTexCoord2f((float) 1.0f, (float) 0.0f);
        GL11.glVertex3f((float) n2, (float) 0.0f, (float) 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    public static float Method2159739(float f) {
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

    public void Method2159738() {
        ArrayList<ItemF> arrayList = new ArrayList<ItemF>();
        if (!this.Field1614.Method2150362().isEmpty()) {
            for (Setting setting : this.Field1614.Method2150362()) {
                if (setting.getValue() instanceof Boolean && !setting.getName().equals("Enabled")) {
                    arrayList.add(new BooleanButtonF(setting));
                }
                if (setting.getValue() instanceof Bind && !this.Field1614.Method2150361().equalsIgnoreCase("Hud")) {
                    arrayList.add(new BindButtonF(setting));
                }
                if (setting.getValue() instanceof String || setting.getValue() instanceof Character) {
                    arrayList.add(new StringButtonF(setting));
                }
                if (setting.isNumberSetting()) {
                    if (setting.hasRestriction()) {
                        arrayList.add(new SliderF(setting));
                        continue;
                    }
                    arrayList.add(new UnlimitedSliderF(setting));
                }
                if (!setting.isEnumSetting()) continue;
                arrayList.add(new EnumButtonF(setting));
            }
        }
        this.Field1616 = arrayList;
    }

    @Override
    public void Method2159752(int n2, int n3, float f) {
        super.Method2159752(n2, n3, f);
        if (!this.Field1616.isEmpty()) {
            ClickGuiF clickGuiF = AliceMain.Field756.Method2150180(ClickGuiF.class);
            Field2811.getTextureManager().bindTexture(this.Field1615);
            ModuleButtonF.Method2159737(this.Field1549 - 3.0f + (float) this.Field1551 - 7.5f, this.Field1550 - 2.0f - (float) FutureGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), 9, 9);
            if (this.Field1617) {
                float f2 = 1.0f;
                for (ItemF itemF : this.Field1616) {
                    if (!itemF.Method2159763()) {
                        itemF.Method2159751(this.Field1549 + 1.0f, this.Field1550 + (f2 += 15.0f));
                        itemF.Method2159762(15);
                        itemF.Method2159750(this.Field1551 - 9);
                        itemF.Method2159752(n2, n3, f);
                    }
                    itemF.Method2159755();
                }
            }
        }
    }

    @Override
    public void Method2159753(int n2, int n3, int n4) {
        super.Method2159753(n2, n3, n4);
        if (!this.Field1616.isEmpty()) {
            if (n4 == 1 && this.Method2159736(n2, n3)) {
                this.Field1617 = !this.Field1617;
                Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            }
            if (this.Field1617) {
                for (ItemF itemF : this.Field1616) {
                    if (itemF.Method2159763()) continue;
                    itemF.Method2159753(n2, n3, n4);
                }
            }
        }
    }

    @Override
    public void Method2159756(char c, int n2) {
        super.Method2159756(c, n2);
        if (!this.Field1616.isEmpty() && this.Field1617) {
            for (ItemF itemF : this.Field1616) {
                if (itemF.Method2159763()) continue;
                itemF.Method2159756(c, n2);
            }
        }
    }

    @Override
    public int Method2159761() {
        if (this.Field1617) {
            int n2 = 14;
            for (ItemF itemF : this.Field1616) {
                if (itemF.Method2159763()) continue;
                n2 += itemF.Method2159761() + 1;
            }
            return n2 + 2;
        }
        return 14;
    }

    public Module Method2159730() {
        return this.Field1614;
    }

    @Override
    public void Method2159734() {
        this.Field1614.Method2150391();
    }

    @Override
    public boolean Method2159735() {
        return this.Field1614.Method2150364();
    }
}

