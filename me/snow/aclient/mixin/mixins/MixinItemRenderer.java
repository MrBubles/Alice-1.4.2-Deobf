

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ao
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.at
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.EnumHandSide
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ao;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.at;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ItemRenderer.class})
public abstract class MixinItemRenderer {
    public Minecraft mc;
    private boolean injection = true;

    @Shadow
    public abstract void renderItemInFirstPerson(AbstractClientPlayer var1, float var2, float var3, EnumHand var4, float var5, ItemStack var6, float var7);

    @Inject(method={"renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderItemInFirstPersonHook(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_, CallbackInfo info) {
        if (this.injection) {
            info.cancel();
            ao offset = ao.Method2162546();
            float xOffset = 0.0f;
            float yOffset = 0.0f;
            this.injection = false;
            if (hand == EnumHand.MAIN_HAND) {
                if (offset.Method2150386() && player.getHeldItemMainhand() != ItemStack.EMPTY) {
                    xOffset = ((Float)offset.IIllIIIlllIIIllIIIllIIlIIllIIllIIIlllIIlIIIllIIllIIIlIIIlllIIlllIIlllIIllIIlIlllIlllIlIlIlllIllIIIllIIIllIlIlIllIlIllIIlllIllIlIIlIIIlIlIIllIlllIIlIllIIIlIlllIIllIllIIlIIlllIIlllIIIllIIllIlllIIlIlIIIllIIllIIIlIIIllIIllIIllIIIlllIIll.getValue()).floatValue();
                    yOffset = ((Float)offset.IIlIIlIllIIllIIllIIIlIIIlllIIIlIIlllIIIlIIllIIlIIlIIllIIIllIlllIIIlllIIlIlIIIllIIlllIIlIlllIIllIIlIIllIIlIllIllIIlIIllIIllIIllIIlllIIlIIllIlIIllIlIIllIlllIllIlllIIIlIIllIIlllIlIllIIlIllIIlIIllIIIllIllIIlIIIlIllIllIlllIll.getValue()).floatValue();
                }
            } else if (!((Boolean)offset.IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue()).booleanValue() && offset.Method2150386() && player.getHeldItemOffhand() != ItemStack.EMPTY) {
                xOffset = ((Float)offset.IllIlllIIllIIlIIlIlIIIllIIllIIlllIIIlIIlIIlllIIlIlIIIlIlIIIlIIllIlllIIIlllIIllIllIllIIlllIlIllIIlIlIIIlIlIlllIIIlIlllIIlIIllIIlIIllIllIIllIlllIIIllIllIlIIIllIIllIIllIIlIIIlIIlIlIIIllIIllIllIlllIIIllIIIllIIIlllIIlIIIlIlll.getValue()).floatValue();
                yOffset = ((Float)offset.IIllIIlIlIIlllIIllIIllIIIlllIIIlllIllIIllIIlllIlIIllIIllIllIIlIIllIIlIlllIIIlIIlIllIIIllIIIlllIIlIIIlllIIIlllIIlIllIIIllIIlIlIllIlIIllIlIIIlllIIllIIlIIIlIIlIIlIlIlllIlIIIlIIlIIlllIllIllIllIIIlllIIllIIIllIIllIIlllIIlIllIlIIll.getValue()).floatValue();
            }
            this.renderItemInFirstPerson(player, p_187457_2_, p_187457_3_, hand, p_187457_5_ + xOffset, stack, p_187457_7_ + yOffset);
            this.injection = true;
        }
    }

    @Inject(method={"transformSideFirstPerson"}, at={@At(value="HEAD")}, cancellable=true)
    public void transformSideFirstPerson(EnumHandSide hand, float p_187459_2_, CallbackInfo cancel) {
        IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll event = new IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        MinecraftForge.EVENT_BUS.post((Event)event);
    }

    @Redirect(method={"renderArmFirstPerson"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal=0))
    public void translateHook(float x, float y, float z) {
        ao offset = ao.Method2162546();
        boolean shiftPos = Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().player.getHeldItemMainhand() != ItemStack.EMPTY && offset.Method2150386();
        GlStateManager.translate((float)(x + (shiftPos ? ((Float)offset.IIllIIIlllIIIllIIIllIIlIIllIIllIIIlllIIlIIIllIIllIIIlIIIlllIIlllIIlllIIllIIlIlllIlllIlIlIlllIllIIIllIIIllIlIlIllIlIllIIlllIllIlIIlIIIlIlIIllIlllIIlIllIIIlIlllIIllIllIIlIIlllIIlllIIIllIIllIlllIIlIlIIIllIIllIIIlIIIllIIllIIllIIIlllIIll.getValue()).floatValue() : 0.0f)), (float)(y + (shiftPos ? ((Float)offset.IIlIIlIllIIllIIllIIIlIIIlllIIIlIIlllIIIlIIllIIlIIlIIllIIIllIlllIIIlllIIlIlIIIllIIlllIIlIlllIIllIIlIIllIIlIllIllIIlIIllIIllIIllIIlllIIlIIllIlIIllIlIIllIlllIllIlllIIIlIIllIIlllIlIllIIlIllIIlIIllIIIllIllIIlIIIlIllIllIlllIll.getValue()).floatValue() : 0.0f)), (float)z);
    }

    @Inject(method={"renderFireInFirstPerson"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderFireInFirstPersonHook(CallbackInfo info) {
        if (at.Method2162599().Method2150386() && ((Boolean)at.Method2162599().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).booleanValue()) {
            info.cancel();
        }
    }

    @Inject(method={"renderSuffocationOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderSuffocationOverlay(CallbackInfo ci) {
        if (at.Method2162599().Method2150386() && ((Boolean)at.Method2162599().IlIIlllIlllIlllIIIlIIlIIlIIllIIIllIlllIIllIIlIIllIllIIllIIIllIIlIlIIllIIllIllIIIlIlIIIllIIlllIllIIlIllIIlIllIlllIIllIlllIllIlllIllIIIllIllIIlIIIlIIlllIIIlIllIllIllIlllIllIIlllIlIIIlllIIlllIllIlIIlIllIIIlllIIIllIIIllIIlIl.getValue()).booleanValue()) {
            ci.cancel();
        }
    }
}

