

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.GuiScreenEvent$KeyboardInputEvent$Post
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.ArrayList;
import java.util.Random;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Snake
        extends Module {
    public static Snake Field2151;
    public static ArrayList<Integer> Field2152;
    public static ArrayList<Integer> Field2153;
    public static int Field2154;
    public static int Field2155;
    public static int Field2156;
    public static int Field2157;
    public static int Field2158;
    public static int Field2159;
    public static int Field2160;
    public static boolean Field2161;
    public static int Field2162;
    public static int Field2163;
    public static int Field2164;
    public static int Field2165;
    public static long Field2166;
    public static String Field2167;
    public static int Field2168;
    public static int Field2169;

    static {
        Field2152 = new ArrayList();
        Field2153 = new ArrayList();
        Field2154 = 0;
        Field2161 = true;
        Field2162 = 0;
        Field2165 = 0;
        Field2166 = 0L;
        Field2168 = Snake.Field2811.displayWidth / 4;
        Field2169 = Snake.Field2811.displayHeight / 5;
    }

    public Snake() {
        super("Snake", "Snake game", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, false, false, false);
        Field2151 = this;
    }

    public static BlockPos Method2161505() {
        return new BlockPos(Snake.Field2811.player.posX, Snake.Field2811.player.posY, Snake.Field2811.player.posZ);
    }

    public static void Method2161506() {
        if (!Field2161) {
            Field2161 = true;
            Field2152.clear();
            Field2153.clear();
            Field2157 = 0;
            Field2158 = 0;
            Field2163 = 0;
            Field2164 = 0;
        }
    }

    public static void Method2161507() {
        Field2161 = false;
        Field2155 = Field2168 + 100;
        Field2156 = Field2169 + 180;
        Field2167 = "Up";
        Field2154 = 1;
    }

    public static void Method2161508() {
        for (int j = 0; j < 100; ++j) {
            Random random = new Random();
            int n2 = random.nextInt(10);
            int n3 = random.nextInt(10);
            Field2163 = Field2168 + n2 * 20;
            Field2164 = Field2169 + n3 * 20;
            for (int i2 = 0; i2 < Field2152.size(); ++i2) {
                if (Field2152.isEmpty() || Field2152.get(i2) != Field2163 || Field2153.get(i2) != Field2164) continue;
                Field2163 = 0;
                Field2164 = 0;
                break;
            }
            if (Field2155 == Field2163 && Field2156 == Field2164) {
                Field2163 = 0;
                Field2164 = 0;
                continue;
            }
            if (Field2163 < 140 || Field2163 > 340 || Field2164 < 140 || Field2164 > 340) {
                Field2163 = 0;
                Field2164 = 0;
                continue;
            }
            if (Field2163 != 0 && Field2164 != 0) break;
        }
    }

    @Override
    @SubscribeEvent
    public void Method2150370(Render2DEvent render2DEvent) {
        GlStateManager.pushMatrix();
        GlStateManager.scale((float) 1.5f, (float) 1.5f, (float) 1.5f);
        GuiScreen.drawRect((int) (Field2168 - 1), (int) (Field2169 - 1), (int) (Field2168 + 201), (int) (Field2169 + 201), (int) -12388932);
        GuiScreen.drawRect((int) Field2168, (int) Field2169, (int) (Field2168 + 200), (int) (Field2169 + 200), (int) -16777216);
        if (Field2155 < Field2168 || Field2155 >= Field2168 + 200 || Field2156 < Field2169 || Field2156 >= Field2169 + 200) {
            Snake.Method2161506();
        }
        if (!Field2161) {
            for (int j = 0; j < Field2152.size(); ++j) {
                if (Field2152.get(j) != Field2155 || Field2153.get(j) != Field2156) continue;
                Snake.Method2161506();
                return;
            }
            Snake.Field2811.fontRenderer.drawStringWithShadow((Object) ChatFormatting.RED + "Score = " + (Object) ChatFormatting.GREEN + Field2154, (float) (Field2168 + 3), (float) (Field2169 + 2), 65535);
            if (Field2163 == 0 || Field2164 == 0) {
                Snake.Method2161508();
            }
            GuiScreen.drawRect((int) Field2163, (int) Field2164, (int) (Field2163 + 20), (int) (Field2164 + 20), (int) -65536);
            long l2 = System.currentTimeMillis() / 150L;
            if (l2 != Field2166) {
                Field2165 = 0;
                if (Field2167.equals("Up")) {
                    Field2156 -= 20;
                } else if (Field2167.equals("Down")) {
                    Field2156 += 20;
                } else if (Field2167.equals("Right")) {
                    Field2155 += 20;
                } else if (Field2167.equals("Left")) {
                    Field2155 -= 20;
                }
                if (!Field2152.isEmpty()) {
                    Field2152.remove(Field2152.get(0));
                    Field2153.remove(Field2153.get(0));
                    Field2152.add(Field2157);
                    Field2153.add(Field2158);
                }
                Field2166 = l2;
            }
            if (Field2155 == Field2163 && Field2156 == Field2164) {
                ++Field2154;
                Field2163 = 0;
                Field2164 = 0;
                if (Field2152.isEmpty()) {
                    Field2152.add(Field2157);
                    Field2153.add(Field2158);
                } else {
                    Field2152.add(Field2159);
                    Field2153.add(Field2160);
                }
                Snake.Field2811.world.playSound(Snake.Method2161505(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.AMBIENT, 100.0f, 2.0f, true);
            }
            Field2157 = Field2155;
            Field2158 = Field2156;
            if (!Field2152.isEmpty()) {
                Field2159 = Field2152.get(Field2152.size() - 1);
                Field2160 = Field2153.get(Field2153.size() - 1);
            }
            GuiScreen.drawRect((int) Field2155, (int) Field2156, (int) (Field2155 + 20), (int) (Field2156 + 20), (int) -11141376);
            GuiScreen.drawRect((int) (Field2155 + 3), (int) (Field2156 + 3), (int) (Field2155 + 8), (int) (Field2156 + 8), (int) -16777216);
            for (int j = 0; j < Field2152.size(); ++j) {
                if (Field2152.isEmpty()) continue;
                GuiScreen.drawRect((int) Field2152.get(j), (int) Field2153.get(j), (int) (Field2152.get(j) + 20), (int) (Field2153.get(j) + 20), (int) -11141376);
            }
        }
        if (Field2161) {
            GlStateManager.pushMatrix();
            GlStateManager.scale((float) 3.0f, (float) 3.0f, (float) 3.0f);
            Snake.Field2811.fontRenderer.drawStringWithShadow((Object) ChatFormatting.RED + "Game Over!", (float) (Field2168 / 3 + 6), (float) (Field2169 / 3 + 2), 65535);
            Snake.Field2811.fontRenderer.drawStringWithShadow((Object) ChatFormatting.LIGHT_PURPLE + "Score = " + (Object) ChatFormatting.GREEN + Field2154, (float) (Field2168 / 3 + 9), (float) (Field2169 / 3 + 12), 65535);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale((float) 2.0f, (float) 2.0f, (float) 2.0f);
            Snake.Field2811.fontRenderer.drawStringWithShadow((Object) ChatFormatting.GREEN + "Click to Play!", (float) (Field2168 / 2 + 18), (float) (Field2169 / 2 + 85), 65535);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale((float) 1.5f, (float) 1.5f, (float) 1.5f);
            Snake.Field2811.fontRenderer.drawStringWithShadow((Object) ChatFormatting.AQUA + "Use " + (Object) ChatFormatting.GREEN + "ARROW KEYS " + (Object) ChatFormatting.AQUA + "To play!", (float) ((int) ((double) Field2168 / 1.5) + 5), (float) ((int) ((double) Field2169 / 1.5) + 75), 65535);
            GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
    }

    @Override
    public boolean Method2150384(int n2, int n3, int n4) {
        n2 = (int) ((double) n2 / 1.5);
        n3 = (int) ((double) n3 / 1.5);
        if (Field2168 < n2 && Field2168 + 200 > n2 && Field2169 < n3 && Field2169 + 200 > n3) {
            if (Field2161) {
                Snake.Method2161507();
            }
            return true;
        }
        return false;
    }

    @SubscribeEvent
    public void Method2161504(GuiScreenEvent.KeyboardInputEvent.Post post) {
        if (Keyboard.isKeyDown((int) 208)) {
            Field2167 = "Down";
        } else if (Keyboard.isKeyDown((int) 200)) {
            Field2167 = "Up";
        } else if (Keyboard.isKeyDown((int) 205)) {
            Field2167 = "Right";
        } else if (Keyboard.isKeyDown((int) 203)) {
            Field2167 = "Left";
        }
    }
}

