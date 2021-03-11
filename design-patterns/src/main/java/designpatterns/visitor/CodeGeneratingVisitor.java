package designpatterns.visitor;

public class CodeGeneratingVisitor implements NodeVisitor {
    @Override
    public void visitAssignment(AssignmentNode assignmentNode) {
        System.out.println("CodeGeneratingVisitor -> " + assignmentNode);
        assignmentNode.generateCode();
    }

    @Override
    public void visitVariableReference(VariableRefNode variableRefNode) {
        System.out.println("CodeGeneratingVisitor -> " + variableRefNode);
        variableRefNode.generateCode();
    }
}
