

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SafeWalk
        extends Module {
    public SafeWalk() {
        super("SafeWalk", "Walks safe", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    @SubscribeEvent
    public void Method2162120(MoveEvent moveEvent) {
        if (moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            double d = moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
            double d2 = moveEvent.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
            double d3 = moveEvent.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll();
            if (SafeWalk.Field2811.player.onGround) {
                double d4 = 0.05;
                while (d != 0.0 && this.Method2162131(d, -1.0, 0.0)) {
                    if (d < d4 && d >= -d4) {
                        d = 0.0;
                        continue;
                    }
                    if (d > 0.0) {
                        d -= d4;
                        continue;
                    }
                    d += d4;
                }
                while (d3 != 0.0 && this.Method2162131(0.0, -1.0, d3)) {
                    if (d3 < d4 && d3 >= -d4) {
                        d3 = 0.0;
                        continue;
                    }
                    if (d3 > 0.0) {
                        d3 -= d4;
                        continue;
                    }
                    d3 += d4;
                }
                while (d != 0.0 && d3 != 0.0 && this.Method2162131(d, -1.0, d3)) {
                    double d5 = d < d4 && d >= -d4 ? 0.0 : (d = d > 0.0 ? (d = d - d4) : (d = d + d4));
                    if (d3 < d4 && d3 >= -d4) {
                        d3 = 0.0;
                        continue;
                    }
                    if (d3 > 0.0) {
                        d3 -= d4;
                        continue;
                    }
                    d3 += d4;
                }
            }
            moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(d);
            moveEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(d2);
            moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(d3);
        }
    }

    public boolean Method2162131(double d, double d2, double d3) {
        EntityPlayerSP entityPlayerSP = SafeWalk.Field2811.player;
        return SafeWalk.Field2811.world.getCollisionBoxes((Entity) entityPlayerSP, entityPlayerSP.getEntityBoundingBox().offset(d, d2, d3)).isEmpty();
    }
}

