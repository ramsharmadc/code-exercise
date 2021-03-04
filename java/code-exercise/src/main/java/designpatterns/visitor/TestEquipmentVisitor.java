package designpatterns.visitor;

public class TestEquipmentVisitor {

    public static void main(String[] args) {
        Equipment floppyDisk = new FloppyDisk();
        Equipment card = new Card();
        Equipment chassis = new Chassis();
        Equipment bus = new Bus();

        EquipmentVisitor floppyDiskVisitor = new FloppyDiskVisitor();
        EquipmentVisitor busVisitor = new BusVisitor();
        EquipmentVisitor cardVisitor = new CardVisitor();
        EquipmentVisitor chassisVisitor = new ChassisVisitor();

        floppyDiskVisitor.visitFloppyDisk((FloppyDisk) floppyDisk);
        cardVisitor.visitCard((Card) card);
        chassisVisitor.visitChassis((Chassis) chassis);
        busVisitor.visitBus((Bus) bus);
    }
}
