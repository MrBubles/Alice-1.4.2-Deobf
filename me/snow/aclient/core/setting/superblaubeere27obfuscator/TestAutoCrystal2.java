

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketFlight;
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

public class TestAutoCrystal2
        extends Module {
    private static TestAutoCrystal2 Field468 = new TestAutoCrystal2();
    private static float Field556;
    public final Setting<Bind> Field506 = this.Method2150366(new Setting<Bind>("Faceplace", new Bind(-1)));
    public final Timer Field527 = new Timer();
    public final Timer Field528 = new Timer();
    public final Timer Field529 = new Timer();
    public final Timer Field530 = new Timer();
    public final Timer Field533 = new Timer();
    public final Timer Field535 = new Timer();
    public final ConcurrentHashMap<BlockPos, Long> Field537 = new ConcurrentHashMap();
    public final ConcurrentHashMap<Integer, Long> Field538 = new ConcurrentHashMap();
    public final Map<EntityPlayer, Timer> Field539 = new ConcurrentHashMap<EntityPlayer, Timer>();
    public final List<BlockPos> Field540 = new CopyOnWriteArrayList<BlockPos>();
    public final Timer Field542 = new Timer();
    public final Timer Field543 = new Timer();
    public final Timer Field545 = new Timer();
    private final Setting<Boolean> Field507 = this.Method2150366(new Setting<Boolean>("ArmorBreaker", true));
    private final Setting<Float> Field508 = this.Method2150366(new Setting<Float>("Depletion", Float.valueOf(0.9f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2161717));
    private final Timer Field547 = new Timer();
    public Setting<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll> Field469 = this.Method2150366(new Setting<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll>("Timing", IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.ADAPTIVE));
    public Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll> Field470 = this.Method2150366(new Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll>("Rotate", IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.TRACK));
    public Setting<Boolean> Field471 = this.Method2150366(new Setting<Boolean>("Inhibit", false));
    public Setting<Boolean> Field472 = this.Method2150366(new Setting<Boolean>("Limit", true));
    public Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl> Field473 = this.Method2150366(new Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl>("YawStep", IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.OFF));
    public Setting<Float> Field474 = this.Method2150366(new Setting<Float>("YawAngle", Float.valueOf(0.3f), Float.valueOf(0.1f), Float.valueOf(1.0f)));
    public Setting<Integer> Field475 = this.Method2150366(new Setting<Integer>("YawTicks", 1, 1, 5));
    public Setting<Boolean> Field476 = this.Method2150366(new Setting<Boolean>("StrictDirection", true));
    public Setting<Boolean> Field477 = this.Method2150366(new Setting<Boolean>("Check", true));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field478 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Interact", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRICT));
    public Setting<Boolean> Field479 = this.Method2150366(new Setting<Boolean>("Protocol", false));
    public Setting<Boolean> Field480 = this.Method2150366(new Setting<Boolean>("PlaceInLiquids", false));
    public Setting<Boolean> Field481 = this.Method2150366(new Setting<Boolean>("PlaceInFire", false));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field482 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Confirm", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF));
    public Setting<Integer> Field483 = this.Method2150366(new Setting<Integer>("Delay", 0, 0, 20));
    public Setting<Integer> Field484 = this.Method2150366(new Setting<Integer>("AttackFactor", 3, 1, 20));
    public Setting<Float> Field485 = this.Method2150366(new Setting<Float>("BreakSpeed", Float.valueOf(20.0f), Float.valueOf(1.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field486 = this.Method2150366(new Setting<Float>("PlaceSpeed", Float.valueOf(20.0f), Float.valueOf(2.0f), Float.valueOf(20.0f)));
    public Setting<IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll> Field487 = this.Method2150366(new Setting<IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll>("Sync", IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT));
    public Setting<Float> Field488 = this.Method2150366(new Setting<Float>("Offset", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(8.0f)));
    public Setting<Float> Field489 = this.Method2150366(new Setting<Float>("EnemyRange", Float.valueOf(8.0f), Float.valueOf(4.0f), Float.valueOf(15.0f)));
    public Setting<Float> Field490 = this.Method2150366(new Setting<Float>("CrystalRange", Float.valueOf(6.0f), Float.valueOf(2.0f), Float.valueOf(12.0f)));
    public Setting<Float> Field491 = this.Method2150366(new Setting<Float>("BreakRange", Float.valueOf(4.3f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Float> Field492 = this.Method2150366(new Setting<Float>("BreakWalls", Float.valueOf(1.5f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Float> Field493 = this.Method2150366(new Setting<Float>("PlaceRange", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Float> Field494 = this.Method2150366(new Setting<Float>("PlaceWalls", Float.valueOf(3.0f), Float.valueOf(1.0f), Float.valueOf(6.0f)));
    public Setting<Boolean> Field495 = this.Method2150366(new Setting<Boolean>("AutoSwap", true));
    public Setting<Float> Field496 = this.Method2150366(new Setting<Float>("SwapDelay", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field497 = this.Method2150366(new Setting<Float>("GhostDelay", Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field498 = this.Method2150366(new Setting<Boolean>("AntiWeakness", false));
    public Setting<IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll> Field499 = this.Method2150366(new Setting<IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll>("Target", IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.ALL));
    public Setting<Float> Field500 = this.Method2150366(new Setting<Float>("Security", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    public Setting<Float> Field501 = this.Method2150366(new Setting<Float>("Compromise", Float.valueOf(1.0f), Float.valueOf(0.05f), Float.valueOf(2.0f)));
    public Setting<Float> Field502 = this.Method2150366(new Setting<Float>("MinDamage", Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field503 = this.Method2150366(new Setting<Float>("MaxSelfDmg", Float.valueOf(12.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field504 = this.Method2150366(new Setting<Float>("SuicideHealth", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Float> Field505 = this.Method2150366(new Setting<Float>("FaceplaceHealth", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Integer> Field509 = this.Method2150366(new Setting<Integer>("PredictTicks", Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(10), this::Method2161716));
    public Setting<Boolean> Field510 = this.Method2150366(new Setting<Boolean>("PredictPops", Boolean.valueOf(false), this::Method2161715));
    public Setting<Boolean> Field511 = this.Method2150366(new Setting<Boolean>("PredictDestruction", Boolean.valueOf(false), this::Method2161714));
    public Setting<Boolean> Field512 = this.Method2150366(new Setting<Boolean>("Mining", false));
    public Setting<Boolean> Field513 = this.Method2150366(new Setting<Boolean>("Gapping", false));
    public Setting<Boolean> Field514 = this.Method2150366(new Setting<Boolean>("RightClickGap", Boolean.valueOf(false), this::Method2161713));
    public Setting<Boolean> Field515 = this.Method2150366(new Setting<Boolean>("KillAura", true));
    public Setting<Boolean> Field516 = this.Method2150366(new Setting<Boolean>("PistonAura", true));
    public Setting<Float> Field517 = this.Method2150366(new Setting<Float>("Health", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(10.0f)));
    public Setting<Boolean> Field518 = this.Method2150366(new Setting<Boolean>("DisableOnTP", false));
    public Vec3d Field519 = null;
    public float[] Field520 = new float[]{0.0f, 0.0f};
    public Timer Field521 = new Timer();
    public BlockPos Field531;
    public float Field532 = 0.0f;
    public BlockPos Field534;
    public boolean Field536 = false;
    public AtomicBoolean Field541 = new AtomicBoolean(false);
    public BlockPos Field544 = null;
    public EntityEnderCrystal Field546 = null;
    private EntityEnderCrystal Field522;
    private BlockPos Field523;
    private BlockPos Field524 = null;
    private EnumFacing Field525;
    private RayTraceResult Field526;
    private Vec3d Field548 = null;
    private Thread Field549;
    private AtomicBoolean Field550 = new AtomicBoolean(false);
    private AtomicBoolean Field551 = new AtomicBoolean(false);
    private EntityPlayer Field552;
    private Timer Field553 = new Timer();
    private int Field554;
    private boolean Field555 = false;

    public TestAutoCrystal2() {
        super(" this.modules.add ( new NEWAC());", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0441\u0442\u0430\u0432\u0438\u0442-\u0438 \u043b\u043e\u043c\u0430\u0435\u0442 \u043a\u0440\u0438\u0441\u0442\u0430\u043b\u044b", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        this.Method2161650();
    }

    public static TestAutoCrystal2 Method2161659() {
        if (Field468 == null) {
            Field468 = new TestAutoCrystal2();
        }
        return Field468;
    }

    public static List<BlockPos> Method2161688(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static void Method2161689(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - ((IRenderManager) Field2811.getRenderManager()).getRenderPosX()), (double) ((double) f2 - ((IRenderManager) Field2811.getRenderManager()).getRenderPosY()), (double) ((double) f3 - ((IRenderManager) Field2811.getRenderManager()).getRenderPosZ()));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-Minecraft.getMinecraft().player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) Minecraft.getMinecraft().player.rotationPitch, (float) (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2161680(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        TestAutoCrystal2.Method2161689(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    private static Float Method2161692(EntityPlayer entityPlayer) {
        return Float.valueOf(TestAutoCrystal2.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161693(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() < 10.0f;
    }

    private static Float Method2161694(EntityPlayer entityPlayer) {
        return Float.valueOf(TestAutoCrystal2.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161695(EntityPlayer entityPlayer) {
        return !BlockUtilSC.Method2162896(new BlockPos((Entity) entityPlayer)) && (TestAutoCrystal2.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.AIR || TestAutoCrystal2.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.WEB || TestAutoCrystal2.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() instanceof BlockLiquid);
    }

    private static Float Method2161696(EntityPlayer entityPlayer) {
        return Float.valueOf(TestAutoCrystal2.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2161698(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    private static boolean Method2161699(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2161690(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    private static boolean Method2161601(EntityPlayer entityPlayer) {
        return entityPlayer != TestAutoCrystal2.Field2811.player && entityPlayer != Field2811.getRenderViewEntity();
    }

    private static Float Method2161603(Entity entity) {
        return Float.valueOf(TestAutoCrystal2.Field2811.player.getDistance(entity));
    }

    private static Float Method2161605(Entity entity) {
        return Float.valueOf(TestAutoCrystal2.Field2811.player.getDistance(entity));
    }

    private static boolean Method2161600(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    static AtomicBoolean Method2161718(TestAutoCrystal2 testAutoCrystal2) {
        return testAutoCrystal2.Field550;
    }

    static float Method2161719() {
        return Field556;
    }

    static Thread Method2161710(TestAutoCrystal2 testAutoCrystal2) {
        return testAutoCrystal2.Field549;
    }

    static void Method2161721(TestAutoCrystal2 testAutoCrystal2) {
        testAutoCrystal2.Method2161665();
    }

    private void Method2161650() {
        Field468 = this;
    }

    @Override
    public void Method2150373() {
    }

    @Override
    public void Method2150372() {
        this.Field522 = null;
        this.Field523 = null;
        this.Field525 = null;
        this.Field526 = null;
        this.Field524 = null;
        this.Field544 = null;
        this.Field548 = null;
        this.Field551.set(false);
        this.Field519 = null;
        this.Field521.Method2164750();
        this.Field536 = false;
        this.Field555 = false;
        this.Field539.clear();
    }

    @SubscribeEvent
    public void Method2161661(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            this.Field537.forEach((arg_0, arg_1) -> this.Method2161712(arg_0, arg_1));
            --this.Field554;
            if (this.Field548 != null) {
                for (Entity entity : TestAutoCrystal2.Field2811.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.Field548.x, this.Field548.y, this.Field548.z) <= 6.0))
                        continue;
                    this.Field538.put(entity.getEntityId(), System.currentTimeMillis());
                }
                this.Field548 = null;
            }
            if (updateWalkingPlayerEvent.isCanceled()) {
                return;
            }
            this.Field522 = null;
            this.Field523 = null;
            this.Field525 = null;
            this.Field526 = null;
            this.Field555 = false;
            this.Method2161663();
            if (this.Field470.getValue() != IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.OFF && !this.Field521.Method2164755(650L) && this.Field519 != null) {
                if (this.Field470.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.TRACK) {
                    this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
                }
                if (this.Field474.getValue().floatValue() < 1.0f && this.Field473.getValue() != IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.OFF && (this.Field522 != null || this.Field473.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FULL)) {
                    if (this.Field554 > 0) {
                        this.Field520[0] = ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw();
                        this.Field522 = null;
                        this.Field523 = null;
                    } else {
                        float f = MathHelper.wrapDegrees((float) (this.Field520[0] - ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()));
                        if (Math.abs(f) > 180.0f * this.Field474.getValue().floatValue()) {
                            this.Field520[0] = ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw() + f * (180.0f * this.Field474.getValue().floatValue() / Math.abs(f));
                            this.Field522 = null;
                            this.Field523 = null;
                            this.Field554 = this.Field475.getValue();
                        }
                    }
                }
                SilentRotaionUtil.Method2162907(this.Field520[0], this.Field520[1]);
            }
        }
    }

    @SubscribeEvent
    public void Method2161662(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        Field556 = this.Field488.getValue().floatValue() / 10.0f;
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1) {
            if (this.Field522 != null) {
                if (this.Method2161669(this.Field522)) {
                    this.Field528.Method2164750();
                    this.Field538.put(this.Field522.getEntityId(), System.currentTimeMillis());
                    for (Entity entity : TestAutoCrystal2.Field2811.world.loadedEntityList) {
                        if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.Field522.posX, this.Field522.posY, this.Field522.posZ) <= 6.0))
                            continue;
                        this.Field538.put(entity.getEntityId(), System.currentTimeMillis());
                    }
                    this.Field522 = null;
                    if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                        this.Method2161666();
                    }
                }
            } else if (this.Field523 != null) {
                if (!this.Method2161668(this.Field523, this.Field525)) {
                    this.Field550.set(false);
                    this.Field523 = null;
                    return;
                }
                this.Field527.Method2164750();
                this.Field523 = null;
            }
        }
    }

    private void Method2161663() {
        if (TestAutoCrystal2.Field2811.player.getHealth() + TestAutoCrystal2.Field2811.player.getAbsorptionAmount() < this.Field517.getValue().floatValue() || this.Field513.getValue() != false && TestAutoCrystal2.Field2811.player.getActiveItemStack().getItem() instanceof ItemFood || this.Field512.getValue().booleanValue() && TestAutoCrystal2.Field2811.playerController.getIsHittingBlock() && TestAutoCrystal2.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
            this.Field519 = null;
            return;
        }
        if (this.Field513.getValue().booleanValue() && this.Field514.getValue().booleanValue() && TestAutoCrystal2.Field2811.gameSettings.keyBindUseItem.isKeyDown() && TestAutoCrystal2.Field2811.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) {
            int n2 = -1;
            for (int j = 0; j < 9; ++j) {
                if (TestAutoCrystal2.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.GOLDEN_APPLE) {
                    continue;
                }
                n2 = j;
                break;
            }
            if (n2 != -1 && n2 != TestAutoCrystal2.Field2811.player.inventory.currentItem && this.Field530.Method2164755((long) (this.Field496.getValue().floatValue() * 50.0f))) {
                TestAutoCrystal2.Field2811.player.inventory.currentItem = n2;
                TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                this.Field530.Method2164750();
                this.Field529.Method2164750();
                return;
            }
        }
        if (!(this.Method2161686() || TestAutoCrystal2.Field2811.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal || this.Field495.getValue().booleanValue())) {
            return;
        }
        List<EntityPlayer> list = this.Method2161684();
        EntityEnderCrystal entityEnderCrystal = this.Method2161676(list);
        int n3 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
        if (entityEnderCrystal != null && this.Field528.Method2164755((long) (1000.0f - this.Field485.getValue().floatValue() * 50.0f)) && (entityEnderCrystal.ticksExisted >= this.Field483.getValue() || this.Field469.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.ADAPTIVE)) {
            this.Field522 = entityEnderCrystal;
            this.Method2161670(this.Field522.posX, this.Field522.posY, this.Field522.posZ);
        }
        if (entityEnderCrystal == null && (this.Field482.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FULL || this.Field546 == null || (double) this.Field546.ticksExisted >= Math.floor(this.Field483.getValue().intValue())) && (this.Field487.getValue() != IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT || this.Field528.Method2164755((long) (950.0f - this.Field485.getValue().floatValue() * 50.0f - (float) CrystalUtilSC.Method2162805()))) && this.Field527.Method2164755((long) (1000.0f - this.Field486.getValue().floatValue() * 50.0f)) && (this.Field469.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.SEQUENTIAL || this.Field542.Method2164755((long) ((float) this.Field483.getValue().intValue() * 5.0f)))) {
            BlockPos blockPos;
            if (this.Field482.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF && this.Field544 != null && !this.Field543.Method2164755(n3 + 100) && this.Method2161683(this.Field544)) {
                this.Field523 = this.Field544;
                this.Field525 = this.Method2161681(this.Field523);
                this.Field551.set(false);
                return;
            }
            List<BlockPos> list2 = this.Method2161682();
            if (!list2.isEmpty() && (blockPos = this.Method2161678(list2, list)) != null) {
                this.Field523 = blockPos;
                this.Field525 = this.Method2161681(this.Field523);
            }
        }
        this.Field551.set(false);
    }

    private double Method2161664(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        return Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
    }

    private void Method2161665() {
        BlockPos blockPos;
        List<BlockPos> list;
        if (this.Field482.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF && (this.Field482.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.FULL || this.Field546 == null || (double) this.Field546.ticksExisted >= Math.floor(this.Field483.getValue().intValue()))) {
            int n2 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
            if (this.Field544 != null && !this.Field543.Method2164755(n2 + 100) && this.Method2161683(this.Field544)) {
                this.Field523 = this.Field544;
                this.Field525 = this.Method2161681(this.Field523);
                if (this.Field523 != null) {
                    if (!this.Method2161668(this.Field523, this.Field525)) {
                        this.Field523 = null;
                        return;
                    }
                    this.Field527.Method2164750();
                    this.Field523 = null;
                }
                return;
            }
        }
        if (!(list = this.Method2161682()).isEmpty() && (blockPos = this.Method2161678(list, this.Method2161684())) != null) {
            this.Field523 = blockPos;
            this.Field525 = this.Method2161681(this.Field523);
            if (this.Field523 != null) {
                if (!this.Method2161668(this.Field523, this.Field525)) {
                    this.Field523 = null;
                    return;
                }
                this.Field527.Method2164750();
                this.Field523 = null;
            }
        }
    }

    private void Method2161666() {
        if (this.Field488.getValue().floatValue() == 0.0f) {
            this.Method2161665();
        } else {
            this.Field550.set(true);
            if (this.Field549 == null || this.Field549.isInterrupted() || !this.Field549.isAlive()) {
                if (this.Field549 == null) {
                    this.Field549 = new Thread(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161658(this));
                }
                if (this.Field549 != null && (this.Field549.isInterrupted() || !this.Field549.isAlive())) {
                    this.Field549 = new Thread(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Method2161658(this));
                }
                if (this.Field549 != null && this.Field549.getState() == Thread.State.NEW) {
                    try {
                        this.Field549.start();
                    } catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void Method2161667(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSpawnObject) {
            SPacketSpawnObject sPacketSpawnObject = (SPacketSpawnObject) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSpawnObject.getType() == 51) {
                this.Field537.forEach((arg_0, arg_1) -> this.Method2161711(sPacketSpawnObject, arg_0, arg_1));
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect) {
            SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSoundEffect.getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
                if (this.Field546 != null && this.Field546.getDistance(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ()) < 6.0) {
                    this.Field546 = null;
                }
                if (this.Field500.getValue().floatValue() >= 0.5f) {
                    try {
                        this.Field540.remove((Object) new BlockPos(sPacketSoundEffect.getX(), sPacketSoundEffect.getY() - 1.0, sPacketSoundEffect.getZ()));
                    } catch (ConcurrentModificationException concurrentModificationException) {
                    }
                }
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityStatus) {
            SPacketEntityStatus sPacketEntityStatus = (SPacketEntityStatus) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketEntityStatus.getOpCode() == 35 && sPacketEntityStatus.getEntity((World) TestAutoCrystal2.Field2811.world) instanceof EntityPlayer) {
                this.Field539.put((EntityPlayer) sPacketEntityStatus.getEntity((World) TestAutoCrystal2.Field2811.world), new Timer());
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketPlayerPosLook && this.Field518.getValue().booleanValue() && !AliceMain.Field756.Method2150180(PacketFlight.class).Method2150364()) {
            this.Method2150391();
        }
    }

    public boolean Method2161668(BlockPos blockPos, EnumFacing enumFacing) {
        if (blockPos != null) {
            if (this.Field495.getValue().booleanValue()) {
                if (this.Field530.Method2164755((long) (this.Field496.getValue().floatValue() * 50.0f))) {
                    if (!this.Method2161687()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (!this.Method2161686() && TestAutoCrystal2.Field2811.player.getHeldItemMainhand().getItem() != Items.END_CRYSTAL) {
                return false;
            }
            if (TestAutoCrystal2.Field2811.world.getBlockState(blockPos.up()).getBlock() == Blocks.FIRE) {
                TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                return true;
            }
            this.Field536 = true;
            if (this.Field526 == null) {
                BlockUtilSC.Method2162870(blockPos, TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0), this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
            } else {
                TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, (float) this.Field526.hitVec.x, (float) this.Field526.hitVec.y, (float) this.Field526.hitVec.z));
                TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            }
            if (this.Field555 && this.Field552 != null) {
                this.Field539.put(this.Field552, new Timer());
            }
            this.Field536 = false;
            this.Field537.put(blockPos, System.currentTimeMillis());
            if (this.Field500.getValue().floatValue() >= 0.5f) {
                this.Field540.add(blockPos);
            }
            this.Field533.Method2164750();
            this.Field524 = blockPos;
            return true;
        }
        return false;
    }

    private boolean Method2161669(EntityEnderCrystal entityEnderCrystal) {
        if (!this.Field529.Method2164755((long) (this.Field497.getValue().floatValue() * 100.0f))) {
            return false;
        }
        if (entityEnderCrystal != null) {
            if (this.Field498.getValue().booleanValue() && TestAutoCrystal2.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && !(TestAutoCrystal2.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
                this.Method2161685();
                return false;
            }
            TestAutoCrystal2.Field2811.playerController.attackEntity((EntityPlayer) TestAutoCrystal2.Field2811.player, (Entity) entityEnderCrystal);
            TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            this.Method2161660(this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                this.Field527.Method2164750();
            }
            if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT) {
                this.Field551.set(true);
            }
            this.Field545.Method2164750();
            this.Field546 = entityEnderCrystal;
            this.Field534 = new BlockPos((Entity) entityEnderCrystal).down();
            this.Field535.Method2164750();
            return true;
        }
        return false;
    }

    private void Method2161660(EnumHand enumHand) {
        ItemStack itemStack = TestAutoCrystal2.Field2811.player.getHeldItem(enumHand);
        if (!itemStack.isEmpty() && itemStack.getItem().onEntitySwing((EntityLivingBase) TestAutoCrystal2.Field2811.player, itemStack)) {
            return;
        }
        if (!TestAutoCrystal2.Field2811.player.isSwingInProgress || TestAutoCrystal2.Field2811.player.swingProgressInt >= this.Method2161671((EntityLivingBase) TestAutoCrystal2.Field2811.player) / 2 || TestAutoCrystal2.Field2811.player.swingProgressInt < 0) {
            TestAutoCrystal2.Field2811.player.swingProgressInt = -1;
            TestAutoCrystal2.Field2811.player.isSwingInProgress = true;
            TestAutoCrystal2.Field2811.player.swingingHand = enumHand;
        }
    }

    private int Method2161671(EntityLivingBase entityLivingBase) {
        if (entityLivingBase.isPotionActive(MobEffects.HASTE)) {
            return 6 - (1 + entityLivingBase.getActivePotionEffect(MobEffects.HASTE).getAmplifier());
        }
        return entityLivingBase.isPotionActive(MobEffects.MINING_FATIGUE) ? 6 + (1 + entityLivingBase.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2 : 6;
    }

    public EntityEnderCrystal Method2161672() {
        return this.Field522;
    }

    public BlockPos Method2161673() {
        return this.Field523;
    }

    private List<Entity> Method2161674() {
        return TestAutoCrystal2.Field2811.world.loadedEntityList.stream().filter(TestAutoCrystal2::Method2161600).filter(this::Method2161609).collect(Collectors.toList());
    }

    private boolean Method2161675(EntityEnderCrystal entityEnderCrystal) {
        if (TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f).distanceTo(entityEnderCrystal.getPositionVector()) > (double) this.Field491.getValue().floatValue()) {
            return false;
        }
        if (this.Field538.containsKey(entityEnderCrystal.getEntityId()) && this.Field472.getValue().booleanValue()) {
            return false;
        }
        if (this.Field538.containsKey(entityEnderCrystal.getEntityId()) && entityEnderCrystal.ticksExisted > this.Field483.getValue() + this.Field484.getValue()) {
            return false;
        }
        return !(CrystalUtilSC.Method2162915(entityEnderCrystal, (Entity) TestAutoCrystal2.Field2811.player) + this.Field504.getValue().floatValue() >= TestAutoCrystal2.Field2811.player.getHealth() + TestAutoCrystal2.Field2811.player.getAbsorptionAmount());
    }

    private EntityEnderCrystal Method2161676(List<EntityPlayer> list) {
        this.Field538.forEach((arg_0, arg_1) -> this.Method2161608(arg_0, arg_1));
        if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT && !this.Field472.getValue().booleanValue() && this.Field551.get()) {
            return null;
        }
        EntityEnderCrystal entityEnderCrystal = null;
        int n2 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
        if (this.Field471.getValue().booleanValue() && !this.Field472.getValue().booleanValue() && !this.Field545.Method2164755(n2) && this.Field546 != null && TestAutoCrystal2.Field2811.world.getEntityByID(this.Field546.getEntityId()) != null && this.Method2161675(this.Field546)) {
            entityEnderCrystal = this.Field546;
            return entityEnderCrystal;
        }
        List<Entity> list2 = this.Method2161674();
        if (list2.isEmpty()) {
            return null;
        }
        if (this.Field500.getValue().floatValue() >= 1.0f) {
            double d = 0.5;
            for (Entity entity : list2) {
                if (!(entity.getPositionVector().distanceTo(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field492.getValue().floatValue()) && !CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ))
                    continue;
                EntityEnderCrystal entityEnderCrystal2 = (EntityEnderCrystal) entity;
                double d2 = 0.0;
                for (EntityPlayer entityPlayer : list) {
                    double d3 = CrystalUtilSC.Method2162915(entityEnderCrystal2, (Entity) entityPlayer);
                    d2 += d3;
                }
                double d4 = CrystalUtilSC.Method2162915(entityEnderCrystal2, (Entity) TestAutoCrystal2.Field2811.player);
                if (d4 > d2 * (double) (this.Field500.getValue().floatValue() - 0.8f) && !this.Field540.contains((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ)) || !(d2 > d))
                    continue;
                d = d2;
                entityEnderCrystal = entityEnderCrystal2;
            }
        } else {
            entityEnderCrystal = this.Field500.getValue().floatValue() >= 0.5f ? (EntityEnderCrystal) list2.stream().filter(this::Method2161607).filter(this::Method2161606).min(Comparator.comparing(TestAutoCrystal2::Method2161605)).orElse(null) : (EntityEnderCrystal) list2.stream().filter(this::Method2161604).min(Comparator.comparing(TestAutoCrystal2::Method2161603)).orElse(null);
        }
        return entityEnderCrystal;
    }

    private boolean Method2161677(EntityPlayer entityPlayer) {
        if (!this.Field507.getValue().booleanValue()) {
            return false;
        }
        for (int j = 3; j >= 0; --j) {
            double d;
            ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(j);
            if (itemStack == null || !((d = itemStack.getItem().getDurabilityForDisplay(itemStack)) > (double) this.Field508.getValue().floatValue()))
                continue;
            return true;
        }
        return false;
    }

    private BlockPos Method2161678(List<BlockPos> list, List<EntityPlayer> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        float f = 0.5f;
        EntityPlayer entityPlayer = null;
        BlockPos blockPos = null;
        this.Field555 = false;
        EntityPlayer entityPlayer2 = null;
        for (BlockPos blockPos2 : list) {
            float f2 = CrystalUtilSC.Method2162913(blockPos2, (Entity) TestAutoCrystal2.Field2811.player);
            if (!((double) f2 + (double) this.Field504.getValue().floatValue() < (double) (TestAutoCrystal2.Field2811.player.getHealth() + TestAutoCrystal2.Field2811.player.getAbsorptionAmount())) || !(f2 <= this.Field503.getValue().floatValue()))
                continue;
            if (this.Field499.getValue() != IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.ALL) {
                entityPlayer2 = list2.get(0);
                if (entityPlayer2.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5) > (double) this.Field490.getValue().floatValue())
                    continue;
                float f3 = CrystalUtilSC.Method2162913(blockPos2, (Entity) entityPlayer2);
                if (this.Method2161679(entityPlayer2, f3) && (blockPos == null || entityPlayer2.getDistanceSq(blockPos2) < entityPlayer2.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer2;
                    f = f3;
                    blockPos = blockPos2;
                    this.Field555 = true;
                    continue;
                }
                if (this.Field555 || !(f3 > f) || !(f3 * this.Field501.getValue().floatValue() > f2) && !(f3 > entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount()) || f3 < this.Field502.getValue().floatValue() && entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount() > this.Field505.getValue().floatValue() && !this.Field506.getValue().isDown() && !this.Method2161677(entityPlayer2))
                    continue;
                f = f3;
                entityPlayer = entityPlayer2;
                blockPos = blockPos2;
                continue;
            }
            for (EntityPlayer entityPlayer3 : list2) {
                if (entityPlayer3.equals((Object) entityPlayer2) || entityPlayer3.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5) > (double) this.Field490.getValue().floatValue())
                    continue;
                float f4 = CrystalUtilSC.Method2162913(blockPos2, (Entity) entityPlayer3);
                if (this.Method2161679(entityPlayer3, f4) && (blockPos == null || entityPlayer3.getDistanceSq(blockPos2) < entityPlayer3.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer3;
                    f = f4;
                    blockPos = blockPos2;
                    this.Field555 = true;
                    continue;
                }
                if (this.Field555 || !(f4 > f) || !(f4 * this.Field501.getValue().floatValue() > f2) && !(f4 > entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount()) || f4 < this.Field502.getValue().floatValue() && entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount() > this.Field505.getValue().floatValue() && !this.Field506.getValue().isDown() && !this.Method2161677(entityPlayer3))
                    continue;
                f = f4;
                entityPlayer = entityPlayer3;
                blockPos = blockPos2;
            }
        }
        if (entityPlayer != null && blockPos != null) {
            this.Field552 = entityPlayer;
            this.Field553.Method2164750();
        }
        if (blockPos != null) {
            this.Field531 = blockPos;
            this.Field532 = f;
        }
        this.Field544 = blockPos;
        this.Field543.Method2164750();
        return blockPos;
    }

    private boolean Method2161679(EntityPlayer entityPlayer, float f) {
        if (this.Field510.getValue().booleanValue() && entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() <= 2.0f && (double) f > (double) entityPlayer.getHealth() + (double) entityPlayer.getAbsorptionAmount() + 0.5 && f <= 4.0f) {
            Timer timer = this.Field539.get((Object) entityPlayer);
            return timer == null || timer.Method2164755(500L);
        }
        return false;
    }

    public void Method2161670(double d, double d2, double d3) {
        if (this.Field470.getValue() != IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.OFF) {
            if (this.Field470.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.INTERACT && this.Field519 != null && !this.Field521.Method2164755(650L)) {
                if (this.Field519.y < d2 - 0.1) {
                    this.Field519 = new Vec3d(this.Field519.x, d2, this.Field519.z);
                }
                this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
                this.Field521.Method2164750();
                return;
            }
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d - 1.0, d2, d3 - 1.0, d + 1.0, d2 + 2.0, d3 + 1.0);
            Vec3d vec3d = new Vec3d(TestAutoCrystal2.Field2811.player.posX, TestAutoCrystal2.Field2811.player.getEntityBoundingBox().minY + (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), TestAutoCrystal2.Field2811.player.posZ);
            double d4 = 0.1;
            double d5 = 0.15;
            double d6 = 0.85;
            if (axisAlignedBB.intersects(TestAutoCrystal2.Field2811.player.getEntityBoundingBox())) {
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
                        if (this.Field478.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA && !CrystalUtilSC.Method2162890(vec3d3)) {
                            bl2 = false;
                        }
                        if (this.Field476.getValue().booleanValue()) {
                            if (vec3d2 != null && arrd != null) {
                                if (!bl2 && bl || !(TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d3) < TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d2)))
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
                            if (!bl2 && bl || !(Math.hypot(((arrd2[0] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd2[1] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedPitch())))
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
                this.Field521.Method2164750();
                this.Field519 = vec3d2;
                this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
            }
        }
    }

    public EnumFacing Method2161681(BlockPos blockPos) {
        if (blockPos == null || TestAutoCrystal2.Field2811.player == null) {
            return null;
        }
        EnumFacing enumFacing = null;
        if (this.Field478.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA) {
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
            Vec3d vec3d6 = new Vec3d(TestAutoCrystal2.Field2811.player.posX, TestAutoCrystal2.Field2811.player.getEntityBoundingBox().minY + (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), TestAutoCrystal2.Field2811.player.posZ);
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
                        rayTraceResult = TestAutoCrystal2.Field2811.world.rayTraceBlocks(vec3d6, vec3d2, false, true, false);
                        if (!(this.Field494.getValue().floatValue() >= this.Field493.getValue().floatValue() || rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && rayTraceResult.getBlockPos().equals((Object) blockPos)))
                            continue;
                        vec3d = vec3d4;
                        arrd = arrd2;
                        if (this.Field476.getValue().booleanValue()) {
                            if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d5)))
                                    continue;
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field526 = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field526 = rayTraceResult;
                            continue;
                        }
                        if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                            if (!(Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd3[0] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd3[1] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedPitch())))
                                continue;
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field526 = rayTraceResult;
                            continue;
                        }
                        vec3d5 = vec3d;
                        arrd3 = arrd;
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                        enumFacing = rayTraceResult.sideHit;
                        this.Field526 = rayTraceResult;
                    }
                }
            }
            if (this.Field494.getValue().floatValue() < this.Field493.getValue().floatValue() && this.Field478.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.STRICT) {
                if (arrd3 != null && enumFacing != null) {
                    this.Field521.Method2164750();
                    this.Field519 = vec3d5;
                    this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
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
                            rayTraceResult = TestAutoCrystal2.Field2811.world.rayTraceBlocks(vec3d6, vec3d2, false, true, true);
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            vec3d = vec3d4;
                            arrd = arrd2;
                            if (this.Field476.getValue().booleanValue()) {
                                if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                    if (!(TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d5)))
                                        continue;
                                    vec3d5 = vec3d;
                                    arrd3 = arrd;
                                    if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                        continue;
                                    enumFacing = rayTraceResult.sideHit;
                                    this.Field526 = rayTraceResult;
                                    continue;
                                }
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field526 = rayTraceResult;
                                continue;
                            }
                            if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd3[0] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd3[1] - (double) ((IEntityPlayerSP) TestAutoCrystal2.Field2811.player).getLastReportedPitch())))
                                    continue;
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field526 = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field526 = rayTraceResult;
                        }
                    }
                }
            } else {
                if (arrd3 != null) {
                    this.Field521.Method2164750();
                    this.Field519 = vec3d5;
                    this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
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
                RayTraceResult rayTraceResult = TestAutoCrystal2.Field2811.world.rayTraceBlocks(new Vec3d(TestAutoCrystal2.Field2811.player.posX, TestAutoCrystal2.Field2811.player.posY + (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), TestAutoCrystal2.Field2811.player.posZ), vec3d, false, true, false);
                if (rayTraceResult == null || !rayTraceResult.typeOfHit.equals((Object) RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                    continue;
                if (this.Field476.getValue().booleanValue()) {
                    if (vec3d7 != null && !(TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d7)))
                        continue;
                    vec3d7 = vec3d;
                    enumFacing2 = enumFacing3;
                    this.Field526 = rayTraceResult;
                    continue;
                }
                this.Field521.Method2164750();
                this.Field519 = vec3d;
                this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
                return enumFacing3;
            }
            if (enumFacing2 != null) {
                this.Field521.Method2164750();
                this.Field519 = vec3d7;
                this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
                return enumFacing2;
            }
            if (this.Field476.getValue().booleanValue()) {
                for (EnumFacing enumFacing3 : EnumFacing.values()) {
                    vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing3.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing3.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing3.getDirectionVec().getZ() * 0.5);
                    if (vec3d7 != null && !(TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d7)))
                        continue;
                    vec3d7 = vec3d;
                    enumFacing2 = enumFacing3;
                }
                if (enumFacing2 != null) {
                    this.Field521.Method2164750();
                    this.Field519 = vec3d7;
                    this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
                    return enumFacing2;
                }
            }
        }
        if ((double) blockPos.getY() > TestAutoCrystal2.Field2811.player.posY + (double) TestAutoCrystal2.Field2811.player.getEyeHeight()) {
            this.Field521.Method2164750();
            this.Field519 = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
            this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
            return EnumFacing.DOWN;
        }
        this.Field521.Method2164750();
        this.Field519 = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
        this.Field520 = RotationManager.Method2150291(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f), this.Field519);
        return EnumFacing.UP;
    }

    private List<BlockPos> Method2161682() {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) TestAutoCrystal2.Method2161688(new BlockPos((Entity) TestAutoCrystal2.Field2811.player), this.Field476.getValue() != false ? this.Field493.getValue().floatValue() + 2.0f : this.Field493.getValue().floatValue(), this.Field493.getValue().intValue(), false, true, 0).stream().filter(this::Method2161683).collect(Collectors.toList()));
        return nonNullList;
    }

    public boolean Method2161683(BlockPos blockPos) {
        if (TestAutoCrystal2.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && TestAutoCrystal2.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (!(TestAutoCrystal2.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || TestAutoCrystal2.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.FIRE && this.Field481.getValue().booleanValue() || TestAutoCrystal2.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid && this.Field480.getValue().booleanValue())) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (!(this.Field479.getValue().booleanValue() || TestAutoCrystal2.Field2811.world.getBlockState(blockPos3).getBlock() == Blocks.AIR || TestAutoCrystal2.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid && this.Field480.getValue().booleanValue())) {
            return false;
        }
        if (this.Field477.getValue().booleanValue() && !CrystalUtilSC.Method2162899((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5)) {
            Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
            if (TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double) this.Field492.getValue().floatValue()) {
                return false;
            }
        }
        if (this.Field494.getValue().floatValue() < this.Field493.getValue().floatValue()) {
            if (!CrystalUtilSC.Method2162916(blockPos)) {
                if (this.Field476.getValue().booleanValue()) {
                    boolean bl;
                    block30:
                    {
                        Vec3d vec3d = TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0);
                        bl = false;
                        if (this.Field478.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA) {
                            for (EnumFacing enumFacing : EnumFacing.values()) {
                                Vec3d vec3d2 = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                                if (!(vec3d.distanceTo(vec3d2) <= (double) this.Field494.getValue().floatValue())) {
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
                                        if (!(d7 <= (double) this.Field494.getValue().floatValue())) {
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
                } else if ((double) blockPos.getY() > TestAutoCrystal2.Field2811.player.posY + (double) TestAutoCrystal2.Field2811.player.getEyeHeight() ? TestAutoCrystal2.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5) > (double) this.Field494.getValue().floatValue() : TestAutoCrystal2.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) (blockPos.getY() + 1), (double) blockPos.getZ() + 0.5) > (double) this.Field494.getValue().floatValue()) {
                    return false;
                }
            }
        } else if (this.Field476.getValue().booleanValue()) {
            boolean bl;
            block31:
            {
                Vec3d vec3d = TestAutoCrystal2.Field2811.player.getPositionVector().add(0.0, (double) TestAutoCrystal2.Field2811.player.getEyeHeight(), 0.0);
                bl = false;
                if (this.Field478.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.VANILLA) {
                    for (EnumFacing enumFacing : EnumFacing.values()) {
                        Vec3d vec3d4 = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                        if (!(vec3d.distanceTo(vec3d4) <= (double) this.Field493.getValue().floatValue())) {
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
                                if (!(d13 <= (double) this.Field493.getValue().floatValue())) {
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
        return TestAutoCrystal2.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).stream().filter(this::Method2161602).count() == 0L;
    }

    private List<EntityPlayer> Method2161684() {
        List<Object> list = TestAutoCrystal2.Field2811.world.playerEntities.stream().filter(TestAutoCrystal2::Method2161601).filter(TestAutoCrystal2::Method2161690).filter(TestAutoCrystal2::Method2161699).filter(TestAutoCrystal2::Method2161698).filter(this::Method2161697).sorted(Comparator.comparing(TestAutoCrystal2::Method2161696)).collect(Collectors.toList());
        if (this.Field499.getValue() == IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.SMART) {
            List list2 = list.stream().filter(TestAutoCrystal2::Method2161695).sorted(Comparator.comparing(TestAutoCrystal2::Method2161694)).collect(Collectors.toList());
            if (list2.size() > 0) {
                list = list2;
            }
            if ((list2 = list.stream().filter(TestAutoCrystal2::Method2161693).sorted(Comparator.comparing(TestAutoCrystal2::Method2161692)).collect(Collectors.toList())).size() > 0) {
                list = list2;
            }
        }
        return list;
    }

    public void Method2161685() {
        int n2 = CrystalUtilSC.Method2162807();
        if (TestAutoCrystal2.Field2811.player.inventory.currentItem != n2 && n2 != -1) {
            TestAutoCrystal2.Field2811.player.inventory.currentItem = n2;
            TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            this.Field530.Method2164750();
            this.Field529.Method2164750();
        }
    }

    public boolean Method2161686() {
        return TestAutoCrystal2.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public boolean Method2161687() {
        if (this.Method2161686()) {
            return true;
        }
        int n2 = CrystalUtilSC.Method2162806();
        if (n2 == -1) {
            return false;
        }
        if (TestAutoCrystal2.Field2811.player.inventory.currentItem != n2) {
            TestAutoCrystal2.Field2811.player.inventory.currentItem = n2;
            TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
            this.Field530.Method2164750();
            this.Field529.Method2164750();
        }
        return true;
    }

    public boolean Method2161691(EntityPlayer entityPlayer) {
        return (double) entityPlayer.moveForward != 0.0 || (double) entityPlayer.moveStrafing != 0.0;
    }

    private boolean Method2161697(EntityPlayer entityPlayer) {
        return TestAutoCrystal2.Field2811.player.getDistance((Entity) entityPlayer) < this.Field489.getValue().floatValue();
    }

    private boolean Method2161602(Entity entity) {
        return !this.Field538.containsKey(entity.getEntityId()) && (!(entity instanceof EntityEnderCrystal) || entity.ticksExisted > 20);
    }

    private boolean Method2161604(Entity entity) {
        return entity.getPositionVector().distanceTo(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field492.getValue().floatValue() || CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ);
    }

    private boolean Method2161606(Entity entity) {
        return entity.getPositionVector().distanceTo(TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field492.getValue().floatValue() || CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ);
    }

    private boolean Method2161607(Entity entity) {
        return this.Field540.contains((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ));
    }

    private void Method2161608(Integer n2, Long l2) {
        if (System.currentTimeMillis() - l2 > 1000L) {
            this.Field538.remove(n2);
        }
    }

    private boolean Method2161609(Entity entity) {
        return this.Method2161675((EntityEnderCrystal) entity);
    }

    private void Method2161711(SPacketSpawnObject sPacketSpawnObject, BlockPos blockPos, Long l2) {
        if (this.Method2161664((double) blockPos.getX() + 0.5, blockPos.getY(), (double) blockPos.getZ() + 0.5, sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ()) < 1.0) {
            try {
                this.Field537.remove((Object) blockPos);
                this.Field544 = null;
                if (!this.Field472.getValue().booleanValue() && this.Field471.getValue().booleanValue()) {
                    this.Field547.Method2164750();
                }
            } catch (ConcurrentModificationException concurrentModificationException) {
                // empty catch block
            }
            if (this.Field469.getValue() != IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.ADAPTIVE) {
                return;
            }
            if (!this.Field529.Method2164755((long) (this.Field497.getValue().floatValue() * 100.0f))) {
                return;
            }
            if (this.Field541.get()) {
                return;
            }
            if (TestAutoCrystal2.Field2811.player.isPotionActive(MobEffects.WEAKNESS)) {
                return;
            }
            if (this.Field538.containsKey(sPacketSpawnObject.getEntityID())) {
                return;
            }
            if (TestAutoCrystal2.Field2811.player.getHealth() + TestAutoCrystal2.Field2811.player.getAbsorptionAmount() < this.Field517.getValue().floatValue() || this.Field513.getValue() != false && TestAutoCrystal2.Field2811.player.getActiveItemStack().getItem() instanceof ItemFood || this.Field512.getValue().booleanValue() && TestAutoCrystal2.Field2811.playerController.getIsHittingBlock() && TestAutoCrystal2.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
                this.Field519 = null;
                return;
            }
            Vec3d vec3d = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            if (TestAutoCrystal2.Field2811.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double) this.Field491.getValue().floatValue()) {
                return;
            }
            if (!this.Field528.Method2164755((long) (1000.0f - this.Field485.getValue().floatValue() * 50.0f))) {
                return;
            }
            if (CrystalUtilSC.Method2162914(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ(), (Entity) TestAutoCrystal2.Field2811.player) + this.Field504.getValue().floatValue() >= TestAutoCrystal2.Field2811.player.getHealth() + TestAutoCrystal2.Field2811.player.getAbsorptionAmount()) {
                return;
            }
            this.Field538.put(sPacketSpawnObject.getEntityID(), System.currentTimeMillis());
            this.Field548 = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
            ((ICPacketUseEntity) cPacketUseEntity).setEntityId(sPacketSpawnObject.getEntityID());
            ((ICPacketUseEntity) cPacketUseEntity).setAction(CPacketUseEntity.Action.ATTACK);
            TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            TestAutoCrystal2.Field2811.player.connection.sendPacket((Packet) cPacketUseEntity);
            this.Method2161660(this.Method2161686() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            this.Field534 = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ());
            this.Field535.Method2164750();
            this.Field528.Method2164750();
            this.Field542.Method2164750();
            if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                this.Field527.Method2164750();
            }
            if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT) {
                this.Field551.set(true);
            }
            if (this.Field487.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.MERGE) {
                this.Method2161666();
            }
        }
    }

    private void Method2161712(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > 1500L) {
            this.Field537.remove((Object) blockPos);
        }
    }

    private boolean Method2161713(Boolean bl) {
        return this.Field513.getValue();
    }

    private boolean Method2161714(Boolean bl) {
        return this.Field507.getValue();
    }

    private boolean Method2161715(Boolean bl) {
        return this.Field507.getValue();
    }

    private boolean Method2161716(Integer n2) {
        return this.Field507.getValue();
    }

    private boolean Method2161717(Float f) {
        return this.Field507.getValue();
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
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
        private static IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll Field2884;
        private TestAutoCrystal2 Field2885;

        private IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() {
        }

        static IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll Method2161658(TestAutoCrystal2 testAutoCrystal2) {
            if (Field2884 == null) {
                Field2884 = new IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll();
                IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Field2884.Field2885 = testAutoCrystal2;
            }
            return Field2884;
        }

        @Override
        public void run() {
            if (TestAutoCrystal2.Method2161718(this.Field2885).get()) {
                try {
                    Thread.sleep((long) (TestAutoCrystal2.Method2161719() * 40.0f));
                } catch (InterruptedException interruptedException) {
                    TestAutoCrystal2.Method2161710(this.Field2885).interrupt();
                }
                if (!TestAutoCrystal2.Method2161718(this.Field2885).get()) {
                    return;
                }
                TestAutoCrystal2.Method2161718(this.Field2885).set(false);
                if (this.Field2885.Field541.get()) {
                    return;
                }
                TestAutoCrystal2.Method2161721(this.Field2885);
            }
        }
    }
}

