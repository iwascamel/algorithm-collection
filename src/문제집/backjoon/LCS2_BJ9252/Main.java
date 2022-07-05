package 문제집.backjoon.LCS2_BJ9252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.07.05
 */

public class Main {
    static int[][] dp;
    static int N,M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/LCS2_BJ9252/input.txt"));

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
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = N;
        int y = M;
        while(y>=1 && x>=1){
            if(dp[x][y] == dp[x-1][y]){
                x--;
            }else if(dp[x][y] == dp[x][y-1]){
                y--;
            }else{
                sb.append(s2.charAt(y-1));
                x--;
                y--;
            }
        }

        System.out.println(dp[N][M]);
        System.out.println(sb.reverse());
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
