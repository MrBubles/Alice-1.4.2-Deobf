

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlIIIlIIllIIIlIIllIIIllIlllIIllIIIlllIllIIllIIIllIlIllIIllIIllIIIllIIllIIlllIIIlllIIIlIllIllIIlIIlllIIIlllIlllIIlIIIlIIlllIIIlIIIlllIIllIIlIIlIIIlllIIlIIllIlllIIllIlIlIIllIIlIIlIIlIIllIIlllIIIllIlIIIllIIIllIIIllIIIlIIlIIllIIIlIlllIllIIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlIIlllIIlllIIllIIIlllIllIIIlIllIIllIllIIlIIlllIIlllIlIIIlllIIllIIllIIlllIllIIIllIlIIIllIlllIlIlllIllIIIlIlllIlllIIIllIIIlIllIIlllIIllIIllIllIIlllIIlllIIlIIlllIIIllIIlIIIlIllIlIlllIlllIIIlIIllIlIlllIIlIlllIlIIlllIIlllIIIlllIllIIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ad
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.ak
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.cp
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.RenderLivingEvent$Post
 *  net.minecraftforge.client.event.RenderLivingEvent$Pre
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.mixin.mixins;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.util.List;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlIIIlIIllIIIlIIllIIIllIlllIIllIIIlllIllIIllIIIllIlIllIIllIIllIIIllIIllIIlllIIIlllIIIlIllIllIIlIIlllIIIlllIlllIIlIIIlIIlllIIIlIIIlllIIllIIlIIlIIIlllIIlIIllIlllIIllIlIlIIllIIlIIlIIlIIllIIlllIIIllIlIIIllIIIllIIIllIIIlIIlIIllIIIlIlllIllIIIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlIIlllIIlllIIllIIIlllIllIIIlIllIIllIllIIlIIlllIIlllIlIIIlllIIllIIllIIlllIllIIIllIlIIIllIlllIlIlllIllIIIlIlllIlllIIIllIIIlIllIIlllIIllIIllIllIIlllIIlllIIlIIlllIIIllIIlIIIlIllIlIlllIlllIIIlIIllIlIlllIIlIlllIlIIlllIIlllIIIlllIllIIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ad;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ak;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.cp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={RenderLivingBase.class})
public abstract class MixinRenderLivingBase<T extends EntityLivingBase>
extends Render<T> {
    private static final ResourceLocation glint = new ResourceLocation("textures/shinechams.png");
    float red;
    float green;
    float blue;
    @Shadow
    private static final Logger LOGGER = LogManager.getLogger();
    @Shadow
    private static final DynamicTexture TEXTURE_BRIGHTNESS = new DynamicTexture(16, 16);
    @Shadow
    protected ModelBase mainModel;
    @Shadow
    protected FloatBuffer brightnessBuffer;
    @Shadow
    protected List layerRenderers;
    @Shadow
    protected boolean renderMarker;
    @Shadow
    public static float NAME_TAG_RANGE = 64.0f;
    @Shadow
    public static float NAME_TAG_RANGE_SNEAK = 32.0f;

    protected MixinRenderLivingBase(RenderManager renderManager) {
        super(renderManager);
    }

    @Overwrite
    public void doRender(T entity, double x2, double y, double z, float entityYaw, float partialTicks) {
        boolean isRiding;
        Color color;
        if (!MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Pre(entity, (RenderLivingBase)RenderLivingBase.class.cast((Object)this), partialTicks, x2, y, z))) {
            boolean shouldSit;
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
            this.mainModel.isRiding = shouldSit = entity.isRiding() && entity.getRidingEntity() != null && entity.getRidingEntity().shouldRiderSit();
            this.mainModel.isChild = entity.isChild();
            try {
                boolean flag1;
                float f = this.interpolateRotation(((EntityLivingBase)entity).prevRenderYawOffset, ((EntityLivingBase)entity).renderYawOffset, partialTicks);
                float f1 = this.interpolateRotation(((EntityLivingBase)entity).prevRotationYawHead, ((EntityLivingBase)entity).rotationYawHead, partialTicks);
                float f2 = f1 - f;
                if (shouldSit && entity.getRidingEntity() instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)entity.getRidingEntity();
                    f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
                    f2 = f1 - f;
                    float f3 = MathHelper.wrapDegrees((float)f2);
                    if (f3 < -85.0f) {
                        f3 = -85.0f;
                    }
                    if (f3 >= 85.0f) {
                        f3 = 85.0f;
                    }
                    f = f1 - f3;
                    if (f3 * f3 > 2500.0f) {
                        f += f3 * 0.2f;
                    }
                    f2 = f1 - f;
                }
                float f7 = ((EntityLivingBase)entity).prevRotationPitch + (((EntityLivingBase)entity).rotationPitch - ((EntityLivingBase)entity).prevRotationPitch) * partialTicks;
                this.renderLivingAt(entity, x2, y, z);
                float f8 = this.handleRotationFloat(entity, partialTicks);
                this.applyRotations(entity, f8, f, partialTicks);
                float f4 = this.prepareScale(entity, partialTicks);
                float f5 = 0.0f;
                float f6 = 0.0f;
                if (!entity.isRiding()) {
                    f5 = ((EntityLivingBase)entity).prevLimbSwingAmount + (((EntityLivingBase)entity).limbSwingAmount - ((EntityLivingBase)entity).prevLimbSwingAmount) * partialTicks;
                    f6 = ((EntityLivingBase)entity).limbSwing - ((EntityLivingBase)entity).limbSwingAmount * (1.0f - partialTicks);
                    if (entity.isChild()) {
                        f6 *= 3.0f;
                    }
                    if (f5 > 1.0f) {
                        f5 = 1.0f;
                    }
                    f2 = f1 - f;
                }
                GlStateManager.enableAlpha();
                this.mainModel.setLivingAnimations(entity, f6, f5, partialTicks);
                this.mainModel.setRotationAngles(f6, f5, f8, f2, f7, f4, entity);
                if (this.renderOutlines) {
                    flag1 = this.setScoreTeamColor(entity);
                    GlStateManager.enableColorMaterial();
                    GlStateManager.enableOutlineMode((int)this.getTeamColor((Entity)entity));
                    if (!this.renderMarker) {
                        this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                    }
                    if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).isSpectator()) {
                        this.renderLayers(entity, f6, f5, partialTicks, f8, f2, f7, f4);
                    }
                    GlStateManager.disableOutlineMode();
                    GlStateManager.disableColorMaterial();
                    if (flag1) {
                        this.unsetScoreTeamColor();
                    }
                } else {
                    if (ad.Method2162352().Method2150386() && entity instanceof EntityPlayer && ((Boolean)ad.Method2162352().IIllIIlIlIIlllIIllIIllIIIlllIIIlllIllIIllIIlllIlIIllIIllIllIIlIIllIIlIlllIIIlIIlIllIIIllIIIlllIIlIIIlllIIIlllIIlIllIIIllIIlIlIllIlIIllIlIIIlllIIllIIlIIIlIIlIIlIlIlllIlIIIlIIlIIlllIllIllIllIIIlllIIllIIIllIIllIIlllIIlIllIlIIll.getValue()).booleanValue()) {
                        Color cc = (Boolean)ad.Method2162352().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue() != false ? IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150586() : new Color((Integer)ad.Method2162352().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue(), (Integer)ad.Method2162352().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue(), (Integer)ad.Method2162352().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue(), ((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).intValue());
                        GlStateManager.pushMatrix();
                        GL11.glPushAttrib((int)1048575);
                        GL11.glDisable((int)3553);
                        GL11.glDisable((int)2896);
                        GL11.glEnable((int)2848);
                        GL11.glEnable((int)3042);
                        GL11.glBlendFunc((int)770, (int)771);
                        GL11.glDisable((int)2929);
                        GL11.glDepthMask((boolean)false);
                        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.Method2150168(entity.getName()) || entity == Minecraft.getMinecraft().player) {
                            GL11.glColor4f((float)((float)((Integer)ad.Method2162352().IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.getValue()).intValue() / 255.0f), (float)((float)((Integer)ad.Method2162352().IlIllIIlllIIlllIIlllIIIllIIIllIIlllIlIIllIllIIIllIlIIlllIlIIlIIllIllIlIIlIllIIIllIIllIIIllIllIlIIIlllIIIlIIlllIIlIIIlllIIIllIIIllIIlllIIllIIlIIIllIIllIIlllIIllIlIllIIllIIllIllIIIllIIllIIlIIIlIIlllIIIlIIlllIIlIIIllIlIlllIlIllIIlIIIll.getValue()).intValue() / 255.0f), (float)((float)((Integer)ad.Method2162352().IIlIllIlIIllIllIIlIIIllIIlIIllIIlIllIlIllIllIIlIIlIlllIllIllIlllIIIlIIlIIIlIIlllIIlllIIlIIlIIIllIIlllIllIIIlIllIIlllIlIIlllIIlllIllIIlIIlIllIlllIllIllIIlIllIIIlIIlllIIllIIllIllIIlllIlIIlIllIIllIlIIllIIllIIIlllIll.getValue()).intValue() / 255.0f), (float)(((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).floatValue() / 255.0f));
                        } else {
                            GL11.glColor4f((float)((float)cc.getRed() / 255.0f), (float)((float)cc.getGreen() / 255.0f), (float)((float)cc.getBlue() / 255.0f), (float)(((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).floatValue() / 255.0f));
                        }
                        this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                        GL11.glDisable((int)2896);
                        GL11.glEnable((int)2929);
                        GL11.glDepthMask((boolean)true);
                        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.Method2150168(entity.getName()) || entity == Minecraft.getMinecraft().player) {
                            GL11.glColor4f((float)((float)((Integer)ad.Method2162352().IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.getValue()).intValue() / 255.0f), (float)((float)((Integer)ad.Method2162352().IlIllIIlllIIlllIIlllIIIllIIIllIIlllIlIIllIllIIIllIlIIlllIlIIlIIllIllIlIIlIllIIIllIIllIIIllIllIlIIIlllIIIlIIlllIIlIIIlllIIIllIIIllIIlllIIllIIlIIIllIIllIIlllIIllIlIllIIllIIllIllIIIllIIllIIlIIIlIIlllIIIlIIlllIIlIIIllIlIlllIlIllIIlIIIll.getValue()).intValue() / 255.0f), (float)((float)((Integer)ad.Method2162352().IIlIllIlIIllIllIIlIIIllIIlIIllIIlIllIlIllIllIIlIIlIlllIllIllIlllIIIlIIlIIIlIIlllIIlllIIlIIlIIIllIIlllIllIIIlIllIIlllIlIIlllIIlllIllIIlIIlIllIlllIllIllIIlIllIIIlIIlllIIllIIllIllIIlllIlIIlIllIIllIlIIllIIllIIIlllIll.getValue()).intValue() / 255.0f), (float)(((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).floatValue() / 255.0f));
                        } else {
                            GL11.glColor4f((float)((float)cc.getRed() / 255.0f), (float)((float)cc.getGreen() / 255.0f), (float)((float)cc.getBlue() / 255.0f), (float)(((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).floatValue() / 255.0f));
                        }
                        this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                        GL11.glEnable((int)2896);
                        GlStateManager.popAttrib();
                        GlStateManager.popMatrix();
                    }
                    flag1 = this.setDoRenderBrightness(entity, partialTicks);
                    if (!(entity instanceof EntityPlayer) || ad.Method2162352().Method2150386() && ((Boolean)ad.Method2162352().IIllIIIlllIIIllIIIllIIlIIllIIllIIIlllIIlIIIllIIllIIIlIIIlllIIlllIIlllIIllIIlIlllIlllIlIlIlllIllIIIllIIIllIlIlIllIlIllIIlllIllIlIIlIIIlIlIIllIlllIIlIllIIIlIlllIIllIllIIlIIlllIIlllIIIllIIllIlllIIlIlIIIllIIllIIIlIIIllIIllIIllIIIlllIIll.getValue()).booleanValue() && ((Boolean)ad.Method2162352().IIlIIlIllIIllIIllIIIlIIIlllIIIlIIlllIIIlIIllIIlIIlIIllIIIllIlllIIIlllIIlIlIIIllIIlllIIlIlllIIllIIlIIllIIlIllIllIIlIIllIIllIIllIIlllIIlIIllIlIIllIlIIllIlllIllIlllIIIlIIllIIlllIlIllIIlIllIIlIIllIIIllIllIIlIIIlIllIllIlllIll.getValue()).booleanValue() || ad.Method2162352().Method2150387()) {
                        this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                    }
                    if (flag1) {
                        this.unsetBrightness();
                    }
                    GlStateManager.depthMask((boolean)true);
                    if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).isSpectator()) {
                        this.renderLayers(entity, f6, f5, partialTicks, f8, f2, f7, f4);
                    }
                    if (ad.Method2162352().Method2150386() && entity instanceof EntityPlayer && ((Boolean)ad.Method2162352().IIllIIIlllIIIllIIIllIIlIIllIIllIIIlllIIlIIIllIIllIIIlIIIlllIIlllIIlllIIllIIlIlllIlllIlIlIlllIllIIIllIIIllIlIlIllIlIllIIlllIllIlIIlIIIlIlIIllIlllIIlIllIIIlIlllIIllIllIIlIIlllIIlllIIIllIIllIlllIIlIlIIIllIIllIIIlIIIllIIllIIllIIIlllIIll.getValue()).booleanValue()) {
                        Color cc = (Boolean)ad.Method2162352().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue() != false ? IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150586() : new Color((Integer)ad.Method2162352().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue(), (Integer)ad.Method2162352().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue(), (Integer)ad.Method2162352().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue(), ((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).intValue());
                        GlStateManager.pushMatrix();
                        GL11.glPushAttrib((int)1048575);
                        GL11.glPolygonMode((int)1032, (int)6913);
                        GL11.glDisable((int)3553);
                        GL11.glDisable((int)2896);
                        GL11.glDisable((int)2929);
                        GL11.glEnable((int)2848);
                        GL11.glEnable((int)3042);
                        GL11.glBlendFunc((int)770, (int)771);
                        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.Method2150168(entity.getName()) || entity == Minecraft.getMinecraft().player) {
                            GL11.glColor4f((float)((float)((Integer)ad.Method2162352().IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.getValue()).intValue() / 255.0f), (float)((float)((Integer)ad.Method2162352().IlIllIIlllIIlllIIlllIIIllIIIllIIlllIlIIllIllIIIllIlIIlllIlIIlIIllIllIlIIlIllIIIllIIllIIIllIllIlIIIlllIIIlIIlllIIlIIIlllIIIllIIIllIIlllIIllIIlIIIllIIllIIlllIIllIlIllIIllIIllIllIIIllIIllIIlIIIlIIlllIIIlIIlllIIlIIIllIlIlllIlIllIIlIIIll.getValue()).intValue() / 255.0f), (float)((float)((Integer)ad.Method2162352().IIlIllIlIIllIllIIlIIIllIIlIIllIIlIllIlIllIllIIlIIlIlllIllIllIlllIIIlIIlIIIlIIlllIIlllIIlIIlIIIllIIlllIllIIIlIllIIlllIlIIlllIIlllIllIIlIIlIllIlllIllIllIIlIllIIIlIIlllIIllIIllIllIIlllIlIIlIllIIllIlIIllIIllIIIlllIll.getValue()).intValue() / 255.0f), (float)(((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).floatValue() / 255.0f));
                        } else {
                            GL11.glColor4f((float)((float)cc.getRed() / 255.0f), (float)((float)cc.getGreen() / 255.0f), (float)((float)cc.getBlue() / 255.0f), (float)(((Float)ad.Method2162352().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).floatValue() / 255.0f));
                        }
                        GL11.glLineWidth((float)((Float)ad.Method2162352().IllIlllIIllIIlIIlIlIIIllIIllIIlllIIIlIIlIIlllIIlIlIIIlIlIIIlIIllIlllIIIlllIIllIllIllIIlllIlIllIIlIlIIIlIlIlllIIIlIlllIIlIIllIIlIIllIllIIllIlllIIIllIllIlIIIllIIllIIllIIlIIIlIIlIlIIIllIIllIllIlllIIIllIIIllIIIlllIIlIIIlIlll.getValue()).floatValue());
                        this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                        GL11.glEnable((int)2896);
                        GlStateManager.popAttrib();
                        GlStateManager.popMatrix();
                    }
                }
                GlStateManager.disableRescaleNormal();
            }
            catch (Exception var20) {
                IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.error("Couldn't render entity", (Throwable)var20);
            }
            GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
            GlStateManager.enableTexture2D();
            GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
            GlStateManager.enableCull();
            GlStateManager.popMatrix();
            super.doRender(entity, x2, y, z, entityYaw, partialTicks);
            MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post(entity, (RenderLivingBase)RenderLivingBase.class.cast((Object)this), partialTicks, x2, y, z));
        }
        Color color2 = color = (Boolean)ak.Method2162370().IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue() != false ? IllIIIlllIllIIIllIIIlIlIIIlllIlIIlllIIllIIlllIIlllIllIIllIIIlIIlllIIIlIIllIllIlllIIIllIIlIllIllIlIIllIlllIllIIllIIIlIllIIlIIllIIIlIllIIlIllIIIllIIlIlIIIllIIlIIlIIllIIIlIIlllIlllIIlIIllIIIlIllIIlIIlIIlIIlllIIIllIIllIIlIIIllIIl.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150586() : new Color((Integer)ak.Method2162370().IIllIIlIlIIlllIIllIIllIIIlllIIIlllIllIIllIIlllIlIIllIIllIllIIlIIllIIlIlllIIIlIIlIllIIIllIIIlllIIlIIIlllIIIlllIIlIllIIIllIIlIlIllIlIIllIlIIIlllIIllIIlIIIlIIlIIlIlIlllIlIIIlIIlIIlllIllIllIllIIIlllIIllIIIllIIllIIlllIIlIllIlIIll.getValue(), (Integer)ak.Method2162370().IIllIIIlllIIIllIIIllIIlIIllIIllIIIlllIIlIIIllIIllIIIlIIIlllIIlllIIlllIIllIIlIlllIlllIlIlIlllIllIIIllIIIllIlIlIllIlIllIIlllIllIlIIlIIIlIlIIllIlllIIlIllIIIlIlllIIllIllIIlIIlllIIlllIIIllIIllIlllIIlIlIIIllIIllIIIlIIIllIIllIIllIIIlllIIll.getValue(), (Integer)ak.Method2162370().IIlIIlIllIIllIIllIIIlIIIlllIIIlIIlllIIIlIIllIIlIIlIIllIIIllIlllIIIlllIIlIlIIIllIIlllIIlIlllIIllIIlIIllIIlIllIllIIlIIllIIllIIllIIlllIIlIIllIlIIllIlIIllIlllIllIlllIIIlIIllIIlllIlIllIIlIllIIlIIllIIIllIllIIlIIIlIllIllIlllIll.getValue());
        if (entity instanceof EntityPlayer) {
            EntityPlayer targetAC;
            if (((Boolean)ak.Method2162370().IlIllIlllIIllIlllIIllIIlllIIIllIIllIIlIIIlllIllIIlIlIIllIIIllIlIlIIllIllIlllIlIIllIIIlllIIllIIIlIIIlIIlIIlIIIlllIllIlllIIIlIIllIIIlIllIIIllIIlIIlIIIlIlIlIIIlllIlllIIlIllIIlllIIllIllIIlllIIIllIlIIllIIllIIlIIlIIllIllIIIllIl.getValue()).booleanValue() && IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.Method2150169((EntityPlayer)entity)) {
                color = new Color(0.33333334f, 1.0f, 1.0f, 1.0f);
            }
            Entity targetKA = IIlIIlllIIlllIIllIIIlllIllIIIlIllIIllIllIIlIIlllIIlllIlIIIlllIIllIIllIIlllIllIIIllIlIIIllIlllIlIlllIllIIIlIlllIlllIIIllIIIlIllIIlllIIllIIllIllIIlllIIlllIIlIIlllIIIllIIlIIIlIllIlIlllIlllIIIlIIllIlIlllIIlIlllIlIIlllIIlllIIIlllIllIIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll != null ? IIlIIlllIIlllIIllIIIlllIllIIIlIllIIllIllIIlIIlllIIlllIlIIIlllIIllIIllIIlllIllIIIllIlIIIllIlllIlIlllIllIIIlIlllIlllIIIllIIIlIllIIlllIIllIIllIllIIlllIIlllIIlIIlllIIIllIIlIIIlIllIlIlllIlllIIIlIIllIlIlllIIlIlllIlIIlllIIlllIIIlllIllIIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll : null;
            EntityPlayer entityPlayer = targetAC = IIlIIIlIIllIIIlIIllIIIllIlllIIllIIIlllIllIIllIIIllIlIllIIllIIllIIIllIIllIIlllIIIlllIIIlIllIllIIlIIlllIIIlllIlllIIlIIIlIIlllIIIlIIIlllIIllIIlIIlIIIlllIIlIIllIlllIIllIlIlIIllIIlIIlIIlIIllIIlllIIIllIlIIIllIIIllIIIllIIIlIIlIIllIIIlIlllIllIIIlll.Method2150751().IIllIIllIIlIIllIIllIIlllIIlllIllIIIllIIIlllIIlIlIIlIIllIlIIllIllIIlIIllIllIlIIllIllIlllIIIlIIIllIIllIIlIllIIIllIlIIllIIllIIllIlIIlllIIlIIIlllIIIlllIIllIIlllIIIlllIIIllIIIllIIllIIllIIllIlllIlIIIlllIIlIIIlIlllIIllIIllIIllIIIlIIllIIlllIlll != null ? IIlIIIlIIllIIIlIIllIIIllIlllIIllIIIlllIllIIllIIIllIlIllIIllIIllIIIllIIllIIlllIIIlllIIIlIllIllIIlIIlllIIIlllIlllIIlIIIlIIlllIIIlIIIlllIIllIIlIIlIIIlllIIlIIllIlllIIllIlIlIIllIIlIIlIIlIIllIIlllIIIllIlIIIllIIIllIIIllIIIlIIlIIllIIIlIlllIllIIIlll.Method2150751().IIllIIllIIlIIllIIllIIlllIIlllIllIIIllIIIlllIIlIlIIlIIllIlIIllIllIIlIIllIllIlIIllIllIlllIIIlIIIllIIllIIlIllIIIllIlIIllIIllIIllIlIIlllIIlIIIlllIIIlllIIllIIlllIIIlllIIIllIIIllIIllIIllIIllIlllIlIIIlllIIlIIIlIlllIIllIIllIIllIIIlIIllIIlllIlll : null;
            if (((Boolean)ak.Method2162370().IllIllIllIlllIIlllIIlllIIlIIlllIIlIIllIIllIIllIIIlIllIIllIlllIlIIllIIlllIIlIIIlIIlIIllIlllIIlIIIlIIIlIllIlIIllIIllIIlllIIllIIlIlllIlllIIIlIIIlllIIllIIIlllIIllIllIIlllIIllIIllIIllIlIIllIllIIlllIIllIIlIIllIlIIIlllIIlIllIIlllIllIIl.getValue()).booleanValue() && (entity.equals((Object)targetKA) || entity.equals((Object)targetAC) && IIlIIIlIIllIIIlIIllIIIllIlllIIllIIIlllIllIIllIIIllIlIllIIllIIllIIIllIIllIIlllIIIlllIIIlIllIllIIlIIlllIIIlllIlllIIlIIIlIIlllIIIlIIIlllIIllIIlIIlIIIlllIIlIIllIlllIIllIlIlIIllIIlIIlIIlIIllIIlllIIIllIlIIIllIIIllIIIllIIIlIIlIIllIIIlIlllIllIIIlll.Method2150751().Method2150788())) {
                color = new Color(1.0f, 0.0f, 0.0f, 1.0f);
            }
        }
        float lineWidth = ((Float)ak.Method2162370().IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.getValue()).floatValue();
        if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Pre(entity, (RenderLivingBase)RenderLivingBase.class.cast((Object)this), partialTicks, x2, y, z))) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GL11.glEnable((int)2848);
        this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
        ModelBase mainModel = this.mainModel;
        mainModel.isRiding = isRiding = entity.isRiding() && entity.getRidingEntity() != null && entity.getRidingEntity().shouldRiderSit();
        boolean shouldSit = isRiding;
        this.mainModel.isChild = entity.isChild();
        try {
            float f = this.interpolateRotation(((EntityLivingBase)entity).prevRenderYawOffset, ((EntityLivingBase)entity).renderYawOffset, partialTicks);
            float f2 = this.interpolateRotation(((EntityLivingBase)entity).prevRotationYawHead, ((EntityLivingBase)entity).rotationYawHead, partialTicks);
            float f3 = f2 - f;
            if (shouldSit && entity.getRidingEntity() instanceof EntityLivingBase) {
                EntityLivingBase entitylivingbase = (EntityLivingBase)entity.getRidingEntity();
                f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
                f3 = f2 - f;
                float f4 = MathHelper.wrapDegrees((float)f3);
                if (f4 < -85.0f) {
                    f4 = -85.0f;
                }
                if (f4 >= 85.0f) {
                    f4 = 85.0f;
                }
                f = f2 - f4;
                if (f4 * f4 > 2500.0f) {
                    f += f4 * 0.2f;
                }
                f3 = f2 - f;
            }
            float f5 = ((EntityLivingBase)entity).prevRotationPitch + (((EntityLivingBase)entity).rotationPitch - ((EntityLivingBase)entity).prevRotationPitch) * partialTicks;
            this.renderLivingAt(entity, x2, y, z);
            float f6 = this.handleRotationFloat(entity, partialTicks);
            this.applyRotations(entity, f6, f, partialTicks);
            float f7 = this.prepareScale(entity, partialTicks);
            float f8 = 0.0f;
            float f9 = 0.0f;
            if (!entity.isRiding()) {
                f8 = ((EntityLivingBase)entity).prevLimbSwingAmount + (((EntityLivingBase)entity).limbSwingAmount - ((EntityLivingBase)entity).prevLimbSwingAmount) * partialTicks;
                f9 = ((EntityLivingBase)entity).limbSwing - ((EntityLivingBase)entity).limbSwingAmount * (1.0f - partialTicks);
                if (entity.isChild()) {
                    f9 *= 3.0f;
                }
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                f3 = f2 - f;
            }
            GlStateManager.enableAlpha();
            this.mainModel.setLivingAnimations(entity, f9, f8, partialTicks);
            this.mainModel.setRotationAngles(f9, f8, f6, f3, f5, f7, entity);
            if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150196(ak.class)) {
                GlStateManager.depthMask((boolean)true);
                if (((Boolean)ak.Method2162370().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).booleanValue()) {
                    if (entity instanceof EntityPlayer) {
                        if (entity != Minecraft.getMinecraft().player) {
                            cp.Method2163079((Color)color);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163073((float)lineWidth);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163074();
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163075();
                            cp.Method2163076((Color)color);
                            cp.Method2163079((Color)color);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163077();
                            cp.Method2163079((Color)Color.WHITE);
                        }
                    } else {
                        this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                    }
                }
                if (((Boolean)ak.Method2162370().IllIlllIIllIIlIIlIlIIIllIIllIIlllIIIlIIlIIlllIIlIlIIIlIlIIIlIIllIlllIIIlllIIllIllIllIIlllIlIllIIlIlIIIlIlIlllIIIlIlllIIlIIllIIlIIllIllIIllIlllIIIllIllIlIIIllIIllIIllIIlIIIlIIlIlIIIllIIllIllIlllIIIllIIIllIIIlllIIlIIIlIlll.getValue()).booleanValue()) {
                    if (entity instanceof EntityMob || entity instanceof EntitySlime || entity instanceof EntityMagmaCube || entity instanceof EntityGhast) {
                        if (entity != Minecraft.getMinecraft().player && !(entity instanceof EntityPigZombie)) {
                            cp.Method2163079((Color)Color.RED);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163073((float)lineWidth);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163074();
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163075();
                            cp.Method2163076((Color)Color.RED);
                            cp.Method2163079((Color)Color.RED);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163077();
                            cp.Method2163079((Color)Color.WHITE);
                        }
                    } else {
                        this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                    }
                }
                if (((Boolean)ak.Method2162370().IIIlIIIllIIIllIlllIIllIlllIIlIIIllIIIlIIIllIIlllIIlllIIIlIlIllIlIIllIIlIllIIIlIlIIlllIIllIIIllIIllIIIlIIllIlIIllIIIllIlIIlllIIllIIIlIIlIIIllIlIIlllIIIllIllIlllIllIlIllIIIllIIlIllIIlIIlllIIllIlllIllIIlIllIIlIIllIlIllIIllIIl.getValue()).booleanValue()) {
                    if (entity instanceof EntityAnimal || entity instanceof EntityIronGolem || entity instanceof EntityGolem || entity instanceof EntitySquid || entity instanceof EntityPigZombie) {
                        if (entity != Minecraft.getMinecraft().player) {
                            cp.Method2163079((Color)Color.GREEN);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163073((float)lineWidth);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163074();
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163075();
                            cp.Method2163076((Color)Color.GREEN);
                            cp.Method2163079((Color)Color.GREEN);
                            this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                            cp.Method2163077();
                            cp.Method2163079((Color)Color.WHITE);
                        }
                    } else {
                        this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                    }
                }
            } else {
                this.renderModel(entity, f9, f8, f6, f3, f5, f7);
            }
            if (this.renderOutlines) {
                boolean flag1 = this.setScoreTeamColor(entity);
                GlStateManager.enableColorMaterial();
                GlStateManager.enableOutlineMode((int)255);
                if (!this.renderMarker) {
                    this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                }
                if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).isSpectator()) {
                    this.renderLayers(entity, f9, f8, partialTicks, f6, f3, f5, f7);
                }
                GlStateManager.disableOutlineMode();
                GlStateManager.disableColorMaterial();
                if (flag1) {
                    this.unsetScoreTeamColor();
                }
            } else {
                boolean flag2 = this.setDoRenderBrightness(entity, partialTicks);
                this.renderModel(entity, f9, f8, f6, f3, f5, f7);
                if (flag2) {
                    this.unsetBrightness();
                }
                GlStateManager.depthMask((boolean)true);
                if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).isSpectator()) {
                    this.renderLayers(entity, f9, f8, partialTicks, f6, f3, f5, f7);
                }
            }
            GlStateManager.disableRescaleNormal();
        }
        catch (Exception exception) {
            LOGGER.error("Couldn't render entity", (Throwable)exception);
        }
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
        GlStateManager.enableCull();
        GL11.glDisable((int)2848);
        GlStateManager.popMatrix();
        MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post(entity, (RenderLivingBase)RenderLivingBase.class.cast((Object)this), partialTicks, x2, y, z));
    }

    @Shadow
    protected abstract boolean isVisible(EntityLivingBase var1);

    @Shadow
    protected abstract float getSwingProgress(T var1, float var2);

    @Shadow
    protected abstract float interpolateRotation(float var1, float var2, float var3);

    @Shadow
    protected abstract float handleRotationFloat(T var1, float var2);

    @Shadow
    protected abstract void applyRotations(T var1, float var2, float var3, float var4);

    @Shadow
    public abstract float prepareScale(T var1, float var2);

    @Shadow
    protected abstract void unsetScoreTeamColor();

    @Shadow
    protected abstract boolean setScoreTeamColor(T var1);

    @Shadow
    protected abstract void renderLivingAt(T var1, double var2, double var4, double var6);

    @Shadow
    protected abstract void unsetBrightness();

    @Shadow
    protected abstract void renderModel(T var1, float var2, float var3, float var4, float var5, float var6, float var7);

    @Shadow
    protected abstract void renderLayers(T var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

    @Shadow
    protected abstract boolean setDoRenderBrightness(T var1, float var2);
}

