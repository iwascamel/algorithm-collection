package 문제집.프로그래머스.카카오기출.카카오2021.로또의_최고순위와_최저순위;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(Arrays.toString(solution));
    }
    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {

            int count =0;
            int zero = 0;

            for(int lotto : lottos){
                if (lotto ==0 ){
                    zero ++;
                    continue;
                }
                for(int win : win_nums){
                    if(lotto == win) count++;
                }
            }

            int[] result = new int[2];

            int max=0;

            max = count + zero;

            switch (max){
                case 6:
                    result[0]=1;
                    break;
                case 5:
                    result[0]=2;
                    break;
                case 4:
                    result[0]=3;
                    break;
                case 3:
                    result[0]=4;
                    break;
                case 2:
                    result[0]=5;
                    break;
                case 1:
                case 0:
                    result[0]=6;
                    break;
            }
            switch (count){
                case 6:
                    result[1]=1;
                    break;
                case 5:
                    result[1]=2;
                    break;
                case 4:
                    result[1]=3;
                    break;
                case 3:
                    result[1]=4;
                    break;
                case 2:
                    result[1]=5;
                    break;
                case 1:
                case 0:
                    result[1]=6;
                    break;
            }
            return result;
        }
    }
}
