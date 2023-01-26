

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.HashMap;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextUtil;
import net.minecraft.entity.player.EntityPlayer;

public class TotemPopCounter
        extends Module {
    public static HashMap<String, Integer> Field2475 = new HashMap();
    public static TotemPopCounter Field2476 = new TotemPopCounter();
    public Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2477 = this.Method2150366(new Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("PlayerName", TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.GOLD));
    public Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2478 = this.Method2150366(new Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Text", TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RED));
    public Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2479 = this.Method2150366(new Setting<TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Pop Amount", TextUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.GOLD));

    public TotemPopCounter() {
        super("TotemPopCounter", "Counts other players totem pops.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150743();
    }

    public static TotemPopCounter Method2150742() {
        if (Field2476 == null) {
            Field2476 = new TotemPopCounter();
        }
        return Field2476;
    }

    private void Method2150743() {
        Field2476 = this;
    }

    @Override
    public void Method2150372() {
        Field2475.clear();
    }

    public void Method2150744(EntityPlayer entityPlayer) {
        if (TotemPopCounter.Method2150742().Method2150386() && Field2475.containsKey(entityPlayer.getName())) {
            int n2 = Field2475.get(entityPlayer.getName());
            Field2475.remove(entityPlayer.getName());
            if (n2 == 1) {
                Command.Method2159697("" + TextUtil.Method2164747(entityPlayer.getName(), this.Field2477.getPlannedValue()) + TextUtil.Method2164747(" died after popping ", this.Field2478.getPlannedValue()) + TextUtil.Method2164747(String.valueOf(n2), this.Field2479.getPlannedValue()) + TextUtil.Method2164747(" totem.", this.Field2478.getPlannedValue()));
            } else {
                Command.Method2159697("" + TextUtil.Method2164747(entityPlayer.getName(), this.Field2477.getPlannedValue()) + TextUtil.Method2164747(" died after popping ", this.Field2478.getPlannedValue()) + TextUtil.Method2164747(String.valueOf(n2), this.Field2479.getPlannedValue()) + TextUtil.Method2164747(" totems.", this.Field2478.getPlannedValue()));
            }
        }
    }

    public void Method2150745(EntityPlayer entityPlayer) {
        if (TotemPopCounter.Method2150742().Method2150386()) {
            if (Feature.Method2150359()) {
                return;
            }
            if (TotemPopCounter.Field2811.player.equals((Object) entityPlayer)) {
                return;
            }
            int n2 = 1;
            if (Field2475.containsKey(entityPlayer.getName())) {
                n2 = Field2475.get(entityPlayer.getName());
                Field2475.put(entityPlayer.getName(), ++n2);
            } else {
                Field2475.put(entityPlayer.getName(), n2);
            }
            if (n2 == 1) {
                Command.Method2159697("" + TextUtil.Method2164747(entityPlayer.getName(), this.Field2477.getPlannedValue()) + TextUtil.Method2164747(" popped ", this.Field2478.getPlannedValue()) + TextUtil.Method2164747(String.valueOf(n2), this.Field2479.getPlannedValue()) + TextUtil.Method2164747(" totem.", this.Field2478.getPlannedValue()));
            } else {
                Command.Method2159697("" + TextUtil.Method2164747(entityPlayer.getName(), this.Field2477.getPlannedValue()) + TextUtil.Method2164747(" popped ", this.Field2478.getPlannedValue()) + TextUtil.Method2164747(String.valueOf(n2), this.Field2479.getPlannedValue()) + TextUtil.Method2164747(" totems.", this.Field2478.getPlannedValue()));
            }
        }
    }
}

