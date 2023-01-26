/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package me.snow.aclient.mixin.mixins.accessors;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Entity.class}, priority=0x7FFFFFFF)
public interface IEntity {
    @Invoker(value="setFlag")
    public void invokeSetFlag(int var1, boolean var2);

    @Accessor(value="inPortal")
    public void setInPortal(boolean var1);
}

