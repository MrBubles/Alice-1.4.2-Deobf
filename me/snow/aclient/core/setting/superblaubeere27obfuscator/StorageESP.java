

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.item.EntityMinecartChest
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.tileentity.TileEntityDispenser
 *  net.minecraft.tileentity.TileEntityEnderChest
 *  net.minecraft.tileentity.TileEntityFurnace
 *  net.minecraft.tileentity.TileEntityHopper
 *  net.minecraft.tileentity.TileEntityShulkerBox
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.BlockPos;

public class StorageESP
        extends Module {
    private final Setting<Float> Field2607 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(50.0f), Float.valueOf(1.0f), Float.valueOf(300.0f)));
    private final Setting<Boolean> Field2608 = this.Method2150366(new Setting<Boolean>("Sync", false));
    private final Setting<Boolean> Field2609 = this.Method2150366(new Setting<Boolean>("Chest", true));
    private final Setting<Boolean> Field2610 = this.Method2150366(new Setting<Boolean>("Dispenser", false));
    private final Setting<Boolean> Field2611 = this.Method2150366(new Setting<Boolean>("Shulker", true));
    private final Setting<Boolean> Field2612 = this.Method2150366(new Setting<Boolean>("Ender Chest", true));
    private final Setting<Boolean> Field2613 = this.Method2150366(new Setting<Boolean>("Furnace", false));
    private final Setting<Boolean> Field2614 = this.Method2150366(new Setting<Boolean>("Hopper", false));
    private final Setting<Boolean> Field2615 = this.Method2150366(new Setting<Boolean>("Minecart", false));
    private final Setting<Boolean> Field2616 = this.Method2150366(new Setting<Boolean>("Item Frame", false));
    private final Setting<Boolean> Field2617 = this.Method2150366(new Setting<Boolean>("Box", true));
    private final Setting<Integer> Field2618 = this.Method2150366(new Setting<Object>("BoxAlpha", Integer.valueOf(70), Integer.valueOf(0), Integer.valueOf(255), this::Method2162734));
    private final Setting<Boolean> Field2619 = this.Method2150366(new Setting<Boolean>("Outline", true));
    private final Setting<Float> Field2620 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2162733));

    public StorageESP() {
        super("StorageESP", "Highlights Containers.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        int n2;
        BlockPos blockPos;
        HashMap<BlockPos, Integer> hashMap = new HashMap<BlockPos, Integer>();
        for (TileEntity object : StorageESP.Field2811.world.loadedTileEntityList) {
            BlockPos blockPos2;
            if (!(object instanceof TileEntityChest && this.Field2609.getValue() != false || object instanceof TileEntityDispenser && this.Field2610.getValue() != false || object instanceof TileEntityShulkerBox && this.Field2611.getValue() != false || object instanceof TileEntityEnderChest && this.Field2612.getValue() != false || object instanceof TileEntityFurnace && this.Field2613.getValue() != false) && (!(object instanceof TileEntityHopper) || !this.Field2614.getValue().booleanValue()))
                continue;
            blockPos = object.getPos();
            if (!(StorageESP.Field2811.player.getDistanceSq(blockPos2) <= MathUtil.Method2163857(this.Field2607.getValue().floatValue())) || (n2 = this.Method2162731(object)) == -1)
                continue;
            hashMap.put(blockPos, n2);
        }
        for (Entity entity : StorageESP.Field2811.world.loadedEntityList) {
            BlockPos blockPos3;
            if ((!(entity instanceof EntityItemFrame) || !this.Field2616.getValue().booleanValue()) && (!(entity instanceof EntityMinecartChest) || !this.Field2615.getValue().booleanValue()))
                continue;
            blockPos = entity.getPosition();
            if (!(StorageESP.Field2811.player.getDistanceSq(blockPos3) <= MathUtil.Method2163857(this.Field2607.getValue().floatValue())) || (n2 = this.Method2162732(entity)) == -1)
                continue;
            hashMap.put(blockPos, n2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            BlockPos blockPos4 = (BlockPos) entry.getKey();
            n2 = (Integer) entry.getValue();
            RenderUtil.Method2163908(blockPos4, this.Field2608.getValue() != false ? Colors.Field1782.Method2150586() : new Color(n2), false, new Color(n2), this.Field2620.getValue().floatValue(), this.Field2619.getValue(), this.Field2617.getValue(), this.Field2618.getValue(), false);
        }
    }

    private int Method2162731(TileEntity tileEntity) {
        if (tileEntity instanceof TileEntityChest) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field312;
        }
        if (tileEntity instanceof TileEntityShulkerBox) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field319;
        }
        if (tileEntity instanceof TileEntityEnderChest) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field313;
        }
        if (tileEntity instanceof TileEntityFurnace) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field318;
        }
        if (tileEntity instanceof TileEntityHopper) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field314;
        }
        if (tileEntity instanceof TileEntityDispenser) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field318;
        }
        return -1;
    }

    private int Method2162732(Entity entity) {
        if (entity instanceof EntityMinecartChest) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field312;
        }
        if (entity instanceof EntityItemFrame && ((EntityItemFrame) entity).getDisplayedItem().getItem() instanceof ItemShulkerBox) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field316;
        }
        if (entity instanceof EntityItemFrame && !(((EntityItemFrame) entity).getDisplayedItem().getItem() instanceof ItemShulkerBox)) {
            return ColorUtil.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field312;
        }
        return -1;
    }

    private boolean Method2162733(Object object) {
        return this.Field2619.getValue();
    }

    private boolean Method2162734(Object object) {
        return this.Field2617.getValue();
    }
}

