

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class SafetyManager
        extends Feature
        implements Runnable {
    private final Timer Field4234 = new Timer();
    private final AtomicBoolean Field4235 = new AtomicBoolean(false);
    private ScheduledExecutorService Field4236;

    @Override
    public void run() {
        if (AutoCrystal.Method2150936().Method2150387() || AutoCrystal.Method2150936().Field184.getValue() == AutoCrystal.IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE) {
            this.Method2150293();
        }
    }

    public void Method2150293() {
        if (!SafetyManager.Method2150359()) {
            EntityPlayer entityPlayer;
            boolean bl = true;
            EntityPlayer entityPlayer2 = entityPlayer = Global.Method2150598().Field1135.getValue() != false ? EntityUtil.Method2163561(18.0) : null;
            if (Global.Method2150598().Field1135.getValue().booleanValue() && entityPlayer == null) {
                this.Field4235.set(true);
                return;
            }
            ArrayList arrayList = new ArrayList(SafetyManager.Field2811.world.loadedEntityList);
            for (Entity entity : arrayList) {
                if (!(entity instanceof EntityEnderCrystal) || !((double) DamageUtil.Method2163461(entity, (Entity) SafetyManager.Field2811.player) > 4.0) || entityPlayer != null && !(entityPlayer.getDistanceSq(entity) < 40.0))
                    continue;
                bl = false;
                break;
            }
            if (bl) {
                for (BlockPos blockPos : BlockUtil.Method2162796(4.0f, false, Global.Method2150598().Field1137.getValue())) {
                    if (!((double) DamageUtil.Method2163462(blockPos, (Entity) SafetyManager.Field2811.player) > 4.0) || entityPlayer != null && !(entityPlayer.getDistanceSq(blockPos) < 40.0))
                        continue;
                    bl = false;
                    break;
                }
            }
            this.Field4235.set(bl);
        }
    }

    public void Method2150294() {
        this.run();
    }

    public String Method2150295() {
        if (this.Field4235.get()) {
            return "\u00a7aSecure";
        }
        return "\u00a7cUnsafe";
    }

    public boolean Method2150296() {
        return this.Field4235.get();
    }

    public ScheduledExecutorService Method2150297() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this, 0L, Global.Method2150598().Field1136.getValue().intValue(), TimeUnit.MILLISECONDS);
        return scheduledExecutorService;
    }
}

