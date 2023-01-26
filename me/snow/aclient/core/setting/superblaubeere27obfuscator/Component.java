

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Button;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Item;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

public class Component
        extends Feature {
    private final ArrayList<Item> Field4518 = new ArrayList();
    private final ResourceLocation Field4519 = new ResourceLocation("textures/arrow.png");
    public boolean Field4520;
    private int Field4521;
    private int Field4522;
    private int Field4523;
    private int Field4524;
    private int Field4525;
    private int Field4526;
    private boolean Field4527;
    private boolean Field4528;

    public Component(String string, int n2, int n3, boolean bl) {
        super(string);
        this.Field4521 = n2;
        this.Field4522 = n3;
        this.Field4525 = 96;
        this.Field4526 = 18;
        this.Field4527 = bl;
        this.Method2159871();
    }

    private static void Method2159893(char c, int n2, Item item) {
        item.Method2159919(c, n2);
    }

    private static void Method2159894(int n2, int n3, int n4, Item item) {
        item.Method2159917(n2, n3, n4);
    }

    private static void Method2159895(int n2, int n3, int n4, Item item) {
        item.Method2159916(n2, n3, n4);
    }

    private static void Method2159896(Component component) {
        if (component.Field4520) {
            component.Field4520 = false;
        }
    }

    public void Method2159871() {
    }

    private void Method2159872(int n2, int n3) {
        if (!this.Field4520) {
            return;
        }
        this.Field4521 = this.Field4523 + n2;
        this.Field4522 = this.Field4524 + n3;
    }

    private void Method2159873(float f, int n2) {
        float f2 = 0.0f;
        if (this.Field4527) {
            f2 = this.Method2159892() - 2.0f;
        }
        RenderUtil.Method2163012(this.Field4521, (float) this.Field4522 - 1.5f, this.Field4521, (float) (this.Field4522 + this.Field4526) + f2, f, ColorUtil.Method2163379(ClickGui2.Method2150488().Field1724.getValue(), ClickGui2.Method2150488().Field1725.getValue(), ClickGui2.Method2150488().Field1726.getValue(), ClickGui2.Method2150488().Field1727.getValue()));
        RenderUtil.Method2163012(this.Field4521, (float) this.Field4522 - 1.5f, this.Field4521 + this.Field4525, (float) this.Field4522 - 1.5f, f, ColorUtil.Method2163379(ClickGui2.Method2150488().Field1724.getValue(), ClickGui2.Method2150488().Field1725.getValue(), ClickGui2.Method2150488().Field1726.getValue(), ClickGui2.Method2150488().Field1727.getValue()));
        RenderUtil.Method2163012(this.Field4521 + this.Field4525, (float) this.Field4522 - 1.5f, this.Field4521 + this.Field4525, (float) (this.Field4522 + this.Field4526) + f2, f, ColorUtil.Method2163379(ClickGui2.Method2150488().Field1724.getValue(), ClickGui2.Method2150488().Field1725.getValue(), ClickGui2.Method2150488().Field1726.getValue(), ClickGui2.Method2150488().Field1727.getValue()));
        RenderUtil.Method2163012(this.Field4521, (float) (this.Field4522 + this.Field4526) + f2, this.Field4521 + this.Field4525, (float) (this.Field4522 + this.Field4526) + f2, f, ColorUtil.Method2163379(ClickGui2.Method2150488().Field1724.getValue(), ClickGui2.Method2150488().Field1725.getValue(), ClickGui2.Method2150488().Field1726.getValue(), ClickGui2.Method2150488().Field1727.getValue()));
    }

    public void Method2159874(int n2, int n3, float f) {
        int n4;
        this.Method2159872(n2, n3);
        float f2 = this.Field4527 ? this.Method2159892() - 2.0f : 0.0f;
        int n5 = -7829368;
        if (this.Field4527) {
            RenderUtil.Method2163027(this.Field4521, (float) this.Field4522 + 14.0f, this.Field4521 + this.Field4525, (float) (this.Field4522 + this.Field4526) + f2, 0);
            if (ClickGui2.Method2150488().Field1722.getValue().booleanValue()) {
                this.Method2159873(ClickGui2.Method2150488().Field1723.getValue().floatValue(), n5);
            }
        }
        if (ClickGui2.Method2150488().Field1716.getValue().booleanValue()) {
            n4 = n5 = ColorUtil.Method2163370(ClickGui2.Method2150488().Field1717.getValue(), ClickGui2.Method2150488().Field1718.getValue(), ClickGui2.Method2150488().Field1719.getValue(), ClickGui2.Method2150488().Field1720.getValue());
            RenderUtil.Method2163027(this.Field4521, (float) this.Field4522 + 11.0f, this.Field4521 + this.Field4525, this.Field4522 + this.Field4526 - 6, ClickGui2.Method2150488().Field1681.getValue() != false ? Colors.Field1782.Method2150586().getRGB() : ColorUtil.Method2163370(ClickGui2.Method2150488().Field1717.getValue(), ClickGui2.Method2150488().Field1718.getValue(), ClickGui2.Method2150488().Field1719.getValue(), ClickGui2.Method2150488().Field1720.getValue()));
        }
        if (ClickGui2.Method2150488().Field1697.getValue().booleanValue()) {
            n5 = ClickGui2.Method2150488().Field1681.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163370(ClickGui2.Method2150488().Field1698.getValue(), ClickGui2.Method2150488().Field1699.getValue(), ClickGui2.Method2150488().Field1700.getValue(), ClickGui2.Method2150488().Field1701.getValue());
            n4 = n5;
        }
        if (ClickGui2.Method2150488().Field1682.getValue().booleanValue() && ClickGui2.Method2150488().Field1681.getValue().booleanValue() && Colors.Field1782.Field1783.getValue().booleanValue()) {
            RenderUtil.Method2163905(this.Field4521, (float) this.Field4522 - 1.5f, this.Field4525, this.Field4526 - 4, HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field4522, 0, this.Field3872.Field2304)), HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field4522 + this.Field4526 - 4, 0, this.Field3872.Field2304)));
        } else {
            RenderUtil.Method2163027(this.Field4521, (float) this.Field4522 - 1.5f, this.Field4521 + this.Field4525, this.Field4522 + this.Field4526 - 6, n5);
        }
        if (this.Field4527) {
            RenderUtil.Method2163027(this.Field4521, (float) this.Field4522 + 12.5f, this.Field4521 + this.Field4525, (float) (this.Field4522 + this.Field4526) + f2, ColorUtil.Method2163379(ClickGui2.Method2150488().Field1688.getValue(), ClickGui2.Method2150488().Field1689.getValue(), ClickGui2.Method2150488().Field1690.getValue(), ClickGui2.Method2150488().Field1691.getValue()));
        }
        if (this.Field4527) {
            RenderUtil.Method2163027(this.Field4521, (float) this.Field4522 + 12.5f, this.Field4521 + this.Field4525, (float) (this.Field4522 + this.Field4526) + f2, 0);
            if (ClickGui2.Method2150488().Field1721.getValue().booleanValue()) {
                if (ClickGui2.Method2150488().Field1682.getValue().booleanValue()) {
                    GlStateManager.disableTexture2D();
                    GlStateManager.enableBlend();
                    GlStateManager.disableAlpha();
                    GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
                    GlStateManager.shadeModel((int) 7425);
                    GL11.glBegin((int) 1);
                    Color color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field4522, 0, this.Field3872.Field2304)));
                    GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                    GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) this.Field4522 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field4521, (float) ((float) this.Field4522 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field4521, (float) ((float) this.Field4522 - 1.5f), (float) 0.0f);
                    float f3 = (float) this.Method2159885() - 1.5f;
                    for (Item item : this.Method2159880()) {
                        color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) this.Field4522 + (f3 += (float) item.Method2159924() + 1.5f)), 0, this.Field3872.Field2304)));
                        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                        GL11.glVertex3f((float) this.Field4521, (float) ((float) this.Field4522 + f3), (float) 0.0f);
                        GL11.glVertex3f((float) this.Field4521, (float) ((float) this.Field4522 + f3), (float) 0.0f);
                    }
                    color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) (this.Field4522 + this.Field4526) + f2), 0, this.Field3872.Field2304)));
                    GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                    GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) (this.Field4522 + this.Field4526) + f2), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) (this.Field4522 + this.Field4526) + f2), (float) 0.0f);
                    for (Item item : this.Method2159880()) {
                        color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) this.Field4522 + (f3 -= (float) item.Method2159924() + 1.5f)), 0, this.Field3872.Field2304)));
                        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                        GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) this.Field4522 + f3), (float) 0.0f);
                        GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) this.Field4522 + f3), (float) 0.0f);
                    }
                    GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) this.Field4522, (float) 0.0f);
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
                    Color color = ClickGui2.Method2150488().Field1681.getValue() != false ? new Color(Colors.Field1782.Method2150585()) : new Color(AliceMain.Field786.Method2159062());
                    GL11.glColor4f((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), (float) color.getAlpha());
                    GL11.glVertex3f((float) this.Field4521, (float) ((float) this.Field4522 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) this.Field4522 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field4521 + this.Field4525), (float) ((float) (this.Field4522 + this.Field4526) + f2), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field4521, (float) ((float) (this.Field4522 + this.Field4526) + f2), (float) 0.0f);
                    GL11.glEnd();
                    GlStateManager.shadeModel((int) 7424);
                    GlStateManager.disableBlend();
                    GlStateManager.enableAlpha();
                    GlStateManager.enableTexture2D();
                }
            }
        }
        if (ClickGui2.Method2150488().Field1702.getValue().booleanValue()) {
            AliceMain.Field766.Method2150317(this.Method2150361(), (float) this.Field4521 + (float) (this.Field4525 / 2) - (float) (this.Field3872.Method2150310(this.Method2150361()) / 2), (float) this.Field4522 - 4.0f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
        } else {
            AliceMain.Field766.Method2150317(this.Method2150361(), (float) this.Field4521 + 3.0f, (float) this.Field4522 - 4.0f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
        }
        if (this.Field4527) {
            if (ClickGui2.Method2150488().Field1708.getValue().booleanValue()) {
                Field2811.getTextureManager().bindTexture(this.Field4519);
                ModuleButton.Method2159801((float) this.Field4521 - 1.5f + (float) this.Field4525 - 12.0f, (float) this.Field4522 - 5.0f - (float) LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), 12, 11);
            }
            float f4 = (float) (this.Method2159881() + this.Method2159885()) - 3.0f;
            for (Item item : this.Method2159880()) {
                if (item.Method2159926()) continue;
                item.Method2159914((float) this.Field4521 + 2.0f, f4);
                item.Method2159923(this.Method2159883() - 4);
                item.Method2159915(n2, n3, f);
                f4 += (float) item.Method2159924() + 1.5f;
            }
        }
    }

    public void Method2159875(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159891(n2, n3)) {
            this.Field4523 = this.Field4521 - n2;
            this.Field4524 = this.Field4522 - n3;
            LuigiGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().forEach(Component::Method2159896);
            this.Field4520 = true;
            return;
        }
        if (n4 == 1 && this.Method2159891(n2, n3)) {
            this.Field4527 = !this.Field4527;
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            return;
        }
        if (!this.Field4527) {
            return;
        }
        this.Method2159880().forEach(arg_0 -> Component.Method2159895(n2, n3, n4, arg_0));
    }

    public void Method2159876(int n2, int n3, int n4) {
        if (n4 == 0) {
            this.Field4520 = false;
        }
        if (!this.Field4527) {
            return;
        }
        this.Method2159880().forEach(arg_0 -> Component.Method2159894(n2, n3, n4, arg_0));
    }

    public void Method2159877(char c, int n2) {
        if (!this.Field4527) {
            return;
        }
        this.Method2159880().forEach(arg_0 -> Component.Method2159893(c, n2, arg_0));
    }

    public void Method2159878(Button button) {
        this.Field4518.add(button);
    }

    public int Method2159879() {
        return this.Field4521;
    }

    public void Method2159870(int n2) {
        this.Field4521 = n2;
    }

    public int Method2159881() {
        return this.Field4522;
    }

    public void Method2159882(int n2) {
        this.Field4522 = n2;
    }

    public int Method2159883() {
        return this.Field4525;
    }

    public void Method2159884(int n2) {
        this.Field4525 = n2;
    }

    public int Method2159885() {
        return this.Field4526;
    }

    public void Method2159886(int n2) {
        this.Field4526 = n2;
    }

    public boolean Method2159887() {
        return this.Field4528;
    }

    public void Method2159888(boolean bl) {
        this.Field4528 = bl;
    }

    public boolean Method2159889() {
        return this.Field4527;
    }

    public final ArrayList<Item> Method2159880() {
        return this.Field4518;
    }

    private boolean Method2159891(int n2, int n3) {
        return n2 >= this.Method2159879() && n2 <= this.Method2159879() + this.Method2159883() && n3 >= this.Method2159881() && n3 <= this.Method2159881() + this.Method2159885() - (this.Field4527 ? 2 : 0);
    }

    private float Method2159892() {
        float f = 0.0f;
        for (Item item : this.Method2159880()) {
            f += (float) item.Method2159924() + 1.5f;
        }
        return f;
    }
}

