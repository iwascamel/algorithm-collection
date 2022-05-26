package 문제집.프로그래머스.이분탐색.입국심사;

import java.util.Arrays;

/**
 * date : 22.02.21
 * 참조 링크 : https://yubh1017.tistory.com/30
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(6, new int[]{7, 10});
        System.out.println(solution1);
    }

    static class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);
            long start = 0;
            long end = Long.MAX_VALUE;
            long result = Long.MAX_VALUE;

            while(start<=end){
                long mid = (start+end)/2;
                long peopleCount =0;

                for(int t : times){
                    peopleCount += mid/t;
                    if(peopleCount>=n) break;
                }

                if(peopleCount < n){
                    start = mid+1;
                }else{
                    result = Math.min(result,mid);
                    end = mid-1;
                }
            }
            return result;
        }
    }
}
