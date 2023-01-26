

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Crosshair
        extends Module {
    private final Setting<Boolean> Field1383 = this.Method2150366(new Setting<Boolean>("Dot", false));
    private final Setting<Float> Field1384 = this.Method2150366(new Setting<Float>("Gap", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    private final Setting<Float> Field1385 = this.Method2150366(new Setting<Float>("MotionGap", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f)));
    private final Setting<Float> Field1386 = this.Method2150366(new Setting<Float>("Width", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    private final Setting<Float> Field1387 = this.Method2150366(new Setting<Float>("MotionWidth", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(2.5f)));
    private final Setting<Float> Field1388 = this.Method2150366(new Setting<Float>("Size", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(40.0f)));
    private final Setting<Float> Field1389 = this.Method2150366(new Setting<Float>("MotionSize", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    private final Setting<Boolean> Field1390 = this.Method2150366(new Setting<Boolean>("Sync", false));
    private final Setting<Integer> Field1391 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    private final Setting<Integer> Field1392 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private final Setting<Integer> Field1393 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    private final Setting<Integer> Field1394 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));
    float Field1395 = 0.0f;
    long Field1396 = -1L;
    float Field1397 = 0.0f;

    public Crosshair() {
        super("Crosshair", "Draws a custom crosshair", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }

    public static void Method2162359(float f, float f2, float f3, float f4, int n2) {
        float f5;
        if (f < f3) {
            f5 = f;
            f = f3;
            f3 = f5;
        }
        if (f2 < f4) {
            f5 = f2;
            f2 = f4;
            f4 = f5;
        }
        f5 = (float) (n2 >> 24 & 0xFF) / 255.0f;
        float f6 = (float) (n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float) (n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float) (n2 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float) f6, (float) f7, (float) f8, (float) f5);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double) f, (double) f4, 0.0).endVertex();
        bufferBuilder.pos((double) f3, (double) f4, 0.0).endVertex();
        bufferBuilder.pos((double) f3, (double) f2, 0.0).endVertex();
        bufferBuilder.pos((double) f, (double) f2, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static float Method2162350(float f, float f2, float f3) {
        return f * (1.0f - f3) + f2 * f3;
    }

    @SubscribeEvent
    public void Method2162357(RenderGameOverlayEvent renderGameOverlayEvent) {
        if (this.Method2150350()) {
            return;
        }
        if (renderGameOverlayEvent.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            renderGameOverlayEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void Method2162358(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        this.Field1397 = this.Field1395;
        double d = Crosshair.Field2811.player.posX - Crosshair.Field2811.player.prevPosX;
        double d2 = Crosshair.Field2811.player.posZ - Crosshair.Field2811.player.prevPosZ;
        this.Field1395 = (float) Math.sqrt(d * d + d2 * d2);
        this.Field1396 = System.currentTimeMillis();
    }

    @Override
    public void Method2150370(Render2DEvent render2DEvent) {
        ScaledResolution scaledResolution = new ScaledResolution(Field2811);
        float f = (float) (scaledResolution.getScaledWidth_double() / 2.0 + 0.5);
        float f2 = (float) (scaledResolution.getScaledHeight_double() / 2.0 + 0.5);
        float f3 = this.Field1384.getValue().floatValue();
        float f4 = Math.max(this.Field1386.getValue().floatValue(), 0.5f);
        float f5 = this.Field1388.getValue().floatValue();
        float f6 = Crosshair.Field2811.timer.tickLength;
        Crosshair.Method2162359(f - (f3 += Crosshair.Method2162350(this.Field1397, this.Field1395, Math.min((float) (System.currentTimeMillis() - this.Field1396) / f6, 1.0f)) * this.Field1385.getValue().floatValue()) - (f5 += Crosshair.Method2162350(this.Field1397, this.Field1395, Math.min((float) (System.currentTimeMillis() - this.Field1396) / f6, 1.0f)) * this.Field1389.getValue().floatValue()), f2 - (f4 += Crosshair.Method2162350(this.Field1397, this.Field1395, Math.min((float) (System.currentTimeMillis() - this.Field1396) / f6, 1.0f)) * this.Field1387.getValue().floatValue()) / 2.0f, f - f3, f2 + f4 / 2.0f, this.Field1390.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(this.Field1391.getValue(), this.Field1392.getValue(), this.Field1393.getValue(), this.Field1394.getValue()));
        Crosshair.Method2162359(f + f3 + f5, f2 - f4 / 2.0f, f + f3, f2 + f4 / 2.0f, this.Field1390.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(this.Field1391.getValue(), this.Field1392.getValue(), this.Field1393.getValue(), this.Field1394.getValue()));
        Crosshair.Method2162359(f - f4 / 2.0f, f2 + f3 + f5, f + f4 / 2.0f, f2 + f3, this.Field1390.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(this.Field1391.getValue(), this.Field1392.getValue(), this.Field1393.getValue(), this.Field1394.getValue()));
        Crosshair.Method2162359(f - f4 / 2.0f, f2 - f3 - f5, f + f4 / 2.0f, f2 - f3, this.Field1390.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(this.Field1391.getValue(), this.Field1392.getValue(), this.Field1393.getValue(), this.Field1394.getValue()));
        if (this.Field1383.getValue().booleanValue()) {
            Crosshair.Method2162359(f - f4 / 2.0f, f2 - f4 / 2.0f, f + f4 / 2.0f, f2 + f4 / 2.0f, this.Field1390.getValue() != false ? Colors.Field1782.Method2150585() : ColorUtil.Method2163379(this.Field1391.getValue(), this.Field1392.getValue(), this.Field1393.getValue(), this.Field1394.getValue()));
        }
    }
}

