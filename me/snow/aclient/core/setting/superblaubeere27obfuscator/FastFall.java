

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Arrays;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ElytraFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Flight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LongJump;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class FastFall
        extends Module {
    public Setting<Double> Field2593 = this.Method2150366(new Setting<Double>("Speed", 3.0, 0.1, 10.0));
    public Setting<Double> Field2594 = this.Method2150366(new Setting<Double>("Height", 5.0, 0.1, 20.0));
    public Setting<Boolean> Field2595 = this.Method2150366(new Setting<Boolean>("NoLag", true));
    List<Block> Field2596 = Arrays.asList(new Block[]{Blocks.BED, Blocks.SLIME_BLOCK});

    public FastFall() {
        super("FastFall", "Fast fall", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    public static boolean Method2161011() {
        return !PlayerUtil.Field2811.world.getCollisionBoxes((Entity) PlayerUtil.Field2811.player, PlayerUtil.Field2811.player.getEntityBoundingBox()).isEmpty();
    }

    @Override
    public void Method2150379() {
        if (FastFall.Method2150359() || this.Method2161012()) {
            return;
        }
        if (this.Field2595.getValue().booleanValue() && AliceMain.Field772.Method2150234()) {
            return;
        }
        RayTraceResult rayTraceResult = FastFall.Field2811.world.rayTraceBlocks(FastFall.Field2811.player.getPositionVector(), new Vec3d(FastFall.Field2811.player.posX, FastFall.Field2811.player.posY - this.Field2594.getValue(), FastFall.Field2811.player.posZ), false, false, false);
        if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && FastFall.Field2811.world.getBlockState(new BlockPos(FastFall.Field2811.player.posX, FastFall.Field2811.player.posY - 0.1, FastFall.Field2811.player.posZ)).getBlock() != this.Field2596) {
            FastFall.Field2811.player.motionY = -this.Field2593.getValue().doubleValue();
        }
    }

    boolean Method2161012() {
        return FastFall.Field2811.player.isElytraFlying() || FastFall.Method2161011() || EntityUtil.Method2163563() || FastFall.Field2811.player.isOnLadder() || FastFall.Field2811.player.capabilities.isFlying || FastFall.Field2811.player.motionY > 0.0 || FastFall.Field2811.gameSettings.keyBindJump.isKeyDown() || FastFall.Field2811.player.isEntityInsideOpaqueBlock() || FastFall.Field2811.player.noClip || !FastFall.Field2811.player.onGround || Freecam.Method2162238().Method2150364() || AliceMain.Field756.Method2150180(PacketFlight.class).Method2150364() || AliceMain.Field756.Method2150180(LongJump.class).Method2150364() || AliceMain.Field756.Method2150180(Flight.class).Method2150364() || AliceMain.Field756.Method2150180(ElytraFlight.class).Method2150364();
    }
}

