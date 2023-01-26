/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumStages;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosEvent;
import net.minecraft.network.Packet;

public class EventPacketRecieve
        extends PhobosEvent {
    private final Packet<?> Field3208;

    public EventPacketRecieve(EnumStages enumStages, Packet<?> packet) {
        super(enumStages);
        this.Field3208 = packet;
    }

    public Packet<?> Method2159025() {
        return this.Field3208;
    }
}

