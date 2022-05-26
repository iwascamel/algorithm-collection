package 문제집.프로그래머스.스택큐.프린터;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * date: 22.03.31
 */

/*
[2, 4, 8, 2, 9, 3, 3], 2
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 1, 9, 1, 1, 1},0);
    }
    static class Solution {
        static int N;
        public int solution(int[] priorities, int location) {
            Queue<int[]> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            N = priorities.length;
            for(int i=0;i<N;i++){
                queue.offer(new int[]{i,priorities[i]});
            }
            for(int n : priorities){
                pq.offer(n);
            }

            int cnt = 0;
            while(!queue.isEmpty()){
                int[] poll = queue.poll();

                int index = poll[0];
                int value = poll[1];

                if(!pq.isEmpty() && value == pq.peek()){
                    cnt++;
                    pq.poll();
                    if(index == location) break;
                }else{
                    queue.offer(new int[]{index,value});
                }
            }

            return cnt;
        }
    }
}
