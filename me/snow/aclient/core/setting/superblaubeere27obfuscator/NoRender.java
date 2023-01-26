

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.gui.BossInfoClient
 *  net.minecraft.client.gui.GuiBossOverlay
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.EntityBat
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.world.BossInfo
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Pre
 *  net.minecraftforge.client.event.RenderLivingEvent$Pre
 *  net.minecraftforge.event.entity.PlaySoundAtEntityEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderMapEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.BossInfoClient;
import net.minecraft.client.gui.GuiBossOverlay;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class NoRender
        extends Module {
    private static NoRender Field3527 = new NoRender();

    static {
        Field3527 = new NoRender();
    }

    public Setting<Boolean> Field3528 = this.Method2150366(new Setting<Boolean>("AntiFog", Boolean.FALSE, "Removes the portal overlay."));
    public Setting<Boolean> Field3529 = this.Method2150366(new Setting<Boolean>("Fire", Boolean.FALSE, "Removes the portal overlay."));
    public Setting<Boolean> Field3530 = this.Method2150366(new Setting<Boolean>("Portal", Boolean.FALSE, "Removes the portal overlay."));
    public Setting<Boolean> Field3531 = this.Method2150366(new Setting<Boolean>("Pumpkin", Boolean.FALSE, "Removes the pumpkin overlay."));
    public Setting<Boolean> Field3532 = this.Method2150366(new Setting<Boolean>("TotemPop", Boolean.FALSE, "Removes the Totem overlay."));
    public Setting<Boolean> Field3533 = this.Method2150366(new Setting<Boolean>("Items", Boolean.FALSE, "Removes items on the ground."));
    public Setting<Boolean> Field3534 = this.Method2150366(new Setting<Boolean>("Nausea", Boolean.FALSE, "Removes Portal Nausea."));
    public Setting<Boolean> Field3535 = this.Method2150366(new Setting<Boolean>("HurtCam", Boolean.FALSE, "Removes shaking after taking damage."));
    public Setting<Boolean> Field3536 = this.Method2150366(new Setting<Boolean>("Explosions", Boolean.FALSE, "Removes crystal explosions."));
    public Setting<Boolean> Field3537 = this.Method2150366(new Setting<Boolean>("Weather", Boolean.FALSE, "AntiWeather"));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3538 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("BossBars", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE, "Modifies the bossbars."));
    public Setting<Float> Field3539 = this.Method2150366(new Setting<Object>("Scale", Float.valueOf(0.5f), Float.valueOf(0.5f), Float.valueOf(1.0f), this::Method2162500, "Scale of the bars."));
    public Setting<Boolean> Field3540 = this.Method2150366(new Setting<Boolean>("Bats", Boolean.FALSE, "Removes bats."));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field3541 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("NoArmor", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE, "Doesnt Render Armor on players."));
    public Setting<Boolean> Field3542 = this.Method2150366(new Setting<Boolean>("Barriers", Boolean.FALSE, "Barriers"));
    public Setting<Boolean> Field3543 = this.Method2150366(new Setting<Boolean>("Blocks", Boolean.FALSE, "Blocks"));
    public Setting<Boolean> Field3544 = this.Method2150366(new Setting<Boolean>("Advancements", false));
    public Setting<Boolean> Field3545 = this.Method2150366(new Setting<Boolean>("Pigmen", false));
    public Setting<Boolean> Field3546 = this.Method2150366(new Setting<Boolean>("Map", false));
    public Setting<Boolean> Field3547 = this.Method2150366(new Setting<Boolean>("TimeChange", false));
    public Setting<Integer> Field3548 = this.Method2150366(new Setting<Object>("Time", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(23000), this::Method2162509));

    public NoRender() {
        super("NoRender", "Allows you to stop rendering stuff", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
        this.Method2162590();
    }

    public static NoRender Method2162599() {
        if (Field3527 == null) {
            Field3527 = new NoRender();
        }
        return Field3527;
    }

    private void Method2162590() {
        Field3527 = this;
    }

    @SubscribeEvent
    public void Method2162501(RenderMapEvent renderMapEvent) {
        if (this.Field3546.getValue().booleanValue()) {
            renderMapEvent.setCanceled(true);
        }
    }

    @Override
    public void Method2150379() {
        if (this.Field3533.getValue().booleanValue()) {
            NoRender.Field2811.world.loadedEntityList.stream().filter(EntityItem.class::isInstance).map(EntityItem.class::cast).forEach(Entity::setDead);
        }
        if (this.Field3537.getValue().booleanValue() && NoRender.Field2811.world.isRaining()) {
            NoRender.Field2811.world.setRainStrength(0.0f);
        }
        if (this.Field3547.getValue().booleanValue()) {
            NoRender.Field2811.world.setWorldTime((long) this.Field3548.getValue().intValue());
        }
    }

    @SubscribeEvent
    public void Method2162502(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketTimeUpdate & this.Field3547.getValue()) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.setCanceled(true);
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketExplosion & this.Field3536.getValue()) {
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.setCanceled(true);
        }
    }

    public void Method2162503(int n2, int n3, int n4) {
        Random random = new Random();
        ItemStack itemStack = NoRender.Field2811.player.getHeldItemMainhand();
        boolean bl = this.Field3542.getValue() == false || NoRender.Field2811.playerController.getCurrentGameType() == GameType.CREATIVE && !itemStack.isEmpty() && itemStack.getItem() == Item.getItemFromBlock((Block) Blocks.BARRIER);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int j = 0; j < 667; ++j) {
            this.Method2162504(n2, n3, n4, 16, random, bl, mutableBlockPos);
            this.Method2162504(n2, n3, n4, 32, random, bl, mutableBlockPos);
        }
    }

    public void Method2162504(int n2, int n3, int n4, int n5, Random random, boolean bl, BlockPos.MutableBlockPos mutableBlockPos) {
        int n6 = n2 + NoRender.Field2811.world.rand.nextInt(n5) - NoRender.Field2811.world.rand.nextInt(n5);
        int n7 = n3 + NoRender.Field2811.world.rand.nextInt(n5) - NoRender.Field2811.world.rand.nextInt(n5);
        int n8 = n4 + NoRender.Field2811.world.rand.nextInt(n5) - NoRender.Field2811.world.rand.nextInt(n5);
        mutableBlockPos.setPos(n6, n7, n8);
        IBlockState iBlockState = NoRender.Field2811.world.getBlockState((BlockPos) mutableBlockPos);
        iBlockState.getBlock().randomDisplayTick(iBlockState, (World) NoRender.Field2811.world, (BlockPos) mutableBlockPos, random);
        if (!bl && iBlockState.getBlock() == Blocks.BARRIER) {
            NoRender.Field2811.world.spawnParticle(EnumParticleTypes.BARRIER, (double) ((float) n6 + 0.5f), (double) ((float) n7 + 0.5f), (double) ((float) n8 + 0.5f), 0.0, 0.0, 0.0, new int[0]);
        }
    }

    @SubscribeEvent
    public void Method2162505(RenderGameOverlayEvent.Pre pre) {
        if (pre.getType() == RenderGameOverlayEvent.ElementType.BOSSINFO && this.Field3538.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE) {
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void Method2162506(RenderGameOverlayEvent.Post post) {
        block7:
        {
            block8:
            {
                if (post.getType() != RenderGameOverlayEvent.ElementType.BOSSINFO || this.Field3538.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE)
                    break block7;
                if (this.Field3538.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MINIMIZE)
                    break block8;
                Map map = NoRender.Field2811.ingameGUI.getBossOverlay().mapBossInfos;
                if (map == null) {
                    return;
                }
                ScaledResolution scaledResolution = new ScaledResolution(Field2811);
                int n2 = scaledResolution.getScaledWidth();
                int n3 = 12;
                for (Map.Entry entry : map.entrySet()) {
                    BossInfoClient bossInfoClient = (BossInfoClient) entry.getValue();
                    String string = bossInfoClient.getName().getFormattedText();
                    int n4 = (int) ((float) n2 / this.Field3539.getValue().floatValue() / 2.0f - 91.0f);
                    GL11.glScaled((double) this.Field3539.getValue().floatValue(), (double) this.Field3539.getValue().floatValue(), (double) 1.0);
                    if (!post.isCanceled()) {
                        GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
                        Field2811.getTextureManager().bindTexture(GuiBossOverlay.GUI_BARS_TEXTURES);
                        NoRender.Field2811.ingameGUI.getBossOverlay().render(n4, n3, (BossInfo) bossInfoClient);
                        NoRender.Field2811.fontRenderer.drawStringWithShadow(string, (float) n2 / this.Field3539.getValue().floatValue() / 2.0f - (float) (NoRender.Field2811.fontRenderer.getStringWidth(string) / 2), (float) (n3 - 9), 0xFFFFFF);
                    }
                    GL11.glScaled((double) (1.0 / (double) this.Field3539.getValue().floatValue()), (double) (1.0 / (double) this.Field3539.getValue().floatValue()), (double) 1.0);
                    n3 += 10 + NoRender.Field2811.fontRenderer.FONT_HEIGHT;
                }
                break block7;
            }
            if (this.Field3538.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STACK)
                break block7;
            Map map = NoRender.Field2811.ingameGUI.getBossOverlay().mapBossInfos;
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll;
                String string = ((BossInfoClient) entry.getValue()).getName().getFormattedText();
                if (hashMap.containsKey(string)) {
                    illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll = (IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll) hashMap.get(string);
                    illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll = new IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2162595(), illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2162597() + 1);
                    hashMap.put(string, illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll);
                    continue;
                }
                illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll = new IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(entry.getValue(), 1);
                hashMap.put(string, illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll);
            }
            ScaledResolution scaledResolution = new ScaledResolution(Field2811);
            int n5 = scaledResolution.getScaledWidth();
            int n6 = 12;
            for (Map.Entry entry : hashMap.entrySet()) {
                String string = (String) entry.getKey();
                BossInfoClient bossInfoClient = (BossInfoClient) ((IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll) entry.getValue()).Method2162595();
                int n7 = (Integer) ((IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll) entry.getValue()).Method2162597();
                string = string + " x" + n7;
                int n8 = (int) ((float) n5 / this.Field3539.getValue().floatValue() / 2.0f - 91.0f);
                GL11.glScaled((double) this.Field3539.getValue().floatValue(), (double) this.Field3539.getValue().floatValue(), (double) 1.0);
                if (!post.isCanceled()) {
                    GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
                    Field2811.getTextureManager().bindTexture(GuiBossOverlay.GUI_BARS_TEXTURES);
                    NoRender.Field2811.ingameGUI.getBossOverlay().render(n8, n6, (BossInfo) bossInfoClient);
                    NoRender.Field2811.fontRenderer.drawStringWithShadow(string, (float) n5 / this.Field3539.getValue().floatValue() / 2.0f - (float) (NoRender.Field2811.fontRenderer.getStringWidth(string) / 2), (float) (n6 - 9), 0xFFFFFF);
                }
                GL11.glScaled((double) (1.0 / (double) this.Field3539.getValue().floatValue()), (double) (1.0 / (double) this.Field3539.getValue().floatValue()), (double) 1.0);
                n6 += 10 + NoRender.Field2811.fontRenderer.FONT_HEIGHT;
            }
        }
    }

    @SubscribeEvent
    public void Method2162507(RenderLivingEvent.Pre<?> pre) {
        if (this.Field3540.getValue().booleanValue() && pre.getEntity() instanceof EntityBat) {
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void Method2162508(PlaySoundAtEntityEvent playSoundAtEntityEvent) {
        if (this.Field3540.getValue().booleanValue() && playSoundAtEntityEvent.getSound().equals((Object) SoundEvents.ENTITY_BAT_AMBIENT) || playSoundAtEntityEvent.getSound().equals((Object) SoundEvents.ENTITY_BAT_DEATH) || playSoundAtEntityEvent.getSound().equals((Object) SoundEvents.ENTITY_BAT_HURT) || playSoundAtEntityEvent.getSound().equals((Object) SoundEvents.ENTITY_BAT_LOOP) || playSoundAtEntityEvent.getSound().equals((Object) SoundEvents.ENTITY_BAT_TAKEOFF)) {
            playSoundAtEntityEvent.setVolume(0.0f);
            playSoundAtEntityEvent.setPitch(0.0f);
            playSoundAtEntityEvent.setCanceled(true);
        }
    }

    private boolean Method2162509(Object object) {
        return this.Field3547.getValue();
    }

    private boolean Method2162500(Object object) {
        return this.Field3538.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MINIMIZE || this.Field3538.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STACK;
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        NONE,
        ALL,
        HELMET;

    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        REMOVE,
        STACK,
        MINIMIZE;

    }

    public static enum IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
        NONE,
        WORLD,
        ENTITY,
        ALL;

    }

    public static class IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll<T, S> {
        private T Field3806;
        private S Field3807;

        public IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll(T t, S s) {
            this.Field3806 = t;
            this.Field3807 = s;
        }

        public T Method2162595() {
            return this.Field3806;
        }

        public void Method2162596(T t) {
            this.Field3806 = t;
        }

        public S Method2162597() {
            return this.Field3807;
        }

        public void Method2162598(S s) {
            this.Field3807 = s;
        }
    }
}

