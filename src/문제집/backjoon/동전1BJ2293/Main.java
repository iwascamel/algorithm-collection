package 문제집.backjoon.동전1BJ2293;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.07.01~04
 */

public class Main {
    static int n,k;
    static int[] dp;
    static int[] coins;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/동전1BJ2293/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());    
        }
        dp = new int[k+1];

        dp[0] = 1;
        for(int j=0;j<n;j++){
            for(int i=1;i<=k;i++){
                if(i - coins[j] >= 0){
                    dp[i] += dp[i-coins[j]];
                }
            }    
        }
        System.out.println(dp[k]);
    }
}
