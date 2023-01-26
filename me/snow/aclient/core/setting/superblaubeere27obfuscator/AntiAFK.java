

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketTabComplete
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Random;
import java.util.UUID;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class AntiAFK
        extends Module {
    private final Random Field2578;
    private final Setting<Boolean> Field2579 = this.Method2150366(new Setting<Boolean>("Swing", true));
    private final Setting<Boolean> Field2580 = this.Method2150366(new Setting<Boolean>("Turn", true));
    private final Setting<Boolean> Field2581 = this.Method2150366(new Setting<Boolean>("Jump", true));
    private final Setting<Boolean> Field2582 = this.Method2150366(new Setting<Boolean>("Sneak", true));
    private final Setting<Boolean> Field2583 = this.Method2150366(new Setting<Boolean>("InteractBlock", false));
    private final Setting<Boolean> Field2584 = this.Method2150366(new Setting<Boolean>("TabComplete", true));
    private final Setting<Boolean> Field2585 = this.Method2150366(new Setting<Boolean>("ChatMsgs", true));
    private final Setting<Boolean> Field2586 = this.Method2150366(new Setting<Boolean>("Stats", true));
    private final Setting<Boolean> Field2587 = this.Method2150366(new Setting<Boolean>("WindowClick", true));
    private final Setting<Boolean> Field2588 = this.Method2150366(new Setting<Boolean>("ItemSwap", true));
    private final Setting<Boolean> Field2589 = this.Method2150366(new Setting<Boolean>("HitBlock", true));
    private final Setting<Boolean> Field2590 = this.Method2150366(new Setting<Boolean>("Move", true));

    public AntiAFK() {
        super("AntiAFK", "Attempts to stop the server from kicking u when ur afk.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
        this.Field2578 = new Random();
    }

    @Override
    public void Method2150379() {
        BlockPos blockPos;
        if (AntiAFK.Field2811.player.ticksExisted % 45 == 0 && this.Field2579.getValue().booleanValue()) {
            AntiAFK.Field2811.player.swingArm(EnumHand.MAIN_HAND);
        }
        if (AntiAFK.Field2811.player.ticksExisted % 20 == 0 && this.Field2580.getValue().booleanValue()) {
            AntiAFK.Field2811.player.rotationYaw = this.Field2578.nextInt(360) - 180;
        }
        if (AntiAFK.Field2811.player.ticksExisted % 60 == 0 && this.Field2581.getValue().booleanValue() && AntiAFK.Field2811.player.onGround) {
            AntiAFK.Field2811.player.jump();
        }
        if (AntiAFK.Field2811.player.ticksExisted % 50 == 0 && this.Field2582.getValue().booleanValue() && !AntiAFK.Field2811.player.isSneaking()) {
            AntiAFK.Field2811.player.movementInput.sneak = true;
        }
        if ((double) AntiAFK.Field2811.player.ticksExisted % 52.5 == 0.0 && this.Field2582.getValue().booleanValue() && AntiAFK.Field2811.player.isSneaking()) {
            AntiAFK.Field2811.player.movementInput.sneak = false;
        }
        if (AntiAFK.Field2811.player.ticksExisted % 30 == 0 && this.Field2583.getValue().booleanValue() && !AntiAFK.Field2811.world.isAirBlock(blockPos = AntiAFK.Field2811.objectMouseOver.getBlockPos())) {
            AntiAFK.Field2811.playerController.clickBlock(blockPos, AntiAFK.Field2811.objectMouseOver.sideHit);
        }
        if (AntiAFK.Field2811.player.ticksExisted % 80 == 0 && this.Field2584.getValue().booleanValue() && !AntiAFK.Field2811.player.isDead) {
            AntiAFK.Field2811.player.connection.sendPacket((Packet) new CPacketTabComplete("/" + UUID.randomUUID().toString().replace('-', 'v'), AntiAFK.Field2811.player.getPosition(), false));
        }
        if (AntiAFK.Field2811.player.ticksExisted % 200 == 0 && this.Field2585.getValue().booleanValue() && !AntiAFK.Field2811.player.isDead) {
            AntiAFK.Field2811.player.sendChatMessage("Alice AntiAFK " + this.Field2578.nextInt());
        }
        if (AntiAFK.Field2811.player.ticksExisted % 300 == 0 && this.Field2586.getValue().booleanValue() && !AntiAFK.Field2811.player.isDead) {
            AntiAFK.Field2811.player.sendChatMessage("/stats");
        }
        if (AntiAFK.Field2811.player.ticksExisted % 125 == 0 && this.Field2587.getValue().booleanValue() && !AntiAFK.Field2811.player.isDead) {
            AntiAFK.Field2811.player.connection.sendPacket((Packet) new CPacketClickWindow(1, 1, 1, ClickType.CLONE, new ItemStack(Blocks.OBSIDIAN), 1));
        }
        if (AntiAFK.Field2811.player.ticksExisted % 70 == 0 && this.Field2588.getValue().booleanValue() && !AntiAFK.Field2811.player.isDead) {
            AntiAFK.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.SWAP_HELD_ITEMS, AntiAFK.Field2811.player.getPosition(), EnumFacing.DOWN));
        }
        if (AntiAFK.Field2811.player.ticksExisted % 50 == 0 && this.Field2589.getValue().booleanValue()) {
            AntiAFK.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, AntiAFK.Field2811.player.getPosition(), EnumFacing.DOWN));
        }
        if (AntiAFK.Field2811.player.ticksExisted % 150 == 0 && this.Field2590.getValue().booleanValue()) {
            AntiAFK.Field2811.gameSettings.keyBindForward.pressed = true;
            AntiAFK.Field2811.gameSettings.keyBindBack.pressed = true;
            AntiAFK.Field2811.gameSettings.keyBindRight.pressed = true;
            AntiAFK.Field2811.gameSettings.keyBindLeft.pressed = true;
        }
    }
}

