

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.player.EntityPlayer
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleTools;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Notifications;
import net.minecraft.entity.player.EntityPlayer;

public class TotemPopManager
        extends Feature {
    private final Set<EntityPlayer> Field3450 = new HashSet<EntityPlayer>();
    private Notifications Field3448;
    private Map<EntityPlayer, Integer> Field3449 = new ConcurrentHashMap<EntityPlayer, Integer>();

    public void Method2150336() {
        if (this.Field3448.Field4604.Method2164755(this.Field3448.Field4577.getValue().intValue()) && this.Field3448.Method2150386() && this.Field3448.Field4575.getValue().booleanValue()) {
            for (EntityPlayer entityPlayer : this.Field3450) {
                if (entityPlayer == null) continue;
                int n2 = 0;
                for (char c : entityPlayer.getName().toCharArray()) {
                    n2 += c;
                    n2 *= 10;
                }
                Command.Method2159699(this.Method2150337(entityPlayer), n2, this.Field3448.Field4576.getValue());
                this.Field3450.remove((Object) entityPlayer);
                this.Field3448.Field4604.Method2164750();
                break;
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String Method2150337(EntityPlayer entityPlayer) {
        if (this.Method2150349(entityPlayer) == 1) {
            if (!ModuleTools.Method2150698().Method2150364())
                return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " popped " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totem.";
            switch (1.F ield325[ModuleTools.Method2150698().Field227.getValue().ordinal()]){
                case 1: {
                    return (Object) ChatFormatting.RED + "[Future] " + (Object) ChatFormatting.GREEN + entityPlayer.getName() + (Object) ChatFormatting.GRAY + " just popped " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.GRAY + " totem.";
                }
                case 2: {
                    return (Object) ChatFormatting.GOLD + entityPlayer.getName() + (Object) ChatFormatting.RED + " popped " + (Object) ChatFormatting.GOLD + this.Method2150349(entityPlayer) + (Object) ChatFormatting.RED + " totem.";
                }
                case 3: {
                    return (Object) ChatFormatting.DARK_PURPLE + "[" + (Object) ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + (Object) ChatFormatting.DARK_PURPLE + "] " + (Object) ChatFormatting.LIGHT_PURPLE + entityPlayer.getName() + " has popped " + (Object) ChatFormatting.RED + this.Method2150349(entityPlayer) + (Object) ChatFormatting.LIGHT_PURPLE + " time in total!";
                }
                case 4: {
                    return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " popped " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totem.";
                }
            }
            return "";
        } else {
            if (!ModuleTools.Method2150698().Method2150364())
                return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " popped " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totems.";
            switch (1.F ield325[ModuleTools.Method2150698().Field227.getValue().ordinal()]){
                case 1: {
                    return (Object) ChatFormatting.RED + "[Future] " + (Object) ChatFormatting.GREEN + entityPlayer.getName() + (Object) ChatFormatting.GRAY + " just popped " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.GRAY + " totems.";
                }
                case 2: {
                    return (Object) ChatFormatting.GOLD + entityPlayer.getName() + (Object) ChatFormatting.RED + " popped " + (Object) ChatFormatting.GOLD + this.Method2150349(entityPlayer) + (Object) ChatFormatting.RED + " totems.";
                }
                case 3: {
                    return (Object) ChatFormatting.DARK_PURPLE + "[" + (Object) ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + (Object) ChatFormatting.DARK_PURPLE + "] " + (Object) ChatFormatting.LIGHT_PURPLE + entityPlayer.getName() + " has popped " + (Object) ChatFormatting.RED + this.Method2150349(entityPlayer) + (Object) ChatFormatting.LIGHT_PURPLE + " times in total!";
                }
                case 4: {
                    return (Object) ChatFormatting.WHITE + entityPlayer.getName() + " popped " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totems.";
                }
            }
        }
        return "";
    }

    public void Method2150338() {
        this.Method2150344(this.Field3448.Field4578.getValue());
    }

    public void Method2150339() {
        this.Field3448 = AliceMain.Field756.Method2150180(Notifications.class);
    }

    public void Method2150330(EntityPlayer entityPlayer) {
        this.Method2150347(entityPlayer);
        if (!entityPlayer.equals((Object) TotemPopManager.Field2811.player)) {
            this.Field3450.add(entityPlayer);
            this.Field3448.Field4604.Method2164750();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String Method2150341(EntityPlayer entityPlayer) {
        if (this.Method2150349(entityPlayer) == 1) {
            if (!ModuleTools.Method2150698().Method2150364())
                return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totem!";
            switch (1.F ield325[ModuleTools.Method2150698().Field227.getValue().ordinal()]){
                case 1: {
                    return (Object) ChatFormatting.RED + "[Future] " + (Object) ChatFormatting.GREEN + entityPlayer.getName() + (Object) ChatFormatting.GRAY + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.GRAY + " totem.";
                }
                case 2: {
                    return (Object) ChatFormatting.GOLD + entityPlayer.getName() + (Object) ChatFormatting.RED + " died after popping " + (Object) ChatFormatting.GOLD + this.Method2150349(entityPlayer) + (Object) ChatFormatting.RED + " totem.";
                }
                case 3: {
                    return (Object) ChatFormatting.DARK_PURPLE + "[" + (Object) ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + (Object) ChatFormatting.DARK_PURPLE + "] " + (Object) ChatFormatting.LIGHT_PURPLE + entityPlayer.getName() + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.LIGHT_PURPLE + " time!";
                }
                case 4: {
                    return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totem!";
                }
            }
            return null;
        } else {
            if (!ModuleTools.Method2150698().Method2150364())
                return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totems!";
            switch (1.F ield325[ModuleTools.Method2150698().Field227.getValue().ordinal()]){
                case 1: {
                    return (Object) ChatFormatting.RED + "[Future] " + (Object) ChatFormatting.GREEN + entityPlayer.getName() + (Object) ChatFormatting.GRAY + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.GRAY + " totems.";
                }
                case 2: {
                    return (Object) ChatFormatting.GOLD + entityPlayer.getName() + (Object) ChatFormatting.RED + " died after popping " + (Object) ChatFormatting.GOLD + this.Method2150349(entityPlayer) + (Object) ChatFormatting.RED + " totems.";
                }
                case 3: {
                    return (Object) ChatFormatting.DARK_PURPLE + "[" + (Object) ChatFormatting.LIGHT_PURPLE + "DotGod.CC" + (Object) ChatFormatting.DARK_PURPLE + "] " + (Object) ChatFormatting.LIGHT_PURPLE + entityPlayer.getName() + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.LIGHT_PURPLE + " times!";
                }
                case 4: {
                    return AliceMain.Field761.Method2150112() + (Object) ChatFormatting.WHITE + entityPlayer.getName() + " died after popping " + (Object) ChatFormatting.GREEN + this.Method2150349(entityPlayer) + (Object) ChatFormatting.WHITE + " Totems!";
                }
            }
        }
        return null;
    }

    public void Method2150342(EntityPlayer entityPlayer) {
        if (this.Method2150349(entityPlayer) != 0 && !entityPlayer.equals((Object) TotemPopManager.Field2811.player) && this.Field3448.Method2150386() && this.Field3448.Field4575.getValue().booleanValue()) {
            int n2 = 0;
            for (char c : entityPlayer.getName().toCharArray()) {
                n2 += c;
                n2 *= 10;
            }
            Command.Method2159699(this.Method2150341(entityPlayer), n2, this.Field3448.Field4576.getValue());
            this.Field3450.remove((Object) entityPlayer);
        }
        this.Method2150346(entityPlayer);
    }

    public void Method2150343(EntityPlayer entityPlayer, boolean bl) {
        if (bl) {
            this.Method2150346(entityPlayer);
        }
    }

    public void Method2150344(boolean bl) {
        if (bl) {
            this.Method2150345();
        }
    }

    public void Method2150345() {
        this.Field3449 = new ConcurrentHashMap<EntityPlayer, Integer>();
    }

    public void Method2150346(EntityPlayer entityPlayer) {
        this.Method2150348(entityPlayer, 0);
    }

    public void Method2150347(EntityPlayer entityPlayer) {
        this.Field3449.merge(entityPlayer, 1, Integer::sum);
    }

    public void Method2150348(EntityPlayer entityPlayer, int n2) {
        this.Field3449.put(entityPlayer, n2);
    }

    public int Method2150349(EntityPlayer entityPlayer) {
        Integer n2 = this.Field3449.get((Object) entityPlayer);
        if (n2 == null) {
            return 0;
        }
        return n2;
    }

    public String Method2150340(EntityPlayer entityPlayer) {
        return "\u00a7f" + (this.Method2150349(entityPlayer) <= 0 ? "" : "-" + this.Method2150349(entityPlayer) + " ");
    }
}

