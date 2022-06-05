package 문제집.backjoon.BOJ거리;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 22.06.05
 */

public class MainV2 {
    static int N;
    static int[] dp;
    static char[] next;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/BOJ거리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        dp = new int[N];
        next = new char[]{'B','O','J'};
        Map<Character,Integer> map = new HashMap<>();
        map.put('B',0);
        map.put('O',1);
        map.put('J',2);
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0;i<N-1;i++){
            int target = map.get(input.charAt(i));
            if(dp[i] == Integer.MAX_VALUE) continue;
            for(int j=i+1;j<N;j++){
                int cur = map.get(input.charAt(j));
                if(cur == (target+1)%3){
                    dp[j] = Math.min(dp[j], dp[i] + (j-i) * (j-i));
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1]);
    }
}
