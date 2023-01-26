

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionManager
        extends Feature {
    private final Map<EntityPlayer, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field333 = new ConcurrentHashMap<EntityPlayer, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>();

    public void Method2150262() {
        this.Field333.clear();
    }

    public void Method2150263() {
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
        for (PotionEffect potionEffect : PotionManager.Field2811.player.getActivePotionEffects()) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2150250(potionEffect);
        }
        this.Field333.put((EntityPlayer) PotionManager.Field2811.player, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
    }

    public void Method2150264() {
        this.Method2150263();
        if (HUD.Method2150504().Method2150386() && HUD.Method2150504().Field3043.getValue().booleanValue() && Global.Method2150598().Field1133.getValue().booleanValue()) {
            ArrayList<EntityPlayer> arrayList = new ArrayList<EntityPlayer>();
            for (Map.Entry<EntityPlayer, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> entityPlayer : this.Field333.entrySet()) {
                boolean bl = true;
                for (EntityPlayer entityPlayer2 : PotionManager.Field2811.world.playerEntities) {
                    if (this.Field333.get((Object) entityPlayer2) == null) {
                        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
                        for (PotionEffect potionEffect : entityPlayer2.getActivePotionEffects()) {
                            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2150250(potionEffect);
                        }
                        this.Field333.put(entityPlayer2, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
                        bl = false;
                    }
                    if (!entityPlayer.getKey().equals((Object) entityPlayer2)) continue;
                    bl = false;
                }
                if (!bl) continue;
                arrayList.add(entityPlayer.getKey());
            }
            for (EntityPlayer entityPlayer : arrayList) {
                this.Field333.remove((Object) entityPlayer);
            }
        }
    }

    public List<PotionEffect> Method2150265() {
        return this.Method2150266((EntityPlayer) PotionManager.Field2811.player);
    }

    public List<PotionEffect> Method2150266(EntityPlayer entityPlayer) {
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = this.Field333.get((Object) entityPlayer);
        List<PotionEffect> list = new ArrayList<PotionEffect>();
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll != null) {
            list = iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2150261();
        }
        return list;
    }

    public void Method2150267(EntityPlayer entityPlayer) {
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
        this.Field333.put(entityPlayer, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
    }

    public PotionEffect[] Method2150268(EntityPlayer entityPlayer) {
        PotionEffect[] arrpotionEffect = new PotionEffect[3];
        for (PotionEffect potionEffect : this.Method2150266(entityPlayer)) {
            Potion potion = potionEffect.getPotion();
            switch (I18n.format((String) potion.getName(), (Object[]) new Object[0]).toLowerCase()) {
                case "strength": {
                    arrpotionEffect[0] = potionEffect;
                    break;
                }
                case "weakness": {
                    arrpotionEffect[1] = potionEffect;
                    break;
                }
                case "speed": {
                    arrpotionEffect[2] = potionEffect;
                }
            }
        }
        return arrpotionEffect;
    }

    public String Method2150269(PotionEffect potionEffect) {
        Potion potion = potionEffect.getPotion();
        return I18n.format((String) potion.getName(), (Object[]) new Object[0]) + " " + (potionEffect.getAmplifier() + 1) + " " + (Object) ChatFormatting.WHITE + Potion.getPotionDurationString((PotionEffect) potionEffect, (float) 1.0f);
    }

    public String Method2150260(PotionEffect potionEffect) {
        Potion potion = potionEffect.getPotion();
        switch (I18n.format((String) potion.getName(), (Object[]) new Object[0])) {
            case "Jump Boost":
            case "Speed": {
                return "\u00a7b" + this.Method2150269(potionEffect);
            }
            case "Resistance":
            case "Strength": {
                return "\u00a7c" + this.Method2150269(potionEffect);
            }
            case "Wither":
            case "Slowness":
            case "Weakness": {
                return "\u00a70" + this.Method2150269(potionEffect);
            }
            case "Absorption": {
                return "\u00a79" + this.Method2150269(potionEffect);
            }
            case "Haste":
            case "Fire Resistance": {
                return "\u00a76" + this.Method2150269(potionEffect);
            }
            case "Regeneration": {
                return "\u00a7d" + this.Method2150269(potionEffect);
            }
            case "Night Vision":
            case "Poison": {
                return "\u00a7a" + this.Method2150269(potionEffect);
            }
        }
        return "\u00a7f" + this.Method2150269(potionEffect);
    }

    public String Method2150271(EntityPlayer entityPlayer) {
        PotionEffect[] arrpotionEffect = this.Method2150268(entityPlayer);
        PotionEffect potionEffect = arrpotionEffect[0];
        PotionEffect potionEffect2 = arrpotionEffect[1];
        PotionEffect potionEffect3 = arrpotionEffect[2];
        return "" + (potionEffect != null ? "\u00a7c S" + (potionEffect.getAmplifier() + 1) + " " + Potion.getPotionDurationString((PotionEffect) potionEffect, (float) 1.0f) : "") + (potionEffect2 != null ? "\u00a78 W " + Potion.getPotionDurationString((PotionEffect) potionEffect2, (float) 1.0f) : "") + (potionEffect3 != null ? "\u00a7b S" + (potionEffect3.getAmplifier() + 1) + " " + Potion.getPotionDurationString((PotionEffect) Objects.requireNonNull(potionEffect2), (float) 1.0f) : "");
    }

    public String Method2150272(EntityPlayer entityPlayer) {
        PotionEffect[] arrpotionEffect = this.Method2150268(entityPlayer);
        PotionEffect potionEffect = arrpotionEffect[0];
        PotionEffect potionEffect2 = arrpotionEffect[1];
        PotionEffect potionEffect3 = arrpotionEffect[2];
        return "" + (potionEffect != null ? "\u00a7c S" + (potionEffect.getAmplifier() + 1) + " " : "") + (potionEffect2 != null ? "\u00a78 W " : "") + (potionEffect3 != null ? "\u00a7b S" + (potionEffect3.getAmplifier() + 1) + " " : "");
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private final List<PotionEffect> Field4237 = new ArrayList<PotionEffect>();

        public void Method2150250(PotionEffect potionEffect) {
            if (potionEffect != null) {
                this.Field4237.add(potionEffect);
            }
        }

        public List<PotionEffect> Method2150261() {
            return this.Field4237;
        }
    }
}

