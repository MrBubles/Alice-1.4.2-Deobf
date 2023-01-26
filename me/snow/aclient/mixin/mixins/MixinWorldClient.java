/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIIlIIIllIIIlllIIllIllIIllIIlIIlIIllIIlIIllIIllIllIIlIIlIIllIIlllIIllIIlIIlIIlIIlIIllIIIlllIIIlIIllIIIllIIIlIIlIIllIlIIIllIIllIlIIIllIIIllIIllIIIllIlIIIlIIIllIlllIIlllIlIlIIlllIIllIIlllIlIIlIIIllIIllIIllIllIlIllIlIllIll$IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIIlIIIllIIIlllIIllIllIIllIIlIIlIIllIIlIIllIIllIllIIlIIlIIllIIlllIIllIIlIIlIIlIIlIIllIIIlllIIIlIIllIIIllIIIlIIlIIllIlIIIllIIllIlIIIllIIIllIIllIIIllIlIIIlIIIllIlllIIlllIlIlIIlllIIllIIlllIlIIlIIIllIIllIIllIllIlIllIlIllIll;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={WorldClient.class})
public abstract class MixinWorldClient {
    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void constructorHook(CallbackInfo callbackInfo) {
        MinecraftForge.EVENT_BUS.post((Event)new IlIIIlIIIllIIIlllIIllIllIIllIIlIIlIIllIIlIIllIIllIllIIlIIlIIllIIlllIIllIIlIIlIIlIIlIIllIIIlllIIIlIIllIIIllIIIlIIlIIllIlIIIllIIllIlIIIllIIIllIIllIIIllIlIIIlIIIllIlllIIlllIlIlIIlllIIllIIlllIlIIlIIIllIIllIIllIllIlIllIlIllIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll((WorldClient)WorldClient.class.cast(this)));
    }
}

