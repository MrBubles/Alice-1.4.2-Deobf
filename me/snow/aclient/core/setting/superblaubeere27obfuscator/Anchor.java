

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.eventbus.Subscribe
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.eventbus.Subscribe;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Anchor
        extends Module {
    public static boolean Field3700;
    private final Setting<Integer> Field3701 = this.Method2150366(new Setting<Integer>("Pitch", 60, 0, 90));
    private final Setting<Boolean> Field3702 = this.Method2150366(new Setting<Boolean>("Pull", true));
    int Field3703;

    public Anchor() {
        super("Anchor", "For disabled people that can't move into holes on their own.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, false, false, false);
    }

    public boolean Method2161960(BlockPos blockPos) {
        this.Field3703 = 0;
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, 3, 0)).getBlock() == Blocks.AIR) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, 2, 0)).getBlock() == Blocks.AIR) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock() == Blocks.AIR) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, 0, 0)).getBlock() == Blocks.AIR) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() == Blocks.OBSIDIAN || Anchor.Field2811.world.getBlockState(blockPos.add(0, -1, 0)).getBlock() == Blocks.BEDROCK) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.OBSIDIAN || Anchor.Field2811.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.BEDROCK) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.OBSIDIAN || Anchor.Field2811.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.BEDROCK) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.OBSIDIAN || Anchor.Field2811.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.BEDROCK) {
            ++this.Field3703;
        }
        if (Anchor.Field2811.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.OBSIDIAN || Anchor.Field2811.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.BEDROCK) {
            ++this.Field3703;
        }
        return this.Field3703 >= 9;
    }

    public Vec3d Method2161971(double d, double d2, double d3) {
        double d4 = Math.floor(d) + 0.5;
        double d5 = Math.floor(d2);
        double d6 = Math.floor(d3) + 0.5;
        return new Vec3d(d4, d5, d6);
    }

    @Override
    @Subscribe
    public void Method2150379() {
        if (Anchor.Field2811.world == null) {
            return;
        }
        if (Anchor.Field2811.player.rotationPitch >= (float) this.Field3701.getValue().intValue()) {
            if (this.Method2161960(this.Method2161972().down(1)) || this.Method2161960(this.Method2161972().down(2)) || this.Method2161960(this.Method2161972().down(3)) || this.Method2161960(this.Method2161972().down(4))) {
                Field3700 = true;
                if (!this.Field3702.getValue().booleanValue()) {
                    Anchor.Field2811.player.motionX = 0.0;
                    Anchor.Field2811.player.motionZ = 0.0;
                } else {
                    Vec3d vec3d = this.Method2161971(Anchor.Field2811.player.posX, Anchor.Field2811.player.posY, Anchor.Field2811.player.posZ);
                    double d = Math.abs(vec3d.x - Anchor.Field2811.player.posX);
                    double d2 = Math.abs(vec3d.z - Anchor.Field2811.player.posZ);
                    if (!(d <= 0.1) || !(d2 <= 0.1)) {
                        double d3 = vec3d.x - Anchor.Field2811.player.posX;
                        double d4 = vec3d.z - Anchor.Field2811.player.posZ;
                        Anchor.Field2811.player.motionX = d3 / 2.0;
                        Anchor.Field2811.player.motionZ = d4 / 2.0;
                    }
                }
            } else {
                Field3700 = false;
            }
        }
    }

    @Override
    public void Method2150373() {
        Field3700 = false;
        this.Field3703 = 0;
    }

    public BlockPos Method2161972() {
        return new BlockPos(Math.floor(Anchor.Field2811.player.posX), Math.floor(Anchor.Field2811.player.posY), Math.floor(Anchor.Field2811.player.posZ));
    }
}

