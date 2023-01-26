

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class PhaseWalk
        extends Module {
    public final Setting<Boolean> Field2834 = this.Method2150366(new Setting<Boolean>("Only In Block", true));
    public final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2835 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("NoClipMode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoClip));
    public final Setting<Boolean> Field2836 = this.Method2150366(new Setting<Boolean>("Fall Packet", true));
    public final Setting<Boolean> Field2837 = this.Method2150366(new Setting<Boolean>("Sprint Packet", true));
    public final Setting<Boolean> Field2838 = this.Method2150366(new Setting<Boolean>("Instant Walk", true));
    public final Setting<Boolean> Field2839 = this.Method2150366(new Setting<Boolean>("Anti Void", false));
    public final Setting<Boolean> Field2840 = this.Method2150366(new Setting<Boolean>("Clip", true));
    public final Setting<Integer> Field2841 = this.Method2150366(new Setting<Integer>("Anti Void Height", 5, 1, 100));
    public final Setting<Double> Field2842 = this.Method2150366(new Setting<Object>("Instant Speed", Double.valueOf(1.8), Double.valueOf(0.1), Double.valueOf(2.0), this::Method2162129));
    public final Setting<Double> Field2843 = this.Method2150366(new Setting<Double>("Phase Walk Speed", 42.4, 0.1, 70.0));
    public final Setting<Boolean> Field2844 = this.Method2150366(new Setting<Boolean>("Phase Down When Crouch", true));
    public final Setting<Boolean> Field2845 = this.Method2150366(new Setting<Boolean>("Attempt Clips", true));
    public final Setting<Integer> Field2846 = this.Method2150366(new Setting<Object>("Attempt Clips Delay", Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(20), this::Method2162128));
    int Field2847 = 0;

    public PhaseWalk() {
        super("PhaseWalk", "Allows you to walk through blocks", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @Override
    public void Method2150379() {
        RayTraceResult rayTraceResult;
        ++this.Field2847;
        double d = this.Field2843.getValue() / 1000.0;
        double d2 = this.Field2842.getValue() / 10.0;
        if (this.Field2839.getValue().booleanValue() && PhaseWalk.Field2811.player.posY <= (double) this.Field2841.getValue().intValue() && ((rayTraceResult = PhaseWalk.Field2811.world.rayTraceBlocks(PhaseWalk.Field2811.player.getPositionVector(), new Vec3d(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ), false, false, false)) == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)) {
            PhaseWalk.Field2811.player.setVelocity(0.0, 0.0, 0.0);
        }
        if (this.Field2834.getValue().booleanValue()) {
            if ((PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) && (!this.Method2162127() && !PhaseWalk.Field2811.world.getBlockState(PlayerUtil.Method2163942()).getBlock().equals((Object) Blocks.AIR) || !PhaseWalk.Field2811.world.getBlockState(PlayerUtil.Method2163942().up()).getBlock().equals((Object) Blocks.AIR))) {
                double[] arrd;
                double[] arrd2;
                if (PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isPressed() && PhaseWalk.Field2811.player.isSneaking()) {
                    arrd2 = this.Method2162125(d);
                    if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY - 0.0424, PhaseWalk.Field2811.player.posZ + arrd2[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                    } else {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd2[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                    }
                    if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Fall) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX, -1300.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.rotationYaw * -5.0f, PhaseWalk.Field2811.player.rotationPitch * -5.0f, true));
                    }
                    if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoClip) {
                        PhaseWalk.Field2811.player.setVelocity(0.0, 0.0, 0.0);
                        if (PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown()) {
                            arrd = MathUtil.Method2163867(0.06f);
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX + arrd[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd[1], PhaseWalk.Field2811.player.onGround));
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        }
                        if (PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY - (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        }
                        if (PhaseWalk.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY + (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        }
                    }
                    if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Bypass) {
                        PhaseWalk.Field2811.player.noClip = true;
                    }
                    if (this.Field2836.getValue().booleanValue()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.STOP_RIDING_JUMP));
                    }
                    if (this.Field2837.getValue().booleanValue()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
                    }
                    if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY - 0.0424, PhaseWalk.Field2811.player.posZ + arrd2[1]);
                    } else {
                        PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd2[1]);
                    }
                    PhaseWalk.Field2811.player.motionZ = 0.0;
                    PhaseWalk.Field2811.player.motionY = 0.0;
                    PhaseWalk.Field2811.player.motionX = 0.0;
                    PhaseWalk.Field2811.player.noClip = true;
                }
                if (!PhaseWalk.Field2811.player.collidedHorizontally || !this.Field2840.getValue().booleanValue() || PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown()) {
                    // empty if block
                }
                if (PhaseWalk.Field2811.player.collidedHorizontally && this.Field2845.getValue() != false ? this.Field2847 >= this.Field2846.getValue() : PhaseWalk.Field2811.player.collidedHorizontally) {
                    arrd2 = this.Method2162125(d);
                    if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY - 0.1, PhaseWalk.Field2811.player.posZ + arrd2[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                    } else {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd2[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                    }
                    if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Fall) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX, -1300.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.rotationYaw * -5.0f, PhaseWalk.Field2811.player.rotationPitch * -5.0f, true));
                    }
                    if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoClip) {
                        PhaseWalk.Field2811.player.setVelocity(0.0, 0.0, 0.0);
                        if (PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown()) {
                            arrd = MathUtil.Method2163867(0.06f);
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX + arrd[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd[1], PhaseWalk.Field2811.player.onGround));
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        }
                        if (PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY - (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        }
                        if (PhaseWalk.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY + (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                            PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        }
                    }
                    if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Bypass) {
                        PhaseWalk.Field2811.player.noClip = true;
                    }
                    if (this.Field2836.getValue().booleanValue()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.STOP_RIDING_JUMP));
                    }
                    if (this.Field2837.getValue().booleanValue()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
                    }
                    if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY - 0.1, PhaseWalk.Field2811.player.posZ + arrd2[1]);
                    } else {
                        PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd2[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd2[1]);
                    }
                    PhaseWalk.Field2811.player.motionZ = 0.0;
                    PhaseWalk.Field2811.player.motionY = 0.0;
                    PhaseWalk.Field2811.player.motionX = 0.0;
                    PhaseWalk.Field2811.player.noClip = true;
                    this.Field2847 = 0;
                } else if (this.Field2838.getValue().booleanValue()) {
                    double[] arrd3 = MathUtil.Method2163867(d2);
                    PhaseWalk.Field2811.player.motionX = arrd3[0];
                    PhaseWalk.Field2811.player.motionZ = arrd3[1];
                }
            }
        } else if (PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
            double[] arrd;
            double[] arrd4;
            if (PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isPressed() && PhaseWalk.Field2811.player.isSneaking()) {
                arrd4 = this.Method2162125(d);
                if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY - 0.0424, PhaseWalk.Field2811.player.posZ + arrd4[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                } else {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd4[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                }
                if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Fall) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX, -1300.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.rotationYaw * -5.0f, PhaseWalk.Field2811.player.rotationPitch * -5.0f, true));
                }
                if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoClip) {
                    PhaseWalk.Field2811.player.setVelocity(0.0, 0.0, 0.0);
                    if (PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown()) {
                        arrd = MathUtil.Method2163867(0.06f);
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX + arrd[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd[1], PhaseWalk.Field2811.player.onGround));
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                    }
                    if (PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY - (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                    }
                    if (PhaseWalk.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY + (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                    }
                }
                if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Bypass) {
                    PhaseWalk.Field2811.player.noClip = true;
                }
                if (this.Field2836.getValue().booleanValue()) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.STOP_RIDING_JUMP));
                }
                if (this.Field2837.getValue().booleanValue()) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
                }
                if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                    PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY - 0.0424, PhaseWalk.Field2811.player.posZ + arrd4[1]);
                } else {
                    PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd4[1]);
                }
                PhaseWalk.Field2811.player.motionZ = 0.0;
                PhaseWalk.Field2811.player.motionY = 0.0;
                PhaseWalk.Field2811.player.motionX = 0.0;
                PhaseWalk.Field2811.player.noClip = true;
            }
            if (PhaseWalk.Field2811.player.collidedHorizontally && this.Field2845.getValue() != false ? this.Field2847 >= this.Field2846.getValue() : PhaseWalk.Field2811.player.collidedHorizontally) {
                arrd4 = this.Method2162125(d);
                if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY - 0.1, PhaseWalk.Field2811.player.posZ + arrd4[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                } else {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd4[1], PhaseWalk.Field2811.player.rotationYaw, PhaseWalk.Field2811.player.rotationPitch, false));
                }
                if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Fall) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.PositionRotation(PhaseWalk.Field2811.player.posX, -1300.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.rotationYaw * -5.0f, PhaseWalk.Field2811.player.rotationPitch * -5.0f, true));
                }
                if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NoClip) {
                    PhaseWalk.Field2811.player.setVelocity(0.0, 0.0, 0.0);
                    if (PhaseWalk.Field2811.gameSettings.keyBindForward.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindBack.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindLeft.isKeyDown() || PhaseWalk.Field2811.gameSettings.keyBindRight.isKeyDown()) {
                        arrd = MathUtil.Method2163867(0.06f);
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX + arrd[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd[1], PhaseWalk.Field2811.player.onGround));
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                    }
                    if (PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY - (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                    }
                    if (PhaseWalk.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, PhaseWalk.Field2811.player.posY + (double) 0.06f, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                        PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(PhaseWalk.Field2811.player.posX, 0.0, PhaseWalk.Field2811.player.posZ, PhaseWalk.Field2811.player.onGround));
                    }
                }
                if (this.Field2835.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Bypass) {
                    PhaseWalk.Field2811.player.noClip = true;
                }
                if (this.Field2836.getValue().booleanValue()) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.STOP_RIDING_JUMP));
                }
                if (this.Field2837.getValue().booleanValue()) {
                    PhaseWalk.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) PhaseWalk.Field2811.player, CPacketEntityAction.Action.START_SPRINTING));
                }
                if (this.Field2844.getValue().booleanValue() && PhaseWalk.Field2811.player.collidedVertically && PhaseWalk.Field2811.gameSettings.keyBindSneak.isKeyDown()) {
                    PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY - 0.1, PhaseWalk.Field2811.player.posZ + arrd4[1]);
                } else {
                    PhaseWalk.Field2811.player.setPosition(PhaseWalk.Field2811.player.posX + arrd4[0], PhaseWalk.Field2811.player.posY, PhaseWalk.Field2811.player.posZ + arrd4[1]);
                }
                PhaseWalk.Field2811.player.motionZ = 0.0;
                PhaseWalk.Field2811.player.motionY = 0.0;
                PhaseWalk.Field2811.player.motionX = 0.0;
                PhaseWalk.Field2811.player.noClip = true;
                this.Field2847 = 0;
            } else if (this.Field2838.getValue().booleanValue()) {
                double[] arrd5 = MathUtil.Method2163867(d2);
                PhaseWalk.Field2811.player.motionX = arrd5[0];
                PhaseWalk.Field2811.player.motionZ = arrd5[1];
            }
        }
    }

    private double[] Method2162125(double d) {
        float f = PhaseWalk.Field2811.player.movementInput.moveForward;
        float f2 = PhaseWalk.Field2811.player.movementInput.moveStrafe;
        float f3 = PhaseWalk.Field2811.player.prevRotationYaw + (PhaseWalk.Field2811.player.rotationYaw - PhaseWalk.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = (double) f * d * -Math.sin(Math.toRadians(f3)) + (double) f2 * d * Math.cos(Math.toRadians(f3));
        double d3 = (double) f * d * Math.cos(Math.toRadians(f3)) - (double) f2 * d * -Math.sin(Math.toRadians(f3));
        return new double[]{d2, d3};
    }

    private double[] Method2162126() {
        float f = PhaseWalk.Field2811.player.movementInput.moveForward;
        float f2 = PhaseWalk.Field2811.player.movementInput.moveStrafe;
        float f3 = PhaseWalk.Field2811.player.prevRotationYaw + (PhaseWalk.Field2811.player.rotationYaw - PhaseWalk.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        double d = (double) f2 * (double) f * -Math.sin(Math.toRadians(f3)) + (double) f2 * (double) f * Math.cos(Math.toRadians(f3));
        double d2 = (double) f2 * (double) f * Math.cos(Math.toRadians(f3)) - (double) f2 * (double) f * -Math.sin(Math.toRadians(f3));
        return new double[]{d, d2};
    }

    @Override
    public void Method2150373() {
        PhaseWalk.Field2811.player.noClip = false;
    }

    private boolean Method2162127() {
        String string = String.valueOf(PhaseWalk.Field2811.player.posY);
        String string2 = string.split("\\.")[1];
        return string2.equals("875");
    }

    private boolean Method2162128(Object object) {
        return this.Field2845.getValue();
    }

    private boolean Method2162129(Object object) {
        return this.Field2838.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NoClip,
        Fall,
        Bypass,
        None;

    }
}

