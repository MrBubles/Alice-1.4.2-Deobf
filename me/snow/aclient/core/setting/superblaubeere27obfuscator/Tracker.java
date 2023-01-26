

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ConnectionEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DeathEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Tracker
        extends Module {
    private static Tracker Field4685;
    private final Timer Field4686 = new Timer();
    private final Set<BlockPos> Field4687 = new HashSet<BlockPos>();
    public Setting<Boolean> Field4688 = this.Method2150366(new Setting<Boolean>("AutoEnable", false));
    public Setting<Boolean> Field4689 = this.Method2150366(new Setting<Boolean>("AutoDisable", true));
    private EntityPlayer Field4690;
    private int Field4691;
    private int Field4692;
    private int Field4693;
    private int Field4694;
    private boolean Field4695;

    public Tracker() {
        super("Tracker", "Tracks players in 1v1s. Only good in duels tho!", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, true);
        Field4685 = this;
    }

    public static Tracker Method2161958() {
        if (Field4685 == null) {
            Field4685 = new Tracker();
        }
        return Field4685;
    }

    @SubscribeEvent
    public void Method2161959(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (!Tracker.Method2150359() && (this.Field4688.getValue().booleanValue() || this.Field4689.getValue().booleanValue()) && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketChat) {
            SPacketChat sPacketChat = (SPacketChat) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            String string = sPacketChat.getChatComponent().getFormattedText();
            if (this.Field4688.getValue().booleanValue() && (string.contains("has accepted your duel request") || string.contains("Accepted the duel request from")) && !string.contains("<")) {
                Command.Method2159696("Tracker will enable in 5 seconds.");
                this.Field4686.Method2164750();
                this.Field4695 = true;
            } else if (this.Field4689.getValue().booleanValue() && string.contains("has defeated") && string.contains(Tracker.Field2811.player.getName()) && !string.contains("<")) {
                this.Method2150380();
            }
        }
    }

    @SubscribeEvent
    public void Method2161950(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (!Tracker.Method2150359() && this.Method2150386() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerTryUseItemOnBlock) {
            CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock = (CPacketPlayerTryUseItemOnBlock) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (Tracker.Field2811.player.getHeldItem(cPacketPlayerTryUseItemOnBlock.hand).getItem() == Items.END_CRYSTAL && !AutoCrystal.Field49.contains((Object) cPacketPlayerTryUseItemOnBlock.position)) {
                this.Field4687.add(cPacketPlayerTryUseItemOnBlock.position);
            }
        }
    }

    @SubscribeEvent
    public void Method2161961(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (this.Field4695 && this.Field4686.Method2164751(5.0) && this.Method2150387()) {
            this.Method2150389();
        }
    }

    @Override
    public void Method2150379() {
        if (this.Method2150387()) {
            return;
        }
        if (this.Field4690 == null) {
            this.Field4690 = EntityUtil.Method2163561(1000.0);
        } else {
            if (this.Field4692 != this.Field4691 / 64) {
                this.Field4692 = this.Field4691 / 64;
                Command.Method2159696((Object) ChatFormatting.WHITE + "<Tracker> " + (Object) ChatFormatting.DARK_PURPLE + this.Field4690.getName() + (Object) ChatFormatting.LIGHT_PURPLE + " used " + (Object) ChatFormatting.WHITE + this.Field4692 + (Object) ChatFormatting.LIGHT_PURPLE + " Stacks of EXP!");
            }
            if (this.Field4694 != this.Field4693 / 64) {
                this.Field4694 = this.Field4693 / 64;
                Command.Method2159696((Object) ChatFormatting.WHITE + "<Tracker> " + (Object) ChatFormatting.DARK_PURPLE + this.Field4690.getName() + (Object) ChatFormatting.LIGHT_PURPLE + " used: " + (Object) ChatFormatting.WHITE + this.Field4694 + (Object) ChatFormatting.LIGHT_PURPLE + " Stacks of Crystals!");
            }
        }
    }

    public void Method2161962(Entity entity) {
        if (this.Method2150387()) {
            return;
        }
        if (entity instanceof EntityExpBottle && Objects.equals((Object) Tracker.Field2811.world.getClosestPlayerToEntity(entity, 3.0), (Object) this.Field4690)) {
            ++this.Field4691;
        }
        if (entity instanceof EntityEnderCrystal) {
            if (this.Field4687.contains((Object) entity.getPosition().down())) {
                this.Field4687.remove((Object) entity.getPosition().down());
            } else if (!AutoCrystal.Field49.contains((Object) entity.getPosition().down())) {
                ++this.Field4693;
            }
        }
    }

    @SubscribeEvent
    public void Method2161963(ConnectionEvent connectionEvent) {
        if (this.Method2150387() || connectionEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 1) {
            return;
        }
        String string = connectionEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
        if (this.Field4690 != null && string != null && string.equals(this.Field4690.getName()) && this.Field4689.getValue().booleanValue()) {
            Command.Method2159696(string + " logged, Tracker disabling.");
            this.Method2150380();
        }
    }

    @Override
    public void Method2150374() {
        this.Field4687.clear();
        this.Field4695 = false;
        this.Field4690 = null;
        this.Field4691 = 0;
        this.Field4692 = 0;
        this.Field4693 = 0;
        this.Field4694 = 0;
    }

    @Override
    public void Method2150378() {
        if (this.Field4689.getValue().booleanValue()) {
            this.Method2150380();
        }
    }

    @SubscribeEvent
    public void Method2161964(DeathEvent deathEvent) {
        if (this.Method2150386() && (deathEvent.Field2030.equals((Object) this.Field4690) || deathEvent.Field2030.equals((Object) Tracker.Field2811.player))) {
            this.Field4691 = 0;
            this.Field4692 = 0;
            this.Field4693 = 0;
            this.Field4694 = 0;
            if (this.Field4689.getValue().booleanValue()) {
                this.Method2150380();
            }
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field4690 != null) {
            return this.Field4690.getName();
        }
        return null;
    }
}

