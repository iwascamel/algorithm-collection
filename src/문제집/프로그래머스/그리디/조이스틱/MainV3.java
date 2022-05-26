package 문제집.프로그래머스.그리디.조이스틱;

import java.util.Arrays;

/**
 * date : 21.12.18
 * memo : left, right에 대한 고민 + 11번 테스트 케이스에 의해서 left right 다시 설정하는 고민
 */

public class MainV3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int jeroen = solution.solution("ABAAAAAAAAABB");
        System.out.println(jeroen);
    }

    static class Solution {
        static int N;
        static char[] alphas;

        public int solution(String name) {
            N = name.length();
            int left = 0;
            int right = N-1;
            alphas = name.toCharArray();
            int cntLeft = 0;
            int cntRight = 1;
            int cntTotal = 0;

            while(left < N){
                if(leftCountA(left)) break;
                left ++;
            }

            while(right > 0){
                if(rightCountA(right)) break;
                right --;
            }
            if(alphas[right]=='A') right++;
            cntLeft = left-1;
            cntRight += (N-1) - right;

            for(int i=0;i<N;i++){
                int num = alphas[i] - 'A';
                cntTotal += Math.min(num,26-num);
            }

            System.out.println("left " + cntLeft);
            System.out.println("right " + cntRight);
            System.out.println("totalCnt " +cntTotal);

            System.out.println(Arrays.toString(alphas));
            for(char c : alphas){
                System.out.print(c - 'A' +  " ");
            }

            cntTotal += Math.min(cntLeft,cntRight);

            return cntTotal;
        }

        private boolean rightCountA(int right) {
            for(int i=right;i>0;i--){
                if(alphas[i] != 'A') return false;
            }
            return true;
        }

        private boolean leftCountA(int left) {
            for(int i=left;i<N;i++){
                if(alphas[i] != 'A') return false;
            }
            return true;
        }
    }
}
