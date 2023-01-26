

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Location {
    protected static final Minecraft Field1438 = Minecraft.getMinecraft();
    public static boolean Field1445;
    private double Field1439;
    private double Field1440;
    private double Field1441;
    private float Field1442;
    private float Field1443;
    private double Field1444;
    private boolean Field1446;

    public Location(double d, double d2, double d3, float f, float f2) {
        this.Field1439 = d;
        this.Field1440 = d2;
        this.Field1441 = d3;
        this.Field1442 = f;
        this.Field1443 = f2;
    }

    public Location(double d, double d2, double d3, boolean bl, boolean bl2) {
        this.Field1439 = d;
        this.Field1440 = d2;
        this.Field1444 = d2;
        this.Field1441 = d3;
        this.Field1446 = bl;
        Field1445 = bl2;
    }

    public Location(double d, double d2, double d3) {
        this.Field1439 = d;
        this.Field1440 = d2;
        this.Field1441 = d3;
        this.Field1442 = 0.0f;
        this.Field1446 = true;
        this.Field1443 = 0.0f;
    }

    public Location(BlockPos blockPos) {
        this.Field1439 = blockPos.getX();
        this.Field1440 = blockPos.getY();
        this.Field1441 = blockPos.getZ();
        this.Field1442 = 0.0f;
        this.Field1443 = 0.0f;
    }

    public Location(EntityLivingBase entityLivingBase) {
        this.Field1439 = entityLivingBase.posX;
        this.Field1440 = entityLivingBase.posY;
        this.Field1441 = entityLivingBase.posZ;
        this.Field1442 = 0.0f;
        this.Field1443 = 0.0f;
    }

    public Location(int n2, int n3, int n4) {
        this.Field1439 = n2;
        this.Field1440 = n3;
        this.Field1441 = n4;
        this.Field1442 = 0.0f;
        this.Field1443 = 0.0f;
    }

    public static boolean Method2163815() {
        return Field1445;
    }

    public static Location Method2163832(BlockPos blockPos) {
        return new Location(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    public boolean Method2163816() {
        return this.Field1446;
    }

    public Location Method2163817(int n2, int n3, int n4) {
        this.Field1439 += (double) n2;
        this.Field1440 += (double) n3;
        this.Field1441 += (double) n4;
        return this;
    }

    public Location Method2163818(double d, double d2, double d3) {
        this.Field1439 += d;
        this.Field1440 += d2;
        this.Field1441 += d3;
        return this;
    }

    public Location Method2163819(int n2, int n3, int n4) {
        this.Field1439 -= (double) n2;
        this.Field1440 -= (double) n3;
        this.Field1441 -= (double) n4;
        return this;
    }

    public Location Method2163810(double d, double d2, double d3) {
        this.Field1439 -= d;
        this.Field1440 -= d2;
        this.Field1441 -= d3;
        return this;
    }

    public Block Method2163821() {
        return Location.Field1438.world.getBlockState(this.Method2163833()).getBlock();
    }

    public double Method2163822() {
        return this.Field1439;
    }

    public Location Method2163823(double d) {
        this.Field1439 = d;
        return this;
    }

    public double Method2163824() {
        return this.Field1440;
    }

    public Location Method2163825(double d) {
        this.Field1440 = d;
        return this;
    }

    public double Method2163826() {
        return this.Field1441;
    }

    public Location Method2163827(double d) {
        this.Field1441 = d;
        return this;
    }

    public float Method2163828() {
        return this.Field1442;
    }

    public Location Method2163829(float f) {
        this.Field1442 = f;
        return this;
    }

    public float Method2163820() {
        return this.Field1443;
    }

    public Location Method2163831(float f) {
        this.Field1443 = f;
        return this;
    }

    public BlockPos Method2163833() {
        return new BlockPos(this.Method2163822(), this.Method2163824(), this.Method2163826());
    }

    public double Method2163834(Location location) {
        double d = location.Field1439 - this.Field1439;
        double d2 = location.Field1441 - this.Field1441;
        double d3 = location.Field1440 - this.Field1440;
        return Math.sqrt(d * d + d3 * d3 + d2 * d2);
    }

    public double Method2163835(Location location) {
        double d = location.Field1439 - this.Field1439;
        double d2 = location.Field1441 - this.Field1441;
        return Math.sqrt(d * d + d2 * d2);
    }

    public double Method2163836(Location location) {
        double d = location.Field1440 - this.Field1440;
        return Math.sqrt(d * d);
    }

    public Vec3d Method2163837() {
        return new Vec3d(this.Field1439, this.Field1440, this.Field1441);
    }
}

