

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.HashMap;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;

public class SpeedManager
        extends Feature {
    public static final double Field1988 = 3.0;
    public static boolean Field1989;
    public static boolean Field1990;
    public double Field1991;
    public double Field1992;
    public double Field1993;
    public double Field1994;
    public boolean Field1995;
    public long Field1996;
    public boolean Field1997 = true;
    public double Field1998;
    public HashMap<EntityPlayer, Double> Field1999 = new HashMap();

    public static void Method2150207(boolean bl) {
        Field1989 = bl;
    }

    public static void Method2150208(boolean bl) {
        Field1990 = bl;
    }

    public float Method2150209() {
        return (float) (Minecraft.getSystemTime() - this.Field1996) / 1000.0f;
    }

    public void Method2150200() {
        double d = SpeedManager.Field2811.player.posX - SpeedManager.Field2811.player.prevPosX;
        double d2 = SpeedManager.Field2811.player.posZ - SpeedManager.Field2811.player.prevPosZ;
        this.Field1998 = d * d + d2 * d2;
        if (Field1989 && (!SpeedManager.Field2811.player.onGround || Field1990)) {
            if (!this.Field1995) {
                this.Field1997 = this.Field1992 == 0.0;
                this.Field1993 = this.Field1998 != 0.0 ? this.Field1998 / this.Field1992 - 1.0 : -1.0;
                this.Field1994 = this.Field1998 - this.Field1992;
                this.Field1996 = Minecraft.getSystemTime();
                this.Field1992 = this.Field1998;
                this.Field1991 = this.Field1997 ? this.Field1992 : 0.0;
            }
            this.Field1995 = Field1989;
        } else {
            this.Field1995 = false;
            this.Field1992 = 0.0;
        }
        this.Method2150311();
    }

    public void Method2150311() {
        for (EntityPlayer entityPlayer : SpeedManager.Field2811.world.playerEntities) {
            int n2 = 20;
            if (!(SpeedManager.Field2811.player.getDistanceSq((Entity) entityPlayer) < (double) (n2 * n2))) continue;
            double d = entityPlayer.posX - entityPlayer.prevPosX;
            double d2 = entityPlayer.posZ - entityPlayer.prevPosZ;
            double d3 = d * d + d2 * d2;
            this.Field1999.put(entityPlayer, d3);
        }
    }

    public double Method2150312(EntityPlayer entityPlayer) {
        if (this.Field1999.get((Object) entityPlayer) == null) {
            return 0.0;
        }
        return this.Method2150313(this.Field1999.get((Object) entityPlayer));
    }

    public double Method2150313(double d) {
        return (double) MathHelper.sqrt((double) d) * 71.2729367892;
    }

    public double Method2150314() {
        double d = this.Method2150313(this.Field1998);
        d = (double) Math.round(10.0 * d) / 10.0;
        return d;
    }

    public double Method2150315() {
        double d = this.Method2150313(this.Field1998) / 3.6;
        d = (double) Math.round(10.0 * d) / 10.0;
        return d;
    }
}

