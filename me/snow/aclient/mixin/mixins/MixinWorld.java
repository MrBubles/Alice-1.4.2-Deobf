

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIlIllIIlIIlIllIIlllIIlIIlIIlIIllIllIIlIIIlIIllIIlIIlllIlIIIllIllIIIlllIIlllIllIIIlIlllIIIllIIlIlllIIllIIIlllIIllIlllIllIIllIIIllIIIlIIlIIIlllIllIIIllIIlllIllIIIllIIIllIIlIIlllIIIlIIIlIIllIIlllIlIIIlllIIllIIIlIIIllIlIIIllIIlllIIlllIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIllIlIIllIlIIIllIIIlllIIlIlllIllIlIIllIlIIllIIIlIlIIlIlIIIllIIllIIllIllIIIllIIlllIIllIIIlIIlIIIllIllIlllIllIIlIlIIllIIllIIlllIIllIIIlllIlIIlllIIllIIllIllIIlIIlIIIlIIlIIlIllIllIlIIllIIIlllIlIIIllIlllIIIlIIlIIIlIl
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.l
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.mixin.mixins;

import com.google.common.base.Predicate;
import java.util.List;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIIlIllIIlIIlIllIIlllIIlIIlIIlIIllIllIIlIIIlIIllIIlIIlllIlIIIllIllIIIlllIIlllIllIIIlIlllIIIllIIlIlllIIllIIIlllIIllIlllIllIIllIIIllIIIlIIlIIIlllIllIIIllIIlllIllIIIllIIIllIIlIIlllIIIlIIIlIIllIIlllIlIIIlllIIllIIIlIIIllIlIIIllIIlllIIlllIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIIllIlIIllIlIIIllIIIlllIIlIlllIllIlIIllIlIIllIIIlIlIIlIlIIIllIIllIIllIllIIIllIIlllIIllIIIlIIlIIIllIllIlllIllIIlIlIIllIIllIIlllIIllIIIlllIlIIlllIIllIIllIllIIlIIlIIIlIIlIIlIllIllIlIIllIIIlllIlIIIllIlllIIIlIIlIIIlIl;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.l;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class MixinWorld {
    @Redirect(method={"getEntitiesWithinAABB(Ljava/lang/Class;Lnet/minecraft/util/math/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/chunk/Chunk;getEntitiesOfTypeWithinAABB(Ljava/lang/Class;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lcom/google/common/base/Predicate;)V"))
    public <T extends Entity> void getEntitiesOfTypeWithinAABBHook(Chunk chunk, Class<? extends T> entityClass, AxisAlignedBB aabb, List<T> listToFill, Predicate<? super T> filter) {
        try {
            chunk.getEntitiesOfTypeWithinAABB(entityClass, aabb, listToFill, filter);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"onEntityAdded"}, at={@At(value="HEAD")})
    private void onEntityAdded(Entity entityIn, CallbackInfo ci) {
        IllIIIllIlIIllIlIIIllIIIlllIIlIlllIllIlIIllIlIIllIIIlIlIIlIlIIIllIIllIIllIllIIIllIIlllIIllIIIlIIlIIIllIllIlllIllIIlIlIIllIIllIIlllIIllIIIlllIlIIlllIIllIIllIllIIlIIlIIIlIIlIIlIllIllIlIIllIIIlllIlIIIllIlllIIIlIIlIIIlIl.Method2161958().Method2161962(entityIn);
    }

    @Redirect(method={"handleMaterialAcceleration"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;isPushedByWater()Z"))
    public boolean isPushedbyWaterHook(Entity entity) {
        IIllIIIlIllIIlIIlIllIIlllIIlIIlIIlIIllIllIIlIIIlIIllIIlIIlllIlIIIllIllIIIlllIIlllIllIIIlIlllIIIllIIlIlllIIllIIIlllIIllIlllIllIIllIIIllIIIlIIlIIIlllIllIIIllIIlllIllIIIllIIIllIIlIIlllIIIlIIIlIIllIIlllIlIIIlllIIllIIIlIIIllIlIIIllIIlllIIlllIlll event = new IIllIIIlIllIIlIIlIllIIlllIIlIIlIIlIIllIllIIlIIIlIIllIIlIIlllIlIIIllIllIIIlllIIlllIllIIIlIlllIIIllIIlIlllIIllIIIlllIIllIlllIllIIllIIIllIIIlIIlIIIlllIllIIIllIIlllIllIIIllIIIllIIlIIlllIIIlIIIlIIllIIlllIlIIIlllIIllIIIlIIIllIlIIIllIIlllIIlllIlll(2, entity);
        MinecraftForge.EVENT_BUS.post((Event)event);
        return entity.isPushedByWater() && !event.isCanceled();
    }

    @Inject(method={"setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void setBlockState(BlockPos pos, IBlockState newState, int flags, CallbackInfoReturnable<Boolean> cir) {
        l noGlitchBlock = (l)IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.Method2150180(l.class);
        if (noGlitchBlock.Method2150364() && ((Boolean)noGlitchBlock.IllIllIIIlllIllIIlllIlIllIIllIllIIlIIIlIIlllIIllIlllIIlIlIlIIlIIIllIIlIIIllIIIllIIlIIlIIIllIIlIllIIlllIlIIlllIllIIIllIIllIIlllIIIllIIllIIIllIIIllIIIlllIIlIlIIIlIlllIIIlIIllIlIIlllIlIIllIllIllIlllIIllIIIllIIIllIIlIIlIIIlIIllIll.getValue()).booleanValue() && flags != 3) {
            cir.cancel();
            cir.setReturnValue(false);
        }
    }
}

