

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoTrap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FutureGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InstantMine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Surround;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ToolTips;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD
        extends Module {
    private static final ResourceLocation Field2997 = new ResourceLocation("textures/gui/container/shulker_box.png");
    private static final ItemStack Field2998 = new ItemStack(Items.TOTEM_OF_UNDYING);
    private static final ItemStack Field2999 = new ItemStack(Items.TOTEM_OF_UNDYING);
    private static final ItemStack Field3000 = new ItemStack(Items.END_CRYSTAL);
    private static final ItemStack Field3001 = new ItemStack(Items.GOLDEN_APPLE);
    private static final ItemStack Field3002 = new ItemStack(Items.EXPERIENCE_BOTTLE);
    private static HUD Field3003 = new HUD();
    private final Setting<Boolean> Field3004 = this.Method2150366(new Setting<Boolean>("RenderingUp", Boolean.TRUE, "Orientation of the HUD-Elements."));
    private final Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll> Field3005 = this.Method2150366(new Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll>("Logo", IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.ALICE, "WaterMark"));
    private final Setting<Float> Field3006 = this.Method2150366(new Setting<Float>("WatermarkPosY", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    private final Setting<String> Field3007 = this.Method2150366(new Setting<String>("WatermarkName", "Future v2.13.5"));
    private final Setting<Boolean> Field3008 = this.Method2150366(new Setting<Object>("Version", Boolean.FALSE, this::Method2150640));
    private final Setting<Boolean> Field3009 = this.Method2150366(new Setting<Boolean>("ActiveModules", Boolean.TRUE, "Lists the active modules."));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3010 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("ArrayListMode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static, "color"));
    private final Setting<Boolean> Field3020 = this.Method2150366(new Setting<Object>("ActiveModules Line", Boolean.FALSE, this::Method2150641));
    private final Setting<Integer> Field3021 = this.Method2150366(new Setting<Object>("ActiveModules PosY", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(20), this::Method2150630));
    private final Setting<Boolean> Field3022 = this.Method2150366(new Setting<Object>("AlphabeticalSorting", Boolean.FALSE, this::Method2150639));
    private final Setting<Boolean> Field3023 = this.Method2150366(new Setting<Boolean>("Ping", Boolean.TRUE, "Your response time to the server."));
    private final Setting<Boolean> Field3024 = this.Method2150366(new Setting<Boolean>("TPS", Boolean.TRUE, "Ticks per second of the server."));
    private final Setting<Boolean> Field3025 = this.Method2150366(new Setting<Boolean>("FPS", Boolean.TRUE, "Your frames per second."));
    private final Setting<Boolean> Field3026 = this.Method2150366(new Setting<Boolean>("Coords", Boolean.TRUE, "Your current coordinates"));
    private final Setting<Boolean> Field3027 = this.Method2150366(new Setting<Boolean>("Direction", Boolean.TRUE, "The Direction you are facing."));
    private final Setting<Boolean> Field3028 = this.Method2150366(new Setting<Boolean>("Speed", Boolean.TRUE, "Your Speed"));
    private final Setting<Boolean> Field3029 = this.Method2150366(new Setting<Boolean>("Potions", Boolean.TRUE, "Active potion effects"));
    private final Setting<Boolean> Field3030 = this.Method2150366(new Setting<Object>("AltPotionColors", Boolean.TRUE, this::Method2150638));
    private final Setting<Boolean> Field3031 = this.Method2150366(new Setting<Boolean>("Armor", Boolean.TRUE, "ArmorHUD"));
    private final Setting<Boolean> Field3032 = this.Method2150366(new Setting<Boolean>("Durability", Boolean.FALSE, "Durability"));
    private final Setting<Boolean> Field3033 = this.Method2150366(new Setting<Boolean>("Totems", Boolean.TRUE, "TotemHUD"));
    private final Setting<Boolean> Field3034 = this.Method2150366(new Setting<Boolean>("ItemInfo", Boolean.FALSE, "ItemInfo"));
    private final Setting<Boolean> Field3035 = this.Method2150366(new Setting<Boolean>("PvpInfo", false));
    private final Setting<Boolean> Field3036 = this.Method2150366(new Setting<Boolean>("ItemTextInfoRewrite", true));
    private final Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field3037 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Welcomer", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE, "Greets you."));
    private final Setting<String> Field3038 = this.Method2150366(new Setting<Object>("GreeterName", "3arthqu4ke", this::Method2150637));
    private final Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field3039 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("Lag", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.GRAY, "Lag Notifier"));
    private final Setting<Boolean> Field3040 = this.Method2150366(new Setting<Boolean>("FutureColour", true));
    private final Setting<Boolean> Field3050 = this.Method2150366(new Setting<Boolean>("Server ip", false));
    private final Setting<Float> Field3051 = this.Method2150366(new Setting<Object>("Server ip PosX", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this::Method2150632));
    private final Setting<Float> Field3052 = this.Method2150366(new Setting<Object>("Server ip PosY", Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this::Method2150631));
    private final Timer Field3059 = new Timer();
    private final Timer Field3060 = new Timer();
    private final Map<Potion, Color> Field3061 = new HashMap<Potion, Color>();
    public Setting<Integer> Field3011 = this.Method2150366(new Setting<Object>("Factor", Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(20), this::Method2150649));
    public Setting<Boolean> Field3012 = this.Method2150366(new Setting<Object>("Rolling", Boolean.FALSE, this::Method2150648));
    public Setting<Integer> Field3013 = this.Method2150366(new Setting<Object>("RSpeed", Integer.valueOf(60), Integer.valueOf(0), Integer.valueOf(100), this::Method2150647));
    public Setting<Integer> Field3014 = this.Method2150366(new Setting<Object>("Saturation", Integer.valueOf(200), Integer.valueOf(0), Integer.valueOf(255), this::Method2150646));
    public Setting<Integer> Field3015 = this.Method2150366(new Setting<Object>("Brightness", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2150645));
    public Setting<Integer> Field3016 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(36), Integer.valueOf(0), Integer.valueOf(255), this::Method2150644));
    public Setting<Integer> Field3017 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(150), Integer.valueOf(0), Integer.valueOf(255), this::Method2150643));
    public Setting<Integer> Field3018 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(190), Integer.valueOf(0), Integer.valueOf(255), this::Method2150642));
    public Setting<Boolean> Field3019 = this.Method2150366(new Setting<Boolean>("Sync", Boolean.FALSE, "Universal colors for HUD."));
    public Setting<Integer> Field3041 = this.Method2150366(new Setting<Object>("AnimationHTime", Integer.valueOf(500), Integer.valueOf(1), Integer.valueOf(1000), this::Method2150636));
    public Setting<Integer> Field3042 = this.Method2150366(new Setting<Object>("AnimationVTime", Integer.valueOf(50), Integer.valueOf(1), Integer.valueOf(500), this::Method2150635));
    public Setting<Boolean> Field3043 = this.Method2150366(new Setting<Boolean>("TextRadar", Boolean.FALSE, "A TextRadar"));
    public Setting<Boolean> Field3044 = this.Method2150366(new Setting<Boolean>("Time", Boolean.FALSE, "The time"));
    public Setting<Boolean> Field3045 = this.Method2150366(new Setting<Boolean>("NoShadow", Boolean.TRUE, "Draws the text with a shadow."));
    public Setting<Boolean> Field3046 = this.Method2150366(new Setting<Boolean>("PotionIcons", Boolean.TRUE, "Draws Potion Icons."));
    public Setting<Boolean> Field3047 = this.Method2150366(new Setting<Boolean>("ArmorDurabilityWarner", Boolean.TRUE, "."));
    private final Setting<Float> Field3048 = this.Method2150366(new Setting<Object>("Warn X", Float.valueOf(420.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this::Method2150634));
    private final Setting<Float> Field3049 = this.Method2150366(new Setting<Object>("Warn Y", Float.valueOf(67.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this::Method2150633));
    public Map<Module, Float> Field3053 = new HashMap<Module, Float>();
    public Map<Integer, Integer> Field3054 = new HashMap<Integer, Integer>();
    private Map<String, Integer> Field3055 = new HashMap<String, Integer>();
    private int Field3056;
    private boolean Field3057;
    private int Field3058;

    public HUD() {
        super("HUD", "HUD Elements rendered on your screen", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150505();
        this.Field3061.put(MobEffects.SPEED, new Color(124, 175, 198));
        this.Field3061.put(MobEffects.SLOWNESS, new Color(90, 108, 129));
        this.Field3061.put(MobEffects.HASTE, new Color(217, 192, 67));
        this.Field3061.put(MobEffects.MINING_FATIGUE, new Color(74, 66, 23));
        this.Field3061.put(MobEffects.STRENGTH, new Color(147, 36, 35));
        this.Field3061.put(MobEffects.INSTANT_HEALTH, new Color(67, 10, 9));
        this.Field3061.put(MobEffects.INSTANT_DAMAGE, new Color(67, 10, 9));
        this.Field3061.put(MobEffects.JUMP_BOOST, new Color(34, 255, 76));
        this.Field3061.put(MobEffects.NAUSEA, new Color(85, 29, 74));
        this.Field3061.put(MobEffects.REGENERATION, new Color(205, 92, 171));
        this.Field3061.put(MobEffects.RESISTANCE, new Color(153, 69, 58));
        this.Field3061.put(MobEffects.FIRE_RESISTANCE, new Color(228, 154, 58));
        this.Field3061.put(MobEffects.WATER_BREATHING, new Color(46, 82, 153));
        this.Field3061.put(MobEffects.INVISIBILITY, new Color(127, 131, 146));
        this.Field3061.put(MobEffects.BLINDNESS, new Color(31, 31, 35));
        this.Field3061.put(MobEffects.NIGHT_VISION, new Color(31, 31, 161));
        this.Field3061.put(MobEffects.HUNGER, new Color(88, 118, 83));
        this.Field3061.put(MobEffects.WEAKNESS, new Color(72, 77, 72));
        this.Field3061.put(MobEffects.POISON, new Color(78, 147, 49));
        this.Field3061.put(MobEffects.WITHER, new Color(53, 42, 39));
        this.Field3061.put(MobEffects.HEALTH_BOOST, new Color(248, 125, 35));
        this.Field3061.put(MobEffects.ABSORPTION, new Color(37, 82, 165));
        this.Field3061.put(MobEffects.SATURATION, new Color(248, 36, 35));
        this.Field3061.put(MobEffects.GLOWING, new Color(148, 160, 97));
        this.Field3061.put(MobEffects.LEVITATION, new Color(206, 255, 255));
        this.Field3061.put(MobEffects.LUCK, new Color(51, 153, 0));
        this.Field3061.put(MobEffects.UNLUCK, new Color(192, 164, 77));
    }

    public static HUD Method2150504() {
        if (Field3003 == null) {
            Field3003 = new HUD();
        }
        return Field3003;
    }

    private static boolean Method2150622(ItemStack itemStack) {
        return itemStack.getItem() == Items.GOLDEN_APPLE;
    }

    private static boolean Method2150623(ItemStack itemStack) {
        return itemStack.getItem() == Items.EXPERIENCE_BOTTLE;
    }

    private static boolean Method2150624(ItemStack itemStack) {
        return itemStack.getItem() == Items.END_CRYSTAL;
    }

    private static boolean Method2150625(ItemStack itemStack) {
        return itemStack.getItem() == Items.TOTEM_OF_UNDYING;
    }

    private static boolean Method2150626(ItemStack itemStack) {
        return itemStack.getItem() == Items.TOTEM_OF_UNDYING;
    }

    private static boolean Method2150627(ItemStack itemStack) {
        return itemStack.getItem() == Items.EXPERIENCE_BOTTLE;
    }

    private static boolean Method2150628(ItemStack itemStack) {
        return itemStack.getItem() == Items.TOTEM_OF_UNDYING;
    }

    private static boolean Method2150629(ItemStack itemStack) {
        return itemStack.getItem() == Items.GOLDEN_APPLE;
    }

    private static boolean Method2150620(ItemStack itemStack) {
        return itemStack.getItem() == Items.END_CRYSTAL;
    }

    private void Method2150505() {
        Field3003 = this;
    }

    @Override
    public void Method2150379() {
        for (Module module : AliceMain.Field756.Field3970) {
            if (!module.Method2150365() || module.Field3717 != 0.0f) continue;
            module.Field3721 = true;
        }
        if (this.Field3059.Method2164755(0L)) {
            this.Field3055 = this.Method2150500();
            this.Field3059.Method2164750();
        }
        if (this.Field3057) {
            ++this.Field3058;
        }
        if (this.Field3058 == 10) {
            this.Field3058 = 0;
            this.Field3057 = false;
        }
    }

    @SubscribeEvent
    public void Method2150506(ClientEvent clientEvent) {
        block4:
        {
            block5:
            {
                if (!(clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof Module))
                    break block4;
                if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0)
                    break block5;
                for (float f = 0.0f; f <= (float) this.Field3872.Method2150310(((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()); f += (float) this.Field3872.Method2150310(((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()) / 500.0f) {
                    if (this.Field3060.Method2164755(1L)) {
                        this.Field3053.put((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(), Float.valueOf((float) this.Field3872.Method2150310(((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()) - f));
                    }
                    this.Field3059.Method2164750();
                }
                break block4;
            }
            if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 1)
                break block4;
            for (float f = 0.0f; f <= (float) this.Field3872.Method2150310(((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()); f += (float) this.Field3872.Method2150310(((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()) / 500.0f) {
                if (this.Field3060.Method2164755(1L)) {
                    this.Field3053.put((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(), Float.valueOf((float) this.Field3872.Method2150310(((Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()) - f));
                }
                this.Field3059.Method2164750();
            }
        }
    }

    @Override
    public void Method2150370(Render2DEvent render2DEvent) {
        int n2;
        String string;
        int n3;
        Object object;
        Object object2;
        int n4;
        if (HUD.Method2150359()) {
            return;
        }
        Color color = this.Field3019.getValue() != false ? Colors.Field1782.Method2150586() : new Color(HUD.Method2150504().Field3016.getValue(), HUD.Method2150504().Field3017.getValue(), HUD.Method2150504().Field3018.getValue());
        int n5 = 101 - this.Field3013.getValue();
        float f = this.Field3019.getValue() != false ? Colors.Field1782.Field1791 : (float) (System.currentTimeMillis() % (long) (360 * n5)) / (360.0f * (float) n5);
        int n6 = this.Field3872.Field2303;
        int n7 = this.Field3872.Field2304;
        float f2 = f;
        for (int j = 0; j <= n7; ++j) {
            if (this.Field3019.getValue().booleanValue()) {
                this.Field3054.put(j, Color.HSBtoRGB(f2, (float) Colors.Field1782.Field1785.getValue().intValue() / 255.0f, (float) Colors.Field1782.Field1786.getValue().intValue() / 255.0f));
            } else {
                this.Field3054.put(j, Color.HSBtoRGB(f2, (float) this.Field3014.getValue().intValue() / 255.0f, (float) this.Field3015.getValue().intValue() / 255.0f));
            }
            f2 += 1.0f / (float) n7 * (float) this.Field3011.getValue().intValue();
        }
        GlStateManager.pushMatrix();
        if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow && !this.Field3012.getValue().booleanValue()) {
            this.Field3056 = this.Field3019.getValue() != false ? Colors.Field1782.Method2150585() : Color.HSBtoRGB(f, (float) this.Field3014.getValue().intValue() / 255.0f, (float) this.Field3015.getValue().intValue() / 255.0f);
        } else if (this.Field3010.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
            int n8 = this.Field3056 = this.Field3019.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163378(this.Field3016.getValue(), this.Field3017.getValue(), this.Field3018.getValue());
        }
        if (this.Field3035.getValue().booleanValue()) {
            this.Method2150613();
        }
        if (this.Field3050.getValue().booleanValue()) {
            String string2;
            String string3 = string2 = Minecraft.getMinecraft().isSingleplayer() ? "singleplayer".toLowerCase() : HUD.Field2811.getCurrentServerData().serverIP.toLowerCase();
            if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                this.Field3872.Method2150318("IP: " + string2, this.Field3051.getValue().floatValue(), this.Field3052.getValue().floatValue(), this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2) : this.Field3056, true);
            } else {
                this.Field3872.Method2150318("IP: " + string2, this.Field3051.getValue().floatValue(), this.Field3052.getValue().floatValue(), this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377(0.89f, color) : this.Field3056, true);
            }
        }
        String string4 = this.Field3040.getValue() != false ? "\u00a77" : "";
        switch (this.Field3005.getValue()) {
            case LUIGI: {
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318("LuigiHack " + (this.Field3008.getValue() != false ? "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2) : this.Field3056, true);
                    break;
                }
                this.Field3872.Method2150318("LuigiHack " + (this.Field3008.getValue() != false ? "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377(0.89f, color) : this.Field3056, true);
                break;
            }
            case ALICE: {
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318("Alice " + (this.Field3008.getValue() != false ? "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2) : this.Field3056, true);
                    break;
                }
                this.Field3872.Method2150318("Alice " + (this.Field3008.getValue() != false ? "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377(0.89f, color) : this.Field3056, true);
                break;
            }
            case WhiteVersion: {
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318("LuigiHack " + (this.Field3008.getValue() != false ? (Object) ChatFormatting.WHITE + "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2) : this.Field3056, true);
                    break;
                }
                this.Field3872.Method2150318("LuigiHack " + (this.Field3008.getValue() != false ? (Object) ChatFormatting.WHITE + "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377(0.89f, color) : this.Field3056, true);
                break;
            }
            case CUSTOM: {
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318(this.Field3007.getValue() + " " + (this.Field3008.getValue() != false ? "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2) : this.Field3056, true);
                    break;
                }
                this.Field3872.Method2150318(this.Field3007.getValue() + " " + (this.Field3008.getValue() != false ? "1.4.2" : ""), 2.0f, this.Field3006.getValue().floatValue(), this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377(0.89f, color) : this.Field3056, true);
            }
        }
        if (this.Field3043.getValue().booleanValue()) {
            this.Method2150621(ToolTips.Method2161937().Method2150387() || ToolTips.Method2161937().Field930.getValue() == false || ToolTips.Method2161937().Field931.getValue() == false ? 0 : ToolTips.Method2161937().Method2161930());
        }
        int n9 = this.Field3004.getValue() != false ? this.Field3021.getValue() : (n4 = HUD.Field2811.currentScreen instanceof GuiChat ? 14 : 0);
        if (this.Field3009.getValue().booleanValue()) {
            int n10;
            String string5;
            if (this.Field3004.getValue().booleanValue()) {
                string5 = this.Field3020.getValue() != false ? "|" : "";
                for (n10 = 0; n10 < (this.Field3022.getValue() != false ? AliceMain.Field756.Field3971.size() : AliceMain.Field756.Field3970.size()); ++n10) {
                    Module object32 = this.Field3022.getValue() != false ? AliceMain.Field756.Field3971.get(n10) : AliceMain.Field756.Field3970.get(n10);
                    object2 = AliceMain.Field756.Field3972.get(object32);
                    object = string5 + object32.Method2150392() + "\u00a77" + (object32.Method2150385() != null ? " [\u00a7f" + object32.Method2150385() + "\u00a77]" : "");
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        this.Field3872.Method2150318((String) object, (float) (n6 - 2 - this.Field3872.Method2150310((String) object)) + (this.Field3041.getValue() == 1 ? 0.0f : object32.Field3717), 2 + n4 * 10, this.Field3012.getValue() != false ? this.Field3054.get(MathUtil.Method2163843(2 + n4 * 10, 0, n7)) : this.Field3056, true);
                    }
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Future) {
                        this.Field3872.Method2150318((String) object, (float) (n6 - 2 - this.Field3872.Method2150310((String) object)) + (this.Field3041.getValue() == 1 ? 0.0f : object32.Field3717), 2 + n4 * 10, object2 != null ? ((Color) object2).getRGB() : this.Field3056, true);
                    }
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow) {
                        this.Field3872.Method2150318((String) object, (float) (n6 - 2 - this.Field3872.Method2150310((String) object)) + (this.Field3041.getValue() == 1 ? 0.0f : object32.Field3717), 2 + n4 * 10, ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color), true);
                    }
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static) {
                        this.Field3872.Method2150318((String) object, (float) (n6 - 2 - this.Field3872.Method2150310((String) object)) + (this.Field3041.getValue() == 1 ? 0.0f : object32.Field3717), 2 + n4 * 10, this.Field3056, true);
                    }
                    ++n4;
                }
            } else {
                string5 = this.Field3020.getValue() != false ? "|" : "";
                for (n10 = 0; n10 < (this.Field3022.getValue() != false ? AliceMain.Field756.Field3971.size() : AliceMain.Field756.Field3970.size()); ++n10) {
                    Module n23 = this.Field3022.getValue() != false ? AliceMain.Field756.Field3971.get(AliceMain.Field756.Field3971.size() - 1 - n10) : AliceMain.Field756.Field3970.get(n10);
                    object2 = string5 + n23.Method2150392() + "\u00a77" + (n23.Method2150385() != null ? " [\u00a7f" + n23.Method2150385() + "\u00a77]" : "");
                    object = AliceMain.Field756.Field3972.get(n23);
                    TextManager textManager = this.Field3872;
                    float f3 = (float) (n6 - 2 - this.Field3872.Method2150310((String) object2)) + (this.Field3041.getValue() == 1 ? 0.0f : n23.Field3717);
                    n4 += 10;
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        textManager.Method2150318((String) object2, f3, n7 - n4, this.Field3012.getValue() != false ? this.Field3054.get(MathUtil.Method2163843(n7 - n4, 0, n7)) : this.Field3056, true);
                    }
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Future) {
                        textManager.Method2150318((String) object2, f3, n7 - n4, object != null ? ((Color) object).getRGB() : this.Field3056, true);
                    }
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow) {
                        textManager.Method2150318((String) object2, f3, n7 - n4, ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color), true);
                    }
                    if (this.Field3010.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static)
                        continue;
                    textManager.Method2150318((String) object2, f3, n7 - n4, this.Field3056, true);
                }
            }
        }
        int n10 = this.Field3004.getValue().booleanValue() ? (HUD.Field2811.currentScreen instanceof GuiChat ? 0 : 0) : (n3 = 0);
        if (this.Field3004.getValue().booleanValue()) {
            int n12;
            if (this.Field3029.getValue().booleanValue()) {
                for (PotionEffect potionEffect : AliceMain.Field769.Method2150265()) {
                    object2 = this.Field3030.getValue() != false ? AliceMain.Field769.Method2150269(potionEffect) : AliceMain.Field769.Method2150260(potionEffect);
                    object = this.Field3872;
                    float f4 = n6 - (this.Field3872.Method2150310((String) object2) + 2);
                    int n11 = n7 - 2;
                    ((TextManager) object).Method2150318((String) object2, f4, n11 - (n3 += 10), this.Field3030.getValue() != false ? this.Field3061.get((Object) potionEffect.getPotion()).getRGB() : this.Field3056, true);
                }
            }
            if (this.Field3028.getValue().booleanValue()) {
                String string6 = string4 + "Speed \u00a7f" + AliceMain.Field757.Method2150314() + " km/h";
                TextManager textManager = this.Field3872;
                float f5 = n6 - (this.Field3872.Method2150310(string6) + 2);
                int n13 = n7 - 2;
                n3 += 10;
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    textManager.Method2150318(string6, f5, n13 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                } else {
                    textManager.Method2150318(string6, f5, n13 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            if (this.Field3044.getValue().booleanValue()) {
                String string7 = string4 + "Time \u00a7f" + new SimpleDateFormat("h:mm a").format(new Date());
                TextManager textManager = this.Field3872;
                float f6 = n6 - (this.Field3872.Method2150310(string7) + 2);
                int n14 = n7 - 2;
                n3 += 10;
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    textManager.Method2150318(string7, f6, n14 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                } else {
                    textManager.Method2150318(string7, f6, n14 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            if (this.Field3032.getValue().booleanValue() && (n12 = HUD.Field2811.player.getHeldItemMainhand().getMaxDamage() - HUD.Field2811.player.getHeldItemMainhand().getItemDamage()) > 0) {
                String string5 = string4 + "Durability \u00a7a" + n12;
                TextManager textManager = this.Field3872;
                float f7 = n6 - (this.Field3872.Method2150310(string5) + 2);
                int n15 = n7 - 2;
                n3 += 10;
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    textManager.Method2150318(string5, f7, n15 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                } else {
                    textManager.Method2150318(string5, f7, n15 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            if (this.Field3024.getValue().booleanValue()) {
                String string8 = string4 + "TPS \u00a7f" + AliceMain.Field768.Method2150203();
                TextManager textManager = this.Field3872;
                float f8 = n6 - (this.Field3872.Method2150310(string8) + 2);
                int n16 = n7 - 2;
                n3 += 10;
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    textManager.Method2150318(string8, f8, n16 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                } else {
                    textManager.Method2150318(string8, f8, n16 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            string = string4 + "FPS \u00a7f" + Minecraft.debugFPS;
            String string6 = string4 + "Ping \u00a7f" + AliceMain.Field768.Method2150206();
            if (this.Field3872.Method2150310(string6) > this.Field3872.Method2150310(string)) {
                if (this.Field3023.getValue().booleanValue()) {
                    TextManager textManager = this.Field3872;
                    float f9 = n6 - (this.Field3872.Method2150310(string6) + 2);
                    int n17 = n7 - 2;
                    n3 += 10;
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        textManager.Method2150318(string6, f9, n17 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                    } else {
                        textManager.Method2150318(string6, f9, n17 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
                if (this.Field3025.getValue().booleanValue()) {
                    TextManager textManager = this.Field3872;
                    float f10 = n6 - (this.Field3872.Method2150310(string) + 2);
                    int n18 = n7 - 2;
                    n3 += 10;
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        textManager.Method2150318(string, f10, n18 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                    } else {
                        textManager.Method2150318(string, f10, n18 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
            } else {
                if (this.Field3025.getValue().booleanValue()) {
                    TextManager textManager = this.Field3872;
                    float f11 = n6 - (this.Field3872.Method2150310(string) + 2);
                    int n19 = n7 - 2;
                    n3 += 10;
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        textManager.Method2150318(string, f11, n19 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                    } else {
                        textManager.Method2150318(string, f11, n19 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
                if (this.Field3023.getValue().booleanValue()) {
                    TextManager textManager = this.Field3872;
                    float f12 = n6 - (this.Field3872.Method2150310(string6) + 2);
                    int n20 = n7 - 2;
                    n3 += 10;
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        textManager.Method2150318(string6, f12, n20 - n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n7 - n3) : this.Field3056, true);
                    } else {
                        textManager.Method2150318(string6, f12, n20 - n3, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
            }
        } else {
            int n22;
            if (this.Field3029.getValue().booleanValue()) {
                for (PotionEffect potionEffect : AliceMain.Field769.Method2150265()) {
                    object2 = this.Field3030.getValue() != false ? AliceMain.Field769.Method2150269(potionEffect) : AliceMain.Field769.Method2150260(potionEffect);
                    this.Field3872.Method2150318((String) object2, n6 - (this.Field3872.Method2150310((String) object2) + 2), 2 + n3++ * 10, this.Field3030.getValue() != false ? this.Field3061.get((Object) potionEffect.getPotion()).getRGB() : this.Field3056, true);
                }
            }
            if (this.Field3028.getValue().booleanValue()) {
                String string9 = string4 + "Speed \u00a7f" + AliceMain.Field757.Method2150314() + " km/h";
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318(string9, n6 - (this.Field3872.Method2150310(string9) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                } else {
                    this.Field3872.Method2150318(string9, n6 - (this.Field3872.Method2150310(string9) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            if (this.Field3044.getValue().booleanValue()) {
                String string10 = string4 + "Time \u00a7f" + new SimpleDateFormat("h:mm a").format(new Date());
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318(string10, n6 - (this.Field3872.Method2150310(string10) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                } else {
                    this.Field3872.Method2150318(string10, n6 - (this.Field3872.Method2150310(string10) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            if (this.Field3032.getValue().booleanValue() && (n22 = HUD.Field2811.player.getHeldItemMainhand().getMaxDamage() - HUD.Field2811.player.getHeldItemMainhand().getItemDamage()) > 0) {
                String string7 = string4 + "Durability \u00a7a" + n22;
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318(string7, n6 - (this.Field3872.Method2150310(string7) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                } else {
                    this.Field3872.Method2150318(string7, n6 - (this.Field3872.Method2150310(string7) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            if (this.Field3024.getValue().booleanValue()) {
                String string11 = string4 + "TPS \u00a7f" + AliceMain.Field768.Method2150203();
                if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                    this.Field3872.Method2150318(string11, n6 - (this.Field3872.Method2150310(string11) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                } else {
                    this.Field3872.Method2150318(string11, n6 - (this.Field3872.Method2150310(string11) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                }
            }
            string = string4 + "FPS \u00a7f" + Minecraft.debugFPS;
            String string8 = string4 + "Ping \u00a7f" + AliceMain.Field768.Method2150206();
            if (this.Field3872.Method2150310(string8) > this.Field3872.Method2150310(string)) {
                if (this.Field3023.getValue().booleanValue()) {
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        this.Field3872.Method2150318(string8, n6 - (this.Field3872.Method2150310(string8) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                    } else {
                        this.Field3872.Method2150318(string8, n6 - (this.Field3872.Method2150310(string8) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
                if (this.Field3025.getValue().booleanValue()) {
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        this.Field3872.Method2150318(string, n6 - (this.Field3872.Method2150310(string) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                    } else {
                        this.Field3872.Method2150318(string, n6 - (this.Field3872.Method2150310(string) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
            } else {
                if (this.Field3025.getValue().booleanValue()) {
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        this.Field3872.Method2150318(string, n6 - (this.Field3872.Method2150310(string) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                    } else {
                        this.Field3872.Method2150318(string, n6 - (this.Field3872.Method2150310(string) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
                if (this.Field3023.getValue().booleanValue()) {
                    if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
                        this.Field3872.Method2150318(string8, n6 - (this.Field3872.Method2150310(string8) + 2), 2 + n3++ * 10, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2 + n3 * 10) : this.Field3056, true);
                    } else {
                        this.Field3872.Method2150318(string8, n6 - (this.Field3872.Method2150310(string8) + 2), 2 + n3++ * 10, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377((float) (n4 + 1) * 0.89f, color) : this.Field3056, true);
                    }
                }
            }
        }
        boolean bl = HUD.Field2811.world.getBiome(HUD.Field2811.player.getPosition()).getBiomeName().equals("Hell");
        int n21 = (int) HUD.Field2811.player.posX;
        int n22 = (int) HUD.Field2811.player.posY;
        int n23 = (int) HUD.Field2811.player.posZ;
        float f13 = bl ? 8.0f : 0.125f;
        int n24 = (int) (HUD.Field2811.player.posX * (double) f13);
        int n25 = (int) (HUD.Field2811.player.posZ * (double) f13);
        if (this.Field3004.getValue().booleanValue()) {
            AliceMain.Field776.Method2150227(n7 - (n3 + 16));
        } else {
            AliceMain.Field776.Method2150227(n7 - (n4 + 16));
        }
        n3 = HUD.Field2811.currentScreen instanceof GuiChat ? 14 : 0;
        String string9 = string4 + "XYZ \u00a7f" + n21 + ", " + n22 + ", " + n23 + " \u00a7r" + string4 + "[\u00a7f" + n24 + ", " + n25 + "\u00a7r" + string4 + "]";
        String string10 = (this.Field3027.getValue() != false ? AliceMain.Field760.Method2150280(false) + " " : "") + (this.Field3026.getValue() != false ? string9 : "") + "";
        TextManager textManager = this.Field3872;
        float f14 = 2.0f;
        float f15 = n7 - (n3 += 10);
        if (this.Field3012.getValue().booleanValue() && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
            Map<Integer, Integer> map = this.Field3054;
            n2 = map.get(n7 - (n3 += 10));
        } else {
            n2 = this.Field3056;
        }
        textManager.Method2150318(string10, 2.0f, f15, n2, true);
        if (this.Field3031.getValue().booleanValue()) {
            this.Method2150610(true);
        }
        if (this.Field3033.getValue().booleanValue()) {
            this.Method2150615();
        }
        if (this.Field3037.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
            this.Method2150611();
        }
        if (this.Field3039.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NONE) {
            this.Method2150612();
        }
        GlStateManager.popMatrix();
        if (this.Field3034.getValue().booleanValue()) {
            this.Method2150616();
            this.Method2150617();
            this.Method2150618();
            this.Method2150619();
        }
        if (this.Field3036.getValue().booleanValue()) {
            this.Method2150614();
        }
        if (this.Field3047.getValue().booleanValue() && (this.Method2150507() || HUD.Field2811.currentScreen instanceof LuigiGuiOld || HUD.Field2811.currentScreen instanceof PhobosGui || HUD.Field2811.currentScreen instanceof FutureGui)) {
            this.Field3872.Method2150317("ur armor is kinda low rn :/", this.Field3048.getValue().floatValue(), this.Field3049.getValue().floatValue(), ColorUtil.Method2163378(255, 20, 20));
        }
    }

    private boolean Method2150507() {
        for (Map.Entry<Integer, ItemStack> entry : this.Method2150508().entrySet()) {
            if (entry.getValue().isEmpty()) continue;
            ItemStack itemStack = entry.getValue();
            double d = itemStack.getMaxDamage();
            double d2 = itemStack.getMaxDamage() - itemStack.getItemDamage();
            double d3 = d2 / d * 100.0;
            if (!(d3 < 30.0)) continue;
            return true;
        }
        return false;
    }

    private Map<Integer, ItemStack> Method2150508() {
        return this.Method2150509(5, 8);
    }

    private Map<Integer, ItemStack> Method2150509(int n2, int n3) {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        while (n2 <= n3) {
            hashMap.put(n2, (ItemStack) HUD.Field2811.player.inventoryContainer.getInventory().get(n2));
            ++n2;
        }
        return hashMap;
    }

    public Map<String, Integer> Method2150500() {
        return EntityUtil.Method2163560();
    }

    public void Method2150611() {
        Color color;
        int n2 = this.Field3872.Field2303;
        String string = "";
        switch (this.Field3037.getValue()) {
            case TIME: {
                string = string + MathUtil.Method2163863() + HUD.Field2811.player.getDisplayNameString();
                break;
            }
            case LONG: {
                string = string + "Welcome to LuigiHack " + HUD.Field2811.player.getDisplayNameString() + " ";
                break;
            }
            case CHRISTMAS: {
                string = string + "Merry Christmas " + HUD.Field2811.player.getDisplayNameString() + " :^)";
                break;
            }
            case CUSTOM: {
                string = string + this.Field3038.getValue();
                break;
            }
            default: {
                string = string + "Welcome " + HUD.Field2811.player.getDisplayNameString();
            }
        }
        Color color2 = color = this.Field3019.getValue() != false ? Colors.Field1782.Method2150586() : new Color(HUD.Method2150504().Field3016.getValue(), HUD.Method2150504().Field3017.getValue(), HUD.Method2150504().Field3018.getValue());
        if (this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
            this.Field3872.Method2150318(string, (float) n2 / 2.0f - (float) this.Field3872.Method2150310(string) / 2.0f + 2.0f, 2.0f, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(2) : this.Field3056, true);
        } else {
            this.Field3872.Method2150318(string, (float) n2 / 2.0f - (float) this.Field3872.Method2150310(string) / 2.0f + 2.0f, 2.0f, this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.StaticRainbow ? ColorUtil.Method2163377(0.89f, color) : this.Field3056, true);
        }
    }

    public void Method2150612() {
        int n2 = this.Field3872.Field2303;
        if (AliceMain.Field768.Method2150299()) {
            String string = (this.Field3039.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.GRAY ? "\u00a77" : "\u00a7c") + "Server not responding: " + MathUtil.Method2163861((float) AliceMain.Field768.Method2150290() / 1000.0f, 1) + "s.";
            this.Field3872.Method2150318(string, (float) n2 / 2.0f - (float) this.Field3872.Method2150310(string) / 2.0f + 2.0f, 20.0f, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(20) : this.Field3056, true);
        }
    }

    public void Method2150613() {
        if (AliceMain.Field756.Method2150180(AliceAura.class).Method2150364()) {
            this.Field3872.Method2150318((Object) ChatFormatting.GREEN + "CA", 2.0f, 210.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(AutoTrap.class).Method2150364()) {
            this.Field3872.Method2150318((Object) ChatFormatting.GREEN + "Trap", 2.0f, 220.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(Surround.class).Method2150364()) {
            this.Field3872.Method2150318((Object) ChatFormatting.GREEN + "SU", 2.0f, 230.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(InstantMine.class).Method2150364()) {
            this.Field3872.Method2150318((Object) ChatFormatting.GREEN + "Mine", 2.0f, 240.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(AliceAura.class).Method2150365()) {
            this.Field3872.Method2150318((Object) ChatFormatting.DARK_RED + "CA", 2.0f, 210.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(AutoTrap.class).Method2150365()) {
            this.Field3872.Method2150318((Object) ChatFormatting.DARK_RED + "Trap", 2.0f, 220.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(Surround.class).Method2150365()) {
            this.Field3872.Method2150318((Object) ChatFormatting.DARK_RED + "SU", 2.0f, 230.0f, this.Field3056, true);
        }
        if (AliceMain.Field756.Method2150180(InstantMine.class).Method2150365()) {
            this.Field3872.Method2150318((Object) ChatFormatting.DARK_RED + "Mine", 2.0f, 240.0f, this.Field3056, true);
        }
    }

    public void Method2150614() {
        int n2 = Util.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150620).mapToInt(ItemStack::getCount).sum();
        int n3 = Util.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150629).mapToInt(ItemStack::getCount).sum();
        int n4 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150628).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
            n4 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
            n2 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
            n3 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        int n5 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150627).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE) {
            n5 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        this.Field3872.Method2150318("T " + (Object) ChatFormatting.WHITE + n4, 2.0f, 250.0f, this.Field3056, true);
        this.Field3872.Method2150318("C " + (Object) ChatFormatting.WHITE + n2, 2.0f, 260.0f, this.Field3056, true);
        this.Field3872.Method2150318("X " + (Object) ChatFormatting.WHITE + n5, 2.0f, 270.0f, this.Field3056, true);
        this.Field3872.Method2150318("G " + (Object) ChatFormatting.WHITE + n3, 2.0f, 280.0f, this.Field3056, true);
    }

    public void Method2150615() {
        int n2 = this.Field3872.Field2303;
        int n3 = this.Field3872.Field2304;
        int n4 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150626).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
            n4 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (n4 > 0) {
            GlStateManager.enableTexture2D();
            int n5 = n2 / 2;
            int n6 = n3 - 55 - (HUD.Field2811.player.isInWater() && HUD.Field2811.playerController.gameIsSurvivalOrAdventure() ? 10 : 0);
            int n7 = n5 - 189 + 180 + 2;
            GlStateManager.enableDepth();
            RenderUtil.Field3115.zLevel = 200.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(Field2998, n7, n6);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HUD.Field2811.fontRenderer, Field2998, n7, n6, "");
            RenderUtil.Field3115.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.Field3872.Method2150317(n4 + "", n7 + 19 - 2 - this.Field3872.Method2150310(n4 + ""), n6 + 9, 0xFFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
        }
    }

    public void Method2150616() {
        int n2 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150625).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
            n2 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (n2 > 0) {
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            RenderUtil.Field3115.zLevel = 200.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(Field2999, 0, 20);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HUD.Field2811.fontRenderer, Field2999, 0, 20, "");
            RenderUtil.Field3115.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.Field3872.Method2150317(n2 + "", 10.0f, 30.0f, 0xFFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
        }
    }

    public void Method2150617() {
        int n2 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150624).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
            n2 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (n2 > 0) {
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            RenderUtil.Field3115.zLevel = 200.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(Field3000, 0, 37);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HUD.Field2811.fontRenderer, Field3000, 0, 37, "");
            RenderUtil.Field3115.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.Field3872.Method2150317(n2 + "", 10.0f, 47.0f, 0xFFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
        }
    }

    public void Method2150618() {
        int n2 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150623).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE) {
            n2 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (n2 > 0) {
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            RenderUtil.Field3115.zLevel = 200.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(Field3002, 0, 54);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HUD.Field2811.fontRenderer, Field3002, 10, 54, "");
            RenderUtil.Field3115.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.Field3872.Method2150317(n2 + "", 10.0f, 64.0f, 0xFFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
        }
    }

    public void Method2150619() {
        int n2 = HUD.Field2811.player.inventory.mainInventory.stream().filter(HUD::Method2150622).mapToInt(ItemStack::getCount).sum();
        if (HUD.Field2811.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE) {
            n2 += HUD.Field2811.player.getHeldItemOffhand().getCount();
        }
        if (n2 > 0) {
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            RenderUtil.Field3115.zLevel = 200.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(Field3001, 0, 69);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HUD.Field2811.fontRenderer, Field3001, 0, 69, "");
            RenderUtil.Field3115.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.Field3872.Method2150317(n2 + "", 10.0f, 79.0f, 0xFFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
        }
    }

    public void Method2150610(boolean bl) {
        int n2 = this.Field3872.Field2303;
        int n3 = this.Field3872.Field2304;
        GlStateManager.enableTexture2D();
        int n4 = n2 / 2;
        int n5 = 0;
        int n6 = n3 - 55 - (HUD.Field2811.player.isInWater() && HUD.Field2811.playerController.gameIsSurvivalOrAdventure() ? 10 : 0);
        for (ItemStack itemStack : HUD.Field2811.player.inventory.armorInventory) {
            ++n5;
            if (itemStack.isEmpty()) continue;
            int n7 = n4 - 90 + (9 - n5) * 20 + 2;
            GlStateManager.enableDepth();
            RenderUtil.Field3115.zLevel = 200.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(itemStack, n7, n6);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HUD.Field2811.fontRenderer, itemStack, n7, n6, "");
            RenderUtil.Field3115.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            String string = itemStack.getCount() > 1 ? itemStack.getCount() + "" : "";
            this.Field3872.Method2150317(string, n7 + 19 - 2 - this.Field3872.Method2150310(string), n6 + 9, 0xFFFFFF);
            if (!bl) continue;
            float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
            float f2 = 1.0f - f;
            int n8 = 100 - (int) (f2 * 100.0f);
            this.Field3872.Method2150317(n8 + "", n7 + 8 - this.Field3872.Method2150310(n8 + "") / 2, n6 - 11, ColorUtil.Method2163378((int) (f2 * 255.0f), (int) (f * 255.0f), 0));
        }
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
    }

    public void Method2150621(int n2) {
        if (!this.Field3055.isEmpty()) {
            int n3 = this.Field3872.Method2150321() + 7 + n2;
            for (Map.Entry<String, Integer> entry : this.Field3055.entrySet()) {
                String string = entry.getKey() + " ";
                int n4 = this.Field3872.Method2150321() + 1;
                this.Field3872.Method2150318(string, 2.0f, n3, this.Field3012.getValue() != false && this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow ? this.Field3054.get(n3) : this.Field3056, true);
                n3 += n4;
            }
        }
    }

    private boolean Method2150631(Object object) {
        return this.Field3050.getValue();
    }

    private boolean Method2150632(Object object) {
        return this.Field3050.getValue();
    }

    private boolean Method2150633(Object object) {
        return this.Field3047.getValue();
    }

    private boolean Method2150634(Object object) {
        return this.Field3047.getValue();
    }

    private boolean Method2150635(Object object) {
        return this.Field3009.getValue();
    }

    private boolean Method2150636(Object object) {
        return this.Field3009.getValue();
    }

    private boolean Method2150637(Object object) {
        return this.Field3037.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CUSTOM;
    }

    private boolean Method2150638(Object object) {
        return this.Field3029.getValue();
    }

    private boolean Method2150639(Object object) {
        return this.Field3009.getValue();
    }

    private boolean Method2150630(Object object) {
        return this.Field3009.getValue() != false && this.Field3004.getValue() != false;
    }

    private boolean Method2150641(Object object) {
        return this.Field3009.getValue();
    }

    private boolean Method2150642(Object object) {
        return this.Field3010.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150643(Object object) {
        return this.Field3010.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150644(Object object) {
        return this.Field3010.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150645(Object object) {
        return this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150646(Object object) {
        return this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150647(Object object) {
        return this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150648(Object object) {
        return this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150649(Object object) {
        return this.Field3010.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    private boolean Method2150640(Object object) {
        return this.Field3005.getValue() != IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Static,
        Future,
        StaticRainbow,
        Rainbow;

    }

    public static enum IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
        NONE,
        ALICE,
        LUIGI,
        WhiteVersion,
        CUSTOM;

    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        NONE,
        RED,
        GRAY;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        NONE,
        NAME,
        TIME,
        CHRISTMAS,
        LONG,
        CUSTOM;

    }
}

