/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.UUID;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.entity.player.EntityPlayer;

public class ConnectionEvent
        extends EventStage {
    private final UUID Field330;
    private final EntityPlayer Field331;
    private final String Field332;

    public ConnectionEvent(int n2, UUID uUID, String string) {
        super(n2);
        this.Field330 = uUID;
        this.Field332 = string;
        this.Field331 = null;
    }

    public ConnectionEvent(int n2, EntityPlayer entityPlayer, UUID uUID, String string) {
        super(n2);
        this.Field331 = entityPlayer;
        this.Field330 = uUID;
        this.Field332 = string;
    }

    public String IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
        return this.Field332;
    }

    public UUID IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        return this.Field330;
    }

    public EntityPlayer IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll() {
        return this.Field331;
    }
}

