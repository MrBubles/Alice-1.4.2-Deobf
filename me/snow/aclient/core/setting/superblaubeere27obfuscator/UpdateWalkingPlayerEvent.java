/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.Cancelable
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class UpdateWalkingPlayerEvent
        extends EventStage {
    private static UpdateWalkingPlayerEvent Field4228;

    public UpdateWalkingPlayerEvent(int n2) {
        super(n2);
    }

    public UpdateWalkingPlayerEvent() {
        Field4228 = this;
    }

    public static UpdateWalkingPlayerEvent IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
        if (Field4228 == null) {
            Field4228 = new UpdateWalkingPlayerEvent();
        }
        return Field4228;
    }
}

