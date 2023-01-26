

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIlIIlllIlIllIIIllIIIlIIIllIIIllIIllIIlllIlllIlllIIllIIlIIIlllIIIlllIllIlllIIlIllIlIIlIIllIlIllIIllIlIlllIIllIlIlIIlIlIIlllIIIlIIllIIIlIIllIIlllIlllIIlIlllIIIlIIlllIllIIllIIllIllIIllIIllIIllIllIIlIlllIlllIlllIIlIIIlllIIIlll
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.item.ItemStack
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIlIIlllIlIllIIIllIIIlIIIllIIIllIIllIIlllIlllIlllIIllIIlIIIlllIIIlllIllIlllIIlIllIlIIlIIllIlIllIIllIlIlllIIllIlIlIIlIlIIlllIIIlIIllIIIlIIllIIlllIlllIIlIlllIIIlIIlllIllIIllIIllIllIIllIIllIIllIllIIlIlllIlllIlllIIlIIIlllIIIlll;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiScreen.class})
public class MixinGuiScreen
extends Gui {
    @Inject(method={"renderToolTip"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderToolTipHook(ItemStack stack, int x2, int y, CallbackInfo info) {
        if (IllIlIIlllIlIllIIIllIIIlIIIllIIIllIIllIIlllIlllIlllIIllIIlIIIlllIIIlllIllIlllIIlIllIlIIlIIllIlIllIIllIlIlllIIllIlIlIIlIlIIlllIIIlIIllIIIlIIllIIlllIlllIIlIlllIIIlIIlllIllIIllIIllIllIIllIIllIIllIllIIlIlllIlllIlllIIlIIIlllIIIlll.Method2161937().Method2150386() && ((Boolean)IllIlIIlllIlIllIIIllIIIlIIIllIIIllIIllIIlllIlllIlllIIllIIlIIIlllIIIlllIllIlllIIlIllIlIIlIIllIlIllIIllIlIlllIIllIlIlIIlIlIIlllIIIlIIllIIIlIIllIIlllIlllIIlIlllIIIlIIlllIllIIllIIllIllIIllIIllIIllIllIIlIlllIlllIlllIIlIIIlllIIIlll.Method2161937().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue()).booleanValue() && stack.getItem() instanceof ItemShulkerBox) {
            IllIlIIlllIlIllIIIllIIIlIIIllIIIllIIllIIlllIlllIlllIIllIIlIIIlllIIIlllIllIlllIIlIllIlIIlIIllIlIllIIllIlIlllIIllIlIlIIlIlIIlllIIIlIIllIIIlIIllIIlllIlllIIlIlllIIIlIIlllIllIIllIIllIllIIllIIllIIllIllIIlIlllIlllIlllIIlIIIlllIIIlll.Method2161937().Method2161943(stack, x2, y, null);
            info.cancel();
        }
    }
}

