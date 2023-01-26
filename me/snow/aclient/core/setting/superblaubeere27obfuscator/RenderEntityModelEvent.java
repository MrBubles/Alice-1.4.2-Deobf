/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.common.eventhandler.Cancelable
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class RenderEntityModelEvent
        extends EventStage {
    public ModelBase Field618;
    public Entity Field619;
    public float Field620;
    public float Field621;
    public float Field622;
    public float Field623;
    public float Field624;
    public float Field625;

    public RenderEntityModelEvent(int n2, ModelBase modelBase, Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super(n2);
        this.Field618 = modelBase;
        this.Field619 = entity;
        this.Field620 = f;
        this.Field621 = f2;
        this.Field622 = f3;
        this.Field623 = f4;
        this.Field624 = f5;
        this.Field625 = f6;
    }
}

