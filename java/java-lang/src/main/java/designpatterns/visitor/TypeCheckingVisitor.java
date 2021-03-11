package designpatterns.visitor;

public class TypeCheckingVisitor implements NodeVisitor {

    @Override
    public void visitAssignment(AssignmentNode assignmentNode) {
        System.out.println("TypeCheckingVisitor -> " + assignmentNode);
        assignmentNode.typeCheck();
    }

    @Override
    public void visitVariableReference(VariableRefNode variableRefNode) {
        System.out.println("TypeCheckingVisitor -> " + variableRefNode);
        variableRefNode.typeCheck();
    }
}
