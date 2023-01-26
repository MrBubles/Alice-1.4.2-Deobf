

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;

public class SilentAutoXP
        extends Module {
    private static SilentAutoXP Field2931 = new SilentAutoXP();
    public final Setting<Boolean> Field2935 = this.Method2150366(new Setting<Boolean>("Rotate to Feet", true));
    public final Setting<Bind> Field2936 = this.Method2150366(new Setting<Bind>("XpBind", new Bind(-1)));
    int Field2932;
    int Field2933;
    int Field2934;

    public SilentAutoXP() {
        super("SilentXP", "Switches to Experience Bottles and Throws them at your feet to mend your armor", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162299();
    }

    public static SilentAutoXP Method2162298() {
        if (Field2931 == null) {
            Field2931 = new SilentAutoXP();
        }
        return Field2931;
    }

    private void Method2162299() {
        Field2931 = this;
    }

    @Override
    public void Method2150372() {
        this.Field2934 = (int) SilentAutoXP.Field2811.player.rotationPitch;
        this.Field2932 = SilentAutoXP.Field2811.player.inventory.currentItem;
    }

    @Override
    public void Method2150379() {
        if (this.Field2936.getValue().isDown()) {
            this.Method2162290();
        }
    }

    public void Method2162290() {
        this.Field2934 = (int) SilentAutoXP.Field2811.player.rotationPitch;
        if (InventoryUtil2.Method2164565(Items.EXPERIENCE_BOTTLE) >= 0) {
            this.Field2932 = SilentAutoXP.Field2811.player.inventory.currentItem;
            this.Field2933 = InventoryUtil2.Method2164565(Items.EXPERIENCE_BOTTLE);
            SilentAutoXP.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2933));
            if (this.Field2935.getValue().booleanValue()) {
                SilentAutoXP.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(SilentAutoXP.Field2811.player.cameraYaw, 90.0f, SilentAutoXP.Field2811.player.onGround));
            }
            SilentAutoXP.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            SilentAutoXP.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2932));
            if (this.Field2935.getValue().booleanValue()) {
                SilentAutoXP.Field2811.player.rotationPitch = this.Field2934;
            }
        }
    }
}

