package 문제집.프로그래머스.스택큐.선입선출스케줄링;

import java.util.*;

public class MainV2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6,new int[]{1,2,3});
    }
    static class Solution {
        public int solution(int n, int[] cores) {
            PriorityQueue<int[]> workQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            Queue<int[]> queue = new LinkedList<>();

            for(int i=0;i<cores.length;i++){
                workQueue.offer(new int[]{i,cores[i]});
            }
            int answer = 0;

            while(n>0){
                System.out.println("work queue");
                for(int[] a : workQueue){
                    System.out.println(Arrays.toString(a));
                }
                System.out.println("queue");
                for(int[] a : queue){
                    System.out.println(Arrays.toString(a));
                }
                System.out.println("-----------");
                if(!workQueue.isEmpty()){
                    int[] poll = workQueue.poll();
                    int index = poll[0];
                    int value = poll[1];
                    n--;
                    if(n==0){
                        answer = index;
                        break;
                    }
                    queue.offer(new int[]{index,value});
                }

                int size = queue.size();

                while(size-->0){
                    int[] poll = queue.poll();
                    int index = poll[0];
                    int value = poll[1];

                    if(value == 0){
                        workQueue.offer(new int[]{index,value});
                    }else{
                        queue.offer(new int[]{index,value-1});
                    }
                }
            }

            System.out.println(answer);
            return answer;
        }
    }
}
