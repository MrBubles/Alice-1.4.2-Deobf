

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClickGuiF
        extends Module {
    private static ClickGuiF Field3241 = new ClickGuiF();
    public Setting<Boolean> Field3242 = this.Method2150366(new Setting<Boolean>("Sync", false));
    public Setting<Integer> Field3243 = this.Method2150366(new Setting<Integer>("Red", 160, 0, 255));
    public Setting<Integer> Field3244 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    public Setting<Integer> Field3245 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    public Setting<Integer> Field3246 = this.Method2150366(new Setting<Integer>("Alpha", 130, 0, 255));
    public Setting<Integer> Field3247 = this.Method2150366(new Setting<Integer>("HoverAlpha", 240, 0, 255));

    public ClickGuiF() {
        super("ExeterGui", "Opens the ClickGuiF", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150569();
    }

    public static ClickGuiF Method2150568() {
        if (Field3241 == null) {
            Field3241 = new ClickGuiF();
        }
        return Field3241;
    }

    private void Method2150569() {
        Field3241 = this;
    }

    @SubscribeEvent
    public void Method2150560(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature().equals(this)) {
            AliceMain.Field785.Method2159002(this.Field3243.getPlannedValue(), this.Field3244.getPlannedValue(), this.Field3245.getPlannedValue(), this.Field3246.getPlannedValue());
        }
    }

    @Override
    public void Method2150372() {
        Util.Field2811.displayGuiScreen((GuiScreen) new FutureGui());
    }

    @Override
    public void Method2150375() {
        if (this.Field3242.getValue().booleanValue()) {
            AliceMain.Field785.Method2159002(Colors.Field1782.Method2150586().getRed(), Colors.Field1782.Method2150586().getGreen(), Colors.Field1782.Method2150586().getBlue(), this.Field3246.getValue());
        } else {
            AliceMain.Field785.Method2159002(this.Field3243.getValue(), this.Field3244.getValue(), this.Field3245.getValue(), this.Field3246.getValue());
        }
    }

    @Override
    public void Method2150376() {
        if (!(ClickGuiF.Field2811.currentScreen instanceof FutureGui)) {
            this.Method2150380();
        }
    }

    @Override
    public void Method2150373() {
        if (ClickGuiF.Field2811.currentScreen instanceof FutureGui) {
            Util.Field2811.displayGuiScreen(null);
        }
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        Static,
        Sideway;

    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        Static,
        Up;

    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Main,
        Misc,
        Line,
        BackGround,
        Text,
        TEST;

    }
}

