

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.gui.GuiHopper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InstantMine;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class Automine
        extends Module {
    public static EntityPlayer Field2753;
    public static BlockPos Field2759;
    private final Setting<Boolean> Field2754 = this.Method2150366(new Setting<Boolean>("MineCity", true));
    private final Setting<Boolean> Field2755 = this.Method2150366(new Setting<Boolean>("MineBurrow", true));
    private final Setting<Boolean> Field2756 = this.Method2150366(new Setting<Boolean>("ToggleOnInstantMine", true));
    private final Setting<Float> Field2757 = this.Method2150366(new Setting<Float>("CityMineRange", Float.valueOf(5.0f), Float.valueOf(1.0f), Float.valueOf(8.0f)));
    private final Setting<Double> Field2758 = this.Method2150366(new Setting<Double>("BurrowMineRange", 5.0, 1.0, 8.0));
    int Field2760 = 0;
    EntityPlayer Field2761;

    public Automine() {
        super("AutoMine", "Automatically dig the enemy's hole.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.PLAYER, true, false, false);
    }

    @Override
    public void Method2150372() {
        if (this.Field2756.getValue().booleanValue() && InstantMine.Method2162244().Method2150387()) {
            InstantMine.Method2162244().Method2150389();
        }
    }

    @Override
    public void Method2150376() {
        if (Automine.Method2150359()) {
            return;
        }
        if (this.Field2754.getValue().booleanValue()) {
            Field2753 = this.Method2162190(this.Field2757.getValue().floatValue());
            if (Field2753 == null) {
                return;
            }
            if (Field2753 == Automine.Field2811.player) {
                return;
            }
            BlockPos blockPos = new BlockPos(Automine.Field2753.posX, Automine.Field2753.posY, Automine.Field2753.posZ);
            if (!this.Method2162199(Field2753)) {
                if (InstantMine.Method2162244().Field4328.getValue().booleanValue()) {
                    if (this.Method2162101(blockPos.add(0, 1, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, 1));
                    } else if (this.Method2162101(blockPos.add(0, 1, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, -1));
                    } else if (this.Method2162101(blockPos.add(2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(1, 0, 0));
                    } else if (this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-1, 0, 0));
                    } else if (this.Method2162101(blockPos.add(2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(2, 0, 0));
                    } else if (this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-2, 0, 0));
                    } else if (this.Method2162101(blockPos.add(0, 1, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, -2));
                    } else if (this.Method2162101(blockPos.add(0, 1, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, 2));
                    } else if (this.Method2162101(blockPos.add(2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(2, 0, 0));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(1, 0, 0));
                        }
                    } else if (this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-2, 0, 0));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(-1, 0, 0));
                        }
                    } else if (this.Method2162101(blockPos.add(0, 1, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, -2));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(0, 0, -1));
                        }
                    } else if (this.Method2162101(blockPos.add(0, 1, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, 2));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(0, 0, 1));
                        }
                    } else if (this.Method2162101(blockPos.add(0, 2, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 1, 1));
                    } else if (this.Method2162101(blockPos.add(0, 2, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, 1));
                    } else if (this.Method2162101(blockPos.add(0, 2, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 0, -1));
                    } else if (this.Method2162101(blockPos.add(1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(1, 0, 0));
                    } else if (this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-1, 0, 0));
                    } else if (this.Method2162101(blockPos.add(1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(1, 1, 0));
                    } else if (this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-1, 1, 0));
                    } else if (this.Method2162101(blockPos.add(0, 2, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 1, -1));
                    } else if (this.Method2162101(blockPos.add(1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(1, 1, 0));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(1, 0, 0));
                        }
                    } else if (this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-1, 1, 0));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(-1, 0, 0));
                        }
                    } else if (this.Method2162101(blockPos.add(0, 2, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 1, -1));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(0, 0, -1));
                        }
                    } else if (this.Method2162101(blockPos.add(0, 2, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 1, 1));
                        if (InstantMine.Field4342 == null) {
                            this.Method2162198(blockPos.add(0, 0, 1));
                        }
                    } else if (this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-2, 1, 0));
                    } else if (this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(2, 1, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(2, 1, 0));
                    } else if (this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 2)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 1, 2));
                    } else if (this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, -2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -2)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 1, -2));
                    } else if (this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(-1, 2, 0));
                    } else if (this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 2, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 2, 0)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(1, 2, 0));
                    } else if (this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 2, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 2, 1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 2, 1));
                    } else if (this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 2, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 2, -1)).getBlock() != Blocks.BEDROCK) {
                        this.Method2162198(blockPos.add(0, 2, -1));
                    }
                } else if (this.Method2162101(blockPos.add(0, 1, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, 1));
                } else if (this.Method2162101(blockPos.add(0, 1, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, -1));
                } else if (this.Method2162101(blockPos.add(2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(1, 0, 0));
                } else if (this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-1, 0, 0));
                } else if (this.Method2162101(blockPos.add(2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(2, 0, 0));
                } else if (this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-2, 0, 0));
                } else if (this.Method2162101(blockPos.add(0, 1, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, -2));
                } else if (this.Method2162101(blockPos.add(0, 1, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, 2));
                } else if (this.Method2162101(blockPos.add(2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(2, 0, 0));
                } else if (this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-2, 0, 0));
                } else if (this.Method2162101(blockPos.add(0, 1, -2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, -2));
                } else if (this.Method2162101(blockPos.add(0, 1, 2)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, 2));
                } else if (this.Method2162101(blockPos.add(0, 2, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 1, 1));
                } else if (this.Method2162101(blockPos.add(0, 2, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, 1));
                } else if (this.Method2162101(blockPos.add(0, 2, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 0, -1));
                } else if (this.Method2162101(blockPos.add(1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(1, 0, 0));
                } else if (this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-1, 0, 0));
                } else if (this.Method2162101(blockPos.add(1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(1, 1, 0));
                } else if (this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-1, 1, 0));
                } else if (this.Method2162101(blockPos.add(0, 2, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 1, -1));
                } else if (this.Method2162101(blockPos.add(1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(1, 1, 0));
                } else if (this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-1, 1, 0));
                } else if (this.Method2162101(blockPos.add(0, 2, -1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 1, -1));
                } else if (this.Method2162101(blockPos.add(0, 2, 1)).getBlock() == Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 1, 1));
                } else if (this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-2, 1, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-2, 1, 0));
                } else if (this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(2, 1, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(2, 1, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(2, 1, 0));
                } else if (this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, 2)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, 2)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 1, 2));
                } else if (this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 0, -2)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, -2)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 1, -2)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 1, -2));
                } else if (this.Method2162101(blockPos.add(-1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 1, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(-1, 2, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(-1, 2, 0));
                } else if (this.Method2162101(blockPos.add(1, 0, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 1, 0)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(1, 2, 0)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(1, 2, 0)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(1, 2, 0));
                } else if (this.Method2162101(blockPos.add(0, 0, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, 1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 2, 1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 2, 1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 2, 1));
                } else if (this.Method2162101(blockPos.add(0, 0, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 1, -1)).getBlock() != Blocks.BEDROCK && this.Method2162101(blockPos.add(0, 2, -1)).getBlock() != Blocks.AIR && this.Method2162101(blockPos.add(0, 2, -1)).getBlock() != Blocks.BEDROCK) {
                    this.Method2162198(blockPos.add(0, 2, -1));
                }
            }
        }
        if (this.Field2755.getValue().booleanValue()) {
            if (Automine.Field2811.currentScreen instanceof GuiHopper) {
                return;
            }
            this.Field2761 = this.Method2162104(this.Field2758.getValue());
            if (this.Field2761 == null) {
                return;
            }
            if (this.Field2761 == Automine.Field2811.player) {
                return;
            }
            Field2759 = new BlockPos(this.Field2761.posX, this.Field2761.posY + 0.5, this.Field2761.posZ);
            if (this.Field2760 >= 0) {
                ++this.Field2760;
            }
            if (InstantMine.Field4339 != null && InstantMine.Field4339.equals((Object) Field2759) && this.Field2760 >= 60 && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.BEDROCK && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.AIR && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.WEB && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.REDSTONE_WIRE && !this.Method2162102() && !this.Method2162103() && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.WATER && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.LAVA) {
                Automine.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                Automine.Field2811.playerController.onPlayerDamageBlock(Field2759, BlockUtil.Method2162814(Field2759));
                this.Field2760 = 1;
            }
            if (InstantMine.Field4342 != null && InstantMine.Field4342.equals((Object) Field2759)) {
                return;
            }
            if (InstantMine.Field4339 != null) {
                if (InstantMine.Field4339.equals((Object) Field2759)) {
                    return;
                }
                if (InstantMine.Field4339.equals((Object) new BlockPos(Automine.Field2811.player.posX, Automine.Field2811.player.posY + 2.0, Automine.Field2811.player.posZ))) {
                    return;
                }
                if (InstantMine.Field4339.equals((Object) new BlockPos(Automine.Field2811.player.posX, Automine.Field2811.player.posY - 1.0, Automine.Field2811.player.posZ))) {
                    return;
                }
                if (Automine.Field2811.world.getBlockState(InstantMine.Field4339).getBlock() == Blocks.WEB) {
                    return;
                }
            }
            if (Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.AIR && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.BEDROCK && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.WEB && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.REDSTONE_WIRE && !this.Method2162102() && !this.Method2162103() && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.WATER && Automine.Field2811.world.getBlockState(Field2759).getBlock() != Blocks.LAVA) {
                Automine.Field2811.player.swingArm(EnumHand.MAIN_HAND);
                Automine.Field2811.playerController.onPlayerDamageBlock(Field2759, BlockUtil.Method2162814(Field2759));
                this.Field2760 = 1;
            }
        }
    }

    @Override
    public String Method2150385() {
        if (Field2753 != null) {
            return Field2753.getName();
        }
        return null;
    }

    private void Method2162198(BlockPos blockPos) {
        if (InstantMine.Field4342 != null && InstantMine.Field4342.equals((Object) blockPos)) {
            return;
        }
        if (InstantMine.Field4339 != null) {
            if (InstantMine.Field4339.equals((Object) blockPos)) {
                return;
            }
            if (InstantMine.Field4339.equals((Object) new BlockPos(Automine.Field2753.posX, Automine.Field2753.posY, Automine.Field2753.posZ)) && Automine.Field2811.world.getBlockState(new BlockPos(Automine.Field2753.posX, Automine.Field2753.posY, Automine.Field2753.posZ)).getBlock() != Blocks.AIR) {
                return;
            }
            if (InstantMine.Field4339.equals((Object) new BlockPos(Automine.Field2811.player.posX, Automine.Field2811.player.posY + 2.0, Automine.Field2811.player.posZ))) {
                return;
            }
            if (InstantMine.Field4339.equals((Object) new BlockPos(Automine.Field2811.player.posX, Automine.Field2811.player.posY - 1.0, Automine.Field2811.player.posZ))) {
                return;
            }
            if (Automine.Field2811.player.rotationPitch <= 90.0f && Automine.Field2811.player.rotationPitch >= 80.0f) {
                return;
            }
            if (Automine.Field2811.world.getBlockState(InstantMine.Field4339).getBlock() == Blocks.WEB) {
                return;
            }
        }
        Automine.Field2811.playerController.onPlayerDamageBlock(blockPos, BlockUtil.Method2162814(blockPos));
    }

    private boolean Method2162199(EntityPlayer entityPlayer) {
        return Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX + 1.2, entityPlayer.posY, entityPlayer.posZ)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX + 1.2, entityPlayer.posY + 1.0, entityPlayer.posZ)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX - 1.2, entityPlayer.posY, entityPlayer.posZ)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX - 1.2, entityPlayer.posY + 1.0, entityPlayer.posZ)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ + 1.2)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY + 1.0, entityPlayer.posZ + 1.2)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ - 1.2)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY + 1.0, entityPlayer.posZ - 1.2)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX + 2.2, entityPlayer.posY + 1.0, entityPlayer.posZ)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX + 2.2, entityPlayer.posY, entityPlayer.posZ)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX + 1.2, entityPlayer.posY, entityPlayer.posZ)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX - 2.2, entityPlayer.posY + 1.0, entityPlayer.posZ)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX - 2.2, entityPlayer.posY, entityPlayer.posZ)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX - 1.2, entityPlayer.posY, entityPlayer.posZ)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY + 1.0, entityPlayer.posZ + 2.2)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ + 2.2)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ + 1.2)).getBlock() == Blocks.AIR || Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY + 1.0, entityPlayer.posZ - 2.2)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ - 2.2)).getBlock() == Blocks.AIR & Automine.Field2811.world.getBlockState(new BlockPos(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ - 1.2)).getBlock() == Blocks.AIR;
    }

    private EntityPlayer Method2162190(double d) {
        EntityPlayer entityPlayer = null;
        double d2 = Math.pow(d, 2.0) + 1.0;
        for (EntityPlayer entityPlayer2 : Automine.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d) || AliceMain.Field757.Method2150312(entityPlayer2) > 10.0)
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                d2 = Automine.Field2811.player.getDistanceSq((Entity) entityPlayer2);
                continue;
            }
            if (Automine.Field2811.player.getDistanceSq((Entity) entityPlayer2) >= d2) continue;
            entityPlayer = entityPlayer2;
            d2 = Automine.Field2811.player.getDistanceSq((Entity) entityPlayer2);
        }
        return entityPlayer;
    }

    private IBlockState Method2162101(BlockPos blockPos) {
        return Automine.Field2811.world.getBlockState(blockPos);
    }

    private boolean Method2162102() {
        double d = Automine.Field2811.player.posY - 0.03;
        for (int j = MathHelper.floor((double) Automine.Field2811.player.posX); j < MathHelper.ceil((double) Automine.Field2811.player.posX); ++j) {
            for (int i2 = MathHelper.floor((double) Automine.Field2811.player.posZ); i2 < MathHelper.ceil((double) Automine.Field2811.player.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, MathHelper.floor((double) d), i2);
                if (!(Automine.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    private boolean Method2162103() {
        double d = Automine.Field2811.player.posY + 0.01;
        for (int j = MathHelper.floor((double) Automine.Field2811.player.posX); j < MathHelper.ceil((double) Automine.Field2811.player.posX); ++j) {
            for (int i2 = MathHelper.floor((double) Automine.Field2811.player.posZ); i2 < MathHelper.ceil((double) Automine.Field2811.player.posZ); ++i2) {
                BlockPos blockPos = new BlockPos(j, (int) d, i2);
                if (!(Automine.Field2811.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    private EntityPlayer Method2162104(double d) {
        EntityPlayer entityPlayer = null;
        double d2 = Math.pow(d, 2.0) + 1.0;
        for (EntityPlayer entityPlayer2 : Automine.Field2811.world.playerEntities) {
            if (EntityUtil.Method2163545((Entity) entityPlayer2, d) || AliceMain.Field757.Method2150312(entityPlayer2) > 10.0)
                continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                d2 = Automine.Field2811.player.getDistanceSq((Entity) entityPlayer2);
                continue;
            }
            if (Automine.Field2811.player.getDistanceSq((Entity) entityPlayer2) >= d2) continue;
            entityPlayer = entityPlayer2;
            d2 = Automine.Field2811.player.getDistanceSq((Entity) entityPlayer2);
        }
        return entityPlayer;
    }
}

