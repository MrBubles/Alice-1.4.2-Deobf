

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Automine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;

public class InstantMine
        extends Module {
    public static BlockPos Field4339;
    public static BlockPos Field4342;
    static int Field4348;
    private static InstantMine Field4317 = new InstantMine();

    static {
        Field4348 = 0;
    }

    public final Timer Field4345 = new Timer();
    public final Timer Field4346 = new Timer();
    private final Timer Field4316 = new Timer();
    private final Setting<Boolean> Field4324 = this.Method2150366(new Setting<Boolean>("Crystal", Boolean.TRUE));
    public final Setting<Boolean> Field4326 = this.Method2150366(new Setting<Object>("Attack Crystal", Boolean.TRUE, this::Method2162254));
    public final Setting<Bind> Field4327 = this.Method2150366(new Setting<Object>("ObsidianBind", new Bind(-1), this::Method2162253));
    private final Setting<Boolean> Field4325 = this.Method2150366(new Setting<Boolean>("Crystal on Break", Boolean.TRUE, this::Method2162255));
    private final List<Block> Field4335 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.BEDROCK});
    public Setting<Boolean> Field4328 = this.Method2150366(new Setting<Boolean>("Silent Double", true));
    public final Setting<Float> Field4329 = this.Method2150366(new Setting<Float>("Health", Float.valueOf(18.0f), Float.valueOf(0.0f), Float.valueOf(35.9f), this::Method2162252));
    int Field4340;
    int Field4341;
    double Field4343 = 0.0;
    double Field4344 = 0.0;
    long Field4347 = 0L;
    private Setting<Boolean> Field4318 = this.Method2150366(new Setting<Boolean>("CreativeMode", true));
    private Setting<Boolean> Field4319 = this.Method2150366(new Setting<Boolean>("GhostHand", Boolean.valueOf(true), this::Method2162258));
    private Setting<Boolean> Field4320 = this.Method2150366(new Setting<Boolean>("Fill", true));
    private Setting<Integer> Field4321 = this.Method2150366(new Setting<Object>("FillAlpha1", Integer.valueOf(30), Integer.valueOf(0), Integer.valueOf(255), this::Method2162257));
    private Setting<Boolean> Field4322 = this.Method2150366(new Setting<Boolean>("Box", true));
    private Setting<Integer> Field4323 = this.Method2150366(new Setting<Object>("BoxAlpha1", Integer.valueOf(30), Integer.valueOf(0), Integer.valueOf(255), this::Method2162256));
    private Setting<Integer> Field4330 = this.Method2150366(new Setting<Integer>("Red", 255, 0, 255));
    private Setting<Integer> Field4331 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private Setting<Integer> Field4332 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    private Setting<Integer> Field4333 = this.Method2150366(new Setting<Integer>("BoxAlpha", 90, 0, 255));
    private Setting<Integer> Field4334 = this.Method2150366(new Setting<Integer>("FillAlpha", 90, 0, 255));
    private boolean Field4336 = false;
    private boolean Field4337 = false;
    private EnumFacing Field4338;

    public InstantMine() {
        super("InstantMine", "Crazy packet miner.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162245();
    }

    public static InstantMine Method2162244() {
        if (Field4317 != null) {
            return Field4317;
        }
        Field4317 = new InstantMine();
        return Field4317;
    }

    public static void Method2162248() {
        for (Entity entity : InstantMine.Field2811.world.loadedEntityList.stream().filter(InstantMine::Method2162251).sorted(Comparator.comparing(InstantMine::Method2162240)).collect(Collectors.toList())) {
            if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistanceSq(Field4339) <= 2.0)) continue;
            InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
            InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        }
    }

    private static Float Method2162240(Entity entity) {
        return Float.valueOf(InstantMine.Field2811.player.getDistance(entity));
    }

    private static boolean Method2162251(Entity entity) {
        return entity instanceof EntityEnderCrystal && !entity.isDead;
    }

    private void Method2162245() {
        Field4317 = this;
    }

    @Override
    public void Method2150372() {
    }

    @Override
    public void Method2150373() {
        if (AliceMain.Field756.Method2150180(Automine.class).Method2150364()) {
            Command.Method2159696("<InstantMine> Automine is on.please turn AutoMine off");
            this.Method2150389();
        }
    }

    @Override
    public void Method2150376() {
        if (InstantMine.Field2811.player.isCreative()) {
            return;
        }
        this.Field4340 = InstantMine.Field2811.player.inventory.currentItem;
        if (Field4348 <= 86 && Field4348 >= 0) {
            ++Field4348;
        }
        if (Field4342 == null) {
            this.Field4344 = 0.0;
        }
        if (Field4342 != null && (Field4348 >= 65 || Field4348 >= 20 && InstantMine.Field2811.world.getBlockState(Field4339).getBlock() == Blocks.ENDER_CHEST)) {
            if (InstantMine.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.GOLDEN_APPLE || InstantMine.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.CHORUS_FRUIT) {
                if (!Mouse.isButtonDown((int) 1)) {
                    if (InstantMine.Field2811.player.getHealth() + InstantMine.Field2811.player.getAbsorptionAmount() >= this.Field4329.getValue().floatValue()) {
                        if (InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE) != -1 && this.Field4328.getValue().booleanValue()) {
                            InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE)));
                            this.Field4341 = 1;
                            ++Field4348;
                        }
                    } else if (this.Field4341 == 1) {
                        InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4340));
                        this.Field4341 = 0;
                    }
                } else if (this.Field4341 == 1) {
                    InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4340));
                    this.Field4341 = 0;
                }
            } else if (InstantMine.Field2811.player.getHealth() + InstantMine.Field2811.player.getAbsorptionAmount() >= this.Field4329.getValue().floatValue()) {
                if (InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE) != -1 && this.Field4328.getValue().booleanValue()) {
                    InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE)));
                    this.Field4341 = 1;
                    ++Field4348;
                }
            } else if (this.Field4341 == 1) {
                InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4340));
                this.Field4341 = 0;
            }
        }
        if (Field4342 != null && InstantMine.Field2811.world.getBlockState(Field4342).getBlock() == Blocks.AIR) {
            if (this.Field4341 == 1) {
                InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4340));
                this.Field4341 = 0;
            }
            Field4342 = null;
            this.Field4344 = 0.0;
            Field4348 = 0;
        }
        if (Field4348 == 0) {
            this.Field4344 = 0.0;
            Field4342 = null;
        }
        if (Field4348 >= 140) {
            if (this.Field4341 == 1) {
                InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4340));
                this.Field4341 = 0;
            }
            this.Field4344 = 0.0;
            Field4342 = null;
            Field4348 = 0;
        }
        if (Field4339 != null && InstantMine.Field2811.world.getBlockState(Field4339).getBlock() == Blocks.AIR && Field4342 == null) {
            Field4348 = 0;
        }
        if (InstantMine.Method2150359()) {
            return;
        }
        if (!this.Field4318.getValue().booleanValue()) {
            return;
        }
        if (!this.Field4336) {
            return;
        }
        if (this.Field4324.getValue().booleanValue() && this.Field4326.getValue().booleanValue() && InstantMine.Field2811.world.getBlockState(Field4339).getBlock() == Blocks.AIR) {
            InstantMine.Method2162248();
        }
        if (this.Field4327.getValue().isDown() && this.Field4324.getValue().booleanValue() && InventoryUtil.Method2163778(BlockObsidian.class) != -1 && InstantMine.Field2811.world.getBlockState(Field4339).getBlock() == Blocks.AIR) {
            int n2 = InventoryUtil.Method2163778(BlockObsidian.class);
            int n3 = InstantMine.Field2811.player.inventory.currentItem;
            this.Method2162246(n2);
            BlockUtil.Method2162810(Field4339, EnumHand.MAIN_HAND, false, true, false);
            this.Method2162246(n3);
        }
        if (InventoryUtil.Method2163781(Items.END_CRYSTAL) != -1 && this.Field4324.getValue().booleanValue() && InstantMine.Field2811.world.getBlockState(Field4339).getBlock() == Blocks.OBSIDIAN && !Field4339.equals((Object) Automine.Field2759)) {
            if (this.Field4337) {
                BlockUtil.Method2162838(Field4339, EnumHand.MAIN_HAND, true, false, true);
            } else if (!this.Field4325.getValue().booleanValue()) {
                BlockUtil.Method2162838(Field4339, EnumHand.MAIN_HAND, true, false, true);
            }
        }
        if (this.Field4335.contains((Object) InstantMine.Field2811.world.getBlockState(Field4339).getBlock())) {
            return;
        }
        if (InstantMine.Field2811.world.getBlockState(Field4339).getBlock() != Blocks.WEB) {
            if (this.Field4319.getValue().booleanValue() && InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE) != -1 && InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE) != -1) {
                int n4 = InstantMine.Field2811.player.inventory.currentItem;
                if (InstantMine.Field2811.world.getBlockState(Field4339).getBlock() == Blocks.OBSIDIAN) {
                    if (!this.Field4316.Method2164755(1234L)) {
                        return;
                    }
                    InstantMine.Field2811.player.inventory.currentItem = InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE);
                    InstantMine.Field2811.playerController.updateController();
                    InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, Field4339, this.Field4338));
                    InstantMine.Field2811.player.inventory.currentItem = n4;
                    InstantMine.Field2811.playerController.updateController();
                    return;
                }
                InstantMine.Field2811.player.inventory.currentItem = InventoryUtil.Method2163781(Items.DIAMOND_PICKAXE);
                InstantMine.Field2811.playerController.updateController();
                InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, Field4339, this.Field4338));
                InstantMine.Field2811.player.inventory.currentItem = n4;
                InstantMine.Field2811.playerController.updateController();
                return;
            }
        } else if (this.Field4319.getValue().booleanValue() && InventoryUtil.Method2163781(Items.DIAMOND_SWORD) != -1 && InventoryUtil.Method2163781(Items.DIAMOND_SWORD) != -1) {
            int n5 = InstantMine.Field2811.player.inventory.currentItem;
            InstantMine.Field2811.player.inventory.currentItem = InventoryUtil.Method2163781(Items.DIAMOND_SWORD);
            InstantMine.Field2811.playerController.updateController();
            InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, Field4339, this.Field4338));
            InstantMine.Field2811.player.inventory.currentItem = n5;
            InstantMine.Field2811.playerController.updateController();
            return;
        }
        InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, Field4339, this.Field4338));
    }

    private void Method2162246(int n2) {
        InstantMine.Field2811.player.inventory.currentItem = n2;
        InstantMine.Field2811.playerController.updateController();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (!InstantMine.Field2811.player.isCreative()) {
            AxisAlignedBB axisAlignedBB;
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            double d6;
            AxisAlignedBB axisAlignedBB2;
            if (Field4342 != null) {
                axisAlignedBB2 = InstantMine.Field2811.world.getBlockState(Field4342).getSelectedBoundingBox((World) InstantMine.Field2811.world, Field4342);
                d6 = axisAlignedBB2.minX + (axisAlignedBB2.maxX - axisAlignedBB2.minX) / 2.0;
                d5 = axisAlignedBB2.minY + (axisAlignedBB2.maxY - axisAlignedBB2.minY) / 2.0;
                d4 = axisAlignedBB2.minZ + (axisAlignedBB2.maxZ - axisAlignedBB2.minZ) / 2.0;
                d3 = InstantMine.Method2162244().Field4344 * ((axisAlignedBB2.maxX - d6) / 10.0);
                d2 = InstantMine.Method2162244().Field4344 * ((axisAlignedBB2.maxY - d5) / 10.0);
                d = InstantMine.Method2162244().Field4344 * ((axisAlignedBB2.maxZ - d4) / 10.0);
                axisAlignedBB = new AxisAlignedBB(d6 - d3, d5 - d2, d4 - d, d6 + d3, d5 + d2, d4 + d);
                if (Field4339 != null) {
                    if (!Field4342.equals((Object) Field4339)) {
                        RenderUtil.Method2163962(axisAlignedBB, new Color(this.Field4330.getValue(), this.Field4331.getValue(), this.Field4332.getValue(), this.Field4334.getValue()), this.Field4334.getValue());
                    }
                } else {
                    RenderUtil.Method2163962(axisAlignedBB, new Color(this.Field4330.getValue(), this.Field4331.getValue(), this.Field4332.getValue(), this.Field4334.getValue()), this.Field4334.getValue());
                }
            }
            if (this.Field4318.getValue().booleanValue() && this.Field4336) {
                if (this.Field4335.contains((Object) InstantMine.Field2811.world.getBlockState(Field4339).getBlock())) {
                    this.Field4337 = true;
                }
                if (this.Field4345.Method2164755(15L)) {
                    if (this.Field4343 <= 10.0) {
                        this.Field4343 += 0.11;
                    }
                    this.Field4345.Method2164750();
                }
                if (this.Field4346.Method2164755(22L)) {
                    if (this.Field4344 <= 10.0 && this.Field4344 >= 0.0) {
                        this.Field4344 += 0.11;
                    }
                    this.Field4346.Method2164750();
                }
                axisAlignedBB2 = InstantMine.Field2811.world.getBlockState(Field4339).getSelectedBoundingBox((World) InstantMine.Field2811.world, Field4339);
                d6 = axisAlignedBB2.minX + (axisAlignedBB2.maxX - axisAlignedBB2.minX) / 2.0;
                d5 = axisAlignedBB2.minY + (axisAlignedBB2.maxY - axisAlignedBB2.minY) / 2.0;
                d4 = axisAlignedBB2.minZ + (axisAlignedBB2.maxZ - axisAlignedBB2.minZ) / 2.0;
                d3 = this.Field4343 * ((axisAlignedBB2.maxX - d6) / 10.0);
                d2 = this.Field4343 * ((axisAlignedBB2.maxY - d5) / 10.0);
                d = this.Field4343 * ((axisAlignedBB2.maxZ - d4) / 10.0);
                axisAlignedBB = new AxisAlignedBB(d6 - d3, d5 - d2, d4 - d, d6 + d3, d5 + d2, d4 + d);
                if (this.Field4320.getValue().booleanValue()) {
                    RenderUtil.Method2163962(axisAlignedBB, new Color(this.Field4337 ? 0 : 255, this.Field4337 ? 255 : 0, 0, 255), this.Field4321.getValue());
                }
                if (this.Field4322.getValue().booleanValue()) {
                    RenderUtil.Method2163962(axisAlignedBB, new Color(this.Field4337 ? 0 : 255, this.Field4337 ? 255 : 0, 0, 255), this.Field4323.getValue());
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2162247(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (InstantMine.Method2150359()) {
            return;
        }
        if (InstantMine.Field2811.player.isCreative()) {
            return;
        }
        if (!(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerDigging)) {
            return;
        }
        CPacketPlayerDigging cPacketPlayerDigging = (CPacketPlayerDigging) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        if (cPacketPlayerDigging.getAction() != CPacketPlayerDigging.Action.START_DESTROY_BLOCK) {
            return;
        }
        iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(this.Field4336);
    }

    @SubscribeEvent
    public void Method2162249(BlockEvent blockEvent) {
        if (InstantMine.Method2150359()) {
            return;
        }
        if (InstantMine.Field2811.player.isCreative()) {
            return;
        }
        if (!BlockUtil.Method2162840(blockEvent.Field3432)) {
            return;
        }
        if (Field4339 != null && Field4339.getX() == blockEvent.Field3432.getX() && Field4339.getY() == blockEvent.Field3432.getY() && Field4339.getZ() == blockEvent.Field3432.getZ()) {
            return;
        }
        if (Field4348 == 0) {
            Field4348 = 1;
        }
        if (this.Field4344 == 0.0) {
            this.Field4344 = 0.11;
        }
        if (Field4339 != null && Field4342 == null && InstantMine.Field2811.world.getBlockState(Field4339).getBlock() != Blocks.AIR) {
            Field4342 = Field4339;
        }
        if (Field4339 == null && Field4342 == null) {
            Field4342 = blockEvent.Field3432;
        }
        this.Field4343 = 0.0;
        this.Field4337 = false;
        this.Field4336 = false;
        Field4339 = blockEvent.Field3432;
        this.Field4316.Method2164750();
        this.Field4338 = blockEvent.Field3433;
        if (Field4339 == null) {
            return;
        }
        InstantMine.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, Field4339, this.Field4338));
        this.Field4336 = true;
        InstantMine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, Field4339, this.Field4338));
        blockEvent.setCanceled(true);
    }

    private boolean Method2162252(Float f) {
        return this.Field4328.getValue();
    }

    private boolean Method2162253(Object object) {
        return this.Field4324.getValue();
    }

    private boolean Method2162254(Object object) {
        return this.Field4324.getValue();
    }

    private boolean Method2162255(Boolean bl) {
        return this.Field4324.getValue();
    }

    private boolean Method2162256(Object object) {
        return this.Field4322.getValue();
    }

    private boolean Method2162257(Object object) {
        return this.Field4320.getValue();
    }

    private boolean Method2162258(Boolean bl) {
        return this.Field4318.getValue();
    }
}

