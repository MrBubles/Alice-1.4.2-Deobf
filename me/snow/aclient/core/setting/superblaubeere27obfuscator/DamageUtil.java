

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemSpade
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class DamageUtil
        implements Util {
    public static boolean Method2163451(EntityPlayer entityPlayer, int n2) {
        for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
            if (itemStack == null) {
                return true;
            }
            if (DamageUtil.Method2163453(itemStack) >= n2) continue;
            return true;
        }
        return false;
    }

    public static boolean Method2163452(EntityPlayer entityPlayer) {
        for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
            if (itemStack == null || itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    public static int Method2163453(ItemStack itemStack) {
        return itemStack.getMaxDamage() - itemStack.getItemDamage();
    }

    public static float Method2163454(ItemStack itemStack) {
        return (float) DamageUtil.Method2163453(itemStack) / (float) itemStack.getMaxDamage() * 100.0f;
    }

    public static int Method2163455(ItemStack itemStack) {
        return (int) DamageUtil.Method2163454(itemStack);
    }

    public static boolean Method2163456(ItemStack itemStack) {
        Item item = itemStack.getItem();
        return item instanceof ItemArmor || item instanceof ItemSword || item instanceof ItemTool || item instanceof ItemShield;
    }

    public static boolean Method2163457(EntityPlayer entityPlayer) {
        int n2 = 0;
        PotionEffect potionEffect = DamageUtil.Field2811.player.getActivePotionEffect(MobEffects.STRENGTH);
        if (potionEffect != null) {
            n2 = potionEffect.getAmplifier();
        }
        return !DamageUtil.Field2811.player.isPotionActive(MobEffects.WEAKNESS) || n2 >= 1 || DamageUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword || DamageUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe || DamageUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemAxe || DamageUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSpade;
    }

    public static float Method2163458(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        double d4 = entity.getDistance(d, d2, d3) / (double) f;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        double d5 = 0.0;
        try {
            d5 = entity.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
        } catch (Exception exception) {
            // empty catch block
        }
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * (double) f + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = DamageUtil.Method2163459((EntityLivingBase) entity, DamageUtil.Method2163450(f2), new Explosion((World) DamageUtil.Field2811.world, null, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    public static float Method2163459(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
        float f2 = f;
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion) explosion);
            f2 = CombatRules.getDamageAfterAbsorb((float) f2, (float) entityPlayer.getTotalArmorValue(), (float) ((float) entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n2 = 0;
            try {
                n2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable) entityPlayer.getArmorInventoryList(), (DamageSource) damageSource);
            } catch (Exception exception) {
                // empty catch block
            }
            float f3 = MathHelper.clamp((float) n2, (float) 0.0f, (float) 20.0f);
            f2 *= 1.0f - f3 / 25.0f;
            if (entityLivingBase.isPotionActive(MobEffects.RESISTANCE)) {
                f2 -= f2 / 4.0f;
            }
            f2 = Math.max(f2, 0.0f);
            return f2;
        }
        f2 = CombatRules.getDamageAfterAbsorb((float) f2, (float) entityLivingBase.getTotalArmorValue(), (float) ((float) entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f2;
    }

    public static float Method2163450(float f) {
        int n2 = DamageUtil.Field2811.world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static float Method2163461(Entity entity, Entity entity2) {
        return DamageUtil.Method2163458(entity.posX, entity.posY, entity.posZ, entity2);
    }

    public static float Method2163462(BlockPos blockPos, Entity entity) {
        return DamageUtil.Method2163458((double) blockPos.getX() + 0.5, blockPos.getY() + 1, (double) blockPos.getZ() + 0.5, entity);
    }

    public static boolean Method2163463(boolean bl) {
        return !DamageUtil.Field2811.player.capabilities.isCreativeMode && !bl;
    }

    public static int Method2163464(EntityPlayer entityPlayer) {
        Item item = entityPlayer.getHeldItemMainhand().getItem();
        if (item instanceof ItemSword) {
            return 600;
        }
        if (item instanceof ItemPickaxe) {
            return 850;
        }
        if (item == Items.IRON_AXE) {
            return 1100;
        }
        if (item == Items.STONE_HOE) {
            return 500;
        }
        if (item == Items.IRON_HOE) {
            return 350;
        }
        if (item == Items.WOODEN_AXE || item == Items.STONE_AXE) {
            return 1250;
        }
        if (item instanceof ItemSpade || item == Items.GOLDEN_AXE || item == Items.DIAMOND_AXE || item == Items.WOODEN_HOE || item == Items.GOLDEN_HOE) {
            return 1000;
        }
        return 250;
    }

    public static float Method2163465(ItemStack itemStack) {
        return (float) DamageUtil.Method2163466(itemStack) / (float) itemStack.getMaxDamage() * 100.0f;
    }

    public static int Method2163466(ItemStack itemStack) {
        return itemStack.getMaxDamage() - itemStack.getItemDamage();
    }
}

