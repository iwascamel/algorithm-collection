package 문제집.backjoon.LCS_BJ9251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.07.04
 */

public class Main {
    static int N,M;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/LCS_BJ9251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        String s2 = br.readLine();

        N = s1.length();
        M = s2.length();

        dp = new int[N+1][M+1];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    // -1 행 -> 지금까지 존재했던 값, 문자 -1을 했을 때 ( ABC라면 AB까지만 다루었을 때 )의 최대값
                    // 같은 행 -1열 -> ABC까지 다뤘을 때 최대값
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[N][M]);
    }
    private static void printDP() {
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
