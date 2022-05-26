package 문제집.프로그래머스.스택큐.선입선출스케줄링;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6,new int[]{1,2,3});
    }
    static class Solution {
        public int solution(int n, int[] cores) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Queue<int[]> queue = new LinkedList<>();

            for(int num : cores){
                pq.offer(num);
            }
            int answer = 0;
            out : while(true){
                while(!pq.isEmpty()){
                    int poll = pq.poll();
                    if(n==1){
                        answer = poll;
                        break out;
                    }
                    queue.offer(new int[]{poll,poll});
                    n--;
                }

                Queue<int[]> temp = new LinkedList<>();
                int size = queue.size();
                while(size-->0){
                    int[] poll = queue.poll();
                    poll[1] -= 1;
                    if(poll[1] > 0){
                        temp.offer(new int[]{poll[0],poll[1]});
                    }else{
                        pq.offer(poll[0]);
                    }
                }
                queue = temp;
            }
            System.out.println(answer);
            return answer;
        }
    }
}
