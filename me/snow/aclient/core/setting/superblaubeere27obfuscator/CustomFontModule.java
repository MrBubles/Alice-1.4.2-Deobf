/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.GraphicsEnvironment;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CustomFontModule
        extends Module {
    private static CustomFontModule Field1258 = new CustomFontModule();
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1259 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("BetterFont", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None));
    public Setting<String> Field1260 = this.Method2150366(new Setting<String>("FontName", "Arial", "Name of the font."));
    public Setting<Integer> Field1261 = this.Method2150366(new Setting<Integer>("FontSize", Integer.valueOf(18), Integer.valueOf(12), Integer.valueOf(25), "Size of the font."));
    public Setting<Integer> Field1262 = this.Method2150366(new Setting<Integer>("FontStyle", Integer.valueOf(0), "Style of the font."));
    public Setting<Boolean> Field1263 = this.Method2150366(new Setting<Boolean>("AntiAlias", Boolean.TRUE, "Smoother font."));
    public Setting<Boolean> Field1264 = this.Method2150366(new Setting<Boolean>("Metrics", Boolean.TRUE, "Thinner font."));
    public Setting<Boolean> Field1265 = this.Method2150366(new Setting<Boolean>("Shadow", Boolean.FALSE, "Less shadow offset font."));
    public Setting<Boolean> Field1266 = this.Method2150366(new Setting<Boolean>("Fonts", Boolean.FALSE, "Shows all fonts."));
    public Setting<Boolean> Field1267 = this.Method2150366(new Setting<Boolean>("Full", false));
    private boolean Field1268;

    public CustomFontModule() {
        super("CustomFont", "CustomFont for all of the clients text. Use the font command.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150596();
    }

    public static CustomFontModule Method2150594() {
        if (Field1258 == null) {
            Field1258 = new CustomFontModule();
        }
        return Field1258;
    }

    public static boolean Method2150595(String string, boolean bl) {
        for (String string2 : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
            if (!bl && string2.equals(string)) {
                return true;
            }
            if (!bl) continue;
            Command.Method2159696(string2);
        }
        return false;
    }

    private void Method2150596() {
        Field1258 = this;
    }

    @SubscribeEvent
    public void Method2150597(ClientEvent clientEvent) {
        Setting setting;
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && (setting = clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll()) != null && setting.getFeature().equals(this)) {
            if (setting.getName().equals("FontName") && !CustomFontModule.Method2150595(setting.getPlannedValue().toString(), false)) {
                Command.Method2159696("\u00a7cThat font doesnt exist.");
                clientEvent.setCanceled(true);
                return;
            }
            this.Field1268 = true;
        }
    }

    @Override
    public void Method2150376() {
        if (this.Field1266.getValue().booleanValue()) {
            CustomFontModule.Method2150595("Hello", true);
            Command.Method2159696("Current Font: " + this.Field1260.getValue());
            this.Field1266.setValue(false);
        }
        if (this.Field1268) {
            AliceMain.Field766.Method2150316(false);
            this.Field1268 = false;
        }
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        None,
        LexendDeca,
        Comfortaa,
        ProductSans;

    }
}

