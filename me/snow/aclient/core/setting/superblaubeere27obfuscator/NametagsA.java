

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemTool
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Iterator;
import java.util.Objects;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhaseUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class NametagsA
        extends Module {
    static final boolean Field2065;
    private static NametagsA Field2039;

    static {
        Field2065 = !NametagsA.class.desiredAssertionStatus();
        Field2039 = new NametagsA();
    }

    private final Setting<Boolean> Field2040 = this.Method2150366(new Setting<Boolean>("NoCustomFont", false));
    private final Setting<Boolean> Field2041 = this.Method2150366(new Setting<Boolean>("Health", true));
    private final Setting<Boolean> Field2042 = this.Method2150366(new Setting<Boolean>("Armor", true));
    private final Setting<Boolean> Field2043 = this.Method2150366(new Setting<Boolean>("Enchant", true));
    private final Setting<Boolean> Field2044 = this.Method2150366(new Setting<Boolean>("Invisibles", false));
    private final Setting<Boolean> Field2045 = this.Method2150366(new Setting<Boolean>("Ping", true));
    private final Setting<Boolean> Field2046 = this.Method2150366(new Setting<Boolean>("TotemPops", true));
    private final Setting<Boolean> Field2047 = this.Method2150366(new Setting<Boolean>("Gamemode", false));
    private final Setting<Boolean> Field2048 = this.Method2150366(new Setting<Boolean>("ID", false));
    private final Setting<Boolean> Field2049 = this.Method2150366(new Setting<Boolean>("Background", false));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2050 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("OutLine", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static, "Setting"));
    private final Setting<Float> Field2051 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.2f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2162591));
    private final Setting<Boolean> Field2052 = this.Method2150366(new Setting<Object>("Sync", Boolean.FALSE, this::Method2162580));
    private final Setting<Integer> Field2053 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(70), Integer.valueOf(0), Integer.valueOf(255), this::Method2162589));
    private final Setting<Integer> Field2054 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(70), Integer.valueOf(0), Integer.valueOf(255), this::Method2162588));
    private final Setting<Integer> Field2055 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(70), Integer.valueOf(0), Integer.valueOf(255), this::Method2162587));
    private final Setting<Integer> Field2056 = this.Method2150366(new Setting<Object>("Alpha", Integer.valueOf(140), Integer.valueOf(0), Integer.valueOf(255), this::Method2162586));
    private final Setting<Boolean> Field2057 = this.Method2150366(new Setting<Boolean>("StackName", true));
    private final Setting<Boolean> Field2058 = this.Method2150366(new Setting<Boolean>("OnlyFov", false));
    private final Setting<Boolean> Field2059 = this.Method2150366(new Setting<Boolean>("Sneak-Color", true));
    private final Setting<Boolean> Field2060 = this.Method2150366(new Setting<Boolean>("Phase-Color", false));
    private final Setting<Boolean> Field2061 = this.Method2150366(new Setting<Boolean>("Scale", true));
    private final Setting<Float> Field2062 = this.Method2150366(new Setting<Float>("Size", Float.valueOf(3.0f), Float.valueOf(0.1f), Float.valueOf(20.0f)));
    private final Setting<Float> Field2063 = this.Method2150366(new Setting<Object>("Factor", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2162585));
    private final Setting<Boolean> Field2064 = this.Method2150366(new Setting<Object>("SmartScale", Boolean.TRUE, this::Method2162584));

    public NametagsA() {
        super("Nametags", "Better Nametags.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162571();
    }

    public static NametagsA Method2162560() {
        if (Field2039 == null) {
            Field2039 = new NametagsA();
        }
        return Field2039;
    }

    public static Color Method2162582(int n2) {
        double d = Math.ceil((double) (System.currentTimeMillis() + (long) n2) / 20.0);
        return Color.getHSBColor((float) ((d %= 360.0) / 360.0), 1.0f, 1.0f);
    }

    public static boolean Method2162583(Entity entity) {
        BlockPos blockPos = new BlockPos(entity.posX, entity.posY, entity.posZ);
        return NametagsA.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || NametagsA.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.ENDER_CHEST;
    }

    private void Method2162571() {
        Field2039 = this;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (!NametagsA.Method2150359()) {
            for (EntityPlayer entityPlayer : NametagsA.Field2811.world.playerEntities) {
                if (entityPlayer == null || entityPlayer.equals((Object) NametagsA.Field2811.player) || !entityPlayer.isEntityAlive() || entityPlayer.isInvisible() && !this.Field2044.getValue().booleanValue() || this.Field2058.getValue().booleanValue() && RotationUtil.Method2163007((Entity) entityPlayer))
                    continue;
                double d = this.Method2162579(entityPlayer.lastTickPosX, entityPlayer.posX, render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()) - NametagsA.Field2811.getRenderManager().renderPosX;
                double d2 = this.Method2162579(entityPlayer.lastTickPosY, entityPlayer.posY, render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()) - NametagsA.Field2811.getRenderManager().renderPosY;
                double d3 = this.Method2162579(entityPlayer.lastTickPosZ, entityPlayer.posZ, render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()) - NametagsA.Field2811.getRenderManager().renderPosZ;
                this.Method2162573(entityPlayer, d, d2, d3, render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            }
        }
    }

    public void Method2162572(float f, float f2, float f3, float f4, int n2) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth((float) this.Field2051.getValue().floatValue());
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    private void Method2162573(EntityPlayer entityPlayer, double d, double d2, double d3, float f) {
        int n2;
        double d4 = d2;
        d4 += entityPlayer.isSneaking() ? 0.5 : 0.7;
        Entity entity = Field2811.getRenderViewEntity();
        if (!Field2065 && entity == null) {
            throw new AssertionError();
        }
        double d5 = entity.posX;
        double d6 = entity.posY;
        double d7 = entity.posZ;
        entity.posX = this.Method2162579(entity.prevPosX, entity.posX, f);
        entity.posY = this.Method2162579(entity.prevPosY, entity.posY, f);
        entity.posZ = this.Method2162579(entity.prevPosZ, entity.posZ, f);
        String string = this.Method2162577(entityPlayer);
        double d8 = entity.getDistance(d + NametagsA.Field2811.getRenderManager().viewerPosX, d2 + NametagsA.Field2811.getRenderManager().viewerPosY, d3 + NametagsA.Field2811.getRenderManager().viewerPosZ);
        int n3 = this.Field2040.getValue() != false ? NametagsA.Field2811.fontRenderer.getStringWidth(string) / 2 : this.Field3872.Method2150310(string) / 2;
        double d9 = (0.0018 + (double) this.Field2062.getValue().floatValue() * (d8 * (double) this.Field2063.getValue().floatValue())) / 1000.0;
        if (d8 <= 8.0 && this.Field2064.getValue().booleanValue()) {
            d9 = 0.0245;
        }
        if (!this.Field2061.getValue().booleanValue()) {
            d9 = (double) this.Field2062.getValue().floatValue() / 100.0;
        }
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float) 1.0f, (float) -1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((float) ((float) d), (float) ((float) d4 + 1.4f), (float) ((float) d3));
        GlStateManager.rotate((float) (-NametagsA.Field2811.getRenderManager().playerViewY), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) NametagsA.Field2811.getRenderManager().playerViewX, (float) (NametagsA.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((double) (-d9), (double) (-d9), (double) d9);
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        GlStateManager.enableBlend();
        if (this.Field2049.getValue().booleanValue()) {
            this.Method2162572(-n3 - 2, this.Field2040.getValue() != false ? (float) (-(NametagsA.Field2811.fontRenderer.FONT_HEIGHT + 1)) : (float) (-(this.Field3872.Method2150321() + 1)), (float) n3 + 2.0f, 1.5f, 0x55000000);
        }
        if (this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static) {
            n2 = this.Field2052.getValue() != false ? Colors.Field1782.Method2150585() : new Color(this.Field2053.getValue(), this.Field2054.getValue(), this.Field2055.getValue(), this.Field2056.getValue()).getRGB();
            this.Method2162570(-n3 - 2, this.Field2040.getValue() != false ? (float) (-(NametagsA.Field2811.fontRenderer.FONT_HEIGHT + 1)) : (float) (-(this.Field3872.Method2150321() + 1)), (float) n3 + 2.0f, 1.5f, n2);
        }
        if (this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow) {
            n2 = this.Field2052.getValue() != false ? Colors.Field1782.Method2150585() : new Color(this.Field2053.getValue(), this.Field2054.getValue(), this.Field2055.getValue(), this.Field2056.getValue()).getRGB();
            this.Method2162581(-n3 - 2, this.Field2040.getValue() != false ? (double) (-(NametagsA.Field2811.fontRenderer.FONT_HEIGHT + 1)) : (double) (-(this.Field3872.Method2150321() + 1)), n3 + 2, 1.5, this.Field2051.getValue().floatValue());
        }
        GlStateManager.disableBlend();
        ItemStack itemStack = entityPlayer.getHeldItemMainhand().copy();
        if (itemStack.hasEffect() && (itemStack.getItem() instanceof ItemTool || itemStack.getItem() instanceof ItemArmor)) {
            itemStack.stackSize = 1;
        }
        if (this.Field2057.getValue().booleanValue() && !itemStack.isEmpty && itemStack.getItem() != Items.AIR) {
            String string2 = itemStack.getDisplayName();
            int n4 = this.Field2040.getValue() != false ? NametagsA.Field2811.fontRenderer.getStringWidth(string2) / 2 : this.Field3872.Method2150310(string2) / 2;
            GL11.glPushMatrix();
            GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
            if (this.Field2040.getValue().booleanValue()) {
                NametagsA.Field2811.fontRenderer.drawStringWithShadow(string2, (float) (-n4), -(this.Method2162576(entityPlayer) + 50.0f), -1);
            } else {
                this.Field3872.Method2150317(string2, -n4, -(this.Method2162576(entityPlayer) + 50.0f), -1);
            }
            GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
            GL11.glPopMatrix();
        }
        if (this.Field2042.getValue().booleanValue()) {
            GlStateManager.pushMatrix();
            int n5 = -8;
            for (ItemStack itemStack2 : entityPlayer.inventory.armorInventory) {
                if (itemStack2 == null) continue;
                n5 -= 8;
            }
            Iterator iterator = entityPlayer.getHeldItemOffhand().copy();
            this.Method2162574(itemStack, n5 -= 8);
            n5 += 16;
            for (int j = 3; j >= 0; --j) {
                ItemStack itemStack3 = (ItemStack) entityPlayer.inventory.armorInventory.get(j);
                if (itemStack3 == null) continue;
                ItemStack itemStack4 = itemStack3.copy();
                this.Method2162574(itemStack4, n5);
                n5 += 16;
            }
            this.Method2162574((ItemStack) iterator, n5);
            GlStateManager.popMatrix();
        }
        if (this.Field2040.getValue().booleanValue()) {
            NametagsA.Field2811.fontRenderer.drawStringWithShadow(string, (float) (-n3), (float) (-(NametagsA.Field2811.fontRenderer.FONT_HEIGHT - 1)), this.Method2162578(entityPlayer));
        } else {
            this.Field3872.Method2150317(string, -n3, -(this.Field3872.Method2150321() - 1), this.Method2162578(entityPlayer));
        }
        entity.posX = d5;
        entity.posY = d6;
        entity.posZ = d7;
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float) 1.0f, (float) 1500000.0f);
        GlStateManager.popMatrix();
    }

    private void Method2162574(ItemStack itemStack, int n2) {
        GlStateManager.pushMatrix();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.clear((int) 256);
        RenderHelper.enableStandardItemLighting();
        NametagsA.Field2811.getRenderItem().zLevel = -150.0f;
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableCull();
        Field2811.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n2, -26);
        Field2811.getRenderItem().renderItemOverlays(NametagsA.Field2811.fontRenderer, itemStack, n2, -26);
        NametagsA.Field2811.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableCull();
        GlStateManager.enableAlpha();
        GlStateManager.scale((float) 0.5f, (float) 0.5f, (float) 0.5f);
        GlStateManager.disableDepth();
        if (this.Field2043.getValue().booleanValue()) {
            this.Method2162575(itemStack, n2);
        }
        GlStateManager.enableDepth();
        GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
        GlStateManager.popMatrix();
    }

    private void Method2162575(ItemStack itemStack, int n2) {
        int n3;
        int n4 = -34;
        if (itemStack.getItem() == Items.GOLDEN_APPLE && itemStack.hasEffect()) {
            if (this.Field2040.getValue().booleanValue()) {
                NametagsA.Field2811.fontRenderer.drawStringWithShadow("god", (float) (n2 * 2), (float) n4, -3977919);
            } else {
                this.Field3872.Method2150317("god", n2 * 2, n4, -3977919);
            }
            n4 -= 8;
        }
        NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
        for (n3 = 0; n3 < nBTTagList.tagCount(); ++n3) {
            short s = nBTTagList.getCompoundTagAt(n3).getShort("id");
            short s2 = nBTTagList.getCompoundTagAt(n3).getShort("lvl");
            Enchantment enchantment = Enchantment.getEnchantmentByID((int) s);
            if (enchantment == null) continue;
            String string = s2 == 1 ? enchantment.getTranslatedName((int) s2).substring(0, 3).toLowerCase() : enchantment.getTranslatedName((int) s2).substring(0, 2).toLowerCase() + s2;
            string = string.substring(0, 1).toUpperCase() + string.substring(1);
            if (this.Field2040.getValue().booleanValue()) {
                NametagsA.Field2811.fontRenderer.drawStringWithShadow(string, (float) (n2 * 2), (float) n4, -1);
            } else {
                this.Field3872.Method2150317(string, n2 * 2, n4, -1);
            }
            n4 -= 8;
        }
        if (DamageUtil.Method2163456(itemStack)) {
            String string;
            n3 = DamageUtil.Method2163455(itemStack);
            String string2 = n3 >= 60 ? "\u00a7a" : (string = n3 >= 25 ? "\u00a7e" : "\u00a7c");
            if (this.Field2040.getValue().booleanValue()) {
                NametagsA.Field2811.fontRenderer.drawStringWithShadow(string + n3 + "%", (float) (n2 * 2), (float) n4, -1);
            } else {
                this.Field3872.Method2150317(string + n3 + "%", n2 * 2, n4, -1);
            }
        }
    }

    private float Method2162576(EntityPlayer entityPlayer) {
        ItemStack itemStack;
        Enchantment enchantment;
        short s;
        int n2;
        float f = 0.0f;
        boolean bl = false;
        for (ItemStack itemStack2 : entityPlayer.inventory.armorInventory) {
            float f2 = 0.0f;
            if (itemStack2 != null) {
                NBTTagList nBTTagList = itemStack2.getEnchantmentTagList();
                for (n2 = 0; n2 < nBTTagList.tagCount(); ++n2) {
                    s = nBTTagList.getCompoundTagAt(n2).getShort("id");
                    enchantment = Enchantment.getEnchantmentByID((int) s);
                    if (enchantment == null) continue;
                    f2 += 8.0f;
                    bl = true;
                }
            }
            if (!(f2 > f)) continue;
            f = f2;
        }
        Iterator iterator = entityPlayer.getHeldItemMainhand().copy();
        if (iterator.hasEffect()) {
            float f3 = 0.0f;
            NBTTagList nBTTagList = iterator.getEnchantmentTagList();
            for (int j = 0; j < nBTTagList.tagCount(); ++j) {
                s = nBTTagList.getCompoundTagAt(j).getShort("id");
                Enchantment enchantment2 = Enchantment.getEnchantmentByID((int) s);
                if (enchantment2 == null) continue;
                f3 += 8.0f;
                bl = true;
            }
            if (f3 > f) {
                f = f3;
            }
        }
        if ((itemStack = entityPlayer.getHeldItemOffhand().copy()).hasEffect()) {
            float f4 = 0.0f;
            NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
            for (n2 = 0; n2 < nBTTagList.tagCount(); ++n2) {
                short s2 = nBTTagList.getCompoundTagAt(n2).getShort("id");
                enchantment = Enchantment.getEnchantmentByID((int) s2);
                if (enchantment == null) continue;
                f4 += 8.0f;
                bl = true;
            }
            if (f4 > f) {
                f = f4;
            }
        }
        return (float) (bl ? 0 : 20) + f;
    }

    private String Method2162577(EntityPlayer entityPlayer) {
        String string;
        String string2 = entityPlayer.getDisplayName().getFormattedText();
        if (string2.contains(Field2811.getSession().getUsername())) {
            string2 = NametagsA.Field2811.player.getDisplayNameString();
        }
        if (!this.Field2041.getValue().booleanValue()) {
            return string2;
        }
        float f = EntityUtil.Method2163530((Entity) entityPlayer);
        String string3 = f > 18.0f ? "\u00a7a" : (f > 16.0f ? "\u00a72" : (f > 12.0f ? "\u00a7e" : (f > 8.0f ? "\u00a76" : (f > 5.0f ? "\u00a7c" : "\u00a74"))));
        String string4 = "";
        if (this.Field2045.getValue().booleanValue()) {
            try {
                int n2 = Objects.requireNonNull(Field2811.getConnection()).getPlayerInfo(entityPlayer.getUniqueID()).getResponseTime();
                string4 = string4 + " " + n2 + "ms";
            } catch (Exception exception) {
                // empty catch block
            }
        }
        String string5 = " ";
        if (this.Field2046.getValue().booleanValue()) {
            string5 = string5 + AliceMain.Field774.Method2150340(entityPlayer);
        }
        String string6 = "";
        if (this.Field2048.getValue().booleanValue()) {
            string6 = string6 + " ID: " + entityPlayer.getEntityId() + " ";
        }
        String string7 = "";
        if (this.Field2047.getValue().booleanValue()) {
            string = entityPlayer.isCreative() ? string7 + "[C] " : (string7 = entityPlayer.isSpectator() || entityPlayer.isInvisible() ? string7 + "[I] " : string7 + "[S] ");
        }
        string = "";
        string = Math.floor(f) == (double) f ? string3 + " " + (f > 0.0f ? Integer.valueOf((int) Math.floor(f)) : "dead") : string3 + " " + (f > 0.0f ? Integer.valueOf((int) f) : "dead");
        return string2 + string6 + string7 + string4 + string + string5;
    }

    private int Method2162578(EntityPlayer entityPlayer) {
        int n2 = -5592406;
        n2 = -1;
        if (AliceMain.Field765.Method2150169(entityPlayer)) {
            return -10027009;
        }
        if (entityPlayer.isInvisible()) {
            n2 = -1113785;
        } else if (entityPlayer.isSneaking() && this.Field2059.getValue().booleanValue()) {
            n2 = -6481515;
        } else if (PhaseUtil.Method2163915((Entity) entityPlayer) && this.Field2060.getValue().booleanValue()) {
            n2 = ColorUtil.Method2163379(253, 115, 115, 255);
        }
        return n2;
    }

    private double Method2162579(double d, double d2, float f) {
        return d + (d2 - d) * (double) f;
    }

    public void Method2162570(float f, float f2, float f3, float f4, int n2) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth((float) this.Field2051.getValue().floatValue());
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        bufferBuilder.begin(2, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double) f, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public void Method2162581(double d, double d2, double d3, double d4, float f) {
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
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        int n2 = NametagsA.Method2162582(1).getRGB();
        int n3 = NametagsA.Method2162582(1000).getRGB();
        int n4 = NametagsA.Method2162582(500).getRGB();
        int n5 = NametagsA.Method2162582(1).getRGB();
        float f14 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f15 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f16 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f17 = (float) (n2 & 0xFF) / 255.0f;
        f2 = (float) (n3 >> 24 & 0xFF) / 255.0f;
        f3 = (float) (n3 >> 16 & 0xFF) / 255.0f;
        f4 = (float) (n3 >> 8 & 0xFF) / 255.0f;
        f5 = (float) (n3 & 0xFF) / 255.0f;
        f6 = (float) (n4 >> 24 & 0xFF) / 255.0f;
        f7 = (float) (n4 >> 16 & 0xFF) / 255.0f;
        f8 = (float) (n4 >> 8 & 0xFF) / 255.0f;
        f9 = (float) (n4 & 0xFF) / 255.0f;
        f10 = (float) (n5 >> 24 & 0xFF) / 255.0f;
        f11 = (float) (n5 >> 16 & 0xFF) / 255.0f;
        f12 = (float) (n5 >> 8 & 0xFF) / 255.0f;
        f13 = (float) (n5 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(d, d4, 0.0).color(f15, f16, f17, f14).endVertex();
        bufferBuilder.pos(d3, d4, 0.0).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(d3, d2, 0.0).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(d, d2, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos(d, d4, 0.0).color(f11, f12, f13, f10).endVertex();
        tessellator.draw();
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private boolean Method2162584(Object object) {
        return this.Field2061.getValue();
    }

    private boolean Method2162585(Object object) {
        return this.Field2061.getValue();
    }

    private boolean Method2162586(Object object) {
        return this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static;
    }

    private boolean Method2162587(Object object) {
        return this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static;
    }

    private boolean Method2162588(Object object) {
        return this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static;
    }

    private boolean Method2162589(Object object) {
        return this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static;
    }

    private boolean Method2162580(Object object) {
        return this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static;
    }

    private boolean Method2162591(Object object) {
        return this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Static || this.Field2050.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Rainbow;
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        FULL,
        MINIMAL,
        NONE;

    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        None,
        Static,
        Rainbow;

    }
}

