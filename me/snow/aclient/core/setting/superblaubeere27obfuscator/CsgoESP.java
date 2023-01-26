

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiTessellator;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class CsgoESP
        extends Module {
    private final Setting<Boolean> Field3660 = this.Method2150366(new Setting<Boolean>("Players", true));
    private final Setting<Boolean> Field3661 = this.Method2150366(new Setting<Boolean>("Animals", true));
    private final Setting<Boolean> Field3662 = this.Method2150366(new Setting<Boolean>("Monsters", false));
    private final Setting<Boolean> Field3663 = this.Method2150366(new Setting<Boolean>("Items", false));
    private final Setting<Boolean> Field3664 = this.Method2150366(new Setting<Boolean>("XpBottles", false));
    private final Setting<Boolean> Field3665 = this.Method2150366(new Setting<Boolean>("Crystals", true));
    private final Setting<Boolean> Field3666 = this.Method2150366(new Setting<Boolean>("XpOrbs", false));
    private final Setting<Integer> Field3667 = this.Method2150366(new Setting<Integer>("LineWidth", 1, 1, 8));
    private final Setting<Integer> Field3668 = this.Method2150366(new Setting<Integer>("Player Red", 255, 0, 255));
    private final Setting<Integer> Field3669 = this.Method2150366(new Setting<Integer>("Player Green", 255, 0, 255));
    private final Setting<Integer> Field3670 = this.Method2150366(new Setting<Integer>("Player Blue", 255, 0, 255));
    private final Setting<Integer> Field3671 = this.Method2150366(new Setting<Integer>("Player Alpha", 255, 0, 255));
    private final Setting<Integer> Field3672 = this.Method2150366(new Setting<Integer>("Other Red", 255, 0, 255));
    private final Setting<Integer> Field3673 = this.Method2150366(new Setting<Integer>("Other Green", 255, 0, 255));
    private final Setting<Integer> Field3674 = this.Method2150366(new Setting<Integer>("Other Blue", 255, 0, 255));
    private final Setting<Integer> Field3675 = this.Method2150366(new Setting<Integer>("Other Alpha", 255, 0, 255));

    public CsgoESP() {
        super("CsgoESP", "Renders a nice ESP.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
    }

    public static boolean Method2162375(Entity entity) {
        return (!(entity instanceof EntityWolf) || !((EntityWolf) entity).isAngry()) && (entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid || entity instanceof EntityIronGolem && ((EntityIronGolem) entity).getRevengeTarget() == null);
    }

    public static boolean Method2162376(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.MONSTER, false);
    }

    private static boolean Method2162377(Entity entity) {
        return CsgoESP.Field2811.player != entity;
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (CsgoESP.Field2811.getRenderManager().options == null) {
            return;
        }
        boolean bl = CsgoESP.Field2811.getRenderManager().options.thirdPersonView == 2;
        float f = CsgoESP.Field2811.getRenderManager().playerViewY;
        for (Entity entity : CsgoESP.Field2811.world.loadedEntityList.stream().filter(CsgoESP::Method2162377).collect(Collectors.toList())) {
            LuigiTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
            GlStateManager.pushMatrix();
            Vec3d vec3d = EntityUtil.Method2163493(entity, render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            GlStateManager.translate((double) (vec3d.x - CsgoESP.Field2811.getRenderManager().renderPosX), (double) (vec3d.y - CsgoESP.Field2811.getRenderManager().renderPosY), (double) (vec3d.z - CsgoESP.Field2811.getRenderManager().renderPosZ));
            GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
            GlStateManager.rotate((float) (-f), (float) 0.0f, (float) 1.0f, (float) 0.0f);
            GlStateManager.rotate((float) (bl ? -1 : 1), (float) 1.0f, (float) 0.0f, (float) 0.0f);
            GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 0.5f);
            GL11.glLineWidth((float) ((float) this.Field3667.getValue().intValue() * 6.0f / CsgoESP.Field2811.player.getDistance(entity)));
            GL11.glEnable((int) 2848);
            if (entity instanceof EntityPlayer && this.Field3660.getValue().booleanValue()) {
                if (AliceMain.Field765.Method2150168(entity.getName())) {
                    GL11.glColor4f((float) 0.0f, (float) 1.0f, (float) 1.0f, (float) 0.7f);
                } else {
                    GL11.glColor4f((float) ((float) this.Field3668.getValue().intValue() / 255.0f), (float) (this.Field3669.getValue().floatValue() / 255.0f), (float) (this.Field3670.getValue().floatValue() / 255.0f), (float) (this.Field3671.getValue().floatValue() / 255.0f));
                }
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            GL11.glColor4f((float) ((float) this.Field3672.getValue().intValue() / 255.0f), (float) ((float) this.Field3673.getValue().intValue() / 255.0f), (float) ((float) this.Field3674.getValue().intValue() / 255.0f), (float) ((float) this.Field3675.getValue().intValue() / 255.0f));
            if (CsgoESP.Method2162375(entity) && this.Field3661.getValue().booleanValue()) {
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            if (CsgoESP.Method2162376(entity) && this.Field3662.getValue().booleanValue()) {
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            if (entity instanceof EntityItem && this.Field3663.getValue().booleanValue()) {
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            if (entity instanceof EntityExpBottle && this.Field3664.getValue().booleanValue()) {
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) entity.height);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f), (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) 0.0);
                GL11.glVertex2d((double) entity.width, (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            if (entity instanceof EntityEnderCrystal && this.Field3665.getValue().booleanValue()) {
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f / 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            if (entity instanceof EntityXPOrb && this.Field3666.getValue().booleanValue()) {
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) (entity.height / 3.0f));
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f / 2.0f), (double) 0.0);
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 3.0f * 2.0f / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (-entity.width / 2.0f), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) entity.height);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) (entity.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int) 2);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 3.0f * 2.0f / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) 0.0);
                GL11.glVertex2d((double) (entity.width / 2.0f), (double) (entity.height / 3.0f));
                GL11.glEnd();
            }
            LuigiTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
            GlStateManager.popMatrix();
        }
        GL11.glColor4f((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
    }
}

