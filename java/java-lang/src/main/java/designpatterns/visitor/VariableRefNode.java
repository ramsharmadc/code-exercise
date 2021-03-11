package designpatterns.visitor;

public class VariableRefNode implements Node {

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitVariableReference(this);
    }

    public void typeCheck() {
        System.out.println("VariableRefNode -> typeCheck()");
    }

    public void generateCode() {
        System.out.println("VariableRefNode -> generateCode()");
    }
}
