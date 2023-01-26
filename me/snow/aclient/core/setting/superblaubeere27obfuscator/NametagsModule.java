

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
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemAppleGold
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.text.TextFormatting
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InterpolationUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtilCC;
import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;

public class NametagsModule
        extends Module {
    public static NametagsModule Field985;
    private final Setting<Boolean> Field986 = this.Method2150366(new Setting<Boolean>("Health", true));
    private final Setting<Boolean> Field987 = this.Method2150366(new Setting<Boolean>("HealthBar", Boolean.valueOf(false), this::Method2161525));
    private final Setting<Boolean> Field988 = this.Method2150366(new Setting<Boolean>("Ping", true));
    private final Setting<Boolean> Field989 = this.Method2150366(new Setting<Boolean>("Gamemode", false));
    private final Setting<Boolean> Field990 = this.Method2150366(new Setting<Boolean>("TotemPops", true));
    private final Setting<Boolean> Field991 = this.Method2150366(new Setting<Boolean>("Armor", true));
    private final Setting<Boolean> Field992 = this.Method2150366(new Setting<Boolean>("Enchantments", true));
    private final Setting<Boolean> Field993 = this.Method2150366(new Setting<Boolean>("SimpleEnchantments", Boolean.valueOf(false), this::Method2161524));
    private final Setting<Boolean> Field994 = this.Method2150366(new Setting<Boolean>("Durability", true));
    private final Setting<Boolean> Field995 = this.Method2150366(new Setting<Boolean>("Mainhand", true));
    private final Setting<Boolean> Field996 = this.Method2150366(new Setting<Boolean>("Offhand", true));
    private final Setting<Boolean> Field997 = this.Method2150366(new Setting<Boolean>("ItemName", false));
    private final Setting<Boolean> Field998 = this.Method2150366(new Setting<Boolean>("Background", true));
    private final Setting<Boolean> Field999 = this.Method2150366(new Setting<Boolean>("Outline", false));
    private final Setting<Double> Field1000 = this.Method2150366(new Setting<Double>("Scale", 0.2, 0.1, 3.0));
    private final Setting<Boolean> Field1001 = this.Method2150366(new Setting<Boolean>("DistanceScale", false));
    private final Setting<Boolean> Field1002 = this.Method2150366(new Setting<Boolean>("BackGrounddd", Boolean.FALSE));
    private final Setting<Boolean> Field1003 = this.Method2150366(new Setting<Boolean>("Outline", Boolean.FALSE));
    private final Setting<Boolean> Field1004 = this.Method2150366(new Setting<Object>("Sync", Boolean.FALSE, this::Method2161523));
    private final Setting<Integer> Field1005 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161522));
    private final Setting<Integer> Field1006 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161521));
    private final Setting<Integer> Field1007 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161510));
    private final Setting<Integer> Field1008 = this.Method2150366(new Setting<Object>("Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161519));
    private final Setting<Float> Field1009 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2161518));
    private final Setting<Boolean> Field1010 = this.Method2150366(new Setting<Boolean>("Scale", true));
    private final Setting<Float> Field1011 = this.Method2150366(new Setting<Float>("Size", Float.valueOf(3.0f), Float.valueOf(0.1f), Float.valueOf(20.0f)));
    private final Setting<Float> Field1012 = this.Method2150366(new Setting<Object>("Factor", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2161517));
    private final Setting<Boolean> Field1013 = this.Method2150366(new Setting<Object>("SmartScale", Boolean.TRUE, this::Method2161516));
    private Map<EntityPlayer, String> Field1014 = new ConcurrentHashMap<EntityPlayer, String>();
    private float Field1015;
    private float Field1016;
    private int Field1017;
    private int Field1018;

    public NametagsModule() {
        super("NametagsModule", "Better Nametags.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        Field985 = this;
    }

    private static void Method2161515(List list, ItemStack itemStack) {
        if (!itemStack.isEmpty()) {
            list.add(itemStack);
        }
    }

    @Override
    public void Method2150379() {
        this.Field1014 = this.Method2161407();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (NametagsModule.Field2811.renderEngine != null && NametagsModule.Field2811.getRenderManager().options != null) {
            this.Field1014.forEach((arg_0, arg_1) -> this.Method2161400(arg_0, arg_1));
        }
    }

    public Map<EntityPlayer, String> Method2161407() {
        ConcurrentHashMap<EntityPlayer, String> concurrentHashMap = new ConcurrentHashMap<EntityPlayer, String>();
        NametagsModule.Field2811.world.playerEntities.forEach(arg_0 -> this.Method2161409(concurrentHashMap, arg_0));
        return concurrentHashMap;
    }

    public void Method2161408(float f, float f2, float f3, float f4, int n2) {
        float f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth((float) this.Field1009.getValue().floatValue());
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

    private void Method2161409(Map map, EntityPlayer entityPlayer) {
        if (!NametagsModule.Field2811.player.equals((Object) entityPlayer)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!EntityUtil.Method2163539((Entity) entityPlayer)) {
                TextFormatting textFormatting;
                int n2;
                if (entityPlayer.isSneaking()) {
                    stringBuilder.append((Object) TextFormatting.GOLD);
                }
                if (AliceMain.Field765.Method2150168(entityPlayer.getName())) {
                    stringBuilder.append((Object) TextFormatting.AQUA);
                }
                stringBuilder.append(entityPlayer.getName()).append(" ");
                if (this.Field989.getValue().booleanValue()) {
                    if (entityPlayer.isCreative()) {
                        stringBuilder.append("[C] ");
                    } else if (entityPlayer.isInvisible() || entityPlayer.isSpectator()) {
                        stringBuilder.append("[I] ");
                    } else {
                        stringBuilder.append("[S] ");
                    }
                }
                if (this.Field988.getValue().booleanValue() && Field2811.getConnection() != null && Field2811.getConnection().getPlayerInfo(entityPlayer.getUniqueID()) != null) {
                    n2 = Field2811.getConnection().getPlayerInfo(entityPlayer.getUniqueID()).getResponseTime();
                    textFormatting = TextFormatting.GREEN;
                    if (AliceMain.Field765.Method2150168(entityPlayer.getName())) {
                        textFormatting = TextFormatting.AQUA;
                    } else if (n2 >= 70 && n2 < 120) {
                        textFormatting = TextFormatting.YELLOW;
                    } else if (n2 >= 120 && n2 < 150) {
                        textFormatting = TextFormatting.GOLD;
                    } else if (n2 >= 150) {
                        textFormatting = TextFormatting.RED;
                    }
                    stringBuilder.append(n2).append("ms ");
                }
                if (this.Field986.getValue().booleanValue()) {
                    float f = MathUtil.Method2163854(EntityUtil.Method2163530((Entity) entityPlayer), 1);
                    textFormatting = TextFormatting.GREEN;
                    if (f <= 16.0f && f > 12.0f) {
                        textFormatting = TextFormatting.YELLOW;
                    } else if (f <= 12.0f && f > 8.0f) {
                        textFormatting = TextFormatting.GOLD;
                    } else if (f <= 8.0f && f > 4.0f) {
                        textFormatting = TextFormatting.RED;
                    } else if (f <= 4.0f) {
                        textFormatting = TextFormatting.DARK_RED;
                    }
                    stringBuilder.append((Object) textFormatting).append(f).append(" ");
                }
                if (this.Field990.getValue().booleanValue() && (n2 = AliceMain.Field774.Method2150349(entityPlayer)) > 0) {
                    textFormatting = TextFormatting.GREEN;
                    if (n2 > 2) {
                        textFormatting = TextFormatting.DARK_GREEN;
                    }
                    if (n2 > 4) {
                        textFormatting = TextFormatting.YELLOW;
                    }
                    if (n2 > 6) {
                        textFormatting = TextFormatting.GOLD;
                    }
                    if (n2 > 8) {
                        textFormatting = TextFormatting.RED;
                    }
                    stringBuilder.append((Object) textFormatting).append("-").append(n2).append(" ");
                }
                map.put(entityPlayer, stringBuilder.toString());
            }
        }
    }

    private void Method2161400(EntityPlayer entityPlayer, String string) {
        if (Field2811.getRenderViewEntity() != null) {
            Object object;
            Serializable serializable;
            double d = ((IRenderManager) Field2811.getRenderManager()).getRenderPosX();
            double d2 = ((IRenderManager) Field2811.getRenderManager()).getRenderPosY();
            double d3 = ((IRenderManager) Field2811.getRenderManager()).getRenderPosZ();
            Vec3d vec3d = InterpolationUtil.Method2163764((Entity) entityPlayer, Field2811.getRenderPartialTicks());
            int n2 = AliceMain.Field766.Method2150310(string);
            float f = (float) n2 / 2.0f;
            double d4 = Field2811.getRenderViewEntity().getDistance(vec3d.x, vec3d.y, vec3d.z);
            double d5 = (0.0018 + (double) this.Field1011.getValue().floatValue() * (d4 * (double) this.Field1012.getValue().floatValue())) / 1000.0;
            if (d4 <= 8.0 && this.Field1013.getValue().booleanValue()) {
                d5 = 0.0245;
            }
            if (!this.Field1010.getValue().booleanValue()) {
                d5 = (double) this.Field1011.getValue().floatValue() / 100.0;
            }
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset((float) 1.0f, (float) -1500000.0f);
            GlStateManager.disableLighting();
            GlStateManager.translate((double) (vec3d.x - d), (double) (vec3d.y + (double) entityPlayer.height + (entityPlayer.isSneaking() ? 0.05 : 0.08) - d2), (double) (vec3d.z - d3));
            GlStateManager.rotate((float) (-NametagsModule.Field2811.getRenderManager().playerViewY), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            GlStateManager.rotate((float) NametagsModule.Field2811.getRenderManager().playerViewX, (float) (NametagsModule.Field2811.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
            GlStateManager.scale((double) (-d5), (double) (-d5), (double) d5);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            if (this.Field998.getValue().booleanValue() || this.Field999.getValue().booleanValue() || this.Field987.getValue().booleanValue()) {
                GlStateManager.enableBlend();
                if (this.Field999.getValue().booleanValue()) {
                    serializable = this.Field1004.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field1005.getValue(), this.Field1006.getValue(), this.Field1007.getValue(), this.Field1008.getValue());
                    RenderUtilCC.Method2163336(-f - 1.0f, -AliceMain.Field766.Method2150321() - (7 + (this.Field987.getValue() != false ? 2 : 0)), n2, AliceMain.Field766.Method2150321() + 2, (Color) serializable);
                }
                if (this.Field998.getValue().booleanValue()) {
                    RenderUtilCC.Method2163335(-f - 1.0f, -AliceMain.Field766.Method2150321() - (7 + (this.Field987.getValue() != false ? 2 : 0)), n2, AliceMain.Field766.Method2150321() + 2, new Color(0, 0, 0, 100));
                }
                if (this.Field1002.getValue().booleanValue()) {
                    this.Method2161408(-f - 1.0f, -AliceMain.Field766.Method2150321() - (7 + (this.Field987.getValue() != false ? 2 : 0)), n2, AliceMain.Field766.Method2150321() + 2, 0x55000000);
                }
                if (this.Field987.getValue().booleanValue()) {
                    float f2 = MathUtil.Method2163854(EntityUtil.Method2163530((Entity) entityPlayer), 1);
                    object = Color.GREEN;
                    if (AliceMain.Field765.Method2150168(entityPlayer.getName())) {
                        object = Color.CYAN;
                    } else if (f2 <= 16.0f && f2 > 12.0f) {
                        object = Color.YELLOW;
                    } else if (f2 <= 12.0f && f2 > 8.0f) {
                        object = Color.ORANGE;
                    } else if (f2 <= 8.0f) {
                        object = Color.RED;
                    }
                    if (this.Field999.getValue().booleanValue()) {
                        RenderUtilCC.Method2163335(-f - 2.0f, -7.0f, (float) (n2 + 1) * (f2 / 36.0f), 2.0f, (Color) object);
                    } else {
                        RenderUtilCC.Method2163335(-f - 1.0f, -7.0f, (float) n2 * (f2 / 36.0f), 2.0f, (Color) object);
                    }
                }
                GlStateManager.disableBlend();
            }
            AliceMain.Field766.Method2150317(string, -f + 1.0f, -AliceMain.Field766.Method2150321() - (5 + (this.Field987.getValue() != false ? 2 : 0)), -1);
            serializable = new ArrayList();
            if (this.Field996.getValue().booleanValue() && !entityPlayer.getHeldItemOffhand().isEmpty()) {
                serializable.add(entityPlayer.getHeldItemOffhand());
            }
            if (this.Field991.getValue().booleanValue()) {
                entityPlayer.getArmorInventoryList().forEach(arg_0 -> NametagsModule.Method2161515((List) ((Object) serializable), arg_0));
            }
            if (this.Field995.getValue().booleanValue() && !entityPlayer.getHeldItemMainhand().isEmpty()) {
                serializable.add(entityPlayer.getHeldItemMainhand());
            }
            Collections.reverse(serializable);
            if (this.Field992.getValue().booleanValue()) {
                this.Field1017 = 0;
                serializable.forEach(this::Method2161514);
            } else {
                this.Field1017 = 4;
            }
            if (this.Field993.getValue().booleanValue()) {
                this.Field1017 = 4;
            }
            if (this.Field1017 < 4) {
                this.Field1017 = 4;
            }
            this.Field1015 = -8 * serializable.size();
            serializable.forEach(this::Method2161511);
            if (this.Field997.getValue().booleanValue() && !entityPlayer.getHeldItemMainhand().isEmpty()) {
                object = entityPlayer.getHeldItemMainhand().getDisplayName();
                GlStateManager.pushMatrix();
                GlStateManager.scale((double) 0.3, (double) 0.3, (double) 0.3);
                float f3 = (float) (-8 * serializable.size() + 16) * 3.3333335f;
                float f4 = (float) (this.Field1017 * -6 - AliceMain.Field766.Method2150321() - 12 - (this.Field987.getValue() != false ? 2 : 0)) * 3.3333335f;
                AliceMain.Field766.Method2150317((String) object, f3, f4, -1);
                GlStateManager.scale((double) 3.33334, (double) 3.33334, (double) 3.33334);
                GlStateManager.popMatrix();
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float) 1.0f, (float) 1500000.0f);
        GlStateManager.popMatrix();
    }

    private void Method2161511(ItemStack itemStack) {
        GlStateManager.pushMatrix();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.clear((int) 256);
        RenderHelper.enableStandardItemLighting();
        NametagsModule.Field2811.getRenderItem().zLevel = -150.0f;
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableCull();
        Field2811.getRenderItem().renderItemAndEffectIntoGUI(itemStack, (int) this.Field1015, this.Field1017 * -7 - 5 - (this.Field987.getValue() != false ? 2 : 0));
        Field2811.getRenderItem().renderItemOverlays(NametagsModule.Field2811.fontRenderer, itemStack, (int) this.Field1015, this.Field1017 * -7 - 5 - (this.Field987.getValue() != false ? 2 : 0));
        NametagsModule.Field2811.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableCull();
        GlStateManager.enableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
        if (this.Field994.getValue().booleanValue()) {
            if (itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemPickaxe || itemStack.getItem() instanceof ItemSword || itemStack.getItem() instanceof ItemTool) {
                this.Field1016 = -AliceMain.Field766.Method2150321() - 1;
                GlStateManager.pushMatrix();
                GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
                int n2 = (int) MathUtil.Method2163854((float) (itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float) itemStack.getMaxDamage() * 100.0f, 0);
                TextFormatting textFormatting = TextFormatting.GREEN;
                if (n2 <= 60 && n2 > 40) {
                    textFormatting = TextFormatting.YELLOW;
                } else if (n2 <= 40 && n2 > 20) {
                    textFormatting = TextFormatting.GOLD;
                } else if (n2 <= 20) {
                    textFormatting = TextFormatting.RED;
                }
                float f = (this.Field1015 + 3.0f) * 2.0f;
                float f2 = (this.Field1017 * -7 - 5 - (this.Field987.getValue() != false ? 2 : 0)) * 2;
                AliceMain.Field766.Method2150317(String.valueOf((Object) textFormatting) + n2 + "%", f, f2 + this.Field1016, -1);
                this.Field1016 += (float) (AliceMain.Field766.Method2150321() + 1);
                GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
                GlStateManager.popMatrix();
            }
        } else {
            this.Field1016 = 0.0f;
        }
        if (this.Field992.getValue().booleanValue()) {
            if (this.Field993.getValue().booleanValue()) {
                this.Field1018 = 0;
                EnchantmentHelper.getEnchantments((ItemStack) itemStack).forEach((arg_0, arg_1) -> this.Method2161513(itemStack, arg_0, arg_1));
                if (this.Field1018 >= 4) {
                    GlStateManager.pushMatrix();
                    GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
                    float f = (this.Field1015 + 3.0f) * 2.0f;
                    float f3 = (this.Field1017 * -7 - 5 - (this.Field987.getValue() != false ? 2 : 0)) * 2;
                    AliceMain.Field766.Method2150317("Max", f, f3, -1);
                    GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
                    GlStateManager.popMatrix();
                }
            } else {
                EnchantmentHelper.getEnchantments((ItemStack) itemStack).forEach((arg_0, arg_1) -> this.Method2161512(itemStack, arg_0, arg_1));
            }
        }
        this.Field1015 += 16.0f;
    }

    private void Method2161512(ItemStack itemStack, Enchantment enchantment, Integer n2) {
        GlStateManager.pushMatrix();
        GlStateManager.scale((double) 0.5, (double) 0.5, (double) 0.5);
        StringBuilder stringBuilder = new StringBuilder();
        if (itemStack.getItem() instanceof ItemAppleGold) {
            if (itemStack.hasEffect()) {
                // empty if block
            }
        } else if (itemStack.getItem() instanceof ItemArmor || itemStack.getItem() instanceof ItemPickaxe || itemStack.getItem() instanceof ItemSword || itemStack.getItem() instanceof ItemTool) {
            int n3 = EnchantmentHelper.getEnchantmentLevel((Enchantment) enchantment, (ItemStack) itemStack);
            if (enchantment.getTranslatedName(n3).contains("Vanish")) {
                stringBuilder.append((Object) TextFormatting.DARK_RED);
                stringBuilder.append("Van");
            } else if (enchantment.getTranslatedName(n3).contains("Bind")) {
                stringBuilder.append((Object) TextFormatting.DARK_RED);
                stringBuilder.append("Bind");
            } else if (enchantment.getTranslatedName(n3).contains("Sharp") && n3 > 100) {
                stringBuilder.append((Object) TextFormatting.DARK_PURPLE);
                stringBuilder.append("32k");
            } else {
                int n4;
                String string = enchantment.getTranslatedName(n3);
                int n5 = n4 = n3 > 1 ? 2 : 3;
                if (string.length() > n4) {
                    string = string.substring(0, n4);
                }
                stringBuilder.append(string);
                if (n3 > 1) {
                    if (n3 >= 100) {
                        stringBuilder.append("+");
                    } else {
                        stringBuilder.append(n3);
                    }
                }
            }
        }
        float f = (this.Field1015 + 3.0f) * 2.0f;
        float f2 = (this.Field1017 * -7 - 5 - (this.Field987.getValue() != false ? 2 : 0)) * 2;
        AliceMain.Field766.Method2150317(stringBuilder.toString(), f, f2 + this.Field1016, -1);
        this.Field1016 += (float) (AliceMain.Field766.Method2150321() + 1);
        GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
        GlStateManager.popMatrix();
    }

    private void Method2161513(ItemStack itemStack, Enchantment enchantment, Integer n2) {
        int n3 = EnchantmentHelper.getEnchantmentLevel((Enchantment) enchantment, (ItemStack) itemStack);
        if (n3 > this.Field1018) {
            this.Field1018 = n3;
        }
    }

    private void Method2161514(ItemStack itemStack) {
        if (EnchantmentHelper.getEnchantments((ItemStack) itemStack).size() > this.Field1017) {
            this.Field1017 = EnchantmentHelper.getEnchantments((ItemStack) itemStack).size();
        }
    }

    private boolean Method2161516(Object object) {
        return this.Field1010.getValue();
    }

    private boolean Method2161517(Object object) {
        return this.Field1010.getValue();
    }

    private boolean Method2161518(Object object) {
        return this.Field1003.getValue();
    }

    private boolean Method2161519(Object object) {
        return this.Field1003.getValue();
    }

    private boolean Method2161510(Object object) {
        return this.Field1003.getValue();
    }

    private boolean Method2161521(Object object) {
        return this.Field1003.getValue();
    }

    private boolean Method2161522(Object object) {
        return this.Field1003.getValue();
    }

    private boolean Method2161523(Object object) {
        return this.Field1003.getValue();
    }

    private boolean Method2161524(Boolean bl) {
        return this.Field992.getValue();
    }

    private boolean Method2161525(Boolean bl) {
        return this.Field986.getValue();
    }
}

