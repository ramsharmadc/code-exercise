package designpatterns.visitor;

public class FloppyDisk implements Equipment {
    @Override
    public void accept(EquipmentVisitor equipmentVisitor) {
        equipmentVisitor.visitFloppyDisk(this);
    }

    @Override
    public Watt power() {
        return new Watt();
    }

    @Override
    public Currency netPrice() {
        return new Currency();
    }

    @Override
    public Currency discountPrice() {
        return new Currency();
    }
}
