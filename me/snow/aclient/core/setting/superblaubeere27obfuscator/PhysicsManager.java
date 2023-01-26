

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.DisconnectEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GameLoopEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhysicsUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.WorldClientEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PhysicsManager
        extends Feature {
    Timer Field1669 = new Timer();
    boolean Field1670;
    int Field1671;
    int Field1672;

    @SubscribeEvent
    public void Method2150230(GameLoopEvent gameLoopEvent) {
        if (PhysicsManager.Field2811.player == null) {
            this.Field1672 = 0;
            return;
        }
        if (this.Field1672 > 0 && this.Field1669.Method2164755(this.Field1671)) {
            this.Field1670 = true;
            while (this.Field1672 > 0) {
                this.Method2150244();
                if (this.Field1671 != 0) break;
                --this.Field1672;
            }
            this.Field1670 = false;
            this.Field1669.Method2164750();
        }
    }

    @SubscribeEvent
    public void Method2150241(DisconnectEvent disconnectEvent) {
        this.Field1672 = 0;
    }

    @SubscribeEvent
    public void Method2150242(WorldClientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        this.Field1672 = 0;
    }

    public void Method2150243(int n2, int n3) {
        if (!this.Field1670) {
            this.Field1672 = n2;
            this.Field1671 = n3;
        }
    }

    public void Method2150244() {
        PhysicsUtil.Method2163917();
    }
}

