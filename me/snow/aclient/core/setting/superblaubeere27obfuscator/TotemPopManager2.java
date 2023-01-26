

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EnumStages;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventHandler;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventPacketRecieve;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventTotemPop;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listenable;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Listener;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TotemPopManager2
        implements Util,
        Listenable {
    public static ConcurrentHashMap<EntityLivingBase, Integer> Field3601;
    @EventHandler
    private final Listener<EventPacketRecieve> Field3602;

    public TotemPopManager2() {
        SPacketEntityStatus[] arrsPacketEntityStatus = new SPacketEntityStatus[1];
        EntityLivingBase[] arrentityLivingBase = new EntityLivingBase[1];
        int[] arrn = new int[1];
        this.Field3602 = new Listener<EventPacketRecieve>(arg_0 -> TotemPopManager2.Method2150355(arrsPacketEntityStatus, arrentityLivingBase, arrn, arg_0), new Predicate[0]);
        Field3601 = new ConcurrentHashMap();
        AliceMain.Field759.Method2164861(this);
        MinecraftForge.EVENT_BUS.register((Object) this);
    }

    private static void Method2150351() {
        for (EntityLivingBase entityLivingBase : Field3601.keySet()) {
            if (TotemPopManager2.Field2811.world.loadedEntityList.contains((Object) entityLivingBase)) continue;
            Field3601.remove((Object) entityLivingBase);
        }
    }

    public static int Method2150353(EntityLivingBase entityLivingBase) {
        if (Field3601.containsKey((Object) entityLivingBase)) {
            return Field3601.get((Object) entityLivingBase);
        }
        return 0;
    }

    public static int Method2150354(String string) {
        boolean bl = false;
        EntityLivingBase entityLivingBase = null;
        for (Entity entity : TotemPopManager2.Field2811.world.loadedEntityList) {
            if (!(entity instanceof EntityLivingBase) || !entity.getName().equals(string)) continue;
            bl = true;
            entityLivingBase = (EntityLivingBase) entity;
            break;
        }
        if (bl && Field3601.containsKey((Object) entityLivingBase)) {
            return Field3601.get((Object) entityLivingBase);
        }
        return 0;
    }

    private static void Method2150355(SPacketEntityStatus[] arrsPacketEntityStatus, EntityLivingBase[] arrentityLivingBase, int[] arrn, EventPacketRecieve eventPacketRecieve) {
        if (TotemPopManager2.Field2811.player == null || TotemPopManager2.Field2811.world == null) {
            return;
        }
        if (eventPacketRecieve.Method2159025() instanceof SPacketEntityStatus) {
            arrsPacketEntityStatus[0] = (SPacketEntityStatus) eventPacketRecieve.Method2159025();
            arrentityLivingBase[0] = (EntityLivingBase) arrsPacketEntityStatus[0].getEntity((World) TotemPopManager2.Field2811.world);
            if (arrsPacketEntityStatus[0].getOpCode() == 35) {
                if (Field3601.containsKey((Object) arrentityLivingBase[0])) {
                    arrn[0] = Field3601.get((Object) arrentityLivingBase[0]) + 1;
                    AliceMain.Field759.Method2164871(new EventTotemPop(EnumStages.PRE, arrentityLivingBase[0], arrn[0]));
                    Field3601.remove((Object) arrentityLivingBase[0]);
                    Field3601.put(arrentityLivingBase[0], arrn[0]);
                } else {
                    AliceMain.Field759.Method2164871(new EventTotemPop(EnumStages.PRE, arrentityLivingBase[0], 1));
                    Field3601.put(arrentityLivingBase[0], 1);
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2150352(TickEvent.ClientTickEvent clientTickEvent) {
        if (TotemPopManager2.Field2811.player == null || TotemPopManager2.Field2811.world == null) {
            Field3601.clear();
            return;
        }
        TotemPopManager2.Method2150351();
    }
}

