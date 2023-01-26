

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.event.RenderHandEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.HUD;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NewNotification;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NotificationType;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Module
        extends Feature {
    private final String Field3708;
    private final IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Field3709;
    public Setting<Boolean> Field3710 = this.Method2150366(new Setting<Boolean>("Enabled", false));
    public Setting<Boolean> Field3711 = this.Method2150366(new Setting<Boolean>("Drawn", true));
    public Setting<Bind> Field3712 = this.Method2150366(new Setting<Bind>("Bind", new Bind(-1)));
    public Setting<String> Field3713;
    public boolean Field3714;
    public boolean Field3715;
    public boolean Field3716;
    public float Field3717 = 0.0f;
    public float Field3718 = 0.0f;
    public float Field3719;
    public float Field3720;
    public boolean Field3721;
    public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Field3722;

    public Module(String string, String string2, IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll, boolean bl, boolean bl2, boolean bl3) {
        super(string);
        this.Field3713 = this.Method2150366(new Setting<String>("DisplayName", string));
        this.Field3708 = string2;
        this.Field3709 = iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll;
        this.Field3714 = bl;
        this.Field3716 = bl2;
        this.Field3715 = bl3;
        this.Field3722 = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this, this);
    }

    public void Method2150371(RenderHandEvent renderHandEvent) {
    }

    public void Method2150372() {
    }

    public void Method2150373() {
    }

    public void Method2150374() {
    }

    public void Method2150375() {
    }

    public void Method2150376() {
    }

    public void Method2150377() {
    }

    public void Method2150378() {
    }

    public void Method2150379() {
    }

    public void Method2150370(Render2DEvent render2DEvent) {
    }

    public void Method2150381(Render3DEvent render3DEvent) {
    }

    public void Method2150382() {
    }

    public void Method2150383(int n2, int n3, float f) {
    }

    public boolean Method2150384(int n2, int n3, int n4) {
        return false;
    }

    public String Method2150385() {
        return null;
    }

    public boolean Method2150386() {
        return this.Field3710.getValue();
    }

    public boolean Method2150387() {
        return this.Field3710.getValue() == false;
    }

    public void Method2150388(boolean bl) {
        if (bl) {
            this.Method2150389();
        } else {
            this.Method2150380();
        }
    }

    public void Method2150389() {
        this.Field3710.setValue(true);
        this.Method2150374();
        this.Method2150372();
        if (AliceMain.Field756.Method2150180(NewNotification.class).Method2150364() && NewNotification.Method2162740().Field3144.getValue().booleanValue()) {
            NewNotification.Method2162751((Object) TextFormatting.BOLD + this.Method2150392(), (Object) TextFormatting.GREEN + "disabled", NewNotification.Method2162740().Field3143.getValue(), NotificationType.INFO);
        }
        if (this.Method2150386() && this.Field3714 && !this.Field3715) {
            MinecraftForge.EVENT_BUS.register((Object) this);
        }
    }

    public void Method2150380() {
        if (this.Field3714 && !this.Field3715) {
            MinecraftForge.EVENT_BUS.unregister((Object) this);
        }
        this.Field3710.setValue(false);
        if (AliceMain.Field756.Method2150180(NewNotification.class).Method2150364() && NewNotification.Method2162740().Field3144.getValue().booleanValue()) {
            NewNotification.Method2162751((Object) TextFormatting.BOLD + this.Method2150392(), (Object) TextFormatting.RED + "disabled", NewNotification.Method2162740().Field3143.getValue(), NotificationType.INFO);
        }
        this.Method2150374();
        this.Method2150373();
    }

    public void Method2150391() {
        ClientEvent clientEvent = new ClientEvent(!this.Method2150364() ? 1 : 0, this);
        MinecraftForge.EVENT_BUS.post((Event) clientEvent);
        if (!clientEvent.isCanceled()) {
            this.Method2150388(!this.Method2150364());
        }
    }

    public String Method2150392() {
        return this.Field3713.getValue();
    }

    public void Method2150393(String string) {
        Module module = AliceMain.Field756.Method2150197(string);
        Module module2 = ModuleManager.Method2150189(string);
        if (module == null && module2 == null) {
            Command.Method2159696(this.Method2150392() + ", Original name: " + this.Method2150361() + ", has been renamed to: " + string);
            this.Field3713.setValue(string);
            return;
        }
        Command.Method2159696("\u00a7cA module of this name already exists.");
    }

    public String Method2150394() {
        return this.Field3708;
    }

    public boolean Method2150395() {
        return this.Field3721;
    }

    public boolean Method2150396() {
        return this.Field3711.getValue();
    }

    public void Method2150397(boolean bl) {
        this.Field3711.setValue(bl);
    }

    public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll Method2150398() {
        return this.Field3709;
    }

    public String Method2150399() {
        return null;
    }

    public Bind Method2150390() {
        return this.Field3712.getValue();
    }

    public void Method2150301(int n2) {
        this.Field3712.setValue(new Bind(n2));
    }

    public boolean Method2150302() {
        return this.Field3714 && this.Method2150386() || this.Field3715;
    }

    public String Method2150303() {
        return this.Method2150392() + "\u00a78" + (this.Method2150385() != null ? " [\u00a7r" + this.Method2150385() + "\u00a78]" : "");
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        COMBAT("Combat"),
        MISC("Misc"),
        RENDER("Render"),
        MOVEMENT("Movement"),
        PLAYER("Player"),
        CLIENT("Client");

        private final String Field1107;

        private IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(String string2) {
            this.Field1107 = string2;
        }

        public String IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
            return this.Field1107;
        }
    }

    public class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends Thread {
        final Module Field1059;
        public Module Field1053;
        public float Field1054;
        public float Field1055;
        public String Field1056;
        public boolean Field1057;
        ScheduledExecutorService Field1058;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(Module module, Module module2) {
            this.Field1059 = module;
            super("Animation");
            this.Field1058 = Executors.newSingleThreadScheduledExecutor();
            this.Field1053 = module2;
        }

        @Override
        public void run() {
            String string = this.Field1053.Method2150392() + "\u00a77" + (this.Field1053.Method2150385() != null ? " [\u00a7f" + this.Field1053.Method2150385() + "\u00a77]" : "");
            this.Field1053.Field3719 = (float) this.Field1059.Field3872.Method2150310(string) / HUD.Method2150504().Field3041.getValue().floatValue();
            this.Field1053.Field3720 = (float) this.Field1059.Field3872.Method2150321() / HUD.Method2150504().Field3042.getValue().floatValue();
            if (this.Field1053.Method2150364() && HUD.Method2150504().Field3041.getValue() != 1) {
                if (this.Field1053.Field3717 > this.Field1053.Field3719 && Util.Field2811.world != null) {
                    this.Field1053.Field3717 -= this.Field1053.Field3719;
                    this.Field1053.Field3721 = true;
                }
            } else if (this.Field1053.Method2150365() && HUD.Method2150504().Field3041.getValue() != 1) {
                if (this.Field1053.Field3717 < (float) this.Field1059.Field3872.Method2150310(string) && Util.Field2811.world != null) {
                    this.Field1053.Field3717 += this.Field1053.Field3719;
                    this.Field1053.Field3721 = true;
                } else {
                    this.Field1053.Field3721 = false;
                }
            }
        }

        @Override
        public void start() {
            System.out.println("Starting animation thread for " + this.Field1053.Method2150361());
            this.Field1058.scheduleAtFixedRate(this, 0L, 1L, TimeUnit.MILLISECONDS);
        }
    }
}

