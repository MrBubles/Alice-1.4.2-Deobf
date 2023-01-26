/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiEffect;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiHunger;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiVoid;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Aura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoArmor;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoTrap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Automine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Blocker;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BurrowESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChorusPredict;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Criticals;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomFontModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ESPModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityControl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ExtraTab;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FastUse;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleFillRewrite;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleFiller;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InstantMine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LogoutSpots;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MCF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NametagsA;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoEntityTrace;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoRotate;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoSlowDown;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Notifications;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.OffhandModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PopChams;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Portals;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentAutoXP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpeedRewrite;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Speedmine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Sprint;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Step;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Surround;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ToolTips;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Trails;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Trajectories;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Velocity;

public class AutoConfig
        extends Module {
    public static AutoConfig Field240;
    public Setting<Boolean> Field241 = this.Method2150366(new Setting<Boolean>("Japan-Config", Boolean.FALSE, ""));
    public Setting<Boolean> Field242 = this.Method2150366(new Setting<Boolean>("SemiStrict-Config", Boolean.FALSE, ""));
    public Setting<Boolean> Field243 = this.Method2150366(new Setting<Boolean>("Strict-Config", Boolean.FALSE, ""));

    public AutoConfig() {
        super("AutoConfig", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, true);
        Field240 = this;
    }

    public static AutoConfig Method2150304() {
        if (Field240 == null) {
            Field240 = new AutoConfig();
        }
        return Field240;
    }

    private void Method2150305() {
        Field240 = this;
    }

    @Override
    public void Method2150376() {
        if (this.Field241.getValue().booleanValue()) {
            this.Method2150306();
            Command.Method2159696((Object) ChatFormatting.GRAY + "<AutoConfig> set config for Japan [Aura,AutoCrystal,Criticals,Surround,HoleFiller,Speed,Step]");
            this.Field241.setValue(false);
        }
        if (this.Field242.getValue().booleanValue()) {
            this.Method2150307();
            Command.Method2159696((Object) ChatFormatting.GRAY + "<AutoConfig> set config for SemiStrict [Aura,AutoCrystal,Criticals,Surround,HoleFilleRewrite,Speed,Step,Speedmine]");
            this.Field242.setValue(false);
        }
        if (this.Field243.getValue().booleanValue()) {
            this.Method2150308();
            Command.Method2159696((Object) ChatFormatting.GRAY + "<AutoConfig> set config for Strict [Aura,AutoCrystal,Criticals,Surround,HoleFilleRewrite,Speed,Step,Speedmine]");
            this.Field243.setValue(false);
        }
    }

    public void Method2150306() {
        Aura.Method2150915();
        AliceAura.Method2150792();
        AliceMain.Field756.Method2150180(AutoArmor.class).Field694.setValue(true);
        AliceMain.Field756.Method2150180(AutoTrap.class).Field3980.setValue(false);
        Criticals.Method2161186();
        Surround.Method2161201();
        if (AliceMain.Field756.Method2150180(HoleFiller.class).Method2150365()) {
            AliceMain.Field756.Method2150180(HoleFiller.class).Method2150389();
        }
        HoleFiller.Method2161194();
        AliceMain.Field756.Method2150180(NoSlowDown.class).Field1590.setValue(false);
        SpeedRewrite.Method2162132();
        Step.Method2162149();
        if (AliceMain.Field756.Method2150180(Speedmine.class).Method2150364()) {
            AliceMain.Field756.Method2150180(Speedmine.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(InstantMine.class).Method2150365()) {
            AliceMain.Field756.Method2150180(InstantMine.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Automine.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Automine.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Blocker.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Blocker.class).Method2150389();
        }
    }

    public void Method2150307() {
        Aura.Method2150915();
        AliceAura.Method2150794();
        AliceMain.Field756.Method2150180(AutoArmor.class).Field694.setValue(true);
        AliceMain.Field756.Method2150180(AutoTrap.class).Field3980.setValue(false);
        Criticals.Method2161186();
        Surround.Method2161290();
        HoleFillRewrite.Method2161104();
        AliceMain.Field756.Method2150180(NoSlowDown.class).Field1590.setValue(false);
        SpeedRewrite.Method2162132();
        Step.Method2162147();
        Speedmine.Method2162201();
        if (AliceMain.Field756.Method2150180(InstantMine.class).Method2150364()) {
            AliceMain.Field756.Method2150180(InstantMine.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(Automine.class).Method2150364()) {
            AliceMain.Field756.Method2150180(Automine.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(Blocker.class).Method2150364()) {
            AliceMain.Field756.Method2150180(Blocker.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(Speedmine.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Speedmine.class).Method2150389();
        }
    }

    public void Method2150308() {
        Aura.Method2150915();
        AliceAura.Method2150793();
        AliceMain.Field756.Method2150180(AutoArmor.class).Field694.setValue(false);
        AliceMain.Field756.Method2150180(AutoTrap.class).Field3980.setValue(true);
        Criticals.Method2161187();
        Surround.Method2161299();
        HoleFillRewrite.Method2161104();
        AliceMain.Field756.Method2150180(NoSlowDown.class).Field1590.setValue(true);
        SpeedRewrite.Method2162133();
        Step.Method2162148();
        Speedmine.Method2162202();
        if (AliceMain.Field756.Method2150180(InstantMine.class).Method2150364()) {
            AliceMain.Field756.Method2150180(InstantMine.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(Automine.class).Method2150364()) {
            AliceMain.Field756.Method2150180(Automine.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(Blocker.class).Method2150364()) {
            AliceMain.Field756.Method2150180(Blocker.class).Method2150380();
        }
        if (AliceMain.Field756.Method2150180(Speedmine.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Speedmine.class).Method2150389();
        }
    }

    public void Method2150309() {
        if (AliceMain.Field756.Method2150180(AutoArmor.class).Method2150365()) {
            AliceMain.Field756.Method2150180(AutoArmor.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(OffhandModule.class).Method2150365()) {
            AliceMain.Field756.Method2150180(OffhandModule.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Criticals.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Criticals.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Aura.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Aura.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(AntiEffect.class).Method2150365()) {
            AliceMain.Field756.Method2150180(AntiEffect.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(ExtraTab.class).Method2150365()) {
            AliceMain.Field756.Method2150180(ExtraTab.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(MCF.class).Method2150365()) {
            AliceMain.Field756.Method2150180(MCF.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Portals.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Portals.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(ToolTips.class).Method2150365()) {
            AliceMain.Field756.Method2150180(ToolTips.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(ESPModule.class).Method2150365()) {
            AliceMain.Field756.Method2150180(ESPModule.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(BurrowESP.class).Method2150365()) {
            AliceMain.Field756.Method2150180(BurrowESP.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(ChorusPredict.class).Method2150365()) {
            AliceMain.Field756.Method2150180(ChorusPredict.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(HoleESP.class).Method2150365()) {
            AliceMain.Field756.Method2150180(HoleESP.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(LogoutSpots.class).Method2150365()) {
            AliceMain.Field756.Method2150180(LogoutSpots.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(NametagsA.class).Method2150365()) {
            AliceMain.Field756.Method2150180(NametagsA.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(PopChams.class).Method2150365()) {
            AliceMain.Field756.Method2150180(PopChams.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Trails.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Trails.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Trajectories.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Trajectories.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(AntiVoid.class).Method2150365()) {
            AliceMain.Field756.Method2150180(AntiVoid.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(EntityControl.class).Method2150365()) {
            AliceMain.Field756.Method2150180(EntityControl.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(NoSlowDown.class).Method2150365()) {
            AliceMain.Field756.Method2150180(NoSlowDown.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Sprint.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Sprint.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Velocity.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Velocity.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(AntiHunger.class).Method2150365()) {
            AliceMain.Field756.Method2150180(AntiHunger.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(FastUse.class).Method2150365()) {
            AliceMain.Field756.Method2150180(FastUse.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(NoEntityTrace.class).Method2150365()) {
            AliceMain.Field756.Method2150180(NoEntityTrace.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(NoRotate.class).Method2150365()) {
            AliceMain.Field756.Method2150180(NoRotate.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(SilentAutoXP.class).Method2150365()) {
            AliceMain.Field756.Method2150180(SilentAutoXP.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Colors.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Colors.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(CustomFontModule.class).Method2150365()) {
            AliceMain.Field756.Method2150180(CustomFontModule.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Global.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Global.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(HUD.class).Method2150365()) {
            AliceMain.Field756.Method2150180(HUD.class).Method2150389();
        }
        if (AliceMain.Field756.Method2150180(Notifications.class).Method2150365()) {
            AliceMain.Field756.Method2150180(Notifications.class).Method2150389();
        }
    }
}

