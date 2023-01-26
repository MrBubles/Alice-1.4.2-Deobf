/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.MovementInput
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.EventStage;
import net.minecraft.util.MovementInput;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PlayerUpdateMoveStateEvent
        extends EventStage {
    @NotNull
    private final MovementInput Field2170;

    public PlayerUpdateMoveStateEvent(@NotNull MovementInput movementInput) {
        this.Field2170 = movementInput;
    }

    public static PlayerUpdateMoveStateEvent IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(PlayerUpdateMoveStateEvent playerUpdateMoveStateEvent, MovementInput movementInput, int n2, Object object) {
        if ((n2 & 1) == 0) {
            return playerUpdateMoveStateEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(movementInput);
        }
        movementInput = playerUpdateMoveStateEvent.Field2170;
        return playerUpdateMoveStateEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(movementInput);
    }

    @NotNull
    public final MovementInput IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() {
        return this.Field2170;
    }

    @NotNull
    public final MovementInput IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        return this.Field2170;
    }

    @NotNull
    public final PlayerUpdateMoveStateEvent IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(@NotNull MovementInput movementInput) {
        return new PlayerUpdateMoveStateEvent(movementInput);
    }

    @NotNull
    public String toString() {
        return "PlayerUpdateMoveStateEvent(movementInput=" + (Object) this.Field2170 + ')';
    }

    public int hashCode() {
        return this.Field2170.hashCode();
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayerUpdateMoveStateEvent)) {
            return false;
        }
        PlayerUpdateMoveStateEvent playerUpdateMoveStateEvent = (PlayerUpdateMoveStateEvent) ((Object) object);
        return this.Field2170 == playerUpdateMoveStateEvent.Field2170;
    }
}

