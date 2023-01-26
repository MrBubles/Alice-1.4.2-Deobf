/*
 * Decompiled with CFR 0.150.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AnnotationNode
extends AnnotationVisitor {
    public String desc;
    public List<Object> values;

    public AnnotationNode(String desc) {
        this(327680, desc);
        if (this.getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationNode(int api, String desc) {
        super(api);
        this.desc = desc;
    }

    AnnotationNode(List<Object> values) {
        super(327680);
        this.values = values;
    }

    @Override
    public void visit(String name, Object value) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        if (value instanceof byte[]) {
            byte[] v = (byte[])value;
            ArrayList<Byte> l2 = new ArrayList<Byte>(v.length);
            for (byte b : v) {
                l2.add(b);
            }
            this.values.add(l2);
        } else if (value instanceof boolean[]) {
            boolean[] v = (boolean[])value;
            ArrayList<Boolean> l3 = new ArrayList<Boolean>(v.length);
            for (boolean b : v) {
                l3.add(b);
            }
            this.values.add(l3);
        } else if (value instanceof short[]) {
            short[] v = (short[])value;
            ArrayList<Short> l4 = new ArrayList<Short>(v.length);
            for (short s : v) {
                l4.add(s);
            }
            this.values.add(l4);
        } else if (value instanceof char[]) {
            char[] v = (char[])value;
            ArrayList<Character> l5 = new ArrayList<Character>(v.length);
            for (char c : v) {
                l5.add(Character.valueOf(c));
            }
            this.values.add(l5);
        } else if (value instanceof int[]) {
            int[] v = (int[])value;
            ArrayList<Integer> l6 = new ArrayList<Integer>(v.length);
            for (int i2 : v) {
                l6.add(i2);
            }
            this.values.add(l6);
        } else if (value instanceof long[]) {
            long[] v = (long[])value;
            ArrayList<Long> l7 = new ArrayList<Long>(v.length);
            for (long lng : v) {
                l7.add(lng);
            }
            this.values.add(l7);
        } else if (value instanceof float[]) {
            float[] v = (float[])value;
            ArrayList<Float> l8 = new ArrayList<Float>(v.length);
            for (float f : v) {
                l8.add(Float.valueOf(f));
            }
            this.values.add(l8);
        } else if (value instanceof double[]) {
            double[] v = (double[])value;
            ArrayList<Double> l9 = new ArrayList<Double>(v.length);
            for (double d : v) {
                l9.add(d);
            }
            this.values.add(l9);
        } else {
            this.values.add(value);
        }
    }

    @Override
    public void visitEnum(String name, String desc, String value) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        this.values.add(new String[]{desc, value});
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        AnnotationNode annotation = new AnnotationNode(desc);
        this.values.add(annotation);
        return annotation;
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        ArrayList<Object> array = new ArrayList<Object>();
        this.values.add(array);
        return new AnnotationNode(array);
    }

    @Override
    public void visitEnd() {
    }

    public void check(int api) {
    }

    public void accept(AnnotationVisitor av) {
        if (av != null) {
            if (this.values != null) {
                for (int i2 = 0; i2 < this.values.size(); i2 += 2) {
                    String name = (String)this.values.get(i2);
                    Object value = this.values.get(i2 + 1);
                    AnnotationNode.accept(av, name, value);
                }
            }
            av.visitEnd();
        }
    }

    static void accept(AnnotationVisitor av, String name, Object value) {
        if (av != null) {
            if (value instanceof String[]) {
                String[] typeconst = (String[])value;
                av.visitEnum(name, typeconst[0], typeconst[1]);
            } else if (value instanceof AnnotationNode) {
                AnnotationNode an2 = (AnnotationNode)value;
                an2.accept(av.visitAnnotation(name, an2.desc));
            } else if (value instanceof List) {
                AnnotationVisitor v = av.visitArray(name);
                if (v != null) {
                    List array = (List)value;
                    for (int j = 0; j < array.size(); ++j) {
                        AnnotationNode.accept(v, null, array.get(j));
                    }
                    v.visitEnd();
                }
            } else {
                av.visit(name, value);
            }
        }
    }
}

