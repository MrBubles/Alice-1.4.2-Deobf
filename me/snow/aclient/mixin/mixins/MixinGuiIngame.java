

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIllIIlllIlIlIIlIIIlllIIllIIIlllIIllIIllIIIlllIlIIIlllIIIlIIlllIIlIlIIIllIIIlllIlIIlIlllIIIllIllIllIIlIIllIIlllIlllIIlllIIIlIllIllIIIllIIIlllIIllIIIlllIIlllIlIlllIIIlIIlIIIllIllIIlllIIllIIIllIIlIIIlllIllIIIlIIllIIIlIllIIllIllIllIllIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIIlIllIIllIlIIlIIllIIlllIIIllIIllIIlIIlIIllIlIIllIlllIIllIllIIlIIlIIlIIlIIlllIlllIIllIIIlllIIIlIIlIIIllIllIIllIlIllIlllIIIlIllIIlIIIllIlllIlIIlIIIllIIlIIIllIIllIIllIIIllIIlIIllIIlIIllIIlllIIIllIIllIlIIlllIIlIIIlllIlIIIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.af
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.at
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.GuiNewChat
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIllIIlllIlIlIIlIIIlllIIllIIIlllIIllIIllIIIlllIlIIIlllIIIlIIlllIIlIlIIIllIIIlllIlIIlIlllIIIllIllIllIIlIIllIIlllIlllIIlllIIIlIllIllIIIllIIIlllIIllIIIlllIIlllIlIlllIIIlIIlIIIllIllIIlllIIllIIIllIIlIIIlllIllIIIlIIllIIIlIllIIllIllIllIllIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIIlIllIIllIlIIlIIllIIlllIIIllIIllIIlIIlIIllIlIIllIlllIIllIllIIlIIlIIlIIlIIlllIlllIIllIIIlllIIIlIIlIIIllIllIIllIlIllIlllIIIlIllIIlIIIllIlllIlIIlIIIllIIlIIIllIIllIIllIIIllIIlIIllIIlIIllIIlllIIIllIIllIlIIlllIIlIIIlllIlIIIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.af;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.at;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.ScaledResolution;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiIngame.class})
public class MixinGuiIngame
extends Gui {
    @Mutable
    @Shadow
    @Final
    public GuiNewChat persistantChatGUI;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void init(Minecraft mcIn, CallbackInfo ci) {
        this.persistantChatGUI = new IlIIIlIllIIllIlIIlIIllIIlllIIIllIIllIIlIIlIIllIlIIllIlllIIllIllIIlIIlIIlIIlIIlllIlllIIllIIIlllIIIlIIlIIIllIllIIllIlIllIlllIIIlIllIIlIIIllIlllIlIIlIIIllIIlIIIllIIllIIllIIIllIIlIIllIIlIIllIIlllIIIllIIllIlIIlllIIlIIIlllIlIIIll(mcIn);
    }

    @Inject(method={"renderPortal"}, at={@At(value="HEAD")}, cancellable=true)
    protected void renderPortalHook(float n2, ScaledResolution scaledResolution, CallbackInfo info) {
        if (at.Method2162599().Method2150386() && ((Boolean)at.Method2162599().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue()).booleanValue()) {
            info.cancel();
        }
    }

    @Inject(method={"renderPumpkinOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    protected void renderPumpkinOverlayHook(ScaledResolution scaledRes, CallbackInfo info) {
        if (at.Method2162599().Method2150386() && ((Boolean)at.Method2162599().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue()).booleanValue()) {
            info.cancel();
        }
    }

    @Inject(method={"renderPotionEffects"}, at={@At(value="HEAD")}, cancellable=true)
    protected void renderPotionEffectsHook(ScaledResolution scaledRes, CallbackInfo info) {
        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll != null && !((Boolean)IIllIIllIIlllIlIlIIlIIIlllIIllIIIlllIIllIIllIIIlllIlIIIlllIIIlIIlllIIlIlIIIllIIIlllIlIIlIlllIIIllIllIllIIlIIllIIlllIlllIIlllIIIlIllIllIIIllIIIlllIIllIIIlllIIlllIlIlllIIIlIIlIIIllIllIIlllIIllIIIllIIlIIIlllIllIIIlIIllIIIlIllIIllIllIllIllIll.Method2150504().IIIllIllIIIllIIllIlIllIlllIIlIlIIIllIlIIIlIIIlIlIIIlIIIllIlIllIlIllIIllIIlllIlIIlIIllIlIIIllIIllIIlIllIIlllIlllIllIlIIlllIIlllIIllIlIIlllIIIllIIlIllIIlIIllIIllIIIlIlIIIllIIlllIllIIlllIIlllIIIllIIIlIIIllIlIIIlIIlIIIllIIIll.getValue()).booleanValue()) {
            info.cancel();
        }
    }

    @Inject(method={"renderAttackIndicator"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderAttackIndicator(float partialTicks, ScaledResolution p_184045_2_, CallbackInfo ci) {
        af crosshair = new af();
        if (crosshair.Method2150364()) {
            ci.cancel();
        }
    }
}

