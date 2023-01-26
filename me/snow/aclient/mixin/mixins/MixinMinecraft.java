

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIllIllIlIIlllIlIllIIlllIlIIlllIlIlllIllIIIllIIIllIlIlllIIlllIIlIIlIllIllIllIIllIIlIIllIIllIIIlllIllIlllIIIlIIIlIIllIllIlIIllIIIlllIIIllIlIlIllIIIllIIllIIlllIIlIIlIIlIlllIIllIIllIlIlIIIlIIllIllIIllIIllIIlllIIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIlllIIlllIIIllIIlllIllIIlIIlIIlIllIlllIllIlIIIlllIIIlIllIIllIIIllIllIIlIIIlIIlllIllIlIIllIIllIIlllIIIllIIllIIIlllIIIllIIllIIIlllIllIIIlllIIllIIIlIIllIlIllIIllIIlllIIllIIIllIIIlIIllIIlllIIIlIlllIIIllIIllIIIllIIllIIlIllIIlIlIIlIllIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.at
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.h
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.i
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.crash.CrashReport
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.mixin.mixins;

import javax.annotation.Nullable;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIllIllIlIIlllIlIllIIlllIlIIlllIlIlllIllIIIllIIIllIlIlllIIlllIIlIIlIllIllIllIIllIIlIIllIIllIIIlllIllIlllIIIlIIIlIIllIllIlIIllIIIlllIIIllIlIlIllIIIllIIllIIlllIIlIIlIIlIlllIIllIIllIlIlIIIlIIllIllIIllIIllIIlllIIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIlllIIlllIIIllIIlllIllIIlIIlIIlIllIlllIllIlIIIlllIIIlIllIIllIIIllIllIIlIIIlIIlllIllIlIIllIIllIIlllIIIllIIllIIIlllIIIllIIllIIIlllIllIIIlllIIllIIIlIIllIlIllIIllIIlllIIllIIIllIIIlIIllIIlllIIIlIlllIIIllIIllIIIllIIllIIlIllIIlIlIIlIllIIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.at;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.h;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={Minecraft.class})
public abstract class MixinMinecraft {
    @Shadow
    public GuiScreen currentScreen;
    @Shadow
    public GameSettings gameSettings;
    @Shadow
    public WorldClient world;

    @Shadow
    public abstract void displayGuiScreen(@Nullable GuiScreen var1);

    @Inject(method={"getLimitFramerate"}, at={@At(value="HEAD")}, cancellable=true)
    private void getFrameRateLuigiii(CallbackInfoReturnable<Integer> cir) {
        try {
            if (((Boolean)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue()) {
                cir.setReturnValue(this.world == null && this.currentScreen != null ? (Integer)IIIllIIllIIllIIlllIIlllIIllIIllIllIIIlIlIlIlIIllIIIlIIllIIlllIIIlIllIllIIlllIlllIIIllIlIIIllIIIlIlIIlIIlllIIlllIIlllIlllIIlllIIIlIlllIIlllIlIIlIIlllIIlllIIIllIlIIIllIllIIllIIlllIIllIIlIIIlIIlIllIllIIllIIIlllIIlllIIllIIIllIIIllIIIlIIIlIIIll.Method2150598().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue() : Integer.valueOf(this.gameSettings.limitFramerate));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Inject(method={"runTickKeyboard"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;currentScreen:Lnet/minecraft/client/gui/GuiScreen;", ordinal=0)}, locals=LocalCapture.CAPTURE_FAILSOFT)
    private void onRunTickKeyboard(CallbackInfo ci, int i) {
        if (Keyboard.getEventKeyState() && IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll != null) {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150212(i);
        }
    }

    @Inject(method={"runGameLoop"}, at={@At(value="HEAD")})
    private void onRunGameLoop(CallbackInfo callbackInfo) {
        IlllIlllIIlllIIIllIIlllIllIIlIIlIIlIllIlllIllIlIIIlllIIIlIllIIllIIIllIllIIlIIIlIIlllIllIlIIllIIllIIlllIIIllIIllIIIlllIIIllIIllIIIlllIllIIIlllIIllIIIlIIllIlIllIIllIIlllIIllIIIllIIIlIIllIIlllIIIlIlllIIIllIIllIIIllIIllIIlIllIIlIlIIlIllIIlll event = new IlllIlllIIlllIIIllIIlllIllIIlIIlIIlIllIlllIllIlIIIlllIIIlIllIIllIIIllIllIIlIIIlIIlllIllIlIIllIIllIIlllIIIllIIllIIIlllIIIllIIllIIIlllIllIIIlllIIllIIIlIIllIlIllIIllIIlllIIllIIIllIIIlIIllIIlllIIIlIlllIIIllIIllIIIllIIllIIlIllIIlIlIIlIllIIlll();
        MinecraftForge.EVENT_BUS.post((Event)event);
    }

    @Redirect(method={"run"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;displayCrashReport(Lnet/minecraft/crash/CrashReport;)V"))
    public void displayCrashReportHook(Minecraft minecraft, CrashReport crashReport) {
        this.unload();
    }

    @Redirect(method={"runTick"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;doVoidFogParticles(III)V"))
    public void doVoidFogParticlesHook(WorldClient world, int x2, int y, int z) {
        at.Method2162599().Method2162503(x2, y, z);
    }

    @Inject(method={"shutdown"}, at={@At(value="HEAD")})
    public void shutdownHook(CallbackInfo info) {
        this.unload();
    }

    private void unload() {
        System.out.println("Shutting down: saving configuration");
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2159689();
        System.out.println("Configuration saved.");
    }

    @Redirect(method={"sendClickBlockToController"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isHandActive()Z"))
    private boolean isHandActiveWrapper(EntityPlayerSP playerSP) {
        return !i.Method2162262().Method2150386() && playerSP.isHandActive();
    }

    @Redirect(method={"rightClickMouse"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;getIsHittingBlock()Z", ordinal=0))
    private boolean isHittingBlockHook(PlayerControllerMP playerControllerMP) {
        return !i.Method2162262().Method2150386() && playerControllerMP.getIsHittingBlock();
    }

    @Inject(method={"middleClickMouse"}, at={@At(value="HEAD")}, cancellable=true)
    public void middleClickMouse(CallbackInfo cancel) {
        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150196(h.class)) {
            cancel.cancel();
        }
    }

    @Inject(method={"runGameLoop"}, at={@At(value="INVOKE", target="Lnet/minecraft/profiler/Profiler;endSection()V", ordinal=0, shift=At.Shift.AFTER)})
    private void post_ScheduledTasks(CallbackInfo callbackInfo) {
        MinecraftForge.EVENT_BUS.post((Event)new IIllIIlllIIllIllIlIIlllIlIllIIlllIlIIlllIlIlllIllIIIllIIIllIlIlllIIlllIIlIIlIllIllIllIIllIIlIIllIIllIIIlllIllIlllIIIlIIIlIIllIllIlIIllIIIlllIIIllIlIlIllIIIllIIllIIlllIIlIIlIIlIlllIIllIIllIlIlIIIlIIllIllIIllIIllIIlllIIl());
    }
}

