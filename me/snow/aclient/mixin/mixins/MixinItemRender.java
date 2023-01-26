

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ao
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.item.ItemStack
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ao;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderItem.class})
public abstract class MixinItemRender {
    @Inject(method={"renderItemModel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderItem;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/IBakedModel;)V", shift=At.Shift.BEFORE)})
    private void test(ItemStack stack, IBakedModel bakedmodel, ItemCameraTransforms.TransformType transform, boolean leftHanded, CallbackInfo ci) {
        if (((Boolean)ao.Method2162546().IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.getValue()).booleanValue() && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll.Method2150359()) {
            GlStateManager.scale((float)((Float)ao.Method2162546().IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.getValue()).floatValue(), (float)((Float)ao.Method2162546().IlIllIIlllIIlllIIlllIIIllIIIllIIlllIlIIllIllIIIllIlIIlllIlIIlIIllIllIlIIlIllIIIllIIllIIIllIllIlIIIlllIIIlIIlllIIlIIIlllIIIllIIIllIIlllIIllIIlIIIllIIllIIlllIIllIlIllIIllIIllIllIIIllIIllIIlIIIlIIlllIIIlIIlllIIlIIIllIlIlllIlIllIIlIIIll.getValue()).floatValue(), (float)((Float)ao.Method2162546().IIlIllIlIIllIllIIlIIIllIIlIIllIIlIllIlIllIllIIlIIlIlllIllIllIlllIIIlIIlIIIlIIlllIIlllIIlIIlIIIllIIlllIllIIIlIllIIlllIlIIlllIIlllIllIIlIIlIllIlllIllIllIIlIllIIIlIIlllIIllIIllIllIIlllIlIIlIllIIllIlIIllIIllIIIlllIll.getValue()).floatValue());
            GlStateManager.rotate((float)(((Float)ao.Method2162546().IllIllIIIlIllIllIIllIIIlllIlIllIIlIIlIlIIllIllIIIlllIllIllIIIllIlIlIIIlIIIllIIllIIlIllIIlIIlllIIlIIlllIllIIIllIIllIIIlIllIlllIIllIIIllIlIlIIIlIlIIllIIllIIlllIIIlIIllIllIllIIIlllIIlllIllIIlIIlIIlIIllIIllIIlIIIlllIIlIIlll.getValue()).floatValue() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)(((Float)ao.Method2162546().IlllIllIIllIllIIIlllIllIIIlllIIlIIllIIlIllIIlllIIllIIIlIlIlllIIlIlIllIIIllIlllIlllIllIIIllIIIlIIIlIIIlIIIlIIllIllIIIllIllIlIIIlllIIllIIllIIllIIlllIIIlIIIlIIIlIllIIIlllIIlllIlllIIlIIIlIIlllIlIIllIIllIIIllIIlllIlIIIlIllIIlllIIIlllIIllIIIlll.getValue()).floatValue() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(((Float)ao.Method2162546().IIIllIllIIIllIIllIlIllIlllIIlIlIIIllIlIIIlIIIlIlIIIlIIIllIlIllIlIllIIllIIlllIlIIlIIllIlIIIllIIllIIlIllIIlllIlllIllIlIIlllIIlllIIllIlIIlllIIIllIIlIllIIlIIllIIllIIIlIlIIIllIIlllIllIIlllIIlllIIIllIIIlIIIllIlIIIlIIlIIIllIIIll.getValue()).floatValue() * 360.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.translate((float)((Float)ao.Method2162546().IlIIlllIlllIlllIIIlIIlIIlIIllIIIllIlllIIllIIlIIllIllIIllIIIllIIlIlIIllIIllIllIIIlIlIIIllIIlllIllIIlIllIIlIllIlllIIllIlllIllIlllIllIIIllIllIIlIIIlIIlllIIIlIllIllIllIlllIllIIlllIlIIIlllIIlllIllIlIIlIllIIIlllIIIllIIIllIIlIl.getValue()).floatValue(), (float)((Float)ao.Method2162546().IIllIIlllIllIIllIIIlllIIlllIIllIIllIIlIIllIIllIllIIlllIlllIIlIIllIIllIlllIllIIllIIIlllIllIlllIIlIIlllIllIIIllIlllIIIlIllIIIllIIlIIllIIlIIIllIIIllIIIllIIIllIIIllIlIIllIIIlIIllIIllIllIIlllIIlllIIIllIIlIlIIllIlIIllIIlIIlIIlllIllIIlllIIllIIIl.getValue()).floatValue(), (float)((Float)ao.Method2162546().IIlllIIIlIlllIIlIIllIllIlllIIllIlIllIlIIllIlllIIllIllIlllIlllIIllIIllIIIllIIIllIIIlIIllIllIIIllIIllIIlIlllIIlIIllIIIllIlIllIIIllIIIllIIllIlllIIIlIIllIIIlllIIllIIllIIIllIlIIIlllIIllIIllIIlllIIlllIlllIlIIllIlIIIllIIlllIllIllIIIllIIlllIlll.getValue()).floatValue());
        }
    }
}

