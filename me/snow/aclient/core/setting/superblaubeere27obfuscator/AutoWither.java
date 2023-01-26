

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockSoulSand
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class AutoWither
        extends Module {
    public Setting<Boolean> Field1953 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    public Setting<Boolean> Field1954 = this.Method2150366(new Setting<Boolean>("Triggerable", true));
    public Setting<Integer> Field1955 = this.Method2150366(new Setting<Integer>("Range", 5, 2, 10));
    public Setting<Integer> Field1956 = this.Method2150366(new Setting<Integer>("Block/Place", 3, 1, 5));
    public Setting<Integer> Field1957 = this.Method2150366(new Setting<Integer>("Delay", 15, 1, 30));
    private BlockPos Field1958;
    private boolean Field1959;
    private boolean Field1960;
    private int Field1961;
    private int Field1962;
    private int Field1963;
    private int Field1964;
    private boolean Field1965 = false;

    public AutoWither() {
        super("AutoWither", "Automatically places and spawns wither", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    private static EnumFacing Method2161831(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!AutoWither.Field2811.world.getBlockState(blockPos2).getBlock().canCollideCheck(AutoWither.Field2811.world.getBlockState(blockPos2), false) || (iBlockState = AutoWither.Field2811.world.getBlockState(blockPos2)).getMaterial().isReplaceable() || iBlockState.getBlock() instanceof BlockTallGrass || iBlockState.getBlock() instanceof BlockDeadBush)
                continue;
            return enumFacing;
        }
        return null;
    }

    @Override
    public void Method2150372() {
        if (AutoWither.Field2811.player == null) {
            this.Method2150391();
            return;
        }
        this.Field1963 = 1;
        this.Field1964 = 1;
        this.Field1965 = false;
    }

    @Override
    public void Method2150379() {
        if (this.Field1963 == 1) {
            InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
            if (this.Field1965) {
                this.Field1965 = false;
            } else {
                this.Field1959 = false;
                this.Field1960 = false;
                if (!this.Method2161834()) {
                    this.Method2150391();
                    return;
                }
                List<BlockPos> list = AliceAura.Method2150785(AutoWither.Field2811.player.getPosition().down(), this.Field1955.getValue().intValue(), this.Field1955.getValue(), false, true, 0);
                boolean bl = true;
                for (BlockPos blockPos : list) {
                    this.Field1958 = blockPos.down();
                    if (!this.Method2161832()) continue;
                    bl = false;
                    break;
                }
                if (bl) {
                    if (this.Field1954.getValue().booleanValue()) {
                        this.Method2150391();
                    }
                    return;
                }
            }
            if (AutoWither.Field2811.player.inventory.currentItem != this.Field1961) {
                AutoWither.Field2811.player.inventory.currentItem = this.Field1961;
                AutoWither.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field1961));
            }
            int n2 = 0;
            for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161826()) {
                if (!InteractionUtil.Method2163759(this.Field1958.add((Vec3i) blockPos), false, true) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(this.Field1958.add((Vec3i) blockPos), this.Field1953.getValue(), true)) == null)
                    continue;
                InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, false);
                if (++n2 < this.Field1956.getValue()) continue;
                this.Field1965 = true;
                return;
            }
            if (this.Field1959) {
                for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161827()) {
                    if (!InteractionUtil.Method2163759(this.Field1958.add((Vec3i) blockPos), false, true) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(this.Field1958.add((Vec3i) blockPos), this.Field1953.getValue(), true)) == null)
                        continue;
                    InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, false);
                    if (++n2 < this.Field1956.getValue()) continue;
                    this.Field1965 = true;
                    return;
                }
            } else if (this.Field1960) {
                for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161828()) {
                    if (!InteractionUtil.Method2163759(this.Field1958.add((Vec3i) blockPos), false, true) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(this.Field1958.add((Vec3i) blockPos), this.Field1953.getValue(), true)) == null)
                        continue;
                    InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, false);
                    if (++n2 < this.Field1956.getValue()) continue;
                    this.Field1965 = true;
                    return;
                }
            }
            this.Field1963 = 2;
        } else if (this.Field1963 == 2) {
            if (AutoWither.Field2811.player.inventory.currentItem != this.Field1962) {
                AutoWither.Field2811.player.inventory.currentItem = this.Field1962;
                AutoWither.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field1962));
            }
            int n3 = 0;
            if (this.Field1959) {
                for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161829()) {
                    InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                    if (!InteractionUtil.Method2163759(this.Field1958.add((Vec3i) blockPos), false, true) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(this.Field1958.add((Vec3i) blockPos), this.Field1953.getValue(), true)) == null)
                        continue;
                    InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, false);
                    if (++n3 < this.Field1956.getValue()) continue;
                    return;
                }
            } else if (this.Field1960) {
                for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161820()) {
                    InteractionUtil.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
                    if (!InteractionUtil.Method2163759(this.Field1958.add((Vec3i) blockPos), false, true) || (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = InteractionUtil.Method2163751(this.Field1958.add((Vec3i) blockPos), this.Field1953.getValue(), true)) == null)
                        continue;
                    InteractionUtil.Method2163755(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll, EnumHand.MAIN_HAND, false);
                    if (++n3 < this.Field1956.getValue()) continue;
                    return;
                }
            }
            if (this.Field1954.getValue().booleanValue()) {
                this.Method2150391();
            }
            this.Field1963 = 3;
        } else if (this.Field1963 == 3) {
            if (this.Field1964 < this.Field1957.getValue()) {
                ++this.Field1964;
            } else {
                this.Field1964 = 1;
                this.Field1963 = 1;
            }
        }
    }

    private boolean Method2161832() {
        boolean bl = true;
        this.Field1959 = true;
        this.Field1960 = true;
        boolean bl2 = false;
        if (AutoWither.Field2811.world.getBlockState(this.Field1958) == null) {
            return false;
        }
        Block block = AutoWither.Field2811.world.getBlockState(this.Field1958).getBlock();
        if (block instanceof BlockTallGrass || block instanceof BlockDeadBush) {
            bl2 = true;
        }
        if (AutoWither.Method2161831(this.Field1958.up()) == null) {
            return false;
        }
        for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161826()) {
            if (!this.Method2161833(this.Field1958.add((Vec3i) blockPos))) continue;
            bl = false;
        }
        for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161827()) {
            if (!this.Method2161833(this.Field1958.add((Vec3i) blockPos)) && !this.Method2161833(this.Field1958.add((Vec3i) blockPos.down())))
                continue;
            this.Field1959 = false;
        }
        for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161828()) {
            if (!this.Method2161833(this.Field1958.add((Vec3i) blockPos)) && !this.Method2161833(this.Field1958.add((Vec3i) blockPos.down())))
                continue;
            this.Field1960 = false;
        }
        for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161829()) {
            if (!this.Method2161833(this.Field1958.add((Vec3i) blockPos))) continue;
            this.Field1959 = false;
        }
        for (BlockPos blockPos : IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2161820()) {
            if (!this.Method2161833(this.Field1958.add((Vec3i) blockPos))) continue;
            this.Field1960 = false;
        }
        return !bl2 && bl && (this.Field1959 || this.Field1960);
    }

    private boolean Method2161833(BlockPos blockPos) {
        Block block = AutoWither.Field2811.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir)) {
            return true;
        }
        for (Entity entity : AutoWither.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
            if (entity instanceof EntityItem || entity instanceof EntityXPOrb) continue;
            return true;
        }
        return false;
    }

    private boolean Method2161834() {
        this.Field1962 = -1;
        this.Field1961 = -1;
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = AutoWither.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY) continue;
            if (itemStack.getItem() == Items.SKULL && itemStack.getItemDamage() == 1) {
                if (AutoWither.Field2811.player.inventory.getStackInSlot(j).getCount() < 3) continue;
                this.Field1962 = j;
                continue;
            }
            if (!(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockSoulSand) || AutoWither.Field2811.player.inventory.getStackInSlot(j).getCount() < 4)
                continue;
            this.Field1961 = j;
        }
        return this.Field1961 != -1 && this.Field1962 != -1;
    }

    private static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private static final BlockPos[] Field1449 = new BlockPos[]{new BlockPos(0, 1, 0), new BlockPos(0, 2, 0)};
        private static final BlockPos[] Field1450 = new BlockPos[]{new BlockPos(-1, 2, 0), new BlockPos(1, 2, 0)};
        private static final BlockPos[] Field1451 = new BlockPos[]{new BlockPos(0, 2, -1), new BlockPos(0, 2, 1)};
        private static final BlockPos[] Field1452 = new BlockPos[]{new BlockPos(0, 3, 0), new BlockPos(-1, 3, 0), new BlockPos(1, 3, 0)};
        private static final BlockPos[] Field1453 = new BlockPos[]{new BlockPos(0, 3, 0), new BlockPos(0, 3, -1), new BlockPos(0, 3, 1)};
        private static final BlockPos[] Field1454 = new BlockPos[]{new BlockPos(0, 3, 0)};

        private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
        }

        static BlockPos[] Method2161826() {
            return Field1449;
        }

        static BlockPos[] Method2161827() {
            return Field1450;
        }

        static BlockPos[] Method2161828() {
            return Field1451;
        }

        static BlockPos[] Method2161829() {
            return Field1452;
        }

        static BlockPos[] Method2161820() {
            return Field1453;
        }
    }
}

