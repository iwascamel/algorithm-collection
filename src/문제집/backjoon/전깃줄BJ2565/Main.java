package 문제집.backjoon.전깃줄BJ2565;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * date: 22.06.28
 */

public class Main {
    static int N;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/전깃줄BJ2565/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][2];
        dp = new int[N+1];
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        dp[1] = 1;
        int max = 1;
        for(int i=2;i<=N;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(arr[i][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(N-max);
    }
}
