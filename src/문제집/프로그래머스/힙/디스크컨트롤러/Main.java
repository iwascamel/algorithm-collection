package 문제집.프로그래머스.힙.디스크컨트롤러;

import java.util.*;

/**
 * date : 21.12.21
 * link : https://programmers.co.kr/learn/courses/30/lessons/42627
 */

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[][]{{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}});
        System.out.println(solution1);
    }

    static class Solution {

        static int cnt;
        static int result;
        static int currentTime;

        public int solution(int[][] jobs) {

            cnt = 0;
            result = 0;
            currentTime = 0;

            Comparator<int[]> comp1 = (o1, o2) -> Integer.compare(o1[0],o2[0]);
            Comparator<int[]> comp2 = Comparator.comparingInt(o -> o[1]);
            Comparator<int[]> comp3 = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) {
                        return Integer.compare(o1[1],o2[1]);
                    }else{
                        return Integer.compare(o1[0],o2[0]);
                    }
                }
            };

            PriorityQueue<int[]> pq1 = new PriorityQueue<>(comp1);
            PriorityQueue<int[]> pq2 = new PriorityQueue<>(comp2);

            Arrays.sort(jobs,comp3);

            for(int[] a : jobs){
                pq1.offer(a);
            }

            while(!pq1.isEmpty()){
                Queue<int[]> tempQueue = new LinkedList<>();

                while(!pq1.isEmpty()){
                    int[] pollTemp = pq1.poll();
                    int t = pollTemp[0];
                    if(t > currentTime) tempQueue.offer(pollTemp);
                    else pq2.offer(pollTemp);
                }
                while(!tempQueue.isEmpty()) pq1.offer(tempQueue.poll());

                if(pq2.isEmpty()){
                    currentTime = pq1.peek()[0];
                }else{
                    while(!pq2.isEmpty()){
                        int[] pq2Poll = pq2.poll();

                        int t = pq2Poll[0];
                        int j = pq2Poll[1];

                        currentTime += j;
                        // 끝난시간 - 들어온 시간
                        result += currentTime - t;
                    }
                }
            }

            return result/jobs.length;
        }
    }
}
