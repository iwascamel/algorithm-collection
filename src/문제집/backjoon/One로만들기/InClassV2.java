package 문제집.backjoon.One로만들기;

import java.util.Scanner;

public class InClassV2 {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[1000001];

        dp[1]=0;
        dp[2]=1;
        dp[3]=1;

        for(int i=4;i<=N;i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i],dp[i/3]+1);
        }
        System.out.println(dp[N]);
    }
}
