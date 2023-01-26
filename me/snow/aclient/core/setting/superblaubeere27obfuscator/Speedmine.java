

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.MobEffects
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoTrap;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryManagerCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderBuilderCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtilCC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Speedmine
        extends Module {
    public static Speedmine Field3402;
    private static float Field3412;
    private final Setting<Integer> Field3409 = this.Method2150366(new Setting<Integer>("BoxAlpha", 60, 0, 255));
    public Setting<Boolean> Field3404 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    public Setting<InventoryManagerCC.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field3406 = this.Method2150366(new Setting<InventoryManagerCC.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("SwitchMode", InventoryManagerCC.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PACKET));
    private Setting<Double> Field3403 = this.Method2150366(new Setting<Double>("Range", 6.0, 0.0, 6.0));
    private Setting<Boolean> Field3405 = this.Method2150366(new Setting<Boolean>("Reset", false));
    private Setting<Boolean> Field3407 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private Setting<Boolean> Field3408 = this.Method2150366(new Setting<Boolean>("LimitRetry", true));
    private BlockPos Field3410;
    private EnumFacing Field3411;
    private int Field3413;
    private int Field3414;

    public Speedmine() {
        super("Speedmine", "Mines faster.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        Field3402 = this;
    }

    public static void Method2162201() {
        AliceMain.Field756.Method2150180(Speedmine.class).Field3403.setValue(6.0);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3404.setValue(true);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3406.setValue(InventoryManagerCC.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PACKET);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3407.setValue(false);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3408.setValue(true);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3409.setValue(60);
    }

    public static void Method2162202() {
        AliceMain.Field756.Method2150180(Speedmine.class).Field3403.setValue(6.0);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3404.setValue(true);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3406.setValue(InventoryManagerCC.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PACKET);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3407.setValue(true);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3408.setValue(true);
        AliceMain.Field756.Method2150180(Speedmine.class).Field3409.setValue(60);
    }

    @Override
    public void Method2150379() {
        if (!Speedmine.Field2811.player.capabilities.isCreativeMode) {
            if (this.Field3410 != null) {
                double d = BlockUtilCC.Method2163268((EntityPlayer) Speedmine.Field2811.player, this.Field3410);
                if (this.Field3413 >= 2 && this.Field3408.getValue().booleanValue() || d > this.Field3403.getValue()) {
                    this.Field3410 = null;
                    this.Field3411 = null;
                    Field3412 = 0.0f;
                    this.Field3413 = 0;
                }
            }
            if (this.Field3410 != null && !Speedmine.Field2811.world.isAirBlock(this.Field3410)) {
                if (Field3412 >= 1.0f && (!AliceMain.Field756.Method2150180(AutoTrap.class).Field3980.getValue().booleanValue() || !AutoTrap.Field3974 && AliceMain.Field756.Method2150180(AutoTrap.class).Field3980.getValue().booleanValue())) {
                    ItemStack itemStack;
                    short s;
                    int n2 = Speedmine.Field2811.player.inventory.currentItem;
                    int n3 = AliceMain.Field781.Method2163277(this.Method2162205(Speedmine.Field2811.world.getBlockState(this.Field3410)).getItem(), InventoryManagerCC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.HOTBAR) + 36;
                    if (this.Field3407.getValue().booleanValue()) {
                        s = Speedmine.Field2811.player.openContainer.getNextTransactionID(Speedmine.Field2811.player.inventory);
                        itemStack = Speedmine.Field2811.player.openContainer.slotClick(n3, Speedmine.Field2811.player.inventory.currentItem, ClickType.SWAP, (EntityPlayer) Speedmine.Field2811.player);
                        Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketClickWindow(Speedmine.Field2811.player.inventoryContainer.windowId, n3, Speedmine.Field2811.player.inventory.currentItem, ClickType.SWAP, itemStack, s));
                    } else {
                        AliceMain.Field781.Method2163272(this.Method2162205(Speedmine.Field2811.world.getBlockState(this.Field3410)).getItem(), this.Field3406.getValue());
                    }
                    Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.Field3410, this.Field3411));
                    Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.Field3410, EnumFacing.UP));
                    if (this.Field3407.getValue().booleanValue()) {
                        Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field3410, this.Field3411));
                    }
                    Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.Field3410, this.Field3411));
                    if (n2 != -1) {
                        if (this.Field3407.getValue().booleanValue()) {
                            s = Speedmine.Field2811.player.openContainer.getNextTransactionID(Speedmine.Field2811.player.inventory);
                            itemStack = Speedmine.Field2811.player.openContainer.slotClick(n3, Speedmine.Field2811.player.inventory.currentItem, ClickType.SWAP, (EntityPlayer) Speedmine.Field2811.player);
                            Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketClickWindow(Speedmine.Field2811.player.inventoryContainer.windowId, n3, Speedmine.Field2811.player.inventory.currentItem, ClickType.SWAP, itemStack, s));
                            Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketConfirmTransaction(Speedmine.Field2811.player.inventoryContainer.windowId, s, true));
                        } else {
                            AliceMain.Field781.Method2163271(n2, InventoryManagerCC.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PACKET);
                        }
                    }
                    Field3412 = 0.0f;
                    ++this.Field3413;
                }
                if (!AutoCrystal.Method2150936().Field188 && (double) Field3412 > 0.95 && this.Field3404.getValue().booleanValue()) {
                    BlockUtil2.Method2164235(this.Field3410.getX(), this.Field3410.getY(), this.Field3410.getZ());
                }
                Field3412 += this.Method2162206(Speedmine.Field2811.world.getBlockState(this.Field3410), this.Field3410);
            }
        }
    }

    @Override
    public void Method2150372() {
        if (Speedmine.Field2811.player.isPotionActive(MobEffects.HASTE)) {
            this.Field3414 = Speedmine.Field2811.player.getActivePotionEffect(MobEffects.HASTE).getDuration();
        }
    }

    @Override
    public void Method2150373() {
        if (Speedmine.Field2811.player.isPotionActive(MobEffects.HASTE)) {
            Speedmine.Field2811.player.removePotionEffect(MobEffects.HASTE);
        }
        if (this.Field3414 > 0) {
            Speedmine.Field2811.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, this.Field3414));
        }
        this.Field3410 = null;
        this.Field3411 = null;
        Field3412 = 0.0f;
        this.Field3413 = 0;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (!Speedmine.Field2811.player.capabilities.isCreativeMode && this.Field3410 != null && !Speedmine.Field2811.world.isAirBlock(this.Field3410)) {
            AxisAlignedBB axisAlignedBB = Speedmine.Field2811.world.getBlockState(this.Field3410).getSelectedBoundingBox((World) Speedmine.Field2811.world, this.Field3410);
            Vec3d vec3d = axisAlignedBB.getCenter();
            AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(vec3d.x, vec3d.y, vec3d.z, vec3d.x, vec3d.y, vec3d.z);
            RenderUtilCC.Method2163310(new RenderBuilderCC().Method2163208(axisAlignedBB2.grow((axisAlignedBB.minX - axisAlignedBB.maxX) * 0.5 * (double) MathHelper.clamp((float) Field3412, (float) 0.0f, (float) 1.0f), (axisAlignedBB.minY - axisAlignedBB.maxY) * 0.5 * (double) MathHelper.clamp((float) Field3412, (float) 0.0f, (float) 1.0f), (axisAlignedBB.minZ - axisAlignedBB.maxZ) * 0.5 * (double) MathHelper.clamp((float) Field3412, (float) 0.0f, (float) 1.0f))).Method2163312((double) Field3412 >= 0.95 ? new Color(0, 255, 0, this.Field3409.getValue()) : new Color(255, 0, 0, this.Field3409.getValue())).Method2163313(RenderBuilderCC.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BOTH).Method2163297().Method2163201(1.5f).Method2163202(false).Method2163204(false).Method2163203(false).Method2163298(true).Method2163299().Method2163290());
        }
    }

    @SubscribeEvent
    public void Method2162203(BlockEvent blockEvent) {
        if (BlockUtilCC.Method2163265(blockEvent.Field3432) && !Speedmine.Field2811.player.capabilities.isCreativeMode && !blockEvent.Field3432.equals((Object) this.Field3410)) {
            this.Field3410 = blockEvent.Field3432;
            this.Field3411 = blockEvent.Field3433;
            Field3412 = 0.0f;
            this.Field3413 = 0;
            if (this.Field3410 != null && this.Field3411 != null) {
                Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field3410, this.Field3411));
                Speedmine.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.Field3410, EnumFacing.UP));
            }
        }
    }

    @SubscribeEvent
    public void Method2162204(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketHeldItemChange && this.Field3407.getValue().booleanValue()) {
            Field3412 = 0.0f;
        }
    }

    public ItemStack Method2162205(IBlockState iBlockState) {
        int n2 = -1;
        double d = 0.0;
        for (int j = 0; j < 9; ++j) {
            float f;
            if (Speedmine.Field2811.player.inventory.getStackInSlot(j).isEmpty() || !((f = Speedmine.Field2811.player.inventory.getStackInSlot(j).getDestroySpeed(iBlockState)) > 1.0f))
                continue;
            if (EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) Speedmine.Field2811.player.inventory.getStackInSlot(j)) > 0) {
                f = (float) ((double) f + (StrictMath.pow(EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) Speedmine.Field2811.player.inventory.getStackInSlot(j)), 2.0) + 1.0));
            }
            if (!((double) f > d)) continue;
            d = f;
            n2 = j;
        }
        if (n2 != -1) {
            return Speedmine.Field2811.player.inventory.getStackInSlot(n2);
        }
        return Speedmine.Field2811.player.inventory.getStackInSlot(Speedmine.Field2811.player.inventory.currentItem);
    }

    public float Method2162206(IBlockState iBlockState, BlockPos blockPos) {
        float f = iBlockState.getBlockHardness((World) Speedmine.Field2811.world, blockPos);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!this.Method2162207(iBlockState.getBlock(), blockPos)) {
            return this.Method2162208(iBlockState) / f / 100.0f;
        }
        return this.Method2162208(iBlockState) / f / 30.0f;
    }

    public boolean Method2162207(Block block, BlockPos blockPos) {
        IBlockState iBlockState = Speedmine.Field2811.world.getBlockState(blockPos);
        IBlockState iBlockState2 = iBlockState.getBlock().getActualState(iBlockState, (IBlockAccess) Speedmine.Field2811.world, blockPos);
        if (iBlockState2.getMaterial().isToolNotRequired()) {
            return true;
        }
        ItemStack itemStack = this.Method2162205(iBlockState2);
        String string = block.getHarvestTool(iBlockState2);
        if (itemStack.isEmpty() || string == null) {
            return Speedmine.Field2811.player.canHarvestBlock(iBlockState2);
        }
        int n2 = itemStack.getItem().getHarvestLevel(itemStack, string, (EntityPlayer) Speedmine.Field2811.player, iBlockState2);
        if (n2 < 0) {
            return Speedmine.Field2811.player.canHarvestBlock(iBlockState2);
        }
        return n2 >= block.getHarvestLevel(iBlockState2);
    }

    public float Method2162208(IBlockState iBlockState) {
        ItemStack itemStack;
        int n2;
        float f = this.Method2162209(iBlockState);
        if (f > 1.0f && (n2 = EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) (itemStack = this.Method2162205(iBlockState)))) > 0 && !itemStack.isEmpty()) {
            f = (float) ((double) f + (StrictMath.pow(n2, 2.0) + 1.0));
        }
        if (Speedmine.Field2811.player.isPotionActive(MobEffects.HASTE)) {
            f *= 1.0f + (float) (Speedmine.Field2811.player.getActivePotionEffect(MobEffects.HASTE).getAmplifier() + 1) * 0.2f;
        }
        if (Speedmine.Field2811.player.isPotionActive(MobEffects.MINING_FATIGUE)) {
            float f2;
            switch (Speedmine.Field2811.player.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) {
                case 0: {
                    f2 = 0.3f;
                    break;
                }
                case 1: {
                    f2 = 0.09f;
                    break;
                }
                case 2: {
                    f2 = 0.0027f;
                    break;
                }
                default: {
                    f2 = 8.1E-4f;
                }
            }
            f *= f2;
        }
        if (Speedmine.Field2811.player.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier((EntityLivingBase) Speedmine.Field2811.player)) {
            f /= 5.0f;
        }
        if (!Speedmine.Field2811.player.onGround) {
            f /= 5.0f;
        }
        return f < 0.0f ? 0.0f : f;
    }

    public float Method2162209(IBlockState iBlockState) {
        float f = 1.0f;
        if (this.Method2162205(iBlockState) != null && !this.Method2162205(iBlockState).isEmpty()) {
            f *= this.Method2162205(iBlockState).getDestroySpeed(iBlockState);
        }
        return f;
    }
}

