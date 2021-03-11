package designpatterns.factorypattern;

public interface Pizza<T> {

    void bake();

    void box();

    void cut();

    Pizza<T> prepare();
}
