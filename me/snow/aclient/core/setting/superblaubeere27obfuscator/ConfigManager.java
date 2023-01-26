/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.EnumConverter;
import me.snow.aclient.core.setting.Setting;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.FriendManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.ModuleManager;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Util;

public class ConfigManager
        implements Util {
    public ArrayList<Feature> Field4361 = new ArrayList();
    public String Field4362 = "Alice/config/";
    public boolean Field4363;
    public boolean Field4364;

    public static void Method2150116(Feature feature, Setting setting, JsonElement jsonElement) {
        switch (setting.getType()) {
            case "Boolean": {
                setting.setValue(jsonElement.getAsBoolean());
                break;
            }
            case "Double": {
                setting.setValue(jsonElement.getAsDouble());
                break;
            }
            case "Float": {
                setting.setValue(Float.valueOf(jsonElement.getAsFloat()));
                break;
            }
            case "Integer": {
                setting.setValue(jsonElement.getAsInt());
                break;
            }
            case "String": {
                String string = jsonElement.getAsString();
                setting.setValue(string.replace("_", " "));
                break;
            }
            case "Bind": {
                setting.setValue(new Bind.BindConverter().doBackward(jsonElement));
                break;
            }
            case "Enum": {
                try {
                    EnumConverter enumConverter = new EnumConverter(((Enum) setting.getValue()).getClass());
                    Enum enum_ = enumConverter.doBackward(jsonElement);
                    setting.setValue(enum_ == null ? setting.getDefaultValue() : enum_);
                } catch (Exception exception) {
                }
                break;
            }
            default: {
                AliceMain.Field745.error("Unknown Setting type for: " + feature.Method2150361() + " : " + setting.getName());
            }
        }
    }

    private static void Method2150117(JsonObject jsonObject, Feature feature) {
        for (Map.Entry entry : jsonObject.entrySet()) {
            String string = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (feature instanceof FriendManager) {
                try {
                    AliceMain.Field765.Method2150176(new FriendManager.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll(jsonElement.getAsString(), UUID.fromString(string)));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                continue;
            }
            boolean bl = false;
            for (Setting setting : feature.Method2150362()) {
                if (!string.equals(setting.getName())) continue;
                try {
                    ConfigManager.Method2150116(feature, setting, jsonElement);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                bl = true;
            }
            if (!bl) continue;
        }
    }

    public void Method2150118(String string) {
        this.Field4363 = true;
        List list = Arrays.stream((Object[]) Objects.requireNonNull(new File("Alice").listFiles())).filter(File::isDirectory).collect(Collectors.toList());
        this.Field4362 = list.contains(new File("Alice/" + string + "/")) ? "Alice/" + string + "/" : "Alice/config/";
        AliceMain.Field765.Method2150172();
        for (Feature feature : this.Field4361) {
            try {
                this.Method2150125(feature);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        this.Method2150110();
        this.Field4363 = false;
    }

    public void Method2150119(String string) {
        this.Field4364 = true;
        this.Field4362 = "Alice/" + string + "/";
        File file = new File(this.Field4362);
        if (!file.exists()) {
            file.mkdir();
        }
        AliceMain.Field765.Method2150173();
        for (Feature feature : this.Field4361) {
            try {
                this.Method2150123(feature);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        this.Method2150110();
        this.Field4364 = false;
    }

    public void Method2150110() {
        File file = new File("Alice/currentconfig.txt");
        try {
            if (file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                String string = this.Field4362.replaceAll("/", "");
                fileWriter.write(string.replaceAll("Alice", ""));
                fileWriter.close();
            } else {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                String string = this.Field4362.replaceAll("/", "");
                fileWriter.write(string.replaceAll("Alice", ""));
                fileWriter.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String Method2150121() {
        File file = new File("Alice/currentconfig.txt");
        String string = "config";
        try {
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    string = scanner.nextLine();
                }
                scanner.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return string;
    }

    public void Method2150122(boolean bl, String string) {
        for (Feature feature : this.Field4361) {
            feature.Method2150369();
        }
        if (bl) {
            this.Method2150119(string);
        }
    }

    public void Method2150123(Feature feature) throws IOException {
        Path path;
        new JsonObject();
        File file = new File(this.Field4362 + this.Method2150128(feature));
        if (!file.exists()) {
            file.mkdir();
        }
        if (!Files.exists(path = Paths.get(this.Field4362 + this.Method2150128(feature) + feature.Method2150361() + ".json", new String[0]), new LinkOption[0])) {
            Files.createFile(path, new FileAttribute[0]);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson((JsonElement) this.Method2150127(feature));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, new OpenOption[0])));
        bufferedWriter.write(string);
        bufferedWriter.close();
    }

    public void Method2150124() {
        this.Field4361.addAll(ModuleManager.Field3969);
        this.Field4361.add(AliceMain.Field765);
        String string = this.Method2150121();
        this.Method2150118(string);
        AliceMain.Field745.info("Config loaded.");
    }

    private void Method2150125(Feature feature) throws IOException {
        String string = this.Field4362 + this.Method2150128(feature) + feature.Method2150361() + ".json";
        Path path = Paths.get(string, new String[0]);
        if (!Files.exists(path, new LinkOption[0])) {
            return;
        }
        this.Method2150126(path, feature);
    }

    private void Method2150126(Path path, Feature feature) throws IOException {
        InputStream inputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            ConfigManager.Method2150117(new JsonParser().parse((Reader) new InputStreamReader(inputStream)).getAsJsonObject(), feature);
        } catch (IllegalStateException illegalStateException) {
            AliceMain.Field745.error("Bad Config File for: " + feature.Method2150361() + ". Resetting...");
            ConfigManager.Method2150117(new JsonObject(), feature);
        }
        inputStream.close();
    }

    public JsonObject Method2150127(Feature feature) {
        JsonObject jsonObject = new JsonObject();
        JsonParser jsonParser = new JsonParser();
        for (Setting setting : feature.Method2150362()) {
            Object object;
            if (setting.isEnumSetting()) {
                object = new EnumConverter(((Enum) setting.getValue()).getClass());
                jsonObject.add(setting.getName(), ((EnumConverter) ((Object) object)).doForward((Enum) setting.getValue()));
                continue;
            }
            if (setting.isStringSetting()) {
                object = (String) setting.getValue();
                setting.setValue(((String) object).replace(" ", "_"));
            }
            try {
                jsonObject.add(setting.getName(), jsonParser.parse(setting.getValueAsString()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return jsonObject;
    }

    public String Method2150128(Feature feature) {
        String string = "";
        if (feature instanceof Module) {
            string = string + ((Module) feature).Method2150398().IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll() + "/";
        }
        return string;
    }
}

