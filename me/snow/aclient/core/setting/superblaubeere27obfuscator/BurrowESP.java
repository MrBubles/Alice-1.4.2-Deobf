

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class BurrowESP
        extends Module {
    private final Setting<Integer> Field1600;
    private final Setting<Integer> Field1601;
    private final Setting<Integer> Field1602;
    private final Setting<Boolean> Field1603;
    private final Setting<Boolean> Field1604;
    private final Setting<Integer> Field1605;
    private final Setting<Boolean> Field1606 = this.Method2150366(new Setting<Boolean>("Name", false));
    private final Setting<Integer> Field1607;
    private final Setting<Float> Field1608;
    private final Setting<Integer> Field1609;
    private final Setting<Boolean> Field1610;
    private final Setting<Integer> Field1611;
    private final Map<EntityPlayer, BlockPos> Field1612;
    private final Setting<Integer> Field1613;

    public BurrowESP() {
        super("BurrowESP", "Shows gay people.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
        this.Field1603 = new Setting<Boolean>("Box", true);
        this.Field1600 = this.Method2150366(new Setting<Integer>("BoxRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162351));
        this.Field1602 = this.Method2150366(new Setting<Integer>("BoxGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162340));
        this.Field1611 = this.Method2150366(new Setting<Integer>("BoxBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162349));
        this.Field1607 = this.Method2150366(new Setting<Integer>("BoxAlpha", Integer.valueOf(125), Integer.valueOf(0), Integer.valueOf(255), this::Method2162348));
        this.Field1610 = this.Method2150366(new Setting<Boolean>("Outline", true));
        this.Field1608 = this.Method2150366(new Setting<Float>("OutlineWidth", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162347));
        this.Field1604 = this.Method2150366(new Setting<Boolean>("CustomOutline", Boolean.valueOf(false), this::Method2162346));
        this.Field1609 = this.Method2150366(new Setting<Integer>("OutlineRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162345));
        this.Field1601 = this.Method2150366(new Setting<Integer>("OutlineGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162344));
        this.Field1605 = this.Method2150366(new Setting<Integer>("OutlineBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162343));
        this.Field1613 = this.Method2150366(new Setting<Integer>("OutlineAlpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162342));
        this.Field1612 = new HashMap<EntityPlayer, BlockPos>();
    }

    private void Method2162338() {
        for (EntityPlayer entityPlayer : BurrowESP.Field2811.world.playerEntities) {
            if (entityPlayer == BurrowESP.Field2811.player || AliceMain.Field765.Method2150168(entityPlayer.getName()) || !EntityUtil.Method2163537((Entity) entityPlayer) || !this.Method2162330(entityPlayer))
                continue;
            this.Field1612.put(entityPlayer, new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ));
        }
    }

    @Override
    public void Method2150372() {
        this.Field1612.clear();
    }

    private void Method2162339(Map.Entry entry) {
        this.Method2162341((BlockPos) entry.getValue());
        if (this.Field1606.getValue().booleanValue()) {
            RenderUtil.Method2163022(new AxisAlignedBB((BlockPos) entry.getValue()), ((EntityPlayer) entry.getKey()).getGameProfile().getName());
        }
    }

    private boolean Method2162330(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(Math.floor(entityPlayer.posX), Math.floor(entityPlayer.posY + 0.2), Math.floor(entityPlayer.posZ));
        return BurrowESP.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.ENDER_CHEST || BurrowESP.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || BurrowESP.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.CHEST || BurrowESP.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.ANVIL;
    }

    @Override
    public void Method2150379() {
        if (BurrowESP.Method2150359()) {
            return;
        }
        this.Field1612.clear();
        this.Method2162338();
    }

    private void Method2162341(BlockPos blockPos) {
        RenderUtil.Method2163908(blockPos, new Color(this.Field1600.getValue(), this.Field1602.getValue(), this.Field1611.getValue(), this.Field1607.getValue()), true, new Color(this.Field1609.getValue(), this.Field1601.getValue(), this.Field1605.getValue(), this.Field1613.getValue()), this.Field1608.getValue().floatValue(), this.Field1610.getValue(), this.Field1603.getValue(), this.Field1607.getValue(), true);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (!this.Field1612.isEmpty()) {
            this.Field1612.entrySet().forEach(this::Method2162339);
        }
    }

    private boolean Method2162342(Integer n2) {
        return this.Field1604.getValue();
    }

    private boolean Method2162343(Integer n2) {
        return this.Field1604.getValue();
    }

    private boolean Method2162344(Integer n2) {
        return this.Field1604.getValue();
    }

    private boolean Method2162345(Integer n2) {
        return this.Field1604.getValue();
    }

    private boolean Method2162346(Boolean bl) {
        return this.Field1610.getValue();
    }

    private boolean Method2162347(Float f) {
        return this.Field1610.getValue();
    }

    private boolean Method2162348(Integer n2) {
        return this.Field1603.getValue();
    }

    private boolean Method2162349(Integer n2) {
        return this.Field1603.getValue();
    }

    private boolean Method2162340(Integer n2) {
        return this.Field1603.getValue();
    }

    private boolean Method2162351(Integer n2) {
        return this.Field1603.getValue();
    }
}

