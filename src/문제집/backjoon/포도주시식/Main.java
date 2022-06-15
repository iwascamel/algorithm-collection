package 문제집.backjoon.포도주시식;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 22.06.15
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/포도주시식/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N<=2){
            int sum = 0;
            for(int i=0;i<=N;i++){
                sum += arr[i];
            }
            System.out.println(sum);
            return ;
        }

        dp[1] = arr[1];
        dp[2] = arr[2]+arr[1];

        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i],Math.max(arr[i] + dp[i-2], dp[i-1]));
        }
        System.out.println(dp[N]);
    }
}
