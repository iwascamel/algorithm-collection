package 문제집.프로그래머스.그리디.조이스틱;

/**
 * date : 21.12.18
 * memo : 풀이를 써놓고 검증하지 않고 무지성으로 바로 푸니까, 굉장히 헤매고 풀이도 잘못 풀었다.
 *
 * 1. 위아래 검증 -> 가까운 쪽으로 되는데, 무지성으로 -'A'해버림
 * 2. 양옆 검증 -> 투포인터 이용해서 할라 그랬는데, 헷갈려서 제대로 못함.
 *
 * 다시 풀것
 */

public class MainV2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int jeroen = solution.solution("JEROAANNQN");
        System.out.println(jeroen);
    }

    static class Solution {
        static int N;
        static char[] alphas;

        public int solution(String name) {
            N = name.length();
            char[] ch = name.toCharArray();
            int cnt = 0;
            for(char c : ch) cnt += c-'A';

            int left = 1;
            int right = 1;
            int lp =0;
            int rp =N-1;

            a: while(lp<N-1){
                int dog = lp+1;

                // mistake : i 자리에 dog 를 넣었다.
                for(int i=dog;i<N;i++){
                    if(ch[i] != 'A'){
                        left += i - lp;
                        lp = i;
                        break;
                    }
                    if(i == N-1){
                        if(ch[i] != 'A') left++;
                        break a;
                    }
                }

                if(ch[dog] == 'A'){
                    lp++;
                }
            }

            b: while(rp>0){
                int dog = rp-1;

                // mistake : i 자리에 dog 를 넣었다.
                for(int i=dog;i>=0;i--){
                    if(ch[i] != 'A'){
                        right += rp - i;
                        rp = i;
                        break;
                    }
                    if(i == 0){
                        if(ch[i] != 'A') right++;
                        break b;
                    }
                }

                if(ch[dog] == 'A'){
                    rp--;
                }
            }

            cnt += Math.min(left,right);

            return cnt;
        }
    }
}
