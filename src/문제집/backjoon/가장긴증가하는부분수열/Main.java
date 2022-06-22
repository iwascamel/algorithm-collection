package 문제집.backjoon.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * date: 22.06.22
 */

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/가장긴증가하는부분수열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        int max = 1;
        for(int i=1;i<N;i++){
            dp[i] = 1;

            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
