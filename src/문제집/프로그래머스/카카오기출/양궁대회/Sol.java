package 문제집.프로그래머스.카카오기출.양궁대회;

import java.util.Arrays;

/**
 * link : https://velog.io/@qodlstjd12/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Kakao-%EC%96%91%EA%B6%81-%EB%8C%80%ED%9A%8C-Java
 */

class Sol {
    public static void main(String[] args) {
        int[] solution1 = solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
        System.out.println(Arrays.toString(solution1));
    }
    static int[] res = { -1 };
    static int[] lion;
    static int max = -1000;
    static int count=0;
    public static void dfs(int[] info, int cnt, int n) {
        count ++;
        if(cnt == n+1) {
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++)
            {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i])
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }
            if(lion_point > apeach_point) {
                if(lion_point - apeach_point >= max)
                {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            return ;
        }
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        }
    }
    public static int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info,1,n);
        System.out.println(count);
        return res;
    }
}
