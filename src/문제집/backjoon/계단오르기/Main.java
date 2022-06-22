package 문제집.backjoon.계단오르기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * date: 22.06.22
 */

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/계단오르기/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        if(N<=2){
            for(int n : arr){
                sum += n;
            }
            System.out.println(sum);
            return ;
        }

        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];

        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1]) + arr[i];
        }

        System.out.println(Arrays.toString(dp));
    }
}
