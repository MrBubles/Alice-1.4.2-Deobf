

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.primitives.Ints
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.primitives.Ints;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtils;
import me.snow.aclient.mixin.mixins.accessors.IEntityRenderer;
import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Tracers
        extends Module {
    private Setting<Float> Field2070 = this.Method2150366(new Setting<Float>("Width", Float.valueOf(1.3f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    private Setting<Integer> Field2071 = this.Method2150366(new Setting<Integer>("Range", 200, 1, 500));

    public Tracers() {
        super("Tracer", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (Tracers.Field2811.world == null || Tracers.Field2811.player == null) {
            return;
        }
        for (Entity entity : Tracers.Field2811.world.loadedEntityList) {
            if (!(entity instanceof EntityPlayer) || entity == Tracers.Field2811.player || !(Tracers.Field2811.player.getDistance(entity) <= (float) this.Field2071.getValue().intValue()))
                continue;
            Vec3d vec3d = RenderUtils.Method2162948(entity, render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).subtract(((IRenderManager) Field2811.getRenderManager()).getRenderPosX(), ((IRenderManager) Field2811.getRenderManager()).getRenderPosY(), ((IRenderManager) Field2811.getRenderManager()).getRenderPosZ());
            GL11.glBlendFunc((int) 770, (int) 771);
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth((float) this.Field2070.getValue().floatValue());
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
            boolean bl = Tracers.Field2811.gameSettings.viewBobbing;
            Tracers.Field2811.gameSettings.viewBobbing = false;
            ((IEntityRenderer) Tracers.Field2811.entityRenderer).invokeSetupCameraTransform(render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(), 0);
            Vec3d vec3d2 = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float) Math.toRadians(Tracers.Field2811.player.rotationPitch))).rotateYaw(-((float) Math.toRadians(Tracers.Field2811.player.rotationYaw)));
            int n2 = AliceMain.Field765.Method2150168(entity.getName()) ? Color.CYAN.hashCode() : this.Method2162737(entity.getDistance((Entity) Tracers.Field2811.player));
            RenderUtils.Method2162947((float) vec3d2.x, (float) vec3d2.y + Tracers.Field2811.player.getEyeHeight(), (float) vec3d2.z, (float) vec3d.x, (float) vec3d.y, (float) vec3d.z, this.Field2070.getValue().floatValue(), n2);
            RenderUtils.Method2162947((float) vec3d.x, (float) vec3d.y, (float) vec3d.z, (float) vec3d.x, (float) vec3d.y + entity.getEyeHeight(), (float) vec3d.z, this.Field2070.getValue().floatValue(), n2);
            Tracers.Field2811.gameSettings.viewBobbing = bl;
            ((IEntityRenderer) Tracers.Field2811.entityRenderer).invokeSetupCameraTransform(render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(), 0);
            GlStateManager.enableCull();
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
        }
    }

    private float Method2162735(Entity entity) {
        double d = entity.posX - Tracers.Field2811.player.posX;
        double d2 = entity.posZ - Tracers.Field2811.player.posZ;
        return (float) (-(Math.atan2(d, d2) * 57.29577951308232));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean Method2162736(Vec3d vec3d) {
        if (!(vec3d.x > -1.0)) return false;
        if (!(vec3d.y < 1.0)) return false;
        int n2 = Tracers.Field2811.gameSettings.guiScale == 0 ? 1 : Tracers.Field2811.gameSettings.guiScale;
        if (!(vec3d.x / (double) n2 >= 0.0)) return false;
        int n3 = Tracers.Field2811.gameSettings.guiScale == 0 ? 1 : Tracers.Field2811.gameSettings.guiScale;
        if (!(vec3d.x / (double) n3 <= (double) Display.getWidth())) return false;
        int n4 = Tracers.Field2811.gameSettings.guiScale == 0 ? 1 : Tracers.Field2811.gameSettings.guiScale;
        if (!(vec3d.y / (double) n4 >= 0.0)) return false;
        int n5 = Tracers.Field2811.gameSettings.guiScale == 0 ? 1 : Tracers.Field2811.gameSettings.guiScale;
        if (!(vec3d.y / (double) n5 <= (double) Display.getHeight())) return false;
        return true;
    }

    private int Method2162737(float f) {
        int n2 = Ints.constrainToRange((int) ((int) f * 4), (int) 0, (int) 255);
        return new Color(Ints.constrainToRange((int) (255 - n2), (int) 0, (int) 255), Ints.constrainToRange((int) n2, (int) 0, (int) 255), 0).hashCode();
    }
}

