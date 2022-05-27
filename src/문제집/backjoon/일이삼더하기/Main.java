package 문제집.backjoon.일이삼더하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * date: 22.05.27
 */

public class Main {
    static int T;
    static int[] dp;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/일이삼더하기/input.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<=10;i++){
            for(int d=1;d<=3;d++){
                dp[i] += dp[i-d] ;
            }
        }
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}
