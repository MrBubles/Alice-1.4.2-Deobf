/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.util.math.BlockPos;

public class BlockBreakingEvent
        extends EventStage {
    public BlockPos Field2928;
    public int Field2929;
    public int Field2930;

    public BlockBreakingEvent(BlockPos blockPos, int n2, int n3) {
        this.Field2928 = blockPos;
        this.Field2929 = n2;
        this.Field2930 = n3;
    }
}

