

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIllIIlllIlIlIIlIIIlllIIllIIIlllIIllIIllIIIlllIlIIIlllIIIlIIlllIIlIlIIIllIIIlllIlIIlIlllIIIllIllIllIIlIIllIIlllIlllIIlllIIIlIllIllIIIllIIIlllIIllIIIlllIIlllIlIlllIIIlIIlIIIllIllIIlllIIllIIIllIIlIIIlllIllIIIlIIllIIIlIllIIllIllIllIllIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlllIllIIllIlllIlIIlIIllIllIIllIIIlIIlllIllIlllIlIIllIIIllIIIllIIlIIlIlllIllIIIllIIllIIIllIIlIIlIlllIIlIIlIIIlIIlllIlIIllIIllIIlIllIlIIIlIIlllIllIIIlIIIlIIIlIllIIllIIIlIllIIlIIllIIllIllIIIlIlIIllIlllIIIlllIIIlllIllIIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlllIllIllIIIlllIIlllIlllIIlllIlllIllIlIIIlIIIlIIIlIllIlllIllIlIIIlIlIIIlllIIllIIIlllIIlIIllIIIlIlIIIllIIllIlIIIlllIllIIIllIIllIIIlIIlIlllIIllIlIIIlIIllIIllIlllIIlIllIIllIIIlIIlllIIllIlllIIlIIllIlllIIllIIIlllIIllIllIIlllIIIlllIIIllIIll
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIllIIlllIlIlIIlIIIlllIIllIIIlllIIllIIllIIIlllIlIIIlllIIIlIIlllIIlIlIIIllIIIlllIlIIlIlllIIIllIllIllIIlIIllIIlllIlllIIlllIIIlIllIllIIIllIIIlllIIllIIIlllIIlllIlIlllIIIlIIlIIIllIllIIlllIIllIIIllIIlIIIlllIllIIIlIIllIIIlIllIIllIllIllIllIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlllIllIIllIlllIlIIlIIllIllIIllIIIlIIlllIllIlllIlIIllIIIllIIIllIIlIIlIlllIllIIIllIIllIIIllIIlIIlIlllIIlIIlIIIlIIlllIlIIllIIllIIlIllIlIIIlIIlllIllIIIlIIIlIIIlIllIIllIIIlIllIIlIIllIIllIllIIIlIlIIllIlllIIIlllIIIlllIllIIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlllIllIllIIIlllIIlllIlllIIlllIlllIllIlIIIlIIIlIIIlIllIlllIllIlIIIlIlIIIlllIIllIIIlllIIlIIllIIIlIlIIIllIIllIlIIIlllIllIIIllIIllIIIlIIlIlllIIllIlIIIlIIllIIllIlllIIlIllIIllIIIlIIlllIIllIlllIIlIIllIlllIIllIIIlllIIllIllIIlllIIIlllIIIllIIll;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={FontRenderer.class})
public abstract class MixinFontRenderer {
    @Shadow
    protected abstract int renderString(String var1, float var2, float var3, int var4, boolean var5);

    @Shadow
    protected abstract void renderStringAtPos(String var1, boolean var2);

