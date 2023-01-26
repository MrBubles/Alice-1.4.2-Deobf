/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.Mod$Instance
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.opengl.Display
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClassManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorManager2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorManager3;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorManagerF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CommandManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ConfigManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DiscordPresence;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventBus;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventManager1;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FileManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FriendManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GLSLSandboxShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryManagerCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoStopManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NotificationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhysicsManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PositionManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PotionManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RPC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ReloadManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SafetyManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ServerManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpeedManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TimerManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TotemPopManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.VectorUtils;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.WaypointManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = "alice", name = "Alice", version = "1.4.2")
public class AliceMain {
    public static final String Field742 = "alice";
    public static final String Field743 = "Alice";
    public static final String Field744 = "1.4.2";
    public static final Logger Field745 = LogManager.getLogger((String) "Alice");
    public static final String Field746 = " \u23d0 3\u1d00\u0280\u1d1b\u029c\u029c4\u1d04\u1d0b";
    public static final String Field747 = " \u23d0 \u1d18\u029c\u1d0f\u0299\u1d0f\ua731";
    public static final String Field748 = " \u23d0 \u1d21\u1d07\u1d00\u1d1b\u029c\u1d07\u0280 \u2764 \u2744";
    public static final String Field749 = " \u23d0 \u029f\u1d1c\u026a\u0262\u026a\u029c\u1d00\u1d04\u1d0b \u0e05\u2022\u03c9\u2022\u0e05 meow";
    public static final String Field750 = " \u23d0 \u029f\u1d1c\u026a\u0262\u026a\u029c\u1d00\u1d04\u1d0b+ \u262a";
    public static final String Field751 = " \u30c4 \u2c98\u03c5\u2a0d\u2a0d\u2aef\ufb21";
    public static final String Field752 = " \u1d00\u029f\u026a\u1d04\u1d07 \u269b 1.4.2";
    public static final String Field753 = " | Alice";
    public static GLSLSandboxShader Field754;
    public static long Field755;
    public static ModuleManager Field756;
    public static SpeedManager Field757;
    public static PositionManager Field758;
    public static EventBus Field759;
    public static RotationManager Field760;
    public static CommandManager Field761;
    public static EventManager1 Field762;
    public static ConfigManager Field763;
    public static FileManager Field764;
    public static FriendManager Field765;
    public static TextManager Field766;
    public static ColorManager Field767;
    public static ServerManager Field768;
    public static PotionManager Field769;
    public static InventoryManager Field770;
    public static TimerManager Field771;
    public static PacketManager Field772;
    public static ReloadManager Field773;
    public static TotemPopManager Field774;
    public static HoleManager Field775;
    public static NotificationManager Field776;
    public static SafetyManager Field777;
    public static PlayerManager Field778;
    public static NoStopManager Field779;
    public static WaypointManager Field780;
    public static InventoryManagerCC Field781;
    public static VectorUtils Field782;
    public static ColorManager3 Field783;
    public static PhysicsManager Field784;
    public static ColorManagerF Field785;
    public static ColorManager2 Field786;
    @Mod.Instance
    public static AliceMain Field787;
    private static boolean Field788;

    static {
        Field788 = false;
    }

    private final Image Field739 = Toolkit.getDefaultToolkit().getImage("resources/LuigiA.png");
    private final TrayIcon Field740 = new TrayIcon(this.Field739, "Alice");
    public SystemTray Field741 = SystemTray.getSystemTray();

