

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.biome.Biome
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Random;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.mixin.mixins.accessors.IEntityRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoWeatherModule
        extends Module {
    private static final Random Field2646;
    private static final ResourceLocation Field2647;
    private static final ResourceLocation Field2648;
    public static NoWeatherModule Field2645;

    static {
        Field2646 = new Random();
        Field2647 = new ResourceLocation("textures/environment/rain.png");
        Field2648 = new ResourceLocation("textures/environment/snow.png");
    }

    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2649 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Weather", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CLEAR, "Sets the world's weather."));
    private final Setting<Integer> Field2651 = this.Method2150366(new Setting<Integer>("Height", Integer.valueOf(80), Integer.valueOf(0), Integer.valueOf(255), this::Method2162615));
    private final Setting<Float> Field2652 = this.Method2150366(new Setting<Float>("Strength", Float.valueOf(0.8f), Float.valueOf(0.1f), Float.valueOf(2.0f), this::Method2162614));
    public Setting<Boolean> Field2650 = this.Method2150366(new Setting<Boolean>("Snow", Boolean.valueOf(true), this::Method2162616));
    public Setting<Boolean> Field2653 = this.Method2150366(new Setting<Boolean>("TimeChange", false));
    public Setting<Integer> Field2654 = this.Method2150366(new Setting<Object>("Time", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(23000), this::Method2162613));

    public NoWeatherModule() {
        super("NoWeather", "Allows you to change the weather", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        Field2645 = this;
    }

    @Override
    public String Method2150385() {
        return this.Field2649.currentEnumName();
    }

    @SubscribeEvent
    public void Method2162611(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketTimeUpdate & this.Field2653.getValue()) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.setCanceled(true);
        }
    }

    @Override
    public void Method2150379() {
        NoWeatherModule.Field2811.world.setRainStrength((float) this.Field2649.getValue().IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll());
        if (this.Field2653.getValue().booleanValue()) {
            NoWeatherModule.Field2811.world.setWorldTime(this.Field2654.getValue().longValue());
        }
    }

    public void Method2162612(float f) {
        float f2 = this.Field2652.getValue().floatValue();
        EntityRenderer entityRenderer = NoWeatherModule.Field2811.entityRenderer;
        entityRenderer.enableLightmap();
        Entity entity = Field2811.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        WorldClient worldClient = NoWeatherModule.Field2811.world;
        int n2 = MathHelper.floor((double) entity.posX);
        int n3 = MathHelper.floor((double) entity.posY);
        int n4 = MathHelper.floor((double) entity.posZ);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.disableCull();
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.alphaFunc((int) 516, (float) 0.1f);
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f;
        int n5 = MathHelper.floor((double) d2);
        int n6 = 5;
        if (NoWeatherModule.Field2811.gameSettings.fancyGraphics) {
            n6 = 10;
        }
        int n7 = -1;
        float f3 = (float) ((IEntityRenderer) entityRenderer).getRendererUpdateCount() + f;
        bufferBuilder.setTranslation(-d, -d2, -d3);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int j = n4 - n6; j <= n4 + n6; ++j) {
            for (int i2 = n2 - n6; i2 <= n2 + n6; ++i2) {
                double d4;
                double d5;
                double d6;
                int n8 = (j - n4 + 16) * 32 + i2 - n2 + 16;
                double d7 = (double) ((IEntityRenderer) entityRenderer).getRainXCoords()[n8] * 0.5;
                double d8 = (double) ((IEntityRenderer) entityRenderer).getRainYCoords()[n8] * 0.5;
                mutableBlockPos.setPos(i2, 0, j);
                Biome biome = worldClient.getBiome((BlockPos) mutableBlockPos);
                int n9 = this.Field2651.getValue();
                int n10 = n3 - n6;
                int n11 = n3 + n6;
                if (n10 < n9) {
                    n10 = n9;
                }
                if (n11 < n9) {
                    n11 = n9;
                }
                int n12 = n9;
                if (n9 < n5) {
                    n12 = n5;
                }
                if (n10 == n11) continue;
                Field2646.setSeed(i2 * i2 * 3121 + i2 * 45238971 ^ j * j * 418711 + j * 13761);
                mutableBlockPos.setPos(i2, n10, j);
                float f4 = biome.getTemperature((BlockPos) mutableBlockPos);
                if (!this.Field2650.getValue().booleanValue()) {
                    if (n7 != 0) {
                        if (n7 >= 0) {
                            tessellator.draw();
                        }
                        n7 = 0;
                        Field2811.getTextureManager().bindTexture(Field2647);
                        bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                    }
                    d6 = -((double) (((IEntityRenderer) entityRenderer).getRendererUpdateCount() + i2 * i2 * 3121 + i2 * 45238971 + j * j * 418711 + j * 13761 & 0x1F) + (double) f) / 32.0 * (3.0 + Field2646.nextDouble());
                    d5 = (double) ((float) i2 + 0.5f) - entity.posX;
                    d4 = (double) ((float) j + 0.5f) - entity.posZ;
                    float f5 = MathHelper.sqrt((double) (d5 * d5 + d4 * d4)) / (float) n6;
                    float f6 = ((1.0f - f5 * f5) * 0.5f + 0.5f) * f2;
                    mutableBlockPos.setPos(i2, n12, j);
                    int n13 = worldClient.getCombinedLight((BlockPos) mutableBlockPos, 0);
                    int n14 = n13 >> 16 & 0xFFFF;
                    int n15 = n13 & 0xFFFF;
                    bufferBuilder.pos((double) i2 - d7 + 0.5, (double) n11, (double) j - d8 + 0.5).tex(0.0, (double) n10 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n14, n15).endVertex();
                    bufferBuilder.pos((double) i2 + d7 + 0.5, (double) n11, (double) j + d8 + 0.5).tex(1.0, (double) n10 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n14, n15).endVertex();
                    bufferBuilder.pos((double) i2 + d7 + 0.5, (double) n10, (double) j + d8 + 0.5).tex(1.0, (double) n11 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n14, n15).endVertex();
                    bufferBuilder.pos((double) i2 - d7 + 0.5, (double) n10, (double) j - d8 + 0.5).tex(0.0, (double) n11 * 0.25 + d6).color(1.0f, 1.0f, 1.0f, f6).lightmap(n14, n15).endVertex();
                    continue;
                }
                if (n7 != 1) {
                    if (n7 >= 0) {
                        tessellator.draw();
                    }
                    n7 = 1;
                    Field2811.getTextureManager().bindTexture(Field2648);
                    bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                }
                d6 = -((float) (((IEntityRenderer) entityRenderer).getRendererUpdateCount() & 0x1FF) + f) / 512.0f;
                d5 = Field2646.nextDouble() + (double) f3 * 0.01 * (double) ((float) Field2646.nextGaussian());
                d4 = Field2646.nextDouble() + (double) (f3 * (float) Field2646.nextGaussian()) * 0.001;
                double d9 = (double) ((float) i2 + 0.5f) - entity.posX;
                double d10 = (double) ((float) j + 0.5f) - entity.posZ;
                float f7 = MathHelper.sqrt((double) (d9 * d9 + d10 * d10)) / (float) n6;
                float f8 = ((1.0f - f7 * f7) * 0.3f + 0.5f) * f2;
                mutableBlockPos.setPos(i2, n12, j);
                int n16 = (worldClient.getCombinedLight((BlockPos) mutableBlockPos, 0) * 3 + 0xF000F0) / 4;
                int n17 = n16 >> 16 & 0xFFFF;
                int n18 = n16 & 0xFFFF;
                bufferBuilder.pos((double) i2 - d7 + 0.5, (double) n11, (double) j - d8 + 0.5).tex(0.0 + d5, (double) n10 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n17, n18).endVertex();
                bufferBuilder.pos((double) i2 + d7 + 0.5, (double) n11, (double) j + d8 + 0.5).tex(1.0 + d5, (double) n10 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n17, n18).endVertex();
                bufferBuilder.pos((double) i2 + d7 + 0.5, (double) n10, (double) j + d8 + 0.5).tex(1.0 + d5, (double) n11 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n17, n18).endVertex();
                bufferBuilder.pos((double) i2 - d7 + 0.5, (double) n10, (double) j - d8 + 0.5).tex(0.0 + d5, (double) n11 * 0.25 + d6 + d4).color(1.0f, 1.0f, 1.0f, f8).lightmap(n17, n18).endVertex();
            }
        }
        if (n7 >= 0) {
            tessellator.draw();
        }
        bufferBuilder.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.alphaFunc((int) 516, (float) 0.1f);
        entityRenderer.disableLightmap();
    }

    private boolean Method2162613(Object object) {
        return this.Field2653.getValue();
    }

    private boolean Method2162614(Float f) {
        return this.Field2649.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SNOW;
    }

    private boolean Method2162615(Integer n2) {
        return this.Field2649.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SNOW;
    }

    private boolean Method2162616(Boolean bl) {
        return this.Field2649.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SNOW;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        CLEAR(0),
        RAIN(1),
        THUNDER(2),
        SNOW(0);

        private final int Field3497;

        private IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(int n3) {
            this.Field3497 = n3;
        }

        public int IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
            return this.Field3497;
        }
    }
}

