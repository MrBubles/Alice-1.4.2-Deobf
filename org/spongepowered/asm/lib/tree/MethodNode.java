/*
 * Decompiled with CFR 0.150.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.IincInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.IntInsnNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.LocalVariableAnnotationNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.LookupSwitchInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MultiANewArrayInsnNode;
import org.spongepowered.asm.lib.tree.ParameterNode;
import org.spongepowered.asm.lib.tree.TableSwitchInsnNode;
import org.spongepowered.asm.lib.tree.TryCatchBlockNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;

public class MethodNode
extends MethodVisitor {
    public int access;
    public String name;
    public String desc;
    public String signature;
    public List<String> exceptions;
    public List<ParameterNode> parameters;
    public List<AnnotationNode> visibleAnnotations;
    public List<AnnotationNode> invisibleAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<Attribute> attrs;
    public Object annotationDefault;
    public List<AnnotationNode>[] visibleParameterAnnotations;
    public List<AnnotationNode>[] invisibleParameterAnnotations;
    public InsnList instructions;
    public List<TryCatchBlockNode> tryCatchBlocks;
    public int maxStack;
    public int maxLocals;
    public List<LocalVariableNode> localVariables;
    public List<LocalVariableAnnotationNode> visibleLocalVariableAnnotations;
    public List<LocalVariableAnnotationNode> invisibleLocalVariableAnnotations;
    private boolean visited;

    public MethodNode() {
        this(327680);
        if (this.getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int api) {
        super(api);
        this.instructions = new InsnList();
    }

    public MethodNode(int access, String name, String desc, String signature, String[] exceptions) {
        this(327680, access, name, desc, signature, exceptions);
        if (this.getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int api, int access, String name, String desc, String signature, String[] exceptions) {
        super(api);
        boolean isAbstract;
        this.access = access;
        this.name = name;
        this.desc = desc;
        this.signature = signature;
        this.exceptions = new ArrayList<String>(exceptions == null ? 0 : exceptions.length);
        boolean bl = isAbstract = (access & 0x400) != 0;
        if (!isAbstract) {
            this.localVariables = new ArrayList<LocalVariableNode>(5);
        }
        this.tryCatchBlocks = new ArrayList<TryCatchBlockNode>();
        if (exceptions != null) {
            this.exceptions.addAll(Arrays.asList(exceptions));
        }
        this.instructions = new InsnList();
    }

    public void visitParameter(String name, int access) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<ParameterNode>(5);
        }
        this.parameters.add(new ParameterNode(name, access));
    }

    public AnnotationVisitor visitAnnotationDefault() {
        return new AnnotationNode((List<Object>)new ArrayList<Object>(0){

            @Override
            public boolean add(Object o) {
                MethodNode.this.annotationDefault = o;
                return super.add(o);
            }
        });
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

    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        AnnotationNode an2 = new AnnotationNode(desc);
        if (visible) {
            if (this.visibleParameterAnnotations == null) {
                int params = Type.getArgumentTypes(this.desc).length;
                this.visibleParameterAnnotations = new List[params];
            }
            if (this.visibleParameterAnnotations[parameter] == null) {
                this.visibleParameterAnnotations[parameter] = new ArrayList<AnnotationNode>(1);
            }
            this.visibleParameterAnnotations[parameter].add(an2);
        } else {
            if (this.invisibleParameterAnnotations == null) {
                int params = Type.getArgumentTypes(this.desc).length;
                this.invisibleParameterAnnotations = new List[params];
            }
            if (this.invisibleParameterAnnotations[parameter] == null) {
                this.invisibleParameterAnnotations[parameter] = new ArrayList<AnnotationNode>(1);
            }
            this.invisibleParameterAnnotations[parameter].add(an2);
        }
        return an2;
    }

    public void visitAttribute(Attribute attr) {
        if (this.attrs == null) {
            this.attrs = new ArrayList<Attribute>(1);
        }
        this.attrs.add(attr);
    }

    public void visitCode() {
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        this.instructions.add(new FrameNode(type, nLocal, local == null ? null : this.getLabelNodes(local), nStack, stack == null ? null : this.getLabelNodes(stack)));
    }

    public void visitInsn(int opcode) {
        this.instructions.add(new InsnNode(opcode));
    }

    public void visitIntInsn(int opcode, int operand) {
        this.instructions.add(new IntInsnNode(opcode, operand));
    }

    public void visitVarInsn(int opcode, int var) {
        this.instructions.add(new VarInsnNode(opcode, var));
    }

    public void visitTypeInsn(int opcode, String type) {
        this.instructions.add(new TypeInsnNode(opcode, type));
    }

    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        this.instructions.add(new FieldInsnNode(opcode, owner, name, desc));
    }

    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        if (this.api >= 327680) {
            super.visitMethodInsn(opcode, owner, name, desc);
            return;
        }
        this.instructions.add(new MethodInsnNode(opcode, owner, name, desc));
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (this.api < 327680) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
            return;
        }
        this.instructions.add(new MethodInsnNode(opcode, owner, name, desc, itf));
    }

    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object ... bsmArgs) {
        this.instructions.add(new InvokeDynamicInsnNode(name, desc, bsm, bsmArgs));
    }

    public void visitJumpInsn(int opcode, Label label) {
        this.instructions.add(new JumpInsnNode(opcode, this.getLabelNode(label)));
    }

    public void visitLabel(Label label) {
        this.instructions.add(this.getLabelNode(label));
    }

    public void visitLdcInsn(Object cst) {
        this.instructions.add(new LdcInsnNode(cst));
    }

    public void visitIincInsn(int var, int increment) {
        this.instructions.add(new IincInsnNode(var, increment));
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        this.instructions.add(new TableSwitchInsnNode(min, max, this.getLabelNode(dflt), this.getLabelNodes(labels)));
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        this.instructions.add(new LookupSwitchInsnNode(this.getLabelNode(dflt), keys, this.getLabelNodes(labels)));
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.instructions.add(new MultiANewArrayInsnNode(desc, dims));
    }

    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AbstractInsnNode insn = this.instructions.getLast();
        while (insn.getOpcode() == -1) {
            insn = insn.getPrevious();
        }
        TypeAnnotationNode an2 = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (insn.visibleTypeAnnotations == null) {
                insn.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            insn.visibleTypeAnnotations.add(an2);
        } else {
            if (insn.invisibleTypeAnnotations == null) {
                insn.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            insn.invisibleTypeAnnotations.add(an2);
        }
        return an2;
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        this.tryCatchBlocks.add(new TryCatchBlockNode(this.getLabelNode(start), this.getLabelNode(end), this.getLabelNode(handler), type));
    }

    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        TryCatchBlockNode tcb = this.tryCatchBlocks.get((typeRef & 0xFFFF00) >> 8);
        TypeAnnotationNode an2 = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (tcb.visibleTypeAnnotations == null) {
                tcb.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            tcb.visibleTypeAnnotations.add(an2);
        } else {
            if (tcb.invisibleTypeAnnotations == null) {
                tcb.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            tcb.invisibleTypeAnnotations.add(an2);
        }
        return an2;
    }

    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        this.localVariables.add(new LocalVariableNode(name, desc, signature, this.getLabelNode(start), this.getLabelNode(end), index));
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        LocalVariableAnnotationNode an2 = new LocalVariableAnnotationNode(typeRef, typePath, this.getLabelNodes(start), this.getLabelNodes(end), index, desc);
        if (visible) {
            if (this.visibleLocalVariableAnnotations == null) {
                this.visibleLocalVariableAnnotations = new ArrayList<LocalVariableAnnotationNode>(1);
            }
            this.visibleLocalVariableAnnotations.add(an2);
        } else {
            if (this.invisibleLocalVariableAnnotations == null) {
                this.invisibleLocalVariableAnnotations = new ArrayList<LocalVariableAnnotationNode>(1);
            }
            this.invisibleLocalVariableAnnotations.add(an2);
        }
        return an2;
    }

    public void visitLineNumber(int line, Label start) {
        this.instructions.add(new LineNumberNode(line, this.getLabelNode(start)));
    }

    public void visitMaxs(int maxStack, int maxLocals) {
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
    }

    public void visitEnd() {
    }

    protected LabelNode getLabelNode(Label l) {
        if (!(l.info instanceof LabelNode)) {
            l.info = new LabelNode();
        }
        return (LabelNode)l.info;
    }

    private LabelNode[] getLabelNodes(Label[] l) {
        LabelNode[] nodes = new LabelNode[l.length];
        for (int i2 = 0; i2 < l.length; ++i2) {
            nodes[i2] = this.getLabelNode(l[i2]);
        }
        return nodes;
    }

    private Object[] getLabelNodes(Object[] objs) {
        Object[] nodes = new Object[objs.length];
        for (int i2 = 0; i2 < objs.length; ++i2) {
            Object o = objs[i2];
            if (o instanceof Label) {
                o = this.getLabelNode((Label)o);
            }
            nodes[i2] = o;
        }
        return nodes;
    }

    public void check(int api) {
        if (api == 262144) {
            int i2;
            if (this.visibleTypeAnnotations != null && this.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (this.invisibleTypeAnnotations != null && this.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            int n2 = this.tryCatchBlocks == null ? 0 : this.tryCatchBlocks.size();
            for (i2 = 0; i2 < n2; ++i2) {
                TryCatchBlockNode tcb = this.tryCatchBlocks.get(i2);
                if (tcb.visibleTypeAnnotations != null && tcb.visibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (tcb.invisibleTypeAnnotations == null || tcb.invisibleTypeAnnotations.size() <= 0) continue;
                throw new RuntimeException();
            }
            for (i2 = 0; i2 < this.instructions.size(); ++i2) {
                boolean itf;
                AbstractInsnNode insn = this.instructions.get(i2);
                if (insn.visibleTypeAnnotations != null && insn.visibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (insn.invisibleTypeAnnotations != null && insn.invisibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (!(insn instanceof MethodInsnNode) || (itf = ((MethodInsnNode)insn).itf) == (insn.opcode == 185)) continue;
                throw new RuntimeException();
            }
            if (this.visibleLocalVariableAnnotations != null && this.visibleLocalVariableAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (this.invisibleLocalVariableAnnotations != null && this.invisibleLocalVariableAnnotations.size() > 0) {
                throw new RuntimeException();
            }
        }
    }

    public void accept(ClassVisitor cv2) {
        String[] exceptions = new String[this.exceptions.size()];
        this.exceptions.toArray(exceptions);
        MethodVisitor mv = cv2.visitMethod(this.access, this.name, this.desc, this.signature, exceptions);
        if (mv != null) {
            this.accept(mv);
        }
    }

    public void accept(MethodVisitor mv) {
        AnnotationNode an2;
        int j;
        List<AnnotationNode> l;
        AnnotationNode an3;
        int i2;
        int n2 = this.parameters == null ? 0 : this.parameters.size();
        for (i2 = 0; i2 < n2; ++i2) {
            ParameterNode parameter = this.parameters.get(i2);
            mv.visitParameter(parameter.name, parameter.access);
        }
        if (this.annotationDefault != null) {
            AnnotationVisitor av = mv.visitAnnotationDefault();
            AnnotationNode.accept(av, null, this.annotationDefault);
            if (av != null) {
                av.visitEnd();
            }
        }
        n2 = this.visibleAnnotations == null ? 0 : this.visibleAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an3 = this.visibleAnnotations.get(i2);
            an3.accept(mv.visitAnnotation(an3.desc, true));
        }
        n2 = this.invisibleAnnotations == null ? 0 : this.invisibleAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an3 = this.invisibleAnnotations.get(i2);
            an3.accept(mv.visitAnnotation(an3.desc, false));
        }
        n2 = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an3 = this.visibleTypeAnnotations.get(i2);
            an3.accept(mv.visitTypeAnnotation(((TypeAnnotationNode)an3).typeRef, ((TypeAnnotationNode)an3).typePath, ((TypeAnnotationNode)an3).desc, true));
        }
        n2 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an3 = this.invisibleTypeAnnotations.get(i2);
            an3.accept(mv.visitTypeAnnotation(((TypeAnnotationNode)an3).typeRef, ((TypeAnnotationNode)an3).typePath, ((TypeAnnotationNode)an3).desc, false));
        }
        n2 = this.visibleParameterAnnotations == null ? 0 : this.visibleParameterAnnotations.length;
        for (i2 = 0; i2 < n2; ++i2) {
            l = this.visibleParameterAnnotations[i2];
            if (l == null) continue;
            for (j = 0; j < l.size(); ++j) {
                an2 = l.get(j);
                an2.accept(mv.visitParameterAnnotation(i2, an2.desc, true));
            }
        }
        n2 = this.invisibleParameterAnnotations == null ? 0 : this.invisibleParameterAnnotations.length;
        for (i2 = 0; i2 < n2; ++i2) {
            l = this.invisibleParameterAnnotations[i2];
            if (l == null) continue;
            for (j = 0; j < l.size(); ++j) {
                an2 = l.get(j);
                an2.accept(mv.visitParameterAnnotation(i2, an2.desc, false));
            }
        }
        if (this.visited) {
            this.instructions.resetLabels();
        }
        n2 = this.attrs == null ? 0 : this.attrs.size();
        for (i2 = 0; i2 < n2; ++i2) {
            mv.visitAttribute(this.attrs.get(i2));
        }
        if (this.instructions.size() > 0) {
            mv.visitCode();
            n2 = this.tryCatchBlocks == null ? 0 : this.tryCatchBlocks.size();
            for (i2 = 0; i2 < n2; ++i2) {
                this.tryCatchBlocks.get(i2).updateIndex(i2);
                this.tryCatchBlocks.get(i2).accept(mv);
            }
            this.instructions.accept(mv);
            n2 = this.localVariables == null ? 0 : this.localVariables.size();
            for (i2 = 0; i2 < n2; ++i2) {
                this.localVariables.get(i2).accept(mv);
            }
            n2 = this.visibleLocalVariableAnnotations == null ? 0 : this.visibleLocalVariableAnnotations.size();
            for (i2 = 0; i2 < n2; ++i2) {
                this.visibleLocalVariableAnnotations.get(i2).accept(mv, true);
            }
            n2 = this.invisibleLocalVariableAnnotations == null ? 0 : this.invisibleLocalVariableAnnotations.size();
            for (i2 = 0; i2 < n2; ++i2) {
                this.invisibleLocalVariableAnnotations.get(i2).accept(mv, false);
            }
            mv.visitMaxs(this.maxStack, this.maxLocals);
            this.visited = true;
        }
        mv.visitEnd();
    }
}

