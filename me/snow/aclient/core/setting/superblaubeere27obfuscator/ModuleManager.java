

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderHandEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.EventBus
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AirStrafe;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Ambience;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Anchor;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Announcer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiAFK;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiCity;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiEffect;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiExploits;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiHunger;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AntiVoid;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Aura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoArmor;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoBuilder;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoConfig;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoEat;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoFrameDupe;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoGG;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoLog;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoMountModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoObsidian;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoPorn;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoReconnect;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoRespawn;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoTrap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoWalk;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoWither;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Automine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BedAura1;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Blink;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockTweaks;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Blocker;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BoatFly;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BowAim;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BowMcBomb;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BowSpam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BreadCrumbs;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BuildHeight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BurrowESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BypassModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CevBreaker;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChamsOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChatModifier;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChestSwap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChorusControl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChorusLag;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChorusPredict;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGuiP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Crasher;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Criticals;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Crosshair;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalChams;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CsgoESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomEnchants;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CustomFontModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ESPModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ElytraFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityControl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityDeSync;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntitySpeed;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventCPacket;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventNoStack;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ExtraTab;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FakePlayer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FastFall;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FastSwim;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FastUse;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Flight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Fullbright;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Ghost;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GroundSpeed;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HeadCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleFillRewrite;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleFiller;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleSnap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HudComponents;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IceSpeed;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InstantBurrow;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InstantMine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemChams;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemPhysics;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemViewModel;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Jesus;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.KillEffect;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LiquidInteract;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Logger;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LogoutSpots;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LongJump;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MCF;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MCP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Media;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MobOwner;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleTools;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MultiTask;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NametagsA;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NewChunks;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NewNotification;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoBreakAnimation;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoEntityTrace;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoFall;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoGlitchBlocks;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoHandShake;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoInteractModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoPacketKick;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoRender;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoRotate;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoSlowDown;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoSoundLag;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoWeatherModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoteBot;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Notifications;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Nuker;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.OffhandModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.OffscreenESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketCanceller;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhaseWalk;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PingSpoof;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PistonCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PistonPush;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PluginsGrabber;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PopChams;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Portals;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Quiver;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RPC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Radar;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Reach;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Replenish;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SafeWalk;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Safety;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Scaffold;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SelfAnvil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SelfTrap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Shaders;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentAutoXP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Skeleton;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SkyColor;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpammerModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpawnsESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpeedRewrite;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Speedmine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Sprint;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StashLogger;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Step;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StopWatchModule;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StorageESP;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.StreamerMode;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Surround;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Swing;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TargetHud;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TickShift;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TimerSpeed;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ToolTips;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TotemPopCounter;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TpsSync;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Tracers;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Tracker;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Trails;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Trajectories;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TrapPhase;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TrueDurability;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.VanillaClip;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.VanillaSpeed;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Velocity;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ViewClip;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.WebFill;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.XCarry;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.YawPitchLock;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import org.lwjgl.input.Keyboard;

