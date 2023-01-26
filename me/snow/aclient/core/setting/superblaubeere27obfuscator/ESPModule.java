

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  javax.vecmath.Vector3d
 *  javax.vecmath.Vector4d
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.GLU
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderHelper;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.mixin.mixins.accessors.IEntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ESPModule
        extends Module {
    private static ESPModule Field2199 = new ESPModule();
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2201 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Page", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City));
    private final Setting<Boolean> Field2202 = this.Method2150366(new Setting<Boolean>("CityESP", Boolean.valueOf(true), this::Method2162447));
    private final Setting<Integer> Field2203 = this.Method2150366(new Setting<Integer>("CityESP-Range", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(10), this::Method2162446));
    private final Setting<Double> Field2204 = this.Method2150366(new Setting<Double>("CityESP-Height", Double.valueOf(-0.9), Double.valueOf(-2.0), Double.valueOf(2.0), this::Method2162445));
    private final Setting<Integer> Field2205 = this.Method2150366(new Setting<Integer>("CityESP-BoxAlpha", Integer.valueOf(42), Integer.valueOf(0), Integer.valueOf(255), this::Method2162444));
    private final Setting<Boolean> Field2206 = this.Method2150366(new Setting<Boolean>("CityESP-Outline", Boolean.valueOf(true), this::Method2162443));
    private final Setting<Integer> Field2207 = this.Method2150366(new Setting<Integer>("CityESP-LineAlpha", Integer.valueOf(80), Integer.valueOf(0), Integer.valueOf(255), this::Method2162442));
    private final Setting<Boolean> Field2208 = this.Method2150366(new Setting<Boolean>("Item2D-TextESP", Boolean.valueOf(true), this::Method2162441));
    public Setting<Float> Field2209 = this.Method2150366(new Setting<Float>("Raytrace", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(4.0f), this::Method2162430));
    private final Setting<Boolean> Field2210 = this.Method2150366(new Setting<Boolean>("Items", Boolean.valueOf(false), this::Method2162439));
    private final Setting<Boolean> Field2211 = this.Method2150366(new Setting<Boolean>("XpOrbs", Boolean.valueOf(false), this::Method2162438));
    private final Setting<Boolean> Field2212 = this.Method2150366(new Setting<Boolean>("XpBottles", Boolean.valueOf(false), this::Method2162437));
    private final Setting<Boolean> Field2213 = this.Method2150366(new Setting<Boolean>("Pearls", Boolean.valueOf(false), this::Method2162436));
    private final Setting<Boolean> Field2214 = this.Method2150366(new Setting<Boolean>("Item-ColorSync", Boolean.valueOf(true), this::Method2162435));
    private final Setting<Integer> Field2215 = this.Method2150366(new Setting<Integer>("Item-Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162434));
    private final Setting<Integer> Field2216 = this.Method2150366(new Setting<Integer>("Item-Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162433));
    private final Setting<Integer> Field2217 = this.Method2150366(new Setting<Integer>("Item-Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162432));
    private final Setting<Integer> Field2218 = this.Method2150366(new Setting<Integer>("Item-BoxAlpha", Integer.valueOf(120), Integer.valueOf(0), Integer.valueOf(255), this::Method2162431));
    private final Setting<Integer> Field2219 = this.Method2150366(new Setting<Integer>("Item-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162420));
    private final Setting<Integer> Field2221 = this.Method2150366(new Setting<Integer>("Block-Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162428));
    private final Setting<Integer> Field2222 = this.Method2150366(new Setting<Integer>("Block-Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162427));
    private final Setting<Integer> Field2223 = this.Method2150366(new Setting<Integer>("Block-Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162426));
    private final Setting<Integer> Field2224 = this.Method2150366(new Setting<Integer>("Block-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162425));
    private final Setting<Boolean> Field2236 = this.Method2150366(new Setting<Boolean>("VoidESP", Boolean.valueOf(true), this::Method2162413));
    private final Setting<Float> Field2237 = this.Method2150366(new Setting<Float>("VoidESP-Radius", Float.valueOf(8.0f), Float.valueOf(0.0f), Float.valueOf(50.0f), this::Method2162412));
    private final Setting<Float> Field2238 = this.Method2150366(new Setting<Float>("VoidESP-Range", Float.valueOf(8.0f), Float.valueOf(0.0f), Float.valueOf(50.0f), this::Method2162411));
    private final Setting<Integer> Field2245 = this.Method2150366(new Setting<Integer>("VoidESP-Updates", Integer.valueOf(500), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162304));
    private final Setting<Integer> Field2246 = this.Method2150366(new Setting<Integer>("VoidESP-VoidCap", Integer.valueOf(500), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162303));
    private final Setting<Integer> Field2248 = this.Method2150366(new Setting<Integer>("VoidESP-Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162301));
    private final Setting<Integer> Field2249 = this.Method2150366(new Setting<Integer>("VoidESP-Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162390));
    private final Setting<Integer> Field2250 = this.Method2150366(new Setting<Integer>("VoidESP-Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162399));
    private final Setting<Integer> Field2251 = this.Method2150366(new Setting<Integer>("VoidESP-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162398));
    private final Timer Field2259 = new Timer();
    public EntityPlayer Field2200;
    public Setting<Boolean> Field2220 = this.Method2150366(new Setting<Boolean>("BlockHighlight", Boolean.valueOf(false), this::Method2162429));
    public Setting<Boolean> Field2225 = this.Method2150366(new Setting<Boolean>("Block-Sync", Boolean.valueOf(false), this::Method2162424));
    public Setting<Boolean> Field2226 = this.Method2150366(new Setting<Object>("Block-Rolling", Boolean.FALSE, this::Method2162423));
    public Setting<Boolean> Field2227 = this.Method2150366(new Setting<Boolean>("Block-Box", Boolean.valueOf(false), this::Method2162422));
    private final Setting<Integer> Field2228 = this.Method2150366(new Setting<Object>("Block-BoxAlpha", Integer.valueOf(125), Integer.valueOf(0), Integer.valueOf(255), this::Method2162421));
    public Setting<Boolean> Field2229 = this.Method2150366(new Setting<Boolean>("Block-Outline", Boolean.valueOf(true), this::Method2162410));
    private final Setting<Float> Field2230 = this.Method2150366(new Setting<Object>("Block-LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2162419));
    public Setting<Boolean> Field2231 = this.Method2150366(new Setting<Object>("Block-CustomLine", Boolean.FALSE, this::Method2162418));
    private final Setting<Integer> Field2232 = this.Method2150366(new Setting<Object>("Block-OL-Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162417));
    private final Setting<Integer> Field2233 = this.Method2150366(new Setting<Object>("Block-OL-Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162416));
    private final Setting<Integer> Field2234 = this.Method2150366(new Setting<Object>("Block-OL-Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162415));
    private final Setting<Integer> Field2235 = this.Method2150366(new Setting<Object>("Block-OL-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162414));
    private Setting<Boolean> Field2239 = this.Method2150366(new Setting<Boolean>("VoidESP-OnlyAir", Boolean.valueOf(true), this::Method2162300));
    private Setting<Boolean> Field2240 = this.Method2150366(new Setting<Boolean>("VoidESP-NoEnd", Boolean.valueOf(true), this::Method2162309));
    private Setting<Boolean> Field2241 = this.Method2150366(new Setting<Boolean>("VoidESP-Box", Boolean.valueOf(true), this::Method2162308));
    private final Setting<Integer> Field2252 = this.Method2150366(new Setting<Object>("VoidESP-BoxAlpha", Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(255), this::Method2162397));
    private Setting<Boolean> Field2242 = this.Method2150366(new Setting<Boolean>("VoidESP-Outline", Boolean.valueOf(true), this::Method2162307));
    private Setting<Boolean> Field2244 = this.Method2150366(new Setting<Object>("VoidESP-CustomLine", Boolean.FALSE, this::Method2162305));
    private final Setting<Integer> Field2254 = this.Method2150366(new Setting<Object>("VoidESP-OL-Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162395));
    private final Setting<Integer> Field2255 = this.Method2150366(new Setting<Object>("VoidESP-OL-Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162394));
    private final Setting<Integer> Field2256 = this.Method2150366(new Setting<Object>("VoidESP-OL-Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162393));
    private final Setting<Integer> Field2257 = this.Method2150366(new Setting<Object>("VoidESP-OL-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162392));
    private final Setting<Float> Field2253 = this.Method2150366(new Setting<Object>("VoidESP-LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2162396));
    private Setting<Double> Field2243 = this.Method2150366(new Setting<Double>("VoidESP-Height", Double.valueOf(-1.0), Double.valueOf(-2.0), Double.valueOf(2.0), this::Method2162306));
    private Setting<Boolean> Field2247 = this.Method2150366(new Setting<Boolean>("VoidESP-Sync", Boolean.valueOf(true), this::Method2162302));
    private List<BlockPos> Field2258 = new CopyOnWriteArrayList<BlockPos>();
    private int Field2260 = 0;

    public ESPModule() {
        super("ESP", "Renders a nice ESP.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162384();
    }

    public static ESPModule Method2162383() {
        if (Field2199 == null) {
            Field2199 = new ESPModule();
        }
        return Field2199;
    }

    private void Method2162384() {
        Field2199 = this;
    }

    private void Method2162385() {
        if (this.Field2200 == null) {
            return;
        }
        Vec3d vec3d = this.Field2200.getPositionVector();
        if (ESPModule.Field2811.world.getBlockState(new BlockPos(vec3d)).getBlock() == Blocks.OBSIDIAN || ESPModule.Field2811.world.getBlockState(new BlockPos(vec3d)).getBlock() == Blocks.ENDER_CHEST) {
            RenderUtil.Method2163900(new BlockPos(vec3d), new Color(255, 255, 0, this.Field2207.getValue()), false, new Color(255, 255, 0, this.Field2207.getValue()), 1.0f, this.Field2206.getValue(), true, this.Field2205.getValue(), true, this.Field2204.getValue(), false, false, false, false, this.Field2260);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 1)) {
            this.Method2162386(vec3d, -1.0, 0.0, 0.0, true);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 2)) {
            this.Method2162386(vec3d, 1.0, 0.0, 0.0, true);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 3)) {
            this.Method2162386(vec3d, 0.0, 0.0, -1.0, true);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 4)) {
            this.Method2162386(vec3d, 0.0, 0.0, 1.0, true);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 5)) {
            this.Method2162386(vec3d, -1.0, 0.0, 0.0, false);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 6)) {
            this.Method2162386(vec3d, 1.0, 0.0, 0.0, false);
        }
        if (EntityUtil.Method2163480(vec3d, -1, 7)) {
            this.Method2162386(vec3d, 0.0, 0.0, -1.0, false);
        }
        if (!EntityUtil.Method2163480(vec3d, -1, 8)) {
            return;
        }
        this.Method2162386(vec3d, 0.0, 0.0, 1.0, false);
    }

    private void Method2162386(Vec3d vec3d, double d, double d2, double d3, boolean bl) {
        BlockPos blockPos = new BlockPos(vec3d).add(d, d2, d3);
        if (ESPModule.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.AIR) {
            return;
        }
        if (ESPModule.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.FIRE) {
            return;
        }
        if (bl) {
            RenderUtil.Method2163900(blockPos, new Color(255, 0, 0, this.Field2207.getValue()), false, new Color(255, 0, 0, this.Field2207.getValue()), 1.0f, this.Field2206.getValue(), true, this.Field2205.getValue(), true, this.Field2204.getValue(), false, false, false, false, this.Field2260);
            return;
        }
        RenderUtil.Method2163900(blockPos, new Color(0, 0, 255, this.Field2207.getValue()), false, new Color(0, 0, 255, this.Field2207.getValue()), 1.0f, this.Field2206.getValue(), true, this.Field2205.getValue(), true, this.Field2204.getValue(), false, false, false, false, this.Field2260);
    }

    private EntityPlayer Method2162387(double d) {
        EntityPlayer entityPlayer = null;
        double d2 = d;
        for (EntityPlayer entityPlayer2 : ESPModule.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d) || !EntityUtil.Method2163512((Entity) entityPlayer2))
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                d2 = ESPModule.Field2811.player.getDistanceSq((Entity) entityPlayer2);
                continue;
            }
            if (!(ESPModule.Field2811.player.getDistanceSq((Entity) entityPlayer2) < d2)) continue;
            entityPlayer = entityPlayer2;
            d2 = ESPModule.Field2811.player.getDistanceSq((Entity) entityPlayer2);
        }
        return entityPlayer;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        AxisAlignedBB axisAlignedBB;
        Vec3d vec3d;
        Object object;
        Object object2;
        int n2;
        Color color;
        if (ESPModule.Method2150359()) {
            return;
        }
        Color color2 = color = this.Field2214.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2215.getValue(), this.Field2216.getValue(), this.Field2217.getValue(), this.Field2219.getValue());
        if (this.Field2202.getValue().booleanValue()) {
            this.Field2200 = this.Method2162387(this.Field2203.getValue().intValue());
            this.Method2162385();
        }
        if (this.Field2210.getValue().booleanValue()) {
            n2 = 0;
            object2 = ESPModule.Field2811.world.loadedEntityList.iterator();
            while (object2.hasNext()) {
                object = (Entity) object2.next();
                if (!(object instanceof EntityItem) || !(ESPModule.Field2811.player.getDistanceSq(object) < 2500.0))
                    continue;
                vec3d = EntityUtil.Method2163494(object, Field2811.getRenderPartialTicks());
                axisAlignedBB = new AxisAlignedBB(object.getEntityBoundingBox().minX - 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().minY - 0.0 - object.posY + vec3d.y, object.getEntityBoundingBox().minZ - 0.05 - object.posZ + vec3d.z, object.getEntityBoundingBox().maxX + 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().maxY + 0.1 - object.posY + vec3d.y, object.getEntityBoundingBox().maxZ + 0.05 - object.posZ + vec3d.z);
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.disableDepth();
                GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean) false);
                GL11.glEnable((int) 2848);
                GL11.glHint((int) 3154, (int) 4354);
                GL11.glLineWidth((float) 1.0f);
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) this.Field2218.getValue().intValue() / 255.0f));
                GL11.glDisable((int) 2848);
                GlStateManager.depthMask((boolean) true);
                GlStateManager.enableDepth();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
                RenderUtil.Method2163010(axisAlignedBB, new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field2219.getValue()), 1.0f);
                if (++n2 < 50) continue;
            }
        }
        if (this.Field2211.getValue().booleanValue()) {
            n2 = 0;
            object2 = ESPModule.Field2811.world.loadedEntityList.iterator();
            while (object2.hasNext()) {
                object = (Entity) object2.next();
                if (!(object instanceof EntityXPOrb) || !(ESPModule.Field2811.player.getDistanceSq(object) < 2500.0))
                    continue;
                vec3d = EntityUtil.Method2163494(object, Field2811.getRenderPartialTicks());
                axisAlignedBB = new AxisAlignedBB(object.getEntityBoundingBox().minX - 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().minY - 0.0 - object.posY + vec3d.y, object.getEntityBoundingBox().minZ - 0.05 - object.posZ + vec3d.z, object.getEntityBoundingBox().maxX + 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().maxY + 0.1 - object.posY + vec3d.y, object.getEntityBoundingBox().maxZ + 0.05 - object.posZ + vec3d.z);
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.disableDepth();
                GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean) false);
                GL11.glEnable((int) 2848);
                GL11.glHint((int) 3154, (int) 4354);
                GL11.glLineWidth((float) 1.0f);
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) this.Field2218.getValue().intValue() / 255.0f));
                GL11.glDisable((int) 2848);
                GlStateManager.depthMask((boolean) true);
                GlStateManager.enableDepth();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
                RenderUtil.Method2163010(axisAlignedBB, new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field2219.getValue()), 1.0f);
                if (++n2 < 50) continue;
            }
        }
        if (this.Field2213.getValue().booleanValue()) {
            n2 = 0;
            object2 = ESPModule.Field2811.world.loadedEntityList.iterator();
            while (object2.hasNext()) {
                object = (Entity) object2.next();
                if (!(object instanceof EntityEnderPearl) || !(ESPModule.Field2811.player.getDistanceSq(object) < 2500.0))
                    continue;
                vec3d = EntityUtil.Method2163494(object, Field2811.getRenderPartialTicks());
                axisAlignedBB = new AxisAlignedBB(object.getEntityBoundingBox().minX - 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().minY - 0.0 - object.posY + vec3d.y, object.getEntityBoundingBox().minZ - 0.05 - object.posZ + vec3d.z, object.getEntityBoundingBox().maxX + 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().maxY + 0.1 - object.posY + vec3d.y, object.getEntityBoundingBox().maxZ + 0.05 - object.posZ + vec3d.z);
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.disableDepth();
                GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean) false);
                GL11.glEnable((int) 2848);
                GL11.glHint((int) 3154, (int) 4354);
                GL11.glLineWidth((float) 1.0f);
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) this.Field2218.getValue().intValue() / 255.0f));
                GL11.glDisable((int) 2848);
                GlStateManager.depthMask((boolean) true);
                GlStateManager.enableDepth();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
                RenderUtil.Method2163010(axisAlignedBB, new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field2219.getValue()), 1.0f);
                if (++n2 < 50) continue;
            }
        }
        if (this.Field2212.getValue().booleanValue()) {
            n2 = 0;
            object2 = ESPModule.Field2811.world.loadedEntityList.iterator();
            while (object2.hasNext()) {
                object = (Entity) object2.next();
                if (!(object instanceof EntityExpBottle) || !(ESPModule.Field2811.player.getDistanceSq(object) < 2500.0))
                    continue;
                vec3d = EntityUtil.Method2163494(object, Field2811.getRenderPartialTicks());
                axisAlignedBB = new AxisAlignedBB(object.getEntityBoundingBox().minX - 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().minY - 0.0 - object.posY + vec3d.y, object.getEntityBoundingBox().minZ - 0.05 - object.posZ + vec3d.z, object.getEntityBoundingBox().maxX + 0.05 - object.posX + vec3d.x, object.getEntityBoundingBox().maxY + 0.1 - object.posY + vec3d.y, object.getEntityBoundingBox().maxZ + 0.05 - object.posZ + vec3d.z);
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.disableDepth();
                GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean) false);
                GL11.glEnable((int) 2848);
                GL11.glHint((int) 3154, (int) 4354);
                GL11.glLineWidth((float) 1.0f);
                RenderGlobal.renderFilledBox((AxisAlignedBB) axisAlignedBB, (float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) this.Field2218.getValue().intValue() / 255.0f));
                GL11.glDisable((int) 2848);
                GlStateManager.depthMask((boolean) true);
                GlStateManager.enableDepth();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
                RenderUtil.Method2163010(axisAlignedBB, new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field2219.getValue()), 1.0f);
                if (++n2 < 50) continue;
            }
        }
        if (this.Field2220.getValue().booleanValue() && (object2 = ESPModule.Field2811.objectMouseOver) != null && ((RayTraceResult) object2).typeOfHit == RayTraceResult.Type.BLOCK) {
            object = object2.getBlockPos();
            if (this.Field2226.getValue().booleanValue()) {
                RenderUtil.Method2163997((BlockPos) object, new Color(HUD.Method2150504().Field3054.get(0)), new Color(HUD.Method2150504().Field3054.get(this.Field3872.Field2304 / 4)), new Color(HUD.Method2150504().Field3054.get(this.Field3872.Field2304 / 2)), 1.0f);
            } else {
                RenderUtil.Method2163908((BlockPos) object, this.Field2225.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2221.getValue(), this.Field2222.getValue(), this.Field2223.getValue(), this.Field2224.getValue()), this.Field2231.getValue(), new Color(this.Field2232.getValue(), this.Field2233.getValue(), this.Field2234.getValue(), this.Field2235.getValue()), this.Field2230.getValue().floatValue(), this.Field2229.getValue(), this.Field2227.getValue(), this.Field2228.getValue(), false);
            }
        }
        if (this.Field2236.getValue().booleanValue()) {
            if (ESPModule.Method2150359() || this.Field2240.getValue().booleanValue() && ESPModule.Field2811.player.dimension == 1) {
                return;
            }
            object2 = this.Field2247.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2248.getValue(), this.Field2249.getValue(), this.Field2250.getValue(), this.Field2251.getValue());
            object = new Color(((Color) object2).getRed(), ((Color) object2).getGreen(), ((Color) object2).getBlue(), this.Field2251.getValue());
            for (BlockPos blockPos : this.Field2258) {
                if (!(ESPModule.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()) < (double) this.Field2238.getValue().floatValue()))
                    continue;
                RenderUtil.Method2163900(blockPos, (Color) object, this.Field2244.getValue(), new Color(this.Field2254.getValue(), this.Field2255.getValue(), this.Field2256.getValue(), this.Field2257.getValue()), this.Field2253.getValue().floatValue(), this.Field2242.getValue(), this.Field2241.getValue(), this.Field2252.getValue(), true, this.Field2243.getValue(), false, false, false, false, 0);
            }
        }
    }

    @Override
    @SubscribeEvent
    public void Method2150370(Render2DEvent render2DEvent) {
        if (this.Field2208.getValue().booleanValue()) {
            float f = ESPModule.Field2811.timer.renderPartialTicks;
            Float f2 = this.Field2209.getValue();
            double d = (double) f2.floatValue() / Math.pow(f2.floatValue(), 2.0);
            GlStateManager.scale((double) d, (double) d, (double) d);
            Color color = this.Field2214.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field2215.getValue(), this.Field2216.getValue(), this.Field2217.getValue(), this.Field2219.getValue());
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field2219.getValue());
            float f3 = 1.0f;
            for (Entity entity : ESPModule.Field2811.world.loadedEntityList) {
                if (!this.Method2162389(entity) || !RenderHelper.Method2163694(entity)) continue;
                EntityItem entityItem = (EntityItem) entity;
                double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) Field2811.getRenderPartialTicks();
                double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) Field2811.getRenderPartialTicks();
                double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) Field2811.getRenderPartialTicks();
                AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
                AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity.posX + d2 - 0.05, axisAlignedBB.minY - entity.posY + d3, axisAlignedBB.minZ - entity.posZ + d4 - 0.05, axisAlignedBB.maxX - entity.posX + d2 + 0.05, axisAlignedBB.maxY - entity.posY + d3 + 0.15, axisAlignedBB.maxZ - entity.posZ + d4 + 0.05);
                Vector3d[] arrvector3d = new Vector3d[]{new Vector3d(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.minZ), new Vector3d(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.minZ), new Vector3d(axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.minZ), new Vector3d(axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.minZ), new Vector3d(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.maxZ), new Vector3d(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ), new Vector3d(axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.maxZ), new Vector3d(axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ)};
                ((IEntityRenderer) ESPModule.Field2811.entityRenderer).invokeSetupCameraTransform(f, 0);
                Vector4d vector4d = null;
                for (Vector3d vector3d : arrvector3d) {
                    vector3d = this.Method2162388(f2, vector3d.x - ESPModule.Field2811.getRenderManager().renderPosX, vector3d.y - ESPModule.Field2811.getRenderManager().renderPosY, vector3d.z - ESPModule.Field2811.getRenderManager().renderPosZ);
                    if (vector3d == null || !(vector3d.z > 0.0) || !(vector3d.z < 1.0)) continue;
                    if (vector4d == null) {
                        vector4d = new Vector4d(vector3d.x, vector3d.y, vector3d.z, 0.0);
                    }
                    vector4d.x = Math.min(vector3d.x, vector4d.x);
                    vector4d.y = Math.min(vector3d.y, vector4d.y);
                    vector4d.z = Math.max(vector3d.x, vector4d.z);
                    vector4d.w = Math.max(vector3d.y, vector4d.w);
                }
                if (vector4d == null) continue;
                ESPModule.Field2811.entityRenderer.setupOverlayRendering();
                double d5 = vector4d.x;
                double d6 = vector4d.y;
                double d7 = vector4d.z;
                double d8 = vector4d.w;
                float f4 = (float) (d7 - d5) / 2.0f;
                float f5 = (float) AliceMain.Field766.Method2150310(entityItem.getItem().getDisplayName()) * f3;
                float f6 = (float) ((d5 + (double) f4 - (double) (f5 / 2.0f)) * (double) f3);
                AliceMain.Field766.Method2150317(entityItem.getItem().getDisplayName(), f6, (float) d6 - 10.0f, -1);
            }
            GL11.glEnable((int) 2929);
            ESPModule.Field2811.entityRenderer.setupOverlayRendering();
        }
    }

    private Vector3d Method2162388(Float f, double d, double d2, double d3) {
        float f2 = (float) d;
        float f3 = (float) d2;
        float f4 = (float) d3;
        IntBuffer intBuffer = GLAllocation.createDirectIntBuffer((int) 16);
        FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer((int) 16);
        FloatBuffer floatBuffer2 = GLAllocation.createDirectFloatBuffer((int) 16);
        FloatBuffer floatBuffer3 = GLAllocation.createDirectFloatBuffer((int) 4);
        GL11.glGetFloat((int) 2982, (FloatBuffer) floatBuffer);
        GL11.glGetFloat((int) 2983, (FloatBuffer) floatBuffer2);
        GL11.glGetInteger((int) 2978, (IntBuffer) intBuffer);
        if (GLU.gluProject((float) f2, (float) f3, (float) f4, (FloatBuffer) floatBuffer, (FloatBuffer) floatBuffer2, (IntBuffer) intBuffer, (FloatBuffer) floatBuffer3)) {
            return new Vector3d((double) (floatBuffer3.get(0) / f.floatValue()), (double) (((float) Display.getHeight() - floatBuffer3.get(1)) / f.floatValue()), (double) floatBuffer3.get(2));
        }
        return null;
    }

    private boolean Method2162389(Entity entity) {
        return entity instanceof EntityItem;
    }

    private List<BlockPos> Method2162380() {
        BlockPos blockPos = EntityUtil.Method2163403((EntityPlayer) ESPModule.Field2811.player);
        return BlockUtil.Method2162820(blockPos.add(0, -blockPos.getY(), 0), this.Field2237.getValue().floatValue()).stream().filter(this::Method2162391).collect(Collectors.toList());
    }

    private boolean Method2162391(BlockPos blockPos) {
        return (ESPModule.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.AIR || this.Field2239.getValue() == false && ESPModule.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK) && blockPos.getY() < 1 && blockPos.getY() >= 0;
    }

    @Override
    public void Method2150376() {
        if (this.Field2236.getValue().booleanValue() && !ESPModule.Method2150359() && (!this.Field2240.getValue().booleanValue() || ESPModule.Field2811.player.dimension != 1) && this.Field2259.Method2164755(this.Field2245.getValue().intValue())) {
            this.Field2258.clear();
            this.Field2258 = this.Method2162380();
            if (this.Field2258.size() > this.Field2246.getValue()) {
                this.Field2258.clear();
            }
            this.Field2259.Method2164750();
        }
    }

    @Override
    public void Method2150374() {
        if (this.Field2236.getValue().booleanValue()) {
            this.Field2259.Method2164750();
        }
    }

    @Override
    public void Method2150377() {
        if (this.Field2236.getValue().booleanValue()) {
            this.Field2259.Method2164750();
        }
    }

    private boolean Method2162392(Object object) {
        return this.Field2244.getValue() != false && this.Field2242.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162393(Object object) {
        return this.Field2244.getValue() != false && this.Field2242.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162394(Object object) {
        return this.Field2244.getValue() != false && this.Field2242.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162395(Object object) {
        return this.Field2244.getValue() != false && this.Field2242.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162396(Object object) {
        return this.Field2242.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162397(Object object) {
        return this.Field2241.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162398(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162399(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162390(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162301(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162302(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162303(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162304(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162305(Object object) {
        return this.Field2242.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162306(Double d) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162307(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162308(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162309(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162300(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162411(Float f) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162412(Float f) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162413(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.VoidESP;
    }

    private boolean Method2162414(Object object) {
        return this.Field2231.getValue() != false && this.Field2229.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162415(Object object) {
        return this.Field2231.getValue() != false && this.Field2229.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162416(Object object) {
        return this.Field2231.getValue() != false && this.Field2229.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162417(Object object) {
        return this.Field2231.getValue() != false && this.Field2229.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162418(Object object) {
        return this.Field2229.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162419(Object object) {
        return this.Field2229.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162410(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162421(Object object) {
        return this.Field2227.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162422(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162423(Object object) {
        return this.Field2225.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162424(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162425(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162426(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162427(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162428(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162429(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BlockHighlight;
    }

    private boolean Method2162420(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162431(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162432(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162433(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162434(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162435(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162436(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162437(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162438(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162439(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162430(Float f) {
        return this.Field2208.getValue() != false && this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162441(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Item;
    }

    private boolean Method2162442(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City;
    }

    private boolean Method2162443(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City;
    }

    private boolean Method2162444(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City;
    }

    private boolean Method2162445(Double d) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City;
    }

    private boolean Method2162446(Integer n2) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City;
    }

    private boolean Method2162447(Boolean bl) {
        return this.Field2201.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.City;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        City,
        Item,
        BlockHighlight,
        VoidESP;

    }
}

