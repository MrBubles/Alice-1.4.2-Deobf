/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIlllIIIllIlllIlllIIlllIIIllIIIlllIIIllIIlIIlIllIIllIlIIllIIlIlllIlIIIlllIllIIlIlIIIlllIIlIlIlIlllIIIllIlIllIlllIIlIIlIlIlIIllIIIlllIIlIlIIlllIIlIIIlllIIIlIllIlIllIIllIIIlIIIllIIllIlllIIlIIllIllIIllIIIllIIlllIIlIllIIl
 *  net.minecraft.client.gui.MapItemRenderer
 *  net.minecraft.world.storage.MapData
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIlllIIIllIlllIlllIIlllIIIllIIIlllIIIllIIlIIlIllIIllIlIIllIIlIlllIlIIIlllIllIIlIlIIIlllIIlIlIlIlllIIIllIlIllIlllIIlIIlIlIlIIllIIIlllIIlIlIIlllIIlIIIlllIIIlIllIlIllIIllIIIlIIIllIIllIlllIIlIIllIllIIllIIIllIIlllIIlIllIIl;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MapItemRenderer.class})
public class MixinMapItemRenderer {
    @Inject(method={"renderMap"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderMap(MapData mapdataIn, boolean noOverlayRendering, CallbackInfo info) {
        IlIIlllIIIllIlllIlllIIlllIIIllIIIlllIIIllIIlIIlIllIIllIlIIllIIlIlllIlIIIlllIllIIlIlIIIlllIIlIlIlIlllIIIllIlIllIlllIIlIIlIlIlIIllIIIlllIIlIlIIlllIIlIIIlllIIIlIllIlIllIIllIIIlIIIllIIllIlllIIlIIllIllIIllIIIllIIlllIIlIllIIl renderMapEvent = new IlIIlllIIIllIlllIlllIIlllIIIllIIIlllIIIllIIlIIlIllIIllIlIIllIIlIlllIlIIIlllIllIIlIlIIIlllIIlIlIlIlllIIIllIlIllIlllIIlIIlIlIlIIllIIIlllIIlIlIIlllIIlIIIlllIIIlIllIlIllIIllIIIlIIIllIIllIlllIIlIIllIllIIllIIIllIIlllIIlIllIIl();
        MinecraftForge.EVENT_BUS.post((Event)renderMapEvent);
        if (renderMapEvent.isCanceled()) {
            info.cancel();
        }
    }
}

