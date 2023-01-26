

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 *  net.minecraft.potion.Potion
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Objects;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiEffect
        extends Module {
    private final Queue<UUID> Field3616 = new ConcurrentLinkedQueue<UUID>();
    public Setting<Boolean> Field3617 = this.Method2150366(new Setting<Boolean>("AntiLevitate", true));
    public Setting<Boolean> Field3618 = this.Method2150366(new Setting<Boolean>("AntiVanish", true));

    public AntiEffect() {
        super("AntiEffect", "Notifies you when players vanish", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @SubscribeEvent
    public void Method2161793(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketPlayerListItem sPacketPlayerListItem;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerListItem && (sPacketPlayerListItem = (SPacketPlayerListItem) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction() == SPacketPlayerListItem.Action.UPDATE_LATENCY && this.Field3618.getValue().booleanValue()) {
            for (SPacketPlayerListItem.AddPlayerData addPlayerData : sPacketPlayerListItem.getEntries()) {
                try {
                    if (Field2811.getConnection().getPlayerInfo(addPlayerData.getProfile().getId()) != null) continue;
                } catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
                this.Field3616.add(addPlayerData.getProfile().getId());
            }
        }
    }

    @Override
    public void Method2150379() {
        UUID uUID;
        if (PlayerUtil.Field3934.Method2164751(5.0) && (uUID = this.Field3616.poll()) != null && this.Field3618.getValue().booleanValue()) {
            try {
                String string = PlayerUtil.Method2163931(uUID);
                if (string != null) {
                    Command.Method2159696("\u00a7c" + string + " has gone into vanish.");
                }
            } catch (Exception exception) {
                // empty catch block
            }
            PlayerUtil.Field3934.Method2164750();
        }
        if (this.Field3617.getValue().booleanValue() && AntiEffect.Field2811.player.isPotionActive(Objects.requireNonNull(Potion.getPotionFromResourceLocation((String) "levitation")))) {
            AntiEffect.Field2811.player.removeActivePotionEffect(Potion.getPotionFromResourceLocation((String) "levitation"));
        }
    }

    @Override
    public void Method2150378() {
        this.Field3616.clear();
    }
}

