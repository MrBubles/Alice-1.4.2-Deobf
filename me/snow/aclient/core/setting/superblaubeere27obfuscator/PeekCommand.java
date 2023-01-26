

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.item.ItemStack
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Map;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ToolTips;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;

public class PeekCommand
        extends Command {
    public PeekCommand() {
        super("peek", new String[]{"<player>"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 1) {
            ItemStack itemStack = PeekCommand.Field2811.player.getHeldItemMainhand();
            if (itemStack.getItem() instanceof ItemShulkerBox) {
                ToolTips.Method2161938(itemStack, null);
            } else {
                Command.Method2159696("\u00a7cYou need to hold a Shulker in your mainhand.");
                return;
            }
        }
        if (arrstring.length > 1) {
            if (ToolTips.Method2161937().Method2150386() && ToolTips.Method2161937().Field930.getValue().booleanValue()) {
                for (Map.Entry entry : ToolTips.Method2161937().Field945.entrySet()) {
                    if (!((EntityPlayer) entry.getKey()).getName().equalsIgnoreCase(arrstring[0])) continue;
                    ItemStack itemStack = (ItemStack) entry.getValue();
                    ToolTips.Method2161938(itemStack, ((EntityPlayer) entry.getKey()).getName());
                    break;
                }
            } else {
                Command.Method2159696("\u00a7cYou need to turn on Tooltips - ShulkerSpy");
            }
        }
    }
}

