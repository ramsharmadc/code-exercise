package designpatterns.visitor;

public interface NodeVisitor {

    void visitAssignment(AssignmentNode assignmentNode);

    void visitVariableReference(VariableRefNode variableRefNode);
}
