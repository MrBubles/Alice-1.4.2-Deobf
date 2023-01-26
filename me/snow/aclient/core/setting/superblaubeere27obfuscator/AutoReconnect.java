

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiDisconnected
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.GuiConnecting
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.event.world.WorldEvent$Unload
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoLog;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoReconnect
        extends Module {
    private static ServerData Field373;
    private static AutoReconnect Field374;

    static {
        Field374 = new AutoReconnect();
    }

    private final Setting<Integer> Field375 = this.Method2150366(new Setting<Integer>("Delay", 5));

    public AutoReconnect() {
        super("AutoReconnect", "Reconnects you if you disconnect.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
        this.Method2161819();
    }

    public static AutoReconnect Method2161818() {
        if (Field374 == null) {
            Field374 = new AutoReconnect();
        }
        return Field374;
    }

    static Setting Method2161823(AutoReconnect autoReconnect) {
        return autoReconnect.Field375;
    }

    static ServerData Method2161824() {
        return Field373;
    }

    private void Method2161819() {
        Field374 = this;
    }

    @SubscribeEvent
    public void Method2161810(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.getGui() instanceof GuiDisconnected) {
            this.Method2161822();
            if (AutoLog.Method2161706().Method2150387()) {
                GuiDisconnected guiDisconnected = (GuiDisconnected) guiOpenEvent.getGui();
                guiOpenEvent.setGui((GuiScreen) new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, guiDisconnected));
            }
        }
    }

    @SubscribeEvent
    public void Method2161821(WorldEvent.Unload unload) {
        this.Method2161822();
    }

    public void Method2161822() {
        ServerData serverData = Field2811.getCurrentServerData();
        if (serverData != null) {
            Field373 = serverData;
        }
    }

    private class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends GuiDisconnected {
        final AutoReconnect Field2882;
        private final Timer Field2881;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(AutoReconnect autoReconnect, GuiDisconnected guiDisconnected) {
            this.Field2882 = autoReconnect;
            super(guiDisconnected.parentScreen, guiDisconnected.reason, guiDisconnected.message);
            this.Field2881 = new Timer();
            this.Field2881.Method2164750();
        }

        public void updateScreen() {
            if (this.Field2881.Method2164751(((Integer) AutoReconnect.Method2161823(this.Field2882).getValue()).intValue())) {
                this.mc.displayGuiScreen((GuiScreen) new GuiConnecting(this.parentScreen, this.mc, AutoReconnect.Method2161824() == null ? this.mc.currentServerData : AutoReconnect.Method2161824()));
            }
        }

        public void drawScreen(int n2, int n3, float f) {
            if (Feature.Method2150359()) {
                return;
            }
            super.drawScreen(n2, n3, f);
            String string = "Reconnecting in " + MathUtil.Method2163858((double) ((long) ((Integer) AutoReconnect.Method2161823(this.Field2882).getValue() * 1000) - this.Field2881.Method2164759()) / 1000.0, 1);
            this.Field2882.Field3872.Method2150318(string, this.width / 2 - this.Field2882.Field3872.Method2150310(string) / 2, this.height - 16, 0xFFFFFF, true);
        }
    }
}

