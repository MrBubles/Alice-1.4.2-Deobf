

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ai
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ao
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.bp
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import java.awt.Color;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ai;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ao;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.bp;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderItem.class})
public class MixinRenderItem {
    @Shadow
    private void renderModel(IBakedModel model, int color, ItemStack stack) {
    }

    @Redirect(method={"renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/IBakedModel;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderItem;renderModel(Lnet/minecraft/client/renderer/block/model/IBakedModel;Lnet/minecraft/item/ItemStack;)V"))
    private void yes(RenderItem renderItem, IBakedModel model, ItemStack stack) {
        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150196(ao.class)) {
            this.renderModel(model, new Color(1.0f, 1.0f, 1.0f, (float)((Integer)ao.Method2162546().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue()).intValue() / 255.0f).getRGB(), stack);
        } else {
            this.renderModel(model, -1, stack);
        }
    }

    @Redirect(method={"renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/IBakedModel;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V"))
    private void renderItem(float colorRed, float colorGreen, float colorBlue, float alpha) {
        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150196(ao.class)) {
            GlStateManager.color((float)colorRed, (float)colorGreen, (float)colorBlue, (float)((float)((Integer)ao.Method2162546().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue()).intValue() / 255.0f));
        } else {
            GlStateManager.color((float)colorRed, (float)colorGreen, (float)colorBlue, (float)alpha);
        }
    }

    @Inject(method={"renderItemModel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderItem;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/IBakedModel;)V", shift=At.Shift.BEFORE)})
    private void renderItemModel(ItemStack stack, IBakedModel bakedModel, ItemCameraTransforms.TransformType transform, boolean leftHanded, CallbackInfo ci) {
        IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll event = new IIllIIlllIIlIIlIIllIlllIllIIIllIIllIlllIIllIlIIllIllIIIlIIllIllIlllIIlIIlIllIIllIIIlIIlllIIIlIIIlIIlllIllIlIIlIIIllIllIIllIIIllIlIIIlllIIlllIllIlIIllIIllIIIllIllIllIIIlIIIllIIIlllIIlllIIllIIlIlllIIllIlllIllIIllIIlIIllIIlllIIlIIIll(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        MinecraftForge.EVENT_BUS.post((Event)event);
    }

    @ModifyArg(method={"renderEffect"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderItem;renderModel(Lnet/minecraft/client/renderer/block/model/IBakedModel;I)V"), index=1)
    public int changeColor(int in) {
        Color cc = (Boolean)ai.Method2162378().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue() != false ? IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150586() : new Color((Integer)ai.Method2162378().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue(), (Integer)ai.Method2162378().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue(), (Integer)ai.Method2162378().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue(), (Integer)ai.Method2162378().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue());
        Color cs = new Color(cc.getRed(), cc.getGreen(), cc.getBlue(), (Integer)ai.Method2162378().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue());
        if (((ai)IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150180(ai.class)).Method2150364()) {
            return bp.Method2163384((Color)cs);
        }
        return in;
    }
}

