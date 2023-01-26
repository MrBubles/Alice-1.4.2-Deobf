

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Aura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Particles;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class TargetHud
        extends Module {
    private final Timer Field2439 = new Timer();
    private final ArrayList<Particles> Field2444 = new ArrayList();
    private final Timer Field2447 = new Timer();
    public Setting<Float> Field2437 = this.Method2150366(new Setting<Float>("PosX", Float.valueOf(0.7f), Float.valueOf(0.0f), Float.valueOf(1.0f)));
    public Setting<Float> Field2438 = this.Method2150366(new Setting<Float>("PosY", Float.valueOf(0.8f), Float.valueOf(0.0f), Float.valueOf(1.0f)));
    float Field2448;
    int Field2449;
    int Field2450 = 0;
    boolean Field2451 = false;
    float Field2452 = 0.0f;
    float Field2453 = 0.0f;
    private Entity Field2440;
    private Entity Field2441;
    private float Field2442;
    private float Field2443;
    private boolean Field2445;
    private double Field2446 = 1.0;

    public TargetHud() {
        super("TargetHud", "TargetHud", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
    }

    public static void Method2150736(double d, double d2, float f, float f2, int n2, int n3, int n4, int n5, float f3, float f4) {
        ResourceLocation resourceLocation = new ResourceLocation("textures/entity/steve.png");
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        GL11.glEnable((int) 3042);
        Gui.drawScaledCustomSizeModalRect((int) ((int) d), (int) ((int) d2), (float) f, (float) f2, (int) n2, (int) n3, (int) n4, (int) n5, (float) f3, (float) f4);
        GL11.glDisable((int) 3042);
    }

    public static void Method2150737(double d, double d2, float f, float f2, int n2, int n3, int n4, int n5, float f3, float f4, AbstractClientPlayer abstractClientPlayer) {
        ResourceLocation resourceLocation = abstractClientPlayer.getLocationSkin();
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        GL11.glEnable((int) 3042);
        Gui.drawScaledCustomSizeModalRect((int) ((int) d), (int) ((int) d2), (float) f, (float) f2, (int) n2, (int) n3, (int) n4, (int) n5, (float) f3, (float) f4);
        GL11.glDisable((int) 3042);
    }

    public static EntityPlayer Method2150738() {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : TargetHud.Field2811.world.playerEntities) {
            if (entityPlayer2 == TargetHud.Field2811.player || AliceMain.Field765.Method2150169(entityPlayer2))
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(TargetHud.Field2811.player.getDistanceSq((Entity) entityPlayer2) < TargetHud.Field2811.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public int Method2150739() {
        return (int) ((float) Mouse.getX() / 2.0f);
    }

    public int Method2150730() {
        ScaledResolution scaledResolution = new ScaledResolution(Field2811);
        return (-Mouse.getY() + scaledResolution.getScaledHeight() + scaledResolution.getScaledHeight()) / 2;
    }

    public boolean Method2150741() {
        return (float) this.Method2150739() > this.Field2452 + 38.0f + 2.0f && (float) this.Method2150739() < this.Field2452 + 129.0f && (float) this.Method2150730() > this.Field2453 - 34.0f && (float) this.Method2150730() < this.Field2453 + 14.0f;
    }

    @Override
    @SubscribeEvent
    public void Method2150370(Render2DEvent render2DEvent) {
        Iterator iterator;
        int n2;
        ScaledResolution scaledResolution = new ScaledResolution(Field2811);
        this.Field2452 = (float) scaledResolution.getScaledWidth() * this.Field2437.getValue().floatValue();
        this.Field2453 = (float) scaledResolution.getScaledHeight() * this.Field2438.getValue().floatValue();
        if (TargetHud.Field2811.currentScreen instanceof GuiChat) {
            this.Field2440 = TargetHud.Field2811.player;
        } else {
            Object object = AutoCrystal.Field47 != null ? AutoCrystal.Field47 : (Aura.Field2488 instanceof EntityPlayer ? (EntityPlayer) Aura.Field2488 : (this.Field2440 = TargetHud.Method2150738() != null ? TargetHud.Method2150738() : null));
        }
        if (Mouse.isButtonDown((int) 0) && this.Method2150741()) {
            if (!this.Field2451) {
                this.Field2449 = (int) ((float) this.Method2150739() - this.Field2437.getValue().floatValue() * (float) scaledResolution.getScaledWidth());
                this.Field2450 = (int) ((float) this.Method2150730() - this.Field2438.getValue().floatValue() * (float) scaledResolution.getScaledHeight());
            }
            this.Field2451 = true;
        } else {
            this.Field2451 = false;
        }
        float f = 38.0f;
        if (this.Field2439.Method2164755(9L)) {
            if (this.Field2440 != null && (this.Field2440.getDistance((Entity) TargetHud.Field2811.player) > 15.0f || TargetHud.Field2811.world.getEntityByID(Objects.requireNonNull(this.Field2440).getEntityId()) == null)) {
                this.Field2446 = Math.max(0.0, this.Field2446 - (double) this.Field2447.Method2164759() / 8.0E13 - (1.0 - this.Field2446) / 10.0);
                this.Field2444.clear();
                this.Field2439.Method2164750();
            } else {
                this.Field2446 = Math.min(1.0, this.Field2446 + (double) this.Field2447.Method2164759() / 4.0E14 + (1.0 - this.Field2446) / 10.0);
            }
        }
        if (this.Field2440 == null || !(this.Field2440 instanceof EntityPlayer)) {
            this.Field2444.clear();
            return;
        }
        if (this.Field2446 == 0.0) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate((double) ((double) (this.Field2452 + 38.0f + 2.0f + 64.5f) * (1.0 - this.Field2446)), (double) ((double) (this.Field2453 - 34.0f + 24.0f) * (1.0 - this.Field2446)), (double) 0.0);
        GlStateManager.scale((double) this.Field2446, (double) this.Field2446, (double) 0.0);
        EntityPlayer entityPlayer = (EntityPlayer) this.Field2440;
        double d = TargetHud.Field2811.player.getDistance(this.Field2440);
        String string = ((EntityPlayer) this.Field2440).getName();
        Particles.Method2163645(this.Field2452 + 38.0f + 2.0f, this.Field2453 - 34.0f, 129.0, 48.0, 8.0, new Color(0, 0, 0, 110));
        GlStateManager.popMatrix();
        int n3 = (int) ((float) ((EntityPlayer) this.Field2440).hurtTime * 0.35f);
        for (Particles particles : this.Field2444) {
            if (!(particles.Field1331 > 4.0)) continue;
            particles.Method2163635();
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate((double) ((double) (this.Field2452 + 38.0f + 2.0f + 64.5f) * (1.0 - this.Field2446)), (double) ((double) (this.Field2453 - 34.0f + 24.0f) * (1.0 - this.Field2446)), (double) 0.0);
        GlStateManager.scale((double) this.Field2446, (double) this.Field2446, (double) 0.0);
        if (this.Field2440 instanceof AbstractClientPlayer) {
            double d2 = -(((AbstractClientPlayer) this.Field2440).hurtTime * 23);
            Particles.Method2163653(new Color(255, (int) (255.0 + d2), (int) (255.0 + d2)));
            try {
                TargetHud.Method2150737(this.Field2452 + 38.0f + 6.0f + (float) n3 / 2.0f, this.Field2453 - 34.0f + 5.0f + (float) n3 / 2.0f, 3.0f, 3.0f, 3, 3, 30 - n3, 30 - n3, 24.0f, 24.5f, (AbstractClientPlayer) entityPlayer);
            } catch (Exception exception) {
                // empty catch block
            }
            TargetHud.Method2150737(this.Field2452 + 38.0f + 6.0f + (float) n3 / 2.0f, this.Field2453 - 34.0f + 5.0f + (float) n3 / 2.0f, 15.0f, 3.0f, 3, 3, 30 - n3, 30 - n3, 24.0f, 24.5f, (AbstractClientPlayer) entityPlayer);
            Particles.Method2163653(Color.WHITE);
        }
        double d3 = 7.0;
        TargetHud.Field2811.fontRenderer.drawString("Distance: " + MathUtil.Method2163858(d, 1), (int) (this.Field2452 + 38.0f + 6.0f + 30.0f + 3.0f), (int) (this.Field2453 - 34.0f + 5.0f + 15.0f + 2.0f), Color.WHITE.hashCode());
        GlStateManager.pushMatrix();
        GL11.glEnable((int) 3089);
        Particles.Method2163651(this.Field2452 + 38.0f + 6.0f + 30.0f + 3.0f, (double) (this.Field2453 - 34.0f + 5.0f + 15.0f) - 7.0, 91.0, 30.0);
        TargetHud.Field2811.fontRenderer.drawString("Name: " + string, (int) (this.Field2452 + 38.0f + 6.0f + 30.0f + 3.0f), (int) ((double) (this.Field2453 - 34.0f + 5.0f + 15.0f) - 7.0), Color.WHITE.hashCode());
        GL11.glDisable((int) 3089);
        GlStateManager.popMatrix();
        if (!String.valueOf(((EntityPlayer) this.Field2440).getHealth()).equals("NaN")) {
            this.Field2443 = Math.min(20.0f, ((EntityPlayer) this.Field2440).getHealth());
        }
        if (String.valueOf(this.Field2442).equals("NaN")) {
            this.Field2442 = (float) (Math.random() * 20.0);
        }
        if (d > 20.0 || this.Field2440.isDead) {
            this.Field2443 = 0.0f;
        }
        int n4 = 6;
        if (this.Field2439.Method2164755(16L)) {
            this.Field2442 = (this.Field2442 * 5.0f + this.Field2443) / 6.0f;
            this.Field2448 += 0.1f;
            for (Particles particles : this.Field2444) {
                particles.Method2163636();
                if (!(particles.Field1331 < 1.0)) continue;
                this.Field2444.remove(particles);
            }
            this.Field2439.Method2164750();
        }
        float f2 = 6.0f;
        float f3 = this.Field2452 + 38.0f;
        if ((double) this.Field2442 > 0.1) {
            n2 = 0;
            while ((float) n2 < this.Field2442 * 4.0f) {
                int n5 = -1;
                iterator = new Color(78, 161, 253, 100);
                Color object3 = new Color(78, 253, 154, 100);
                n5 = Particles.Method2163646((Color) ((Object) iterator), object3, (Math.sin(this.Field2448 + this.Field2452 * 0.4f + (float) n2 * 0.6f / 14.0f) + 1.0) * 0.5).hashCode();
                Gui.drawRect((int) ((int) (f3 + f2)), (int) ((int) (this.Field2453 + 5.0f)), (int) ((int) ((double) (f3 + 1.0f) + (double) f2 * 1.25)), (int) ((int) (this.Field2453 + 10.0f)), (int) n5);
                f2 += 1.0f;
                ++n2;
            }
        }
        if (((EntityPlayer) this.Field2440).hurtTime == 9 && !this.Field2445 || this.Field2441 != null && ((EntityPlayer) this.Field2441).hurtTime == 9 && !this.Field2445) {
            for (n2 = 0; n2 <= 15; ++n2) {
                Particles particles = new Particles();
                iterator = new Color(78, 161, 253, 100);
                Color color = new Color(78, 253, 154, 100);
                Color color2 = Particles.Method2163646(iterator, color, (Math.sin(this.Field2448 + this.Field2452 * 0.4f + (float) n2) + 1.0) * 0.5);
                particles.Method2163637(this.Field2452 + 55.0f, this.Field2453 - 15.0f, (Math.random() - 0.5) * 2.0 * 1.4, (Math.random() - 0.5) * 2.0 * 1.4, Math.random() * 4.0, color2);
                this.Field2444.add(particles);
            }
            this.Field2445 = true;
        }
        if (((EntityPlayer) this.Field2440).hurtTime == 8) {
            this.Field2445 = false;
        }
        if (!(d > 20.0) && !this.Field2440.isDead) {
            AliceMain.Field766.Method2150317(MathUtil.Method2163861(this.Field2442, 1) + "", (int) ((double) (f3 + 2.0f) + (double) f2 * 1.25), (int) (this.Field2453 + 2.5f), -1);
        }
        if (this.Field2441 != this.Field2440) {
            this.Field2441 = this.Field2440;
        }
        ArrayList<Particles> arrayList = new ArrayList<Particles>();
        for (Particles particles : this.Field2444) {
            if (!(particles.Field1331 <= 1.0)) continue;
            arrayList.add(particles);
        }
        for (Particles particles : arrayList) {
            this.Field2444.remove(particles);
        }
        GlStateManager.popMatrix();
        this.Field2447.Method2164750();
    }
}

