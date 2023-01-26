

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil2;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AutoTrapOy
        extends Module {
    public static boolean Field4536 = false;
    private final Setting<Integer> Field4537 = this.Method2150366(new Setting<Integer>("Delay", 50, 0, 250));
    private final Setting<Integer> Field4538 = this.Method2150366(new Setting<Integer>("BlocksPerTick", 8, 1, 30));
    private final Setting<Boolean> Field4539 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private final Setting<Boolean> Field4540 = this.Method2150366(new Setting<Boolean>("Raytrace", false));
    private final Setting<Boolean> Field4541 = this.Method2150366(new Setting<Boolean>("AntiScaffold", false));
    private final Setting<Boolean> Field4542 = this.Method2150366(new Setting<Boolean>("AntiStep", false));
    private final Setting<Boolean> Field4543 = this.Method2150366(new Setting<Boolean>("Packet", false));
    private final Timer Field4544 = new Timer();
    private final Map<BlockPos, Integer> Field4545 = new HashMap<BlockPos, Integer>();
    private final Timer Field4546 = new Timer();
    public EntityPlayer Field4547;
    private boolean Field4548 = false;
    private boolean Field4549;
    private boolean Field4550;
    private int Field4551;
    private int Field4552 = 0;
    private BlockPos Field4553 = null;
    private boolean Field4554 = false;

    public AutoTrapOy() {
        super("AutoTrapOyVeyy", "Traps other players", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private static double Method2161399(Vec3d vec3d) {
        return vec3d.y;
    }

    private static int Method2161390(Vec3d vec3d, Vec3d vec3d2) {
        return Double.compare(AutoTrapOy.Field2811.player.getDistanceSq(vec3d2.x, vec3d2.y, vec3d2.z), AutoTrapOy.Field2811.player.getDistanceSq(vec3d.x, vec3d.y, vec3d.z));
    }

    @Override
    public void Method2150372() {
        if (AutoTrapOy.Method2150359()) {
            return;
        }
        this.Field4553 = EntityUtil.Method2163536((Entity) AutoTrapOy.Field2811.player);
        this.Field4551 = AutoTrapOy.Field2811.player.inventory.currentItem;
        this.Field4545.clear();
    }

    @Override
    public void Method2150376() {
        if (AutoTrapOy.Method2150359()) {
            return;
        }
        this.Method2161393();
    }

    @Override
    public String Method2150385() {
        if (this.Field4547 != null) {
            return this.Field4547.getName();
        }
        return null;
    }

    @Override
    public void Method2150373() {
        Field4536 = false;
        this.Field4550 = EntityUtil.Method2163401(this.Field4550);
    }

    private void Method2161393() {
        if (this.Method2161396()) {
            return;
        }
        this.Method2161394();
        if (this.Field4548) {
            this.Field4544.Method2164750();
        }
    }

    private void Method2161394() {
        List<Vec3d> list = EntityUtil2.Method2164448(this.Field4547.getPositionVector(), this.Field4541.getValue(), this.Field4542.getValue(), false, false, false, this.Field4540.getValue());
        this.Method2161395(list);
    }

    private void Method2161395(List<Vec3d> list) {
        list.sort(AutoTrapOy::Method2161390);
        list.sort(Comparator.comparingDouble(AutoTrapOy::Method2161399));
        for (Vec3d vec3d : list) {
            BlockPos blockPos = new BlockPos(vec3d);
            int n2 = BlockUtil.Method2162815(blockPos, this.Field4540.getValue());
            if (n2 == 1 && (this.Field4545.get((Object) blockPos) == null || this.Field4545.get((Object) blockPos) < 4)) {
                this.Method2161398(blockPos);
                this.Field4545.put(blockPos, this.Field4545.get((Object) blockPos) == null ? 1 : this.Field4545.get((Object) blockPos) + 1);
                this.Field4546.Method2164750();
                continue;
            }
            if (n2 != 3) continue;
            this.Method2161398(blockPos);
        }
    }

    private boolean Method2161396() {
        Field4536 = false;
        this.Field4548 = false;
        this.Field4552 = 0;
        int n2 = InventoryUtil.Method2163778(BlockObsidian.class);
        if (n2 == -1) {
            this.Method2150391();
        }
        int n3 = InventoryUtil.Method2163778(BlockObsidian.class);
        if (this.Method2150387()) {
            return true;
        }
        if (!this.Field4553.equals((Object) EntityUtil.Method2163536((Entity) AutoTrapOy.Field2811.player))) {
            this.Method2150380();
            return true;
        }
        if (this.Field4546.Method2164755(2000L)) {
            this.Field4545.clear();
            this.Field4546.Method2164750();
        }
        if (n3 == -1) {
            Command.Method2159696("<" + this.Method2150392() + "> " + (Object) ChatFormatting.RED + "No Obsidian in hotbar disabling...");
            this.Method2150380();
            return true;
        }
        if (AutoTrapOy.Field2811.player.inventory.currentItem != this.Field4551 && AutoTrapOy.Field2811.player.inventory.currentItem != n3) {
            this.Field4551 = AutoTrapOy.Field2811.player.inventory.currentItem;
        }
        this.Field4550 = EntityUtil.Method2163401(this.Field4550);
        this.Field4547 = this.Method2161397(10.0, true);
        return this.Field4547 == null || !this.Field4544.Method2164755(this.Field4537.getValue().intValue());
    }

    private EntityPlayer Method2161397(double d, boolean bl) {
        EntityPlayer entityPlayer = null;
        double d2 = Math.pow(d, 2.0) + 1.0;
        for (EntityPlayer entityPlayer2 : AutoTrapOy.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d) || bl && EntityUtil2.Method2164438(entityPlayer2, this.Field4541.getValue(), this.Field4542.getValue(), false, false, false) || AliceMain.Field757.Method2150312(entityPlayer2) > 10.0)
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                d2 = AutoTrapOy.Field2811.player.getDistanceSq((Entity) entityPlayer2);
                continue;
            }
            if (!(AutoTrapOy.Field2811.player.getDistanceSq((Entity) entityPlayer2) < d2)) continue;
            entityPlayer = entityPlayer2;
            d2 = AutoTrapOy.Field2811.player.getDistanceSq((Entity) entityPlayer2);
        }
        return entityPlayer;
    }

    private void Method2161398(BlockPos blockPos) {
        if (this.Field4552 < this.Field4538.getValue() && AutoTrapOy.Field2811.player.getDistanceSq(blockPos) <= MathUtil.Method2163856(5.0)) {
            Field4536 = true;
            int n2 = AutoTrapOy.Field2811.player.inventory.currentItem;
            int n3 = InventoryUtil.Method2163778(BlockObsidian.class);
            int n4 = InventoryUtil.Method2163778(BlockEnderChest.class);
            if (n3 == -1 && n4 == -1) {
                this.Method2150391();
            }
            if (this.Field4539.getValue().booleanValue()) {
                AutoTrapOy.Field2811.player.inventory.currentItem = n3 == -1 ? n4 : n3;
                AutoTrapOy.Field2811.playerController.updateController();
                this.Field4550 = BlockUtil.Method2162821(blockPos, this.Field4554 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field4539.getValue(), this.Field4543.getValue(), this.Field4550);
                AutoTrapOy.Field2811.player.inventory.currentItem = n2;
                AutoTrapOy.Field2811.playerController.updateController();
            } else {
                AutoTrapOy.Field2811.player.inventory.currentItem = n3 == -1 ? n4 : n3;
                AutoTrapOy.Field2811.playerController.updateController();
                this.Field4550 = BlockUtil.Method2162821(blockPos, this.Field4554 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, this.Field4539.getValue(), this.Field4543.getValue(), this.Field4550);
                AutoTrapOy.Field2811.player.inventory.currentItem = n2;
                AutoTrapOy.Field2811.playerController.updateController();
            }
            this.Field4548 = true;
            ++this.Field4552;
        }
    }
}

