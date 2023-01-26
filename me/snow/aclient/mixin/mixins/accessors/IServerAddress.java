/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ServerAddress
 */
package me.snow.aclient.mixin.mixins.accessors;

import net.minecraft.client.multiplayer.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={ServerAddress.class})
public interface IServerAddress {
    @Invoker(value="getServerAddress")
    public static String[] getServerAddress(String string) {
        throw new IllegalStateException("Mixin didn't transform this");
    }
}

