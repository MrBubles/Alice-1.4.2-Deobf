

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.util.MovementInput
 *  net.minecraft.world.chunk.EmptyChunk
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.MovementInput;
import net.minecraft.world.chunk.EmptyChunk;

public class EntitySpeed
        extends Module {
    public static EntitySpeed Field2459 = new EntitySpeed();
    public Setting<Float> Field2455 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(4.0f)));
    private Setting<Boolean> Field2456 = this.Method2150366(new Setting<Boolean>("AntiStuck", true));
    private Setting<Boolean> Field2457 = this.Method2150366(new Setting<Boolean>("Flight", true));
    private Setting<Boolean> Field2458 = this.Method2150366(new Setting<Boolean>("Wobble", true));

    public EntitySpeed() {
        super("EntitySpeed", "Abuses client-sided movement to change the speed of rideable entities", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, false, false, false);
        this.Method2161902();
    }

    public static EntitySpeed Method2161903() {
        if (Field2459 == null) {
            Field2459 = new EntitySpeed();
        }
        return Field2459;
    }

    public static EntitySpeed Method2161904() {
        if (Field2459 == null) {
            Field2459 = new EntitySpeed();
        }
        return Field2459;
    }

    public void Method2161902() {
        Field2459 = this;
    }

    @Override
    public void Method2150379() {
        if (EntitySpeed.Field2811.world != null && EntitySpeed.Field2811.player.getRidingEntity() != null) {
            Entity entity = EntitySpeed.Field2811.player.getRidingEntity();
            if (entity instanceof EntityPig || entity instanceof AbstractHorse) {
                this.Method2161905(entity);
            } else if (entity instanceof EntityBoat) {
                this.Method2161906(this.Method2161907());
            }
        }
    }

    public void Method2161905(Entity entity) {
        if (!this.Field2457.getValue().booleanValue()) {
            entity.motionY = -0.4;
        }
        if (this.Field2457.getValue().booleanValue()) {
            if (EntitySpeed.Field2811.gameSettings.keyBindJump.isKeyDown()) {
                entity.motionY = this.Field2455.getValue().floatValue();
            } else if (EntitySpeed.Field2811.gameSettings.keyBindForward.isKeyDown() || EntitySpeed.Field2811.gameSettings.keyBindBack.isKeyDown()) {
                entity.motionY = this.Field2458.getValue() != false ? Math.sin(EntitySpeed.Field2811.player.ticksExisted) : 0.0;
            }
        }
        this.Method2161908(entity, (double) this.Field2455.getValue().floatValue() * 3.8);
        if (entity instanceof EntityHorse) {
            entity.rotationYaw = EntitySpeed.Field2811.player.rotationYaw;
        }
    }

    public void Method2161906(EntityBoat entityBoat) {
        int n2 = 0;
        if (entityBoat == null) {
            return;
        }
        boolean bl = EntitySpeed.Field2811.gameSettings.keyBindForward.isKeyDown();
        boolean bl2 = EntitySpeed.Field2811.gameSettings.keyBindLeft.isKeyDown();
        boolean bl3 = EntitySpeed.Field2811.gameSettings.keyBindRight.isKeyDown();
        boolean bl4 = EntitySpeed.Field2811.gameSettings.keyBindBack.isKeyDown();
        if (!bl || !bl4) {
            entityBoat.motionY = 0.0;
        }
        if (EntitySpeed.Field2811.gameSettings.keyBindJump.isKeyDown()) {
            entityBoat.motionY += (double) (this.Field2455.getValue().floatValue() / 2.0f);
        }
        if (!(bl || bl2 || bl3 || bl4)) {
            return;
        }
        if (bl2 && bl3) {
            n2 = bl ? 0 : (bl4 ? 180 : -1);
        } else if (bl && bl4) {
            n2 = bl2 ? -90 : (bl3 ? 90 : -1);
        } else {
            int n3;
            int n4 = bl2 ? -90 : (n3 = (n2 = bl3 ? 90 : 0));
            if (bl) {
                n2 /= 2;
            } else if (bl4) {
                n2 = 180 - n2 / 2;
            }
        }
        if (n2 == -1) {
            return;
        }
        float f = EntitySpeed.Field2811.player.rotationYaw + (float) n2;
        entityBoat.motionX = EntityUtil.Method2163478(f) * (double) this.Field2455.getValue().floatValue();
        entityBoat.motionZ = EntityUtil.Method2163479(f) * (double) this.Field2455.getValue().floatValue();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        EntityBoat entityBoat = this.Method2161907();
        if (entityBoat == null) {
            return;
        }
        entityBoat.rotationYaw = EntitySpeed.Field2811.player.rotationYaw;
        entityBoat.updateInputs(false, false, false, false);
    }

    public EntityBoat Method2161907() {
        if (EntitySpeed.Field2811.player.getRidingEntity() != null && EntitySpeed.Field2811.player.getRidingEntity() instanceof EntityBoat) {
            return (EntityBoat) EntitySpeed.Field2811.player.getRidingEntity();
        }
        return null;
    }

    public void Method2161908(Entity entity, double d) {
        if (entity != null) {
            MovementInput movementInput = EntitySpeed.Field2811.player.movementInput;
            double d2 = movementInput.moveForward;
            double d3 = movementInput.moveStrafe;
            boolean bl = d2 != 0.0;
            boolean bl2 = d3 != 0.0;
            float f = EntitySpeed.Field2811.player.rotationYaw;
            if (!bl && !bl2) {
                this.Method2161909(entity, 0.0, 0.0);
            } else {
                double d4;
                double d5;
                double d6;
                if (d2 != 0.0) {
                    if (d3 > 0.0) {
                        f += (float) (d2 > 0.0 ? -45 : 45);
                    } else if (d3 < 0.0) {
                        f += (float) (d2 > 0.0 ? 45 : -45);
                    }
                    d3 = 0.0;
                    double d7 = d2 = d2 > 0.0 ? 1.0 : -1.0;
                }
                if (this.Method2161900(entity, d6 = d2 * d * (d5 = Math.cos(Math.toRadians(f + 90.0f))) + d3 * d * Math.sin(Math.toRadians(f + 90.0f)), d4 = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * d5)) {
                    d4 = 0.0;
                    d6 = 0.0;
                }
                this.Method2161909(entity, d6, d4);
            }
        }
    }

    public void Method2161909(Entity entity, double d, double d2) {
        entity.motionX = d;
        entity.motionZ = d2;
    }

    public boolean Method2161900(Entity entity, double d, double d2) {
        return this.Field2456.getValue() != false && EntitySpeed.Field2811.world.getChunk((int) (entity.posX + d) >> 4, (int) (entity.posZ + d2) >> 4) instanceof EmptyChunk;
    }
}

