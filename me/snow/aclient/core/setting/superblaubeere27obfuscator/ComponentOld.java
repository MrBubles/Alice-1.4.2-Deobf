

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

public class ComponentOld
        extends Feature {
    private final ArrayList<ItemOld> Field4238 = new ArrayList();
    private final ResourceLocation Field4239 = new ResourceLocation("textures/arrow.png");
    public boolean Field4240;
    private int Field4241;
    private int Field4242;
    private int Field4243;
    private int Field4244;
    private int Field4245;
    private int Field4246;
    private boolean Field4247;
    private boolean Field4248;

    public ComponentOld(String string, int n2, int n3, boolean bl) {
        super(string);
        this.Field4241 = n2;
        this.Field4242 = n3;
        this.Field4245 = 110;
        this.Field4246 = 18;
        this.Field4247 = bl;
        this.Method2159789();
    }

    private static void Method2159811(char c, int n2, ItemOld itemOld) {
        itemOld.Method2159837(c, n2);
    }

    private static void Method2159812(int n2, int n3, int n4, ItemOld itemOld) {
        itemOld.Method2159835(n2, n3, n4);
    }

    private static void Method2159813(int n2, int n3, int n4, ItemOld itemOld) {
        itemOld.Method2159834(n2, n3, n4);
    }

    private static void Method2159814(ComponentOld componentOld) {
        if (componentOld.Field4240) {
            componentOld.Field4240 = false;
        }
    }

    public void Method2159789() {
    }

    private void Method2159780(int n2, int n3) {
        if (!this.Field4240) {
            return;
        }
        this.Field4241 = this.Field4243 + n2;
        this.Field4242 = this.Field4244 + n3;
    }

    private void Method2159791(float f, int n2) {
        float f2 = 0.0f;
        if (this.Field4247) {
            f2 = this.Method2159700() - 2.0f;
        }
        RenderUtil.Method2163012(this.Field4241, (float) this.Field4242 - 1.5f, this.Field4241, (float) (this.Field4242 + this.Field4246) + f2, f, ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(ClickGui.Method2150300().Field860.getValue(), ClickGui.Method2150300().Field861.getValue(), ClickGui.Method2150300().Field862.getValue(), ClickGui.Method2150300().Field863.getValue()));
        RenderUtil.Method2163012(this.Field4241, (float) this.Field4242 - 1.5f, this.Field4241 + this.Field4245, (float) this.Field4242 - 1.5f, f, ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(ClickGui.Method2150300().Field860.getValue(), ClickGui.Method2150300().Field861.getValue(), ClickGui.Method2150300().Field862.getValue(), ClickGui.Method2150300().Field863.getValue()));
        RenderUtil.Method2163012(this.Field4241 + this.Field4245, (float) this.Field4242 - 1.5f, this.Field4241 + this.Field4245, (float) (this.Field4242 + this.Field4246) + f2, f, ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(ClickGui.Method2150300().Field860.getValue(), ClickGui.Method2150300().Field861.getValue(), ClickGui.Method2150300().Field862.getValue(), ClickGui.Method2150300().Field863.getValue()));
        RenderUtil.Method2163012(this.Field4241, (float) (this.Field4242 + this.Field4246) + f2, this.Field4241 + this.Field4245, (float) (this.Field4242 + this.Field4246) + f2, f, ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(ClickGui.Method2150300().Field860.getValue(), ClickGui.Method2150300().Field861.getValue(), ClickGui.Method2150300().Field862.getValue(), ClickGui.Method2150300().Field863.getValue()));
    }

    public void Method2159792(int n2, int n3, float f) {
        this.Method2159780(n2, n3);
        float f2 = this.Field4247 ? this.Method2159700() - 2.0f : 0.0f;
        int n4 = -7829368;
        if (this.Field4247) {
            RenderUtil.Method2163027(this.Field4241, (float) this.Field4242 + 14.0f, this.Field4241 + this.Field4245, (float) (this.Field4242 + this.Field4246) + f2, 0);
            if (ClickGui.Method2150300().Field858.getValue().booleanValue()) {
                this.Method2159791(ClickGui.Method2150300().Field859.getValue().floatValue(), n4);
            }
        }
        if (ClickGui.Method2150300().Field852.getValue().booleanValue()) {
            int n5 = n4 = ColorUtil.Method2163370(ClickGui.Method2150300().Field853.getValue(), ClickGui.Method2150300().Field854.getValue(), ClickGui.Method2150300().Field855.getValue(), ClickGui.Method2150300().Field856.getValue());
            RenderUtil.Method2163027(this.Field4241, (float) this.Field4242 + 11.0f, this.Field4241 + this.Field4245, this.Field4242 + this.Field4246 - 6, ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150586().getRGB() : ColorUtil.Method2163370(ClickGui.Method2150300().Field853.getValue(), ClickGui.Method2150300().Field854.getValue(), ClickGui.Method2150300().Field855.getValue(), ClickGui.Method2150300().Field856.getValue()));
        }
        Color color = new Color(ClickGui.Method2150300().Field815.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163370(ClickGui.Method2150300().Field831.getValue(), ClickGui.Method2150300().Field832.getValue(), ClickGui.Method2150300().Field833.getValue(), ClickGui.Method2150300().Field834.getValue()));
        int n6 = n4 = ColorUtil.Method2163379(color.getRed(), color.getGreen(), color.getBlue(), ClickGui.Method2150300().Field834.getValue());
        if (ClickGui.Method2150300().Field816.getValue().booleanValue() && ClickGui.Method2150300().Field814.getValue().booleanValue() && Colors.Field1782.Field1783.getValue().booleanValue()) {
            RenderUtil.Method2163905(this.Field4241, (float) this.Field4242 - 1.5f, this.Field4245, this.Field4246 - 4, HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field4242, 0, this.Field3872.Field2304)), HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field4242 + this.Field4246 - 4, 0, this.Field3872.Field2304)));
        } else {
            RenderUtil.Method2163027(this.Field4241, (float) this.Field4242 - 1.5f, this.Field4241 + this.Field4245, this.Field4242 + this.Field4246 - 6, n4);
        }
        if (this.Field4247) {
            RenderUtil.Method2163027(this.Field4241, (float) this.Field4242 + 12.5f, this.Field4241 + this.Field4245, (float) (this.Field4242 + this.Field4246) + f2, ColorUtil.Method2163379(ClickGui.Method2150300().Field822.getValue(), ClickGui.Method2150300().Field823.getValue(), ClickGui.Method2150300().Field824.getValue(), ClickGui.Method2150300().Field825.getValue()));
        }
        if (this.Field4247) {
            RenderUtil.Method2163027(this.Field4241, (float) this.Field4242 + 12.5f, this.Field4241 + this.Field4245, (float) (this.Field4242 + this.Field4246) + f2, 0);
            if (ClickGui.Method2150300().Field857.getValue().booleanValue()) {
                Color color2;
                if (ClickGui.Method2150300().Field816.getValue().booleanValue()) {
                    GlStateManager.disableTexture2D();
                    GlStateManager.enableBlend();
                    GlStateManager.disableAlpha();
                    GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
                    GlStateManager.shadeModel((int) 7425);
                    GL11.glBegin((int) 1);
                    color2 = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field4242, 0, this.Field3872.Field2304)));
                    GL11.glColor4f((float) ((float) color2.getRed() / 255.0f), (float) ((float) color2.getGreen() / 255.0f), (float) ((float) color2.getBlue() / 255.0f), (float) ((float) color2.getAlpha() / 255.0f));
                    GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) this.Field4242 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field4241, (float) ((float) this.Field4242 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field4241, (float) ((float) this.Field4242 - 1.5f), (float) 0.0f);
                    float f3 = (float) this.Method2159703() - 1.5f;
                    for (ItemOld itemOld : this.Method2159708()) {
                        color2 = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) this.Field4242 + (f3 += (float) itemOld.Method2159842() + 1.5f)), 0, this.Field3872.Field2304)));
                        GL11.glColor4f((float) ((float) color2.getRed() / 255.0f), (float) ((float) color2.getGreen() / 255.0f), (float) ((float) color2.getBlue() / 255.0f), (float) ((float) color2.getAlpha() / 255.0f));
                        GL11.glVertex3f((float) this.Field4241, (float) ((float) this.Field4242 + f3), (float) 0.0f);
                        GL11.glVertex3f((float) this.Field4241, (float) ((float) this.Field4242 + f3), (float) 0.0f);
                    }
                    color2 = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) (this.Field4242 + this.Field4246) + f2), 0, this.Field3872.Field2304)));
                    GL11.glColor4f((float) ((float) color2.getRed() / 255.0f), (float) ((float) color2.getGreen() / 255.0f), (float) ((float) color2.getBlue() / 255.0f), (float) ((float) color2.getAlpha() / 255.0f));
                    GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) (this.Field4242 + this.Field4246) + f2), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) (this.Field4242 + this.Field4246) + f2), (float) 0.0f);
                    for (ItemOld itemOld : this.Method2159708()) {
                        color2 = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) this.Field4242 + (f3 -= (float) itemOld.Method2159842() + 1.5f)), 0, this.Field3872.Field2304)));
                        GL11.glColor4f((float) ((float) color2.getRed() / 255.0f), (float) ((float) color2.getGreen() / 255.0f), (float) ((float) color2.getBlue() / 255.0f), (float) ((float) color2.getAlpha() / 255.0f));
                        GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) this.Field4242 + f3), (float) 0.0f);
                        GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) this.Field4242 + f3), (float) 0.0f);
                    }
                    GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) this.Field4242, (float) 0.0f);
                    GL11.glEnd();
                    GlStateManager.shadeModel((int) 7424);
                    GlStateManager.disableBlend();
                    GlStateManager.enableAlpha();
                    GlStateManager.enableTexture2D();
                } else {
                    GlStateManager.disableTexture2D();
                    GlStateManager.enableBlend();
                    GlStateManager.disableAlpha();
                    GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
                    GlStateManager.shadeModel((int) 7425);
                    GL11.glBegin((int) 2);
                    color2 = ClickGui.Method2150300().Field814.getValue() != false ? new Color(Colors.Field1782.Method2150585()) : new Color(AliceMain.Field767.Method2159038());
                    GL11.glColor4f((float) color2.getRed(), (float) color2.getGreen(), (float) color2.getBlue(), (float) color2.getAlpha());
                    GL11.glVertex3f((float) this.Field4241, (float) ((float) this.Field4242 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) this.Field4242 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field4241 + this.Field4245), (float) ((float) (this.Field4242 + this.Field4246) + f2), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field4241, (float) ((float) (this.Field4242 + this.Field4246) + f2), (float) 0.0f);
                    GL11.glEnd();
                    GlStateManager.shadeModel((int) 7424);
                    GlStateManager.disableBlend();
                    GlStateManager.enableAlpha();
                    GlStateManager.enableTexture2D();
                }
            }
        }
        if (ClickGui.Method2150300().Field835.getValue().booleanValue()) {
            AliceMain.Field766.Method2150317(this.Method2150361(), (float) this.Field4241 + (float) (this.Field4245 / 2) - (float) (this.Field3872.Method2150310(this.Method2150361()) / 2), (float) this.Field4242 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
        } else {
            AliceMain.Field766.Method2150317(this.Method2150361(), (float) this.Field4241 + 3.0f, (float) this.Field4242 - 4.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
        }
        if (this.Field4247) {
            if (ClickGui.Method2150300().Field841.getValue().booleanValue()) {
                Field2811.getTextureManager().bindTexture(this.Field4239);
                ModuleButtonOld.Method2159819((float) this.Field4241 - 1.5f + (float) this.Field4245 - 12.0f, (float) this.Field4242 - 5.0f - (float) LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), 12, 11);
            }
            float f4 = (float) (this.Method2159799() + this.Method2159703()) - 3.0f;
            for (ItemOld itemOld : this.Method2159708()) {
                if (itemOld.Method2159844()) continue;
                itemOld.Method2159832((float) this.Field4241 + 2.0f, f4);
                itemOld.Method2159841(this.Method2159701() - 4);
                itemOld.Method2159833(n2, n3, f);
                f4 += (float) itemOld.Method2159842() + 2.5f;
            }
        }
    }

    public void Method2159793(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159709(n2, n3)) {
            this.Field4243 = this.Field4241 - n2;
            this.Field4244 = this.Field4242 - n3;
            LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().forEach(ComponentOld::Method2159814);
            this.Field4240 = true;
            return;
        }
        if (n4 == 1 && this.Method2159709(n2, n3)) {
            this.Field4247 = !this.Field4247;
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            return;
        }
        if (!this.Field4247) {
            return;
        }
        this.Method2159708().forEach(arg_0 -> ComponentOld.Method2159813(n2, n3, n4, arg_0));
    }

    public void Method2159794(int n2, int n3, int n4) {
        if (n4 == 0) {
            this.Field4240 = false;
        }
        if (!this.Field4247) {
            return;
        }
        this.Method2159708().forEach(arg_0 -> ComponentOld.Method2159812(n2, n3, n4, arg_0));
    }

    public void Method2159795(char c, int n2) {
        if (!this.Field4247) {
            return;
        }
        this.Method2159708().forEach(arg_0 -> ComponentOld.Method2159811(c, n2, arg_0));
    }

    public void Method2159796(ButtonOld buttonOld) {
        this.Field4238.add(buttonOld);
    }

    public int Method2159797() {
        return this.Field4241;
    }

    public void Method2159798(int n2) {
        this.Field4241 = n2;
    }

    public int Method2159799() {
        return this.Field4242;
    }

    public void Method2159790(int n2) {
        this.Field4242 = n2;
    }

    public int Method2159701() {
        return this.Field4245;
    }

    public void Method2159702(int n2) {
        this.Field4245 = n2;
    }

    public int Method2159703() {
        return this.Field4246;
    }

    public void Method2159704(int n2) {
        this.Field4246 = n2;
    }

    public boolean Method2159705() {
        return this.Field4248;
    }

    public void Method2159706(boolean bl) {
        this.Field4248 = bl;
    }

    public boolean Method2159707() {
        return this.Field4247;
    }

    public final ArrayList<ItemOld> Method2159708() {
        return this.Field4238;
    }

    private boolean Method2159709(int n2, int n3) {
        return n2 >= this.Method2159797() && n2 <= this.Method2159797() + this.Method2159701() && n3 >= this.Method2159799() && n3 <= this.Method2159799() + this.Method2159703() - (this.Field4247 ? 2 : 0);
    }

    private float Method2159700() {
        float f = 0.0f;
        for (ItemOld itemOld : this.Method2159708()) {
            f += (float) itemOld.Method2159842() + 2.5f;
        }
        return f;
    }
}

