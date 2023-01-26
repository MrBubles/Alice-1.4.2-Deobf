

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockWeb
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Freecam;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.MathUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.UpdateWalkingPlayerEvent;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WebFill
        extends Module {
    public static boolean Field1520 = false;
    private final Setting<Integer> Field1521 = this.Method2150366(new Setting<Integer>("Delay/Place", 50, 0, 250));
    private final Setting<Integer> Field1522 = this.Method2150366(new Setting<Integer>("Block/Place", 8, 1, 30));
    private final Setting<Double> Field1523 = this.Method2150366(new Setting<Double>("TargetRange", 10.0, 0.0, 20.0));
    private final Setting<Double> Field1524 = this.Method2150366(new Setting<Double>("PlaceRange", 6.0, 0.0, 10.0));
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1525 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Target", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.CLOSEST));
    private final Setting<InventoryUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field1526 = this.Method2150366(new Setting<InventoryUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Switch", InventoryUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NORMAL));
    private final Setting<Boolean> Field1527 = this.Method2150366(new Setting<Boolean>("Rotate", true));
    private final Setting<Boolean> Field1528 = this.Method2150366(new Setting<Boolean>("Raytrace", false));
    private final Setting<Double> Field1529 = this.Method2150366(new Setting<Double>("Speed", 30.0, 0.0, 30.0));
    private final Setting<Boolean> Field1530 = this.Method2150366(new Setting<Boolean>("Upper", false));
    private final Setting<Boolean> Field1531 = this.Method2150366(new Setting<Boolean>("Lower", true));
    private final Setting<Boolean> Field1532 = this.Method2150366(new Setting<Boolean>("Y-1", false));
    private final Setting<Boolean> Field1533 = this.Method2150366(new Setting<Boolean>("AntiSelf", false));
    private final Setting<Integer> Field1534 = this.Method2150366(new Setting<Integer>("Updates", 3, 1, 3));
    private final Setting<Boolean> Field1535 = this.Method2150366(new Setting<Boolean>("Freecam", false));
    private final Setting<Boolean> Field1536 = this.Method2150366(new Setting<Boolean>("Info", false));
    private final Setting<Boolean> Field1537 = this.Method2150366(new Setting<Boolean>("TSelfMove", false));
    private final Setting<Boolean> Field1538 = this.Method2150366(new Setting<Boolean>("Packet", false));
    private final Timer Field1539 = new Timer();
    public EntityPlayer Field1540;
    private boolean Field1541 = false;
    private boolean Field1542;
    private boolean Field1543;
    private int Field1544;
    private int Field1545 = 0;
    private boolean Field1546 = false;
    private BlockPos Field1547 = null;

    public WebFill() {
        super("WebFill", "Traps other players in webs", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private static double Method2161331(Vec3d vec3d) {
        return vec3d.y;
    }

    private static int Method2161332(Vec3d vec3d, Vec3d vec3d2) {
        return Double.compare(WebFill.Field2811.player.getDistanceSq(vec3d2.x, vec3d2.y, vec3d2.z), WebFill.Field2811.player.getDistanceSq(vec3d.x, vec3d.y, vec3d.z));
    }

    @Override
    public void Method2150372() {
        if (WebFill.Method2150359()) {
            return;
        }
        this.Field1547 = EntityUtil.Method2163536((Entity) WebFill.Field2811.player);
        this.Field1544 = WebFill.Field2811.player.inventory.currentItem;
    }

    @Override
    public void Method2150376() {
        if (this.Field1534.getValue() == 3) {
            this.Field1546 = false;
            this.Method2161323();
        }
    }

    @SubscribeEvent
    public void Method2161322(UpdateWalkingPlayerEvent updateWalkingPlayerEvent) {
        if (updateWalkingPlayerEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 0 && this.Field1534.getValue() == 2) {
            this.Field1546 = this.Field1527.getValue() != false && this.Field1522.getValue() == 1;
            this.Method2161323();
        }
    }

    @Override
    public void Method2150379() {
        if (this.Field1534.getValue() == 1) {
            this.Field1546 = false;
            this.Method2161323();
        }
    }

    @Override
    public String Method2150385() {
        if (this.Field1536.getValue().booleanValue() && this.Field1540 != null) {
            return this.Field1540.getName();
        }
        return null;
    }

    @Override
    public void Method2150373() {
        Field1520 = false;
        this.Field1543 = EntityUtil.Method2163401(this.Field1543);
        this.Method2161320(true);
    }

    private void Method2161323() {
        if (this.Method2161327()) {
            return;
        }
        this.Method2161324();
        if (this.Field1541) {
            this.Field1539.Method2164750();
        }
    }

    private void Method2161324() {
        List<Vec3d> list = this.Method2161325();
        this.Method2161326(list);
    }

    private List<Vec3d> Method2161325() {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        Vec3d vec3d = this.Field1540.getPositionVector();
        if (this.Field1532.getValue().booleanValue()) {
            arrayList.add(vec3d.add(0.0, -1.0, 0.0));
        }
        if (this.Field1531.getValue().booleanValue()) {
            arrayList.add(vec3d);
        }
        if (this.Field1530.getValue().booleanValue()) {
            arrayList.add(vec3d.add(0.0, 1.0, 0.0));
        }
        return arrayList;
    }

    private void Method2161326(List<Vec3d> list) {
        list.sort(WebFill::Method2161332);
        list.sort(Comparator.comparingDouble(WebFill::Method2161331));
        for (Vec3d vec3d : list) {
            BlockPos blockPos = new BlockPos(vec3d);
            int n2 = BlockUtil.Method2162815(blockPos, this.Field1528.getValue());
            if (n2 != 3 && n2 != 1 || this.Field1533.getValue().booleanValue() && MathUtil.Method2163869(WebFill.Field2811.player.getPositionVector(), vec3d))
                continue;
            this.Method2161329(blockPos);
        }
    }

    private boolean Method2161327() {
        Field1520 = false;
        this.Field1541 = false;
        this.Field1545 = 0;
        int n2 = InventoryUtil.Method2163778(BlockWeb.class);
        if (this.Method2150387()) {
            return true;
        }
        if (this.Field1537.getValue().booleanValue() && !this.Field1547.equals((Object) EntityUtil.Method2163536((Entity) WebFill.Field2811.player))) {
            this.Method2150380();
            return true;
        }
        if (n2 == -1) {
            if (this.Field1526.getValue() != InventoryUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE) {
                if (this.Field1536.getValue().booleanValue()) {
                    Command.Method2159696("<" + this.Method2150392() + "> \u00a7cYou are out of Webs.");
                }
                this.Method2150380();
            }
            return true;
        }
        if (WebFill.Field2811.player.inventory.currentItem != this.Field1544 && WebFill.Field2811.player.inventory.currentItem != n2) {
            this.Field1544 = WebFill.Field2811.player.inventory.currentItem;
        }
        this.Method2161320(true);
        this.Field1543 = EntityUtil.Method2163401(this.Field1543);
        this.Field1540 = this.Method2161328(this.Field1523.getValue(), this.Field1525.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.UNTRAPPED);
        return this.Field1540 == null || AliceMain.Field756.Method2150180(Freecam.class).Method2150364() && this.Field1535.getValue() == false || !this.Field1539.Method2164755(this.Field1521.getValue().intValue()) || this.Field1526.getValue() == InventoryUtil.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.NONE && WebFill.Field2811.player.inventory.currentItem != InventoryUtil.Method2163778(BlockWeb.class);
    }

    private EntityPlayer Method2161328(double d, boolean bl) {
        EntityPlayer entityPlayer = null;
        double d2 = Math.pow(d, 2.0) + 1.0;
        for (EntityPlayer entityPlayer2 : WebFill.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d) || bl && entityPlayer2.isInWeb || EntityUtil.Method2163536((Entity) WebFill.Field2811.player).equals((Object) EntityUtil.Method2163536((Entity) entityPlayer2)) && this.Field1533.getValue().booleanValue() || AliceMain.Field757.Method2150312(entityPlayer2) > this.Field1529.getValue())
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                d2 = WebFill.Field2811.player.getDistanceSq((Entity) entityPlayer2);
                continue;
            }
            if (!(WebFill.Field2811.player.getDistanceSq((Entity) entityPlayer2) < d2)) continue;
            entityPlayer = entityPlayer2;
            d2 = WebFill.Field2811.player.getDistanceSq((Entity) entityPlayer2);
        }
        return entityPlayer;
    }

    private void Method2161329(BlockPos blockPos) {
        if (this.Field1545 < this.Field1522.getValue() && WebFill.Field2811.player.getDistanceSq(blockPos) <= MathUtil.Method2163856(this.Field1524.getValue()) && this.Method2161320(false)) {
            Field1520 = true;
            this.Field1543 = this.Field1546 ? BlockUtil.Method2162824(blockPos, EnumHand.MAIN_HAND, true, this.Field1538.getValue(), this.Field1543) : BlockUtil.Method2162810(blockPos, EnumHand.MAIN_HAND, this.Field1527.getValue(), this.Field1538.getValue(), this.Field1543);
            this.Field1541 = true;
            ++this.Field1545;
        }
    }

    private boolean Method2161320(boolean bl) {
        boolean[] arrbl = InventoryUtil.Method2163794(bl, this.Field1544, this.Field1542, this.Field1526.getValue(), BlockWeb.class);
        this.Field1542 = arrbl[0];
        return arrbl[1];
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        CLOSEST,
        UNTRAPPED;

    }
}

