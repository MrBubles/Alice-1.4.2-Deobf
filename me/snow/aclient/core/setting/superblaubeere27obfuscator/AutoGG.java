

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.world.World
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceAura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DeathEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FileManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoGG
        extends Module {
    private static final String Field2129 = "phobos/autogg.txt";
    private final Setting<Boolean> Field2130 = this.Method2150366(new Setting<Boolean>("OwnDeath", false));
    private final Setting<Boolean> Field2131 = this.Method2150366(new Setting<Boolean>("Greentext", false));
    private final Setting<Boolean> Field2132 = this.Method2150366(new Setting<Boolean>("LoadFiles", false));
    private final Setting<Integer> Field2133 = this.Method2150366(new Setting<Integer>("Reset", 30, 0, 90));
    private final Setting<Integer> Field2134 = this.Method2150366(new Setting<Integer>("Delay", 10, 0, 30));
    private final Setting<Boolean> Field2135 = this.Method2150366(new Setting<Boolean>("Test", false));
    private final Timer Field2139 = new Timer();
    private final Timer Field2140 = new Timer();
    public Map<EntityPlayer, Integer> Field2136 = new ConcurrentHashMap<EntityPlayer, Integer>();
    public List<String> Field2137 = new ArrayList<String>();
    public EntityPlayer Field2138;
    private boolean Field2141;

    public AutoGG() {
        super("AutoGG", "Automatically GGs", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
        File file = new File(Field2129);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void Method2150372() {
        this.Method2161702();
        this.Field2139.Method2164750();
        this.Field2140.Method2164750();
    }

    @Override
    public void Method2150376() {
        if (this.Field2132.getValue().booleanValue()) {
            this.Method2161702();
            Command.Method2159696("<AutoGG> Loaded messages.");
            this.Field2132.setValue(false);
        }
        if (AliceAura.Method2150751().Field4180 != null && !AliceAura.Method2150751().Field4181.Method2164755(800L) && this.Field2138 != AliceAura.Method2150751().Field4180) {
            this.Field2138 = AliceAura.Method2150751().Field4180;
        }
        if (this.Field2135.getValue().booleanValue()) {
            this.Method2161704((EntityPlayer) AutoGG.Field2811.player);
            this.Field2135.setValue(false);
        }
        if (!this.Field2141) {
            this.Field2140.Method2164750();
        }
        if (this.Field2140.Method2164751(this.Field2134.getValue().intValue()) && this.Field2141) {
            this.Field2141 = false;
            this.Field2140.Method2164750();
        }
        if (AliceAura.Method2150751().Field4180 != null && !AliceAura.Method2150751().Field4181.Method2164755(800L)) {
            this.Field2136.put(AliceAura.Method2150751().Field4180, (int) (this.Field2139.Method2164759() / 1000L));
        }
        this.Field2136.replaceAll((arg_0, arg_1) -> this.Method2161705(arg_0, arg_1));
        for (EntityPlayer entityPlayer : this.Field2136.keySet()) {
            if (this.Field2136.get((Object) entityPlayer) <= this.Field2133.getValue()) continue;
            this.Field2136.remove((Object) entityPlayer);
            this.Field2139.Method2164750();
        }
    }

    @SubscribeEvent
    public void Method2161799(DeathEvent deathEvent) {
        if (this.Field2136.containsKey((Object) deathEvent.Field2030) && !this.Field2141) {
            this.Method2161704(deathEvent.Field2030);
            this.Field2141 = true;
            this.Field2136.remove((Object) deathEvent.Field2030);
        }
        if (deathEvent.Field2030 == this.Field2138 && !this.Field2141) {
            this.Method2161704(deathEvent.Field2030);
            this.Field2141 = true;
        }
        if (deathEvent.Field2030 == AutoGG.Field2811.player && this.Field2130.getValue().booleanValue()) {
            this.Method2161704(deathEvent.Field2030);
            this.Field2141 = true;
        }
    }

    @SubscribeEvent
    public void Method2161790(AttackEntityEvent attackEntityEvent) {
        if (attackEntityEvent.getTarget() instanceof EntityPlayer && !AliceMain.Field765.Method2150169(attackEntityEvent.getEntityPlayer())) {
            this.Field2136.put((EntityPlayer) attackEntityEvent.getTarget(), 0);
        }
    }

    @SubscribeEvent
    public void Method2161701(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        CPacketUseEntity cPacketUseEntity;
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction() == CPacketUseEntity.Action.ATTACK && cPacketUseEntity.getEntityFromWorld((World) AutoGG.Field2811.world) instanceof EntityPlayer && !AliceMain.Field765.Method2150169((EntityPlayer) cPacketUseEntity.getEntityFromWorld((World) AutoGG.Field2811.world))) {
            this.Field2136.put((EntityPlayer) cPacketUseEntity.getEntityFromWorld((World) AutoGG.Field2811.world), 0);
        }
    }

    public void Method2161702() {
        this.Field2137 = FileManager.Method2150140(Field2129);
    }

    public String Method2161703() {
        this.Method2161702();
        Random random = new Random();
        if (this.Field2137.size() == 0) {
            return "uwu <player> got qwq By LuigiHack | \u0e05\u2022\u03c9\u2022\u0e05 meow";
        }
        if (this.Field2137.size() == 1) {
            return this.Field2137.get(0);
        }
        return this.Field2137.get(MathUtil.Method2163843(random.nextInt(this.Field2137.size()), 0, this.Field2137.size() - 1));
    }

    public void Method2161704(EntityPlayer entityPlayer) {
        AutoGG.Field2811.player.connection.sendPacket((Packet) new CPacketChatMessage((this.Field2131.getValue() != false ? ">" : "") + this.Method2161703().replaceAll("<player>", entityPlayer.getDisplayNameString())));
    }

    private Integer Method2161705(EntityPlayer entityPlayer, Integer n2) {
        return (int) (this.Field2139.Method2164759() / 1000L);
    }
}

