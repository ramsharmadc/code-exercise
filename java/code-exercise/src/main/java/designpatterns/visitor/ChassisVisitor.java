package designpatterns.visitor;

public class ChassisVisitor implements EquipmentVisitor {

    @Override
    public void visitFloppyDisk(FloppyDisk floppyDisk) {
        System.out.println("ChassisVisitor.visitFloppyDisk");
    }

    @Override
    public void visitChassis(Chassis chassis) {
        System.out.println("ChassisVisitor.visitChassis");
    }

    @Override
    public void visitBus(Bus bus) {
        System.out.println("ChassisVisitor.visitBus");
    }

    @Override
    public void visitCard(Card card) {
        System.out.println("ChassisVisitor.visitCard");
    }
}
