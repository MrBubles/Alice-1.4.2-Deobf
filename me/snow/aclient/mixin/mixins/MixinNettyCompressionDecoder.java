/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.NettyCompressionDecoder
 */
package me.snow.aclient.mixin.mixins;

import net.minecraft.network.NettyCompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={NettyCompressionDecoder.class})
public abstract class MixinNettyCompressionDecoder {
}

