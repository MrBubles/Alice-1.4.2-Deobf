

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Aura;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PistonCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RotationManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SilentRotaionUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import me.snow.aclient.mixin.mixins.accessors.ICPacketUseEntity;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;
import me.snow.aclient.mixin.mixins.accessors.IRenderManager;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TestAutoCrystal3
        extends Module {
    private static TestAutoCrystal3 Field376 = new TestAutoCrystal3();
    private static float Field465;
    public final Setting<Bind> Field414 = this.Method2150366(new Setting<Bind>("Faceplace", new Bind(-1)));
    public final Timer Field436 = new Timer();
    public final Timer Field437 = new Timer();
    public final Timer Field438 = new Timer();
    public final Timer Field439 = new Timer();
    public final Timer Field442 = new Timer();
    public final Timer Field444 = new Timer();
    public final ConcurrentHashMap<BlockPos, Long> Field446 = new ConcurrentHashMap();
    public final ConcurrentHashMap<Integer, Long> Field447 = new ConcurrentHashMap();
    public final Map<EntityPlayer, Timer> Field448 = new ConcurrentHashMap<EntityPlayer, Timer>();
    public final List<BlockPos> Field449 = new CopyOnWriteArrayList<BlockPos>();
    public final Timer Field451 = new Timer();
    public final Timer Field452 = new Timer();
    public final Timer Field454 = new Timer();
    private final Setting<Boolean> Field415 = this.Method2150366(new Setting<Boolean>("ArmorBreaker", true));
    private final Setting<Float> Field416 = this.Method2150366(new Setting<Float>("Depletion", Float.valueOf(0.9f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2161782));
    private final Timer Field456 = new Timer();
    public Setting<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll> Field377 = this.Method2150366(new Setting<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll>("Timing", IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.ADAPTIVE));
    public Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll> Field378 = this.Method2150366(new Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll>("Rotate", IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.TRACK));
    public Setting<Boolean> Field379 = this.Method2150366(new Setting<Boolean>("Inhibit", false));
    public Setting<Boolean> Field380 = this.Method2150366(new Setting<Boolean>("Limit", true));
    public Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl> Field381 = this.Method2150366(new Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl>("YawStep", IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.OFF));
    public Setting<Float> Field382 = this.Method2150366(new Setting<Float>("YawAngle", Float.valueOf(0.3f), Float.valueOf(0.1f), Float.valueOf(1.0f)));
    public Setting<Integer> Field383 = this.Method2150366(new Setting<Integer>("YawTicks", 1, 1, 5));
    public Setting<Boolean> Field384 = this.Method2150366(new Setting<Boolean>("StrictDirection", true));
    public Setting<Boolean> Field385 = this.Method2150366(new Setting<Boolean>("Check", true));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field386 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Interact", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NORMAL));
    public Setting<Boolean> Field387 = this.Method2150366(new Setting<Boolean>("Protocol", false));
    public Setting<Boolean> Field388 = this.Method2150366(new Setting<Boolean>("PlaceInLiquids", false));
    public Setting<Boolean> Field389 = this.Method2150366(new Setting<Boolean>("PlaceInFire", false));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field390 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Confirm", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF));
    public Setting<Integer> Field391 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 20));
    public Setting<Integer> Field392 = this.Method2150366(new Setting<Integer>("AttackFactor", 3, 1, 20));
    public Setting<Float> Field393 = this.Method2150366(new Setting<Float>("BreakSpeed", Float.valueOf(20.0f), Float.valueOf(1.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field394 = this.Method2150366(new Setting<Float>("PlaceSpeed", Float.valueOf(20.0f), Float.valueOf(2.0f), Float.valueOf(20.0f)));
    public Setting<IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll> Field395 = this.Method2150366(new Setting<IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll>("Sync", IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT));
    public Setting<Float> Field396 = this.Method2150366(new Setting<Float>("Offset", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(8.0f)));
    public Setting<Float> Field397 = this.Method2150366(new Setting<Float>("EnemyRange", Float.valueOf(8.0f), Float.valueOf(4.0f), Float.valueOf(15.0f)));
    public Setting<Float> Field398 = this.Method2150366(new Setting<Float>("CrystalRange", Float.valueOf(6.0f), Float.valueOf(2.0f), Float.valueOf(12.0f)));
    public Setting<Float> Field399 = this.Method2150366(new Setting<Float>("BreakRange", Float.valueOf(4.3f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Float> Field400 = this.Method2150366(new Setting<Float>("BreakWalls", Float.valueOf(1.5f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Float> Field401 = this.Method2150366(new Setting<Float>("PlaceRange", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Float> Field402 = this.Method2150366(new Setting<Float>("PlaceWalls", Float.valueOf(3.0f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Boolean> Field403 = this.Method2150366(new Setting<Boolean>("AutoSwap", true));
    public Setting<Float> Field404 = this.Method2150366(new Setting<Float>("SwapDelay", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field405 = this.Method2150366(new Setting<Float>("GhostDelay", Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field406 = this.Method2150366(new Setting<Boolean>("AntiWeakness", false));
    public Setting<IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll> Field407 = this.Method2150366(new Setting<IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll>("Target", IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.ALL));
    public Setting<Float> Field408 = this.Method2150366(new Setting<Float>("Security", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    public Setting<Float> Field409 = this.Method2150366(new Setting<Float>("Compromise", Float.valueOf(1.0f), Float.valueOf(0.05f), Float.valueOf(2.0f)));
    public Setting<Float> Field410 = this.Method2150366(new Setting<Float>("MinDamage", Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field411 = this.Method2150366(new Setting<Float>("MaxSelfDmg", Float.valueOf(12.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field412 = this.Method2150366(new Setting<Float>("SuicideHealth", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Float> Field413 = this.Method2150366(new Setting<Float>("FaceplaceHealth", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Integer> Field417 = this.Method2150366(new Setting<Integer>("PredictTicks", Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(10), this::Method2161781));
    public Setting<Boolean> Field418 = this.Method2150366(new Setting<Boolean>("PredictPops", Boolean.valueOf(false), this::Method2161770));
    public Setting<Boolean> Field419 = this.Method2150366(new Setting<Boolean>("PredictDestruction", Boolean.valueOf(false), this::Method2161779));
    public Setting<Boolean> Field420 = this.Method2150366(new Setting<Boolean>("Mining", false));
    public Setting<Boolean> Field421 = this.Method2150366(new Setting<Boolean>("Gapping", false));
    public Setting<Boolean> Field422 = this.Method2150366(new Setting<Boolean>("RightClickGap", Boolean.valueOf(false), this::Method2161778));
    public Setting<Boolean> Field423 = this.Method2150366(new Setting<Boolean>("KillAura", true));
    public Setting<Boolean> Field424 = this.Method2150366(new Setting<Boolean>("PistonAura", true));
    public Setting<Float> Field425 = this.Method2150366(new Setting<Float>("Health", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field426 = this.Method2150366(new Setting<Boolean>("DisableOnTP", false));
    public Setting<Boolean> Field427 = this.Method2150366(new Setting<Boolean>("Swing", true));
    public Vec3d Field428 = null;
    public float[] Field429 = new float[]{0.0f, 0.0f};
    public Timer Field430 = new Timer();
    public BlockPos Field440;
    public float Field441 = 0.0f;
    public BlockPos Field443;
    public boolean Field445 = false;
    public AtomicBoolean Field450 = new AtomicBoolean(false);
    public BlockPos Field453 = null;
    public EntityEnderCrystal Field455 = null;
    private EntityEnderCrystal Field431;
    private BlockPos Field432;
    private BlockPos Field433 = null;
    private EnumFacing Field434;
    private RayTraceResult Field435;
    private Vec3d Field457 = null;
    private Thread Field458;
    private AtomicBoolean Field459 = new AtomicBoolean(false);
    private AtomicBoolean Field460 = new AtomicBoolean(false);
    private EntityPlayer Field461;
    private Timer Field462 = new Timer();
    private int Field463;
    private boolean Field464 = false;

    public TestAutoCrystal3() {
        super("AutoCrystalSSSSSDA", "", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        this.Method2161725();
    }

    public static TestAutoCrystal3 Method2161724() {
        if (Field376 == null) {
            Field376 = new TestAutoCrystal3();
        }
        return Field376;
    }

    public static List<BlockPos> Method2161753(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n4 = blockPos.getX();
        int n5 = blockPos.getY();
        int n6 = blockPos.getZ();
        int n7 = n4 - (int) f;
        while ((float) n7 <= (float) n4 + f) {
            int n8 = n6 - (int) f;
            block1:
            while ((float) n8 <= (float) n6 + f) {
                int n9 = bl2 ? n5 - (int) f : n5;
                while (true) {
                    float f2;
                    float f3 = n9;
                    float f4 = f2 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    if (!(f3 < f2)) {
                        ++n8;
                        continue block1;
                    }
                    double d = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n7, n9 + n3, n8);
                        arrayList.add(blockPos2);
                    }
                    ++n9;
                }
            }
            ++n7;
        }
        return arrayList;
    }

    public static void Method2161754(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - ((IRenderManager) Field2811.getRenderManager()).getRenderPosX()), (double) ((double) f2 - ((IRenderManager) Field2811.getRenderManager()).getRenderPosY()), (double) ((double) f3 - ((IRenderManager) Field2811.getRenderManager()).getRenderPosZ()));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-Minecraft.getMinecraft().player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) Minecraft.getMinecraft().player.rotationPitch, (float) (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2161755(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        TestAutoCrystal3.Method2161754(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    private static Float Method2161757(EntityPlayer entityPlayer) {
        return Float.valueOf(TestAutoCrystal3.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161758(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() < 10.0f;
    }

    private static Float Method2161759(EntityPlayer entityPlayer) {
        return Float.valueOf(TestAutoCrystal3.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161750(EntityPlayer entityPlayer) {
        return !BlockUtilSC.Method2162896(new BlockPos((Entity) entityPlayer)) && (TestAutoCrystal3.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.AIR || TestAutoCrystal3.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.WEB || TestAutoCrystal3.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() instanceof BlockLiquid);
    }

    private static Float Method2161761(EntityPlayer entityPlayer) {
        return Float.valueOf(TestAutoCrystal3.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161763(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    private static boolean Method2161764(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161765(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    private static boolean Method2161766(EntityPlayer entityPlayer) {
        return entityPlayer != TestAutoCrystal3.Field2811.player && entityPlayer != Field2811.getRenderViewEntity();
    }

    private static Float Method2161768(Entity entity) {
        return Float.valueOf(TestAutoCrystal3.Field2811.player.getDistance(entity));
    }

    private static Float Method2161760(Entity entity) {
        return Float.valueOf(TestAutoCrystal3.Field2811.player.getDistance(entity));
    }

    private static boolean Method2161775(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    static AtomicBoolean Method2161783(TestAutoCrystal3 testAutoCrystal3) {
        return testAutoCrystal3.Field459;
    }

    static float Method2161784() {
        return Field465;
    }

    static Thread Method2161785(TestAutoCrystal3 testAutoCrystal3) {
        return testAutoCrystal3.Field458;
    }

    static void Method2161786(TestAutoCrystal3 testAutoCrystal3) {
        testAutoCrystal3.Method2161720();
    }

    private void Method2161725() {
        Field376 = this;
    }

    @Override
    public void Method2150373() {
    }

    @Override
    public void Method2150372() {
        this.Field431 = null;
        this.Field432 = null;
        this.Field434 = null;
        this.Field435 = null;
        this.Field433 = null;
        this.Field453 = null;
        this.Field457 = null;
        this.Field460.set(false);
        this.Field428 = null;
        this.Field430.Method2164750();
        this.Field445 = false;
        this.Field464 = false;
        this.Field448.clear();
    }

    @SubscribeEvent
    public void Method2161726(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            this.Field446.forEach((arg_0, arg_1) -> this.Method2161777(arg_0, arg_1));
            --this.Field463;
            if (this.Field457 != null) {
                for (Entity entity : TestAutoCrystal3.Field2811.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.Field457.x, this.Field457.y, this.Field457.z) <= 6.0))
                        continue;
                    this.Field447.put(entity.getEntityId(), System.currentTimeMillis());
                }
                this.Field457 = null;
            }
            if (updateWalkingPlayerEvent.isCanceled()) {
                return;
            }
            this.Field431 = null;
            this.Field432 = null;
            this.Field434 = null;
            this.Field435 = null;
            this.Field464 = false;
            this.Method2161728();
            if (this.Field378.getValue() != IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.OFF && !this.Field430.Method2164755(650L) && this.Field428 != null) {
                if (this.Field378.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.TRACK) {
                    this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                }
                if (this.Field382.getValue().floatValue() < 1.0f && this.Field381.getValue() != IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.OFF && (this.Field431 != null || this.Field381.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FULL)) {
                    if (this.Field463 > 0) {
                        this.Field429[0] = ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw();
                        this.Field431 = null;
                        this.Field432 = null;
                    } else {
                        float f = MathHelper.wrapDegrees((float) (this.Field429[0] - ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()));
                        if (Math.abs(f) > 180.0f * this.Field382.getValue().floatValue()) {
                            this.Field429[0] = ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw() + f * (180.0f * this.Field382.getValue().floatValue() / Math.abs(f));
                            this.Field431 = null;
                            this.Field432 = null;
                            this.Field463 = this.Field383.getValue();
                        }
                    }
                }
                SilentRotaionUtil.Method2162907(this.Field429[0], this.Field429[1]);
            }
        }
    }

    @SubscribeEvent
    public void Method2161727(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        Field465 = this.Field396.getValue().floatValue() / 10.0f;
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1) {
            if (this.Field431 != null) {
                if (this.Method2161734(this.Field431)) {
                    this.Field437.Method2164750();
                    this.Field447.put(this.Field431.getEntityId(), System.currentTimeMillis());
                    for (Entity entity : TestAutoCrystal3.Field2811.world.loadedEntityList) {
                        if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.Field431.posX, this.Field431.posY, this.Field431.posZ) <= 6.0))
                            continue;
                        this.Field447.put(entity.getEntityId(), System.currentTimeMillis());
                    }
                    this.Field431 = null;
                    if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                        this.Method2161731();
                    }
                }
            } else if (this.Field432 != null) {
                if (!this.Method2161733(this.Field432, this.Field434)) {
                    this.Field459.set(false);
                    this.Field432 = null;
                    return;
                }
                this.Field436.Method2164750();
                this.Field432 = null;
            }
        }
    }

    private void Method2161728() {
        if (TestAutoCrystal3.Field2811.player.getHealth() + TestAutoCrystal3.Field2811.player.getAbsorptionAmount() < this.Field425.getValue().floatValue() || this.Field423.getValue() != false && AliceMain.Field756.Method2150180(Aura.class).Method2150364() || this.Field424.getValue() != false && AliceMain.Field756.Method2150180(PistonCrystal.class).Method2150364() || this.Field421.getValue() != false && TestAutoCrystal3.Field2811.player.getActiveItemStack().getItem() instanceof ItemFood || this.Field420.getValue().booleanValue() && TestAutoCrystal3.Field2811.playerController.getIsHittingBlock() && TestAutoCrystal3.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
            this.Field428 = null;
            return;
        }
        if (this.Field421.getValue().booleanValue() && this.Field422.getValue().booleanValue() && TestAutoCrystal3.Field2811.gameSettings.keyBindUseItem.isKeyDown() && TestAutoCrystal3.Field2811.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) {
            int n2 = -1;
            for (int j = 0; j < 9; ++j) {
                if (TestAutoCrystal3.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.GOLDEN_APPLE) {
                    continue;
                }
                n2 = j;
                break;
            }
            if (n2 != -1 && n2 != TestAutoCrystal3.Field2811.player.inventory.currentItem && this.Field439.Method2164755((long) (this.Field404.getValue().floatValue() * 50.0f))) {
                TestAutoCrystal3.Field2811.player.inventory.currentItem = n2;
                TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                this.Field439.Method2164750();
                this.Field438.Method2164750();
                return;
            }
        }
        if (!(this.Method2161751() || TestAutoCrystal3.Field2811.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal || this.Field403.getValue().booleanValue())) {
            return;
        }
        List<EntityPlayer> list = this.Method2161749();
        EntityEnderCrystal entityEnderCrystal = this.Method2161741(list);
        int n3 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
        if (entityEnderCrystal != null && this.Field437.Method2164755((long) (1000.0f - this.Field393.getValue().floatValue() * 50.0f)) && (entityEnderCrystal.ticksExisted >= this.Field391.getValue() || this.Field377.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.ADAPTIVE)) {
            this.Field431 = entityEnderCrystal;
            this.Method2161745(this.Field431.posX, this.Field431.posY, this.Field431.posZ);
        }
        if (entityEnderCrystal == null && (this.Field390.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FULL || this.Field455 == null || (double) this.Field455.ticksExisted >= Math.floor(this.Field391.getValue().intValue())) && (this.Field395.getValue() != IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT || this.Field437.Method2164755((long) (950.0f - this.Field393.getValue().floatValue() * 50.0f - (float) CrystalUtilSC.Method2162805()))) && this.Field436.Method2164755((long) (1000.0f - this.Field394.getValue().floatValue() * 50.0f)) && (this.Field377.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.SEQUENTIAL || this.Field451.Method2164755((long) ((float) this.Field391.getValue().intValue() * 5.0f)))) {
            BlockPos blockPos;
            if (this.Field390.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF && this.Field453 != null && !this.Field452.Method2164755(n3 + 100) && this.Method2161748(this.Field453)) {
                this.Field432 = this.Field453;
                this.Field434 = this.Method2161746(this.Field432);
                this.Field460.set(false);
                return;
            }
            List<BlockPos> list2 = this.Method2161747();
            if (!list2.isEmpty() && (blockPos = this.Method2161743(list2, list)) != null) {
                this.Field432 = blockPos;
                this.Field434 = this.Method2161746(this.Field432);
            }
        }
        this.Field460.set(false);
    }

    private double Method2161729(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        return Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
    }

    private void Method2161720() {
        BlockPos blockPos;
        List<BlockPos> list;
        if (this.Field390.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF && (this.Field390.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FULL || this.Field455 == null || (double) this.Field455.ticksExisted >= Math.floor(this.Field391.getValue().intValue()))) {
            int n2 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
            if (this.Field453 != null && !this.Field452.Method2164755(n2 + 100) && this.Method2161748(this.Field453)) {
                this.Field432 = this.Field453;
                this.Field434 = this.Method2161746(this.Field432);
                if (this.Field432 != null) {
                    if (!this.Method2161733(this.Field432, this.Field434)) {
                        this.Field432 = null;
                        return;
                    }
                    this.Field436.Method2164750();
                    this.Field432 = null;
                }
                return;
            }
        }
        if (!(list = this.Method2161747()).isEmpty() && (blockPos = this.Method2161743(list, this.Method2161749())) != null) {
            this.Field432 = blockPos;
            this.Field434 = this.Method2161746(this.Field432);
            if (this.Field432 != null) {
                if (!this.Method2161733(this.Field432, this.Field434)) {
                    this.Field432 = null;
                    return;
                }
                this.Field436.Method2164750();
                this.Field432 = null;
            }
        }
    }

    private void Method2161731() {
        if (this.Field396.getValue().floatValue() == 0.0f) {
            this.Method2161720();
        } else {
            this.Field459.set(true);
            if (this.Field458 == null || this.Field458.isInterrupted() || !this.Field458.isAlive()) {
                if (this.Field458 == null) {
                    this.Field458 = new Thread(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161723(this));
                }
                if (this.Field458 != null && (this.Field458.isInterrupted() || !this.Field458.isAlive())) {
                    this.Field458 = new Thread(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161723(this));
                }
                if (this.Field458 != null && this.Field458.getState() == Thread.State.NEW) {
                    try {
                        this.Field458.start();
                    } catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161732(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSpawnObject) {
            SPacketSpawnObject sPacketSpawnObject = (SPacketSpawnObject) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSpawnObject.getType() == 51) {
                this.Field446.forEach((arg_0, arg_1) -> this.Method2161776(sPacketSpawnObject, arg_0, arg_1));
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect) {
            SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSoundEffect.getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
                if (this.Field455 != null && this.Field455.getDistance(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ()) < 6.0) {
                    this.Field455 = null;
                }
                if (this.Field408.getValue().floatValue() >= 0.5f) {
                    try {
                        this.Field449.remove((Object) new BlockPos(sPacketSoundEffect.getX(), sPacketSoundEffect.getY() - 1.0, sPacketSoundEffect.getZ()));
                    } catch (ConcurrentModificationException concurrentModificationException) {
                    }
                }
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityStatus) {
            SPacketEntityStatus sPacketEntityStatus = (SPacketEntityStatus) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketEntityStatus.getOpCode() == 35 && sPacketEntityStatus.getEntity((World) TestAutoCrystal3.Field2811.world) instanceof EntityPlayer) {
                this.Field448.put((EntityPlayer) sPacketEntityStatus.getEntity((World) TestAutoCrystal3.Field2811.world), new Timer());
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook && this.Field426.getValue().booleanValue() && !AliceMain.Field756.Method2150180(PacketFlight.class).Method2150364()) {
            this.Method2150391();
        }
    }

    public boolean Method2161733(BlockPos blockPos, EnumFacing enumFacing) {
        if (blockPos != null) {
            if (this.Field403.getValue().booleanValue()) {
                if (this.Field439.Method2164755((long) (this.Field404.getValue().floatValue() * 50.0f))) {
                    if (!this.Method2161752()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (!this.Method2161751() && TestAutoCrystal3.Field2811.player.getHeldItemMainhand().getItem() != Items.END_CRYSTAL) {
                return false;
            }
            if (TestAutoCrystal3.Field2811.world.getBlockState(blockPos.up()).getBlock() == Blocks.FIRE) {
                TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                return true;
            }
            this.Field445 = true;
            if (this.Field435 == null) {
                BlockUtilSC.Method2162870(blockPos, TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0), this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
            } else {
                TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, (float) this.Field435.hitVec.x, (float) this.Field435.hitVec.y, (float) this.Field435.hitVec.z));
                TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            }
            if (this.Field464 && this.Field461 != null) {
                this.Field448.put(this.Field461, new Timer());
            }
            this.Field445 = false;
            this.Field446.put(blockPos, System.currentTimeMillis());
            if (this.Field408.getValue().floatValue() >= 0.5f) {
                this.Field449.add(blockPos);
            }
            this.Field442.Method2164750();
            this.Field433 = blockPos;
            return true;
        }
        return false;
    }

    private boolean Method2161734(EntityEnderCrystal entityEnderCrystal) {
        if (!this.Field438.Method2164755((long) (this.Field405.getValue().floatValue() * 100.0f))) {
            return false;
        }
        if (entityEnderCrystal != null) {
            if (this.Field406.getValue().booleanValue() && TestAutoCrystal3.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && !(TestAutoCrystal3.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
                this.Method2161740();
                return false;
            }
            TestAutoCrystal3.Field2811.playerController.attackEntity((EntityPlayer) TestAutoCrystal3.Field2811.player, (Entity) entityEnderCrystal);
            TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            this.Method2161735(this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                this.Field436.Method2164750();
            }
            if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT) {
                this.Field460.set(true);
            }
            this.Field454.Method2164750();
            this.Field455 = entityEnderCrystal;
            this.Field443 = new BlockPos((Entity) entityEnderCrystal).down();
            this.Field444.Method2164750();
            return true;
        }
        return false;
    }

    private void Method2161735(EnumHand enumHand) {
        if (!this.Field427.getValue().booleanValue()) {
            return;
        }
        ItemStack itemStack = TestAutoCrystal3.Field2811.player.getHeldItem(enumHand);
        if (!itemStack.isEmpty() && itemStack.getItem().onEntitySwing((EntityLivingBase) TestAutoCrystal3.Field2811.player, itemStack)) {
            return;
        }
        if (!TestAutoCrystal3.Field2811.player.isSwingInProgress || TestAutoCrystal3.Field2811.player.swingProgressInt >= this.Method2161736((EntityLivingBase) TestAutoCrystal3.Field2811.player) / 2 || TestAutoCrystal3.Field2811.player.swingProgressInt < 0) {
            TestAutoCrystal3.Field2811.player.swingProgressInt = -1;
            TestAutoCrystal3.Field2811.player.isSwingInProgress = true;
            TestAutoCrystal3.Field2811.player.swingingHand = enumHand;
        }
    }

    private int Method2161736(EntityLivingBase entityLivingBase) {
        if (entityLivingBase.isPotionActive(MobEffects.HASTE)) {
            return 6 - (1 + entityLivingBase.getActivePotionEffect(MobEffects.HASTE).getAmplifier());
        }
        return entityLivingBase.isPotionActive(MobEffects.MINING_FATIGUE) ? 6 + (1 + entityLivingBase.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2 : 6;
    }

    public EntityEnderCrystal Method2161737() {
        return this.Field431;
    }

    public BlockPos Method2161738() {
        return this.Field432;
    }

    private List<Entity> Method2161739() {
        return TestAutoCrystal3.Field2811.world.loadedEntityList.stream().filter(TestAutoCrystal3::Method2161775).filter(this::Method2161774).collect(Collectors.toList());
    }

    private boolean Method2161730(EntityEnderCrystal entityEnderCrystal) {
        if (TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f).distanceTo(entityEnderCrystal.getPositionVector()) > (double) this.Field399.getValue().floatValue()) {
            return false;
        }
        if (this.Field447.containsKey(entityEnderCrystal.getEntityId()) && this.Field380.getValue().booleanValue()) {
            return false;
        }
        if (this.Field447.containsKey(entityEnderCrystal.getEntityId()) && entityEnderCrystal.ticksExisted > this.Field391.getValue() + this.Field392.getValue()) {
            return false;
        }
        return !(CrystalUtilSC.Method2162915(entityEnderCrystal, (Entity) TestAutoCrystal3.Field2811.player) + this.Field412.getValue().floatValue() >= TestAutoCrystal3.Field2811.player.getHealth() + TestAutoCrystal3.Field2811.player.getAbsorptionAmount());
    }

    private EntityEnderCrystal Method2161741(List<EntityPlayer> list) {
        this.Field447.forEach((arg_0, arg_1) -> this.Method2161773(arg_0, arg_1));
        if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT && !this.Field380.getValue().booleanValue() && this.Field460.get()) {
            return null;
        }
        EntityEnderCrystal entityEnderCrystal = null;
        int n2 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
        if (this.Field379.getValue().booleanValue() && !this.Field380.getValue().booleanValue() && !this.Field454.Method2164755(n2) && this.Field455 != null && TestAutoCrystal3.Field2811.world.getEntityByID(this.Field455.getEntityId()) != null && this.Method2161730(this.Field455)) {
            entityEnderCrystal = this.Field455;
            return entityEnderCrystal;
        }
        List<Entity> list2 = this.Method2161739();
        if (list2.isEmpty()) {
            return null;
        }
        if (this.Field408.getValue().floatValue() >= 1.0f) {
            double d = 0.5;
            for (Entity entity : list2) {
                if (!(entity.getPositionVector().distanceTo(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field400.getValue().floatValue()) && !CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ))
                    continue;
                EntityEnderCrystal entityEnderCrystal2 = (EntityEnderCrystal) entity;
                double d2 = 0.0;
                for (EntityPlayer entityPlayer : list) {
                    double d3 = CrystalUtilSC.Method2162915(entityEnderCrystal2, (Entity) entityPlayer);
                    d2 += d3;
                }
                double d4 = CrystalUtilSC.Method2162915(entityEnderCrystal2, (Entity) TestAutoCrystal3.Field2811.player);
                if (d4 > d2 * (double) (this.Field408.getValue().floatValue() - 0.8f) && !this.Field449.contains((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ)) || !(d2 > d))
                    continue;
                d = d2;
                entityEnderCrystal = entityEnderCrystal2;
            }
        } else {
            entityEnderCrystal = this.Field408.getValue().floatValue() >= 0.5f ? (EntityEnderCrystal) list2.stream().filter(this::Method2161772).filter(this::Method2161771).min(Comparator.comparing(TestAutoCrystal3::Method2161760)).orElse(null) : (EntityEnderCrystal) list2.stream().filter(this::Method2161769).min(Comparator.comparing(TestAutoCrystal3::Method2161768)).orElse(null);
        }
        return entityEnderCrystal;
    }

    private boolean Method2161742(EntityPlayer entityPlayer) {
        if (!this.Field415.getValue().booleanValue()) {
            return false;
        }
        for (int j = 3; j >= 0; --j) {
            double d;
            ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(j);
            if (itemStack == null || !((d = itemStack.getItem().getDurabilityForDisplay(itemStack)) > (double) this.Field416.getValue().floatValue()))
                continue;
            return true;
        }
        return false;
    }

    private BlockPos Method2161743(List<BlockPos> list, List<EntityPlayer> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        float f = 0.5f;
        EntityPlayer entityPlayer = null;
        BlockPos blockPos = null;
        this.Field464 = false;
        EntityPlayer entityPlayer2 = null;
        for (BlockPos blockPos2 : list) {
            float f2 = CrystalUtilSC.Method2162913(blockPos2, (Entity) TestAutoCrystal3.Field2811.player);
            if (!((double) f2 + (double) this.Field412.getValue().floatValue() < (double) (TestAutoCrystal3.Field2811.player.getHealth() + TestAutoCrystal3.Field2811.player.getAbsorptionAmount())) || !(f2 <= this.Field411.getValue().floatValue()))
                continue;
            if (this.Field407.getValue() != IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.ALL) {
                entityPlayer2 = list2.get(0);
                if (entityPlayer2.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5) > (double) this.Field398.getValue().floatValue())
                    continue;
                float f3 = CrystalUtilSC.Method2162913(blockPos2, (Entity) entityPlayer2);
                if (this.Method2161744(entityPlayer2, f3) && (blockPos == null || entityPlayer2.getDistanceSq(blockPos2) < entityPlayer2.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer2;
                    f = f3;
                    blockPos = blockPos2;
                    this.Field464 = true;
                    continue;
                }
                if (this.Field464 || !(f3 > f) || !(f3 * this.Field409.getValue().floatValue() > f2) && !(f3 > entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount()) || f3 < this.Field410.getValue().floatValue() && entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount() > this.Field413.getValue().floatValue() && !this.Field414.getValue().isDown() && !this.Method2161742(entityPlayer2))
                    continue;
                f = f3;
                entityPlayer = entityPlayer2;
                blockPos = blockPos2;
                continue;
            }
            for (EntityPlayer entityPlayer3 : list2) {
                if (entityPlayer3.equals((Object) entityPlayer2) || entityPlayer3.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5) > (double) this.Field398.getValue().floatValue())
                    continue;
                float f4 = CrystalUtilSC.Method2162913(blockPos2, (Entity) entityPlayer3);
                if (this.Method2161744(entityPlayer3, f4) && (blockPos == null || entityPlayer3.getDistanceSq(blockPos2) < entityPlayer3.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer3;
                    f = f4;
                    blockPos = blockPos2;
                    this.Field464 = true;
                    continue;
                }
                if (this.Field464 || !(f4 > f) || !(f4 * this.Field409.getValue().floatValue() > f2) && !(f4 > entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount()) || f4 < this.Field410.getValue().floatValue() && entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount() > this.Field413.getValue().floatValue() && !this.Field414.getValue().isDown() && !this.Method2161742(entityPlayer3))
                    continue;
                f = f4;
                entityPlayer = entityPlayer3;
                blockPos = blockPos2;
            }
        }
        if (entityPlayer != null && blockPos != null) {
            this.Field461 = entityPlayer;
            this.Field462.Method2164750();
        }
        if (blockPos != null) {
            this.Field440 = blockPos;
            this.Field441 = f;
        }
        this.Field453 = blockPos;
        this.Field452.Method2164750();
        return blockPos;
    }

    private boolean Method2161744(EntityPlayer entityPlayer, float f) {
        if (this.Field418.getValue().booleanValue() && entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() <= 2.0f && (double) f > (double) entityPlayer.getHealth() + (double) entityPlayer.getAbsorptionAmount() + 0.5 && f <= 4.0f) {
            Timer timer = this.Field448.get((Object) entityPlayer);
            return timer == null || timer.Method2164755(500L);
        }
        return false;
    }

    public void Method2161745(double d, double d2, double d3) {
        if (this.Field378.getValue() != IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.OFF) {
            if (this.Field378.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.INTERACT && this.Field428 != null && !this.Field430.Method2164755(650L)) {
                if (this.Field428.y < d2 - 0.1) {
                    this.Field428 = new Vec3d(this.Field428.x, d2, this.Field428.z);
                }
                this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                this.Field430.Method2164750();
                return;
            }
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d - 1.0, d2, d3 - 1.0, d + 1.0, d2 + 2.0, d3 + 1.0);
            Vec3d vec3d = new Vec3d(TestAutoCrystal3.Field2811.player.posX, TestAutoCrystal3.Field2811.player.getEntityBoundingBox().minY + (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), TestAutoCrystal3.Field2811.player.posZ);
            double d4 = 0.1;
            double d5 = 0.15;
            double d6 = 0.85;
            if (axisAlignedBB.intersects(TestAutoCrystal3.Field2811.player.getEntityBoundingBox())) {
                d5 = 0.4;
                d6 = 0.6;
                d4 = 0.05;
            }
            Vec3d vec3d2 = null;
            double[] arrd = null;
            boolean bl = false;
            for (double d7 = d5; d7 <= d6; d7 += d4) {
                for (double d8 = d5; d8 <= d6; d8 += d4) {
                    for (double d9 = d5; d9 <= d6; d9 += d4) {
                        Vec3d vec3d3 = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d7, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d8, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d9);
                        double d10 = vec3d3.x - vec3d.x;
                        double d11 = vec3d3.y - vec3d.y;
                        double d12 = vec3d3.z - vec3d.z;
                        double[] arrd2 = new double[]{MathHelper.wrapDegrees((float) ((float) Math.toDegrees(Math.atan2(d12, d10)) - 90.0f)), MathHelper.wrapDegrees((float) ((float) (-Math.toDegrees(Math.atan2(d11, Math.sqrt(d10 * d10 + d12 * d12))))))};
                        boolean bl2 = true;
                        if (this.Field386.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA && !CrystalUtilSC.Method2162890(vec3d3)) {
                            bl2 = false;
                        }
                        if (this.Field384.getValue().booleanValue()) {
                            if (vec3d2 != null && arrd != null) {
                                if (!bl2 && bl || !(TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d3) < TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d2)))
                                    continue;
                                vec3d2 = vec3d3;
                                arrd = arrd2;
                                continue;
                            }
                            vec3d2 = vec3d3;
                            arrd = arrd2;
                            bl = bl2;
                            continue;
                        }
                        if (vec3d2 != null && arrd != null) {
                            if (!bl2 && bl || !(Math.hypot(((arrd2[0] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd2[1] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedPitch())))
                                continue;
                            vec3d2 = vec3d3;
                            arrd = arrd2;
                            continue;
                        }
                        vec3d2 = vec3d3;
                        arrd = arrd2;
                        bl = bl2;
                    }
                }
            }
            if (vec3d2 != null && arrd != null) {
                this.Field430.Method2164750();
                this.Field428 = vec3d2;
                this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
            }
        }
    }

    public EnumFacing Method2161746(BlockPos blockPos) {
        if (blockPos == null || TestAutoCrystal3.Field2811.player == null) {
            return null;
        }
        EnumFacing enumFacing = null;
        if (this.Field386.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA) {
            double[] arrd;
            Vec3d vec3d;
            RayTraceResult rayTraceResult;
            Vec3d vec3d2;
            Vec3d vec3d3;
            float f;
            float f2;
            float f3;
            float f4;
            double[] arrd2;
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            Vec3d vec3d4;
            double d6;
            double d7;
            double d8;
            Vec3d vec3d5 = null;
            double[] arrd3 = null;
            double d9 = 0.45;
            double d10 = 0.05;
            double d11 = 0.95;
            Vec3d vec3d6 = new Vec3d(TestAutoCrystal3.Field2811.player.posX, TestAutoCrystal3.Field2811.player.getEntityBoundingBox().minY + (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), TestAutoCrystal3.Field2811.player.posZ);
            for (d8 = d10; d8 <= d11; d8 += d9) {
                for (d7 = d10; d7 <= d11; d7 += d9) {
                    for (d6 = d10; d6 <= d11; d6 += d9) {
                        vec3d4 = new Vec3d((Vec3i) blockPos).add(d8, d7, d6);
                        d5 = vec3d6.distanceTo(vec3d4);
                        d4 = vec3d4.x - vec3d6.x;
                        d3 = vec3d4.y - vec3d6.y;
                        d2 = vec3d4.z - vec3d6.z;
                        d = MathHelper.sqrt((double) (d4 * d4 + d2 * d2));
                        arrd2 = new double[]{MathHelper.wrapDegrees((float) ((float) Math.toDegrees(Math.atan2(d2, d4)) - 90.0f)), MathHelper.wrapDegrees((float) ((float) (-Math.toDegrees(Math.atan2(d3, d)))))};
                        f4 = MathHelper.cos((float) ((float) (-arrd2[0] * 0.01745329238474369 - 3.1415927410125732)));
                        f3 = MathHelper.sin((float) ((float) (-arrd2[0] * 0.01745329238474369 - 3.1415927410125732)));
                        f2 = -MathHelper.cos((float) ((float) (-arrd2[1] * 0.01745329238474369)));
                        f = MathHelper.sin((float) ((float) (-arrd2[1] * 0.01745329238474369)));
                        vec3d3 = new Vec3d((double) (f3 * f2), (double) f, (double) (f4 * f2));
                        vec3d2 = vec3d6.add(vec3d3.x * d5, vec3d3.y * d5, vec3d3.z * d5);
                        rayTraceResult = TestAutoCrystal3.Field2811.world.rayTraceBlocks(vec3d6, vec3d2, false, true, false);
                        if (!(this.Field402.getValue().floatValue() >= this.Field401.getValue().floatValue() || rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && rayTraceResult.getBlockPos().equals((Object) blockPos)))
                            continue;
                        vec3d = vec3d4;
                        arrd = arrd2;
                        if (this.Field384.getValue().booleanValue()) {
                            if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d5)))
                                    continue;
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field435 = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field435 = rayTraceResult;
                            continue;
                        }
                        if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                            if (!(Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd3[0] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd3[1] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedPitch())))
                                continue;
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field435 = rayTraceResult;
                            continue;
                        }
                        vec3d5 = vec3d;
                        arrd3 = arrd;
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                        enumFacing = rayTraceResult.sideHit;
                        this.Field435 = rayTraceResult;
                    }
                }
            }
            if (this.Field402.getValue().floatValue() < this.Field401.getValue().floatValue() && this.Field386.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRICT) {
                if (arrd3 != null && enumFacing != null) {
                    this.Field430.Method2164750();
                    this.Field428 = vec3d5;
                    this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                    return enumFacing;
                }
                for (d8 = d10; d8 <= d11; d8 += d9) {
                    for (d7 = d10; d7 <= d11; d7 += d9) {
                        for (d6 = d10; d6 <= d11; d6 += d9) {
                            vec3d4 = new Vec3d((Vec3i) blockPos).add(d8, d7, d6);
                            d5 = vec3d6.distanceTo(vec3d4);
                            d4 = vec3d4.x - vec3d6.x;
                            d3 = vec3d4.y - vec3d6.y;
                            d2 = vec3d4.z - vec3d6.z;
                            d = MathHelper.sqrt((double) (d4 * d4 + d2 * d2));
                            arrd2 = new double[]{MathHelper.wrapDegrees((float) ((float) Math.toDegrees(Math.atan2(d2, d4)) - 90.0f)), MathHelper.wrapDegrees((float) ((float) (-Math.toDegrees(Math.atan2(d3, d)))))};
                            f4 = MathHelper.cos((float) ((float) (-arrd2[0] * 0.01745329238474369 - 3.1415927410125732)));
                            f3 = MathHelper.sin((float) ((float) (-arrd2[0] * 0.01745329238474369 - 3.1415927410125732)));
                            f2 = -MathHelper.cos((float) ((float) (-arrd2[1] * 0.01745329238474369)));
                            f = MathHelper.sin((float) ((float) (-arrd2[1] * 0.01745329238474369)));
                            vec3d3 = new Vec3d((double) (f3 * f2), (double) f, (double) (f4 * f2));
                            vec3d2 = vec3d6.add(vec3d3.x * d5, vec3d3.y * d5, vec3d3.z * d5);
                            rayTraceResult = TestAutoCrystal3.Field2811.world.rayTraceBlocks(vec3d6, vec3d2, false, true, true);
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            vec3d = vec3d4;
                            arrd = arrd2;
                            if (this.Field384.getValue().booleanValue()) {
                                if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                    if (!(TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d5)))
                                        continue;
                                    vec3d5 = vec3d;
                                    arrd3 = arrd;
                                    if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                        continue;
                                    enumFacing = rayTraceResult.sideHit;
                                    this.Field435 = rayTraceResult;
                                    continue;
                                }
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field435 = rayTraceResult;
                                continue;
                            }
                            if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd3[0] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd3[1] - (double) ((IEntityPlayerSP) TestAutoCrystal3.Field2811.player).getLastReportedPitch())))
                                    continue;
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field435 = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field435 = rayTraceResult;
                        }
                    }
                }
            } else {
                if (arrd3 != null) {
                    this.Field430.Method2164750();
                    this.Field428 = vec3d5;
                    this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                }
                if (enumFacing != null) {
                    return enumFacing;
                }
            }
        } else {
            Vec3d vec3d;
            EnumFacing enumFacing2 = null;
            Vec3d vec3d7 = null;
            for (EnumFacing enumFacing3 : EnumFacing.values()) {
                vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing3.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing3.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing3.getDirectionVec().getZ() * 0.5);
                RayTraceResult rayTraceResult = TestAutoCrystal3.Field2811.world.rayTraceBlocks(new Vec3d(TestAutoCrystal3.Field2811.player.posX, TestAutoCrystal3.Field2811.player.posY + (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), TestAutoCrystal3.Field2811.player.posZ), vec3d, false, true, false);
                if (rayTraceResult == null || !rayTraceResult.typeOfHit.equals((Object) RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                    continue;
                if (this.Field384.getValue().booleanValue()) {
                    if (vec3d7 != null && !(TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d7)))
                        continue;
                    vec3d7 = vec3d;
                    enumFacing2 = enumFacing3;
                    this.Field435 = rayTraceResult;
                    continue;
                }
                this.Field430.Method2164750();
                this.Field428 = vec3d;
                this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                return enumFacing3;
            }
            if (enumFacing2 != null) {
                this.Field430.Method2164750();
                this.Field428 = vec3d7;
                this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                return enumFacing2;
            }
            if (this.Field384.getValue().booleanValue()) {
                for (EnumFacing enumFacing3 : EnumFacing.values()) {
                    vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing3.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing3.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing3.getDirectionVec().getZ() * 0.5);
                    if (vec3d7 != null && !(TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d7)))
                        continue;
                    vec3d7 = vec3d;
                    enumFacing2 = enumFacing3;
                }
                if (enumFacing2 != null) {
                    this.Field430.Method2164750();
                    this.Field428 = vec3d7;
                    this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
                    return enumFacing2;
                }
            }
        }
        if ((double) blockPos.getY() > TestAutoCrystal3.Field2811.player.posY + (double) TestAutoCrystal3.Field2811.player.getEyeHeight()) {
            this.Field430.Method2164750();
            this.Field428 = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
            this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
            return EnumFacing.DOWN;
        }
        this.Field430.Method2164750();
        this.Field428 = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
        this.Field429 = RotationManager.Method2150291(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f), this.Field428);
        return EnumFacing.UP;
    }

    private List<BlockPos> Method2161747() {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) TestAutoCrystal3.Method2161753(new BlockPos((Entity) TestAutoCrystal3.Field2811.player), this.Field384.getValue() != false ? this.Field401.getValue().floatValue() + 2.0f : this.Field401.getValue().floatValue(), this.Field401.getValue().intValue(), false, true, 0).stream().filter(this::Method2161748).collect(Collectors.toList()));
        return nonNullList;
    }

    public boolean Method2161748(BlockPos blockPos) {
        if (TestAutoCrystal3.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && TestAutoCrystal3.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (!(TestAutoCrystal3.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || TestAutoCrystal3.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.FIRE && this.Field389.getValue().booleanValue() || TestAutoCrystal3.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid && this.Field388.getValue().booleanValue())) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (!(this.Field387.getValue().booleanValue() || TestAutoCrystal3.Field2811.world.getBlockState(blockPos3).getBlock() == Blocks.AIR || TestAutoCrystal3.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid && this.Field388.getValue().booleanValue())) {
            return false;
        }
        if (this.Field385.getValue().booleanValue() && !CrystalUtilSC.Method2162899((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5)) {
            Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
            if (TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double) this.Field400.getValue().floatValue()) {
                return false;
            }
        }
        if (this.Field402.getValue().floatValue() < this.Field401.getValue().floatValue()) {
            if (!CrystalUtilSC.Method2162916(blockPos)) {
                if (this.Field384.getValue().booleanValue()) {
                    boolean bl;
                    block30:
                    {
                        Vec3d vec3d = TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0);
                        bl = false;
                        if (this.Field386.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA) {
                            for (EnumFacing enumFacing : EnumFacing.values()) {
                                Vec3d vec3d2 = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                                if (!(vec3d.distanceTo(vec3d2) <= (double) this.Field402.getValue().floatValue())) {
                                    continue;
                                }
                                bl = true;
                                break;
                            }
                        } else {
                            double d = 0.45;
                            double d2 = 0.05;
                            double d3 = 0.95;
                            for (double d4 = d2; d4 <= d3; d4 += d) {
                                for (double d5 = d2; d5 <= d3; d5 += d) {
                                    for (double d6 = d2; d6 <= d3; d6 += d) {
                                        Vec3d vec3d3 = new Vec3d((Vec3i) blockPos).add(d4, d5, d6);
                                        double d7 = vec3d.distanceTo(vec3d3);
                                        if (!(d7 <= (double) this.Field402.getValue().floatValue())) {
                                            continue;
                                        }
                                        bl = true;
                                        break block30;
                                    }
                                }
                            }
                        }
                    }
                    if (!bl) {
                        return false;
                    }
                } else if ((double) blockPos.getY() > TestAutoCrystal3.Field2811.player.posY + (double) TestAutoCrystal3.Field2811.player.getEyeHeight() ? TestAutoCrystal3.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5) > (double) this.Field402.getValue().floatValue() : TestAutoCrystal3.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) (blockPos.getY() + 1), (double) blockPos.getZ() + 0.5) > (double) this.Field402.getValue().floatValue()) {
                    return false;
                }
            }
        } else if (this.Field384.getValue().booleanValue()) {
            boolean bl;
            block31:
            {
                Vec3d vec3d = TestAutoCrystal3.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal3.Field2811.player.getEyeHeight(), 0.0);
                bl = false;
                if (this.Field386.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA) {
                    for (EnumFacing enumFacing : EnumFacing.values()) {
                        Vec3d vec3d4 = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                        if (!(vec3d.distanceTo(vec3d4) <= (double) this.Field401.getValue().floatValue())) {
                            continue;
                        }
                        bl = true;
                        break;
                    }
                } else {
                    double d = 0.45;
                    double d8 = 0.05;
                    double d9 = 0.95;
                    for (double d10 = d8; d10 <= d9; d10 += d) {
                        for (double d11 = d8; d11 <= d9; d11 += d) {
                            for (double d12 = d8; d12 <= d9; d12 += d) {
                                Vec3d vec3d5 = new Vec3d((Vec3i) blockPos).add(d10, d11, d12);
                                double d13 = vec3d.distanceTo(vec3d5);
                                if (!(d13 <= (double) this.Field401.getValue().floatValue())) {
                                    continue;
                                }
                                bl = true;
                                break block31;
                            }
                        }
                    }
                }
            }
            if (!bl) {
                return false;
            }
        }
        return TestAutoCrystal3.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).stream().filter(this::Method2161767).count() == 0L;
    }

    private List<EntityPlayer> Method2161749() {
        List<Object> list = TestAutoCrystal3.Field2811.world.playerEntities.stream().filter(TestAutoCrystal3::Method2161766).filter(TestAutoCrystal3::Method2161765).filter(TestAutoCrystal3::Method2161764).filter(TestAutoCrystal3::Method2161763).filter(this::Method2161762).sorted(Comparator.comparing(TestAutoCrystal3::Method2161761)).collect(Collectors.toList());
        if (this.Field407.getValue() == IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.SMART) {
            List list2 = list.stream().filter(TestAutoCrystal3::Method2161750).sorted(Comparator.comparing(TestAutoCrystal3::Method2161759)).collect(Collectors.toList());
            if (list2.size() > 0) {
                list = list2;
            }
            if ((list2 = list.stream().filter(TestAutoCrystal3::Method2161758).sorted(Comparator.comparing(TestAutoCrystal3::Method2161757)).collect(Collectors.toList())).size() > 0) {
                list = list2;
            }
        }
        return list;
    }

    public void Method2161740() {
        int n2 = CrystalUtilSC.Method2162807();
        if (TestAutoCrystal3.Field2811.player.inventory.currentItem != n2 && n2 != -1) {
            TestAutoCrystal3.Field2811.player.inventory.currentItem = n2;
            TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            this.Field439.Method2164750();
            this.Field438.Method2164750();
        }
    }

    public boolean Method2161751() {
        return TestAutoCrystal3.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public boolean Method2161752() {
        if (this.Method2161751()) {
            return true;
        }
        int n2 = CrystalUtilSC.Method2162806();
        if (n2 == -1) {
            return false;
        }
        if (TestAutoCrystal3.Field2811.player.inventory.currentItem != n2) {
            TestAutoCrystal3.Field2811.player.inventory.currentItem = n2;
            TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            this.Field439.Method2164750();
            this.Field438.Method2164750();
        }
        return true;
    }

    public boolean Method2161756(EntityPlayer entityPlayer) {
        return (double) entityPlayer.moveForward != 0.0 || (double) entityPlayer.moveStrafing != 0.0;
    }

    private boolean Method2161762(EntityPlayer entityPlayer) {
        return TestAutoCrystal3.Field2811.player.getDistance((Entity) entityPlayer) < this.Field397.getValue().floatValue();
    }

    private boolean Method2161767(Entity entity) {
        return !this.Field447.containsKey(entity.getEntityId()) && (!(entity instanceof EntityEnderCrystal) || entity.ticksExisted > 20);
    }

    private boolean Method2161769(Entity entity) {
        return entity.getPositionVector().distanceTo(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field400.getValue().floatValue() || CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ);
    }

    private boolean Method2161771(Entity entity) {
        return entity.getPositionVector().distanceTo(TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field400.getValue().floatValue() || CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ);
    }

    private boolean Method2161772(Entity entity) {
        return this.Field449.contains((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ));
    }

    private void Method2161773(Integer n2, Long l2) {
        if (System.currentTimeMillis() - l2 > 1000L) {
            this.Field447.remove(n2);
        }
    }

    private boolean Method2161774(Entity entity) {
        return this.Method2161730((EntityEnderCrystal) entity);
    }

    private void Method2161776(SPacketSpawnObject sPacketSpawnObject, BlockPos blockPos, Long l2) {
        if (this.Method2161729((double) blockPos.getX() + 0.5, blockPos.getY(), (double) blockPos.getZ() + 0.5, sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ()) < 1.0) {
            try {
                this.Field446.remove((Object) blockPos);
                this.Field453 = null;
                if (!this.Field380.getValue().booleanValue() && this.Field379.getValue().booleanValue()) {
                    this.Field456.Method2164750();
                }
            } catch (ConcurrentModificationException concurrentModificationException) {
                // empty catch block
            }
            if (this.Field377.getValue() != IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.ADAPTIVE) {
                return;
            }
            if (!this.Field438.Method2164755((long) (this.Field405.getValue().floatValue() * 100.0f))) {
                return;
            }
            if (this.Field450.get()) {
                return;
            }
            if (TestAutoCrystal3.Field2811.player.isPotionActive(MobEffects.WEAKNESS)) {
                return;
            }
            if (this.Field447.containsKey(sPacketSpawnObject.getEntityID())) {
                return;
            }
            if (TestAutoCrystal3.Field2811.player.getHealth() + TestAutoCrystal3.Field2811.player.getAbsorptionAmount() < this.Field425.getValue().floatValue() || this.Field423.getValue() != false && AliceMain.Field756.Method2150180(Aura.class).Method2150364() || this.Field424.getValue() != false && AliceMain.Field756.Method2150180(PistonCrystal.class).Method2150364() || this.Field421.getValue() != false && TestAutoCrystal3.Field2811.player.getActiveItemStack().getItem() instanceof ItemFood || this.Field420.getValue().booleanValue() && TestAutoCrystal3.Field2811.playerController.getIsHittingBlock() && TestAutoCrystal3.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
                this.Field428 = null;
                return;
            }
            Vec3d vec3d = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            if (TestAutoCrystal3.Field2811.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double) this.Field399.getValue().floatValue()) {
                return;
            }
            if (!this.Field437.Method2164755((long) (1000.0f - this.Field393.getValue().floatValue() * 50.0f))) {
                return;
            }
            if (CrystalUtilSC.Method2162914(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ(), (Entity) TestAutoCrystal3.Field2811.player) + this.Field412.getValue().floatValue() >= TestAutoCrystal3.Field2811.player.getHealth() + TestAutoCrystal3.Field2811.player.getAbsorptionAmount()) {
                return;
            }
            this.Field447.put(sPacketSpawnObject.getEntityID(), System.currentTimeMillis());
            this.Field457 = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
            ((ICPacketUseEntity) cPacketUseEntity).setEntityId(sPacketSpawnObject.getEntityID());
            ((ICPacketUseEntity) cPacketUseEntity).setAction(CPacketUseEntity.Action.ATTACK);
            TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            TestAutoCrystal3.Field2811.player.connection.sendPacket((Packet) cPacketUseEntity);
            this.Method2161735(this.Method2161751() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            this.Field443 = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ());
            this.Field444.Method2164750();
            this.Field437.Method2164750();
            this.Field451.Method2164750();
            if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                this.Field436.Method2164750();
            }
            if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT) {
                this.Field460.set(true);
            }
            if (this.Field395.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                this.Method2161731();
            }
        }
    }

    private void Method2161777(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > 1500L) {
            this.Field446.remove((Object) blockPos);
        }
    }

    private boolean Method2161778(Boolean bl) {
        return this.Field421.getValue();
    }

    private boolean Method2161779(Boolean bl) {
        return this.Field415.getValue();
    }

    private boolean Method2161770(Boolean bl) {
        return this.Field415.getValue();
    }

    private boolean Method2161781(Integer n2) {
        return this.Field415.getValue();
    }

    private boolean Method2161782(Float f) {
        return this.Field415.getValue();
    }

    private static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        OFF,
        SEMI,
        FULL;

    }

    public static enum IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
        NONE,
        FLAT,
        SHADED;

    }

    private static enum IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll {
        OFF,
        TRACK,
        INTERACT;

    }

    private static enum IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll {
        SEQUENTIAL,
        ADAPTIVE;

    }

    private static enum IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl {
        OFF,
        BREAK,
        FULL;

    }

    private static enum IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll {
        ALL,
        SMART,
        NEAREST;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        VANILLA,
        NORMAL,
        STRICT;

    }

    public static enum IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll {
        STRICT,
        MERGE;

    }

    private static class IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll
            implements Runnable {
        private static IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll Field3824;
        private TestAutoCrystal3 Field3825;

        private IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        }

        private static IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll Method2161722(TestAutoCrystal3 testAutoCrystal3) {
            if (Field3824 == null) {
                Field3824 = new IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
                IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field3824.Field3825 = testAutoCrystal3;
            }
            return Field3824;
        }

        static IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll Method2161723(TestAutoCrystal3 testAutoCrystal3) {
            return IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161722(testAutoCrystal3);
        }

        @Override
        public void run() {
            if (TestAutoCrystal3.Method2161783(this.Field3825).get()) {
                try {
                    Thread.sleep((long) (TestAutoCrystal3.Method2161784() * 40.0f));
                } catch (InterruptedException interruptedException) {
                    TestAutoCrystal3.Method2161785(this.Field3825).interrupt();
                }
                if (!TestAutoCrystal3.Method2161783(this.Field3825).get()) {
                    return;
                }
                TestAutoCrystal3.Method2161783(this.Field3825).set(false);
                if (this.Field3825.Field450.get()) {
                    return;
                }
                TestAutoCrystal3.Method2161786(this.Field3825);
            }
        }
    }
}

