

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockInteractionHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;

public class InstantBurrow
        extends Module {
    float Field3496;
    private Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3488 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("BurrowMode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NormalBurrow));
    public Setting<Boolean> Field3489 = this.Method2150366(new Setting<Boolean>("Rotate", Boolean.valueOf(true), this::Method2161872));
    public Setting<Boolean> Field3490 = this.Method2150366(new Setting<Boolean>("Silent", Boolean.valueOf(true), this::Method2161871));
    public Setting<Boolean> Field3491 = this.Method2150366(new Setting<Boolean>("EnderChest", Boolean.valueOf(true), this::Method2161860));
    public Setting<Double> Field3492 = this.Method2150366(new Setting<Object>("Height", Double.valueOf(1.5), Double.valueOf(-5.0), Double.valueOf(10.0), this::Method2161869));
    public Setting<Boolean> Field3493 = this.Method2150366(new Setting<Boolean>("5bRotate", Boolean.valueOf(false), this::Method2161868));
    public Setting<Boolean> Field3494 = this.Method2150366(new Setting<Boolean>("5bSilent", Boolean.valueOf(true), this::Method2161867));
    public Setting<Integer> Field3495 = this.Method2150366(new Setting<Object>("5bHeight", Integer.valueOf(2), Integer.valueOf(-30), Integer.valueOf(30), this::Method2161866));

    public InstantBurrow() {
        super("InstantBurrow", "Lags you into a block instantly.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, true);
        this.Field3496 = InstantBurrow.Field2811.timer.tickLength;
    }

    public static int Method2161865(Block block) {
        for (int j = 0; j < 9; ++j) {
            Item item = InstantBurrow.Field2811.player.inventory.getStackInSlot(j).getItem();
            if (!(item instanceof ItemBlock) || !((ItemBlock) item).getBlock().equals((Object) block)) continue;
            return j;
        }
        return -1;
    }

    @Override
    public void Method2150389() {
        BlockPos blockPos;
        int n2;
        if (this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NormalBurrow) {
            if (InstantBurrow.Field2811.player == null || InstantBurrow.Field2811.world == null) {
                return;
            }
            n2 = InstantBurrow.Field2811.player.inventory.currentItem;
            this.Field3496 = InstantBurrow.Field2811.timer.tickLength;
            blockPos = new BlockPos(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY, InstantBurrow.Field2811.player.posZ);
            if (InstantBurrow.Field2811.world.getBlockState(new BlockPos(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY, InstantBurrow.Field2811.player.posZ)).getBlock().equals((Object) Blocks.OBSIDIAN) || InstantBurrow.Field2811.world.getBlockState(new BlockPos(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY, InstantBurrow.Field2811.player.posZ)).getBlock().equals((Object) Blocks.ENDER_CHEST)) {
                Command.Method2159696("Bro ur already in burrow");
                this.Method2150380();
                return;
            }
            if (BlockInteractionHelper.Method2162767(blockPos)) {
                Command.Method2159696("Ur intercepting with another creature.");
                this.Method2150380();
                return;
            }
            if (InstantBurrow.Method2161865(Blocks.OBSIDIAN) == -1 && InstantBurrow.Method2161865(Blocks.ENDER_CHEST) == -1) {
                Command.Method2159696("U need echest or obsidian.");
                this.Method2150380();
                return;
            }
            if (!(InstantBurrow.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) && InstantBurrow.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR) && InstantBurrow.Field2811.world.getBlockState(blockPos.add(0, 3, 0)).getBlock().equals((Object) Blocks.AIR))) {
                Command.Method2159696("need some space!");
                this.Method2150380();
                return;
            }
            if (Field2811.isSingleplayer()) {
                Command.Method2159696("Why are u trying this in singleplayer?");
                this.Method2150380();
                return;
            }
            if (this.Field3490.getValue().booleanValue()) {
                InstantBurrow.Field2811.timer.tickLength = 1.0f;
            }
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 0.41999998688698, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 0.7531999805211997, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 1.00133597911214, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 1.16610926093821, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.setPosition(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 1.16610926093821, InstantBurrow.Field2811.player.posZ);
            InstantBurrow.Field2811.player.inventory.currentItem = this.Field3491.getValue() != false && InstantBurrow.Method2161865(Blocks.ENDER_CHEST) != -1 ? InstantBurrow.Method2161865(Blocks.ENDER_CHEST) : (InstantBurrow.Method2161865(Blocks.OBSIDIAN) != -1 ? InstantBurrow.Method2161865(Blocks.OBSIDIAN) : InstantBurrow.Method2161865(Blocks.ENDER_CHEST));
            BlockInteractionHelper.Method2162760(blockPos, this.Field3489.getValue(), true, false, true, false);
            InstantBurrow.Field2811.player.inventory.currentItem = n2;
            InstantBurrow.Field2811.player.setPosition(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY - 1.16610926093821, InstantBurrow.Field2811.player.posZ);
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + this.Field3492.getValue(), InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.timer.tickLength = this.Field3496;
            this.Method2150380();
        }
        if (this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FiveBeeBypass) {
            if (InstantBurrow.Field2811.player == null || InstantBurrow.Field2811.world == null) {
                return;
            }
            n2 = InstantBurrow.Field2811.player.inventory.currentItem;
            this.Field3496 = InstantBurrow.Field2811.timer.tickLength;
            blockPos = new BlockPos(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY, InstantBurrow.Field2811.player.posZ);
            if (InstantBurrow.Field2811.world.getBlockState(new BlockPos(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY, InstantBurrow.Field2811.player.posZ)).getBlock().equals((Object) Blocks.PISTON)) {
                Command.Method2159696("Bro ur already in burrow");
                this.Method2150380();
                return;
            }
            if (BlockInteractionHelper.Method2162767(blockPos)) {
                Command.Method2159696("Ur intercepting with another creature.");
                this.Method2150380();
                return;
            }
            if (InstantBurrow.Method2161865((Block) Blocks.PISTON) == -1) {
                Command.Method2159696("U need piston");
                this.Method2150380();
                return;
            }
            if (!(InstantBurrow.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock().equals((Object) Blocks.AIR) && InstantBurrow.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock().equals((Object) Blocks.AIR) && InstantBurrow.Field2811.world.getBlockState(blockPos.add(0, 3, 0)).getBlock().equals((Object) Blocks.AIR))) {
                Command.Method2159696("need some space!");
                this.Method2150380();
                return;
            }
            if (Field2811.isSingleplayer()) {
                Command.Method2159696("Why are u trying this in singleplayer?");
                this.Method2150380();
                return;
            }
            if (this.Field3494.getValue().booleanValue()) {
                InstantBurrow.Field2811.timer.tickLength = 1.0f;
            }
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 0.41999998688698, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 0.7531999805211997, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 1.00133597911214, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 1.16610926093821, InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.player.setPosition(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + 1.16610926093821, InstantBurrow.Field2811.player.posZ);
            if (InstantBurrow.Method2161865((Block) Blocks.PISTON) != -1) {
                InstantBurrow.Field2811.player.inventory.currentItem = InstantBurrow.Method2161865((Block) Blocks.PISTON);
            }
            BlockInteractionHelper.Method2162760(blockPos, this.Field3493.getValue(), true, false, true, false);
            InstantBurrow.Field2811.player.inventory.currentItem = n2;
            InstantBurrow.Field2811.player.setPosition(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY - 1.16610926093821, InstantBurrow.Field2811.player.posZ);
            InstantBurrow.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(InstantBurrow.Field2811.player.posX, InstantBurrow.Field2811.player.posY + (double) this.Field3495.getValue().intValue(), InstantBurrow.Field2811.player.posZ, true));
            InstantBurrow.Field2811.timer.tickLength = this.Field3496;
            this.Method2150380();
        }
    }

    private boolean Method2161866(Object object) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FiveBeeBypass;
    }

    private boolean Method2161867(Boolean bl) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FiveBeeBypass;
    }

    private boolean Method2161868(Boolean bl) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FiveBeeBypass;
    }

    private boolean Method2161869(Object object) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NormalBurrow;
    }

    private boolean Method2161860(Boolean bl) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NormalBurrow;
    }

    private boolean Method2161871(Boolean bl) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NormalBurrow;
    }

    private boolean Method2161872(Boolean bl) {
        return this.Field3488.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NormalBurrow;
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        FiveBeeBypass,
        NormalBurrow;

    }
}

