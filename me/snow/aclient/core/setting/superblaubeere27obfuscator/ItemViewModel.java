

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class ItemViewModel
        extends Module {
    public static ItemViewModel Field2347 = new ItemViewModel();
    public Setting<Integer> Field2348 = this.Method2150366(new Setting<Integer>("Fov", 130, 90, 180));
    public Setting<Boolean> Field2349 = this.Method2150366(new Setting<Boolean>("OffNormal", false));
    public Setting<Integer> Field2350 = this.Method2150366(new Setting<Integer>("Item Alpha", 255, 0, 255));
    public Setting<Float> Field2351 = this.Method2150366(new Setting<Object>("Offset", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162551));
    public Setting<Float> Field2352 = this.Method2150366(new Setting<Object>("OffX", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f), this::Method2162540));
    public Setting<Float> Field2353 = this.Method2150366(new Setting<Object>("OffY", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f), this::Method2162549));
    public Setting<Float> Field2354 = this.Method2150366(new Setting<Float>("MainX", Float.valueOf(0.3f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    public Setting<Float> Field2355 = this.Method2150366(new Setting<Float>("MainY", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    public Setting<Float> Field2356 = this.Method2150366(new Setting<Float>("SizeX", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(2.0f)));
    public Setting<Float> Field2357 = this.Method2150366(new Setting<Float>("SizeY", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(2.0f)));
    public Setting<Float> Field2358 = this.Method2150366(new Setting<Float>("SizeZ", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(2.0f)));
    public Setting<Float> Field2359 = this.Method2150366(new Setting<Float>("RotationX", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)));
    public Setting<Float> Field2360 = this.Method2150366(new Setting<Float>("RotationY", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)));
    public Setting<Float> Field2361 = this.Method2150366(new Setting<Float>("RotationZ", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)));
    public Setting<Float> Field2362 = this.Method2150366(new Setting<Float>("PositionX", Float.valueOf(0.0f), Float.valueOf(-2.0f), Float.valueOf(2.0f)));
    public Setting<Float> Field2363 = this.Method2150366(new Setting<Float>("PositionY", Float.valueOf(0.0f), Float.valueOf(-2.0f), Float.valueOf(2.0f)));
    public Setting<Float> Field2364 = this.Method2150366(new Setting<Float>("PositionZ", Float.valueOf(0.0f), Float.valueOf(-2.0f), Float.valueOf(2.0f)));
    public Setting<Boolean> Field2365 = this.Method2150366(new Setting<Boolean>("OldAnimation", false));
    public Setting<Boolean> Field2366 = this.Method2150366(new Setting<Boolean>("SlowSwing", false));
    public Setting<Integer> Field2367 = this.Method2150366(new Setting<Integer>("SwingDelay", Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), this::Method2162548));
    float Field2368;

    public ItemViewModel() {
        super("ItemViewModel", "Allows you to customize how items look in your hand", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162547();
    }

    public static ItemViewModel Method2162546() {
        if (Field2347 == null) {
            Field2347 = new ItemViewModel();
        }
        return Field2347;
    }

    private void Method2162547() {
        Field2347 = this;
    }

    @Override
    public void Method2150372() {
        this.Field2368 = ItemViewModel.Field2811.gameSettings.fovSetting;
    }

    @Override
    public void Method2150373() {
        ItemViewModel.Field2811.gameSettings.fovSetting = this.Field2368;
    }

    @Override
    public void Method2150379() {
        if (this.Field2349.getValue().booleanValue()) {
            ItemViewModel.Field2811.entityRenderer.itemRenderer.equippedProgressOffHand = this.Field2351.getValue().floatValue();
        }
        ItemViewModel.Field2811.gameSettings.fovSetting = this.Field2348.getValue().intValue();
        if (this.Field2365.getValue().booleanValue() && (double) ItemViewModel.Field2811.entityRenderer.itemRenderer.prevEquippedProgressMainHand >= 0.9) {
            ItemViewModel.Field2811.entityRenderer.itemRenderer.equippedProgressMainHand = 1.0f;
            ItemViewModel.Field2811.entityRenderer.itemRenderer.itemStackMainHand = ItemViewModel.Field2811.player.getHeldItemMainhand();
        }
    }

    private boolean Method2162548(Integer n2) {
        return this.Field2366.getValue();
    }

    private boolean Method2162549(Object object) {
        return this.Field2349.getValue() == false;
    }

    private boolean Method2162540(Object object) {
        return this.Field2349.getValue() == false;
    }

    private boolean Method2162551(Object object) {
        return this.Field2349.getValue();
    }
}

