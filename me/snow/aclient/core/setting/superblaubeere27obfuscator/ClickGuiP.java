

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameSettings$Options
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClickGuiP
        extends Module {
    private static ClickGuiP Field3251 = new ClickGuiP();
    public Setting<Boolean> Field3252 = this.Method2150366(new Setting<Boolean>("Sync", false));
    public Setting<Boolean> Field3253 = this.Method2150366(new Setting<Boolean>("Outline", false));
    public Setting<Boolean> Field3254 = this.Method2150366(new Setting<Object>("RollingRainbow", Boolean.FALSE, this::Method2150582));
    public Setting<String> Field3255 = this.Method2150366(new Setting<String>("Prefix", ".").setRenderName(true));
    public Setting<Integer> Field3256 = this.Method2150366(new Setting<Integer>("Red", 255, 0, 255));
    public Setting<Integer> Field3257 = this.Method2150366(new Setting<Integer>("Green", 0, 0, 255));
    public Setting<Integer> Field3258 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    public Setting<Integer> Field3259 = this.Method2150366(new Setting<Integer>("Alpha", 180, 0, 255));
    public Setting<Integer> Field3260 = this.Method2150366(new Setting<Integer>("HoverAlpha", 240, 0, 255));
    public Setting<Boolean> Field3261 = this.Method2150366(new Setting<Boolean>("CustomFov", false));
    public Setting<Float> Field3262 = this.Method2150366(new Setting<Object>("Fov", Float.valueOf(150.0f), Float.valueOf(-180.0f), Float.valueOf(180.0f), this::Method2150581));
    public Setting<Boolean> Field3263 = this.Method2150366(new Setting<Boolean>("Open/Close", false));
    public Setting<String> Field3264 = this.Method2150366(new Setting<Object>("Open:", "", this::Method2150570).setRenderName(true));
    public Setting<String> Field3265 = this.Method2150366(new Setting<Object>("Close:", "", this::Method2150579).setRenderName(true));
    public Setting<String> Field3266 = this.Method2150366(new Setting<Object>("Buttons:", "", this::Method2150578).setRenderName(true));
    public Setting<Boolean> Field3267 = this.Method2150366(new Setting<Boolean>("DevSettings", false));
    public Setting<Integer> Field3268 = this.Method2150366(new Setting<Object>("TopRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150577));
    public Setting<Integer> Field3269 = this.Method2150366(new Setting<Object>("TopGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150576));
    public Setting<Integer> Field3270 = this.Method2150366(new Setting<Object>("TopBlue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150575));
    public Setting<Integer> Field3271 = this.Method2150366(new Setting<Object>("TopAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150574));

    public ClickGuiP() {
        super("PhobosGui", "Opens the ClickGui3", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150572();
    }

    public static ClickGuiP Method2150571() {
        if (Field3251 == null) {
            Field3251 = new ClickGuiP();
        }
        return Field3251;
    }

    private void Method2150572() {
        Field3251 = this;
    }

    @Override
    public void Method2150379() {
        if (this.Field3261.getValue().booleanValue()) {
            ClickGuiP.Field2811.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, this.Field3262.getValue().floatValue());
        }
    }

    @SubscribeEvent
    public void Method2150573(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature().equals(this)) {
            if (clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().equals(this.Field3255)) {
                AliceMain.Field761.Method2150115(this.Field3255.getPlannedValue());
                Command.Method2159696("Prefix set to \u00a7a" + AliceMain.Field761.Method2150114());
            }
            AliceMain.Field783.Method2159078(this.Field3256.getPlannedValue(), this.Field3257.getPlannedValue(), this.Field3258.getPlannedValue(), this.Field3259.getPlannedValue());
        }
    }

    @Override
    public void Method2150372() {
        Field2811.displayGuiScreen((GuiScreen) new PhobosGui());
    }

    @Override
    public void Method2150375() {
        if (this.Field3252.getValue().booleanValue()) {
            AliceMain.Field783.Method2159078(Colors.Field1782.Method2150586().getRed(), Colors.Field1782.Method2150586().getGreen(), Colors.Field1782.Method2150586().getBlue(), this.Field3259.getValue());
        } else {
            AliceMain.Field783.Method2159078(this.Field3256.getValue(), this.Field3257.getValue(), this.Field3258.getValue(), this.Field3259.getValue());
        }
        AliceMain.Field761.Method2150115(this.Field3255.getValue());
    }

    @Override
    public void Method2150376() {
        if (!(ClickGuiP.Field2811.currentScreen instanceof PhobosGui)) {
            this.Method2150380();
            if (ClickGuiP.Field2811.entityRenderer.getShaderGroup() != null) {
                ClickGuiP.Field2811.entityRenderer.getShaderGroup().deleteShaderGroup();
            }
        }
    }

    @Override
    public void Method2150373() {
        if (ClickGuiP.Field2811.currentScreen instanceof PhobosGui) {
            Field2811.displayGuiScreen(null);
        }
    }

    private boolean Method2150574(Object object) {
        return this.Field3267.getValue();
    }

    private boolean Method2150575(Object object) {
        return this.Field3267.getValue();
    }

    private boolean Method2150576(Object object) {
        return this.Field3267.getValue();
    }

    private boolean Method2150577(Object object) {
        return this.Field3267.getValue();
    }

    private boolean Method2150578(Object object) {
        return this.Field3263.getValue() == false;
    }

    private boolean Method2150579(Object object) {
        return this.Field3263.getValue();
    }

    private boolean Method2150570(Object object) {
        return this.Field3263.getValue();
    }

    private boolean Method2150581(Object object) {
        return this.Field3261.getValue();
    }

    private boolean Method2150582(Object object) {
        return this.Field3252.getValue() != false && Colors.Field1782.Field1783.getValue() != false;
    }
}

