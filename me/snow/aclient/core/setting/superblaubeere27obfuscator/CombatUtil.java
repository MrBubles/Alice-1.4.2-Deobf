

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.Minecraft
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CombatUtil {
    public static final List<Block> Field597 = Arrays.asList(new Block[]{Blocks.TALLGRASS, Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR});
    public static final List<Block> Field598 = Arrays.asList(new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
    public static final Vec3d[] Field600 = new Vec3d[]{new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(2.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 2.0), new Vec3d(-2.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -2.0)};
    private static final List<Integer> Field601 = Arrays.asList(0, 5, 6, 7, 8);
    private static Minecraft Field599 = Minecraft.getMinecraft();

    public static int Method2163394() {
        if (CombatUtil.Field599.player == null) {
            return -1;
        }
        for (int j = 0; j < CombatUtil.Field599.player.inventoryContainer.getInventory().size(); ++j) {
            ItemStack itemStack;
            if (Field601.contains(j) || (itemStack = (ItemStack) CombatUtil.Field599.player.inventoryContainer.getInventory().get(j)).isEmpty() || !itemStack.getItem().equals((Object) Items.GOLDEN_APPLE) || itemStack.getItemDamage() == 1)
                continue;
            return j;
        }
        return -1;
    }

    public static EntityPlayer Method2163395(float f) {
        EntityPlayer entityPlayer = null;
        int n2 = CombatUtil.Field599.world.playerEntities.size();
        for (int j = 0; j < n2; ++j) {
            EntityPlayer entityPlayer2 = (EntityPlayer) CombatUtil.Field599.world.playerEntities.get(j);
            if (EntityUtil.Method2163545((Entity) entityPlayer2, f)) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(CombatUtil.Field599.player.getDistanceSq((Entity) entityPlayer2) < CombatUtil.Field599.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static int Method2163396(Item item) {
        if (CombatUtil.Field599.player == null) {
            return -1;
        }
        for (int j = 0; j < CombatUtil.Field599.player.inventoryContainer.getInventory().size(); ++j) {
            ItemStack itemStack;
            if (Field601.contains(j) || (itemStack = (ItemStack) CombatUtil.Field599.player.inventoryContainer.getInventory().get(j)).isEmpty() || !itemStack.getItem().equals((Object) item) || itemStack.getItemDamage() != 1)
                continue;
            return j;
        }
        return -1;
    }

    public static int Method2163397(Item item) {
        if (CombatUtil.Field599.player == null) {
            return -1;
        }
        for (int j = 0; j < CombatUtil.Field599.player.inventoryContainer.getInventory().size(); ++j) {
            ItemStack itemStack;
            if (Field601.contains(j) || (itemStack = (ItemStack) CombatUtil.Field599.player.inventoryContainer.getInventory().get(j)).isEmpty() || !itemStack.getItem().equals((Object) item))
                continue;
            return j;
        }
        return -1;
    }

    public static boolean Method2163398(boolean bl) {
        if (bl) {
            return CombatUtil.Field599.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL;
        }
        return CombatUtil.Field599.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL || CombatUtil.Field599.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public static boolean Method2163399(double d) {
        int n2 = (int) CombatUtil.Field599.world.loadedEntityList.stream().filter(CombatUtil::Method2163449).filter(arg_0 -> CombatUtil.Method2163448(d, arg_0)).filter(CombatUtil::Method2163447).count();
        return n2 > 0;
    }

    public static boolean Method2163390(double d, Item item, boolean bl) {
        double d2 = CombatUtil.Field599.player.getHealth() + CombatUtil.Field599.player.getAbsorptionAmount();
        if (!bl ? CombatUtil.Method2163397(item) == -1 : CombatUtil.Method2163394() == -1) {
            return false;
        }
        return !(d2 < d);
    }

    public static void Method2163301(int n2, int n3) {
        switch (n3) {
            case 0: {
                CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
                break;
            }
            case 1: {
                CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
                break;
            }
            case 2: {
                CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
                CombatUtil.Field599.playerController.updateController();
            }
        }
    }

    public static void Method2163302() {
        int n2 = CombatUtil.Method2163397(Items.TOTEM_OF_UNDYING);
        if (n2 != -1) {
            CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
            CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
            CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
            CombatUtil.Field599.playerController.updateController();
        }
    }

    public static void Method2163303(int n2) {
        CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
        CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
        CombatUtil.Field599.playerController.windowClick(CombatUtil.Field599.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer) CombatUtil.Field599.player);
        CombatUtil.Field599.playerController.updateController();
    }

    public static boolean Method2163304(BlockPos blockPos) {
        return CombatUtil.Field599.world.rayTraceBlocks(new Vec3d(CombatUtil.Field599.player.posX, CombatUtil.Field599.player.posY + (double) CombatUtil.Field599.player.getEyeHeight(), CombatUtil.Field599.player.posZ), new Vec3d((double) blockPos.getX(), (double) ((float) blockPos.getY() + 1.0f), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2163305(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n2) {
        Object object;
        if (!CombatUtil.Method2163300(blockPos)) {
            return false;
        }
        EnumFacing enumFacing = CombatUtil.Method2163309(blockPos);
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        if (!CombatUtil.Field599.world.getBlockState(blockPos2).getBlock().canCollideCheck(CombatUtil.Field599.world.getBlockState(blockPos2), false)) {
            return false;
        }
        if (bl4) {
            if (bl5) {
                CombatUtil.Field599.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            } else if (CombatUtil.Field599.player.inventory.currentItem != n2) {
                CombatUtil.Field599.player.inventory.currentItem = n2;
            }
        }
        boolean bl6 = false;
        if (Field597.contains((Object) CombatUtil.Field599.world.getBlockState(blockPos2).getBlock()) || Field598.contains((Object) CombatUtil.Field599.world.getBlockState(blockPos2).getBlock())) {
            CombatUtil.Field599.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) CombatUtil.Field599.player, CPacketEntityAction.Action.START_SNEAKING));
            bl6 = true;
        }
        Vec3d vec3d = CombatUtil.Method2163306(blockPos2, enumFacing2);
        if (bl2) {
            object = CombatUtil.Method2163430(vec3d);
            CombatUtil.Field599.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(object[0], object[1], CombatUtil.Field599.player.onGround));
        }
        object = (Object) (bl ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
        CombatUtil.Field599.playerController.processRightClickBlock(CombatUtil.Field599.player, CombatUtil.Field599.world, blockPos2, enumFacing2, vec3d, (EnumHand) object);
        CombatUtil.Field599.player.connection.sendPacket((Packet) new CPacketAnimation((EnumHand) object));
        if (bl6) {
            CombatUtil.Field599.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) CombatUtil.Field599.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return true;
    }

    private static Vec3d Method2163306(BlockPos blockPos, EnumFacing enumFacing) {
        return new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
    }

    public static Vec3d Method2163307(double d, double d2, double d3, BlockPos blockPos, EnumFacing enumFacing) {
        return new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
    }

    public static void Method2163308(BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        switch (1.F ield626[CombatUtil.Method2163309(blockPos).ordinal()]){
            case 1: {
                f = 0.5f;
                f3 = 0.5f;
                f2 = 0.0f;
                break;
            }
            case 2: {
                f = 0.5f;
                f3 = 0.5f;
                f2 = -0.5f;
                break;
            }
            case 3: {
                f3 = 0.5f;
                f2 = -0.5f;
                f = -0.5f;
                break;
            }
            case 4: {
                f3 = 0.5f;
                f2 = -0.5f;
                f = 0.5f;
                break;
            }
            case 5: {
                f3 = 0.5f;
                f2 = -0.5f;
                f = 0.5f;
                break;
            }
            case 6: {
                f3 = -0.5f;
                f2 = -0.5f;
                f = 0.5f;
            }
        }
        float[] arrf = CombatUtil.Method2163430(CombatUtil.Method2163307(f3, f2, f, blockPos, enumFacing));
        CombatUtil.Field599.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], arrf[1], CombatUtil.Field599.player.onGround));
    }

    private static EnumFacing Method2163309(BlockPos blockPos) {
        EnumFacing enumFacing = null;
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing2);
            if (!CombatUtil.Field599.world.getBlockState(blockPos2).getBlock().canCollideCheck(CombatUtil.Field599.world.getBlockState(blockPos2), false) || CombatUtil.Field599.world.getBlockState(blockPos2).getMaterial().isReplaceable())
                continue;
            enumFacing = enumFacing2;
        }
        return enumFacing;
    }

    public static boolean Method2163300(BlockPos blockPos) {
        if (!(CombatUtil.Field599.world.getBlockState(blockPos).getBlock() instanceof BlockAir) && !(CombatUtil.Field599.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) {
            return false;
        }
        for (Entity entity : CombatUtil.Field599.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
            if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityArrow)
                continue;
            return false;
        }
        return CombatUtil.Method2163309(blockPos) != null;
    }

    public static boolean Method2163411(EntityPlayer entityPlayer, double d, double d2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        BlockPos blockPos = new BlockPos(entityPlayer.getPositionVector());
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing == EnumFacing.UP || enumFacing == EnumFacing.DOWN) continue;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            BlockPos blockPos3 = blockPos2.offset(enumFacing);
            if (!(CombatUtil.Field599.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && (CombatUtil.Field599.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && CombatUtil.Method2163412(CombatUtil.Field599.world.getBlockState(blockPos3.up()).getBlock()) || !bl) && !bl4 || CombatUtil.Field599.player.getDistanceSq(blockPos3) <= d2 * d2 && CombatUtil.Field599.player.getDistanceSq((Entity) entityPlayer) <= d * d && CombatUtil.Method2163412(CombatUtil.Field599.world.getBlockState(blockPos.up(3)).getBlock()) || !bl2))
                continue;
            return true;
        }
        return false;
    }

    public static boolean Method2163412(Block block) {
        return block == Blocks.OBSIDIAN || block == Blocks.BEDROCK;
    }

    public static boolean Method2163413(EntityPlayer entityPlayer, double d) {
        int n2 = 0;
        int n3 = 0;
        for (Vec3d vec3d : HoleUtil.Field1114) {
            BlockPos blockPos = CombatUtil.Method2163432((Entity) entityPlayer).add(vec3d.x, vec3d.y, vec3d.z);
            if (CombatUtil.Field599.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || CombatUtil.Field599.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK) {
                ++n2;
            }
            if (!(CombatUtil.Field599.player.getDistanceSq(blockPos) >= d * d)) continue;
            ++n3;
        }
        return n2 == 4 && n3 >= 1;
    }

    public static int Method2163414(BlockPos blockPos) {
        return 0;
    }

    public static boolean Method2163415(BlockPos blockPos, double d, double d2, boolean bl) {
        BlockPos blockPos2 = blockPos.up();
        BlockPos blockPos3 = blockPos2.up();
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos2).expand(0.0, 1.0, 0.0);
        return (CombatUtil.Field599.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || CombatUtil.Field599.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK) && CombatUtil.Field599.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && CombatUtil.Field599.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && CombatUtil.Field599.world.getEntitiesWithinAABB(Entity.class, axisAlignedBB).isEmpty() && CombatUtil.Field599.player.getDistanceSq(blockPos) <= d * d && !bl || CombatUtil.Method2163429(blockPos, d2, 0.0);
    }

    public static int Method2163416(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (CombatUtil.Method2163411(entityPlayer, d, d2, true, true, true, false) && bl) {
            return 5;
        }
        if (CombatUtil.Method2163423(entityPlayer, d4, d5, d6, d2, d3, d7, bl2, bl4, bl5, true) != null) {
            return 4;
        }
        if ((double) (entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount()) <= d8) {
            return 3;
        }
        if (CombatUtil.Method2163426(entityPlayer, n2, true) && bl3) {
            return 2;
        }
        return 0;
    }

    public static Map<BlockPos, Double> Method2163417(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, double d5, double d6, boolean bl, boolean bl2, boolean bl3) {
        HashMap<BlockPos, Double> hashMap = new HashMap<BlockPos, Double>();
        for (BlockPos blockPos : CombatUtil.Method2163425(new BlockPos((Vec3i) CombatUtil.Method2163432((Entity) CombatUtil.Field599.player)), (float) d4, (int) d4, false, true, 0)) {
            double d7;
            if (!CombatUtil.Method2163415(blockPos, d4, d5, bl) || !CombatUtil.Method2163418(blockPos, d2, d6, bl3) || !CombatUtil.Method2163410(blockPos, d, bl2) || bl && !CombatUtil.Method2163429(blockPos, d5, 0.0))
                continue;
            double d8 = CombatUtil.Method2163437(blockPos, (Entity) entityPlayer);
            if (d7 < d3) continue;
            hashMap.put(blockPos, d8);
        }
        return hashMap;
    }

    public static boolean Method2163418(BlockPos blockPos, double d, double d2, boolean bl) {
        for (EntityPlayer entityPlayer : CombatUtil.Field599.world.playerEntities) {
            if (CombatUtil.Field599.player.getDistanceSq((Entity) entityPlayer) > d2 * d2) continue;
            if ((double) CombatUtil.Method2163437(blockPos, (Entity) entityPlayer) > d) {
                return false;
            }
            if (!(CombatUtil.Method2163437(blockPos, (Entity) entityPlayer) > entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount()) || !bl)
                continue;
            return false;
        }
        return true;
    }

    public static boolean Method2163419(EntityEnderCrystal entityEnderCrystal, double d, double d2, boolean bl) {
        for (EntityPlayer entityPlayer : CombatUtil.Field599.world.playerEntities) {
            if (CombatUtil.Field599.player.getDistanceSq((Entity) entityPlayer) > d2 * d2) continue;
            if ((double) CombatUtil.Method2163436((Entity) entityEnderCrystal, (Entity) entityPlayer) > d) {
                return false;
            }
            if (!(CombatUtil.Method2163436((Entity) entityEnderCrystal, (Entity) entityPlayer) > entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount()) || !bl)
                continue;
            return false;
        }
        return true;
    }

    public static boolean Method2163410(BlockPos blockPos, double d, boolean bl) {
        boolean bl2 = CombatUtil.Method2163437(blockPos, (Entity) CombatUtil.Field599.player) > CombatUtil.Field599.player.getHealth() + CombatUtil.Field599.player.getAbsorptionAmount();
        boolean bl3 = (double) CombatUtil.Method2163437(blockPos, (Entity) CombatUtil.Field599.player) > d;
        return (!bl || !bl2) && !bl3;
    }

    public static boolean Method2163421(EntityEnderCrystal entityEnderCrystal, double d, boolean bl) {
        boolean bl2 = CombatUtil.Method2163436((Entity) entityEnderCrystal, (Entity) CombatUtil.Field599.player) > CombatUtil.Field599.player.getHealth() + CombatUtil.Field599.player.getAbsorptionAmount();
        boolean bl3 = (double) CombatUtil.Method2163436((Entity) entityEnderCrystal, (Entity) CombatUtil.Field599.player) > d;
        return (!bl || !bl2) && !bl3;
    }

    public static boolean Method2163422(EntityPlayer entityPlayer, BlockPos blockPos, double d, double d2, double d3, double d4, double d5, double d6, boolean bl, boolean bl2, boolean bl3) {
        if (blockPos == null) {
            return false;
        }
        if (!CombatUtil.Method2163412(CombatUtil.Field599.world.getBlockState(blockPos).getBlock())) {
            return false;
        }
        if (!CombatUtil.Method2163415(blockPos, d4, d5, bl)) {
            return false;
        }
        if (!CombatUtil.Method2163418(blockPos, d2, d6, bl3)) {
            return false;
        }
        if (!CombatUtil.Method2163410(blockPos, d, bl2)) {
            return false;
        }
        double d7 = CombatUtil.Method2163437(blockPos, (Entity) entityPlayer);
        if (d7 < d3) {
            return false;
        }
        return !bl || CombatUtil.Method2163429(blockPos, d5, 0.0);
    }

    public static BlockPos Method2163423(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, double d5, double d6, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        double d7 = -1.0;
        BlockPos blockPos = null;
        if (entityPlayer == null) {
            return null;
        }
        List<BlockPos> list = CombatUtil.Method2163425(new BlockPos((Vec3i) CombatUtil.Method2163432((Entity) CombatUtil.Field599.player)), (float) d4, (int) d4, false, true, 0);
        list.sort(Comparator.comparing(CombatUtil::Method2163446));
        for (BlockPos blockPos2 : list) {
            double d8;
            if (!CombatUtil.Method2163415(blockPos2, d4, d5, bl) || bl && !CombatUtil.Method2163429(blockPos2, d5, 0.0) || (d8 = (double) CombatUtil.Method2163437(blockPos2, (Entity) entityPlayer)) < d3 || !CombatUtil.Method2163418(blockPos2, d2, d6, bl3) || !CombatUtil.Method2163410(blockPos2, d, bl2))
                continue;
            if (d8 > 15.0) {
                return blockPos2;
            }
            if (!(d8 > d7)) continue;
            d7 = d8;
            blockPos = blockPos2;
        }
        return blockPos;
    }

    public static BlockPos Method2163424(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, double d5, double d6, boolean bl, boolean bl2, boolean bl3) {
        CopyOnWriteArrayList<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> copyOnWriteArrayList = new CopyOnWriteArrayList<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>();
        BlockPos blockPos = null;
        for (BlockPos object : CombatUtil.Method2163425(new BlockPos(entityPlayer.getPositionVector()), 13.0f, 13, false, true, 0)) {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(entityPlayer, object, d, d2, d3, d4, d5, d6, bl, bl2, bl3);
            copyOnWriteArrayList.add(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll);
            iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.start();
        }
        boolean bl4 = false;
        do {
            for (IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll : copyOnWriteArrayList) {
                if (!iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.isInterrupted() || !iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field4514)
                    continue;
                blockPos = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field4502;
            }
            bl4 = copyOnWriteArrayList.stream().noneMatch(CombatUtil::Method2163445);
        } while (blockPos == null && !bl4);
        AliceMain.Field745.info(blockPos == null ? "pos was null" : blockPos.toString());
        return blockPos;
    }

    public static List<BlockPos> Method2163425(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n4 = blockPos.getX();
        int n5 = blockPos.getY();
        int n6 = blockPos.getZ();
        int n7 = n4 - (int) f;
        while ((float) n7 <= (float) n4 + f) {
            int n8 = n6 - (int) f;
            block1:
            while ((float) n8 <= (float) n6 + f) {
                int n9 = bl2 ? n5 - (int) f : n5;
                while (true) {
                    float f2;
                    float f3 = n9;
                    float f4 = f2 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    if (!(f3 < f2)) {
                        ++n8;
                        continue block1;
                    }
                    double d = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n7, n9 + n3, n8);
                        arrayList.add(blockPos2);
                    }
                    ++n9;
                }
            }
            ++n7;
        }
        return arrayList;
    }

    public static boolean Method2163426(EntityPlayer entityPlayer, int n2, boolean bl) {
        for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
            if (itemStack == null) {
                return true;
            }
            if (!bl || CombatUtil.Method2163427(itemStack) >= n2) continue;
            return true;
        }
        return false;
    }

    public static int Method2163427(ItemStack itemStack) {
        return itemStack.getMaxDamage() - itemStack.getItemDamage();
    }

    public static boolean Method2163428(Entity entity, double d) {
        boolean bl = CombatUtil.Field599.player.canEntityBeSeen(entity);
        return !bl || CombatUtil.Field599.player.getDistanceSq(entity) <= d * d;
    }

    public static boolean Method2163429(BlockPos blockPos, double d, double d2) {
        RayTraceResult rayTraceResult = CombatUtil.Field599.world.rayTraceBlocks(new Vec3d(CombatUtil.Field599.player.posX, CombatUtil.Field599.player.posY + (double) CombatUtil.Field599.player.getEyeHeight(), CombatUtil.Field599.player.posZ), new Vec3d((double) blockPos.getX(), (double) blockPos.getY() + d2, (double) blockPos.getZ()), false, true, false);
        return rayTraceResult == null || CombatUtil.Field599.player.getDistanceSq(blockPos) <= d * d;
    }

    public static Object Method2163420(EntityPlayer entityPlayer, double d, double d2, double d3, double d4, double d5, double d6, boolean bl, boolean bl2, boolean bl3) {
        if (entityPlayer == null) {
            return null;
        }
        List list = CombatUtil.Field599.world.loadedEntityList.stream().filter(CombatUtil::Method2163444).filter(arg_0 -> CombatUtil.Method2163443(d4, arg_0)).sorted(Comparator.comparingDouble(CombatUtil::Method2163442)).map(CombatUtil::Method2163441).collect(Collectors.toList());
        for (Object t : list) {
            if (bl && !CombatUtil.Method2163428((Entity) t, d5) || (double) CombatUtil.Method2163436((Entity) t, (Entity) entityPlayer) < d3 || !CombatUtil.Method2163421((EntityEnderCrystal) t, d, bl2) || !CombatUtil.Method2163419((EntityEnderCrystal) t, d2, d6, bl3))
                continue;
            return t;
        }
        return null;
    }

    public static List<BlockPos> Method2163431(BlockPos blockPos, float f) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n2 = blockPos.getX();
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ();
        int n5 = n2 - (int) f;
        while ((float) n5 <= (float) n2 + f) {
            int n6 = n4 - (int) f;
            while ((float) n6 <= (float) n4 + f) {
                double d = (n2 - n5) * (n2 - n5) + (n4 - n6) * (n4 - n6);
                if (d < (double) (f * f)) {
                    BlockPos blockPos2 = new BlockPos(n5, n3, n6);
                    arrayList.add(blockPos2);
                }
                ++n6;
            }
            ++n5;
        }
        return arrayList;
    }

    public static BlockPos Method2163432(Entity entity) {
        return new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
    }

    public static float Method2163433(double d, double d2, double d3, Entity entity) {
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
            d7 = CombatUtil.Method2163434((EntityLivingBase) entity, CombatUtil.Method2163435(f2), new Explosion((World) Minecraft.getMinecraft().world, null, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    public static float Method2163434(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
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

    public static float Method2163435(float f) {
        int n2 = Minecraft.getMinecraft().world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static float Method2163436(Entity entity, Entity entity2) {
        return CombatUtil.Method2163433(entity.posX, entity.posY, entity.posZ, entity2);
    }

    public static float Method2163437(BlockPos blockPos, Entity entity) {
        return CombatUtil.Method2163433((double) blockPos.getX() + 0.5, blockPos.getY() + 1, (double) blockPos.getZ() + 0.5, entity);
    }

    public static Vec3d Method2163438(Entity entity) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) Field599.getRenderPartialTicks(), entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) Field599.getRenderPartialTicks(), entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) Field599.getRenderPartialTicks());
    }

    public static float[] Method2163439(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double) (d * d + d3 * d3));
        return new float[]{(float) MathHelper.wrapDegrees((double) (Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float) MathHelper.wrapDegrees((double) Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static float[] Method2163430(Vec3d vec3d) {
        Vec3d vec3d2 = new Vec3d(CombatUtil.Field599.player.posX, CombatUtil.Field599.player.posY + (double) CombatUtil.Field599.player.getEyeHeight(), CombatUtil.Field599.player.posZ);
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float) Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float) (-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{CombatUtil.Field599.player.rotationYaw + MathHelper.wrapDegrees((float) (f - CombatUtil.Field599.player.rotationYaw)), CombatUtil.Field599.player.rotationPitch + MathHelper.wrapDegrees((float) (f2 - CombatUtil.Field599.player.rotationPitch))};
    }

    private static EntityEnderCrystal Method2163441(Entity entity) {
        return (EntityEnderCrystal) entity;
    }

    private static double Method2163442(Entity entity) {
        return CombatUtil.Field599.player.getDistanceSq(entity);
    }

    private static boolean Method2163443(double d, Entity entity) {
        return CombatUtil.Field599.player.getDistanceSq(entity) <= d * d;
    }

    private static boolean Method2163444(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    private static boolean Method2163445(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        return iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Field4514 && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.isInterrupted();
    }

    private static Double Method2163446(BlockPos blockPos) {
        return CombatUtil.Field599.player.getDistanceSq(blockPos);
    }

    private static boolean Method2163447(Entity entity) {
        return CombatUtil.Method2163433(entity.posX, entity.posY, entity.posZ, (Entity) CombatUtil.Field599.player) >= CombatUtil.Field599.player.getHealth() + CombatUtil.Field599.player.getAbsorptionAmount();
    }

    private static boolean Method2163448(double d, Entity entity) {
        return (double) CombatUtil.Field599.player.getDistance(entity) <= d;
    }

    private static boolean Method2163449(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    static Minecraft Method2163440() {
        return Field599;
    }

    public static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
            extends Thread {
        public float Field4513;
        public boolean Field4514;
        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field4515;
        BlockPos Field4502;
        EntityPlayer Field4503;
        double Field4504;
        double Field4505;
        double Field4506;
        double Field4507;
        double Field4508;
        double Field4509;
        boolean Field4510;
        boolean Field4511;
        boolean Field4512;

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(EntityPlayer entityPlayer, BlockPos blockPos, double d, double d2, double d3, double d4, double d5, double d6, boolean bl, boolean bl2, boolean bl3) {
            super("Break");
            this.Field4502 = blockPos;
            this.Field4504 = d;
            this.Field4505 = d2;
            this.Field4506 = d3;
            this.Field4507 = d4;
            this.Field4508 = d5;
            this.Field4509 = d6;
            this.Field4510 = bl;
            this.Field4511 = bl2;
            this.Field4512 = bl3;
            this.Field4503 = entityPlayer;
        }

        @Override
        public void run() {
            if (!(CombatUtil.Method2163440().player.getDistanceSq(this.Field4502) > this.Field4507 * this.Field4507) && CombatUtil.Method2163415(this.Field4502, this.Field4507, this.Field4508, this.Field4510) && CombatUtil.Method2163418(this.Field4502, this.Field4505, this.Field4509, this.Field4512) && CombatUtil.Method2163410(this.Field4502, this.Field4504, this.Field4511)) {
                this.Field4513 = CombatUtil.Method2163437(this.Field4502, (Entity) this.Field4503);
                if ((double) this.Field4513 >= this.Field4506 && (!this.Field4510 || CombatUtil.Method2163429(this.Field4502, this.Field4508, 0.0))) {
                    this.Field4514 = true;
                    this.Field4515 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this.Field4503, this.Field4502, this.Field4513);
                    AliceMain.Field745.info("Pos was valid.");
                    return;
                }
            }
            this.Field4514 = false;
            this.Field4515 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this.Field4503, this.Field4502, -1.0f);
            AliceMain.Field745.info("Pos was invalid.");
        }
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        public EntityPlayer Field1636;
        public BlockPos Field1637;
        public float Field1638;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(EntityPlayer entityPlayer, BlockPos blockPos, float f) {
            this.Field1637 = blockPos;
            this.Field1638 = f;
            this.Field1636 = entityPlayer;
        }
    }
}

