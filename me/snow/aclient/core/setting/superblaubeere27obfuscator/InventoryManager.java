

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class InventoryManager
        implements Util {
    public Map<String, List<ItemStack>> Field2486 = new HashMap<String, List<ItemStack>>();
    private int Field2487 = -1;

    public void Method2150184() {
        if (this.Field2487 != -1) {
            InventoryManager.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2487 == 8 ? 7 : this.Field2487 + 1));
            InventoryManager.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field2487));
            InventoryManager.Field2811.player.inventory.currentItem = this.Field2487;
            InventoryManager.Field2811.playerController.syncCurrentPlayItem();
            this.Field2487 = -1;
        }
    }

    public void Method2150185(int n2) {
        this.Field2487 = n2;
    }
}

