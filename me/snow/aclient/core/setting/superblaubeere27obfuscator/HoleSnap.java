

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketPlayerPosLook$EnumFlags
 *  net.minecraft.stats.StatList
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FastFall;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HoleUtilStayyy;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MotionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PairUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SpeedRewrite;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Step;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class HoleSnap
        extends Module {
    private static final Timer Field1029;
    private static final BlockPos[] Field1034;
    private static final double[] Field1036;
    private static final double[] Field1037;
    private static final double[] Field1038;
    private static final double[] Field1039;
    private static final double[] Field1040;
    private static final double[] Field1041;
    private static final double[] Field1042;
    public static BlockPos.MutableBlockPos Field1025 = new BlockPos.MutableBlockPos(0, -69, 0);
    private static int Field1026;
    private static int Field1027;
    private static boolean Field1028;
    private static int Field1030;
    private static double Field1031;
    private static int Field1032;
    private static float Field1033;
    private static Vec2f Field1035;

    static {
        Field1029 = new Timer();
        Field1034 = new BlockPos[]{new BlockPos(0, -1, 0), new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};
        Field1035 = Vec2f.ZERO;
        Field1036 = new double[]{0.42, 0.75, 0.63, 0.51, 0.9, 1.21, 1.45, 1.43, 1.78, 1.63, 1.51, 1.9, 2.21, 2.45, 2.43, 2.78, 2.63, 2.51, 2.9, 3.21, 3.45, 3.43};
        Field1037 = new double[]{0.42, 0.78, 0.63, 0.51, 0.9, 1.21, 1.45, 1.43, 1.78, 1.63, 1.51, 1.9, 2.21, 2.45, 2.43};
        Field1038 = new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907};
        Field1039 = new double[]{0.42, 0.78, 0.63, 0.51, 0.9, 1.21, 1.45, 1.43};
        Field1040 = new double[]{0.41999998688698, 0.7531999805212, 1.00133597911214, 1.16610926093821, 1.24918707874468, 1.1707870772188};
        Field1041 = new double[]{0.41999998688698, 0.7531999805212};
        Field1042 = new double[]{0.39, 0.6938};
    }

    private final Setting<Float> Field1019 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(8.0f)));
    public Setting<Integer> Field1020 = this.Method2150366(new Setting<Integer>("dragTicks", 3, 1, 5));
    public Setting<Boolean> Field1021 = this.Method2150366(new Setting<Boolean>("DisableSpeed", false));
    public Setting<Boolean> Field1022 = this.Method2150366(new Setting<Boolean>("DisableStep", false));
    public Setting<Boolean> Field1023 = this.Method2150366(new Setting<Boolean>("Step", false));
    public Setting<Float> Field1024 = this.Method2150366(new Setting<Float>("StepHeight", Float.valueOf(2.5f), Float.valueOf(1.0f), Float.valueOf(4.0f), this::Method2161070));
    public boolean Field1044 = false;
    public boolean Field1045 = false;
    Timer Field1043 = new Timer();

    public HoleSnap() {
        super("HoleSnap", "Teleport to Hole", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, true, false, false);
    }

    public static final double Method2161056(double d) {
        return d * 180.0 / Math.PI;
    }

    public static double[] Method2161059(double d) {
        float f = HoleSnap.Field2811.player.movementInput.moveForward;
        float f2 = HoleSnap.Field2811.player.movementInput.moveStrafe;
        float f3 = HoleSnap.Field2811.player.prevRotationYaw + (HoleSnap.Field2811.player.rotationYaw - HoleSnap.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        return new double[]{(double) f * d * d3 + (double) f2 * d * d2, (double) f * d * d2 - (double) f2 * d * d3};
    }

    private static void Method2161061(Color color) {
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
    }

    public static void Method2161062(int n2, int n3, int n4, int n5) {
        HoleSnap.Method2161061(new Color(n2, n3, n4, n5));
    }

    public static void Method2161063(double d, double d2, double d3, Color color) {
        GL11.glPushMatrix();
        GL11.glBlendFunc((int) 770, (int) 771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int) 7425);
        GlStateManager.glLineWidth((float) 1.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int) 770, (int) 771);
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        HoleSnap.Method2161062(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        GL11.glBegin((int) 7);
        GL11.glVertex3d((double) d, (double) d2, (double) d3);
        GL11.glEnd();
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        GL11.glPopMatrix();
    }

    public static final float Method2161066(float f) {
        return f * (float) Math.PI / 180.0f;
    }

    public static final double Method2161067(Entity entity) {
        double d = entity.motionX;
        double d2 = entity.motionZ;
        return Math.hypot(d, d2);
    }

    public static final int Method2161068(double d) {
        double d2 = d;
        boolean bl = false;
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9) {
            return Integer.MIN_VALUE;
        }
        int n2 = (int) Math.round(d);
        return n2;
    }

    public static final IBlockState Method2161072(BlockPos blockPos) {
        IBlockState iBlockState = HoleSnap.Field2811.world.getBlockState(blockPos);
        return iBlockState;
    }

    public static final Block Method2161073(BlockPos blockPos) {
        Block block = HoleSnap.Method2161072(blockPos).getBlock();
        return block;
    }

    public static final <A, B> PairUtil<A, B> Method2161077(A a, B b) {
        return new PairUtil<A, B>(a, b);
    }

    @Override
    public void Method2150373() {
        if (HoleSnap.Method2150359()) {
            return;
        }
        Field1025 = new BlockPos.MutableBlockPos(0, -69, 0);
        if (this.Field1023.getValue().booleanValue()) {
            HoleSnap.Field2811.player.stepHeight = 0.5f;
        }
        if (this.Field1045) {
            AliceMain.Field756.Method2150180(FastFall.class).Method2150364();
        }
        if (this.Field1044) {
            AliceMain.Field756.Method2150180(SpeedRewrite.class).Method2150364();
        }
        Field1026 = 0;
        Field1027 = 0;
        Field1028 = false;
        this.Field1045 = false;
        this.Field1044 = false;
        AliceMain.Field771.Method2150369();
    }

    @Override
    public void Method2150372() {
        this.Field1043.Method2164750();
        if (this.Field1021.getValue().booleanValue() && SpeedRewrite.Method2162134().Method2150386()) {
            SpeedRewrite.Method2162134().Method2150380();
            Command.Method2159696("<HoleSnap> Disable Speed");
        }
        if (this.Field1022.getValue().booleanValue() && AliceMain.Field756.Method2150180(Step.class).Method2150364()) {
            AliceMain.Field756.Method2150180(Step.class).Method2150380();
            Command.Method2159696("<HoleSnap> Disable Step");
        }
    }

    @SubscribeEvent
    public void Method2161054(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (!(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook)) {
            return;
        }
        float f = ((SPacketPlayerPosLook) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getYaw();
        float f2 = ((SPacketPlayerPosLook) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getPitch();
        if (((SPacketPlayerPosLook) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getFlags().contains((Object) SPacketPlayerPosLook.EnumFlags.Y_ROT)) {
            f += HoleSnap.Field2811.player.rotationYaw;
        }
        if (((SPacketPlayerPosLook) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getFlags().contains((Object) SPacketPlayerPosLook.EnumFlags.X_ROT)) {
            f2 += HoleSnap.Field2811.player.rotationPitch;
        }
        Field1035 = new Vec2f(f, f2);
        this.Method2150380();
    }

    public final Vec2f Method2161055(Vec3d vec3d, Vec3d vec3d2) {
        Vec3d vec3d3 = vec3d2.subtract(vec3d);
        return this.Method2161058(vec3d3);
    }

    public final double Method2161057(double d) {
        double d2;
        double d3 = d;
        d3 %= 360.0;
        if (d2 >= 180.0) {
            d3 -= 360.0;
        }
        if (!(d3 < -180.0)) {
            return d3;
        }
        return d3 += 360.0;
    }

    public final Vec2f Method2161058(Vec3d vec3d) {
        double d = vec3d.x;
        double d2 = vec3d.z;
        double d3 = Math.hypot(d, d2);
        d2 = vec3d.z;
        double d4 = vec3d.x;
        double d5 = HoleSnap.Method2161056(Math.atan2(d2, d4)) - 90.0;
        d4 = vec3d.y;
        double d6 = -HoleSnap.Method2161056(Math.atan2(d4, d3));
        double d7 = d5 - (double) HoleSnap.Field1035.x;
        if (!(d7 < -180.0) && !(d7 > 180.0)) {
            return new Vec2f((float) this.Method2161057((double) HoleSnap.Field1035.x + d7), (float) this.Method2161057(d6));
        }
        double d8 = d7 / 360.0;
        d8 = Math.abs(d8);
        double d9 = Math.rint(d8);
        d7 = d7 < 0.0 ? d7 + 360.0 * d9 : d7 - 360.0 * d9;
        return new Vec2f((float) this.Method2161057((double) HoleSnap.Field1035.x + d7), (float) this.Method2161057(d6));
    }

    public final boolean Method2161050() {
        if (MotionUtil.Method2163885() && HoleSnap.Field2811.player.onGround) {
            return true;
        }
        if (!HoleSnap.Field2811.player.isOnLadder()) {
            return true;
        }
        if (!HoleSnap.Field2811.player.isInWater()) {
            return true;
        }
        if (HoleSnap.Field2811.player.isInLava()) {
            return false;
        }
        if (EntityUtil.Method2163524((Entity) HoleSnap.Field2811.player)) {
            return false;
        }
        if (!HoleSnap.Field2811.player.collidedHorizontally) {
            return false;
        }
        if (!HoleSnap.Field2811.player.collidedVertically) {
            return false;
        }
        if (HoleSnap.Field2811.player.movementInput.jump) {
            return false;
        }
        return (double) HoleSnap.Field2811.player.fallDistance < 0.1;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (Field1025 == null) {
            return;
        }
        Vec3d vec3d = EntityUtil.Method2163493((Entity) HoleSnap.Field2811.player, HoleSnap.Field2811.isGamePaused ? HoleSnap.Field2811.renderPartialTicksPaused : Field2811.getRenderPartialTicks());
        Color color = new Color(32, 255, 32, 255);
        HoleSnap.Method2161063(vec3d.x, vec3d.y, vec3d.z, color);
        HoleSnap.Method2161063((double) Field1025.getX() + 0.5, (double) Field1025.getY() + 0.5, (double) Field1025.getZ() + 0.5, color);
    }

    public void Method2161064() {
        HoleSnap.Field2811.player.isAirBorne = true;
        HoleSnap.Field2811.player.addStat(StatList.JUMP, 1);
    }

    public final boolean Method2161065(Entity entity, BlockPos blockPos) {
        double d = (double) blockPos.getX() + 0.31;
        double d2 = (double) blockPos.getX() + 0.69;
        double d3 = entity.posX;
        if (!(d <= d3)) {
            return false;
        }
        if (!(d3 <= d2)) {
            return false;
        }
        boolean bl = true;
        if (!bl) {
            return false;
        }
        d = (double) blockPos.getZ() + 0.31;
        d2 = (double) blockPos.getZ() + 0.69;
        d3 = entity.posZ;
        if (!(d <= d3)) {
            return false;
        }
        return d3 <= d2;
    }

    @Override
    public void Method2150379() {
        if (HoleSnap.Method2150359()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = HoleSnap.Field2811.player;
        if (this.Method2161075(EntityUtil.Method2163570((Entity) entityPlayerSP)) != HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE) {
            this.Method2150380();
            return;
        }
        BlockPos blockPos = this.Method2161079();
        if (blockPos == null) {
            Command.Method2159696("Unable to find hole, disabling HoleSnap");
            this.Method2150380();
        }
        if (blockPos != null && !blockPos.equals((Object) new BlockPos.MutableBlockPos(0, -69, 0))) {
            Field1028 = true;
            if (!this.Method2161065((Entity) HoleSnap.Field2811.player, blockPos)) {
                AliceMain.Field771.Method2150334(this.Field1020.getValue().intValue());
                Vec3d vec3d = HoleSnap.Field2811.player.getPositionVector();
                Vec3d vec3d2 = new Vec3d((double) blockPos.getX() + 0.5, HoleSnap.Field2811.player.posY, (double) blockPos.getZ() + 0.5);
                double d = Math.toRadians(RotationUtil.Method2163094((Vec3d) vec3d, (Vec3d) vec3d2).x);
                double d2 = vec3d.distanceTo(vec3d2);
                double d3 = HoleSnap.Field2811.player.onGround ? -Math.min(0.2805, d2 / 2.0) : -EntityUtil.Method2163548() + 0.02;
                HoleSnap.Field2811.player.motionX = 0.0;
                HoleSnap.Field2811.player.motionZ = 0.0;
                HoleSnap.Field2811.player.motionX = -Math.sin(d) * d3;
                HoleSnap.Field2811.player.motionZ = Math.cos(d) * d3;
                if (this.Field1043.Method2164755(500L)) {
                    this.Method2150380();
                    return;
                }
                if (HoleSnap.Field2811.player.collidedHorizontally) {
                    if (this.Field1023.getValue().booleanValue() && HoleSnap.Field2811.player.onGround) {
                        if (HoleSnap.Field2811.player != null && HoleSnap.Field2811.player.onGround && !HoleSnap.Field2811.player.isInWater() && !HoleSnap.Field2811.player.isOnLadder()) {
                            DecimalFormat decimalFormat = new DecimalFormat("#");
                            HoleSnap.Field2811.player.stepHeight = Float.parseFloat(decimalFormat.format(this.Field1024.getValue()));
                        }
                        if (++Field1027 > 5) {
                            HoleSnap.Field2811.player.stepHeight = 0.5f;
                            ++Field1026;
                        }
                    } else {
                        ++Field1026;
                    }
                } else {
                    Field1026 = 0;
                }
            }
        }
    }

    private List<BlockPos> Method2161069(int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8;
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n9 = n2;
        if (n9 > n3) {
            return arrayList;
        }
        do {
            int n10;
            n8 = n9++;
            int n11 = n6;
            if (n11 > n7) continue;
            do {
                int n12;
                n10 = n11++;
                int n13 = n4;
                if (n13 > n5) continue;
                do {
                    n12 = n13++;
                    arrayList.add(new BlockPos(n8, n12, n10));
                } while (n12 != n5);
            } while (n10 != n7);
        } while (n8 != n3);
        return arrayList;
    }

    public final List<BlockPos> Method2161060(BlockPos blockPos, BlockPos blockPos2) {
        int n2 = blockPos.getX();
        int n3 = blockPos2.getX();
        int n4 = 0;
        int n5 = Math.min(n2, n3);
        n3 = blockPos.getX();
        n4 = blockPos2.getX();
        int n6 = 0;
        int n7 = Math.max(n3, n4);
        n4 = blockPos.getY();
        n6 = blockPos2.getY();
        int n8 = 0;
        int n9 = Math.min(n4, n6);
        n6 = blockPos.getY();
        n8 = blockPos2.getY();
        int n10 = 0;
        int n11 = Math.max(n6, n8);
        n8 = blockPos.getZ();
        n10 = blockPos2.getZ();
        int n12 = 0;
        int n13 = Math.min(n8, n10);
        n10 = blockPos.getZ();
        n12 = blockPos2.getZ();
        boolean bl = false;
        int n14 = Math.max(n10, n12);
        return this.Method2161069(n5, n7, n9, n11, n13, n14);
    }

    public final double Method2161071(Entity entity, Vec3i vec3i) {
        double d = (double) vec3i.getX() + 0.5 - entity.posX;
        double d2 = (double) vec3i.getY() + 0.5 - entity.posY;
        double d3 = (double) vec3i.getZ() + 0.5 - entity.posZ;
        double d4 = d * d + d2 * d2 + d3 * d3;
        return Math.sqrt(d4);
    }

    private final boolean Method2161074(Block block) {
        if (block == Blocks.BEDROCK) {
            return true;
        }
        if (block == Blocks.OBSIDIAN) {
            return true;
        }
        if (block == Blocks.ENDER_CHEST) {
            return true;
        }
        return block == Blocks.ANVIL;
    }

    public final HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll Method2161075(BlockPos blockPos) {
        if (!HoleSnap.Field2811.world.isAirBlock(blockPos)) {
            return HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE;
        }
        BlockPos blockPos2 = blockPos.up();
        if (!HoleSnap.Field2811.world.isAirBlock(blockPos2)) {
            return HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE;
        }
        blockPos2 = blockPos.up(2);
        if (!HoleSnap.Field2811.world.isAirBlock(blockPos2)) {
            return HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE;
        }
        HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll = HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.CUSTOM;
        for (BlockPos blockPos3 : Field1034) {
            BlockPos blockPos4 = blockPos.add((Vec3i) blockPos3);
            Block block = HoleSnap.Method2161073(blockPos4);
            if (this.Method2161074(block)) continue;
            return HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE;
        }
        return iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll;
    }

    private final BlockPos Method2161076() {
        PairUtil<Double, BlockPos> pairUtil = new PairUtil<Double, BlockPos>(69.69, BlockPos.ORIGIN);
        EntityPlayerSP entityPlayerSP = HoleSnap.Field2811.player;
        BlockPos blockPos = EntityUtil.Method2163570((Entity) entityPlayerSP);
        int n2 = (int) Math.ceil(this.Field1019.getValue().floatValue());
        List<BlockPos> list = this.Method2161060(blockPos.add(n2, -1, n2), blockPos.add(-n2, -1, -n2));
        Iterator<BlockPos> iterator = list.iterator();
        block0:
        while (true) {
            double d;
            BlockPos blockPos2;
            if (iterator.hasNext()) {
                blockPos2 = iterator.next();
                d = this.Method2161071((Entity) HoleSnap.Field2811.player, (Vec3i) blockPos2);
                if (d > Double.valueOf(this.Field1019.getValue().floatValue()) || d > pairUtil.Method2163911()) {
                    continue;
                }
            } else {
                if (pairUtil.Method2163912() == BlockPos.ORIGIN) {
                    return null;
                }
                BlockPos blockPos3 = pairUtil.Method2163912();
                Field1025.setPos((Vec3i) blockPos3);
                return blockPos3;
            }
            int n3 = 0;
            do {
                int n4;
                BlockPos blockPos4;
                BlockPos blockPos5;
                if (!HoleSnap.Field2811.world.isAirBlock(blockPos5 = (blockPos4 = blockPos2.add(0, -(n4 = n3++), 0)).up()))
                    continue block0;
                if (this.Method2161075(blockPos4) == HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE)
                    continue;
                pairUtil = HoleSnap.Method2161077(d, blockPos4);
            } while (n3 <= 5);
        }
    }

    private final boolean Method2161078(double d) {
        boolean bl;
        if (Field1025 != null) {
            if (HoleSnap.Field2811.player.posY < (double) Field1025.getY()) {
                return true;
            }
            bl = false;
        } else {
            bl = false;
        }
        if (bl) {
            return true;
        }
        if (Field1026 > 5 && d < 0.1) {
            return true;
        }
        if (!(d < 0.01)) {
            return false;
        }
        EntityPlayerSP entityPlayerSP = HoleSnap.Field2811.player;
        return this.Method2161075(EntityUtil.Method2163570((Entity) entityPlayerSP)) != HoleUtilStayyy.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.NONE;
    }

    private final BlockPos Method2161079() {
        EntityPlayerSP entityPlayerSP = HoleSnap.Field2811.player;
        if (!EntityUtil.Method2163570((Entity) entityPlayerSP).equals((Object) Field1025)) {
            BlockPos blockPos = this.Method2161076();
            return blockPos;
        }
        if (Field1025 != null) {
            BlockPos.MutableBlockPos mutableBlockPos = Field1025;
            return mutableBlockPos;
        }
        BlockPos blockPos = this.Method2161076();
        return blockPos;
    }

    private boolean Method2161070(Float f) {
        return this.Field1023.getValue();
    }
}

