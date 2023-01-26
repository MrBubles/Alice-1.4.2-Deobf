/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlIIIllIIlIIlIIlllIIIllIlIIllIIllIllIlIIllIllIIlIIllIIIllIIIlllIllIIlIllIIlIIllIIIlIIlllIIlllIIlllIIIlllIIlllIIlllIIlIIIllIllIllIIIlIllIIlIIllIIIlIlIIlllIIIlllIIllIIllIIIlIIllIlIlIIllIlllIIIllIIIllIIlllIIlIlIIllIIllIIIllIlllIlll
 *  net.minecraft.entity.passive.AbstractHorse
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlIIIllIIlIIlIIlllIIIllIlIIllIIllIllIlIIllIllIIlIIllIIIllIIIlllIllIIlIllIIlIIllIIIlIIlllIIlllIIlllIIIlllIIlllIIlllIIlIIIllIllIllIIIlIllIIlIIllIIIlIlIIlllIIIlllIIllIIllIIIlIIllIlIlIIllIlllIIIllIIIllIIlllIIlIlIIllIIllIIIllIlllIlll;
import net.minecraft.entity.passive.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={AbstractHorse.class})
public class MixinAbstractHorse {
    @Inject(method={"isHorseSaddled"}, at={@At(value="HEAD")}, cancellable=true)
    public void isHorseSaddled(CallbackInfoReturnable<Boolean> cir) {
        if (IllIIIlIIIllIIlIIlIIlllIIIllIlIIllIIllIllIlIIllIllIIlIIllIIIllIIIlllIllIIlIllIIlIIllIIIlIIlllIIlllIIlllIIIlllIIlllIIlllIIlIIIllIllIllIIIlIllIIlIIllIIIlIlIIlllIIIlllIIllIIllIIIlIIllIlIlIIllIlllIIIllIIIllIIlllIIlIlIIllIIllIIIllIlllIlll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150364()) {
            cir.setReturnValue(true);
        }
    }
}

