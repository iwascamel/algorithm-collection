package 문제집.프로그래머스.힙.디스크컨트롤러;

import java.util.*;
import java.util.stream.Collectors;


public class Sol {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[][]{{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}});
        System.out.println(solution1);
    }


    static class Job implements Comparable<Job> {
        private final Integer insertTime;
        private final Integer timeToFinish;
        private Integer endAt;

        public Job(int[] job) {
            this.insertTime = job[0];
            this.timeToFinish = job[1];
        }

        public void setEndAt(Integer endAt) {
            this.endAt = endAt;
        }

        public Integer getInsertTime() {
            return insertTime;
        }

        public Integer getTimeToFinish() {
            return timeToFinish;
        }

        public Integer getSuspendTime() {
            return this.endAt - this.insertTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.timeToFinish - o.timeToFinish;
        }
    }

    static class Disk {
        private Integer jobExecutionTime;
        private Job job;
        Queue<Job> doneQueue;

        public Disk() {
            this.jobExecutionTime = 0;
            this.doneQueue = new LinkedList<>();
        }

        public Queue<Job> getDoneQueue() {
            return doneQueue;
        }

        public void setJob(Job job, Integer curTime) {
            this.jobExecutionTime = 0;
            this.job = job;
        }

        public boolean isIdle() {
            return this.job == null;
        }

        public void done(Integer curTime) {
            job.setEndAt(curTime);
            this.jobExecutionTime = 0;
            doneQueue.add(this.job);
            this.job = null;
        }

        public boolean isDone() {
            if (isIdle()) {
                return false;
            }
            return job.getTimeToFinish().equals(jobExecutionTime);
        }

        public void timeElapsed() {
            jobExecutionTime++;
        }
    }

    static class Solution {
        public int solution(int[][] jobs) {

            PriorityQueue<Job> waitQueue = new PriorityQueue<>(Comparator.comparing(Job::getInsertTime));
            waitQueue.addAll(Arrays.stream(jobs).map(Job::new).collect(Collectors.toList()));
            PriorityQueue<Job> scheduler = new PriorityQueue<>(Comparator.comparing(Job::getTimeToFinish));
            Disk disk = new Disk();

            int currentTime = 0;

            while (!waitQueue.isEmpty() || !scheduler.isEmpty() || !disk.isIdle()) {

                while (!waitQueue.isEmpty()) {
                    Job job = waitQueue.peek();
                    if (job.getInsertTime() <= currentTime) {
                        scheduler.offer(waitQueue.poll());
                    } else {
                        break;
                    }
                }

                if (disk.isDone()) {
                    disk.done(currentTime);
                }

                if (!scheduler.isEmpty() && disk.isIdle()) {
                    disk.setJob(scheduler.poll(), currentTime);
                }

                disk.timeElapsed();
                currentTime++;
            }

            return disk.getDoneQueue().stream().mapToInt(Job::getSuspendTime).sum() ;
        }
    }
}
