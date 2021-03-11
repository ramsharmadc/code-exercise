package designpatterns.visitor;

public interface EquipmentVisitor {

    void visitFloppyDisk(FloppyDisk floppyDisk);

    void visitChassis(Chassis chassis);

    void visitBus(Bus bus);

    void visitCard(Card card);
}
