/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogColors
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogDensity
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SkyColor
        extends Module {
    private static SkyColor Field2431 = new SkyColor();
    private Setting<Integer> Field2432 = this.Method2150366(new Setting<Integer>("Red", 135, 0, 255));
    private Setting<Integer> Field2433 = this.Method2150366(new Setting<Integer>("Green", 0, 0, 255));
    private Setting<Integer> Field2434 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    private Setting<Boolean> Field2435 = this.Method2150366(new Setting<Boolean>("Rainbow", false));
    private Setting<Boolean> Field2436 = this.Method2150366(new Setting<Boolean>("Fog", true));

    public SkyColor() {
        super("SkyColor", "Changes the color of the sky", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
    }

    public static SkyColor Method2162719() {
        if (Field2431 == null) {
            Field2431 = new SkyColor();
        }
        return Field2431;
    }

    private void Method2162710() {
        Field2431 = this;
    }

    @SubscribeEvent
    public void Method2162721(EntityViewRenderEvent.FogColors fogColors) {
        fogColors.setRed((float) this.Field2432.getValue().intValue() / 255.0f);
        fogColors.setGreen((float) this.Field2433.getValue().intValue() / 255.0f);
        fogColors.setBlue((float) this.Field2434.getValue().intValue() / 255.0f);
    }

    @SubscribeEvent
    public void Method2162722(EntityViewRenderEvent.FogDensity fogDensity) {
        if (this.Field2436.getValue().booleanValue()) {
            fogDensity.setDensity(0.0f);
            fogDensity.setCanceled(true);
        }
    }

    @Override
    public void Method2150372() {
        MinecraftForge.EVENT_BUS.register((Object) this);
    }

    @Override
    public void Method2150373() {
        MinecraftForge.EVENT_BUS.unregister((Object) this);
    }

    @Override
    public void Method2150379() {
        if (this.Field2435.getValue().booleanValue()) {
            this.Method2162723();
        }
    }

    public void Method2162723() {
        float[] arrf = new float[]{(float) (System.currentTimeMillis() % 11520L) / 11520.0f};
        int n2 = Color.HSBtoRGB(arrf[0], 0.8f, 0.8f);
        this.Field2432.setValue(n2 >> 16 & 0xFF);
        this.Field2433.setValue(n2 >> 8 & 0xFF);
        this.Field2434.setValue(n2 & 0xFF);
    }
}

