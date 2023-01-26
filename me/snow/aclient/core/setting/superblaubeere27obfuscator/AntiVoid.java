

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class AntiVoid
        extends Module {
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field4290 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Solid));

    public AntiVoid() {
        super("AntiVoid", "Glitches you up from void.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, false, false, false);
    }

    @Override
    public void Method2150376() {
        if (!AntiVoid.Field2811.player.isSpectator() && !AliceMain.Field756.Method2150180(PacketFlight.class).Method2150364() && AntiVoid.Field2811.player.posY < 1.0) {
            Command.Method2159696("[AntiVoid] " + (Object) ChatFormatting.RED + "Player " + (Object) ChatFormatting.GREEN + AntiVoid.Field2811.player.getName() + (Object) ChatFormatting.RED + " is in the void!");
            switch (1.F ield2750[this.Field4290.getValue().ordinal()]){
                case 1: {
                    AntiVoid.Field2811.player.motionY = 0.0;
                    break;
                }
                case 2: {
                    AntiVoid.Field2811.player.motionY = 0.5;
                    break;
                }
                case 3: {
                    if (!(AntiVoid.Field2811.player.motionY < 0.0)) break;
                    AntiVoid.Field2811.player.motionY /= 3.0;
                    break;
                }
                case 4: {
                    AntiVoid.Field2811.player.setVelocity(0.0, 0.0, 0.0);
                    AntiVoid.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(AntiVoid.Field2811.player.posX, AntiVoid.Field2811.player.posY + 10.0, AntiVoid.Field2811.player.posZ, false));
                }
            }
        }
    }

    @Override
    public void Method2150373() {
        AntiVoid.Field2811.player.moveVertical = 0.0f;
    }

    @Override
    public String Method2150385() {
        return (Object) ((Object) this.Field4290.getValue()) + "";
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Solid,
        Launch,
        Glide,
        Rubberband;

    }
}

