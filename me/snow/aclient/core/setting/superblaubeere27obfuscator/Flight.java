

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class Flight
        extends Module {
    private final Setting<Float> Field2875 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(50.0f)));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2876 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VANILLA));
    private final Setting<Boolean> Field2877 = this.Method2150366(new Setting<Boolean>("StopMotion", true));

    public Flight() {
        super("Flight", "Flight.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @Override
    public void Method2150372() {
        if (Flight.Field2811.player == null) {
            return;
        }
        switch (1.F ield3760[this.Field2876.getValue().ordinal()]){
            case 1: {
                Flight.Field2811.player.capabilities.isFlying = true;
                if (Flight.Field2811.player.capabilities.isCreativeMode) {
                    return;
                }
                Flight.Field2811.player.capabilities.allowFlying = true;
            }
        }
    }

    @Override
    public void Method2150379() {
        switch (1.F ield3760[this.Field2876.getValue().ordinal()]){
            case 2: {
                EntityPlayerSP entityPlayerSP;
                Flight.Field2811.player.capabilities.isFlying = false;
                Flight.Field2811.player.motionX = 0.0;
                Flight.Field2811.player.motionY = 0.0;
                Flight.Field2811.player.motionZ = 0.0;
                Flight.Field2811.player.jumpMovementFactor = this.Field2875.getValue().floatValue();
                if (Flight.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                    entityPlayerSP = Flight.Field2811.player;
                    entityPlayerSP.motionY += (double) this.Field2875.getValue().floatValue();
                }
                if (!Flight.Field2811.gameSettings.keyBindSneak.isKeyDown()) break;
                entityPlayerSP = Flight.Field2811.player;
                entityPlayerSP.motionY -= (double) this.Field2875.getValue().floatValue();
                break;
            }
            case 1: {
                Flight.Field2811.player.capabilities.setFlySpeed(this.Field2875.getValue().floatValue() / 100.0f);
                Flight.Field2811.player.capabilities.isFlying = true;
                if (Flight.Field2811.player.capabilities.isCreativeMode) {
                    return;
                }
                Flight.Field2811.player.capabilities.allowFlying = true;
                break;
            }
            case 3: {
                int n2;
                boolean bl = Flight.Field2811.gameSettings.keyBindForward.isKeyDown();
                boolean bl2 = Flight.Field2811.gameSettings.keyBindLeft.isKeyDown();
                boolean bl3 = Flight.Field2811.gameSettings.keyBindRight.isKeyDown();
                boolean bl4 = Flight.Field2811.gameSettings.keyBindBack.isKeyDown();
                if (bl2 && bl3) {
                    n2 = bl ? 0 : (bl4 ? 180 : -1);
                } else if (bl && bl4) {
                    n2 = bl2 ? -90 : (bl3 ? 90 : -1);
                } else {
                    int n3 = bl2 ? -90 : (n2 = bl3 ? 90 : 0);
                    if (bl) {
                        n2 /= 2;
                    } else if (bl4) {
                        n2 = 180 - n2 / 2;
                    }
                }
                if (n2 != -1 && (bl || bl2 || bl3 || bl4)) {
                    float f = Flight.Field2811.player.rotationYaw + (float) n2;
                    Flight.Field2811.player.motionX = EntityUtil.Method2163478(f) * (double) 0.2f;
                    Flight.Field2811.player.motionZ = EntityUtil.Method2163479(f) * (double) 0.2f;
                }
                Flight.Field2811.player.motionY = 0.0;
                Flight.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(Flight.Field2811.player.posX + Flight.Field2811.player.motionX, Flight.Field2811.player.posY + (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() ? 0.0622 : 0.0) - (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown() ? 0.0622 : 0.0), Flight.Field2811.player.posZ + Flight.Field2811.player.motionZ, Flight.Field2811.player.rotationYaw, Flight.Field2811.player.rotationPitch, false));
                Flight.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(Flight.Field2811.player.posX + Flight.Field2811.player.motionX, Flight.Field2811.player.posY - 42069.0, Flight.Field2811.player.posZ + Flight.Field2811.player.motionZ, Flight.Field2811.player.rotationYaw, Flight.Field2811.player.rotationPitch, true));
            }
        }
    }

    @Override
    public void Method2150373() {
        switch (1.F ield3760[this.Field2876.getValue().ordinal()]){
            case 1: {
                Flight.Field2811.player.capabilities.isFlying = false;
                Flight.Field2811.player.capabilities.setFlySpeed(0.05f);
                if (Flight.Field2811.player.capabilities.isCreativeMode) {
                    return;
                }
                Flight.Field2811.player.capabilities.allowFlying = false;
            }
        }
        if (this.Field2877.getValue().booleanValue()) {
            Flight.Field2811.player.motionX = 0.0;
            Flight.Field2811.player.motionZ = 0.0;
        }
    }

    public double[] Method2161015() {
        return new double[]{Flight.Field2811.player.rotationYaw * 360.0f / 360.0f * 180.0f / 180.0f, 0.0};
    }

    @Override
    public String Method2150385() {
        switch (1.F ield3760[this.Field2876.getValue().ordinal()]){
            case 1: {
                return "Vanilla";
            }
            case 2: {
                return "Static";
            }
            case 3: {
                return "Packet";
            }
        }
        return null;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        VANILLA,
        STATIC,
        PACKET;

    }
}

