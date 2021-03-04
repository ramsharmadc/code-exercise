package designpatterns.visitor;

public interface Node {

    void accept(NodeVisitor nodeVisitor);
}
