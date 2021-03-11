package designpatterns.visitor;

public class CardVisitor implements EquipmentVisitor {
    @Override
    public void visitFloppyDisk(FloppyDisk floppyDisk) {
        System.out.println("CardVisitor.visitFloppyDisk");
    }

    @Override
    public void visitChassis(Chassis chassis) {
        System.out.println("CardVisitor.visitChassis");
    }

    @Override
    public void visitBus(Bus bus) {
        System.out.println("CardVisitor.visitBus");
    }

    @Override
    public void visitCard(Card card) {
        System.out.println("CardVisitor.visitCard");
    }
}
