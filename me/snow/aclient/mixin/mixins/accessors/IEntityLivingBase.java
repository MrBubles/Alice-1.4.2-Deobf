/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 */
package me.snow.aclient.mixin.mixins.accessors;

import java.util.Map;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityLivingBase.class})
public interface IEntityLivingBase {
    @Accessor(value="activePotionsMap")
    public Map<Potion, PotionEffect> getActivePotionMap();

    @Invoker(value="onNewPotionEffect")
    public void hookOnNewPotionEffect(PotionEffect var1);

    @Invoker(value="onChangedPotionEffect")
    public void hookOnChangedPotionEffect(PotionEffect var1, boolean var2);

    @Invoker(value="getArmSwingAnimationEnd")
    public int hookGetArmSwingAnimationEnd();

    @Invoker(value="getArmSwingAnimationEnd")
    public int getArmSwingAnimationEnd();

    @Accessor(value="ticksSinceLastSwing")
    public int getTicksSinceLastSwing();

    @Accessor(value="activeItemStackUseCount")
    public int getActiveItemStackUseCount();

    @Accessor(value="ticksSinceLastSwing")
    public void setTicksSinceLastSwing(int var1);

    @Accessor(value="activeItemStackUseCount")
    public void setActiveItemStackUseCount(int var1);
}

