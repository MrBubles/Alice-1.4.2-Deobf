

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.ClientChatEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.client.event.RenderHandEvent
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.Event
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$Phase
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientConnectedToServerEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientDisconnectionFromServerEvent
 *  org.lwjgl.opengl.GL11
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.base.Strings;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ChorusEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ConnectionEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DeathEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GLUProjection;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NewNotification;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TotemPopCounter;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TotemPopEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.lwjgl.opengl.GL11;

public class EventManager1
        extends Feature {
    private final Timer Field3952 = new Timer();
    private final Timer Field3953 = new Timer();
    private final Timer Field3954 = new Timer();
    private final Timer Field3955 = new Timer();
    private final AtomicBoolean Field3956 = new AtomicBoolean(false);
    private boolean Field3957;

    private static void Method2150147(SPacketPlayerListItem sPacketPlayerListItem, SPacketPlayerListItem.AddPlayerData addPlayerData) {
        UUID uUID = addPlayerData.getProfile().getId();
        switch (sPacketPlayerListItem.getAction()) {
            case ADD_PLAYER: {
                String string = addPlayerData.getProfile().getName();
                MinecraftForge.EVENT_BUS.post((Event) new ConnectionEvent(0, uUID, string));
                break;
            }
            case REMOVE_PLAYER: {
                EntityPlayer entityPlayer = EventManager1.Field2811.world.getPlayerEntityByUUID(uUID);
                if (entityPlayer != null) {
                    String string = entityPlayer.getName();
                    MinecraftForge.EVENT_BUS.post((Event) new ConnectionEvent(1, entityPlayer, uUID, string));
                    break;
                }
                MinecraftForge.EVENT_BUS.post((Event) new ConnectionEvent(2, uUID, null));
            }
        }
    }

    private static boolean Method2150148(SPacketPlayerListItem.AddPlayerData addPlayerData) {
        return !Strings.isNullOrEmpty((String) addPlayerData.getProfile().getName()) || addPlayerData.getProfile().getId() != null;
    }

    @SubscribeEvent
    public void Method2150129(RenderHandEvent renderHandEvent) {
        AliceMain.Field756.Method2150187(renderHandEvent);
    }

    public void Method2150120() {
        MinecraftForge.EVENT_BUS.register((Object) this);
    }

    public void Method2150131() {
        MinecraftForge.EVENT_BUS.unregister((Object) this);
    }

    @SubscribeEvent
    public void Method2150132(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        if (!EventManager1.Method2150359() && livingUpdateEvent.getEntity().getEntityWorld().isRemote && livingUpdateEvent.getEntityLiving().equals((Object) EventManager1.Field2811.player)) {
            AliceMain.Field769.Method2150264();
            AliceMain.Field774.Method2150336();
            AliceMain.Field770.Method2150184();
            AliceMain.Field775.Method2150177();
            AliceMain.Field777.Method2150294();
            AliceMain.Field756.Method2150102();
            AliceMain.Field771.Method2150333();
            if (this.Field3952.Method2164755(0L)) {
                AliceMain.Field756.Method2150106(true);
                AliceMain.Field756.Method2150107();
                this.Field3952.Method2164750();
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void Method2150133(TickEvent.ClientTickEvent clientTickEvent) {
        if (clientTickEvent.phase == TickEvent.Phase.START) {
            this.Field3956.set(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void Method2150134(TickEvent.ClientTickEvent clientTickEvent) {
        if (clientTickEvent.phase == TickEvent.Phase.END) {
            this.Field3956.set(false);
            AutoCrystal.Method2150936().Method2150938();
        }
    }

    public boolean Method2150135() {
        return this.Field3956.get();
    }

    @SubscribeEvent
    public void Method2150136(FMLNetworkEvent.ClientConnectedToServerEvent clientConnectedToServerEvent) {
        this.Field3953.Method2164750();
        AliceMain.Field756.Method2150109();
    }

    @SubscribeEvent
    public void Method2150137(FMLNetworkEvent.ClientDisconnectionFromServerEvent clientDisconnectionFromServerEvent) {
        AliceMain.Field756.Method2150108();
        AliceMain.Field774.Method2150338();
        AliceMain.Field769.Method2150262();
    }

    @SubscribeEvent
    public void Method2150138(TickEvent.ClientTickEvent clientTickEvent) {
        if (EventManager1.Method2150359()) {
            return;
        }
        AliceMain.Field756.Method2150103();
        for (EntityPlayer entityPlayer : EventManager1.Field2811.world.playerEntities) {
            if (entityPlayer == null || entityPlayer.getHealth() > 0.0f) continue;
            MinecraftForge.EVENT_BUS.post((Event) new DeathEvent(entityPlayer));
            TotemPopCounter.Method2150742().Method2150744(entityPlayer);
            NewNotification.Method2162740().Method2162753(entityPlayer);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void Method2150139(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (EventManager1.Method2150359()) {
            return;
        }
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            AliceMain.Field779.Method2150222();
            AliceMain.Field757.Method2150200();
            AliceMain.Field760.Method2150276();
            AliceMain.Field758.Method2150249();
        }
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1) {
            AliceMain.Field760.Method2150277();
            AliceMain.Field758.Method2150240();
        }
    }

    @SubscribeEvent
    public void Method2150130(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketHeldItemChange) {
            this.Field3954.Method2164750();
        }
    }

    public boolean Method2150141() {
        return !this.Field3954.Method2164755(500L);
    }

    @SubscribeEvent
    public void Method2150142(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0) {
            return;
        }
        AliceMain.Field768.Method2150298();
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityStatus) {
            SPacketEntityStatus sPacketEntityStatus = (SPacketEntityStatus) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketEntityStatus.getOpCode() == 35 && sPacketEntityStatus.getEntity((World) EventManager1.Field2811.world) instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer) sPacketEntityStatus.getEntity((World) EventManager1.Field2811.world);
                MinecraftForge.EVENT_BUS.post((Event) new TotemPopEvent(entityPlayer));
                TotemPopCounter.Method2150742().Method2150745(entityPlayer);
                NewNotification.Method2162740().Method2162752(entityPlayer);
                AliceMain.Field774.Method2150330(entityPlayer);
                AliceMain.Field769.Method2150267(entityPlayer);
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerListItem && !EventManager1.Method2150359() && this.Field3953.Method2164751(1.0)) {
            SPacketPlayerListItem sPacketPlayerListItem = (SPacketPlayerListItem) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (!SPacketPlayerListItem.Action.ADD_PLAYER.equals((Object) sPacketPlayerListItem.getAction()) && !SPacketPlayerListItem.Action.REMOVE_PLAYER.equals((Object) sPacketPlayerListItem.getAction())) {
                return;
            }
            sPacketPlayerListItem.getEntries().stream().filter(Objects::nonNull).filter(EventManager1::Method2150148).forEach(arg_0 -> EventManager1.Method2150147(sPacketPlayerListItem, arg_0));
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketTimeUpdate) {
            AliceMain.Field768.Method2150201();
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect && ((SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getSound() == SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT) {
            if (!this.Field3955.Method2164755(100L)) {
                MinecraftForge.EVENT_BUS.post((Event) new ChorusEvent(((SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getX(), ((SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getY(), ((SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getZ()));
            }
            this.Field3955.Method2164750();
        }
    }

    @SubscribeEvent
    public void Method2150143(RenderWorldLastEvent renderWorldLastEvent) {
        if (renderWorldLastEvent.isCanceled()) {
            return;
        }
        EventManager1.Field2811.profiler.startSection("phobos");
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int) 770, (int) 771, (int) 1, (int) 0);
        GlStateManager.shadeModel((int) 7425);
        GlStateManager.disableDepth();
        GlStateManager.glLineWidth((float) 1.0f);
        Render3DEvent render3DEvent = new Render3DEvent(renderWorldLastEvent.getPartialTicks());
        GLUProjection gLUProjection = GLUProjection.Method2163610();
        IntBuffer intBuffer = GLAllocation.createDirectIntBuffer((int) 16);
        FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer((int) 16);
        FloatBuffer floatBuffer2 = GLAllocation.createDirectFloatBuffer((int) 16);
        GL11.glGetFloat((int) 2982, (FloatBuffer) floatBuffer);
        GL11.glGetFloat((int) 2983, (FloatBuffer) floatBuffer2);
        GL11.glGetInteger((int) 2978, (IntBuffer) intBuffer);
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        gLUProjection.Method2163621(intBuffer, floatBuffer, floatBuffer2, (double) scaledResolution.getScaledWidth() / (double) Minecraft.getMinecraft().displayWidth, (double) scaledResolution.getScaledHeight() / (double) Minecraft.getMinecraft().displayHeight);
        AliceMain.Field756.Method2150105(render3DEvent);
        GlStateManager.glLineWidth((float) 1.0f);
        GlStateManager.shadeModel((int) 7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.enableCull();
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
        EventManager1.Field2811.profiler.endSection();
    }

    @SubscribeEvent
    public void Method2150144(RenderGameOverlayEvent.Post post) {
        if (post.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            AliceMain.Field766.Method2150324();
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void Method2150145(RenderGameOverlayEvent.Text text) {
        if (text.getType().equals((Object) RenderGameOverlayEvent.ElementType.TEXT)) {
            ScaledResolution scaledResolution = new ScaledResolution(Field2811);
            Render2DEvent render2DEvent = new Render2DEvent(text.getPartialTicks(), scaledResolution);
            AliceMain.Field756.Method2150104(render2DEvent);
            GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void Method2150146(ClientChatEvent clientChatEvent) {
        if (clientChatEvent.getMessage().startsWith(Command.Method2159601())) {
            clientChatEvent.setCanceled(true);
            try {
                EventManager1.Field2811.ingameGUI.getChatGUI().addToSentMessages(clientChatEvent.getMessage());
                if (clientChatEvent.getMessage().length() > 1) {
                    AliceMain.Field761.Method2159009(clientChatEvent.getMessage().substring(Command.Method2159601().length() - 1));
                } else {
                    Command.Method2159696("Please enter a command.");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                Command.Method2159696("\u00a7cAn error occurred while running this command. Check the log!");
            }
            clientChatEvent.setMessage("");
        }
    }
}

