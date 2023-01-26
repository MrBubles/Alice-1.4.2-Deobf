

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.DestroyBlockProgress
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class HudComponents
        extends Module {
    private static final ResourceLocation Field2697;
    private static final double Field2698 = 1.5707963267948966;
    private static HudComponents Field2696;

    static {
        Field2697 = new ResourceLocation("textures/gui/container/shulker_box.png");
    }

    public Setting<Boolean> Field2699 = this.Method2150366(new Setting<Boolean>("WaterMark", false));
    public Setting<Boolean> Field2700 = this.Method2150366(new Setting<Boolean>("Inventory", false));
    public Setting<Boolean> Field2701 = this.Method2150366(new Setting<Object>("InventoryBackGround", Boolean.valueOf(false), this::Method2150693));
    public Setting<Integer> Field2702 = this.Method2150366(new Setting<Object>("InvX", Integer.valueOf(564), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150692));
    public Setting<Integer> Field2703 = this.Method2150366(new Setting<Object>("InvY", Integer.valueOf(467), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150691));
    public Setting<Integer> Field2704 = this.Method2150366(new Setting<Object>("InvFineX", Integer.valueOf(0), this::Method2150680));
    public Setting<Integer> Field2705 = this.Method2150366(new Setting<Object>("InvFineY", Integer.valueOf(0), this::Method2150689));
    public Setting<Boolean> Field2706 = this.Method2150366(new Setting<Object>("RenderXCarry", Boolean.valueOf(false), this::Method2150688));
    public Setting<Integer> Field2707 = this.Method2150366(new Setting<Object>("InvH", Integer.valueOf(3), this::Method2150687));
    public Setting<Boolean> Field2708 = this.Method2150366(new Setting<Boolean>("HoleHUD", false));
    public Setting<Integer> Field2709 = this.Method2150366(new Setting<Object>("HoleX", Integer.valueOf(279), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150686));
    public Setting<Integer> Field2710 = this.Method2150366(new Setting<Object>("HoleY", Integer.valueOf(485), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150685));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2711 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Compass", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE));
    public Setting<Integer> Field2712 = this.Method2150366(new Setting<Object>("CompX", Integer.valueOf(472), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150684));
    public Setting<Integer> Field2713 = this.Method2150366(new Setting<Object>("CompY", Integer.valueOf(424), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150683));
    public Setting<Integer> Field2714 = this.Method2150366(new Setting<Object>("Scale", Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(10), this::Method2150682));
    public Setting<Boolean> Field2715 = this.Method2150366(new Setting<Boolean>("PlayerViewer", false));
    public Setting<Integer> Field2716 = this.Method2150366(new Setting<Object>("PlayerX", Integer.valueOf(752), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150681));
    public Setting<Integer> Field2717 = this.Method2150366(new Setting<Object>("PlayerY", Integer.valueOf(497), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150670));
    public Setting<Float> Field2718 = this.Method2150366(new Setting<Object>("PlayerScale", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(2.0f), this::Method2150679));
    public Setting<Boolean> Field2719 = this.Method2150366(new Setting<Boolean>("New Logo", false));
    public Setting<Integer> Field2720 = this.Method2150366(new Setting<Object>("New LogoX", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150678));
    public Setting<Integer> Field2721 = this.Method2150366(new Setting<Object>("New LogoY", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150677));
    public Setting<Integer> Field2722 = this.Method2150366(new Setting<Object>("New LogoFineX", Integer.valueOf(0), this::Method2150676));
    public Setting<Integer> Field2723 = this.Method2150366(new Setting<Object>("New LogoFineY", Integer.valueOf(0), this::Method2150675));
    public Timer Field2725 = new Timer();
    int Field2724 = 0;

    public HudComponents() {
        super("HudComponents", "HudComponents", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, false, false, true);
        Field2696 = this;
    }

    public static HudComponents Method2150651() {
        if (Field2696 == null) {
            Field2696 = new HudComponents();
        }
        return Field2696;
    }

    public static EntityPlayer Method2150653() {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : HudComponents.Field2811.world.playerEntities) {
            if (entityPlayer2 == HudComponents.Field2811.player || AliceMain.Field765.Method2150169(entityPlayer2))
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(HudComponents.Field2811.player.getDistanceSq((Entity) entityPlayer2) < HudComponents.Field2811.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    private static double Method2150659(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        double d = Math.toRadians(MathHelper.wrapDegrees((float) HudComponents.Field2811.player.rotationYaw));
        int n2 = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.ordinal();
        return d + (double) n2 * 1.5707963267948966;
    }

    private static void Method2150668() {
        GL11.glPushMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.clear((int) 256);
        GlStateManager.enableBlend();
        GlStateManager.color((float) 255.0f, (float) 255.0f, (float) 255.0f, (float) 255.0f);
    }

    private static void Method2150669() {
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
        GL11.glPopMatrix();
    }

    private static void Method2150660() {
        GL11.glPushMatrix();
        GL11.glDepthMask((boolean) true);
        GlStateManager.clear((int) 256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.scale((float) 1.0f, (float) 1.0f, (float) 0.01f);
    }

    private static void Method2150671() {
        GlStateManager.scale((float) 1.0f, (float) 1.0f, (float) 1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
        GL11.glPopMatrix();
    }

    public static void Method2150674(int n2, int n3, int n4, int n5) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) n2, (float) n3, (float) 0.0f);
        GL11.glBegin((int) 7);
        GL11.glTexCoord2f((float) 0.0f, (float) 0.0f);
        GL11.glVertex3f((float) 0.0f, (float) 0.0f, (float) 0.0f);
        GL11.glTexCoord2f((float) 0.0f, (float) 1.0f);
        GL11.glVertex3f((float) 0.0f, (float) n5, (float) 0.0f);
        GL11.glTexCoord2f((float) 1.0f, (float) 1.0f);
        GL11.glVertex3f((float) n4, (float) n5, (float) 0.0f);
        GL11.glTexCoord2f((float) 1.0f, (float) 0.0f);
        GL11.glVertex3f((float) n4, (float) 0.0f, (float) 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    public void Method2150652() {
        AliceMain.Field766.Method2150328("Alice", this.Field2720.getValue() + this.Field2722.getValue(), this.Field2721.getValue() + this.Field2723.getValue(), Colors.Method2150583().Method2150585());
    }

    @Override
    public void Method2150370(Render2DEvent render2DEvent) {
        if (HudComponents.Method2150359()) {
            return;
        }
        if (this.Field2715.getValue().booleanValue()) {
            this.Method2150656();
        }
        if (this.Field2711.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE) {
            this.Method2150654();
        }
        if (this.Field2708.getValue().booleanValue()) {
            this.Method2150650(render2DEvent.Field2694);
        }
        if (this.Field2700.getValue().booleanValue()) {
            this.Method2150667();
        }
        if (this.Field2719.getValue().booleanValue()) {
            this.Method2150652();
        }
        if (this.Field2699.getValue().booleanValue()) {
            RenderUtil.Method2163083(4.0f, 4.0f, AliceMain.Field766.Method2150310("LuigiHack") + 4 + AliceMain.Field766.Method2150310(HudComponents.Field2811.player.getName()) + AliceMain.Field766.Method2150310(" 9999 ms ") + 140, 18.0f, new Color(35, 35, 40, 230).getRGB());
            if (this.Field2725.Method2164755(350L)) {
                ++this.Field2724;
                this.Field2725.Method2164750();
            }
            if (this.Field2724 == 21) {
                this.Field2724 = 0;
            }
            String string = "_";
            String string2 = "L_";
            String string3 = "Lu_";
            String string4 = "Lui_";
            String string5 = "Luig_";
            String string6 = "Luigi_";
            String string7 = "LuigiH_";
            String string8 = "LuigiHa_";
            String string9 = "LuigiHac_";
            String string10 = "LuigiHack";
            String string11 = "LuigiHack";
            String string12 = "LuigiHack";
            String string13 = "LuigiHac_";
            String string14 = "LuigiHa_";
            String string15 = "LuigiH_";
            String string16 = "Luigi_";
            String string17 = "Luig_";
            String string18 = "Lui_";
            String string19 = "Lu_";
            String string20 = "L_";
            String string21 = "_";
            String string22 = "";
            if (this.Field2724 == 0) {
                string22 = string;
            }
            if (this.Field2724 == 1) {
                string22 = string2;
            }
            if (this.Field2724 == 2) {
                string22 = string3;
            }
            if (this.Field2724 == 3) {
                string22 = string4;
            }
            if (this.Field2724 == 4) {
                string22 = string5;
            }
            if (this.Field2724 == 5) {
                string22 = string6;
            }
            if (this.Field2724 == 6) {
                string22 = string7;
            }
            if (this.Field2724 == 7) {
                string22 = string8;
            }
            if (this.Field2724 == 8) {
                string22 = string9;
            }
            if (this.Field2724 == 9) {
                string22 = string10;
            }
            if (this.Field2724 == 10) {
                string22 = string11;
            }
            if (this.Field2724 == 11) {
                string22 = string12;
            }
            if (this.Field2724 == 12) {
                string22 = string13;
            }
            if (this.Field2724 == 13) {
                string22 = string14;
            }
            if (this.Field2724 == 14) {
                string22 = string15;
            }
            if (this.Field2724 == 15) {
                string22 = string16;
            }
            if (this.Field2724 == 16) {
                string22 = string17;
            }
            if (this.Field2724 == 17) {
                string22 = string18;
            }
            if (this.Field2724 == 18) {
                string22 = string19;
            }
            if (this.Field2724 == 19) {
                string22 = string20;
            }
            if (this.Field2724 == 20) {
                string22 = string21;
            }
            AliceMain.Field766.Method2150317(string22, 9.0f, 7.0f, -1);
            AliceMain.Field766.Method2150317("|  " + HudComponents.Field2811.player.getName(), AliceMain.Field766.Method2150310(string13) + 20, 7.0f, -1);
            AliceMain.Field766.Method2150317("|  " + AliceMain.Field768.Method2150206() + " ms", AliceMain.Field766.Method2150310(string13) + 35 + AliceMain.Field766.Method2150310(HudComponents.Field2811.player.getName()), 7.0f, -1);
            try {
                AliceMain.Field766.Method2150317("|  " + Minecraft.getMinecraft().currentServerData.serverIP, AliceMain.Field766.Method2150310(string13) + 38 + AliceMain.Field766.Method2150310(HudComponents.Field2811.player.getName()) + AliceMain.Field766.Method2150310(" 9999 ms "), 7.0f, -1);
            } catch (Exception exception) {
                AliceMain.Field766.Method2150317("|  SinglePlayer", AliceMain.Field766.Method2150310(string13) + 38 + AliceMain.Field766.Method2150310(HudComponents.Field2811.player.getName()) + AliceMain.Field766.Method2150310(" 9999 ms "), 7.0f, -1);
            }
        }
    }

    public void Method2150654() {
        ScaledResolution scaledResolution = new ScaledResolution(Field2811);
        if (this.Field2711.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.LINE) {
            float f = HudComponents.Field2811.player.rotationYaw;
            float f2 = MathUtil.Method2163859(f);
            RenderUtil.Method2163027(this.Field2712.getValue().intValue(), this.Field2713.getValue().intValue(), this.Field2712.getValue() + 100, this.Field2713.getValue() + this.Field3872.Method2150321(), 1963986960);
            RenderUtil.Method2163011(this.Field2712.getValue().intValue(), this.Field2713.getValue().intValue(), this.Field2712.getValue() + 100, this.Field2713.getValue() + this.Field3872.Method2150321(), scaledResolution);
            GL11.glEnable((int) 3089);
            float f3 = MathUtil.Method2163859((float) (Math.atan2(0.0 - HudComponents.Field2811.player.posZ, 0.0 - HudComponents.Field2811.player.posX) * 180.0 / Math.PI) - 90.0f);
            RenderUtil.Method2163012((float) this.Field2712.getValue().intValue() - f2 + 50.0f + f3, this.Field2713.getValue() + 2, (float) this.Field2712.getValue().intValue() - f2 + 50.0f + f3, this.Field2713.getValue() + this.Field3872.Method2150321() - 2, 2.0f, -61424);
            RenderUtil.Method2163012((float) this.Field2712.getValue().intValue() - f2 + 50.0f + 45.0f, this.Field2713.getValue() + 2, (float) this.Field2712.getValue().intValue() - f2 + 50.0f + 45.0f, this.Field2713.getValue() + this.Field3872.Method2150321() - 2, 2.0f, -1);
            RenderUtil.Method2163012((float) this.Field2712.getValue().intValue() - f2 + 50.0f - 45.0f, this.Field2713.getValue() + 2, (float) this.Field2712.getValue().intValue() - f2 + 50.0f - 45.0f, this.Field2713.getValue() + this.Field3872.Method2150321() - 2, 2.0f, -1);
            RenderUtil.Method2163012((float) this.Field2712.getValue().intValue() - f2 + 50.0f + 135.0f, this.Field2713.getValue() + 2, (float) this.Field2712.getValue().intValue() - f2 + 50.0f + 135.0f, this.Field2713.getValue() + this.Field3872.Method2150321() - 2, 2.0f, -1);
            RenderUtil.Method2163012((float) this.Field2712.getValue().intValue() - f2 + 50.0f - 135.0f, this.Field2713.getValue() + 2, (float) this.Field2712.getValue().intValue() - f2 + 50.0f - 135.0f, this.Field2713.getValue() + this.Field3872.Method2150321() - 2, 2.0f, -1);
            this.Field3872.Method2150317("n", (float) this.Field2712.getValue().intValue() - f2 + 50.0f + 180.0f - (float) this.Field3872.Method2150310("n") / 2.0f, this.Field2713.getValue().intValue(), -1);
            this.Field3872.Method2150317("n", (float) this.Field2712.getValue().intValue() - f2 + 50.0f - 180.0f - (float) this.Field3872.Method2150310("n") / 2.0f, this.Field2713.getValue().intValue(), -1);
            this.Field3872.Method2150317("e", (float) this.Field2712.getValue().intValue() - f2 + 50.0f - 90.0f - (float) this.Field3872.Method2150310("e") / 2.0f, this.Field2713.getValue().intValue(), -1);
            this.Field3872.Method2150317("s", (float) this.Field2712.getValue().intValue() - f2 + 50.0f - (float) this.Field3872.Method2150310("s") / 2.0f, this.Field2713.getValue().intValue(), -1);
            this.Field3872.Method2150317("w", (float) this.Field2712.getValue().intValue() - f2 + 50.0f + 90.0f - (float) this.Field3872.Method2150310("w") / 2.0f, this.Field2713.getValue().intValue(), -1);
            RenderUtil.Method2163012(this.Field2712.getValue() + 50, this.Field2713.getValue() + 1, this.Field2712.getValue() + 50, this.Field2713.getValue() + this.Field3872.Method2150321() - 1, 2.0f, -7303024);
            GL11.glDisable((int) 3089);
        } else {
            double d = this.Field2712.getValue().intValue();
            double d2 = this.Field2713.getValue().intValue();
            for (IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll : IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.values()) {
                double d3 = HudComponents.Method2150659(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll);
                this.Field3872.Method2150317(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.name(), (float) (d + this.Method2150657(d3)), (float) (d2 + this.Method2150658(d3)), iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.N ? -65536 : -1);
            }
        }
    }

    public void Method2150655(EntityPlayer entityPlayer, int n2, int n3) {
        EntityPlayer entityPlayer2 = entityPlayer;
        GlStateManager.pushMatrix();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.rotate((float) 0.0f, (float) 0.0f, (float) 5.0f, (float) 0.0f);
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) (this.Field2716.getValue() + 25), (float) (this.Field2717.getValue() + 25), (float) 50.0f);
        GlStateManager.scale((float) (-50.0f * this.Field2718.getValue().floatValue()), (float) (50.0f * this.Field2718.getValue().floatValue()), (float) (50.0f * this.Field2718.getValue().floatValue()));
        GlStateManager.rotate((float) 180.0f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
        GlStateManager.rotate((float) 135.0f, (float) 0.0f, (float) 1.0f, (float) 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float) -135.0f, (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-((float) Math.atan((float) this.Field2717.getValue().intValue() / 40.0f)) * 20.0f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
        GlStateManager.translate((float) 0.0f, (float) 0.0f, (float) 0.0f);
        RenderManager renderManager = Field2811.getRenderManager();
        renderManager.setPlayerViewY(180.0f);
        renderManager.setRenderShadow(false);
        try {
            renderManager.renderEntity((Entity) entityPlayer2, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        } catch (Exception exception) {
            // empty catch block
        }
        renderManager.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int) OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int) OpenGlHelper.defaultTexUnit);
        GlStateManager.depthFunc((int) 515);
        GlStateManager.resetColor();
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
    }

    public void Method2150656() {
        EntityPlayerSP entityPlayerSP = HudComponents.Field2811.player;
        GlStateManager.pushMatrix();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.enableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.rotate((float) 0.0f, (float) 0.0f, (float) 5.0f, (float) 0.0f);
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) (this.Field2716.getValue() + 25), (float) (this.Field2717.getValue() + 25), (float) 50.0f);
        GlStateManager.scale((float) (-50.0f * this.Field2718.getValue().floatValue()), (float) (50.0f * this.Field2718.getValue().floatValue()), (float) (50.0f * this.Field2718.getValue().floatValue()));
        GlStateManager.rotate((float) 180.0f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
        GlStateManager.rotate((float) 135.0f, (float) 0.0f, (float) 1.0f, (float) 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float) -135.0f, (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-((float) Math.atan((float) this.Field2717.getValue().intValue() / 40.0f)) * 20.0f), (float) 1.0f, (float) 0.0f, (float) 0.0f);
        GlStateManager.translate((float) 0.0f, (float) 0.0f, (float) 0.0f);
        RenderManager renderManager = Field2811.getRenderManager();
        renderManager.setPlayerViewY(180.0f);
        renderManager.setRenderShadow(false);
        try {
            renderManager.renderEntity((Entity) entityPlayerSP, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        } catch (Exception exception) {
            // empty catch block
        }
        renderManager.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int) OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int) OpenGlHelper.defaultTexUnit);
        GlStateManager.depthFunc((int) 515);
        GlStateManager.resetColor();
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
    }

    private double Method2150657(double d) {
        return Math.sin(d) * (double) (this.Field2714.getValue() * 10);
    }

    private double Method2150658(double d) {
        double d2 = MathHelper.clamp((float) (HudComponents.Field2811.player.rotationPitch + 30.0f), (float) -90.0f, (float) 90.0f);
        double d3 = Math.toRadians(d2);
        return Math.cos(d) * Math.sin(d3) * (double) (this.Field2714.getValue() * 10);
    }

    public void Method2150650(float f) {
        BlockPos blockPos;
        Block block;
        BlockPos blockPos2;
        Block block2;
        BlockPos blockPos3;
        Block block3;
        float f2 = 0.0f;
        int n2 = MathHelper.floor((double) ((double) (HudComponents.Field2811.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
        switch (n2) {
            case 1: {
                f2 = 90.0f;
                break;
            }
            case 2: {
                f2 = -180.0f;
                break;
            }
            case 3: {
                f2 = -90.0f;
            }
        }
        BlockPos blockPos4 = this.Method2150663(f, f2);
        Block block4 = this.Method2150665(blockPos4);
        if (block4 != null && block4 != Blocks.AIR) {
            int n3 = this.Method2150662(blockPos4);
            if (n3 != 0) {
                RenderUtil.Method2163027(this.Field2709.getValue() + 16, this.Field2710.getValue().intValue(), this.Field2709.getValue() + 32, this.Field2710.getValue() + 16, 0x60FF0000);
            }
            this.Method2150666(block4, this.Field2709.getValue() + 16, this.Field2710.getValue().intValue());
        }
        if ((block3 = this.Method2150665(blockPos3 = this.Method2150663(f, f2 - 180.0f))) != null && block3 != Blocks.AIR) {
            int n4 = this.Method2150662(blockPos3);
            if (n4 != 0) {
                RenderUtil.Method2163027(this.Field2709.getValue() + 16, this.Field2710.getValue() + 32, this.Field2709.getValue() + 32, this.Field2710.getValue() + 48, 0x60FF0000);
            }
            this.Method2150666(block3, this.Field2709.getValue() + 16, this.Field2710.getValue() + 32);
        }
        if ((block2 = this.Method2150665(blockPos2 = this.Method2150663(f, f2 + 90.0f))) != null && block2 != Blocks.AIR) {
            int n5 = this.Method2150662(blockPos2);
            if (n5 != 0) {
                RenderUtil.Method2163027(this.Field2709.getValue() + 32, this.Field2710.getValue() + 16, this.Field2709.getValue() + 48, this.Field2710.getValue() + 32, 0x60FF0000);
            }
            this.Method2150666(block2, this.Field2709.getValue() + 32, this.Field2710.getValue() + 16);
        }
        if ((block = this.Method2150665(blockPos = this.Method2150663(f, f2 - 90.0f))) != null && block != Blocks.AIR) {
            int n6 = this.Method2150662(blockPos);
            if (n6 != 0) {
                RenderUtil.Method2163027(this.Field2709.getValue().intValue(), this.Field2710.getValue() + 16, this.Field2709.getValue() + 16, this.Field2710.getValue() + 32, 0x60FF0000);
            }
            this.Method2150666(block, this.Field2709.getValue().intValue(), this.Field2710.getValue() + 16);
        }
    }

    public void Method2150661(float f, Entity entity, int n2, int n3) {
        BlockPos blockPos;
        Block block;
        BlockPos blockPos2;
        Block block2;
        BlockPos blockPos3;
        Block block3;
        float f2 = 0.0f;
        int n4 = MathHelper.floor((double) ((double) (entity.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
        switch (n4) {
            case 1: {
                f2 = 90.0f;
                break;
            }
            case 2: {
                f2 = -180.0f;
                break;
            }
            case 3: {
                f2 = -90.0f;
            }
        }
        BlockPos blockPos4 = this.Method2150664(f, f2, entity);
        Block block4 = this.Method2150665(blockPos4);
        if (block4 != null && block4 != Blocks.AIR) {
            int n5 = this.Method2150662(blockPos4);
            if (n5 != 0) {
                RenderUtil.Method2163027(n2 + 16, n3, n2 + 32, n3 + 16, 0x60FF0000);
            }
            this.Method2150666(block4, n2 + 16, n3);
        }
        if ((block3 = this.Method2150665(blockPos3 = this.Method2150664(f, f2 - 180.0f, entity))) != null && block3 != Blocks.AIR) {
            int n6 = this.Method2150662(blockPos3);
            if (n6 != 0) {
                RenderUtil.Method2163027(n2 + 16, n3 + 32, n2 + 32, n3 + 48, 0x60FF0000);
            }
            this.Method2150666(block3, n2 + 16, n3 + 32);
        }
        if ((block2 = this.Method2150665(blockPos2 = this.Method2150664(f, f2 + 90.0f, entity))) != null && block2 != Blocks.AIR) {
            int n7 = this.Method2150662(blockPos2);
            if (n7 != 0) {
                RenderUtil.Method2163027(n2 + 32, n3 + 16, n2 + 48, n3 + 32, 0x60FF0000);
            }
            this.Method2150666(block2, n2 + 32, n3 + 16);
        }
        if ((block = this.Method2150665(blockPos = this.Method2150664(f, f2 - 90.0f, entity))) != null && block != Blocks.AIR) {
            int n8 = this.Method2150662(blockPos);
            if (n8 != 0) {
                RenderUtil.Method2163027(n2, n3 + 16, n2 + 16, n3 + 32, 0x60FF0000);
            }
            this.Method2150666(block, n2, n3 + 16);
        }
    }

    private int Method2150662(BlockPos blockPos) {
        for (DestroyBlockProgress destroyBlockProgress : HudComponents.Field2811.renderGlobal.damagedBlocks.values()) {
            if (destroyBlockProgress.getPosition().getX() != blockPos.getX() || destroyBlockProgress.getPosition().getY() != blockPos.getY() || destroyBlockProgress.getPosition().getZ() != blockPos.getZ())
                continue;
            return destroyBlockProgress.getPartialBlockDamage();
        }
        return 0;
    }

    private BlockPos Method2150663(float f, float f2) {
        Vec3d vec3d = EntityUtil.Method2163492((Entity) HudComponents.Field2811.player, f);
        Vec3d vec3d2 = MathUtil.Method2163850(f2);
        return new BlockPos(vec3d.x + vec3d2.x, vec3d.y, vec3d.z + vec3d2.z);
    }

    private BlockPos Method2150664(float f, float f2, Entity entity) {
        Vec3d vec3d = EntityUtil.Method2163492(entity, f);
        Vec3d vec3d2 = MathUtil.Method2163850(f2);
        return new BlockPos(vec3d.x + vec3d2.x, vec3d.y, vec3d.z + vec3d2.z);
    }

    private Block Method2150665(BlockPos blockPos) {
        Block block = HudComponents.Field2811.world.getBlockState(blockPos).getBlock();
        if (block == Blocks.BEDROCK || block == Blocks.OBSIDIAN) {
            return block;
        }
        return Blocks.AIR;
    }

    private void Method2150666(Block block, float f, float f2) {
        ItemStack itemStack = new ItemStack(block);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.translate((float) f, (float) f2, (float) 0.0f);
        HudComponents.Field2811.getRenderItem().zLevel = 501.0f;
        Field2811.getRenderItem().renderItemAndEffectIntoGUI(itemStack, 0, 0);
        HudComponents.Field2811.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableBlend();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        GlStateManager.popMatrix();
    }

    public void Method2150667() {
        if (this.Field2701.getValue().booleanValue()) {
            this.Method2150672(this.Field2702.getValue() + this.Field2704.getValue(), this.Field2703.getValue() + this.Field2705.getValue());
        }
        this.Method2150673((NonNullList<ItemStack>) HudComponents.Field2811.player.inventory.mainInventory, this.Field2702.getValue() + this.Field2704.getValue(), this.Field2703.getValue() + this.Field2705.getValue());
    }

    private void Method2150672(int n2, int n3) {
        HudComponents.Method2150668();
        HudComponents.Field2811.renderEngine.bindTexture(Field2697);
        RenderUtil.Method2163989(n2, n3, 0, 0, 176, 16, 500);
        RenderUtil.Method2163989(n2, n3 + 16, 0, 16, 176, 54 + this.Field2707.getValue(), 500);
        RenderUtil.Method2163989(n2, n3 + 16 + 54, 0, 160, 176, 8, 500);
        HudComponents.Method2150669();
    }

    private void Method2150673(NonNullList<ItemStack> nonNullList, int n2, int n3) {
        int n4;
        int n5;
        for (n5 = 0; n5 < nonNullList.size() - 9; ++n5) {
            n4 = n2 + n5 % 9 * 18 + 8;
            int n6 = n3 + n5 / 9 * 18 + 18;
            ItemStack itemStack = (ItemStack) nonNullList.get(n5 + 9);
            HudComponents.Method2150660();
            HudComponents.Field2811.getRenderItem().zLevel = 501.0f;
            RenderUtil.Field3115.renderItemAndEffectIntoGUI(itemStack, n4, n6);
            RenderUtil.Field3115.renderItemOverlayIntoGUI(HudComponents.Field2811.fontRenderer, itemStack, n4, n6, null);
            HudComponents.Field2811.getRenderItem().zLevel = 0.0f;
            HudComponents.Method2150671();
        }
        if (this.Field2706.getValue().booleanValue()) {
            for (n5 = 1; n5 < 5; ++n5) {
                n4 = n2 + (n5 + 4) % 9 * 18 + 8;
                ItemStack itemStack = ((Slot) HudComponents.Field2811.player.inventoryContainer.inventorySlots.get(n5)).getStack();
                if (itemStack == null || itemStack.isEmpty) continue;
                HudComponents.Method2150660();
                HudComponents.Field2811.getRenderItem().zLevel = 501.0f;
                RenderUtil.Field3115.renderItemAndEffectIntoGUI(itemStack, n4, n3 + 1);
                RenderUtil.Field3115.renderItemOverlayIntoGUI(HudComponents.Field2811.fontRenderer, itemStack, n4, n3 + 1, null);
                HudComponents.Field2811.getRenderItem().zLevel = 0.0f;
                HudComponents.Method2150671();
            }
        }
    }

    private boolean Method2150675(Object object) {
        return this.Field2719.getValue();
    }

    private boolean Method2150676(Object object) {
        return this.Field2719.getValue();
    }

    private boolean Method2150677(Object object) {
        return this.Field2719.getValue();
    }

    private boolean Method2150678(Object object) {
        return this.Field2719.getValue();
    }

    private boolean Method2150679(Object object) {
        return this.Field2715.getValue();
    }

    private boolean Method2150670(Object object) {
        return this.Field2715.getValue();
    }

    private boolean Method2150681(Object object) {
        return this.Field2715.getValue();
    }

    private boolean Method2150682(Object object) {
        return this.Field2711.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE;
    }

    private boolean Method2150683(Object object) {
        return this.Field2711.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE;
    }

    private boolean Method2150684(Object object) {
        return this.Field2711.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE;
    }

    private boolean Method2150685(Object object) {
        return this.Field2708.getValue();
    }

    private boolean Method2150686(Object object) {
        return this.Field2708.getValue();
    }

    private boolean Method2150687(Object object) {
        return this.Field2700.getValue();
    }

    private boolean Method2150688(Object object) {
        return this.Field2700.getValue();
    }

    private boolean Method2150689(Object object) {
        return this.Field2700.getValue();
    }

    private boolean Method2150680(Object object) {
        return this.Field2700.getValue();
    }

    private boolean Method2150691(Object object) {
        return this.Field2700.getValue();
    }

    private boolean Method2150692(Object object) {
        return this.Field2700.getValue();
    }

    private boolean Method2150693(Object object) {
        return this.Field2700.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        CIRCLE,
        LINE;

    }

    private static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        N,
        W,
        S,
        E;

    }
}

