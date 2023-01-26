

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
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$Phase
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Announcer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
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
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AliceAura
        extends Module {
    public static final String Field4193;
    private static final ResourceLocation Field4056 = new ResourceLocation("textures/crystal.png");
    public static List<String> Field4194;
    private static AliceAura Field4054 = new AliceAura();
    private static float Field4185;

    static {
        Field4193 = ModuleManager.Field3973 + Announcer.Field4039 + "bin.com/raw/RDaJDTX9";
        Field4194 = new ArrayList<String>();
    }

    public final Timer Field4156 = new Timer();
    public final Timer Field4157 = new Timer();
    public final Timer Field4158 = new Timer();
    public final Timer Field4161 = new Timer();
    public final Timer Field4163 = new Timer();
    public final ConcurrentHashMap<BlockPos, Long> Field4165 = new ConcurrentHashMap();
    public final ConcurrentHashMap<Integer, Long> Field4166 = new ConcurrentHashMap();
    public final Map<EntityPlayer, Timer> Field4167 = new ConcurrentHashMap<EntityPlayer, Timer>();
    public final List<BlockPos> Field4168 = new CopyOnWriteArrayList<BlockPos>();
    public final Timer Field4170 = new Timer();
    public final Timer Field4171 = new Timer();
    public final Timer Field4173 = new Timer();
    private final Setting<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll> Field4055 = this.Method2150366(new Setting<IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll>("Page", IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General));
    public final Setting<Bind> Field4101 = this.Method2150366(new Setting<Bind>("Faceplace", new Bind(-1), this::Method2150864));
    private final Setting<Boolean> Field4102 = this.Method2150366(new Setting<Boolean>("ArmorBreaker", Boolean.valueOf(true), this::Method2150863));
    private final Setting<Float> Field4103 = this.Method2150366(new Setting<Float>("ArmorDepletion", Float.valueOf(0.9f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2150862));
    private final Setting<Float> Field4135 = this.Method2150366(new Setting<Object>("SlowForcePlaceMin", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(10.0f), this::Method2150820));
    private final Timer Field4175 = new Timer();
    private final List<IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll> Field4192 = new ArrayList<IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll>();
    public Setting<Boolean> Field4057 = this.Method2150366(new Setting<Boolean>("NoMining", Boolean.valueOf(false), this::Method2150808));
    public Setting<Boolean> Field4058 = this.Method2150366(new Setting<Boolean>("NoGapping", Boolean.valueOf(false), this::Method2150807));
    public Setting<Boolean> Field4059 = this.Method2150366(new Setting<Boolean>("RightClickGap", Boolean.FALSE, this::Method2150806));
    public Setting<IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll> Field4060 = this.Method2150366(new Setting<IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll>("Timing", IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.NORMAL, this::Method2150805));
    public Setting<Boolean> Field4061 = this.Method2150366(new Setting<Boolean>("Inhibit", Boolean.valueOf(false), this::Method2150804));
    public Setting<Boolean> Field4062 = this.Method2150366(new Setting<Boolean>("Limit", Boolean.valueOf(true), this::Method2150803));
    public Setting<IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll> Field4063 = this.Method2150366(new Setting<IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll>("Rotate", IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.TRACK, this::Method2150802));
    public Setting<IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll> Field4064 = this.Method2150366(new Setting<IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll>("YawStep", IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll.OFF, this::Method2150801));
    public Setting<Float> Field4065 = this.Method2150366(new Setting<Float>("YawAngle", Float.valueOf(0.3f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2150890));
    public Setting<Integer> Field4066 = this.Method2150366(new Setting<Integer>("YawTicks", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(5), this::Method2150899));
    public Setting<Boolean> Field4067 = this.Method2150366(new Setting<Boolean>("StrictDirection", Boolean.valueOf(true), this::Method2150898));
    public Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field4068 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("SwingHand", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Normal, this::Method2150897));
    public Setting<IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl> Field4069 = this.Method2150366(new Setting<IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl>("Sync", IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.MERGE, this::Method2150896));
    public Setting<Float> Field4070 = this.Method2150366(new Setting<Float>("MergeOffset", Float.valueOf(7.0f), Float.valueOf(0.0f), Float.valueOf(8.0f), this::Method2150895));
    public float Field4189 = this.Field4070.getValue().floatValue() / 10.0f;
    public Setting<Float> Field4071 = this.Method2150366(new Setting<Float>("EnemyRange", Float.valueOf(8.0f), Float.valueOf(4.0f), Float.valueOf(15.0f), this::Method2150894));
    public Setting<Float> Field4072 = this.Method2150366(new Setting<Float>("CrystalRange", Float.valueOf(6.0f), Float.valueOf(2.0f), Float.valueOf(12.0f), this::Method2150893));
    public Setting<Float> Field4073 = this.Method2150366(new Setting<Float>("DisableHealth", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150892));
    public Setting<Float> Field4074 = this.Method2150366(new Setting<Float>("PlaceRange", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(6.0f), this::Method2150891));
    public Setting<Float> Field4075 = this.Method2150366(new Setting<Float>("PlaceWallsRange", Float.valueOf(3.0f), Float.valueOf(1.0f), Float.valueOf(6.0f), this::Method2150880));
    public Setting<Integer> Field4076 = this.Method2150366(new Setting<Object>("PlaceDelay", Integer.valueOf(30), Integer.valueOf(0), Integer.valueOf(500), this::Method2150889));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field4077 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("AutoSwap", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.OFF, this::Method2150888));
    public Setting<Float> Field4078 = this.Method2150366(new Setting<Float>("SwapDelay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150887));
    public Setting<Boolean> Field4079 = this.Method2150366(new Setting<Boolean>("PlacementsCheck", Boolean.valueOf(true), this::Method2150886));
    public Setting<IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll> Field4080 = this.Method2150366(new Setting<IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll>("Interact", IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.NORMAL, this::Method2150885));
    public Setting<Boolean> Field4081 = this.Method2150366(new Setting<Boolean>("1.13+ Place", Boolean.valueOf(false), this::Method2150884));
    public Setting<Boolean> Field4082 = this.Method2150366(new Setting<Boolean>("PlaceInLiquids", Boolean.valueOf(false), this::Method2150883));
    public Setting<Boolean> Field4083 = this.Method2150366(new Setting<Boolean>("PlaceInFire", Boolean.valueOf(false), this::Method2150882));
    public Setting<Float> Field4084 = this.Method2150366(new Setting<Float>("BreakRange", Float.valueOf(4.3f), Float.valueOf(1.0f), Float.valueOf(6.0f), this::Method2150881));
    public Setting<Float> Field4085 = this.Method2150366(new Setting<Float>("BreakWalls", Float.valueOf(3.0f), Float.valueOf(1.0f), Float.valueOf(6.0f), this::Method2150870));
    public Setting<Integer> Field4086 = this.Method2150366(new Setting<Object>("BreakDelay", Integer.valueOf(30), Integer.valueOf(0), Integer.valueOf(500), this::Method2150879));
    public Setting<Integer> Field4087 = this.Method2150366(new Setting<Integer>("AttackFactor", Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(20), this::Method2150878));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field4088 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("AntiWeakness", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF, this::Method2150877));
    public Setting<Boolean> Field4089 = this.Method2150366(new Setting<Boolean>("Collision", Boolean.valueOf(false), this::Method2150876));
    public Setting<Integer> Field4090 = this.Method2150366(new Setting<Integer>("PredictTicks", Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(10), this::Method2150875));
    public Setting<Boolean> Field4091 = this.Method2150366(new Setting<Boolean>("TerrainTrace", Boolean.TRUE, this::Method2150874));
    public Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll> Field4092 = this.Method2150366(new Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll>("Confirm", IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.OFF, this::Method2150873));
    public Setting<Integer> Field4093 = this.Method2150366(new Setting<Integer>("TicksExisted", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(20), this::Method2150872));
    public Setting<IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll> Field4094 = this.Method2150366(new Setting<IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll>("Target", IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll.ALL, this::Method2150871));
    public Setting<Float> Field4095 = this.Method2150366(new Setting<Float>("DamageBalance", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2150860));
    public Setting<Float> Field4096 = this.Method2150366(new Setting<Float>("Compromise", Float.valueOf(1.0f), Float.valueOf(0.05f), Float.valueOf(2.0f), this::Method2150869));
    public Setting<Float> Field4097 = this.Method2150366(new Setting<Float>("MinDamage", Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2150868));
    public Setting<Float> Field4098 = this.Method2150366(new Setting<Float>("MaxSelfDmg", Float.valueOf(12.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2150867));
    public Setting<Float> Field4099 = this.Method2150366(new Setting<Float>("SuicideHealth", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2150866));
    public Setting<Float> Field4100 = this.Method2150366(new Setting<Float>("FaceplaceHealth", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2150865));
    public Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl> Field4104 = this.Method2150366(new Setting<IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl>("RenderMode", IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.STATIC, this::Method2150861));
    public Setting<Float> Field4106 = this.Method2150366(new Setting<Object>("Brightness ", Float.valueOf(150.0f), Float.valueOf(1.0f), Float.valueOf(255.0f), this::Method2150859));
    public Setting<Float> Field4107 = this.Method2150366(new Setting<Object>("Saturation", Float.valueOf(150.0f), Float.valueOf(1.0f), Float.valueOf(255.0f), this::Method2150858));
    private final Setting<Boolean> Field4108 = this.Method2150366(new Setting<Boolean>("Fade", Boolean.valueOf(true), this::Method2150857));
    private final Setting<Boolean> Field4109 = this.Method2150366(new Setting<Boolean>("Shrink", Boolean.valueOf(false), this::Method2150856));
    private final Setting<Boolean> Field4110 = this.Method2150366(new Setting<Boolean>("Slab", Boolean.valueOf(false), this::Method2150855));
    private final Setting<Float> Field4111 = this.Method2150366(new Setting<Float>("Duration", Float.valueOf(1500.0f), Float.valueOf(0.0f), Float.valueOf(5000.0f), this::Method2150854));
    private final Setting<Integer> Field4112 = this.Method2150366(new Setting<Integer>("MaxPositions", Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(30), this::Method2150853));
    private final Setting<Float> Field4113 = this.Method2150366(new Setting<Float>("SlabDepth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2150852));
    private final Setting<Float> Field4114 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(1200.0f), Float.valueOf(0.0f), Float.valueOf(1500.0f), this::Method2150851));
    private final Setting<Float> Field4115 = this.Method2150366(new Setting<Float>("Deceleration", Float.valueOf(0.8f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2150840));
    public Setting<Integer> Field4105 = this.Method2150366(new Setting<Integer>("RenderTimer", Integer.valueOf(300), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150850));
    public Setting<Boolean> Field4116 = this.Method2150366(new Setting<Object>("ColorSync", Boolean.valueOf(true), this::Method2150849));
    public Setting<Boolean> Field4117 = this.Method2150366(new Setting<Object>("Box", Boolean.valueOf(true), this::Method2150848));
    private final Setting<Integer> Field4118 = this.Method2150366(new Setting<Object>("BoxRed", Integer.valueOf(64), Integer.valueOf(0), Integer.valueOf(255), this::Method2150847));
    private final Setting<Integer> Field4119 = this.Method2150366(new Setting<Object>("BoxGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150846));
    private final Setting<Integer> Field4120 = this.Method2150366(new Setting<Object>("BoxBlue", Integer.valueOf(145), Integer.valueOf(0), Integer.valueOf(255), this::Method2150845));
    private final Setting<Integer> Field4121 = this.Method2150366(new Setting<Object>("BoxAlpha", Integer.valueOf(105), Integer.valueOf(0), Integer.valueOf(255), this::Method2150844));
    public Setting<Boolean> Field4122 = this.Method2150366(new Setting<Object>("Outline", Boolean.valueOf(true), this::Method2150843));
    private final Setting<Integer> Field4123 = this.Method2150366(new Setting<Object>("OutlineRed", Integer.valueOf(58), Integer.valueOf(0), Integer.valueOf(255), this::Method2150842));
    private final Setting<Integer> Field4124 = this.Method2150366(new Setting<Object>("OutlineGreen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2150841));
    private final Setting<Integer> Field4125 = this.Method2150366(new Setting<Object>("OutlineBlue", Integer.valueOf(145), Integer.valueOf(0), Integer.valueOf(255), this::Method2150830));
    private final Setting<Integer> Field4126 = this.Method2150366(new Setting<Object>("OutlineAlpha", Integer.valueOf(111), Integer.valueOf(0), Integer.valueOf(255), this::Method2150839));
    private final Setting<Float> Field4127 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.8f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2150838));
    public Setting<Boolean> Field4128 = this.Method2150366(new Setting<Object>("RenderDmg", Boolean.valueOf(true), this::Method2150837));
    public Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll> Field4129 = this.Method2150366(new Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll>("HUDInfo", IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.New, this::Method2150836));
    public Setting<Boolean> Field4130 = this.Method2150366(new Setting<Boolean>("FastMode", Boolean.valueOf(false), this::Method2150835));
    public Setting<Boolean> Field4131 = this.Method2150366(new Setting<Boolean>("SlowFacePlacePreset", Boolean.valueOf(false), this::Method2150834));
    public Setting<Boolean> Field4132 = this.Method2150366(new Setting<Boolean>("NoSlowFacePlacePreset", Boolean.valueOf(false), this::Method2150833));
    public Setting<Boolean> Field4133 = this.Method2150366(new Setting<Boolean>("SlowForcePlace", Boolean.valueOf(false), this::Method2150832));
    public Setting<Boolean> Field4136 = this.Method2150366(new Setting<Object>("AntiTotem", Boolean.FALSE, this::Method2150829));
    public Setting<Double> Field4137 = this.Method2150366(new Setting<Object>("PopHealth", Double.valueOf(2.0), Double.valueOf(0.0), Double.valueOf(3.0), this::Method2150828));
    public Setting<Float> Field4138 = this.Method2150366(new Setting<Object>("PopDamage", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this::Method2150827));
    public Setting<Integer> Field4139 = this.Method2150366(new Setting<Object>("PopTime", Integer.valueOf(500), Integer.valueOf(0), Integer.valueOf(1000), this::Method2150826));
    public Setting<Boolean> Field4140 = this.Method2150366(new Setting<Boolean>("Debug", Boolean.valueOf(false), this::Method2150825));
    public Setting<Boolean> Field4141 = this.Method2150366(new Setting<Boolean>("handleSequential", Boolean.valueOf(false), this::Method2150824));
    public Setting<Boolean> Field4142 = this.Method2150366(new Setting<Boolean>("breakcrystal", Boolean.valueOf(false), this::Method2150823));
    public Setting<Boolean> Field4143 = this.Method2150366(new Setting<Boolean>("placeCrystal", Boolean.valueOf(false), this::Method2150822));
    public Setting<Boolean> Field4144 = this.Method2150366(new Setting<Boolean>("Null Break Crystal", Boolean.valueOf(false), this::Method2150821));
    public Setting<Boolean> Field4145 = this.Method2150366(new Setting<Boolean>("(MergeSync)", Boolean.valueOf(false), this::Method2150810));
    public Setting<Boolean> Field4146 = this.Method2150366(new Setting<Boolean>("DoInstant", Boolean.valueOf(false), this::Method2150819));
    public Vec3d Field4148 = null;
    public float[] Field4149 = new float[]{0.0f, 0.0f};
    public Timer Field4150 = new Timer();
    public BlockPos Field4159;
    public float Field4160 = 0.0f;
    public BlockPos Field4162;
    public boolean Field4164 = false;
    public AtomicBoolean Field4169 = new AtomicBoolean(false);
    public BlockPos Field4172 = null;
    public EntityEnderCrystal Field4174 = null;
    public EntityPlayer Field4180;
    public Timer Field4181 = new Timer();
    public int Field4187 = -1;
    public int Field4188 = -1;
    private Setting<Integer> Field4134 = this.Method2150366(new Setting<Object>("ForcePlaceDelay", Integer.valueOf(450), Integer.valueOf(200), Integer.valueOf(1000), this::Method2150831));
    private float Field4147;
    private EntityEnderCrystal Field4151;
    private BlockPos Field4152;
    private BlockPos Field4153 = null;
    private EnumFacing Field4154;
    private RayTraceResult Field4155;
    private Vec3d Field4176 = null;
    private Thread Field4177;
    private AtomicBoolean Field4178 = new AtomicBoolean(false);
    private AtomicBoolean Field4179 = new AtomicBoolean(false);
    private Timer Field4182 = new Timer();
    private int Field4183;
    private boolean Field4184 = false;
    private float Field4186 = 0.0f;
    private BlockPos Field4190;
    private AxisAlignedBB Field4191;

    public AliceAura() {
        super("AutoCrystal", "Best AutoCrystal", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        this.Method2150752();
    }

    public static AliceAura Method2150751() {
        if (Field4054 == null) {
            Field4054 = new AliceAura();
        }
        return Field4054;
    }

    public static List<BlockPos> Method2150785(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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

    public static void Method2150786(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double) ((double) f - ((IRenderManager) Field2811.getRenderManager()).getRenderPosX()), (double) ((double) f2 - ((IRenderManager) Field2811.getRenderManager()).getRenderPosY()), (double) ((double) f3 - ((IRenderManager) Field2811.getRenderManager()).getRenderPosZ()));
        GlStateManager.glNormal3f((float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) (-Minecraft.getMinecraft().player.rotationYaw), (float) 0.0f, (float) 1.0f, (float) 0.0f);
        GlStateManager.rotate((float) Minecraft.getMinecraft().player.rotationPitch, (float) (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float) 0.0f, (float) 0.0f);
        GlStateManager.scale((float) (-f4), (float) (-f4), (float) f4);
    }

    public static void Method2150787(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        AliceAura.Method2150786(f, f2, f3);
        int n2 = (int) entityPlayer.getDistance((double) f, (double) f2, (double) f3);
        float f5 = (float) n2 / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float) f5, (float) f5, (float) f5);
    }

    public static void Method2150780() {
        Field4194 = AliceAura.Method2150791();
        boolean bl = Field4194.contains(Minecraft.getMinecraft().getSession().getUsername());
        if (bl) {
            AliceMain.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new AliceMain.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll();
            iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.setVisible(false);
            throw new NullPointerException();
        }
    }

    public static List<String> Method2150791() {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String string;
            URL uRL = new URL(Field4193);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
        } catch (Exception exception) {
            // empty catch block
        }
        return arrayList;
    }

    public static void Method2150792() {
        AliceMain.Field756.Method2150180(AliceAura.class).Field4057.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4058.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4059.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4060.setValue(IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4061.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4062.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4063.setValue(IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.OFF);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4064.setValue(IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll.OFF);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4065.setValue(Float.valueOf(0.3f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4066.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4067.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4069.setValue(IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4070.setValue(Float.valueOf(7.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4071.setValue(Float.valueOf(8.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4072.setValue(Float.valueOf(6.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4073.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4074.setValue(Float.valueOf(6.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4075.setValue(Float.valueOf(3.5f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4076.setValue(10);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4077.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SILENT);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4078.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4079.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4080.setValue(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4081.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4082.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4083.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4084.setValue(Float.valueOf(6.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4085.setValue(Float.valueOf(3.5f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4086.setValue(10);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4087.setValue(3);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4088.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SILENT);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4089.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4090.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4091.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4092.setValue(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.SEMI);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4093.setValue(0);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4094.setValue(IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll.SMART);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4095.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4096.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4097.setValue(Float.valueOf(2.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4098.setValue(Float.valueOf(8.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4099.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4100.setValue(Float.valueOf(10.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4102.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4103.setValue(Float.valueOf(0.9f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4105.setValue(300);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4130.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4131.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4132.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4133.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4134.setValue(450);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4135.setValue(Float.valueOf(2.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4136.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4137.setValue(2.0);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4138.setValue(Float.valueOf(4.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4139.setValue(500);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4140.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4141.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4142.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4143.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4144.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4145.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4146.setValue(false);
    }

    public static void Method2150793() {
        AliceMain.Field756.Method2150180(AliceAura.class).Field4057.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4058.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4059.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4060.setValue(IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4061.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4062.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4063.setValue(IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.TRACK);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4064.setValue(IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll.SEMI);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4065.setValue(Float.valueOf(0.4f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4066.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4067.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4069.setValue(IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4070.setValue(Float.valueOf(7.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4071.setValue(Float.valueOf(8.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4072.setValue(Float.valueOf(6.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4073.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4074.setValue(Float.valueOf(5.5f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4075.setValue(Float.valueOf(3.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4076.setValue(60);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4077.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4078.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4079.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4080.setValue(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4081.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4082.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4083.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4084.setValue(Float.valueOf(5.5f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4085.setValue(Float.valueOf(3.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4086.setValue(60);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4087.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4088.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4089.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4090.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4091.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4092.setValue(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.SEMI);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4093.setValue(0);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4094.setValue(IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll.SMART);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4095.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4096.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4097.setValue(Float.valueOf(2.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4098.setValue(Float.valueOf(8.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4099.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4100.setValue(Float.valueOf(20.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4102.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4103.setValue(Float.valueOf(0.9f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4105.setValue(300);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4130.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4131.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4132.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4133.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4134.setValue(450);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4135.setValue(Float.valueOf(2.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4136.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4137.setValue(2.0);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4138.setValue(Float.valueOf(4.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4139.setValue(500);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4140.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4141.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4142.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4143.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4144.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4145.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4146.setValue(false);
    }

    public static void Method2150794() {
        AliceMain.Field756.Method2150180(AliceAura.class).Field4057.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4058.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4059.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4060.setValue(IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4061.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4062.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4063.setValue(IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.TRACK);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4064.setValue(IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll.SEMI);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4065.setValue(Float.valueOf(0.4f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4066.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4067.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4069.setValue(IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4070.setValue(Float.valueOf(7.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4071.setValue(Float.valueOf(8.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4072.setValue(Float.valueOf(6.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4073.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4074.setValue(Float.valueOf(5.5f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4075.setValue(Float.valueOf(3.3f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4076.setValue(30);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4077.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.OFF);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4078.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4079.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4080.setValue(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4081.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4082.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4083.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4084.setValue(Float.valueOf(5.5f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4085.setValue(Float.valueOf(3.3f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4086.setValue(30);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4087.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4088.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORMAL);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4089.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4090.setValue(1);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4091.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4092.setValue(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.SEMI);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4093.setValue(0);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4094.setValue(IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll.SMART);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4095.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4096.setValue(Float.valueOf(1.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4097.setValue(Float.valueOf(2.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4098.setValue(Float.valueOf(8.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4099.setValue(Float.valueOf(0.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4100.setValue(Float.valueOf(20.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4102.setValue(true);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4103.setValue(Float.valueOf(0.9f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4105.setValue(300);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4130.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4131.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4132.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4133.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4134.setValue(450);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4135.setValue(Float.valueOf(2.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4136.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4137.setValue(2.0);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4138.setValue(Float.valueOf(4.0f));
        AliceMain.Field756.Method2150180(AliceAura.class).Field4139.setValue(500);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4140.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4141.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4142.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4143.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4144.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4145.setValue(false);
        AliceMain.Field756.Method2150180(AliceAura.class).Field4146.setValue(false);
    }

    private static Float Method2150795(EntityPlayer entityPlayer) {
        return Float.valueOf(AliceAura.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2150796(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount() < 10.0f;
    }

    private static Float Method2150797(EntityPlayer entityPlayer) {
        return Float.valueOf(AliceAura.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2150798(EntityPlayer entityPlayer) {
        return !BlockUtilSC.Method2162896(new BlockPos((Entity) entityPlayer)) && (AliceAura.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.AIR || AliceAura.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() == Blocks.WEB || AliceAura.Field2811.world.getBlockState(new BlockPos((Entity) entityPlayer)).getBlock() instanceof BlockLiquid);
    }

    private static Float Method2150799(EntityPlayer entityPlayer) {
        return Float.valueOf(AliceAura.Field2811.player.getDistance((Entity) entityPlayer));
    }

    private static boolean Method2150701(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() > 0.0f;
    }

    private static boolean Method2150702(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    private static boolean Method2150703(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    private static boolean Method2150704(EntityPlayer entityPlayer) {
        return entityPlayer != AliceAura.Field2811.player && entityPlayer != Field2811.getRenderViewEntity();
    }

    private static Float Method2150706(Entity entity) {
        return Float.valueOf(AliceAura.Field2811.player.getDistance(entity));
    }

    private static Float Method2150708(Entity entity) {
        return Float.valueOf(AliceAura.Field2811.player.getDistance(entity));
    }

    private static boolean Method2150813(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    static AtomicBoolean Method2150809(AliceAura aliceAura) {
        return aliceAura.Field4178;
    }

    static Thread Method2150800(AliceAura aliceAura) {
        return aliceAura.Field4177;
    }

    static void Method2150911(AliceAura aliceAura) {
        aliceAura.Method2150750();
    }

    @Override
    public void Method2150376() {
        if (this.Field4131.getValue().booleanValue()) {
            this.Field4097.setValue(Float.valueOf(6.5f));
            this.Field4133.setValue(true);
            this.Field4134.setValue(450);
            this.Field4100.setValue(Float.valueOf(6.5f));
            this.Field4131.setValue(false);
        }
        if (this.Field4132.getValue().booleanValue()) {
            this.Field4097.setValue(Float.valueOf(2.0f));
            this.Field4133.setValue(false);
            this.Field4134.setValue(450);
            this.Field4100.setValue(Float.valueOf(10.0f));
            this.Field4132.setValue(false);
        }
    }

    private void Method2150752() {
        Field4054 = this;
    }

    @Override
    public void Method2150373() {
        this.Field4190 = null;
        this.Field4192.clear();
    }

    @Override
    public void Method2150372() {
        this.Field4151 = null;
        this.Field4152 = null;
        this.Field4154 = null;
        this.Field4155 = null;
        this.Field4153 = null;
        this.Field4172 = null;
        this.Field4176 = null;
        this.Field4179.set(false);
        this.Field4148 = null;
        this.Field4150.Method2164750();
        this.Field4164 = false;
        this.Field4184 = false;
        this.Field4167.clear();
        this.Field4187 = -1;
        this.Field4188 = -1;
    }

    @Override
    public String Method2150385() {
        Field4185 = this.Field4181.Method2164759() / 10L;
        if (this.Field4129.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.New && this.Field4180 != null && !this.Field4181.Method2164755(800L)) {
            return this.Field4180.getName() + " , " + (int) Field4185 + "ms , " + (Math.floor(this.Field4160) == (double) this.Field4160 ? Integer.valueOf((int) this.Field4160) : String.format("%.1f", Float.valueOf(this.Field4160))) + "";
        }
        if (this.Field4129.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Future && this.Field4180 != null && !this.Field4181.Method2164755(800L)) {
            return (Math.floor(this.Field4160) == (double) this.Field4160 ? Integer.valueOf((int) this.Field4160) + ".0" : String.format("%.1f", Float.valueOf(this.Field4160))) + "";
        }
        if (!(this.Field4129.getValue() != IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Future || this.Field4180 == null && this.Field4181.Method2164755(800L))) {
            return "0.0";
        }
        if (this.Field4129.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Target && this.Field4180 != null && !this.Field4181.Method2164755(800L)) {
            return this.Field4180.getName() + "";
        }
        return null;
    }

    @SubscribeEvent
    public void Method2150753(TickEvent.ClientTickEvent clientTickEvent) {
        if (clientTickEvent.phase == TickEvent.Phase.START) {
            this.Field4169.set(true);
        } else {
            this.Field4169.set(false);
        }
    }

    @SubscribeEvent
    public void Method2150754(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketEntityStatus sPacketEntityStatus;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSpawnObject) {
            SPacketSpawnObject sPacketSpawnObject = (SPacketSpawnObject) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSpawnObject.getType() == 51) {
                this.Field4165.forEach((arg_0, arg_1) -> this.Method2150818(sPacketSpawnObject, arg_0, arg_1));
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect) {
            SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            if (sPacketSoundEffect.getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
                if (this.Field4174 != null && this.Field4174.getDistance(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ()) < 6.0) {
                    this.Field4174 = null;
                }
                if (this.Field4095.getValue().floatValue() >= 0.5f) {
                    try {
                        this.Field4168.remove((Object) new BlockPos(sPacketSoundEffect.getX(), sPacketSoundEffect.getY() - 1.0, sPacketSoundEffect.getZ()));
                    } catch (ConcurrentModificationException concurrentModificationException) {
                    }
                }
            }
        } else if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketEntityStatus && (sPacketEntityStatus = (SPacketEntityStatus) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getOpCode() == 35 && sPacketEntityStatus.getEntity((World) AliceAura.Field2811.world) instanceof EntityPlayer) {
            this.Field4167.put((EntityPlayer) sPacketEntityStatus.getEntity((World) AliceAura.Field2811.world), new Timer());
        }
    }

    @SubscribeEvent
    public void Method2150755(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        CPacketUseEntity cPacketUseEntity;
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getAction() == CPacketUseEntity.Action.ATTACK && cPacketUseEntity.getEntityFromWorld((World) AliceAura.Field2811.world) instanceof EntityEnderCrystal && this.Field4130.getValue().booleanValue()) {
            Objects.requireNonNull(cPacketUseEntity.getEntityFromWorld((World) AliceAura.Field2811.world)).setDead();
            AliceAura.Field2811.world.removeEntityFromWorld(cPacketUseEntity.entityId);
        }
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (AliceAura.Field2811.world == null || AliceAura.Field2811.player == null) {
            return;
        }
        Color color = new Color(this.Field4118.getValue(), this.Field4119.getValue(), this.Field4120.getValue(), this.Field4121.getValue());
        Color color2 = new Color(this.Field4123.getValue(), this.Field4124.getValue(), this.Field4125.getValue(), this.Field4126.getValue());
        if (this.Field4159 != null) {
            if (this.Field4161.Method2164755(this.Field4105.getValue().intValue())) {
                return;
            }
            AxisAlignedBB axisAlignedBB = null;
            try {
                axisAlignedBB = AliceAura.Field2811.world.getBlockState(this.Field4159).getBoundingBox((IBlockAccess) AliceAura.Field2811.world, this.Field4159).offset(this.Field4159);
            } catch (Exception exception) {
                // empty catch block
            }
            if (axisAlignedBB == null) {
                return;
            }
            try {
                if (this.Field4159 != null) {
                    if (this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE) {
                        this.Field4192.removeIf(this::Method2150817);
                        this.Field4192.add(new IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll(this, this.Field4159, 0.0f));
                    }
                    if (this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.STATIC) {
                        RenderUtil.Method2163909(new AxisAlignedBB(this.Field4159), color, color2, this.Field4127.getValue().floatValue(), this.Field4122.getValue(), this.Field4117.getValue(), this.Field4116.getValue(), 1.0f, 1.0f, this.Field4113.getValue().floatValue());
                    }
                    if (this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.NEWRAINBOW) {
                        AxisAlignedBB axisAlignedBB2 = AliceAura.Field2811.world.getBlockState(this.Field4159).getSelectedBoundingBox((World) AliceAura.Field2811.world, this.Field4159);
                        Vec3d vec3d = EntityUtil.Method2163492((Entity) RenderUtil.Field2811.player, Field2811.getRenderPartialTicks());
                        for (EnumFacing enumFacing : EnumFacing.values()) {
                            RenderUtil.Method2163975(axisAlignedBB2.grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), enumFacing, new Color(ColorUtil2.Method2164315(50).getRed(), ColorUtil2.Method2164315(50).getGreen(), ColorUtil2.Method2164315(50).getBlue(), 127), ColorUtil2.Method2164208(new Color(ColorUtil2.Method2164315(50).getRed(), ColorUtil2.Method2164315(50).getGreen(), ColorUtil2.Method2164315(50).getBlue(), 127)), 2.0);
                        }
                        RenderUtil.Method2163999(axisAlignedBB2.grow((double) 0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), ColorUtil2.Method2164208(new Color(ColorUtil2.Method2164315(50).getRed(), ColorUtil2.Method2164315(50).getGreen(), ColorUtil2.Method2164315(50).getBlue(), 255)), new Color(ColorUtil2.Method2164315(50).getRed(), ColorUtil2.Method2164315(50).getGreen(), ColorUtil2.Method2164315(50).getBlue(), 255), 2.0f);
                    }
                    if (this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.GLIDE) {
                        if (this.Field4190 == null || AliceAura.Field2811.player.getDistance(this.Field4191.minX, this.Field4191.minY, this.Field4191.minZ) > 8.0) {
                            this.Field4190 = this.Field4159;
                            this.Field4191 = new AxisAlignedBB(this.Field4159);
                            this.Field4147 = 0.0f;
                        }
                        if (!this.Field4190.equals((Object) this.Field4159)) {
                            this.Field4190 = this.Field4159;
                            this.Field4147 = 0.0f;
                        }
                        double d = (double) this.Field4159.getX() - this.Field4191.minX;
                        double d2 = (double) this.Field4159.getY() - this.Field4191.minY;
                        double d3 = (double) this.Field4159.getZ() - this.Field4191.minZ;
                        float f = this.Field4147 / this.Field4114.getValue().floatValue() * this.Field4115.getValue().floatValue();
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        this.Field4191 = this.Field4191.offset(d * (double) f, d2 * (double) f, d3 * (double) f);
                        RenderUtil.Method2163909(this.Field4191, color, color2, this.Field4127.getValue().floatValue(), this.Field4122.getValue(), this.Field4117.getValue(), this.Field4116.getValue(), 1.0f, 1.0f, this.Field4113.getValue().floatValue());
                        if (this.Field4128.getValue().booleanValue()) {
                            RenderUtil.Method2163023(this.Field4191.offset(0.0, (double) (1.0f - this.Field4113.getValue().floatValue() / 2.0f) - 0.4, 0.0), (Math.floor(this.Field4160) == (double) this.Field4160 ? Integer.valueOf((int) this.Field4160) : String.format("%.1f", Float.valueOf(this.Field4160))) + "");
                        }
                        this.Field4147 = this.Field4191.equals((Object) new AxisAlignedBB(this.Field4159)) ? 0.0f : (this.Field4147 += 50.0f);
                    }
                }
                if (this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE) {
                    this.Field4192.forEach(arg_0 -> this.Method2150816(color, color2, arg_0));
                    this.Field4192.removeIf(this::Method2150815);
                    if (this.Field4192.size() > this.Field4112.getValue()) {
                        this.Field4192.remove(0);
                    }
                }
                if (this.Field4159 != null && this.Field4128.getValue().booleanValue() && this.Field4104.getValue() != IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.GLIDE) {
                    RenderUtil.Method2163023(new AxisAlignedBB(this.Field4159).offset(0.0, this.Field4104.getValue() != IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE ? (double) (1.0f - this.Field4113.getValue().floatValue() / 2.0f) - 0.4 : 0.1, 0.0), (Math.floor(this.Field4160) == (double) this.Field4160 ? Integer.valueOf((int) this.Field4160) : String.format("%.1f", Float.valueOf(this.Field4160))) + "");
                }
            } catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @SubscribeEvent
    public void Method2150756(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0) {
            this.Field4165.forEach((arg_0, arg_1) -> this.Method2150814(arg_0, arg_1));
            --this.Field4183;
            if (this.Field4176 != null) {
                for (Entity entity : AliceAura.Field2811.world.loadedEntityList) {
                    if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.Field4176.x, this.Field4176.y, this.Field4176.z) <= 6.0))
                        continue;
                    this.Field4166.put(entity.getEntityId(), System.currentTimeMillis());
                }
                this.Field4176 = null;
            }
            if (updateWalkingPlayerEvent.isCanceled()) {
                return;
            }
            this.Field4151 = null;
            this.Field4152 = null;
            this.Field4154 = null;
            this.Field4155 = null;
            this.Field4184 = false;
            this.Method2150758();
            if (this.Field4063.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.OFF && !this.Field4150.Method2164755(650L) && this.Field4148 != null) {
                if (this.Field4063.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.TRACK) {
                    this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
                }
                if (this.Field4065.getValue().floatValue() < 1.0f && this.Field4064.getValue() != IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll.OFF && (this.Field4151 != null || this.Field4064.getValue() == IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll.FULL)) {
                    if (this.Field4183 > 0) {
                        this.Field4149[0] = ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw();
                        this.Field4151 = null;
                        this.Field4152 = null;
                    } else {
                        float f = MathHelper.wrapDegrees((float) (this.Field4149[0] - ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()));
                        if (Math.abs(f) > 180.0f * this.Field4065.getValue().floatValue()) {
                            this.Field4149[0] = ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw() + f * (180.0f * this.Field4065.getValue().floatValue() / Math.abs(f));
                            this.Field4151 = null;
                            this.Field4152 = null;
                            this.Field4183 = this.Field4066.getValue();
                        }
                    }
                }
                SilentRotaionUtil.Method2162907(this.Field4149[0], this.Field4149[1]);
            }
        }
    }

    @SubscribeEvent
    public void Method2150757(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1) {
            if (this.Field4182.Method2164755(this.Field4134.getValue().intValue())) {
                this.Field4182.Method2164750();
            }
            if (this.Field4151 != null) {
                if (this.Method2150763(this.Field4151)) {
                    this.Field4157.Method2164750();
                    this.Field4166.put(this.Field4151.getEntityId(), System.currentTimeMillis());
                    for (Entity entity : AliceAura.Field2811.world.loadedEntityList) {
                        if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(this.Field4151.posX, this.Field4151.posY, this.Field4151.posZ) <= 6.0))
                            continue;
                        this.Field4166.put(entity.getEntityId(), System.currentTimeMillis());
                    }
                    this.Field4151 = null;
                    if (this.Field4144.getValue().booleanValue() && this.Field4151 == null) {
                        Command.Method2159696("postBreakPos Break Pos os Null ");
                    }
                    if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.MERGE) {
                        this.Method2150761();
                    }
                }
            } else if (this.Field4152 != null) {
                if (!this.Method2150762(this.Field4152, this.Field4154)) {
                    this.Field4178.set(false);
                    this.Field4152 = null;
                    return;
                }
                this.Field4156.Method2164750();
                this.Field4152 = null;
            }
        }
    }

    private void Method2150758() {
        if (this.Field4141.getValue().booleanValue()) {
            Command.Method2159696("handleSequential");
        }
        if (AliceAura.Field2811.player.getHealth() + AliceAura.Field2811.player.getAbsorptionAmount() < this.Field4073.getValue().floatValue() || this.Field4058.getValue() != false && AliceAura.Field2811.player.getActiveItemStack().getItem() instanceof ItemFood || this.Field4057.getValue().booleanValue() && AliceAura.Field2811.playerController.getIsHittingBlock() && AliceAura.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
            this.Field4148 = null;
            return;
        }
        if (this.Field4058.getValue().booleanValue() && this.Field4059.getValue().booleanValue() && AliceAura.Field2811.gameSettings.keyBindUseItem.isKeyDown() && AliceAura.Field2811.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) {
            int n2 = -1;
            for (int j = 0; j < 9; ++j) {
                if (AliceAura.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.GOLDEN_APPLE) {
                    continue;
                }
                n2 = j;
                break;
            }
            if (n2 != -1 && n2 != AliceAura.Field2811.player.inventory.currentItem) {
                AliceAura.Field2811.player.inventory.currentItem = n2;
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
                return;
            }
        }
        if (!this.Method2150770() && !(AliceAura.Field2811.player.inventory.getCurrentItem().getItem() instanceof ItemEndCrystal) && this.Field4077.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.OFF) {
            return;
        }
        List<EntityPlayer> list = this.Method2150779();
        EntityEnderCrystal entityEnderCrystal = this.Method2150760(list);
        int n3 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
        if (entityEnderCrystal != null && this.Field4157.Method2164755(this.Field4086.getValue().intValue()) && (entityEnderCrystal.ticksExisted >= this.Field4093.getValue() || this.Field4060.getValue() == IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.NORMAL)) {
            this.Field4151 = entityEnderCrystal;
            this.Method2150775(this.Field4151.posX, this.Field4151.posY, this.Field4151.posZ);
        }
        if (entityEnderCrystal == null && (this.Field4092.getValue() != IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.FULL || this.Field4174 == null || (double) this.Field4174.ticksExisted >= Math.floor(this.Field4093.getValue().intValue())) && (this.Field4069.getValue() != IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT || this.Field4157.Method2164755((long) (this.Field4086.getValue().floatValue() - 50.0f - (float) CrystalUtilSC.Method2162805()))) && this.Field4156.Method2164755(this.Field4076.getValue().intValue()) && (this.Field4060.getValue() == IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.SEQUENTIAL || this.Field4170.Method2164755((long) ((float) this.Field4093.getValue().intValue() * 5.0f)))) {
            BlockPos blockPos;
            if (this.Field4092.getValue() != IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.OFF && this.Field4172 != null && !this.Field4171.Method2164755(n3 + 100) && this.Method2150778(this.Field4172)) {
                this.Field4152 = this.Field4172;
                this.Field4154 = this.Method2150776(this.Field4152);
                this.Field4179.set(false);
                return;
            }
            List<BlockPos> list2 = this.Method2150777();
            if (!list2.isEmpty() && (blockPos = this.Method2150772(list2, list)) != null) {
                this.Field4152 = blockPos;
                this.Field4154 = this.Method2150776(this.Field4152);
            }
        }
        this.Field4179.set(false);
    }

    private double Method2150759(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        return Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
    }

    private void Method2150750() {
        BlockPos blockPos;
        List<BlockPos> list;
        if (this.Field4146.getValue().booleanValue()) {
            Command.Method2159696("Doinstant");
        }
        if (this.Field4092.getValue() != IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.OFF && (this.Field4092.getValue() != IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.FULL || this.Field4174 == null || (double) this.Field4174.ticksExisted >= Math.floor(this.Field4093.getValue().intValue()))) {
            int n2 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
            if (this.Field4172 != null && !this.Field4171.Method2164755(n2 + 100) && this.Method2150778(this.Field4172)) {
                this.Field4152 = this.Field4172;
                this.Field4154 = this.Method2150776(this.Field4152);
                if (this.Field4152 != null) {
                    if (!this.Method2150762(this.Field4152, this.Field4154)) {
                        this.Field4152 = null;
                        return;
                    }
                    this.Field4156.Method2164750();
                    this.Field4152 = null;
                }
                return;
            }
        }
        if (!(list = this.Method2150777()).isEmpty() && (blockPos = this.Method2150772(list, this.Method2150779())) != null) {
            this.Field4152 = blockPos;
            this.Field4154 = this.Method2150776(this.Field4152);
            if (this.Field4152 != null) {
                if (!this.Method2150762(this.Field4152, this.Field4154)) {
                    this.Field4152 = null;
                    return;
                }
                this.Field4156.Method2164750();
                this.Field4152 = null;
            }
        }
    }

    private void Method2150761() {
        if (this.Field4145.getValue().booleanValue()) {
            Command.Method2159696("(Merge)RunningInstantThread");
        }
        if (this.Field4070.getValue().floatValue() == 0.0f) {
            this.Method2150750();
        } else {
            this.Field4178.set(true);
            if (this.Field4177 == null || this.Field4177.isInterrupted() || !this.Field4177.isAlive()) {
                if (this.Field4177 == null) {
                    this.Field4177 = new Thread(IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.Method2150746(this));
                }
                if (this.Field4177 != null && (this.Field4177.isInterrupted() || !this.Field4177.isAlive())) {
                    this.Field4177 = new Thread(IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.Method2150746(this));
                }
                if (this.Field4177 != null && this.Field4177.getState() == Thread.State.NEW) {
                    try {
                        this.Field4177.start();
                    } catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        }
    }

    public boolean Method2150762(BlockPos blockPos, EnumFacing enumFacing) {
        if (blockPos != null) {
            if (this.Field4143.getValue().booleanValue()) {
                Command.Method2159696("placeCrystal");
            }
            if (this.Field4077.getValue() != IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.OFF && !this.Method2150782()) {
                return false;
            }
            if (!this.Method2150770() && AliceAura.Field2811.player.getHeldItemMainhand().getItem() != Items.END_CRYSTAL) {
                if (this.Field4187 != -1) {
                    AliceAura.Field2811.player.inventory.currentItem = this.Field4187;
                    AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4187));
                    this.Field4187 = -1;
                }
                return false;
            }
            if (AliceAura.Field2811.world.getBlockState(blockPos.up()).getBlock() == Blocks.FIRE) {
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos.up(), EnumFacing.DOWN));
                if (this.Field4187 != -1) {
                    AliceAura.Field2811.player.inventory.currentItem = this.Field4187;
                    AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4187));
                    this.Field4187 = -1;
                }
                return true;
            }
            this.Field4164 = true;
            if (this.Field4155 == null) {
                BlockUtilSC.Method2162870(blockPos, AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0), this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
            } else {
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, (float) this.Field4155.hitVec.x, (float) this.Field4155.hitVec.y, (float) this.Field4155.hitVec.z));
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            }
            if (this.Field4184 && this.Field4180 != null) {
                this.Field4167.put(this.Field4180, new Timer());
            }
            this.Field4164 = false;
            this.Field4165.put(blockPos, System.currentTimeMillis());
            if (this.Field4095.getValue().floatValue() >= 0.5f) {
                this.Field4168.add(blockPos);
            }
            if (this.Field4068.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.None) {
                AliceAura.Field2811.player.swingArm(this.Field4068.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.MainHand ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND);
            }
            this.Field4161.Method2164750();
            this.Field4153 = blockPos;
            if (this.Field4187 != -1) {
                AliceAura.Field2811.player.inventory.currentItem = this.Field4187;
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4187));
                this.Field4187 = -1;
            }
            return true;
        }
        return false;
    }

    private boolean Method2150763(EntityEnderCrystal entityEnderCrystal) {
        if (entityEnderCrystal != null) {
            if (this.Field4142.getValue().booleanValue()) {
                Command.Method2159696("BreakCrystal");
            }
            if (this.Field4088.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OFF && AliceAura.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && !(AliceAura.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword) && !this.Method2150783()) {
                return false;
            }
            if (!this.Field4158.Method2164755((long) (this.Field4078.getValue().floatValue() * 100.0f))) {
                return false;
            }
            AliceAura.Field2811.playerController.attackEntity((EntityPlayer) AliceAura.Field2811.player, (Entity) entityEnderCrystal);
            AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            this.Method2150764(this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            if (this.Field4188 != -1 && AliceAura.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword) {
                AliceAura.Field2811.player.inventory.currentItem = this.Field4188;
                AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(this.Field4188));
                this.Field4188 = -1;
            }
            if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.MERGE) {
                this.Field4156.Method2164750();
            }
            if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT) {
                this.Field4179.set(true);
            }
            if (this.Field4068.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.None) {
                AliceAura.Field2811.player.swingArm(this.Field4068.getValue() == IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.MainHand ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND);
            }
            this.Field4173.Method2164750();
            this.Field4174 = entityEnderCrystal;
            this.Field4162 = new BlockPos((Entity) entityEnderCrystal).down();
            this.Field4163.Method2164750();
            return true;
        }
        return false;
    }

    private void Method2150764(EnumHand enumHand) {
        if (this.Field4068.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Normal) {
            return;
        }
        ItemStack itemStack = AliceAura.Field2811.player.getHeldItem(enumHand);
        if (!itemStack.isEmpty() && itemStack.getItem().onEntitySwing((EntityLivingBase) AliceAura.Field2811.player, itemStack)) {
            return;
        }
        if (!AliceAura.Field2811.player.isSwingInProgress || AliceAura.Field2811.player.swingProgressInt >= this.Method2150765((EntityLivingBase) AliceAura.Field2811.player) / 2 || AliceAura.Field2811.player.swingProgressInt < 0) {
            AliceAura.Field2811.player.swingProgressInt = -1;
            AliceAura.Field2811.player.isSwingInProgress = true;
            AliceAura.Field2811.player.swingingHand = enumHand;
        }
    }

    private int Method2150765(EntityLivingBase entityLivingBase) {
        if (entityLivingBase.isPotionActive(MobEffects.HASTE)) {
            return 6 - (1 + entityLivingBase.getActivePotionEffect(MobEffects.HASTE).getAmplifier());
        }
        return entityLivingBase.isPotionActive(MobEffects.MINING_FATIGUE) ? 6 + (1 + entityLivingBase.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2 : 6;
    }

    public EntityEnderCrystal Method2150766() {
        return this.Field4151;
    }

    public BlockPos Method2150767() {
        return this.Field4152;
    }

    private List<Entity> Method2150768() {
        return AliceAura.Field2811.world.loadedEntityList.stream().filter(AliceAura::Method2150813).filter(this::Method2150812).collect(Collectors.toList());
    }

    private boolean Method2150769(EntityEnderCrystal entityEnderCrystal) {
        if (AliceAura.Field2811.player.getPositionEyes(1.0f).distanceTo(entityEnderCrystal.getPositionVector()) > (double) this.Field4084.getValue().floatValue()) {
            return false;
        }
        if (this.Field4166.containsKey(entityEnderCrystal.getEntityId()) && this.Field4062.getValue().booleanValue()) {
            return false;
        }
        if (this.Field4166.containsKey(entityEnderCrystal.getEntityId()) && entityEnderCrystal.ticksExisted > this.Field4093.getValue() + this.Field4087.getValue()) {
            return false;
        }
        return !(CrystalUtilSC.Method2162915(entityEnderCrystal, (Entity) AliceAura.Field2811.player) + this.Field4099.getValue().floatValue() >= AliceAura.Field2811.player.getHealth() + AliceAura.Field2811.player.getAbsorptionAmount());
    }

    private EntityEnderCrystal Method2150760(List<EntityPlayer> list) {
        this.Field4166.forEach((arg_0, arg_1) -> this.Method2150811(arg_0, arg_1));
        if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT && !this.Field4062.getValue().booleanValue() && this.Field4179.get()) {
            return null;
        }
        EntityEnderCrystal entityEnderCrystal = null;
        int n2 = (int) Math.max(100.0f, (float) (CrystalUtilSC.Method2162805() + 50) / 1.0f) + 150;
        if (this.Field4061.getValue().booleanValue() && !this.Field4062.getValue().booleanValue() && !this.Field4173.Method2164755(n2) && this.Field4174 != null && AliceAura.Field2811.world.getEntityByID(this.Field4174.getEntityId()) != null && this.Method2150769(this.Field4174)) {
            entityEnderCrystal = this.Field4174;
            return entityEnderCrystal;
        }
        List<Entity> list2 = this.Method2150768();
        if (list2.isEmpty()) {
            return null;
        }
        if (this.Field4095.getValue().floatValue() >= 1.0f) {
            double d = 0.5;
            for (Entity entity : list2) {
                if (!(entity.getPositionVector().distanceTo(AliceAura.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field4085.getValue().floatValue()) && !CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ))
                    continue;
                EntityEnderCrystal entityEnderCrystal2 = (EntityEnderCrystal) entity;
                double d2 = 0.0;
                for (EntityPlayer entityPlayer : list) {
                    double d3 = CrystalUtilSC.Method2162915(entityEnderCrystal2, (Entity) entityPlayer);
                    d2 += d3;
                }
                double d4 = CrystalUtilSC.Method2162915(entityEnderCrystal2, (Entity) AliceAura.Field2811.player);
                if (d4 > d2 * (double) (this.Field4095.getValue().floatValue() - 0.8f) && !this.Field4168.contains((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ)) || !(d2 > d))
                    continue;
                d = d2;
                entityEnderCrystal = entityEnderCrystal2;
            }
        } else {
            entityEnderCrystal = this.Field4095.getValue().floatValue() >= 0.5f ? (EntityEnderCrystal) list2.stream().filter(this::Method2150700).filter(this::Method2150709).min(Comparator.comparing(AliceAura::Method2150708)).orElse(null) : (EntityEnderCrystal) list2.stream().filter(this::Method2150707).min(Comparator.comparing(AliceAura::Method2150706)).orElse(null);
        }
        return entityEnderCrystal;
    }

    private boolean Method2150771(EntityPlayer entityPlayer) {
        if (!this.Field4102.getValue().booleanValue()) {
            return false;
        }
        for (int j = 3; j >= 0; --j) {
            double d;
            ItemStack itemStack = (ItemStack) entityPlayer.inventory.armorInventory.get(j);
            if (itemStack == null || !((d = itemStack.getItem().getDurabilityForDisplay(itemStack)) > (double) this.Field4103.getValue().floatValue()))
                continue;
            return true;
        }
        return false;
    }

    private BlockPos Method2150772(List<BlockPos> list, List<EntityPlayer> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        float f = 0.5f;
        EntityPlayer entityPlayer = null;
        BlockPos blockPos = null;
        this.Field4184 = false;
        EntityPlayer entityPlayer2 = null;
        for (BlockPos blockPos2 : list) {
            float f2 = CrystalUtilSC.Method2162913(blockPos2, (Entity) AliceAura.Field2811.player);
            if (!((double) f2 + (double) this.Field4099.getValue().floatValue() < (double) (AliceAura.Field2811.player.getHealth() + AliceAura.Field2811.player.getAbsorptionAmount())) || !(f2 <= this.Field4098.getValue().floatValue()))
                continue;
            if (this.Field4094.getValue() != IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll.ALL) {
                entityPlayer2 = list2.get(0);
                if (entityPlayer2.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5) > (double) this.Field4072.getValue().floatValue())
                    continue;
                float f3 = CrystalUtilSC.Method2162913(blockPos2, (Entity) entityPlayer2);
                if (this.Method2150774(entityPlayer2, f3) && (blockPos == null || entityPlayer2.getDistanceSq(blockPos2) < entityPlayer2.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer2;
                    f = f3;
                    blockPos = blockPos2;
                    this.Field4184 = true;
                    continue;
                }
                if (this.Field4184 || !(f3 > f) || !(f3 * this.Field4096.getValue().floatValue() > f2) && !(f3 > entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount()) || f3 < this.Field4097.getValue().floatValue() && entityPlayer2.getHealth() + entityPlayer2.getAbsorptionAmount() > this.Field4100.getValue().floatValue() && !this.Field4101.getValue().isDown() && !this.Method2150773() && !this.Method2150771(entityPlayer2))
                    continue;
                f = f3;
                entityPlayer = entityPlayer2;
                blockPos = blockPos2;
                continue;
            }
            for (EntityPlayer entityPlayer3 : list2) {
                if (entityPlayer3.equals((Object) entityPlayer2) || entityPlayer3.getDistance((double) blockPos2.getX() + 0.5, (double) blockPos2.getY() + 0.5, (double) blockPos2.getZ() + 0.5) > (double) this.Field4072.getValue().floatValue())
                    continue;
                float f4 = CrystalUtilSC.Method2162913(blockPos2, (Entity) entityPlayer3);
                if (this.Method2150774(entityPlayer3, f4) && (blockPos == null || entityPlayer3.getDistanceSq(blockPos2) < entityPlayer3.getDistanceSq(blockPos))) {
                    entityPlayer = entityPlayer3;
                    f = f4;
                    blockPos = blockPos2;
                    this.Field4184 = true;
                    continue;
                }
                if (this.Field4184 || !(f4 > f) || !(f4 * this.Field4096.getValue().floatValue() > f2) && !(f4 > entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount()) || f4 < this.Field4097.getValue().floatValue() && entityPlayer3.getHealth() + entityPlayer3.getAbsorptionAmount() > this.Field4100.getValue().floatValue() && !this.Field4101.getValue().isDown() && !this.Method2150773() && !this.Method2150771(entityPlayer3))
                    continue;
                f = f4;
                entityPlayer = entityPlayer3;
                blockPos = blockPos2;
            }
        }
        if (entityPlayer != null && blockPos != null) {
            this.Field4180 = entityPlayer;
            this.Field4181.Method2164750();
        }
        if (blockPos != null) {
            this.Field4159 = blockPos;
            this.Field4160 = f;
        }
        this.Field4172 = blockPos;
        this.Field4171.Method2164750();
        return blockPos;
    }

    private boolean Method2150773() {
        return this.Field4133.getValue() != false && this.Field4182.Method2164755(this.Field4134.getValue().intValue());
    }

    private boolean Method2150774(EntityPlayer entityPlayer, float f) {
        if (this.Field4136.getValue().booleanValue()) {
            float f2;
            float f3 = EntityUtil.Method2163530((Entity) entityPlayer);
            if ((double) f2 <= this.Field4137.getValue() && (double) f > (double) f3 + 0.5 && f <= this.Field4138.getValue().floatValue()) {
                Timer timer = this.Field4167.get((Object) entityPlayer);
                return timer == null || timer.Method2164755(this.Field4139.getValue().intValue());
            }
        }
        return false;
    }

    public void Method2150775(double d, double d2, double d3) {
        if (this.Field4063.getValue() != IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.OFF) {
            if (this.Field4063.getValue() == IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll.INTERACT && this.Field4148 != null && !this.Field4150.Method2164755(650L)) {
                if (this.Field4148.y < d2 - 0.1) {
                    this.Field4148 = new Vec3d(this.Field4148.x, d2, this.Field4148.z);
                }
                this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
                this.Field4150.Method2164750();
                return;
            }
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d - 1.0, d2, d3 - 1.0, d + 1.0, d2 + 2.0, d3 + 1.0);
            Vec3d vec3d = new Vec3d(AliceAura.Field2811.player.posX, AliceAura.Field2811.player.getEntityBoundingBox().minY + (double) AliceAura.Field2811.player.getEyeHeight(), AliceAura.Field2811.player.posZ);
            double d4 = 0.1;
            double d5 = 0.15;
            double d6 = 0.85;
            if (axisAlignedBB.intersects(AliceAura.Field2811.player.getEntityBoundingBox())) {
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
                        if (this.Field4080.getValue() != IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.VANILLA && !CrystalUtilSC.Method2162890(vec3d3)) {
                            bl2 = false;
                        }
                        if (this.Field4067.getValue().booleanValue()) {
                            if (vec3d2 != null && arrd != null) {
                                if (!bl2 && bl || !(AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d3) < AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d2)))
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
                            if (!bl2 && bl || !(Math.hypot(((arrd2[0] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd2[1] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedPitch())))
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
                this.Field4150.Method2164750();
                this.Field4148 = vec3d2;
                this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
            }
        }
    }

    public EnumFacing Method2150776(BlockPos blockPos) {
        if (blockPos == null || AliceAura.Field2811.player == null) {
            return null;
        }
        EnumFacing enumFacing = null;
        if (this.Field4080.getValue() != IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.VANILLA) {
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
            Vec3d vec3d6 = new Vec3d(AliceAura.Field2811.player.posX, AliceAura.Field2811.player.getEntityBoundingBox().minY + (double) AliceAura.Field2811.player.getEyeHeight(), AliceAura.Field2811.player.posZ);
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
                        rayTraceResult = AliceAura.Field2811.world.rayTraceBlocks(vec3d6, vec3d2, false, true, false);
                        if (!(this.Field4075.getValue().floatValue() >= this.Field4074.getValue().floatValue() || rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && rayTraceResult.getBlockPos().equals((Object) blockPos)))
                            continue;
                        vec3d = vec3d4;
                        arrd = arrd2;
                        if (this.Field4067.getValue().booleanValue()) {
                            if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d5)))
                                    continue;
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field4155 = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field4155 = rayTraceResult;
                            continue;
                        }
                        if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                            if (!(Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd3[0] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd3[1] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedPitch())))
                                continue;
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field4155 = rayTraceResult;
                            continue;
                        }
                        vec3d5 = vec3d;
                        arrd3 = arrd;
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                        enumFacing = rayTraceResult.sideHit;
                        this.Field4155 = rayTraceResult;
                    }
                }
            }
            if (this.Field4075.getValue().floatValue() < this.Field4074.getValue().floatValue() && this.Field4080.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.STRICT) {
                if (arrd3 != null && enumFacing != null) {
                    this.Field4150.Method2164750();
                    this.Field4148 = vec3d5;
                    this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
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
                            rayTraceResult = AliceAura.Field2811.world.rayTraceBlocks(vec3d6, vec3d2, false, true, true);
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            vec3d = vec3d4;
                            arrd = arrd2;
                            if (this.Field4067.getValue().booleanValue()) {
                                if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                    if (!(AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d5)))
                                        continue;
                                    vec3d5 = vec3d;
                                    arrd3 = arrd;
                                    if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                        continue;
                                    enumFacing = rayTraceResult.sideHit;
                                    this.Field4155 = rayTraceResult;
                                    continue;
                                }
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field4155 = rayTraceResult;
                                continue;
                            }
                            if (vec3d5 != null && arrd3 != null && (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK || enumFacing == null)) {
                                if (!(Math.hypot(((arrd[0] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd[1] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedPitch()) < Math.hypot(((arrd3[0] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedYaw()) % 360.0 + 540.0) % 360.0 - 180.0, arrd3[1] - (double) ((IEntityPlayerSP) AliceAura.Field2811.player).getLastReportedPitch())))
                                    continue;
                                vec3d5 = vec3d;
                                arrd3 = arrd;
                                if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                    continue;
                                enumFacing = rayTraceResult.sideHit;
                                this.Field4155 = rayTraceResult;
                                continue;
                            }
                            vec3d5 = vec3d;
                            arrd3 = arrd;
                            if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK)
                                continue;
                            enumFacing = rayTraceResult.sideHit;
                            this.Field4155 = rayTraceResult;
                        }
                    }
                }
            } else {
                if (arrd3 != null) {
                    this.Field4150.Method2164750();
                    this.Field4148 = vec3d5;
                    this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
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
                RayTraceResult rayTraceResult = AliceAura.Field2811.world.rayTraceBlocks(new Vec3d(AliceAura.Field2811.player.posX, AliceAura.Field2811.player.posY + (double) AliceAura.Field2811.player.getEyeHeight(), AliceAura.Field2811.player.posZ), vec3d, false, true, false);
                if (rayTraceResult == null || !rayTraceResult.typeOfHit.equals((Object) RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object) blockPos))
                    continue;
                if (this.Field4067.getValue().booleanValue()) {
                    if (vec3d7 != null && !(AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d7)))
                        continue;
                    vec3d7 = vec3d;
                    enumFacing2 = enumFacing3;
                    this.Field4155 = rayTraceResult;
                    continue;
                }
                this.Field4150.Method2164750();
                this.Field4148 = vec3d;
                this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
                return enumFacing3;
            }
            if (enumFacing2 != null) {
                this.Field4150.Method2164750();
                this.Field4148 = vec3d7;
                this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
                return enumFacing2;
            }
            if (this.Field4067.getValue().booleanValue()) {
                for (EnumFacing enumFacing3 : EnumFacing.values()) {
                    vec3d = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing3.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing3.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing3.getDirectionVec().getZ() * 0.5);
                    if (vec3d7 != null && !(AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d) < AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0).distanceTo(vec3d7)))
                        continue;
                    vec3d7 = vec3d;
                    enumFacing2 = enumFacing3;
                }
                if (enumFacing2 != null) {
                    this.Field4150.Method2164750();
                    this.Field4148 = vec3d7;
                    this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
                    return enumFacing2;
                }
            }
        }
        if ((double) blockPos.getY() > AliceAura.Field2811.player.posY + (double) AliceAura.Field2811.player.getEyeHeight()) {
            this.Field4150.Method2164750();
            this.Field4148 = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
            this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
            return EnumFacing.DOWN;
        }
        this.Field4150.Method2164750();
        this.Field4148 = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
        this.Field4149 = RotationManager.Method2150291(AliceAura.Field2811.player.getPositionEyes(1.0f), this.Field4148);
        return EnumFacing.UP;
    }

    private List<BlockPos> Method2150777() {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) AliceAura.Method2150785(new BlockPos((Entity) AliceAura.Field2811.player), this.Field4067.getValue() != false ? this.Field4074.getValue().floatValue() + 2.0f : this.Field4074.getValue().floatValue(), this.Field4074.getValue().intValue(), false, true, 0).stream().filter(this::Method2150778).collect(Collectors.toList()));
        return nonNullList;
    }

    public boolean Method2150778(BlockPos blockPos) {
        if (AliceAura.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && AliceAura.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (!(AliceAura.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.AIR || AliceAura.Field2811.world.getBlockState(blockPos2).getBlock() == Blocks.FIRE && this.Field4083.getValue().booleanValue() || AliceAura.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid && this.Field4082.getValue().booleanValue())) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (!(this.Field4081.getValue().booleanValue() || AliceAura.Field2811.world.getBlockState(blockPos3).getBlock() == Blocks.AIR || AliceAura.Field2811.world.getBlockState(blockPos2).getBlock() instanceof BlockLiquid && this.Field4082.getValue().booleanValue())) {
            return false;
        }
        if (this.Field4079.getValue().booleanValue() && !CrystalUtilSC.Method2162899((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5)) {
            Vec3d vec3d = new Vec3d((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5);
            if (AliceAura.Field2811.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double) this.Field4085.getValue().floatValue()) {
                return false;
            }
        }
        if (this.Field4075.getValue().floatValue() < this.Field4074.getValue().floatValue()) {
            if (!CrystalUtilSC.Method2162916(blockPos)) {
                if (this.Field4067.getValue().booleanValue()) {
                    boolean bl;
                    block30:
                    {
                        Vec3d vec3d = AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0);
                        bl = false;
                        if (this.Field4080.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.VANILLA) {
                            for (EnumFacing enumFacing : EnumFacing.values()) {
                                Vec3d vec3d2 = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                                if (!(vec3d.distanceTo(vec3d2) <= (double) this.Field4075.getValue().floatValue())) {
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
                                        if (!(d7 <= (double) this.Field4075.getValue().floatValue())) {
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
                } else if ((double) blockPos.getY() > AliceAura.Field2811.player.posY + (double) AliceAura.Field2811.player.getEyeHeight() ? AliceAura.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5) > (double) this.Field4075.getValue().floatValue() : AliceAura.Field2811.player.getDistance((double) blockPos.getX() + 0.5, (double) (blockPos.getY() + 1), (double) blockPos.getZ() + 0.5) > (double) this.Field4075.getValue().floatValue()) {
                    return false;
                }
            }
        } else if (this.Field4067.getValue().booleanValue()) {
            boolean bl;
            block31:
            {
                Vec3d vec3d = AliceAura.Field2811.player.getPositionVector().add(0.0, (double) AliceAura.Field2811.player.getEyeHeight(), 0.0);
                bl = false;
                if (this.Field4080.getValue() == IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.VANILLA) {
                    for (EnumFacing enumFacing : EnumFacing.values()) {
                        Vec3d vec3d4 = new Vec3d((double) blockPos.getX() + 0.5 + (double) enumFacing.getDirectionVec().getX() * 0.5, (double) blockPos.getY() + 0.5 + (double) enumFacing.getDirectionVec().getY() * 0.5, (double) blockPos.getZ() + 0.5 + (double) enumFacing.getDirectionVec().getZ() * 0.5);
                        if (!(vec3d.distanceTo(vec3d4) <= (double) this.Field4074.getValue().floatValue())) {
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
                                if (!(d13 <= (double) this.Field4074.getValue().floatValue())) {
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
        return AliceAura.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).stream().filter(this::Method2150705).count() == 0L;
    }

    private List<EntityPlayer> Method2150779() {
        List<Object> list = AliceAura.Field2811.world.playerEntities.stream().filter(AliceAura::Method2150704).filter(AliceAura::Method2150703).filter(AliceAura::Method2150702).filter(AliceAura::Method2150701).filter(this::Method2150790).sorted(Comparator.comparing(AliceAura::Method2150799)).collect(Collectors.toList());
        if (this.Field4094.getValue() == IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll.SMART) {
            List list2 = list.stream().filter(AliceAura::Method2150798).sorted(Comparator.comparing(AliceAura::Method2150797)).collect(Collectors.toList());
            if (list2.size() > 0) {
                list = list2;
            }
            if ((list2 = list.stream().filter(AliceAura::Method2150796).sorted(Comparator.comparing(AliceAura::Method2150795)).collect(Collectors.toList())).size() > 0) {
                list = list2;
            }
        }
        return list;
    }

    public boolean Method2150770() {
        return AliceAura.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public boolean Method2150781() {
        if (this.Method2150770()) {
            return true;
        }
        int n2 = CrystalUtilSC.Method2162806();
        if (n2 == -1) {
            return false;
        }
        if (AliceAura.Field2811.player.inventory.currentItem != n2) {
            AliceAura.Field2811.player.inventory.currentItem = n2;
            AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        return true;
    }

    public boolean Method2150782() {
        if (this.Method2150770()) {
            return true;
        }
        int n2 = CrystalUtilSC.Method2162806();
        if (n2 == -1) {
            return false;
        }
        if (AliceAura.Field2811.player.inventory.currentItem == n2) {
            return true;
        }
        if (this.Field4077.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.SILENT) {
            this.Field4187 = AliceAura.Field2811.player.inventory.currentItem;
        }
        AliceAura.Field2811.player.inventory.currentItem = n2;
        AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        return true;
    }

    public boolean Method2150783() {
        int n2 = CrystalUtilSC.Method2162807();
        if (AliceAura.Field2811.player.inventory.currentItem != n2 && n2 != -1) {
            if (this.Field4088.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SILENT) {
                this.Field4188 = AliceAura.Field2811.player.inventory.currentItem;
            }
            AliceAura.Field2811.player.inventory.currentItem = n2;
            AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n2));
        }
        return n2 != -1;
    }

    @SubscribeEvent
    public void Method2150784(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketHeldItemChange) {
            this.Field4158.Method2164750();
        }
    }

    public boolean Method2150788() {
        return AliceAura.Method2150751().Field4180 != null && !AliceAura.Method2150751().Field4181.Method2164755(800L);
    }

    public boolean Method2150789(EntityPlayer entityPlayer) {
        return (double) entityPlayer.moveForward != 0.0 || (double) entityPlayer.moveStrafing != 0.0;
    }

    private boolean Method2150790(EntityPlayer entityPlayer) {
        return AliceAura.Field2811.player.getDistance((Entity) entityPlayer) < this.Field4071.getValue().floatValue();
    }

    private boolean Method2150705(Entity entity) {
        return !this.Field4166.containsKey(entity.getEntityId()) && (!(entity instanceof EntityEnderCrystal) || entity.ticksExisted > 20);
    }

    private boolean Method2150707(Entity entity) {
        return entity.getPositionVector().distanceTo(AliceAura.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field4085.getValue().floatValue() || CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ);
    }

    private boolean Method2150709(Entity entity) {
        return entity.getPositionVector().distanceTo(AliceAura.Field2811.player.getPositionEyes(1.0f)) < (double) this.Field4085.getValue().floatValue() || CrystalUtilSC.Method2162899(entity.posX, entity.posY, entity.posZ);
    }

    private boolean Method2150700(Entity entity) {
        return this.Field4168.contains((Object) new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ));
    }

    private void Method2150811(Integer n2, Long l2) {
        if (System.currentTimeMillis() - l2 > 1000L) {
            this.Field4166.remove(n2);
        }
    }

    private boolean Method2150812(Entity entity) {
        return this.Method2150769((EntityEnderCrystal) entity);
    }

    private void Method2150814(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > 1500L) {
            this.Field4165.remove((Object) blockPos);
        }
    }

    private boolean Method2150815(IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll) {
        return illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150749() >= this.Field4111.getValue().floatValue() || AliceAura.Field2811.world.isAirBlock(illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150747()) || !AliceAura.Field2811.world.isAirBlock(illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150747().offset(EnumFacing.UP));
    }

    private void Method2150816(Color color, Color color2, IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll) {
        float f = (this.Field4111.getValue().floatValue() - illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150749()) / this.Field4111.getValue().floatValue();
        RenderUtil.Method2163909(new AxisAlignedBB(illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150747()), color, color2, this.Field4127.getValue().floatValue(), this.Field4122.getValue(), this.Field4117.getValue(), this.Field4116.getValue(), this.Field4108.getValue() != false ? f : 1.0f, this.Field4109.getValue() != false ? f : 1.0f, this.Field4110.getValue() != false ? f : 1.0f);
        illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150740(illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150749() + 50.0f);
    }

    private boolean Method2150817(IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll) {
        return illIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll.Method2150747().equals((Object) this.Field4159);
    }

    private void Method2150818(SPacketSpawnObject sPacketSpawnObject, BlockPos blockPos, Long l2) {
        if (this.Method2150759((double) blockPos.getX() + 0.5, blockPos.getY(), (double) blockPos.getZ() + 0.5, sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ()) < 1.0) {
            try {
                this.Field4165.remove((Object) blockPos);
                this.Field4172 = null;
                if (!this.Field4062.getValue().booleanValue() && this.Field4061.getValue().booleanValue()) {
                    this.Field4175.Method2164750();
                }
            } catch (ConcurrentModificationException concurrentModificationException) {
                // empty catch block
            }
            if (this.Field4060.getValue() != IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll.NORMAL) {
                return;
            }
            if (!this.Field4158.Method2164755((long) (this.Field4078.getValue().floatValue() * 100.0f))) {
                return;
            }
            if (this.Field4169.get()) {
                return;
            }
            if (AliceAura.Field2811.player.isPotionActive(MobEffects.WEAKNESS)) {
                return;
            }
            if (this.Field4166.containsKey(sPacketSpawnObject.getEntityID())) {
                return;
            }
            if (AliceAura.Field2811.player.getHealth() + AliceAura.Field2811.player.getAbsorptionAmount() < this.Field4073.getValue().floatValue() || this.Field4058.getValue() != false && AliceAura.Field2811.player.getActiveItemStack().getItem() instanceof ItemFood || this.Field4057.getValue().booleanValue() && AliceAura.Field2811.playerController.getIsHittingBlock() && AliceAura.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemTool) {
                this.Field4148 = null;
                return;
            }
            Vec3d vec3d = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            if (AliceAura.Field2811.player.getPositionEyes(1.0f).distanceTo(vec3d) > (double) this.Field4084.getValue().floatValue()) {
                return;
            }
            if (!this.Field4157.Method2164755(this.Field4086.getValue().intValue())) {
                return;
            }
            if (CrystalUtilSC.Method2162914(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ(), (Entity) AliceAura.Field2811.player) + this.Field4099.getValue().floatValue() >= AliceAura.Field2811.player.getHealth() + AliceAura.Field2811.player.getAbsorptionAmount()) {
                return;
            }
            this.Field4166.put(sPacketSpawnObject.getEntityID(), System.currentTimeMillis());
            this.Field4176 = new Vec3d(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
            ((ICPacketUseEntity) cPacketUseEntity).setEntityId(sPacketSpawnObject.getEntityID());
            ((ICPacketUseEntity) cPacketUseEntity).setAction(CPacketUseEntity.Action.ATTACK);
            AliceAura.Field2811.player.connection.sendPacket((Packet) new CPacketAnimation(this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            AliceAura.Field2811.player.connection.sendPacket((Packet) cPacketUseEntity);
            this.Method2150764(this.Method2150770() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            this.Field4162 = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY() - 1.0, sPacketSpawnObject.getZ());
            this.Field4163.Method2164750();
            this.Field4157.Method2164750();
            this.Field4170.Method2164750();
            if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.MERGE) {
                this.Field4156.Method2164750();
            }
            if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.STRICT) {
                this.Field4179.set(true);
            }
            if (this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.MERGE) {
                this.Method2150761();
            }
        }
    }

    private boolean Method2150819(Boolean bl) {
        return this.Field4140.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150810(Boolean bl) {
        return this.Field4140.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150821(Boolean bl) {
        return this.Field4140.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150822(Boolean bl) {
        return this.Field4140.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150823(Boolean bl) {
        return this.Field4140.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150824(Boolean bl) {
        return this.Field4140.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150825(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150826(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development && this.Field4136.getValue() != false;
    }

    private boolean Method2150827(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development && this.Field4136.getValue() != false;
    }

    private boolean Method2150828(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development && this.Field4136.getValue() != false;
    }

    private boolean Method2150829(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150820(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150831(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150832(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150833(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150834(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150835(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150836(IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Development;
    }

    private boolean Method2150837(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150838(Object object) {
        return this.Field4122.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150839(Object object) {
        return this.Field4122.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150830(Object object) {
        return this.Field4122.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150841(Object object) {
        return this.Field4122.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150842(Object object) {
        return this.Field4122.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150843(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150844(Object object) {
        return this.Field4117.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150845(Object object) {
        return this.Field4117.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150846(Object object) {
        return this.Field4117.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150847(Object object) {
        return this.Field4117.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150848(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150849(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150840(Float f) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.GLIDE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150851(Float f) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.GLIDE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150852(Float f) {
        return (this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.STATIC || this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.GLIDE) && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150853(Integer n2) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150854(Float f) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150855(Boolean bl) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150856(Boolean bl) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150857(Boolean bl) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.FADE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150858(Object object) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.NEWRAINBOW && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150859(Object object) {
        return this.Field4104.getValue() == IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl.NEWRAINBOW && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150850(Integer n2) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150861(IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl iIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Render;
    }

    private boolean Method2150862(Float f) {
        return this.Field4102.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150863(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150864(Bind bind) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150865(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150866(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150867(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150868(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150869(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150860(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150871(IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll iIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150872(Integer n2) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150873(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Calculation;
    }

    private boolean Method2150874(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150875(Integer n2) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150876(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150877(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150878(Integer n2) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150879(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150870(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150881(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Break;
    }

    private boolean Method2150882(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150883(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150884(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150885(IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150886(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150887(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150888(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150889(Object object) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150880(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150891(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.Place;
    }

    private boolean Method2150892(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150893(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150894(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150895(Float f) {
        return this.Field4069.getValue() == IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl.MERGE && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150896(IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl illIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150897(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150898(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150899(Integer n2) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150890(Float f) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150801(IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll illIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150802(IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll illIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150803(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150804(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150805(IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll illIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150806(Boolean bl) {
        return this.Field4058.getValue() != false && this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150807(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private boolean Method2150808(Boolean bl) {
        return this.Field4055.getValue() == IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll.General;
    }

    private static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        None,
        Normal,
        MainHand,
        OffHand;

    }

    public static enum IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll {
        Future,
        New,
        Target;

    }

    public static enum IIllIllIlIlllIIlllIIlllIlIIIllIIlIIllIIllIIlIIIlllIIIlIIlllIIlllIIIlIlIIlIIllIlIIIllIIlIIllIIlIIlIIlllIIIllIlllIIlIIlllIllIllIIlllIlllIIlllIlIIIllIIllIlIlIIIllIlIIIlIIIllIIllIIlIlllIllIllIIIlIIIlIIllIIllIlIIIlIIIlIIllIIIllIIlll {
        General,
        Place,
        Break,
        Calculation,
        Render,
        Development;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        OFF,
        NORMAL,
        SILENT;

    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        OFF,
        NORMAL,
        SILENT;

    }

    private static enum IIlllIlIIllIlIIlIlllIlIlIIIlIIIlllIllIlIIllIlllIlIIllIllIIllIIlllIlllIIllIIllIIlIllIlIIIlIlllIIlIIIllIlllIllIllIllIIllIllIlIIlIllIIllIIIllIllIIlllIIlIllIIlIIIllIIIllIlIIIlIIlllIIIlIIllIIllIlIllIIllIIIllIlllIllIIl {
        STATIC,
        FADE,
        GLIDE,
        NEWRAINBOW;

    }

    public static enum IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
        OFF,
        SEMI,
        FULL;

    }

    private static enum IllIIlIIlIIllIlIIIllIIIllIlIlllIlllIlIIllIIllIlIllIlllIIIllIIlIIIlIIllIIlIllIIlIIlIIllIIlIlIllIIlllIlIlIIllIIIlIIlllIllIIIlIIlIIIlllIlllIIllIIlIIllIIlIIllIIIllIIlllIIlllIIIlllIIIlIIllIIlIIlllIlIIIllIIIllIIllIIllIllIIlllIIll {
        OFF,
        TRACK,
        INTERACT;

    }

    private static enum IllIIlIIllIllIIlllIlllIlIIllIlIllIIllIlllIIllIIIlIIIlllIIllIIllIlIIIlIIllIIlIIIlIllIIllIIlIIllIIIlIIlllIIllIIIlIIlIlIIIlIllIIlIIIllIIlIlIIIlIIIllIIlllIIllIIlllIIlIIIllIIllIIlllIllIllIIlIIllIIlllIIIlllIllIllIIlIIlllIlllIIIlIIIll {
        SEQUENTIAL,
        NORMAL;

    }

    private static enum IllIllIlIIIllIIlIIllIIlllIIlllIIllIlllIIlIIllIIlllIlIllIIIllIllIIlllIlllIIlIIlIllIIllIlllIlllIIlIIlIIlIIlIIlllIllIIlIllIIIlllIIllIIIlIIIlllIlIIIlIlIlIIllIIIlIIllIlIIlIlIllIIlllIIllIIIlllIIllIIlIllIllIIllIllIIlllIIlIll {
        OFF,
        SEMI,
        FULL;

    }

    private static enum IIIllIIlllIlIIIllIllIIIlllIIlllIIlllIlIlIIlIIIllIIllIlllIIlllIIlIlllIIlIIlIIllIIlIIIlllIllIIlllIIlIllIIIllIIlIIlIIlIIllIIlIIlIIIllIIllIIlIIlIIlllIIlllIIIllIlIIllIllIIlllIlIIIlllIIllIIlllIIllIlllIIllIIIllIIllIIllIIIlllIlIIlllIIllIIllIIlll {
        ALL,
        SMART,
        NEAREST;

    }

    public static enum IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll {
        VANILLA,
        NORMAL,
        STRICT;

    }

    public static enum IllIIllIlIlIllIIllIIIllIIIllIIIllIIIlIlIlIllIlIIllIIlllIlllIIlIIIllIIlIllIIlllIIllIllIIIlIIlIlIlllIIIlllIIlIIIllIIIllIIIllIlIIlllIIlIlIIIlllIIlIlIIIlllIIlllIIlIllIllIIlIIIllIIllIlllIIllIIllIllIIllIIllIIlIIllIllIIllIIlIIl {
        STRICT,
        MERGE;

    }

    private static class IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll
            implements Runnable {
        private static IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll Field2184;
        private AliceAura Field2185;

        private IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll() {
        }

        static IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll Method2150746(AliceAura aliceAura) {
            if (Field2184 == null) {
                Field2184 = new IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll();
                IllIllIIlllIIIllIIlllIIlIIlllIIIllIIIlllIIllIIIlIIIlIIIllIIllIlIIIllIlIIlllIIIlllIlIIlIIIlIIlIIlllIlIIlIlllIIllIIllIIllIIIlIIIlIIllIIllIllIIlIIIlllIllIIlIIIllIIllIIlIllIIIlllIIIllIIIllIIllIIlIIIllIIlllIIlllIIIlllIIIllIllIIlIIIlllIIlIIIllIIllIll.Field2184.Field2185 = aliceAura;
            }
            return Field2184;
        }

        @Override
        public void run() {
            if (AliceAura.Method2150809(this.Field2185).get()) {
                try {
                    Thread.sleep((long) (this.Field2185.Field4189 * 40.0f));
                } catch (InterruptedException interruptedException) {
                    AliceAura.Method2150800(this.Field2185).interrupt();
                }
                if (!AliceAura.Method2150809(this.Field2185).get()) {
                    return;
                }
                AliceAura.Method2150809(this.Field2185).set(false);
                if (this.Field2185.Field4169.get()) {
                    return;
                }
                AliceAura.Method2150911(this.Field2185);
            }
        }
    }

    private class IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll {
        final AliceAura Field2819;
        private BlockPos Field2817;
        private float Field2818;

        public IllIllIlIIlllIIIlllIIIllIIIlIlIIIlllIIlIIllIIllIllIIIlIIIlllIIllIIIllIIllIIlllIlllIlIllIIlllIIllIIllIlIlllIIIllIIllIlllIIlllIIIlIIllIIIlllIlIIlIIlIllIlllIIllIllIIIllIIllIIIllIIllIIllIIllIIlIIlIIllIIIlIIIllIIlllIIIllIlIlllIllIIlIIIlllIll(AliceAura aliceAura, BlockPos blockPos, float f) {
            this.Field2819 = aliceAura;
            this.Field2817 = blockPos;
            this.Field2818 = f;
        }

        public BlockPos Method2150747() {
            return this.Field2817;
        }

        public void Method2150748(BlockPos blockPos) {
            this.Field2817 = blockPos;
        }

        public float Method2150749() {
            return this.Field2818;
        }

        public void Method2150740(float f) {
            this.Field2818 = f;
        }
    }
}

