

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemPickaxe
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;

public class NoEntityTrace
        extends Module {
    private static NoEntityTrace Field2371 = new NoEntityTrace();
    public Setting<Boolean> Field2372 = this.Method2150366(new Setting<Boolean>("Pick", true));
    public Setting<Boolean> Field2373 = this.Method2150366(new Setting<Boolean>("Gap", false));
    public Setting<Boolean> Field2374 = this.Method2150366(new Setting<Boolean>("Obby", false));
    public boolean Field2375;

    public NoEntityTrace() {
        super("NoEntityTrace", "Mine through entities", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, false, false, false);
        this.Method2162268();
    }

    public static NoEntityTrace Method2162267() {
        if (Field2371 == null) {
            Field2371 = new NoEntityTrace();
        }
        return Field2371;
    }

    private void Method2162268() {
        Field2371 = this;
    }

    @Override
    public void Method2150379() {
        Item item = NoEntityTrace.Field2811.player.getHeldItemMainhand().getItem();
        if (item instanceof ItemPickaxe && this.Field2372.getValue().booleanValue()) {
            this.Field2375 = true;
            return;
        }
        if (item == Items.GOLDEN_APPLE && this.Field2373.getValue().booleanValue()) {
            this.Field2375 = true;
            return;
        }
        if (item instanceof ItemBlock) {
            this.Field2375 = ((ItemBlock) item).getBlock() == Blocks.OBSIDIAN && this.Field2374.getValue() != false;
            return;
        }
        this.Field2375 = false;
    }
}

