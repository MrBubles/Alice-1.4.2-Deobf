

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicInteger;

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
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SmokeOutlineShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.SmokeShader;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Timer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Shaders
        extends Module {
    private final Timer Field4488 = new Timer();
    public Setting<Float> Field4407 = this.Method2150366(new Setting<Float>("duplicateOutline", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field4408 = this.Method2150366(new Setting<Float>("Duplicate Fill", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(5.0f)));
    public Setting<Float> Field4409 = this.Method2150366(new Setting<Float>("Speed Outline", Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(100.0f)));
    public Setting<Float> Field4410 = this.Method2150366(new Setting<Float>("Speed Fill", Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(100.0f)));
    public Setting<Float> Field4411 = this.Method2150366(new Setting<Float>("Shader Quality", Float.valueOf(0.6f), Float.valueOf(0.0f), Float.valueOf(20.0f)));
    public Setting<Float> Field4412 = this.Method2150366(new Setting<Float>("Shader Radius", Float.valueOf(1.7f), Float.valueOf(0.0f), Float.valueOf(5.0f)));
    public Setting<Integer> Field4423 = this.Method2150366(new Setting<Integer>("Max Entities", 100, 10, 500));
    public Setting<Integer> Field4438 = this.Method2150366(new Setting<Integer>("Alpha Outline", 255, 0, 255));
    public Setting<Integer> Field4469 = this.Method2150366(new Setting<Integer>("GlowESP Red", 0, 0, 255));
    public Setting<Integer> Field4470 = this.Method2150366(new Setting<Integer>("GlowESP Green", 0, 0, 255));
    public Setting<Integer> Field4471 = this.Method2150366(new Setting<Integer>("GlowESP Blue", 0, 0, 255));
    public Setting<Integer> Field4472 = this.Method2150366(new Setting<Integer>("GlowESP Alpha", 255, 0, 255));
    public Setting<Integer> Field4473 = this.Method2150366(new Setting<Integer>("FillShader Red", 0, 0, 255));
    public Setting<Integer> Field4474 = this.Method2150366(new Setting<Integer>("FillShader Green", 0, 0, 255));
    public Setting<Integer> Field4475 = this.Method2150366(new Setting<Integer>("FillShader Blue", 0, 0, 255));
    public Setting<Integer> Field4476 = this.Method2150366(new Setting<Integer>("FillShader Alpha", 255, 0, 255));
    public boolean Field4489 = true;
    public boolean Field4490 = true;
    private Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll> Field4394 = this.Method2150366(new Setting<IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll>("Fill Shader", IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.None));
    public Setting<Float> Field4413 = this.Method2150366(new Setting<Object>("RAD Fill", Float.valueOf(0.75f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162608));
    public Setting<Float> Field4414 = this.Method2150366(new Setting<Object>("PI Fill", Float.valueOf((float) Math.PI), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162607));
    public Setting<Float> Field4415 = this.Method2150366(new Setting<Object>("saturation", Float.valueOf(0.4f), Float.valueOf(0.0f), Float.valueOf(3.0f), this::Method2162606));
    public Setting<Float> Field4416 = this.Method2150366(new Setting<Object>("distfading", Float.valueOf(0.56f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162605));
    public Setting<Float> Field4417 = this.Method2150366(new Setting<Object>("Tile", Float.valueOf(0.45f), Float.valueOf(0.0f), Float.valueOf(1.3f), this::Method2162604));
    public Setting<Float> Field4418 = this.Method2150366(new Setting<Object>("Step Size", Float.valueOf(0.2f), Float.valueOf(0.0f), Float.valueOf(0.7f), this::Method2162603));
    public Setting<Float> Field4419 = this.Method2150366(new Setting<Object>("Volum Steps", Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162602));
    public Setting<Float> Field4420 = this.Method2150366(new Setting<Object>("Zoom", Float.valueOf(3.9f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162601));
    public Setting<Float> Field4421 = this.Method2150366(new Setting<Object>("formuparam2", Float.valueOf(0.89f), Float.valueOf(0.0f), Float.valueOf(1.5f), this::Method2162690));
    public Setting<Integer> Field4424 = this.Method2150366(new Setting<Integer>("Iteration", Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(20), this::Method2162698));
    public Setting<Integer> Field4425 = this.Method2150366(new Setting<Integer>("Max Iter", Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(30), this::Method2162697));
    public Setting<Integer> Field4426 = this.Method2150366(new Setting<Integer>("NUM_OCTAVES", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(30), this::Method2162696));
    public Setting<Integer> Field4427 = this.Method2150366(new Setting<Integer>("BSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162695));
    public Setting<Integer> Field4428 = this.Method2150366(new Setting<Integer>("GSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162694));
    public Setting<Integer> Field4429 = this.Method2150366(new Setting<Integer>("RSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162693));
    public Setting<Integer> Field4430 = this.Method2150366(new Setting<Integer>("Wave Lenght", Integer.valueOf(555), Integer.valueOf(0), Integer.valueOf(2000), this::Method2162692));
    public Setting<Float> Field4441 = this.Method2150366(new Setting<Object>("AlphaF", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162682));
    public Setting<Float> Field4442 = this.Method2150366(new Setting<Object>("BlueF", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162681));
    public Setting<Float> Field4443 = this.Method2150366(new Setting<Object>("GreenF", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162670));
    public Setting<Integer> Field4444 = this.Method2150366(new Setting<Integer>("RedF", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(100), this::Method2162679));
    public Setting<Float> Field4445 = this.Method2150366(new Setting<Object>("TAU", Float.valueOf((float) Math.PI * 2), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162678));
    public Setting<Float> Field4446 = this.Method2150366(new Setting<Object>("Creepy", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162677));
    public Setting<Float> Field4447 = this.Method2150366(new Setting<Object>("More Gradient", Float.valueOf(1.0f), Float.valueOf(0.0f), Double.valueOf(10.0), this::Method2162676));
    private Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll> Field4395 = this.Method2150366(new Setting<IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll>("Glow ESP", IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.None));
    public Setting<Float> Field4422 = this.Method2150366(new Setting<Object>("saturation", Float.valueOf(0.4f), Float.valueOf(0.0f), Float.valueOf(3.0f), this::Method2162699));
    public Setting<Integer> Field4431 = this.Method2150366(new Setting<Integer>("Volum Steps", Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(10), this::Method2162691));
    public Setting<Integer> Field4432 = this.Method2150366(new Setting<Integer>("Iteration", Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(20), this::Method2162680));
    public Setting<Integer> Field4433 = this.Method2150366(new Setting<Integer>("Max Iter", Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(30), this::Method2162689));
    public Setting<Integer> Field4434 = this.Method2150366(new Setting<Integer>("NUM_OCTAVES", Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(30), this::Method2162688));
    public Setting<Integer> Field4435 = this.Method2150366(new Setting<Integer>("BSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162687));
    public Setting<Integer> Field4436 = this.Method2150366(new Setting<Integer>("GSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162686));
    public Setting<Integer> Field4437 = this.Method2150366(new Setting<Integer>("RSTART", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1000), this::Method2162685));
    public Setting<Integer> Field4439 = this.Method2150366(new Setting<Integer>("Wave Lenght", Integer.valueOf(555), Integer.valueOf(0), Integer.valueOf(2000), this::Method2162684));
    public Setting<Integer> Field4440 = this.Method2150366(new Setting<Integer>("Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(100), this::Method2162683));
    public Setting<Float> Field4448 = this.Method2150366(new Setting<Object>("distfading", Float.valueOf(0.56f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162675));
    public Setting<Float> Field4449 = this.Method2150366(new Setting<Object>("Tile", Float.valueOf(0.45f), Float.valueOf(0.0f), Float.valueOf(1.3f), this::Method2162674));
    public Setting<Float> Field4450 = this.Method2150366(new Setting<Object>("Step Size", Float.valueOf(0.19f), Float.valueOf(0.0f), Float.valueOf(0.7f), this::Method2162673));
    public Setting<Float> Field4451 = this.Method2150366(new Setting<Object>("Zoom", Float.valueOf(3.9f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162672));
    public Setting<Float> Field4452 = this.Method2150366(new Setting<Object>("formuparam2", Float.valueOf(0.89f), Float.valueOf(0.0f), Float.valueOf(1.5f), this::Method2162671));
    public Setting<Float> Field4453 = this.Method2150366(new Setting<Object>("Alpha", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this::Method2162660));
    public Setting<Float> Field4454 = this.Method2150366(new Setting<Object>("Blue", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162669));
    public Setting<Float> Field4455 = this.Method2150366(new Setting<Object>("Green", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162668));
    public Setting<Float> Field4456 = this.Method2150366(new Setting<Object>("TAU", Float.valueOf((float) Math.PI * 2), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162667));
    public Setting<Float> Field4457 = this.Method2150366(new Setting<Object>("Gradient Creepy", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this::Method2162666));
    public Setting<Float> Field4458 = this.Method2150366(new Setting<Object>("More Gradient", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162665));
    public Setting<Float> Field4459 = this.Method2150366(new Setting<Object>("RAD Outline", Float.valueOf(0.75f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162664));
    public Setting<Float> Field4460 = this.Method2150366(new Setting<Object>("PI Outline", Float.valueOf((float) Math.PI), Float.valueOf(0.0f), Float.valueOf(10.0f), this::Method2162663));
    public Setting<Integer> Field4461 = this.Method2150366(new Setting<Integer>("colorImgOutline Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162662));
    public Setting<Integer> Field4462 = this.Method2150366(new Setting<Integer>("colorImgOutline Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162661));
    public Setting<Integer> Field4463 = this.Method2150366(new Setting<Integer>("colorImgOutline Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162650));
    public Setting<Integer> Field4464 = this.Method2150366(new Setting<Integer>("colorImgOutline Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162659));
    public Setting<Integer> Field4465 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162658));
    public Setting<Integer> Field4466 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162657));
    public Setting<Integer> Field4467 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162656));
    public Setting<Integer> Field4468 = this.Method2150366(new Setting<Integer>("thirdColorImgOutline Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162655));
    public Setting<Integer> Field4477 = this.Method2150366(new Setting<Integer>("SmokeImgFill Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162654));
    public Setting<Integer> Field4478 = this.Method2150366(new Setting<Integer>("SmokeImgFill Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162653));
    public Setting<Integer> Field4479 = this.Method2150366(new Setting<Integer>("SmokeFImgill Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162652));
    public Setting<Integer> Field4480 = this.Method2150366(new Setting<Integer>("SmokeImgFill Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162651));
    public Setting<Integer> Field4481 = this.Method2150366(new Setting<Integer>("SmokeFill Red", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162640));
    public Setting<Integer> Field4482 = this.Method2150366(new Setting<Integer>("SmokeFill Green", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162649));
    public Setting<Integer> Field4483 = this.Method2150366(new Setting<Integer>("SmokeFill Blue", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), this::Method2162648));
    public Setting<Integer> Field4484 = this.Method2150366(new Setting<Integer>("SmokeFill Alpha", Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(255), this::Method2162647));
    private Setting<Boolean> Field4396 = this.Method2150366(new Setting<Boolean>("Range Check", true));
    public Setting<Float> Field4397 = this.Method2150366(new Setting<Object>("Max Range", Float.valueOf(35.0f), Float.valueOf(10.0f), Float.valueOf(100.0f), this::Method2162712));
    public Setting<Float> Field4398 = this.Method2150366(new Setting<Object>("Min range", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f), this::Method2162711));
    private Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll> Field4399 = this.Method2150366(new Setting<IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll>("Crystals", IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None));
    private Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll> Field4400 = this.Method2150366(new Setting<IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll>("Players", IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.None));
    private Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll> Field4401 = this.Method2150366(new Setting<IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll>("Mobs", IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.None));
    private Setting<Boolean> Field4402 = this.Method2150366(new Setting<Boolean>("Reset Setting", false));
    private Setting<Boolean> Field4403 = this.Method2150366(new Setting<Boolean>("FutureRainbow Preset", false));
    private Setting<Boolean> Field4404 = this.Method2150366(new Setting<Boolean>("ColorFill Preset", false));
    private Setting<Boolean> Field4405 = this.Method2150366(new Setting<Boolean>("Fade Fill", Boolean.valueOf(false), this::Method2162600));
    private Setting<Boolean> Field4406 = this.Method2150366(new Setting<Boolean>("FadeOL Fill", Boolean.valueOf(false), this::Method2162609));
    private Setting<Boolean> Field4485 = this.Method2150366(new Setting<Boolean>("TestColorSync", false));
    private Setting<Boolean> Field4486 = this.Method2150366(new Setting<Boolean>("LoginDisable", false));
    private Setting<Boolean> Field4487 = this.Method2150366(new Setting<Boolean>("NewDisable", true));

    public Shaders() {
        super("Shaders", "Spawns in a fake player", Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.RENDER, true, false, false);
    }

    private static void Method2162641(float f, Entity entity) {
        Field2811.getRenderManager().renderEntityStatic(entity, f, true);
    }

    private static boolean Method2162642(boolean bl, double d, double d2, Entity entity) {
        if (!bl) {
            return true;
        }
        double d3 = Shaders.Field2811.player.getDistanceSq(entity);
        return d3 > d && d3 < d2 || entity.getEntityId() == -1000;
    }

    private static void Method2162644(float f, Entity entity) {
        Field2811.getRenderManager().renderEntityStatic(entity, f, true);
    }

    private static boolean Method2162645(boolean bl, double d, double d2, Entity entity) {
        if (!bl) {
            return true;
        }
        double d3 = Shaders.Field2811.player.getDistanceSq(entity);
        return d3 > d && d3 < d2;
    }

    @Override
    public void Method2150377() {
        if (this.Field4486.getValue().booleanValue()) {
            this.Method2150380();
        }
        this.Field4488.Method2164750();
    }

    public boolean Method2162637() {
        return this.Field4487.getValue() == false || this.Field4487.getValue() != false && this.Field4488.Method2164755(600L);
    }

    @Override
    public void Method2150376() {
        if (this.Field4403.getValue().booleanValue()) {
            this.Field4394.setValue(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.None);
            this.Field4395.setValue(IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Gradient);
            this.Field4400.setValue(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Outline);
            this.Field4399.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Outline);
            this.Field4407.setValue(Float.valueOf(2.0f));
            this.Field4409.setValue(Float.valueOf(30.0f));
            this.Field4411.setValue(Float.valueOf(0.6f));
            this.Field4412.setValue(Float.valueOf(1.7f));
            this.Field4457.setValue(Float.valueOf(1.0f));
            this.Field4458.setValue(Float.valueOf(1.0f));
            this.Field4403.setValue(false);
        }
        if (this.Field4404.getValue().booleanValue()) {
            this.Field4394.setValue(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Fill);
            this.Field4395.setValue(IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Color);
            this.Field4400.setValue(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Both);
            this.Field4399.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Both);
            this.Field4407.setValue(Float.valueOf(2.0f));
            this.Field4409.setValue(Float.valueOf(30.0f));
            this.Field4411.setValue(Float.valueOf(0.6f));
            this.Field4412.setValue(Float.valueOf(1.7f));
            this.Field4457.setValue(Float.valueOf(1.0f));
            this.Field4458.setValue(Float.valueOf(1.0f));
            this.Field4438.setValue(255);
            this.Field4476.setValue(40);
            this.Field4404.setValue(false);
        }
        if (this.Field4402.getValue().booleanValue()) {
            this.Field4394.setValue(IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.None);
            this.Field4395.setValue(IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.None);
            this.Field4396.setValue(true);
            this.Field4397.setValue(Float.valueOf(35.0f));
            this.Field4398.setValue(Float.valueOf(0.0f));
            this.Field4399.setValue(IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.None);
            this.Field4400.setValue(IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.None);
            this.Field4401.setValue(IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.None);
            this.Field4405.setValue(false);
            this.Field4406.setValue(false);
            this.Field4407.setValue(Float.valueOf(1.0f));
            this.Field4408.setValue(Float.valueOf(1.0f));
            this.Field4409.setValue(Float.valueOf(10.0f));
            this.Field4410.setValue(Float.valueOf(10.0f));
            this.Field4411.setValue(Float.valueOf(0.6f));
            this.Field4412.setValue(Float.valueOf(1.7f));
            this.Field4413.setValue(Float.valueOf(0.75f));
            this.Field4414.setValue(Float.valueOf((float) Math.PI));
            this.Field4415.setValue(Float.valueOf(0.4f));
            this.Field4416.setValue(Float.valueOf(0.56f));
            this.Field4417.setValue(Float.valueOf(0.45f));
            this.Field4418.setValue(Float.valueOf(0.2f));
            this.Field4419.setValue(Float.valueOf(10.0f));
            this.Field4420.setValue(Float.valueOf(3.9f));
            this.Field4421.setValue(Float.valueOf(0.89f));
            this.Field4422.setValue(Float.valueOf(0.4f));
            this.Field4423.setValue(100);
            this.Field4424.setValue(4);
            this.Field4444.setValue(0);
            this.Field4425.setValue(5);
            this.Field4426.setValue(5);
            this.Field4427.setValue(0);
            this.Field4428.setValue(0);
            this.Field4429.setValue(0);
            this.Field4430.setValue(555);
            this.Field4431.setValue(10);
            this.Field4432.setValue(4);
            this.Field4433.setValue(5);
            this.Field4434.setValue(5);
            this.Field4435.setValue(0);
            this.Field4436.setValue(0);
            this.Field4437.setValue(0);
            this.Field4438.setValue(255);
            this.Field4439.setValue(555);
            this.Field4440.setValue(0);
            this.Field4441.setValue(Float.valueOf(1.0f));
            this.Field4442.setValue(Float.valueOf(0.0f));
            this.Field4443.setValue(Float.valueOf(0.0f));
            this.Field4445.setValue(Float.valueOf((float) Math.PI * 2));
            this.Field4446.setValue(Float.valueOf(1.0f));
            this.Field4447.setValue(Float.valueOf(1.0f));
            this.Field4448.setValue(Float.valueOf(0.56f));
            this.Field4449.setValue(Float.valueOf(0.45f));
            this.Field4450.setValue(Float.valueOf(0.19f));
            this.Field4451.setValue(Float.valueOf(3.9f));
            this.Field4452.setValue(Float.valueOf(0.89f));
            this.Field4453.setValue(Float.valueOf(1.0f));
            this.Field4454.setValue(Float.valueOf(0.0f));
            this.Field4455.setValue(Float.valueOf(0.0f));
            this.Field4456.setValue(Float.valueOf(0.0f));
            this.Field4457.setValue(Float.valueOf(1.0f));
            this.Field4458.setValue(Float.valueOf(1.0f));
            this.Field4459.setValue(Float.valueOf(0.75f));
            this.Field4460.setValue(Float.valueOf((float) Math.PI));
            this.Field4402.setValue(false);
        }
    }

    @SubscribeEvent
    public void Method2162638(RenderGameOverlayEvent renderGameOverlayEvent) {
        if (this.Method2162637() && renderGameOverlayEvent.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            if (Shaders.Field2811.world == null || Shaders.Field2811.player == null) {
                return;
            }
            GlStateManager.pushMatrix();
            this.Field4489 = false;
            this.Field4490 = false;
            Color color = new Color(this.Field4473.getValue(), this.Field4474.getValue(), this.Field4475.getValue(), this.Field4476.getValue());
            Color color2 = new Color(this.Field4469.getValue(), this.Field4470.getValue(), this.Field4471.getValue(), this.Field4472.getValue());
            Color color3 = new Color(this.Field4481.getValue(), this.Field4482.getValue(), this.Field4483.getValue(), this.Field4484.getValue());
            Color color4 = new Color(this.Field4465.getValue(), this.Field4466.getValue(), this.Field4467.getValue(), this.Field4468.getValue());
            Color color5 = new Color(this.Field4477.getValue(), this.Field4478.getValue(), this.Field4479.getValue(), this.Field4480.getValue());
            Color color6 = new Color(this.Field4461.getValue(), this.Field4462.getValue(), this.Field4463.getValue(), this.Field4464.getValue());
            Color color7 = this.Field4485.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field4473.getValue(), this.Field4474.getValue(), this.Field4475.getValue(), this.Field4476.getValue());
            Color color8 = new Color(color7.getRed(), color7.getGreen(), color7.getBlue(), this.Field4476.getValue());
            Color color9 = this.Field4485.getValue() != false ? Colors.Field1782.Method2150586() : new Color(this.Field4469.getValue(), this.Field4470.getValue(), this.Field4471.getValue(), this.Field4472.getValue());
            Color color10 = new Color(color9.getRed(), color9.getGreen(), color9.getBlue(), this.Field4472.getValue());
            if (this.Field4395.getValue() != IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.None && this.Field4394.getValue() != IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.None) {
                switch (this.Field4394.getValue()) {
                    case Astral: {
                        FlowShader.Field3091.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        FlowShader.Field3091.Method2164138(Color.WHITE, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4444.getValue().floatValue(), this.Field4443.getValue().floatValue(), this.Field4442.getValue().floatValue(), this.Field4441.getValue().floatValue(), this.Field4424.getValue(), this.Field4421.getValue().floatValue(), this.Field4420.getValue().floatValue(), this.Field4419.getValue().floatValue(), this.Field4418.getValue().floatValue(), this.Field4417.getValue().floatValue(), this.Field4416.getValue().floatValue(), this.Field4415.getValue().floatValue(), 0.0f, this.Field4405.getValue() != false ? 1 : 0);
                        FlowShader.Field3091.Method2164130(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Aqua: {
                        AquaShader.Field1798.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        AquaShader.Field1798.Method2164126(color, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4425.getValue(), this.Field4445.getValue().floatValue());
                        AquaShader.Field1798.Method2164128(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Smoke: {
                        SmokeShader.Field3658.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        SmokeShader.Field3658.Method2164154(Color.WHITE, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), color, color3, color5, this.Field4426.getValue());
                        SmokeShader.Field3658.Method2164156(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case RainbowCube: {
                        RainbowCubeShader.Field3637.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        RainbowCubeShader.Field3637.Method2164140(Color.WHITE, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), color, this.Field4430.getValue(), this.Field4429.getValue(), this.Field4428.getValue(), this.Field4427.getValue());
                        RainbowCubeShader.Field3637.Method2164152(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Gradient: {
                        GradientShader.Field2332.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        GradientShader.Field2332.Method2164142(color2, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4447.getValue().floatValue(), this.Field4446.getValue().floatValue(), this.Field4441.getValue().floatValue(), this.Field4426.getValue());
                        GradientShader.Field2332.Method2164144(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Fill: {
                        FillShader.Field2031.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        FillShader.Field2031.Method2164134(color8);
                        FillShader.Field2031.Method2164136(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Circle: {
                        CircleShader.Field732.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        CircleShader.Field732.Method2164120(this.Field4408.getValue().floatValue(), color, this.Field4414.getValue(), this.Field4413.getValue());
                        CircleShader.Field732.Method2164132(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Phobos: {
                        PhobosShader.Field3396.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        PhobosShader.Field3396.Method2164146(color, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4425.getValue(), this.Field4445.getValue().floatValue());
                        PhobosShader.Field3396.Method2164148(this.Field4410.getValue().floatValue() / 1000.0f);
                    }
                }
                switch (this.Field4395.getValue()) {
                    case Color: {
                        GlowShader.Field305.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        GlowShader.Field305.Method2164174(color10, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue());
                        break;
                    }
                    case RainbowCube: {
                        RainbowCubeOutlineShader.Field2995.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        RainbowCubeOutlineShader.Field2995.Method2164181(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), color6, this.Field4439.getValue(), this.Field4437.getValue(), this.Field4436.getValue(), this.Field4435.getValue());
                        RainbowCubeOutlineShader.Field2995.Method2164183(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Gradient: {
                        GradientOutlineShader.Field327.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        GradientOutlineShader.Field327.Method2164177(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4458.getValue().floatValue(), this.Field4457.getValue().floatValue(), this.Field4453.getValue().floatValue(), this.Field4434.getValue());
                        GradientOutlineShader.Field327.Method2164179(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Astral: {
                        AstralOutlineShader.Field634.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        AstralOutlineShader.Field634.Method2164162(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4440.getValue().floatValue(), this.Field4455.getValue().floatValue(), this.Field4454.getValue().floatValue(), this.Field4453.getValue().floatValue(), this.Field4432.getValue(), this.Field4452.getValue().floatValue(), this.Field4451.getValue().floatValue(), this.Field4431.getValue().intValue(), this.Field4450.getValue().floatValue(), this.Field4449.getValue().floatValue(), this.Field4448.getValue().floatValue(), this.Field4422.getValue().floatValue(), 0.0f, this.Field4406.getValue() != false ? 1 : 0);
                        AstralOutlineShader.Field634.Method2164164(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Aqua: {
                        AquaOutlineShader.Field1447.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        AquaOutlineShader.Field1447.Method2164158(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4433.getValue(), this.Field4456.getValue().floatValue());
                        AquaOutlineShader.Field1447.Method2164150(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Circle: {
                        CircleOutlineShader.Field2605.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        CircleOutlineShader.Field2605.Method2164166(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4460.getValue().floatValue(), this.Field4459.getValue().floatValue());
                        CircleOutlineShader.Field2605.Method2164168(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Smoke: {
                        SmokeOutlineShader.Field1977.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        SmokeOutlineShader.Field1977.Method2164185(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), color3, color4, this.Field4434.getValue());
                        SmokeOutlineShader.Field1977.Method2164187(this.Field4409.getValue().floatValue() / 1000.0f);
                    }
                }
            } else {
                switch (this.Field4395.getValue()) {
                    case Color: {
                        GlowShader.Field305.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        GlowShader.Field305.Method2164174(color10, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue());
                        break;
                    }
                    case RainbowCube: {
                        RainbowCubeOutlineShader.Field2995.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        RainbowCubeOutlineShader.Field2995.Method2164181(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), color6, this.Field4439.getValue(), this.Field4437.getValue(), this.Field4436.getValue(), this.Field4435.getValue());
                        RainbowCubeOutlineShader.Field2995.Method2164183(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Gradient: {
                        GradientOutlineShader.Field327.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        GradientOutlineShader.Field327.Method2164177(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4458.getValue().floatValue(), this.Field4457.getValue().floatValue(), this.Field4453.getValue().floatValue(), this.Field4434.getValue());
                        GradientOutlineShader.Field327.Method2164179(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Astral: {
                        AstralOutlineShader.Field634.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        AstralOutlineShader.Field634.Method2164162(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4440.getValue().floatValue(), this.Field4455.getValue().floatValue(), this.Field4454.getValue().floatValue(), this.Field4453.getValue().floatValue(), this.Field4432.getValue(), this.Field4452.getValue().floatValue(), this.Field4451.getValue().floatValue(), this.Field4431.getValue().intValue(), this.Field4450.getValue().floatValue(), this.Field4449.getValue().floatValue(), this.Field4448.getValue().floatValue(), this.Field4422.getValue().floatValue(), 0.0f, this.Field4406.getValue() != false ? 1 : 0);
                        AstralOutlineShader.Field634.Method2164164(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Aqua: {
                        AquaOutlineShader.Field1447.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        AquaOutlineShader.Field1447.Method2164158(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4433.getValue(), this.Field4456.getValue().floatValue());
                        AquaOutlineShader.Field1447.Method2164150(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Circle: {
                        CircleOutlineShader.Field2605.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        CircleOutlineShader.Field2605.Method2164166(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), this.Field4460.getValue().floatValue(), this.Field4459.getValue().floatValue());
                        CircleOutlineShader.Field2605.Method2164168(this.Field4409.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Smoke: {
                        SmokeOutlineShader.Field1977.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162630(renderGameOverlayEvent.getPartialTicks());
                        SmokeOutlineShader.Field1977.Method2164185(color2, this.Field4412.getValue().floatValue(), this.Field4411.getValue().floatValue(), false, this.Field4438.getValue(), this.Field4407.getValue().floatValue(), color3, color4, this.Field4434.getValue());
                        SmokeOutlineShader.Field1977.Method2164187(this.Field4409.getValue().floatValue() / 1000.0f);
                    }
                }
                switch (this.Field4394.getValue()) {
                    case Astral: {
                        FlowShader.Field3091.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        FlowShader.Field3091.Method2164138(Color.WHITE, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4444.getValue().floatValue(), this.Field4443.getValue().floatValue(), this.Field4442.getValue().floatValue(), this.Field4441.getValue().floatValue(), this.Field4424.getValue(), this.Field4421.getValue().floatValue(), this.Field4420.getValue().floatValue(), this.Field4419.getValue().floatValue(), this.Field4418.getValue().floatValue(), this.Field4417.getValue().floatValue(), this.Field4416.getValue().floatValue(), this.Field4415.getValue().floatValue(), 0.0f, this.Field4405.getValue() != false ? 1 : 0);
                        FlowShader.Field3091.Method2164130(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Aqua: {
                        AquaShader.Field1798.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        AquaShader.Field1798.Method2164126(color, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4425.getValue(), this.Field4445.getValue().floatValue());
                        AquaShader.Field1798.Method2164128(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Smoke: {
                        SmokeShader.Field3658.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        SmokeShader.Field3658.Method2164154(Color.WHITE, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), color, color3, color5, this.Field4426.getValue());
                        SmokeShader.Field3658.Method2164156(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case RainbowCube: {
                        RainbowCubeShader.Field3637.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        RainbowCubeShader.Field3637.Method2164140(Color.WHITE, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), color, this.Field4430.getValue(), this.Field4429.getValue(), this.Field4428.getValue(), this.Field4427.getValue());
                        RainbowCubeShader.Field3637.Method2164152(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Gradient: {
                        GradientShader.Field2332.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        GradientShader.Field2332.Method2164142(color2, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4447.getValue().floatValue(), this.Field4446.getValue().floatValue(), this.Field4441.getValue().floatValue(), this.Field4426.getValue());
                        GradientShader.Field2332.Method2164144(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Fill: {
                        FillShader.Field2031.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        FillShader.Field2031.Method2164134(color8);
                        FillShader.Field2031.Method2164136(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Circle: {
                        CircleShader.Field732.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        CircleShader.Field732.Method2164120(this.Field4408.getValue().floatValue(), color, this.Field4414.getValue(), this.Field4413.getValue());
                        CircleShader.Field732.Method2164132(this.Field4410.getValue().floatValue() / 1000.0f);
                        break;
                    }
                    case Phobos: {
                        PhobosShader.Field3396.Method2164121(renderGameOverlayEvent.getPartialTicks());
                        this.Method2162639(renderGameOverlayEvent.getPartialTicks());
                        PhobosShader.Field3396.Method2164146(color, 1.0f, 1.0f, this.Field4408.getValue().floatValue(), this.Field4425.getValue(), this.Field4445.getValue().floatValue());
                        PhobosShader.Field3396.Method2164148(this.Field4410.getValue().floatValue() / 1000.0f);
                    }
                }
            }
            this.Field4489 = true;
            this.Field4490 = true;
            GlStateManager.popMatrix();
        }
    }

    void Method2162639(float f) {
        if (this.Method2162637()) {
            boolean bl = this.Field4396.getValue();
            double d = this.Field4398.getValue().floatValue() * this.Field4398.getValue().floatValue();
            double d2 = this.Field4397.getValue().floatValue() * this.Field4397.getValue().floatValue();
            AtomicInteger atomicInteger = new AtomicInteger();
            int n2 = this.Field4423.getValue();
            try {
                Shaders.Field2811.world.loadedEntityList.stream().filter(arg_0 -> this.Method2162646(atomicInteger, n2, arg_0)).filter(arg_0 -> Shaders.Method2162645(bl, d, d2, arg_0)).forEach(arg_0 -> Shaders.Method2162644(f, arg_0));
            } catch (Exception exception) {
                // empty catch block
            }
        }
    }

    void Method2162630(float f) {
        if (this.Method2162637()) {
            boolean bl = this.Field4396.getValue();
            double d = this.Field4398.getValue().floatValue() * this.Field4398.getValue().floatValue();
            double d2 = this.Field4397.getValue().floatValue() * this.Field4397.getValue().floatValue();
            AtomicInteger atomicInteger = new AtomicInteger();
            int n2 = this.Field4423.getValue();
            Shaders.Field2811.world.addEntityToWorld(-1000, (Entity) new EntityXPOrb((World) Shaders.Field2811.world, Shaders.Field2811.player.posX, Shaders.Field2811.player.posY + 1000000.0, Shaders.Field2811.player.posZ, 1));
            Shaders.Field2811.world.loadedEntityList.stream().filter(arg_0 -> this.Method2162643(atomicInteger, n2, arg_0)).filter(arg_0 -> Shaders.Method2162642(bl, d, d2, arg_0)).forEach(arg_0 -> Shaders.Method2162641(f, arg_0));
            Shaders.Field2811.world.removeEntityFromWorld(-1000);
        }
    }

    private boolean Method2162643(AtomicInteger atomicInteger, int n2, Entity entity) {
        if (atomicInteger.getAndIncrement() > n2) {
            return false;
        }
        return entity instanceof EntityPlayer ? !(this.Field4400.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Outline && this.Field4400.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Both || entity == Shaders.Field2811.player && Shaders.Field2811.gameSettings.thirdPersonView == 0) : (entity instanceof EntityCreature ? this.Field4401.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Outline || this.Field4401.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Both : entity instanceof EntityEnderCrystal && (this.Field4399.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Outline || this.Field4399.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Both));
    }

    private boolean Method2162646(AtomicInteger atomicInteger, int n2, Entity entity) {
        if (atomicInteger.getAndIncrement() > n2) {
            return false;
        }
        return entity instanceof EntityPlayer ? !(this.Field4400.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Fill && this.Field4400.getValue() != IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll.Both || entity == Shaders.Field2811.player && Shaders.Field2811.gameSettings.thirdPersonView == 0) : (entity instanceof EntityCreature ? this.Field4401.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Fill || this.Field4401.getValue() == IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.Both : entity instanceof EntityEnderCrystal && (this.Field4399.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Fill || this.Field4399.getValue() == IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.Both));
    }

    private boolean Method2162647(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162648(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162649(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162640(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162651(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162652(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162653(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162654(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162655(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162656(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162657(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162658(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162659(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162650(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162661(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162662(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162663(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Circle;
    }

    private boolean Method2162664(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Circle;
    }

    private boolean Method2162665(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Gradient;
    }

    private boolean Method2162666(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Gradient;
    }

    private boolean Method2162667(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Aqua;
    }

    private boolean Method2162668(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162669(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162660(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Gradient;
    }

    private boolean Method2162671(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162672(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162673(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162674(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162675(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162676(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke;
    }

    private boolean Method2162677(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke;
    }

    private boolean Method2162678(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Aqua;
    }

    private boolean Method2162679(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162670(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162681(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162682(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral || this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke;
    }

    private boolean Method2162683(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162684(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162685(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162686(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162687(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.RainbowCube;
    }

    private boolean Method2162688(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Smoke;
    }

    private boolean Method2162689(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Aqua;
    }

    private boolean Method2162680(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162691(Integer n2) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162692(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube;
    }

    private boolean Method2162693(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube;
    }

    private boolean Method2162694(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube;
    }

    private boolean Method2162695(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.RainbowCube;
    }

    private boolean Method2162696(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Smoke;
    }

    private boolean Method2162697(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Aqua;
    }

    private boolean Method2162698(Integer n2) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162699(Object object) {
        return this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162690(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162601(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162602(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162603(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162604(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162605(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162606(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral;
    }

    private boolean Method2162607(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Circle;
    }

    private boolean Method2162608(Object object) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Circle;
    }

    private boolean Method2162609(Boolean bl) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162600(Boolean bl) {
        return this.Field4394.getValue() == IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll.Astral || this.Field4395.getValue() == IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll.Astral;
    }

    private boolean Method2162711(Object object) {
        return this.Field4396.getValue();
    }

    private boolean Method2162712(Object object) {
        return this.Field4396.getValue();
    }

    public static enum IIllIIIllIllIIIlllIIIlllIIllIIlllIlIIIllIllIlIIlIIIlllIIlIIllIIllIlIllIIllIIIllIIlIllIIlIIlIIllIIlIlIIllIllIIlIlIIlIIIllIIlIllIllIIlllIllIIlIlllIIllIlIlllIIlllIIIlIIlIIllIlllIlIIllIIIllIlIlIIlIIllIllIlIllIIIllIIll {
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

    public static enum IlIIIlIIllIlllIlIIIlIIlllIIlIllIIlIIllIIIlllIIlllIIIlIIIlIIllIlllIIllIllIIIlllIlIllIIIlllIIlllIlIIllIIIllIlIIlIlllIllIIlIIllIllIlIlIIlIIIllIIllIIlIllIIllIIlIIlllIllIIIllIlllIIllIlllIlIIlIllIIlllIIIllIlllIIIllIIlIIllIlllIIll {
        None,
        Color,
        Astral,
        RainbowCube,
        Gradient,
        Circle,
        Smoke,
        Aqua;

    }

    public static enum IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll {
        None,
        Fill,
        Outline,
        Both;

    }

    public static enum IlllIIlIIIlllIIIlIIllIlIllIIIlIIIllIlllIIIllIIlIIllIIllIlllIIllIIllIIllIIllIIlllIIlllIllIIllIlllIlIllIIlllIllIllIIlllIIllIIIlllIIIllIIIllIlllIIlllIIlIlIlIlIllIIIlllIIlIllIIllIIlllIIlIIIllIIIllIIlIIlllIlIllIllIIlIIIllIllIIlIIllIll {
        None,
        Fill,
        Outline,
        Both;

    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        None,
        Fill,
        Outline,
        Both;

    }
}

