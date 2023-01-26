

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.BlockSnow
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoCrystal;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PlayerUtilSC;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SurroundRewrite
        extends Module {
    public static boolean Field361;
    private static SurroundRewrite Field336;

    static {
        Field361 = false;
    }

    private final Setting<Boolean> Field337 = this.Method2150366(new Setting<Boolean>("Packets", false));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field338 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("TP Center", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None));
    private final Setting<Boolean> Field339 = this.Method2150366(new Setting<Boolean>("Rotate", false));
    private final Setting<Integer> Field340 = this.Method2150366(new Setting<Integer>("Delay/Place", 0, 0, 250));
    private final Setting<Integer> Field341 = this.Method2150366(new Setting<Integer>("Block/Place", 12, 1, 20));
    private final Setting<Boolean> Field342 = this.Method2150366(new Setting<Boolean>("AllowEChests", true));
    private final Setting<Boolean> Field343 = this.Method2150366(new Setting<Boolean>("DisplayInfo", false));
    private final Setting<Boolean> Field344 = this.Method2150366(new Setting<Boolean>("HelpingBlocks", true));
    private final Setting<Boolean> Field345 = this.Method2150366(new Setting<Boolean>("AlwaysHelp", false));
    private final Setting<Boolean> Field346 = this.Method2150366(new Setting<Boolean>("Attack", false));
    private final Setting<Integer> Field347 = this.Method2150366(new Setting<Integer>("Retry", 4, 1, 15));
    private final Setting<Integer> Field348 = this.Method2150366(new Setting<Integer>("Extend", 1, 0, 4));
    private final Timer Field349;
    private final Timer Field350;
    private final Set<Vec3d> Field359;
    private final Map<BlockPos, Integer> Field364;
    Vec3d Field357 = Vec3d.ZERO;
    private int Field351;
    private BlockPos Field352;
    private boolean Field353;
    private boolean Field354;
    private int Field355;
    private boolean Field356;
    private int Field358;
    private int Field360;
    private int Field362;
    private boolean Field363;

    public SurroundRewrite() {
        super("Surround", "awa surround", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
        Field336 = this;
        this.Field349 = new Timer();
        this.Field350 = new Timer();
        this.Field353 = false;
        this.Field358 = 0;
        this.Field359 = new HashSet<Vec3d>();
        this.Field360 = 1;
        this.Field362 = -1;
        this.Field363 = false;
        this.Field364 = new HashMap<BlockPos, Integer>();
    }

    public static SurroundRewrite Method2161644() {
        if (Field336 == null) {
            Field336 = new SurroundRewrite();
        }
        return Field336;
    }

    public static Vec3d[] Method2161647(Entity entity, int n2) {
        List<Vec3d> list = SurroundRewrite.Method2161648(entity, n2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2161648(Entity entity, int n2) {
        return SurroundRewrite.Method2161640(entity.getPositionVector(), n2);
    }

    public static Vec3d[] Method2161649(Vec3d vec3d, int n2) {
        List<Vec3d> list = SurroundRewrite.Method2161640(vec3d, n2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2161640(Vec3d vec3d, int n2) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(4);
        for (Vec3d vec3d2 : SurroundRewrite.Method2161651(n2)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = SurroundRewrite.Field2811.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow))
                continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static Vec3d[] Method2161651(int n2) {
        List<Vec3d> list = SurroundRewrite.Method2161652(n2);
        Vec3d[] arrvec3d = new Vec3d[list.size()];
        return list.toArray((T[]) arrvec3d);
    }

    public static List<Vec3d> Method2161652(int n2) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(4);
        arrayList.add(new Vec3d(-1.0, (double) n2, 0.0));
        arrayList.add(new Vec3d(1.0, (double) n2, 0.0));
        arrayList.add(new Vec3d(0.0, (double) n2, -1.0));
        arrayList.add(new Vec3d(0.0, (double) n2, 1.0));
        return arrayList;
    }

    @Override
    public void Method2150372() {
        if (SurroundRewrite.Method2150359()) {
            this.Method2150380();
        }
        super.Method2150372();
        this.Field355 = SurroundRewrite.Field2811.player.inventory.currentItem;
        this.Field352 = EntityUtil.Method2163536((Entity) SurroundRewrite.Field2811.player);
        this.Field357 = EntityUtil.Method2163482(SurroundRewrite.Field2811.player.posX, SurroundRewrite.Field2811.player.posY, SurroundRewrite.Field2811.player.posZ);
        if (!EntityUtil.Method2163470((EntityPlayer) SurroundRewrite.Field2811.player)) {
            switch (1.F ield3088[this.Field338.getValue().ordinal()]){
                case 1: {
                    AliceMain.Field758.Method2150253((double) this.Field352.getX() + 0.5, this.Field352.getY(), (double) this.Field352.getZ() + 0.5, true, true, true);
                }
                case 2: {
                    PlayerUtilSC.Method2162931((this.Field357.x - SurroundRewrite.Field2811.player.posX) / 2.0, SurroundRewrite.Field2811.player.motionY, (this.Field357.z - SurroundRewrite.Field2811.player.posZ) / 2.0);
                }
            }
        }
        this.Field364.clear();
        this.Field350.Method2164750();
    }

    @Override
    public void Method2150376() {
        this.Method2161645();
    }

    @Override
    public void Method2150373() {
        if (SurroundRewrite.Method2150358()) {
            return;
        }
        super.Method2150373();
        Field361 = false;
        this.Field356 = EntityUtil.Method2163401(this.Field356);
    }

    @Override
    public String Method2150385() {
        if (!this.Field343.getValue().booleanValue()) {
            return null;
        }
        switch (this.Field351) {
            case 0: {
                return (Object) ChatFormatting.RED + "Unsafe";
            }
            case 1: {
                return (Object) ChatFormatting.YELLOW + "Safe";
            }
        }
        return (Object) ChatFormatting.GREEN + "Safe";
    }

    private void Method2161645() {
        if (this.Method2161656()) {
            return;
        }
        if (!EntityUtil2.Method2164414((Entity) SurroundRewrite.Field2811.player, 0, true)) {
            this.Field351 = 0;
            this.Method2161655(SurroundRewrite.Field2811.player.getPositionVector(), EntityUtil2.Method2164435((Entity) SurroundRewrite.Field2811.player, 0, true), true, false, false);
        } else if (!EntityUtil2.Method2164414((Entity) SurroundRewrite.Field2811.player, -1, false)) {
            this.Field351 = 1;
            this.Method2161655(SurroundRewrite.Field2811.player.getPositionVector(), EntityUtil2.Method2164435((Entity) SurroundRewrite.Field2811.player, -1, false), false, false, true);
        } else {
            this.Field351 = 2;
        }
        this.Method2161653();
        if (this.Field353) {
            this.Field349.Method2164750();
        }
        boolean bl = SurroundRewrite.Field2811.world.getBlockState(new BlockPos(SurroundRewrite.Field2811.player.getPositionVector())).getBlock() == Blocks.ENDER_CHEST;
        boolean bl2 = bl;
        if (SurroundRewrite.Field2811.player.posY - (double) ((int) SurroundRewrite.Field2811.player.posY) < 0.7) {
            bl = false;
        }
        if (!this.Method2161646((Entity) SurroundRewrite.Field2811.player, bl ? 1 : 0)) {
            this.Method2161655(SurroundRewrite.Field2811.player.getPositionVector(), SurroundRewrite.Method2161647((Entity) SurroundRewrite.Field2811.player, bl ? 1 : 0), this.Field344.getValue(), false, false);
        } else if (!this.Method2161646((Entity) SurroundRewrite.Field2811.player, bl ? 0 : -1) && this.Field345.getValue().booleanValue()) {
            this.Method2161655(SurroundRewrite.Field2811.player.getPositionVector(), SurroundRewrite.Method2161647((Entity) SurroundRewrite.Field2811.player, bl ? 0 : -1), false, false, true);
        }
    }

    public boolean Method2161646(Entity entity, int n2) {
        return SurroundRewrite.Method2161648(entity, n2).size() == 0;
    }

    private void Method2161653() {
        if (this.Field359.size() == 2 && this.Field360 < this.Field348.getValue()) {
            Vec3d[] arrvec3d = new Vec3d[2];
            int n2 = 0;
            Iterator<Vec3d> iterator = this.Field359.iterator();
            while (iterator.hasNext()) {
                Vec3d vec3d = arrvec3d[n2] = iterator.next();
                ++n2;
            }
            if (this.Field346.getValue().booleanValue()) {
                BlockUtil.Method2162790(new BlockPos(this.Method2161654((Vec3d[]) arrvec3d).x, this.Method2161654((Vec3d[]) arrvec3d).y, this.Method2161654((Vec3d[]) arrvec3d).z), AutoCrystal.Method2150936().Field88.getValue().floatValue());
            }
            int n3 = this.Field358;
            if (this.Method2161654(arrvec3d) != null) {
                this.Method2161655(this.Method2161654(arrvec3d), EntityUtil2.Method2164436(this.Method2161654(arrvec3d), 0, this.Field344.getValue()), true, false, true);
            }
            if (n3 < this.Field358) {
                this.Field359.clear();
            }
        } else if (this.Field359.size() > 2 || this.Field360 >= this.Field348.getValue()) {
            this.Field359.clear();
        }
    }

    private Vec3d Method2161654(Vec3d[] arrvec3d) {
        int n2 = 0;
        for (Vec3d vec3d : arrvec3d) {
            for (Vec3d vec3d2 : EntityUtil2.Method2164435((Entity) SurroundRewrite.Field2811.player, 0, true)) {
                if (!vec3d.equals((Object) vec3d2)) continue;
                ++n2;
            }
        }
        if (n2 == 2) {
            return SurroundRewrite.Field2811.player.getPositionVector().add(arrvec3d[0].add(arrvec3d[1]));
        }
        return null;
    }

    private boolean Method2161655(Vec3d vec3d, Vec3d[] arrvec3d, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = true;
        block6:
        for (Vec3d vec3d2 : arrvec3d) {
            bl4 = true;
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            switch (BlockUtil.Method2162815(blockPos, false)) {
                case -1: {
                    continue block6;
                }
                case 1: {
                    if (this.Field364.get((Object) blockPos) == null || this.Field364.get((Object) blockPos) < this.Field347.getValue()) {
                        this.Method2161657(blockPos);
                        this.Field364.put(blockPos, this.Field364.get((Object) blockPos) == null ? 1 : this.Field364.get((Object) blockPos) + 1);
                        this.Field350.Method2164750();
                        continue block6;
                    }
                    if (this.Field348.getValue() <= 0 || bl3 || this.Field360 >= this.Field348.getValue())
                        continue block6;
                    this.Method2161655(SurroundRewrite.Field2811.player.getPositionVector().add(vec3d2), EntityUtil2.Method2164436(SurroundRewrite.Field2811.player.getPositionVector().add(vec3d2), 0, true), bl, false, true);
                    this.Field359.add(vec3d2);
                    ++this.Field360;
                    continue block6;
                }
                case 2: {
                    if (!bl) continue block6;
                    bl4 = this.Method2161655(vec3d, BlockUtil.Method2162826(vec3d2), false, true, true);
                }
                case 3: {
                    if (bl4) {
                        this.Method2161657(blockPos);
                    }
                    if (!bl2) continue block6;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Method2161656() {
        if (SurroundRewrite.Method2150358()) {
            return true;
        }
        int n2 = InventoryUtil.Method2163778(BlockObsidian.class);
        int n3 = InventoryUtil.Method2163778(BlockEnderChest.class);
        if (n2 == -1 && n3 == -1) {
            this.Method2150391();
        }
        this.Field363 = InventoryUtil.Method2163789(SurroundRewrite.Field2811.player.getHeldItemOffhand().getItem(), BlockObsidian.class);
        Field361 = false;
        this.Field353 = false;
        this.Field360 = 1;
        this.Field358 = 0;
        this.Field362 = InventoryUtil.Method2163778(BlockObsidian.class);
        int n4 = InventoryUtil.Method2163778(BlockEnderChest.class);
        if (this.Method2150387()) {
            return true;
        }
        if (this.Field350.Method2164755(2500L)) {
            this.Field364.clear();
            this.Field350.Method2164750();
        }
        if (this.Field362 == -1 && !this.Field363 && n4 == -1) {
            this.Field362 = n4;
            Command.Method2159696("Out of blocks, disabling " + (Object) ChatFormatting.RED + "Surround");
            this.Method2150380();
            return true;
        }
        if (this.Field362 == -1 && !this.Field363 && n4 == -1) {
            Command.Method2159696("<" + this.Method2150392() + "> " + (Object) ChatFormatting.RED + "No Obsidian in hotbar disabling...");
            this.Method2150380();
            return true;
        }
        this.Field356 = EntityUtil.Method2163401(this.Field356);
        if (SurroundRewrite.Field2811.player.inventory.currentItem != this.Field355 && SurroundRewrite.Field2811.player.inventory.currentItem != this.Field362 && SurroundRewrite.Field2811.player.inventory.currentItem != n4) {
            this.Field355 = SurroundRewrite.Field2811.player.inventory.currentItem;
        }
        if (!this.Field352.equals((Object) EntityUtil.Method2163536((Entity) SurroundRewrite.Field2811.player))) {
            this.Method2150380();
            return true;
        }
        return !this.Field349.Method2164755(this.Field340.getValue().intValue());
    }

    private void Method2161657(BlockPos blockPos) {
        if (this.Field358 < this.Field341.getValue()) {
            int n2 = SurroundRewrite.Field2811.player.inventory.currentItem;
            int n3 = InventoryUtil.Method2163778(BlockObsidian.class);
            int n4 = InventoryUtil.Method2163778(BlockEnderChest.class);
            if (n3 == -1 && n4 == -1) {
                this.Method2150391();
            }
            Field361 = true;
            SurroundRewrite.Field2811.player.inventory.currentItem = n3 == -1 ? n4 : n3;
            SurroundRewrite.Field2811.playerController.updateController();
            this.Field356 = BlockUtil.Method2162810(blockPos, this.Field363 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field339.getValue(), this.Field337.getValue(), this.Field356);
            SurroundRewrite.Field2811.player.inventory.currentItem = n2;
            SurroundRewrite.Field2811.playerController.updateController();
            this.Field353 = true;
            ++this.Field358;
        }
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        None,
        Instant,
        NCP;

    }
}

