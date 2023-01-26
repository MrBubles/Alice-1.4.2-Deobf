

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickBlock
 *  net.minecraftforge.event.world.BlockEvent$BreakEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockTweaks
        extends Module {
    private static BlockTweaks Field4281 = new BlockTweaks();
    public Setting<Boolean> Field4282 = this.Method2150366(new Setting<Boolean>("AutoTool", false));
    public Setting<Boolean> Field4283 = this.Method2150366(new Setting<Boolean>("AutoWeapon", false));
    public Setting<Boolean> Field4284 = this.Method2150366(new Setting<Boolean>("NoFriendAttack", false));
    public Setting<Boolean> Field4285 = this.Method2150366(new Setting<Boolean>("NoGlitchBlocks", false));
    public Setting<Boolean> Field4286 = this.Method2150366(new Setting<Object>("Destroy", Boolean.valueOf(false), this::Method2162223));
    private int Field4287 = -1;
    private int Field4288 = -1;
    private boolean Field4289;

    public BlockTweaks() {
        super("BlockTweaks", "Some tweaks for blocks.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2162214();
    }

    public static BlockTweaks Method2162213() {
        if (Field4281 == null) {
            Field4281 = new BlockTweaks();
        }
        return Field4281;
    }

    private void Method2162214() {
        Field4281 = this;
    }

    @Override
    public void Method2150373() {
        if (this.Field4289) {
            this.Method2162222(this.Field4287, false);
        }
        this.Field4287 = -1;
        this.Field4288 = -1;
    }

    @SubscribeEvent
    public void Method2162215(BlockEvent.BreakEvent breakEvent) {
        if (BlockTweaks.Method2150359() || !this.Field4285.getValue().booleanValue() || !this.Field4286.getValue().booleanValue()) {
            return;
        }
        if (!(BlockTweaks.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemBlock)) {
            BlockPos blockPos = BlockTweaks.Field2811.player.getPosition();
            this.Method2162219(blockPos);
        }
    }

    @SubscribeEvent
    public void Method2162216(PlayerInteractEvent.LeftClickBlock leftClickBlock) {
        if (this.Field4282.getValue().booleanValue() && !BlockTweaks.Method2150359() && leftClickBlock.getPos() != null) {
            this.Method2162210(BlockTweaks.Field2811.world.getBlockState(leftClickBlock.getPos()));
        }
    }

    @SubscribeEvent
    public void Method2162217(AttackEntityEvent attackEntityEvent) {
        if (this.Field4283.getValue().booleanValue() && !BlockTweaks.Method2150359() && attackEntityEvent.getTarget() != null) {
            this.Method2162221(attackEntityEvent.getTarget());
        }
    }

    @SubscribeEvent
    public void Method2162218(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        Entity entity;
        if (BlockTweaks.Method2150359()) {
            return;
        }
        if (this.Field4284.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketUseEntity && (entity = ((CPacketUseEntity) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getEntityFromWorld((World) BlockTweaks.Field2811.world)) != null && AliceMain.Field765.Method2150168(entity.getName())) {
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
        }
    }

    @Override
    public void Method2150379() {
        if (!BlockTweaks.Method2150359()) {
            if (BlockTweaks.Field2811.player.inventory.currentItem != this.Field4287 && BlockTweaks.Field2811.player.inventory.currentItem != this.Field4288) {
                this.Field4287 = BlockTweaks.Field2811.player.inventory.currentItem;
            }
            if (!BlockTweaks.Field2811.gameSettings.keyBindAttack.isKeyDown() && this.Field4289) {
                this.Method2162222(this.Field4287, false);
            }
        }
    }

    private void Method2162219(BlockPos blockPos) {
        for (int j = -4; j <= 4; ++j) {
            for (int i2 = -4; i2 <= 4; ++i2) {
                for (int i3 = -4; i3 <= 4; ++i3) {
                    BlockPos blockPos2 = new BlockPos(blockPos.getX() + j, blockPos.getY() + i2, blockPos.getZ() + i3);
                    if (!BlockTweaks.Field2811.world.getBlockState(blockPos2).getBlock().equals((Object) Blocks.AIR))
                        continue;
                    BlockTweaks.Field2811.playerController.processRightClickBlock(BlockTweaks.Field2811.player, BlockTweaks.Field2811.world, blockPos2, EnumFacing.DOWN, new Vec3d(0.5, 0.5, 0.5), EnumHand.MAIN_HAND);
                }
            }
        }
    }

    private void Method2162210(IBlockState iBlockState) {
        int n2 = -1;
        double d = 0.0;
        for (int j = 0; j < 9; ++j) {
            int n3;
            float f;
            ItemStack itemStack = BlockTweaks.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack.isEmpty) continue;
            float f2 = itemStack.getDestroySpeed(iBlockState);
            if (!(f > 1.0f) || !((double) (f2 = (float) ((double) f2 + ((n3 = EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) itemStack)) > 0 ? Math.pow(n3, 2.0) + 1.0 : 0.0))) > d))
                continue;
            d = f2;
            n2 = j;
        }
        this.Method2162222(n2, true);
    }

    public void Method2162221(Entity entity) {
        int n2 = -1;
        double d = 0.0;
        EnumCreatureAttribute enumCreatureAttribute = EnumCreatureAttribute.UNDEFINED;
        if (EntityUtil.Method2163537(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
            enumCreatureAttribute = entityLivingBase.getCreatureAttribute();
        }
        for (int j = 0; j < 9; ++j) {
            double d2;
            ItemStack itemStack = BlockTweaks.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack.isEmpty) continue;
            if (itemStack.getItem() instanceof ItemTool) {
                d2 = (double) ((ItemTool) itemStack.getItem()).attackDamage + (double) EnchantmentHelper.getModifierForCreature((ItemStack) itemStack, (EnumCreatureAttribute) enumCreatureAttribute);
                if (!(d2 > d)) continue;
                d = d2;
                n2 = j;
                continue;
            }
            if (!(itemStack.getItem() instanceof ItemSword) || !((d2 = (double) ((ItemSword) itemStack.getItem()).getAttackDamage() + (double) EnchantmentHelper.getModifierForCreature((ItemStack) itemStack, (EnumCreatureAttribute) enumCreatureAttribute)) > d))
                continue;
            d = d2;
            n2 = j;
        }
        this.Method2162222(n2, true);
    }

    private void Method2162222(int n2, boolean bl) {
        if (n2 != -1) {
            if (n2 != BlockTweaks.Field2811.player.inventory.currentItem) {
                this.Field4287 = BlockTweaks.Field2811.player.inventory.currentItem;
            }
            this.Field4288 = n2;
            BlockTweaks.Field2811.player.inventory.currentItem = n2;
            BlockTweaks.Field2811.playerController.syncCurrentPlayItem();
            this.Field4289 = bl;
        }
    }

    private boolean Method2162223(Object object) {
        return this.Field4285.getValue();
    }
}

