/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.function.Predicate;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumStages;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventHandler;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosEvent;
import net.minecraft.entity.EntityLivingBase;

public class EventTotemPop
        extends PhobosEvent {
    private final EntityLivingBase Field3152;
    private final int Field3153;
    @EventHandler
    private final Listener<EventTotemPop> Field3154 = new Listener<EventTotemPop>(EventTotemPop::Method2159028, new Predicate[0]);

    public EventTotemPop(EnumStages enumStages, EntityLivingBase entityLivingBase, int n2) {
        super(enumStages);
        this.Field3152 = entityLivingBase;
        this.Field3153 = n2;
    }

    private static void Method2159028(EventTotemPop eventTotemPop) {
    }

    public EntityLivingBase Method2159026() {
        return this.Field3152;
    }

    public int Method2159027() {
        return this.Field3153;
    }
}

