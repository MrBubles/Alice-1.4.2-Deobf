/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL20
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.lwjgl.opengl.GL20;

public class GLSLSandboxShader {
    private final int Field3648;
    private final int Field3649;
    private final int Field3650;
    private final int Field3651;

    public GLSLSandboxShader(String string) throws IOException {
        int n2 = GL20.glCreateProgram();
        GL20.glAttachShader((int) n2, (int) this.Method2164189("/shaders/passthrough.vsh", GLSLSandboxShader.class.getResourceAsStream("/shaders/passthrough.vsh"), 35633));
        GL20.glAttachShader((int) n2, (int) this.Method2164189(string, GLSLSandboxShader.class.getResourceAsStream(string), 35632));
        GL20.glLinkProgram((int) n2);
        int n3 = GL20.glGetProgrami((int) n2, (int) 35714);
        if (n3 == 0) {
            System.err.println(GL20.glGetProgramInfoLog((int) n2, (int) GL20.glGetProgrami((int) n2, (int) 35716)));
            throw new IllegalStateException("Shader failed to link");
        }
        this.Field3648 = n2;
        GL20.glUseProgram((int) n2);
        this.Field3649 = GL20.glGetUniformLocation((int) n2, (CharSequence) "time");
        this.Field3650 = GL20.glGetUniformLocation((int) n2, (CharSequence) "mouse");
        this.Field3651 = GL20.glGetUniformLocation((int) n2, (CharSequence) "resolution");
        GL20.glUseProgram((int) 0);
    }

    public void Method2164188(int n2, int n3, float f, float f2, float f3) {
        GL20.glUseProgram((int) this.Field3648);
        GL20.glUniform2f((int) this.Field3651, (float) n2, (float) n3);
        GL20.glUniform2f((int) this.Field3650, (float) (f / (float) n2), (float) (1.0f - f2 / (float) n3));
        GL20.glUniform1f((int) this.Field3649, (float) f3);
    }

    private int Method2164189(String string, InputStream inputStream, int n2) throws IOException {
        int n3 = GL20.glCreateShader((int) n2);
        GL20.glShaderSource((int) n3, (CharSequence) this.Method2164180(inputStream));
        GL20.glCompileShader((int) n3);
        int n4 = GL20.glGetShaderi((int) n3, (int) 35713);
        if (n4 == 0) {
            System.err.println(GL20.glGetShaderInfoLog((int) n3, (int) GL20.glGetShaderi((int) n3, (int) 35716)));
            System.err.println("Caused by " + string);
            throw new IllegalStateException("Failed to compile shader: " + string);
        }
        return n3;
    }

    private String Method2164180(InputStream inputStream) throws IOException {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[512];
        while ((n2 = inputStream.read(arrby, 0, arrby.length)) != -1) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }
}

