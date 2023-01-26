

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PaletteHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RectHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Radar
        extends Module {
    public Setting<Integer> Field1362 = this.Method2150366(new Setting<Integer>("PosX", 860, 0, 900));
    public Setting<Integer> Field1363 = this.Method2150366(new Setting<Integer>("PosY", 15, 100, 350));
    public Setting<Integer> Field1364 = this.Method2150366(new Setting<Integer>("Size", 100, 30, 300));
    public int Field1365;

    public Radar() {
        super("3DRadar", "Radar", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
    }

    @Override
    @SubscribeEvent
    public void Method2150370(Render2DEvent render2DEvent) {
        double d = this.Field1362.getValue().intValue();
        double d2 = this.Field1363.getValue().intValue();
        ScaledResolution scaledResolution = new ScaledResolution(Field2811);
        this.Field1365 = 2;
        int n2 = this.Field1364.getValue();
        float f = (float) ((double) (scaledResolution.getScaledWidth() - n2) - d);
        float f2 = (float) d2;
        double d3 = Radar.Field2811.player.posX;
        double d4 = Radar.Field2811.player.posZ;
        RectHelper.Method2163680(f + 2.5f, f2 + 2.5f, f + (float) n2 - 2.5f, f2 + (float) n2 - 2.5f, 0.5f, PaletteHelper.Method2163674(2), PaletteHelper.Method2163674(11), false);
        RectHelper.Method2163680(f + 3.0f, f2 + 3.0f, f + (float) n2 - 3.0f, f2 + (float) n2 - 3.0f, 0.2f, PaletteHelper.Method2163674(2), PaletteHelper.Method2163674(11), false);
        RectHelper.Method2163686((double) f + ((double) ((float) n2 / 2.0f) - 0.5), (double) f2 + 3.5, (double) f + ((double) ((float) n2 / 2.0f) + 0.2), (double) (f2 + (float) n2) - 3.5, PaletteHelper.Method2163678(155, 100));
        RectHelper.Method2163686((double) f + 3.5, (double) f2 + ((double) ((float) n2 / 2.0f) - 0.2), (double) (f + (float) n2) - 3.5, (double) f2 + ((double) ((float) n2 / 2.0f) + 0.5), PaletteHelper.Method2163678(155, 100));
        for (EntityPlayer entityPlayer : Radar.Field2811.world.playerEntities) {
            if (entityPlayer == Radar.Field2811.player) continue;
            float f3 = Radar.Field2811.timer.renderPartialTicks;
            float f4 = (float) (entityPlayer.posX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double) f3 - d3) * 2.0f;
            float f5 = (float) (entityPlayer.posZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double) f3 - d4) * 2.0f;
            int n3 = Radar.Field2811.player.canEntityBeSeen((Entity) entityPlayer) ? new Color(255, 0, 0).getRGB() : new Color(255, 255, 0).getRGB();
            float f6 = (float) Math.cos((double) Radar.Field2811.player.rotationYaw * 0.017453292);
            float f7 = (float) Math.sin((double) Radar.Field2811.player.rotationYaw * 0.017453292);
            float f8 = -(f5 * f6 - f4 * f7);
            float f9 = -(f4 * f6 + f5 * f7);
            if (f8 > (float) n2 / 2.0f - 6.0f) {
                f8 = (float) n2 / 2.0f - 6.0f;
            } else if (f8 < -((float) n2 / 2.0f - 8.0f)) {
                f8 = -((float) n2 / 2.0f - 8.0f);
            }
            if (f9 > (float) n2 / 2.0f - 5.0f) {
                f9 = (float) n2 / 2.0f - 5.0f;
            } else if (f9 < -((float) n2 / 2.0f - 5.0f)) {
                f9 = -((float) n2 / 2.0f - 5.0f);
            }
            RectHelper.Method2163686(f + (float) n2 / 2.0f + f9 - 1.5f, f2 + (float) n2 / 2.0f + f8 - 1.5f, f + (float) n2 / 2.0f + f9 + 1.5f, f2 + (float) n2 / 2.0f + f8 + 1.5f, n3);
        }
    }
}

