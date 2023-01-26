

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemBed
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.potion.Potion
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityBed
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BedAura1
        extends Module {
    private static boolean Field3897;
    private static double Field3898;
    private static double Field3899;
    private final Setting<Boolean> Field3883 = this.Method2150366(new Setting<Boolean>("Rotate", false));
    private final Setting<Boolean> Field3884 = this.Method2150366(new Setting<Boolean>("Swing", true));
    private final Setting<Boolean> Field3885 = this.Method2150366(new Setting<Boolean>("AirPlace", false));
    private final Setting<Boolean> Field3886 = this.Method2150366(new Setting<Boolean>("RayTrace", false));
    private final Setting<Boolean> Field3887 = this.Method2150366(new Setting<Boolean>("StrictDirection", false));
    private final Setting<Float> Field3888 = this.Method2150366(new Setting<Float>("BreakRange", Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    private final Setting<Float> Field3889 = this.Method2150366(new Setting<Float>("PlaceRange", Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    private final Setting<Integer> Field3890 = this.Method2150366(new Setting<Integer>("BreakSpeed", 20, 1, 20));
    private final Setting<Integer> Field3891 = this.Method2150366(new Setting<Integer>("PlaceSpeed", 20, 1, 20));
    private final Setting<Boolean> Field3892 = this.Method2150366(new Setting<Boolean>("Swap", true));
    private final Setting<Boolean> Field3893 = this.Method2150366(new Setting<Boolean>("AutoMove", true));
    private final Timer Field3896 = new Timer();
    private Timer Field3894 = new Timer();
    private Timer Field3895 = new Timer();
    private BlockPos Field3900 = null;
    private BlockPos Field3901 = null;
    private EnumFacing Field3902 = null;
    private int Field3903 = -1;

    public BedAura1() {
        super("BedAura", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static float[] Method2161139(EnumFacing enumFacing) {
        switch (1.F ield2949[enumFacing.ordinal()]){
            case 1: {
                return new float[]{BedAura1.Field2811.player.rotationYaw, 90.0f};
            }
            case 2: {
                return new float[]{BedAura1.Field2811.player.rotationYaw, -90.0f};
            }
            case 3: {
                return new float[]{180.0f, 0.0f};
            }
            case 4: {
                return new float[]{0.0f, 0.0f};
            }
            case 5: {
                return new float[]{90.0f, 0.0f};
            }
        }
        return new float[]{270.0f, 0.0f};
    }

    public static float Method2161143(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        double d4 = entity.getDistance(d, d2, d3) / 12.0;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        double d5 = entity.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * 12.0 + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = BedAura1.Method2161144((EntityLivingBase) entity, BedAura1.Method2161145(f2), new Explosion((World) Minecraft.getMinecraft().world, (Entity) null, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    public static float Method2161144(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion) explosion);
            f = CombatRules.getDamageAfterAbsorb((float) f, (float) entityPlayer.getTotalArmorValue(), (float) ((float) entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable) entityPlayer.getArmorInventoryList(), (DamageSource) damageSource);
            float f2 = MathHelper.clamp((float) n2, (float) 0.0f, (float) 20.0f);
            f *= 1.0f - f2 / 25.0f;
            if (entityLivingBase.isPotionActive(Potion.getPotionById((int) 11))) {
                f -= f / 4.0f;
            }
            return f;
        }
        f = CombatRules.getDamageAfterAbsorb((float) f, (float) entityLivingBase.getTotalArmorValue(), (float) ((float) entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f;
    }

    private static float Method2161145(float f) {
        int n2 = Minecraft.getMinecraft().world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static BlockPos Method2161147() {
        return new BlockPos(Math.floor(BedAura1.Field2811.player.posX), Math.floor(BedAura1.Field2811.player.posY), Math.floor(BedAura1.Field2811.player.posZ));
    }

    private static Float Method2161149(EntityPlayer entityPlayer) {
        return Float.valueOf(BedAura1.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161151(EntityPlayer entityPlayer) {
        return entityPlayer != BedAura1.Field2811.player;
    }

    private static boolean Method2161152(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161153(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    private static double Method2161154(BlockPos blockPos) {
        return BedAura1.Field2811.player.getDistanceSq(blockPos);
    }

    private static Double Method2161155(TileEntity tileEntity) {
        return BedAura1.Field2811.player.getDistance((double) tileEntity.getPos().getX(), (double) tileEntity.getPos().getY(), (double) tileEntity.getPos().getZ());
    }

    private static boolean Method2161158(TileEntity tileEntity) {
        return ((TileEntityBed) tileEntity).isHeadPiece();
    }

    private static boolean Method2161159(TileEntity tileEntity) {
        return tileEntity instanceof TileEntityBed;
    }

    @SubscribeEvent
    public void Method2161131(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            if (BedAura1.Field2811.player == null || BedAura1.Field2811.world == null) {
                return;
            }
            this.Field3900 = null;
            this.Field3901 = null;
            if (updateWalkingPlayerEvent.isCanceled() || !InteractionUtil.Method2163740(this.Field3883.getValue())) {
                return;
            }
            if (BedAura1.Field2811.player.dimension == 0) {
                return;
            }
            if (this.Field3894.Method2164740(1000 - this.Field3890.getValue() * 50)) {
                this.Field3900 = this.Method2161136();
            }
            if (this.Field3900 == null && this.Field3895.Method2164740(1000 - this.Field3891.getValue() * 50)) {
                if (BedAura1.Field2811.player.inventory.getCurrentItem().getItem() == Items.BED || this.Method2161133()) {
                    this.Method2161137();
                } else if (!this.Method2161130().isEmpty() && this.Field3892.getValue().booleanValue() && !this.Method2161133()) {
                    int n2;
                    for (n2 = 0; n2 < 9; ++n2) {
                        ItemStack itemStack = (ItemStack) BedAura1.Field2811.player.inventory.mainInventory.get(n2);
                        if (itemStack.getItem() != Items.BED) continue;
                        this.Field3903 = BedAura1.Field2811.player.inventory.currentItem;
                        BedAura1.Field2811.player.inventory.currentItem = n2;
                        BedAura1.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                        this.Method2161137();
                        break;
                    }
                    if (this.Field3893.getValue().booleanValue() && BedAura1.Field2811.player.inventory.getCurrentItem().getItem() != Items.BED) {
                        for (n2 = 9; n2 <= 35; ++n2) {
                            if (BedAura1.Field2811.player.inventory.getStackInSlot(n2).getItem() != Items.BED) continue;
                            BedAura1.Field2811.playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer) BedAura1.Field2811.player);
                            BedAura1.Field2811.playerController.windowClick(0, BedAura1.Field2811.player.inventory.currentItem < 9 ? BedAura1.Field2811.player.inventory.currentItem + 36 : BedAura1.Field2811.player.inventory.currentItem, 0, ClickType.PICKUP, (EntityPlayer) BedAura1.Field2811.player);
                            BedAura1.Field2811.playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer) BedAura1.Field2811.player);
                        }
                    }
                }
            } else if (this.Field3900 != null) {
                double[] arrd = PlayerUtilSC.Method2162928((double) this.Field3900.getX() + 0.5, (double) this.Field3900.getY() + 0.5, (double) this.Field3900.getZ() + 0.5, (EntityPlayer) BedAura1.Field2811.player);
                Field3898 = arrd[0];
                Field3899 = arrd[1];
                Field3897 = true;
                this.Field3896.Method2164750();
            }
            if (Field3897) {
                AliceMain.Field760.Method2150278((float) Field3898, (float) Field3899);
            }
            if (this.Field3896.Method2164740(450.0)) {
                Field3897 = false;
            }
        }
    }

    @SubscribeEvent
    public void Method2161132(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1) {
            if (this.Field3900 != null) {
                this.Method2161134(this.Field3900);
            } else if (this.Field3901 != null) {
                this.Method2161135();
            }
            if (this.Field3903 != -1 && !this.Method2161133()) {
                BedAura1.Field2811.player.inventory.currentItem = this.Field3903;
                BedAura1.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field3903));
                this.Field3903 = -1;
            }
        }
    }

    public boolean Method2161133() {
        return BedAura1.Field2811.player.getHeldItemOffhand().getItem() instanceof ItemBed;
    }

    private void Method2161134(BlockPos blockPos) {
        if (blockPos == null) {
            return;
        }
        RayTraceResult rayTraceResult = this.Field3887.getValue() != false ? BedAura1.Field2811.world.rayTraceBlocks(BedAura1.Field2811.player.getPositionEyes(1.0f), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5)) : null;
        Vec3d vec3d = new Vec3d((Vec3i) blockPos).add(0.5, 0.5, 0.5);
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        InteractionUtil.Method2163756(blockPos, vec3d, EnumHand.MAIN_HAND, enumFacing, true, this.Field3884.getValue());
        this.Field3894.Method2164750();
    }

    private void Method2161135() {
        Vec3d vec3d = new Vec3d((Vec3i) this.Field3901.down()).add(0.5, 0.5, 0.5).add(new Vec3d(this.Field3902.getOpposite().getDirectionVec()).scale(0.5));
        BedAura1.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BedAura1.Field2811.player, CPacketEntityAction.Action.START_SNEAKING));
        InteractionUtil.Method2163756(this.Field3901.down(), vec3d, this.Method2161133() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, EnumFacing.UP, true, this.Field3884.getValue());
        BedAura1.Field2811.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) BedAura1.Field2811.player, CPacketEntityAction.Action.STOP_SNEAKING));
        this.Field3895.Method2164750();
        this.Field3901 = null;
    }

    private BlockPos Method2161136() {
        TileEntityBed tileEntityBed = BedAura1.Field2811.world.loadedTileEntityList.stream().filter(BedAura1::Method2161159).filter(BedAura1::Method2161158).filter(this::Method2161157).filter(this::Method2161156).min(Comparator.comparing(BedAura1::Method2161155)).orElse(null);
        if (tileEntityBed != null) {
            return tileEntityBed.getPos();
        }
        return null;
    }

    private void Method2161137() {
        List<EntityPlayer> list = this.Method2161130();
        if (list.isEmpty()) {
            return;
        }
        this.Method2161138(new BlockPos((Entity) list.get(0)), true);
    }

    private void Method2161138(BlockPos blockPos, boolean bl) {
        if (BedAura1.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BED) {
            return;
        }
        float f = this.Method2161142(blockPos, (Entity) BedAura1.Field2811.player);
        if ((double) f > (double) BedAura1.Field2811.player.getHealth() + (double) BedAura1.Field2811.player.getAbsorptionAmount() + 0.5) {
            if (bl && this.Field3885.getValue().booleanValue()) {
                this.Method2161138(blockPos.up(), false);
            }
            return;
        }
        if (!BedAura1.Field2811.world.getBlockState(blockPos).getMaterial().isReplaceable()) {
            if (bl && this.Field3885.getValue().booleanValue()) {
                this.Method2161138(blockPos.up(), false);
            }
            return;
        }
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        HashMap<BlockPos, EnumFacing> hashMap = new HashMap<BlockPos, EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2;
            if (enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP) continue;
            BlockPos blockPos3 = blockPos.offset(enumFacing);
            if (!(BedAura1.Field2811.player.getDistanceSq(blockPos2) <= Math.pow(this.Field3889.getValue().floatValue(), 2.0)) || !BedAura1.Field2811.world.getBlockState(blockPos3).getMaterial().isReplaceable() || BedAura1.Field2811.world.getBlockState(blockPos3.down()).getMaterial().isReplaceable() || this.Field3883.getValue().booleanValue() && EnumFacing.fromAngle((double) BlockUtilSC.Method2162889(blockPos3, EnumFacing.UP, (EntityPlayer) BedAura1.Field2811.player)[0]).getOpposite() != enumFacing || this.Field3886.getValue().booleanValue() && BedAura1.Field2811.world.rayTraceBlocks(BedAura1.Field2811.player.getPositionEyes(1.0f), new Vec3d((double) blockPos3.getX() + 0.5, (double) (blockPos3.getY() + 1), (double) blockPos3.getZ() + 0.5)) != null)
                continue;
            arrayList.add(blockPos3);
            hashMap.put(blockPos3, enumFacing.getOpposite());
        }
        if (arrayList.isEmpty()) {
            if (bl && this.Field3885.getValue().booleanValue()) {
                this.Method2161138(blockPos.up(), false);
            }
            return;
        }
        arrayList.sort(Comparator.comparingDouble(BedAura1::Method2161154));
        this.Field3901 = (BlockPos) arrayList.get(0);
        this.Field3902 = (EnumFacing) hashMap.get((Object) this.Field3901);
        if (this.Field3883.getValue().booleanValue()) {
            float[] arrf = RotationManager.Method2150291(BedAura1.Field2811.player.getPositionEyes(1.0f), new Vec3d((double) this.Field3901.down().getX() + 0.5, (double) (this.Field3901.down().getY() + 1), (double) this.Field3901.down().getZ() + 0.5));
            Field3898 = arrf[0];
            Field3899 = arrf[1];
            Field3897 = true;
        } else {
            float[] arrf = BedAura1.Method2161139(this.Field3902);
            Field3898 = arrf[0];
            Field3899 = arrf[1];
            Field3897 = true;
        }
        this.Field3896.Method2164750();
    }

    public List<EntityPlayer> Method2161130() {
        return BedAura1.Field2811.world.playerEntities.stream().filter(BedAura1::Method2161153).filter(BedAura1::Method2161152).filter(BedAura1::Method2161151).filter(this::Method2161140).sorted(Comparator.comparing(BedAura1::Method2161149)).collect(Collectors.toList());
    }

    private boolean Method2161141(BlockPos blockPos) {
        return (double) (BedAura1.Field2811.player.getHealth() + BedAura1.Field2811.player.getAbsorptionAmount() - BedAura1.Method2161143((double) blockPos.getX() + 0.5, blockPos.getY() + 1, (double) blockPos.getZ() + 0.5, (Entity) BedAura1.Field2811.player)) > 0.5;
    }

    public float Method2161142(BlockPos blockPos, Entity entity) {
        return BedAura1.Method2161143((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5, entity);
    }

    private boolean Method2161146(BlockPos blockPos) {
        IBlockState iBlockState = BedAura1.Field2811.world.getBlockState(blockPos.up());
        if (iBlockState.getBlock() == Blocks.AIR) {
            return BedAura1.Field2811.world.getBlockState(blockPos).isSideSolid((IBlockAccess) BedAura1.Field2811.world, blockPos, EnumFacing.UP);
        }
        return false;
    }

    public List<BlockPos> Method2161148(BlockPos blockPos, float f, float f2, boolean bl, boolean bl2, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        int n6 = n3 - (int) f;
        while ((float) n6 <= (float) n3 + f) {
            int n7 = n5 - (int) f;
            while ((float) n7 <= (float) n5 + f) {
                int n8 = bl2 ? n4 - (int) f : n4;
                while (true) {
                    float f3 = n8;
                    float f4 = bl2 ? (float) n4 + f : (float) n4 + f2;
                    if (!(f3 < f4)) break;
                    double d = (n3 - n6) * (n3 - n6) + (n5 - n7) * (n5 - n7) + (bl2 ? (n4 - n8) * (n4 - n8) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n6, n8 + n2, n7);
                        arrayList.add(blockPos2);
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    private boolean Method2161140(EntityPlayer entityPlayer) {
        return BedAura1.Field2811.player.getDistance((Entity) entityPlayer) < this.Field3889.getValue().floatValue() + 2.0f;
    }

    private boolean Method2161156(TileEntity tileEntity) {
        return this.Method2161141(tileEntity.getPos());
    }

    private boolean Method2161157(TileEntity tileEntity) {
        return BedAura1.Field2811.player.getDistance((double) tileEntity.getPos().getX(), (double) tileEntity.getPos().getY(), (double) tileEntity.getPos().getZ()) <= (double) this.Field3888.getValue().floatValue();
    }
}

