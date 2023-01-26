

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.CFont;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomFontModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Media;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

public class CustomFont
        extends CFont {
    private final int[] Field1346 = new int[32];
    protected CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[] Field1347 = new CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[256];
    protected CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[] Field1348 = new CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[256];
    protected CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[] Field1349 = new CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[256];
    protected DynamicTexture Field1350;
    protected DynamicTexture Field1351;
    protected DynamicTexture Field1352;

    public CustomFont(Font font, boolean bl, boolean bl2) {
        super(font, bl, bl2);
        this.Method2159788();
        this.Method2159784();
    }

    public float Method2159779(String string, double d, double d2, int n2) {
        float f = this.Method2159783(string, d + 1.0, d2 + 1.0, n2, true);
        return Math.max(f, this.Method2159783(string, d, d2, n2, false));
    }

    public float Method2159770(String string, float f, float f2, int n2) {
        return this.Method2159783(string, f, f2, n2, false);
    }

    public float Method2159781(String string, float f, float f2, int n2) {
        return this.Method2159770(string, f - (float) (this.Method2159772(string) / 2), f2, n2);
    }

    public float Method2159782(String string, float f, float f2, int n2) {
        float f3 = this.Method2159783(string, (double) (f - (float) (this.Method2159772(string) / 2)) + 1.0, (double) f2 + 1.0, n2, true);
        return this.Method2159770(string, f - (float) (this.Method2159772(string) / 2), f2, n2);
    }

    public float Method2159783(String string, double d, double d2, int n2, boolean bl) {
        String string2 = Media.Method2150694().Method2150386() && Media.Method2150694().Field1555.getValue() != false ? string.replace(Media.Method2150695(), Media.Method2150694().Field1556.getValue()) : string;
        double d3 = d;
        double d4 = d2;
        if (CustomFontModule.Method2150594().Method2150386() && !CustomFontModule.Method2150594().Field1265.getValue().booleanValue() && bl) {
            d3 -= 0.5;
            d4 -= 0.5;
        }
        d3 -= 1.0;
        if (string2 == null) {
            return 0.0f;
        }
        if (n2 == 0x20FFFFFF) {
            n2 = 0xFFFFFF;
        }
        if ((n2 & 0xFC000000) == 0) {
            n2 |= 0xFF000000;
        }
        if (bl) {
            n2 = (n2 & 0xFCFCFC) >> 2 | n2 & 0xFF000000;
        }
        CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[] arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field3520;
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = true;
        d3 *= 2.0;
        d4 = (d4 - 3.0) * 2.0;
        if (bl6) {
            GL11.glPushMatrix();
            GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc((int) 770, (int) 771);
            GlStateManager.color((float) ((float) (n2 >> 16 & 0xFF) / 255.0f), (float) ((float) (n2 >> 8 & 0xFF) / 255.0f), (float) ((float) (n2 & 0xFF) / 255.0f), (float) f);
            int n3 = string2.length();
            GlStateManager.enableTexture2D();
            GlStateManager.bindTexture((int) this.Field3526.getGlTextureId());
            GL11.glBindTexture((int) 3553, (int) this.Field3526.getGlTextureId());
            for (int j = 0; j < n3; ++j) {
                char c = string2.charAt(j);
                if (c == '\u00a7' && j < n3) {
                    int n4 = 21;
                    try {
                        n4 = "0123456789abcdefklmnor".indexOf(string2.charAt(j + 1));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (n4 < 16) {
                        bl2 = false;
                        bl3 = false;
                        bl5 = false;
                        bl4 = false;
                        GlStateManager.bindTexture((int) this.Field3526.getGlTextureId());
                        arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field3520;
                        if (n4 < 0 || n4 > 15) {
                            n4 = 15;
                        }
                        if (bl) {
                            n4 += 16;
                        }
                        int n5 = this.Field1346[n4];
                        GlStateManager.color((float) ((float) (n5 >> 16 & 0xFF) / 255.0f), (float) ((float) (n5 >> 8 & 0xFF) / 255.0f), (float) ((float) (n5 & 0xFF) / 255.0f), (float) f);
                    } else if (n4 == 17) {
                        bl2 = true;
                        if (bl3) {
                            GlStateManager.bindTexture((int) this.Field1352.getGlTextureId());
                            arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field1349;
                        } else {
                            GlStateManager.bindTexture((int) this.Field1350.getGlTextureId());
                            arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field1347;
                        }
                    } else if (n4 == 18) {
                        bl4 = true;
                    } else if (n4 == 19) {
                        bl5 = true;
                    } else if (n4 == 20) {
                        bl3 = true;
                        if (bl2) {
                            GlStateManager.bindTexture((int) this.Field1352.getGlTextureId());
                            arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field1349;
                        } else {
                            GlStateManager.bindTexture((int) this.Field1351.getGlTextureId());
                            arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field1348;
                        }
                    } else if (n4 == 21) {
                        bl2 = false;
                        bl3 = false;
                        bl5 = false;
                        bl4 = false;
                        GlStateManager.color((float) ((float) (n2 >> 16 & 0xFF) / 255.0f), (float) ((float) (n2 >> 8 & 0xFF) / 255.0f), (float) ((float) (n2 & 0xFF) / 255.0f), (float) f);
                        GlStateManager.bindTexture((int) this.Field3526.getGlTextureId());
                        arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field3520;
                    }
                    ++j;
                    continue;
                }
                if (c >= arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.length || c < '\u0000')
                    continue;
                GL11.glBegin((int) 4);
                this.Method2159768(arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, c, (float) d3, (float) d4);
                GL11.glEnd();
                if (bl4) {
                    this.Method2159785(d3, d4 + (double) (arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2985 / 2), d3 + (double) arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2984 - 8.0, d4 + (double) (arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2985 / 2), 1.0f);
                }
                if (bl5) {
                    this.Method2159785(d3, d4 + (double) arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2985 - 2.0, d3 + (double) arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2984 - 8.0, d4 + (double) arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2985 - 2.0, 1.0f);
                }
                d3 += (double) (arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2984 - 8 + this.Field3525);
            }
            GL11.glHint((int) 3155, (int) 4352);
            GL11.glPopMatrix();
        }
        return (float) d3 / 2.0f;
    }

    @Override
    public int Method2159772(String string) {
        if (string == null) {
            return 0;
        }
        int n2 = 0;
        CFont.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[] arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field3520;
        boolean bl = false;
        boolean bl2 = false;
        int n3 = string.length();
        for (int j = 0; j < n3; ++j) {
            char c = string.charAt(j);
            if (c == '\u00a7' && j < n3) {
                int n4 = "0123456789abcdefklmnor".indexOf(c);
                if (n4 < 16) {
                    bl = false;
                    bl2 = false;
                } else if (n4 == 17) {
                    bl = true;
                    arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = bl2 ? this.Field1349 : this.Field1347;
                } else if (n4 == 20) {
                    bl2 = true;
                    arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = bl ? this.Field1349 : this.Field1348;
                } else if (n4 == 21) {
                    bl = false;
                    bl2 = false;
                    arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field3520;
                }
                ++j;
                continue;
            }
            if (c >= arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.length || c < '\u0000')
                continue;
            n2 += arriIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll[c].Field2984 - 8 + this.Field3525;
        }
        return n2 / 2;
    }

    @Override
    public void Method2159778(Font font) {
        super.Method2159778(font);
        this.Method2159784();
    }

    @Override
    public void Method2159774(boolean bl) {
        super.Method2159774(bl);
        this.Method2159784();
    }

    @Override
    public void Method2159776(boolean bl) {
        super.Method2159776(bl);
        this.Method2159784();
    }

    private void Method2159784() {
        this.Field1350 = this.Method2159766(this.Field3521.deriveFont(1), this.Field3522, this.Field3523, this.Field1347);
        this.Field1351 = this.Method2159766(this.Field3521.deriveFont(2), this.Field3522, this.Field3523, this.Field1348);
        this.Field1352 = this.Method2159766(this.Field3521.deriveFont(3), this.Field3522, this.Field3523, this.Field1349);
    }

    private void Method2159785(double d, double d2, double d3, double d4, float f) {
        GL11.glDisable((int) 3553);
        GL11.glLineWidth((float) f);
        GL11.glBegin((int) 1);
        GL11.glVertex2d((double) d, (double) d2);
        GL11.glVertex2d((double) d3, (double) d4);
        GL11.glEnd();
        GL11.glEnable((int) 3553);
    }

    public List<String> Method2159786(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if ((double) this.Method2159772(string) > d) {
            String[] arrstring = string.split(" ");
            String string2 = "";
            char c = '\uffff';
            for (String string3 : arrstring) {
                for (int j = 0; j < string3.toCharArray().length; ++j) {
                    char c2 = string3.toCharArray()[j];
                    if (c2 != '\u00a7' || j >= string3.toCharArray().length - 1) continue;
                    c = string3.toCharArray()[j + 1];
                }
                StringBuilder stringBuilder = new StringBuilder();
                if ((double) this.Method2159772(stringBuilder.append(string2).append(string3).append(" ").toString()) < d) {
                    string2 = string2 + string3 + " ";
                    continue;
                }
                arrayList.add(string2);
                string2 = "\u00a7" + c + string3 + " ";
            }
            if (string2.length() > 0) {
                if ((double) this.Method2159772(string2) < d) {
                    arrayList.add("\u00a7" + c + string2 + " ");
                    string2 = "";
                } else {
                    for (String string4 : this.Method2159787(string2, d)) {
                        arrayList.add(string4);
                    }
                }
            }
        } else {
            arrayList.add(string);
        }
        return arrayList;
    }

    public List<String> Method2159787(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = "";
        char c = '\uffff';
        char[] arrc = string.toCharArray();
        for (int j = 0; j < arrc.length; ++j) {
            StringBuilder stringBuilder;
            char c2 = arrc[j];
            if (c2 == '\u00a7' && j < arrc.length - 1) {
                c = arrc[j + 1];
            }
            if ((double) this.Method2159772((stringBuilder = new StringBuilder()).append(string2).append(c2).toString()) < d) {
                string2 = string2 + c2;
                continue;
            }
            arrayList.add(string2);
            string2 = "\u00a7" + c + c2;
        }
        if (string2.length() > 0) {
            arrayList.add(string2);
        }
        return arrayList;
    }

    private void Method2159788() {
        for (int j = 0; j < 32; ++j) {
            int n2 = (j >> 3 & 1) * 85;
            int n3 = (j >> 2 & 1) * 170 + n2;
            int n4 = (j >> 1 & 1) * 170 + n2;
            int n5 = (j >> 0 & 1) * 170 + n2;
            if (j == 6) {
                n3 += 85;
            }
            if (j >= 16) {
                n3 /= 4;
                n4 /= 4;
                n5 /= 4;
            }
            this.Field1346[j] = (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
        }
    }
}

