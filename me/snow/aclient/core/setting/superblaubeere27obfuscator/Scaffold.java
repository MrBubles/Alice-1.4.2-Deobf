

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InteractionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Sprint;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Scaffold
        extends Module {
    private List<Block> Field3062 = Arrays.asList(new Block[]{Blocks.ANVIL, Blocks.AIR, Blocks.WEB, Blocks.WATER, Blocks.FIRE, Blocks.FLOWING_WATER, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.CHEST, Blocks.ENCHANTING_TABLE, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.GRAVEL, Blocks.LADDER, Blocks.VINE, Blocks.BEACON, Blocks.JUKEBOX, Blocks.ACACIA_DOOR, Blocks.BIRCH_DOOR, Blocks.DARK_OAK_DOOR, Blocks.IRON_DOOR, Blocks.JUNGLE_DOOR, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.IRON_TRAPDOOR, Blocks.TRAPDOOR, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX});
    private Timer Field3063 = new Timer();
    private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field3064;
    private Setting<Double> Field3065 = this.Method2150366(new Setting<Double>("Expand", 1.0, 0.0, 6.0));
    private Setting<Double> Field3066 = this.Method2150366(new Setting<Double>("Delay", 3.5, 1.0, 10.0));
    private Setting<Boolean> Field3067 = this.Method2150366(new Setting<Boolean>("Switch", true));
    private Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field3068 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("Tower", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NORMAL));
    private Setting<Boolean> Field3069 = this.Method2150366(new Setting<Boolean>("Center", true));
    private Setting<Boolean> Field3070 = this.Method2150366(new Setting<Boolean>("Safe", true));
    private Setting<Boolean> Field3071 = this.Method2150366(new Setting<Boolean>("KeepY", true));
    private Setting<Boolean> Field3072 = this.Method2150366(new Setting<Boolean>("Sprint", true));
    private Setting<Boolean> Field3073 = this.Method2150366(new Setting<Boolean>("Down", true));
    private Setting<Boolean> Field3074 = this.Method2150366(new Setting<Boolean>("Swing", false));
    private int Field3075;
    private Timer Field3076 = new Timer();
    private float Field3077;
    private float Field3078;
    private BlockPos Field3079;
    private boolean Field3080;

    public Scaffold() {
        super("Scaffold", "sCaff0ld", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    private boolean Method2162287(Block block) {
        return !this.Field3062.contains((Object) block);
    }

    @Override
    public void Method2150372() {
        if (Scaffold.Field2811.world != null) {
            this.Field3063.Method2164750();
            this.Field3075 = MathHelper.floor((double) Scaffold.Field2811.player.posY);
        }
    }

    @Override
    public void Method2150373() {
        AliceMain.Field771.Method2150369();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field3064 != null && this.Field3064.Field1102 != null) {
            RenderUtil.Method2163021(this.Field3064.Field1102, new Color(0, 255, 255), 1.0f, true, true, 60);
        }
    }

    @SubscribeEvent
    public void Method2162288(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && !this.Field3076.Method2164740(100.0 * this.Field3066.getValue()) && InteractionUtil.Method2163748()) {
            AliceMain.Field760.Method2150278(this.Field3077, this.Field3078);
        }
    }

    @SubscribeEvent
    public void Method2162289(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (!AliceMain.Field756.Method2150180(Sprint.class).Method2150364() && (this.Field3073.getValue().booleanValue() && Scaffold.Field2811.gameSettings.keyBindSneak.isKeyDown() || !this.Field3072.getValue().booleanValue())) {
            Scaffold.Field2811.player.setSprinting(false);
        }
        int n2 = this.Field3073.getValue() != false && Keyboard.isKeyDown((int) 56) ? 2 : 1;
        if (this.Field3071.getValue().booleanValue()) {
            if (!PlayerUtilSC.Method2162917() && Scaffold.Field2811.gameSettings.keyBindJump.isKeyDown() || Scaffold.Field2811.player.collidedVertically || Scaffold.Field2811.player.onGround) {
                this.Field3075 = MathHelper.floor((double) Scaffold.Field2811.player.posY);
            }
        } else {
            this.Field3075 = MathHelper.floor((double) Scaffold.Field2811.player.posY);
        }
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            Object object;
            this.Field3064 = null;
            double d = Scaffold.Field2811.player.posX;
            double d2 = Scaffold.Field2811.player.posZ;
            double d3 = this.Field3071.getValue() != false ? (double) this.Field3075 : Scaffold.Field2811.player.posY;
            double d4 = Scaffold.Field2811.player.movementInput.moveForward;
            double d5 = Scaffold.Field2811.player.movementInput.moveStrafe;
            float f = Scaffold.Field2811.player.rotationYaw;
            if (!Scaffold.Field2811.player.collidedHorizontally && this.Field3065.getValue() > 0.0) {
                object = this.Method2162291(d, d2, d4, d5, f);
                d = object[0];
                d2 = object[1];
            }
            if (this.Method2162292(Scaffold.Field2811.world.getBlockState(new BlockPos(Scaffold.Field2811.player.posX, Scaffold.Field2811.player.posY - (double) n2, Scaffold.Field2811.player.posZ)).getBlock())) {
                d = Scaffold.Field2811.player.posX;
                d2 = Scaffold.Field2811.player.posZ;
            }
            object = (Object) new BlockPos(d, d3 - (double) n2, d2);
            this.Field3079 = (BlockPos) object;
            if (Scaffold.Field2811.world.getBlockState((BlockPos) object).getBlock() == Blocks.AIR) {
                this.Field3064 = this.Method2162295((BlockPos) object);
                if (this.Field3064 != null) {
                    float[] arrf = RotationManager.Method2150291(Scaffold.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) this.Field3064.Field1102.getX() + 0.5 + (double) this.Field3064.Field1103.getDirectionVec().getX() * 0.5, (double) this.Field3064.Field1102.getY() + 0.5 + (double) this.Field3064.Field1103.getDirectionVec().getY() * 0.5, (double) this.Field3064.Field1102.getZ() + 0.5 + (double) this.Field3064.Field1103.getDirectionVec().getZ() * 0.5));
                    AliceMain.Field760.Method2150278(arrf[0], arrf[1]);
                    this.Field3077 = arrf[0];
                    this.Field3078 = arrf[1];
                    this.Field3076.Method2164750();
                }
            }
        } else if (this.Field3064 != null) {
            if (this.Method2162293() <= 0 || !this.Field3067.getValue().booleanValue() && Scaffold.Field2811.player.getHeldItemMainhand().getItem() != null && !(Scaffold.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemBlock)) {
                return;
            }
            int n3 = Scaffold.Field2811.player.inventory.currentItem;
            if (!(!this.Field3067.getValue().booleanValue() || Scaffold.Field2811.player.getHeldItemMainhand().getItem() != null && Scaffold.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemBlock && this.Method2162287(((ItemBlock) Scaffold.Field2811.player.getHeldItemMainhand().getItem()).getBlock()))) {
                for (int j = 0; j < 9; ++j) {
                    if (Scaffold.Field2811.player.inventory.getStackInSlot(j) == null || Scaffold.Field2811.player.inventory.getStackInSlot(j).getCount() == 0 || !(Scaffold.Field2811.player.inventory.getStackInSlot(j).getItem() instanceof ItemBlock) || !this.Method2162287(((ItemBlock) Scaffold.Field2811.player.inventory.getStackInSlot(j).getItem()).getBlock()))
                        continue;
                    Scaffold.Field2811.player.inventory.currentItem = j;
                    break;
                }
            }
            if (this.Field3068.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NONE) {
                if (Scaffold.Field2811.gameSettings.keyBindJump.isKeyDown() && Scaffold.Field2811.player.moveForward == 0.0f && Scaffold.Field2811.player.moveStrafing == 0.0f && this.Field3068.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.NONE && !Scaffold.Field2811.player.isPotionActive(MobEffects.JUMP_BOOST)) {
                    if (!this.Field3080 && this.Field3069.getValue().booleanValue()) {
                        this.Field3080 = true;
                        BlockPos blockPos = new BlockPos(Scaffold.Field2811.player.posX, Scaffold.Field2811.player.posY, Scaffold.Field2811.player.posZ);
                        Scaffold.Field2811.player.setPosition((double) blockPos.getX() + 0.5, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5);
                    }
                    if (this.Field3069.getValue().booleanValue() && !this.Field3080) {
                        return;
                    }
                    if (this.Field3068.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.FAST) {
                        AliceMain.Field771.Method2150334(Scaffold.Field2811.player.ticksExisted % 10 == 0 ? 1.0f : 1.5782f);
                    }
                    Scaffold.Field2811.player.motionY = 0.42f;
                    Scaffold.Field2811.player.motionZ = 0.0;
                    Scaffold.Field2811.player.motionX = 0.0;
                    if (this.Field3063.Method2164740(1500.0)) {
                        AliceMain.Field771.Method2150369();
                        this.Field3063.Method2164750();
                        Scaffold.Field2811.player.motionY = -0.28;
                    }
                } else {
                    AliceMain.Field771.Method2150369();
                    this.Field3063.Method2164750();
                    if (this.Field3080 && this.Field3069.getValue().booleanValue()) {
                        this.Field3080 = false;
                    }
                }
            } else {
                AliceMain.Field771.Method2150369();
            }
            if (Scaffold.Field2811.playerController.processRightClickBlock(Scaffold.Field2811.player, Scaffold.Field2811.world, this.Field3064.Field1102, this.Field3064.Field1103, new Vec3d((double) this.Field3064.Field1102.getX() + Math.random(), (double) this.Field3064.Field1102.getY() + Math.random(), (double) this.Field3064.Field1102.getZ() + Math.random()), EnumHand.MAIN_HAND) != EnumActionResult.FAIL) {
                if (this.Field3074.getValue().booleanValue()) {
                    Scaffold.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                } else {
                    Scaffold.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
                }
            }
            Scaffold.Field2811.player.inventory.currentItem = n3;
        }
    }

    private int Method2162280() {
        int n2 = 0;
        for (int j = 0; j < 45; ++j) {
            if (!Scaffold.Field2811.player.inventoryContainer.getSlot(j).getHasStack()) continue;
            ItemStack itemStack = Scaffold.Field2811.player.inventoryContainer.getSlot(j).getStack();
            Item item = itemStack.getItem();
            if (!(itemStack.getItem() instanceof ItemBlock) || this.Field3062.contains((Object) ((ItemBlock) item).getBlock()))
                continue;
            n2 += itemStack.getCount();
        }
        return n2;
    }

    public double[] Method2162291(double d, double d2, double d3, double d4, float f) {
        BlockPos blockPos = new BlockPos(d, Scaffold.Field2811.player.posY - (double) (Keyboard.isKeyDown((int) 56) && this.Field3073.getValue() != false ? 2 : 1), d2);
        Block block = Scaffold.Field2811.world.getBlockState(blockPos).getBlock();
        double d5 = -999.0;
        double d6 = -999.0;
        double d7 = 0.0;
        double d8 = this.Field3065.getValue() * 2.0;
        while (!this.Method2162292(block)) {
            d5 = d;
            d6 = d2;
            if ((d7 += 1.0) > d8) {
                d7 = d8;
            }
            d5 += (d3 * 0.45 * Math.cos(Math.toRadians(f + 90.0f)) + d4 * 0.45 * Math.sin(Math.toRadians(f + 90.0f))) * d7;
            d6 += (d3 * 0.45 * Math.sin(Math.toRadians(f + 90.0f)) - d4 * 0.45 * Math.cos(Math.toRadians(f + 90.0f))) * d7;
            if (d7 == d8) break;
            blockPos = new BlockPos(d5, Scaffold.Field2811.player.posY - (double) (Keyboard.isKeyDown((int) 56) && this.Field3073.getValue() != false ? 2 : 1), d6);
            block = Scaffold.Field2811.world.getBlockState(blockPos).getBlock();
        }
        return new double[]{d5, d6};
    }

    public boolean Method2162292(Block block) {
        return (block instanceof BlockAir || block instanceof BlockLiquid) && Scaffold.Field2811.world != null && Scaffold.Field2811.player != null && this.Field3079 != null && Scaffold.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(this.Field3079)).isEmpty();
    }

    private int Method2162293() {
        int n2 = 0;
        for (int j = 36; j < 45; ++j) {
            if (!Scaffold.Field2811.player.inventoryContainer.getSlot(j).getHasStack()) continue;
            ItemStack itemStack = Scaffold.Field2811.player.inventoryContainer.getSlot(j).getStack();
            Item item = itemStack.getItem();
            if (!(itemStack.getItem() instanceof ItemBlock) || this.Field3062.contains((Object) ((ItemBlock) item).getBlock()))
                continue;
            n2 += itemStack.getCount();
        }
        return n2;
    }

    @SubscribeEvent
    public void Method2162294(MoveEvent moveEvent) {
        double d = moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
        double d2 = moveEvent.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll();
        if (Scaffold.Field2811.player.onGround && !Scaffold.Field2811.player.noClip && this.Field3070.getValue().booleanValue() && !Keyboard.isKeyDown((int) 56)) {
            double d3 = 0.05;
            while (d != 0.0 && Scaffold.Field2811.world.getCollisionBoxes((Entity) Scaffold.Field2811.player, Scaffold.Field2811.player.getEntityBoundingBox().offset(d, -1.0, 0.0)).isEmpty()) {
                if (d < d3 && d >= -d3) {
                    d = 0.0;
                    continue;
                }
                if (d > 0.0) {
                    d -= d3;
                    continue;
                }
                d += d3;
            }
            while (d2 != 0.0 && Scaffold.Field2811.world.getCollisionBoxes((Entity) Scaffold.Field2811.player, Scaffold.Field2811.player.getEntityBoundingBox().offset(0.0, -1.0, d2)).isEmpty()) {
                if (d2 < d3 && d2 >= -d3) {
                    d2 = 0.0;
                    continue;
                }
                if (d2 > 0.0) {
                    d2 -= d3;
                    continue;
                }
                d2 += d3;
            }
            while (d != 0.0 && d2 != 0.0 && Scaffold.Field2811.world.getCollisionBoxes((Entity) Scaffold.Field2811.player, Scaffold.Field2811.player.getEntityBoundingBox().offset(d, -1.0, d2)).isEmpty()) {
                d = d < d3 && d >= -d3 ? 0.0 : (d > 0.0 ? (d -= d3) : (d += d3));
                if (d2 < d3 && d2 >= -d3) {
                    d2 = 0.0;
                    continue;
                }
                if (d2 > 0.0) {
                    d2 -= d3;
                    continue;
                }
                d2 += d3;
            }
        }
        moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(d);
        moveEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(d2);
    }

    private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2162295(BlockPos blockPos) {
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos.add(0, 1, 0), EnumFacing.DOWN);
        }
        BlockPos blockPos2 = blockPos.add(-1, 0, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos3 = blockPos.add(1, 0, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos4 = blockPos.add(0, 0, 1);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos5 = blockPos.add(0, 0, -1);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos6 = blockPos.add(-2, 0, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos2.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos2.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos7 = blockPos.add(2, 0, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos3.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos3.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos8 = blockPos.add(0, 0, 2);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos4.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos4.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos9 = blockPos.add(0, 0, -2);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos5.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos5.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos10 = blockPos.add(0, -1, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos10.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos10.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos10.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos10.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos10.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos10.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos10.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos10.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos10.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos10.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos10.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos10.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos11 = blockPos10.add(1, 0, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos11.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos11.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos11.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos11.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos11.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos11.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos11.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos11.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos11.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos11.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos11.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos11.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos12 = blockPos10.add(-1, 0, 0);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos12.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos12.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos12.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos12.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos12.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos12.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos12.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos12.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos12.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos12.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos12.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos12.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos13 = blockPos10.add(0, 0, 1);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos13.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos13.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos13.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos13.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos13.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos13.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos13.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos13.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos13.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos13.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos13.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos13.add(0, 0, -1), EnumFacing.SOUTH);
        }
        BlockPos blockPos14 = blockPos10.add(0, 0, -1);
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos14.add(0, -1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos14.add(0, -1, 0), EnumFacing.UP);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos14.add(0, 1, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos14.add(0, 1, 0), EnumFacing.DOWN);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos14.add(-1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos14.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos14.add(1, 0, 0)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos14.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos14.add(0, 0, 1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos14.add(0, 0, 1), EnumFacing.NORTH);
        }
        if (!this.Field3062.contains((Object) Scaffold.Field2811.world.getBlockState(blockPos14.add(0, 0, -1)).getBlock())) {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, blockPos14.add(0, 0, -1), EnumFacing.SOUTH);
        }
        return null;
    }

    private float[] Method2162296(double d, double d2, double d3, EnumFacing enumFacing) {
        EntitySnowball entitySnowball = new EntitySnowball((World) Scaffold.Field2811.world);
        entitySnowball.posX = d + 0.5;
        entitySnowball.posY = d2 - 2.7035252353;
        entitySnowball.posZ = d3 + 0.5;
        return this.Method2162297(entitySnowball.posX, entitySnowball.posY, entitySnowball.posZ);
    }

    private float[] Method2162297(double d, double d2, double d3) {
        double d4 = d - Scaffold.Field2811.player.posX;
        double d5 = d2 - Scaffold.Field2811.player.posY;
        double d6 = d3 - Scaffold.Field2811.player.posZ;
        double d7 = MathHelper.sqrt((double) (d4 * d4 + d6 * d6));
        return new float[]{(float) (Math.atan2(d6, d4) * 180.0 / Math.PI) - 90.0f, (float) (-(Math.atan2(d5, d7) * 180.0 / Math.PI))};
    }

    private static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        NONE,
        NORMAL,
        FAST;

    }

    private static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        NONE,
        WHITELIST,
        BLACKLIST;

    }

    private class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        final Scaffold Field1104;
        public BlockPos Field1102;
        public EnumFacing Field1103;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Scaffold scaffold, BlockPos blockPos, EnumFacing enumFacing) {
            this.Field1104 = scaffold;
            this.Field1102 = blockPos;
            this.Field1103 = enumFacing;
        }
    }
}

