/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.server.integrated.IntegratedServer
 *  net.minecraft.util.Session
 *  net.minecraft.util.Timer
 */
package me.snow.aclient.mixin.mixins.accessors;

import net.minecraft.client.Minecraft;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Minecraft.class})
public interface IMinecraft {
    @Accessor(value="integratedServer")
    public void setIntegratedServer(IntegratedServer var1);

    @Accessor(value="timer")
    public Timer getTimer();

    @Accessor(value="rightClickDelayTimer")
    public void setRightClickDelayTimer(int var1);

    @Accessor(value="rightClickDelayTimer")
    public int getRightClickDelayTimer();

    @Accessor(value="session")
    public void setSession(Session var1);

    @Invoker(value="rightClickMouse")
    public void invokeRightClickMouse();
}

