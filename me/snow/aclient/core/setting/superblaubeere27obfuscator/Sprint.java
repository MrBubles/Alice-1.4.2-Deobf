

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MoveEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Sprint
        extends Module {
    private static Sprint Field2267 = new Sprint();
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field2268 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.LEGIT));

    public Sprint() {
        super("Sprint", "Modifies sprinting", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MOVEMENT, false, false, false);
        this.Method2162143();
    }

    public static Sprint Method2162142() {
        if (Field2267 == null) {
            Field2267 = new Sprint();
        }
        return Field2267;
    }

    private void Method2162143() {
        Field2267 = this;
    }

    @SubscribeEvent
    public void Method2162144(MoveEvent moveEvent) {
        if (moveEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1 && this.Field2268.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RAGE && (Sprint.Field2811.player.movementInput.moveForward != 0.0f || Sprint.Field2811.player.movementInput.moveStrafe != 0.0f)) {
            moveEvent.setCanceled(true);
        }
    }

    @Override
    public void Method2150379() {
        switch (1.F ield2559[this.Field2268.getValue().ordinal()]){
            case 1: {
                if (!Sprint.Field2811.gameSettings.keyBindForward.isKeyDown() && !Sprint.Field2811.gameSettings.keyBindBack.isKeyDown() && !Sprint.Field2811.gameSettings.keyBindLeft.isKeyDown() && !Sprint.Field2811.gameSettings.keyBindRight.isKeyDown() || Sprint.Field2811.player.isSneaking() || Sprint.Field2811.player.collidedHorizontally || (float) Sprint.Field2811.player.getFoodStats().getFoodLevel() <= 6.0f)
                    break;
                Sprint.Field2811.player.setSprinting(true);
                break;
            }
            case 2: {
                if (!Sprint.Field2811.gameSettings.keyBindForward.isKeyDown() || Sprint.Field2811.player.isSneaking() || Sprint.Field2811.player.isHandActive() || Sprint.Field2811.player.collidedHorizontally || (float) Sprint.Field2811.player.getFoodStats().getFoodLevel() <= 6.0f || Sprint.Field2811.currentScreen != null)
                    break;
                Sprint.Field2811.player.setSprinting(true);
            }
        }
    }

    @Override
    public void Method2150373() {
        if (!Sprint.Method2150358()) {
            Sprint.Field2811.player.setSprinting(false);
        }
    }

    @Override
    public String Method2150385() {
        return this.Field2268.currentEnumName();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        LEGIT,
        RAGE;

    }
}

