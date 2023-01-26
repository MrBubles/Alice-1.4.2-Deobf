/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIIlIlIIIllIlllIIllIIlIIlIIlllIIllIlIlllIIllIIllIIlllIllIllIIlIIlIIlllIIlllIlIllIIllIIlllIIllIIllIIllIllIlIllIIIlIlIIIllIIIlIIlIlIIllIllIlllIIlIIllIIlIlIIIlIIllIIIlIIlIIlIlllIIIlIlllIIllIIlllIIlllIIlllIIllIIIllIlIIl
 *  net.minecraft.entity.passive.EntityPig
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIIlIlIIIllIlllIIllIIlIIlIIlllIIllIlIlllIIllIIllIIlllIllIllIIlIIlIIlllIIlllIlIllIIllIIlllIIllIIllIIllIllIlIllIIIlIlIIIllIIIlIIlIlIIllIllIlllIIlIIllIIlIlIIIlIIllIIIlIIlIIlIlllIIIlIlllIIllIIlllIIlllIIlllIIllIIIllIlIIl;
import net.minecraft.entity.passive.EntityPig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityPig.class})
public class MixinEntityPig {
    @Inject(method={"canBeSteered"}, at={@At(value="HEAD")}, cancellable=true)
    public void canBeSteered(CallbackInfoReturnable<Boolean> returnable) {
        if (IlIIIlIlIIIllIlllIIllIIlIIlIIlllIIllIlIlllIIllIIllIIlllIllIllIIlIIlIIlllIIlllIlIllIIllIIlllIIllIIllIIllIllIlIllIIIlIlIIIllIIIlIIlIlIIllIllIlllIIlIIllIIlIlIIIlIIllIIIlIIlIIlIlllIIIlIlllIIllIIlllIIlllIIlllIIllIIIllIlIIl.IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.Method2150364()) {
            returnable.setReturnValue(true);
            returnable.cancel();
        }
    }
}

