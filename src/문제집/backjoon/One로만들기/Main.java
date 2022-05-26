package 문제집.backjoon.One로만들기;

import java.util.Scanner;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();

        dp = new Integer[N+1];

        dp[0]=0;
        dp[1]=0;

//        int recurse = recurse(N);
//        System.out.println(recurse);
        System.out.println(recur(N));
    }

    private static int recurse(int N) {
        if(dp[N]==0){
            if(N%6==0){
                dp[N] = Math.min(recurse(N-1),Math.min(recurse(N/3),recurse(N/2)))+1;
            }else if(N%3==0){
                dp[N] = Math.min(recurse(N/3),recurse(N-1))+1;
            }else if(N%2==0){
                dp[N] = Math.min(recurse(N/2),recurse(N-1))+1;
            }else{
                dp[N] = recurse(N-1)+1;
            }
        }
        return dp[N];
    }
    static int recur(int N) {
        if (dp[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
