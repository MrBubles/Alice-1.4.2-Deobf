

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClickGui;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ComponentOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ItemOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleButtonOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ParticleSystem1;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Snow1;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class LuigiGuiOld
        extends GuiScreen {
    private static LuigiGuiOld Field612 = new LuigiGuiOld();
    final ScaledResolution Field613 = new ScaledResolution(Minecraft.getMinecraft());
    private final ArrayList<ComponentOld> Field614 = new ArrayList();
    public ParticleSystem1 Field617;
    Random Field615 = new Random();
    private ArrayList<Snow1> Field616 = new ArrayList();

    public LuigiGuiOld() {
        this.IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll();
        this.IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll();
    }

    public static LuigiGuiOld IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
        if (Field612 == null) {
            Field612 = new LuigiGuiOld();
        }
        return Field612;
    }

    public static LuigiGuiOld IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
        return LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
    }

    private static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(char c, int n2, ComponentOld componentOld) {
        componentOld.Method2159795(c, n2);
    }

    private static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(ComponentOld componentOld) {
        componentOld.Method2159790(componentOld.Method2159799() + 10);
    }

    private static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(ComponentOld componentOld) {
        componentOld.Method2159790(componentOld.Method2159799() - 10);
    }

    private static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(int n2, int n3, int n4, ComponentOld componentOld) {
        componentOld.Method2159794(n2, n3, n4);
    }

    private static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(int n2, int n3, int n4, ComponentOld componentOld) {
        componentOld.Method2159793(n2, n3, n4);
    }

    private static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(ScaledResolution scaledResolution, Snow1 snow1) {
        snow1.Method2159869(scaledResolution);
    }

    private static void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(int n2, int n3, float f, ComponentOld componentOld) {
        componentOld.Method2159792(n2, n3, f);
    }

    private static void IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(int n2, int n3, float f, ComponentOld componentOld) {
        componentOld.Method2159792(n2, n3, f);
    }

    private static void IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(ComponentOld componentOld) {
        componentOld.Method2159708().sort(Comparator.comparing(Feature::Method2150361));
    }

    private void IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll() {
        Field612 = this;
    }

    private void IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll() {
        int n2;
        for (n2 = 0; n2 < 100; ++n2) {
            for (int j = 0; j < 3; ++j) {
                Object object = new Snow1(25 * n2, j * -50, this.Field615.nextInt(3) + 1, this.Field615.nextInt(2) + 1);
                this.Field616.add((Snow1) object);
            }
        }
        n2 = -112;
        for (Object object : AliceMain.Field756.Method2150190()) {
            this.Field614.add(new ComponentOld(this, object.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(), n2 += 114, 6, true, (Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) ((Object) object)) {
                final Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field1324;
                final LuigiGuiOld Field1325;

                {
                    this.Field1325 = luigiGuiOld;
                    this.Field1324 = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll;
                    super(string, n2, n3, bl);
                }

                @Override
                public void Method2159789() {
                    AliceMain.Field756.Method2150199(this.Field1324).forEach(this::Method2159860);
                }

                private void Method2159860(Module module) {
                    if (!module.Field3716) {
                        this.Method2159796(new ModuleButtonOld(module));
                    }
                }
            });
        }
        this.Field614.forEach(LuigiGuiOld::IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll);
    }

    public void IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Module module) {
        block0:
        for (ComponentOld componentOld : this.Field614) {
            for (ItemOld itemOld : componentOld.Method2159708()) {
                if (!(itemOld instanceof ModuleButtonOld)) continue;
                ModuleButtonOld moduleButtonOld = (ModuleButtonOld) itemOld;
                Module module2 = moduleButtonOld.Method2159821();
                if (module == null || !module.equals(module2)) continue;
                moduleButtonOld.Method2159810();
                continue block0;
            }
        }
    }

    public void drawScreen(int n2, int n3, float f) {
        if (ClickGui.Method2150300().Field870.getValue().booleanValue()) {
            this.drawDefaultBackground();
        }
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        this.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
        this.Field614.forEach(arg_0 -> LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(n2, n3, f, arg_0));
        ScaledResolution scaledResolution2 = new ScaledResolution(this.mc);
        if (ClickGui.Method2150300().Field871.getValue().booleanValue()) {
            Color color = ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150586() : new Color(ClickGui.Method2150300().Field872.getValue(), ClickGui.Method2150300().Field873.getValue(), ClickGui.Method2150300().Field874.getValue(), ClickGui.Method2150300().Field875.getValue());
            this.drawGradientRect(0, 0, scaledResolution2.getScaledWidth(), scaledResolution2.getScaledHeight(), 0, ClickGui.Method2150300().Field814.getValue() != false ? Colors.Field1782.Method2150585() : new Color(color.getRed(), color.getGreen(), color.getBlue(), ClickGui.Method2150300().Field875.getValue() / 2).getRGB());
        }
        this.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
        this.Field614.forEach(arg_0 -> LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(n2, n3, f, arg_0));
        if (!this.Field616.isEmpty() && ClickGui.Method2150300().Field869.getValue().booleanValue()) {
            this.Field616.forEach(arg_0 -> LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(scaledResolution, arg_0));
        }
        if (this.Field617 != null && ClickGui.Method2150300().Field876.getValue().booleanValue()) {
            this.Field617.Method2159861(n2, n3);
        } else {
            this.Field617 = new ParticleSystem1(new ScaledResolution(this.mc));
        }
    }

    public void mouseClicked(int n2, int n3, int n4) {
        this.Field614.forEach(arg_0 -> LuigiGuiOld.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(n2, n3, n4, arg_0));
    }

    public void mouseReleased(int n2, int n3, int n4) {
        this.Field614.forEach(arg_0 -> LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(n2, n3, n4, arg_0));
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public final ArrayList<ComponentOld> IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        return this.Field614;
    }

    public void IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll() {
        int n2 = Mouse.getDWheel();
        if (n2 < 0) {
            this.Field614.forEach(LuigiGuiOld::IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll);
        } else if (n2 > 0) {
            this.Field614.forEach(LuigiGuiOld::IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
        }
    }

    public int IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll() {
        return -6;
    }

    public ComponentOld IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string) {
        for (ComponentOld componentOld : this.Field614) {
            if (!componentOld.Method2150361().equalsIgnoreCase(string)) continue;
            return componentOld;
        }
        return null;
    }

    public void keyTyped(char c, int n2) throws IOException {
        super.keyTyped(c, n2);
        this.Field614.forEach(arg_0 -> LuigiGuiOld.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(c, n2, arg_0));
    }

    public void updateScreen() {
        if (this.Field617 != null) {
            this.Field617.Method2159850();
        }
    }
}

