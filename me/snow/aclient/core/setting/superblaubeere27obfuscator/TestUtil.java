

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.opengl.GL11;

public class TestUtil {
    private static final Minecraft Field4349 = Minecraft.getMinecraft();
    public static List<Block> Field4351 = Arrays.asList(new Block[]{Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE});
    public static List<Block> Field4352 = Arrays.asList(new Block[]{Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.ANVIL, Blocks.WOODEN_BUTTON, Blocks.STONE_BUTTON, Blocks.UNPOWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.POWERED_COMPARATOR, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.JUKEBOX, Blocks.BEACON, Blocks.BED, Blocks.FURNACE, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CAKE, Blocks.ENCHANTING_TABLE, Blocks.DRAGON_EGG, Blocks.HOPPER, Blocks.REPEATING_COMMAND_BLOCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.CRAFTING_TABLE});
    private static float[] Field4350 = new float[20];
    private static boolean Field4353 = GL11.glIsEnabled((int) 2896);
    private static boolean Field4354 = GL11.glIsEnabled((int) 3042);
    private static boolean Field4355 = GL11.glIsEnabled((int) 3553);
    private static boolean Field4356 = GL11.glIsEnabled((int) 2929);
    private static boolean Field4357 = GL11.glIsEnabled((int) 2848);

    public static boolean Method2164719(BlockPos blockPos) {
        return TestUtil.Field4349.player != null && TestUtil.Field4349.world.rayTraceBlocks(new Vec3d(TestUtil.Field4349.player.posX, TestUtil.Field4349.player.posY + (double) TestUtil.Field4349.player.getEyeHeight(), TestUtil.Field4349.player.posZ), new Vec3d((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static void Method2164710(BlockPos blockPos, EnumHand enumHand) {
        RayTraceResult rayTraceResult = TestUtil.Field4349.world.rayTraceBlocks(new Vec3d(TestUtil.Field4349.player.posX, TestUtil.Field4349.player.posY + (double) TestUtil.Field4349.player.getEyeHeight(), TestUtil.Field4349.player.posZ), new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() - 0.5, (double) blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        TestUtil.Field4349.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
    }

    public static Vec3d Method2164721(Entity entity, float f) {
        return TestUtil.Method2164728(entity, f).subtract(EntityUtil.Field2811.getRenderManager().renderPosX, EntityUtil.Field2811.getRenderManager().renderPosY, EntityUtil.Field2811.getRenderManager().renderPosZ);
    }

    public static void Method2164722(float f) {
        Field4353 = GL11.glIsEnabled((int) 2896);
        Field4354 = GL11.glIsEnabled((int) 3042);
        Field4355 = GL11.glIsEnabled((int) 3553);
        Field4356 = GL11.glIsEnabled((int) 2929);
        Field4357 = GL11.glIsEnabled((int) 2848);
        TestUtil.Method2164726(Field4353, Field4354, Field4355, Field4356, Field4357, f);
    }

    public static void Method2164723() {
        TestUtil.Method2164725(Field4353, Field4354, Field4355, Field4356, Field4357);
    }

    public static float[][] Method2164724(ModelBiped modelBiped) {
        float[][] arrarrf = new float[5][];
        float[] arrf = new float[]{modelBiped.bipedHead.rotateAngleX, modelBiped.bipedHead.rotateAngleY, modelBiped.bipedHead.rotateAngleZ};
        arrarrf[0] = arrf;
        float[] arrf2 = new float[]{modelBiped.bipedRightArm.rotateAngleX, modelBiped.bipedRightArm.rotateAngleY, modelBiped.bipedRightArm.rotateAngleZ};
        arrarrf[1] = arrf2;
        float[] arrf3 = new float[]{modelBiped.bipedLeftArm.rotateAngleX, modelBiped.bipedLeftArm.rotateAngleY, modelBiped.bipedLeftArm.rotateAngleZ};
        arrarrf[2] = arrf3;
        float[] arrf4 = new float[]{modelBiped.bipedRightLeg.rotateAngleX, modelBiped.bipedRightLeg.rotateAngleY, modelBiped.bipedRightLeg.rotateAngleZ};
        arrarrf[3] = arrf4;
        float[] arrf5 = new float[]{modelBiped.bipedLeftLeg.rotateAngleX, modelBiped.bipedLeftLeg.rotateAngleY, modelBiped.bipedLeftLeg.rotateAngleZ};
        arrarrf[4] = arrf5;
        return arrarrf;
    }

    private static void Method2164725(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        GlStateManager.depthMask((boolean) true);
        if (!bl5) {
            GL11.glDisable((int) 2848);
        }
        if (bl4) {
            GL11.glEnable((int) 2929);
        }
        if (bl3) {
            GL11.glEnable((int) 3553);
        }
        if (!bl2) {
            GL11.glDisable((int) 3042);
        }
        if (bl) {
            GL11.glEnable((int) 2896);
        }
    }

    private static void Method2164726(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f) {
        if (bl) {
            GL11.glDisable((int) 2896);
        }
        if (!bl2) {
            GL11.glEnable((int) 3042);
        }
        GL11.glLineWidth((float) f);
        if (bl3) {
            GL11.glDisable((int) 3553);
        }
        if (bl4) {
            GL11.glDisable((int) 2929);
        }
        if (!bl5) {
            GL11.glEnable((int) 2848);
        }
        GlStateManager.blendFunc((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GL11.glHint((int) 3154, (int) 4354);
        GlStateManager.depthMask((boolean) false);
    }

    public static Color Method2164727(Entity entity, int n2, int n3, int n4, int n5, boolean bl) {
        Color color = new Color((float) n2 / 255.0f, (float) n3 / 255.0f, (float) n4 / 255.0f, (float) n5 / 255.0f);
        if (entity instanceof EntityPlayer && bl && AliceMain.Field765.Method2150169((EntityPlayer) entity)) {
            color = new Color(0.33333334f, 1.0f, 1.0f, (float) n5 / 255.0f);
        }
        return color;
    }

    public static Vec3d Method2164728(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(TestUtil.Method2164720(entity, f));
    }

    public static Vec3d Method2164729(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static Vec3d Method2164720(Entity entity, float f) {
        return TestUtil.Method2164729(entity, f, f, f);
    }

    public static float Method2164731() {
        float f = 0.0f;
        float f2 = 0.0f;
        for (float f3 : Field4350) {
            if (!(f3 > 0.0f)) continue;
            f2 += f3;
            f += 1.0f;
        }
        return MathHelper.clamp((float) (f2 / f), (float) 0.0f, (float) 20.0f);
    }

    public static boolean Method2164732(BlockPos blockPos, boolean bl, float f) {
        return !bl || TestUtil.Field4349.world.rayTraceBlocks(new Vec3d(TestUtil.Field4349.player.posX, TestUtil.Field4349.player.posY + (double) TestUtil.Field4349.player.getEyeHeight(), TestUtil.Field4349.player.posZ), new Vec3d((double) blockPos.getX(), (double) ((float) blockPos.getY() + f), (double) blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method2164733(BlockPos blockPos, boolean bl) {
        return TestUtil.Method2164732(blockPos, bl, 1.0f);
    }

    public static void Method2164734(BlockPos blockPos) {
        EnumFacing[] arrenumFacing;
        for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
            Block block = TestUtil.Field4349.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
            if (!Field4351.contains((Object) block)) {
                continue;
            }
            TestUtil.Field4349.playerController.processRightClickBlock(TestUtil.Field4349.player, TestUtil.Field4349.world, blockPos, enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
            return;
        }
    }

    public static boolean Method2164735(BlockPos blockPos) {
        if (TestUtil.Method2164736(blockPos)) {
            EnumFacing[] arrenumFacing;
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                Block block = TestUtil.Field4349.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (Field4351.contains((Object) block) || !(TestUtil.Field4349.player.getPositionEyes(Field4349.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                float[] arrf = new float[]{TestUtil.Field4349.player.rotationYaw, TestUtil.Field4349.player.rotationPitch};
                if (Field4352.contains((Object) block)) {
                    TestUtil.Field4349.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) TestUtil.Field4349.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                TestUtil.Field4349.playerController.processRightClickBlock(TestUtil.Field4349.player, TestUtil.Field4349.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i) blockPos), EnumHand.MAIN_HAND);
                if (Field4352.contains((Object) block)) {
                    TestUtil.Field4349.player.connection.sendPacket((Packet) new CPacketEntityAction((Entity) TestUtil.Field4349.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                TestUtil.Field4349.player.swingArm(EnumHand.MAIN_HAND);
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Method2164736(BlockPos blockPos) {
        try {
            Entity entity;
            if (!Field4351.contains((Object) TestUtil.Field4349.world.getBlockState(blockPos).getBlock())) return false;
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
            Iterator iterator = TestUtil.Field4349.world.loadedEntityList.iterator();
            do {
                if (!iterator.hasNext()) return true;
            } while (!((entity = (Entity) iterator.next()) instanceof EntityLivingBase) || !axisAlignedBB.intersects(entity.getEntityBoundingBox()));
            return false;
        } catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public static boolean Method2164737(BlockPos blockPos) {
        if (TestUtil.Method2164736(blockPos)) {
            EnumFacing[] arrenumFacing;
            for (EnumFacing enumFacing : arrenumFacing = EnumFacing.values()) {
                if (Field4351.contains((Object) TestUtil.Field4349.world.getBlockState(blockPos.offset(enumFacing)).getBlock()))
                    continue;
                Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getXOffset() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getYOffset() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getZOffset() * 0.5);
                if (!(TestUtil.Field4349.player.getPositionEyes(Field4349.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25))
                    continue;
                return true;
            }
        }
        return false;
    }
}

