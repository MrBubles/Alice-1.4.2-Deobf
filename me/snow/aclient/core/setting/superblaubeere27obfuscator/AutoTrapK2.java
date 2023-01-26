

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

import java.awt.Color;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
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

public class AutoTrapK2
        extends Module {
    public static ConcurrentHashMap<BlockPos, Long> Field2874 = new ConcurrentHashMap();
    private final Setting<Float> Field2850 = this.Method2150366(new Setting<Float>("TargetRange", Float.valueOf(4.5f), Float.valueOf(1.0f), Float.valueOf(16.0f)));
    private final Setting<Boolean> Field2853 = this.Method2150366(new Setting<Boolean>("Top", true));
    private final Setting<Boolean> Field2857 = this.Method2150366(new Setting<Boolean>("Disable", false));
    private final Setting<Integer> Field2858 = this.Method2150366(new Setting<Integer>("Sc/Disable", 5, 1, 15));
    private final Setting<Boolean> Field2859 = this.Method2150366(new Setting<Boolean>("Render", false));
    private final Setting<Boolean> Field2860 = this.Method2150366(new Setting<Boolean>("Csync", false));
    private final Setting<Integer> Field2861 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    private final Setting<Integer> Field2862 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private final Setting<Integer> Field2863 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    private final Setting<Integer> Field2864 = this.Method2150366(new Setting<Integer>("Alpha", 70, 0, 255));
    private final Setting<Integer> Field2865 = this.Method2150366(new Setting<Integer>("BoxAlpha", 70, 0, 255));
    Timer Field2867 = new Timer();
    private Setting<Integer> Field2851 = this.Method2150366(new Setting<Integer>("BlockPerTick", 3, 1, 8));
    private Setting<Integer> Field2852 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 10));
    private Setting<Boolean> Field2854 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private Setting<Boolean> Field2855 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private Setting<Boolean> Field2856 = this.Method2150366(new Setting<Boolean>("Toggle", false));
    private int Field2866;
    private BlockPos Field2868;
    private int Field2869 = 0;
    private BlockPos Field2870 = null;
    private InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field2871;
    private InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field2872;
    private Timer Field2873 = new Timer();

    public AutoTrapK2() {
        super("AutoTrapKonasPart2 OMG", "Traps other players", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private static Float Method2161388(EntityPlayer entityPlayer) {
        return Float.valueOf(AutoTrapK2.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161380(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161391(EntityPlayer entityPlayer) {
        return entityPlayer != AutoTrapK2.Field2811.player && entityPlayer != Field2811.getRenderViewEntity();
    }

    private static void Method2161392(int n2, BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long) (n2 + 100)) {
            Field2874.remove((Object) blockPos);
        }
    }

    @Override
    public void Method2150372() {
        if (AutoTrapK2.Field2811.player == null || AutoTrapK2.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        this.Field2868 = null;
        this.Field2870 = null;
        this.Field2871 = null;
        this.Field2872 = null;
        this.Field2869 = this.Field2852.getValue();
    }

    @SubscribeEvent
    public void Method2161381(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            int n2;
            if (this.Field2871 != null) {
                this.Field2872 = this.Field2871;
                this.Field2873.Method2164750();
            }
            this.Field2871 = null;
            this.Field2870 = null;
            int n3 = CrystalUtilSC.Method2162805();
            Field2874.forEach((arg_0, arg_1) -> AutoTrapK2.Method2161392(n3, arg_0, arg_1));
            if (updateWalkingPlayerEvent.isCanceled() || !InteractionUtil.Method2163740(this.Field2855.getValue())) {
                return;
            }
            if (!(!this.Field2854.getValue().booleanValue() || AutoTrapK2.Field2811.player.onGround && AutoTrapK2.Field2811.player.collidedVertically)) {
                return;
            }
            if (this.Field2869 < this.Field2852.getValue()) {
                ++this.Field2869;
            }
            if ((n2 = this.Method2161385()) == -1) {
                Command.Method2159696("No Obby Found!");
                this.Method2150391();
                return;
            }
            this.Field2866 = n2;
            EntityPlayer entityPlayer = this.Method2161386();
            if (entityPlayer == null) {
                return;
            }
            if (this.Field2869 < this.Field2852.getValue()) {
                if (this.Field2872 != null && !this.Field2873.Method2164740(650.0)) {
                    SilentRotaionUtil.Method2162907(this.Field2872.Method2163746(), this.Field2872.Method2163747());
                }
                return;
            }
            this.Field2870 = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
            BlockPos blockPos = this.Method2161384(this.Field2870);
            if (blockPos != null) {
                this.Field2871 = InteractionUtil.Method2163749(blockPos, this.Field2855.getValue());
                if (this.Field2871 != null) {
                    Field2874.put(blockPos, System.currentTimeMillis());
                    this.Field2869 = 0;
                    this.Field2868 = blockPos;
                    this.Field2867.Method2164750();
                }
            } else if (this.Field2856.getValue().booleanValue()) {
                this.Method2150391();
                return;
            }
        }
    }

    @SubscribeEvent
    public void Method2161382(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1 && this.Field2871 != null && this.Field2870 != null && this.Field2866 != -1) {
            boolean bl = AutoTrapK2.Field2811.player.inventory.currentItem != this.Field2866;
            int n2 = AutoTrapK2.Field2811.player.inventory.currentItem;
            if (bl) {
                AutoTrapK2.Field2811.player.inventory.currentItem = this.Field2866;
                AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2866));
            }
            boolean bl2 = AutoTrapK2.Field2811.player.isSprinting();
            boolean bl3 = BlockUtilSC.Method2162891(this.Field2871.Method2163743());
            if (bl2) {
                AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapK2.Field2811.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapK2.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            InteractionUtil.Method2163755(this.Field2871, EnumHand.MAIN_HAND, true);
            for (int j = 0; j < this.Field2851.getValue() - 1; ++j) {
                BlockPos blockPos = this.Method2161384(this.Field2870);
                if (blockPos != null) {
                    InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(blockPos, this.Field2855.getValue(), true);
                    if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll == null)
                        break;
                    this.Field2871 = iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                    Field2874.put(blockPos, System.currentTimeMillis());
                    InteractionUtil.Method2163755(this.Field2871, EnumHand.MAIN_HAND, true);
                    this.Field2868 = blockPos;
                    this.Field2867.Method2164750();
                    continue;
                }
                if (!this.Field2856.getValue().booleanValue()) break;
                this.Method2150391();
                if (bl) {
                    AutoTrapK2.Field2811.player.inventory.currentItem = n2;
                    AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                }
                return;
            }
            if (bl3) {
                AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapK2.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) AutoTrapK2.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl) {
                AutoTrapK2.Field2811.player.inventory.currentItem = n2;
                AutoTrapK2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            }
        }
    }

    private boolean Method2161383(BlockPos blockPos, boolean bl) {
        return InteractionUtil.Method2163757(blockPos, bl) && !Field2874.containsKey((Object) blockPos);
    }

    private BlockPos Method2161384(BlockPos blockPos) {
        BlockPos blockPos2;
        double d;
        double d2;
        BlockPos blockPos3;
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d2 = 0.0;
            if (this.Method2161383(blockPos.offset(enumFacing).down(), true) && (d = AutoTrapK2.Field2811.player.getDistance((double) (blockPos2 = blockPos.offset(enumFacing).down()).getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5)) >= d2) {
                blockPos3 = blockPos2;
                d2 = d;
            }
            if (blockPos3 == null) continue;
            return blockPos3;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            blockPos3 = null;
            d2 = 0.0;
            if (this.Method2161383(blockPos.offset(enumFacing), false) && (d = AutoTrapK2.Field2811.player.getDistance((double) (blockPos2 = blockPos.offset(enumFacing)).getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5)) >= d2) {
                blockPos3 = blockPos2;
                d2 = d;
            }
            if (blockPos3 == null) continue;
            return blockPos3;
        }
        Block block = EnumFacing.HORIZONTALS;
        int n2 = ((EnumFacing[]) block).length;
        for (int j = 0; j < n2; ++j) {
            EnumFacing enumFacing;
            enumFacing = block[j];
            blockPos3 = null;
            d2 = 0.0;
            if (this.Method2161383(blockPos.up().offset(enumFacing), false) && (d = AutoTrapK2.Field2811.player.getDistance((double) (blockPos2 = blockPos.up().offset(enumFacing)).getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5)) >= d2) {
                blockPos3 = blockPos2;
                d2 = d;
            }
            if (blockPos3 == null) continue;
            return blockPos3;
        }
        if (this.Field2853.getValue().booleanValue() && ((block = AutoTrapK2.Field2811.world.getBlockState(blockPos.up().up()).getBlock()) instanceof BlockAir || block instanceof BlockLiquid)) {
            if (this.Method2161383(blockPos.up().up(), false)) {
                return blockPos.up().up();
            }
            BlockPos blockPos4 = blockPos.up().up().offset(EnumFacing.byHorizontalIndex((int) (MathHelper.floor((double) ((double) (AutoTrapK2.Field2811.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3)));
            if (this.Method2161383(blockPos4, false)) {
                return blockPos4;
            }
        }
        return null;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (AutoTrapK2.Field2811.world == null || AutoTrapK2.Field2811.player == null) {
            return;
        }
        if (this.Field2868 != null && !this.Field2867.Method2164740(500.0)) {
            RenderUtil.Method2163908(this.Field2868, this.Field2860.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2861.getValue(), this.Field2862.getValue(), this.Field2863.getValue(), this.Field2864.getValue()), true, this.Field2860.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2861.getValue(), this.Field2862.getValue(), this.Field2863.getValue(), this.Field2864.getValue()), 1.2f, true, true, this.Field2865.getValue(), true);
        }
    }

    private int Method2161385() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = AutoTrapK2.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockObsidian))
                continue;
            n2 = j;
            break;
        }
        return n2;
    }

    private EntityPlayer Method2161386() {
        Stream stream = AutoTrapK2.Field2811.world.playerEntities.stream();
        return stream.filter(AutoTrapK2::Method2161391).filter(AutoTrapK2::Method2161380).filter(this::Method2161389).filter(this::Method2161387).min(Comparator.comparing(AutoTrapK2::Method2161388)).orElse(null);
    }

    private boolean Method2161387(EntityPlayer entityPlayer) {
        BlockPos blockPos = new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ).down();
        Block block = AutoTrapK2.Field2811.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockAir) && !(block instanceof BlockLiquid);
    }

    private boolean Method2161389(EntityPlayer entityPlayer) {
        return AutoTrapK2.Field2811.player.getDistance((Entity) entityPlayer) < Math.max(this.Field2850.getValue().floatValue() - 1.0f, 1.0f);
    }
}

