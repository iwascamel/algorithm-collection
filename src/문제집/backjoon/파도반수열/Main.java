package 문제집.backjoon.파도반수열;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 22.06.21
 */

public class Main {
    static int T;
    static long[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/파도반수열/input.txt"));

        dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4;i<=100;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}
