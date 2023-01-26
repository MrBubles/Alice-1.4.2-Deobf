

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BindButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BooleanButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Button;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Item;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Slider;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StringButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UnlimitedSlider;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

public class ModuleButton
        extends Button {
    private final Module Field3155;
    private final ResourceLocation Field3156 = new ResourceLocation("textures/gear.png");
    private List<Item> Field3157 = new ArrayList<Item>();
    private boolean Field3158;

    public ModuleButton(Module module) {
        super(module.Method2150361());
        this.Field3155 = module;
        this.Method2159802();
    }

    public static void Method2159801(float f, float f2, int n2, int n3) {
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

    public void Method2159802() {
        ArrayList<Item> arrayList = new ArrayList<Item>();
        if (!this.Field3155.Method2150362().isEmpty()) {
            for (Setting setting : this.Field3155.Method2150362()) {
                if (setting.getValue() instanceof Boolean && !setting.getName().equals("Enabled")) {
                    arrayList.add(new BooleanButton(setting));
                }
                if (setting.getValue() instanceof Bind && !this.Field3155.Method2150361().equalsIgnoreCase("Hud")) {
                    arrayList.add(new BindButton(setting));
                }
                if (setting.getValue() instanceof String || setting.getValue() instanceof Character) {
                    arrayList.add(new StringButton(setting));
                }
                if (setting.isNumberSetting()) {
                    if (setting.hasRestriction()) {
                        arrayList.add(new Slider(setting));
                        continue;
                    }
                    arrayList.add(new UnlimitedSlider(setting));
                }
                if (!setting.isEnumSetting()) continue;
                arrayList.add(new EnumButton(setting));
            }
        }
        this.Field3157 = arrayList;
    }

    @Override
    public void Method2159915(int n2, int n3, float f) {
        super.Method2159915(n2, n3, f);
        if (!this.Field3157.isEmpty()) {
            ClickGui2 clickGui2 = AliceMain.Field756.Method2150180(ClickGui2.class);
            AliceMain.Field766.Method2150317(clickGui2.Field1703.getValue().booleanValue() ? (this.Field3158 ? clickGui2.Field1705.getValue() : clickGui2.Field1704.getValue()) : clickGui2.Field1706.getValue(), this.Field1237 - 1.5f + (float) this.Field1239 - 7.4f, this.Field1238 - 2.0f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
            if (ClickGui2.Method2150488().Field1707.getValue().booleanValue()) {
                Field2811.getTextureManager().bindTexture(this.Field3156);
                ModuleButton.Method2159801(this.Field1237 - 3.0f + (float) this.Field1239 - 7.5f, this.Field1238 - 2.0f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), 9, 9);
            }
            if (this.Field3158) {
                float f2 = 1.0f;
                for (Item item : this.Field3157) {
                    if (!item.Method2159926()) {
                        item.Method2159914(this.Field1237 + 1.0f, this.Field1238 + (f2 += 15.0f));
                        item.Method2159925(15);
                        item.Method2159923(this.Field1239 - 9);
                        item.Method2159915(n2, n3, f);
                    }
                    item.Method2159918();
                }
            }
        }
    }

    @Override
    public void Method2159916(int n2, int n3, int n4) {
        super.Method2159916(n2, n3, n4);
        if (!this.Field3157.isEmpty()) {
            if (n4 == 1 && this.Method2159890(n2, n3)) {
                this.Field3158 = !this.Field3158;
                Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            }
            if (this.Field3158) {
                for (Item item : this.Field3157) {
                    if (item.Method2159926()) continue;
                    item.Method2159916(n2, n3, n4);
                }
            }
        }
    }

    @Override
    public void Method2159919(char c, int n2) {
        super.Method2159919(c, n2);
        if (!this.Field3157.isEmpty() && this.Field3158) {
            for (Item item : this.Field3157) {
                if (item.Method2159926()) continue;
                item.Method2159919(c, n2);
            }
        }
    }

    @Override
    public int Method2159924() {
        if (this.Field3158) {
            int n2 = 14;
            for (Item item : this.Field3157) {
                if (item.Method2159926()) continue;
                n2 += item.Method2159924() + 1;
            }
            return n2 + 2;
        }
        return 14;
    }

    public Module Method2159803() {
        return this.Field3155;
    }

    @Override
    public void Method2159898() {
        this.Field3155.Method2150391();
    }

    @Override
    public boolean Method2159899() {
        return this.Field3155.Method2150364();
    }
}

