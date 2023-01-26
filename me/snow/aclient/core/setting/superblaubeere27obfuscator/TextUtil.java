/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.Random;
import java.util.regex.Pattern;

public class TextUtil {
    public static final String Field1467 = "\u00a7";
    public static final String Field1468 = "\u00a70";
    public static final String Field1469 = "\u00a71";
    public static final String Field1470 = "\u00a72";
    public static final String Field1471 = "\u00a73";
    public static final String Field1472 = "\u00a74";
    public static final String Field1473 = "\u00a75";
    public static final String Field1474 = "\u00a76";
    public static final String Field1475 = "\u00a77";
    public static final String Field1476 = "\u00a78";
    public static final String Field1477 = "\u00a79";
    public static final String Field1478 = "\u00a7a";
    public static final String Field1479 = "\u00a7b";
    public static final String Field1480 = "\u00a7c";
    public static final String Field1481 = "\u00a7d";
    public static final String Field1482 = "\u00a7e";
    public static final String Field1483 = "\u00a7f";
    public static final String Field1484 = "\u00a7k";
    public static final String Field1485 = "\u00a7l";
    public static final String Field1486 = "\u00a7m";
    public static final String Field1487 = "\u00a7n";
    public static final String Field1488 = "\u00a7o";
    public static final String Field1489 = "\u00a7r";
    public static final String Field1490 = "\u00a7+";
    public static final String Field1491 = " \u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592";
    public static final String Field1492 = " \u2588\u2588\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588";
    public static final String Field1493 = " \u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2592";
    public static final String Field1494 = " \u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588";
    public static final String Field1495 = " \u2588\u2592\u2592\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2592\u2592\u2588";
    public static final String Field1496 = " \u2588\u2592\u2592\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588";
    public static final String Field1497 = "  \u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\n \u2588\u2588\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\n \u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2592\n \u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\n \u2588\u2592\u2592\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2588\u2592\u2592\u2592\u2588\n \u2588\u2592\u2592\u2592\u2588\u2592\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\u2592\u2588\u2588\u2588\n \u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592\u2592";
    private static final Pattern Field1498 = Pattern.compile("(?i)\u00a7[0-9A-FK-OR]");
    private static final Random Field1499 = new Random();
    public static String Field1500 = "\u00af\\_(\u30c4)_/\u00af";
    public static String Field1501 = "\u267f";

    public static String Method2164746(String string) {
        if (string == null) {
            return null;
        }
        return Field1498.matcher(string).replaceAll("");
    }

    public static String Method2164747(String string, IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll) {
        String string2 = string;
        switch (1.F
        ield3334[iIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll.ordinal()])
        {
            case 1: {
                string2 = Field1479 + string2 + Field1489;
                break;
            }
            case 2: {
                string2 = Field1483 + string2 + Field1489;
                break;
            }
            case 3: {
                string2 = Field1468 + string2 + Field1489;
                break;
            }
            case 4: {
                string2 = Field1469 + string2 + Field1489;
                break;
            }
            case 5: {
                string2 = Field1470 + string2 + Field1489;
                break;
            }
            case 6: {
                string2 = Field1471 + string2 + Field1489;
                break;
            }
            case 7: {
                string2 = Field1472 + string2 + Field1489;
                break;
            }
            case 8: {
                string2 = Field1473 + string2 + Field1489;
                break;
            }
            case 9: {
                string2 = Field1474 + string2 + Field1489;
                break;
            }
            case 10: {
                string2 = Field1476 + string2 + Field1489;
                break;
            }
            case 11: {
                string2 = Field1475 + string2 + Field1489;
                break;
            }
            case 12: {
                string2 = Field1477 + string2 + Field1489;
                break;
            }
            case 13: {
                string2 = Field1480 + string2 + Field1489;
                break;
            }
            case 14: {
                string2 = Field1478 + string2 + Field1489;
                break;
            }
            case 15: {
                string2 = Field1481 + string2 + Field1489;
                break;
            }
            case 16: {
                string2 = Field1482 + string2 + Field1489;
            }
        }
        return string2;
    }

    public static String Method2164748(String string, int n2) {
        String string2 = "";
        if (string.length() >= 256 - n2) {
            string2 = string.substring(0, 256 - n2);
        }
        return string2;
    }

    public static enum IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll {
        NONE,
        WHITE,
        BLACK,
        DARK_BLUE,
        DARK_GREEN,
        DARK_AQUA,
        DARK_RED,
        DARK_PURPLE,
        GOLD,
        GRAY,
        DARK_GRAY,
        BLUE,
        GREEN,
        AQUA,
        RED,
        LIGHT_PURPLE,
        YELLOW;

    }
}

