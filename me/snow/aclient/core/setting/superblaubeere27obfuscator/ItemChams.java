

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AquaOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AquaShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AstralOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CircleOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.CircleShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Colors;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FillShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FlowShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GlowShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GradientOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.GradientShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.PhobosShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RainbowCubeOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RainbowCubeShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.RenderHand;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SmokeOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SmokeShader;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemChams
        extends Module {
    private static ItemChams Field1836 = new ItemChams();
    public Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field1837 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Fill Shader", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None));
    public Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field1838 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Glow ESP", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.None));
    public Setting<Float> Field1843 = this.Method2150366(new Setting<Float>("Speed", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field1844 = this.Method2150366(new Setting<Float>("Duplicate Fill", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(5.0f)));
    public Setting<Float> Field1845 = this.Method2150366(new Setting<Float>("Speed Outline", Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(100.0f)));
    public Setting<Float> Field1846 = this.Method2150366(new Setting<Float>("Speed Fill", Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(100.0f)));
    public Setting<Float> Field1847 = this.Method2150366(new Setting<Object>("RAD Fill", Float.valueOf(0.75f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162543));
    public Setting<Float> Field1848 = this.Method2150366(new Setting<Object>("PI Fill", Float.valueOf((float) Math.PI), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162542));
    public Setting<Float> Field1849 = this.Method2150366(new Setting<Object>("saturation", Float.valueOf(0.4f), Float.valueOf(0.0f), Float.valueOf(3.0f), this::Method2162541));
    public Setting<Float> Field1850 = this.Method2150366(new Setting<Object>("distfading", Float.valueOf(0.56f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162530));
    public Setting<Float> Field1851 = this.Method2150366(new Setting<Object>("Tile", Float.valueOf(0.45f), Float.valueOf(0.0f), Float.valueOf(1.3f), this::Method2162539));
    public Setting<Float> Field1852 = this.Method2150366(new Setting<Object>("Step Size", Float.valueOf(0.19f), Float.valueOf(0.0f), Float.valueOf(0.7f), this::Method2162538));
    public Setting<Float> Field1853 = this.Method2150366(new Setting<Object>("Volum Steps", Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162537));
    public Setting<Float> Field1854 = this.Method2150366(new Setting<Object>("Zoom", Float.valueOf(3.9f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162536));
    public Setting<Float> Field1855 = this.Method2150366(new Setting<Object>("formuparam2", Float.valueOf(0.89f), Float.valueOf(0.0f), Float.valueOf(1.5f), this::Method2162535));
    public Setting<Float> Field1856 = this.Method2150366(new Setting<Object>("saturation", Float.valueOf(0.4f), Float.valueOf(0.0f), Float.valueOf(3.0f), this::Method2162534));
    public Setting<Integer> Field1857 = this.Method2150366(new Setting<Integer>("Iteration", Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(20), this::Method2162533));
    public Setting<Integer> Field1858 = this.Method2150366(new Setting<Integer>("Tick Regen", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(100), this::Method2162532));
    public Setting<Integer> Field1859 = this.Method2150366(new Setting<Integer>("Max Iter", Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(30), this::Method2162531));
    public Setting<Integer> Field1860 = this.Method2150366(new Setting<Integer>("NUM_OCTAVES", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(30), this::Method2162520));
    public Setting<Integer> Field1861 = this.Method2150366(new Setting<Integer>("BSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162529));
    public Setting<Integer> Field1862 = this.Method2150366(new Setting<Integer>("GSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162528));
    public Setting<Integer> Field1863 = this.Method2150366(new Setting<Integer>("RSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162527));
    public Setting<Integer> Field1864 = this.Method2150366(new Setting<Integer>("Wave Lenght", Integer.valueOf(555), Integer.valueOf(0), Integer.valueOf(2000), this::Method2162526));
    public Setting<Integer> Field1865 = this.Method2150366(new Setting<Integer>("Volum Steps", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(10), this::Method2162525));
    public Setting<Integer> Field1866 = this.Method2150366(new Setting<Integer>("Iteration", Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(20), this::Method2162524));
    public Setting<Integer> Field1867 = this.Method2150366(new Setting<Integer>("Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(100), this::Method2162523));
    public Setting<Integer> Field1868 = this.Method2150366(new Setting<Integer>("Max Iter", Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(30), this::Method2162522));
    public Setting<Integer> Field1869 = this.Method2150366(new Setting<Integer>("NUM_OCTAVES", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(30), this::Method2162521));
    public Setting<Integer> Field1870 = this.Method2150366(new Setting<Integer>("BSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162510));
    public Setting<Integer> Field1871 = this.Method2150366(new Setting<Integer>("GSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162519));
    public Setting<Integer> Field1872 = this.Method2150366(new Setting<Integer>("RSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162518));
    public Setting<Integer> Field1874 = this.Method2150366(new Setting<Integer>("Wave Lenght", Integer.valueOf(555), Integer.valueOf(0), Integer.valueOf(2000), this::Method2162516));
    public Setting<Boolean> Field1875 = this.Method2150366(new Setting<Boolean>("Cancel Item", false));
    public Setting<Float> Field1876 = this.Method2150366(new Setting<Object>("AlphaF", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162515));
    public Setting<Float> Field1877 = this.Method2150366(new Setting<Object>("BlueF", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162514));
    public Setting<Float> Field1878 = this.Method2150366(new Setting<Object>("GreenF", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162513));
    public Setting<Float> Field1879 = this.Method2150366(new Setting<Object>("TAU", Float.valueOf((float) Math.PI * 2), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162512));
    public Setting<Float> Field1880 = this.Method2150366(new Setting<Object>("Creepy", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162511));
    public Setting<Float> Field1881 = this.Method2150366(new Setting<Object>("More Gradient", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162400));
    public Setting<Float> Field1882 = this.Method2150366(new Setting<Object>("distfading", Float.valueOf(0.56f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162409));
    public Setting<Float> Field1883 = this.Method2150366(new Setting<Object>("Tile", Float.valueOf(0.45f), Float.valueOf(0.0f), Float.valueOf(1.3f), this::Method2162408));
    public Setting<Float> Field1884 = this.Method2150366(new Setting<Object>("Step Size", Float.valueOf(0.2f), Float.valueOf(0.1f), Float.valueOf(1.0f), this::Method2162407));
    public Setting<Float> Field1885 = this.Method2150366(new Setting<Object>("Zoom", Float.valueOf(3.9f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162406));
    public Setting<Float> Field1886 = this.Method2150366(new Setting<Object>("formuparam2", Float.valueOf(0.89f), Float.valueOf(0.0f), Float.valueOf(1.5f), this::Method2162405));
    public Setting<Float> Field1887 = this.Method2150366(new Setting<Object>("Alpha", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162404));
    public Setting<Float> Field1888 = this.Method2150366(new Setting<Object>("Blue", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162403));
    public Setting<Float> Field1889 = this.Method2150366(new Setting<Object>("Green", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162402));
    public Setting<Float> Field1890 = this.Method2150366(new Setting<Object>("TAU", Float.valueOf((float) Math.PI * 2), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162401));
    public Setting<Float> Field1891 = this.Method2150366(new Setting<Object>("Creepy", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162490));
    public Setting<Float> Field1892 = this.Method2150366(new Setting<Object>("More Gradient", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162499));
    public Setting<Float> Field1893 = this.Method2150366(new Setting<Object>("RAD Outline", Float.valueOf(0.75f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162498));
    public Setting<Float> Field1894 = this.Method2150366(new Setting<Object>("PI Outline", Float.valueOf((float) Math.PI), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162497));
    public Setting<Float> Field1895 = this.Method2150366(new Setting<Float>("quality", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field1896 = this.Method2150366(new Setting<Float>("radius", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(5.0f)));
    public Setting<Integer> Field1897 = this.Method2150366(new Setting<Integer>("colorImgOutline Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162496));
    public Setting<Integer> Field1898 = this.Method2150366(new Setting<Integer>("colorImgOutline Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162495));
    public Setting<Integer> Field1899 = this.Method2150366(new Setting<Integer>("colorImgOutline Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162494));
    public Setting<Integer> Field1900 = this.Method2150366(new Setting<Integer>("colorImgOutline Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162493));
    public Setting<Integer> Field1901 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162492));
    public Setting<Integer> Field1902 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162491));
    public Setting<Integer> Field1903 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162480));
    public Setting<Integer> Field1904 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162489));
    public Setting<Integer> Field1905 = this.Method2150366(new Setting<Integer>("GlowESP Red", 0, 0, 255));
    public Setting<Integer> Field1906 = this.Method2150366(new Setting<Integer>("GlowESP Green", 0, 0, 255));
    public Setting<Integer> Field1907 = this.Method2150366(new Setting<Integer>("GlowESP Blue", 0, 0, 255));
    public Setting<Integer> Field1908 = this.Method2150366(new Setting<Integer>("GlowESP Alpha", 255, 0, 255));
    public Setting<Integer> Field1909 = this.Method2150366(new Setting<Integer>("FillShader Red", 0, 0, 255));
    public Setting<Integer> Field1910 = this.Method2150366(new Setting<Integer>("FillShader Green", 0, 0, 255));
    public Setting<Integer> Field1911 = this.Method2150366(new Setting<Integer>("FillShader Blue", 0, 0, 255));
    public Setting<Integer> Field1912 = this.Method2150366(new Setting<Integer>("FillShader Alpha", 255, 0, 255));
    public Setting<Integer> Field1913 = this.Method2150366(new Setting<Integer>("SmokeImgFill Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162488));
    public Setting<Integer> Field1914 = this.Method2150366(new Setting<Integer>("SmokeImgFill Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162487));
    public Setting<Integer> Field1915 = this.Method2150366(new Setting<Integer>("SmokeFImgill Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162486));
    public Setting<Integer> Field1916 = this.Method2150366(new Setting<Integer>("SmokeImgFill Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162485));
    public Setting<Integer> Field1917 = this.Method2150366(new Setting<Integer>("SmokeFill Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162484));
    public Setting<Integer> Field1918 = this.Method2150366(new Setting<Integer>("SmokeFill Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162483));
    public Setting<Integer> Field1919 = this.Method2150366(new Setting<Integer>("SmokeFill Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162482));
    public Setting<Integer> Field1920 = this.Method2150366(new Setting<Integer>("SmokeFill Alpha", Integer.valueOf(160), Integer.valueOf(0), Integer.valueOf(255), this::Method2162481));
    private Setting<Boolean> Field1839 = this.Method2150366(new Setting<Boolean>("ColorFill Preset", false));
    private Setting<Boolean> Field1840 = this.Method2150366(new Setting<Boolean>("Fade Fill", false));
    private Setting<Boolean> Field1841 = this.Method2150366(new Setting<Boolean>("FadeOL Fill", false));
    private Setting<Boolean> Field1842 = this.Method2150366(new Setting<Boolean>("Gradient Alpha", false));
    public Setting<Integer> Field1873 = this.Method2150366(new Setting<Integer>("Alpha Outline", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162517));
    private Setting<Boolean> Field1921 = this.Method2150366(new Setting<Boolean>("TestColorSync", false));

    public ItemChams() {
        super("ItemChams", "Chamsss", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
        this.Method2162474();
    }

    public static ItemChams Method2162473() {
        if (Field1836 == null) {
            Field1836 = new ItemChams();
        }
        return Field1836;
    }

    @Override
    public void Method2150376() {
        if (this.Field1839.getValue().booleanValue()) {
            this.Field1912.setValue(160);
            this.Field1838.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.None);
            this.Field1837.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Fill);
            this.Field1839.setValue(false);
        }
    }

    private void Method2162474() {
        Field1836 = this;
    }

    @SubscribeEvent
    public void Method2162475(RenderHand.IIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll) {
        if (ItemChams.Field2811.world == null || ItemChams.Field2811.player == null) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableAlpha();
        switch (this.Field1838.getValue()) {
            case Color: {
                GlowShader.Field305.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case RainbowCube: {
                RainbowCubeOutlineShader.Field2995.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Gradient: {
                GradientOutlineShader.Field327.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Astral: {
                AstralOutlineShader.Field634.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Aqua: {
                AquaOutlineShader.Field1447.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Circle: {
                CircleOutlineShader.Field2605.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Smoke: {
                SmokeOutlineShader.Field1977.Method2164121(iIlIlllIIllIllIlllIIlIlIllIIlIIllIIllIIIllIlIIlllIIIllIIllIIlllIlllIIllIlllIllIIIlIIllIIllIIlllIIIllIIIlIIllIllIIlIIlIIlllIlIIlIllIlllIIlllIIIlIIIllIIllIIlIIIllIlllIIlIlIlllIIlIIllIIlIllIIlIIlllIIIlllIIlllIIlllIllIIlIllIIIlIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            }
        }
    }

    @SubscribeEvent
    public void Method2162476(RenderHand.IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll illlIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll) {
        if (ItemChams.Field2811.world == null || ItemChams.Field2811.player == null) {
            return;
        }
        Color color = this.Field1921.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field1905.getValue(), this.Field1906.getValue(), this.Field1907.getValue(), this.Field1908.getValue());
        Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field1908.getValue());
        Color color3 = new Color(this.Field1897.getValue(), this.Field1898.getValue(), this.Field1899.getValue(), this.Field1900.getValue());
        Color color4 = new Color(this.Field1901.getValue(), this.Field1902.getValue(), this.Field1903.getValue(), this.Field1904.getValue());
        Color color5 = new Color(this.Field1917.getValue(), this.Field1918.getValue(), this.Field1919.getValue(), this.Field1920.getValue());
        switch (this.Field1838.getValue()) {
            case Color: {
                GlowShader.Field305.Method2164174(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue());
                break;
            }
            case RainbowCube: {
                RainbowCubeOutlineShader.Field2995.Method2164181(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), color3, this.Field1874.getValue(), this.Field1872.getValue(), this.Field1871.getValue(), this.Field1870.getValue());
                RainbowCubeOutlineShader.Field2995.Method2164183(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Gradient: {
                GradientOutlineShader.Field327.Method2164177(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1892.getValue().floatValue(), this.Field1891.getValue().floatValue(), this.Field1887.getValue().floatValue(), this.Field1869.getValue());
                GradientOutlineShader.Field327.Method2164179(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Astral: {
                AstralOutlineShader.Field634.Method2164162(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1867.getValue().floatValue(), this.Field1889.getValue().floatValue(), this.Field1888.getValue().floatValue(), this.Field1887.getValue().floatValue(), this.Field1866.getValue(), this.Field1886.getValue().floatValue(), this.Field1885.getValue().floatValue(), this.Field1865.getValue().intValue(), this.Field1884.getValue().floatValue(), this.Field1883.getValue().floatValue(), this.Field1882.getValue().floatValue(), this.Field1856.getValue().floatValue(), 0.0f, this.Field1841.getValue() != false ? 1 : 0);
                AstralOutlineShader.Field634.Method2164164(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Aqua: {
                AquaOutlineShader.Field1447.Method2164158(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1868.getValue(), this.Field1890.getValue().floatValue());
                AquaOutlineShader.Field1447.Method2164150(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Circle: {
                CircleOutlineShader.Field2605.Method2164166(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1894.getValue().floatValue(), this.Field1893.getValue().floatValue());
                CircleOutlineShader.Field2605.Method2164168(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Smoke: {
                SmokeOutlineShader.Field1977.Method2164185(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), color5, color4, this.Field1869.getValue());
                SmokeOutlineShader.Field1977.Method2164187(this.Field1845.getValue().floatValue() / 1000.0f);
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void Method2162477(RenderHand.IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll) {
        if (ItemChams.Field2811.world == null || ItemChams.Field2811.player == null) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableAlpha();
        switch (this.Field1837.getValue()) {
            case Astral: {
                FlowShader.Field3091.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Aqua: {
                AquaShader.Field1798.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Smoke: {
                SmokeShader.Field3658.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case RainbowCube: {
                RainbowCubeShader.Field3637.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Gradient: {
                GradientShader.Field2332.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Fill: {
                FillShader.Field2031.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Circle: {
                CircleShader.Field732.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Phobos: {
                PhobosShader.Field3396.Method2164121(ilIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            }
        }
    }

    @SubscribeEvent
    public void Method2162478(RenderHand.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll) {
        if (ItemChams.Field2811.world == null || ItemChams.Field2811.player == null) {
            return;
        }
        Color color = new Color(this.Field1897.getValue(), this.Field1898.getValue(), this.Field1899.getValue(), this.Field1900.getValue());
        Color color2 = this.Field1921.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field1909.getValue(), this.Field1910.getValue(), this.Field1911.getValue(), this.Field1912.getValue());
        Color color3 = new Color(color2.getRed(), color2.getGreen(), color2.getBlue(), this.Field1912.getValue());
        Color color4 = new Color(this.Field1917.getValue(), this.Field1918.getValue(), this.Field1919.getValue(), this.Field1920.getValue());
        Color color5 = new Color(this.Field1913.getValue(), this.Field1914.getValue(), this.Field1915.getValue(), this.Field1916.getValue());
        Color color6 = this.Field1921.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field1905.getValue(), this.Field1906.getValue(), this.Field1907.getValue(), this.Field1908.getValue());
        Color color7 = new Color(color6.getRed(), color6.getGreen(), color6.getBlue(), this.Field1908.getValue());
        switch (this.Field1837.getValue()) {
            case Astral: {
                FlowShader.Field3091.Method2164138(Color.WHITE, 1.0f, 1.0f, this.Field1844.getValue().floatValue(), this.Field1858.getValue().floatValue(), this.Field1878.getValue().floatValue(), this.Field1877.getValue().floatValue(), this.Field1876.getValue().floatValue(), this.Field1857.getValue(), this.Field1855.getValue().floatValue(), this.Field1854.getValue().floatValue(), this.Field1853.getValue().floatValue(), this.Field1852.getValue().floatValue(), this.Field1851.getValue().floatValue(), this.Field1850.getValue().floatValue(), this.Field1849.getValue().floatValue(), 0.0f, this.Field1840.getValue() != false ? 1 : 0);
                FlowShader.Field3091.Method2164130(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case Aqua: {
                AquaShader.Field1798.Method2164126(color3, 1.0f, 1.0f, this.Field1844.getValue().floatValue(), this.Field1859.getValue(), this.Field1879.getValue().floatValue());
                AquaShader.Field1798.Method2164128(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case Smoke: {
                SmokeShader.Field3658.Method2164154(Color.WHITE, 1.0f, 1.0f, this.Field1844.getValue().floatValue(), color3, color4, color5, this.Field1860.getValue());
                SmokeShader.Field3658.Method2164156(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case RainbowCube: {
                RainbowCubeShader.Field3637.Method2164140(Color.WHITE, 1.0f, 1.0f, this.Field1844.getValue().floatValue(), color3, this.Field1864.getValue(), this.Field1863.getValue(), this.Field1862.getValue(), this.Field1861.getValue());
                RainbowCubeShader.Field3637.Method2164152(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case Gradient: {
                GradientShader.Field2332.Method2164142(color7, 1.0f, 1.0f, this.Field1844.getValue().floatValue(), this.Field1881.getValue().floatValue(), this.Field1880.getValue().floatValue(), this.Field1876.getValue().floatValue(), this.Field1860.getValue());
                GradientShader.Field2332.Method2164144(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case Fill: {
                FillShader.Field2031.Method2164134(color3);
                FillShader.Field2031.Method2164136(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case Circle: {
                CircleShader.Field732.Method2164120(this.Field1844.getValue().floatValue(), color3, this.Field1848.getValue(), this.Field1847.getValue());
                CircleShader.Field732.Method2164132(this.Field1846.getValue().floatValue() / 1000.0f);
                break;
            }
            case Phobos: {
                PhobosShader.Field3396.Method2164146(color3, 1.0f, 1.0f, this.Field1844.getValue().floatValue(), this.Field1859.getValue(), this.Field1879.getValue().floatValue());
                PhobosShader.Field3396.Method2164148(this.Field1846.getValue().floatValue() / 1000.0f);
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void Method2162479(RenderHand.IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll) {
        if (ItemChams.Field2811.world == null || ItemChams.Field2811.player == null) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor) GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor) GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor) GlStateManager.DestFactor.ZERO);
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean) true);
        GlStateManager.enableAlpha();
        switch (this.Field1838.getValue()) {
            case Color: {
                GlowShader.Field305.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case RainbowCube: {
                RainbowCubeOutlineShader.Field2995.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Gradient: {
                GradientOutlineShader.Field327.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Astral: {
                AstralOutlineShader.Field634.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Aqua: {
                AquaOutlineShader.Field1447.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Circle: {
                CircleOutlineShader.Field2605.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
                break;
            }
            case Smoke: {
                SmokeOutlineShader.Field1977.Method2164121(iIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll());
            }
        }
    }

    @SubscribeEvent
    public void Method2162470(RenderHand.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        if (ItemChams.Field2811.world == null || ItemChams.Field2811.player == null) {
            return;
        }
        Color color = this.Field1921.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field1905.getValue(), this.Field1906.getValue(), this.Field1907.getValue(), this.Field1908.getValue());
        Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.Field1908.getValue());
        Color color3 = new Color(this.Field1897.getValue(), this.Field1898.getValue(), this.Field1899.getValue(), this.Field1900.getValue());
        Color color4 = new Color(this.Field1901.getValue(), this.Field1902.getValue(), this.Field1903.getValue(), this.Field1904.getValue());
        switch (this.Field1838.getValue()) {
            case Color: {
                GlowShader.Field305.Method2164174(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue());
                break;
            }
            case RainbowCube: {
                RainbowCubeOutlineShader.Field2995.Method2164181(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), color3, this.Field1874.getValue(), this.Field1872.getValue(), this.Field1871.getValue(), this.Field1870.getValue());
                RainbowCubeOutlineShader.Field2995.Method2164183(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Gradient: {
                GradientOutlineShader.Field327.Method2164177(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1892.getValue().floatValue(), this.Field1891.getValue().floatValue(), this.Field1887.getValue().floatValue(), this.Field1869.getValue());
                GradientOutlineShader.Field327.Method2164179(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Astral: {
                AstralOutlineShader.Field634.Method2164162(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1867.getValue().floatValue(), this.Field1889.getValue().floatValue(), this.Field1888.getValue().floatValue(), this.Field1887.getValue().floatValue(), this.Field1866.getValue(), this.Field1886.getValue().floatValue(), this.Field1885.getValue().floatValue(), this.Field1865.getValue().intValue(), this.Field1884.getValue().floatValue(), this.Field1883.getValue().floatValue(), this.Field1882.getValue().floatValue(), this.Field1856.getValue().floatValue(), 0.0f, this.Field1841.getValue() != false ? 1 : 0);
                AstralOutlineShader.Field634.Method2164164(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Aqua: {
                AquaOutlineShader.Field1447.Method2164158(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1868.getValue(), this.Field1890.getValue().floatValue());
                AquaOutlineShader.Field1447.Method2164150(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Circle: {
                CircleOutlineShader.Field2605.Method2164166(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), this.Field1894.getValue().floatValue(), this.Field1893.getValue().floatValue());
                CircleOutlineShader.Field2605.Method2164168(this.Field1845.getValue().floatValue() / 1000.0f);
                break;
            }
            case Smoke: {
                SmokeOutlineShader.Field1977.Method2164185(color2, this.Field1896.getValue().floatValue(), this.Field1895.getValue().floatValue(), this.Field1842.getValue(), this.Field1873.getValue(), this.Field1843.getValue().floatValue(), color4, color4, this.Field1869.getValue());
                SmokeOutlineShader.Field1977.Method2164187(this.Field1845.getValue().floatValue() / 1000.0f);
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
    }

    private boolean Method2162481(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162482(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162483(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162484(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162485(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162486(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162487(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162488(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162489(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162480(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162491(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162492(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162493(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162494(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162495(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162496(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162497(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Circle;
    }

    private boolean Method2162498(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Circle;
    }

    private boolean Method2162499(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Gradient;
    }

    private boolean Method2162490(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Gradient;
    }

    private boolean Method2162401(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Aqua;
    }

    private boolean Method2162402(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162403(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162404(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral || this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Gradient;
    }

    private boolean Method2162405(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162406(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162407(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162408(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162409(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162400(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke;
    }

    private boolean Method2162511(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke;
    }

    private boolean Method2162512(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Aqua;
    }

    private boolean Method2162513(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162514(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162515(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral || this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke;
    }

    private boolean Method2162516(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162517(Integer n2) {
        return this.Field1842.getValue() == false;
    }

    private boolean Method2162518(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162519(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162510(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RainbowCube;
    }

    private boolean Method2162521(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Smoke;
    }

    private boolean Method2162522(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Aqua;
    }

    private boolean Method2162523(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162524(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162525(Integer n2) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162526(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube;
    }

    private boolean Method2162527(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube;
    }

    private boolean Method2162528(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube;
    }

    private boolean Method2162529(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.RainbowCube;
    }

    private boolean Method2162520(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Smoke;
    }

    private boolean Method2162531(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Aqua;
    }

    private boolean Method2162532(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162533(Integer n2) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162534(Object object) {
        return this.Field1838.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Astral;
    }

    private boolean Method2162535(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162536(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162537(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162538(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162539(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162530(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162541(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Astral;
    }

    private boolean Method2162542(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Circle;
    }

    private boolean Method2162543(Object object) {
        return this.Field1837.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Circle;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        Astral,
        Aqua,
        Smoke,
        RainbowCube,
        Gradient,
        Fill,
        Circle,
        Phobos,
        None;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        None,
        Color,
        Astral,
        RainbowCube,
        Gradient,
        Circle,
        Smoke,
        Aqua;

    }
}

