/*
 * Decompiled with CFR 0.150.
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import me.snow.aclient.core.setting.superblaubeere27obfuscator.AliceMain;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Feature;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.Module;

public class FileManager
        extends Feature {
    private final Path Field4491 = this.Method2150156(this.Method2150154(), "Alice");
    private final Path Field4492 = this.Method2150156(this.Field4491, "notebot");

    public FileManager() {
        this.Method2150156(this.Field4491, "util");
        for (Module.IIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll : AliceMain.Field756.Method2150190()) {
            Path path = this.Method2150156(this.Field4491, "config");
            this.Method2150156(path, iIllIllIIllIlIIlIlIIlllIllIIllIIllIlIIllIIIllIIIllIIllIIIlIllIIlIIlllIllIIlIllIllIIlIIlIlIIIlIllIIllIlllIllIIIllIIlIIlllIllIIlIIIlIIllIIllIIlIlIIlIllIIlllIlIIlllIIlIlIIlIIlIlllIIlIIIlIIllIllIlllIIlllIIIlIIllIIIlll.IIllIIlIllIIlIlllIIllIIIllIIIllIlIIlIIIllIIlllIIllIllIlIIlllIIlllIlIlIIlllIIlllIIIllIIllIIlIIIllIIIlllIIIllIllIIIlllIIllIllIlllIIIllIIIllIIlIlIIllIIlIIIlllIIllIIllIllIlllIIIlIIlIIIlIIllIlIIllIlllIlIIIllIIIlIIIllIIIlIlIllIIllIlIll());
        }
    }

    public static void Method2150149(String string, String string2) {
        try {
            Path path = Paths.get(string2, new String[0]);
            Files.write(path, Collections.singletonList(string), StandardCharsets.UTF_8, Files.exists(path, new LinkOption[0]) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (IOException iOException) {
            System.out.println("WARNING: Unable to write file: " + string2);
        }
    }

    public static List<String> Method2150140(String string) {
        try {
            Path path = Paths.get(string, new String[0]);
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException iOException) {
            System.out.println("WARNING: Unable to read file, creating new file: " + string);
            FileManager.Method2150149("", string);
            return Collections.emptyList();
        }
    }

    private static String[] Method2150165(int n2) {
        return new String[n2];
    }

    private String[] Method2150151(String string) {
        return string.split(":?\\\\\\\\|\\/");
    }

    private Stream<String> Method2150152(String... arrstring) {
        return Arrays.stream(arrstring).map(this::Method2150151).flatMap(Arrays::stream);
    }

    private Path Method2150153(Path path, String... arrstring) {
        return Paths.get(path.toString(), arrstring);
    }

    private Path Method2150154() {
        return Paths.get("", new String[0]);
    }

    private void Method2150155(Path path) {
        try {
            if (!Files.isDirectory(path, new LinkOption[0])) {
                if (Files.exists(path, new LinkOption[0])) {
                    Files.delete(path);
                }
                Files.createDirectories(path, new FileAttribute[0]);
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private Path Method2150156(Path path, String... arrstring) {
        if (arrstring.length < 1) {
            return path;
        }
        Path path2 = this.Method2150153(path, arrstring);
        this.Method2150155(path2);
        return path2;
    }

    public Path Method2150157() {
        return this.Field4491;
    }

    public Path Method2150158(String... arrstring) {
        String[] arrstring2 = (String[]) this.Method2150152(arrstring).toArray(FileManager::Method2150165);
        if (arrstring2.length < 1) {
            throw new IllegalArgumentException("missing path");
        }
        return this.Method2150153(this.Method2150157(), arrstring2);
    }

    public Path Method2150159(String... arrstring) {
        Path path = this.Method2150158(arrstring);
        this.Method2150155(path.getParent());
        return path;
    }

    public Path Method2150150() {
        return this.Method2150157().resolve("config");
    }

    public Path Method2150161() {
        return this.Method2150157().resolve("cache");
    }

    public Path Method2150162() {
        return this.Method2150157().resolve("notebot");
    }

    public Path Method2150163(String... arrstring) {
        return this.Method2150156(this.Method2150157(), this.Method2150152(arrstring).collect(Collectors.joining(File.separator)));
    }

    public Path Method2150164(String... arrstring) {
        return this.Method2150156(this.Method2150150(), this.Method2150152(arrstring).collect(Collectors.joining(File.separator)));
    }
}

