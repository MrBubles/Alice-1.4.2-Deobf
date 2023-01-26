

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlllIIIlIlllIIIlIIIlIIIlIIlIIlIIIllIlIIllIllIlllIIIlllIlIIllIlllIIlIIIlllIIlllIllIIIllIlllIIlllIIlllIIIlIllIllIIllIIlIIlllIIIllIIllIIllIlIIIlllIIIllIllIllIIlIIIlIllIIlIIIllIIIllIlIIlIIIlIllIIlllIIllIIlllIIlllIIlllIIllIIIlIllIIlIIlllIIl
 *  net.minecraft.client.gui.GuiPlayerTabOverlay
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Team
 */
package me.snow.aclient.mixin.mixins;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.List;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIlllIIIlIlllIIIlIIIlIIIlIIlIIlIIIllIlIIllIllIlllIIIlllIlIIllIlllIIlIIIlllIIlllIllIIIllIlllIIlllIIlllIIIlIllIllIIllIIlIIlllIIIllIIllIIllIlIIIlllIIIllIllIllIIlIIIlIllIIlIIIllIIIllIlIIlIIIlIllIIlllIIllIIlllIIlllIIlllIIllIIIlIllIIlIIlllIIl;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GuiPlayerTabOverlay.class})
public class MixinGuiPlayerTabOverlay {
    IIlllIIIlIlllIIIlIIIlIIIlIIlIIlIIIllIlIIllIllIlllIIIlllIlIIllIlllIIlIIIlllIIlllIllIIIllIlllIIlllIIlllIIIlIllIllIIllIIlIIlllIIIllIIllIIllIlIIIlllIIIllIllIllIIlIIIlIllIIlIIIllIIIllIlIIlIIIlIllIIlllIIllIIlllIIlllIIlllIIllIIIlIllIIlIIlllIIl extratab = (IIlllIIIlIlllIIIlIIIlIIIlIIlIIlIIIllIlIIllIllIlllIIIlllIlIIllIlllIIlIIIlllIIlllIllIIIllIlllIIlllIIlllIIIlIllIllIIllIIlIIlllIIIllIIllIIllIlIIIlllIIIllIllIllIIlIIIlIllIIlIIIllIIIllIlIIlIIIlIllIIlllIIllIIlllIIlllIIlllIIllIIIlIllIIlIIlllIIl)IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150180(IIlllIIIlIlllIIIlIIIlIIIlIIlIIlIIIllIlIIllIllIlllIIIlllIlIIllIlllIIlIIIlllIIlllIllIIIllIlllIIlllIIlllIIIlIllIllIIllIIlIIlllIIIllIIllIIllIlIIIlllIIIllIllIllIIlIIIlIllIIlIIIllIIIllIlIIlIIIlIllIIlllIIllIIlllIIlllIIlllIIllIIIlIllIIlIIlllIIl.class);

    @Redirect(method={"renderPlayerlist"}, at=@At(value="INVOKE", target="Ljava/util/List;subList(II)Ljava/util/List;", remap=false))
    public List<NetworkPlayerInfo> subListHook(List<NetworkPlayerInfo> list, int fromIndex, int toIndex) {
        return list.subList(fromIndex, this.extratab.Method2150364() ? Math.min((Integer)this.extratab.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue(), list.size()) : toIndex);
    }

    @Inject(method={"getPlayerName"}, at={@At(value="HEAD")}, cancellable=true)
    public void getPlayerNameHead(NetworkPlayerInfo networkPlayerInfoIn, CallbackInfoReturnable<String> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue(this.getPlayerNameGS(networkPlayerInfoIn));
    }

    private String getPlayerNameGS(NetworkPlayerInfo networkPlayerInfoIn) {
        String displayName;
        String string = displayName = networkPlayerInfoIn.getDisplayName() != null ? networkPlayerInfoIn.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName((Team)networkPlayerInfoIn.getPlayerTeam(), (String)networkPlayerInfoIn.getGameProfile().getName());
        if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIlllIIIllIIllIIllIlIIIlIIIllIIIlIIlllIIIlIlllIIlIIllIlIlIlIlIIIlllIIIlllIIIlllIIIlllIIlIllIIllIlllIllIIlllIlllIlllIIlIIlIIIllIllIIIlllIIllIIlIlllIIllIIIllIIlIIllIIIlIllIIIllIIllIIIlIIllIIlllIIlllIIIllIllIIIllIIllIIllIlIllIllIIIlIIllIIl.Method2150168(displayName)) {
            return (Object)ChatFormatting.AQUA + displayName;
        }
        return displayName;
    }
}

