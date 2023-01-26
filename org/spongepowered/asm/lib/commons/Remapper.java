/*
 * Decompiled with CFR 0.150.
 */
package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.commons.SignatureRemapper;
import org.spongepowered.asm.lib.signature.SignatureReader;
import org.spongepowered.asm.lib.signature.SignatureVisitor;
import org.spongepowered.asm.lib.signature.SignatureWriter;

public abstract class Remapper {
    public String mapDesc(String desc) {
        Type t = Type.getType(desc);
        switch (t.getSort()) {
            case 9: {
                String s = this.mapDesc(t.getElementType().getDescriptor());
                for (int i2 = 0; i2 < t.getDimensions(); ++i2) {
                    s = '[' + s;
                }
                return s;
            }
            case 10: {
                String newType = this.map(t.getInternalName());
                if (newType == null) break;
                return 'L' + newType + ';';
            }
        }
        return desc;
    }

    private Type mapType(Type t) {
        switch (t.getSort()) {
            case 9: {
                String s = this.mapDesc(t.getElementType().getDescriptor());
                for (int i2 = 0; i2 < t.getDimensions(); ++i2) {
                    s = '[' + s;
                }
                return Type.getType(s);
            }
            case 10: {
                String s = this.map(t.getInternalName());
                return s != null ? Type.getObjectType(s) : t;
            }
            case 11: {
                return Type.getMethodType(this.mapMethodDesc(t.getDescriptor()));
            }
        }
        return t;
    }

    public String mapType(String type) {
        if (type == null) {
            return null;
        }
        return this.mapType(Type.getObjectType(type)).getInternalName();
    }

    public String[] mapTypes(String[] types) {
        String[] newTypes = null;
        boolean needMapping = false;
        for (int i2 = 0; i2 < types.length; ++i2) {
            String type = types[i2];
            String newType = this.map(type);
            if (newType != null && newTypes == null) {
                newTypes = new String[types.length];
                if (i2 > 0) {
                    System.arraycopy(types, 0, newTypes, 0, i2);
                }
                needMapping = true;
            }
            if (!needMapping) continue;
            newTypes[i2] = newType == null ? type : newType;
        }
        return needMapping ? newTypes : types;
    }

    public String mapMethodDesc(String desc) {
        if ("()V".equals(desc)) {
            return desc;
        }
        Type[] args = Type.getArgumentTypes(desc);
        StringBuilder sb = new StringBuilder("(");
        for (int i2 = 0; i2 < args.length; ++i2) {
            sb.append(this.mapDesc(args[i2].getDescriptor()));
        }
        Type returnType = Type.getReturnType(desc);
        if (returnType == Type.VOID_TYPE) {
            sb.append(")V");
            return sb.toString();
        }
        sb.append(')').append(this.mapDesc(returnType.getDescriptor()));
        return sb.toString();
    }

    public Object mapValue(Object value) {
        if (value instanceof Type) {
            return this.mapType((Type)value);
        }
        if (value instanceof Handle) {
            Handle h2 = (Handle)value;
            return new Handle(h2.getTag(), this.mapType(h2.getOwner()), this.mapMethodName(h2.getOwner(), h2.getName(), h2.getDesc()), this.mapMethodDesc(h2.getDesc()), h2.isInterface());
        }
        return value;
    }

    public String mapSignature(String signature, boolean typeSignature) {
        if (signature == null) {
            return null;
        }
        SignatureReader r = new SignatureReader(signature);
        SignatureWriter w2 = new SignatureWriter();
        SignatureVisitor a = this.createSignatureRemapper(w2);
        if (typeSignature) {
            r.acceptType(a);
        } else {
            r.accept(a);
        }
        return w2.toString();
    }

    @Deprecated
    protected SignatureVisitor createRemappingSignatureAdapter(SignatureVisitor v) {
        return new SignatureRemapper(v, this);
    }

    protected SignatureVisitor createSignatureRemapper(SignatureVisitor v) {
        return this.createRemappingSignatureAdapter(v);
    }

    public String mapMethodName(String owner, String name, String desc) {
        return name;
    }

    public String mapInvokeDynamicMethodName(String name, String desc) {
        return name;
    }

    public String mapFieldName(String owner, String name, String desc) {
        return name;
    }

    public String map(String typeName) {
        return typeName;
    }
}

