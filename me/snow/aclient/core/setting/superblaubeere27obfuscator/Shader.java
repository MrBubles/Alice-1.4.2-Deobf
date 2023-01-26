/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  org.apache.commons.io.IOUtils
 *  org.lwjgl.opengl.ARBShaderObjects
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package me.snow.aclient.core.setting.superblaubeere27obfuscator;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Shader {
    protected int Field1381;
    protected Map<String, Integer> Field1382;

    public Shader(String string) {
        int n2;
        int n3;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/assets/mario/shaders/vertex.vert");
            n3 = this.Method2164195(IOUtils.toString((InputStream) inputStream), 35633);
            IOUtils.closeQuietly((InputStream) inputStream);
            InputStream inputStream2 = this.getClass().getResourceAsStream("/assets/mario/shaders/fragment/" + string);
            n2 = this.Method2164195(IOUtils.toString((InputStream) inputStream2), 35632);
            IOUtils.closeQuietly((InputStream) inputStream2);
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        if (n3 == 0 || n2 == 0) {
            return;
        }
        this.Field1381 = ARBShaderObjects.glCreateProgramObjectARB();
        if (this.Field1381 == 0) {
            return;
        }
        ARBShaderObjects.glAttachObjectARB((int) this.Field1381, (int) n3);
        ARBShaderObjects.glAttachObjectARB((int) this.Field1381, (int) n2);
        ARBShaderObjects.glLinkProgramARB((int) this.Field1381);
        ARBShaderObjects.glValidateProgramARB((int) this.Field1381);
    }

    public void Method2164191(float f) {
        GL11.glPushMatrix();
        GL20.glUseProgram((int) this.Field1381);
        if (this.Field1382 == null) {
            this.Field1382 = new HashMap<String, Integer>();
            this.Method2164193();
        }
        this.Method2164194(f);
    }

    public void Method2164192() {
        GL20.glUseProgram((int) 0);
        GL11.glPopMatrix();
    }

    public void Method2164193() {
    }

    public void Method2164194(float f) {
    }

    private int Method2164195(String string, int n2) {
        int n3;
        block4:
        {
            n3 = 0;
            try {
                n3 = ARBShaderObjects.glCreateShaderObjectARB((int) n2);
                if (n3 != 0) break block4;
                return 0;
            } catch (Exception exception) {
                ARBShaderObjects.glDeleteObjectARB((int) n3);
                throw exception;
            }
        }
        ARBShaderObjects.glShaderSourceARB((int) n3, (CharSequence) string);
        ARBShaderObjects.glCompileShaderARB((int) n3);
        if (ARBShaderObjects.glGetObjectParameteriARB((int) n3, (int) 35713) == 0) {
            throw new RuntimeException("Error creating shader: " + this.Method2164196(n3));
        }
        return n3;
    }

    private String Method2164196(int n2) {
        return ARBShaderObjects.glGetInfoLogARB((int) n2, (int) ARBShaderObjects.glGetObjectParameteriARB((int) n2, (int) 35716));
    }

    public void Method2164197(String string, int n2) {
        this.Field1382.put(string, n2);
    }

    public void Method2164198(String string) {
        this.Method2164197(string, GL20.glGetUniformLocation((int) this.Field1381, (CharSequence) string));
    }

    public int Method2164199(String string) {
        return this.Field1382.get(string);
    }
}

