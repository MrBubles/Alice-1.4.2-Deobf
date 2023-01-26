

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll$IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.fc
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.fd
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package me.snow.aclient.mixin.mixins;

import java.io.IOException;
import java.util.Random;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.fc;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.fd;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiMainMenu.class})
public abstract class MixinGuiMainMenu
extends GuiScreen {
    @Shadow
    protected abstract void renderSkybox(int var1, int var2, float var3);

    @Inject(method={"initGui"}, at={@At(value="RETURN")}, cancellable=true)
    public void initGui(CallbackInfo info) {
        try {
            if (((Boolean)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue() && IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue() == IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
                Random random = new Random();
                fd[] shaders = fd.values();
                IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll = new fc(shaders[random.nextInt(shaders.length)].IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll());
            } else {
                IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll = new fc(((fd)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue()).IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll());
            }
        }
        catch (IOException e2) {
            throw new IllegalStateException("Failed to load background shader", e2);
        }
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll = System.currentTimeMillis();
    }

    @Redirect(method={"drawScreen"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiMainMenu;renderSkybox(IIF)V"))
    private void voided(GuiMainMenu guiMainMenu, int mouseX, int mouseY, float partialTicks) {
        if (!((Boolean)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue()) {
            this.renderSkybox(mouseX, mouseY, partialTicks);
        }
    }

    @Redirect(method={"drawScreen"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiMainMenu;drawGradientRect(IIIIII)V", ordinal=0))
    private void noRect1(GuiMainMenu guiMainMenu, int left, int top, int right, int bottom, int startColor, int endColor) {
        if (!((Boolean)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue()) {
            this.drawGradientRect(left, top, right, bottom, startColor, endColor);
        }
    }

    @Redirect(method={"drawScreen"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiMainMenu;drawGradientRect(IIIIII)V", ordinal=1))
    private void noRect2(GuiMainMenu guiMainMenu, int left, int top, int right, int bottom, int startColor, int endColor) {
        if (!((Boolean)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue()) {
            this.drawGradientRect(left, top, right, bottom, startColor, endColor);
        }
    }

    @Inject(method={"drawScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void drawScreenShader(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        if (((Boolean)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue()) {
            GlStateManager.disableCull();
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.Method2164188(this.width * 2, this.height * 2, (float)(mouseX * 2), (float)(mouseY * 2), (float)(System.currentTimeMillis() - IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll) / 1000.0f);
            GL11.glBegin((int)7);
            GL11.glVertex2f((float)-1.0f, (float)-1.0f);
            GL11.glVertex2f((float)-1.0f, (float)1.0f);
            GL11.glVertex2f((float)1.0f, (float)1.0f);
            GL11.glVertex2f((float)1.0f, (float)-1.0f);
            GL11.glEnd();
            GL20.glUseProgram((int)0);
        }
    }
}

