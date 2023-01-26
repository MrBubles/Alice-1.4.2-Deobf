

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.passive.EntityCow
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMule
 *  net.minecraft.entity.passive.EntitySheep
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AutoRespawn;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ClientEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FileManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleTools;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.TextUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Notifications
        extends Module {
    private static final String Field4556 = "Alice/util/ModuleMessage_List.txt";
    private static final List<String> Field4557 = new ArrayList<String>();
    private static Notifications Field4558 = new Notifications();
    public final Setting<Boolean> Field4590 = this.Method2150366(new Setting<Boolean>("Weakness", true));
    public final Setting<Boolean> Field4591 = this.Method2150366(new Setting<Boolean>("Slowness", true));
    public final Setting<Boolean> Field4592 = this.Method2150366(new Setting<Boolean>("32kAlert", false));
    private final ConcurrentHashMap<EntityPlayer, Integer> Field4559 = new ConcurrentHashMap();
    private final Set<EntityPlayer> Field4560 = Collections.newSetFromMap(new WeakHashMap());
    private final Set<Entity> Field4566 = new HashSet<Entity>();
    private final Set<Entity> Field4567 = new HashSet<Entity>();
    private final Set<Entity> Field4568 = new HashSet<Entity>();
    private final Set<Entity> Field4569 = new HashSet<Entity>();
    private final Set<Entity> Field4570 = new HashSet<Entity>();
    private final Set<Entity> Field4571 = new HashSet<Entity>();
    private final Image Field4572 = Toolkit.getDefaultToolkit().getImage("resources/LuigiA.png");
    private final TrayIcon Field4573 = new TrayIcon(this.Field4572, "AliceClient");
    private final Timer Field4574 = new Timer();
    public Setting<Boolean> Field4575 = this.Method2150366(new Setting<Boolean>("TotemPops", false));
    public Setting<Boolean> Field4576 = this.Method2150366(new Setting<Object>("TotemNoti", Boolean.TRUE, this::Method2150727));
    public Setting<Integer> Field4577 = this.Method2150366(new Setting<Object>("Delay", 2000, 0, 5000, this::Method2150726, "Delays messages."));
    public Setting<Boolean> Field4578 = this.Method2150366(new Setting<Boolean>("LogoutClear", false));
    public Setting<Boolean> Field4579 = this.Method2150366(new Setting<Boolean>("ModuleMessage", true));
    private final Setting<Boolean> Field4581 = this.Method2150366(new Setting<Object>("LoadFile", Boolean.valueOf(false), this::Method2150724));
    public Setting<Boolean> Field4580 = this.Method2150366(new Setting<Object>("List", Boolean.FALSE, this::Method2150725));
    public Setting<Boolean> Field4582 = this.Method2150366(new Setting<Boolean>("VisualRange", false));
    public Setting<Boolean> Field4583 = this.Method2150366(new Setting<Boolean>("VisualRangeSound", false));
    public Setting<Boolean> Field4584 = this.Method2150366(new Setting<Object>("Coords", Boolean.TRUE, this::Method2150723));
    public Setting<Boolean> Field4585 = this.Method2150366(new Setting<Object>("Leaving", Boolean.FALSE, this::Method2150722));
    public Setting<Boolean> Field4586 = this.Method2150366(new Setting<Boolean>("PopUpVisualRange", false));
    public Setting<Boolean> Field4587 = this.Method2150366(new Setting<Boolean>("PearlNotif", false));
    public Setting<Boolean> Field4588 = this.Method2150366(new Setting<Boolean>("Burrow", false));
    public Setting<Boolean> Field4589 = this.Method2150366(new Setting<Boolean>("DeathCoords", false));
    public Setting<Boolean> Field4593 = this.Method2150366(new Setting<Boolean>("Crash", false));
    public Setting<Boolean> Field4594 = this.Method2150366(new Setting<Boolean>("EntityNotifier", false));
    public Setting<Boolean> Field4595 = this.Method2150366(new Setting<Boolean>("Chat", Boolean.valueOf(true), this::Method2150721));
    public Setting<Boolean> Field4596 = this.Method2150366(new Setting<Boolean>("Sound", Boolean.valueOf(true), this::Method2150710));
    public Setting<Boolean> Field4597 = this.Method2150366(new Setting<Boolean>("DesktopNotifs", Boolean.valueOf(false), this::Method2150719));
    public Setting<Boolean> Field4598 = this.Method2150366(new Setting<Boolean>("Ghasts", Boolean.valueOf(true), this::Method2150718));
    public Setting<Boolean> Field4599 = this.Method2150366(new Setting<Boolean>("Cow", Boolean.valueOf(false), this::Method2150717));
    public Setting<Boolean> Field4600 = this.Method2150366(new Setting<Boolean>("Sheep", Boolean.valueOf(false), this::Method2150716));
    public Setting<Boolean> Field4601 = this.Method2150366(new Setting<Boolean>("Donkeys", Boolean.valueOf(false), this::Method2150715));
    public Setting<Boolean> Field4602 = this.Method2150366(new Setting<Boolean>("Mules", Boolean.valueOf(false), this::Method2150714));
    public Setting<Boolean> Field4603 = this.Method2150366(new Setting<Boolean>("Llamas", Boolean.valueOf(false), this::Method2150713));
    public Timer Field4604 = new Timer();
    List<EntityPlayer> Field4561 = new ArrayList<EntityPlayer>();
    List<Entity> Field4562 = new ArrayList<Entity>();
    private boolean Field4563 = false;
    private boolean Field4564 = false;
    private boolean Field4565;
    private List<EntityPlayer> Field4605 = new ArrayList<EntityPlayer>();
    private boolean Field4606;

    public Notifications() {
        super("Notifications", "Sends Messages.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.CLIENT, true, false, false);
        this.Method2150603();
        this.Field4573.setImageAutoSize(true);
        try {
            SystemTray systemTray = SystemTray.getSystemTray();
            systemTray.add(this.Field4573);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Notifications Method2150601() {
        if (Field4558 == null) {
            Field4558 = new Notifications();
        }
        return Field4558;
    }

    public static void Method2150602(Exception exception) {
        Command.Method2159696("\u00a7cException caught: " + exception.getMessage());
    }

    private static boolean Method2150712(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    private void Method2150603() {
        Field4558 = this;
    }

    @Override
    public void Method2150375() {
        this.Field4606 = true;
        this.Method2150608();
        this.Field4606 = false;
    }

    private boolean Method2150604(ItemStack itemStack) {
        if (itemStack.getItem() instanceof ItemSword) {
            NBTTagList nBTTagList = itemStack.getEnchantmentTagList();
            for (int j = 0; j < nBTTagList.tagCount(); ++j) {
                if (nBTTagList.getCompoundTagAt(j).getShort("lvl") < 32767) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void Method2150372() {
        this.Field4605 = new ArrayList<EntityPlayer>();
        if (!this.Field4606) {
            this.Method2150608();
        }
        this.Field4565 = true;
        this.Field4559.clear();
        this.Field4561.clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void Method2150379() {
        Iterator<Object> iterator22;
        Object object2;
        if (this.Field4581.getValue().booleanValue()) {
            if (!this.Field4606) {
                Command.Method2159696("Loading File...");
                this.Field4574.Method2164750();
                this.Method2150608();
            }
            this.Field4606 = true;
        }
        if (this.Field4606 && this.Field4574.Method2164755(750L)) {
            this.Field4581.setValue(false);
            this.Field4606 = false;
        }
        if (this.Field4582.getValue().booleanValue()) {
            object2 = new ArrayList(Notifications.Field2811.world.playerEntities);
            if (((ArrayList) object2).size() > 0) {
                iterator22 = ((ArrayList) object2).iterator();
                while (iterator22.hasNext()) {
                    EntityPlayer object3 = (EntityPlayer) iterator22.next();
                    if (object3.getName().equals(Notifications.Field2811.player.getName()) || this.Field4605.contains((Object) object3))
                        continue;
                    this.Field4605.add(object3);
                    if (AliceMain.Field765.Method2150169(object3)) {
                        Command.Method2159695("Your Friend " + (Object) ChatFormatting.AQUA + object3.getName() + "\u00a7r entered your visual range" + (this.Field4584.getValue() != false ? " at (" + (int) object3.posX + ", " + (int) object3.posY + ", " + (int) object3.posZ + ")!" : "!"), this.Field4586.getValue());
                    } else {
                        Command.Method2159695("Player " + (Object) ChatFormatting.RED + object3.getName() + "\u00a7r" + (Object) ChatFormatting.RED + " entered " + (Object) ChatFormatting.RESET + "your visual range" + (this.Field4584.getValue() != false ? " at (" + (int) object3.posX + ", " + (int) object3.posY + ", " + (int) object3.posZ + ")!" : "!"), this.Field4586.getValue());
                    }
                    if (this.Field4583.getValue().booleanValue()) {
                        Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                    }
                    return;
                }
            }
            if (this.Field4605.size() > 0) {
                for (EntityPlayer entityPlayer : this.Field4605) {
                    if (((ArrayList) object2).contains((Object) entityPlayer)) continue;
                    this.Field4605.remove((Object) entityPlayer);
                    if (this.Field4585.getValue().booleanValue()) {
                        if (AliceMain.Field765.Method2150169(entityPlayer)) {
                            Command.Method2159695("Your Friend " + (Object) ChatFormatting.AQUA + entityPlayer.getName() + "\u00a7r left your visual range" + (this.Field4584.getValue() != false ? " at (" + (int) entityPlayer.posX + ", " + (int) entityPlayer.posY + ", " + (int) entityPlayer.posZ + ")!" : "!"), this.Field4586.getValue());
                        } else {
                            Command.Method2159695("Player " + (Object) ChatFormatting.RED + entityPlayer.getName() + "\u00a7r" + (Object) ChatFormatting.GREEN + " left " + (Object) ChatFormatting.RESET + "your visual range" + (this.Field4584.getValue() != false ? " at (" + (int) entityPlayer.posX + ", " + (int) entityPlayer.posY + ", " + (int) entityPlayer.posZ + ")!" : "!"), this.Field4586.getValue());
                        }
                    }
                    return;
                }
            }
        }
        if (this.Field4587.getValue().booleanValue()) {
            if (Notifications.Field2811.world == null || Notifications.Field2811.player == null) {
                return;
            }
            object2 = null;
            for (Entity entity : Notifications.Field2811.world.loadedEntityList) {
                if (!(entity instanceof EntityEnderPearl)) continue;
                object2 = entity;
                break;
            }
            if (object2 == null) {
                this.Field4565 = true;
                return;
            }
            iterator22 = null;
            for (EntityPlayer entityPlayer : Notifications.Field2811.world.playerEntities) {
                if (iterator22 == null) {
                    iterator22 = entityPlayer;
                    continue;
                }
                if (iterator22.getDistance((Entity) object2) <= entityPlayer.getDistance(object2)) continue;
                iterator22 = entityPlayer;
            }
            if (iterator22 == Notifications.Field2811.player) {
                this.Field4565 = false;
            }
            if (iterator22 != null && this.Field4565) {
                void var3_12;
                String string = object2.getHorizontalFacing().toString();
                if (string.equals("west")) {
                    String string2 = "east";
                } else if (string.equals("east")) {
                    String string3 = "west";
                }
                Command.Method2159696(AliceMain.Field765.Method2150168(iterator22.getName()) ? (Object) ChatFormatting.AQUA + iterator22.getName() + (Object) ChatFormatting.DARK_GRAY + " has just thrown a pearl heading " + (String) var3_12 + "!" : (Object) ChatFormatting.RED + iterator22.getName() + (Object) ChatFormatting.DARK_GRAY + " has just thrown a pearl heading " + (String) var3_12 + "!");
                this.Field4565 = false;
            }
        }
        if (this.Field4588.getValue().booleanValue()) {
            if (Notifications.Field2811.player == null || Notifications.Field2811.world == null) {
                return;
            }
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.loadedEntityList.stream().filter(Notifications::Method2150712).collect(Collectors.toList())) {
                if (!(iterator22 instanceof EntityPlayer)) continue;
                if (!this.Field4562.contains(iterator22) && this.Method2150606((Entity) iterator22)) {
                    this.Field4562.add((Entity) iterator22);
                    Command.Method2159696((Object) ChatFormatting.RED + iterator22.getName() + " has just burrowed!");
                    continue;
                }
                if (!this.Field4562.contains(iterator22) || this.Method2150606((Entity) iterator22)) continue;
                this.Field4562.remove(iterator22);
                Command.Method2159696((Object) ChatFormatting.GREEN + iterator22.getName() + " is no longer burrowed!");
            }
        }
        if (this.Field4590.getValue().booleanValue()) {
            if (Notifications.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && !this.Field4563) {
                Command.Method2159696("You now have " + (Object) ChatFormatting.RED + (Object) ChatFormatting.BOLD + "Weakness" + (Object) ChatFormatting.RESET + "!");
                this.Field4563 = true;
            }
            if (!Notifications.Field2811.player.isPotionActive(MobEffects.WEAKNESS) && this.Field4563) {
                Command.Method2159696("You no longer have " + (Object) ChatFormatting.RED + (Object) ChatFormatting.BOLD + "Weakness" + (Object) ChatFormatting.RESET + "!");
                this.Field4563 = false;
            }
        }
        if (this.Field4591.getValue().booleanValue()) {
            if (Notifications.Field2811.player.isPotionActive(MobEffects.SLOWNESS) && !this.Field4564) {
                Command.Method2159696("You now have " + (Object) ChatFormatting.DARK_RED + (Object) ChatFormatting.BOLD + "Slowness" + (Object) ChatFormatting.RESET + "!");
                this.Field4564 = true;
            }
            if (!Notifications.Field2811.player.isPotionActive(MobEffects.SLOWNESS) && this.Field4564) {
                Command.Method2159696("You no longer have " + (Object) ChatFormatting.DARK_RED + (Object) ChatFormatting.BOLD + "Slowness" + (Object) ChatFormatting.RESET + "!");
                this.Field4564 = false;
            }
        }
        if (this.Field4594.getValue().booleanValue() && this.Field4598.getValue().booleanValue()) {
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.getLoadedEntityList()) {
                if (!(iterator22 instanceof EntityGhast) || this.Field4566.contains(iterator22)) continue;
                if (this.Field4595.getValue().booleanValue()) {
                    Command.Method2159696("Ghast Detected at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.");
                }
                this.Field4566.add((Entity) iterator22);
                if (!this.Field4597.getValue().booleanValue()) continue;
                this.Field4573.displayMessage("WeatherHack", "I found a ghast at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.", TrayIcon.MessageType.INFO);
                if (!this.Field4596.getValue().booleanValue()) continue;
                Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
            }
        }
        if (this.Field4594.getValue().booleanValue() && this.Field4601.getValue().booleanValue()) {
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.getLoadedEntityList()) {
                if (!(iterator22 instanceof EntityDonkey) || this.Field4567.contains(iterator22)) continue;
                if (this.Field4595.getValue().booleanValue()) {
                    Command.Method2159696("Donkey Detected at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.");
                }
                this.Field4567.add((Entity) iterator22);
                if (!this.Field4597.getValue().booleanValue()) continue;
                this.Field4573.displayMessage("WeatherHack", "I found a donkey at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.", TrayIcon.MessageType.INFO);
                if (!this.Field4596.getValue().booleanValue()) continue;
                Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
            }
        }
        if (this.Field4594.getValue().booleanValue() && this.Field4602.getValue().booleanValue()) {
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.getLoadedEntityList()) {
                if (!(iterator22 instanceof EntityMule) || this.Field4568.contains(iterator22)) continue;
                if (this.Field4595.getValue().booleanValue()) {
                    Command.Method2159696("Mule Detected at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.");
                }
                this.Field4568.add((Entity) iterator22);
                if (!this.Field4597.getValue().booleanValue()) continue;
                this.Field4573.displayMessage("WeatherHack", "I found a mule at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.", TrayIcon.MessageType.INFO);
                if (!this.Field4596.getValue().booleanValue()) continue;
                Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
            }
        }
        if (this.Field4594.getValue().booleanValue() && this.Field4603.getValue().booleanValue()) {
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.getLoadedEntityList()) {
                if (!(iterator22 instanceof EntityLlama) || this.Field4569.contains(iterator22)) continue;
                if (this.Field4595.getValue().booleanValue()) {
                    Command.Method2159696("Llama Detected at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.");
                }
                this.Field4569.add((Entity) iterator22);
                if (!this.Field4597.getValue().booleanValue()) continue;
                this.Field4573.displayMessage("WeatherHack", "I found a llama at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.", TrayIcon.MessageType.INFO);
                if (!this.Field4596.getValue().booleanValue()) continue;
                Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
            }
        }
        if (this.Field4594.getValue().booleanValue() && this.Field4599.getValue().booleanValue()) {
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.getLoadedEntityList()) {
                if (!(iterator22 instanceof EntityCow) || this.Field4570.contains(iterator22)) continue;
                if (this.Field4595.getValue().booleanValue()) {
                    Command.Method2159696("Cow Detected at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.");
                }
                this.Field4570.add((Entity) iterator22);
                if (!this.Field4597.getValue().booleanValue()) continue;
                this.Field4573.displayMessage("WeatherHack", "I found a cow at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.", TrayIcon.MessageType.INFO);
                if (!this.Field4596.getValue().booleanValue()) continue;
                Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
            }
        }
        if (this.Field4594.getValue().booleanValue() && this.Field4600.getValue().booleanValue()) {
            for (Iterator<Object> iterator22 : Notifications.Field2811.world.getLoadedEntityList()) {
                if (!(iterator22 instanceof EntitySheep) || this.Field4571.contains(iterator22)) continue;
                if (this.Field4595.getValue().booleanValue()) {
                    Command.Method2159696("Sheep Detected at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.");
                }
                this.Field4571.add((Entity) iterator22);
                if (!this.Field4597.getValue().booleanValue()) continue;
                this.Field4573.displayMessage("WeatherHack", "I found a Sheep at: " + Math.round(iterator22.getPosition().getX()) + "x, " + Math.round(iterator22.getPosition().getY()) + "y, " + Math.round(iterator22.getPosition().getZ()) + "z.", TrayIcon.MessageType.INFO);
                if (!this.Field4596.getValue().booleanValue()) continue;
                Notifications.Field2811.player.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void Method2150376() {
        if (Notifications.Method2150359()) {
            return;
        }
        if (this.Field4592.getValue().booleanValue()) {
            int n2 = 0;
            for (EntityPlayer entityPlayer : Notifications.Field2811.world.playerEntities) {
                if (entityPlayer.equals((Object) Notifications.Field2811.player)) continue;
                if (this.Method2150604(entityPlayer.getHeldItem(EnumHand.MAIN_HAND)) && !this.Field4560.contains((Object) entityPlayer)) {
                    Command.Method2159696((Object) ChatFormatting.RED + entityPlayer.getDisplayNameString() + " is holding a 32k");
                    this.Field4560.add(entityPlayer);
                }
                if (this.Method2150604(entityPlayer.getHeldItem(EnumHand.MAIN_HAND))) {
                    if (n2 > 0) {
                        return;
                    }
                    ++n2;
                }
                if (!this.Field4560.contains((Object) entityPlayer) || this.Method2150604(entityPlayer.getHeldItem(EnumHand.MAIN_HAND)))
                    continue;
                Command.Method2159696((Object) ChatFormatting.GREEN + entityPlayer.getDisplayNameString() + " is no longer holding a 32k");
                this.Field4560.remove((Object) entityPlayer);
            }
        }
    }

    @SubscribeEvent
    public void Method2150605(GuiOpenEvent guiOpenEvent) {
        if (this.Field4589.getValue().booleanValue() && guiOpenEvent.getGui() instanceof GuiGameOver && guiOpenEvent.getGui() instanceof GuiGameOver) {
            Command.Method2159696(String.format("You died at x %d y %d z %d", (int) AutoRespawn.Field2811.player.posX, (int) AutoRespawn.Field2811.player.posY, (int) AutoRespawn.Field2811.player.posZ));
        }
    }

    private boolean Method2150606(Entity entity) {
        BlockPos blockPos = new BlockPos(this.Method2150607(entity.posX), entity.posY + 0.2, this.Method2150607(entity.posZ));
        return Notifications.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN || Notifications.Field2811.world.getBlockState(blockPos).getBlock() == Blocks.ENDER_CHEST;
    }

    private double Method2150607(double d) {
        double d2 = Math.round(d);
        if (d2 > d) {
            d2 -= 0.5;
        } else if (d2 <= d) {
            d2 += 0.5;
        }
        return d2;
    }

    public void Method2150608() {
        List<String> list = FileManager.Method2150140(Field4556);
        Iterator<String> iterator = list.iterator();
        Field4557.clear();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.replaceAll("\\s", "").isEmpty()) continue;
            Field4557.add(string);
        }
    }

    public TextComponentString Method2150609(Module module) {
        if (ModuleTools.Method2150698().Method2150364()) {
            switch (1.F ield1772[ModuleTools.Method2150698().Field226.getValue().ordinal()]){
                case 1: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.GREEN + "[LuigiHack] " + (Object) ChatFormatting.GRAY + module.Method2150392() + " toggled " + (Object) ChatFormatting.GREEN + "on" + (Object) ChatFormatting.GRAY + ".");
                    return textComponentString;
                }
                case 2: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.RED + "[Future] " + (Object) ChatFormatting.GRAY + module.Method2150392() + " toggled " + (Object) ChatFormatting.GREEN + "on" + (Object) ChatFormatting.GRAY + ".");
                    return textComponentString;
                }
                case 3: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.LIGHT_PURPLE + "[" + (Object) ChatFormatting.DARK_PURPLE + "Muffin" + (Object) ChatFormatting.LIGHT_PURPLE + "] " + (Object) ChatFormatting.LIGHT_PURPLE + module.Method2150392() + (Object) ChatFormatting.DARK_PURPLE + " was " + (Object) ChatFormatting.GREEN + "enabled.");
                    return textComponentString;
                }
                case 4: {
                    TextComponentString textComponentString = new TextComponentString(TextUtil.Method2164747("[Abyss] ", ModuleTools.Method2150698().Field228.getPlannedValue()) + (Object) ChatFormatting.WHITE + module.Method2150392() + (Object) ChatFormatting.GREEN + " ON");
                    return textComponentString;
                }
                case 5: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.BOLD + module.Method2150392() + (Object) ChatFormatting.RESET + (Object) ChatFormatting.GREEN + " enabled.");
                    return textComponentString;
                }
                case 6: {
                    TextComponentString textComponentString = new TextComponentString(AliceMain.Field761.Method2150112() + " " + (Object) ChatFormatting.GREEN + module.Method2150392() + " enabled.");
                    return textComponentString;
                }
                case 7: {
                    TextComponentString textComponentString = new TextComponentString(AliceMain.Field761.Method2150112() + (Object) ChatFormatting.RESET + " " + module.Method2150392() + (Object) ChatFormatting.GREEN + " enabled");
                    return textComponentString;
                }
            }
        }
        TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.BOLD + "" + module.Method2150392() + (Object) ChatFormatting.GREEN + " Enabled");
        return textComponentString;
    }

    public TextComponentString Method2150600(Module module) {
        if (ModuleTools.Method2150698().Method2150364()) {
            switch (1.F ield1772[ModuleTools.Method2150698().Field226.getValue().ordinal()]){
                case 1: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.GREEN + "[LuigiHack] " + (Object) ChatFormatting.GRAY + module.Method2150392() + " toggled " + (Object) ChatFormatting.RED + "off" + (Object) ChatFormatting.GRAY + ".");
                    return textComponentString;
                }
                case 2: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.RED + "[Future] " + (Object) ChatFormatting.GRAY + module.Method2150392() + " toggled " + (Object) ChatFormatting.RED + "off" + (Object) ChatFormatting.GRAY + ".");
                    return textComponentString;
                }
                case 3: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.LIGHT_PURPLE + "[" + (Object) ChatFormatting.DARK_PURPLE + "Muffin" + (Object) ChatFormatting.LIGHT_PURPLE + "] " + (Object) ChatFormatting.LIGHT_PURPLE + module.Method2150392() + (Object) ChatFormatting.DARK_PURPLE + " was " + (Object) ChatFormatting.RED + "disabled.");
                    return textComponentString;
                }
                case 5: {
                    TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.BOLD + module.Method2150392() + (Object) ChatFormatting.RESET + (Object) ChatFormatting.RED + " disabled.");
                    return textComponentString;
                }
                case 4: {
                    TextComponentString textComponentString = new TextComponentString(TextUtil.Method2164747("[Abyss] ", ModuleTools.Method2150698().Field228.getPlannedValue()) + (Object) ChatFormatting.WHITE + module.Method2150392() + (Object) ChatFormatting.RED + " OFF");
                    return textComponentString;
                }
                case 6: {
                    TextComponentString textComponentString = new TextComponentString(AliceMain.Field761.Method2150112() + " " + (Object) ChatFormatting.RED + module.Method2150392() + " disabled.");
                    return textComponentString;
                }
                case 7: {
                    TextComponentString textComponentString = new TextComponentString(AliceMain.Field761.Method2150112() + (Object) ChatFormatting.RESET + " " + module.Method2150392() + (Object) ChatFormatting.RED + " disabled");
                    return textComponentString;
                }
            }
        }
        TextComponentString textComponentString = new TextComponentString((Object) ChatFormatting.BOLD + "" + module.Method2150392() + (Object) ChatFormatting.RED + " Disabled");
        return textComponentString;
    }

    @SubscribeEvent
    public void Method2150711(ClientEvent clientEvent) {
        int n2;
        Module module;
        if (!this.Field4579.getValue().booleanValue()) {
            return;
        }
        if (!(clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() != 0 || (module = (Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).equals(this) || !Field4557.contains(module.Method2150392()) && this.Field4580.getValue().booleanValue())) {
            n2 = 0;
            for (char c : module.Method2150392().toCharArray()) {
                n2 += c;
                n2 *= 10;
            }
            Notifications.Field2811.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((ITextComponent) this.Method2150600(module), n2);
        }
        if (clientEvent.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() == 1 && (Field4557.contains((module = (Module) clientEvent.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll()).Method2150392()) || !this.Field4580.getValue().booleanValue())) {
            n2 = 0;
            for (char c : module.Method2150392().toCharArray()) {
                n2 += c;
                n2 *= 10;
            }
            Notifications.Field2811.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((ITextComponent) this.Method2150609(module), n2);
        }
    }

    private boolean Method2150713(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150714(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150715(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150716(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150717(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150718(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150719(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150710(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150721(Boolean bl) {
        return this.Field4594.getValue();
    }

    private boolean Method2150722(Object object) {
        return this.Field4582.getValue();
    }

    private boolean Method2150723(Object object) {
        return this.Field4582.getValue();
    }

    private boolean Method2150724(Object object) {
        return this.Field4579.getValue();
    }

    private boolean Method2150725(Object object) {
        return this.Field4579.getValue();
    }

    private boolean Method2150726(Object object) {
        return this.Field4575.getValue();
    }

    private boolean Method2150727(Object object) {
        return this.Field4575.getValue();
    }
}

