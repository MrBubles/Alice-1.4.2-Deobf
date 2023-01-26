

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEndPortalFrame
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpeedMineOld
        extends Module {
    private static SpeedMineOld Field4614 = new SpeedMineOld();
    private final Setting<Float> Field4615 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(50.0f)));
    private final Timer Field4616 = new Timer();
    public Setting<Boolean> Field4617 = this.Method2150366(new Setting<Boolean>("Tweaks", true));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field4618 = this.Method2150366(new Setting<Object>("Mode", (Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PACKET, this::Method2161643));
    public Setting<Float> Field4620 = this.Method2150366(new Setting<Object>("Damage", Float.valueOf(0.7f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2161642));
    public Setting<Boolean> Field4619 = this.Method2150366(new Setting<Boolean>("Reset", true));
    public Setting<Boolean> Field4621 = this.Method2150366(new Setting<Boolean>("NoBreakAnim", false));
    public Setting<Boolean> Field4622 = this.Method2150366(new Setting<Boolean>("NoDelay", false));
    public Setting<Boolean> Field4623 = this.Method2150366(new Setting<Boolean>("NoSwing", false));
    public Setting<Boolean> Field4624 = this.Method2150366(new Setting<Boolean>("NoTrace", false));
    public Setting<Boolean> Field4625 = this.Method2150366(new Setting<Object>("NoGapTrace", Boolean.valueOf(false), this::Method2161641));
    public Setting<Boolean> Field4626 = this.Method2150366(new Setting<Boolean>("AllowMultiTask", false));
    public Setting<Boolean> Field4627 = this.Method2150366(new Setting<Object>("Pickaxe", Boolean.valueOf(true), this::Method2161630));
    public Setting<Boolean> Field4628 = this.Method2150366(new Setting<Boolean>("DoubleBreak", false));
    public Setting<Boolean> Field4629 = this.Method2150366(new Setting<Boolean>("WebSwitch", false));
    public Setting<Boolean> Field4630 = this.Method2150366(new Setting<Boolean>("SilentSwitch", false));
    public Setting<Boolean> Field4631 = this.Method2150366(new Setting<Boolean>("IllegalMine", false));
    public Setting<Boolean> Field4632 = this.Method2150366(new Setting<Boolean>("Render", false));
    public Setting<Boolean> Field4633 = this.Method2150366(new Setting<Object>("Box", Boolean.valueOf(false), this::Method2161639));
    private final Setting<Integer> Field4634 = this.Method2150366(new Setting<Object>("BoxAlpha", Integer.valueOf(85), Integer.valueOf(0), Integer.valueOf(255), this::Method2161638));
    public Setting<Boolean> Field4635 = this.Method2150366(new Setting<Object>("Outline", Boolean.valueOf(true), this::Method2161637));
    private final Setting<Float> Field4636 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2161636));
    public BlockPos Field4637;
    public IBlockState Field4638;
    private boolean Field4639 = false;
    private BlockPos Field4640 = null;
    private EnumFacing Field4641 = null;

    public SpeedMineOld() {
        super("SpeedmineOld", "Speeds up mining.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
        this.Method2161625();
    }

    public static SpeedMineOld Method2161624() {
        if (Field4614 == null) {
            Field4614 = new SpeedMineOld();
        }
        return Field4614;
    }

    private void Method2161625() {
        Field4614 = this;
    }

    @Override
    public void Method2150376() {
        if (this.Field4637 != null) {
            if (SpeedMineOld.Field2811.player != null && SpeedMineOld.Field2811.player.getDistanceSq(this.Field4637) > MathUtil.Method2163857(this.Field4615.getValue().floatValue())) {
                this.Field4637 = null;
                this.Field4638 = null;
                return;
            }
            if (SpeedMineOld.Field2811.player != null && this.Field4630.getValue().booleanValue() && this.Field4616.Method2164755((int) (2000.0f * AliceMain.Field768.Method2150202())) && this.Method2161628() != -1) {
                SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Method2161628()));
            }
            if (!SpeedMineOld.Field2811.world.getBlockState(this.Field4637).equals((Object) this.Field4638) || SpeedMineOld.Field2811.world.getBlockState(this.Field4637).getBlock() == Blocks.AIR) {
                this.Field4637 = null;
                this.Field4638 = null;
            } else if (this.Field4629.getValue().booleanValue() && this.Field4638.getBlock() == Blocks.WEB && SpeedMineOld.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
                InventoryUtil.Method2163775(ItemSword.class, false);
            }
        }
    }

    @Override
    public void Method2150379() {
        if (SpeedMineOld.Method2150359()) {
            return;
        }
        if (this.Field4622.getValue().booleanValue()) {
            SpeedMineOld.Field2811.playerController.blockHitDelay = 0;
        }
        if (this.Field4639 && this.Field4640 != null && this.Field4641 != null && this.Field4621.getValue().booleanValue()) {
            SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.Field4640, this.Field4641));
        }
        if (this.Field4619.getValue().booleanValue() && SpeedMineOld.Field2811.gameSettings.keyBindUseItem.isKeyDown() && !this.Field4626.getValue().booleanValue()) {
            SpeedMineOld.Field2811.playerController.isHittingBlock = false;
        }
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field4632.getValue().booleanValue() && this.Field4637 != null) {
            Color color = new Color(this.Field4616.Method2164755((int) (2000.0f * AliceMain.Field768.Method2150202())) ? 0 : 255, this.Field4616.Method2164755((int) (2000.0f * AliceMain.Field768.Method2150202())) ? 255 : 0, 0, 255);
            RenderUtil.Method2163908(this.Field4637, color, false, color, this.Field4636.getValue().floatValue(), this.Field4635.getValue(), this.Field4633.getValue(), this.Field4634.getValue(), false);
        }
    }

    @SubscribeEvent
    public void Method2161626(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (SpeedMineOld.Method2150359()) {
            return;
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            CPacketPlayerDigging cPacketPlayerDigging;
            if (this.Field4623.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketAnimation) {
                iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.setCanceled(true);
            }
            if (this.Field4621.getValue().booleanValue() && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayerDigging && (cPacketPlayerDigging = (CPacketPlayerDigging) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()) != null && cPacketPlayerDigging.getPosition() != null) {
                try {
                    for (Entity entity : SpeedMineOld.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(cPacketPlayerDigging.getPosition()))) {
                        if (!(entity instanceof EntityEnderCrystal)) continue;
                        this.Method2161620();
                        return;
                    }
                } catch (Exception exception) {
                    // empty catch block
                }
                if (cPacketPlayerDigging.getAction().equals((Object) CPacketPlayerDigging.Action.START_DESTROY_BLOCK)) {
                    this.Method2161629(true, cPacketPlayerDigging.getPosition(), cPacketPlayerDigging.getFacing());
                }
                if (cPacketPlayerDigging.getAction().equals((Object) CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK)) {
                    this.Method2161620();
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161627(BlockEvent blockEvent) {
        if (SpeedMineOld.Method2150359()) {
            return;
        }
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 3 && SpeedMineOld.Field2811.world.getBlockState(blockEvent.Field3432).getBlock() instanceof BlockEndPortalFrame) {
            SpeedMineOld.Field2811.world.getBlockState(blockEvent.Field3432).getBlock().setHardness(50.0f);
        }
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 3 && this.Field4619.getValue().booleanValue() && SpeedMineOld.Field2811.playerController.curBlockDamageMP > 0.1f) {
            SpeedMineOld.Field2811.playerController.isHittingBlock = true;
        }
        if (blockEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 4 && this.Field4617.getValue().booleanValue()) {
            BlockPos blockPos;
            if (BlockUtil.Method2162840(blockEvent.Field3432)) {
                if (this.Field4619.getValue().booleanValue()) {
                    SpeedMineOld.Field2811.playerController.isHittingBlock = false;
                }
                switch (1.F ield2106[this.Field4618.getValue().ordinal()]){
                    case 1: {
                        if (this.Field4637 == null) {
                            this.Field4637 = blockEvent.Field3432;
                            this.Field4638 = SpeedMineOld.Field2811.world.getBlockState(this.Field4637);
                            this.Field4616.Method2164750();
                        }
                        SpeedMineOld.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                        SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        blockEvent.setCanceled(true);
                        break;
                    }
                    case 2: {
                        if (!(SpeedMineOld.Field2811.playerController.curBlockDamageMP >= this.Field4620.getValue().floatValue()))
                            break;
                        SpeedMineOld.Field2811.playerController.curBlockDamageMP = 1.0f;
                        break;
                    }
                    case 3: {
                        SpeedMineOld.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                        SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockEvent.Field3432, blockEvent.Field3433));
                        SpeedMineOld.Field2811.playerController.onPlayerDestroyBlock(blockEvent.Field3432);
                        SpeedMineOld.Field2811.world.setBlockToAir(blockEvent.Field3432);
                    }
                }
            }
            if (this.Field4628.getValue().booleanValue() && BlockUtil.Method2162840(blockPos = blockEvent.Field3432.add(0, 1, 0)) && SpeedMineOld.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()) <= 5.0) {
                SpeedMineOld.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, blockEvent.Field3433));
                SpeedMineOld.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, blockEvent.Field3433));
                SpeedMineOld.Field2811.playerController.onPlayerDestroyBlock(blockPos);
                SpeedMineOld.Field2811.world.setBlockToAir(blockPos);
            }
        }
    }

    private int Method2161628() {
        for (int j = 0; j < 9; ++j) {
            if (SpeedMineOld.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.DIAMOND_PICKAXE) {
                continue;
            }
            return j;
        }
        return -1;
    }

    private void Method2161629(boolean bl, BlockPos blockPos, EnumFacing enumFacing) {
        this.Field4639 = bl;
        this.Field4640 = blockPos;
        this.Field4641 = enumFacing;
    }

    public void Method2161620() {
        this.Method2161629(false, null, null);
    }

    @Override
    public String Method2150385() {
        return this.Field4618.currentEnumName();
    }

    public float Method2161631(IBlockState iBlockState, BlockPos blockPos) {
        float f = iBlockState.getBlockHardness((World) SpeedMineOld.Field2811.world, blockPos);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!this.Method2161632(iBlockState.getBlock(), blockPos)) {
            return this.Method2161633(iBlockState) / f / 100.0f;
        }
        return this.Method2161633(iBlockState) / f / 30.0f;
    }

    public boolean Method2161632(Block block, BlockPos blockPos) {
        IBlockState iBlockState = SpeedMineOld.Field2811.world.getBlockState(blockPos);
        IBlockState iBlockState2 = iBlockState.getBlock().getActualState(iBlockState, (IBlockAccess) SpeedMineOld.Field2811.world, blockPos);
        if (iBlockState2.getMaterial().isToolNotRequired()) {
            return true;
        }
        ItemStack itemStack = this.Method2161635(iBlockState2);
        String string = block.getHarvestTool(iBlockState2);
        if (itemStack.isEmpty() || string == null) {
            return SpeedMineOld.Field2811.player.canHarvestBlock(iBlockState2);
        }
        int n2 = itemStack.getItem().getHarvestLevel(itemStack, string, (EntityPlayer) SpeedMineOld.Field2811.player, iBlockState2);
        if (n2 < 0) {
            return SpeedMineOld.Field2811.player.canHarvestBlock(iBlockState2);
        }
        return n2 >= block.getHarvestLevel(iBlockState2);
    }

    public float Method2161633(IBlockState iBlockState) {
        ItemStack itemStack;
        int n2;
        float f = this.Method2161634(iBlockState);
        if (f > 1.0f && (n2 = EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) (itemStack = this.Method2161635(iBlockState)))) > 0 && !itemStack.isEmpty()) {
            f = (float) ((double) f + (StrictMath.pow(n2, 2.0) + 1.0));
        }
        if (SpeedMineOld.Field2811.player.isPotionActive(MobEffects.HASTE)) {
            f *= 1.0f + (float) (SpeedMineOld.Field2811.player.getActivePotionEffect(MobEffects.HASTE).getAmplifier() + 1) * 0.2f;
        }
        if (SpeedMineOld.Field2811.player.isPotionActive(MobEffects.MINING_FATIGUE)) {
            float f2;
            switch (SpeedMineOld.Field2811.player.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) {
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
        if (SpeedMineOld.Field2811.player.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier((EntityLivingBase) SpeedMineOld.Field2811.player)) {
            f /= 5.0f;
        }
        if (!SpeedMineOld.Field2811.player.onGround) {
            f /= 5.0f;
        }
        return f < 0.0f ? 0.0f : f;
    }

    public float Method2161634(IBlockState iBlockState) {
        float f = 1.0f;
        if (this.Method2161635(iBlockState) != null && !this.Method2161635(iBlockState).isEmpty()) {
            f *= this.Method2161635(iBlockState).getDestroySpeed(iBlockState);
        }
        return f;
    }

    public ItemStack Method2161635(IBlockState iBlockState) {
        int n2 = -1;
        double d = 0.0;
        for (int j = 0; j < 9; ++j) {
            float f;
            if (SpeedMineOld.Field2811.player.inventory.getStackInSlot(j).isEmpty() || !((f = SpeedMineOld.Field2811.player.inventory.getStackInSlot(j).getDestroySpeed(iBlockState)) > 1.0f))
                continue;
            if (EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) SpeedMineOld.Field2811.player.inventory.getStackInSlot(j)) > 0) {
                f = (float) ((double) f + (StrictMath.pow(EnchantmentHelper.getEnchantmentLevel((Enchantment) Enchantments.EFFICIENCY, (ItemStack) SpeedMineOld.Field2811.player.inventory.getStackInSlot(j)), 2.0) + 1.0));
            }
            if (!((double) f > d)) continue;
            d = f;
            n2 = j;
        }
        if (n2 != -1) {
            return SpeedMineOld.Field2811.player.inventory.getStackInSlot(n2);
        }
        return SpeedMineOld.Field2811.player.inventory.getStackInSlot(SpeedMineOld.Field2811.player.inventory.currentItem);
    }

    private boolean Method2161636(Object object) {
        return this.Field4635.getValue() != false && this.Field4632.getValue() != false;
    }

    private boolean Method2161637(Object object) {
        return this.Field4632.getValue();
    }

    private boolean Method2161638(Object object) {
        return this.Field4633.getValue() != false && this.Field4632.getValue() != false;
    }

    private boolean Method2161639(Object object) {
        return this.Field4632.getValue();
    }

    private boolean Method2161630(Object object) {
        return this.Field4624.getValue();
    }

    private boolean Method2161641(Object object) {
        return this.Field4624.getValue();
    }

    private boolean Method2161642(Object object) {
        return this.Field4618.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.DAMAGE && this.Field4617.getValue() != false;
    }

    private boolean Method2161643(Object object) {
        return this.Field4617.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        PACKET,
        DAMAGE,
        INSTANT;

    }
}

