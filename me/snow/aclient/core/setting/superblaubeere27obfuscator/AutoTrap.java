

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockEndPortalFrame
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render3DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoTrap
        extends Module {
    public static boolean Field3974 = false;
    public final Setting<Boolean> Field3980 = this.Method2150366(new Setting<Boolean>("Strict", false));
    private final Setting<Integer> Field3975 = this.Method2150366(new Setting<Integer>("Delay/Place", 100, 0, 250));
    private final Setting<Integer> Field3976 = this.Method2150366(new Setting<Integer>("Block/Place", 4, 1, 30));
    private final Setting<Double> Field3977 = this.Method2150366(new Setting<Double>("TargetRange", 6.0, 0.0, 20.0));
    private final Setting<Double> Field3978 = this.Method2150366(new Setting<Double>("PlaceRange", 4.5, 0.0, 10.0));
    private final Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field3979 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Target", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLOSEST));
    private final Setting<Boolean> Field3981 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private final Setting<Boolean> Field3982 = this.Method2150366(new Setting<Boolean>("Raytrace", false));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3983 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Pattern", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STATIC));
    private final Setting<Integer> Field3984 = this.Method2150366(new Setting<Object>("Extend", 4, 1, 4, this::Method2161120, "Extending the Trap."));
    private final Setting<Boolean> Field3985 = this.Method2150366(new Setting<Boolean>("AntiScaffold", false));
    private final Setting<Boolean> Field3986 = this.Method2150366(new Setting<Boolean>("AntiStep", true));
    private final Setting<Boolean> Field3987 = this.Method2150366(new Setting<Boolean>("Face", true));
    private final Setting<Boolean> Field3988 = this.Method2150366(new Setting<Object>("Legs", Boolean.FALSE, this::Method2161129));
    private final Setting<Boolean> Field3989 = this.Method2150366(new Setting<Object>("Platform", Boolean.FALSE, this::Method2161128));
    private final Setting<Boolean> Field3990 = this.Method2150366(new Setting<Boolean>("AntiDrop", false));
    private final Setting<Boolean> Field3991 = this.Method2150366(new Setting<Boolean>("Disable", false));
    private final Setting<Integer> Field3992 = this.Method2150366(new Setting<Integer>("Sc/Disable", 5, 1, 15));
    private final Setting<Double> Field3993 = this.Method2150366(new Setting<Double>("Speed", 10.0, 0.0, 30.0));
    private final Setting<Boolean> Field3994 = this.Method2150366(new Setting<Boolean>("AntiSelf", false));
    private final Setting<Integer> Field3995 = this.Method2150366(new Setting<Integer>("Updates", 3, 1, 3));
    private final Setting<Boolean> Field3996 = this.Method2150366(new Setting<Boolean>("Freecam", false));
    private final Setting<Boolean> Field3997 = this.Method2150366(new Setting<Boolean>("Info", false));
    private final Setting<Boolean> Field3998 = this.Method2150366(new Setting<Boolean>("NoBlock", true));
    private final Setting<Boolean> Field3999 = this.Method2150366(new Setting<Boolean>("NoScaffoldExtend", false));
    private final Setting<Boolean> Field4000 = this.Method2150366(new Setting<Boolean>("TSelfMove", false));
    private final Setting<Boolean> Field4001 = this.Method2150366(new Setting<Boolean>("Packet", false));
    private final Setting<Boolean> Field4002 = this.Method2150366(new Setting<Object>("AirPacket", Boolean.FALSE, this::Method2161127));
    private final Setting<Integer> Field4003 = this.Method2150366(new Setting<Integer>("Retries", 4, 1, 15));
    private final Setting<Boolean> Field4004 = this.Method2150366(new Setting<Boolean>("EndPortals", false));
    private final Setting<Boolean> Field4005 = this.Method2150366(new Setting<Boolean>("Render", true));
    public final Setting<Boolean> Field4006 = this.Method2150366(new Setting<Object>("Sync", Boolean.FALSE, this::Method2161126));
    public final Setting<Boolean> Field4007 = this.Method2150366(new Setting<Object>("Box", Boolean.TRUE, this::Method2161125));
    private final Setting<Integer> Field4014 = this.Method2150366(new Setting<Object>("BoxAlpha", Integer.valueOf(70), Integer.valueOf(0), Integer.valueOf(255), this::Method2161118));
    public final Setting<Boolean> Field4008 = this.Method2150366(new Setting<Object>("Outline", Boolean.valueOf(true), this::Method2161124));
    public final Setting<Boolean> Field4009 = this.Method2150366(new Setting<Object>("CustomLine", Boolean.valueOf(false), this::Method2161123));
    private final Setting<Integer> Field4016 = this.Method2150366(new Setting<Object>("OL-Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161116));
    private final Setting<Integer> Field4017 = this.Method2150366(new Setting<Object>("OL-Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161115));
    private final Setting<Integer> Field4018 = this.Method2150366(new Setting<Object>("OL-Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161114));
    private final Setting<Integer> Field4019 = this.Method2150366(new Setting<Object>("OL-Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161113));
    private final Setting<Float> Field4015 = this.Method2150366(new Setting<Object>("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f), this::Method2161117));
    private final Setting<Integer> Field4010 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161122));
    private final Setting<Integer> Field4011 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161121));
    private final Setting<Integer> Field4012 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161110));
    private final Setting<Integer> Field4013 = this.Method2150366(new Setting<Object>("Alpha", Integer.valueOf(70), Integer.valueOf(0), Integer.valueOf(255), this::Method2161119));
    private final Timer Field4020 = new Timer();
    private final Map<BlockPos, Integer> Field4021 = new HashMap<BlockPos, Integer>();
    private final Timer Field4022 = new Timer();
    private final Map<BlockPos, IBlockState> Field4023 = new HashMap<BlockPos, IBlockState>();
    private final Timer Field4033 = new Timer();
    public EntityPlayer Field4024;
    private boolean Field4025 = false;
    private boolean Field4026;
    private boolean Field4027;
    private int Field4028;
    private int Field4029 = 0;
    private boolean Field4030 = false;
    private BlockPos Field4031 = null;
    private List<Vec3d> Field4032 = new ArrayList<Vec3d>();

    public AutoTrap() {
        super("AutoTrap", "Traps other players", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private static double Method2161111(Vec3d vec3d) {
        return vec3d.y;
    }

    private static int Method2161112(Vec3d vec3d, Vec3d vec3d2) {
        return Double.compare(AutoTrap.Field2811.player.getDistanceSq(vec3d2.x, vec3d2.y, vec3d2.z), AutoTrap.Field2811.player.getDistanceSq(vec3d.x, vec3d.y, vec3d.z));
    }

    @Override
    public void Method2150372() {
        if (AutoTrap.Method2150359()) {
            this.Method2150380();
            return;
        }
        this.Field4023.clear();
        this.Field4031 = EntityUtil.Method2163536((Entity) AutoTrap.Field2811.player);
        this.Field4028 = AutoTrap.Field2811.player.inventory.currentItem;
        this.Field4021.clear();
        this.Field4033.Method2164750();
    }

    @Override
    public void Method2150378() {
        this.Method2150380();
    }

    @Override
    public void Method2150376() {
        if (this.Field3995.getValue() == 3) {
            this.Field4030 = false;
            this.Method2150004();
        }
    }

    @SubscribeEvent
    public void Method2150003(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && this.Field3995.getValue() == 2) {
            this.Field4030 = this.Field3981.getValue() != false && this.Field3976.getValue() == 1;
            this.Method2150004();
        }
    }

    @Override
    public void Method2150379() {
        if (this.Field3995.getValue() == 1) {
            this.Field4030 = false;
            this.Method2150004();
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field3997.getValue().booleanValue() && this.Field4024 != null) {
            return this.Field4024.getName();
        }
        return null;
    }

    @Override
    public void Method2150373() {
        if (AutoTrap.Method2150359()) {
            return;
        }
        Field3974 = false;
        this.Field4027 = EntityUtil.Method2163401(this.Field4027);
    }

    @Override
    public void Method2150381(Render3DEvent render3DEvent) {
        if (this.Field4005.getValue().booleanValue() && this.Field4032 != null) {
            for (Vec3d vec3d : this.Field4032) {
                BlockPos blockPos = new BlockPos(vec3d);
                if (!(AutoTrap.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockAir)) continue;
                RenderUtil.Method2163908(blockPos, this.Field4006.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field4010.getValue(), this.Field4011.getValue(), this.Field4012.getValue(), this.Field4013.getValue()), this.Field4009.getValue(), new Color(this.Field4016.getValue(), this.Field4017.getValue(), this.Field4018.getValue(), this.Field4019.getValue()), this.Field4015.getValue().floatValue(), this.Field4008.getValue(), this.Field4007.getValue(), this.Field4014.getValue(), false);
            }
        }
    }

    private void Method2150004() {
        if (this.Method2150008()) {
            return;
        }
        if (this.Field3991.getValue().booleanValue() && this.Field4033.Method2164755(this.Field3992.getValue() * 1000)) {
            Command.Method2159696("<AutoTrap> Disable");
            this.Method2150380();
        }
        if (!(!this.Field3980.getValue().booleanValue() || AutoTrap.Field2811.player.onGround && AutoTrap.Field2811.player.collidedVertically)) {
            return;
        }
        switch (1.F ield326[this.Field3983.getValue().ordinal()]){
            case 1: {
                this.Method2150006();
                break;
            }
            case 2:
            case 3: {
                this.Method2150005();
            }
        }
        if (this.Field4001.getValue().booleanValue() && this.Field4002.getValue().booleanValue()) {
            for (Map.Entry<BlockPos, IBlockState> entry : this.Field4023.entrySet()) {
                AutoTrap.Field2811.world.setBlockState(entry.getKey(), entry.getValue());
            }
            this.Field4023.clear();
        }
        if (this.Field4025) {
            this.Field4020.Method2164750();
        }
    }

    private void Method2150005() {
        List<Vec3d> list = EntityUtil.Method2163529(this.Field3984.getValue(), this.Field4024, this.Field3985.getValue(), this.Field3986.getValue(), this.Field3988.getValue(), this.Field3989.getValue(), this.Field3990.getValue(), this.Field3982.getValue(), this.Field3999.getValue(), this.Field3987.getValue());
        this.Method2150007(list);
        this.Field4032 = list;
    }

    private void Method2150006() {
        List<Vec3d> list = EntityUtil.Method2163520(this.Field4024.getPositionVector(), this.Field3985.getValue(), this.Field3986.getValue(), this.Field3988.getValue(), this.Field3989.getValue(), this.Field3990.getValue(), this.Field3982.getValue(), this.Field3987.getValue());
        this.Method2150007(list);
        this.Field4032 = list;
    }

    private void Method2150007(List<Vec3d> list) {
        list.sort(AutoTrap::Method2161112);
        list.sort(Comparator.comparingDouble(AutoTrap::Method2161111));
        for (Vec3d vec3d : list) {
            BlockPos blockPos = new BlockPos(vec3d);
            int n2 = BlockUtil.Method2162815(blockPos, this.Field3982.getValue());
            if (this.Field3998.getValue().booleanValue() && n2 == 1 && (this.Field4021.get((Object) blockPos) == null || this.Field4021.get((Object) blockPos) < this.Field4003.getValue())) {
                this.Method2150000(blockPos);
                this.Field4021.put(blockPos, this.Field4021.get((Object) blockPos) == null ? 1 : this.Field4021.get((Object) blockPos) + 1);
                this.Field4022.Method2164750();
                continue;
            }
            if (n2 != 3 || this.Field3994.getValue().booleanValue() && MathUtil.Method2163869(AutoTrap.Field2811.player.getPositionVector(), vec3d))
                continue;
            this.Method2150000(blockPos);
        }
    }

    private boolean Method2150008() {
        Field3974 = false;
        this.Field4025 = false;
        this.Field4029 = 0;
        int n2 = -1;
        if (this.Field4004.getValue().booleanValue()) {
            n2 = InventoryUtil.Method2163778(BlockEndPortalFrame.class);
            if (n2 == -1) {
                n2 = InventoryUtil.Method2163778(BlockObsidian.class);
            }
        } else {
            n2 = InventoryUtil.Method2163778(BlockObsidian.class);
        }
        if (this.Method2150387()) {
            return true;
        }
        if (this.Field4000.getValue().booleanValue() && this.Field4031 != null && !this.Field4031.equals((Object) EntityUtil.Method2163536((Entity) AutoTrap.Field2811.player))) {
            this.Method2150380();
            return true;
        }
        if (this.Field4022.Method2164755(2000L)) {
            this.Field4021.clear();
            this.Field4022.Method2164750();
        }
        if (n2 == -1) {
            if (this.Field3997.getValue().booleanValue()) {
                Command.Method2159696("<" + this.Method2150392() + "> \u00a7cYou are out of Obsidian.");
            }
            this.Method2150380();
        }
        if (AutoTrap.Field2811.player.inventory.currentItem != this.Field4028 && AutoTrap.Field2811.player.inventory.currentItem != n2) {
            this.Field4028 = AutoTrap.Field2811.player.inventory.currentItem;
        }
        this.Field4027 = EntityUtil.Method2163401(this.Field4027);
        this.Field4024 = this.Method2150009(this.Field3977.getValue(), this.Field3979.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.UNTRAPPED);
        return this.Field4024 == null || AliceMain.Field756.Method2150195("Freecam") && this.Field3996.getValue() == false || !this.Field4020.Method2164755(this.Field3975.getValue().intValue());
    }

    private EntityPlayer Method2150009(double d, boolean bl) {
        EntityPlayer entityPlayer = null;
        double d2 = Math.pow(d, 2.0) + 1.0;
        for (EntityPlayer entityPlayer2 : AutoTrap.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d) || this.Field3983.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STATIC && bl && EntityUtil.Method2163521(entityPlayer2, this.Field3985.getValue(), this.Field3986.getValue(), this.Field3988.getValue(), this.Field3989.getValue(), this.Field3990.getValue(), this.Field3987.getValue()) || this.Field3983.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STATIC && bl && EntityUtil.Method2163522(this.Field3984.getValue(), entityPlayer2, this.Field3985.getValue(), this.Field3986.getValue(), this.Field3988.getValue(), this.Field3989.getValue(), this.Field3990.getValue(), this.Field3982.getValue(), this.Field3999.getValue(), this.Field3987.getValue()) || EntityUtil.Method2163536((Entity) AutoTrap.Field2811.player).equals((Object) EntityUtil.Method2163536((Entity) entityPlayer2)) && this.Field3994.getValue().booleanValue() || AliceMain.Field757.Method2150312(entityPlayer2) > this.Field3993.getValue())
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                d2 = AutoTrap.Field2811.player.getDistanceSq((Entity) entityPlayer2);
                continue;
            }
            if (!(AutoTrap.Field2811.player.getDistanceSq((Entity) entityPlayer2) < d2)) continue;
            entityPlayer = entityPlayer2;
            d2 = AutoTrap.Field2811.player.getDistanceSq((Entity) entityPlayer2);
        }
        return entityPlayer;
    }

    private void Method2150000(BlockPos blockPos) {
        if (this.Field4029 < this.Field3976.getValue() && AutoTrap.Field2811.player.getDistanceSq(blockPos) <= MathUtil.Method2163856(this.Field3978.getValue())) {
            Field3974 = true;
            if (this.Field4002.getValue().booleanValue() && this.Field4001.getValue().booleanValue()) {
                this.Field4023.put(blockPos, AutoTrap.Field2811.world.getBlockState(blockPos));
            }
            int n2 = AutoTrap.Field2811.player.inventory.currentItem;
            int n3 = InventoryUtil.Method2163778(BlockObsidian.class);
            int n4 = InventoryUtil.Method2163778(BlockEnderChest.class);
            if (n3 == -1 && n4 == -1) {
                this.Method2150391();
            }
            AutoTrap.Field2811.player.inventory.currentItem = n3 == -1 ? n4 : n3;
            AutoTrap.Field2811.playerController.updateController();
            this.Field4027 = this.Field4030 ? BlockUtil.Method2162824(blockPos, EnumHand.MAIN_HAND, true, this.Field4002.getValue() == false && this.Field4001.getValue() != false, this.Field4027) : BlockUtil.Method2162821(blockPos, EnumHand.MAIN_HAND, this.Field3981.getValue(), this.Field4002.getValue() == false && this.Field4001.getValue() != false, this.Field4027);
            AutoTrap.Field2811.player.inventory.currentItem = n2;
            AutoTrap.Field2811.playerController.updateController();
            this.Field4025 = true;
            ++this.Field4029;
        }
    }

    private boolean Method2161113(Object object) {
        return this.Field4009.getValue() != false && this.Field4008.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161114(Object object) {
        return this.Field4009.getValue() != false && this.Field4008.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161115(Object object) {
        return this.Field4009.getValue() != false && this.Field4008.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161116(Object object) {
        return this.Field4009.getValue() != false && this.Field4008.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161117(Object object) {
        return this.Field4008.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161118(Object object) {
        return this.Field4007.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161119(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161110(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161121(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161122(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161123(Object object) {
        return this.Field4008.getValue() != false && this.Field4005.getValue() != false;
    }

    private boolean Method2161124(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161125(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161126(Object object) {
        return this.Field4005.getValue();
    }

    private boolean Method2161127(Object object) {
        return this.Field4001.getValue();
    }

    private boolean Method2161128(Object object) {
        return this.Field3983.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OPEN;
    }

    private boolean Method2161129(Object object) {
        return this.Field3983.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.OPEN;
    }

    private boolean Method2161120(Object object) {
        return this.Field3983.getValue() != IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.STATIC;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        STATIC,
        SMART,
        OPEN;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        CLOSEST,
        UNTRAPPED;

    }
}

