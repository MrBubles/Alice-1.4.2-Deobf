

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  io.netty.util.internal.ConcurrentSet
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.authlib.GameProfile;
import io.netty.util.internal.ConcurrentSet;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ACAutoSwitch;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ACRenderMode;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ACRotate;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ACSettings;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ACSwing;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ACYaw;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.DamageUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtilCC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.LuigiGuiOld;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.NoSoundLag;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Speedmine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class AutoCrystal
        extends Module {
    public static EntityPlayer Field47;
    public static Set<BlockPos> Field48;
    public static Set<BlockPos> Field49;
    public static Set<BlockPos> Field50;
    private static AutoCrystal Field51;

    static {
        Field48 = new ConcurrentSet();
        Field49 = new HashSet<BlockPos>();
        Field50 = new HashSet<BlockPos>();
        Field48 = new ConcurrentSet();
        Field49 = new HashSet<BlockPos>();
        Field50 = new HashSet<BlockPos>();
    }

    public final Timer Field65 = new Timer();
    private final Timer Field52 = new Timer();
    private final Timer Field53 = new Timer();
    private final Timer Field54 = new Timer();
    private final Timer Field55 = new Timer();
    private final Timer Field56 = new Timer();
    private final Timer Field57 = new Timer();
    private final Timer Field58 = new Timer();
    private final AtomicBoolean Field59 = new AtomicBoolean(false);
    private final Timer Field60 = new Timer();
    private final Map<EntityPlayer, Timer> Field61 = new ConcurrentHashMap<EntityPlayer, Timer>();
    private final Queue<CPacketUseEntity> Field62 = new LinkedList<CPacketUseEntity>();
    private final AtomicBoolean Field63 = new AtomicBoolean(false);
    private final List<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll> Field64 = new ArrayList<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll>();
    private final Setting<ACSettings> Field66 = this.Method2150366(new Setting<ACSettings>("Page", ACSettings.Place));
    public final Setting<Boolean> Field164 = this.Method2150366(new Setting<Object>("OppositeHand", Boolean.FALSE, this::Method2150901));
    public final Setting<Boolean> Field165 = this.Method2150366(new Setting<Object>("FastMode", Boolean.FALSE, this::Method2150990));
    public final Setting<Boolean> Field166 = this.Method2150366(new Setting<Object>("AntiFeetPlace", Boolean.FALSE, this::Method2150999));
    public final Setting<Boolean> Field170 = this.Method2150366(new Setting<Object>("PacketSwing", Boolean.TRUE, this::Method2150995));
    private final Setting<Integer> Field140 = this.Method2150366(new Setting<Object>("SwapDelay", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150025));
    private final Setting<Integer> Field163 = this.Method2150366(new Setting<Object>("EventUpdates", Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(3), this::Method2150902));
    public Setting<Integer> Field67 = this.Method2150366(new Setting<Object>("PlaceDelay", Integer.valueOf(18), Integer.valueOf(0), Integer.valueOf(500), this::Method2150098));
    public Setting<Float> Field68 = this.Method2150366(new Setting<Object>("PlaceRange", Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150097));
    public Setting<Float> Field70 = this.Method2150366(new Setting<Object>("MinDamage", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(20.0f), this::Method2150095));
    public Setting<Float> Field71 = this.Method2150366(new Setting<Object>("MaxSelfPlace", Float.valueOf(8.0f), Float.valueOf(0.1f), Float.valueOf(36.0f), this::Method2150094));
    public Setting<Integer> Field72 = this.Method2150366(new Setting<Object>("WasteAmount", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(5), this::Method2150093));
    public Setting<Boolean> Field73 = this.Method2150366(new Setting<Object>("CountMinDmg", Boolean.TRUE, this::Method2150092));
    public Setting<Float> Field74 = this.Method2150366(new Setting<Object>("Face Place Health", Float.valueOf(36.0f), Float.valueOf(0.1f), Float.valueOf(36.0f), this::Method2150091));
    public Setting<Boolean> Field75 = this.Method2150366(new Setting<Object>("AntiSurround", Boolean.TRUE, this::Method2150080));
    public Setting<Boolean> Field76 = this.Method2150366(new Setting<Object>("LimitFacePlace", Boolean.FALSE, this::Method2150089));
    public Setting<Boolean> Field77 = this.Method2150366(new Setting<Object>("1.13 Place", Boolean.FALSE, this::Method2150088));
    public Setting<Boolean> Field78 = this.Method2150366(new Setting<Object>("AntiTotem", Boolean.FALSE, this::Method2150087));
    public Setting<Double> Field79 = this.Method2150366(new Setting<Object>("PopHealth", Double.valueOf(1.0), Double.valueOf(0.0), Double.valueOf(3.0), this::Method2150086));
    public Setting<Float> Field80 = this.Method2150366(new Setting<Object>("PopDamage", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this::Method2150085));
    public Setting<Integer> Field81 = this.Method2150366(new Setting<Object>("PopTime", Integer.valueOf(500), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150084));
    public Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl> Field83 = this.Method2150366(new Setting<Object>("Attack", (Object) IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.BREAKSLOT, this::Method2150082));
    public Setting<Integer> Field84 = this.Method2150366(new Setting<Object>("BreakDelay", Integer.valueOf(18), Integer.valueOf(0), Integer.valueOf(500), this::Method2150081));
    public Setting<Float> Field85 = this.Method2150366(new Setting<Object>("BreakRange", Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150070));
    public Setting<Integer> Field87 = this.Method2150366(new Setting<Object>("Packets", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), this::Method2150078));
    public Setting<Float> Field88 = this.Method2150366(new Setting<Object>("MaxSelfBreakDmg", Float.valueOf(8.0f), Float.valueOf(0.1f), Float.valueOf(36.0f), this::Method2150077));
    public Setting<Boolean> Field89 = this.Method2150366(new Setting<Object>("ManualBreaker", Boolean.FALSE, this::Method2150076));
    public Setting<Boolean> Field90 = this.Method2150366(new Setting<Object>("ManualMinDmg", Boolean.TRUE, this::Method2150075));
    public Setting<Integer> Field91 = this.Method2150366(new Setting<Object>("ManualDelay", Integer.valueOf(500), Integer.valueOf(0), Integer.valueOf(500), this::Method2150074));
    public Setting<Boolean> Field92 = this.Method2150366(new Setting<Object>("Sync", Boolean.FALSE, this::Method2150073));
    public Setting<Boolean> Field93 = this.Method2150366(new Setting<Object>("Predict", Boolean.TRUE, this::Method2150072));
    public Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll> Field94 = this.Method2150366(new Setting<Object>("PredictTimer", (Object) IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.NONE, this::Method2150071));
    public Setting<Integer> Field96 = this.Method2150366(new Setting<Object>("PredictDelay", Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(500), this::Method2150069));
    public Setting<Boolean> Field95 = this.Method2150366(new Setting<Object>("ResetBreakTimer", Boolean.TRUE, this::Method2150060));
    public Setting<Boolean> Field97 = this.Method2150366(new Setting<Object>("PredictCalc", Boolean.FALSE, this::Method2150068));
    public Setting<Boolean> Field102 = this.Method2150366(new Setting<Object>("SuperSafe", Boolean.FALSE, this::Method2150063));
    public Setting<Boolean> Field103 = this.Method2150366(new Setting<Object>("AntiOverCommit", Boolean.FALSE, this::Method2150062));
    public Setting<Boolean> Field98 = this.Method2150366(new Setting<Object>("PredictPos", Boolean.FALSE, this::Method2150067));
    public Setting<Integer> Field99 = this.Method2150366(new Setting<Object>("ExtrapolationTicks", Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(20), this::Method2150066));
    public Setting<Boolean> Field100 = this.Method2150366(new Setting<Object>("PredictRotate", Boolean.FALSE, this::Method2150065));
    public Setting<Float> Field101 = this.Method2150366(new Setting<Object>("PredictOffset", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(4.0f), this::Method2150064));
    public Setting<Boolean> Field104 = this.Method2150366(new Setting<Object>("AntiWeakness", Boolean.FALSE, this::Method2150061));
    public Setting<ACRenderMode> Field105 = this.Method2150366(new Setting<ACRenderMode>("RenderMode", ACRenderMode.STATIC, this::Method2150050));
    public Setting<Float> Field106 = this.Method2150366(new Setting<Object>("Brightness ", Float.valueOf(150.0f), Float.valueOf(1.0f), Float.valueOf(255.0f), this::Method2150059));
    public Setting<Float> Field107 = this.Method2150366(new Setting<Object>("Saturation", Float.valueOf(150.0f), Float.valueOf(1.0f), Float.valueOf(255.0f), this::Method2150058));
    private final Setting<Boolean> Field108 = this.Method2150366(new Setting<Boolean>("Fade", Boolean.valueOf(true), this::Method2150057));
    private final Setting<Boolean> Field109 = this.Method2150366(new Setting<Boolean>("Shrink", Boolean.valueOf(false), this::Method2150056));
    private final Setting<Boolean> Field110 = this.Method2150366(new Setting<Boolean>("Slab", Boolean.valueOf(false), this::Method2150055));
    private final Setting<Boolean> Field111 = this.Method2150366(new Setting<Boolean>("OnlyPlaced", Boolean.valueOf(false), this::Method2150054));
    private final Setting<Float> Field112 = this.Method2150366(new Setting<Float>("Duration", Float.valueOf(1500.0f), Float.valueOf(0.0f), Float.valueOf(5000.0f), this::Method2150053));
    private final Setting<Integer> Field113 = this.Method2150366(new Setting<Integer>("MaxPositions", Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(30), this::Method2150052));
    private final Setting<Float> Field114 = this.Method2150366(new Setting<Float>("SlabDepth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2150051));
    private final Setting<Float> Field115 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(900.0f), Float.valueOf(0.0f), Float.valueOf(1500.0f), this::Method2150040));
    private final Setting<Float> Field116 = this.Method2150366(new Setting<Float>("Deceleration", Float.valueOf(0.8f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2150049));
    public Setting<Boolean> Field117 = this.Method2150366(new Setting<Object>("ColorSync", Boolean.valueOf(true), this::Method2150048));
    public Setting<Boolean> Field118 = this.Method2150366(new Setting<Object>("Box", Boolean.valueOf(true), this::Method2150047));
    private final Setting<Integer> Field119 = this.Method2150366(new Setting<Object>("BoxRed", Integer.valueOf(64), Integer.valueOf(0), Integer.valueOf(255), this::Method2150046));
    private final Setting<Integer> Field120 = this.Method2150366(new Setting<Object>("BoxGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150045));
    private final Setting<Integer> Field121 = this.Method2150366(new Setting<Object>("BoxBlue", Integer.valueOf(145), Integer.valueOf(0), Integer.valueOf(255), this::Method2150044));
    private final Setting<Integer> Field122 = this.Method2150366(new Setting<Object>("BoxAlpha", Integer.valueOf(105), Integer.valueOf(0), Integer.valueOf(255), this::Method2150043));
    public Setting<Boolean> Field123 = this.Method2150366(new Setting<Object>("Outline", Boolean.valueOf(true), this::Method2150042));
    private final Setting<Integer> Field124 = this.Method2150366(new Setting<Object>("OutlineRed", Integer.valueOf(58), Integer.valueOf(0), Integer.valueOf(255), this::Method2150041));
    private final Setting<Integer> Field125 = this.Method2150366(new Setting<Object>("OutlineGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150030));
    private final Setting<Integer> Field126 = this.Method2150366(new Setting<Object>("OutlineBlue", Integer.valueOf(145), Integer.valueOf(0), Integer.valueOf(255), this::Method2150039));
    private final Setting<Integer> Field127 = this.Method2150366(new Setting<Object>("OutlineAlpha", Integer.valueOf(111), Integer.valueOf(0), Integer.valueOf(255), this::Method2150038));
    private final Setting<Float> Field128 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.8f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2150037));
    public Setting<Boolean> Field129 = this.Method2150366(new Setting<Object>("RenderDmg", Boolean.valueOf(false), this::Method2150036));
    public Setting<Boolean> Field130 = this.Method2150366(new Setting<Object>("HoldFacePlace", Boolean.FALSE, this::Method2150035));
    public Setting<Boolean> Field131 = this.Method2150366(new Setting<Object>("HoldSlowBreak", Boolean.FALSE, this::Method2150034));
    public Setting<Boolean> Field132 = this.Method2150366(new Setting<Object>("SlowFaceBreak", Boolean.FALSE, this::Method2150033));
    public Setting<Boolean> Field133 = this.Method2150366(new Setting<Object>("ActuallySlow", Boolean.FALSE, this::Method2150032));
    public Setting<Integer> Field134 = this.Method2150366(new Setting<Object>("FaceSpeed", Integer.valueOf(500), Integer.valueOf(0), Integer.valueOf(500), this::Method2150031));
    public Setting<Boolean> Field135 = this.Method2150366(new Setting<Object>("AntiNaked", Boolean.FALSE, this::Method2150020));
    public Setting<Float> Field136 = this.Method2150366(new Setting<Object>("TargetRange", Float.valueOf(8.0f), Float.valueOf(0.1f), Float.valueOf(20.0f), this::Method2150029));
    public Setting<IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll> Field137 = this.Method2150366(new Setting<Object>("Target", (Object) IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.DAMAGE, this::Method2150028));
    public Setting<Boolean> Field82 = this.Method2150366(new Setting<Object>("DamagePop", Boolean.FALSE, this::Method2150083));
    public Setting<Boolean> Field150 = this.Method2150366(new Setting<Object>("WebAttack", Boolean.TRUE, this::Method2150015));
    public Setting<Integer> Field138 = this.Method2150366(new Setting<Object>("Armour%", Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(125), this::Method2150027));
    public Setting<ACAutoSwitch> Field139 = this.Method2150366(new Setting<Object>("SwapMode", (Object) ACAutoSwitch.Spoof, this::Method2150026));
    public Setting<Bind> Field141 = this.Method2150366(new Setting<Object>("SwitchBind", new Bind(-1), this::Method2150024));
    public Setting<Boolean> Field142 = this.Method2150366(new Setting<Object>("LethalSwitch", Boolean.FALSE, this::Method2150023));
    public Setting<Boolean> Field143 = this.Method2150366(new Setting<Object>("MineSwitch", Boolean.TRUE, this::Method2150022));
    public Setting<ACRotate> Field144 = this.Method2150366(new Setting<Object>("Rotate", (Object) ACRotate.OFF, this::Method2150021));
    public Setting<ACYaw> Field146 = this.Method2150366(new Setting<Object>("YawStep", (Object) ACYaw.Full, this::Method2150019));
    public Setting<Integer> Field147 = this.Method2150366(new Setting<Object>("YawStepThreshold", Integer.valueOf(45), Integer.valueOf(0), Integer.valueOf(180), this::Method2150018));
    public Setting<Integer> Field148 = this.Method2150366(new Setting<Integer>("YawStepTicks", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(20), this::Method2150017));
    public Setting<Boolean> Field183 = this.Method2150366(new Setting<Object>("FirstRotation", Boolean.FALSE, this::Method2150982));
    public Setting<Integer> Field145 = this.Method2150366(new Setting<Object>("RotationSpoofs", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(20), this::Method2150010));
    public Setting<Boolean> Field149 = this.Method2150366(new Setting<Object>("IgnoreSelfDamage", Boolean.FALSE, this::Method2150016));
    public Setting<Boolean> Field151 = this.Method2150366(new Setting<Object>("ExtraCalc", Boolean.TRUE, this::Method2150014));
    public Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field152 = this.Method2150366(new Setting<Object>("Logic", (Object) IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.PLACEBREAK, this::Method2150013));
    public Setting<IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll> Field153 = this.Method2150366(new Setting<Object>("Raytrace", (Object) IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.NONE, this::Method2150012));
    public Setting<Float> Field69 = this.Method2150366(new Setting<Object>("PlaceTrace", Float.valueOf(3.5f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150096));
    public Setting<Float> Field86 = this.Method2150366(new Setting<Object>("BreakTrace", Float.valueOf(3.5f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150079));
    public Setting<Boolean> Field154 = this.Method2150366(new Setting<Object>("Sound", Boolean.TRUE, this::Method2150011));
    public Setting<Float> Field155 = this.Method2150366(new Setting<Object>("SoundRange", Float.valueOf(12.0f), Float.valueOf(0.0f), Float.valueOf(12.0f), this::Method2150900));
    public Setting<Float> Field156 = this.Method2150366(new Setting<Object>("SoundPlayer", Float.valueOf(12.0f), Float.valueOf(0.0f), Float.valueOf(12.0f), this::Method2150909));
    public Setting<Boolean> Field157 = this.Method2150366(new Setting<Object>("SoundConfirm", Boolean.TRUE, this::Method2150908));
    public Setting<Boolean> Field158 = this.Method2150366(new Setting<Object>("MinSelfDmg", Boolean.TRUE, this::Method2150907));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field159 = this.Method2150366(new Setting<Object>("FriendPop", (Object) IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NONE, this::Method2150906));
    public Setting<Boolean> Field160 = this.Method2150366(new Setting<Object>("AntiCount", Boolean.FALSE, this::Method2150905));
    public Setting<Boolean> Field161 = this.Method2150366(new Setting<Object>("BigFriendCalc", Boolean.FALSE, this::Method2150904));
    public Setting<Boolean> Field162 = this.Method2150366(new Setting<Object>("PredictFriend", Boolean.FALSE, this::Method2150903));
    public Setting<Float> Field167 = this.Method2150366(new Setting<Object>("MinMinDmg", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(3.0f), this::Method2150998));
    public Setting<ACSwing> Field168 = this.Method2150366(new Setting<Object>("SwingHand", (Object) ACSwing.Both, this::Method2150997));
    public Setting<Boolean> Field169 = this.Method2150366(new Setting<Object>("ExactHand", Boolean.FALSE, this::Method2150996));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field171 = this.Method2150366(new Setting<Object>("DamageSync", (Object) IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE, this::Method2150994));
    public Setting<Integer> Field172 = this.Method2150366(new Setting<Object>("SyncDelay", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(500), this::Method2150993));
    public Setting<Float> Field173 = this.Method2150366(new Setting<Object>("DropOff", Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150992));
    public Setting<Integer> Field174 = this.Method2150366(new Setting<Object>("Confirm", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150991));
    public Setting<Boolean> Field175 = this.Method2150366(new Setting<Object>("FeetSync", Boolean.FALSE, this::Method2150980));
    public Setting<Boolean> Field176 = this.Method2150366(new Setting<Object>("FullSync", Boolean.FALSE, this::Method2150989));
    public Setting<Boolean> Field177 = this.Method2150366(new Setting<Object>("SyncCount", Boolean.FALSE, this::Method2150988));
    public Setting<Boolean> Field178 = this.Method2150366(new Setting<Object>("HyperSync", Boolean.FALSE, this::Method2150987));
    public Setting<Boolean> Field179 = this.Method2150366(new Setting<Object>("GigaSync", Boolean.FALSE, this::Method2150986));
    public Setting<Boolean> Field180 = this.Method2150366(new Setting<Object>("SyncySync", Boolean.FALSE, this::Method2150985));
    public Setting<Boolean> Field181 = this.Method2150366(new Setting<Object>("EnormousSync", Boolean.FALSE, this::Method2150984));
    public Setting<Boolean> Field182 = this.Method2150366(new Setting<Object>("UnbelievableSync", Boolean.FALSE, this::Method2150983));
    public Setting<IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll> Field184 = this.Method2150366(new Setting<Object>("Thread", (Object) IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE, this::Method2150981));
    public Setting<Integer> Field185 = this.Method2150366(new Setting<Object>("ThreadDelay", Integer.valueOf(364), Integer.valueOf(1), Integer.valueOf(1000), this::Method2150970));
    public Setting<Boolean> Field186 = this.Method2150366(new Setting<Object>("ThreadSync", Boolean.TRUE, this::Method2150979));
    public Setting<Integer> Field187 = this.Method2150366(new Setting<Object>("SyncThreads", Integer.valueOf(1000), Integer.valueOf(1), Integer.valueOf(10000), this::Method2150978));
    public boolean Field188;
    public Entity Field191;
    public BlockPos Field197;
    private Queue<Entity> Field189 = new ConcurrentLinkedQueue<Entity>();
    private Map<Entity, Float> Field190 = new HashMap<Entity, Float>();
    private double Field192;
    private double Field193;
    private double Field194;
    private boolean Field195;
    private boolean Field196;
    private BlockPos Field198;
    private boolean Field199;
    private boolean Field200;
    private int Field201;
    private int Field202;
    private int Field203 = -1;
    private float Field204;
    private float Field205;
    private BlockPos Field206;
    private BlockPos Field207;
    private boolean Field208;
    private boolean Field209;
    private int Field210;
    private ScheduledExecutorService Field211;
    private Thread Field212;
    private EntityPlayer Field213;
    private BlockPos Field214;
    private BlockPos Field215;
    private IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll Field216;
    private boolean Field217;
    private boolean Field218;
    private BlockPos Field219;
    private AxisAlignedBB Field220;
    private float Field221;

    public AutoCrystal() {
        super("CrystalAura", "Best CA made by snow :D", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        Field51 = this;
    }

    public static AutoCrystal Method2150936() {
        if (Field51 == null) {
            Field51 = new AutoCrystal();
        }
        return Field51;
    }

    static AtomicBoolean Method2150099(AutoCrystal autoCrystal) {
        return autoCrystal.Field59;
    }

    static Timer Method2150090(AutoCrystal autoCrystal) {
        return autoCrystal.Field60;
    }

    static Thread Method2150001(AutoCrystal autoCrystal) {
        return autoCrystal.Field212;
    }

    static AtomicBoolean Method2150002(AutoCrystal autoCrystal) {
        return autoCrystal.Field63;
    }

    @Override
    public void Method2150376() {
        if (this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE && this.Field163.getValue() == 3) {
            this.Method2150954();
        }
    }

    @SubscribeEvent
    public void Method2150937(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1) {
            this.Method2150947();
        }
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0) {
            return;
        }
        if (this.Field163.getValue() == 2) {
            this.Method2150954();
        }
    }

    public void Method2150938() {
        if (this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE) {
            this.Method2150940();
        }
    }

    @Override
    public void Method2150379() {
        if (this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE && this.Field163.getValue() == 1) {
            this.Method2150954();
        }
    }

    @Override
    public void Method2150374() {
        Field50.clear();
        Field49.clear();
        this.Field61.clear();
        this.Field188 = false;
    }

    @Override
    public void Method2150373() {
        this.Field64.clear();
        this.Field219 = null;
        if (this.Field212 != null) {
            this.Field59.set(true);
        }
        if (this.Field211 != null) {
            this.Field211.shutdown();
        }
    }

    @Override
    public void Method2150372() {
        if (this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE) {
            this.Method2150940();
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field196) {
            return "\u00a7aSwitch";
        }
        if (Field47 != null) {
            return Field47.getName();
        }
        return null;
    }

    @SubscribeEvent
    public void Method2150939(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        CPacketUseEntity cPacketUseEntity;
        CPacketPlayer cPacketPlayer;
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && this.Field144.getValue() != ACRotate.OFF && this.Field188 && this.Field163.getValue() != 2 && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayer) {
            cPacketPlayer = (CPacketPlayer) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            cPacketPlayer.yaw = this.Field204;
            cPacketPlayer.pitch = this.Field205;
            ++this.Field210;
            if (this.Field210 >= this.Field145.getValue()) {
                this.Field188 = false;
                this.Field210 = 0;
            }
        }
        cPacketPlayer = null;
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction() == CPacketUseEntity.Action.ATTACK && cPacketUseEntity.getEntityFromWorld((World) AutoCrystal.Field2811.world) instanceof EntityEnderCrystal) {
            cPacketPlayer = Objects.requireNonNull(cPacketUseEntity.getEntityFromWorld((World) AutoCrystal.Field2811.world)).getPosition();
            if (this.Field165.getValue().booleanValue()) {
                Objects.requireNonNull(cPacketUseEntity.getEntityFromWorld((World) AutoCrystal.Field2811.world)).setDead();
                AutoCrystal.Field2811.world.removeEntityFromWorld(cPacketUseEntity.entityId);
            }
        }
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction() == CPacketUseEntity.Action.ATTACK && cPacketUseEntity.getEntityFromWorld((World) AutoCrystal.Field2811.world) instanceof EntityEnderCrystal) {
            EntityEnderCrystal entityEnderCrystal = (EntityEnderCrystal) cPacketUseEntity.getEntityFromWorld((World) AutoCrystal.Field2811.world);
            if (this.Field166.getValue().booleanValue() && EntityUtil.Method2163514(entityEnderCrystal, this.Field136.getValue().floatValue()) && cPacketPlayer != null) {
                this.Method2150971((BlockPos) cPacketPlayer);
                BlockUtil.Method2162838(this.Field197, this.Field200 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field168.getValue() == ACSwing.Place || this.Field168.getValue() == ACSwing.Both, this.Field169.getValue(), this.Field218);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
    public void Method2150930(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketSoundEffect sPacketSoundEffect;
        if (AutoCrystal.Method2150359()) {
            return;
        }
        if (this.Field52.Method2164755(this.Field140.getValue().intValue()) && this.Field93.getValue().booleanValue() && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSpawnObject && (this.Field215 == null || !this.Field175.getValue().booleanValue() || this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE)) {
            BlockPos blockPos;
            SPacketSpawnObject sPacketSpawnObject = (SPacketSpawnObject) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSpawnObject.getType() == 51 && AutoCrystal.Field2811.player.getDistanceSq(blockPos = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ())) + (double) this.Field101.getValue().floatValue() <= MathUtil.Method2163857(this.Field85.getValue().floatValue()) && (this.Field94.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.NONE || this.Field94.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.BREAK && this.Field54.Method2164755(this.Field84.getValue().intValue()) || this.Field94.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.PREDICT && this.Field57.Method2164755(this.Field96.getValue().intValue()))) {
                if (this.Method2150941(blockPos.down())) {
                    return;
                }
                if (this.Field162.getValue().booleanValue() && (this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAK || this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL) && this.Method2150942()) {
                    for (Object object : AutoCrystal.Field2811.world.playerEntities) {
                        if (object == null || AutoCrystal.Field2811.player.equals(object) || object.getDistanceSq(blockPos) > MathUtil.Method2163857(this.Field136.getValue().floatValue() + this.Field68.getValue().floatValue()) || !AliceMain.Field765.Method2150169((EntityPlayer) object) || !((double) DamageUtil.Method2163462(blockPos, (Entity) object) > (double) EntityUtil.Method2163530((Entity) object) + 0.5))
                            continue;
                        return;
                    }
                }
                if (Field49.contains((Object) blockPos.down())) {
                    float f;
                    if (this.Method2150942() && this.Field102.getValue() != false ? DamageUtil.Method2163463(this.Field149.getValue()) && ((double) (f = DamageUtil.Method2163462(blockPos, (Entity) AutoCrystal.Field2811.player)) - 0.5 > (double) EntityUtil.Method2163530((Entity) AutoCrystal.Field2811.player) || f > this.Field88.getValue().floatValue()) : this.Field102.getValue() != false) {
                        return;
                    }
                    this.Method2150943(sPacketSpawnObject.getEntityID(), blockPos);
                } else if (this.Field97.getValue().booleanValue() && this.Method2150942()) {
                    float f = -1.0f;
                    if (DamageUtil.Method2163463(this.Field149.getValue())) {
                        f = DamageUtil.Method2163462(blockPos, (Entity) AutoCrystal.Field2811.player);
                    }
                    if ((double) f + 0.5 < (double) EntityUtil.Method2163530((Entity) AutoCrystal.Field2811.player) && f <= this.Field88.getValue().floatValue()) {
                        for (EntityPlayer entityPlayer : AutoCrystal.Field2811.world.playerEntities) {
                            float f2;
                            if (!(entityPlayer.getDistanceSq(blockPos) <= MathUtil.Method2163857(this.Field136.getValue().floatValue())) || !EntityUtil.Method2163546((Entity) entityPlayer, this.Field136.getValue().floatValue() + this.Field85.getValue().floatValue()) || this.Field135.getValue().booleanValue() && DamageUtil.Method2163452(entityPlayer) || !((f2 = DamageUtil.Method2163462(blockPos, (Entity) entityPlayer)) > f || f2 > this.Field70.getValue().floatValue() && !DamageUtil.Method2163463(this.Field149.getValue())) && !(f2 > EntityUtil.Method2163530((Entity) entityPlayer)))
                                continue;
                            if (this.Field100.getValue().booleanValue() && this.Field163.getValue() != 2 && (this.Field144.getValue() == ACRotate.BREAK || this.Field144.getValue() == ACRotate.ALL)) {
                                this.Method2150971(blockPos);
                            }
                            this.Method2150943(sPacketSpawnObject.getEntityID(), blockPos);
                            break;
                        }
                    }
                }
            }
        } else if (!this.Field157.getValue().booleanValue() && iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketExplosion) {
            SPacketExplosion sPacketExplosion = (SPacketExplosion) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            BlockPos blockPos = new BlockPos(sPacketExplosion.getX(), sPacketExplosion.getY(), sPacketExplosion.getZ()).down();
            this.Method2150944(blockPos);
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketDestroyEntities) {
            SPacketDestroyEntities sPacketDestroyEntities = (SPacketDestroyEntities) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            for (int n2 : sPacketDestroyEntities.getEntityIDs()) {
                Entity entity = AutoCrystal.Field2811.world.getEntityByID(n2);
                if (!(entity instanceof EntityEnderCrystal)) continue;
                Field50.remove((Object) new BlockPos(entity.getPositionVector()).down());
                Field49.remove((Object) new BlockPos(entity.getPositionVector()).down());
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityStatus) {
            SPacketEntityStatus sPacketEntityStatus = (SPacketEntityStatus) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketEntityStatus.getOpCode() == 35 && sPacketEntityStatus.getEntity((World) AutoCrystal.Field2811.world) instanceof EntityPlayer) {
                this.Field61.put((EntityPlayer) sPacketEntityStatus.getEntity((World) AutoCrystal.Field2811.world), new Timer().Method2164750());
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect && (sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
            BlockPos blockPos = new BlockPos(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ());
            if (this.Field154.getValue().booleanValue() || this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.SOUND) {
                NoSoundLag.Method2161870(sPacketSoundEffect, this.Field155.getValue().floatValue());
            }
            if (this.Field157.getValue().booleanValue()) {
                this.Method2150944(blockPos);
            }
            if (this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.SOUND && this.Method2150942() && AutoCrystal.Field2811.player != null && AutoCrystal.Field2811.player.getDistanceSq(blockPos) < MathUtil.Method2163857(this.Field156.getValue().floatValue())) {
                this.Method2150951(true);
            }
        }
    }

    private boolean Method2150941(BlockPos blockPos) {
        if (this.Field103.getValue().booleanValue() && Field48.remove((Object) blockPos)) {
            return this.Method2150957(false);
        }
        return false;
    }

    private boolean Method2150942() {
        return Field2811.isCallingFromMinecraftThread() || !AliceMain.Field762.Method2150135() && !this.Field63.get();
    }

    private void Method2150943(int n2, BlockPos blockPos) {
        if (!(!this.Field100.getValue().booleanValue() || this.Field163.getValue() == 2 && this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE || this.Field144.getValue() != ACRotate.BREAK && this.Field144.getValue() != ACRotate.ALL)) {
            this.Method2150971(blockPos);
        }
        CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
        cPacketUseEntity.entityId = n2;
        cPacketUseEntity.action = CPacketUseEntity.Action.ATTACK;
        AutoCrystal.Field2811.player.connection.sendPacket((Packet) cPacketUseEntity);
        if (this.Field168.getValue() == ACSwing.Break || this.Field168.getValue() == ACSwing.Both) {
            AutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(EnumHand.MAIN_HAND));
        }
        if (this.Field95.getValue().booleanValue()) {
            this.Field54.Method2164750();
        }
        this.Field57.Method2164750();
    }

    private void Method2150944(BlockPos blockPos) {
        if (this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLACE) {
            if (Field49.remove((Object) blockPos)) {
                this.Field208 = true;
            }
        } else if (this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAK && Field50.remove((Object) blockPos)) {
            this.Field208 = true;
        }
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        Color color = new Color(this.Field119.getValue(), this.Field120.getValue(), this.Field121.getValue(), this.Field122.getValue());
        Color color2 = new Color(this.Field124.getValue(), this.Field125.getValue(), this.Field126.getValue(), this.Field127.getValue());
        if ((this.Field200 || this.Field199 || this.Field83.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.CALC) && this.Field198 != null && (this.Field118.getValue().booleanValue() || this.Field123.getValue().booleanValue())) {
            if (this.Field105.getValue() == ACRenderMode.FADE) {
                this.Field64.removeIf(this::Method2150977);
                this.Field64.add(new IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll(this, this.Field198, 0.0f));
            }
            if (this.Field105.getValue() == ACRenderMode.STATIC) {
                RenderUtil.Method2163909(new AxisAlignedBB(this.Field198), color, color2, this.Field128.getValue().floatValue(), this.Field123.getValue(), this.Field118.getValue(), this.Field117.getValue(), 1.0f, 1.0f, this.Field114.getValue().floatValue());
            }
            if (this.Field105.getValue() == ACRenderMode.NEWRAINBOW) {
                AxisAlignedBB axisAlignedBB = AutoCrystal.Field2811.world.getBlockState(this.Field198).getSelectedBoundingBox((World) AutoCrystal.Field2811.world, this.Field198);
                Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    RenderUtil.Method2163975(axisAlignedBB.grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), enumFacing, new Color(ColorUtil2.Method2164314(50).getRed(), ColorUtil2.Method2164314(50).getGreen(), ColorUtil2.Method2164314(50).getBlue(), 127), ColorUtil2.Method2164208(new Color(ColorUtil2.Method2164314(50).getRed(), ColorUtil2.Method2164314(50).getGreen(), ColorUtil2.Method2164314(50).getBlue(), 127)), 2.0);
                }
                RenderUtil.Method2163999(axisAlignedBB.grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), ColorUtil2.Method2164208(new Color(ColorUtil2.Method2164314(50).getRed(), ColorUtil2.Method2164314(50).getGreen(), ColorUtil2.Method2164314(50).getBlue(), 255)), new Color(ColorUtil2.Method2164314(50).getRed(), ColorUtil2.Method2164314(50).getGreen(), ColorUtil2.Method2164314(50).getBlue(), 255), 2.0f);
            }
            if (this.Field105.getValue() == ACRenderMode.GLIDE) {
                if (this.Field219 == null || AutoCrystal.Field2811.player.getDistance(this.Field220.minX, this.Field220.minY, this.Field220.minZ) > (double) this.Field136.getValue().floatValue()) {
                    this.Field219 = this.Field198;
                    this.Field220 = new AxisAlignedBB(this.Field198);
                    this.Field221 = 0.0f;
                }
                if (!this.Field219.equals((Object) this.Field198)) {
                    this.Field219 = this.Field198;
                    this.Field221 = 0.0f;
                }
                double d = (double) this.Field198.getX() - this.Field220.minX;
                double d2 = (double) this.Field198.getY() - this.Field220.minY;
                double d3 = (double) this.Field198.getZ() - this.Field220.minZ;
                float f = this.Field221 / this.Field115.getValue().floatValue() * this.Field116.getValue().floatValue();
                if (f > 1.0f) {
                    f = 1.0f;
                }
                this.Field220 = this.Field220.offset(d * (double) f, d2 * (double) f, d3 * (double) f);
                RenderUtil.Method2163909(this.Field220, color, color2, this.Field128.getValue().floatValue(), this.Field123.getValue(), this.Field118.getValue(), this.Field117.getValue(), 1.0f, 1.0f, this.Field114.getValue().floatValue());
                if (this.Field129.getValue().booleanValue()) {
                    RenderUtil.Method2163023(this.Field220.offset(0.0, (double) (1.0f - this.Field114.getValue().floatValue() / 2.0f) - 0.4, 0.0), (Math.floor(this.Field193) == this.Field193 ? Integer.valueOf((int) this.Field193) : String.format("%.1f", this.Field193)) + "");
                }
                this.Field221 = this.Field220.equals((Object) new AxisAlignedBB(this.Field198)) ? 0.0f : (this.Field221 += 50.0f);
            }
        }
        if (this.Field105.getValue() == ACRenderMode.FADE) {
            this.Field64.forEach(arg_0 -> this.Method2150976(color, color2, arg_0));
            this.Field64.removeIf(this::Method2150975);
            if (this.Field64.size() > this.Field113.getValue()) {
                this.Field64.remove(0);
            }
        }
        if ((this.Field200 || this.Field199 || this.Field83.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.CALC) && this.Field198 != null && this.Field129.getValue().booleanValue() && this.Field105.getValue() != ACRenderMode.GLIDE) {
            RenderUtil.Method2163023(new AxisAlignedBB(this.Field198).offset(0.0, this.Field105.getValue() != ACRenderMode.FADE ? (double) (1.0f - this.Field114.getValue().floatValue() / 2.0f) - 0.4 : 0.1, 0.0), (Math.floor(this.Field193) == this.Field193 ? Integer.valueOf((int) this.Field193) : String.format("%.1f", this.Field193)) + "");
        }
    }

    @SubscribeEvent
    public void Method2150945(InputEvent.KeyInputEvent keyInputEvent) {
        if (Keyboard.getEventKeyState() && !(AutoCrystal.Field2811.currentScreen instanceof LuigiGuiOld) && this.Field141.getValue().getKey() == Keyboard.getEventKey()) {
            this.Field196 = !this.Field196;
        }
    }

    @SubscribeEvent
    public void Method2150946(ClientEvent clientEvent) {
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 2 && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll() != null && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature() != null && clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().getFeature().equals(this) && this.Method2150364() && (clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().equals(this.Field185) || clientEvent.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll().equals(this.Field184))) {
            if (this.Field211 != null) {
                this.Field211.shutdown();
            }
            if (this.Field212 != null) {
                this.Field59.set(true);
            }
        }
    }

    private void Method2150947() {
        if (this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE || this.Field163.getValue() != 2 || this.Field144.getValue() == ACRotate.OFF || !this.Field183.getValue().booleanValue()) {
            return;
        }
        switch (this.Field152.getValue()) {
            case BREAKPLACE: {
                this.Method2150948();
                this.Method2150949();
                break;
            }
            case PLACEBREAK: {
                this.Method2150949();
                this.Method2150948();
            }
        }
    }

    private void Method2150948() {
        while (!this.Field62.isEmpty()) {
            CPacketUseEntity cPacketUseEntity = this.Field62.poll();
            AutoCrystal.Field2811.player.connection.sendPacket((Packet) cPacketUseEntity);
            if (this.Field168.getValue() == ACSwing.Break || this.Field168.getValue() == ACSwing.Both) {
                AutoCrystal.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            }
            this.Field54.Method2164750();
        }
    }

    private void Method2150949() {
        if (this.Field216 != null) {
            this.Field216.Method2150920();
            this.Field55.Method2164750();
            this.Field216 = null;
        }
    }

    private void Method2150940() {
        if (this.Method2150387()) {
            return;
        }
        if (this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.WHILE) {
            this.Method2150952();
        } else if (this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE) {
            this.Method2150951(false);
        }
    }

    private void Method2150951(boolean bl) {
        if (bl || this.Field211 == null || this.Field211.isTerminated() || this.Field211.isShutdown() || this.Field60.Method2164755(this.Field187.getValue().intValue()) && this.Field186.getValue().booleanValue()) {
            if (this.Field211 != null) {
                this.Field211.shutdown();
            }
            this.Field211 = this.Method2150953();
            this.Field60.Method2164750();
        }
    }

    private void Method2150952() {
        if (this.Field212 == null || this.Field212.isInterrupted() || !this.Field212.isAlive() || this.Field60.Method2164755(this.Field187.getValue().intValue()) && this.Field186.getValue().booleanValue()) {
            if (this.Field212 == null) {
                this.Field212 = new Thread(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.Method2150931(this));
            } else if (this.Field60.Method2164755(this.Field187.getValue().intValue()) && !this.Field59.get() && this.Field186.getValue().booleanValue()) {
                this.Field59.set(true);
                this.Field60.Method2164750();
                return;
            }
            if (this.Field212 != null && (this.Field212.isInterrupted() || !this.Field212.isAlive())) {
                this.Field212 = new Thread(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.Method2150931(this));
            }
            if (this.Field212 != null && this.Field212.getState() == Thread.State.NEW) {
                try {
                    this.Field212.start();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                this.Field60.Method2164750();
            }
        }
    }

    private ScheduledExecutorService Method2150953() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.Method2150931(this), 0L, this.Field185.getValue().intValue(), TimeUnit.MILLISECONDS);
        return scheduledExecutorService;
    }

    public void Method2150954() {
        if (this.Method2150955()) {
            switch (this.Field152.getValue()) {
                case PLACEBREAK: {
                    this.Method2150958();
                    this.Method2150964();
                    break;
                }
                case BREAKPLACE: {
                    this.Method2150964();
                    this.Method2150958();
                }
            }
            this.Method2150969();
        }
    }

    private boolean Method2150955() {
        if (AutoCrystal.Method2150359()) {
            return false;
        }
        if (this.Field56.Method2164755(this.Field172.getValue().intValue())) {
            this.Field213 = null;
            this.Field215 = null;
            this.Field214 = null;
        } else if (this.Field180.getValue().booleanValue() && this.Field215 != null) {
            this.Field208 = true;
        }
        this.Field209 = false;
        if (this.Field58.Method2164755(500L)) {
            this.Field198 = null;
            this.Field58.Method2164750();
        }
        this.Field199 = AutoCrystal.Field2811.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL;
        boolean bl = this.Field199;
        if (this.Field139.getValue() == ACAutoSwitch.Spoof && InventoryUtil.Method2163781(Items.END_CRYSTAL) != -1) {
            this.Field199 = true;
            this.Field218 = true;
        } else {
            this.Field218 = false;
        }
        this.Field200 = AutoCrystal.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
        this.Field192 = 0.0;
        this.Field197 = null;
        if (this.Field203 != AutoCrystal.Field2811.player.inventory.currentItem) {
            this.Field203 = AutoCrystal.Field2811.player.inventory.currentItem;
            this.Field52.Method2164750();
        }
        if (!this.Field200 && !this.Field199) {
            this.Field216 = null;
            this.Field62.clear();
        }
        if (this.Field200 || this.Field199) {
            this.Field196 = false;
        }
        if (!((this.Field200 || this.Field199 || this.Field83.getValue() != IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.BREAKSLOT || this.Field196) && DamageUtil.Method2163457((EntityPlayer) AutoCrystal.Field2811.player) && this.Field52.Method2164755(this.Field140.getValue().intValue()))) {
            this.Field198 = null;
            Field47 = null;
            this.Field188 = false;
            return false;
        }
        if (this.Field143.getValue().booleanValue() && Mouse.isButtonDown((int) 0) && (this.Field196 || this.Field139.getValue() == ACAutoSwitch.Swap) && Mouse.isButtonDown((int) 1) && AutoCrystal.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
            this.Method2150950();
        }
        this.Method2150956();
        if (!this.Field208 && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field56.Method2164755(this.Field174.getValue().intValue())) {
            this.Field56.Method2164756(this.Field172.getValue() + 1);
        }
        return true;
    }

    private void Method2150956() {
        this.Field191 = null;
        if (this.Field87.getValue() != 1) {
            this.Field189 = new ConcurrentLinkedQueue<Entity>();
            this.Field190 = new HashMap<Entity, Float>();
        }
        this.Field201 = 0;
        this.Field202 = 0;
        Entity object = null;
        float f = 0.5f;
        for (Entity object2 : AutoCrystal.Field2811.world.loadedEntityList) {
            if (object2.isDead || !(object2 instanceof EntityEnderCrystal) || !this.Method2150973(object2)) continue;
            if (this.Field175.getValue().booleanValue() && object2.getPosition().down().equals((Object) this.Field215) && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
                ++this.Field202;
                ++this.Field201;
                if (this.Field177.getValue().booleanValue()) {
                    this.Field202 = this.Field72.getValue() + 1;
                    this.Field201 = this.Field72.getValue() + 1;
                }
                if (!this.Field178.getValue().booleanValue()) continue;
                object = null;
                break;
            }
            boolean bl = false;
            boolean bl2 = false;
            float f2 = -1.0f;
            if (DamageUtil.Method2163463(this.Field149.getValue())) {
                f2 = DamageUtil.Method2163461(object2, (Entity) AutoCrystal.Field2811.player);
            }
            if ((double) f2 + 0.5 < (double) EntityUtil.Method2163530((Entity) AutoCrystal.Field2811.player) && f2 <= this.Field88.getValue().floatValue()) {
                Entity entity = object;
                float f3 = f;
                for (EntityPlayer entityPlayer : AutoCrystal.Field2811.world.playerEntities) {
                    if (!(entityPlayer.getDistanceSq(object2) <= MathUtil.Method2163857(this.Field136.getValue().floatValue())))
                        continue;
                    if (EntityUtil.Method2163546((Entity) entityPlayer, this.Field136.getValue().floatValue() + this.Field85.getValue().floatValue())) {
                        float f4;
                        if (this.Field135.getValue().booleanValue() && DamageUtil.Method2163452(entityPlayer) || !((f4 = DamageUtil.Method2163461(object2, (Entity) entityPlayer)) > f2 || f4 > this.Field70.getValue().floatValue() && !DamageUtil.Method2163463(this.Field149.getValue())) && !(f4 > EntityUtil.Method2163530((Entity) entityPlayer)))
                            continue;
                        if (f4 > f) {
                            f = f4;
                            object = object2;
                        }
                        if (this.Field87.getValue() == 1) {
                            if (f4 >= this.Field70.getValue().floatValue() || !this.Field73.getValue().booleanValue()) {
                                bl = true;
                            }
                            bl2 = true;
                            continue;
                        }
                        if (this.Field190.get((Object) object2) != null && !(this.Field190.get((Object) object2).floatValue() < f4))
                            continue;
                        this.Field190.put(object2, Float.valueOf(f4));
                        continue;
                    }
                    if (this.Field159.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAK && this.Field159.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL || !AliceMain.Field765.Method2150168(entityPlayer.getName()) || !((double) DamageUtil.Method2163461(object2, (Entity) entityPlayer) > (double) EntityUtil.Method2163530((Entity) entityPlayer) + 0.5))
                        continue;
                    object = entity;
                    f = f3;
                    this.Field190.remove((Object) object2);
                    if (!this.Field160.getValue().booleanValue()) break;
                    bl = false;
                    bl2 = false;
                    break;
                }
            }
            if (!bl2) continue;
            ++this.Field202;
            if (!bl) continue;
            ++this.Field201;
        }
        if (this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAK && ((double) f > this.Field194 || this.Field56.Method2164755(this.Field172.getValue().intValue()) || this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE)) {
            this.Field194 = f;
        }
        if (this.Field181.getValue().booleanValue() && this.Field175.getValue().booleanValue() && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field215 != null) {
            if (this.Field177.getValue().booleanValue()) {
                this.Field202 = this.Field72.getValue() + 1;
                this.Field201 = this.Field72.getValue() + 1;
            }
            return;
        }
        if (this.Field150.getValue().booleanValue() && this.Field206 != null) {
            if (AutoCrystal.Field2811.player.getDistanceSq(this.Field206.up()) > MathUtil.Method2163857(this.Field85.getValue().floatValue())) {
                this.Field206 = null;
            } else {
                for (Entity entity : AutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(this.Field206.up()))) {
                    if (!(entity instanceof EntityEnderCrystal)) continue;
                    this.Field189.add(entity);
                    this.Field191 = entity;
                    this.Field206 = null;
                    this.Field194 = 0.5;
                    return;
                }
            }
        }
        if (this.Method2150957(true) && f < this.Field70.getValue().floatValue() && (Field47 == null || !(EntityUtil.Method2163530((Entity) Field47) <= this.Field74.getValue().floatValue()) || !this.Field54.Method2164755(this.Field134.getValue().intValue()) && this.Field132.getValue().booleanValue() && Mouse.isButtonDown((int) 0) && this.Field130.getValue().booleanValue() && this.Field131.getValue().booleanValue())) {
            this.Field191 = null;
            return;
        }
        if (this.Field87.getValue() == 1) {
            this.Field191 = object;
        } else {
            this.Field190 = MathUtil.Method2163862(this.Field190, true);
            for (Map.Entry entry : this.Field190.entrySet()) {
                Entity entity = (Entity) entry.getKey();
                float f5 = ((Float) entry.getValue()).floatValue();
                if (f5 >= this.Field70.getValue().floatValue() || !this.Field73.getValue().booleanValue()) {
                    ++this.Field201;
                }
                this.Field189.add(entity);
                ++this.Field202;
            }
        }
    }

    private boolean Method2150957(boolean bl) {
        return bl && this.Field89.getValue() != false && this.Field90.getValue() != false && Mouse.isButtonDown((int) 1) && (!Mouse.isButtonDown((int) 0) || this.Field130.getValue() == false) || this.Field130.getValue() != false && this.Field131.getValue() != false && Mouse.isButtonDown((int) 0) && !this.Field54.Method2164755(this.Field134.getValue().intValue()) || this.Field132.getValue() != false && !this.Field54.Method2164755(this.Field134.getValue().intValue());
    }

    private void Method2150958() {
        int n2 = this.Field72.getValue();
        if (this.Field55.Method2164755(this.Field67.getValue().intValue()) && (this.Field200 || this.Field199 || this.Field83.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.CALC || this.Field83.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.BREAKSLOT && this.Field196)) {
            if (!(!this.Field200 && !this.Field199 && (this.Field83.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.ALWAYS || this.Field196) || this.Field201 < n2 || this.Field75.getValue().booleanValue() && this.Field207 != null && this.Field207.equals((Object) this.Field197))) {
                return;
            }
            this.Method2150962(this.Method2150963(this.Field137.getValue() == IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.UNSAFE));
            if (Field47 != null && this.Field197 != null) {
                if (!this.Field200 && !this.Field199 && this.Field139.getValue() != ACAutoSwitch.None && (this.Field192 > (double) this.Field70.getValue().floatValue() || this.Field142.getValue().booleanValue() && EntityUtil.Method2163530((Entity) Field47) <= this.Field74.getValue().floatValue()) && !this.Method2150950()) {
                    return;
                }
                if (this.Field192 < (double) this.Field70.getValue().floatValue() && this.Field76.getValue().booleanValue()) {
                    n2 = 1;
                }
                if (this.Field192 >= (double) this.Field167.getValue().floatValue() && (this.Field200 || this.Field199 || this.Field139.getValue() != ACAutoSwitch.None) && (this.Field201 < n2 || this.Field75.getValue().booleanValue() && this.Field207 != null && this.Field207.equals((Object) this.Field197)) && (this.Field192 > (double) this.Field70.getValue().floatValue() || this.Field202 < n2) && this.Field192 >= 1.0 && (DamageUtil.Method2163451(Field47, this.Field138.getValue()) || EntityUtil.Method2163530((Entity) Field47) <= this.Field74.getValue().floatValue() || this.Field192 > (double) this.Field70.getValue().floatValue() || this.Method2150959())) {
                    float f = this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAK ? this.Field173.getValue().floatValue() - 5.0f : 0.0f;
                    boolean bl = false;
                    if (this.Field175.getValue().booleanValue() && this.Field197.equals((Object) this.Field207) && this.Method2150974(Field47, this.Field197) && !this.Field56.Method2164755(this.Field172.getValue().intValue()) && Field47.equals((Object) this.Field213) && Field47.getPosition().equals((Object) this.Field214) && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
                        this.Field215 = this.Field197;
                        this.Field194 = this.Field192;
                        if (this.Field176.getValue().booleanValue()) {
                            this.Field194 = 100.0;
                        }
                        bl = true;
                    }
                    if (bl || this.Field192 - (double) f > this.Field194 || this.Field56.Method2164755(this.Field172.getValue().intValue()) || this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
                        if (!bl && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAK) {
                            this.Field194 = this.Field192;
                        }
                        if (!this.Field111.getValue().booleanValue()) {
                            this.Field198 = this.Field197;
                        }
                        this.Field193 = this.Field192;
                        if (this.Method2150950()) {
                            this.Field213 = Field47;
                            this.Field214 = Field47.getPosition();
                            if (this.Field209) {
                                this.Field61.put(Field47, new Timer().Method2164750());
                            }
                            this.Method2150971(this.Field197);
                            if (this.Field217 || this.Field133.getValue().booleanValue() && this.Field192 < (double) this.Field70.getValue().floatValue()) {
                                Field48.add(this.Field197);
                            }
                            Field49.add(this.Field197);
                            if (this.Field163.getValue() == 2 && this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE && this.Field183.getValue().booleanValue() && this.Field144.getValue() != ACRotate.OFF) {
                                this.Field216 = new IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(this.Field197, this.Field200, this.Field168.getValue() == ACSwing.Place || this.Field168.getValue() == ACSwing.Both, this.Field169.getValue(), this.Field218);
                            } else {
                                BlockUtil.Method2162839(this.Field197, this.Field200 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field168.getValue() == ACSwing.Place || this.Field168.getValue() == ACSwing.Both, this.Field169.getValue(), this.Field170.getValue(), this.Field218);
                                AutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(this.Field197, EnumFacing.UP, AutoCrystal.Field2811.player.getHeldItemOffhand().getItem().equals((Object) Items.END_CRYSTAL) ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, 0.5f, 1.0f, 0.5f));
                            }
                            this.Field207 = this.Field197;
                            this.Field55.Method2164750();
                            this.Field208 = false;
                            if (this.Field56.Method2164755(this.Field172.getValue().intValue())) {
                                this.Field215 = null;
                                this.Field56.Method2164750();
                            }
                        }
                    }
                }
            } else {
                this.Field198 = null;
            }
        }
    }

    private boolean Method2150959() {
        this.Field217 = false;
        if (this.Field130.getValue().booleanValue() && Mouse.isButtonDown((int) 0)) {
            this.Field217 = true;
            return true;
        }
        return false;
    }

    private boolean Method2150950() {
        if (this.Field200 || this.Field199) {
            return true;
        }
        switch (this.Field139.getValue()) {
            case None: {
                return false;
            }
            case Toggle: {
                if (!this.Field196) {
                    return false;
                }
            }
            case Swap: {
                if (!this.Method2150961()) break;
                return true;
            }
        }
        return false;
    }

    private boolean Method2150961() {
        if (AutoCrystal.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
            this.Field199 = false;
        } else {
            InventoryUtil.Method2163775(ItemEndCrystal.class, false);
            this.Field199 = true;
        }
        this.Field196 = false;
        return true;
    }

    private void Method2150962(EntityPlayer entityPlayer) {
        BlockPos blockPos;
        if (entityPlayer == null && this.Field137.getValue() != IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.DAMAGE && !this.Field151.getValue().booleanValue()) {
            return;
        }
        float f = 0.5f;
        EntityPlayer entityPlayer2 = null;
        BlockPos blockPos2 = null;
        float f2 = 0.0f;
        this.Field209 = false;
        BlockPos blockPos3 = null;
        IBlockState iBlockState = null;
        if (this.Field150.getValue().booleanValue() && entityPlayer != null && AutoCrystal.Field2811.world.getBlockState(blockPos = new BlockPos(entityPlayer.getPositionVector())).getBlock() == Blocks.WEB) {
            blockPos3 = blockPos;
            iBlockState = AutoCrystal.Field2811.world.getBlockState(blockPos);
            AutoCrystal.Field2811.world.setBlockToAir(blockPos);
        }
        block0:
        for (BlockPos blockPos4 : BlockUtil.Method2162796(this.Field68.getValue().floatValue(), this.Field75.getValue(), this.Field77.getValue())) {
            float f3;
            if (!BlockUtil.Method2162853(blockPos4, (this.Field153.getValue() == IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.PLACE || this.Field153.getValue() == IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.FULL) && AutoCrystal.Field2811.player.getDistanceSq(blockPos4) > MathUtil.Method2163857(this.Field69.getValue().floatValue()), 1.0f))
                continue;
            float f4 = -1.0f;
            if (DamageUtil.Method2163463(this.Field149.getValue())) {
                f4 = DamageUtil.Method2163462(blockPos4, (Entity) AutoCrystal.Field2811.player);
            }
            if (!((double) f4 + 0.5 < (double) EntityUtil.Method2163530((Entity) AutoCrystal.Field2811.player)) || !(f4 <= this.Field71.getValue().floatValue()))
                continue;
            if (entityPlayer != null) {
                f3 = DamageUtil.Method2163462(blockPos4, (Entity) entityPlayer);
                if (this.Field161.getValue().booleanValue() && (this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL || this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PLACE)) {
                    boolean bl = false;
                    for (EntityPlayer entityPlayer3 : AutoCrystal.Field2811.world.playerEntities) {
                        if (entityPlayer3 == null || AutoCrystal.Field2811.player.equals((Object) entityPlayer3) || entityPlayer3.getDistanceSq(blockPos4) > MathUtil.Method2163857(this.Field136.getValue().floatValue() + this.Field68.getValue().floatValue()) || !AliceMain.Field765.Method2150169(entityPlayer3) || !((double) DamageUtil.Method2163462(blockPos4, (Entity) entityPlayer3) > (double) EntityUtil.Method2163530((Entity) entityPlayer3) + 0.5))
                            continue;
                        bl = true;
                        break;
                    }
                    if (bl) continue;
                }
                if (this.Method2150972(entityPlayer, f3) && (blockPos2 == null || entityPlayer.getDistanceSq(blockPos4) < entityPlayer.getDistanceSq(blockPos2))) {
                    entityPlayer2 = entityPlayer;
                    f = f3;
                    blockPos2 = blockPos4;
                    this.Field209 = true;
                    continue;
                }
                if (!(!this.Field209 && (f3 > f || this.Field158.getValue() != false && f3 >= f && f4 < f2) && (f3 > f4 || f3 > this.Field70.getValue().floatValue() && !DamageUtil.Method2163463(this.Field149.getValue()) || f3 > EntityUtil.Method2163530((Entity) entityPlayer))))
                    continue;
                f = f3;
                entityPlayer2 = entityPlayer;
                blockPos2 = blockPos4;
                f2 = f4;
                continue;
            }
            f3 = f;
            EntityPlayer entityPlayer4 = entityPlayer2;
            BlockPos blockPos5 = blockPos2;
            float f5 = f2;
            for (EntityPlayer entityPlayer5 : AutoCrystal.Field2811.world.playerEntities) {
                if (EntityUtil.Method2163546((Entity) entityPlayer5, this.Field68.getValue().floatValue() + this.Field136.getValue().floatValue())) {
                    if (this.Field135.getValue().booleanValue() && DamageUtil.Method2163452(entityPlayer5)) continue;
                    float f6 = DamageUtil.Method2163462(blockPos4, (Entity) entityPlayer5);
                    if (this.Field82.getValue().booleanValue() && this.Method2150972(entityPlayer5, f6) && (blockPos2 == null || entityPlayer5.getDistanceSq(blockPos4) < entityPlayer5.getDistanceSq(blockPos2))) {
                        entityPlayer2 = entityPlayer5;
                        f = f6;
                        blockPos2 = blockPos4;
                        f2 = f4;
                        this.Field209 = true;
                        if (this.Field159.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAK && this.Field159.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PLACE)
                            continue;
                        continue block0;
                    }
                    if (!(!this.Field209 && (f6 > f || this.Field158.getValue() != false && f6 >= f && f4 < f2) && (f6 > f4 || f6 > this.Field70.getValue().floatValue() && !DamageUtil.Method2163463(this.Field149.getValue()) || f6 > EntityUtil.Method2163530((Entity) entityPlayer5))))
                        continue;
                    f = f6;
                    entityPlayer2 = entityPlayer5;
                    blockPos2 = blockPos4;
                    f2 = f4;
                    continue;
                }
                if (this.Field159.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL && this.Field159.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.PLACE || entityPlayer5 == null || !(entityPlayer5.getDistanceSq(blockPos4) <= MathUtil.Method2163857(this.Field136.getValue().floatValue() + this.Field68.getValue().floatValue())) || !AliceMain.Field765.Method2150169(entityPlayer5) || !((double) DamageUtil.Method2163462(blockPos4, (Entity) entityPlayer5) > (double) EntityUtil.Method2163530((Entity) entityPlayer5) + 0.5))
                    continue;
                f = f3;
                entityPlayer2 = entityPlayer4;
                blockPos2 = blockPos5;
                f2 = f5;
                continue block0;
            }
        }
        if (blockPos3 != null) {
            AutoCrystal.Field2811.world.setBlockState(blockPos3, iBlockState);
            this.Field206 = blockPos2;
        }
        Field47 = entityPlayer2;
        this.Field192 = f;
        this.Field197 = blockPos2;
    }

    private EntityPlayer Method2150963(boolean bl) {
        if (this.Field137.getValue() == IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.DAMAGE) {
            return null;
        }
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : AutoCrystal.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, this.Field68.getValue().floatValue() + this.Field136.getValue().floatValue()) || this.Field135.getValue().booleanValue() && DamageUtil.Method2163452(entityPlayer2) || bl && EntityUtil.Method2163402((Entity) entityPlayer2))
                continue;
            if (this.Field138.getValue() > 0 && DamageUtil.Method2163451(entityPlayer2, this.Field138.getValue())) {
                entityPlayer = entityPlayer2;
                break;
            }
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(AutoCrystal.Field2811.player.getDistanceSq((Entity) entityPlayer2) < AutoCrystal.Field2811.player.getDistanceSq((Entity) entityPlayer)))
                continue;
            entityPlayer = entityPlayer2;
        }
        if (bl && entityPlayer == null) {
            return this.Method2150963(false);
        }
        if (this.Field98.getValue().booleanValue() && entityPlayer != null) {
            EntityPlayer entityPlayer2;
            entityPlayer.getUniqueID();
            GameProfile gameProfile = new GameProfile(entityPlayer.getUniqueID(), entityPlayer.getName());
            entityPlayer2 = new EntityOtherPlayerMP((World) AutoCrystal.Field2811.world, gameProfile);
            Vec3d vec3d = MathUtil.Method2163875(entityPlayer, this.Field99.getValue());
            entityPlayer2.copyLocationAndAnglesFrom((Entity) entityPlayer);
            entityPlayer2.posX = vec3d.x;
            entityPlayer2.posY = vec3d.y;
            entityPlayer2.posZ = vec3d.z;
            entityPlayer2.setHealth(EntityUtil.Method2163530((Entity) entityPlayer));
            entityPlayer2.inventory.copyInventory(entityPlayer.inventory);
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    private void Method2150964() {
        if (this.Field54.Method2164755(this.Field84.getValue().intValue()) && (this.Field83.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.ALWAYS || this.Field199 || this.Field200)) {
            if (this.Field87.getValue() == 1 && this.Field191 != null) {
                if (this.Field175.getValue().booleanValue() && this.Field179.getValue().booleanValue() && this.Field215 != null && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
                    return;
                }
                this.Method2150960(this.Field191);
                this.Method2150965(this.Field191);
                this.Field54.Method2164750();
            } else if (!this.Field189.isEmpty()) {
                if (this.Field175.getValue().booleanValue() && this.Field179.getValue().booleanValue() && this.Field215 != null && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
                    return;
                }
                for (int j = 0; j < this.Field87.getValue(); ++j) {
                    Entity entity = this.Field189.poll();
                    if (entity == null) continue;
                    this.Method2150960(entity);
                    this.Method2150965(entity);
                }
                this.Field54.Method2164750();
            }
        }
    }

    private void Method2150965(Entity entity) {
        if (entity != null) {
            if (this.Field163.getValue() == 2 && this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE && this.Field183.getValue().booleanValue() && this.Field144.getValue() != ACRotate.OFF) {
                this.Field62.add(new CPacketUseEntity(entity));
            } else {
                EntityUtil.Method2163488(entity, this.Field92.getValue(), this.Field168.getValue() == ACSwing.Break || this.Field168.getValue() == ACSwing.Both);
                EntityUtil.Method2163491(entity, this.Field164.getValue(), this.Field164.getValue());
                Field50.add(new BlockPos(entity.getPositionVector()).down());
            }
        }
    }

    public boolean Method2150966() {
        return InventoryUtilCC.Method2163282(Items.END_CRYSTAL) || this.Field139.getValue().equals((Object) ACAutoSwitch.Spoof) && InventoryUtilCC.Method2163287(Items.END_CRYSTAL);
    }

    public boolean Method2150967() {
        return this.Method2150364() && (this.Field191 != null || this.Field197 != null) && this.Method2150966();
    }

    public boolean Method2150968() {
        return this.Method2150364() && (this.Field191 != null || this.Field197 != null) && this.Method2150966() & this.Field144.getValue() != ACRotate.OFF && Speedmine.Field3402.Field3404.getValue() != false;
    }

    private void Method2150969() {
        RayTraceResult rayTraceResult;
        if (this.Field144.getValue() != ACRotate.OFF && this.Field163.getValue() != 2 && this.Field188) {
            if (this.Field195) {
                AutoCrystal.Field2811.player.rotationPitch = (float) ((double) AutoCrystal.Field2811.player.rotationPitch + 4.0E-4);
                this.Field195 = false;
            } else {
                AutoCrystal.Field2811.player.rotationPitch = (float) ((double) AutoCrystal.Field2811.player.rotationPitch - 4.0E-4);
                this.Field195 = true;
            }
        }
        if ((this.Field200 || this.Field199) && this.Field89.getValue().booleanValue() && this.Field53.Method2164755(this.Field91.getValue().intValue()) && Mouse.isButtonDown((int) 1) && AutoCrystal.Field2811.player.getHeldItemOffhand().getItem() != Items.GOLDEN_APPLE && AutoCrystal.Field2811.player.inventory.getCurrentItem().getItem() != Items.GOLDEN_APPLE && AutoCrystal.Field2811.player.inventory.getCurrentItem().getItem() != Items.BOW && AutoCrystal.Field2811.player.inventory.getCurrentItem().getItem() != Items.EXPERIENCE_BOTTLE && (rayTraceResult = AutoCrystal.Field2811.objectMouseOver) != null) {
            switch (rayTraceResult.typeOfHit) {
                case ENTITY: {
                    Entity entity = rayTraceResult.entityHit;
                    if (!(entity instanceof EntityEnderCrystal)) break;
                    EntityUtil.Method2163488(entity, this.Field92.getValue(), this.Field168.getValue() == ACSwing.Break || this.Field168.getValue() == ACSwing.Both);
                    EntityUtil.Method2163491(entity, this.Field164.getValue(), this.Field164.getValue());
                    this.Field53.Method2164750();
                    break;
                }
                case BLOCK: {
                    BlockPos blockPos = AutoCrystal.Field2811.objectMouseOver.getBlockPos().up();
                    for (Entity entity : AutoCrystal.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
                        if (!(entity instanceof EntityEnderCrystal)) continue;
                        EntityUtil.Method2163488(entity, this.Field92.getValue(), this.Field168.getValue() == ACSwing.Break || this.Field168.getValue() == ACSwing.Both);
                        EntityUtil.Method2163491(entity, this.Field164.getValue(), this.Field164.getValue());
                        this.Field53.Method2164750();
                    }
                    break;
                }
            }
        }
    }

    private void Method2150960(Entity entity) {
        switch (this.Field144.getValue()) {
            case OFF: {
                this.Field188 = false;
            }
            case PLACE: {
                break;
            }
            case BREAK:
            case ALL: {
                float[] arrf = MathUtil.Method2163871(AutoCrystal.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionVector());
                if (this.Field163.getValue() == 2 && this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE) {
                    if (this.Field146.getValue() == ACYaw.Semi) {
                        float f = AliceMain.Field760.Method2150285();
                        while (f < arrf[1]) {
                            if (AutoCrystal.Field2811.player.ticksExisted % this.Field148.getValue() != 0) continue;
                            AliceMain.Field760.Method2150278(f += (float) this.Field147.getValue().intValue(), arrf[1]);
                        }
                        break;
                    }
                    AliceMain.Field760.Method2150278(arrf[0], arrf[1]);
                    break;
                }
                this.Field204 = arrf[0];
                this.Field205 = arrf[1];
                this.Field188 = true;
            }
        }
    }

    private void Method2150971(BlockPos blockPos) {
        switch (this.Field144.getValue()) {
            case OFF: {
                this.Field188 = false;
            }
            case BREAK: {
                break;
            }
            case PLACE:
            case ALL: {
                float[] arrf = MathUtil.Method2163871(AutoCrystal.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() - 0.5f), (double) ((float) blockPos.getZ() + 0.5f)));
                if (this.Field163.getValue() == 2 && this.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE) {
                    if (this.Field146.getValue() == ACYaw.Semi) {
                        float f = AliceMain.Field760.Method2150285();
                        while (f < arrf[1]) {
                            if (AutoCrystal.Field2811.player.ticksExisted % this.Field148.getValue() != 0) continue;
                            AliceMain.Field760.Method2150278(f += (float) this.Field147.getValue().intValue(), arrf[1]);
                            this.Field65.Method2164750();
                        }
                        break;
                    }
                    AliceMain.Field760.Method2150278(arrf[0], arrf[1]);
                    break;
                }
                this.Field204 = arrf[0];
                this.Field205 = arrf[1];
                this.Field188 = true;
            }
        }
    }

    private boolean Method2150972(EntityPlayer entityPlayer, float f) {
        if (this.Field78.getValue().booleanValue()) {
            float f2;
            float f3 = EntityUtil.Method2163530((Entity) entityPlayer);
            if ((double) f2 <= this.Field79.getValue() && (double) f > (double) f3 + 0.5 && f <= this.Field80.getValue().floatValue()) {
                Timer timer = this.Field61.get((Object) entityPlayer);
                return timer == null || timer.Method2164755(this.Field81.getValue().intValue());
            }
        }
        return false;
    }

    private boolean Method2150973(Entity entity) {
        return entity != null && AutoCrystal.Field2811.player.getDistanceSq(entity) <= MathUtil.Method2163857(this.Field85.getValue().floatValue()) && (this.Field153.getValue() == IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.NONE || this.Field153.getValue() == IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.PLACE || AutoCrystal.Field2811.player.canEntityBeSeen(entity) || !AutoCrystal.Field2811.player.canEntityBeSeen(entity) && AutoCrystal.Field2811.player.getDistanceSq(entity) <= MathUtil.Method2163857(this.Field86.getValue().floatValue()));
    }

    private boolean Method2150974(EntityPlayer entityPlayer, BlockPos blockPos) {
        if (this.Field182.getValue().booleanValue()) {
            BlockPos blockPos2 = new BlockPos(entityPlayer.getPositionVector());
            for (EnumFacing enumFacing : EnumFacing.values()) {
                if (enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP || !blockPos.equals((Object) blockPos2.down().offset(enumFacing)))
                    continue;
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean Method2150975(IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll) {
        return iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150934() >= this.Field112.getValue().floatValue() || AutoCrystal.Field2811.world.isAirBlock(iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150932()) || !AutoCrystal.Field2811.world.isAirBlock(iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150932().offset(EnumFacing.UP));
    }

    private void Method2150976(Color color, Color color2, IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll) {
        float f = (this.Field112.getValue().floatValue() - iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150934()) / this.Field112.getValue().floatValue();
        RenderUtil.Method2163909(new AxisAlignedBB(iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150932()), color, color2, this.Field128.getValue().floatValue(), this.Field123.getValue(), this.Field118.getValue(), this.Field117.getValue(), this.Field108.getValue() != false ? f : 1.0f, this.Field109.getValue() != false ? f : 1.0f, this.Field110.getValue() != false ? f : 1.0f);
        iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150935(iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150934() + 50.0f);
    }

    private boolean Method2150977(IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll) {
        return iIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Method2150932().equals((Object) this.Field198);
    }

    private boolean Method2150978(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE && this.Field186.getValue() != false;
    }

    private boolean Method2150979(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE;
    }

    private boolean Method2150970(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE;
    }

    private boolean Method2150981(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150982(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field144.getValue() != ACRotate.OFF && this.Field163.getValue() == 2;
    }

    private boolean Method2150983(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150984(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150985(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150986(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150987(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150988(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150989(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && this.Field175.getValue() != false;
    }

    private boolean Method2150980(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE;
    }

    private boolean Method2150991(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE;
    }

    private boolean Method2150992(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.BREAK;
    }

    private boolean Method2150993(Object object) {
        return this.Field66.getValue() == ACSettings.Development && this.Field171.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE;
    }

    private boolean Method2150994(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150995(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150996(Object object) {
        return this.Field66.getValue() == ACSettings.Development && (this.Field168.getValue() == ACSwing.Place || this.Field168.getValue() == ACSwing.Both);
    }

    private boolean Method2150997(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150998(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150999(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150990(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150901(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150902(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150903(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && (this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL || this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAK) && this.Field93.getValue() != false;
    }

    private boolean Method2150904(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && (this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL || this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAK) && this.Field137.getValue() != IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.DAMAGE;
    }

    private boolean Method2150905(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && (this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ALL || this.Field159.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.BREAK);
    }

    private boolean Method2150906(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150907(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150908(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150909(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150900(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150011(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150012(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150013(Object object) {
        return this.Field66.getValue() == ACSettings.Development;
    }

    private boolean Method2150014(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150015(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field137.getValue() != IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.DAMAGE;
    }

    private boolean Method2150016(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150017(Integer n2) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field144.getValue() != ACRotate.OFF && this.Field146.getValue() == ACYaw.Semi;
    }

    private boolean Method2150018(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field144.getValue() != ACRotate.OFF && this.Field146.getValue() == ACYaw.Semi;
    }

    private boolean Method2150019(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field144.getValue() != ACRotate.OFF;
    }

    private boolean Method2150010(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150021(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150022(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field139.getValue() != ACAutoSwitch.None && this.Field139.getValue() != ACAutoSwitch.Spoof;
    }

    private boolean Method2150023(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field139.getValue() != ACAutoSwitch.None && this.Field139.getValue() != ACAutoSwitch.Spoof;
    }

    private boolean Method2150024(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field139.getValue() == ACAutoSwitch.Toggle;
    }

    private boolean Method2150025(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150026(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150027(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150028(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150029(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150020(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150031(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150032(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150033(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150034(Object object) {
        return this.Field66.getValue() == ACSettings.Misc && this.Field130.getValue() != false;
    }

    private boolean Method2150035(Object object) {
        return this.Field66.getValue() == ACSettings.Misc;
    }

    private boolean Method2150036(Object object) {
        return this.Field66.getValue() == ACSettings.Render;
    }

    private boolean Method2150037(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field123.getValue() != false;
    }

    private boolean Method2150038(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field123.getValue() != false;
    }

    private boolean Method2150039(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field123.getValue() != false;
    }

    private boolean Method2150030(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field123.getValue() != false;
    }

    private boolean Method2150041(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field123.getValue() != false;
    }

    private boolean Method2150042(Object object) {
        return this.Field66.getValue() == ACSettings.Render;
    }

    private boolean Method2150043(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field118.getValue() != false;
    }

    private boolean Method2150044(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field118.getValue() != false;
    }

    private boolean Method2150045(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field118.getValue() != false;
    }

    private boolean Method2150046(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field118.getValue() != false;
    }

    private boolean Method2150047(Object object) {
        return this.Field66.getValue() == ACSettings.Render;
    }

    private boolean Method2150048(Object object) {
        return this.Field66.getValue() == ACSettings.Render;
    }

    private boolean Method2150049(Float f) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.GLIDE;
    }

    private boolean Method2150040(Float f) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.GLIDE;
    }

    private boolean Method2150051(Float f) {
        return this.Field66.getValue() == ACSettings.Render && (this.Field105.getValue() == ACRenderMode.STATIC || this.Field105.getValue() == ACRenderMode.GLIDE);
    }

    private boolean Method2150052(Integer n2) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.FADE;
    }

    private boolean Method2150053(Float f) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.FADE;
    }

    private boolean Method2150054(Boolean bl) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.FADE;
    }

    private boolean Method2150055(Boolean bl) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.FADE;
    }

    private boolean Method2150056(Boolean bl) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.FADE;
    }

    private boolean Method2150057(Boolean bl) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.FADE;
    }

    private boolean Method2150058(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.NEWRAINBOW;
    }

    private boolean Method2150059(Object object) {
        return this.Field66.getValue() == ACSettings.Render && this.Field105.getValue() == ACRenderMode.NEWRAINBOW;
    }

    private boolean Method2150050(ACRenderMode aCRenderMode) {
        return this.Field66.getValue() == ACSettings.Render;
    }

    private boolean Method2150061(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150062(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field93.getValue() != false;
    }

    private boolean Method2150063(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field93.getValue() != false;
    }

    private boolean Method2150064(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150065(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150066(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field98.getValue() != false;
    }

    private boolean Method2150067(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150068(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field93.getValue() != false;
    }

    private boolean Method2150069(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field93.getValue() != false && this.Field94.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.PREDICT;
    }

    private boolean Method2150060(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field93.getValue() != false;
    }

    private boolean Method2150071(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field93.getValue() != false;
    }

    private boolean Method2150072(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150073(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field89.getValue() != false;
    }

    private boolean Method2150074(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field89.getValue() != false;
    }

    private boolean Method2150075(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field89.getValue() != false;
    }

    private boolean Method2150076(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150077(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150078(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150079(Object object) {
        return this.Field66.getValue() == ACSettings.Break && this.Field153.getValue() != IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.NONE && this.Field153.getValue() != IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.PLACE;
    }

    private boolean Method2150070(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150081(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150082(Object object) {
        return this.Field66.getValue() == ACSettings.Break;
    }

    private boolean Method2150083(Object object) {
        return this.Field66.getValue() == ACSettings.Place && this.Field78.getValue() != false && this.Field137.getValue() == IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.DAMAGE;
    }

    private boolean Method2150084(Object object) {
        return this.Field66.getValue() == ACSettings.Place && this.Field78.getValue() != false;
    }

    private boolean Method2150085(Object object) {
        return this.Field66.getValue() == ACSettings.Place && this.Field78.getValue() != false;
    }

    private boolean Method2150086(Object object) {
        return this.Field66.getValue() == ACSettings.Place && this.Field78.getValue() != false;
    }

    private boolean Method2150087(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150088(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150089(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150080(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150091(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150092(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150093(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150094(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150095(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150096(Object object) {
        return this.Field66.getValue() == ACSettings.Place && this.Field153.getValue() != IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.NONE && this.Field153.getValue() != IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.BREAK;
    }

    private boolean Method2150097(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    private boolean Method2150098(Object object) {
        return this.Field66.getValue() == ACSettings.Place;
    }

    public static enum IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll {
        NONE,
        BREAK,
        PREDICT;

    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        PLACE,
        BREAK,
        ALL;

    }

    public static enum IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll {
        NONE,
        POOL,
        SOUND,
        WHILE;

    }

    public static enum IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll {
        NONE,
        PLACE,
        BREAK,
        FULL;

    }

    public static enum IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl {
        ALWAYS,
        BREAKSLOT,
        CALC;

    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        BREAKPLACE,
        PLACEBREAK;

    }

    public static enum IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll {
        CLOSEST,
        UNSAFE,
        DAMAGE;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        NONE,
        PLACE,
        BREAK;

    }

    public static class IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
        private final BlockPos Field586;
        private final boolean Field587;
        private final boolean Field588;
        private final boolean Field589;
        private final boolean Field590;

        public IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            this.Field586 = blockPos;
            this.Field587 = bl;
            this.Field588 = bl2;
            this.Field589 = bl3;
            this.Field590 = bl4;
        }

        public void Method2150920() {
            BlockUtil.Method2162838(this.Field586, this.Field587 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field588, this.Field589, this.Field590);
        }
    }

    private static class IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll
            implements Runnable {
        private static IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll Field3106;
        private AutoCrystal Field3107;

        private IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll() {
        }

        public static IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll Method2150931(AutoCrystal autoCrystal) {
            if (Field3106 == null) {
                Field3106 = new IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll();
                IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.Field3106.Field3107 = autoCrystal;
            }
            return Field3106;
        }

        @Override
        public void run() {
            if (this.Field3107.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.WHILE) {
                while (this.Field3107.Method2150386() && this.Field3107.Field184.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.WHILE) {
                    while (AliceMain.Field762.Method2150135()) {
                    }
                    if (AutoCrystal.Method2150099(this.Field3107).get()) {
                        AutoCrystal.Method2150099(this.Field3107).set(false);
                        AutoCrystal.Method2150090(this.Field3107).Method2164750();
                        AutoCrystal.Method2150001(this.Field3107).interrupt();
                        break;
                    }
                    AutoCrystal.Method2150002(this.Field3107).set(true);
                    AliceMain.Field777.Method2150293();
                    this.Field3107.Method2150954();
                    AutoCrystal.Method2150002(this.Field3107).set(false);
                    try {
                        Thread.sleep(this.Field3107.Field185.getValue().intValue());
                    } catch (InterruptedException interruptedException) {
                        AutoCrystal.Method2150001(this.Field3107).interrupt();
                        interruptedException.printStackTrace();
                    }
                }
            } else if (this.Field3107.Field184.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.NONE && this.Field3107.Method2150386()) {
                while (AliceMain.Field762.Method2150135()) {
                }
                AutoCrystal.Method2150002(this.Field3107).set(true);
                AliceMain.Field777.Method2150293();
                this.Field3107.Method2150954();
                AutoCrystal.Method2150002(this.Field3107).set(false);
            }
        }
    }

    private class IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll {
        final AutoCrystal Field2331;
        private BlockPos Field2329;
        private float Field2330;

        public IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll(AutoCrystal autoCrystal, BlockPos blockPos, float f) {
            this.Field2331 = autoCrystal;
            this.Field2329 = blockPos;
            this.Field2330 = f;
        }

        public BlockPos Method2150932() {
            return this.Field2329;
        }

        public void Method2150933(BlockPos blockPos) {
            this.Field2329 = blockPos;
        }

        public float Method2150934() {
            return this.Field2330;
        }

        public void Method2150935(float f) {
            this.Field2330 = f;
        }
    }
}

