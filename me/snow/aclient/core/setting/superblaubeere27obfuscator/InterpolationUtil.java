

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class InterpolationUtil
        implements Util {
    public static Vec3d Method2163764(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(new Vec3d(entity.posX - entity.lastTickPosX, entity.posY - entity.lastTickPosY, entity.posZ - entity.lastTickPosZ).scale((double) f));
    }
}

