

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Global;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.util.math.BlockPos;

public class NoStopManager
        extends Feature {
    private final Timer Field2090 = new Timer();
    private String Field2091;
    private boolean Field2092;
    private boolean Field2093;
    private BlockPos Field2094;
    private BlockPos Field2095;
    private boolean Field2096;

    public void Method2150222() {
        if (NoStopManager.Method2150359()) {
            this.Method2150225();
            return;
        }
        if (this.Field2092 && this.Field2094 != null) {
            BlockPos blockPos = NoStopManager.Field2811.player.getPosition();
            if (blockPos.equals((Object) this.Field2094)) {
                BlockUtil.Method2162837("<Baritone> Arrived at Position: ", this.Field2094);
                this.Field2092 = false;
                return;
            }
            if (blockPos.equals((Object) this.Field2095)) {
                if (this.Field2096 && this.Field2090.Method2164751(Global.Method2150598().Field1139.getValue().intValue())) {
                    this.Method2150223();
                    this.Field2096 = false;
                    return;
                }
                if (!this.Field2096) {
                    this.Field2096 = true;
                    this.Field2090.Method2164750();
                }
            } else {
                this.Field2095 = blockPos;
                this.Field2096 = false;
            }
            if (!this.Field2093) {
                this.Method2150223();
                this.Field2093 = true;
            }
        }
    }

    public void Method2150223() {
        NoStopManager.Field2811.player.sendChatMessage(this.Field2091 + "goto " + this.Field2094.getX() + " " + this.Field2094.getY() + " " + this.Field2094.getZ());
    }

    public void Method2150224(int n2, int n3, int n4) {
        this.Field2094 = new BlockPos(n2, n3, n4);
        this.Field2093 = false;
        this.Field2092 = true;
    }

    public void Method2150225() {
        if (this.Field2092) {
            if (NoStopManager.Field2811.player != null) {
                NoStopManager.Field2811.player.sendChatMessage(this.Field2091 + "stop");
            }
            this.Field2092 = false;
        }
    }

    public void Method2150226(String string) {
        this.Field2091 = string;
    }
}

