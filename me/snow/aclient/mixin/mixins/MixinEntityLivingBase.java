/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIllIlllIIlIIlllIllIllIlIlllIIllIIlIIlIIIlIIlIIIllIIllIIlllIIlIIlllIllIIIllIlllIIllIIlIIllIIlllIlllIIllIIIllIlllIIlIIllIIllIIllIIIlIllIIIlIlIIllIIllIIlllIIlIllIIllIIlllIllIlIlIlllIIIllIlIIlIIllIIIlllIIIllIIllIllIIlIIIllIIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIllIIlIIlllIllIIlllIIIlllIIlllIIIllIlllIlIIIlIIllIlIIIllIIllIIlllIllIIlIIIlIIlllIIlllIllIIlllIllIIllIllIIlllIIIlIIllIIlIlIIllIIIlllIIllIIllIIllIllIIIllIIlIIIlllIIIllIIllIlIllIIlllIIlllIIIllIllIIlIlIIllIllIllIIIlIllIIlIIIlIllIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ao
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIllIlllIIlIIlllIllIllIlIlllIIllIIlIIlIIIlIIlIIIllIIllIIlllIIlIIlllIllIIIllIlllIIllIIlIIllIIlllIlllIIllIIIllIlllIIlIIllIIllIIllIIIlIllIIIlIlIIllIIllIIlllIIlIllIIllIIlllIllIlIlIlllIIIllIlIIlIIllIIIlllIIIllIIllIllIIlIIIllIIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIllIIlIIlllIllIIlllIIIlllIIlllIIIllIlllIlIIIlIIllIlIIIllIIllIIlllIllIIlIIIlIIlllIIlllIllIIlllIllIIllIllIIlllIIIlIIllIIlIlIIllIIIlllIIllIIllIIllIllIIIllIIlIIIlllIIIllIIllIlIllIIlllIIlllIIIllIllIIlIlIIllIllIllIIIlIllIIlIIIlIllIIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ao;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityLivingBase.class})
public abstract class MixinEntityLivingBase
extends Entity {
    public MixinEntityLivingBase(World worldIn) {
        super(worldIn);
    }

    @Inject(method={"travel"}, at={@At(value="HEAD")}, cancellable=true)
    public void onTravel(float strafe, float vertical, float forward, CallbackInfo ci) {
        IlIllIlllIIlIIlllIllIllIlIlllIIllIIlIIlIIIlIIlIIIllIIllIIlllIIlIIlllIllIIIllIlllIIllIIlIIllIIlllIlllIIllIIIllIlllIIlIIllIIllIIllIIIlIllIIIlIlIIllIIllIIlllIIlIllIIllIIlllIllIlIlIlllIIIllIlIIlIIllIIIlllIIIllIIllIllIIlIIIllIIl event = new IlIllIlllIIlIIlllIllIllIlIlllIIllIIlIIlIIIlIIlIIIllIIllIIlllIIlIIlllIllIIIllIlllIIllIIlIIllIIlllIlllIIllIIIllIlllIIlIIllIIllIIllIIIlIllIIIlIlIIllIIllIIlllIIlIllIIllIIlllIllIlIlIlllIIIllIlIIlIIllIIIlllIIIllIIllIllIIlIIIllIIl((Entity)this);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"getArmSwingAnimationEnd"}, at={@At(value="HEAD")}, cancellable=true)
    private void getArmSwingAnimationEnd(CallbackInfoReturnable<Integer> info) {
        if (((ao)IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150180(ao.class)).Method2150364() && ((Boolean)ao.Method2162546().IIllIllIIllIIlllIIlIIlIIIlIllIllIIlIIIlllIIllIIllIlllIIllIIlIIlllIlllIllIlllIIllIIlIlllIlllIlIlllIllIlllIIlIlllIIlIIlIIlllIIlllIlIlIIIllIlIllIllIIllIIIlllIIIllIllIIlIlIllIllIIIllIIIlIlIIlllIIIllIlIlIIlIlllIIlllIIllIIIl.getValue()).booleanValue()) {
            info.setReturnValue((int)((Integer)ao.Method2162546().IIlIlllIIIllIIlllIIlIIllIIlIlIIlIIlIIlllIIlllIIIllIIlllIIllIIllIIlIIlIIlIIIlIIlllIIlllIlIIIlIllIIIlllIlIIIlIlIIIlllIIlIllIIllIIIlIIlllIIllIIIlIIllIIllIIlllIIllIIllIIllIIIllIIIllIIIlIIllIlllIlllIllIIlllIlIlllIIlIIlIlllIIlIIIllIIllIIl.getValue()));
        }
    }

    @Inject(method={"handleJumpWater"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleJumpWater(CallbackInfo ci) {
        IlllIllIIlIIlllIllIIlllIIIlllIIlllIIIllIlllIlIIIlIIllIlIIIllIIllIIlllIllIIlIIIlIIlllIIlllIllIIlllIllIIllIllIIlllIIIlIIllIIlIlIIllIIIlllIIllIIllIIllIllIIIllIIlIIIlllIIIllIIllIlIllIIlllIIlllIIIllIllIIlIlIIllIllIllIIIlIllIIlIIIlIllIIlll event = new IlllIllIIlIIlllIllIIlllIIIlllIIlllIIIllIlllIlIIIlIIllIlIIIllIIllIIlllIllIIlIIIlIIlllIIlllIllIIlllIllIIllIllIIlllIIIlIIllIIlIlIIllIIIlllIIllIIllIIllIllIIIllIIlIIIlllIIIllIIllIlIllIIlllIIlllIIIllIllIIlIlIIllIllIllIIIlIllIIlIIIlIllIIlll();
        if (event.isCanceled()) {
            ci.cancel();
        }
    }

    @Inject(method={"handleJumpLava"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleJumpLava(CallbackInfo ci) {
        IlllIllIIlIIlllIllIIlllIIIlllIIlllIIIllIlllIlIIIlIIllIlIIIllIIllIIlllIllIIlIIIlIIlllIIlllIllIIlllIllIIllIllIIlllIIIlIIllIIlIlIIllIIIlllIIllIIllIIllIllIIIllIIlIIIlllIIIllIIllIlIllIIlllIIlllIIIllIllIIlIlIIllIllIllIIIlIllIIlIIIlIllIIlll event = new IlllIllIIlIIlllIllIIlllIIIlllIIlllIIIllIlllIlIIIlIIllIlIIIllIIllIIlllIllIIlIIIlIIlllIIlllIllIIlllIllIIllIllIIlllIIIlIIllIIlIlIIllIIIlllIIllIIllIIllIllIIIllIIlIIIlllIIIllIIllIlIllIIlllIIlllIIIllIllIIlIlIIllIllIllIIIlIllIIlIIIlIllIIlll();
        if (event.isCanceled()) {
            ci.cancel();
        }
    }
}

