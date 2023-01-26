

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.awt.Font;
import java.util.Objects;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomFont;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomFontModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.util.math.MathHelper;

public class TextManager
        extends Feature {
    private final Timer Field2302 = new Timer();
    public int Field2303;
    public int Field2304;
    public int Field2305;
    private CustomFont Field2306 = new CustomFont(new Font("Verdana", 0, 17), true, false);
    private boolean Field2307;
    private CustomFont Field2308 = new CustomFont(new Font("Verdana", 0, 17), true, false);
    private CustomFont Field2309 = new CustomFont(new Font("Verdana", 0, 17), true, false);

    public TextManager() {
        this.Method2150324();
    }

    public void Method2150316(boolean bl) {
        CustomFontModule customFontModule = AliceMain.Field756.Method2150180(CustomFontModule.class);
        if (customFontModule.Field1259.getValue() == CustomFontModule.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None) {
            try {
                this.Method2150322(new Font(customFontModule.Field1260.getValue(), (int) customFontModule.Field1262.getValue(), customFontModule.Field1261.getValue()), customFontModule.Field1263.getValue(), customFontModule.Field1264.getValue());
            } catch (Exception exception) {
            }
        } else if (customFontModule.Field1259.getValue() == CustomFontModule.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.LexendDeca) {
            try {
                this.Method2150322(Font.createFont(0, Objects.requireNonNull(AliceMain.class.getResourceAsStream("/assets/mario/LexendDeca-Regular.ttf"))).deriveFont(customFontModule.Field1262.getValue()).deriveFont(customFontModule.Field1261.getValue().floatValue()), customFontModule.Field1263.getValue(), customFontModule.Field1264.getValue());
            } catch (Exception exception) {
            }
        } else if (customFontModule.Field1259.getValue() == CustomFontModule.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Comfortaa) {
            try {
                this.Method2150322(Font.createFont(0, Objects.requireNonNull(AliceMain.class.getResourceAsStream("/assets/mario/Comfortaa-Bold.ttf"))).deriveFont(customFontModule.Field1262.getValue()).deriveFont(customFontModule.Field1261.getValue().floatValue()), customFontModule.Field1263.getValue(), customFontModule.Field1264.getValue());
            } catch (Exception exception) {
            }
        } else if (customFontModule.Field1259.getValue() == CustomFontModule.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ProductSans) {
            try {
                this.Method2150322(Font.createFont(0, Objects.requireNonNull(AliceMain.class.getResourceAsStream("/assets/mario/ProductSans-Regular.ttf"))).deriveFont(customFontModule.Field1262.getValue()).deriveFont(customFontModule.Field1261.getValue().floatValue()), customFontModule.Field1263.getValue(), customFontModule.Field1264.getValue());
            } catch (Exception exception) {
                // empty catch block
            }
        }
        try {
            this.Method2150326(Font.createFont(0, Objects.requireNonNull(AliceMain.class.getResourceAsStream("/assets/mario/Dash-Horizon-Demo.otf"))).deriveFont(0).deriveFont(60.0f), true, false);
        } catch (Exception exception) {
            // empty catch block
        }
        try {
            this.Method2150327(Font.createFont(0, Objects.requireNonNull(AliceMain.class.getResourceAsStream("/assets/mario/IconFont.ttf"))).deriveFont(0).deriveFont(60.0f), true, false);
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public void Method2150317(String string, float f, float f2, int n2) {
        this.Method2150318(string, f, f2, n2, true);
    }

    public float Method2150318(String string, float f, float f2, int n2, boolean bl) {
        if (AliceMain.Field756.Method2150196(CustomFontModule.class)) {
            if (bl) {
                return this.Field2306.Method2159779(string, f, f2, n2);
            }
            return this.Field2306.Method2159770(string, f, f2, n2);
        }
        return TextManager.Field2811.fontRenderer.drawString(string, f, f2, n2, bl);
    }

    public void Method2150319(String string, float f, float f2, int n2, float f3, boolean bl) {
        Color color = new Color(n2);
        float f4 = 1.0f / f3;
        String[] arrstring = string.split("\u00a7.");
        float f5 = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0];
        float f6 = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[1];
        float f7 = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[2];
        int n3 = 0;
        boolean bl2 = true;
        boolean bl3 = false;
        for (int j = 0; j < string.length(); ++j) {
            char c = string.charAt(j);
            char c2 = string.charAt(MathUtil.Method2163843(j + 1, 0, string.length() - 1));
            if ((String.valueOf(c) + c2).equals("\u00a7r")) {
                bl2 = false;
            } else if ((String.valueOf(c) + c2).equals("\u00a7+")) {
                bl2 = true;
            }
            if (bl3) {
                bl3 = false;
                continue;
            }
            if ((String.valueOf(c) + c2).equals("\u00a7r")) {
                String string2 = string.substring(j);
                this.Method2150318(string2, f + (float) n3, f2, Color.WHITE.getRGB(), bl);
                break;
            }
            this.Method2150318(String.valueOf(c).equals("\u00a7") ? "" : String.valueOf(c), f + (float) n3, f2, bl2 ? color.getRGB() : Color.WHITE.getRGB(), bl);
            if (String.valueOf(c).equals("\u00a7")) {
                bl3 = true;
            }
            n3 += this.Method2150310(String.valueOf(c));
            if (String.valueOf(c).equals(" ")) continue;
            color = new Color(Color.HSBtoRGB(f5, f6, f7));
            f5 += f4;
        }
    }

    public int Method2150310(String string) {
        if (AliceMain.Field756.Method2150196(CustomFontModule.class)) {
            return this.Field2306.Method2159772(string);
        }
        return TextManager.Field2811.fontRenderer.getStringWidth(string);
    }

    public int Method2150321() {
        if (AliceMain.Field756.Method2150196(CustomFontModule.class)) {
            String string = "A";
            return this.Field2306.Method2159760(string);
        }
        return TextManager.Field2811.fontRenderer.FONT_HEIGHT;
    }

    public void Method2150322(Font font, boolean bl, boolean bl2) {
        this.Field2306 = new CustomFont(font, bl, bl2);
    }

    public Font Method2150323() {
        return this.Field2306.Method2159777();
    }

    public void Method2150324() {
        this.Field2303 = TextManager.Field2811.displayWidth;
        this.Field2304 = TextManager.Field2811.displayHeight;
        this.Field2305 = 1;
        boolean bl = Field2811.isUnicode();
        int n2 = TextManager.Field2811.gameSettings.guiScale;
        if (n2 == 0) {
            n2 = 1000;
        }
        while (this.Field2305 < n2 && this.Field2303 / (this.Field2305 + 1) >= 320 && this.Field2304 / (this.Field2305 + 1) >= 240) {
            ++this.Field2305;
        }
        if (bl && this.Field2305 % 2 != 0 && this.Field2305 != 1) {
            --this.Field2305;
        }
        double d = (double) this.Field2303 / (double) this.Field2305;
        double d2 = (double) this.Field2304 / (double) this.Field2305;
        this.Field2303 = MathHelper.ceil((double) d);
        this.Field2304 = MathHelper.ceil((double) d2);
    }

    public String Method2150325() {
        if (this.Field2302.Method2164755(500L)) {
            this.Field2307 = !this.Field2307;
            this.Field2302.Method2164750();
        }
        if (this.Field2307) {
            return "_";
        }
        return "";
    }

    public void Method2150326(Font font, boolean bl, boolean bl2) {
        this.Field2308 = new CustomFont(font, bl, bl2);
    }

    public void Method2150327(Font font, boolean bl, boolean bl2) {
        this.Field2309 = new CustomFont(font, bl, bl2);
    }

    public float Method2150328(String string, float f, float f2, int n2) {
        return this.Field2308.Method2159779(string, f, f2, n2);
    }

    public float Method2150329(String string, float f, float f2, int n2) {
        return this.Field2309.Method2159770(string, f, f2, n2);
    }

    public int Method2150320(String string) {
        return this.Field2308.Method2159772(string);
    }

    public void Method2150331(String string, float f, float f2, int n2, float f3, boolean bl) {
        Color color = new Color(n2);
        float f4 = 1.0f / f3;
        String[] arrstring = string.split("\u00a7.");
        float f5 = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0];
        float f6 = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[1];
        float f7 = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[2];
        int n3 = 0;
        boolean bl2 = true;
        boolean bl3 = false;
        for (int j = 0; j < string.length(); ++j) {
            char c = string.charAt(j);
            char c2 = string.charAt(MathUtil.Method2163843(j + 1, 0, string.length() - 1));
            if ((String.valueOf(c) + c2).equals("\u00a7r")) {
                bl2 = false;
            } else if ((String.valueOf(c) + c2).equals("\u00a7+")) {
                bl2 = true;
            }
            if (bl3) {
                bl3 = false;
                continue;
            }
            if ((String.valueOf(c) + c2).equals("\u00a7r")) {
                String string2 = string.substring(j);
                TextManager.Field2811.fontRenderer.drawString(string2, f + (float) n3, f2, Color.WHITE.getRGB(), bl);
                break;
            }
            TextManager.Field2811.fontRenderer.drawString(String.valueOf(c).equals("\u00a7") ? "" : String.valueOf(c), f + (float) n3, f2, bl2 ? color.getRGB() : Color.WHITE.getRGB(), bl);
            if (String.valueOf(c).equals("\u00a7")) {
                bl3 = true;
            }
            n3 += TextManager.Field2811.fontRenderer.getStringWidth(String.valueOf(c));
            if (String.valueOf(c).equals(" ")) continue;
            color = new Color(Color.HSBtoRGB(f5, f6, f7));
            f5 += f4;
        }
    }
}

