/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GLSLShaders;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Global
        extends Module {
    private static Global Field1119 = new Global();
    public Setting<Boolean> Field1120 = this.Method2150366(new Setting<Boolean>("MainMenuShader", true));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1121 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Random));
    public Setting<GLSLShaders> Field1122 = this.Method2150366(new Setting<GLSLShaders>("Shader", GLSLShaders.ICYFIRE));
    public Setting<Integer> Field1123 = this.Method2150366(new Setting<Integer>("FPS", 60, 5, 60));
    public Setting<String> Field1124 = this.Method2150366(new Setting<String>("Bracket", "["));
    public Setting<String> Field1125 = this.Method2150366(new Setting<String>("Bracket2", "]"));
    public Setting<String> Field1126 = this.Method2150366(new Setting<String>("Command", "Alice"));
    public Setting<Boolean> Field1127 = this.Method2150366(new Setting<Boolean>("RainbowPrefix", false));
    public Setting<Integer> Field1128 = this.Method2150366(new Setting<Integer>("RainbowPrefix-Saturation ", 255, 0, 255));
    public Setting<Integer> Field1129 = this.Method2150366(new Setting<Integer>("RainbowPrefix-Brightness ", 255, 0, 255));
    public Setting<Float> Field1130 = this.Method2150366(new Setting<Float>("RainbowPrefix-Factor ", Float.valueOf(100.0f), Float.valueOf(0.0f), Float.valueOf(200.0f)));
    public Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1131 = this.Method2150366(new Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("BColor", TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AQUA));
    public Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1132 = this.Method2150366(new Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("CColor", TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.AQUA));
    public Setting<Boolean> Field1133 = this.Method2150366(new Setting<Boolean>("Potions", true));
    public Setting<Integer> Field1134 = this.Method2150366(new Setting<Integer>("SeverTime", 500, 0, 1000));
    public Setting<Boolean> Field1135 = this.Method2150366(new Setting<Boolean>("SafetyPlayer", false));
    public Setting<Integer> Field1136 = this.Method2150366(new Setting<Integer>("SafetyCheck", 50, 1, 150));
    public Setting<Boolean> Field1137 = this.Method2150366(new Setting<Boolean>("1.13+", false));
    public Setting<Boolean> Field1138 = this.Method2150366(new Setting<Boolean>("TRadarInv", true));
    public Setting<Integer> Field1139 = this.Method2150366(new Setting<Integer>("BaritoneTimeOut", 5, 1, 20));
    public Setting<Integer> Field1140 = this.Method2150366(new Setting<Integer>("Delay", 240, 0, 600));
    public Setting<Float> Field1141 = this.Method2150366(new Setting<Float>("Brightness ", Float.valueOf(150.0f), Float.valueOf(1.0f), Float.valueOf(255.0f)));
    public Setting<Float> Field1142 = this.Method2150366(new Setting<Float>("Saturation", Float.valueOf(150.0f), Float.valueOf(1.0f), Float.valueOf(255.0f)));

    public Global() {
        super("Global", "ClientGlobal", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, false, false, true);
        this.Method2150599();
    }

    public static Global Method2150598() {
        if (Field1119 == null) {
            Field1119 = new Global();
        }
        return Field1119;
    }

    private void Method2150599() {
        Field1119 = this;
    }

    @Override
    public void Method2150375() {
        AliceMain.Field761.Method2150113(this.Method2150501());
    }

    @SubscribeEvent
    public void Method2150590(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() != null && this.equals(clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature())) {
            AliceMain.Field761.Method2150113(this.Method2150501());
        }
    }

    public String Method2150501() {
        if (this.Field1127.getPlannedValue().booleanValue()) {
            StringBuilder stringBuilder = new StringBuilder(this.Method2150503());
            stringBuilder.insert(0, "\u00a7+");
            stringBuilder.append("\u00a7r");
            return stringBuilder.toString();
        }
        return TextUtil.Method2164747(this.Field1124.getPlannedValue(), this.Field1131.getPlannedValue()) + TextUtil.Method2164747(this.Field1126.getPlannedValue(), this.Field1132.getPlannedValue()) + TextUtil.Method2164747(this.Field1125.getPlannedValue(), this.Field1131.getPlannedValue());
    }

    public String Method2150502() {
        StringBuilder stringBuilder = new StringBuilder(this.Method2150503());
        stringBuilder.insert(0, "\u00a7+");
        stringBuilder.append("\u00a7r");
        return stringBuilder.toString();
    }

    public String Method2150503() {
        return this.Field1124.getValue() + this.Field1126.getValue() + this.Field1125.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Random,
        Select;

    }
}

