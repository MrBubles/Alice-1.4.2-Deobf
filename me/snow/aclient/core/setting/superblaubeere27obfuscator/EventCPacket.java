/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.apache.commons.codec.digest.DigestUtils
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import org.apache.commons.codec.digest.DigestUtils;

public class EventCPacket {
    public static String Method2159693() {
        return DigestUtils.sha256Hex((String) DigestUtils.sha256Hex((String) (System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("user.name") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS"))));
    }
}

