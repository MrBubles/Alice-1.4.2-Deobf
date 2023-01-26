/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 */
package me.snow.aclient.mixin.mixins.accessors;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={NetworkManager.class})
public interface INetworkManager {
    @Invoker(value="dispatchPacket")
    public void hookDispatchPacket(Packet<?> var1, GenericFutureListener<? extends Future<? super Void>>[] var2);
}

