

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentRotaionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoTrap4
        extends Module {
    public static ConcurrentHashMap<BlockPos, Long> Field2288 = new ConcurrentHashMap();
    private final Setting<Float> Field2271 = this.Method2150366(new Setting<Float>("TargetRange", Float.valueOf(4.5f), Float.valueOf(1.0f), Float.valueOf(16.0f)));
    private final Setting<Boolean> Field2274 = this.Method2150366(new Setting<Boolean>("Top", true));
    private final Setting<Boolean> Field2278 = this.Method2150366(new Setting<Boolean>("Disable", false));
    private final Setting<Integer> Field2279 = this.Method2150366(new Setting<Integer>("Sc/Disable", 5, 1, 15));
    private final Timer Field2289 = new Timer();
    Timer Field2281 = new Timer();
    private Setting<Integer> Field2272 = this.Method2150366(new Setting<Integer>("BlockPerTick", 3, 1, 8));
    private Setting<Integer> Field2273 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 10));
    private Setting<Boolean> Field2275 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private Setting<Boolean> Field2276 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private Setting<Boolean> Field2277 = this.Method2150366(new Setting<Boolean>("Toggle", false));
    private int Field2280;
    private BlockPos Field2282;
    private int Field2283 = 0;
    private BlockPos Field2284 = null;
    private InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field2285;
    private InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field2286;
    private Timer Field2287 = new Timer();

    public AutoTrap4() {
        super("AutoTrap", "Trap your enemy", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private static Float Method2161376(EntityPlayer entityPlayer) {
        return Float.valueOf(AutoTrap4.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161378(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161379(EntityPlayer entityPlayer) {
        return entityPlayer != AutoTrap4.Field2811.player && entityPlayer != Field2811.getRenderViewEntity();
    }

    private static void Method2161370(int n2, BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long) (n2 + 100)) {
            Field2288.remove((Object) blockPos);
        }
    }

    @Override
    public void Method2150372() {
        if (AutoTrap4.Field2811.player == null || AutoTrap4.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        this.Field2282 = null;
        this.Field2284 = null;
        this.Field2285 = null;
        this.Field2286 = null;
        this.Field2283 = this.Field2273.getValue();
        this.Field2289.Method2164750();
    }

    @SubscribeEvent
    public void Method2161369(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        int n2;
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0) {
            return;
        }
        if (this.Field2278.getValue().booleanValue() && this.Field2289.Method2164755(this.Field2279.getValue() * 1000)) {
            Command.Method2159696("<AutoTrap> Disable");
            this.Method2150380();
        }
        if (this.Field2285 != null) {
            this.Field2286 = this.Field2285;
            this.Field2287.Method2164750();
        }
        this.Field2285 = null;
        this.Field2284 = null;
        int n3 = CrystalUtilSC.Method2162805();
        Field2288.forEach((arg_0, arg_1) -> AutoTrap4.Method2161370(n3, arg_0, arg_1));
        if (updateWalkingPlayerEvent.isCanceled() || !InteractionUtil.Method2163740(this.Field2276.getValue())) {
            return;
        }
        if (!(!this.Field2275.getValue().booleanValue() || AutoTrap4.Field2811.player.onGround && AutoTrap4.Field2811.player.collidedVertically)) {
            return;
        }
        if (this.Field2283 < this.Field2273.getValue()) {
            ++this.Field2283;
        }
        if ((n2 = this.Method2161373()) == -1) {
            Command.Method2159696("No Obsidian. Disable Module!");
            this.Method2150391();
            return;
        }
        this.Field2280 = n2;
        EntityPlayer entityPlayer = this.Method2161374();
        if (entityPlayer == null) {
            return;
        }
        if (this.Field2283 < this.Field2273.getValue()) {
            if (this.Field2286 != null && !this.Field2287.Method2164755(650L)) {
                SilentRotaionUtil.Method2162907(this.Field2286.Method2163746(), this.Field2286.Method2163747());
            }
            return;
        }
        this.Field2284 = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
        BlockPos blockPos = this.Method2161372(this.Field2284);
        if (blockPos != null) {
            this.Field2285 = InteractionUtil.Method2163749(blockPos, this.Field2276.getValue());
            if (this.Field2285 != null) {
                Field2288.put(blockPos, System.currentTimeMillis());
                this.Field2283 = 0;
                this.Field2282 = blockPos;
                this.Field2281.Method2164750();
            }
        } else if (this.Field2277.getValue().booleanValue()) {
            this.Method2150391();
            return;
        }
    }

    @SubscribeEvent
    public void Method2161360(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 1) {
            return;
        }
        if (this.Field2285 != null && this.Field2284 != null && this.Field2280 != -1) {
            boolean bl = AutoTrap4.Field2811.player.inventory.currentItem != this.Field2280;
            int n2 = AutoTrap4.Field2811.player.inventory.currentItem;
            if (bl) {
                AutoTrap4.Field2811.player.inventory.currentItem = this.Field2280;
                AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2280));
            }
            boolean bl2 = AutoTrap4.Field2811.player.isSprinting();
            boolean bl3 = BlockUtilSC.Method2162891(this.Field2285.Method2163743());
            if (bl2) {
                AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrap4.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrap4.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            InteractionUtil.Method2163755(this.Field2285, EnumHand.MAIN_HAND, true);
            for (int j = 0; j < this.Field2272.getValue() - 1; ++j) {
                BlockPos blockPos = this.Method2161372(this.Field2284);
                if (blockPos != null) {
                    InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(blockPos, this.Field2276.getValue(), true);
                    if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll == null)
                        break;
                    this.Field2285 = iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                    Field2288.put(blockPos, System.currentTimeMillis());
                    InteractionUtil.Method2163755(this.Field2285, EnumHand.MAIN_HAND, true);
                    this.Field2282 = blockPos;
                    this.Field2281.Method2164750();
                    continue;
                }
                if (!this.Field2277.getValue().booleanValue()) break;
                this.Method2150391();
                if (bl) {
                    AutoTrap4.Field2811.player.inventory.currentItem = n2;
                    AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                }
                return;
            }
            if (bl3) {
                AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrap4.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrap4.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl) {
                AutoTrap4.Field2811.player.inventory.currentItem = n2;
                AutoTrap4.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            }
        }
    }

    private boolean Method2161371(BlockPos blockPos, boolean bl) {
        return InteractionUtil.Method2163757(blockPos, bl) && !Field2288.containsKey((Object) blockPos);
    }

    private BlockPos Method2161372(BlockPos blockPos) {
        Block block;
        double d;
        BlockPos blockPos2;
        double d2;
        BlockPos blockPos3;
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d2 = 0.0;
            if (this.Method2161371(blockPos.offset(enumFacing).down(), true)) {
                double d3;
                blockPos2 = blockPos.offset(enumFacing).down();
                d = AutoTrap4.Field2811.player.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5);
                if (d3 >= d2) {
                    blockPos3 = blockPos2;
                    d2 = d;
                }
            }
            if (blockPos3 == null) {
                continue;
            }
            return blockPos3;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d2 = 0.0;
            if (this.Method2161371(blockPos.offset(enumFacing), false)) {
                double d4;
                blockPos2 = blockPos.offset(enumFacing);
                d = AutoTrap4.Field2811.player.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5);
                if (d4 >= d2) {
                    blockPos3 = blockPos2;
                    d2 = d;
                }
            }
            if (blockPos3 == null) {
                continue;
            }
            return blockPos3;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d2 = 0.0;
            if (this.Method2161371(blockPos.up().offset(enumFacing), false)) {
                double d5;
                blockPos2 = blockPos.up().offset(enumFacing);
                d = AutoTrap4.Field2811.player.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5);
                if (d5 >= d2) {
                    blockPos3 = blockPos2;
                    d2 = d;
                }
            }
            if (blockPos3 == null) {
                continue;
            }
            return blockPos3;
        }
        if (this.Field2274.getValue().booleanValue() && ((block = AutoTrap4.Field2811.world.getBlockState(blockPos.up().up()).getBlock()) instanceof BlockAir || block instanceof BlockLiquid)) {
            if (this.Method2161371(blockPos.up().up(), false)) {
                return blockPos.up().up();
            }
            BlockPos blockPos4 = blockPos.up().up().offset(EnumFacing.byHorizontalIndex((int) (MathHelper.floor((double) ((double) (AutoTrap4.Field2811.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3)));
            if (this.Method2161371(blockPos4, false)) {
                return blockPos4;
            }
        }
        return null;
    }

    private int Method2161373() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = AutoTrap4.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private EntityPlayer Method2161374() {
        Stream stream = AutoTrap4.Field2811.world.playerEntities.stream();
        return stream.filter(AutoTrap4::Method2161379).filter(AutoTrap4::Method2161378).filter(this::Method2161377).filter(this::Method2161375).min(Comparator.comparing(AutoTrap4::Method2161376)).orElse(null);
    }

    private boolean Method2161375(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ).down();
        Block block = AutoTrap4.Field2811.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockAir) && !(block instanceof BlockLiquid);
    }

    private boolean Method2161377(EntityPlayer entityPlayer) {
        return AutoTrap4.Field2811.player.getDistance((Entity) entityPlayer) < Math.max(this.Field2271.getValue().floatValue() - 1.0f, 1.0f);
    }
}

