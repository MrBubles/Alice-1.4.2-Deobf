

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Objects;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class YawPitchLock
        extends Module {
    public Setting<Boolean> Field1762 = this.Method2150366(new Setting<Boolean>("LockYaw", false));
    public Setting<Boolean> Field1763 = this.Method2150366(new Setting<Boolean>("ByDirection", false));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1764 = this.Method2150366(new Setting<Object>("Direction", (Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORTH, this::Method2162335));
    public Setting<Integer> Field1765 = this.Method2150366(new Setting<Object>("Yaw", Integer.valueOf(0), Integer.valueOf(-180), Integer.valueOf(180), this::Method2162334));
    public Setting<Boolean> Field1766 = this.Method2150366(new Setting<Boolean>("LockPitch", false));
    public Setting<Integer> Field1767 = this.Method2150366(new Setting<Integer>("Pitch", 0, -180, 180));

    public YawPitchLock() {
        super("YawLock", "Locks your yaw", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    @SubscribeEvent
    public void Method2162332(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (this.Field1762.getValue().booleanValue()) {
            if (this.Field1763.getValue().booleanValue()) {
                switch (1.F ield3932[this.Field1764.getValue().ordinal()]){
                    case 1: {
                        this.Method2162333(180);
                        break;
                    }
                    case 2: {
                        this.Method2162333(225);
                        break;
                    }
                    case 3: {
                        this.Method2162333(270);
                        break;
                    }
                    case 4: {
                        this.Method2162333(315);
                        break;
                    }
                    case 5: {
                        this.Method2162333(0);
                        break;
                    }
                    case 6: {
                        this.Method2162333(45);
                        break;
                    }
                    case 7: {
                        this.Method2162333(90);
                        break;
                    }
                    case 8: {
                        this.Method2162333(135);
                    }
                }
            } else {
                this.Method2162333(this.Field1765.getValue());
            }
        }
        if (this.Field1766.getValue().booleanValue()) {
            if (YawPitchLock.Field2811.player.isRiding()) {
                Objects.requireNonNull(YawPitchLock.Field2811.player.getRidingEntity()).rotationPitch = this.Field1767.getValue().intValue();
            }
            YawPitchLock.Field2811.player.rotationPitch = this.Field1767.getValue().intValue();
        }
    }

    private void Method2162333(int n2) {
        if (YawPitchLock.Field2811.player.isRiding()) {
            Objects.requireNonNull(YawPitchLock.Field2811.player.getRidingEntity()).rotationYaw = n2;
        }
        YawPitchLock.Field2811.player.rotationYaw = n2;
    }

    private boolean Method2162334(Object object) {
        return this.Field1763.getValue() == false;
    }

    private boolean Method2162335(Object object) {
        return this.Field1763.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NORTH,
        NE,
        EAST,
        SE,
        SOUTH,
        SW,
        WEST,
        NW;

    }
}

