

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderPlayerEvent$Pre
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChamsOld
        extends Module {
    private static ChamsOld Field3762 = new ChamsOld();
    public final Setting<Float> Field3767 = this.Method2150366(new Setting<Float>("PAlpha", Float.valueOf(85.0f), Float.valueOf(0.1f), Float.valueOf(255.0f)));
    public final Setting<Float> Field3768 = this.Method2150366(new Setting<Float>("PLineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(3.0f)));
    public Setting<Boolean> Field3763 = this.Method2150366(new Setting<Boolean>("ColorSync", Boolean.FALSE));
    public Setting<Integer> Field3764 = this.Method2150366(new Setting<Integer>("Red", 168, 0, 255));
    public Setting<Integer> Field3765 = this.Method2150366(new Setting<Integer>("Green", 0, 0, 255));
    public Setting<Integer> Field3766 = this.Method2150366(new Setting<Integer>("Blue", 232, 0, 255));
    public Setting<Boolean> Field3769 = this.Method2150366(new Setting<Boolean>("Solid", Boolean.FALSE));
    public Setting<Boolean> Field3770 = this.Method2150366(new Setting<Boolean>("WireFrame", Boolean.FALSE));
    public Setting<Boolean> Field3771 = this.Method2150366(new Setting<Boolean>("PlayerModel", Boolean.FALSE, this::Method2162355));
    public Setting<Integer> Field3772 = this.Method2150366(new Setting<Integer>("FriendRed", 0, 0, 255));
    public Setting<Integer> Field3773 = this.Method2150366(new Setting<Integer>("FriendPGreen", 191, 0, 255));
    public Setting<Integer> Field3774 = this.Method2150366(new Setting<Integer>("FriendPBlue", 255, 0, 255));

    public ChamsOld() {
        super("Chams", "Draws a wireframe esp around other players.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, false, false, false);
        this.Method2162353();
    }

    public static ChamsOld Method2162352() {
        if (Field3762 == null) {
            Field3762 = new ChamsOld();
        }
        return Field3762;
    }

    private void Method2162353() {
        Field3762 = this;
    }

    @SubscribeEvent
    public void Method2162354(RenderPlayerEvent.Pre pre) {
        pre.getEntityPlayer().hurtTime = 0;
    }

    private boolean Method2162355(Boolean bl) {
        return this.Field3770.getValue();
    }
}