public class ModuleManager
        extends Feature {
    public static ArrayList<Module> Field3969 = new ArrayList();
    public static String Field3973 = "htt";
    public List<Module> Field3970 = new ArrayList<Module>();
    public List<Module> Field3971 = new ArrayList<Module>();
    public Map<Module, Color> Field3972 = new HashMap<Module, Color>();

    public static Module Method2150189(String string) {
        for (Module module : Field3969) {
            if (!module.Method2150361().equalsIgnoreCase(string)) continue;
            return module;
        }
        return null;
    }

    public static void Method2150214() {
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
        iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.setVisible(false);
        throw new EventNoStack("You are on Blacklist");
    }

    public static List<String> Method2150215() {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String string;
            URL uRL = new URL("https://pastebin.com/raw/KEYsHwEu");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
        } catch (Exception exception) {
            // empty catch block
        }
        return arrayList;
    }

    private static void Method2150216(int n2, Module module) {
        if (module.Method2150390().getKey() == n2) {
            module.Method2150391();
        }
    }

    private static void Method2150218(Render3DEvent render3DEvent, Module module) {
        module.Method2150381(render3DEvent);
    }

    private static void Method2150219(Render2DEvent render2DEvent, Module module) {
        module.Method2150370(render2DEvent);
    }

    private static void Method2150210(Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, ArrayList arrayList, Module module) {
        if (module.Method2150398() == iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
            arrayList.add(module);
        }
    }

    private static void Method2150221(RenderHandEvent renderHandEvent, Module module) {
        module.Method2150371(renderHandEvent);
    }

    public void Method2150187(RenderHandEvent renderHandEvent) {
        Field3969.stream().filter(Feature::Method2150364).forEach(arg_0 -> ModuleManager.Method2150221(renderHandEvent, arg_0));
    }

    public void Method2150188() {
        Field3969.add(new ExtraTab());
        Field3969.add(new AutoTrap());
        Field3969.add(new PistonPush());
        Field3969.add(new NoFall());
        Field3969.add(new AutoObsidian());
        Field3969.add(new AutoMountModule());
        Field3969.add(new BypassModule());
        Field3969.add(new StopWatchModule());
        Field3969.add(new AutoConfig());
        Field3969.add(new HoleSnap());
        Field3969.add(new Replenish());
        Field3969.add(new AutoPorn());
        Field3969.add(new EntityESP());
        Field3969.add(new HoleESP());
        Field3969.add(new ClickGui2());
        Field3969.add(new BedAura1());
        Field3969.add(new ClickGuiF());
        Field3969.add(new ClickGuiP());
        Field3969.add(new NoWeatherModule());
        Field3969.add(new NewChunks());
        Field3969.add(new Scaffold());
        Field3969.add(new AirStrafe());
        Field3969.add(new Crasher());
        Field3969.add(new AutoBuilder());
        Field3969.add(new MobOwner());
        Field3969.add(new ItemChams());
        Field3969.add(new AutoGG());
        Field3969.add(new InstantMine());
        Field3969.add(new OffhandModule());
        Field3969.add(new SpawnsESP());
        Field3969.add(new AutoWither());
        Field3969.add(new OffscreenESP());
        Field3969.add(new Ambience());
        Field3969.add(new Tracers());
        Field3969.add(new CustomEnchants());
        Field3969.add(new Trails());
        Field3969.add(new Trajectories());
        Field3969.add(new SafeWalk());
        Field3969.add(new BowAim());
        Field3969.add(new Radar());
        Field3969.add(new TargetHud());
        Field3969.add(new NewNotification());
        Field3969.add(new VanillaClip());
        Field3969.add(new Jesus());
        Field3969.add(new ElytraFlight());
        Field3969.add(new BoatFly());
        Field3969.add(new Surround());
        Field3969.add(new LongJump());
        Field3969.add(new HoleFillRewrite());
        Field3969.add(new AliceAura());
        Field3969.add(new Portals());
        Field3969.add(new NoInteractModule());
        Field3969.add(new Announcer());
        Field3969.add(new PacketFlight());
        Field3969.add(new NoPacketKick());
        Field3969.add(new NoBreakAnimation());
        Field3969.add(new EntitySpeed());
        Field3969.add(new Speedmine());
        Field3969.add(new Blocker());
        Field3969.add(new Shaders());
        Field3969.add(new SpeedRewrite());
        Field3969.add(new AntiEffect());
        Field3969.add(new ModuleTools());
        Field3969.add(new PopChams());
        Field3969.add(new Skeleton());
        Field3969.add(new CsgoESP());
        Field3969.add(new AntiAFK());
        Field3969.add(new StorageESP());
        Field3969.add(new FastSwim());
        Field3969.add(new FastFall());
        Field3969.add(new FastUse());
        Field3969.add(new Ghost());
        Field3969.add(new TimerSpeed());
        Field3969.add(new Quiver());
        Field3969.add(new ItemPhysics());
        Field3969.add(new TickShift());
        Field3969.add(new AutoFrameDupe());
        Field3969.add(new EntityDeSync());
        Field3969.add(new AntiExploits());
        Field3969.add(new TrapPhase());
        Field3969.add(new NoRotate());
        Field3969.add(new StashLogger());
        Field3969.add(new Crosshair());
        Field3969.add(new PacketCanceller());
        Field3969.add(new AutoEat());
        Field3969.add(new BreadCrumbs());
        Field3969.add(new Nuker());
        Field3969.add(new AntiHunger());
        Field3969.add(new YawPitchLock());
        Field3969.add(new AutoWalk());
        Field3969.add(new Swing());
        Field3969.add(new TotemPopCounter());
        Field3969.add(new Logger());
        Field3969.add(new ChorusControl());
        Field3969.add(new NoGlitchBlocks());
        Field3969.add(new Automine());
        Field3969.add(new NoteBot());
        Field3969.add(new InstantBurrow());
        Field3969.add(new BowMcBomb());
        Field3969.add(new KillEffect());
        Field3969.add(new AntiCity());
        Field3969.add(new PhaseWalk());
        Field3969.add(new BowSpam());
        Field3969.add(new CevBreaker());
        Field3969.add(new ChorusPredict());
        Field3969.add(new AntiVoid());
        Field3969.add(new PingSpoof());
        Field3969.add(new BuildHeight());
        Field3969.add(new ChamsOld());
        Field3969.add(new ChestSwap());
        Field3969.add(new Safety());
        Field3969.add(new WebFill());
        Field3969.add(new SpammerModule());
        Field3969.add(new HeadCrystal());
        Field3969.add(new FakePlayer());
        Field3969.add(new PistonCrystal());
        Field3969.add(new SilentAutoXP());
        Field3969.add(new PluginsGrabber());
        Field3969.add(new ChorusLag());
        Field3969.add(new HoleFiller());
        Field3969.add(new ItemViewModel());
        Field3969.add(new AutoCrystal());
        Field3969.add(new Criticals());
        Field3969.add(new Aura());
        Field3969.add(new SelfTrap());
        Field3969.add(new AutoArmor());
        Field3969.add(new ChatModifier());
        Field3969.add(new NoHandShake());
        Field3969.add(new AutoRespawn());
        Field3969.add(new MCF());
        Field3969.add(new NoSoundLag());
        Field3969.add(new AutoLog());
        Field3969.add(new AutoReconnect());
        Field3969.add(new Tracker());
        Field3969.add(new RPC());
        Field3969.add(new EntityControl());
        Field3969.add(new Velocity());
        Field3969.add(new GroundSpeed());
        Field3969.add(new Step());
        Field3969.add(new Sprint());
        Field3969.add(new Flight());
        Field3969.add(new NoSlowDown());
        Field3969.add(new IceSpeed());
        Field3969.add(new VanillaSpeed());
        Field3969.add(new Reach());
        Field3969.add(new LiquidInteract());
        Field3969.add(new Freecam());
        Field3969.add(new Blink());
        Field3969.add(new MultiTask());
        Field3969.add(new BlockTweaks());
        Field3969.add(new XCarry());
        Field3969.add(new TpsSync());
        Field3969.add(new MCP());
        Field3969.add(new TrueDurability());
        Field3969.add(new NoRender());
        Field3969.add(new Fullbright());
        Field3969.add(new ViewClip());
        Field3969.add(new ESPModule());
        Field3969.add(new LogoutSpots());
        Field3969.add(new CrystalChams());
        Field3969.add(new Notifications());
        Field3969.add(new HUD());
        Field3969.add(new ToolTips());
        Field3969.add(new CustomFontModule());
        Field3969.add(new ClickGui());
        Field3969.add(new Global());
        Field3969.add(new HudComponents());
        Field3969.add(new StreamerMode());
        Field3969.add(new Colors());
        Field3969.add(new Media());
        Field3969.add(new NametagsA());
        Field3969.add(new Anchor());
        Field3969.add(new SelfAnvil());
        Field3969.add(new BurrowESP());
        Field3969.add(new SkyColor());
        Field3969.add(new NoEntityTrace());
        this.Field3972.put(this.Method2150180(AntiCity.class), new Color(90, 227, 96));
        this.Field3972.put(this.Method2150180(BedAura1.class), new Color(114, 75, 175));
        this.Field3972.put(this.Method2150180(OffhandModule.class), new Color(162, 187, 125));
        this.Field3972.put(this.Method2150180(HoleFiller.class), new Color(118, 57, 145));
        this.Field3972.put(this.Method2150180(AutoArmor.class), new Color(74, 227, 206));
        this.Field3972.put(this.Method2150180(AliceAura.class), new Color(255, 15, 43));
        this.Field3972.put(this.Method2150180(AutoCrystal.class), new Color(255, 15, 43));
        this.Field3972.put(this.Method2150180(AutoTrap.class), new Color(193, 49, 244));
        this.Field3972.put(this.Method2150180(Blocker.class), new Color(35, 92, 40));
        this.Field3972.put(this.Method2150180(BowAim.class), new Color(198, 184, 146));
        this.Field3972.put(this.Method2150180(BowSpam.class), new Color(204, 191, 153));
        this.Field3972.put(this.Method2150180(CevBreaker.class), new Color(42, 88, 109));
        this.Field3972.put(this.Method2150180(Criticals.class), new Color(173, 218, 156));
        this.Field3972.put(this.Method2150180(PistonPush.class), new Color(42, 88, 109));
        this.Field3972.put(this.Method2150180(HeadCrystal.class), new Color(52, 60, 92));
        this.Field3972.put(this.Method2150180(HoleFillRewrite.class), new Color(166, 55, 110));
        this.Field3972.put(this.Method2150180(Aura.class), new Color(255, 37, 0));
        this.Field3972.put(this.Method2150180(PistonCrystal.class), new Color(200, 124, 111));
        this.Field3972.put(this.Method2150180(Quiver.class), new Color(118, 84, 179));
        this.Field3972.put(this.Method2150180(SelfAnvil.class), new Color(13, 113, 149));
        this.Field3972.put(this.Method2150180(SelfTrap.class), new Color(22, 127, 145));
        this.Field3972.put(this.Method2150180(Surround.class), new Color(214, 134, 49));
        this.Field3972.put(this.Method2150180(TrapPhase.class), new Color(172, 169, 64));
        this.Field3972.put(this.Method2150180(WebFill.class), new Color(11, 161, 121));
        this.Field3972.put(this.Method2150180(AutoMountModule.class), new Color(183, 8, 48));
        this.Field3972.put(this.Method2150180(AutoPorn.class), new Color(183, 8, 48));
        this.Field3972.put(this.Method2150180(Announcer.class), new Color(183, 8, 48));
        this.Field3972.put(this.Method2150180(AntiAFK.class), new Color(80, 5, 98));
        this.Field3972.put(this.Method2150180(AntiEffect.class), new Color(25, 209, 135));
        this.Field3972.put(this.Method2150180(AutoGG.class), new Color(27, 86, 123));
        this.Field3972.put(this.Method2150180(AntiExploits.class), new Color(240, 49, 110));
        this.Field3972.put(this.Method2150180(AutoEat.class), new Color(229, 194, 255));
        this.Field3972.put(this.Method2150180(AutoFrameDupe.class), new Color(137, 130, 57));
        this.Field3972.put(this.Method2150180(AutoLog.class), new Color(176, 176, 176));
        this.Field3972.put(this.Method2150180(AutoObsidian.class), new Color(174, 14, 50));
        this.Field3972.put(this.Method2150180(AutoReconnect.class), new Color(75, 75, 137));
        this.Field3972.put(this.Method2150180(AutoRespawn.class), new Color(36, 84, 143));
        this.Field3972.put(this.Method2150180(AutoWither.class), new Color(24, 144, 62));
        this.Field3972.put(this.Method2150180(BowMcBomb.class), new Color(140, 118, 64));
        this.Field3972.put(this.Method2150180(BuildHeight.class), new Color(64, 136, 199));
        this.Field3972.put(this.Method2150180(BypassModule.class), new Color(64, 136, 199));
        this.Field3972.put(this.Method2150180(ChatModifier.class), new Color(255, 59, 216));
        this.Field3972.put(this.Method2150180(Crasher.class), new Color(18, 132, 120));
        this.Field3972.put(this.Method2150180(ChorusControl.class), new Color(105, 97, 29));
        this.Field3972.put(this.Method2150180(EntityDeSync.class), new Color(21, 56, 111));
        this.Field3972.put(this.Method2150180(ExtraTab.class), new Color(21, 56, 111));
        this.Field3972.put(this.Method2150180(Ghost.class), new Color(106, 48, 104));
        this.Field3972.put(this.Method2150180(InstantBurrow.class), new Color(80, 136, 165));
        this.Field3972.put(this.Method2150180(Logger.class), new Color(186, 0, 109));
        this.Field3972.put(this.Method2150180(MCF.class), new Color(17, 85, 255));
        this.Field3972.put(this.Method2150180(MobOwner.class), new Color(15, 132, 79));
        this.Field3972.put(this.Method2150180(NoSoundLag.class), new Color(255, 56, 0));
        this.Field3972.put(this.Method2150180(NoteBot.class), new Color(181, 177, 59));
        this.Field3972.put(this.Method2150180(Nuker.class), new Color(152, 169, 17));
        this.Field3972.put(this.Method2150180(PingSpoof.class), new Color(23, 214, 187));
        this.Field3972.put(this.Method2150180(PluginsGrabber.class), new Color(69, 8, 126));
        this.Field3972.put(this.Method2150180(Portals.class), new Color(71, 214, 187));
        this.Field3972.put(this.Method2150180(SpammerModule.class), new Color(143, 70, 179));
        this.Field3972.put(this.Method2150180(StashLogger.class), new Color(135, 61, 107));
        this.Field3972.put(this.Method2150180(StopWatchModule.class), new Color(135, 61, 107));
        this.Field3972.put(this.Method2150180(ToolTips.class), new Color(209, 125, 156));
        this.Field3972.put(this.Method2150180(Tracker.class), new Color(0, 255, 225));
        this.Field3972.put(this.Method2150180(Ambience.class), new Color(165, 126, 97));
        this.Field3972.put(this.Method2150180(BreadCrumbs.class), new Color(182, 69, 111));
        this.Field3972.put(this.Method2150180(BurrowESP.class), new Color(77, 108, 132));
        this.Field3972.put(this.Method2150180(ChamsOld.class), new Color(34, 152, 34));
        this.Field3972.put(this.Method2150180(ChorusPredict.class), new Color(136, 152, 34));
        this.Field3972.put(this.Method2150180(Crosshair.class), new Color(161, 51, 112));
        this.Field3972.put(this.Method2150180(CrystalChams.class), new Color(42, 106, 91));
        this.Field3972.put(this.Method2150180(CsgoESP.class), new Color(198, 182, 59));
        this.Field3972.put(this.Method2150180(CustomEnchants.class), new Color(45, 85, 139));
        this.Field3972.put(this.Method2150180(ESPModule.class), new Color(255, 27, 155));
        this.Field3972.put(this.Method2150180(EntityESP.class), new Color(255, 27, 155));
        this.Field3972.put(this.Method2150180(Fullbright.class), new Color(255, 164, 107));
        this.Field3972.put(this.Method2150180(HoleESP.class), new Color(95, 83, 130));
        this.Field3972.put(this.Method2150180(ItemPhysics.class), new Color(59, 189, 72));
        this.Field3972.put(this.Method2150180(ItemChams.class), new Color(174, 32, 168));
        this.Field3972.put(this.Method2150180(ItemViewModel.class), new Color(24, 113, 6));
        this.Field3972.put(this.Method2150180(KillEffect.class), new Color(62, 31, 164));
        this.Field3972.put(this.Method2150180(LogoutSpots.class), new Color(2, 135, 134));
        this.Field3972.put(this.Method2150180(NametagsA.class), new Color(98, 82, 223));
        this.Field3972.put(this.Method2150180(NoRender.class), new Color(255, 164, 107));
        this.Field3972.put(this.Method2150180(NoWeatherModule.class), new Color(255, 164, 107));
        this.Field3972.put(this.Method2150180(NewChunks.class), new Color(29, 161, 75));
        this.Field3972.put(this.Method2150180(OffscreenESP.class), new Color(193, 219, 20));
        this.Field3972.put(this.Method2150180(PopChams.class), new Color(25, 115, 129));
        this.Field3972.put(this.Method2150180(Shaders.class), new Color(174, 32, 168));
        this.Field3972.put(this.Method2150180(Skeleton.class), new Color(219, 219, 219));
        this.Field3972.put(this.Method2150180(SkyColor.class), new Color(150, 61, 61));
        this.Field3972.put(this.Method2150180(SpawnsESP.class), new Color(61, 165, 130));
        this.Field3972.put(this.Method2150180(StorageESP.class), new Color(97, 81, 223));
        this.Field3972.put(this.Method2150180(Swing.class), new Color(68, 178, 142));
        this.Field3972.put(this.Method2150180(Tracers.class), new Color(255, 107, 107));
        this.Field3972.put(this.Method2150180(Trails.class), new Color(54, 95, 172));
        this.Field3972.put(this.Method2150180(Trajectories.class), new Color(98, 18, 223));
        this.Field3972.put(this.Method2150180(ViewClip.class), new Color(247, 169, 107));
        this.Field3972.put(this.Method2150180(AirStrafe.class), new Color(32, 146, 115));
        this.Field3972.put(this.Method2150180(Anchor.class), new Color(128, 150, 90));
        this.Field3972.put(this.Method2150180(AntiVoid.class), new Color(72, 72, 147));
        this.Field3972.put(this.Method2150180(AutoWalk.class), new Color(153, 153, 170));
        this.Field3972.put(this.Method2150180(BoatFly.class), new Color(181, 58, 36));
        this.Field3972.put(this.Method2150180(ElytraFlight.class), new Color(55, 161, 201));
        this.Field3972.put(this.Method2150180(EntityControl.class), new Color(7, 128, 112));
        this.Field3972.put(this.Method2150180(EntitySpeed.class), new Color(6, 154, 32));
        this.Field3972.put(this.Method2150180(FastFall.class), new Color(89, 89, 88));
        this.Field3972.put(this.Method2150180(FastSwim.class), new Color(65, 152, 207));
        this.Field3972.put(this.Method2150180(Flight.class), new Color(186, 164, 178));
        this.Field3972.put(this.Method2150180(GroundSpeed.class), new Color(106, 94, 177));
        this.Field3972.put(this.Method2150180(HoleSnap.class), new Color(64, 196, 120));
        this.Field3972.put(this.Method2150180(IceSpeed.class), new Color(33, 193, 247));
        this.Field3972.put(this.Method2150180(Jesus.class), new Color(136, 221, 235));
        this.Field3972.put(this.Method2150180(LongJump.class), new Color(4, 146, 59));
        this.Field3972.put(this.Method2150180(NoFall.class), new Color(61, 204, 78));
        this.Field3972.put(this.Method2150180(NoSlowDown.class), new Color(61, 204, 78));
        this.Field3972.put(this.Method2150180(PacketFlight.class), new Color(238, 59, 27));
        this.Field3972.put(this.Method2150180(PhaseWalk.class), new Color(186, 144, 212));
        this.Field3972.put(this.Method2150180(SafeWalk.class), new Color(182, 186, 164));
        this.Field3972.put(this.Method2150180(SpeedRewrite.class), new Color(55, 153, 188));
        this.Field3972.put(this.Method2150180(Sprint.class), new Color(148, 184, 142));
        this.Field3972.put(this.Method2150180(Step.class), new Color(129, 196, 192));
        this.Field3972.put(this.Method2150180(TickShift.class), new Color(58, 144, 182));
        this.Field3972.put(this.Method2150180(VanillaClip.class), new Color(133, 136, 51));
        this.Field3972.put(this.Method2150180(VanillaSpeed.class), new Color(137, 77, 103));
        this.Field3972.put(this.Method2150180(Velocity.class), new Color(115, 134, 140));
        this.Field3972.put(this.Method2150180(AntiHunger.class), new Color(86, 53, 98));
        this.Field3972.put(this.Method2150180(Automine.class), new Color(82, 161, 87));
        this.Field3972.put(this.Method2150180(AutoBuilder.class), new Color(37, 132, 156));
        this.Field3972.put(this.Method2150180(Blink.class), new Color(144, 184, 141));
        this.Field3972.put(this.Method2150180(BlockTweaks.class), new Color(89, 223, 235));
        this.Field3972.put(this.Method2150180(ChestSwap.class), new Color(95, 94, 175));
        this.Field3972.put(this.Method2150180(ChorusLag.class), new Color(83, 133, 108));
        this.Field3972.put(this.Method2150180(FakePlayer.class), new Color(37, 192, 170));
        this.Field3972.put(this.Method2150180(FastUse.class), new Color(219, 212, 102));
        this.Field3972.put(this.Method2150180(NoInteractModule.class), new Color(100, 178, 99));
        this.Field3972.put(this.Method2150180(Freecam.class), new Color(206, 232, 128));
        this.Field3972.put(this.Method2150180(Replenish.class), new Color(85, 223, 235));
        this.Field3972.put(this.Method2150180(InstantMine.class), new Color(64, 80, 142));
        this.Field3972.put(this.Method2150180(LiquidInteract.class), new Color(85, 223, 235));
        this.Field3972.put(this.Method2150180(MCP.class), new Color(153, 68, 170));
        this.Field3972.put(this.Method2150180(MultiTask.class), new Color(17, 223, 235));
        this.Field3972.put(this.Method2150180(NoBreakAnimation.class), new Color(76, 157, 86));
        this.Field3972.put(this.Method2150180(NoEntityTrace.class), new Color(66, 76, 193));
        this.Field3972.put(this.Method2150180(NoGlitchBlocks.class), new Color(177, 128, 31));
        this.Field3972.put(this.Method2150180(NoPacketKick.class), new Color(31, 133, 29));
        this.Field3972.put(this.Method2150180(NoRotate.class), new Color(64, 74, 208));
        this.Field3972.put(this.Method2150180(PacketCanceller.class), new Color(168, 68, 94));
        this.Field3972.put(this.Method2150180(Reach.class), new Color(9, 223, 187));
        this.Field3972.put(this.Method2150180(Scaffold.class), new Color(152, 166, 113));
        this.Field3972.put(this.Method2150180(SilentAutoXP.class), new Color(146, 68, 180));
        this.Field3972.put(this.Method2150180(Speedmine.class), new Color(135, 149, 102));
        this.Field3972.put(this.Method2150180(TimerSpeed.class), new Color(255, 133, 18));
        this.Field3972.put(this.Method2150180(TpsSync.class), new Color(93, 144, 153));
        this.Field3972.put(this.Method2150180(TrueDurability.class), new Color(254, 161, 51));
        this.Field3972.put(this.Method2150180(XCarry.class), new Color(254, 161, 51));
        this.Field3972.put(this.Method2150180(YawPitchLock.class), new Color(115, 39, 141));
        this.Field3972.put(this.Method2150180(AutoConfig.class), new Color(28, 171, 100));
        this.Field3972.put(this.Method2150180(ClickGui.class), new Color(26, 81, 135));
        this.Field3972.put(this.Method2150180(ClickGuiP.class), new Color(26, 81, 135));
        this.Field3972.put(this.Method2150180(ClickGuiF.class), new Color(26, 81, 135));
        this.Field3972.put(this.Method2150180(ClickGui2.class), new Color(26, 81, 135));
        this.Field3972.put(this.Method2150180(Colors.class), new Color(135, 133, 26));
        this.Field3972.put(this.Method2150180(CustomFontModule.class), new Color(135, 26, 88));
        this.Field3972.put(this.Method2150180(Global.class), new Color(26, 90, 135));
        this.Field3972.put(this.Method2150180(HUD.class), new Color(110, 26, 135));
        this.Field3972.put(this.Method2150180(HudComponents.class), new Color(135, 26, 26));
        this.Field3972.put(this.Method2150180(Media.class), new Color(158, 82, 56));
        this.Field3972.put(this.Method2150180(ModuleTools.class), new Color(60, 110, 175));
        this.Field3972.put(this.Method2150180(NoHandShake.class), new Color(42, 50, 116));
        this.Field3972.put(this.Method2150180(Notifications.class), new Color(170, 153, 255));
        this.Field3972.put(this.Method2150180(Radar.class), new Color(115, 135, 26));
        this.Field3972.put(this.Method2150180(RPC.class), new Color(8, 59, 216));
        this.Field3972.put(this.Method2150180(Safety.class), new Color(85, 142, 182));
        this.Field3972.put(this.Method2150180(StreamerMode.class), new Color(59, 58, 58));
        this.Field3972.put(this.Method2150180(TargetHud.class), new Color(101, 142, 52));
        this.Field3972.put(this.Method2150180(TotemPopCounter.class), new Color(142, 72, 52));
        for (Module module : Field3969) {
            module.Field3722.start();
        }
    }

    public <T extends Module> T Method2150180(Class<T> class_) {
        for (Module module : Field3969) {
            if (!class_.isInstance(module)) continue;
            return (T) module;
        }
        return null;
    }

    public void Method2150191(Class<Module> class_) {
        Module module = this.Method2150180(class_);
        if (module != null) {
            module.Method2150389();
        }
    }

    public void Method2150192(Class<Module> class_) {
        Module module = this.Method2150180(class_);
        if (module != null) {
            module.Method2150380();
        }
    }

    public void Method2150193(String string) {
        Module module = ModuleManager.Method2150189(string);
        if (module != null) {
            module.Method2150389();
        }
    }

    public void Method2150194(String string) {
        Module module = ModuleManager.Method2150189(string);
        if (module != null) {
            module.Method2150380();
        }
    }

    public boolean Method2150195(String string) {
        Module module = ModuleManager.Method2150189(string);
        return module != null && module.Method2150386();
    }

    public boolean Method2150196(Class class_) {
        Object t = this.Method2150180(class_);
        return t != null && ((Module) t).Method2150386();
    }

    public Module Method2150197(String string) {
        for (Module module : Field3969) {
            if (!module.Method2150392().equalsIgnoreCase(string)) continue;
            return module;
        }
        return null;
    }

    public ArrayList<Module> Method2150198() {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        for (Module module : Field3969) {
            if (!module.Method2150364() && !module.Method2150395()) continue;
            arrayList.add(module);
        }
        return arrayList;
    }

    public ArrayList<Module> Method2150199(Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        Field3969.forEach(arg_0 -> ModuleManager.Method2150210(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, arrayList, arg_0));
        return arrayList;
    }

    public List<Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Method2150190() {
        return Arrays.asList(Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.values());
    }

    public void Method2150101() {
        Field3969.stream().filter(Module::Method2150302).forEach(((EventBus) MinecraftForge.EVENT_BUS)::register);
        Field3969.forEach(Module::Method2150375);
    }

    public void Method2150102() {
        Field3969.stream().filter(Feature::Method2150364).forEach(Module::Method2150379);
    }

    public void Method2150103() {
        Field3969.stream().filter(Feature::Method2150364).forEach(Module::Method2150376);
    }

    public void Method2150104(Render2DEvent render2DEvent) {
        Field3969.stream().filter(Feature::Method2150364).forEach(arg_0 -> ModuleManager.Method2150219(render2DEvent, arg_0));
    }

    public void Method2150105(Render3DEvent render3DEvent) {
        Field3969.stream().filter(Feature::Method2150364).forEach(arg_0 -> ModuleManager.Method2150218(render3DEvent, arg_0));
    }

    public void Method2150106(boolean bl) {
        this.Field3970 = this.Method2150198().stream().filter(Module::Method2150396).sorted(Comparator.comparing(arg_0 -> this.Method2150217(bl, arg_0))).collect(Collectors.toList());
    }

    public void Method2150107() {
        this.Field3971 = this.Method2150198().stream().filter(Module::Method2150396).sorted(Comparator.comparing(Module::Method2150392)).collect(Collectors.toList());
    }

    public void Method2150108() {
        Field3969.forEach(Module::Method2150378);
    }

    public void Method2150109() {
        Field3969.forEach(Module::Method2150377);
    }

    public void Method2150100() {
        Field3969.forEach(((EventBus) MinecraftForge.EVENT_BUS)::unregister);
        Field3969.forEach(Module::Method2150382);
    }

    public void Method2150211() {
        for (Module module : Field3969) {
            module.Field3710.setValue(false);
        }
    }

    public void Method2150212(int n2) {
        if (n2 == 0 || !Keyboard.getEventKeyState() || ModuleManager.Field2811.currentScreen instanceof LuigiGuiOld) {
            return;
        }
        Field3969.forEach(arg_0 -> ModuleManager.Method2150216(n2, arg_0));
    }

    public List<Module> Method2150213(Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        for (Module module : this.Method2150198()) {
            if (module.Method2150398() != iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll || module.Method2150365() || !module.Method2150395() || !module.Method2150396())
                continue;
            arrayList.add(module);
        }
        return arrayList;
    }

    private Integer Method2150217(boolean bl, Module module) {
        return this.Field3872.Method2150310(module.Method2150303()) * (bl ? -1 : 1);
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends JFrame {
        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
            this.setTitle("Black list");
            this.setDefaultCloseOperation(2);
            this.setLocationRelativeTo(null);
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2150186();
            String string = "Sorry, You are on Blacklist :D";
            JOptionPane.showMessageDialog(this, string, "Bakaaaaaaaaa", -1, UIManager.getIcon("OptionPane.errorIcon"));
        }

        public static void Method2150186() {
            StringSelection stringSelection = new StringSelection(EventCPacket.Method2159693());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);
        }
    }
}

