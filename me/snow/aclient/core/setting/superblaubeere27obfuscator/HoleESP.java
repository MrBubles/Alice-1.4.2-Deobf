

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockAir
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import net.minecraft.block.BlockAir;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class HoleESP
        extends Module {
    private static HoleESP Field1186;
    public final Setting<Integer> Field1192 = this.Method2150366(new Setting<Integer>("Alpha", 50, 0, 255));
    public final Setting<Integer> Field1193 = this.Method2150366(new Setting<Integer>("OutLineAlpha", 255, 0, 255));
    public final Setting<Integer> Field1194 = this.Method2150366(new Setting<Integer>("ObsidianRed", 255, 0, 255));
    public final Setting<Integer> Field1195 = this.Method2150366(new Setting<Integer>("ObsidianGreen", 255, 0, 255));
    public final Setting<Integer> Field1196 = this.Method2150366(new Setting<Integer>("ObsidianBlue", 31, 0, 255));
    public final Setting<Boolean> Field1197 = this.Method2150366(new Setting<Boolean>("ObsidianCustomOutLine", false));
    public final Setting<Integer> Field1198 = this.Method2150366(new Setting<Integer>("OL-ObsidianRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162461));
    public final Setting<Integer> Field1199 = this.Method2150366(new Setting<Integer>("OL-ObsidianGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162450));
    public final Setting<Integer> Field1200 = this.Method2150366(new Setting<Integer>("OL-ObsidianBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162459));
    public final Setting<Integer> Field1201 = this.Method2150366(new Setting<Integer>("BedrockRed", 31, 0, 255));
    public final Setting<Integer> Field1202 = this.Method2150366(new Setting<Integer>("BedrockGreen", 255, 0, 255));
    public final Setting<Integer> Field1203 = this.Method2150366(new Setting<Integer>("BedrockBlue", 31, 0, 255));
    public final Setting<Boolean> Field1204 = this.Method2150366(new Setting<Boolean>("BedrockCustomOutLine", false));
    public final Setting<Integer> Field1205 = this.Method2150366(new Setting<Integer>("OL-BedrockRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162458));
    public final Setting<Integer> Field1206 = this.Method2150366(new Setting<Integer>("OL-BedrockGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162457));
    public final Setting<Integer> Field1207 = this.Method2150366(new Setting<Integer>("OL-BedrockBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162456));
    public final Setting<Integer> Field1208 = this.Method2150366(new Setting<Integer>("DoublesRed", 255, 0, 255));
    public final Setting<Integer> Field1209 = this.Method2150366(new Setting<Integer>("DoublesGreen", 127, 0, 255));
    public final Setting<Integer> Field1210 = this.Method2150366(new Setting<Integer>("DoublesBlue", 31, 0, 255));
    public final Setting<Boolean> Field1211 = this.Method2150366(new Setting<Boolean>("DoubleCustomOutLine", false));
    public final Setting<Integer> Field1212 = this.Method2150366(new Setting<Integer>("OL-DoublesRed", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162455));
    public final Setting<Integer> Field1213 = this.Method2150366(new Setting<Integer>("OL-DoublesGreen", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162454));
    public final Setting<Integer> Field1214 = this.Method2150366(new Setting<Integer>("OL-DoublesBlue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162453));
    public Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field1187 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("Mode", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Glow));
    public Setting<Float> Field1188 = this.Method2150366(new Setting<Float>("Height", Float.valueOf(0.3f), Float.valueOf(-2.0f), Float.valueOf(2.0f)));
    public Setting<Float> Field1189 = this.Method2150366(new Setting<Float>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    public Setting<Boolean> Field1190 = this.Method2150366(new Setting<Boolean>("Doubles", true));
    public Setting<Integer> Field1191 = this.Method2150366(new Setting<Integer>("Range", 8, 1, 10));
    public List<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1215 = new ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>();

    public HoleESP() {
        super("HoleESP", "Shows safe spots.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162440();
    }

    public static HoleESP Method2162449() {
        if (Field1186 == null) {
            Field1186 = new HoleESP();
        }
        return Field1186;
    }

    private void Method2162440() {
        Field1186 = this;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (HoleESP.Field2811.player == null || HoleESP.Field2811.world == null) {
            return;
        }
        RenderUtil.Field3116.setPosition(Objects.requireNonNull(HoleESP.Field2811.getRenderViewEntity()).posX, HoleESP.Field2811.getRenderViewEntity().posY, HoleESP.Field2811.getRenderViewEntity().posZ);
        ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> arrayList = new ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>();
        arrayList.addAll(this.Field1215);
        arrayList.forEach(this::Method2162452);
    }

    @Override
    public String Method2150385() {
        return this.Field1215.size() + "";
    }

    @Override
    public void Method2150379() {
        if (HoleESP.Field2811.player == null || HoleESP.Field2811.world == null) {
            return;
        }
        ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> arrayList = new ArrayList<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>();
        for (BlockPos blockPos : BlockUtil.Method2162871((EntityPlayer) HoleESP.Field2811.player, this.Field1191.getValue().intValue(), false)) {
            if (!(HoleESP.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockAir)) continue;
            if (HoleUtil2.Method2162462(blockPos)) {
                arrayList.add(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, this, blockPos, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Bedrock, 0, 0));
            } else if (HoleUtil2.Method2162463(blockPos)) {
                arrayList.add(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, this, blockPos, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Obsidian, 0, 0));
            }
            if (!this.Field1190.getValue().booleanValue()) continue;
            if (HoleUtil2.Method2162469(blockPos.west()) || HoleUtil2.Method2162471(blockPos.west())) {
                arrayList.add(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, this, blockPos.west(), IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Double, 1, 0));
                continue;
            }
            if (!HoleUtil2.Method2162460(blockPos.north()) && !HoleUtil2.Method2162472(blockPos.north())) continue;
            arrayList.add(new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, this, blockPos.north(), IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Double, 0, 1));
        }
        this.Field1215.clear();
        this.Field1215.addAll(arrayList);
    }

    public void Method2162451(BlockPos blockPos, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, double d, double d2) {
        Color color;
        Color color2 = new Color(this.Field1194.getValue(), this.Field1195.getValue(), this.Field1196.getValue(), this.Field1192.getValue());
        Color color3 = this.Field1197.getValue() != false ? new Color(this.Field1198.getValue(), this.Field1199.getValue(), this.Field1200.getValue()) : color2;
        Color color4 = new Color(color3.getRed(), color3.getGreen(), color3.getBlue(), this.Field1193.getValue());
        Color color5 = new Color(this.Field1201.getValue(), this.Field1202.getValue(), this.Field1203.getValue(), this.Field1192.getValue());
        Color color6 = this.Field1204.getValue() != false ? new Color(this.Field1205.getValue(), this.Field1206.getValue(), this.Field1207.getValue()) : color5;
        Color color7 = new Color(color6.getRed(), color6.getGreen(), color6.getBlue(), this.Field1193.getValue());
        Color color8 = new Color(this.Field1208.getValue(), this.Field1209.getValue(), this.Field1210.getValue(), this.Field1192.getValue());
        Color color9 = this.Field1211.getValue() != false ? new Color(this.Field1212.getValue(), this.Field1213.getValue(), this.Field1214.getValue()) : color8;
        Color color10 = new Color(color9.getRed(), color9.getGreen(), color9.getBlue(), this.Field1193.getValue());
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) blockPos.getX() - HoleESP.Field2811.getRenderManager().viewerPosX, (double) blockPos.getY() - HoleESP.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() - HoleESP.Field2811.getRenderManager().viewerPosZ, (double) (blockPos.getX() + 1) - HoleESP.Field2811.getRenderManager().viewerPosX + d, (double) blockPos.getY() + (double) this.Field1188.getValue().floatValue() - HoleESP.Field2811.getRenderManager().viewerPosY, (double) blockPos.getZ() + d2 + Double.longBitsToDouble(Double.doubleToLongBits(25.803604906891547) ^ 0x7FC9CDB90D1A011BL) - HoleESP.Field2811.getRenderManager().viewerPosZ);
        Color color11 = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Bedrock ? color7 : (color = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Obsidian ? color4 : color10);
        if (this.Field1187.getValue().equals((Object) IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Normal)) {
            RenderUtil.Method2163010(axisAlignedBB, color, this.Field1189.getValue().floatValue());
            color = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Bedrock ? color5 : (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Obsidian ? color2 : color8);
            RenderUtil.Method2163088(axisAlignedBB.shrink(Double.longBitsToDouble(Double.doubleToLongBits(1010.6878854844731) ^ 0x7FEFF7CD2A1AD9A4L)), color);
        }
        if (this.Field1187.getValue().equals((Object) IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Glow)) {
            RenderUtil.Method2163999(axisAlignedBB, new Color(0, 0, 0, 0), color, this.Field1189.getValue().floatValue());
            color = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Bedrock ? color5 : (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Obsidian ? color2 : color8);
            RenderUtil.Method2163086(axisAlignedBB.shrink(Double.longBitsToDouble(Double.doubleToLongBits(3872.007843348089) ^ 0x7FDA3AE5440B1711L)), color, new Color(0, 0, 0, 0), false);
        }
    }

    public void Method2162452(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        this.Method2162451(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field3940, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field3941, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field3942, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Field3943);
    }

    private boolean Method2162453(Integer n2) {
        return this.Field1211.getValue();
    }

    private boolean Method2162454(Integer n2) {
        return this.Field1211.getValue();
    }

    private boolean Method2162455(Integer n2) {
        return this.Field1211.getValue();
    }

    private boolean Method2162456(Integer n2) {
        return this.Field1204.getValue();
    }

    private boolean Method2162457(Integer n2) {
        return this.Field1204.getValue();
    }

    private boolean Method2162458(Integer n2) {
        return this.Field1204.getValue();
    }

    private boolean Method2162459(Integer n2) {
        return this.Field1197.getValue();
    }

    private boolean Method2162450(Integer n2) {
        return this.Field1197.getValue();
    }

    private boolean Method2162461(Integer n2) {
        return this.Field1197.getValue();
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        Obsidian,
        Bedrock,
        Double;

    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        Normal,
        Glow;

    }

    public class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        final HoleESP Field3945;
        public BlockPos Field3940;
        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field3941;
        public int Field3942;
        public int Field3943;
        public HoleESP Field3944;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(HoleESP holeESP, HoleESP holeESP2, BlockPos blockPos, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, int n2, int n3) {
            this.Field3945 = holeESP;
            this.Field3944 = holeESP2;
            this.Field3940 = blockPos;
            this.Field3941 = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll;
            this.Field3942 = n2;
            this.Field3943 = n3;
        }
    }
}

