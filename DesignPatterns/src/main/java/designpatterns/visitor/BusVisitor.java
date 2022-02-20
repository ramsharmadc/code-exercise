package designpatterns.visitor;

public class BusVisitor implements EquipmentVisitor {

    @Override
    public void visitFloppyDisk(FloppyDisk floppyDisk) {
        System.out.println("BusVisitor.visitFloppyDisk");
    }

    @Override
    public void visitChassis(Chassis chassis) {
        System.out.println("BusVisitor.visitChassis");
    }

    @Override
    public void visitBus(Bus bus) {
        System.out.println("BusVisitor.visitBus");
    }

    @Override
    public void visitCard(Card card) {
        System.out.println("BusVisitor.visitCard");
    }
}
