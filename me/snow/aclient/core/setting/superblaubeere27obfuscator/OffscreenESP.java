

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.collect.Maps;

import java.awt.Color;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class OffscreenESP
        extends Module {
    private final Setting<Boolean> Field1508 = this.Method2150366(new Setting<Boolean>("Sync", false));
    private final Setting<Boolean> Field1509 = this.Method2150366(new Setting<Boolean>("Invisibles", false));
    private final Setting<Boolean> Field1510 = this.Method2150366(new Setting<Boolean>("Offscreen-Only", true));
    private final Setting<Boolean> Field1511 = this.Method2150366(new Setting<Boolean>("Outline", true));
    private final Setting<Float> Field1512 = this.Method2150366(new Setting<Float>("Outline-Width", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(3.0f)));
    private final Setting<Integer> Field1513 = this.Method2150366(new Setting<Integer>("Fade-Distance", 100, 10, 200));
    private final Setting<Integer> Field1514 = this.Method2150366(new Setting<Integer>("Radius", 45, 10, 200));
    private final Setting<Float> Field1515 = this.Method2150366(new Setting<Float>("Size", Float.valueOf(10.0f), Float.valueOf(5.0f), Float.valueOf(25.0f)));
    private final Setting<Integer> Field1516 = this.Method2150366(new Setting<Integer>("Red", 255, 0, 255));
    private final Setting<Integer> Field1517 = this.Method2150366(new Setting<Integer>("Green", 0, 0, 255));
    private final Setting<Integer> Field1518 = this.Method2150366(new Setting<Integer>("Blue", 255, 0, 255));
    private final IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field1519 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(null);

    public OffscreenESP() {
        super("ArrowESP", "Shows the direction players are in with cool little triangles :3", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }

    @Override
    public void Method2150370(Render2DEvent render2DEvent) {
        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162610(this.Field1519);
        OffscreenESP.Field2811.world.loadedEntityList.forEach(this::Method2162624);
    }

    private boolean Method2162621(Vec3d vec3d) {
        int n2;
        int n3;
        int n4;
        if (!(vec3d.x > -1.0)) {
            return false;
        }
        if (!(vec3d.y < 1.0)) {
            return false;
        }
        int n5 = n4 = OffscreenESP.Field2811.gameSettings.guiScale == 0 ? 1 : OffscreenESP.Field2811.gameSettings.guiScale;
        if (!(vec3d.x / (double) n4 >= 0.0)) {
            return false;
        }
        int n6 = n3 = OffscreenESP.Field2811.gameSettings.guiScale == 0 ? 1 : OffscreenESP.Field2811.gameSettings.guiScale;
        if (!(vec3d.x / (double) n3 <= (double) Display.getWidth())) {
            return false;
        }
        int n7 = n2 = OffscreenESP.Field2811.gameSettings.guiScale == 0 ? 1 : OffscreenESP.Field2811.gameSettings.guiScale;
        if (!(vec3d.y / (double) n2 >= 0.0)) {
            return false;
        }
        int n8 = OffscreenESP.Field2811.gameSettings.guiScale == 0 ? 1 : OffscreenESP.Field2811.gameSettings.guiScale;
        return vec3d.y / (double) n8 <= (double) Display.getHeight();
    }

    private boolean Method2162622(EntityPlayer entityPlayer) {
        return entityPlayer != OffscreenESP.Field2811.player && (!entityPlayer.isInvisible() || this.Field1509.getValue() != false) && entityPlayer.isEntityAlive();
    }

    private float Method2162623(EntityLivingBase entityLivingBase) {
        double d = entityLivingBase.posX - OffscreenESP.Field2811.player.posX;
        double d2 = entityLivingBase.posZ - OffscreenESP.Field2811.player.posZ;
        return (float) (-(Math.atan2(d, d2) * 57.29577951308232));
    }

    private void Method2162624(Entity entity) {
        if (entity instanceof EntityPlayer && this.Method2162622((EntityPlayer) entity)) {
            EntityPlayer entityPlayer = (EntityPlayer) entity;
            Vec3d vec3d = this.Field1519.Method2162619().get((Object) entityPlayer);
            if (!(vec3d == null || this.Method2162621(vec3d) || RenderUtil.Method2163060((Entity) entityPlayer) && this.Field1510.getValue().booleanValue())) {
                Color color = this.Field1508.getValue() != false ? new Color(Colors.Field1782.Method2150586().getRed(), Colors.Field1782.Method2150586().getGreen(), Colors.Field1782.Method2150586().getBlue(), (int) MathHelper.clamp((float) (255.0f - 255.0f / (float) this.Field1513.getValue().intValue() * OffscreenESP.Field2811.player.getDistance((Entity) entityPlayer)), (float) 100.0f, (float) 255.0f)) : EntityUtil.Method2163558((Entity) entityPlayer, this.Field1516.getValue(), this.Field1517.getValue(), this.Field1518.getValue(), (int) MathHelper.clamp((float) (255.0f - 255.0f / (float) this.Field1513.getValue().intValue() * OffscreenESP.Field2811.player.getDistance((Entity) entityPlayer)), (float) 100.0f, (float) 255.0f), true);
                int n2 = Display.getWidth() / 2 / (OffscreenESP.Field2811.gameSettings.guiScale == 0 ? 1 : OffscreenESP.Field2811.gameSettings.guiScale);
                int n3 = Display.getHeight() / 2 / (OffscreenESP.Field2811.gameSettings.guiScale == 0 ? 1 : OffscreenESP.Field2811.gameSettings.guiScale);
                float f = this.Method2162623((EntityLivingBase) entityPlayer) - OffscreenESP.Field2811.player.rotationYaw;
                GL11.glTranslatef((float) n2, (float) n3, (float) 0.0f);
                GL11.glRotatef((float) f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
                GL11.glTranslatef((float) (-n2), (float) (-n3), (float) 0.0f);
                RenderUtil.Method2163067(n2, n3 - this.Field1514.getValue(), this.Field1515.getValue().floatValue(), 2.0f, 1.0f, this.Field1511.getValue(), this.Field1512.getValue().floatValue(), color.getRGB());
                GL11.glTranslatef((float) n2, (float) n3, (float) 0.0f);
                GL11.glRotatef((float) (-f), (float) 0.0f, (float) 0.0f, (float) 1.0f);
                GL11.glTranslatef((float) (-n2), (float) (-n3), (float) 0.0f);
            }
        }
    }

    private static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        private final Map<Entity, Vec3d> Field3621 = Maps.newHashMap();
        private final Map<Entity, Vec3d> Field3622 = Maps.newHashMap();

        private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
        }

        IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(1var1_1) {
            this();
        }

        static void Method2162610(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2162617();
        }

        private void Method2162617() {
            if (!this.Field3621.isEmpty()) {
                this.Field3621.clear();
            }
            if (!this.Field3622.isEmpty()) {
                this.Field3622.clear();
            }
            for (Entity entity : Util.Field2811.world.loadedEntityList) {
                Vec3d vec3d = this.Method2162618(entity);
                vec3d.add(new Vec3d(0.0, (double) entity.height + 0.2, 0.0));
                Vec3d vec3d2 = RenderUtil.Method2163066(vec3d.x, vec3d.y, vec3d.z);
                Vec3d vec3d3 = RenderUtil.Method2163066(vec3d.x, vec3d.y - 2.0, vec3d.z);
                if (vec3d2 == null || vec3d3 == null) continue;
                this.Field3621.put(entity, vec3d2);
                this.Field3622.put(entity, vec3d3);
            }
        }

        private Vec3d Method2162618(Entity entity) {
            double d = Util.Field2811.timer.renderPartialTicks;
            double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * d - Util.Field2811.getRenderManager().viewerPosX;
            double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * d - Util.Field2811.getRenderManager().viewerPosY;
            double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * d - Util.Field2811.getRenderManager().viewerPosZ;
            return new Vec3d(d2, d3, d4);
        }

        public Map<Entity, Vec3d> Method2162619() {
            return this.Field3622;
        }
    }
}

