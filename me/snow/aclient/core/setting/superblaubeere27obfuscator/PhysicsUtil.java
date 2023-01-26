

/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;
import me.snow.aclient.mixin.mixins.accessors.IEntityLivingBase;
import me.snow.aclient.mixin.mixins.accessors.IEntityPlayerSP;

public class PhysicsUtil
        implements Util {
    public static void Method2163917() {
        int n2 = ((IEntityLivingBase) PhysicsUtil.Field2811.player).getTicksSinceLastSwing();
        int n3 = ((IEntityLivingBase) PhysicsUtil.Field2811.player).getActiveItemStackUseCount();
        int n4 = PhysicsUtil.Field2811.player.hurtTime;
        float f = PhysicsUtil.Field2811.player.prevSwingProgress;
        float f2 = PhysicsUtil.Field2811.player.swingProgress;
        int n5 = PhysicsUtil.Field2811.player.swingProgressInt;
        boolean bl = PhysicsUtil.Field2811.player.isSwingInProgress;
        float f3 = PhysicsUtil.Field2811.player.rotationYaw;
        float f4 = PhysicsUtil.Field2811.player.prevRotationYaw;
        float f5 = PhysicsUtil.Field2811.player.renderYawOffset;
        float f6 = PhysicsUtil.Field2811.player.prevRenderYawOffset;
        float f7 = PhysicsUtil.Field2811.player.rotationYawHead;
        float f8 = PhysicsUtil.Field2811.player.prevRotationYawHead;
        float f9 = PhysicsUtil.Field2811.player.cameraYaw;
        float f10 = PhysicsUtil.Field2811.player.prevCameraYaw;
        float f11 = PhysicsUtil.Field2811.player.renderArmYaw;
        float f12 = PhysicsUtil.Field2811.player.prevRenderArmYaw;
        float f13 = PhysicsUtil.Field2811.player.renderArmPitch;
        float f14 = PhysicsUtil.Field2811.player.prevRenderArmPitch;
        float f15 = PhysicsUtil.Field2811.player.distanceWalkedModified;
        float f16 = PhysicsUtil.Field2811.player.prevDistanceWalkedModified;
        double d = PhysicsUtil.Field2811.player.chasingPosX;
        double d2 = PhysicsUtil.Field2811.player.prevChasingPosX;
        double d3 = PhysicsUtil.Field2811.player.chasingPosY;
        double d4 = PhysicsUtil.Field2811.player.prevChasingPosY;
        double d5 = PhysicsUtil.Field2811.player.chasingPosZ;
        double d6 = PhysicsUtil.Field2811.player.prevChasingPosZ;
        float f17 = PhysicsUtil.Field2811.player.limbSwingAmount;
        float f18 = PhysicsUtil.Field2811.player.prevLimbSwingAmount;
        float f19 = PhysicsUtil.Field2811.player.limbSwing;
        ((IEntityPlayerSP) PhysicsUtil.Field2811.player).superUpdate();
        ((IEntityLivingBase) PhysicsUtil.Field2811.player).setTicksSinceLastSwing(n2);
        ((IEntityLivingBase) PhysicsUtil.Field2811.player).setActiveItemStackUseCount(n3);
        PhysicsUtil.Field2811.player.hurtTime = n4;
        PhysicsUtil.Field2811.player.prevSwingProgress = f;
        PhysicsUtil.Field2811.player.swingProgress = f2;
        PhysicsUtil.Field2811.player.swingProgressInt = n5;
        PhysicsUtil.Field2811.player.isSwingInProgress = bl;
        PhysicsUtil.Field2811.player.rotationYaw = f3;
        PhysicsUtil.Field2811.player.prevRotationYaw = f4;
        PhysicsUtil.Field2811.player.renderYawOffset = f5;
        PhysicsUtil.Field2811.player.prevRenderYawOffset = f6;
        PhysicsUtil.Field2811.player.rotationYawHead = f7;
        PhysicsUtil.Field2811.player.prevRotationYawHead = f8;
        PhysicsUtil.Field2811.player.cameraYaw = f9;
        PhysicsUtil.Field2811.player.prevCameraYaw = f10;
        PhysicsUtil.Field2811.player.renderArmYaw = f11;
        PhysicsUtil.Field2811.player.prevRenderArmYaw = f12;
        PhysicsUtil.Field2811.player.renderArmPitch = f13;
        PhysicsUtil.Field2811.player.prevRenderArmPitch = f14;
        PhysicsUtil.Field2811.player.distanceWalkedModified = f15;
        PhysicsUtil.Field2811.player.prevDistanceWalkedModified = f16;
        PhysicsUtil.Field2811.player.chasingPosX = d;
        PhysicsUtil.Field2811.player.prevChasingPosX = d2;
        PhysicsUtil.Field2811.player.chasingPosY = d3;
        PhysicsUtil.Field2811.player.prevChasingPosY = d4;
        PhysicsUtil.Field2811.player.chasingPosZ = d5;
        PhysicsUtil.Field2811.player.prevChasingPosZ = d6;
        PhysicsUtil.Field2811.player.limbSwingAmount = f17;
        PhysicsUtil.Field2811.player.prevLimbSwingAmount = f18;
        PhysicsUtil.Field2811.player.limbSwing = f19;
        ((IEntityPlayerSP) PhysicsUtil.Field2811.player).invokeOnUpdateWalkingPlayer();
    }
}

