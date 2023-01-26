

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.an
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.entity.RenderEntityItem
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.ForgeHooksClient
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.mixin.mixins;

import java.util.Random;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.an;
import me.snow.aclient.mixin.mixins.MixinRenderer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={RenderEntityItem.class})
public abstract class MixinRenderEntityItem
extends MixinRenderer<EntityItem> {
    @Shadow
    @Final
    private RenderItem itemRenderer;
    @Shadow
    @Final
    private Random random;
    private Minecraft mc = Minecraft.getMinecraft();
    private long tick;
    private double rotation;

    @Shadow
    public abstract int getModelCount(ItemStack var1);

    @Shadow
    public abstract boolean shouldSpreadItems();

    @Shadow
    public abstract boolean shouldBob();

    @Shadow
    protected abstract ResourceLocation getEntityTexture(EntityItem var1);

    private double formPositiv(float rotationPitch) {
        return rotationPitch > 0.0f ? (double)rotationPitch : (double)(-rotationPitch);
    }

    @Overwrite
    private int transformModelCount(EntityItem itemIn, double x2, double y, double z, float p_177077_8_, IBakedModel p_177077_9_) {
        if (an.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150364()) {
            ItemStack itemstack = itemIn.getItem();
            Item item2 = itemstack.getItem();
            if (item2 == null) {
                return 0;
            }
            boolean flag = p_177077_9_.isAmbientOcclusion();
            int i = this.getModelCount(itemstack);
            float f2 = 0.0f;
            GlStateManager.translate((float)((float)x2), (float)((float)y + 0.0f + 0.1f), (float)((float)z));
            float f3 = 0.0f;
            if (flag || this.mc.getRenderManager().options != null && this.mc.getRenderManager().options.fancyGraphics) {
                GlStateManager.rotate((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            if (!flag) {
                f3 = -0.0f * (float)(i - 1) * 0.5f;
                float f4 = -0.0f * (float)(i - 1) * 0.5f;
                float f5 = -0.046875f * (float)(i - 1) * 0.5f;
                GlStateManager.translate((float)f3, (float)f4, (float)f5);
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            return i;
        }
        ItemStack itemstack = itemIn.getItem();
        Item item = itemstack.getItem();
        if (item == null) {
            return 0;
        }
        boolean flag = p_177077_9_.isGui3d();
        int i = this.getModelCount(itemstack);
        float f1 = this.shouldBob() ? MathHelper.sin((float)(((float)itemIn.getAge() + p_177077_8_) / 10.0f + itemIn.hoverStart)) * 0.1f + 0.1f : 0.0f;
        float f2 = p_177077_9_.getItemCameraTransforms().getTransform((ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.GROUND).scale.y;
        GlStateManager.translate((float)((float)x2), (float)((float)y + f1 + 0.25f * f2), (float)((float)z));
        if (flag || this.renderManager.options != null) {
            float f3 = (((float)itemIn.getAge() + p_177077_8_) / 20.0f + itemIn.hoverStart) * 57.295776f;
            GlStateManager.rotate((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        return i;
    }

    @Overwrite
    public void doRender(EntityItem entity, double x2, double y, double z, float entityYaw, float partialTicks) {
        if (an.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150364()) {
            EntityItem entityitem;
            ItemStack itemstack;
            this.rotation = (double)(System.nanoTime() - this.tick) / 3000000.0 * 1.0;
            if (!this.mc.inGameHasFocus) {
                this.rotation = 0.0;
            }
            if ((itemstack = (entityitem = entity).getItem()).getItem() != null) {
                this.random.setSeed(187L);
                boolean flag = false;
                if (TextureMap.LOCATION_BLOCKS_TEXTURE != null) {
                    this.mc.getRenderManager().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                    this.mc.getRenderManager().renderEngine.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
                    flag = true;
                }
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc((int)516, (float)0.1f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
                GlStateManager.pushMatrix();
                IBakedModel ibakedmodel = this.itemRenderer.getItemModelMesher().getItemModel(itemstack);
                int i = this.transformModelCount(entityitem, x2, y, z, partialTicks, ibakedmodel);
                BlockPos blockpos = new BlockPos((Entity)entityitem);
                if (entityitem.rotationPitch > 360.0f) {
                    entityitem.rotationPitch = 0.0f;
                }
                if (!(entityitem == null || Double.isNaN(entityitem.posX) || Double.isNaN(entityitem.posY) || Double.isNaN(entityitem.posZ) || entityitem.world == null)) {
                    if (entityitem.onGround) {
                        if (entityitem.rotationPitch != 0.0f && entityitem.rotationPitch != 90.0f && entityitem.rotationPitch != 180.0f && entityitem.rotationPitch != 270.0f) {
                            double d0 = this.formPositiv(entityitem.rotationPitch);
                            double d2 = this.formPositiv(entityitem.rotationPitch - 90.0f);
                            double d3 = this.formPositiv(entityitem.rotationPitch - 180.0f);
                            double d4 = this.formPositiv(entityitem.rotationPitch - 270.0f);
                            if (d0 <= d2 && d0 <= d3 && d0 <= d4) {
                                entityitem.rotationPitch = entityitem.rotationPitch < 0.0f ? (entityitem.rotationPitch += (float)this.rotation) : (entityitem.rotationPitch -= (float)this.rotation);
                            }
                            if (d2 < d0 && d2 <= d3 && d2 <= d4) {
                                entityitem.rotationPitch = entityitem.rotationPitch - 90.0f < 0.0f ? (entityitem.rotationPitch += (float)this.rotation) : (entityitem.rotationPitch -= (float)this.rotation);
                            }
                            if (d3 < d2 && d3 < d0 && d3 <= d4) {
                                entityitem.rotationPitch = entityitem.rotationPitch - 180.0f < 0.0f ? (entityitem.rotationPitch += (float)this.rotation) : (entityitem.rotationPitch -= (float)this.rotation);
                            }
                            if (d4 < d2 && d4 < d3 && d4 < d0) {
                                entityitem.rotationPitch = entityitem.rotationPitch - 270.0f < 0.0f ? (entityitem.rotationPitch += (float)this.rotation) : (entityitem.rotationPitch -= (float)this.rotation);
                            }
                        }
                    } else {
                        BlockPos blockpos2 = new BlockPos((Entity)entityitem);
                        blockpos2.add(0, 1, 0);
                        Material material = entityitem.world.getBlockState(blockpos2).getMaterial();
                        Material material2 = entityitem.world.getBlockState(blockpos).getMaterial();
                        boolean flag2 = entityitem.isInsideOfMaterial(Material.WATER);
                        boolean flag3 = entityitem.isInWater();
                        entityitem.rotationPitch = flag2 | material == Material.WATER | material2 == Material.WATER | flag3 ? (entityitem.rotationPitch += (float)(this.rotation / 4.0)) : (entityitem.rotationPitch += (float)(this.rotation * 2.0));
                    }
                }
                GL11.glRotatef((float)entityitem.rotationYaw, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(entityitem.rotationPitch + 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                for (int j = 0; j < i; ++j) {
                    if (ibakedmodel.isAmbientOcclusion()) {
                        GlStateManager.pushMatrix();
                        GlStateManager.scale((float)((Float)an.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).floatValue(), (float)((Float)an.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).floatValue(), (float)((Float)an.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).floatValue());
                        this.itemRenderer.renderItem(itemstack, ibakedmodel);
                        GlStateManager.popMatrix();
                        continue;
                    }
                    GlStateManager.pushMatrix();
                    if (j > 0 && this.shouldSpreadItems()) {
                        GlStateManager.translate((float)0.0f, (float)0.0f, (float)(0.046875f * (float)j));
                    }
                    this.itemRenderer.renderItem(itemstack, ibakedmodel);
                    if (!this.shouldSpreadItems()) {
                        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.046875f);
                    }
                    GlStateManager.popMatrix();
                }
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
                this.mc.getRenderManager().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                if (flag) {
                    this.mc.getRenderManager().renderEngine.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
                }
            }
            return;
        }
        ItemStack itemstack = entity.getItem();
        int i = itemstack.isEmpty() ? 187 : Item.getIdFromItem((Item)itemstack.getItem()) + itemstack.getMetadata();
        this.random.setSeed(i);
        boolean flag = false;
        if (this.bindEntityTexture(entity)) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(entity)).setBlurMipmap(false, false);
            flag = true;
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc((int)516, (float)0.1f);
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();
        IBakedModel ibakedmodel = this.itemRenderer.getItemModelWithOverrides(itemstack, entity.world, (EntityLivingBase)null);
        int j = this.transformModelCount(entity, x2, y, z, partialTicks, ibakedmodel);
        boolean flag1 = ibakedmodel.isGui3d();
        if (!flag1) {
            float f3 = -0.0f * (float)(j - 1) * 0.5f;
            float f4 = -0.0f * (float)(j - 1) * 0.5f;
            float f5 = -0.09375f * (float)(j - 1) * 0.5f;
            GlStateManager.translate((float)f3, (float)f4, (float)f5);
        }
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode((int)this.getTeamColor(entity));
        }
        for (int k2 = 0; k2 < j; ++k2) {
            IBakedModel transformedModel;
            if (flag1) {
                GlStateManager.pushMatrix();
                if (k2 > 0) {
                    float f7 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    float f9 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    float f6 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    GlStateManager.translate((float)(this.shouldSpreadItems() ? f7 : 0.0f), (float)(this.shouldSpreadItems() ? f9 : 0.0f), (float)f6);
                }
                transformedModel = ForgeHooksClient.handleCameraTransforms((IBakedModel)ibakedmodel, (ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.GROUND, (boolean)false);
                this.itemRenderer.renderItem(itemstack, transformedModel);
                GlStateManager.popMatrix();
                continue;
            }
            GlStateManager.pushMatrix();
            if (k2 > 0) {
                float f8 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f * 0.5f;
                float f10 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f * 0.5f;
                GlStateManager.translate((float)f8, (float)f10, (float)0.0f);
            }
            transformedModel = ForgeHooksClient.handleCameraTransforms((IBakedModel)ibakedmodel, (ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.GROUND, (boolean)false);
            this.itemRenderer.renderItem(itemstack, transformedModel);
            GlStateManager.popMatrix();
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.09375f);
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        this.bindEntityTexture(entity);
        if (flag) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(entity)).restoreLastBlurMipmap();
        }
    }
}

