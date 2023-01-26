

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIllIIIllIIllIlllIllIIIlllIIlllIIlllIlIIIlIlIllIIIlIIIllIIIllIIlIlllIIIlIlllIIIlIIlIIIllIIIllIIIllIIlllIIllIIlIllIIlIlIIlllIIIllIIllIllIIllIIIlIIlllIIllIIIlIIlIlIllIllIIlllIIlIIllIIlIllIIlllIIIlllIIllIllIIlIIlllIIIlIIIllIIllIlllIll
 *  net.minecraft.block.BlockEndPortalFrame
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IlIIllIIIllIIllIlllIllIIIlllIIlllIIlllIlIIIlIlIllIIIlIIIllIIIllIIlIlllIIIlIlllIIIlIIlIIIllIIIllIIIllIIlllIIllIIlIllIIlIlIIlllIIIllIIllIllIIllIIIlIIlllIIllIIIlIIlIlIllIllIIlllIIlIIllIIlIllIIlllIIIlllIIllIllIIlIIlllIIIlIIIllIIllIlllIll;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockEndPortalFrame.class})
public class MixinBlockEndPortalFrame {
    @Shadow
    @Final
    protected static AxisAlignedBB AABB_BLOCK;

    @Inject(method={"getBoundingBox"}, at={@At(value="HEAD")}, cancellable=true)
    public void getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos, CallbackInfoReturnable<AxisAlignedBB> info) {
        if (IlIIllIIIllIIllIlllIllIIIlllIIlllIIlllIlIIIlIlIllIIIlIIIllIIIllIIlIlllIIIlIlllIIIlIIlIIIllIIIllIIIllIIlllIIllIIlIllIIlIlIIlllIIIllIIllIllIIllIIIlIIlllIIllIIIlIIlIlIllIllIIlllIIlIIllIIlIllIIlllIIIlllIIllIllIIlIIlllIIIlIIIllIIllIlllIll.Method2161004().Method2150386() && ((Boolean)IlIIllIIIllIIllIlllIllIIIlllIIlllIIlllIlIIIlIlIllIIIlIIIllIIIllIIlIlllIIIlIlllIIIlIIlIIIllIIIllIIIllIIlllIIllIIlIllIIlIlIIlllIIIllIIllIllIIllIIIlIIlllIIllIIIlIIlIlIllIllIIlllIIlIIllIIlIllIIlllIIIlllIIllIllIIlIIlllIIIlIIIllIIllIlllIll.Method2161004().IllIlllIIllIIlIIlIlIIIllIIllIIlllIIIlIIlIIlllIIlIlIIIlIlIIIlIIllIlllIIIlllIIllIllIllIIlllIlIllIIlIlIIIlIlIlllIIIlIlllIIlIIllIIlIIllIllIIllIlllIIIllIllIlIIIllIIllIIllIIlIIIlIIlIlIIIllIIllIllIlllIIIllIIIllIIIlllIIlIIIlIlll.getValue()).booleanValue()) {
            info.setReturnValue(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0));
        }
    }
}

