

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ConnectionEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Announcer
        extends Module {
    public static final ArrayList<String> Field4044 = new ArrayList();
    public static final ArrayList<String> Field4045 = new ArrayList();
    public static String Field4039 = "ps://paste";
    static double Field4051;
    static double Field4052;
    static double Field4053;
    private final Setting<Integer> Field4040 = this.Method2150366(new Setting<Integer>("WelcomeDelay", 2, 0, 60));
    private final Setting<Boolean> Field4041 = this.Method2150366(new Setting<Boolean>("Welcome", true));
    private final Setting<Boolean> Field4042 = this.Method2150366(new Setting<Boolean>("ClientSide", true));
    private final Setting<Boolean> Field4043 = this.Method2150366(new Setting<Boolean>("Advertisement", false));
    private Random Field4046 = new Random();
    private Random Field4047 = new Random();
    private Timer Field4048 = new Timer();
    private Timer Field4049 = new Timer();
    private LinkedHashMap<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, Integer> Field4050 = new LinkedHashMap();

    public Announcer() {
        super("Announcer", "How to get muted quick.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
        Field4044.add("Welcome <player>!");
        Field4044.add("Hello <player>");
        Field4044.add("Nice weather isn't it, <player>");
        Field4045.add("Goodbye <player>!");
        Field4045.add("Have a good day <player>");
    }

    @Override
    public void Method2150379() {
        if (Announcer.Field2811.player == null || Announcer.Field2811.world == null) {
            return;
        }
    }

    @SubscribeEvent
    public void Method2161787(ConnectionEvent connectionEvent) {
        EntityPlayer entityPlayer;
        if (Announcer.Field2811.player == null || Announcer.Field2811.world == null) {
            return;
        }
        if (connectionEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            if (this.Field4041.getValue().booleanValue() && Announcer.Field2811.player.ticksExisted > 100 && connectionEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() != Announcer.Field2811.player.getUniqueID() && this.Field4048.Method2164751(this.Field4040.getValue().intValue())) {
                this.Method2161788(connectionEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                this.Field4048.Method2164761();
            }
        } else if (connectionEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1 && this.Field4041.getValue().booleanValue() && Announcer.Field2811.player.ticksExisted > 100 && connectionEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() != Announcer.Field2811.player.getUniqueID() && this.Field4048.Method2164751(this.Field4040.getValue().intValue()) && (entityPlayer = Announcer.Field2811.world.getPlayerEntityByUUID(connectionEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll())) != null) {
            this.Method2161789(entityPlayer.getName());
            this.Field4048.Method2164761();
        }
    }

    public void Method2161788(String string) {
        String string2;
        String string3 = string2 = this.Field4043.getValue() != false ? " Alice|.gg/EtTGvzt3nS" : "";
        if (this.Field4042.getValue().booleanValue()) {
            Command.Method2159696(Field4044.get(this.Field4046.nextInt(Field4044.size())).replace("<player>", string) + string2);
        } else {
            Announcer.Field2811.player.sendChatMessage(Field4044.get(this.Field4046.nextInt(Field4044.size())).replace("<player>", string) + string2);
        }
    }

    public void Method2161789(String string) {
        String string2;
        String string3 = string2 = this.Field4043.getValue() != false ? " Alice|.gg/EtTGvzt3nS" : "";
        if (this.Field4042.getValue().booleanValue()) {
            Command.Method2159696(Field4045.get(this.Field4046.nextInt(Field4045.size())).replace("<player>", string) + string2);
        } else {
            Announcer.Field2811.player.sendChatMessage(Field4045.get(this.Field4046.nextInt(Field4045.size())).replace("<player>", string) + string2);
        }
    }

    private void Method2161780(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (this.Field4050.containsKey((Object) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll)) {
            this.Field4050.put(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, this.Field4050.get((Object) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) + 1);
        } else {
            this.Field4050.put(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, 1);
        }
    }

    private double Method2161791(double d, double d2, double d3) {
        double d4 = d - Announcer.Field2811.player.posX;
        double d5 = d2 - Announcer.Field2811.player.posY;
        double d6 = d3 - Announcer.Field2811.player.posZ;
        return Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
    }

    private String Method2161792(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, int n2) {
        String string = this.Field4043.getValue() != false ? " thanks to AliceClient! | .gg/EtTGvzt3nS" : "!";
        String string2 = n2 > 1 ? "s" : "";
        switch (1.F
        ield304[iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ordinal()])
        {
            case 1: {
                return "I just picked up " + n2 + " item" + string2 + string;
            }
            case 2: {
                return "I just broke " + n2 + " block" + string2 + string;
            }
            case 3: {
                return "I just placed " + n2 + " block" + string2 + string;
            }
            case 4: {
                return "I just dropped " + n2 + " item" + string2 + string;
            }
            case 5: {
                return "I just ate " + n2 + " item" + string2 + string;
            }
        }
        return "I just did " + (Object) ((Object) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) + " " + n2 + " time" + string2 + string;
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        PLACE,
        BREAK,
        EAT,
        DROP,
        PICKUP;

    }
}

