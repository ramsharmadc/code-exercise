package code.main.app.mock.cpu;

public class MainApp {

    public static void main(String[] args) {

        Scheduler scheduler = Scheduler.instance;

        try {
            Process mainProc = new Process() {
                @Override
                public void run() {
                    this.state = Process.ProcState.NEW;
                    this.processId = ProcessIdGen.instance.getUniqueId();
                    System.out.println("Executing proess with pid - " + this.processId);
                }
            };
            scheduler.schedule(mainProc);

            int childProcCount = -1;
            mainProc.children = new Process[10];

            Process childProc_1 = new Process() {
                @Override
                public void run() {
                    this.processId = ProcessIdGen.instance.getUniqueId();
                    this.parent = mainProc;
                    this.state = ProcState.NEW;
                    System.out.println("Executing proess with pid - " + this.processId);
                }
            };
            mainProc.children[childProcCount + 1] = childProc_1;
            scheduler.schedule(childProc_1);

            Process childProc_2 = new Process() {
                @Override
                public void run() {
                    this.processId = ProcessIdGen.instance.getUniqueId();
                    this.parent = mainProc;
                    this.state = ProcState.NEW;
                    System.out.println("Executing proess with pid - " + this.processId);
                }
            };
            mainProc.children[childProcCount + 1] = childProc_2;
            scheduler.schedule(childProc_2);

            Process childProc_3 = new Process() {

                @Override
                public void run() {
                    this.processId = ProcessIdGen.instance.getUniqueId();
                    this.parent = mainProc;
                    this.state = ProcState.NEW;
                    System.out.println("Executing proess with pid - " + this.processId);
                }
            };
            mainProc.children[childProcCount + 1] = childProc_3;
            scheduler.schedule(childProc_3);

            Process childProc_4 = new Process() {

                @Override
                public void run() {
                    this.processId = ProcessIdGen.instance.getUniqueId();
                    this.parent = mainProc;
                    this.state = ProcState.NEW;
                    System.out.println("Executing proess with pid - " + this.processId);
                }
            };
            mainProc.children[childProcCount + 1] = childProc_4;
            scheduler.schedule(childProc_4);

            Process childProc_5 = new Process() {

                @Override
                public void run() {
                    this.processId = ProcessIdGen.instance.getUniqueId();
                    this.parent = mainProc;
                    this.state = ProcState.NEW;
                    System.out.println("Executing proess with pid - " + this.processId);
                }
            };
            mainProc.children[childProcCount + 1] = childProc_5;
            scheduler.schedule(childProc_5);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
