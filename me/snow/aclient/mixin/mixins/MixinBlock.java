

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll$IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.bs
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.cv
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.e
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package me.snow.aclient.mixin.mixins;

import java.util.List;
import javax.annotation.Nullable;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.bs;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.cv;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.e;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Block.class})
public abstract class MixinBlock {
    @Shadow
    @Deprecated
    public abstract float getBlockHardness(IBlockState var1, World var2, BlockPos var3);

    @Inject(method={"addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void addCollisionBoxToListHook(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState, CallbackInfo info) {
        try {
            if (e.Method2162238().Method2150387() && IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll.Method2161082().Method2150386() && IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll.Method2161082().IIlllIIllIlllIlllIIlllIIIlIllIIIlllIIlIIIlIlllIlllIIllIIIlIIllIIlIIlIllIIIllIIlllIIIllIIIllIIlllIIllIIllIIllIlllIlllIIIllIllIlIllIIlllIlllIIIlllIlllIlllIllIIllIIIllIIllIlllIIllIIllIIlllIIlIIlllIIIlIlIllIIlIIllIIIlIIlIIlIIIlllIIIllIIIllIIlIl.getValue() == IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll && cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player != null && state != null && state.getBlock() instanceof BlockLiquid && !(entityIn instanceof EntityBoat) && !cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player.isSneaking() && cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player.fallDistance < 3.0f && !bs.Method2163565((Entity)cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player) && bs.Method2163567((Entity)cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player, (boolean)false) || bs.Method2163567((Entity)cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player, (boolean)false) && cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player.getRidingEntity() != null && cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player.getRidingEntity().fallDistance < 3.0f && bs.Method2163573((Entity)cv.IIlIIllIlIIllIIlllIIlllIIlIIlIIIllIIllIIlIIlllIIllIIllIIllIIllIllIIIlIIIllIIlIlIlIIlllIIIllIIIlIIlIIIlIllIlllIlIIllIllIIIlIIIlIIIlllIlIIllIlIlllIIlIllIIllIIIlIIllIIllIIllIIIlIIIlIIllIIllIlIIIllIIllIIllIIllIlIIIlIIIlIIlIIIlll.player, (BlockPos)pos)) {
                AxisAlignedBB offset = IIllIIIllIlIIIlllIIlllIllIIlllIIllIlllIllIIllIlIIllIIllIlIIllIllIIllIlllIllIIlllIlllIIllIlIIlllIIllIlIIlIIlllIIlIIIllIIlllIlIllIIlllIIllIIlIlIIlIIllIllIIllIIllIIIlIIIlllIIIllIIIlllIIIllIlllIIllIIlllIlIIllIlIIIllIIllIIIlIllIIllIlll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.offset(pos);
                if (entityBox.intersects(offset)) {
                    collidingBoxes.add(offset);
                }
                info.cancel();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

