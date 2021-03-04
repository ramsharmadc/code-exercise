package designpatterns.visitor;

public class AssignmentNode implements Node {

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitAssignment(this);
    }

    public void typeCheck() {
        System.out.println("AssignmentNode -> typeCheck()");
    }

    public void generateCode() {
        System.out.println("AssignmentNode -> generateCode()");
    }
}
