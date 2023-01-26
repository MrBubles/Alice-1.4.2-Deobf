

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Nuker
        extends Module {
    private final Timer Field3435 = new Timer();
    private final Setting<Boolean> Field3436 = this.Method2150366(new Setting<Boolean>("AutoSwitch", false));
    public Setting<Boolean> Field3437 = this.Method2150366(new Setting<Boolean>("Rotate", false));
    public Setting<Float> Field3438 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(10.0f)));
    public Setting<Integer> Field3439 = this.Method2150366(new Setting<Integer>("Blocks/Attack", 50, 1, 100));
    public Setting<Integer> Field3440 = this.Method2150366(new Setting<Integer>("Delay/Attack", 50, 1, 1000));
    public Setting<Boolean> Field3441 = this.Method2150366(new Setting<Boolean>("Nuke", false));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3442 = this.Method2150366(new Setting<Object>("Mode", (Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NUKE, this::Method2161919));
    public Setting<Boolean> Field3443 = this.Method2150366(new Setting<Boolean>("AntiRegear", false));
    public Setting<Boolean> Field3444 = this.Method2150366(new Setting<Boolean>("HopperAura", false));
    private int Field3445 = -1;
    private boolean Field3446;
    private Block Field3447;

    public Nuker() {
        super("Nuker", "Mines many blocks.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @Override
    public void Method2150374() {
        this.Field3447 = null;
    }

    @SubscribeEvent
    public void Method2161912(BlockEvent blockEvent) {
        Block block;
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 3 && (this.Field3442.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SELECTION || this.Field3442.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NUKE) && (block = Nuker.Field2811.world.getBlockState(blockEvent.Field3432).getBlock()) != null && block != this.Field3447) {
            this.Field3447 = block;
            blockEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void Method2161913(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            Object object;
            if (this.Field3441.getValue().booleanValue()) {
                object = null;
                switch (1.F ield2346[this.Field3442.getValue().ordinal()]){
                    case 1:
                    case 2: {
                        object = this.Method2161918();
                        break;
                    }
                    case 3: {
                        object = this.Method2161917();
                    }
                }
                if (object != null) {
                    if (this.Field3442.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SELECTION || this.Field3442.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL) {
                        if (this.Field3437.getValue().booleanValue()) {
                            float[] arrf = MathUtil.Method2163871(Nuker.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) ((float) object.getX() + 0.5f), (double) ((float) object.getY() + 0.5f), (double) ((float) object.getZ() + 0.5f)));
                            AliceMain.Field760.Method2150278(arrf[0], arrf[1]);
                        }
                        if (this.Method2161915((BlockPos) object)) {
                            Nuker.Field2811.playerController.onPlayerDamageBlock((BlockPos) object, Nuker.Field2811.player.getHorizontalFacing());
                            Nuker.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                        }
                    } else {
                        for (int j = 0; j < this.Field3439.getValue(); ++j) {
                            object = this.Method2161918();
                            if (object == null) continue;
                            if (this.Field3437.getValue().booleanValue()) {
                                float[] arrf = MathUtil.Method2163871(Nuker.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) ((float) object.getX() + 0.5f), (double) ((float) object.getY() + 0.5f), (double) ((float) object.getZ() + 0.5f)));
                                AliceMain.Field760.Method2150278(arrf[0], arrf[1]);
                            }
                            if (!this.Field3435.Method2164755(this.Field3440.getValue().intValue())) continue;
                            Nuker.Field2811.playerController.onPlayerDamageBlock((BlockPos) object, Nuker.Field2811.player.getHorizontalFacing());
                            Nuker.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                            this.Field3435.Method2164750();
                        }
                    }
                }
            }
            if (this.Field3443.getValue().booleanValue()) {
                this.Method2161914(BlockUtil.Field577);
            }
            if (this.Field3444.getValue().booleanValue()) {
                object = new ArrayList();
                ((ArrayList) object).add(Blocks.HOPPER);
                this.Method2161914((List<Block>) object);
            }
        }
    }

    public void Method2161914(List<Block> list) {
        BlockPos blockPos = this.Method2161916(list);
        if (blockPos != null) {
            if (!this.Field3446) {
                this.Field3445 = Nuker.Field2811.player.inventory.currentItem;
                this.Field3446 = true;
            }
            if (this.Field3437.getValue().booleanValue()) {
                float[] arrf = MathUtil.Method2163871(Nuker.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() + 0.5f), (double) ((float) blockPos.getZ() + 0.5f)));
                AliceMain.Field760.Method2150278(arrf[0], arrf[1]);
            }
            if (this.Method2161915(blockPos)) {
                if (this.Field3436.getValue().booleanValue()) {
                    int n2 = -1;
                    for (int j = 0; j < 9; ++j) {
                        ItemStack itemStack = Nuker.Field2811.player.inventory.getStackInSlot(j);
                        if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemPickaxe)) continue;
                        n2 = j;
                        break;
                    }
                    if (n2 != -1) {
                        Nuker.Field2811.player.inventory.currentItem = n2;
                    }
                }
                Nuker.Field2811.playerController.onPlayerDamageBlock(blockPos, Nuker.Field2811.player.getHorizontalFacing());
                Nuker.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            }
        } else if (this.Field3436.getValue().booleanValue() && this.Field3445 != -1) {
            Nuker.Field2811.player.inventory.currentItem = this.Field3445;
            this.Field3445 = -1;
            this.Field3446 = false;
        }
    }

    private boolean Method2161915(BlockPos blockPos) {
        IBlockState iBlockState = Nuker.Field2811.world.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getBlockHardness(iBlockState, (World) Nuker.Field2811.world, blockPos) != -1.0f;
    }

    private BlockPos Method2161916(List<Block> list) {
        double d = MathUtil.Method2163857(this.Field3438.getValue().floatValue());
        BlockPos blockPos = null;
        for (double d2 = d; d2 >= -d; d2 -= 1.0) {
            for (double d3 = d; d3 >= -d; d3 -= 1.0) {
                for (double d4 = d; d4 >= -d; d4 -= 1.0) {
                    BlockPos blockPos2 = new BlockPos(Nuker.Field2811.player.posX + d2, Nuker.Field2811.player.posY + d3, Nuker.Field2811.player.posZ + d4);
                    double d5 = Nuker.Field2811.player.getDistanceSq((double) blockPos2.getX(), (double) blockPos2.getY(), (double) blockPos2.getZ());
                    if (!(d5 <= d) || !list.contains((Object) Nuker.Field2811.world.getBlockState(blockPos2).getBlock()) || !this.Method2161915(blockPos2))
                        continue;
                    d = d5;
                    blockPos = blockPos2;
                }
            }
        }
        return blockPos;
    }

    private BlockPos Method2161917() {
        float f = this.Field3438.getValue().floatValue();
        BlockPos blockPos = null;
        for (float f2 = f; f2 >= -f; f2 -= 1.0f) {
            for (float f3 = f; f3 >= -f; f3 -= 1.0f) {
                for (float f4 = f; f4 >= -f; f4 -= 1.0f) {
                    BlockPos blockPos2 = new BlockPos(Nuker.Field2811.player.posX + (double) f2, Nuker.Field2811.player.posY + (double) f3, Nuker.Field2811.player.posZ + (double) f4);
                    double d = Nuker.Field2811.player.getDistance((double) blockPos2.getX(), (double) blockPos2.getY(), (double) blockPos2.getZ());
                    if (!(d <= (double) f) || Nuker.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || Nuker.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid || !this.Method2161915(blockPos2) || !((double) blockPos2.getY() >= Nuker.Field2811.player.posY))
                        continue;
                    f = (float) d;
                    blockPos = blockPos2;
                }
            }
        }
        return blockPos;
    }

    private BlockPos Method2161918() {
        float f = this.Field3438.getValue().floatValue();
        BlockPos blockPos = null;
        for (float f2 = f; f2 >= -f; f2 -= 1.0f) {
            for (float f3 = f; f3 >= -f; f3 -= 1.0f) {
                for (float f4 = f; f4 >= -f; f4 -= 1.0f) {
                    BlockPos blockPos2 = new BlockPos(Nuker.Field2811.player.posX + (double) f2, Nuker.Field2811.player.posY + (double) f3, Nuker.Field2811.player.posZ + (double) f4);
                    double d = Nuker.Field2811.player.getDistance((double) blockPos2.getX(), (double) blockPos2.getY(), (double) blockPos2.getZ());
                    if (!(d <= (double) f) || Nuker.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || Nuker.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid || Nuker.Field2811.world.getBlockState(blockPos2).getBlock() != this.Field3447 || !this.Method2161915(blockPos2) || !((double) blockPos2.getY() >= Nuker.Field2811.player.posY))
                        continue;
                    f = (float) d;
                    blockPos = blockPos2;
                }
            }
        }
        return blockPos;
    }

    private boolean Method2161919(Object object) {
        return this.Field3441.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        SELECTION,
        ALL,
        NUKE;

    }
}

