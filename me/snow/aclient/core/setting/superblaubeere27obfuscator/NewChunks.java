

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PairUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class NewChunks
        extends Module {
    private final List<PairUtil<Integer, Integer>> Field3683 = new CopyOnWriteArrayList<PairUtil<Integer, Integer>>();
    private Setting<Boolean> Field3678 = this.Method2150366(new Setting<Boolean>("Sync", true));
    private Setting<Integer> Field3679 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    private Setting<Integer> Field3680 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private Setting<Integer> Field3681 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    private Setting<Integer> Field3682 = this.Method2150366(new Setting<Integer>("Alpha", 70, 0, 255));

    public NewChunks() {
        super("NewChunks", "Shows newly generated chunks", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }

    private static boolean Method2162593(SPacketChunkData sPacketChunkData, PairUtil pairUtil) {
        return ((Integer) pairUtil.Method2163911()).intValue() == sPacketChunkData.getChunkX() && ((Integer) pairUtil.Method2163912()).intValue() == sPacketChunkData.getChunkZ();
    }

    private static void Method2162594(Color color, PairUtil pairUtil) {
        float f = (Integer) pairUtil.Method2163911() * 16;
        float f2 = (Integer) pairUtil.Method2163912() * 16;
        RenderUtil.Field3116.setPosition(Objects.requireNonNull(NewChunks.Field2811.getRenderViewEntity()).posX, NewChunks.Field2811.getRenderViewEntity().posY, NewChunks.Field2811.getRenderViewEntity().posZ);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double) f - NewChunks.Field2811.getRenderManager().viewerPosX, 0.0 - NewChunks.Field2811.getRenderManager().viewerPosY, (double) f2 - NewChunks.Field2811.getRenderManager().viewerPosZ, (double) (f + 16.0f) - NewChunks.Field2811.getRenderManager().viewerPosX, 1.0 - NewChunks.Field2811.getRenderManager().viewerPosY, (double) (f2 + 16.0f) - NewChunks.Field2811.getRenderManager().viewerPosZ);
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB((double) f, 0.0, (double) f2, (double) (f + 16.0f), 1.0, (double) (f2 + 16.0f));
        if (RenderUtil.Field3116.isBoundingBoxInFrustum(axisAlignedBB2)) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 0, (int) 1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean) false);
            GL11.glEnable((int) 2848);
            GL11.glHint((int) 3154, (int) 4354);
            GL11.glLineWidth((float) 1.5f);
            RenderUtils.Method2162936(axisAlignedBB, 3, ColorUtil.Method2163384(color));
            GL11.glDisable((int) 2848);
            GlStateManager.depthMask((boolean) true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    @Override
    public void Method2150372() {
        this.Field3683.clear();
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        Color color = this.Field3678.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field3679.getValue(), this.Field3680.getValue(), this.Field3681.getValue(), this.Field3682.getValue());
        Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field3682.getValue());
        this.Field3683.forEach(arg_0 -> NewChunks.Method2162594(color2, arg_0));
    }

    @SubscribeEvent
    public void Method2162592(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketChunkData sPacketChunkData;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketChunkData && !(sPacketChunkData = (SPacketChunkData) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).isFullChunk()) {
            this.Field3683.removeIf(arg_0 -> NewChunks.Method2162593(sPacketChunkData, arg_0));
            PairUtil<Integer, Integer> pairUtil = new PairUtil<Integer, Integer>(sPacketChunkData.getChunkX(), sPacketChunkData.getChunkZ());
            if (!this.Field3683.contains(pairUtil)) {
                this.Field3683.add(pairUtil);
            }
        }
    }
}

