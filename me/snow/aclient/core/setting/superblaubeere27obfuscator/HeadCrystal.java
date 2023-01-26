

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Arrays;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.BlockUtilsCr;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.InventoryUtilsCr;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class HeadCrystal
        extends Module {
    public Setting<Float> Field790 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(6.0f)));
    int Field789;
    boolean Field791;
    Entity Field792;
    boolean Field793;
    int Field794 = 0;
    int Field795;

    public HeadCrystal() {
        super("HeadCrystal", "CevBreaker skid from crberry", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    public void Method2161180() {
        this.Field792 = HeadCrystal.Field2811.world.loadedEntityList.stream().filter(this::Method2161193).findFirst().orElse(null);
    }

    @Override
    public void Method2150376() {
        int n2 = this.Method2161192(Items.DIAMOND_PICKAXE);
        int n3 = this.Method2161192(Items.END_CRYSTAL);
        int n4 = this.Method2161191(Blocks.OBSIDIAN);
        BlockPos[] arrblockPos = new BlockPos[]{new BlockPos(0, 0, 1), new BlockPos(0, 1, 1), new BlockPos(0, 1, 0)};
        int n5 = InventoryUtilsCr.Method2164100();
        if (n2 == -1 || n3 == -1 || n4 == -1) {
            Command.Method2159696("Pix or Crystal or Obsidian No Material");
            this.Method2150380();
            return;
        }
        if (this.Field792 == null || (double) this.Field792.getDistance((Entity) HeadCrystal.Field2811.player) > (double) this.Field790.getValue().floatValue()) {
            this.Method2161180();
        }
        if (this.Field792 != null) {
            Entity entity = this.Field792;
            if (entity instanceof EntityPlayer && !AliceMain.Field765.Method2150168(entity.getName())) {
                if (n3 == -1 || n3 != -1 || !((ItemStack) HeadCrystal.Field2811.player.inventory.offHandInventory.get(0)).getItem().getClass().equals(Item.getItemById((int) 426).getClass())) {
                    // empty if block
                }
                if (this.Field789 > 0) {
                    --this.Field789;
                } else {
                    switch (this.Field794) {
                        case 0: {
                            BlockPos blockPos = new BlockPos(entity);
                            for (BlockPos blockPos2 : arrblockPos) {
                                if (Arrays.asList(arrblockPos).indexOf((Object) blockPos2) != -1 && this.Field795 < 1) {
                                    this.Field793 = true;
                                    InventoryUtilsCr.Method2164211(n4);
                                } else {
                                    InventoryUtilsCr.Method2164211(n4);
                                }
                                BlockUtilsCr blockUtilsCr = BlockUtilsCr.Method2164103(blockPos.add((Vec3i) blockPos2), 0.0, true);
                                if (blockUtilsCr == null) continue;
                                blockUtilsCr.Method2164107(true);
                            }
                            InventoryUtilsCr.Method2164211(n3);
                            CrystalUtil.Method2164331(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ + 1.0));
                            ++this.Field794;
                            break;
                        }
                        case 1: {
                            InventoryUtilsCr.Method2164211(n2);
                            HeadCrystal.Field2811.playerController.onPlayerDamageBlock(new BlockPos(entity).add(0, 1, 1), EnumFacing.UP);
                            Field2811.getConnection().sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, new BlockPos(entity).add(0, 1, 1), EnumFacing.UP));
                            if (HeadCrystal.Field2811.world.isAirBlock(new BlockPos(entity).add(0, 1, 1))) {
                                for (Entity entity2 : HeadCrystal.Field2811.world.loadedEntityList) {
                                    if ((double) entity.getDistance(entity2) > (double) this.Field790.getValue().floatValue() || !(entity2 instanceof EntityEnderCrystal))
                                        continue;
                                    HeadCrystal.Field2811.playerController.attackEntity((EntityPlayer) HeadCrystal.Field2811.player, entity2);
                                }
                                this.Field791 = true;
                            }
                            if (this.Field795 < 1) {
                                HeadCrystal.Field2811.playerController.onPlayerDamageBlock(new BlockPos(entity).add(0, 1, 1), EnumFacing.UP);
                                this.Field789 += 30;
                            }
                            ++this.Field794;
                            break;
                        }
                        case 2: {
                            int n6 = 0;
                            for (Entity entity3 : HeadCrystal.Field2811.world.loadedEntityList) {
                                if ((double) entity.getDistance(entity3) > (double) this.Field790.getValue().floatValue() || !(entity3 instanceof EntityEnderCrystal))
                                    continue;
                                HeadCrystal.Field2811.playerController.attackEntity((EntityPlayer) HeadCrystal.Field2811.player, entity3);
                                ++n6;
                            }
                            if (n6 != 0 && !this.Field793) break;
                            ++this.Field794;
                            break;
                        }
                        case 3: {
                            BlockUtilsCr.Method2164102(BlockUtilsCr.Method2164103(new BlockPos(entity.posX, entity.posY + 1.0, entity.posZ + 1.0), 0.0, true), true);
                            InventoryUtilsCr.Method2164211(n4);
                            this.Field794 = 0;
                            ++this.Field795;
                        }
                    }
                }
                InventoryUtilsCr.Method2164211(n5);
                return;
            }
            InventoryUtilsCr.Method2164211(n5);
        }
    }

    @Override
    public void Method2150372() {
        this.Method2161180();
        this.Field794 = 0;
        this.Field791 = false;
        this.Field793 = false;
        this.Field795 = 0;
        this.Field789 = 0;
        super.Method2150372();
    }

    private int Method2161191(Block block) {
        for (int j = 0; j < 9; ++j) {
            if (!(HeadCrystal.Field2811.player.inventory.getStackInSlot(j).getItem() instanceof ItemBlock) || ((ItemBlock) HeadCrystal.Field2811.player.inventory.getStackInSlot(j).getItem()).getBlock() != block)
                continue;
            return j;
        }
        return -1;
    }

    private int Method2161192(Item item) {
        if (item == Items.END_CRYSTAL && HeadCrystal.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
            return 999;
        }
        for (int j = 0; j < 9; ++j) {
            if (HeadCrystal.Field2811.player.inventory.getStackInSlot(j).getItem() != item) {
                continue;
            }
            return j;
        }
        return -1;
    }

    private boolean Method2161193(Entity entity) {
        return entity != HeadCrystal.Field2811.player && entity instanceof EntityLivingBase && (double) entity.getDistance((Entity) HeadCrystal.Field2811.player) < (double) this.Field790.getValue().floatValue() && !AliceMain.Field765.Method2150168(entity.getName());
    }
}

