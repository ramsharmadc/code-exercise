package designpatterns.visitor;

public interface Equipment {

    void accept(EquipmentVisitor equipmentVisitor);

    Watt power();

    Currency netPrice();

    Currency discountPrice();
}
