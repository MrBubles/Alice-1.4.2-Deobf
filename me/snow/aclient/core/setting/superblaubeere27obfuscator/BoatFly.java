

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiDownloadTerrain
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketConfirmTeleport
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketMoveVehicle
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketPlayerPosLook$EnumFlags
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.concurrent.atomic.AtomicBoolean;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DismountRidingEntityEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerTravelEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilSC;
import me.snow.aclient.mixin.mixins.accessors.ISPacketPlayerPosLook;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BoatFly
        extends Module {
    public Setting<Integer> Field9 = this.Method2150366(new Setting<Integer>("SafetyFactor", 2, 0, 10));
    public Setting<Integer> Field10 = this.Method2150366(new Setting<Integer>("MaxSetbacks", 10, 0, 20));
    private Setting<Boolean> Field1 = this.Method2150366(new Setting<Boolean>("FixYaw", true));
    private Setting<Boolean> Field2 = this.Method2150366(new Setting<Boolean>("AntiKick", true));
    private Setting<Boolean> Field3 = this.Method2150366(new Setting<Boolean>("Confirm", false));
    private Setting<Boolean> Field4 = this.Method2150366(new Setting<Boolean>("Bypass", true));
    private Setting<Boolean> Field5 = this.Method2150366(new Setting<Boolean>("Semi", true));
    private Setting<Boolean> Field6 = this.Method2150366(new Setting<Boolean>("Constrict", false));
    private Setting<Double> Field7 = this.Method2150366(new Setting<Double>("Speed", 1.0, 0.1, 50.0));
    private Setting<Double> Field8 = this.Method2150366(new Setting<Double>("VSpeed", 0.5, 0.1, 10.0));
    private int Field11;
    private Vec3d Field12 = null;
    private int Field13;
    private AtomicBoolean Field14 = new AtomicBoolean(false);
    private int Field15 = 0;

    public BoatFly() {
        super("BoatFly", "Automatically walks in a straight line", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @Override
    public void Method2150372() {
        this.Field13 = 0;
        this.Field12 = null;
        this.Field11 = 0;
        if (BoatFly.Field2811.player == null || BoatFly.Field2811.world == null) {
            this.Method2150391();
            return;
        }
    }

    @SubscribeEvent
    public void Method2161974(DismountRidingEntityEvent dismountRidingEntityEvent) {
        if (BoatFly.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
            dismountRidingEntityEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void Method2161975(PlayerTravelEvent playerTravelEvent) {
        if (BoatFly.Field2811.player == null || BoatFly.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        if (BoatFly.Field2811.player.getRidingEntity() instanceof EntityBoat) {
            EntityBoat entityBoat = (EntityBoat) BoatFly.Field2811.player.getRidingEntity();
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            if (PlayerUtilSC.Method2162917()) {
                double[] arrd = PlayerUtilSC.Method2162924(this.Field7.getValue());
                d = arrd[0];
                d3 = arrd[1];
            } else {
                d = 0.0;
                d3 = 0.0;
            }
            if (BoatFly.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                d2 = this.Field8.getValue();
                if (this.Field2.getValue().booleanValue() && BoatFly.Field2811.player.ticksExisted % 20 == 0) {
                    d2 = -0.04;
                }
            } else if (BoatFly.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                d2 = -this.Field8.getValue().doubleValue();
            } else if (this.Field2.getValue().booleanValue() && BoatFly.Field2811.player.ticksExisted % 4 == 0) {
                d2 = -0.04;
            }
            if (this.Field1.getValue().booleanValue()) {
                entityBoat.rotationYaw = BoatFly.Field2811.player.rotationYaw;
            }
            if (this.Field9.getValue() > 0 && !BoatFly.Field2811.world.isBlockLoaded(new BlockPos(entityBoat.posX + d * (double) this.Field9.getValue().intValue(), entityBoat.posY + d2 * (double) this.Field9.getValue().intValue(), entityBoat.posZ + d3 * (double) this.Field9.getValue().intValue()), false)) {
                d = 0.0;
                d3 = 0.0;
            }
            if (!this.Field5.getValue().booleanValue() || BoatFly.Field2811.player.ticksExisted % 2 != 0) {
                if (this.Field14.get() && this.Field5.getValue().booleanValue()) {
                    entityBoat.setVelocity(0.0, 0.0, 0.0);
                    this.Field14.set(false);
                } else {
                    entityBoat.setVelocity(d, d2, d3);
                }
            }
            if (this.Field3.getValue().booleanValue()) {
                ++this.Field11;
                BoatFly.Field2811.player.connection.sendPacket((Packet) new CPacketConfirmTeleport(this.Field11));
            }
        }
    }

    private double Method2161976(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.z - vec3d2.z;
        return MathHelper.sqrt((double) (d * d + d2 * d2));
    }

    private double Method2161977(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d.y - vec3d2.y;
        return MathHelper.sqrt((double) (d * d));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @SubscribeEvent
    public void Method2161978(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll var1_1) {
        block8:
        {
            block9:
            {
                block12:
                {
                    block11:
                    {
                        block10:
                        {
                            if (BoatFly.Field2811.player == null || BoatFly.Field2811.world == null) {
                                this.Method2150391();
                                return;
                            }
                            if (!(var1_1.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook) || !BoatFly.Field2811.player.isRiding())
                                break block8;
                            var2_2 = (SPacketPlayerPosLook) var1_1.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
                            ((ISPacketPlayerPosLook) var2_2).setYaw(BoatFly.Field2811.player.rotationYaw);
                            ((ISPacketPlayerPosLook) var2_2).setPitch(BoatFly.Field2811.player.rotationPitch);
                            var2_2.getFlags().remove((Object) SPacketPlayerPosLook.EnumFlags.X_ROT);
                            var2_2.getFlags().remove((Object) SPacketPlayerPosLook.EnumFlags.Y_ROT);
                            this.Field11 = var2_2.getTeleportId();
                            if (this.Field10.getValue() <= 0) break block9;
                            if (this.Field12 != null) break block10;
                            this.Field12 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                            this.Field13 = 1;
                            break block9;
                        }
                        if (!PlayerUtilSC.Method2162917()) break block11;
                        v0 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                        if (!(this.Method2161976(this.Field12, v0) < this.Field7.getValue() * 0.8)) break block11;
                        this.Field12 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                        ++this.Field13;
                        break block9;
                    }
                    if (!BoatFly.Field2811.gameSettings.keyBindJump.isKeyDown() && !BoatFly.Field2811.gameSettings.keyBindSneak.isKeyDown())
                        break block12;
                    v1 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                    if (!(this.Method2161977(this.Field12, v1) < this.Field8.getValue() * 0.5)) break block12;
                    this.Field12 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                    ++this.Field13;
                    break block9;
                }
                if (BoatFly.Field2811.gameSettings.keyBindJump.isKeyDown() || BoatFly.Field2811.gameSettings.keyBindSneak.isKeyDown()) **
                GOTO lbl -1000
                if (this.Method2161977(this.Field12, new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ())) < 0.02) **
                GOTO lbl -1000
                v2 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                if (this.Method2161977(this.Field12, v2) > 1.0) lbl - 1000:
                // 2 sources

                {
                    this.Field12 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                    ++this.Field13;
                } else lbl - 1000:
                // 2 sources

                {
                    this.Field12 = new Vec3d(var2_2.getX(), var2_2.getY(), var2_2.getZ());
                    this.Field13 = 1;
                }
            }
            if (this.Field10.getValue() > 0 && this.Field13 > this.Field10.getValue()) {
                return;
            }
            if (BoatFly.Field2811.player.isEntityAlive() && BoatFly.Field2811.world.isBlockLoaded(new BlockPos(BoatFly.Field2811.player.posX, BoatFly.Field2811.player.posY, BoatFly.Field2811.player.posZ)) && !(BoatFly.Field2811.currentScreen instanceof GuiDownloadTerrain)) {
                if (this.Field11 <= 0) {
                    this.Field11 = var2_2.getTeleportId();
                    return;
                }
                if (!this.Field3.getValue().booleanValue()) {
                    BoatFly.Field2811.player.connection.sendPacket((Packet) new CPacketConfirmTeleport(var2_2.getTeleportId()));
                }
                var1_1.setCanceled(true);
            }
        }
        if (var1_1.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketMoveVehicle == false)
            return;
        if (BoatFly.Field2811.player.isRiding() == false) return;
        if (this.Field5.getValue().booleanValue()) {
            this.Field14.set(true);
            return;
        }
        var1_1.setCanceled(true);
    }

    @SubscribeEvent
    public void Method2161979(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (BoatFly.Field2811.player == null || BoatFly.Field2811.world == null) {
            this.Method2150391();
            return;
        }
        if (!this.Field4.getValue().booleanValue()) {
            return;
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketVehicleMove) {
            if (BoatFly.Field2811.player.isRiding() && BoatFly.Field2811.player.ticksExisted % 2 == 0) {
                BoatFly.Field2811.playerController.interactWithEntity((EntityPlayer) BoatFly.Field2811.player, BoatFly.Field2811.player.getRidingEntity(), this.Field6.getValue() != false ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            }
        } else if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayer.Rotation && BoatFly.Field2811.player.isRiding()) {
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.isCanceled();
        } else if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketInput && (!this.Field5.getValue().booleanValue() || BoatFly.Field2811.player.ticksExisted % 2 == 0)) {
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.isCanceled();
        }
    }
}

