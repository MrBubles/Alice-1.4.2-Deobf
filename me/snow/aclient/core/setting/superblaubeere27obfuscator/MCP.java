

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.world.World
 *  org.lwjgl.input.Mouse
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

public class MCP
        extends Module {
    private final Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field3852 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Mode", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MIDDLECLICK));
    private final Setting<Boolean> Field3853 = this.Method2150366(new Setting<Boolean>("AntiFriend", true));
    private final Setting<Boolean> Field3854 = this.Method2150366(new Setting<Boolean>("AboveHorizon", false));
    private final Setting<Boolean> Field3855 = this.Method2150366(new Setting<Boolean>("Skyonly", false));
    private boolean Field3856;

    public MCP() {
        super("MCP", "Throws a pearl", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, false, false, false);
    }

    @Override
    public void Method2150372() {
        if (!MCP.Method2150359() && this.Field3852.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.TOGGLE) {
            this.Method2162261();
            this.Method2150380();
        }
    }

    @Override
    public void Method2150376() {
        if (this.Field3852.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.MIDDLECLICK) {
            if (Mouse.isButtonDown((int) 2)) {
                if (!this.Field3856) {
                    this.Method2162261();
                }
                this.Field3856 = true;
            } else {
                this.Field3856 = false;
            }
        }
    }

    private void Method2162261() {
        boolean bl;
        RayTraceResult rayTraceResult;
        if (this.Field3853.getValue().booleanValue() && (rayTraceResult = MCP.Field2811.objectMouseOver) != null && rayTraceResult.typeOfHit == RayTraceResult.Type.ENTITY && rayTraceResult.entityHit instanceof EntityPlayer) {
            return;
        }
        if (this.Field3854.getValue().booleanValue() && MCP.Field2811.player.rotationPitch > 0.0f) {
            return;
        }
        if (this.Field3855.getValue().booleanValue() && (rayTraceResult = MCP.Field2811.objectMouseOver) != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
            return;
        }
        int n2 = InventoryUtil.Method2163778(ItemEnderPearl.class);
        boolean bl2 = bl = MCP.Field2811.player.getHeldItemOffhand().getItem() == Items.ENDER_PEARL;
        if (n2 != -1 || bl) {
            int n3 = MCP.Field2811.player.inventory.currentItem;
            if (!bl) {
                InventoryUtil.Method2163773(n2, false);
            }
            MCP.Field2811.playerController.processRightClick((EntityPlayer) MCP.Field2811.player, (World) MCP.Field2811.world, bl ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            if (!bl) {
                InventoryUtil.Method2163773(n3, false);
            }
        }
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        TOGGLE,
        MIDDLECLICK;

    }
}

