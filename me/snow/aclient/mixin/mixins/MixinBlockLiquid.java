

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIIllIIIlllIlllIIIlIIlIIlIlllIlllIIllIIIllIIlIllIIIllIlllIIlIIIlIllIllIllIlllIllIlIIllIIIllIlIIIllIIllIIIllIlIIIllIllIIIlllIlllIlIIlllIIlIIIllIllIIlllIllIIllIIlllIlIlIIIlllIIlIIlllIIlllIIIllIlIllIIllIllIlllIIlIlIlIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.g
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.IProperty
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlllIIIllIIIlllIlllIIIlIIlIIlIlllIlllIIllIIIllIIlIllIIIllIlllIIlIIIlIllIllIllIlllIllIlIIllIIIllIlIIIllIIllIIIllIlIIIllIllIIIlllIlllIlIIlllIIlIIIllIllIIlllIllIIllIIlllIlIlIIIlllIIlIIlllIIlllIIIllIlIllIIllIllIlllIIlIlIlIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.g;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockLiquid.class})
public class MixinBlockLiquid
extends Block {
    protected MixinBlockLiquid(Material materialIn) {
        super(materialIn);
    }

    @Inject(method={"getCollisionBoundingBox"}, at={@At(value="HEAD")}, cancellable=true)
    public void getCollisionBoundingBoxHook(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable<AxisAlignedBB> info) {
        IIllIIlllIIIllIIIlllIlllIIIlIIlIIlIlllIlllIIllIIIllIIlIllIIIllIlllIIlIIIlIllIllIllIlllIllIlIIllIIIllIlIIIllIIllIIIllIlIIIllIllIIIlllIlllIlIIlllIIlIIIllIllIIlllIllIIllIIlllIlIlIIIlllIIlIIlllIIlllIIIllIlIllIIllIllIlllIIlIlIlIlll event = new IIllIIlllIIIllIIIlllIlllIIIlIIlIIlIlllIlllIIllIIIllIIlIllIIIllIlllIIlIIIlIllIllIllIlllIllIlIIllIIIllIlIIIllIIllIIIllIlIIIllIllIIIlllIlllIlIIlllIIlIIIllIllIIlllIllIIllIIlllIlIlIIIlllIIlIIlllIIlllIIIllIlIllIIllIllIlllIIlIlIlIlll(0, pos);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            info.setReturnValue(event.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll());
        }
    }

    @Inject(method={"canCollideCheck"}, at={@At(value="HEAD")}, cancellable=true)
    public void canCollideCheckHook(IBlockState blockState, boolean hitIfLiquid, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(hitIfLiquid && (Integer)blockState.getValue((IProperty)BlockLiquid.LEVEL) == 0 || g.Method2162259().Method2150386());
    }
}

