

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.MoverType
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
import net.minecraft.entity.MoverType;
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

public class CevBreaker
        extends Module {
    public Setting<Float> Field1629 = this.Method2150366(new Setting<Float>("Range", Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(6.0f)));
    int Field1628;
    boolean Field1630;
    Entity Field1631;
    boolean Field1632;
    int Field1633 = 0;
    int Field1634;

    public CevBreaker() {
        super("CevBreaker", "CevBreaker skid from crberry", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.COMBAT, true, false, false);
    }

    private int Method2161170(Item item) {
        if (item == Items.END_CRYSTAL && CevBreaker.Field2811.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
            return 999;
        }
        for (int j = 0; j < 9; ++j) {
            if (CevBreaker.Field2811.player.inventory.getStackInSlot(j).getItem() != item) {
                continue;
            }
            return j;
        }
        return -1;
    }

    @Override
    public void Method2150372() {
        this.Method2161182();
        this.Field1633 = 0;
        this.Field1630 = false;
        this.Field1632 = false;
        this.Field1634 = 0;
        this.Field1628 = 0;
        super.Method2150372();
    }

    @Override
    public void Method2150376() {
        int n2 = this.Method2161170(Items.DIAMOND_PICKAXE);
        int n3 = this.Method2161170(Items.END_CRYSTAL);
        int n4 = this.Method2161181(Blocks.OBSIDIAN);
        BlockPos[] arrblockPos = new BlockPos[]{new BlockPos(0, 0, 1), new BlockPos(0, 1, 1), new BlockPos(0, 2, 1), new BlockPos(0, 2, 0)};
        int n5 = InventoryUtilsCr.Method2164100();
        if (n2 == -1 || n3 == -1 || n4 == -1) {
            Command.Method2159696("Pix or Crystal or Obsidian No Material");
            this.Method2150380();
            return;
        }
        if (this.Field1631 == null || (double) this.Field1631.getDistance((Entity) CevBreaker.Field2811.player) > (double) this.Field1629.getValue().floatValue()) {
            this.Method2161182();
        }
        if (this.Field1631 != null) {
            Entity entity = this.Field1631;
            if (entity instanceof EntityPlayer && !AliceMain.Field765.Method2150168(entity.getName())) {
                if (n3 == -1 || n3 != -1 || !((ItemStack) CevBreaker.Field2811.player.inventory.offHandInventory.get(0)).getItem().getClass().equals(Item.getItemById((int) 426).getClass())) {
                    // empty if block
                }
                if (this.Field1628 > 0) {
                    --this.Field1628;
                } else {
                    entity.move(MoverType.SELF, 0.0, -2.0, 0.0);
                    switch (this.Field1633) {
                        case 0: {
                            BlockPos blockPos = new BlockPos(entity);
                            for (BlockPos blockPos2 : arrblockPos) {
                                if (Arrays.asList(arrblockPos).indexOf((Object) blockPos2) != -1 && this.Field1634 < 1) {
                                    this.Field1632 = true;
                                    InventoryUtilsCr.Method2164211(n4);
                                } else {
                                    InventoryUtilsCr.Method2164211(n4);
                                }
                                BlockUtilsCr blockUtilsCr = BlockUtilsCr.Method2164103(blockPos.add((Vec3i) blockPos2), 0.0, true);
                                if (blockUtilsCr == null) continue;
                                blockUtilsCr.Method2164107(true);
                            }
                            InventoryUtilsCr.Method2164211(n3);
                            CrystalUtil.Method2164331(new BlockPos(entity.posX, entity.posY + 3.0, entity.posZ));
                            ++this.Field1633;
                            break;
                        }
                        case 1: {
                            InventoryUtilsCr.Method2164211(n2);
                            CevBreaker.Field2811.playerController.onPlayerDamageBlock(new BlockPos(entity).add(0, 2, 0), EnumFacing.UP);
                            Field2811.getConnection().sendPacket((Packet) new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, new BlockPos(entity).add(0, 2, 0), EnumFacing.UP));
                            if (CevBreaker.Field2811.world.isAirBlock(new BlockPos(entity).add(0, 2, 0))) {
                                for (Entity entity2 : CevBreaker.Field2811.world.loadedEntityList) {
                                    if ((double) entity.getDistance(entity2) > (double) this.Field1629.getValue().floatValue() || !(entity2 instanceof EntityEnderCrystal))
                                        continue;
                                    CevBreaker.Field2811.playerController.attackEntity((EntityPlayer) CevBreaker.Field2811.player, entity2);
                                }
                                this.Field1630 = true;
                            }
                            if (this.Field1634 < 1) {
                                CevBreaker.Field2811.playerController.onPlayerDamageBlock(new BlockPos(entity).add(0, 2, 0), EnumFacing.UP);
                                this.Field1628 += 30;
                            }
                            ++this.Field1633;
                            break;
                        }
                        case 2: {
                            int n6 = 0;
                            for (Entity entity3 : CevBreaker.Field2811.world.loadedEntityList) {
                                if ((double) entity.getDistance(entity3) > (double) this.Field1629.getValue().floatValue() || !(entity3 instanceof EntityEnderCrystal))
                                    continue;
                                CevBreaker.Field2811.playerController.attackEntity((EntityPlayer) CevBreaker.Field2811.player, entity3);
                                ++n6;
                            }
                            if (n6 != 0 && !this.Field1632) break;
                            ++this.Field1633;
                            break;
                        }
                        case 3: {
                            BlockUtilsCr.Method2164102(BlockUtilsCr.Method2164103(new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ), 0.0, true), true);
                            InventoryUtilsCr.Method2164211(n4);
                            this.Field1633 = 0;
                            ++this.Field1634;
                        }
                    }
                }
                InventoryUtilsCr.Method2164211(n5);
                return;
            }
            InventoryUtilsCr.Method2164211(n5);
        }
    }

    private int Method2161181(Block block) {
        for (int j = 0; j < 9; ++j) {
            if (!(CevBreaker.Field2811.player.inventory.getStackInSlot(j).getItem() instanceof ItemBlock) || ((ItemBlock) CevBreaker.Field2811.player.inventory.getStackInSlot(j).getItem()).getBlock() != block)
                continue;
            return j;
        }
        return -1;
    }

    public void Method2161182() {
        this.Field1631 = CevBreaker.Field2811.world.loadedEntityList.stream().filter(this::Method2161183).findFirst().orElse(null);
    }

    private boolean Method2161183(Entity entity) {
        return entity != CevBreaker.Field2811.player && entity instanceof EntityLivingBase && (double) entity.getDistance((Entity) CevBreaker.Field2811.player) < (double) this.Field1629.getValue().floatValue() && !AliceMain.Field765.Method2150168(entity.getName());
    }
}

