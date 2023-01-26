/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 */
package me.snow.aclient.mixin.mixins.accessors;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={PlayerControllerMP.class})
public interface IPlayerControllerMP {
    @Accessor(value="curBlockDamageMP")
    public void setCurrentBlockDamage(float var1);

    @Accessor(value="curBlockDamageMP")
    public float getCurrentBlockDamage();

    @Accessor(value="blockHitDelay")
    public void setBlockHitDelay(int var1);

    @Accessor(value="currentPlayerItem")
    public int getCurrentPlayerItem();

    @Accessor(value="currentPlayerItem")
    public void setCurrentPlayerItem(int var1);

    @Invoker(value="syncCurrentPlayItem")
    public void hookSyncCurrentPlayItem();
}

