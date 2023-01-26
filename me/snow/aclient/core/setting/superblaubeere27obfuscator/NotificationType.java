/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.awt.Color;

public enum NotificationType {
    SUCCESS(new Color(100, 255, 100).getRGB()),
    INFO(new Color(225, 225, 255).getRGB()),
    ERROR(new Color(255, 100, 100).getRGB()),
    WARNING(new Color(255, 211, 53).getRGB());

    private final int Field2992;

    private NotificationType(int n3) {
        this.Field2992 = n3;
    }

    public int IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() {
        return this.Field2992;
    }
}