    public static void Method2159686() {
        Field745.info("\n\nLoading Alice");
        Field788 = false;
        if (Field773 != null) {
            Field773.Method2150274();
            Field773 = null;
        }
        Field759 = new EventManager();
        Field779 = new NoStopManager();
        Field774 = new TotemPopManager();
        Field771 = new TimerManager();
        Field772 = new PacketManager();
        Field768 = new ServerManager();
        Field767 = new ColorManager();
        Field783 = new ColorManager3();
        Field784 = new PhysicsManager();
        Field766 = new TextManager();
        Field756 = new ModuleManager();
        Field757 = new SpeedManager();
        Field760 = new RotationManager();
        Field758 = new PositionManager();
        Field761 = new CommandManager();
        Field762 = new EventManager1();
        Field778 = new PlayerManager();
        Field763 = new ConfigManager();
        Field764 = new FileManager();
        Field765 = new FriendManager();
        Field769 = new PotionManager();
        Field770 = new InventoryManager();
        Field775 = new HoleManager();
        Field781 = new InventoryManagerCC();
        Field776 = new NotificationManager();
        Field777 = new SafetyManager();
        Field780 = new WaypointManager();
        Field782 = new VectorUtils();
        Field785 = new ColorManagerF();
        Field786 = new ColorManager2();
        Field745.info("Initialized Management");
        Field756.Method2150188();
        Field745.info("Modules loaded.");
        Field763.Method2150124();
        Field762.Method2150120();
        Field745.info("EventManager loaded.");
        Field766.Method2150316(true);
        Field756.Method2150101();
        Field774.Method2150339();
        if (Field756.Method2150180(RPC.class).Method2150364()) {
            DiscordPresence.Method2159022();
        }
        Field745.info("Alice initialized!\n");
    }

    public static void Method2159687(boolean bl) {
        Field745.info("\n\nUnloading Alice 1.0.0");
        if (bl) {
            Field773 = new ReloadManager();
            Field773.Method2150273(Field761 != null ? Field761.Method2150114() : ".");
        }
        if (Field779 != null) {
            Field779.Method2150225();
        }
        AliceMain.Method2159689();
        Field762 = null;
        Field775 = null;
        Field759 = null;
        Field771 = null;
        Field756 = null;
        Field774 = null;
        Field768 = null;
        Field767 = null;
        Field783 = null;
        Field766 = null;
        Field784 = null;
        Field757 = null;
        Field760 = null;
        Field781 = null;
        Field758 = null;
        Field761 = null;
        Field763 = null;
        Field764 = null;
        Field765 = null;
        Field769 = null;
        Field770 = null;
        Field776 = null;
        Field777 = null;
        Field782 = null;
        Field785 = null;
        Field786 = null;
        Field745.info("Alice unloaded!\n");
    }

    public static void Method2159688() {
        AliceMain.Method2159687(false);
        AliceMain.Method2159686();
    }

    public static void Method2159689() {
        if (!Field788) {
            Field762.Method2150131();
            Field756.Method2150100();
            Field763.Method2150119(AliceMain.Field763.Field4362.replaceFirst("Alice/", ""));
            Field756.Method2150211();
            Field771.Method2150332();
            Field788 = true;
        }
    }

    public static String Method2159680() {
        return Field744;
    }

    @Mod.EventHandler
    public void Method2159691(FMLPreInitializationEvent fMLPreInitializationEvent) {
        new ClassManager();
        this.Field740.setImageAutoSize(true);
        this.Field740.setToolTip("Welcome Thanks for using Alice:3");
        try {
            this.Field741.add(this.Field740);
        } catch (AWTException aWTException) {
            aWTException.printStackTrace();
        }
        this.Field740.displayMessage("Welcome", "Welcome Thanks for using Alice :3", TrayIcon.MessageType.NONE);
        AliceAura.Method2150780();
        Field745.info("TextRender loaded.");
    }

    @Mod.EventHandler
    public void Method2159692(FMLInitializationEvent fMLInitializationEvent) {
        Display.setTitle((String) "LuigiHack / Alice - 1.4.2 | https://discord.gg/EtTGvzt3nS");
        AliceMain.Method2159686();
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends JFrame {
        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
            this.setTitle("Black list");
            this.setDefaultCloseOperation(2);
            this.setLocationRelativeTo(null);
            String string = "Sorry, You are on Blacklist :D";
            JOptionPane.showMessageDialog(this, string, "Bakaaaaaaaaa", -1, UIManager.getIcon("OptionPane.errorIcon"));
        }
    }
}

