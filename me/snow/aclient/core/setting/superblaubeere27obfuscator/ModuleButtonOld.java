

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BindButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BooleanButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SliderOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StringButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UnlimitedSliderOld;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

public class ModuleButtonOld
        extends ButtonOld {
    private final Module Field3281;
    private final ResourceLocation Field3282 = new ResourceLocation("textures/gear.png");
    private List<ItemOld> Field3283 = new ArrayList<ItemOld>();
    private boolean Field3284;

    public ModuleButtonOld(Module module) {
        super(module.Method2150361());
        this.Field3281 = module;
        this.Method2159810();
    }

    public static void Method2159819(float f, float f2, int n2, int n3) {
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

    public void Method2159810() {
        ArrayList<ItemOld> arrayList = new ArrayList<ItemOld>();
        if (!this.Field3281.Method2150362().isEmpty()) {
            for (Setting setting : this.Field3281.Method2150362()) {
                if (setting.getValue() instanceof Boolean && !setting.getName().equals("Enabled")) {
                    arrayList.add(new BooleanButtonOld(setting));
                }
                if (setting.getValue() instanceof Bind && !this.Field3281.Method2150361().equalsIgnoreCase("Hud")) {
                    arrayList.add(new BindButtonOld(setting));
                }
                if (setting.getValue() instanceof String || setting.getValue() instanceof Character) {
                    arrayList.add(new StringButtonOld(setting));
                }
                if (setting.isNumberSetting()) {
                    if (setting.hasRestriction()) {
                        arrayList.add(new SliderOld(setting));
                        continue;
                    }
                    arrayList.add(new UnlimitedSliderOld(setting));
                }
                if (!setting.isEnumSetting()) continue;
                arrayList.add(new EnumButtonOld(setting));
            }
        }
        this.Field3283 = arrayList;
    }

    @Override
    public void Method2159833(int n2, int n3, float f) {
        super.Method2159833(n2, n3, f);
        if (!this.Field3283.isEmpty()) {
            ClickGui clickGui = AliceMain.Field756.Method2150180(ClickGui.class);
            AliceMain.Field766.Method2150317(clickGui.Field836.getValue().booleanValue() ? (this.Field3284 ? clickGui.Field838.getValue() : clickGui.Field837.getValue()) : clickGui.Field839.getValue(), this.Field19 - 1.5f + (float) this.Field21 - 7.4f, this.Field20 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), ColorUtil.Method2163379(ClickGui.Method2150300().Field844.getValue(), ClickGui.Method2150300().Field845.getValue(), ClickGui.Method2150300().Field846.getValue(), 255));
            if (ClickGui.Method2150300().Field840.getValue().booleanValue()) {
                Field2811.getTextureManager().bindTexture(this.Field3282);
                ModuleButtonOld.Method2159819(this.Field19 - 4.0f + (float) this.Field21 - 7.4f, this.Field20 - 4.8f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), 9, 9);
            }
            if (this.Field3284) {
                float f2 = 1.0f;
                for (ItemOld itemOld : this.Field3283) {
                    if (!itemOld.Method2159844()) {
                        itemOld.Method2159832(this.Field19 + 1.0f, this.Field20 + (f2 += 12.0f));
                        itemOld.Method2159843(11);
                        itemOld.Method2159841(this.Field21 - 9);
                        itemOld.Method2159833(n2, n3, f);
                    }
                    itemOld.Method2159836();
                }
            }
        }
    }

    @Override
    public void Method2159834(int n2, int n3, int n4) {
        super.Method2159834(n2, n3, n4);
        if (!this.Field3283.isEmpty()) {
            if (n4 == 1 && this.Method2159818(n2, n3)) {
                this.Field3284 = !this.Field3284;
                Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            }
            if (this.Field3284) {
                for (ItemOld itemOld : this.Field3283) {
                    if (itemOld.Method2159844()) continue;
                    itemOld.Method2159834(n2, n3, n4);
                }
            }
        }
    }

    @Override
    public void Method2159837(char c, int n2) {
        super.Method2159837(c, n2);
        if (!this.Field3283.isEmpty() && this.Field3284) {
            for (ItemOld itemOld : this.Field3283) {
                if (itemOld.Method2159844()) continue;
                itemOld.Method2159837(c, n2);
            }
        }
    }

    @Override
    public int Method2159842() {
        if (this.Field3284) {
            int n2 = 11;
            for (ItemOld itemOld : this.Field3283) {
                if (itemOld.Method2159844()) continue;
                n2 += itemOld.Method2159842() + 1;
            }
            return n2 + 2;
        }
        return 11;
    }

    public Module Method2159821() {
        return this.Field3281;
    }

    @Override
    public void Method2159816() {
        this.Field3281.Method2150391();
    }

    @Override
    public boolean Method2159817() {
        return this.Field3281.Method2150364();
    }
}

