

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.EntityPlayer
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;

public class MobOwner
        extends Module {
    private final Map<Entity, String> Field3199 = new HashMap<Entity, String>();
    private final Map<Entity, UUID> Field3200 = new ConcurrentHashMap<Entity, UUID>();
    private final List<Entity> Field3201 = new ArrayList<Entity>();

    public MobOwner() {
        super("MobOwner", "Shows you who owns mobs.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, false, false, false);
    }

    @Override
    public void Method2150379() {
        Entity entity;
        if (MobOwner.Method2150359()) {
            return;
        }
        if (PlayerUtil.Field3934.Method2164751(5.0)) {
            for (Map.Entry<Object, UUID> entity2 : this.Field3200.entrySet()) {
                entity = (Entity) entity2.getKey();
                UUID uUID = entity2.getValue();
                if (uUID != null) {
                    EntityPlayer entityPlayer = MobOwner.Field2811.world.getPlayerEntityByUUID(uUID);
                    if (entityPlayer == null) {
                        try {
                            String string = PlayerUtil.Method2163931(uUID);
                            if (string != null) {
                                this.Field3199.put(entity, string);
                                this.Field3201.add(entity);
                            }
                        } catch (Exception exception) {
                            this.Field3201.add(entity);
                            this.Field3200.remove(entity2);
                        }
                        PlayerUtil.Field3934.Method2164750();
                        break;
                    }
                    this.Field3199.put(entity, entityPlayer.getName());
                    this.Field3201.add(entity);
                    continue;
                }
                this.Field3201.add(entity);
                this.Field3200.remove(entity2);
            }
        }
        for (Entity entity2 : MobOwner.Field2811.world.getLoadedEntityList()) {
            if (entity2.getAlwaysRenderNameTag()) continue;
            if (entity2 instanceof EntityTameable) {
                entity = (EntityTameable) entity2;
                if (!entity.isTamed() || entity.getOwnerId() == null) continue;
                if (this.Field3199.get((Object) entity) != null) {
                    entity.setAlwaysRenderNameTag(true);
                    entity.setCustomNameTag(this.Field3199.get((Object) entity));
                    continue;
                }
                if (this.Field3201.contains((Object) entity2)) continue;
                this.Field3200.put(entity, entity.getOwnerId());
                continue;
            }
            if (!(entity2 instanceof AbstractHorse) || !(entity = (AbstractHorse) entity2).isTame() || entity.getOwnerUniqueId() == null)
                continue;
            if (this.Field3199.get((Object) entity) != null) {
                entity.setAlwaysRenderNameTag(true);
                entity.setCustomNameTag(this.Field3199.get((Object) entity));
                continue;
            }
            if (this.Field3201.contains((Object) entity2)) continue;
            this.Field3200.put(entity, entity.getOwnerUniqueId());
        }
    }

    @Override
    public void Method2150373() {
        for (Entity entity : MobOwner.Field2811.world.loadedEntityList) {
            if (!(entity instanceof EntityTameable) && !(entity instanceof AbstractHorse)) continue;
            try {
                entity.setAlwaysRenderNameTag(false);
            } catch (Exception exception) {
            }
        }
    }
}

