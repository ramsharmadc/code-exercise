package lang.java_8.threading.concurrent.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class UseForkJoinPool {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(new UseForkJoinPool().new MyRecursiveAction(67));

    }

    class MyRecursiveAction extends RecursiveAction {

        long workload = 0;

        public MyRecursiveAction(long workload) {
            this.workload = workload;
        }

        @Override
        protected void compute() {
            if (this.workload > 16) {
                System.out.println("too much workload, splitting tasks");
                List<MyRecursiveAction> subTasks = createSubActions();
                for (MyRecursiveAction a : subTasks) {
                    a.fork();
                }
            } else {
                System.out.println("doing my task of workload: " + this.workload);
            }
        }

        public List<MyRecursiveAction> createSubActions() {
            List<MyRecursiveAction> subActions = new ArrayList<>();
            MyRecursiveAction action_1 = new MyRecursiveAction(this.workload / 2);
            MyRecursiveAction action_2 = new MyRecursiveAction(this.workload / 2);
            subActions.add(action_1);
            subActions.add(action_2);
            return subActions;
        }
    }
}
