package dsa.problemsolving.misc;

import java.util.*;

/**
 * Priority Job Queue ->
 * Job -> [jobQueue] { sizeLimit - unbounded }
 * Job priority (1 - 10) low to high
 * <p>
 * add(job, priority)
 * cancel(job)
 */
public class ScheduleJobsWithPriority {

    private final static Map<Integer, Job> jobLookup = new HashMap<>();
    private final static Set<Job> jobsPriorityQueue = new TreeSet<>();

    public static void main(String[] args) {

        ScheduleJobsWithPriority a = new ScheduleJobsWithPriority();
        a.add(a.new Job(1), 9);
        a.add(a.new Job(2), 1);
        a.add(a.new Job(3), 7);
        a.add(a.new Job(4), 6);
        a.add(a.new Job(5), 2);
        a.add(a.new Job(5), 10);

        System.out.println(jobsPriorityQueue);

        a.cancel(a.new Job(1));

        System.out.println(jobsPriorityQueue);
    }

    public void add(Job job, int priority) {

        job.setPriority(priority);

        if (jobLookup.containsKey(job.getId())) {
            Job curJob = jobLookup.get(job.getId());

            synchronized (jobsPriorityQueue) {
                jobsPriorityQueue.remove(curJob);
            }
        }

        Job newJob = new Job(job.getId(), priority);

        synchronized (jobsPriorityQueue) {
            jobsPriorityQueue.add(newJob);
        }

        jobLookup.put(newJob.getId(), newJob);

    }

    public void cancel(Job job) {
        if (jobLookup.containsKey(job.getId())) {
            Job curJob = jobLookup.get(job.getId());

            synchronized (jobsPriorityQueue) {
                jobsPriorityQueue.remove(curJob);
            }
        }
    }

    class Job implements Comparable<Job> {

        private int id;
        private int priority;

        public Job(int id) {
            this(id, 0);
        }

        public Job(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(Job that) {
            return Integer.compare(that.priority, this.priority);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Job job = (Job) o;
            return id == job.id && priority == job.priority;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, priority);
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", priority=" + priority +
                    '}';
        }
    }
}
