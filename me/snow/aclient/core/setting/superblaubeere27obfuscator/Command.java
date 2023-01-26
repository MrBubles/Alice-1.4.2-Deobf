

/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentBase
 *  net.minecraft.util.text.TextComponentString
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;

public abstract class Command
        extends Feature {
    protected String Field4314;
    protected String[] Field4315;

    public Command(String string) {
        super(string);
        this.Field4314 = string;
        this.Field4315 = new String[]{""};
    }

    public Command(String string, String[] arrstring) {
        super(string);
        this.Field4314 = string;
        this.Field4315 = arrstring;
    }

    public static void Method2159695(String string, boolean bl) {
        Command.Method2159697(AliceMain.Field761.Method2150112() + " \u00a7r" + string);
        if (bl) {
            AliceMain.Field776.Method2150228(string, 3000L);
        }
    }

    public static void Method2159696(String string) {
        Command.Method2159697(AliceMain.Field761.Method2150112() + " \u00a7r" + string);
    }

    public static void Method2159697(String string) {
        if (Command.Method2150358()) {
            return;
        }
        Command.Field2811.player.sendMessage((ITextComponent) new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(string));
    }

    public static void Method2159698(String string, boolean bl) {
        if (Command.Method2150358()) {
            return;
        }
        Command.Field2811.player.sendMessage((ITextComponent) new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(string));
        if (bl) {
            AliceMain.Field776.Method2150228(string, 3000L);
        }
    }

    public static void Method2159699(String string, int n2, boolean bl) {
        TextComponentString textComponentString = new TextComponentString(string);
        Command.Field2811.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion((ITextComponent) textComponentString, n2);
        if (bl) {
            AliceMain.Field776.Method2150228(string, 3000L);
        }
    }

    public static void Method2159690(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.insert(0, "\u00a7+");
        Command.Field2811.player.sendMessage((ITextComponent) new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(stringBuilder.toString()));
    }

    public static String Method2159601() {
        return AliceMain.Field761.Method2150114();
    }

    public abstract void Method2159602(String[] var1);

    @Override
    public String Method2150361() {
        return this.Field4314;
    }

    public String[] Method2159603() {
        return this.Field4315;
    }

    public static class IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll
            extends TextComponentBase {
        private final String Field1098;

        public IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(String string) {
            Pattern pattern = Pattern.compile("&[0123456789abcdefrlosmk]");
            Matcher matcher = pattern.matcher(string);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String string2 = "\u00a7" + matcher.group().substring(1);
                matcher.appendReplacement(stringBuffer, string2);
            }
            matcher.appendTail(stringBuffer);
            this.Field1098 = stringBuffer.toString();
        }

        public String getUnformattedComponentText() {
            return this.Field1098;
        }

        public ITextComponent createCopy() {
            return new IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(this.Field1098);
        }
    }
}

