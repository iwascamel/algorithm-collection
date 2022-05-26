package 문제집.프로그래머스.카카오기출.무지의먹방라이브;

import java.util.LinkedList;
import java.util.Queue;

/**
 * date : 22.01.28
 * memo : fail
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{3, 1, 2}, 5);
        System.out.println(solution1);
    }
    static class Solution {
        static class Food{
            int index;
            int remain;

            public Food(int index, int remain) {
                this.index = index;
                this.remain = remain;
            }

            @Override
            public String toString() {
                return "Food{" +
                        "index=" + index +
                        ", remain=" + remain +
                        '}';
            }
        }
        public int solution(int[] food_times, long k) {
            Queue<Food> queue = new LinkedList<>();
            for(int i=0;i<food_times.length;i++){
                queue.offer(new Food(i,food_times[i]));
            }
            long time =0 ;
            int result =-1 ;
            while (!queue.isEmpty()){
                time++;
                Food poll = queue.poll();
                if(time == k-1) {
                    result = poll.index+1;
                    break;
                }
                if(poll.remain > 0) {
                    poll.remain -= 1;
                    queue.offer(poll);
                }
            }
            return result;
        }
    }
}
