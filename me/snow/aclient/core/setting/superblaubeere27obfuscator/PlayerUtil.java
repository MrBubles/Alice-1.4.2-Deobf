

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.mojang.util.UUIDTypeAdapter
 *  net.minecraft.advancements.AdvancementManager
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.apache.commons.io.IOUtils
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.util.UUIDTypeAdapter;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class PlayerUtil
        implements Util {
    public static Timer Field3934 = new Timer();
    private static JsonParser Field3935 = new JsonParser();

    public static double[] Method2163923(double d) {
        float f = PlayerUtil.Field2811.player.movementInput.moveForward;
        float f2 = PlayerUtil.Field2811.player.movementInput.moveStrafe;
        float f3 = PlayerUtil.Field2811.player.prevRotationYaw + (PlayerUtil.Field2811.player.rotationYaw - PlayerUtil.Field2811.player.prevRotationYaw) * Field2811.getRenderPartialTicks();
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

    public static double[] Method2163924(double d, EntityPlayerSP entityPlayerSP) {
        Minecraft minecraft = Minecraft.getMinecraft();
        float f = entityPlayerSP.movementInput.moveForward;
        float f2 = entityPlayerSP.movementInput.moveStrafe;
        float f3 = entityPlayerSP.prevRotationYaw + (entityPlayerSP.rotationYaw - entityPlayerSP.prevRotationYaw) * minecraft.getRenderPartialTicks();
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

    public static double Method2163925(Entity entity) {
        return PlayerUtil.Field2811.player.getDistance(entity);
    }

    public static double Method2163926(BlockPos blockPos) {
        return PlayerUtil.Field2811.player.getDistance((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ());
    }

    public static double Method2163927(Vec3d vec3d) {
        return PlayerUtil.Field2811.player.getDistance(vec3d.x, vec3d.y, vec3d.z);
    }

    public static boolean Method2163928() {
        return PlayerUtil.Field2811.player.movementInput.moveStrafe != 0.0f || PlayerUtil.Field2811.player.movementInput.moveForward != 0.0f;
    }

    public static void Method2163929(Vec3d vec3d, boolean bl) {
        float[] arrf = EntityUtil.Method2163489(vec3d);
        Util.Field2811.player.connection.sendPacket((Packet) new CPacketPlayer.Rotation(arrf[0], bl ? (float) MathHelper.normalizeAngle((int) ((int) arrf[1]), (int) 360) : arrf[1], Util.Field2811.player.onGround));
    }

    public static int Method2163920() {
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = PlayerUtil.Field2811.player.inventory.getStackInSlot(j);
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

    public static String Method2163931(UUID uUID) {
        try {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(uUID);
            Thread thread = new Thread(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
            thread.start();
            thread.join();
            return iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163919();
        } catch (Exception exception) {
            return null;
        }
    }

    public static boolean Method2163932(Entity entity) {
        BlockPos blockPos = new BlockPos(Math.floor(entity.getPositionVector().x), Math.floor(entity.getPositionVector().y + 0.2), Math.floor(entity.getPositionVector().z));
        return PlayerUtil.Field2811.world.getBlockState((BlockPos) blockPos.down()).getBlock().blockResistance >= 1200.0f && PlayerUtil.Field2811.world.getBlockState((BlockPos) blockPos.east()).getBlock().blockResistance >= 1200.0f && PlayerUtil.Field2811.world.getBlockState((BlockPos) blockPos.west()).getBlock().blockResistance >= 1200.0f && PlayerUtil.Field2811.world.getBlockState((BlockPos) blockPos.north()).getBlock().blockResistance >= 1200.0f && PlayerUtil.Field2811.world.getBlockState((BlockPos) blockPos.south()).getBlock().blockResistance >= 1200.0f;
    }

    public static String Method2163933(String string) {
        try {
            IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll = new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(string);
            Thread thread = new Thread(iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll);
            thread.start();
            thread.join();
            return iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Method2163919();
        } catch (Exception exception) {
            return null;
        }
    }

    public static UUID Method2163934(String string) {
        try {
            IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll = new IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(string);
            Thread thread = new Thread(iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll);
            thread.start();
            thread.join();
            return iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Method2163910();
        } catch (Exception exception) {
            return null;
        }
    }

    public static String Method2163935(String string) {
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
            String string3 = PlayerUtil.Method2163936(bufferedInputStream);
            ((InputStream) bufferedInputStream).close();
            httpURLConnection.disconnect();
            return string3;
        } catch (Exception exception) {
            return null;
        }
    }

    public static String Method2163936(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "/";
    }

    public static List<String> Method2163937(UUID uUID) {
        try {
            JsonArray jsonArray = PlayerUtil.Method2163939(new URL("https://api.mojang.com/user/profiles/" + PlayerUtil.Method2163938(uUID) + "/names"), "GET").getAsJsonArray();
            ArrayList arrayList = Lists.newArrayList();
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string = jsonObject.get("name").getAsString();
                long l2 = jsonObject.has("changedToAt") ? jsonObject.get("changedToAt").getAsLong() : 0L;
                arrayList.add(string + "\u00a78" + new Date(l2));
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception exception) {
            return null;
        }
    }

    public static String Method2163938(UUID uUID) {
        return uUID.toString().replaceAll("-", "");
    }

    private static JsonElement Method2163939(URL uRL, String string) throws Exception {
        return PlayerUtil.Method2163930(uRL, string, null);
    }

    private static JsonElement Method2163930(URL uRL, String string, JsonElement jsonElement) throws Exception {
        HttpsURLConnection httpsURLConnection = null;
        try {
            Closeable closeable;
            httpsURLConnection = (HttpsURLConnection) uRL.openConnection();
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod(string);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            if (jsonElement != null) {
                closeable = new DataOutputStream(httpsURLConnection.getOutputStream());
                ((DataOutputStream) closeable).writeBytes(AdvancementManager.GSON.toJson(jsonElement));
                ((FilterOutputStream) closeable).close();
            }
            closeable = new Scanner(httpsURLConnection.getInputStream());
            StringBuilder stringBuilder = new StringBuilder();
            while (((Scanner) closeable).hasNextLine()) {
                stringBuilder.append(((Scanner) closeable).nextLine());
                stringBuilder.append('\n');
            }
            ((Scanner) closeable).close();
            String string2 = stringBuilder.toString();
            JsonElement jsonElement2 = Field3935.parse(string2);
            return jsonElement2;
        } finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
        }
    }

    public static BlockPos Method2163941() {
        return new BlockPos(Math.floor(PlayerUtil.Field2811.player.posX), Math.floor(PlayerUtil.Field2811.player.posY), Math.floor(PlayerUtil.Field2811.player.posZ));
    }

    public static BlockPos Method2163942() {
        return new BlockPos(Math.floor(PlayerUtil.Field2811.player.posX), Math.floor(PlayerUtil.Field2811.player.posY), Math.floor(PlayerUtil.Field2811.player.posZ));
    }

    public static boolean Method2163943() {
        return PlayerUtil.Field2811.player != null && PlayerUtil.Field2811.player.getHeldItemMainhand().getItem() instanceof ItemFood && PlayerUtil.Field2811.player.isHandActive();
    }

    public static EntityPlayer Method2163944(double d) {
        EntityPlayer entityPlayer22;
        ArrayList<EntityPlayer> arrayList = new ArrayList<EntityPlayer>();
        for (EntityPlayer entityPlayer22 : PlayerUtil.Field2811.world.playerEntities) {
            if (entityPlayer22.getName().equals(PlayerUtil.Field2811.player.getName()) || AliceMain.Field765.Method2150168(entityPlayer22.getName()) || entityPlayer22.isDead || !((double) PlayerUtil.Field2811.player.getDistance((Entity) entityPlayer22) <= d))
                continue;
            arrayList.add(entityPlayer22);
        }
        EntityPlayer entityPlayer3 = null;
        entityPlayer22 = PlayerUtil.Field2811.player.getPositionEyes(Field2811.getRenderPartialTicks());
        Vec3d vec3d = PlayerUtil.Field2811.player.getLook(Field2811.getRenderPartialTicks());
        int n2 = 2;
        for (int j = 0; j < (int) d; ++j) {
            for (int i2 = n2; i2 > 0; --i2) {
                for (Entity entity : arrayList) {
                    AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
                    double d2 = entityPlayer22.x + vec3d.x * (double) j + vec3d.x / (double) i2;
                    double d3 = entityPlayer22.y + vec3d.y * (double) j + vec3d.y / (double) i2;
                    double d4 = entityPlayer22.z + vec3d.z * (double) j + vec3d.z / (double) i2;
                    if (!(axisAlignedBB.maxY >= d3) || !(axisAlignedBB.minY <= d3) || !(axisAlignedBB.maxX >= d2) || !(axisAlignedBB.minX <= d2) || !(axisAlignedBB.maxZ >= d4) || !(axisAlignedBB.minZ <= d4))
                        continue;
                    entityPlayer3 = (EntityPlayer) entity;
                }
            }
        }
        return entityPlayer3;
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            implements Runnable {
        private final String Field2906;
        private final UUID Field2907;
        private String Field2908;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string) {
            this.Field2906 = string;
            this.Field2907 = UUID.fromString(string);
        }

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(UUID uUID) {
            this.Field2907 = uUID;
            this.Field2906 = uUID.toString();
        }

        @Override
        public void run() {
            this.Field2908 = this.Method2163918();
        }

        public String Method2163918() {
            EntityPlayer entityPlayer = null;
            if (Util.Field2811.world != null) {
                entityPlayer = Util.Field2811.world.getPlayerEntityByUUID(this.Field2907);
            }
            if (entityPlayer == null) {
                String string = "https://api.mojang.com/user/profiles/" + this.Field2906.replace("-", "") + "/names";
                try {
                    String string2 = IOUtils.toString((URL) new URL(string));
                    JSONArray jSONArray = (JSONArray) JSONValue.parseWithException(string2);
                    String string3 = jSONArray.get(jSONArray.size() - 1).toString();
                    JSONObject jSONObject = (JSONObject) JSONValue.parseWithException(string3);
                    return jSONObject.get("name").toString();
                } catch (IOException | ParseException exception) {
                    exception.printStackTrace();
                    return null;
                }
            }
            return entityPlayer.getName();
        }

        public String Method2163919() {
            return this.Field2908;
        }
    }

    public static class IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll
            implements Runnable {
        static final boolean Field2007 = !PlayerUtil.class.desiredAssertionStatus();
        private final String Field2005;
        private UUID Field2006;

        public IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll(String string) {
            this.Field2005 = string;
        }

        @Override
        public void run() {
            NetworkPlayerInfo networkPlayerInfo;
            Object object;
            try {
                object = new ArrayList(Objects.requireNonNull(Util.Field2811.getConnection()).getPlayerInfoMap());
                networkPlayerInfo = object.stream().filter(this::Method2163922).findFirst().orElse(null);
                if (!Field2007 && networkPlayerInfo == null) {
                    throw new AssertionError();
                }
                this.Field2006 = networkPlayerInfo.getGameProfile().getId();
            } catch (Exception exception) {
                networkPlayerInfo = null;
            }
            if (networkPlayerInfo == null) {
                Command.Method2159696("Player isn't online. Looking up UUID..");
                object = PlayerUtil.Method2163935("[\"" + this.Field2005 + "\"]");
                if (object == null || ((String) object).isEmpty()) {
                    Command.Method2159696("Couldn't find player ID. Are you connected to the internet? (0)");
                } else {
                    JsonElement jsonElement = new JsonParser().parse((String) object);
                    if (jsonElement.getAsJsonArray().size() == 0) {
                        Command.Method2159696("Couldn't find player ID. (1)");
                    } else {
                        try {
                            String string = jsonElement.getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
                            this.Field2006 = UUIDTypeAdapter.fromString((String) string);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Command.Method2159696("Couldn't find player ID. (2)");
                        }
                    }
                }
            }
        }

        public UUID Method2163910() {
            return this.Field2006;
        }

        public String Method2163921() {
            return this.Field2005;
        }

        private boolean Method2163922(NetworkPlayerInfo networkPlayerInfo) {
            return networkPlayerInfo.getGameProfile().getName().equalsIgnoreCase(this.Field2005);
        }
    }
}

