

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIllIlllIIlIlllIIIllIIlllIlIlIIIllIIlllIIIlllIIIlIIllIIIlIIlIIllIlllIIlllIIlllIllIIllIIlllIlIIIllIIlIIlllIIlIIIlIIlllIIllIIlllIIIlIllIlllIIllIIlIIlllIIIllIIlllIIlllIIllIIlIIllIIlllIIlllIIllIllIllIIIllIIIlllIllIIllIIlllIIlIllIlIIllIIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl$IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl$IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.n
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import io.netty.channel.ChannelHandlerContext;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIllIlllIIlIlllIIIllIIlllIlIlIIIllIIlllIIIlllIIIlIIllIIIlIIlIIllIlllIIlllIIlllIllIIllIIlllIlIIIllIIlIIlllIIlIIIlIIlllIIllIIlllIIIlIllIlllIIllIIlIIlllIIIllIIlllIIlllIIllIIlIIllIIlllIIlllIIllIllIllIIIllIIIlllIllIIllIIlllIIlIllIlIIllIIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.n;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetworkManager.class})
public abstract class MixinNetworkManager {
    @Shadow
    public abstract boolean isChannelOpen();

    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendPacketPre(Packet<?> packet, CallbackInfo info) {
        IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll event = new IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(0, packet);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            info.cancel();
        }
    }

    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="RETURN")}, cancellable=true)
    private void onSendPacketPost(Packet<?> packet, CallbackInfo info) {
        IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll event = new IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(1, packet);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            info.cancel();
        }
    }

    @Inject(method={"channelRead0"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChannelReadPre(ChannelHandlerContext context, Packet<?> packet, CallbackInfo info) {
        IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll event = new IlllIIIlIlIlllIIIlIIlIIlIIIlIIlIIlIIllIlllIlIIlllIIllIIlllIlllIlllIIlllIIllIlllIIllIlIllIIlIIIlIIIlllIIlllIIIllIIllIIlllIlllIllIIllIIIlllIIlIIllIllIIlIIllIIllIIlllIIIlllIIlIIllIIIlllIlIIllIllIIlllIIlIIlIllIIllIIlllIllIllIllIlIl.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(0, packet);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            info.cancel();
        }
    }

    @Inject(method={"exceptionCaught"}, at={@At(value="HEAD")}, cancellable=true)
    private void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable, CallbackInfo ci) {
        if (n.Method2162272().Method2150364()) {
            n.Method2162273((Throwable)throwable);
            ci.cancel();
        }
    }

    @Inject(method={"closeChannel"}, at={@At(value="INVOKE", target="Lio/netty/channel/Channel;isOpen()Z", remap=false)})
    private void onDisconnectHook(ITextComponent component, CallbackInfo info) {
        if (this.isChannelOpen()) {
            MinecraftForge.EVENT_BUS.post((Event)new IIllIIlllIIllIlllIIlIlllIIIllIIlllIlIlIIIllIIlllIIIlllIIIlIIllIIIlIIlIIllIlllIIlllIIlllIllIIllIIlllIlIIIllIIlIIlllIIlIIIlIIlllIIllIIlllIIIlIllIlllIIllIIlIIlllIIIllIIlllIIlllIIllIIlIIllIIlllIIlllIIllIllIllIIIllIIIlllIllIIllIIlllIIlIllIlIIllIIl(component));
        }
    }
}