    @Inject(method={"drawString(Ljava/lang/String;FFIZ)I"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderStringHook(String text, float x2, float y, int color, boolean dropShadow, CallbackInfoReturnable<Integer> info) {
        if (IIlllIllIllIIIlllIIlllIlllIIlllIlllIllIlIIIlIIIlIIIlIllIlllIllIlIIIlIlIIIlllIIllIIIlllIIlIIllIIIlIlIIIllIIllIlIIIlllIllIIIllIIllIIIlIIlIlllIIllIlIIIlIIllIIllIlllIIlIllIIllIIIlIIlllIIllIlllIIlIIllIlllIIllIIIlllIIllIllIIlllIIIlllIIIllIIll.Method2150594().Method2150386() && ((Boolean)IIlllIllIllIIIlllIIlllIlllIIlllIlllIllIlIIIlIIIlIIIlIllIlllIllIlIIIlIlIIIlllIIllIIIlllIIlIIllIIIlIlIIIllIIllIlIIIlllIllIIIllIIllIIIlIIlIlllIIllIlIIIlIIllIIllIlllIIlIllIIllIIIlIIlllIIllIlllIIlIIllIlllIIllIIIlllIIllIllIIlllIIIlllIIIllIIll.Method2150594().IIlIIlIllIIllIIllIIIlIIIlllIIIlIIlllIIIlIIllIIlIIlIIllIIIllIlllIIIlllIIlIlIIIllIIlllIIlIlllIIllIIlIIllIIlIllIllIIlIIllIIllIIllIIlllIIlIIllIlIIllIlIIllIlllIllIlllIIIlIIllIIlllIlIllIIlIllIIlIIllIIIllIllIIlIIIlIllIllIlllIll.getValue()).booleanValue() && IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IlIllIIlllIIlllIIlllIIIllIIIllIIlllIlIIllIllIIIllIlIIlllIlIIlIIllIllIlIIlIllIIIllIIllIIIllIllIlIIIlllIIIlIIlllIIlIIIlllIIIllIIIllIIlllIIllIIlIIIllIIllIIlllIIllIlIllIIllIIllIllIIIllIIllIIlIIIlIIlllIIIlIIlllIIlIIIllIlIlllIlIllIIlIIIll != null) {
            float result = IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IlIllIIlllIIlllIIlllIIIllIIIllIIlllIlIIllIllIIIllIlIIlllIlIIlIIllIllIlIIlIllIIIllIIllIIIllIllIlIIIlllIIIlIIlllIIlIIIlllIIIllIIIllIIlllIIllIIlIIIllIIllIIlllIIllIlIllIIllIIllIllIIIllIIllIIlIIIlIIlllIIIlIIlllIIlIIIllIlIlllIlIllIIlIIIll.Method2150318(text, x2, y, color, dropShadow);
            info.setReturnValue((int)result);
        }
    }

    @Redirect(method={"drawString(Ljava/lang/String;FFIZ)I"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/FontRenderer;renderString(Ljava/lang/String;FFIZ)I"))
    public int renderStringHook(FontRenderer fontrenderer, String text, float x2, float y, int color, boolean dropShadow) {
        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll != null && ((Boolean)IIllIIllIIlllIlIlIIlIIIlllIIllIIIlllIIllIIllIIIlllIlIIIlllIIIlIIlllIIlIlIIIllIIIlllIlIIlIlllIIIllIllIllIIlIIllIIlllIlllIIlllIIIlIllIllIIIllIIIlllIIllIIIlllIIlllIlIlllIIIlIIlIIIllIllIIlllIIllIIIllIIlIIIlllIllIIIlIIllIIIlIllIIllIllIllIllIll.Method2150504().IlllIllIIllIllIIIlllIllIIIlllIIlIIllIIlIllIIlllIIllIIIlIlIlllIIlIlIllIIIllIlllIlllIllIIIllIIIlIIIlIIIlIIIlIIllIllIIIllIllIlIIIlllIIllIIllIIllIIlllIIIlIIIlIIIlIllIIIlllIIlllIlllIIlIIIlIIlllIlIIllIIllIIIllIIlllIlIIIlIllIIlllIIIlllIIllIIIlll.getValue()).booleanValue() && dropShadow) {
            return this.renderString(text, x2 - 0.5f, y - 0.5f, color, true);
        }
        return this.renderString(text, x2, y, color, dropShadow);
    }

    @Redirect(method={"renderString(Ljava/lang/String;FFIZ)I"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/FontRenderer;renderStringAtPos(Ljava/lang/String;Z)V"))
    public void renderStringAtPosHook(FontRenderer renderer, String text, boolean shadow) {
        if (IIlllIllIIllIlllIlIIlIIllIllIIllIIIlIIlllIllIlllIlIIllIIIllIIIllIIlIIlIlllIllIIIllIIllIIIllIIlIIlIlllIIlIIlIIIlIIlllIlIIllIIllIIlIllIlIIIlIIlllIllIIIlIIIlIIIlIllIIllIIIlIllIIlIIllIIllIllIIIlIlIIllIlllIIIlllIIIlllIllIIlIll.Method2150694().Method2150386()) {
            this.renderStringAtPos(text.replace(Minecraft.getMinecraft().getSession().getUsername(), IIlllIllIIllIlllIlIIlIIllIllIIllIIIlIIlllIllIlllIlIIllIIIllIIIllIIlIIlIlllIllIIIllIIllIIIllIIlIIlIlllIIlIIlIIIlIIlllIlIIllIIllIIlIllIlIIIlIIlllIllIIIlIIIlIIIlIllIIllIIIlIllIIlIIllIIllIllIIIlIlIIllIlllIIIlllIIIlllIllIIlIll.Method2150694().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValueAsString()), shadow);
        } else {
            this.renderStringAtPos(text, shadow);
        }
    }
}
