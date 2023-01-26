

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIlllIlIIlIIlllIllIIlllIIlllIlIIIllIIIlllIIlIIllIllIllIIllIIIllIIlllIllIIIlIllIIlIIlllIIllIllIlIIllIllIIllIIIllIIlIIlllIIlIIIlIlllIIllIIllIIlllIIllIIlllIIIlllIlIIlllIIllIIllIIlIIlIllIIllIlllIIIllIIllIIllIlllIIIllIlllIIllIllIIIlIl
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIlllIlIIlIIlllIllIIlllIIlllIlIIIllIIIlllIIlIIllIllIllIIllIIIllIIlllIllIIIlIllIIlIIlllIIllIllIlIIllIllIIllIIIllIIlIIlllIIlIIIlIlllIIllIIllIIlllIIllIIlllIIIlllIlIIlllIIllIIllIIlIIlIllIIllIlllIIIllIIllIIllIlllIIIllIlllIIllIllIIIlIl;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={KeyBinding.class})
public class MixinKeyBinding {
    @Shadow
    private boolean pressed;

    @Inject(method={"isKeyDown"}, at={@At(value="RETURN")}, cancellable=true)
    private void isKeyDown(CallbackInfoReturnable<Boolean> info) {
        IIllIIIlllIlIIlIIlllIllIIlllIIlllIlIIIllIIIlllIIlIIllIllIllIIllIIIllIIlllIllIIIlIllIIlIIlllIIllIllIlIIllIllIIllIIIllIIlIIlllIIlIIIlIlllIIllIIllIIlllIIllIIlllIIIlllIlIIlllIIllIIllIIlIIlIllIIllIlllIIIllIIllIIllIlllIIIllIlllIIllIllIIIlIl event = new IIllIIIlllIlIIlIIlllIllIIlllIIlllIlIIIllIIIlllIIlIIllIllIllIIllIIIllIIlllIllIIIlIllIIlIIlllIIllIllIlIIllIllIIllIIIllIIlIIlllIIlIIIlIlllIIllIIllIIlllIIllIIlllIIIlllIlIIlllIIllIIllIIlIIlIllIIllIlllIIIllIIllIIllIlllIIIllIlllIIllIllIIIlIl(0, info.getReturnValue().booleanValue(), this.pressed);
        MinecraftForge.EVENT_BUS.post((Event)event);
        info.setReturnValue(event.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
    }
}

