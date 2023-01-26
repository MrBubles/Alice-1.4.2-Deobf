/*
 * Decompiled with CFR 0.150.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractInsnNode {
    public static final int INSN = 0;
    public static final int INT_INSN = 1;
    public static final int VAR_INSN = 2;
    public static final int TYPE_INSN = 3;
    public static final int FIELD_INSN = 4;
    public static final int METHOD_INSN = 5;
    public static final int INVOKE_DYNAMIC_INSN = 6;
    public static final int JUMP_INSN = 7;
    public static final int LABEL = 8;
    public static final int LDC_INSN = 9;
    public static final int IINC_INSN = 10;
    public static final int TABLESWITCH_INSN = 11;
    public static final int LOOKUPSWITCH_INSN = 12;
    public static final int MULTIANEWARRAY_INSN = 13;
    public static final int FRAME = 14;
    public static final int LINE = 15;
    protected int opcode;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    AbstractInsnNode prev;
    AbstractInsnNode next;
    int index;

    protected AbstractInsnNode(int opcode) {
        this.opcode = opcode;
        this.index = -1;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public abstract int getType();

    public AbstractInsnNode getPrevious() {
        return this.prev;
    }

    public AbstractInsnNode getNext() {
        return this.next;
    }

    public abstract void accept(MethodVisitor var1);

    protected final void acceptAnnotations(MethodVisitor mv) {
        TypeAnnotationNode an2;
        int i2;
        int n2 = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.visibleTypeAnnotations.get(i2);
            an2.accept(mv.visitInsnAnnotation(an2.typeRef, an2.typePath, an2.desc, true));
        }
        n2 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.invisibleTypeAnnotations.get(i2);
            an2.accept(mv.visitInsnAnnotation(an2.typeRef, an2.typePath, an2.desc, false));
        }
    }

    public abstract AbstractInsnNode clone(Map<LabelNode, LabelNode> var1);

    static LabelNode clone(LabelNode label, Map<LabelNode, LabelNode> map) {
        return map.get(label);
    }

    static LabelNode[] clone(List<LabelNode> labels, Map<LabelNode, LabelNode> map) {
        LabelNode[] clones = new LabelNode[labels.size()];
        for (int i2 = 0; i2 < clones.length; ++i2) {
            clones[i2] = map.get(labels.get(i2));
        }
        return clones;
    }

    protected final AbstractInsnNode cloneAnnotations(AbstractInsnNode insn) {
        TypeAnnotationNode ann;
        TypeAnnotationNode src;
        int i2;
        if (insn.visibleTypeAnnotations != null) {
            this.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>();
            for (i2 = 0; i2 < insn.visibleTypeAnnotations.size(); ++i2) {
                src = insn.visibleTypeAnnotations.get(i2);
                ann = new TypeAnnotationNode(src.typeRef, src.typePath, src.desc);
                src.accept(ann);
                this.visibleTypeAnnotations.add(ann);
            }
        }
        if (insn.invisibleTypeAnnotations != null) {
            this.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>();
            for (i2 = 0; i2 < insn.invisibleTypeAnnotations.size(); ++i2) {
                src = insn.invisibleTypeAnnotations.get(i2);
                ann = new TypeAnnotationNode(src.typeRef, src.typePath, src.desc);
                src.accept(ann);
                this.invisibleTypeAnnotations.add(ann);
            }
        }
        return this;
    }
}

