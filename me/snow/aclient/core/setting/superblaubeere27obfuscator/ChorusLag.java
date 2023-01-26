

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketConfirmTeleport
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent$Finish
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent$Start
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.LinkedList;
import java.util.Queue;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChorusLag
        extends Module {
    public final Setting<Integer> Field2800 = this.Method2150366(new Setting<Integer>("Lag Delay", 18, 0, 500));
    int Field2801 = 0;
    int Field2802 = 0;
    boolean Field2803 = false;
    boolean Field2804 = false;
    boolean Field2805 = false;
    double Field2806;
    double Field2807;
    double Field2808;
    Queue<CPacketPlayer> Field2809 = new LinkedList<CPacketPlayer>();
    Queue<CPacketConfirmTeleport> Field2810 = new LinkedList<CPacketConfirmTeleport>();

    public ChorusLag() {
        super("ChorusLag", "Makes your teleport delayed serverside", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    @Override
    public void Method2150372() {
        this.Field2803 = false;
        this.Field2804 = false;
        this.Field2805 = false;
    }

    @Override
    public void Method2150379() {
        if (this.Field2803) {
            ++this.Field2801;
            ++this.Field2802;
            if (!ChorusLag.Field2811.player.getPosition().equals((Object) new BlockPos(this.Field2806, this.Field2807, this.Field2808)) && !this.Field2805 && ChorusLag.Field2811.player.getDistance(this.Field2806, this.Field2807, this.Field2808) > 1.0) {
                ChorusLag.Field2811.player.setPosition(this.Field2806, this.Field2807, this.Field2808);
                this.Field2805 = true;
            }
        }
        if (this.Field2803 && this.Field2802 > this.Field2800.getValue()) {
            this.Field2803 = false;
            this.Field2801 = 0;
            this.Field2804 = true;
            this.Field2802 = 0;
            this.Method2162225();
        }
        if (this.Field2802 == this.Field2800.getValue() - 40) {
            Command.Method2159696("Chorusing In 2 seconds");
        }
    }

    public void Method2162225() {
        while (!this.Field2809.isEmpty()) {
            ChorusLag.Field2811.player.connection.sendPacket((Packet) this.Field2809.poll());
        }
        while (!this.Field2810.isEmpty()) {
            ChorusLag.Field2811.player.connection.sendPacket((Packet) this.Field2810.poll());
        }
        this.Field2804 = false;
        this.Field2802 = 0;
        this.Field2803 = false;
    }

    @SubscribeEvent
    public void Method2162226(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
    }

    @SubscribeEvent
    public void Method2162227(LivingEntityUseItemEvent.Finish finish) {
        if (finish.getEntity() == ChorusLag.Field2811.player && finish.getResultStack().getItem().equals((Object) Items.CHORUS_FRUIT)) {
            this.Field2806 = ChorusLag.Field2811.player.posX;
            this.Field2807 = ChorusLag.Field2811.player.posY;
            this.Field2808 = ChorusLag.Field2811.player.posZ;
            this.Field2805 = false;
            this.Field2803 = true;
        }
    }

    @SubscribeEvent
    public void Method2162228(LivingEntityUseItemEvent.Start start) {
    }

    @SubscribeEvent
    public void Method2162229(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketConfirmTeleport && this.Field2803 && this.Field2802 < this.Field2800.getValue()) {
            this.Field2810.add((CPacketConfirmTeleport) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayer && this.Field2803 && this.Field2802 < this.Field2800.getValue()) {
            this.Field2809.add((CPacketPlayer) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
        }
    }
}

