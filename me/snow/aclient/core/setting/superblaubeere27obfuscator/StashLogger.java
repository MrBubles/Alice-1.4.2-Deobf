

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class StashLogger
        extends Module {
    final Iterator<NBTTagCompound> Field1568;
    private final Setting<Boolean> Field1562 = this.Method2150366(new Setting<Boolean>("Chests", true));
    private final Setting<Integer> Field1563 = this.Method2150366(new Setting<Object>("ChestsValue", Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(30), this::Method2161936));
    private final Setting<Boolean> Field1564 = this.Method2150366(new Setting<Boolean>("Shulkers", true));
    private final Setting<Integer> Field1565 = this.Method2150366(new Setting<Object>("ShulkersValue", Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(30), this::Method2161935));
    private final Setting<Boolean> Field1566 = this.Method2150366(new Setting<Boolean>("CoordsSaver", true));
    File Field1567;

    public StashLogger() {
        super("StashLogger", "Logs stashes", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
        this.Field1567 = new File(Minecraft.getMinecraft().gameDir + File.separator + "Alice");
        this.Field1568 = null;
    }

    @SubscribeEvent
    public void Method2161933(PacketEvent packetEvent) {
        if (StashLogger.Method2150358()) {
            return;
        }
        if (packetEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketChunkData) {
            SPacketChunkData sPacketChunkData = (SPacketChunkData) packetEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            int n2 = 0;
            int n3 = 0;
            for (NBTTagCompound nBTTagCompound : sPacketChunkData.getTileEntityTags()) {
                String string = nBTTagCompound.getString("id");
                if (string.equals("minecraft:chest") && this.Field1562.getValue().booleanValue()) {
                    ++n2;
                    continue;
                }
                if (!string.equals("minecraft:shulker_box") || !this.Field1564.getValue().booleanValue()) continue;
                ++n3;
            }
            if (n2 >= this.Field1563.getValue()) {
                this.Method2161934(String.format("%s chests located at X: %s, Z: %s", n2, sPacketChunkData.getChunkX() * 16, sPacketChunkData.getChunkZ() * 16), true);
            }
            if (n3 >= this.Field1565.getValue()) {
                this.Method2161934(String.format("%s shulker boxes at X: %s, Z: %s", n3, sPacketChunkData.getChunkX() * 16, sPacketChunkData.getChunkZ() * 16), true);
            }
        }
    }

    private void Method2161934(String string, boolean bl) {
        String string2;
        String string3 = string2 = Minecraft.getMinecraft().isSingleplayer() ? "singleplayer".toUpperCase() : StashLogger.Field2811.getCurrentServerData().serverIP;
        if (this.Field1566.getValue().booleanValue() && bl) {
            try {
                FileWriter fileWriter = new FileWriter(this.Field1567 + "/stashes.txt", true);
                fileWriter.write("[" + string2 + "]: " + string + "\n");
                fileWriter.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        Field2811.getSoundHandler().playSound((ISound) PositionedSoundRecord.getRecord((SoundEvent) SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, (float) 1.0f, (float) 1.0f));
        Command.Method2159696((Object) ChatFormatting.GREEN + string);
    }

    private boolean Method2161935(Object object) {
        return this.Field1564.getValue();
    }

    private boolean Method2161936(Object object) {
        return this.Field1562.getValue();
    }
}

