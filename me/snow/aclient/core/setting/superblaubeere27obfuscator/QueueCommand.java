/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.Command;

public class QueueCommand
        extends Command {
    public QueueCommand() {
        super("queue", new String[]{"priority, regular"});
    }

    @Override
    public void Method2159602(String[] arrstring) {
        if (arrstring.length == 1 || arrstring.length == 0) {
            QueueCommand.Method2159696("ayo, specify the type! (priority/regular)");
            return;
        }
        String string = "https://2bqueue.info/*";
        String string2 = arrstring[0];
        if (string2.equalsIgnoreCase("regular")) {
            try {
                URL uRL = new URL(string);
                URLConnection uRLConnection = uRL.openConnection();
                uRLConnection.connect();
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse((Reader) new InputStreamReader((InputStream) uRLConnection.getContent()));
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string3 = jsonObject.get("regular").getAsString();
                QueueCommand.Method2159696("Regular queue currently have: " + string3);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        } else if (string2.equalsIgnoreCase("priority")) {
            try {
                URL uRL = new URL(string);
                URLConnection uRLConnection = uRL.openConnection();
                uRLConnection.connect();
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse((Reader) new InputStreamReader((InputStream) uRLConnection.getContent()));
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string4 = jsonObject.get("prio").getAsString();
                QueueCommand.Method2159696("Priority queue currently have: " + string4);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

