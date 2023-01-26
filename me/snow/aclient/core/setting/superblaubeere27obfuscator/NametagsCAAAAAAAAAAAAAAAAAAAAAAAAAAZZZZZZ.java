

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ
        extends Module {
    private static NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ Field1952;
    private final Setting<Boolean> Field1923;
    private final Setting<Boolean> Field1924;
    private final Setting<Integer> Field1925;
    private final Setting<Integer> Field1926;
    private final Setting<Integer> Field1927;
    private final Setting<Integer> Field1928;
    private final Setting<Float> Field1929;
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1930;
    private final Setting<Boolean> Field1931;
    private final Setting<Boolean> Field1932;
    private final Setting<Boolean> Field1933;
    private final Setting<Boolean> Field1934;
    private final Setting<Boolean> Field1935;
    private final Setting<Boolean> Field1936;
    private final Setting<Boolean> Field1937;
    private final Setting<Boolean> Field1938;
    private final Setting<Boolean> Field1939;
    private final Setting<Boolean> Field1940;
    private final Setting<Float> Field1941;
    private final Setting<Float> Field1942;
    private final Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field1943;
    private final Setting<Boolean> Field1944;
    private final Setting<Integer> Field1945;
    private final Setting<Integer> Field1946;
    private final Setting<Integer> Field1947;
    public Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field1948;
    boolean Field1950;
    private ICamera Field1949;
    private Map<Integer, Boolean> Field1951 = new HashMap<Integer, Boolean>();

    public NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ() {
        super("NametagsNew", "Better Nametags.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Field1949 = new Frustum();
        this.Field1923 = this.Method2150366(new Setting<Boolean>("Outline", true));
        this.Field1924 = this.Method2150366(new Setting<Boolean>("Background", true));
        this.Field1948 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("Outline Mode", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.DEPEND));
        this.Field1925 = this.Method2150366(new Setting<Object>("Outline Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161406));
        this.Field1926 = this.Method2150366(new Setting<Object>("Outline Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161405));
        this.Field1927 = this.Method2150366(new Setting<Object>("Outline Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161404));
        this.Field1928 = this.Method2150366(new Setting<Object>("Outline Alpha", Integer.valueOf(155), Integer.valueOf(0), Integer.valueOf(255), this::Method2161403));
        this.Field1929 = this.Method2150366(new Setting<Object>("Outline Width", Float.valueOf(1.5f), Float.valueOf(0.0f), Float.valueOf(3.0f), this::Method2161402));
        this.Field1931 = this.Method2150366(new Setting<Boolean>("Reversed", false));
        this.Field1932 = this.Method2150366(new Setting<Boolean>("Reversed Hand", false));
        this.Field1930 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Enchant Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MAX));
        this.Field1933 = this.Method2150366(new Setting<Boolean>("Health", true));
        this.Field1934 = this.Method2150366(new Setting<Boolean>("GameMode", true));
        this.Field1935 = this.Method2150366(new Setting<Boolean>("Ping", true));
        this.Field1936 = this.Method2150366(new Setting<Boolean>("Ping Color", true));
        this.Field1937 = this.Method2150366(new Setting<Boolean>("Armor", true));
        this.Field1938 = this.Method2150366(new Setting<Boolean>("Durability", true));
        this.Field1939 = this.Method2150366(new Setting<Boolean>("Item Name", true));
        this.Field1940 = this.Method2150366(new Setting<Boolean>("Invisibles", false));
        this.Field1941 = this.Method2150366(new Setting<Float>("Scale", Float.valueOf(5.0f), Float.valueOf(1.0f), Float.valueOf(9.0f)));
        this.Field1942 = this.Method2150366(new Setting<Float>("Height", Float.valueOf(2.5f), Float.valueOf(0.5f), Float.valueOf(5.0f)));
        this.Field1944 = this.Method2150366(new Setting<Boolean>("Friends", true));
        this.Field1943 = this.Method2150366(new Setting<Object>("Friend Mode", (Object) IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.TEXT, this::Method2161401));
        this.Field1945 = this.Method2150366(new Setting<Object>("Friend Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161490));
        this.Field1946 = this.Method2150366(new Setting<Object>("Friend Green", Integer.valueOf(130), Integer.valueOf(0), Integer.valueOf(255), this::Method2161499));
        this.Field1947 = this.Method2150366(new Setting<Object>("Friend Blue", Integer.valueOf(130), Integer.valueOf(0), Integer.valueOf(255), this::Method2161498));
        Field1952 = this;
    }

    public static NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ Method2161466() {
        if (Field1952 == null) {
            Field1952 = new NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ();
        }
        return Field1952;
    }

    public static void Method2161474(double d, double d2, double d3, double d4, int n2) {
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glEnable((int) 2848);
        GL11.glPushMatrix();
        GL11.glColor4f((float) f2, (float) f3, (float) f4, (float) f);
        GL11.glBegin((int) 7);
        GL11.glVertex2d((double) d3, (double) d2);
        GL11.glVertex2d((double) d, (double) d2);
        GL11.glVertex2d((double) d, (double) d4);
        GL11.glVertex2d((double) d3, (double) d4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
    }

    public static void Method2161475(double d, double d2, double d3, double d4, int n2) {
        double d5;
        if (d < d3) {
            d5 = d;
            d = d3;
            d3 = d5;
        }
        if (d2 < d4) {
            d5 = d2;
            d2 = d4;
            d4 = d5;
        }
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f2, (float) f3, (float) f4, (float) f);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).endVertex();
        bufferBuilder.pos(d, d2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method2161476(double d, double d2, double d3, double d4, double d5, int n2, int n3) {
        GlStateManager.pushMatrix();
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161482();
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161475(d + d5, d2 + d5, d3 - d5, d4 - d5, n2);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161475(d + d5, d2, d3 - d5, d2 + d5, n3);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161475(d, d2, d + d5, d4, n3);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161475(d3 - d5, d2, d3, d4, n3);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161475(d + d5, d4 - d5, d3 - d5, d4, n3);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161483();
        GlStateManager.popMatrix();
    }

    public static final int Method2161481(int n2, int n3) {
        return n3 << 24 | (n2 &= 0xFFFFFF);
    }

    public static void Method2161482() {
        GL11.glDisable((int) 2929);
        GL11.glEnable((int) 3042);
        GL11.glDisable((int) 3553);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDepthMask((boolean) true);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glHint((int) 3155, (int) 4354);
    }

    public static void Method2161483() {
        GL11.glEnable((int) 3553);
        GL11.glDisable((int) 3042);
        GL11.glDisable((int) 2848);
        GL11.glHint((int) 3154, (int) 4352);
        GL11.glHint((int) 3155, (int) 4352);
    }

    public static Color Method2161495(int n2) {
        double d = Math.ceil((double) (System.currentTimeMillis() + (long) n2) / 20.0);
        return Color.getHSBColor((float) ((d %= 360.0) / 360.0), 1.0f, 1.0f);
    }

    public static boolean Method2161496(Entity entity) {
        BlockPos blockPos = new BlockPos(entity.posX, entity.posY, entity.posZ);
        return NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.ENDER_CHEST;
    }

    private static Float Method2161497(EntityPlayerSP entityPlayerSP, Object object) {
        return Float.valueOf(entityPlayerSP.getDistance((Entity) object));
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2150359() || render3DEvent == null) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Field2811.getRenderViewEntity() == null ? NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.player : Field2811.getRenderViewEntity();
        double d = entityPlayerSP.lastTickPosX + (entityPlayerSP.posX - entityPlayerSP.lastTickPosX) * (double) render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        double d2 = entityPlayerSP.lastTickPosY + (entityPlayerSP.posY - entityPlayerSP.lastTickPosY) * (double) render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        double d3 = entityPlayerSP.lastTickPosZ + (entityPlayerSP.posZ - entityPlayerSP.lastTickPosZ) * (double) render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        this.Field1949.setPosition(d, d2, d3);
        ArrayList<Object> arrayList = new ArrayList<Object>(NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.world.playerEntities);
        arrayList.sort(Comparator.comparing(arg_0 -> NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161497(entityPlayerSP, arg_0)).reversed());
        for (EntityPlayer entityPlayer : arrayList) {
            NetworkPlayerInfo networkPlayerInfo = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.player.connection.getPlayerInfo(entityPlayer.getGameProfile().getId());
            if (!this.Field1949.isBoundingBoxInFrustum(entityPlayer.getEntityBoundingBox()) && !this.Field1949.isBoundingBoxInFrustum(entityPlayer.getEntityBoundingBox().offset(0.0, 2.0, 0.0)) || entityPlayer == Field2811.getRenderViewEntity() || !entityPlayer.isEntityAlive())
                continue;
            double d4 = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double) NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.timer.renderPartialTicks - NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.renderManager.renderPosX;
            double d5 = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double) NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.timer.renderPartialTicks - NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.renderManager.renderPosY;
            double d6 = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double) NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.timer.renderPartialTicks - NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.renderManager.renderPosZ;
            if (networkPlayerInfo != null && this.Method2161467(networkPlayerInfo.getGameType().getName()).equalsIgnoreCase("SP") && !this.Field1940.getValue().booleanValue() || entityPlayer.getName().startsWith("Body #"))
                continue;
            try {
                this.Method2161471(entityPlayer, d4, d5, d6);
            } catch (Exception exception) {
                AliceMain.Field745.info("Caught an exception from Nametags");
                exception.printStackTrace();
            }
        }
    }

    public String Method2161467(String string) {
        if (string.equalsIgnoreCase("survival")) {
            return "S";
        }
        if (string.equalsIgnoreCase("creative")) {
            return "C";
        }
        if (string.equalsIgnoreCase("adventure")) {
            return "A";
        }
        if (string.equalsIgnoreCase("spectator")) {
            return "SP";
        }
        return "NONE";
    }

    public String Method2161468(float f) {
        if (f > 18.0f) {
            return "a";
        }
        if (f > 16.0f) {
            return "2";
        }
        if (f > 12.0f) {
            return "e";
        }
        if (f > 8.0f) {
            return "6";
        }
        if (f > 5.0f) {
            return "c";
        }
        return "4";
    }

    public String Method2161469(float f) {
        if (f > 200.0f) {
            return "c";
        }
        if (f > 100.0f) {
            return "e";
        }
        return "a";
    }

    private String Method2161460(EntityPlayer entityPlayer) {
        return entityPlayer.getName();
    }

    public void Method2161471(EntityPlayer entityPlayer, double d, double d2, double d3) {
        this.Field1950 = false;
        GlStateManager.pushMatrix();
        NetworkPlayerInfo networkPlayerInfo = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.player.connection.getPlayerInfo(entityPlayer.getGameProfile().getId());
        boolean bl = AliceMain.Field765.Method2150168(entityPlayer.getName()) && this.Field1944.getValue() != false;
        StringBuilder stringBuilder = new StringBuilder().append(bl && this.Field1943.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.TEXT ? "\uff82\uff67" + (bl ? "b" : "c") : (entityPlayer.isSneaking() ? "\uff82\uff677" : "\uff82\uff67r")).append(this.Method2161460(entityPlayer)).append(this.Field1934.getValue() != false && networkPlayerInfo != null ? " [" + this.Method2161467(networkPlayerInfo.getGameType().getName()) + "]" : "").append(this.Field1935.getValue() != false && networkPlayerInfo != null ? " " + (this.Field1936.getValue() != false ? "\uff82\uff67" + this.Method2161469(networkPlayerInfo.getResponseTime()) : "") + networkPlayerInfo.getResponseTime() + "ms" : "").append(this.Field1933.getValue() != false ? " \uff82\uff67" + this.Method2161468(entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount()) + MathHelper.ceil((float) (entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount())) : "");
        String string = "";
        EntityPlayerSP entityPlayerSP = Field2811.getRenderViewEntity() == null ? NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.player : Field2811.getRenderViewEntity();
        float f = entityPlayerSP.getDistance((Entity) entityPlayer);
        float f2 = (f / 5.0f <= 2.0f ? 2.0f : f / 5.0f * (this.Field1941.getValue().floatValue() / 100.0f * 10.0f + 1.0f)) * 2.5f * (this.Field1941.getValue().floatValue() / 100.0f / 10.0f);
        if ((double) f <= 8.0) {
            f2 = 0.0245f;
        }
        GL11.glTranslated((double) ((float) d), (double) ((double) ((float) d2 + this.Field1942.getValue().floatValue()) - (entityPlayer.isSneaking() ? 0.4 : 0.0) + (f / 5.0f > 2.0f ? (double) (f / 12.0f) - 0.7 : 0.0)), (double) ((float) d3));
        GL11.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GL11.glRotatef((float) (-NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.getRenderManager().playerViewY), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GL11.glRotatef((float) NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.getRenderManager().playerViewX, (float) (NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GL11.glScalef((float) (-f2), (float) (-f2), (float) f2);
        this.Method2161491(2896, 2929);
        this.Method2161488(3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        int n2 = AliceMain.Field766.Method2150310(this.Method2161460(entityPlayer)) / 2 + 1;
        int n3 = bl && this.Field1943.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BOX ? new Color(this.Field1945.getValue(), this.Field1946.getValue(), this.Field1947.getValue()).getRGB() : 0;
        int n4 = new Color(this.Field1925.getValue(), this.Field1926.getValue(), this.Field1927.getValue(), this.Field1928.getValue()).getRGB();
        if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.DEPEND) {
            n4 = AliceMain.Field765.Method2150168(entityPlayer.getName()) ? new Color(0, 191, 230, this.Field1928.getValue()).getRGB() : (NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161496((Entity) entityPlayer) ? new Color(177, 27, 196, this.Field1928.getValue()).getRGB() : (EntityUtil.Method2163402((Entity) entityPlayer) ? new Color(0, 255, 0, this.Field1928.getValue()).getRGB() : new Color(255, 0, 0, this.Field1928.getValue()).getRGB()));
        }
        if (this.Field1924.getValue().booleanValue()) {
            Gui.drawRect((int) (-n2 - 1), (int) 8, (int) (n2 + 1), (int) 19, (int) NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161481(n3, 120));
        }
        if (this.Field1923.getValue().booleanValue()) {
            this.Method2161494(-n2 - 1, 8.0, n2 + 1, 19.0, this.Field1929.getValue().floatValue(), n4);
        }
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.fontRenderer.drawStringWithShadow(this.Method2161460(entityPlayer), (float) (-n2), 9.2f, -1);
        if (this.Field1937.getValue().booleanValue()) {
            int n5;
            int n6 = -8;
            Item item = entityPlayer.getHeldItemMainhand().getItem();
            Item item2 = entityPlayer.getHeldItemOffhand().getItem();
            if (item != Items.AIR && item2 == Items.AIR) {
                n6 = -16;
            } else if (item == Items.AIR && item2 != Items.AIR) {
                n6 = 0;
            }
            int n7 = 0;
            for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
                if (itemStack == null) continue;
                n6 -= 8;
                if (itemStack.getItem() == Items.AIR) continue;
                ++n7;
            }
            if (entityPlayer.getHeldItemOffhand().getItem() != Items.AIR) {
                ++n7;
            }
            int n8 = n6 - 8;
            n6 += 8 * (5 - n7) - (n7 == 0 ? 4 : 0);
            if (!(this.Field1932.getValue() != false ? entityPlayer.getHeldItemOffhand().getItem() == Items.AIR : entityPlayer.getHeldItemMainhand().getItem() == Items.AIR)) {
                ItemStack itemStack;
                n6 -= 10;
                if (this.Field1932.getValue().booleanValue()) {
                    itemStack = entityPlayer.getHeldItemOffhand().copy();
                    this.Method2161477(entityPlayer, itemStack, n6, -8, n8, false);
                } else {
                    itemStack = entityPlayer.getHeldItemMainhand().copy();
                    this.Method2161477(entityPlayer, itemStack, n6, -8, n8, true);
                }
                n6 += 18;
            } else if (!this.Field1932.getValue().booleanValue()) {
                this.Field1950 = true;
            }
            if (this.Field1931.getValue().booleanValue()) {
                for (n5 = 0; n5 <= 3; ++n5) {
                    ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(n5);
                    if (itemStack == null || itemStack.getItem() == Items.AIR) continue;
                    ItemStack itemStack2 = itemStack.copy();
                    this.Method2161477(entityPlayer, itemStack2, n6, -8, n8, false);
                    n6 += 16;
                }
            } else {
                for (n5 = 3; n5 >= 0; --n5) {
                    ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(n5);
                    if (itemStack == null || itemStack.getItem() == Items.AIR) continue;
                    ItemStack itemStack3 = itemStack.copy();
                    this.Method2161477(entityPlayer, itemStack3, n6, -8, n8, false);
                    n6 += 16;
                }
            }
            if (!(this.Field1932.getValue() != false ? entityPlayer.getHeldItemMainhand().getItem() == Items.AIR : entityPlayer.getHeldItemOffhand().getItem() == Items.AIR)) {
                ItemStack itemStack;
                n6 += 0;
                if (this.Field1932.getValue().booleanValue()) {
                    itemStack = entityPlayer.getHeldItemMainhand().copy();
                    this.Method2161477(entityPlayer, itemStack, n6, -8, n8, true);
                } else {
                    itemStack = entityPlayer.getHeldItemOffhand().copy();
                    this.Method2161477(entityPlayer, itemStack, n6, -8, n8, false);
                }
                n6 += 8;
            }
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
        } else if (this.Field1938.getValue().booleanValue()) {
            int n9 = -6;
            int n10 = 0;
            for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
                if (itemStack == null) continue;
                n9 -= 8;
                if (itemStack.getItem() == Items.AIR) continue;
                ++n10;
            }
            if (entityPlayer.getHeldItemOffhand().getItem() != Items.AIR) {
                ++n10;
            }
            int n11 = n9 - 8;
            n9 += 8 * (5 - n10) - (n10 == 0 ? 4 : 0);
            if (this.Field1931.getValue().booleanValue()) {
                for (int j = 0; j <= 3; ++j) {
                    ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(j);
                    if (itemStack == null || itemStack.getItem() == Items.AIR) continue;
                    ItemStack itemStack4 = itemStack.copy();
                    this.Method2161479(entityPlayer, itemStack4, n9, -8);
                    n9 += 16;
                }
            } else {
                for (int j = 3; j >= 0; --j) {
                    ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(j);
                    if (itemStack == null || itemStack.getItem() == Items.AIR) continue;
                    ItemStack itemStack5 = itemStack.copy();
                    this.Method2161479(entityPlayer, itemStack5, n9, -8);
                    n9 += 16;
                }
            }
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
        }
        this.Method2161487();
        GlStateManager.resetColor();
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        GL11.glPopMatrix();
    }

    public float Method2161472(EntityLivingBase entityLivingBase) {
        ScaledResolution scaledResolution = new ScaledResolution(Field2811);
        double d = (double) scaledResolution.getScaleFactor() / Math.pow(scaledResolution.getScaleFactor(), 2.0);
        EntityPlayerSP entityPlayerSP = Field2811.getRenderViewEntity() == null ? NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.player : Field2811.getRenderViewEntity();
        return (float) d + entityPlayerSP.getDistance((Entity) entityLivingBase) / 7.0f;
    }

    public void Method2161473(float f, float f2, float f3, float f4, int n2, int n3, float f5) {
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161474(f + f5, f2 + f5, f3 - f5, f4 - f5, n3);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161474(f, f2, f + f5, f4, n2);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161474(f + f5, f2, f3, f2 + f5, n2);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161474(f + f5, f4 - f5, f3, f4, n2);
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161474(f3 - f5, f2 + f5, f3, f4 - f5, n2);
    }

    public void Method2161477(EntityPlayer entityPlayer, ItemStack itemStack, int n2, int n3, int n4, boolean bl) {
        GL11.glPushMatrix();
        GL11.glDepthMask((boolean) true);
        GlStateManager.clear((int) 256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.getRenderItem().zLevel = -100.0f;
        GlStateManager.scale((float) 1.0f, (float) 1.0f, (float) 0.01f);
        Field2811.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n2, n3 / 2 - 12);
        if (this.Field1938.getValue().booleanValue()) {
            Field2811.getRenderItem().renderItemOverlays(NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.fontRenderer, itemStack, n2, n3 / 2 - 12);
        }
        NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Field2811.getRenderItem().zLevel = 0.0f;
        GlStateManager.scale((float) 1.0f, (float) 1.0f, (float) 1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
        GlStateManager.disableDepth();
        this.Method2161470(entityPlayer, itemStack, n2, n3 - 18);
        if (!this.Field1950 && this.Field1939.getValue().booleanValue() && bl) {
            AliceMain.Field766.Method2150317(itemStack.getDisplayName().equalsIgnoreCase("Air") ? "" : itemStack.getDisplayName(), n4 * 2 + 95 - AliceMain.Field766.Method2150310(itemStack.getDisplayName()) / 2, n3 - 37, -1);
            this.Field1950 = true;
        }
        GlStateManager.enableDepth();
        GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
        GL11.glPopMatrix();
    }

    public boolean Method2161478(ItemStack itemStack) {
        int n2;
        NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
        ArrayList<String> arrayList = new ArrayList<String>();
        int n3 = 0;
        if (nBTTagList == null) {
            return false;
        }
        for (n2 = 0; n2 < nBTTagList.tagCount(); ++n2) {
            short s = nBTTagList.getCompoundTagAt(n2).getShort("id");
            short s2 = nBTTagList.getCompoundTagAt(n2).getShort("lvl");
            Enchantment enchantment = Enchantment.getEnchantmentByID((int) s);
            if (enchantment == null) continue;
            arrayList.add(enchantment.getTranslatedName((int) s2));
        }
        if (itemStack.getItem() == Items.DIAMOND_HELMET) {
            n2 = 5;
            for (String string : arrayList) {
                if (string.equalsIgnoreCase("Protection IV")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Respiration III")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Aqua Affinity")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Unbreaking III")) {
                    ++n3;
                }
                if (!string.equalsIgnoreCase("Mending")) continue;
                ++n3;
            }
            return n3 >= 5;
        }
        if (itemStack.getItem() == Items.DIAMOND_CHESTPLATE) {
            n2 = 3;
            for (String string : arrayList) {
                if (string.equalsIgnoreCase("Protection IV")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Unbreaking III")) {
                    ++n3;
                }
                if (!string.equalsIgnoreCase("Mending")) continue;
                ++n3;
            }
            return n3 >= 3;
        }
        if (itemStack.getItem() == Items.DIAMOND_LEGGINGS) {
            n2 = 3;
            for (String string : arrayList) {
                if (string.equalsIgnoreCase("Blast Protection IV")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Unbreaking III")) {
                    ++n3;
                }
                if (!string.equalsIgnoreCase("Mending")) continue;
                ++n3;
            }
            return n3 >= 3;
        }
        if (itemStack.getItem() == Items.DIAMOND_BOOTS) {
            n2 = 5;
            for (String string : arrayList) {
                if (string.equalsIgnoreCase("Protection IV")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Feather Falling IV")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Depth Strider III")) {
                    ++n3;
                }
                if (string.equalsIgnoreCase("Unbreaking III")) {
                    ++n3;
                }
                if (!string.equalsIgnoreCase("Mending")) continue;
                ++n3;
            }
            return n3 >= 5;
        }
        return false;
    }

    private void Method2161479(EntityPlayer entityPlayer, ItemStack itemStack, int n2, int n3) {
        GL11.glPushMatrix();
        GL11.glDepthMask((boolean) true);
        GlStateManager.clear((int) 256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.scale((float) 1.0f, (float) 1.0f, (float) 0.01f);
        GlStateManager.scale((float) 1.0f, (float) 1.0f, (float) 1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
        GlStateManager.disableDepth();
        if (itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemSword || itemStack.getItem() instanceof ItemTool) {
            float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
            float f2 = 1.0f - f;
            int n4 = 100 - (int) (f2 * 100.0f);
            AliceMain.Field766.Method2150317(n4 + "%", n2 * 2 + 4, n3 - 10, ColorUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163347((int) (f2 * 255.0f), (int) (f * 255.0f), 0));
        }
        GlStateManager.enableDepth();
        GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
        GL11.glPopMatrix();
    }

    public void Method2161470(EntityPlayer entityPlayer, ItemStack itemStack, int n2, int n3) {
        int n4;
        int n5 = n3;
        int n6 = n3;
        if ((itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemSword || itemStack.getItem() instanceof ItemTool) && this.Field1938.getValue().booleanValue()) {
            float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
            float f2 = 1.0f - f;
            n4 = 100 - (int) (f2 * 100.0f);
            AliceMain.Field766.Method2150317(n4 + "%", n2 * 2 + 4, n3 - 10, ColorUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163347((int) (f2 * 255.0f), (int) (f * 255.0f), 0));
        }
        if (this.Field1930.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE) {
            return;
        }
        if (this.Field1930.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MAX && this.Method2161478(itemStack)) {
            GL11.glPushMatrix();
            GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 0.0f);
            AliceMain.Field766.Method2150317("Max", n2 * 2 + 7, n6 + 24, 0xFF0000);
            GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 1.0f);
            GL11.glPopMatrix();
            return;
        }
        if (this.Field1930.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PROT) {
            NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
            for (int j = 0; j < nBTTagList.tagCount(); ++j) {
                n4 = nBTTagList.getCompoundTagAt(j).getShort("id");
                short s = nBTTagList.getCompoundTagAt(j).getShort("lvl");
                Enchantment enchantment = Enchantment.getEnchantmentByID((int) n4);
                if (enchantment == null || enchantment.isCurse()) continue;
                String string = s == 1 ? enchantment.getTranslatedName((int) s).substring(0, 3).toLowerCase() : enchantment.getTranslatedName((int) s).substring(0, 2).toLowerCase() + s;
                if (!(string = string.substring(0, 1).toUpperCase() + string.substring(1)).contains("Pr") && !string.contains("Bl"))
                    continue;
                GL11.glPushMatrix();
                GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 0.0f);
                AliceMain.Field766.Method2150317(string, n2 * 2 + 3, n6, -1);
                GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 1.0f);
                GL11.glPopMatrix();
                n5 += 8;
                n6 += 8;
            }
            return;
        }
        NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
        for (int j = 0; j < nBTTagList.tagCount(); ++j) {
            n4 = nBTTagList.getCompoundTagAt(j).getShort("id");
            short s = nBTTagList.getCompoundTagAt(j).getShort("lvl");
            Enchantment enchantment = Enchantment.getEnchantmentByID((int) n4);
            if (enchantment == null || enchantment.isCurse()) continue;
            String string = s == 1 ? enchantment.getTranslatedName((int) s).substring(0, 3).toLowerCase() : enchantment.getTranslatedName((int) s).substring(0, 2).toLowerCase() + s;
            string = string.substring(0, 1).toUpperCase() + string.substring(1);
            GL11.glPushMatrix();
            GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 0.0f);
            AliceMain.Field766.Method2150317(string, n2 * 2 + 3, n6, -1);
            GL11.glScalef((float) 1.0f, (float) 1.0f, (float) 1.0f);
            GL11.glPopMatrix();
            n5 += 8;
            n6 += 8;
        }
    }

    public void Method2161484(int n2, int n3, int n4, int n5) {
        GlStateManager.color((float) ((float) n2 / 255.0f), (float) ((float) n3 / 255.0f), (float) ((float) n4 / 255.0f), (float) ((float) n5 / 255.0f));
    }

    public void Method2161485(Color color) {
        float f = (float) color.getRed() / 255.0f;
        float f2 = (float) color.getGreen() / 255.0f;
        float f3 = (float) color.getBlue() / 255.0f;
        float f4 = (float) color.getAlpha() / 255.0f;
        GlStateManager.color((float) f, (float) f2, (float) f3, (float) f4);
    }

    private void Method2161486(int n2) {
        float f = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f2 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f4 = (float) (n2 & 0xFF) / 255.0f;
        GlStateManager.color((float) f2, (float) f3, (float) f4, (float) f);
    }

    public void Method2161487() {
        this.Field1951.forEach((arg_0, arg_1) -> this.Method2161493(arg_0, arg_1));
    }

    public void Method2161488(int n2) {
        this.Method2161492(n2, true);
    }

    public void Method2161489(int... arrn) {
        for (int n2 : arrn) {
            this.Method2161492(n2, true);
        }
    }

    public void Method2161480(int n2) {
        this.Method2161492(n2, false);
    }

    public void Method2161491(int... arrn) {
        for (int n2 : arrn) {
            this.Method2161492(n2, false);
        }
    }

    public void Method2161492(int n2, boolean bl) {
        this.Field1951.put(n2, GL11.glGetBoolean((int) n2));
        this.Method2161493(n2, bl);
    }

    public void Method2161493(int n2, boolean bl) {
        if (bl) {
            GL11.glEnable((int) n2);
        } else {
            GL11.glDisable((int) n2);
        }
    }

    public void Method2161494(double d, double d2, double d3, double d4, float f, int n2) {
        float f2;
        float f3;
        float f4;
        float f5;
        int n3;
        int n4;
        double d5;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glLineWidth((float) f);
        if (d < d3) {
            d5 = d;
            d = d3;
            d3 = d5;
        }
        if (d2 < d4) {
            d5 = d2;
            d2 = d4;
            d4 = d5;
        }
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.RAINBOW) {
            n4 = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161495(1).getRGB();
            n3 = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161495(1000).getRGB();
            int n5 = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161495(500).getRGB();
            int n6 = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161495(1).getRGB();
            f5 = (float) (n4 >> 24 & 0xFF) / 255.0f;
            f4 = (float) (n4 >> 16 & 0xFF) / 255.0f;
            f3 = (float) (n4 >> 8 & 0xFF) / 255.0f;
            f2 = (float) (n4 & 0xFF) / 255.0f;
            f6 = (float) (n3 >> 24 & 0xFF) / 255.0f;
            f7 = (float) (n3 >> 16 & 0xFF) / 255.0f;
            f8 = (float) (n3 >> 8 & 0xFF) / 255.0f;
            f9 = (float) (n3 & 0xFF) / 255.0f;
            f10 = (float) (n5 >> 24 & 0xFF) / 255.0f;
            f11 = (float) (n5 >> 16 & 0xFF) / 255.0f;
            f12 = (float) (n5 >> 8 & 0xFF) / 255.0f;
            f13 = (float) (n5 & 0xFF) / 255.0f;
            f14 = (float) (n6 >> 24 & 0xFF) / 255.0f;
            f15 = (float) (n6 >> 16 & 0xFF) / 255.0f;
            f16 = (float) (n6 >> 8 & 0xFF) / 255.0f;
            f17 = (float) (n6 & 0xFF) / 255.0f;
        } else if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.RAINBOW2) {
            n4 = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161495(1).getRGB();
            n3 = NametagsCAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZ.Method2161495(1000).getRGB();
            f5 = (float) (n4 >> 24 & 0xFF) / 255.0f;
            f4 = (float) (n4 >> 16 & 0xFF) / 255.0f;
            f3 = (float) (n4 >> 8 & 0xFF) / 255.0f;
            f2 = (float) (n4 & 0xFF) / 255.0f;
            f6 = (float) (n3 >> 24 & 0xFF) / 255.0f;
            f7 = (float) (n3 >> 16 & 0xFF) / 255.0f;
            f8 = (float) (n3 >> 8 & 0xFF) / 255.0f;
            f9 = (float) (n3 & 0xFF) / 255.0f;
        } else {
            f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
            f4 = (float) (n2 >> 16 & 0xFF) / 255.0f;
            f3 = (float) (n2 >> 8 & 0xFF) / 255.0f;
            f2 = (float) (n2 & 0xFF) / 255.0f;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.RAINBOW) {
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d3, d4, 0.0).color(f7, f8, f9, f6).endVertex();
            bufferBuilder.pos(d3, d2, 0.0).color(f7, f8, f9, f6).endVertex();
            bufferBuilder.pos(d, d2, 0.0).color(f11, f12, f13, f10).endVertex();
            bufferBuilder.pos(d, d4, 0.0).color(f15, f16, f17, f14).endVertex();
        } else if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.DEPEND) {
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d3, d4, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d3, d2, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d, d2, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
        } else if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NORMAL) {
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d3, d4, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d3, d2, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d, d2, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
        } else if (this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.RAINBOW2) {
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d3, d4, 0.0).color(f7, f8, f9, f6).endVertex();
            bufferBuilder.pos(d3, d2, 0.0).color(f4, f3, f2, f5).endVertex();
            bufferBuilder.pos(d, d2, 0.0).color(f7, f8, f9, f6).endVertex();
            bufferBuilder.pos(d, d4, 0.0).color(f4, f3, f2, f5).endVertex();
        }
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private boolean Method2161498(Object object) {
        return this.Field1944.getValue();
    }

    private boolean Method2161499(Object object) {
        return this.Field1944.getValue();
    }

    private boolean Method2161490(Object object) {
        return this.Field1944.getValue();
    }

    private boolean Method2161401(Object object) {
        return this.Field1944.getValue();
    }

    private boolean Method2161402(Object object) {
        return this.Field1923.getValue();
    }

    private boolean Method2161403(Object object) {
        return this.Field1923.getValue();
    }

    private boolean Method2161404(Object object) {
        return this.Field1923.getValue() != false && this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NORMAL;
    }

    private boolean Method2161405(Object object) {
        return this.Field1923.getValue() != false && this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NORMAL;
    }

    private boolean Method2161406(Object object) {
        return this.Field1923.getValue() != false && this.Field1948.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NORMAL;
    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        NORMAL,
        DEPEND,
        RAINBOW,
        RAINBOW2;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        TEXT,
        BOX;

    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        PROT,
        LIST,
        MAX,
        NONE;

    }
}

