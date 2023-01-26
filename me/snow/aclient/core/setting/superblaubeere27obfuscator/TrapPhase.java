

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class TrapPhase
        extends Module {
    public Setting<Float> Field2941 = this.Method2150366(new Setting<Float>("Offset", Float.valueOf(0.2f), Float.valueOf(0.0f), Float.valueOf(1.0f)));
    public Setting<Boolean> Field2942 = this.Method2150366(new Setting<Boolean>("SilentSwitch", true));
    public Setting<Boolean> Field2943 = this.Method2150366(new Setting<Boolean>("PacketPlace", true));
    public Setting<Boolean> Field2944 = this.Method2150366(new Setting<Boolean>("FaceObsidian", false));
    private EnumHand Field2945 = null;
    private int Field2946 = -1;

    public TrapPhase() {
        super("TrapPhase", "Lags you into a block instantly.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, true);
    }

    private static boolean Method2161321(Entity entity) {
        return entity instanceof EntityEnderCrystal || entity instanceof EntityPlayer;
    }

    @Override
    public void Method2150376() {
        if (Feature.Method2150358()) {
            return;
        }
        int n2 = InventoryUtil.Method2163772(Blocks.IRON_TRAPDOOR);
        int n3 = InventoryUtil.Method2163772(Blocks.OBSIDIAN);
        if (this.Field2944.getValue().booleanValue()) {
            if (n2 == -1 || n3 == -1) {
                Command.Method2159696("Cannot find materials! disabling");
                this.Method2150380();
                return;
            }
        } else if (n2 == -1) {
            Command.Method2159696("Cannot find materials! disabling");
            this.Method2150380();
            return;
        }
        BlockPos[] arrblockPos = new BlockPos[]{new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(0, 0, -1)};
        BlockPos blockPos = EntityUtil.Method2163481((Entity) TrapPhase.Field2811.player);
        BlockPos blockPos2 = null;
        for (BlockPos blockPos3 : arrblockPos) {
            BlockPos blockPos4 = blockPos.add((Vec3i) blockPos3);
            if (!this.Method2161318(blockPos4) || BlockUtil2.Method2164265(blockPos4).equals((Object) Blocks.AIR))
                continue;
            blockPos2 = blockPos4;
        }
        if (blockPos2 == null) {
            Command.Method2159696("Cannot find space! disabling");
            this.Method2150380();
            return;
        }
        this.Method2161319(n2);
        double d = TrapPhase.Field2811.player.posX;
        double d2 = TrapPhase.Field2811.player.posY;
        double d3 = TrapPhase.Field2811.player.posZ;
        TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, d2 + (double) this.Field2941.getValue().floatValue(), d3, TrapPhase.Field2811.player.onGround));
        EnumFacing enumFacing = null;
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            if (!blockPos2.add(enumFacing2.getDirectionVec()).equals((Object) blockPos)) {
                continue;
            }
            enumFacing = enumFacing2;
            break;
        }
        if (this.Field2944.getValue().booleanValue()) {
            BlockUtil2.Method2164226(blockPos2, enumFacing, new Vec3d(0.5, 0.8, 0.5), this.Field2943.getValue());
            TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, d2, d3, TrapPhase.Field2811.player.onGround));
            this.Method2161319(n3);
            TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, d2 - 0.8, d3, false));
            BlockUtil2.Method2164227(blockPos, EnumFacing.UP, this.Field2943.getValue());
            TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, d2, d3, false));
            this.Method2161310();
            this.Method2150380();
        } else {
            BlockUtil2.Method2164226(blockPos2, enumFacing, new Vec3d(0.5, 0.8, 0.5), this.Field2943.getValue());
            TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Position(d, d2, d3, TrapPhase.Field2811.player.onGround));
            this.Method2161310();
            this.Method2150380();
        }
    }

    public boolean Method2161318(BlockPos blockPos) {
        return TrapPhase.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos), TrapPhase::Method2161321).isEmpty();
    }

    public void Method2161319(int n2) {
        if (this.Field2942.getValue().booleanValue()) {
            this.Field2945 = null;
            if (TrapPhase.Field2811.player.isHandActive()) {
                this.Field2945 = TrapPhase.Field2811.player.getActiveHand();
            }
            this.Field2946 = TrapPhase.Field2811.player.inventory.currentItem;
            TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        } else {
            TrapPhase.Field2811.player.inventory.currentItem = n2;
            TrapPhase.Field2811.playerController.updateController();
        }
    }

    public void Method2161310() {
        if (this.Field2946 != -1 && this.Field2942.getValue().booleanValue()) {
            if (this.Field2945 != null) {
                TrapPhase.Field2811.player.setActiveHand(this.Field2945);
            }
            TrapPhase.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2946));
            this.Field2946 = -1;
            this.Field2945 = null;
        }
    }
}

