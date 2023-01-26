

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemExpBottle
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Cylinder
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemSnowball;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

public class Trajectories
        extends Module {
    public Setting<Boolean> Field3483 = this.Method2150366(new Setting<Boolean>("CSync", false));
    public Setting<Integer> Field3484 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    public Setting<Integer> Field3485 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    public Setting<Integer> Field3486 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    public Setting<Integer> Field3487 = this.Method2150366(new Setting<Integer>("Alpha", 170, 0, 255));

    public Trajectories() {
        super("Trajectories", "Draws trajectories.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (Trajectories.Field2811.world != null && Trajectories.Field2811.player != null) {
            Color color = this.Field3483.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3484.getValue(), this.Field3485.getValue(), this.Field3486.getValue(), this.Field3487.getValue());
            Field2811.getRenderManager();
            double d = Trajectories.Field2811.player.lastTickPosX + (Trajectories.Field2811.player.posX - Trajectories.Field2811.player.lastTickPosX) * (double) render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            double d2 = Trajectories.Field2811.player.lastTickPosY + (Trajectories.Field2811.player.posY - Trajectories.Field2811.player.lastTickPosY) * (double) render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            double d3 = Trajectories.Field2811.player.lastTickPosZ + (Trajectories.Field2811.player.posZ - Trajectories.Field2811.player.lastTickPosZ) * (double) render3DEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND);
            if (Trajectories.Field2811.gameSettings.thirdPersonView == 0 && (Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemBow || Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemFishingRod || Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemEnderPearl || Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemEgg || Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemSnowball || Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemExpBottle)) {
                Vec3d vec3d;
                float f;
                GL11.glPushMatrix();
                Item item = Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem();
                double d4 = d - (double) (MathHelper.cos((float) (Trajectories.Field2811.player.rotationYaw / 180.0f * (float) Math.PI)) * 0.16f);
                double d5 = d2 + (double) Trajectories.Field2811.player.getEyeHeight() - 0.1000000014901161;
                double d6 = d3 - (double) (MathHelper.sin((float) (Trajectories.Field2811.player.rotationYaw / 180.0f * (float) Math.PI)) * 0.16f);
                double d7 = (double) (-MathHelper.sin((float) (Trajectories.Field2811.player.rotationYaw / 180.0f * (float) Math.PI)) * MathHelper.cos((float) (Trajectories.Field2811.player.rotationPitch / 180.0f * (float) Math.PI))) * (item instanceof ItemBow ? 1.0 : 0.4);
                double d8 = (double) (-MathHelper.sin((float) (Trajectories.Field2811.player.rotationPitch / 180.0f * (float) Math.PI))) * (item instanceof ItemBow ? 1.0 : 0.4);
                double d9 = (double) (MathHelper.cos((float) (Trajectories.Field2811.player.rotationYaw / 180.0f * (float) Math.PI)) * MathHelper.cos((float) (Trajectories.Field2811.player.rotationPitch / 180.0f * (float) Math.PI))) * (item instanceof ItemBow ? 1.0 : 0.4);
                int n2 = 72000 - Trajectories.Field2811.player.getItemInUseCount();
                float f2 = (float) n2 / 20.0f;
                f2 = (f2 * f2 + f2 * 2.0f) / 3.0f;
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                float f3 = MathHelper.sqrt((double) (d7 * d7 + d8 * d8 + d9 * d9));
                d7 /= (double) f3;
                d8 /= (double) f3;
                d9 /= (double) f3;
                float f4 = item instanceof ItemBow ? f2 * 2.0f : (item instanceof ItemFishingRod ? 1.25f : (f = Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.EXPERIENCE_BOTTLE ? 0.9f : 1.0f));
                d7 *= (double) (f * (item instanceof ItemFishingRod ? 0.75f : (Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.EXPERIENCE_BOTTLE ? 0.75f : 1.5f)));
                d8 *= (double) (f * (item instanceof ItemFishingRod ? 0.75f : (Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.EXPERIENCE_BOTTLE ? 0.75f : 1.5f)));
                d9 *= (double) (f * (item instanceof ItemFishingRod ? 0.75f : (Trajectories.Field2811.player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.EXPERIENCE_BOTTLE ? 0.75f : 1.5f)));
                this.Method2162742(2.0f);
                GlStateManager.color((float) ((float) Integer.valueOf(color.getRed()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getGreen()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getBlue()).intValue() / 255.0f), (float) ((float) this.Field3487.getValue().intValue() / 255.0f));
                GL11.glEnable((int) 2848);
                float f5 = (float) (item instanceof ItemBow ? 0.3 : 0.25);
                boolean bl = false;
                Entity entity = null;
                RayTraceResult rayTraceResult = null;
                while (!bl && d5 > 0.0) {
                    Vec3d vec3d2 = new Vec3d(d4, d5, d6);
                    vec3d = new Vec3d(d4 + d7, d5 + d8, d6 + d9);
                    RayTraceResult rayTraceResult2 = Trajectories.Field2811.world.rayTraceBlocks(vec3d2, vec3d, false, true, false);
                    if (rayTraceResult2 != null && rayTraceResult2.typeOfHit != RayTraceResult.Type.MISS) {
                        rayTraceResult = rayTraceResult2;
                        bl = true;
                    }
                    AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d4 - (double) f5, d5 - (double) f5, d6 - (double) f5, d4 + (double) f5, d5 + (double) f5, d6 + (double) f5);
                    List<Entity> list = this.Method2162745(axisAlignedBB.offset(d7, d8, d9).expand(1.0, 1.0, 1.0));
                    for (Entity entity2 : list) {
                        AxisAlignedBB axisAlignedBB2;
                        RayTraceResult rayTraceResult3;
                        if (!entity2.canBeCollidedWith() || entity2 == Trajectories.Field2811.player || (rayTraceResult3 = (axisAlignedBB2 = entity2.getEntityBoundingBox().expand((double) 0.3f, (double) 0.3f, (double) 0.3f)).calculateIntercept(vec3d2, vec3d)) == null)
                            continue;
                        bl = true;
                        entity = entity2;
                        rayTraceResult = rayTraceResult3;
                    }
                    if (entity != null) {
                        GlStateManager.color((float) ((float) Integer.valueOf(color.getRed()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getGreen()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getBlue()).intValue() / 255.0f), (float) ((float) this.Field3487.getValue().intValue() / 255.0f));
                    }
                    d8 *= (double) 0.99f;
                    this.Method2162744((d4 += (d7 *= (double) 0.99f)) - d, (d5 += (d8 -= item instanceof ItemBow ? 0.05 : 0.03)) - d2, (d6 += (d9 *= (double) 0.99f)) - d3);
                }
                if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
                    GlStateManager.translate((double) (d4 - d), (double) (d5 - d2), (double) (d6 - d3));
                    int n3 = rayTraceResult.sideHit.getIndex();
                    if (n3 == 2) {
                        GlStateManager.rotate((float) 90.0f, (float) 1.0f, (float) 0.0f, (float) 0.0f);
                    } else if (n3 == 3) {
                        GlStateManager.rotate((float) 90.0f, (float) 1.0f, (float) 0.0f, (float) 0.0f);
                    } else if (n3 == 4) {
                        GlStateManager.rotate((float) 90.0f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
                    } else if (n3 == 5) {
                        GlStateManager.rotate((float) 90.0f, (float) 0.0f, (float) 0.0f, (float) 1.0f);
                    }
                    vec3d = new Cylinder();
                    GlStateManager.rotate((float) -90.0f, (float) 1.0f, (float) 0.0f, (float) 0.0f);
                    vec3d.setDrawStyle(100011);
                    if (entity != null) {
                        GlStateManager.color((float) ((float) Integer.valueOf(color.getRed()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getGreen()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getBlue()).intValue() / 255.0f), (float) ((float) this.Field3487.getValue().intValue() / 255.0f));
                        GL11.glLineWidth((float) 2.5f);
                        vec3d.draw(0.5f, 0.5f, 0.0f, Integer.valueOf(9).intValue(), 1);
                        GL11.glLineWidth((float) 0.1f);
                        GlStateManager.color((float) ((float) Integer.valueOf(color.getRed()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getGreen()).intValue() / 255.0f), (float) ((float) Integer.valueOf(color.getBlue()).intValue() / 255.0f), (float) ((float) this.Field3487.getValue().intValue() / 255.0f));
                    }
                    vec3d.draw(0.5f, 0.2f, 0.0f, Integer.valueOf(9).intValue(), 1);
                }
                this.Method2162743();
                GL11.glPopMatrix();
            }
        }
    }

    public void Method2162742(float f) {
        GL11.glDisable((int) 3008);
        GL11.glEnable((int) 3042);
        GL11.glBlendFunc((int) 770, (int) 771);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2929);
        GL11.glDepthMask((boolean) false);
        GL11.glEnable((int) 2884);
        Trajectories.Field2811.entityRenderer.disableLightmap();
        GL11.glEnable((int) 2848);
        GL11.glHint((int) 3154, (int) 4354);
        GL11.glHint((int) 3155, (int) 4354);
        GL11.glLineWidth((float) f);
    }

    public void Method2162743() {
        GL11.glEnable((int) 3553);
        GL11.glEnable((int) 2929);
        GL11.glDisable((int) 3042);
        GL11.glEnable((int) 3008);
        GL11.glDepthMask((boolean) true);
        GL11.glCullFace((int) 1029);
        GL11.glDisable((int) 2848);
        GL11.glHint((int) 3154, (int) 4352);
        GL11.glHint((int) 3155, (int) 4352);
    }

    public void Method2162744(double d, double d2, double d3) {
        GL11.glVertex3d((double) d, (double) d2, (double) d3);
    }

    private List<Entity> Method2162745(AxisAlignedBB axisAlignedBB) {
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        int n2 = MathHelper.floor((double) ((axisAlignedBB.minX - 2.0) / 16.0));
        int n3 = MathHelper.floor((double) ((axisAlignedBB.maxX + 2.0) / 16.0));
        int n4 = MathHelper.floor((double) ((axisAlignedBB.minZ - 2.0) / 16.0));
        int n5 = MathHelper.floor((double) ((axisAlignedBB.maxZ + 2.0) / 16.0));
        for (int j = n2; j <= n3; ++j) {
            for (int i2 = n4; i2 <= n5; ++i2) {
                if (Trajectories.Field2811.world.getChunkProvider().getLoadedChunk(j, i2) == null) continue;
                Trajectories.Field2811.world.getChunk(j, i2).getEntitiesWithinAABBForEntity((Entity) Trajectories.Field2811.player, axisAlignedBB, arrayList, null);
            }
        }
        return arrayList;
    }
}

