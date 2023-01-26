

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.StreamSupport;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HoleFillRewrite
        extends Module {
    public final Setting<Boolean> Field3210 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    public final Setting<Boolean> Field3211 = this.Method2150366(new Setting<Boolean>("Swing", true));
    public final Setting<Double> Field3212 = this.Method2150366(new Setting<Double>("Range", 5.0, 0.1, 6.0));
    public final Setting<Boolean> Field3213 = this.Method2150366(new Setting<Boolean>("StrictDirection", false));
    public final Setting<Integer> Field3214 = this.Method2150366(new Setting<Integer>("BlockPerTick", 1, 1, 8));
    public final Setting<Integer> Field3215 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 5));
    public final Setting<Boolean> Field3216 = this.Method2150366(new Setting<Boolean>("RayTrace", false));
    public final Setting<Boolean> Field3217 = this.Method2150366(new Setting<Boolean>("Double", false));
    public final Setting<Boolean> Field3218 = this.Method2150366(new Setting<Boolean>("JumpDisable", false));
    public final Setting<Boolean> Field3219 = this.Method2150366(new Setting<Boolean>("OnlyWebs", false));
    public final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3220 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Smart", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALWAYS));
    public final Setting<Double> Field3221 = this.Method2150366(new Setting<Double>("EnemyRange", 10.0, 1.0, 15.0));
    public final Setting<Boolean> Field3222 = this.Method2150366(new Setting<Boolean>("TogglesOff", false));
    public final Setting<Boolean> Field3223 = this.Method2150366(new Setting<Boolean>("Disable", false));
    public final Setting<Integer> Field3224 = this.Method2150366(new Setting<Integer>("Ms/Disable", 400, 1, 1000));
    private final Timer Field3225 = new Timer();
    ArrayList<BlockPos> Field3229;
    private Map<BlockPos, Long> Field3226 = new ConcurrentHashMap<BlockPos, Long>();
    private InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field3227 = null;
    private int Field3228;
    private Map<BlockPos, Long> Field3230 = new ConcurrentHashMap<BlockPos, Long>();
    private int Field3231 = 0;

    public HoleFillRewrite() {
        super("HoleFillRewrite", "Automatically Fills safe holes near the opponent for Crystal PvP", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static void Method2161104() {
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3210.setValue(true);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3211.setValue(true);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3212.setValue(4.5);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3213.setValue(true);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3214.setValue(3);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3215.setValue(0);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3216.setValue(false);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3217.setValue(false);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3218.setValue(false);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3219.setValue(false);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3220.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALWAYS);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3221.setValue(10.0);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3222.setValue(false);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3223.setValue(true);
        AliceMain.Field756.Method2150180(HoleFillRewrite.class).Field3224.setValue(400);
    }

    private static Float Method2161105(EntityPlayer entityPlayer) {
        return Float.valueOf(HoleFillRewrite.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161107(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161108(EntityPlayer entityPlayer) {
        return entityPlayer != HoleFillRewrite.Field2811.player;
    }

    private static Float Method2161100(BlockPos blockPos) {
        return Float.valueOf(MathHelper.sqrt((double) HoleFillRewrite.Field2811.player.getDistanceSq(blockPos)));
    }

    @Override
    public void Method2150372() {
        if (HoleFillRewrite.Field2811.player == null || HoleFillRewrite.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        this.Field3229 = Lists.newArrayList((Iterable) BlockPos.getAllInBox((BlockPos) HoleFillRewrite.Field2811.player.getPosition().add(-this.Field3212.getValue().doubleValue(), -this.Field3212.getValue().doubleValue(), -this.Field3212.getValue().doubleValue()), (BlockPos) HoleFillRewrite.Field2811.player.getPosition().add(this.Field3212.getValue().doubleValue(), this.Field3212.getValue().doubleValue(), this.Field3212.getValue().doubleValue())));
        this.Field3231 = this.Field3215.getValue();
        this.Field3225.Method2164750();
    }

    @SubscribeEvent
    public void Method2161197(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            this.Field3227 = null;
            if (this.Field3218.getValue().booleanValue() && HoleFillRewrite.Field2811.player.prevPosY < HoleFillRewrite.Field2811.player.posY) {
                this.Method2150391();
            }
            if (this.Field3223.getValue().booleanValue() && this.Field3225.Method2164755(this.Field3224.getValue().intValue())) {
                Command.Method2159696("<HoleFill> Disable");
                this.Method2150380();
            }
            if (!InteractionUtil.Method2163740(this.Field3210.getValue())) {
                return;
            }
            if (this.Field3231 < this.Field3215.getValue()) {
                ++this.Field3231;
            }
            if (this.Field3231 < this.Field3215.getValue()) {
                return;
            }
            int n2 = this.Method2161101();
            this.Field3228 = -1;
            if (n2 == -1) {
                return;
            }
            this.Field3229 = Lists.newArrayList((Iterable) BlockPos.getAllInBox((BlockPos) HoleFillRewrite.Field2811.player.getPosition().add(-this.Field3212.getValue().doubleValue(), -this.Field3212.getValue().doubleValue(), -this.Field3212.getValue().doubleValue()), (BlockPos) HoleFillRewrite.Field2811.player.getPosition().add(this.Field3212.getValue().doubleValue(), this.Field3212.getValue().doubleValue(), this.Field3212.getValue().doubleValue())));
            int n3 = CrystalUtilSC.Method2162805();
            this.Field3230.forEach((arg_0, arg_1) -> this.Method2161213(n3, arg_0, arg_1));
            if (this.Field3220.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.TARGET && this.Method2161103() == null) {
                return;
            }
            BlockPos blockPos = StreamSupport.stream(this.Field3229.spliterator(), false).filter(this::Method2161102).filter(this::Method2161212).filter(this::Method2161211).min(Comparator.comparing(HoleFillRewrite::Method2161100)).orElse(null);
            if (blockPos != null) {
                this.Field3227 = InteractionUtil.Method2163753(blockPos, this.Field3210.getValue(), false, this.Field3213.getValue(), this.Field3216.getValue());
                if (this.Field3227 != null) {
                    this.Field3231 = 0;
                    this.Field3228 = n2;
                    this.Field3226.put(blockPos, System.currentTimeMillis());
                    this.Field3230.put(blockPos, System.currentTimeMillis());
                }
            } else if (this.Field3222.getValue().booleanValue()) {
                Command.Method2159696("We are finished hole filling. toggling");
                this.Method2150391();
            }
        }
    }

    @SubscribeEvent
    public void Method2161198(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1 && this.Field3227 != null && this.Field3228 != -1) {
            boolean bl = HoleFillRewrite.Field2811.player.inventory.currentItem != this.Field3228;
            int n2 = HoleFillRewrite.Field2811.player.inventory.currentItem;
            if (bl) {
                HoleFillRewrite.Field2811.player.inventory.currentItem = this.Field3228;
                HoleFillRewrite.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field3228));
            }
            boolean bl2 = HoleFillRewrite.Field2811.player.isSprinting();
            boolean bl3 = BlockUtilSC.Method2162891(this.Field3227.Method2163743());
            if (bl2) {
                HoleFillRewrite.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) HoleFillRewrite.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                HoleFillRewrite.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) HoleFillRewrite.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            Vec3d vec3d = new Vec3d((Vec3i) this.Field3227.Method2163743()).add(0.5, 0.5, 0.5).add(new Vec3d(this.Field3227.Method2163744().getDirectionVec()).scale(0.5));
            InteractionUtil.Method2163756(this.Field3227.Method2163743(), vec3d, EnumHand.MAIN_HAND, this.Field3227.Method2163744(), true, this.Field3211.getValue());
            double d = HoleFillRewrite.Field2811.player.posX - ((IEntityPlayerSP) HoleFillRewrite.Field2811.player).getLastReportedPosX();
            double d2 = HoleFillRewrite.Field2811.player.posY - ((IEntityPlayerSP) HoleFillRewrite.Field2811.player).getLastReportedPosY();
            double d3 = HoleFillRewrite.Field2811.player.posZ - ((IEntityPlayerSP) HoleFillRewrite.Field2811.player).getLastReportedPosZ();
            boolean bl4 = d * d + d2 * d2 + d3 * d3 > 9.0E-4;
            for (int j = 0; j < this.Field3214.getValue() - 1 && !bl4; ++j) {
                InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                EntityPlayer entityPlayer = this.Method2161103();
                BlockPos blockPos = StreamSupport.stream(this.Field3229.spliterator(), false).filter(this::Method2161102).min(Comparator.comparing(arg_0 -> this.Method2161109(entityPlayer, arg_0))).orElse(null);
                if (blockPos == null || !InteractionUtil.Method2163757(blockPos, this.Field3213.getValue()) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163752(blockPos, this.Field3210.getValue(), true, this.Field3213.getValue())) == null)
                    break;
                Vec3d vec3d2 = new Vec3d((Vec3i) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163743()).add(0.5, 0.5, 0.5).add(new Vec3d(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163744().getDirectionVec()).scale(0.5));
                InteractionUtil.Method2163756(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163743(), vec3d2, EnumHand.MAIN_HAND, iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163744(), true, this.Field3211.getValue());
                this.Field3230.put(blockPos, System.currentTimeMillis());
                this.Field3226.put(blockPos, System.currentTimeMillis());
            }
            if (bl3) {
                HoleFillRewrite.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) HoleFillRewrite.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                HoleFillRewrite.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) HoleFillRewrite.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl) {
                HoleFillRewrite.Field2811.player.inventory.currentItem = n2;
                HoleFillRewrite.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            }
        }
    }

    @SubscribeEvent
    public void Method2161199(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketBlockChange && this.Field3226.containsKey((Object) ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockPosition()) && ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockState().getBlock() != Blocks.AIR) {
            this.Field3226.remove((Object) ((SPacketBlockChange) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getBlockPosition());
        }
    }

    private boolean Method2161190(Item item) {
        if (item instanceof ItemBlock) {
            if (this.Field3219.getValue().booleanValue()) {
                return ((ItemBlock) item).getBlock() instanceof BlockWeb;
            }
            return true;
        }
        return false;
    }

    private int Method2161101() {
        ItemStack itemStack = HoleFillRewrite.Field2811.player.getHeldItemMainhand();
        if (!itemStack.isEmpty() && this.Method2161190(itemStack.getItem())) {
            return HoleFillRewrite.Field2811.player.inventory.currentItem;
        }
        for (int j = 0; j < 9; ++j) {
            itemStack = HoleFillRewrite.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack.isEmpty() || !this.Method2161190(itemStack.getItem())) continue;
            return j;
        }
        return -1;
    }

    private boolean Method2161102(BlockPos blockPos) {
        if (this.Field3230.containsKey((Object) blockPos)) {
            return false;
        }
        for (Entity entity : HoleFillRewrite.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
            if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityArrow)
                continue;
            return false;
        }
        if (this.Field3217.getValue().booleanValue()) {
            BlockPos blockPos2 = BlockUtilSC.Method2162895(blockPos);
            if (blockPos2 == null) {
                blockPos2 = BlockUtilSC.Method2162894(blockPos);
            }
            if (blockPos2 != null) {
                return true;
            }
        }
        return BlockUtilSC.Method2162896(blockPos);
    }

    private EntityPlayer Method2161103() {
        return HoleFillRewrite.Field2811.world.playerEntities.stream().filter(HoleFillRewrite::Method2161108).filter(HoleFillRewrite::Method2161107).filter(this::Method2161106).min(Comparator.comparing(HoleFillRewrite::Method2161105)).orElse(null);
    }

    private boolean Method2161106(EntityPlayer entityPlayer) {
        return (double) HoleFillRewrite.Field2811.player.getDistance((Entity) entityPlayer) < this.Field3221.getValue();
    }

    private Float Method2161109(EntityPlayer entityPlayer, BlockPos blockPos) {
        return Float.valueOf(this.Field3220.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE && entityPlayer != null ? MathHelper.sqrt((double) HoleFillRewrite.Field2811.player.getDistanceSq((Entity) entityPlayer)) : MathHelper.sqrt((double) HoleFillRewrite.Field2811.player.getDistanceSq(blockPos)));
    }

    private boolean Method2161211(BlockPos blockPos) {
        return InteractionUtil.Method2163750(blockPos, this.Field3213.getValue(), this.Field3216.getValue(), true);
    }

    private boolean Method2161212(BlockPos blockPos) {
        return HoleFillRewrite.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5) <= this.Field3212.getValue();
    }

    private void Method2161213(int n2, BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long) (n2 + 100)) {
            this.Field3230.remove((Object) blockPos);
        }
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        ALWAYS,
        TARGET;

    }
}

