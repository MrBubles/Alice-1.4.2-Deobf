

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomFontModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClickGui
        extends Module {
    private static ClickGui Field812 = new ClickGui();
    public Setting<String> Field813 = this.Method2150366(new Setting<String>("Prefix", ".").setRenderName(true));
    public Setting<Boolean> Field814 = this.Method2150366(new Setting<Boolean>("CSync", false));
    public Setting<Boolean> Field815 = this.Method2150366(new Setting<Boolean>("TopCSync", false));
    public Setting<Boolean> Field816 = this.Method2150366(new Setting<Object>("RollingRainbow", Boolean.valueOf(false), this::Method2150487));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field817 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Settings", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main));
    public Setting<Integer> Field818 = this.Method2150366(new Setting<Integer>("Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150486));
    public Setting<Integer> Field819 = this.Method2150366(new Setting<Integer>("Green", Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(255), this::Method2150485));
    public Setting<Integer> Field820 = this.Method2150366(new Setting<Integer>("Blue", Integer.valueOf(50), Integer.valueOf(0), Integer.valueOf(255), this::Method2150484));
    public Setting<Integer> Field821 = this.Method2150366(new Setting<Integer>("Alpha", Integer.valueOf(130), Integer.valueOf(0), Integer.valueOf(255), this::Method2150483));
    public Setting<Integer> Field822 = this.Method2150366(new Setting<Integer>("BackgroundRed", Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(255), this::Method2150482));
    public Setting<Integer> Field823 = this.Method2150366(new Setting<Integer>("BackgroundGreen", Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(255), this::Method2150481));
    public Setting<Integer> Field824 = this.Method2150366(new Setting<Integer>("BackgroundBlue", Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(255), this::Method2150470));
    public Setting<Integer> Field825 = this.Method2150366(new Setting<Object>("BackgroundAlpha", Integer.valueOf(130), Integer.valueOf(0), Integer.valueOf(255), this::Method2150479));
    public Setting<Integer> Field826 = this.Method2150366(new Setting<Object>("DisabledRed", Integer.valueOf(127), Integer.valueOf(0), Integer.valueOf(255), this::Method2150478));
    public Setting<Integer> Field827 = this.Method2150366(new Setting<Object>("DisabledGreen", Integer.valueOf(127), Integer.valueOf(0), Integer.valueOf(255), this::Method2150477));
    public Setting<Integer> Field828 = this.Method2150366(new Setting<Object>("DisabledBlue", Integer.valueOf(127), Integer.valueOf(0), Integer.valueOf(255), this::Method2150476));
    public Setting<Integer> Field829 = this.Method2150366(new Setting<Object>("DisabledAlpha", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150475));
    public Setting<Integer> Field830 = this.Method2150366(new Setting<Integer>("HoverAlpha", Integer.valueOf(240), Integer.valueOf(0), Integer.valueOf(255), this::Method2150474));
    public Setting<Integer> Field831 = this.Method2150366(new Setting<Object>("TopRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150473));
    public Setting<Integer> Field832 = this.Method2150366(new Setting<Object>("TopGreen", Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(255), this::Method2150472));
    public Setting<Integer> Field833 = this.Method2150366(new Setting<Object>("TopBlue", Integer.valueOf(50), Integer.valueOf(0), Integer.valueOf(255), this::Method2150471));
    public Setting<Integer> Field834 = this.Method2150366(new Setting<Object>("TopAlpha", Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(255), this::Method2150460));
    public Setting<Boolean> Field835 = this.Method2150366(new Setting<Boolean>("TitleCenter", Boolean.valueOf(false), this::Method2150469));
    public Setting<Boolean> Field836 = this.Method2150366(new Setting<Boolean>("Open/Close", Boolean.valueOf(false), this::Method2150468));
    public Setting<String> Field837 = this.Method2150366(new Setting<Object>("Open:", "+", this::Method2150467).setRenderName(true));
    public Setting<String> Field838 = this.Method2150366(new Setting<Object>("Close:", "-", this::Method2150466).setRenderName(true));
    public Setting<String> Field839 = this.Method2150366(new Setting<Object>("Buttons:", "", this::Method2150465).setRenderName(true));
    public Setting<Boolean> Field840 = this.Method2150366(new Setting<Object>("FutureGear", Boolean.valueOf(false), this::Method2150464));
    public Setting<Boolean> Field841 = this.Method2150366(new Setting<Object>("TopArrow", Boolean.valueOf(false), this::Method2150463));
    public Setting<Boolean> Field842 = this.Method2150366(new Setting<Boolean>("CustomFov", Boolean.valueOf(false), this::Method2150462));
    public Setting<Float> Field843 = this.Method2150366(new Setting<Object>("Fov", Float.valueOf(150.0f), Float.valueOf(-180.0f), Float.valueOf(180.0f), this::Method2150461));
    public Setting<Integer> Field844 = this.Method2150366(new Setting<Object>("StringGearRed", Integer.valueOf(160), Integer.valueOf(0), Integer.valueOf(255), this::Method2150450));
    public Setting<Integer> Field845 = this.Method2150366(new Setting<Object>("StringGearGreen", Integer.valueOf(160), Integer.valueOf(0), Integer.valueOf(255), this::Method2150459));
    public Setting<Integer> Field846 = this.Method2150366(new Setting<Object>("StringGearBlue", Integer.valueOf(160), Integer.valueOf(0), Integer.valueOf(255), this::Method2150458));
    public Setting<Boolean> Field847 = this.Method2150366(new Setting<Boolean>("SideSetting", Boolean.valueOf(false), this::Method2150457));
    public Setting<Integer> Field848 = this.Method2150366(new Setting<Integer>("SideRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150456));
    public Setting<Integer> Field849 = this.Method2150366(new Setting<Integer>("SideGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150455));
    public Setting<Integer> Field850 = this.Method2150366(new Setting<Integer>("SideBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150454));
    public Setting<Integer> Field851 = this.Method2150366(new Setting<Integer>("SideAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150453));
    public Setting<Boolean> Field852 = this.Method2150366(new Setting<Boolean>("FrameSetting", Boolean.valueOf(false), this::Method2150452));
    public Setting<Integer> Field853 = this.Method2150366(new Setting<Integer>("FrameRed", Integer.valueOf(160), Integer.valueOf(0), Integer.valueOf(255), this::Method2150451));
    public Setting<Integer> Field854 = this.Method2150366(new Setting<Integer>("FrameGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150440));
    public Setting<Integer> Field855 = this.Method2150366(new Setting<Integer>("FrameBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150449));
    public Setting<Integer> Field856 = this.Method2150366(new Setting<Integer>("FrameAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150448));
    public Setting<Boolean> Field857 = this.Method2150366(new Setting<Boolean>("OutlineOld", Boolean.valueOf(false), this::Method2150447));
    public Setting<Boolean> Field858 = this.Method2150366(new Setting<Object>("Outline2", Boolean.valueOf(false), this::Method2150446));
    public Setting<Float> Field859 = this.Method2150366(new Setting<Float>("LineThickness", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(5.0f), this::Method2150445));
    public Setting<Integer> Field860 = this.Method2150366(new Setting<Object>("OutlineRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150444));
    public Setting<Integer> Field861 = this.Method2150366(new Setting<Object>("OutlineGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150443));
    public Setting<Integer> Field862 = this.Method2150366(new Setting<Object>("OutlineBlue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150442));
    public Setting<Integer> Field863 = this.Method2150366(new Setting<Object>("OutlineAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150441));
    public Setting<Boolean> Field864 = this.Method2150366(new Setting<Boolean>("Module Outline", Boolean.valueOf(true), this::Method2150430));
    public Setting<Integer> Field865 = this.Method2150366(new Setting<Object>("Module OutlineRed", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150439));
    public Setting<Integer> Field866 = this.Method2150366(new Setting<Object>("Module OutlineGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150438));
    public Setting<Integer> Field867 = this.Method2150366(new Setting<Object>("Module OutlineBlue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150437));
    public Setting<Integer> Field868 = this.Method2150366(new Setting<Object>("Module OutlineAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150436));
    public Setting<Boolean> Field869 = this.Method2150366(new Setting<Object>("Snowing", Boolean.valueOf(false), this::Method2150435));
    public Setting<Boolean> Field870 = this.Method2150366(new Setting<Boolean>("BackGround Dark", Boolean.valueOf(false), this::Method2150434));
    public Setting<Boolean> Field871 = this.Method2150366(new Setting<Boolean>("Gradiant", Boolean.valueOf(false), this::Method2150433));
    public Setting<Integer> Field872 = this.Method2150366(new Setting<Object>("GradiantRed", Integer.valueOf(36), Integer.valueOf(0), Integer.valueOf(255), this::Method2150432));
    public Setting<Integer> Field873 = this.Method2150366(new Setting<Object>("GradiantGreen", Integer.valueOf(150), Integer.valueOf(0), Integer.valueOf(255), this::Method2150431));
    public Setting<Integer> Field874 = this.Method2150366(new Setting<Object>("GradiantBlue", Integer.valueOf(190), Integer.valueOf(0), Integer.valueOf(255), this::Method2150420));
    public Setting<Integer> Field875 = this.Method2150366(new Setting<Object>("GradiantAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150429));
    public Setting<Boolean> Field876 = this.Method2150366(new Setting<Object>("Particles", Boolean.valueOf(false), this::Method2150428));
    public Setting<Integer> Field877 = this.Method2150366(new Setting<Object>("ParticleLength", Integer.valueOf(150), Integer.valueOf(0), Integer.valueOf(300), this::Method2150427));
    public Setting<Integer> Field878 = this.Method2150366(new Setting<Object>("ParticleRed", Integer.valueOf(36), Integer.valueOf(0), Integer.valueOf(255), this::Method2150426));
    public Setting<Integer> Field879 = this.Method2150366(new Setting<Object>("ParticleGreen", Integer.valueOf(150), Integer.valueOf(0), Integer.valueOf(255), this::Method2150425));
    public Setting<Integer> Field880 = this.Method2150366(new Setting<Object>("ParticleBlue", Integer.valueOf(190), Integer.valueOf(0), Integer.valueOf(255), this::Method2150424));
    public Setting<Integer> Field881 = this.Method2150366(new Setting<Object>("EnabledTextRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150423));
    public Setting<Integer> Field882 = this.Method2150366(new Setting<Object>("EnabledTextGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150422));
    public Setting<Integer> Field883 = this.Method2150366(new Setting<Object>("EnabledTextBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150421));
    public Setting<Integer> Field884 = this.Method2150366(new Setting<Object>("EnabledTextAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150410));
    public Setting<Integer> Field885 = this.Method2150366(new Setting<Object>("DisabledTextRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150419));
    public Setting<Integer> Field886 = this.Method2150366(new Setting<Object>("DisabledTextGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150418));
    public Setting<Integer> Field887 = this.Method2150366(new Setting<Object>("DisabledTextBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150417));
    public Setting<Integer> Field888 = this.Method2150366(new Setting<Object>("DisabledTextAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150416));
    public Setting<Boolean> Field889 = this.Method2150366(new Setting<Boolean>("PresetRed", Boolean.valueOf(false), this::Method2150415));
    public Setting<Boolean> Field890 = this.Method2150366(new Setting<Boolean>("PresetBlack", Boolean.valueOf(false), this::Method2150414));
    public Setting<Boolean> Field891 = this.Method2150366(new Setting<Boolean>("PresetDefault", Boolean.valueOf(false), this::Method2150413));

    public ClickGui() {
        super("ClickGui", "Opens the ClickGui", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150411();
    }

    public static ClickGui Method2150300() {
        if (Field812 == null) {
            Field812 = new ClickGui();
        }
        return Field812;
    }

    private void Method2150411() {
        Field812 = this;
    }

    @Override
    public void Method2150379() {
        if (this.Field842.getValue().booleanValue()) {
            ClickGui.Field2811.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, this.Field843.getValue().floatValue());
        }
    }

    @SubscribeEvent
    public void Method2150412(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature().equals(this)) {
            if (clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().equals(this.Field813)) {
                AliceMain.Field761.Method2150115(this.Field813.getPlannedValue());
                Command.Method2159696("Prefix set to \u00a7a" + AliceMain.Field761.Method2150114());
            }
            AliceMain.Field767.Method2159042(this.Field818.getPlannedValue(), this.Field819.getPlannedValue(), this.Field820.getPlannedValue(), this.Field821.getPlannedValue());
        }
    }

    @Override
    public void Method2150372() {
        Util.Field2811.displayGuiScreen((GuiScreen) new LuigiGuiOld());
    }

    @Override
    public void Method2150375() {
        if (this.Field814.getValue().booleanValue()) {
            AliceMain.Field767.Method2159042(Colors.Field1782.Method2150586().getRed(), Colors.Field1782.Method2150586().getGreen(), Colors.Field1782.Method2150586().getBlue(), this.Field821.getValue());
        } else {
            AliceMain.Field767.Method2159042(this.Field818.getValue(), this.Field819.getValue(), this.Field820.getValue(), this.Field821.getValue());
        }
        AliceMain.Field761.Method2150115(this.Field813.getValue());
    }

    @Override
    public void Method2150376() {
        if (!(ClickGui.Field2811.currentScreen instanceof LuigiGuiOld)) {
            this.Method2150380();
        }
        if (this.Field889.getValue().booleanValue()) {
            this.Field814.setValue(false);
            this.Field815.setValue(false);
            this.Field818.setValue(225);
            this.Field819.setValue(0);
            this.Field820.setValue(0);
            this.Field821.setValue(130);
            this.Field822.setValue(0);
            this.Field823.setValue(0);
            this.Field824.setValue(0);
            this.Field825.setValue(85);
            this.Field826.setValue(0);
            this.Field827.setValue(0);
            this.Field828.setValue(0);
            this.Field829.setValue(31);
            this.Field830.setValue(240);
            this.Field831.setValue(255);
            this.Field832.setValue(0);
            this.Field833.setValue(0);
            this.Field834.setValue(100);
            this.Field835.setValue(true);
            this.Field836.setValue(false);
            this.Field837.setValue("+");
            this.Field838.setValue("-");
            this.Field839.setValue("");
            this.Field840.setValue(false);
            this.Field841.setValue(false);
            this.Field842.setValue(false);
            this.Field844.setValue(160);
            this.Field845.setValue(160);
            this.Field846.setValue(160);
            this.Field847.setValue(false);
            this.Field848.setValue(255);
            this.Field849.setValue(0);
            this.Field850.setValue(0);
            this.Field851.setValue(255);
            this.Field852.setValue(false);
            this.Field853.setValue(255);
            this.Field854.setValue(0);
            this.Field855.setValue(0);
            this.Field856.setValue(255);
            this.Field857.setValue(false);
            this.Field858.setValue(true);
            this.Field859.setValue(Float.valueOf(1.0f));
            this.Field860.setValue(255);
            this.Field861.setValue(0);
            this.Field862.setValue(0);
            this.Field863.setValue(255);
            this.Field864.setValue(false);
            this.Field865.setValue(0);
            this.Field866.setValue(0);
            this.Field867.setValue(0);
            this.Field868.setValue(255);
            this.Field869.setValue(true);
            this.Field870.setValue(false);
            this.Field871.setValue(true);
            this.Field872.setValue(255);
            this.Field873.setValue(0);
            this.Field874.setValue(0);
            this.Field875.setValue(255);
            this.Field876.setValue(true);
            this.Field877.setValue(86);
            this.Field878.setValue(255);
            this.Field879.setValue(0);
            this.Field880.setValue(0);
            this.Field881.setValue(255);
            this.Field882.setValue(255);
            this.Field883.setValue(255);
            this.Field884.setValue(255);
            this.Field885.setValue(255);
            this.Field886.setValue(255);
            this.Field887.setValue(255);
            this.Field888.setValue(255);
            if (CustomFontModule.Method2150594().Method2150387()) {
                CustomFontModule.Method2150594().Method2150389();
            }
            CustomFontModule.Method2150594().Field1260.setValue("Dialog");
            CustomFontModule.Method2150594().Field1261.setValue(18);
            CustomFontModule.Method2150594().Field1262.setValue(0);
            CustomFontModule.Method2150594().Field1263.setValue(true);
            CustomFontModule.Method2150594().Field1264.setValue(true);
            CustomFontModule.Method2150594().Field1265.setValue(false);
            this.Field889.setValue(false);
        }
        if (this.Field890.getValue().booleanValue()) {
            this.Field814.setValue(false);
            this.Field815.setValue(false);
            this.Field818.setValue(255);
            this.Field819.setValue(36);
            this.Field820.setValue(130);
            this.Field821.setValue(130);
            this.Field822.setValue(14);
            this.Field823.setValue(14);
            this.Field824.setValue(14);
            this.Field825.setValue(130);
            this.Field826.setValue(26);
            this.Field827.setValue(48);
            this.Field828.setValue(90);
            this.Field829.setValue(9);
            this.Field830.setValue(240);
            this.Field831.setValue(31);
            this.Field832.setValue(31);
            this.Field833.setValue(31);
            this.Field834.setValue(255);
            this.Field835.setValue(false);
            this.Field836.setValue(false);
            this.Field837.setValue("+");
            this.Field838.setValue("-");
            this.Field839.setValue("");
            this.Field840.setValue(false);
            this.Field841.setValue(false);
            this.Field842.setValue(false);
            this.Field844.setValue(255);
            this.Field845.setValue(255);
            this.Field846.setValue(255);
            this.Field847.setValue(false);
            this.Field848.setValue(255);
            this.Field849.setValue(0);
            this.Field850.setValue(0);
            this.Field851.setValue(255);
            this.Field852.setValue(false);
            this.Field853.setValue(255);
            this.Field854.setValue(0);
            this.Field855.setValue(0);
            this.Field856.setValue(255);
            this.Field857.setValue(false);
            this.Field858.setValue(false);
            this.Field859.setValue(Float.valueOf(1.0f));
            this.Field860.setValue(255);
            this.Field861.setValue(0);
            this.Field862.setValue(0);
            this.Field863.setValue(255);
            this.Field864.setValue(false);
            this.Field865.setValue(0);
            this.Field866.setValue(0);
            this.Field867.setValue(0);
            this.Field868.setValue(255);
            this.Field869.setValue(false);
            this.Field870.setValue(false);
            this.Field871.setValue(true);
            this.Field872.setValue(156);
            this.Field873.setValue(153);
            this.Field874.setValue(151);
            this.Field875.setValue(255);
            this.Field876.setValue(false);
            this.Field877.setValue(150);
            this.Field878.setValue(36);
            this.Field879.setValue(150);
            this.Field880.setValue(190);
            this.Field881.setValue(255);
            this.Field882.setValue(255);
            this.Field883.setValue(255);
            this.Field884.setValue(255);
            this.Field885.setValue(255);
            this.Field886.setValue(255);
            this.Field887.setValue(255);
            this.Field888.setValue(255);
            if (CustomFontModule.Method2150594().Method2150387()) {
                CustomFontModule.Method2150594().Method2150389();
            }
            CustomFontModule.Method2150594().Field1260.setValue("Tahoma");
            CustomFontModule.Method2150594().Field1261.setValue(18);
            CustomFontModule.Method2150594().Field1262.setValue(0);
            CustomFontModule.Method2150594().Field1263.setValue(true);
            CustomFontModule.Method2150594().Field1264.setValue(true);
            CustomFontModule.Method2150594().Field1265.setValue(false);
            this.Field890.setValue(false);
        }
        if (this.Field891.getValue().booleanValue()) {
            this.Field814.setValue(false);
            this.Field815.setValue(false);
            this.Field818.setValue(36);
            this.Field819.setValue(150);
            this.Field820.setValue(190);
            this.Field821.setValue(130);
            this.Field822.setValue(0);
            this.Field823.setValue(0);
            this.Field824.setValue(0);
            this.Field825.setValue(75);
            this.Field826.setValue(127);
            this.Field827.setValue(127);
            this.Field828.setValue(127);
            this.Field829.setValue(0);
            this.Field830.setValue(240);
            this.Field831.setValue(36);
            this.Field832.setValue(150);
            this.Field833.setValue(190);
            this.Field834.setValue(100);
            this.Field835.setValue(false);
            this.Field836.setValue(true);
            this.Field837.setValue("+");
            this.Field838.setValue("-");
            this.Field839.setValue("");
            this.Field840.setValue(false);
            this.Field841.setValue(false);
            this.Field842.setValue(false);
            this.Field844.setValue(160);
            this.Field845.setValue(160);
            this.Field846.setValue(160);
            this.Field847.setValue(false);
            this.Field848.setValue(255);
            this.Field849.setValue(255);
            this.Field850.setValue(255);
            this.Field851.setValue(255);
            this.Field852.setValue(false);
            this.Field853.setValue(160);
            this.Field854.setValue(255);
            this.Field855.setValue(255);
            this.Field856.setValue(255);
            this.Field857.setValue(false);
            this.Field858.setValue(false);
            this.Field859.setValue(Float.valueOf(1.0f));
            this.Field860.setValue(255);
            this.Field861.setValue(0);
            this.Field862.setValue(0);
            this.Field863.setValue(255);
            this.Field864.setValue(true);
            this.Field865.setValue(0);
            this.Field866.setValue(0);
            this.Field867.setValue(0);
            this.Field868.setValue(255);
            this.Field869.setValue(true);
            this.Field870.setValue(false);
            this.Field871.setValue(false);
            this.Field872.setValue(36);
            this.Field873.setValue(150);
            this.Field874.setValue(190);
            this.Field875.setValue(255);
            this.Field876.setValue(true);
            this.Field877.setValue(150);
            this.Field878.setValue(36);
            this.Field879.setValue(150);
            this.Field880.setValue(190);
            this.Field881.setValue(255);
            this.Field882.setValue(255);
            this.Field883.setValue(255);
            this.Field884.setValue(255);
            this.Field885.setValue(160);
            this.Field886.setValue(160);
            this.Field887.setValue(160);
            this.Field888.setValue(255);
            if (CustomFontModule.Method2150594().Method2150387()) {
                CustomFontModule.Method2150594().Method2150389();
            }
            CustomFontModule.Method2150594().Field1260.setValue("Arial");
            CustomFontModule.Method2150594().Field1261.setValue(18);
            CustomFontModule.Method2150594().Field1262.setValue(0);
            CustomFontModule.Method2150594().Field1263.setValue(true);
            CustomFontModule.Method2150594().Field1264.setValue(true);
            CustomFontModule.Method2150594().Field1265.setValue(false);
            this.Field891.setValue(false);
        }
    }

    @Override
    public void Method2150373() {
        if (ClickGui.Field2811.currentScreen instanceof LuigiGuiOld) {
            Util.Field2811.displayGuiScreen(null);
        }
    }

    private boolean Method2150413(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Preset;
    }

    private boolean Method2150414(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Preset;
    }

    private boolean Method2150415(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Preset;
    }

    private boolean Method2150416(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150417(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150418(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150419(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150410(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150421(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150422(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150423(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Text;
    }

    private boolean Method2150424(Object object) {
        return this.Field876.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150425(Object object) {
        return this.Field876.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150426(Object object) {
        return this.Field876.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150427(Object object) {
        return this.Field876.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150428(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150429(Object object) {
        return this.Field871.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150420(Object object) {
        return this.Field871.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150431(Object object) {
        return this.Field871.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150432(Object object) {
        return this.Field871.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150433(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150434(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150435(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BackGround;
    }

    private boolean Method2150436(Object object) {
        return this.Field864.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150437(Object object) {
        return this.Field864.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150438(Object object) {
        return this.Field864.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150439(Object object) {
        return this.Field864.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150430(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150441(Object object) {
        return this.Field858.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150442(Object object) {
        return this.Field858.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150443(Object object) {
        return this.Field858.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150444(Object object) {
        return this.Field858.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150445(Float f) {
        return this.Field858.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150446(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150447(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150448(Integer n2) {
        return this.Field852.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150449(Integer n2) {
        return this.Field852.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150440(Integer n2) {
        return this.Field852.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150451(Integer n2) {
        return this.Field852.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150452(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150453(Integer n2) {
        return this.Field847.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150454(Integer n2) {
        return this.Field847.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150455(Integer n2) {
        return this.Field847.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150456(Integer n2) {
        return this.Field847.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150457(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Line;
    }

    private boolean Method2150458(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150459(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150450(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150461(Object object) {
        return this.Field842.getValue() != false && this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150462(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150463(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150464(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150465(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc && this.Field836.getValue() == false;
    }

    private boolean Method2150466(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc && this.Field836.getValue() != false;
    }

    private boolean Method2150467(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc && this.Field836.getValue() != false;
    }

    private boolean Method2150468(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150469(Boolean bl) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Misc;
    }

    private boolean Method2150460(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150471(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150472(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150473(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150474(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150475(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150476(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150477(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150478(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150479(Object object) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150470(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150481(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150482(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150483(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150484(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150485(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150486(Integer n2) {
        return this.Field817.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Main;
    }

    private boolean Method2150487(Object object) {
        return this.Field814.getValue() != false && Colors.Field1782.Field1783.getValue() != false;
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
        Preset;

    }
}

