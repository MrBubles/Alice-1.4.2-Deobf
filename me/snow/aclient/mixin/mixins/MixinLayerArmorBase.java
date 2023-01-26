

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ai
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.at
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.at$IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.layers.LayerArmorBase
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.inventory.EntityEquipmentSlot
 */
package me.snow.aclient.mixin.mixins;

import java.awt.Color;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ai;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.at;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LayerArmorBase.class})
public class MixinLayerArmorBase {
    @Inject(method={"doRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, CallbackInfo ci) {
        if (at.Method2162599().Method2150364() && at.Method2162599().IlllIllIIllIllIIIlllIllIIIlllIIlIIllIIlIllIIlllIIllIIIlIlIlllIIlIlIllIIIllIlllIlllIllIIIllIIIlIIIlIIIlIIIlIIllIllIIIllIllIlIIIlllIIllIIllIIllIIlllIIIlIIIlIIIlIllIIIlllIIlllIlllIIlIIIlIIlllIlIIllIIllIIIllIIlllIlIIIlIllIIlllIIIlllIIllIIIlll.getValue() == at.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
            ci.cancel();
        }
    }

    @Inject(method={"renderArmorLayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderArmorLayer(EntityLivingBase entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, EntityEquipmentSlot slotIn, CallbackInfo ci) {
        if (at.Method2162599().Method2150364() && at.Method2162599().IlllIllIIllIllIIIlllIllIIIlllIIlIIllIIlIllIIlllIIllIIIlIlIlllIIlIlIllIIIllIlllIlllIllIIIllIIIlIIIlIIIlIIIlIIllIllIIIllIllIlIIIlllIIllIIllIIllIIlllIIIlIIIlIIIlIllIIIlllIIlllIlllIIlIIIlIIlllIlIIllIIllIIIllIIlllIlIIIlIllIIlllIIIlllIIllIIIlll.getValue() == at.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll && slotIn == EntityEquipmentSlot.HEAD) {
            ci.cancel();
        }
    }

    @Redirect(method={"renderEnchantedGlint"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V"))
    private static void onRenderEnchantedGlint(float colorRed, float colorGreen, float colorBlue, float colorAlpha) {
        Color cc;
        Color color = cc = (Boolean)ai.Method2162378().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue() != false ? IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150586() : new Color((Integer)ai.Method2162378().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue(), (Integer)ai.Method2162378().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue(), (Integer)ai.Method2162378().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue(), (Integer)ai.Method2162378().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue());
        if (colorBlue == 0.608f && ((ai)IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150180(ai.class)).Method2150364()) {
            GlStateManager.color((float)((float)cc.getRed() / 255.0f), (float)((float)cc.getGreen() / 255.0f), (float)((float)cc.getBlue() / 255.0f), (float)((float)((Integer)ai.Method2162378().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).intValue() / 255.0f));
        } else {
            GlStateManager.color((float)colorRed, (float)colorGreen, (float)colorBlue, (float)colorAlpha);
        }
    }
}

