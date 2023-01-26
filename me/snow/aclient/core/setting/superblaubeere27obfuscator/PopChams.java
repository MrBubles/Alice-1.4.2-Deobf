

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.authlib.GameProfile;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NordTessellator;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TotemPopCham;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class PopChams
        extends Module {
    public static PopChams Field3829;
    public Setting<Boolean> Field3830 = this.Method2150366(new Setting<Boolean>("SelfPop", false));
    public Setting<Boolean> Field3831 = this.Method2150366(new Setting<Boolean>("GlobalColor", false));
    public Setting<Integer> Field3832 = this.Method2150366(new Setting<Integer>("OutLine-Red", 255, 0, 255));
    public Setting<Integer> Field3833 = this.Method2150366(new Setting<Integer>("OutLine-Green", 0, 0, 255));
    public Setting<Integer> Field3834 = this.Method2150366(new Setting<Integer>("OutLine-Blue", 0, 0, 255));
    public Setting<Integer> Field3835 = this.Method2150366(new Setting<Integer>("Fill-Red", 255, 0, 255));
    public Setting<Integer> Field3836 = this.Method2150366(new Setting<Integer>("Fill-Green", 0, 0, 255));
    public Setting<Integer> Field3837 = this.Method2150366(new Setting<Integer>("Fill-Blue", 0, 0, 255));
    public Setting<Integer> Field3839 = this.Method2150366(new Setting<Integer>("FadeStart", 800, 0, 3000));
    public Setting<Double> Field3840 = this.Method2150366(new Setting<Integer>("FadeTime", (Integer) 0.8, 0, 2));
    public Setting<Integer> Field3841 = this.Method2150366(new Setting<Integer>("FillAlpha", 120, 0, 255));
    public Setting<Integer> Field3842 = this.Method2150366(new Setting<Integer>("OutLineAlpha", 140, 0, 255));
    public Setting<Boolean> Field3843 = this.Method2150366(new Setting<Boolean>("OnlyOneEsp", true));
    EntityOtherPlayerMP Field3844;
    ModelPlayer Field3845;
    Long Field3846;
    double Field3847;
    double Field3848;
    private Setting<Boolean> Field3838 = this.Method2150366(new Setting<Boolean>("Preset", false));

    public PopChams() {
        super("PopChams", "Renders when some1 pops", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
        Field3829 = this;
    }

    public static void Method2162628(EntityLivingBase entityLivingBase, ModelBase modelBase, float f, float f2, float f3, float f4, float f5, float f6) {
        if (Field2811.getRenderManager() == null) {
            return;
        }
        float f7 = Field2811.getRenderPartialTicks();
        double d = entityLivingBase.posX - PopChams.Field2811.getRenderManager().viewerPosX;
        double d2 = entityLivingBase.posY - PopChams.Field2811.getRenderManager().viewerPosY;
        double d3 = entityLivingBase.posZ - PopChams.Field2811.getRenderManager().viewerPosZ;
        GlStateManager.pushMatrix();
        if (entityLivingBase.isSneaking()) {
            d2 -= 0.125;
        }
        float f8 = PopChams.Method2162633(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f7);
        float f9 = PopChams.Method2162633(entityLivingBase.prevRotationYawHead, entityLivingBase.rotationYawHead, f7);
        float f10 = f9 - f8;
        float f11 = entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f7;
        PopChams.Method2162620(d, d2, d3);
        float f12 = PopChams.Method2162636(entityLivingBase, f7);
        PopChams.Method2162632(entityLivingBase);
        float f13 = PopChams.Method2162631(entityLivingBase, f6);
        GlStateManager.enableAlpha();
        modelBase.setLivingAnimations(entityLivingBase, f, f2, f7);
        modelBase.setRotationAngles(f, f2, f12, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch, f13, (Entity) entityLivingBase);
        modelBase.render((Entity) entityLivingBase, f, f2, f12, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch, f13);
        GlStateManager.popMatrix();
    }

    public static void Method2162629(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        PopChams.Method2162620(d - PopChams.Field2811.getRenderManager().viewerPosX, d2 - PopChams.Field2811.getRenderManager().viewerPosY, d3 - PopChams.Field2811.getRenderManager().viewerPosZ);
    }

    public static void Method2162620(double d, double d2, double d3) {
        GlStateManager.translate((float) ((float) d), (float) ((float) d2), (float) ((float) d3));
    }

    public static float Method2162631(EntityLivingBase entityLivingBase, float f) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale((float) -1.0f, (float) -1.0f, (float) 1.0f);
        double d = entityLivingBase.getRenderBoundingBox().maxX - entityLivingBase.getRenderBoundingBox().minX;
        double d2 = entityLivingBase.getRenderBoundingBox().maxZ - entityLivingBase.getRenderBoundingBox().minZ;
        GlStateManager.scale((double) ((double) f + d), (double) (f * entityLivingBase.height), (double) ((double) f + d2));
        float f2 = 0.0625f;
        GlStateManager.translate((float) 0.0f, (float) -1.501f, (float) 0.0f);
        return 0.0625f;
    }

    public static void Method2162632(EntityLivingBase entityLivingBase) {
        GlStateManager.rotate((float) (180.0f - entityLivingBase.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
    }

    public static float Method2162633(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public static Color Method2162634(Color color, int n2) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n2);
    }

    public static void Method2162635(Color color) {
        GL11.glColor4f((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
    }

    public static float Method2162636(EntityLivingBase entityLivingBase, float f) {
        return 0.0f;
    }

    @Override
    public void Method2150376() {
        if (this.Field3838.getValue().booleanValue()) {
            this.Field3839.setValue(800);
            this.Field3840.setValue(0.8);
            this.Field3841.setValue(120);
            this.Field3842.setValue(140);
            this.Field3838.setValue(false);
        }
    }

    @SubscribeEvent
    public void Method2162625(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketEntityStatus sPacketEntityStatus;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityStatus && (sPacketEntityStatus = (SPacketEntityStatus) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getOpCode() == 35 && sPacketEntityStatus.getEntity((World) PopChams.Field2811.world) != null && (this.Field3830.getValue().booleanValue() || sPacketEntityStatus.getEntity((World) PopChams.Field2811.world).getEntityId() != PopChams.Field2811.player.getEntityId())) {
            GameProfile gameProfile = new GameProfile(PopChams.Field2811.player.getUniqueID(), "");
            this.Field3844 = new EntityOtherPlayerMP((World) PopChams.Field2811.world, gameProfile);
            this.Field3844.copyLocationAndAnglesFrom(sPacketEntityStatus.getEntity((World) PopChams.Field2811.world));
            this.Field3845 = new ModelPlayer(0.0f, false);
            this.Field3846 = System.currentTimeMillis();
            this.Field3845.bipedHead.showModel = false;
            this.Field3845.bipedBody.showModel = false;
            this.Field3845.bipedLeftArmwear.showModel = false;
            this.Field3845.bipedLeftLegwear.showModel = false;
            this.Field3845.bipedRightArmwear.showModel = false;
            this.Field3845.bipedRightLegwear.showModel = false;
            this.Field3847 = this.Field3841.getValue().intValue();
            this.Field3848 = this.Field3842.getValue().intValue();
            if (!this.Field3843.getValue().booleanValue()) {
                TotemPopCham totemPopCham = new TotemPopCham(this.Field3844, this.Field3845, this.Field3846, this.Field3847, this.Field3848);
            }
        }
    }

    @SubscribeEvent
    public void Method2162626(RenderWorldLastEvent renderWorldLastEvent) {
        if (this.Field3843.getValue().booleanValue()) {
            if (this.Field3844 == null || PopChams.Field2811.world == null || PopChams.Field2811.player == null) {
                return;
            }
            GL11.glLineWidth((float) 1.0f);
            Color color = this.Field3831.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3832.getValue(), this.Field3833.getValue(), this.Field3834.getValue(), this.Field3842.getValue());
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field3842.getValue());
            Color color3 = this.Field3831.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3835.getValue(), this.Field3836.getValue(), this.Field3837.getValue(), this.Field3841.getValue());
            Color color4 = new Color(color3.getRed(), color3.getGreen(), color3.getBlue(), this.Field3841.getValue());
            int n2 = color2.getAlpha();
            int n3 = color4.getAlpha();
            long l2 = System.currentTimeMillis() - this.Field3846 - ((Number) this.Field3839.getValue()).longValue();
            if (System.currentTimeMillis() - this.Field3846 > ((Number) this.Field3839.getValue()).longValue()) {
                double d = this.Method2162627(l2, 0.0, ((Number) this.Field3840.getValue()).doubleValue());
                d = MathHelper.clamp((double) d, (double) 0.0, (double) 1.0);
                d = -d + 1.0;
                n2 *= (int) d;
                n3 *= (int) d;
            }
            Color color5 = PopChams.Method2162634(color2, n2);
            Color color6 = PopChams.Method2162634(color4, n3);
            if (this.Field3844 != null && this.Field3845 != null) {
                NordTessellator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
                GL11.glPushAttrib((int) 1048575);
                GL11.glEnable((int) 2881);
                GL11.glEnable((int) 2848);
                if (this.Field3847 > 1.0) {
                    this.Field3847 -= this.Field3840.getValue().doubleValue();
                }
                Color color7 = new Color(color6.getRed(), color6.getGreen(), color6.getBlue(), (int) this.Field3847);
                if (this.Field3848 > 1.0) {
                    this.Field3848 -= this.Field3840.getValue().doubleValue();
                }
                Color color8 = new Color(color5.getRed(), color5.getGreen(), color5.getBlue(), (int) this.Field3848);
                PopChams.Method2162635(color7);
                GL11.glPolygonMode((int) 1032, (int) 6914);
                PopChams.Method2162628((EntityLivingBase) this.Field3844, (ModelBase) this.Field3845, this.Field3844.limbSwing, this.Field3844.limbSwingAmount, this.Field3844.ticksExisted, this.Field3844.rotationYawHead, this.Field3844.rotationPitch, 1.0f);
                PopChams.Method2162635(color8);
                GL11.glPolygonMode((int) 1032, (int) 6913);
                PopChams.Method2162628((EntityLivingBase) this.Field3844, (ModelBase) this.Field3845, this.Field3844.limbSwing, this.Field3844.limbSwingAmount, this.Field3844.ticksExisted, this.Field3844.rotationYawHead, this.Field3844.rotationPitch, 1.0f);
                GL11.glPolygonMode((int) 1032, (int) 6914);
                GL11.glPopAttrib();
                NordTessellator.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll();
            }
        }
    }

    double Method2162627(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }
}

