/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketVehicleMove
 */
package me.snow.aclient.mixin.mixins.accessors;

import net.minecraft.network.play.client.CPacketVehicleMove;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketVehicleMove.class})
public interface ICPacketVehicleMove {
    @Accessor(value="y")
    public void setY(double var1);

    @Accessor(value="y")
    public double getY();
}

