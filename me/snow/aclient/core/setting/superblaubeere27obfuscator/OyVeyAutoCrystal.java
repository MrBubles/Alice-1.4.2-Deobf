

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemEndCrystal
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
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
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PacketEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OyVeyAutoCrystal
        extends Module {
    private final Timer Field244 = new Timer();
    private final Timer Field245 = new Timer();
    private final Timer Field246 = new Timer();
    private final Timer Field247 = new Timer();
    private final Setting<Integer> Field248 = this.Method2150366(new Setting<Integer>("PredictDelay", 0, 0, 200));
    private final Setting<Integer> Field249 = this.Method2150366(new Setting<Integer>("Red", 0, 0, 255));
    private final Setting<Integer> Field250 = this.Method2150366(new Setting<Integer>("Green", 255, 0, 255));
    private final Setting<Integer> Field251 = this.Method2150366(new Setting<Integer>("Blue", 0, 0, 255));
    private final Setting<Integer> Field252 = this.Method2150366(new Setting<Integer>("Alpha", 255, 0, 255));
    private final Setting<Integer> Field253 = this.Method2150366(new Setting<Integer>("BoxAlpha", 125, 0, 255));
    private final Setting<Float> Field254 = this.Method2150366(new Setting<Float>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f)));
    public Setting<Boolean> Field255 = this.Method2150366(new Setting<Boolean>("Sequential", true));
    public Setting<Boolean> Field256 = this.Method2150366(new Setting<Boolean>("Place", true));
    public Setting<Float> Field257 = this.Method2150366(new Setting<Float>("PlaceDelay", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(300.0f)));
    public Setting<Float> Field258 = this.Method2150366(new Setting<Float>("PlaceRange", Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(7.0f)));
    public Setting<Boolean> Field259 = this.Method2150366(new Setting<Boolean>("Break", true));
    public Setting<Boolean> Field260 = this.Method2150366(new Setting<Boolean>("PacketBreak", true));
    public Setting<Boolean> Field261 = this.Method2150366(new Setting<Boolean>("Predict", true));
    public Setting<Boolean> Field262 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    public Setting<Float> Field263 = this.Method2150366(new Setting<Float>("BreakDelay", Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(300.0f)));
    public Setting<Float> Field264 = this.Method2150366(new Setting<Float>("BreakRange", Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(7.0f)));
    public Setting<Float> Field265 = this.Method2150366(new Setting<Float>("BreakWallRange", Float.valueOf(4.0f), Float.valueOf(0.1f), Float.valueOf(7.0f)));
    public Setting<Boolean> Field266 = this.Method2150366(new Setting<Boolean>("1.13 Place", false));
    public Setting<Boolean> Field267 = this.Method2150366(new Setting<Boolean>("AntiSuicide", true));
    public Setting<Boolean> Field268 = this.Method2150366(new Setting<Boolean>("AutoSwitch", true));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field269 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("SwitchMode", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Silent, this::Method2161551));
    public Setting<Boolean> Field270 = this.Method2150366(new Setting<Boolean>("SilentSwitchHand", Boolean.valueOf(true), this::Method2161540));
    public Setting<Boolean> Field271 = this.Method2150366(new Setting<Boolean>("IgnoreUseAmount", true));
    public Setting<Integer> Field272 = this.Method2150366(new Setting<Integer>("UseAmount", 4, 1, 5));
    public Setting<Boolean> Field273 = this.Method2150366(new Setting<Boolean>("FacePlaceSword", false));
    public Setting<Float> Field274 = this.Method2150366(new Setting<Float>("TargetRange", Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(12.0f)));
    public Setting<Float> Field275 = this.Method2150366(new Setting<Float>("MinDamage", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(20.0f)));
    public Setting<Float> Field276 = this.Method2150366(new Setting<Float>("FacePlaceHP", Float.valueOf(36.0f), Float.valueOf(0.0f), Float.valueOf(36.0f)));
    public Setting<Float> Field277 = this.Method2150366(new Setting<Float>("BreakMaxSelf", Float.valueOf(8.0f), Float.valueOf(0.1f), Float.valueOf(12.0f)));
    public Setting<Float> Field278 = this.Method2150366(new Setting<Float>("BreakMinDmg", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(7.0f)));
    public Setting<Float> Field279 = this.Method2150366(new Setting<Float>("MinArmor", Float.valueOf(4.0f), Float.valueOf(0.1f), Float.valueOf(80.0f)));
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field280 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Swing", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None));
    public Setting<Boolean> Field281 = this.Method2150366(new Setting<Boolean>("Render", true));
    public Setting<Boolean> Field282 = this.Method2150366(new Setting<Boolean>("RenderDmg", true));
    public Setting<Boolean> Field283 = this.Method2150366(new Setting<Boolean>("Box", true));
    public Setting<Boolean> Field284 = this.Method2150366(new Setting<Boolean>("Outline", true));
    private final Setting<Integer> Field285 = this.Method2150366(new Setting<Object>("OL-Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161549));
    private final Setting<Integer> Field286 = this.Method2150366(new Setting<Object>("OL-Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161548));
    private final Setting<Integer> Field287 = this.Method2150366(new Setting<Object>("OL-Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161547));
    private final Setting<Integer> Field288 = this.Method2150366(new Setting<Object>("OL-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161546));
    EntityEnderCrystal Field289;
    private EntityLivingBase Field290;
    private BlockPos Field291;
    private int Field292;
    private boolean Field293;
    private boolean Field294;
    private int Field295;
    private int Field296;
    private int Field297;
    private boolean Field298;
    private float Field299 = 0.0f;
    private EntityLivingBase Field300;
    private int Field301;
    private float Field302 = 0.0f;
    private boolean Field303 = false;

    public OyVeyAutoCrystal() {
        super("CrystalAura", "skitty ac best ac", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public static List<BlockPos> Method2161526(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
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
                    float f2 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    float f3 = f2;
                    if (!((float) n9 < f2)) {
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

    private static EntityEnderCrystal Method2161545(Entity entity) {
        return (EntityEnderCrystal) entity;
    }

    @SubscribeEvent
    public void Method2161527(PacketEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && this.Field262.getValue().booleanValue() && this.Field303 && iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof CPacketPlayer) {
            CPacketPlayer cPacketPlayer = (CPacketPlayer) iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll();
            cPacketPlayer.yaw = this.Field299;
            cPacketPlayer.pitch = this.Field302;
            this.Field303 = false;
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
    public void Method2161528(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketSoundEffect sPacketSoundEffect;
        if (OyVeyAutoCrystal.Method2150359()) {
            return;
        }
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSoundEffect && this.Field255.getValue().booleanValue() && (sPacketSoundEffect = (SPacketSoundEffect) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
            ArrayList arrayList = new ArrayList(OyVeyAutoCrystal.Field2811.world.loadedEntityList);
            int n2 = arrayList.size();
            for (int j = 0; j < n2; ++j) {
                Entity entity = (Entity) arrayList.get(j);
                if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistanceSq(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ()) < 36.0))
                    continue;
                entity.setDead();
            }
        }
    }

    private void Method2161529(Entity entity) {
        if (this.Field262.getValue().booleanValue()) {
            float[] arrf = MathUtil.Method2163871(OyVeyAutoCrystal.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), entity.getPositionVector());
            this.Field299 = arrf[0];
            this.Field302 = arrf[1];
            this.Field303 = true;
        }
    }

    private void Method2161520(BlockPos blockPos) {
        if (this.Field262.getValue().booleanValue()) {
            float[] arrf = MathUtil.Method2163871(OyVeyAutoCrystal.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks()), new Vec3d((double) ((float) blockPos.getX() + 0.5f), (double) ((float) blockPos.getY() - 0.5f), (double) ((float) blockPos.getZ() + 0.5f)));
            this.Field299 = arrf[0];
            this.Field302 = arrf[1];
            this.Field303 = true;
        }
    }

    @Override
    public void Method2150372() {
        this.Field244.Method2164750();
        this.Field245.Method2164750();
        this.Field296 = 0;
        this.Field292 = -1;
        this.Field291 = null;
        this.Field289 = null;
        this.Field301 = 0;
        this.Field297 = 1;
        this.Field290 = null;
        this.Field298 = false;
        this.Field300 = null;
        this.Field293 = false;
        this.Field294 = false;
    }

    @Override
    public void Method2150373() {
        this.Field303 = false;
    }

    @Override
    public void Method2150376() {
        this.Method2161531();
    }

    @Override
    public String Method2150385() {
        if (this.Field300 != null) {
            return this.Field300.getName();
        }
        return null;
    }

    public void Method2161531() {
        if (OyVeyAutoCrystal.Field2811.world == null || OyVeyAutoCrystal.Field2811.player == null) {
            return;
        }
        this.Field300 = null;
        this.Method2161536();
        this.Field295 = 0;
        if (!this.Field271.getValue().booleanValue()) {
            for (Entity entity : OyVeyAutoCrystal.Field2811.world.loadedEntityList) {
                if (!(entity instanceof EntityEnderCrystal) || !this.Method2161534(entity)) continue;
                boolean bl = false;
                double d = this.Method2161530((double) this.Field290.getPosition().getX() + 0.5, (double) this.Field290.getPosition().getY() + 1.0, (double) this.Field290.getPosition().getZ() + 0.5, (Entity) this.Field290);
                if (d >= (double) this.Field275.getValue().floatValue()) {
                    bl = true;
                }
                if (!bl) continue;
                ++this.Field295;
            }
        }
        this.Field292 = -1;
        if (OyVeyAutoCrystal.Field2811.player.getHeldItemOffhand().getItem() != Items.END_CRYSTAL) {
            int n2;
            int n3 = n2 = OyVeyAutoCrystal.Field2811.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL ? OyVeyAutoCrystal.Field2811.player.inventory.currentItem : -1;
            if (n2 == -1) {
                for (int j = 0; j < 9; ++j) {
                    if (OyVeyAutoCrystal.Field2811.player.inventory.getStackInSlot(j).getItem() != Items.END_CRYSTAL) {
                        continue;
                    }
                    n2 = j;
                    this.Field292 = j;
                    break;
                }
            }
            if (n2 == -1) {
                this.Field291 = null;
                this.Field290 = null;
                return;
            }
        }
        if (OyVeyAutoCrystal.Field2811.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE && OyVeyAutoCrystal.Field2811.player.getHeldItemMainhand().getItem() != Items.END_CRYSTAL) {
            this.Field291 = null;
            this.Field290 = null;
            return;
        }
        if (this.Field290 == null) {
            this.Field290 = this.Method2161535();
        }
        if (this.Field290 == null) {
            this.Field289 = null;
            return;
        }
        if (this.Field290.getDistance((Entity) OyVeyAutoCrystal.Field2811.player) > 12.0f) {
            this.Field289 = null;
            this.Field290 = null;
        }
        this.Field289 = OyVeyAutoCrystal.Field2811.world.loadedEntityList.stream().filter(this::Method2161534).map(OyVeyAutoCrystal::Method2161545).min(Comparator.comparing(this::Method2161544)).orElse(null);
        if (this.Field289 != null && this.Field259.getValue().booleanValue() && this.Field245.Method2164755(this.Field263.getValue().longValue())) {
            this.Field245.Method2164750();
            if (this.Field260.getValue().booleanValue()) {
                this.Method2161529((Entity) this.Field289);
                OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity((Entity) this.Field289));
            } else {
                this.Method2161529((Entity) this.Field289);
                OyVeyAutoCrystal.Field2811.playerController.attackEntity((EntityPlayer) OyVeyAutoCrystal.Field2811.player, (Entity) this.Field289);
            }
            if (this.Field280.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MainHand) {
                OyVeyAutoCrystal.Field2811.player.swingArm(EnumHand.MAIN_HAND);
            } else if (this.Field280.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OffHand) {
                OyVeyAutoCrystal.Field2811.player.swingArm(EnumHand.OFF_HAND);
            }
        }
        if (this.Field244.Method2164755(this.Field257.getValue().longValue()) && this.Field256.getValue().booleanValue()) {
            this.Field244.Method2164750();
            double d = 0.5;
            for (BlockPos blockPos : this.Method2161538(this.Field258.getValue().floatValue())) {
                double d2;
                double d3;
                if (blockPos == null || this.Field290 == null || !OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos)).isEmpty() || (d3 = this.Field290.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ())) > (double) this.Field274.getValue().floatValue() || this.Field290.isDead || this.Field290.getHealth() + this.Field290.getAbsorptionAmount() <= 0.0f)
                    continue;
                double d4 = this.Method2161530((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5, (Entity) this.Field290);
                this.Field293 = false;
                for (ItemStack itemStack : this.Field290.getArmorInventoryList()) {
                    float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
                    float f2 = 1.0f - f;
                    int n4 = 100 - (int) (f2 * 100.0f);
                    if (!((float) n4 <= this.Field279.getValue().floatValue())) continue;
                    this.Field293 = true;
                }
                if (d4 < (double) this.Field275.getValue().floatValue() && (this.Field273.getValue() != false ? this.Field290.getAbsorptionAmount() + this.Field290.getHealth() > this.Field276.getValue().floatValue() : OyVeyAutoCrystal.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword || this.Field290.getAbsorptionAmount() + this.Field290.getHealth() > this.Field276.getValue().floatValue()) && (this.Field273.getValue() == false ? OyVeyAutoCrystal.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemSword || !this.Field293 : !this.Field293))
                    continue;
                double d5 = this.Method2161530((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.0, (double) blockPos.getZ() + 0.5, (Entity) OyVeyAutoCrystal.Field2811.player);
                if (d2 + (this.Field267.getValue() != false ? 2.0 : 0.5) >= (double) (OyVeyAutoCrystal.Field2811.player.getHealth() + OyVeyAutoCrystal.Field2811.player.getAbsorptionAmount()) && d5 >= d4 && d4 < (double) (this.Field290.getHealth() + this.Field290.getAbsorptionAmount()) || !(d < d4))
                    continue;
                this.Field291 = blockPos;
                d = d4;
            }
            if (d == 0.5) {
                this.Field291 = null;
                this.Field290 = null;
                this.Field300 = null;
                return;
            }
            this.Field300 = this.Field290;
            if (this.Field292 != -1 && this.Field268.getValue().booleanValue() && !OyVeyAutoCrystal.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && this.Field269.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Normal && !this.Field270.getValue().booleanValue()) {
                OyVeyAutoCrystal.Field2811.player.inventory.currentItem = this.Field292;
            }
            int n5 = InventoryUtil.Method2163778(ItemEndCrystal.class);
            int n6 = OyVeyAutoCrystal.Field2811.player.inventory.currentItem;
            EnumHand enumHand = null;
            if (this.Field269.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Silent && n5 != -1) {
                if (OyVeyAutoCrystal.Field2811.player.isHandActive() && this.Field270.getValue().booleanValue()) {
                    enumHand = OyVeyAutoCrystal.Field2811.player.getActiveHand();
                }
                OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n5));
            }
            if (!this.Field271.getValue().booleanValue()) {
                int n7 = this.Field272.getValue();
                if (this.Field295 >= n7) {
                    return;
                }
                if (d < (double) this.Field275.getValue().floatValue()) {
                    n7 = 1;
                }
                if (this.Field295 < n7 && this.Field291 != null) {
                    this.Method2161520(this.Field291);
                    OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(this.Field291, EnumFacing.UP, OyVeyAutoCrystal.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                }
            } else if (this.Field291 != null) {
                this.Method2161520(this.Field291);
                OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketPlayerTryUseItemOnBlock(this.Field291, EnumFacing.UP, OyVeyAutoCrystal.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            }
            if (this.Field269.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Silent && n5 != -1) {
                if (this.Field270.getValue().booleanValue() && enumHand != null) {
                    OyVeyAutoCrystal.Field2811.player.setActiveHand(enumHand);
                }
                OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketHeldItemChange(n6));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void Method2161532(PacketEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        SPacketSpawnObject sPacketSpawnObject;
        if (iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll() instanceof SPacketSpawnObject && (sPacketSpawnObject = (SPacketSpawnObject) iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).getType() == 51 && this.Field261.getValue().booleanValue() && this.Field246.Method2164755(this.Field248.getValue().longValue()) && this.Field261.getValue().booleanValue() && this.Field259.getValue().booleanValue() && this.Field260.getValue().booleanValue() && this.Field290 != null) {
            if (!this.Method2161533(sPacketSpawnObject)) {
                return;
            }
            CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
            cPacketUseEntity.entityId = sPacketSpawnObject.getEntityID();
            cPacketUseEntity.action = CPacketUseEntity.Action.ATTACK;
            OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) cPacketUseEntity);
        }
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field291 != null && this.Field281.getValue().booleanValue() && this.Field290 != null) {
            RenderUtil.Method2163908(this.Field291, new Color(this.Field249.getValue(), this.Field250.getValue(), this.Field251.getValue(), this.Field252.getValue()), this.Field284.getValue(), new Color(this.Field285.getValue(), this.Field286.getValue(), this.Field287.getValue(), this.Field288.getValue()), this.Field254.getValue().floatValue(), this.Field284.getValue(), this.Field283.getValue(), this.Field253.getValue(), true);
            if (this.Field282.getValue().booleanValue()) {
                double d = this.Method2161530((double) this.Field291.getX() + 0.5, (double) this.Field291.getY() + 1.0, (double) this.Field291.getZ() + 0.5, (Entity) this.Field290);
                RenderUtil2.Method2164668(this.Field291, (Math.floor(d) == d ? Integer.valueOf((int) d) : String.format("%.1f", d)) + "");
            }
        }
    }

    private boolean Method2161533(SPacketSpawnObject sPacketSpawnObject) {
        double d;
        BlockPos blockPos = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
        if (OyVeyAutoCrystal.Field2811.player.getDistance(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ()) > (double) this.Field264.getValue().floatValue()) {
            return false;
        }
        if (!this.Method2161537(blockPos) && OyVeyAutoCrystal.Field2811.player.getDistance(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ()) > (double) this.Field265.getValue().floatValue()) {
            return false;
        }
        double d2 = this.Method2161530(sPacketSpawnObject.getX() + 0.5, sPacketSpawnObject.getY() + 1.0, sPacketSpawnObject.getZ() + 0.5, (Entity) this.Field290);
        if (EntityUtil.Method2163512((Entity) OyVeyAutoCrystal.Field2811.player) && d2 >= 1.0) {
            return true;
        }
        double d3 = this.Method2161530(sPacketSpawnObject.getX() + 0.5, sPacketSpawnObject.getY() + 1.0, sPacketSpawnObject.getZ() + 0.5, (Entity) OyVeyAutoCrystal.Field2811.player);
        double d4 = d = this.Field267.getValue() != false ? 2.0 : 0.5;
        if (d3 + d < (double) (OyVeyAutoCrystal.Field2811.player.getHealth() + OyVeyAutoCrystal.Field2811.player.getAbsorptionAmount()) && d2 >= (double) (this.Field290.getAbsorptionAmount() + this.Field290.getHealth())) {
            return true;
        }
        this.Field294 = false;
        for (ItemStack itemStack : this.Field290.getArmorInventoryList()) {
            float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
            float f2 = 1.0f - f;
            int n2 = 100 - (int) (f2 * 100.0f);
            if (!((float) n2 <= this.Field279.getValue().floatValue())) continue;
            this.Field294 = true;
        }
        if (d2 >= (double) this.Field278.getValue().floatValue() && d3 <= (double) this.Field277.getValue().floatValue()) {
            return true;
        }
        return EntityUtil.Method2163512((Entity) this.Field290) && this.Field290.getHealth() + this.Field290.getAbsorptionAmount() <= this.Field276.getValue().floatValue();
    }

    private boolean Method2161534(Entity entity) {
        double d;
        if (entity == null) {
            return false;
        }
        if (!(entity instanceof EntityEnderCrystal)) {
            return false;
        }
        if (this.Field290 == null) {
            return false;
        }
        if (entity.getDistance((Entity) OyVeyAutoCrystal.Field2811.player) > this.Field264.getValue().floatValue()) {
            return false;
        }
        if (!OyVeyAutoCrystal.Field2811.player.canEntityBeSeen(entity) && entity.getDistance((Entity) OyVeyAutoCrystal.Field2811.player) > this.Field265.getValue().floatValue()) {
            return false;
        }
        if (this.Field290.isDead || this.Field290.getHealth() + this.Field290.getAbsorptionAmount() <= 0.0f) {
            return false;
        }
        double d2 = this.Method2161530((double) entity.getPosition().getX() + 0.5, (double) entity.getPosition().getY() + 1.0, (double) entity.getPosition().getZ() + 0.5, (Entity) this.Field290);
        if (EntityUtil.Method2163512((Entity) OyVeyAutoCrystal.Field2811.player) && d2 >= 1.0) {
            return true;
        }
        double d3 = this.Method2161530((double) entity.getPosition().getX() + 0.5, (double) entity.getPosition().getY() + 1.0, (double) entity.getPosition().getZ() + 0.5, (Entity) OyVeyAutoCrystal.Field2811.player);
        double d4 = d = this.Field267.getValue() != false ? 2.0 : 0.5;
        if (d3 + d < (double) (OyVeyAutoCrystal.Field2811.player.getHealth() + OyVeyAutoCrystal.Field2811.player.getAbsorptionAmount()) && d2 >= (double) (this.Field290.getAbsorptionAmount() + this.Field290.getHealth())) {
            return true;
        }
        this.Field294 = false;
        for (ItemStack itemStack : this.Field290.getArmorInventoryList()) {
            float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
            float f2 = 1.0f - f;
            int n2 = 100 - (int) (f2 * 100.0f);
            if (!((float) n2 <= this.Field279.getValue().floatValue())) continue;
            this.Field294 = true;
        }
        if (d2 >= (double) this.Field278.getValue().floatValue() && d3 <= (double) this.Field277.getValue().floatValue()) {
            return true;
        }
        return EntityUtil.Method2163512((Entity) this.Field290) && this.Field290.getHealth() + this.Field290.getAbsorptionAmount() <= this.Field276.getValue().floatValue();
    }

    EntityPlayer Method2161535() {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : OyVeyAutoCrystal.Field2811.world.playerEntities) {
            if (OyVeyAutoCrystal.Field2811.player == null || OyVeyAutoCrystal.Field2811.player.isDead || entityPlayer2.isDead || entityPlayer2 == OyVeyAutoCrystal.Field2811.player || AliceMain.Field765.Method2150168(entityPlayer2.getName()) || entityPlayer2.getDistance((Entity) OyVeyAutoCrystal.Field2811.player) > 12.0f)
                continue;
            this.Field294 = false;
            for (ItemStack itemStack : entityPlayer2.getArmorInventoryList()) {
                float f = ((float) itemStack.getMaxDamage() - (float) itemStack.getItemDamage()) / (float) itemStack.getMaxDamage();
                float f2 = 1.0f - f;
                int n2 = 100 - (int) (f2 * 100.0f);
                if (!((float) n2 <= this.Field279.getValue().floatValue())) continue;
                this.Field294 = true;
            }
            if (EntityUtil.Method2163512((Entity) entityPlayer2) && entityPlayer2.getAbsorptionAmount() + entityPlayer2.getHealth() > this.Field276.getValue().floatValue() && !this.Field294 && this.Field275.getValue().floatValue() > 2.2f)
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(entityPlayer.getDistance((Entity) OyVeyAutoCrystal.Field2811.player) > entityPlayer2.getDistance((Entity) OyVeyAutoCrystal.Field2811.player)))
                continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    private void Method2161536() {
        RayTraceResult rayTraceResult;
        if (this.Field247.Method2164755(200L) && OyVeyAutoCrystal.Field2811.gameSettings.keyBindUseItem.isKeyDown() && OyVeyAutoCrystal.Field2811.player.getHeldItemOffhand().getItem() != Items.GOLDEN_APPLE && OyVeyAutoCrystal.Field2811.player.inventory.getCurrentItem().getItem() != Items.GOLDEN_APPLE && OyVeyAutoCrystal.Field2811.player.inventory.getCurrentItem().getItem() != Items.BOW && OyVeyAutoCrystal.Field2811.player.inventory.getCurrentItem().getItem() != Items.EXPERIENCE_BOTTLE && (rayTraceResult = OyVeyAutoCrystal.Field2811.objectMouseOver) != null) {
            if (rayTraceResult.typeOfHit.equals((Object) RayTraceResult.Type.ENTITY)) {
                Entity entity = rayTraceResult.entityHit;
                if (entity instanceof EntityEnderCrystal) {
                    if (this.Field260.getValue().booleanValue()) {
                        OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
                    } else {
                        OyVeyAutoCrystal.Field2811.playerController.attackEntity((EntityPlayer) OyVeyAutoCrystal.Field2811.player, entity);
                    }
                    this.Field247.Method2164750();
                }
            } else if (rayTraceResult.typeOfHit.equals((Object) RayTraceResult.Type.BLOCK)) {
                BlockPos blockPos = new BlockPos((double) OyVeyAutoCrystal.Field2811.objectMouseOver.getBlockPos().getX(), (double) OyVeyAutoCrystal.Field2811.objectMouseOver.getBlockPos().getY() + 1.0, (double) OyVeyAutoCrystal.Field2811.objectMouseOver.getBlockPos().getZ());
                for (Entity entity : OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
                    if (!(entity instanceof EntityEnderCrystal)) continue;
                    if (this.Field260.getValue().booleanValue()) {
                        OyVeyAutoCrystal.Field2811.player.connection.sendPacket((Packet) new CPacketUseEntity(entity));
                    } else {
                        OyVeyAutoCrystal.Field2811.playerController.attackEntity((EntityPlayer) OyVeyAutoCrystal.Field2811.player, entity);
                    }
                    this.Field247.Method2164750();
                }
            }
        }
    }

    private boolean Method2161537(BlockPos blockPos) {
        return OyVeyAutoCrystal.Field2811.world.rayTraceBlocks(new Vec3d(OyVeyAutoCrystal.Field2811.player.posX, OyVeyAutoCrystal.Field2811.player.posY + (double) OyVeyAutoCrystal.Field2811.player.getEyeHeight(), OyVeyAutoCrystal.Field2811.player.posZ), new Vec3d((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()), false, true, false) == null;
    }

    private NonNullList<BlockPos> Method2161538(float f) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection) OyVeyAutoCrystal.Method2161526(new BlockPos(Math.floor(OyVeyAutoCrystal.Field2811.player.posX), Math.floor(OyVeyAutoCrystal.Field2811.player.posY), Math.floor(OyVeyAutoCrystal.Field2811.player.posZ)), f, (int) f, false, true, 0).stream().filter(this::Method2161543).collect(Collectors.toList()));
        return nonNullList;
    }

    private boolean Method2161539(BlockPos blockPos, boolean bl) {
        block18:
        {
            BlockPos blockPos2;
            block20:
            {
                block19:
                {
                    block15:
                    {
                        BlockPos blockPos3;
                        block17:
                        {
                            block16:
                            {
                                blockPos2 = blockPos.add(0, 1, 0);
                                blockPos3 = blockPos.add(0, 2, 0);
                                if (this.Field266.getValue().booleanValue()) break block15;
                                if (OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                                    break block16;
                                return false;
                            }
                            if (OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR || OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
                                return false;
                            }
                            if (bl) break block17;
                            return OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
                        }
                        for (Entity entity : OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                        for (Entity entity : OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                        break block18;
                    }
                    if (OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN)
                        break block19;
                    return false;
                }
                if (OyVeyAutoCrystal.Field2811.world.getBlockState(blockPos2).getBlock() != Blocks.AIR) {
                    return false;
                }
                if (bl) break block20;
                return OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty();
            }
            try {
                for (Entity entity : OyVeyAutoCrystal.Field2811.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                    if (entity instanceof EntityEnderCrystal) continue;
                    return false;
                }
            } catch (Exception exception) {
                return false;
            }
        }
        return true;
    }

    private float Method2161530(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        double d4 = entity.getDistance(d, d2, d3) / 12.0;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        double d5 = 0.0;
        try {
            d5 = entity.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
        } catch (Exception exception) {
            // empty catch block
        }
        double d6 = (1.0 - d4) * d5;
        float f2 = (int) ((d6 * d6 + d6) / 2.0 * 7.0 * 12.0 + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = this.Method2161541((EntityLivingBase) entity, this.Method2161542(f2), new Explosion((World) OyVeyAutoCrystal.Field2811.world, null, d, d2, d3, 6.0f, false, true));
        }
        return (float) d7;
    }

    private float Method2161541(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
        float f2 = f;
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion) explosion);
            f2 = CombatRules.getDamageAfterAbsorb((float) f2, (float) entityPlayer.getTotalArmorValue(), (float) ((float) entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n2 = 0;
            try {
                n2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable) entityPlayer.getArmorInventoryList(), (DamageSource) damageSource);
            } catch (Exception exception) {
                // empty catch block
            }
            float f3 = MathHelper.clamp((float) n2, (float) 0.0f, (float) 20.0f);
            f2 *= 1.0f - f3 / 25.0f;
            if (entityLivingBase.isPotionActive(MobEffects.RESISTANCE)) {
                f2 -= f2 / 4.0f;
            }
            f2 = Math.max(f2, 0.0f);
            return f2;
        }
        f2 = CombatRules.getDamageAfterAbsorb((float) f2, (float) entityLivingBase.getTotalArmorValue(), (float) ((float) entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f2;
    }

    private float Method2161542(float f) {
        int n2 = OyVeyAutoCrystal.Field2811.world.getDifficulty().getId();
        return f * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    private boolean Method2161543(BlockPos blockPos) {
        return this.Method2161539(blockPos, true);
    }

    private Float Method2161544(EntityEnderCrystal entityEnderCrystal) {
        return Float.valueOf(this.Field290.getDistance((Entity) entityEnderCrystal));
    }

    private boolean Method2161546(Object object) {
        return this.Field284.getValue();
    }

    private boolean Method2161547(Object object) {
        return this.Field284.getValue();
    }

    private boolean Method2161548(Object object) {
        return this.Field284.getValue();
    }

    private boolean Method2161549(Object object) {
        return this.Field284.getValue();
    }

    private boolean Method2161540(Boolean bl) {
        return this.Field269.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Silent;
    }

    private boolean Method2161551(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        return this.Field268.getValue();
    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        Normal,
        Silent;

    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        MainHand,
        OffHand,
        None;

    }
}

