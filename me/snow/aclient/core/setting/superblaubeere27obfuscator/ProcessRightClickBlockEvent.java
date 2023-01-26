/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.eventhandler.Cancelable
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class ProcessRightClickBlockEvent
        extends EventStage {
    public BlockPos Field2191;
    public EnumHand Field2192;
    public ItemStack Field2193;

    public ProcessRightClickBlockEvent(BlockPos blockPos, EnumHand enumHand, ItemStack itemStack) {
        this.Field2191 = blockPos;
        this.Field2192 = enumHand;
        this.Field2193 = itemStack;
    }
}

