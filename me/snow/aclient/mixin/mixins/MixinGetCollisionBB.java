

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIllIIlIIlllIllIIllIIIlIIllIIlIlIIllIIlIIlIIIlIllIllIIIlIIIlllIIllIIllIllIIllIllIIlllIIlIIIlIIIllIIIllIlllIIllIIIlllIlIIIlIIlllIllIIlIlIllIIlllIIlIIllIIllIIIllIIlllIIIlIIlIlIIllIIIllIIlllIIllIIIlIlllIIllIllIIIlIllIIllIlIIlll
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIllIIlIIlllIllIIllIIIlIIllIIlIlIIllIIlIIlIIIlIllIllIIIlIIIlllIIllIIllIllIIllIllIIlllIIlIIIlIIIllIIIllIlllIIllIIIlllIlIIIlIIlllIllIIlIlIllIIlllIIlIIllIIllIIIllIIlllIIIlIIlIlIIllIIIllIIlllIIllIIIlIlllIIllIllIIIlIllIIllIlIIlll;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Block.class})
public class MixinGetCollisionBB {
    Minecraft mc = Minecraft.getMinecraft();

    @Inject(method={"getCollisionBoundingBox"}, at={@At(value="HEAD")}, cancellable=true)
    private void getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable<AxisAlignedBB> cir) {
        IlIllIIlIIlllIllIIllIIIlIIllIIlIlIIllIIlIIlIIIlIllIllIIIlIIIlllIIllIIllIllIIllIllIIlllIIlIIIlIIIllIIIllIlllIIllIIIlllIlIIIlIIlllIllIIlIlIllIIlllIIlIIllIIllIIIllIIlllIIIlIIlIlIIllIIIllIIlllIIllIIIlIlllIIllIllIIIlIllIIllIlIIlll event = new IlIllIIlIIlllIllIIllIIIlIIllIIlIlIIllIIlIIlIIIlIllIllIIIlIIIlllIIllIIllIllIIllIllIIlllIIlIIIlIIIllIIIllIlllIIllIIIlllIlIIIlIIlllIllIIlIlIllIIlllIIlIIllIIllIIIllIIlllIIIlIIlIlIIllIIIllIIlllIIllIIIlIlllIIllIllIIIlIllIIllIlIIlll(blockState.getBlock(), new Vec3d((Vec3i)pos));
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll) {
            cir.cancel();
            cir.setReturnValue(event.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll());
        }
    }
}

