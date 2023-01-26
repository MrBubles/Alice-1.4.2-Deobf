

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonParser
 *  com.mojang.util.UUIDTypeAdapter
 *  javafx.util.Pair
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockConcretePowder
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.util.UUIDTypeAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import javafx.util.Pair;

import javax.annotation.Nullable;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CrystalUtilCa;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockConcretePowder;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class PlayerUtilCa
        implements Util {
    private static final BlockPos[] Field4034 = new BlockPos[]{new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};

    public static UUID Method2163172(String string) {
        try {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(string);
            Thread thread = new Thread(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll);
            thread.start();
            thread.join();
            return iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Method2163169();
        } catch (Exception exception) {
            return null;
        }
    }

    public static List<BlockPos> Method2163173(BlockPos blockPos, float f, int n2, boolean bl, boolean bl2, int n3) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n4 = blockPos.getX();
        int n5 = blockPos.getY();
        int n6 = blockPos.getZ();
        int n7 = n4 - (int) f;
        while ((float) n7 <= (float) n4 + f) {
            int n8 = n6 - (int) f;
            while ((float) n8 <= (float) n6 + f) {
                int n9 = bl2 ? n5 - (int) f : n5 - n2;
                while (true) {
                    float f2 = n9;
                    float f3 = bl2 ? (float) n5 + f : (float) (n5 + n2);
                    if (!(f2 < f3)) break;
                    double d = (n4 - n7) * (n4 - n7) + (n6 - n8) * (n6 - n8) + (bl2 ? (n5 - n9) * (n5 - n9) : 0);
                    if (!(!(d < (double) (f * f)) || bl && d < (double) ((f - 1.0f) * (f - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n7, n9 + n3, n8);
                        arrayList.add(blockPos2);
                    }
                    ++n9;
                }
                ++n8;
            }
            ++n7;
        }
        return arrayList;
    }

    public static BlockPos Method2163174() {
        return new BlockPos(Math.floor(PlayerUtilCa.Field2811.player.posX), Math.floor(PlayerUtilCa.Field2811.player.posY), Math.floor(PlayerUtilCa.Field2811.player.posZ));
    }

    public static BlockPos Method2163175(double d) {
        return new BlockPos(Math.floor(PlayerUtilCa.Field2811.player.posX), Math.floor(PlayerUtilCa.Field2811.player.posY + d), Math.floor(PlayerUtilCa.Field2811.player.posZ));
    }

    public static double[] Method2163176(double d) {
        float f = PlayerUtilCa.Field2811.player.movementInput.moveForward;
        float f2 = PlayerUtilCa.Field2811.player.movementInput.moveStrafe;
        float f3 = PlayerUtilCa.Field2811.player.prevRotationYaw + (PlayerUtilCa.Field2811.player.rotationYaw - PlayerUtilCa.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float) (f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float) (f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double) f * d * d3 + (double) f2 * d * d2;
        double d5 = (double) f * d * d2 - (double) f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static int Method2163177() {
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = PlayerUtilCa.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock)) continue;
            Block block = ((ItemBlock) itemStack.getItem()).getBlock();
            if (block instanceof BlockEnderChest) {
                return j;
            }
            if (!(block instanceof BlockObsidian)) continue;
            return j;
        }
        return -1;
    }

    public static int Method2163178() {
        for (int j = 0; j < 9; ++j) {
            Block block;
            ItemStack itemStack = PlayerUtilCa.Field2811.player.inventory.getStackInSlot(j);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock) itemStack.getItem()).getBlock()) instanceof BlockConcretePowder))
                continue;
            return j;
        }
        return -1;
    }

    public static String Method2163179(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String string = null;
        while ((string = bufferedReader.readLine()) != null) {
            stringBuilder.append(string + "\n");
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static boolean Method2163170() {
        BlockPos blockPos = PlayerUtilCa.Method2163174();
        return PlayerUtilCa.Field2811.world.getBlockState(blockPos.east()).getBlock() != Blocks.AIR && PlayerUtilCa.Field2811.world.getBlockState(blockPos.west()).getBlock() != Blocks.AIR && PlayerUtilCa.Field2811.world.getBlockState(blockPos.north()).getBlock() != Blocks.AIR && PlayerUtilCa.Field2811.world.getBlockState(blockPos.south()).getBlock() != Blocks.AIR;
    }

    public static String Method2163181(String string) {
        String string2 = "https://api.mojang.com/profiles/minecraft";
        try {
            URL uRL = new URL("https://api.mojang.com/profiles/minecraft");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRL.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(string.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            String string3 = PlayerUtilCa.Method2163179(bufferedInputStream);
            ((InputStream) bufferedInputStream).close();
            httpURLConnection.disconnect();
            return string3;
        } catch (Exception exception) {
            return null;
        }
    }

    public static boolean Method2163182(EntityLivingBase entityLivingBase) {
        return entityLivingBase.moveForward != 0.0f || entityLivingBase.moveStrafing != 0.0f;
    }

    public static void Method2163183(EntityLivingBase entityLivingBase, double d) {
        double[] arrd = PlayerUtilCa.Method2163176(d);
        entityLivingBase.motionX = arrd[0];
        entityLivingBase.motionZ = arrd[1];
    }

    public static double Method2163184() {
        double d = 0.2873;
        if (PlayerUtilCa.Field2811.player != null && PlayerUtilCa.Field2811.player.isPotionActive(Potion.getPotionById((int) 1))) {
            int n2 = PlayerUtilCa.Field2811.player.getActivePotionEffect(Potion.getPotionById((int) 1)).getAmplifier();
            d *= 1.0 + 0.2 * (double) (n2 + 1);
        }
        return d;
    }

    public static Item Method2163185(Block block) {
        String string = block.getHarvestTool(block.getDefaultState());
        if (string != null) {
            switch (string) {
                case "axe": {
                    return Items.DIAMOND_AXE;
                }
                case "shovel": {
                    return Items.DIAMOND_SHOVEL;
                }
            }
            return Items.DIAMOND_PICKAXE;
        }
        return Items.DIAMOND_PICKAXE;
    }

    public static ItemStack Method2163186(Item item) {
        if (PlayerUtilCa.Field2811.player == null) {
            return null;
        }
        for (int j = 0; j <= 9; ++j) {
            if (PlayerUtilCa.Field2811.player.inventory.getStackInSlot(j).getItem() != item) continue;
            return PlayerUtilCa.Field2811.player.inventory.getStackInSlot(j);
        }
        return null;
    }

    public static IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll Method2163187() {
        int n2 = (int) Math.floor(PlayerUtilCa.Field2811.player.getRotationYawHead());
        if (n2 <= 0) {
            n2 += 360;
        }
        n2 = (n2 % 360 + 360) % 360;
        int n3 = (n2 += 45) / 45;
        switch (n3) {
            case 0:
            case 1: {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SOUTH;
            }
            case 2:
            case 3: {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.WEST;
            }
            case 4:
            case 5: {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.NORTH;
            }
            case 6:
            case 7: {
                return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.EAST;
            }
        }
        return IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.SOUTH;
    }

    public static BlockPos Method2163188(Entity entity, @Nullable BlockPos blockPos) {
        Vec3d vec3d = entity.getPositionVector();
        if (blockPos == null) {
            return new BlockPos(vec3d.x, vec3d.y, vec3d.z);
        }
        return new BlockPos(vec3d.x, vec3d.y, vec3d.z).add((Vec3i) blockPos);
    }

    public static ArrayList<Pair<EntityPlayer, ArrayList<BlockPos>>> Method2163189() {
        ArrayList<Pair<EntityPlayer, ArrayList<BlockPos>>> arrayList = new ArrayList<Pair<EntityPlayer, ArrayList<BlockPos>>>();
        for (Entity entity : PlayerUtilCa.Field2811.world.playerEntities.stream().filter(PlayerUtilCa::Method2163180).collect(Collectors.toList())) {
            ArrayList<BlockPos> arrayList2 = new ArrayList<BlockPos>();
            for (int j = 0; j < 4; ++j) {
                BlockPos blockPos = PlayerUtilCa.Method2163188(entity, Field4034[j]);
                if (PlayerUtilCa.Field2811.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) continue;
                boolean bl = false;
                switch (j) {
                    case 0: {
                        bl = CrystalUtilCa.Method2162087(blockPos.north(1).down(), false, false);
                        break;
                    }
                    case 1: {
                        bl = CrystalUtilCa.Method2162087(blockPos.east(1).down(), false, false);
                        break;
                    }
                    case 2: {
                        bl = CrystalUtilCa.Method2162087(blockPos.south(1).down(), false, false);
                        break;
                    }
                    case 3: {
                        bl = CrystalUtilCa.Method2162087(blockPos.west(1).down(), false, false);
                    }
                }
                if (!bl) continue;
                arrayList2.add(blockPos);
            }
            if (arrayList2.isEmpty()) continue;
            arrayList.add((Pair<EntityPlayer, ArrayList<BlockPos>>) new Pair((Object) ((EntityPlayer) entity), arrayList2));
        }
        return arrayList;
    }

    private static boolean Method2163180(EntityPlayer entityPlayer) {
        return !AliceMain.Field765.Method2150168(entityPlayer.getName());
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NORTH,
        SOUTH,
        EAST,
        WEST;

    }

    public static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
            implements Runnable {
        static final boolean Field3084 = !PlayerUtilCa.class.desiredAssertionStatus();
        private final String Field3082;
        private UUID Field3083;

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(String string) {
            this.Field3082 = string;
        }

        @Override
        public void run() {
            JsonElement jsonElement;
            NetworkPlayerInfo networkPlayerInfo;
            Object object;
            try {
                object = new ArrayList(Objects.requireNonNull(Util.Field2811.getConnection()).getPlayerInfoMap());
                networkPlayerInfo = object.stream().filter(this::Method2163171).findFirst().orElse(null);
                if (!Field3084 && networkPlayerInfo == null) {
                    throw new AssertionError();
                }
                this.Field3083 = networkPlayerInfo.getGameProfile().getId();
            } catch (Exception exception) {
                networkPlayerInfo = null;
            }
            if (networkPlayerInfo == null && (object = PlayerUtilCa.Method2163181("[\"" + this.Field3082 + "\"]")) != null && !((String) object).isEmpty() && (jsonElement = new JsonParser().parse((String) object)).getAsJsonArray().size() != 0) {
                try {
                    String string = jsonElement.getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
                    this.Field3083 = UUIDTypeAdapter.fromString((String) string);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

        public UUID Method2163169() {
            return this.Field3083;
        }

        public String Method2163160() {
            return this.Field3082;
        }

        private boolean Method2163171(NetworkPlayerInfo networkPlayerInfo) {
            return networkPlayerInfo.getGameProfile().getName().equalsIgnoreCase(this.Field3082);
        }
    }
}

