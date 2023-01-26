

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.util.EnumHand
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.util.EnumHand;

public class AutoFrameDupe
        extends Module {
    public Setting<Boolean> Field687 = this.Method2150366(new Setting<Boolean>("Shulkers Only", true));
    public Setting<Integer> Field688 = this.Method2150366(new Setting<Integer>("Range", 5, 0, 6));
    public Setting<Integer> Field689 = this.Method2150366(new Setting<Integer>("Turns", 1, 0, 3));
    public Setting<Integer> Field690 = this.Method2150366(new Setting<Integer>("Ticks", 10, 1, 20));
    private int Field691 = 0;

    public AutoFrameDupe() {
        super("FrameDupe", "6b dupe.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @Override
    public void Method2150379() {
        if (AutoFrameDupe.Field2811.player != null && AutoFrameDupe.Field2811.world != null) {
            int n2;
            if (this.Field687.getValue().booleanValue() && (n2 = this.Method2161798()) != -1) {
                AutoFrameDupe.Field2811.player.inventory.currentItem = n2;
            }
            for (Entity entity : AutoFrameDupe.Field2811.world.loadedEntityList) {
                if (!(entity instanceof EntityItemFrame) || !(AutoFrameDupe.Field2811.player.getDistance(entity) <= (float) this.Field688.getValue().intValue()))
                    continue;
                if (this.Field691 >= this.Field690.getValue()) {
                    if (((EntityItemFrame) entity).getDisplayedItem().getItem() == Items.AIR && !AutoFrameDupe.Field2811.player.getHeldItemMainhand().isEmpty) {
                        AutoFrameDupe.Field2811.playerController.interactWithEntity((EntityPlayer) AutoFrameDupe.Field2811.player, entity, EnumHand.MAIN_HAND);
                    }
                    if (((EntityItemFrame) entity).getDisplayedItem().getItem() != Items.AIR) {
                        for (int j = 0; j < this.Field689.getValue(); ++j) {
                            AutoFrameDupe.Field2811.playerController.interactWithEntity((EntityPlayer) AutoFrameDupe.Field2811.player, entity, EnumHand.MAIN_HAND);
                        }
                        AutoFrameDupe.Field2811.playerController.attackEntity((EntityPlayer) AutoFrameDupe.Field2811.player, entity);
                        this.Field691 = 0;
                    }
                }
                ++this.Field691;
            }
        }
    }

    private int Method2161798() {
        int n2 = -1;
        for (int j = 0; j < 9; ++j) {
            Item item = AutoFrameDupe.Field2811.player.inventory.getStackInSlot(j).getItem();
            if (!(item instanceof ItemShulkerBox)) continue;
            n2 = j;
        }
        return n2;
    }
}

