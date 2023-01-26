

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.authlib.GameProfile;

import java.util.Random;
import java.util.UUID;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumStages;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventTotemPop;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TotemPopManager2;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FakePlayer
        extends Module {
    public final Setting<Boolean> Field1972 = this.Method2150366(new Setting<Boolean>("Copy Inventory", true));
    public final Setting<Boolean> Field1973 = this.Method2150366(new Setting<Boolean>("Can Pop Totems", true));
    public final Setting<Boolean> Field1974 = this.Method2150366(new Setting<Boolean>("Can Move", true));
    private EntityOtherPlayerMP Field1975;

    public FakePlayer() {
        super("FakePlayer", "Spawns in a fake player for testing purposes", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    @Override
    public void Method2150372() {
        if (FakePlayer.Method2150358()) {
            return;
        }
        this.Field1975 = new EntityOtherPlayerMP((World) FakePlayer.Field2811.world, new GameProfile(UUID.fromString("fdee323e-7f0c-4c15-8d1c-0f277442342a"), "Fit"));
        this.Field1975.copyLocationAndAnglesFrom((Entity) FakePlayer.Field2811.player);
        this.Field1975.rotationYawHead = FakePlayer.Field2811.player.rotationYawHead;
        if (this.Field1972.getValue().booleanValue()) {
            this.Field1975.inventory.copyInventory(FakePlayer.Field2811.player.inventory);
        }
        FakePlayer.Field2811.world.addEntityToWorld(-100, (Entity) this.Field1975);
    }

    @Override
    public void Method2150376() {
        if (this.Field1975 != null) {
            Random random = new Random();
            this.Field1975.moveForward = FakePlayer.Field2811.player.moveForward + (float) random.nextInt(5) / 10.0f;
            this.Field1975.moveStrafing = FakePlayer.Field2811.player.moveStrafing + (float) random.nextInt(5) / 10.0f;
            if (this.Field1974.getValue().booleanValue()) {
                this.Method2162220(this.Field1975.moveStrafing, this.Field1975.moveVertical, this.Field1975.moveForward);
            }
        }
    }

    public void Method2162220(float f, float f2, float f3) {
        double d = this.Field1975.posY;
        float f4 = 0.8f;
        float f5 = 0.02f;
        float f6 = EnchantmentHelper.getDepthStriderModifier((EntityLivingBase) this.Field1975);
        if (f6 > 3.0f) {
            f6 = 3.0f;
        }
        if (!this.Field1975.onGround) {
            f6 *= 0.5f;
        }
        if (f6 > 0.0f) {
            f4 += (0.54600006f - f4) * f6 / 3.0f;
            f5 += (this.Field1975.getAIMoveSpeed() - f5) * f6 / 4.0f;
        }
        this.Field1975.moveRelative(f, f2, f3, f5);
        this.Field1975.move(MoverType.SELF, this.Field1975.motionX, this.Field1975.motionY, this.Field1975.motionZ);
        this.Field1975.motionX *= (double) f4;
        this.Field1975.motionY *= (double) 0.8f;
        this.Field1975.motionZ *= (double) f4;
        if (!this.Field1975.hasNoGravity()) {
            this.Field1975.motionY -= 0.02;
        }
        if (this.Field1975.collidedHorizontally && this.Field1975.isOffsetPositionInLiquid(this.Field1975.motionX, this.Field1975.motionY + (double) 0.6f - this.Field1975.posY + d, this.Field1975.motionZ)) {
            this.Field1975.motionY = 0.3f;
        }
    }

    @Override
    public void Method2150378() {
        this.Method2150380();
    }

    @Override
    public void Method2150379() {
        if (FakePlayer.Method2150358()) {
            this.Method2150388(false);
        }
    }

    @Override
    public void Method2150373() {
        block3:
        {
            if (!FakePlayer.Method2150358()) break block3;
            return;
        }
        try {
            FakePlayer.Field2811.world.removeEntity((Entity) this.Field1975);
        } catch (Exception exception) {
            // empty catch block
        }
    }

    private void Method2162231(Entity entity) {
        FakePlayer.Field2811.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.TOTEM, 30);
        FakePlayer.Field2811.world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0f, 1.0f, false);
    }

    @SubscribeEvent
    public void Method2162232(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        block13:
        {
            if (this.Field1973.getValue().booleanValue()) {
                if (!(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketDestroyEntities))
                    break block13;
                try {
                    SPacketDestroyEntities sPacketDestroyEntities = (SPacketDestroyEntities) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
                    for (int n2 : sPacketDestroyEntities.getEntityIDs()) {
                        Entity entity = FakePlayer.Field2811.world.getEntityByID(n2);
                        if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistanceSq((Entity) this.Field1975) < 144.0))
                            continue;
                        float f = DamageUtil2.Method2164358(entity.getPositionVector(), (Entity) this.Field1975);
                        float f2 = this.Field1975.getAbsorptionAmount() - f;
                        boolean bl = f2 < 0.0f;
                        float f3 = this.Field1975.getHealth() + f2;
                        if (bl && f3 > 0.0f) {
                            this.Field1975.setHealth(f3);
                            this.Field1975.setAbsorptionAmount(0.0f);
                        } else if (f3 > 0.0f) {
                            this.Field1975.setAbsorptionAmount(f2);
                        } else {
                            this.Field1975.setHealth(2.0f);
                            this.Field1975.setAbsorptionAmount(8.0f);
                            this.Field1975.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 5));
                            this.Field1975.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1));
                            try {
                                FakePlayer.Field2811.player.connection.handleEntityStatus(new SPacketEntityStatus((Entity) this.Field1975, 35));
                            } catch (Exception exception) {
                                // empty catch block
                            }
                            if (TotemPopManager2.Field3601.containsKey((Object) this.Field1975)) {
                                int n3 = TotemPopManager2.Field3601.get((Object) this.Field1975) + 1;
                                AliceMain.Field759.Method2164871(new EventTotemPop(EnumStages.PRE, (EntityLivingBase) this.Field1975, n3));
                                TotemPopManager2.Field3601.remove((Object) this.Field1975);
                                TotemPopManager2.Field3601.put((EntityLivingBase) this.Field1975, n3);
                            } else {
                                AliceMain.Field759.Method2164871(new EventTotemPop(EnumStages.PRE, (EntityLivingBase) this.Field1975, 1));
                                TotemPopManager2.Field3601.put((EntityLivingBase) this.Field1975, 1);
                            }
                        }
                        this.Field1975.hurtTime = 5;
                    }
                } catch (Exception exception) {
                    return;
                }
            }
        }
    }
}

