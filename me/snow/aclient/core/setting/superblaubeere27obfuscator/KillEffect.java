

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.world.World
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KillEffect
        extends Module {
    final Object Field1296 = new Object();
    public Setting<Boolean> Field1278 = this.Method2150366(new Setting<Boolean>("Thunder", true));
    public Setting<Integer> Field1279 = this.Method2150366(new Setting<Integer>("Number Thunder", 1, 1, 10));
    public Setting<Boolean> Field1280 = this.Method2150366(new Setting<Boolean>("Sound", true));
    public Setting<Integer> Field1281 = this.Method2150366(new Setting<Integer>("Number Sound", 1, 1, 10));
    public Setting<Boolean> Field1282 = this.Method2150366(new Setting<Boolean>("_______________________________", false));
    public Setting<Integer> Field1283 = this.Method2150366(new Setting<Integer>("TimeActive", 20, 0, 50));
    public Setting<Boolean> Field1284 = this.Method2150366(new Setting<Boolean>("lightning", true));
    public Setting<Boolean> Field1285 = this.Method2150366(new Setting<Boolean>("TotemPop", true));
    public Setting<Boolean> Field1286 = this.Method2150366(new Setting<Boolean>("TotemPopSound", false));
    public Setting<Boolean> Field1287 = this.Method2150366(new Setting<Boolean>("FireWork", false));
    public Setting<Boolean> Field1288 = this.Method2150366(new Setting<Boolean>("Fire", false));
    public Setting<Boolean> Field1289 = this.Method2150366(new Setting<Boolean>("Water", false));
    public Setting<Boolean> Field1290 = this.Method2150366(new Setting<Boolean>("Smoke", false));
    public Setting<Boolean> Field1291 = this.Method2150366(new Setting<Boolean>("Players", true));
    public Setting<Boolean> Field1292 = this.Method2150366(new Setting<Boolean>("Animals", true));
    public Setting<Boolean> Field1293 = this.Method2150366(new Setting<Boolean>("Mobs", true));
    public Setting<Boolean> Field1294 = this.Method2150366(new Setting<Boolean>("All", true));
    ArrayList<EntityPlayer> Field1295 = new ArrayList();

    public KillEffect() {
        super("KillEffect", "When you kill something it spawns shit.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }

    @Override
    public void Method2150372() {
        this.Field1295.clear();
    }

    @Override
    public void Method2150379() {
        if (KillEffect.Field2811.world == null) {
            this.Field1295.clear();
            return;
        }
        KillEffect.Field2811.world.playerEntities.forEach(this::Method2162555);
    }

    @SubscribeEvent
    public void Method2162552(LivingDeathEvent livingDeathEvent) {
        if (livingDeathEvent.getEntity() == KillEffect.Field2811.player) {
            return;
        }
        if (this.Method2162553(livingDeathEvent.getEntity())) {
            if (this.Field1284.getValue().booleanValue()) {
                KillEffect.Field2811.world.addEntityToWorld(-999, (Entity) new EntityLightningBolt((World) KillEffect.Field2811.world, livingDeathEvent.getEntity().posX, livingDeathEvent.getEntity().posY, livingDeathEvent.getEntity().posZ, true));
            }
            if (this.Field1285.getValue().booleanValue()) {
                this.Method2162554(livingDeathEvent.getEntity());
            }
            if (this.Field1287.getValue().booleanValue()) {
                KillEffect.Field2811.effectRenderer.emitParticleAtEntity(livingDeathEvent.getEntity(), EnumParticleTypes.FIREWORKS_SPARK, this.Field1283.getValue().intValue());
            }
            if (this.Field1288.getValue().booleanValue()) {
                KillEffect.Field2811.effectRenderer.emitParticleAtEntity(livingDeathEvent.getEntity(), EnumParticleTypes.FLAME, this.Field1283.getValue().intValue());
                KillEffect.Field2811.effectRenderer.emitParticleAtEntity(livingDeathEvent.getEntity(), EnumParticleTypes.DRIP_LAVA, this.Field1283.getValue().intValue());
            }
            if (this.Field1289.getValue().booleanValue()) {
                KillEffect.Field2811.effectRenderer.emitParticleAtEntity(livingDeathEvent.getEntity(), EnumParticleTypes.WATER_BUBBLE, this.Field1283.getValue().intValue());
                KillEffect.Field2811.effectRenderer.emitParticleAtEntity(livingDeathEvent.getEntity(), EnumParticleTypes.WATER_DROP, this.Field1283.getValue().intValue());
            }
            if (this.Field1290.getValue().booleanValue()) {
                KillEffect.Field2811.effectRenderer.emitParticleAtEntity(livingDeathEvent.getEntity(), EnumParticleTypes.SMOKE_NORMAL, this.Field1283.getValue().intValue());
            }
        }
    }

    public boolean Method2162553(Entity entity) {
        return entity != KillEffect.Field2811.player && (this.Field1294.getValue() != false || entity instanceof EntityPlayer && this.Field1291.getValue() != false || entity instanceof EntityMob || entity instanceof EntitySlime && this.Field1293.getValue() != false || entity instanceof EntityAnimal && this.Field1292.getValue() != false);
    }

    public void Method2162554(Entity entity) {
        KillEffect.Field2811.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM, this.Field1283.getValue().intValue());
        if (this.Field1286.getValue().booleanValue()) {
            KillEffect.Field2811.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0f, 1.0f, false);
        }
    }

    private void Method2162555(EntityPlayer entityPlayer) {
        if (this.Field1295.contains((Object) entityPlayer)) {
            if (entityPlayer.getHealth() > 0.0f) {
                this.Field1295.remove((Object) entityPlayer);
            }
        } else if (entityPlayer.getHealth() == 0.0f) {
            int n2;
            if (this.Field1278.getValue().booleanValue()) {
                for (n2 = 0; n2 < this.Field1279.getValue(); ++n2) {
                    KillEffect.Field2811.world.spawnEntity((Entity) new EntityLightningBolt((World) KillEffect.Field2811.world, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, true));
                }
            }
            if (this.Field1280.getValue().booleanValue()) {
                for (n2 = 0; n2 < this.Field1281.getValue(); ++n2) {
                    KillEffect.Field2811.player.playSound(SoundEvents.ENTITY_LIGHTNING_THUNDER, 0.5f, 1.0f);
                }
            }
            this.Field1295.add(entityPlayer);
        }
    }
}

