

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Pair;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Trails
        extends Module {
    private final HashMap<UUID, List<Pair<Vec3d, Long>>> Field1654 = new HashMap();
    private final HashMap<UUID, List<Pair<Vec3d, Long>>> Field1655 = new HashMap();
    public Setting<Float> Field1643 = this.Method2150366(new Setting<Float>("Width", Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    public Setting<Float> Field1645 = this.Method2150366(new Setting<Float>("Projectile Fade Time", Float.valueOf(3.0f), Float.valueOf(0.1f), Float.valueOf(30.0f)));
    public Setting<Float> Field1651 = this.Method2150366(new Setting<Float>("Player Fade Time", Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(30.0f)));
    private Setting<Boolean> Field1640 = this.Method2150366(new Setting<Boolean>("Pearls", true));
    private Setting<Boolean> Field1641 = this.Method2150366(new Setting<Boolean>("Arrows", true));
    private Setting<Boolean> Field1642 = this.Method2150366(new Setting<Boolean>("Xp", false));
    private Setting<Boolean> Field1644 = this.Method2150366(new Setting<Boolean>("2d", false));
    private Setting<Boolean> Field1646 = this.Method2150366(new Setting<Boolean>("CSync", false));
    private Setting<Integer> Field1647 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    private Setting<Integer> Field1648 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private Setting<Integer> Field1649 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    private Setting<Integer> Field1650 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));
    private Setting<Boolean> Field1652 = this.Method2150366(new Setting<Boolean>("Players", false));
    private Setting<Boolean> Field1653 = this.Method2150366(new Setting<Boolean>("Self", Boolean.valueOf(false), this::Method2162741));

    public Trails() {
        super("Trails", "Draws Trails.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }

    public static void Method2162738() {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean) false);
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
    }

    public static void Method2162739() {
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GL11.glEnable((int) 2848);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
    }

    public static void Method2162730() {
        GL11.glDisable((int) 2848);
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    public void Method2150379() {
        if (Feature.Method2150359()) {
            return;
        }
        for (Entity entity : Trails.Field2811.world.loadedEntityList) {
            if (entity instanceof EntityEnderPearl && this.Field1640.getValue() != false || entity instanceof EntityArrow && this.Field1641.getValue() != false || entity instanceof EntityExpBottle && this.Field1642.getValue().booleanValue()) {
                if (!this.Field1654.containsKey(entity.getUniqueID())) {
                    this.Field1654.put(entity.getUniqueID(), new ArrayList());
                }
                if (!this.Field1654.get(entity.getUniqueID()).contains((Object) entity.getPositionVector())) {
                    this.Field1654.get(entity.getUniqueID()).add(new Pair<Vec3d, Long>(entity.getPositionVector(), System.currentTimeMillis()));
                }
            }
            if (!(entity instanceof EntityPlayer) || !this.Field1652.getValue().booleanValue() || entity == Trails.Field2811.player && !this.Field1653.getValue().booleanValue())
                continue;
            if (!this.Field1655.containsKey(entity.getUniqueID())) {
                this.Field1655.put(entity.getUniqueID(), new ArrayList());
            }
            if (this.Field1655.get(entity.getUniqueID()).contains((Object) entity.getPositionVector())) continue;
            this.Field1655.get(entity.getUniqueID()).add(new Pair<Vec3d, Long>(entity.getPositionVector(), System.currentTimeMillis()));
        }
    }

    @Override
    @SubscribeEvent
    public void Method2150381(Render3DEvent render3DEvent) {
        float f;
        long l2;
        int n2;
        Color color = this.Field1646.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field1647.getValue(), this.Field1648.getValue(), this.Field1649.getValue(), this.Field1650.getValue());
        IRenderManager iRenderManager = (IRenderManager) Field2811.getRenderManager();
        Trails.Method2162738();
        for (Map.Entry<UUID, List<Pair<Vec3d, Long>>> entry : this.Field1654.entrySet()) {
            GL11.glLineWidth((float) this.Field1643.getValue().floatValue());
            GL11.glBegin((int) 1);
            for (n2 = 1; n2 < entry.getValue().size(); ++n2) {
                l2 = System.currentTimeMillis() - entry.getValue().get(n2).Method2163633();
                f = (float) this.Field1650.getValue().intValue() / 255.0f - (float) l2 / (this.Field1645.getValue().floatValue() * 1000.0f) * (float) this.Field1650.getValue().intValue() / 255.0f;
                GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) f);
                GL11.glVertex3d((double) (entry.getValue().get((int) n2).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) n2).Method2163631().y - iRenderManager.getRenderPosY()), (double) (entry.getValue().get((int) n2).Method2163631().z - iRenderManager.getRenderPosZ()));
                GL11.glVertex3d((double) (entry.getValue().get((int) (n2 - 1)).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().y - iRenderManager.getRenderPosY()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().z - iRenderManager.getRenderPosZ()));
            }
            for (n2 = 0; n2 < entry.getValue().size(); ++n2) {
                if (!((float) (System.currentTimeMillis() - entry.getValue().get(n2).Method2163633()) >= this.Field1645.getValue().floatValue() * 1000.0f))
                    continue;
                this.Field1654.get(entry.getKey()).remove(n2);
            }
            GL11.glEnd();
        }
        Trails.Method2162730();
        Trails.Method2162738();
        for (Map.Entry<UUID, List<Pair<Vec3d, Long>>> entry : this.Field1655.entrySet()) {
            if (!this.Field1644.getValue().booleanValue()) {
                GL11.glLineWidth((float) this.Field1643.getValue().floatValue());
                GL11.glBegin((int) 1);
                for (n2 = 1; n2 < entry.getValue().size(); ++n2) {
                    l2 = System.currentTimeMillis() - entry.getValue().get(n2).Method2163633();
                    f = (float) this.Field1650.getValue().intValue() / 255.0f - (float) l2 / (this.Field1651.getValue().floatValue() * 1000.0f) * (float) this.Field1650.getValue().intValue() / 255.0f;
                    GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) f);
                    GL11.glVertex3d((double) (entry.getValue().get((int) n2).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) n2).Method2163631().y - iRenderManager.getRenderPosY()), (double) (entry.getValue().get((int) n2).Method2163631().z - iRenderManager.getRenderPosZ()));
                    GL11.glVertex3d((double) (entry.getValue().get((int) (n2 - 1)).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().y - iRenderManager.getRenderPosY()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().z - iRenderManager.getRenderPosZ()));
                }
                for (n2 = 0; n2 < entry.getValue().size(); ++n2) {
                    if (!((float) (System.currentTimeMillis() - entry.getValue().get(n2).Method2163633()) >= this.Field1651.getValue().floatValue() * 1000.0f))
                        continue;
                    this.Field1655.get(entry.getKey()).remove(n2);
                }
                GL11.glEnd();
                continue;
            }
            GL11.glBegin((int) 8);
            for (n2 = 1; n2 < entry.getValue().size(); ++n2) {
                l2 = System.currentTimeMillis() - entry.getValue().get(n2).Method2163633();
                f = (float) this.Field1650.getValue().intValue() / 255.0f - (float) l2 / (this.Field1651.getValue().floatValue() * 1000.0f) * (float) this.Field1650.getValue().intValue() / 255.0f;
                GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) f);
                GL11.glVertex3d((double) (entry.getValue().get((int) n2).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) n2).Method2163631().y - iRenderManager.getRenderPosY()), (double) (entry.getValue().get((int) n2).Method2163631().z - iRenderManager.getRenderPosZ()));
                GL11.glVertex3d((double) (entry.getValue().get((int) n2).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) n2).Method2163631().y - iRenderManager.getRenderPosY() + 1.8), (double) (entry.getValue().get((int) n2).Method2163631().z - iRenderManager.getRenderPosZ()));
                GL11.glVertex3d((double) (entry.getValue().get((int) (n2 - 1)).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().y - iRenderManager.getRenderPosY()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().z - iRenderManager.getRenderPosZ()));
                GL11.glVertex3d((double) (entry.getValue().get((int) (n2 - 1)).Method2163631().x - iRenderManager.getRenderPosX()), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().y - iRenderManager.getRenderPosY() + 1.8), (double) (entry.getValue().get((int) (n2 - 1)).Method2163631().z - iRenderManager.getRenderPosZ()));
            }
            for (n2 = 0; n2 < entry.getValue().size(); ++n2) {
                if (!((float) (System.currentTimeMillis() - entry.getValue().get(n2).Method2163633()) >= this.Field1651.getValue().floatValue() * 1000.0f))
                    continue;
                this.Field1655.get(entry.getKey()).remove(n2);
            }
            GL11.glEnd();
        }
        Trails.Method2162730();
    }

    private boolean Method2162741(Boolean bl) {
        return this.Field1652.getValue();
    }
}

