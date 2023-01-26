

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBow
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Comparator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentRotaionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BowAim
        extends Module {
    public static final Timer Field2187 = new Timer();
    public static double Field2188 = 0.0;
    public static double Field2189 = 0.0;
    private Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2190 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("RotateMode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Update));

    public BowAim() {
        super("BowAim", "BowAimbot", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private static void Method2161174(float f, float f2) {
        Field2188 = f;
        Field2189 = f2;
    }

    private static Float Method2161175(EntityPlayer entityPlayer) {
        return Float.valueOf(BowAim.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161176(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    private static boolean Method2161177(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161178(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    private static boolean Method2161179(EntityPlayer entityPlayer) {
        return entityPlayer != BowAim.Field2811.player;
    }

    @SubscribeEvent
    public void Method2161171(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        double d;
        double d2;
        float f;
        if (updateWalkingPlayerEvent.isCanceled()) {
            return;
        }
        if (!(BowAim.Field2811.player.getActiveItemStack().getItem() instanceof ItemBow)) {
            return;
        }
        EntityPlayer entityPlayer = BowAim.Field2811.world.playerEntities.stream().filter(BowAim::Method2161179).filter(BowAim::Method2161178).filter(BowAim::Method2161177).filter(BowAim::Method2161176).min(Comparator.comparing(BowAim::Method2161175)).orElse(null);
        if (entityPlayer == null) {
            return;
        }
        float f2 = (float) (BowAim.Field2811.player.getActiveItemStack().getMaxItemUseDuration() - BowAim.Field2811.player.getItemInUseCount()) / 20.0f;
        if ((f2 = (f2 * f2 + f2 * 2.0f) / 3.0f) >= 1.0f) {
            f2 = 1.0f;
        }
        if (Float.isNaN(f = (float) (-Math.toDegrees(this.Method2161172(entityPlayer, d2 = (double) (f2 * 3.0f), d = (double) 0.05f))))) {
            return;
        }
        double d3 = entityPlayer.posX - entityPlayer.lastTickPosX;
        double d4 = entityPlayer.posZ - entityPlayer.lastTickPosZ;
        double d5 = BowAim.Field2811.player.getDistance((Entity) entityPlayer);
        d5 -= d5 % 2.0;
        d3 = d5 / 2.0 * d3 * (BowAim.Field2811.player.isSprinting() ? 1.3 : 1.1);
        d4 = d5 / 2.0 * d4 * (BowAim.Field2811.player.isSprinting() ? 1.3 : 1.1);
        float f3 = (float) Math.toDegrees(Math.atan2(entityPlayer.posZ + d4 - BowAim.Field2811.player.posZ, entityPlayer.posX + d3 - BowAim.Field2811.player.posX)) - 90.0f;
        if (this.Field2190.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Silentlookat) {
            SilentRotaionUtil.Method2162907(f3, f);
        }
        if (this.Field2190.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Update) {
            RotationUtilSC.Method2162902(f3, f);
        }
        if (this.Field2190.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SilentUpdate) {
            SilentRotaionUtil.Method2162012(f3, f);
        }
        BowAim.Method2161174(f3, f);
        Field2187.Method2164750();
    }

    private float Method2161172(EntityPlayer entityPlayer, double d, double d2) {
        double d3 = entityPlayer.posY + (double) (entityPlayer.getEyeHeight() / 2.0f) - (BowAim.Field2811.player.posY + (double) BowAim.Field2811.player.getEyeHeight());
        double d4 = entityPlayer.posX - BowAim.Field2811.player.posX;
        double d5 = entityPlayer.posZ - BowAim.Field2811.player.posZ;
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        return this.Method2161173(d, d2, d6, d3);
    }

    private float Method2161173(double d, double d2, double d3, double d4) {
        double d5 = d2 * (d3 * d3);
        d4 = 2.0 * d4 * (d * d);
        d4 = d2 * (d5 + d4);
        d4 = Math.sqrt(d * d * d * d - d4);
        d = d * d - d4;
        d4 = Math.atan2(d * d + d4, d2 * d3);
        d = Math.atan2(d, d2 * d3);
        return (float) Math.min(d4, d);
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        None,
        Update,
        Silentlookat,
        SilentUpdate;

    }
}

