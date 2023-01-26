

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemMap
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.tileentity.TileEntityShulkerBox
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.MapData
 *  net.minecraftforge.client.event.RenderTooltipEvent$PostText
 *  net.minecraftforge.event.entity.player.ItemTooltipEvent
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Keyboard
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ColorUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.EntityUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Render2DEvent;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderUtil;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class ToolTips
        extends Module {
    private static final ResourceLocation Field924 = new ResourceLocation("textures/map/map_background.png");
    private static final ResourceLocation Field925 = new ResourceLocation("textures/gui/container/shulker_box.png");
    private static ToolTips Field926 = new ToolTips();
    public Setting<Boolean> Field927 = this.Method2150366(new Setting<Boolean>("Maps", true));
    public Setting<Boolean> Field928 = this.Method2150366(new Setting<Boolean>("ShulkerViewer", true));
    public Setting<Bind> Field929 = this.Method2150366(new Setting<Bind>("Peek", new Bind(-1)));
    public Setting<Boolean> Field930 = this.Method2150366(new Setting<Boolean>("ShulkerSpy", true));
    public Setting<Boolean> Field931 = this.Method2150366(new Setting<Object>("Render", Boolean.TRUE, this::Method2161957));
    public Setting<Boolean> Field932 = this.Method2150366(new Setting<Object>("OwnShulker", Boolean.TRUE, this::Method2161956));
    public Setting<Integer> Field933 = this.Method2150366(new Setting<Object>("ShowForS", Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(5), this::Method2161955));
    public Setting<Boolean> Field934 = this.Method2150366(new Setting<Object>("TextColor", Boolean.FALSE, this::Method2161954));
    private final Setting<Integer> Field935 = this.Method2150366(new Setting<Object>("Red", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161953));
    private final Setting<Integer> Field936 = this.Method2150366(new Setting<Object>("Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161952));
    private final Setting<Integer> Field937 = this.Method2150366(new Setting<Object>("Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2161951));
    private final Setting<Integer> Field938 = this.Method2150366(new Setting<Object>("Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2161940));
    public Setting<Boolean> Field939 = this.Method2150366(new Setting<Boolean>("Offsets", false));
    private final Setting<Integer> Field940 = this.Method2150366(new Setting<Object>("Y/Player", Integer.valueOf(18), this::Method2161949));
    private final Setting<Integer> Field941 = this.Method2150366(new Setting<Object>("XOffset", Integer.valueOf(4), this::Method2161948));
    private final Setting<Integer> Field942 = this.Method2150366(new Setting<Object>("YOffset", Integer.valueOf(2), this::Method2161947));
    private final Setting<Integer> Field943 = this.Method2150366(new Setting<Object>("TROffset", Integer.valueOf(2), this::Method2161946));
    public Setting<Integer> Field944 = this.Method2150366(new Setting<Object>("InvH", Integer.valueOf(3), this::Method2161945));
    public Map<EntityPlayer, ItemStack> Field945 = new ConcurrentHashMap<EntityPlayer, ItemStack>();
    public Map<EntityPlayer, Timer> Field946 = new ConcurrentHashMap<EntityPlayer, Timer>();
    private int Field947;

    public ToolTips() {
        super("ToolTips", "Several tweaks for tooltips.", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.MISC, true, false, false);
        this.Method2161939();
    }

    public static ToolTips Method2161937() {
        if (Field926 == null) {
            Field926 = new ToolTips();
        }
        return Field926;
    }

    public static void Method2161938(ItemStack itemStack, String string) {
        try {
            Item item = itemStack.getItem();
            TileEntityShulkerBox tileEntityShulkerBox = new TileEntityShulkerBox();
            ItemShulkerBox itemShulkerBox = (ItemShulkerBox) item;
            tileEntityShulkerBox.blockType = itemShulkerBox.getBlock();
            tileEntityShulkerBox.setWorld((World) ToolTips.Field2811.world);
            ItemStackHelper.loadAllItems((NBTTagCompound) Objects.requireNonNull(itemStack.getTagCompound()).getCompoundTag("BlockEntityTag"), (NonNullList) tileEntityShulkerBox.items);
            tileEntityShulkerBox.readFromNBT(itemStack.getTagCompound().getCompoundTag("BlockEntityTag"));
            tileEntityShulkerBox.setCustomName(string == null ? itemStack.getDisplayName() : string);
            new Thread(() -> ToolTips.Method2161944(tileEntityShulkerBox)).start();
        } catch (Exception exception) {
            // empty catch block
        }
    }

    private static void Method2161944(TileEntityShulkerBox tileEntityShulkerBox) {
        try {
            Thread.sleep(200L);
        } catch (InterruptedException interruptedException) {
            // empty catch block
        }
        ToolTips.Field2811.player.displayGUIChest((IInventory) tileEntityShulkerBox);
    }

    private void Method2161939() {
        Field926 = this;
    }

    @Override
    public void Method2150379() {
        ItemStack itemStack;
        Slot slot;
        if (ToolTips.Method2150359() || !this.Field930.getValue().booleanValue()) {
            return;
        }
        if (this.Field929.getValue().getKey() != -1 && ToolTips.Field2811.currentScreen instanceof GuiContainer && Keyboard.isKeyDown((int) this.Field929.getValue().getKey()) && (slot = ((GuiContainer) ToolTips.Field2811.currentScreen).getSlotUnderMouse()) != null && (itemStack = slot.getStack()) != null && itemStack.getItem() instanceof ItemShulkerBox) {
            ToolTips.Method2161938(itemStack, null);
        }
        for (EntityPlayer entityPlayer : ToolTips.Field2811.world.playerEntities) {
            if (entityPlayer == null || !(entityPlayer.getHeldItemMainhand().getItem() instanceof ItemShulkerBox) || EntityUtil.Method2163559(entityPlayer) || !this.Field932.getValue().booleanValue() && ToolTips.Field2811.player.equals((Object) entityPlayer))
                continue;
            ItemStack itemStack2 = entityPlayer.getHeldItemMainhand();
            this.Field945.put(entityPlayer, itemStack2);
        }
    }

    @Override
    public void Method2150370(Render2DEvent render2DEvent) {
        if (ToolTips.Method2150359() || !this.Field930.getValue().booleanValue() || !this.Field931.getValue().booleanValue()) {
            return;
        }
        int n2 = -4 + this.Field941.getValue();
        int n3 = 10 + this.Field942.getValue();
        this.Field947 = 0;
        for (EntityPlayer entityPlayer : ToolTips.Field2811.world.playerEntities) {
            Object object;
            Timer timer;
            if (this.Field945.get((Object) entityPlayer) == null) continue;
            entityPlayer.getHeldItemMainhand();
            if (!(entityPlayer.getHeldItemMainhand().getItem() instanceof ItemShulkerBox)) {
                timer = this.Field946.get((Object) entityPlayer);
                if (timer == null) {
                    object = new Timer();
                    ((Timer) object).Method2164750();
                    this.Field946.put(entityPlayer, (Timer) object);
                } else if (timer.Method2164751(this.Field933.getValue().intValue())) {
                    continue;
                }
            } else if (entityPlayer.getHeldItemMainhand().getItem() instanceof ItemShulkerBox && (timer = this.Field946.get((Object) entityPlayer)) != null) {
                timer.Method2164750();
                this.Field946.put(entityPlayer, timer);
            }
            object = this.Field945.get((Object) entityPlayer);
            this.Method2161943((ItemStack) object, n2, n3, entityPlayer.getName());
            this.Field947 = (n3 += this.Field940.getValue() + 60) - 10 - this.Field942.getValue() + this.Field943.getValue();
        }
    }

    public int Method2161930() {
        return this.Field947;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void Method2161941(ItemTooltipEvent itemTooltipEvent) {
    }

    @SubscribeEvent
    public void Method2161942(RenderTooltipEvent.PostText postText) {
        MapData mapData;
        if (this.Field927.getValue().booleanValue() && !postText.getStack().isEmpty() && postText.getStack().getItem() instanceof ItemMap && (mapData = Items.FILLED_MAP.getMapData(postText.getStack(), (World) ToolTips.Field2811.world)) != null) {
            GlStateManager.pushMatrix();
            GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f);
            RenderHelper.disableStandardItemLighting();
            Field2811.getTextureManager().bindTexture(Field924);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferBuilder = tessellator.getBuffer();
            int n2 = 7;
            float f = 135.0f;
            float f2 = 0.5f;
            GlStateManager.translate((float) postText.getX(), (float) ((float) postText.getY() - f * f2 - 5.0f), (float) 0.0f);
            GlStateManager.scale((float) f2, (float) f2, (float) f2);
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.pos((double) (-n2), (double) f, 0.0).tex(0.0, 1.0).endVertex();
            bufferBuilder.pos((double) f, (double) f, 0.0).tex(1.0, 1.0).endVertex();
            bufferBuilder.pos((double) f, (double) (-n2), 0.0).tex(1.0, 0.0).endVertex();
            bufferBuilder.pos((double) (-n2), (double) (-n2), 0.0).tex(0.0, 0.0).endVertex();
            tessellator.draw();
            ToolTips.Field2811.entityRenderer.getMapItemRenderer().renderMap(mapData, false);
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }
    }

    public void Method2161943(ItemStack itemStack, int n2, int n3, String string) {
        NBTTagCompound nBTTagCompound;
        NBTTagCompound nBTTagCompound2 = itemStack.getTagCompound();
        if (nBTTagCompound2 != null && nBTTagCompound2.hasKey("BlockEntityTag", 10) && (nBTTagCompound = nBTTagCompound2.getCompoundTag("BlockEntityTag")).hasKey("Items", 9)) {
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
            Field2811.getTextureManager().bindTexture(Field925);
            RenderUtil.Method2163989(n2, n3, 0, 0, 176, 16, 500);
            RenderUtil.Method2163989(n2, n3 + 16, 0, 16, 176, 54 + this.Field944.getValue(), 500);
            RenderUtil.Method2163989(n2, n3 + 16 + 54, 0, 160, 176, 8, 500);
            GlStateManager.disableDepth();
            Color color = new Color(0, 0, 0, 255);
            if (this.Field934.getValue().booleanValue()) {
                color = new Color(this.Field935.getValue(), this.Field936.getValue(), this.Field937.getValue(), this.Field938.getValue());
            }
            this.Field3872.Method2150317(string == null ? itemStack.getDisplayName() : string, n2 + 8, n3 + 6, ColorUtil.Method2163384(color));
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            NonNullList nonNullList = NonNullList.withSize((int) 27, (Object) ItemStack.EMPTY);
            ItemStackHelper.loadAllItems((NBTTagCompound) nBTTagCompound, (NonNullList) nonNullList);
            for (int j = 0; j < nonNullList.size(); ++j) {
                int n4 = n2 + j % 9 * 18 + 8;
                int n5 = n3 + j / 9 * 18 + 18;
                ItemStack itemStack2 = (ItemStack) nonNullList.get(j);
                ToolTips.Field2811.getRenderItem().zLevel = 501.0f;
                RenderUtil.Field3115.renderItemAndEffectIntoGUI(itemStack2, n4, n5);
                RenderUtil.Field3115.renderItemOverlayIntoGUI(ToolTips.Field2811.fontRenderer, itemStack2, n4, n5, null);
                ToolTips.Field2811.getRenderItem().zLevel = 0.0f;
            }
            GlStateManager.disableLighting();
            GlStateManager.disableBlend();
            GlStateManager.color((float) 1.0f, (float) 1.0f, (float) 1.0f, (float) 1.0f);
        }
    }

    private boolean Method2161945(Object object) {
        return this.Field939.getValue();
    }

    private boolean Method2161946(Object object) {
        return this.Field939.getValue();
    }

    private boolean Method2161947(Object object) {
        return this.Field939.getValue();
    }

    private boolean Method2161948(Object object) {
        return this.Field939.getValue();
    }

    private boolean Method2161949(Object object) {
        return this.Field939.getValue();
    }

    private boolean Method2161940(Object object) {
        return this.Field934.getValue();
    }

    private boolean Method2161951(Object object) {
        return this.Field934.getValue();
    }

    private boolean Method2161952(Object object) {
        return this.Field934.getValue();
    }

    private boolean Method2161953(Object object) {
        return this.Field934.getValue();
    }

    private boolean Method2161954(Object object) {
        return this.Field928.getValue();
    }

    private boolean Method2161955(Object object) {
        return this.Field930.getValue();
    }

    private boolean Method2161956(Object object) {
        return this.Field930.getValue();
    }

    private boolean Method2161957(Object object) {
        return this.Field930.getValue();
    }
}

