package 문제집.프로그래머스.완전탐색.카펫;

import java.util.Arrays;

/**
 * date : 22.02.10
 * 참조풀이 링크 : https://mozzioi.tistory.com/95
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(24,24);
    }
    static class Solution {
        public int[] solution(int brown, int yellow) {

            int totalCnt = brown + yellow;
            int[] res = new int[2];

            for(int i=1;i<totalCnt;i++){
                int row = i;
                int col = totalCnt/row;

                if((row-2) * (col-2) == yellow && row >= col){
                    res[0] = row;
                    res[1] = col;
                }
            }
            System.out.println(Arrays.toString(res));
            return res;
        }
    }
}
