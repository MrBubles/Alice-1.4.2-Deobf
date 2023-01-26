

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockHopper
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.IBlockAccess
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockHopper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class VanillaClip
        extends Module {
    public static VanillaClip Field1659;
    public Setting<Boolean> Field1660 = this.Method2150366(new Setting<Boolean>("OnlyPhasing", true));

    public VanillaClip() {
        super("VanillaClip", "VanillaClip", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
        Field1659 = this;
    }

    public static boolean Method2162151() {
        try {
            AxisAlignedBB axisAlignedBB = VanillaClip.Field2811.player.getEntityBoundingBox();
            for (int j = MathHelper.floor((double) axisAlignedBB.minX); j < MathHelper.floor((double) axisAlignedBB.maxX) + 1; ++j) {
                for (int i2 = MathHelper.floor((double) axisAlignedBB.minY); i2 < MathHelper.floor((double) axisAlignedBB.maxY) + 1; ++i2) {
                    for (int i3 = MathHelper.floor((double) axisAlignedBB.minZ); i3 < MathHelper.floor((double) axisAlignedBB.maxZ) + 1; ++i3) {
                        Block block = VanillaClip.Field2811.world.getBlockState(new BlockPos(j, i2, i3)).getBlock();
                        if (block == null || block instanceof BlockAir) continue;
                        AxisAlignedBB axisAlignedBB2 = block.getCollisionBoundingBox(VanillaClip.Field2811.world.getBlockState(new BlockPos(j, i2, i3)), (IBlockAccess) VanillaClip.Field2811.world, new BlockPos(j, i2, i3)).offset((double) j, (double) i2, (double) i3);
                        if (block instanceof BlockHopper) {
                            axisAlignedBB2 = new AxisAlignedBB((double) j, (double) i2, (double) i3, (double) (j + 1), (double) (i2 + 1), (double) (i3 + 1));
                        }
                        if (axisAlignedBB2 == null || !axisAlignedBB.intersects(axisAlignedBB2)) continue;
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception exception) {
            return false;
        }
    }
}

