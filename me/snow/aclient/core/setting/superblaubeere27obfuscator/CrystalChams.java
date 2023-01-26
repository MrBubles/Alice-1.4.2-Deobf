

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderEntityModelEvent;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class CrystalChams
        extends Module {
    static final ResourceLocation Field1431;
    public static CrystalChams Field1407;

    static {
        Field1431 = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    }

    public Setting<Boolean> Field1408 = this.Method2150366(new Setting<Boolean>("AnimateScale", false));
    public Setting<Boolean> Field1409 = this.Method2150366(new Setting<Boolean>("Chams", false));
    public Setting<Boolean> Field1410 = this.Method2150366(new Setting<Boolean>("ThroughWalls", true));
    public Setting<Boolean> Field1411 = this.Method2150366(new Setting<Boolean>("WireThroughWalls", true));
    public Setting<Boolean> Field1412 = this.Method2150366(new Setting<Object>("Glint", Boolean.FALSE, this::Method2162374));
    public Setting<Boolean> Field1413 = this.Method2150366(new Setting<Boolean>("Wireframe", false));
    public Setting<Float> Field1414 = this.Method2150366(new Setting<Float>("Scale", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f)));
    public Setting<Float> Field1415 = this.Method2150366(new Setting<Float>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(3.0f)));
    public Setting<Boolean> Field1416 = this.Method2150366(new Setting<Boolean>("Sync", false));
    public Setting<Boolean> Field1417 = this.Method2150366(new Setting<Boolean>("Rainbow", false));
    public Setting<Integer> Field1418 = this.Method2150366(new Setting<Object>("Saturation", Integer.valueOf(50), Integer.valueOf(0), Integer.valueOf(100), this::Method2162373));
    public Setting<Integer> Field1419 = this.Method2150366(new Setting<Object>("Brightness", Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(100), this::Method2162372));
    public Setting<Integer> Field1420 = this.Method2150366(new Setting<Object>("Speed", Integer.valueOf(40), Integer.valueOf(1), Integer.valueOf(100), this::Method2162371));
    public Setting<Boolean> Field1421 = this.Method2150366(new Setting<Object>("XQZ", Boolean.FALSE, this::Method2162360));
    public Setting<Integer> Field1426 = this.Method2150366(new Setting<Object>("Hidden Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162366));
    public Setting<Integer> Field1427 = this.Method2150366(new Setting<Object>("Hidden Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162365));
    public Setting<Integer> Field1428 = this.Method2150366(new Setting<Object>("Hidden Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162364));
    public Setting<Integer> Field1429 = this.Method2150366(new Setting<Object>("Hidden Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162363));
    public Setting<Integer> Field1422 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162369));
    public Setting<Integer> Field1423 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162368));
    public Setting<Integer> Field1424 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162367));
    public Setting<Integer> Field1425 = this.Method2150366(new Setting<Integer>("Alpha", 100, 0, 255));
    public Map<EntityEnderCrystal, Float> Field1430 = new ConcurrentHashMap<EntityEnderCrystal, Float>();

    public CrystalChams() {
        super("CrystalChams", "Modifies crystal rendering in different ways", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
        Field1407 = this;
    }

    @Override
    public void Method2150379() {
        if (CrystalChams.Method2150359()) {
            return;
        }
        for (Entity entity : CrystalChams.Field2811.world.loadedEntityList) {
            if (!(entity instanceof EntityEnderCrystal)) continue;
            if (!this.Field1430.containsKey((Object) entity)) {
                this.Field1430.put((EntityEnderCrystal) entity, Float.valueOf(3.125E-4f));
            } else {
                this.Field1430.put((EntityEnderCrystal) entity, Float.valueOf(this.Field1430.get((Object) entity).floatValue() + 3.125E-4f));
            }
            if (!(this.Field1430.get((Object) entity).floatValue() >= 0.0625f * this.Field1414.getValue().floatValue()))
                continue;
            this.Field1430.remove((Object) entity);
        }
    }

    @SubscribeEvent
    public void Method2162361(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketDestroyEntities) {
            SPacketDestroyEntities sPacketDestroyEntities = (SPacketDestroyEntities) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            for (int n2 : sPacketDestroyEntities.getEntityIDs()) {
                Entity entity = CrystalChams.Field2811.world.getEntityByID(n2);
                if (!(entity instanceof EntityEnderCrystal)) continue;
                this.Field1430.remove((Object) entity);
            }
        }
    }

    public void Method2162362(RenderEntityModelEvent renderEntityModelEvent) {
        if (renderEntityModelEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0 || !(renderEntityModelEvent.Field619 instanceof EntityEnderCrystal) || !this.Field1413.getValue().booleanValue()) {
            return;
        }
        Color color = this.Field1416.getValue() != false ? Colors.Field1782.Method2150586() : EntityUtil.Method2163558(renderEntityModelEvent.Field619, this.Field1422.getValue(), this.Field1423.getValue(), this.Field1424.getValue(), this.Field1425.getValue(), false);
        CrystalChams.Field2811.gameSettings.fancyGraphics = false;
        CrystalChams.Field2811.gameSettings.gammaSetting = 10000.0f;
        GL11.glPushMatrix();
        GL11.glPushAttrib((int) 1048575);
        GL11.glPolygonMode((int) 1032, (int) 6913);
        GL11.glDisable((int) 3553);
        GL11.glDisable((int) 2896);
        if (this.Field1411.getValue().booleanValue()) {
            GL11.glDisable((int) 2929);
        }
        GL11.glEnable((int) 2848);
        GL11.glEnable((int) 3042);
        GlStateManager.blendFunc((int) 770, (int) 771);
        GlStateManager.color((float) ((float) color.getRed() / 255.0f), (float) ((float) color.getGreen() / 255.0f), (float) ((float) color.getBlue() / 255.0f), (float) ((float) color.getAlpha() / 255.0f));
        GlStateManager.glLineWidth((float) this.Field1415.getValue().floatValue());
        renderEntityModelEvent.Field618.render(renderEntityModelEvent.Field619, renderEntityModelEvent.Field620, renderEntityModelEvent.Field621, renderEntityModelEvent.Field622, renderEntityModelEvent.Field623, renderEntityModelEvent.Field624, renderEntityModelEvent.Field625);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    private boolean Method2162363(Object object) {
        return this.Field1421.getValue() != false && this.Field1417.getValue() == false;
    }

    private boolean Method2162364(Object object) {
        return this.Field1421.getValue() != false && this.Field1417.getValue() == false;
    }

    private boolean Method2162365(Object object) {
        return this.Field1421.getValue() != false && this.Field1417.getValue() == false;
    }

    private boolean Method2162366(Object object) {
        return this.Field1421.getValue() != false && this.Field1417.getValue() == false;
    }

    private boolean Method2162367(Object object) {
        return this.Field1417.getValue() == false;
    }

    private boolean Method2162368(Object object) {
        return this.Field1417.getValue() == false;
    }

    private boolean Method2162369(Object object) {
        return this.Field1417.getValue() == false;
    }

    private boolean Method2162360(Object object) {
        return this.Field1417.getValue() == false && this.Field1410.getValue() != false;
    }

    private boolean Method2162371(Object object) {
        return this.Field1417.getValue();
    }

    private boolean Method2162372(Object object) {
        return this.Field1417.getValue();
    }

    private boolean Method2162373(Object object) {
        return this.Field1417.getValue();
    }

    private boolean Method2162374(Object object) {
        return this.Field1409.getValue();
    }
}

