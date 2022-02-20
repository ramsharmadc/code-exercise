package designpatterns.visitor;

public class TestNodeVisitor {

    public static void main(String[] args) {
        Node n1 = new AssignmentNode();
        Node n2 = new VariableRefNode();

        NodeVisitor nv1 = new CodeGeneratingVisitor();
        NodeVisitor nv2 = new TypeCheckingVisitor();

        nv1.visitAssignment((AssignmentNode) n1);
        nv1.visitVariableReference((VariableRefNode) n2);

        nv2.visitAssignment((AssignmentNode) n1);
        nv2.visitVariableReference((VariableRefNode) n2);

    }
}
