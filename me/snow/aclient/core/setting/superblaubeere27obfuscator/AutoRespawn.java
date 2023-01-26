

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoRespawn
        extends Module {
    public Setting<Boolean> Field1090 = this.Method2150366(new Setting<Boolean>("AntiDeathScreen", true));
    public Setting<Boolean> Field1091 = this.Method2150366(new Setting<Boolean>("DeathCoords", false));
    public Setting<Boolean> Field1092 = this.Method2150366(new Setting<Boolean>("Respawn", true));

    public AutoRespawn() {
        super("AutoRespawn", "Respawns you when you die.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @SubscribeEvent
    public void Method2161825(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.getGui() instanceof GuiGameOver) {
            if (this.Field1091.getValue().booleanValue() && guiOpenEvent.getGui() instanceof GuiGameOver) {
                Command.Method2159696(String.format("You died at x %d y %d z %d", (int) AutoRespawn.Field2811.player.posX, (int) AutoRespawn.Field2811.player.posY, (int) AutoRespawn.Field2811.player.posZ));
            }
            if (this.Field1092.getValue() != false && AutoRespawn.Field2811.player.getHealth() <= 0.0f || this.Field1090.getValue().booleanValue() && AutoRespawn.Field2811.player.getHealth() > 0.0f) {
                guiOpenEvent.setCanceled(true);
                AutoRespawn.Field2811.player.respawnPlayer();
            }
        }
    }
}

