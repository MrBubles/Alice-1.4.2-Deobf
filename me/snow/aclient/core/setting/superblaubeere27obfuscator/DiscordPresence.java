

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiMainMenu
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;

public class DiscordPresence {
    private static final DiscordRPC Field2311;
    public static DiscordRichPresence Field2312;
    private static Thread Field2313;
    private static int Field2314;

    static {
        Field2314 = 1;
        Field2311 = DiscordRPC.INSTANCE;
        Field2312 = new DiscordRichPresence();
    }

    public static void Method2159022() {
        DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers();
        Field2311.Discord_Initialize("969887055301705778", discordEventHandlers, true, "");
        DiscordPresence.Field2312.startTimestamp = System.currentTimeMillis() / 1000L;
        DiscordPresence.Field2312.details = Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu ? "In the main menu." : "Playing " + (Minecraft.getMinecraft().currentServerData != null ? (RPC.Field1558.Field1560.getValue().booleanValue() ? "on " + Minecraft.getMinecraft().currentServerData.serverIP + "." : " multiplayer.") : " singleplayer.");
        DiscordPresence.Field2312.state = RPC.Field1558.Field1561;
        DiscordPresence.Field2312.largeImageKey = "Alice";
        DiscordPresence.Field2312.largeImageText = " Alice+ 1.0.0";
        Field2311.Discord_UpdatePresence(Field2312);
        Field2313 = new Thread(DiscordPresence::Method2159024, "RPC-Callback-Handler");
        Field2313.start();
    }

    public static void Method2159023() {
        if (Field2313 != null && !Field2313.isInterrupted()) {
            Field2313.interrupt();
        }
        Field2311.Discord_Shutdown();
    }

    private static void Method2159024() {
        while (!Thread.currentThread().isInterrupted()) {
            Field2311.Discord_RunCallbacks();
            DiscordPresence.Field2312.details = Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu ? "In the main menu." : "Playing " + (Minecraft.getMinecraft().currentServerData != null ? (RPC.Field1558.Field1560.getValue().booleanValue() ? "on " + Minecraft.getMinecraft().currentServerData.serverIP + "." : " multiplayer.") : " singleplayer.");
            DiscordPresence.Field2312.state = RPC.Field1558.Field1561;
            if (RPC.Field1558.Field1559.getValue().booleanValue()) {
                if (Field2314 == 16) {
                    Field2314 = 1;
                }
                DiscordPresence.Field2312.largeImageKey = "cat" + Field2314;
                ++Field2314;
            }
            Field2311.Discord_UpdatePresence(Field2312);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException interruptedException) {
            }
        }
    }
}

