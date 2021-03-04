package designpatterns.visitor;

public class FloppyDiskVisitor implements EquipmentVisitor {
    @Override
    public void visitFloppyDisk(FloppyDisk floppyDisk) {
        System.out.println("FloppyDiskVisitor.visitFloppyDisk");
        floppyDisk.discountPrice();
        floppyDisk.netPrice();
        floppyDisk.power();
    }

    @Override
    public void visitChassis(Chassis chassis) {
        System.out.println("FloppyDiskVisitor.visitChassis");
    }

    @Override
    public void visitBus(Bus bus) {
        System.out.println("FloppyDiskVisitor.visitBus");
    }

    @Override
    public void visitCard(Card card) {
        System.out.println("FloppyDiskVisitor.visitCard");
    }
}
