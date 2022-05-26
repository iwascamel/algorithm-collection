package 문제집.backjoon.소형기관차;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int N;
    static int max;
    static int[] arr;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/소형기관차/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        max = sc.nextInt();

        sum = new int[N+1];
        dp = new int[3+1][N+1];

        for(int i=0;i<N;i++){
            sum[i+1] = sum[i] +  arr[i];
        }

        for(int i=1;i<3+1;i++){
            for(int j=i*max;j<N+1;j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max] + (sum[j] - sum[j-max]));
            }
        }

        System.out.println(dp[3][N]);
    }
}
