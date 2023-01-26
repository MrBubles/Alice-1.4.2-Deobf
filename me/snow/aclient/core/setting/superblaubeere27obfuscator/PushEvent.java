/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.common.eventhandler.Cancelable
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class PushEvent
        extends EventStage {
    public Entity Field2979;
    public double Field2980;
    public double Field2981;
    public double Field2982;
    public boolean Field2983;

    public PushEvent(Entity entity, double d, double d2, double d3, boolean bl) {
        super(0);
        this.Field2979 = entity;
        this.Field2980 = d;
        this.Field2981 = d2;
        this.Field2982 = d3;
        this.Field2983 = bl;
    }

    public PushEvent(int n2) {
        super(n2);
    }

    public PushEvent(int n2, Entity entity) {
        super(n2);
        this.Field2979 = entity;
    }
}

