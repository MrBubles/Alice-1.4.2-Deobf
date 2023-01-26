

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
 *  net.minecraft.util.SoundEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhButton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhItem;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

public class PhComponent
        extends Feature {
    private final ArrayList<PhItem> Field1366 = new ArrayList();
    public boolean Field1367;
    private int Field1368;
    private int Field1369;
    private int Field1370;
    private int Field1371;
    private int Field1372;
    private int Field1373;
    private boolean Field1374;
    private boolean Field1375;

    public PhComponent(String string, int n2, int n3, boolean bl) {
        super(string);
        this.Field1368 = n2;
        this.Field1369 = n3;
        this.Field1372 = 88;
        this.Field1373 = 18;
        this.Field1374 = bl;
        this.Method2159996();
    }

    private static void Method2159017(char c, int n2, PhItem phItem) {
        phItem.Method2159987(c, n2);
    }

    private static void Method2159018(int n2, int n3, int n4, PhItem phItem) {
        phItem.Method2159985(n2, n3, n4);
    }

    private static void Method2159019(int n2, int n3, int n4, PhItem phItem) {
        phItem.Method2159984(n2, n3, n4);
    }

    private static void Method2159010(PhComponent phComponent) {
        if (phComponent.Field1367) {
            phComponent.Field1367 = false;
        }
    }

    public void Method2159996() {
    }

    private void Method2159997(int n2, int n3) {
        if (!this.Field1367) {
            return;
        }
        this.Field1368 = this.Field1370 + n2;
        this.Field1369 = this.Field1371 + n3;
    }

    public void Method2159998(int n2, int n3, float f) {
        this.Method2159997(n2, n3);
        float f2 = this.Field1374 ? this.Method2159016() - 2.0f : 0.0f;
        int n4 = -7829368;
        if (ClickGuiP.Method2150571().Field3267.getValue().booleanValue()) {
            n4 = ClickGuiP.Method2150571().Field3252.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163370(ClickGuiP.Method2150571().Field3268.getValue(), ClickGuiP.Method2150571().Field3269.getValue(), ClickGuiP.Method2150571().Field3270.getValue(), ClickGuiP.Method2150571().Field3271.getValue());
            int n5 = n4;
        }
        if (ClickGuiP.Method2150571().Field3254.getValue().booleanValue() && ClickGuiP.Method2150571().Field3252.getValue().booleanValue() && Colors.Field1782.Field1783.getValue().booleanValue()) {
            RenderUtil.Method2163905(this.Field1368, (float) this.Field1369 - 1.5f, this.Field1372, this.Field1373 - 4, HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field1369, 0, this.Field3872.Field2304)), HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field1369 + this.Field1373 - 4, 0, this.Field3872.Field2304)));
        } else {
            RenderUtil.Method2163027(this.Field1368, (float) this.Field1369 - 1.5f, this.Field1368 + this.Field1372, this.Field1369 + this.Field1373 - 6, n4);
        }
        if (this.Field1374) {
            RenderUtil.Method2163027(this.Field1368, (float) this.Field1369 + 12.5f, this.Field1368 + this.Field1372, (float) (this.Field1369 + this.Field1373) + f2, 0x77000000);
            if (ClickGuiP.Method2150571().Field3253.getValue().booleanValue()) {
                if (ClickGuiP.Method2150571().Field3254.getValue().booleanValue()) {
                    GlStateManager.disableTexture2D();
                    GlStateManager.enableBlend();
                    GlStateManager.disableAlpha();
                    GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
                    GlStateManager.shadeModel((int) 7425);
                    GL11.glBegin((int) 1);
                    Color color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843(this.Field1369, 0, this.Field3872.Field2304)));
                    GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                    GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) this.Field1369 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field1368, (float) ((float) this.Field1369 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field1368, (float) ((float) this.Field1369 - 1.5f), (float) 0.0f);
                    float f3 = (float) this.Method2159909() - 1.5f;
                    for (PhItem phItem : this.Method2159014()) {
                        color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) this.Field1369 + (f3 += (float) phItem.Method2159992() + 1.5f)), 0, this.Field3872.Field2304)));
                        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                        GL11.glVertex3f((float) this.Field1368, (float) ((float) this.Field1369 + f3), (float) 0.0f);
                        GL11.glVertex3f((float) this.Field1368, (float) ((float) this.Field1369 + f3), (float) 0.0f);
                    }
                    color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) (this.Field1369 + this.Field1373) + f2), 0, this.Field3872.Field2304)));
                    GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                    GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) (this.Field1369 + this.Field1373) + f2), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) (this.Field1369 + this.Field1373) + f2), (float) 0.0f);
                    for (PhItem phItem : this.Method2159014()) {
                        color = new Color(HUD.Method2150504().Field3054.get(MathUtil.Method2163843((int) ((float) this.Field1369 + (f3 -= (float) phItem.Method2159992() + 1.5f)), 0, this.Field3872.Field2304)));
                        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
                        GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) this.Field1369 + f3), (float) 0.0f);
                        GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) this.Field1369 + f3), (float) 0.0f);
                    }
                    GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) this.Field1369, (float) 0.0f);
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
                    Color color = ClickGuiP.Method2150571().Field3252.getValue() != false ? new Color(Colors.Field1782.Method2150585()) : new Color(AliceMain.Field783.Method2159074());
                    GL11.glColor4f((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), (float) color.getAlpha());
                    GL11.glVertex3f((float) this.Field1368, (float) ((float) this.Field1369 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) this.Field1369 - 1.5f), (float) 0.0f);
                    GL11.glVertex3f((float) (this.Field1368 + this.Field1372), (float) ((float) (this.Field1369 + this.Field1373) + f2), (float) 0.0f);
                    GL11.glVertex3f((float) this.Field1368, (float) ((float) (this.Field1369 + this.Field1373) + f2), (float) 0.0f);
                    GL11.glEnd();
                    GlStateManager.shadeModel((int) 7424);
                    GlStateManager.disableBlend();
                    GlStateManager.enableAlpha();
                    GlStateManager.enableTexture2D();
                }
            }
        }
        AliceMain.Field766.Method2150317(this.Method2150361(), (float) this.Field1368 + 3.0f, (float) this.Field1369 - 4.0f - (float) PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll(), -1);
        if (this.Field1374) {
            float f4 = (float) (this.Method2159905() + this.Method2159909()) - 3.0f;
            for (PhItem phItem : this.Method2159014()) {
                if (phItem.Method2159994()) continue;
                phItem.Method2159982((float) this.Field1368 + 2.0f, f4);
                phItem.Method2159991(this.Method2159907() - 4);
                phItem.Method2159983(n2, n3, f);
                f4 += (float) phItem.Method2159992() + 1.5f;
            }
        }
    }

    public void Method2159999(int n2, int n3, int n4) {
        if (n4 == 0 && this.Method2159015(n2, n3)) {
            this.Field1370 = this.Field1368 - n2;
            this.Field1371 = this.Field1369 - n3;
            PhobosGui.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll().IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().forEach(PhComponent::Method2159010);
            this.Field1367 = true;
            return;
        }
        if (n4 == 1 && this.Method2159015(n2, n3)) {
            this.Field1374 = !this.Field1374;
            Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getMasterRecord((SoundEvent) SoundEvents.UI_BUTTON_CLICK, (float) 1.0f));
            return;
        }
        if (!this.Field1374) {
            return;
        }
        this.Method2159014().forEach(arg_0 -> PhComponent.Method2159019(n2, n3, n4, arg_0));
    }

    public void Method2159990(int n2, int n3, int n4) {
        if (n4 == 0) {
            this.Field1367 = false;
        }
        if (!this.Field1374) {
            return;
        }
        this.Method2159014().forEach(arg_0 -> PhComponent.Method2159018(n2, n3, n4, arg_0));
    }

    public void Method2159901(char c, int n2) {
        if (!this.Field1374) {
            return;
        }
        this.Method2159014().forEach(arg_0 -> PhComponent.Method2159017(c, n2, arg_0));
    }

    public void Method2159902(PhButton phButton) {
        this.Field1366.add(phButton);
    }

    public int Method2159903() {
        return this.Field1368;
    }

    public void Method2159904(int n2) {
        this.Field1368 = n2;
    }

    public int Method2159905() {
        return this.Field1369;
    }

    public void Method2159906(int n2) {
        this.Field1369 = n2;
    }

    public int Method2159907() {
        return this.Field1372;
    }

    public void Method2159908(int n2) {
        this.Field1372 = n2;
    }

    public int Method2159909() {
        return this.Field1373;
    }

    public void Method2159900(int n2) {
        this.Field1373 = n2;
    }

    public boolean Method2159011() {
        return this.Field1375;
    }

    public void Method2159012(boolean bl) {
        this.Field1375 = bl;
    }

    public boolean Method2159013() {
        return this.Field1374;
    }

    public final ArrayList<PhItem> Method2159014() {
        return this.Field1366;
    }

    private boolean Method2159015(int n2, int n3) {
        return n2 >= this.Method2159903() && n2 <= this.Method2159903() + this.Method2159907() && n3 >= this.Method2159905() && n3 <= this.Method2159905() + this.Method2159909() - (this.Field1374 ? 2 : 0);
    }

    private float Method2159016() {
        float f = 0.0f;
        for (PhItem phItem : this.Method2159014()) {
            f += (float) phItem.Method2159992() + 1.5f;
        }
        return f;
    }
}

