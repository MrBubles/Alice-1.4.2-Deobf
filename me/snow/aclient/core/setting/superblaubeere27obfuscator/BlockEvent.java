/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.eventhandler.Cancelable
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class BlockEvent
        extends EventStage {
    public BlockPos Field3432;
    public EnumFacing Field3433;

    public BlockEvent(int n2, BlockPos blockPos, EnumFacing enumFacing) {
        super(n2);
        this.Field3432 = blockPos;
        this.Field3433 = enumFacing;
    }
}

