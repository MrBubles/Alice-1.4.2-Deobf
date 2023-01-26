/*
 * Decompiled with CFR 0.150.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

public class FieldNode
extends FieldVisitor {
    public int access;
    public String name;
    public String desc;
    public String signature;
    public Object value;
    public List<AnnotationNode> visibleAnnotations;
    public List<AnnotationNode> invisibleAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<Attribute> attrs;

    public FieldNode(int access, String name, String desc, String signature, Object value) {
        this(327680, access, name, desc, signature, value);
        if (this.getClass() != FieldNode.class) {
            throw new IllegalStateException();
        }
    }

    public FieldNode(int api, int access, String name, String desc, String signature, Object value) {
        super(api);
        this.access = access;
        this.name = name;
        this.desc = desc;
        this.signature = signature;
        this.value = value;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationNode an2 = new AnnotationNode(desc);
        if (visible) {
            if (this.visibleAnnotations == null) {
                this.visibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            this.visibleAnnotations.add(an2);
        } else {
            if (this.invisibleAnnotations == null) {
                this.invisibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            this.invisibleAnnotations.add(an2);
        }
        return an2;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        TypeAnnotationNode an2 = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (this.visibleTypeAnnotations == null) {
                this.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            this.visibleTypeAnnotations.add(an2);
        } else {
            if (this.invisibleTypeAnnotations == null) {
                this.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            this.invisibleTypeAnnotations.add(an2);
        }
        return an2;
    }

    public void visitAttribute(Attribute attr) {
        if (this.attrs == null) {
            this.attrs = new ArrayList<Attribute>(1);
        }
        this.attrs.add(attr);
    }

    public void visitEnd() {
    }

    public void check(int api) {
        if (api == 262144) {
            if (this.visibleTypeAnnotations != null && this.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (this.invisibleTypeAnnotations != null && this.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
        }
    }

    public void accept(ClassVisitor cv2) {
        AnnotationNode an2;
        int i2;
        FieldVisitor fv = cv2.visitField(this.access, this.name, this.desc, this.signature, this.value);
        if (fv == null) {
            return;
        }
        int n2 = this.visibleAnnotations == null ? 0 : this.visibleAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.visibleAnnotations.get(i2);
            an2.accept(fv.visitAnnotation(an2.desc, true));
        }
        n2 = this.invisibleAnnotations == null ? 0 : this.invisibleAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.invisibleAnnotations.get(i2);
            an2.accept(fv.visitAnnotation(an2.desc, false));
        }
        n2 = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.visibleTypeAnnotations.get(i2);
            an2.accept(fv.visitTypeAnnotation(((TypeAnnotationNode)an2).typeRef, ((TypeAnnotationNode)an2).typePath, ((TypeAnnotationNode)an2).desc, true));
        }
        n2 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.invisibleTypeAnnotations.get(i2);
            an2.accept(fv.visitTypeAnnotation(((TypeAnnotationNode)an2).typeRef, ((TypeAnnotationNode)an2).typePath, ((TypeAnnotationNode)an2).desc, false));
        }
        n2 = this.attrs == null ? 0 : this.attrs.size();
        for (i2 = 0; i2 < n2; ++i2) {
            fv.visitAttribute(this.attrs.get(i2));
        }
        fv.visitEnd();
    }
}

