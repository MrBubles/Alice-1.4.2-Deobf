

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class MCF
        extends Module {
    private final Setting<Boolean> Field3866 = this.Method2150366(new Setting<Boolean>("MiddleClick", true));
    private final Setting<Boolean> Field3867 = this.Method2150366(new Setting<Boolean>("Keyboard", false));
    private final Setting<Boolean> Field3868 = this.Method2150366(new Setting<Boolean>("Send Msgs", true));
    private final Setting<Bind> Field3869 = this.Method2150366(new Setting<Object>("KeyBind", new Bind(-1), this::Method2161878));
    private boolean Field3870;

    public MCF() {
        super("MCF", "Middleclick Friends.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
    }

    @Override
    public void Method2150379() {
        if (Mouse.isButtonDown((int) 2)) {
            if (!this.Field3870 && this.Field3866.getValue().booleanValue() && MCF.Field2811.currentScreen == null) {
                this.Method2161877();
            }
            this.Field3870 = true;
        } else {
            this.Field3870 = false;
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void Method2161876(InputEvent.KeyInputEvent keyInputEvent) {
        if (this.Field3867.getValue().booleanValue() && Keyboard.getEventKeyState() && !(MCF.Field2811.currentScreen instanceof LuigiGuiOld) && this.Field3869.getValue().getKey() == Keyboard.getEventKey()) {
            this.Method2161877();
        }
    }

    private void Method2161877() {
        Entity entity;
        RayTraceResult rayTraceResult = MCF.Field2811.objectMouseOver;
        if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.ENTITY && (entity = rayTraceResult.entityHit) instanceof EntityPlayer) {
            if (AliceMain.Field765.Method2150168(entity.getName())) {
                AliceMain.Field765.Method2150171(entity.getName());
                Command.Method2159696("\u00a7c" + entity.getName() + "\u00a7r unfriended.");
                if (this.Field3868.getValue().booleanValue()) {
                    // empty if block
                }
            } else {
                AliceMain.Field765.Method2150160(entity.getName());
                Command.Method2159696("\u00a7b" + entity.getName() + "\u00a7r friended.");
                if (this.Field3868.getValue().booleanValue()) {
                    MCF.Field2811.player.sendChatMessage("/msg " + entity.getName() + " You got added to " + HUD.Field2811.player.getDisplayNameString() + "'s friends list.");
                }
            }
        }
        this.Field3870 = true;
    }

    private boolean Method2161878(Object object) {
        return this.Field3867.getValue();
    }
}

