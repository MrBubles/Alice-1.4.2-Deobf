

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIllIIlIIllIIllIIlllIIlllIllIIIllIIIlllIIlIlIIlIIllIlIIllIllIIlIIllIllIlIIllIllIlllIIIlIIIllIIllIIlIllIIIllIlIIllIIllIIllIlIIlllIIlIIIlllIIIlllIIllIIlllIIIlllIIIllIIIllIIllIIllIIllIlllIlIIIlllIIlIIIlIlllIIllIIllIIllIIIlIIllIIlllIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.w
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import com.mojang.authlib.GameProfile;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIllIIlIIllIIllIIlllIIlllIllIIIllIIIlllIIlIlIIlIIllIlIIllIllIIlIIllIllIlIIllIllIlllIIIlIIIllIIllIIlIllIIIllIlIIllIIllIIllIlIIlllIIlIIIlllIIIlllIIllIIlllIIIlllIIIllIIIllIIllIIllIIllIlllIlIIIlllIIlIIIlIlllIIllIIllIIllIIIlIIllIIlllIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.w;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityPlayer.class})
public abstract class MixinEntityPlayer
extends EntityLivingBase {
    public MixinEntityPlayer(World worldIn, GameProfile gameProfileIn) {
        super(worldIn);
    }

    @Inject(method={"getCooldownPeriod"}, at={@At(value="HEAD")}, cancellable=true)
    private void getCooldownPeriodHook(CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (w.Method2162200().Method2150386() && ((Boolean)w.Method2162200().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).booleanValue()) {
            callbackInfoReturnable.setReturnValue(Float.valueOf((float)(1.0 / this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getAttributeValue() * 20.0 * (double)IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlIllIllIIllIIIlllIlIllIIlIIlIlIIllIllIIIlllIllIllIIIllIlIlIIIlIIIllIIllIIlIllIIlIIlllIIlIIlllIllIIIllIIllIIIlIllIlllIIllIIIllIlIlIIIlIlIIllIIllIIlllIIIlIIllIllIllIIIlllIIlllIllIIlIIlIIlIIllIIllIIlIIIlllIIlIIlll.Method2150202())));
        }
    }

    @Inject(method={"travel"}, at={@At(value="HEAD")}, cancellable=true)
    public void travel(float strafe, float vertical, float forward, CallbackInfo info) {
        if (this.equals((Object)Minecraft.getMinecraft().player)) {
            IIllIIllIIlIIllIIllIIlllIIlllIllIIIllIIIlllIIlIlIIlIIllIlIIllIllIIlIIllIllIlIIllIllIlllIIIlIIIllIIllIIlIllIIIllIlIIllIIllIIllIlIIlllIIlIIIlllIIIlllIIllIIlllIIIlllIIIllIIIllIIllIIllIIllIlllIlIIIlllIIlIIIlIlllIIllIIllIIllIIIlIIllIIlllIlll event = new IIllIIllIIlIIllIIllIIlllIIlllIllIIIllIIIlllIIlIlIIlIIllIlIIllIllIIlIIllIllIlIIllIllIlllIIIlIIIllIIllIIlIllIIIllIlIIllIIllIIllIlIIlllIIlIIIlllIIIlllIIllIIlllIIIlllIIIllIIIllIIllIIllIIllIlllIlIIIlllIIlIIIlIlllIIllIIllIIllIIIlIIllIIlllIlll(strafe, vertical, forward);
            MinecraftForge.EVENT_BUS.post((Event)event);
            if (event.isCanceled()) {
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                info.cancel();
            }
        }
    }
}

