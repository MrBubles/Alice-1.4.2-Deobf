

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIlllIllIIIllIIllIIIlllIIIlIIIlllIIlIIlllIIIlIllIIllIlIIlIIlIlIIlllIIlIIllIlIlllIIIlIIIlIIIlIIlIlllIIlIIIllIIIllIIIlIlIlllIIlIIlllIIlllIIllIlIllIlllIIIlllIlIlIIllIllIlllIIlIIlIIIllIlllIllIlllIIIlIllIllIllIIllIlllIIlIIIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.cv
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.play.server.SPacketEntityMetadata
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIlllIllIIIllIIllIIIlllIIIlIIIlllIIlIIlllIIIlIllIIllIlIIlIIlIlIIlllIIlIIllIlIlllIIIlIIIlIIIlIIlIlllIIlIIIllIIIllIIIlIlIlllIIlIIlllIIlllIIllIlIllIlllIIIlllIlIlIIllIllIlllIIlIIlIIIllIlllIllIlllIIIlIllIllIllIIllIlllIIlIIIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.cv;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetHandlerPlayClient.class})
public class MixinNetHandlerPlayClient {
    @Inject(method={"handleEntityMetadata"}, at={@At(value="RETURN")}, cancellable=true)
    private void handleEntityMetadataHook(SPacketEntityMetadata packetIn, CallbackInfo info) {
        Entity entity;
        if (cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.world != null && (entity = cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.world.getEntityByID(packetIn.getEntityId())) instanceof EntityPlayer) {
            EntityPlayer entityPlayer;
            EntityPlayer player = (EntityPlayer)entity;
            if (entityPlayer.getHealth() <= 0.0f) {
                MinecraftForge.EVENT_BUS.post((Event)new IlIIlllIllIIIllIIllIIIlllIIIlIIIlllIIlIIlllIIIlIllIIllIlIIlIIlIlIIlllIIlIIllIlIlllIIIlIIIlIIIlIIlIlllIIlIIIllIIIllIIIlIlIlllIIlIIlllIIlllIIllIlIllIlllIIIlllIlIlIIllIllIlllIIlIIlIIIllIlllIllIlllIIIlIllIllIllIIllIlllIIlIIIll(player));
                if (IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIIllIIllIIIlIllIllIIlIllIlIlllIllIIIllIIIlllIlllIlIIIlIllIlIllIlIllIIIlIIllIllIlIllIlllIIIllIIllIlllIIllIIlIllIIIlllIIIllIIllIIllIIllIIIlllIIlIIIlllIIIlllIlllIllIllIIlIlIIIllIlIllIlIIllIllIlllIllIlllIIlIIlllIlll != null) {
                    IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIIllIIllIIIlIllIllIIlIllIlIlllIllIIIllIIIlllIlllIlIIIlIllIlIllIlIllIIIlIIllIllIlIllIlllIIIllIIllIlllIIllIIlIllIIIlllIIIllIIllIIllIIllIIIlllIIlIIIlllIIIlllIlllIllIllIIlIlIIIllIlIllIlIIllIllIlllIllIlllIIlIIlllIlll.Method2150342(player);
                }
            }
        }
    }
}

