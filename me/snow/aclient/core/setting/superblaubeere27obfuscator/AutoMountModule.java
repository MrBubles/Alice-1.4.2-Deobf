

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMule
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.entity.passive.EntitySkeletonHorse
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Comparator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class AutoMountModule
        extends Module {
    private final Setting<Integer> Field3425 = this.Method2150366(new Setting<Integer>("Range", 4, 0, 10));
    private final Setting<Float> Field3426 = this.Method2150366(new Setting<Float>("Delay", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field3418 = this.Method2150366(new Setting<Boolean>("Boats", true));
    public Setting<Boolean> Field3419 = this.Method2150366(new Setting<Boolean>("Horses", true));
    public Setting<Boolean> Field3420 = this.Method2150366(new Setting<Boolean>("SkeletonHorses", true));
    public Setting<Boolean> Field3421 = this.Method2150366(new Setting<Boolean>("Donkeys", true));
    public Setting<Boolean> Field3422 = this.Method2150366(new Setting<Boolean>("Pigs", true));
    public Setting<Boolean> Field3423 = this.Method2150366(new Setting<Boolean>("Llamas", true));
    public Setting<Boolean> Field3424 = this.Method2150366(new Setting<Boolean>("Mules", true));
    private Timer Field3427 = new Timer();

    public AutoMountModule() {
        super("AutoMount", "Automatically attempts to mount an entity near you", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    private static Float Method2161811(Entity entity) {
        return Float.valueOf(AutoMountModule.Field2811.player.getDistance(entity));
    }

    @Override
    public void Method2150379() {
        if (AutoMountModule.Field2811.player.isRiding()) {
            return;
        }
        if (!this.Field3427.Method2164755((long) (this.Field3426.getValue().floatValue() * 1000.0f))) {
            return;
        }
        this.Field3427.Method2164750();
        Entity entity = AutoMountModule.Field2811.world.loadedEntityList.stream().filter(this::Method2161812).min(Comparator.comparing(AutoMountModule::Method2161811)).orElse(null);
        if (entity != null) {
            AutoMountModule.Field2811.playerController.interactWithEntity((EntityPlayer) AutoMountModule.Field2811.player, entity, EnumHand.MAIN_HAND);
        }
    }

    private boolean Method2161700(Entity entity) {
        AbstractHorse abstractHorse;
        if (entity.getDistance((Entity) AutoMountModule.Field2811.player) > (float) this.Field3425.getValue().intValue()) {
            return false;
        }
        if (entity instanceof AbstractHorse && (abstractHorse = (AbstractHorse) entity).isChild()) {
            return false;
        }
        if (entity instanceof EntityBoat && this.Field3418.getValue().booleanValue()) {
            return true;
        }
        if (entity instanceof EntitySkeletonHorse && this.Field3420.getValue().booleanValue()) {
            return true;
        }
        if (entity instanceof EntityHorse && this.Field3419.getValue().booleanValue()) {
            return true;
        }
        if (entity instanceof EntityDonkey && this.Field3421.getValue().booleanValue()) {
            return true;
        }
        if (entity instanceof EntityPig && this.Field3422.getValue().booleanValue()) {
            abstractHorse = (EntityPig) entity;
            return abstractHorse.getSaddled();
        }
        if (entity instanceof EntityLlama && this.Field3423.getValue().booleanValue() && !(abstractHorse = (EntityLlama) entity).isChild()) {
            return true;
        }
        return entity instanceof EntityMule && this.Field3423.getValue() != false && !(abstractHorse = (EntityLlama) entity).isChild();
    }

    private boolean Method2161812(Entity entity) {
        return this.Method2161700(entity);
    }
}

