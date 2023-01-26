

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockEndPortalFrame
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Speedmine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Speedmine1
        extends Module {
    private static Speedmine1 Field3285 = new Speedmine1();
    private final Setting<Float> Field3286 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(50.0f)));
    private final Timer Field3287 = new Timer();
    public Setting<Boolean> Field3288 = this.Method2150366(new Setting<Boolean>("Tweaks", true));
    public Setting<Speedmine.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3289 = this.Method2150366(new Setting<Object>("Mode", (Object) Speedmine.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PACKET, this::Method2161623));
    public Setting<Float> Field3291 = this.Method2150366(new Setting<Object>("Damage", Float.valueOf(0.7f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2161622));
    public Setting<Boolean> Field3290 = this.Method2150366(new Setting<Boolean>("Reset", true));
    public Setting<Boolean> Field3292 = this.Method2150366(new Setting<Boolean>("NoBreakAnim", false));
    public Setting<Boolean> Field3293 = this.Method2150366(new Setting<Boolean>("NoDelay", false));
    public Setting<Boolean> Field3294 = this.Method2150366(new Setting<Boolean>("NoSwing", false));
    public Setting<Boolean> Field3295 = this.Method2150366(new Setting<Boolean>("NoTrace", false));
    public Setting<Boolean> Field3296 = this.Method2150366(new Setting<Object>("NoGapTrace", Boolean.valueOf(false), this::Method2161621));
    public Setting<Boolean> Field3297 = this.Method2150366(new Setting<Boolean>("AllowMultiTask", false));
    public Setting<Boolean> Field3298 = this.Method2150366(new Setting<Object>("Pickaxe", Boolean.valueOf(true), this::Method2161610));
    public Setting<Boolean> Field3299 = this.Method2150366(new Setting<Boolean>("DoubleBreak", false));
    public Setting<Boolean> Field3300 = this.Method2150366(new Setting<Boolean>("WebSwitch", false));
    public Setting<Boolean> Field3301 = this.Method2150366(new Setting<Boolean>("SilentSwitch", false));
    public Setting<Boolean> Field3302 = this.Method2150366(new Setting<Boolean>("IllegalMine", false));
    public Setting<Boolean> Field3303 = this.Method2150366(new Setting<Boolean>("Render", false));
    public Setting<Boolean> Field3304 = this.Method2150366(new Setting<Object>("Box", Boolean.valueOf(false), this::Method2161619));
    private final Setting<Integer> Field3305 = this.Method2150366(new Setting<Object>("BoxAlpha", Integer.valueOf(85), Integer.valueOf(0), Integer.valueOf(255), this::Method2161618));
    public Setting<Boolean> Field3306 = this.Method2150366(new Setting<Object>("Outline", Boolean.valueOf(true), this::Method2161617));
    private final Setting<Float> Field3307 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2161616));
    public BlockPos Field3308;
    public IBlockState Field3309;
    private boolean Field3310 = false;
    private BlockPos Field3311 = null;
    private EnumFacing Field3312 = null;

    public Speedmine1() {
        super("Speedmine", "Speeds up mining.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2161500();
    }

    public static Speedmine1 Method2161509() {
        if (Field3285 == null) {
            Field3285 = new Speedmine1();
        }
        return Field3285;
    }

    private void Method2161500() {
        Field3285 = this;
    }

    @Override
    public void Method2150376() {
        if (this.Field3308 != null) {
            if (Speedmine1.Field2811.player != null && Speedmine1.Field2811.player.getDistanceSq(this.Field3308) > MathUtil.Method2163857(this.Field3286.getValue().floatValue())) {
                this.Field3308 = null;
                this.Field3309 = null;
                return;
            }
            if (Speedmine1.Field2811.player != null && this.Field3301.getValue().booleanValue() && this.Field3287.Method2164755((int) (2000.0f * AliceMain.Field768.Method2150202())) && this.Method2161613() != -1) {
                Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161613()));
            }
            if (!Speedmine1.Field2811.world.getBlockState(this.Field3308).equals((Object) this.Field3309) || Speedmine1.Field2811.world.getBlockState(this.Field3308).getBlock() == Blocks.AIR) {
                this.Field3308 = null;
                this.Field3309 = null;
            } else if (this.Field3300.getValue().booleanValue() && this.Field3309.getBlock() == Blocks.WEB && Speedmine1.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
                InventoryUtil.Method2163775(ItemSword.class, false);
            }
        }
    }

    @Override
    public void Method2150379() {
        if (Speedmine1.Method2150359()) {
            return;
        }
        if (this.Field3293.getValue().booleanValue()) {
            Speedmine1.Field2811.playerController.blockHitDelay = 0;
        }
        if (this.Field3310 && this.Field3311 != null && this.Field3312 != null && this.Field3292.getValue().booleanValue()) {
            Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.Field3311, this.Field3312));
        }
        if (this.Field3290.getValue().booleanValue() && Speedmine1.Field2811.gameSettings.keyBindUseItem.isKeyDown() && !this.Field3297.getValue().booleanValue()) {
            Speedmine1.Field2811.playerController.isHittingBlock = false;
        }
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field3303.getValue().booleanValue() && this.Field3308 != null) {
            Color color = new Color(this.Field3287.Method2164755((int) (2000.0f * AliceMain.Field768.Method2150202())) ? 0 : 255, this.Field3287.Method2164755((int) (2000.0f * AliceMain.Field768.Method2150202())) ? 255 : 0, 0, 255);
            RenderUtil.Method2163908(this.Field3308, color, false, color, this.Field3307.getValue().floatValue(), this.Field3306.getValue(), this.Field3304.getValue(), this.Field3305.getValue(), false);
        }
    }

    @SubscribeEvent
    public void Method2161611(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (Speedmine1.Method2150359()) {
            return;
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            CPacketPlayerDigging cPacketPlayerDigging;
            if (this.Field3294.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketAnimation) {
                iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
            }
            if (this.Field3292.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerDigging && (cPacketPlayerDigging = (CPacketPlayerDigging) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()) != null && cPacketPlayerDigging.getPosition() != null) {
                try {
                    for (Entity entity : Speedmine1.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(cPacketPlayerDigging.getPosition()))) {
                        if (!(entity instanceof EntityEnderCrystal)) continue;
                        this.Method2161615();
                        return;
                    }
                } catch (Exception exception) {
                    // empty catch block
                }
                if (cPacketPlayerDigging.getAction().equals((Object) CPacketPlayerDigging.Action.START_DESTROY_BLOCK)) {
                    this.Method2161614(true, cPacketPlayerDigging.getPosition(), cPacketPlayerDigging.getFacing());
                }
                if (cPacketPlayerDigging.getAction().equals((Object) CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK)) {
                    this.Method2161615();
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161612(BlockEvent blockEvent) {
        if (Speedmine1.Method2150359()) {
            return;
        }
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 3 && Speedmine1.Field2811.world.getBlockState(blockEvent.Field3432).getBlock() instanceof BlockEndPortalFrame) {
            Speedmine1.Field2811.world.getBlockState(blockEvent.Field3432).getBlock().setHardness(50.0f);
        }
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 3 && this.Field3290.getValue().booleanValue() && Speedmine1.Field2811.playerController.curBlockDamageMP > 0.1f) {
            Speedmine1.Field2811.playerController.isHittingBlock = true;
        }
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 4 && this.Field3288.getValue().booleanValue()) {
            BlockPos blockPos;
            if (BlockUtil.Method2162840(blockEvent.Field3432)) {
                if (this.Field3290.getValue().booleanValue()) {
                    Speedmine1.Field2811.playerController.isHittingBlock = false;
                }
                switch (this.Field3289.getValue()) {
                    case PACKET: {
                        if (this.Field3308 == null) {
                            this.Field3308 = blockEvent.Field3432;
                            this.Field3309 = Speedmine1.Field2811.world.getBlockState(this.Field3308);
                            this.Field3287.Method2164750();
                        }
                        Speedmine1.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                        Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        blockEvent.setCanceled(true);
                        break;
                    }
                    case DAMAGE: {
                        if (!(Speedmine1.Field2811.playerController.curBlockDamageMP >= this.Field3291.getValue().floatValue()))
                            break;
                        Speedmine1.Field2811.playerController.curBlockDamageMP = 1.0f;
                        break;
                    }
                    case INSTANT: {
                        Speedmine1.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                        Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        Speedmine1.Field2811.playerController.onPlayerDestroyBlock(blockEvent.Field3432);
                        Speedmine1.Field2811.world.setBlockToAir(blockEvent.Field3432);
                    }
                }
            }
            if (this.Field3299.getValue().booleanValue() && BlockUtil.Method2162840(blockPos = blockEvent.Field3432.add(0, 1, 0)) && Speedmine1.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()) <= 5.0) {
                Speedmine1.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, blockEvent.Field3433));
                Speedmine1.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, blockEvent.Field3433));
                Speedmine1.Field2811.playerController.onPlayerDestroyBlock(blockPos);
                Speedmine1.Field2811.world.setBlockToAir(blockPos);
            }
        }
    }

    private int Method2161613() {
        for (int j = 0; j < 9; ++j) {
            if (Speedmine1.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.DIAMOND_PICKAXE) {
                continue;
            }
            return j;
        }
        return -1;
    }

    private void Method2161614(boolean bl, BlockPos blockPos, EnumFacing enumFacing) {
        this.Field3310 = bl;
        this.Field3311 = blockPos;
        this.Field3312 = enumFacing;
    }

    public void Method2161615() {
        this.Method2161614(false, null, null);
    }

    @Override
    public String Method2150385() {
        return this.Field3289.currentEnumName();
    }

    private boolean Method2161616(Object object) {
        return this.Field3306.getValue() != false && this.Field3303.getValue() != false;
    }

    private boolean Method2161617(Object object) {
        return this.Field3303.getValue();
    }

    private boolean Method2161618(Object object) {
        return this.Field3304.getValue() != false && this.Field3303.getValue() != false;
    }

    private boolean Method2161619(Object object) {
        return this.Field3303.getValue();
    }

    private boolean Method2161610(Object object) {
        return this.Field3295.getValue();
    }

    private boolean Method2161621(Object object) {
        return this.Field3295.getValue();
    }

    private boolean Method2161622(Object object) {
        return this.Field3289.getValue() == Speedmine.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE && this.Field3288.getValue() != false;
    }

    private boolean Method2161623(Object object) {
        return this.Field3288.getValue();
    }
}

