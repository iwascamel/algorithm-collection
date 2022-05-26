package 문제집.backjoon.점프;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sol{
    static long[][] dp = new long[101][101];
    static int N;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/점프/input.txt"));

        Scanner sc = new Scanner(System.in);
        int[][] map = new int[101][101];
        int n = sc.nextInt();
        N = n;

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || (i == n - 1 && j == n - 1)) {
                    continue;
                }

                print();
                System.out.println("---------");

                int dist = map[i][j];
                int down = dist + i;
                int right = dist + j;

                if (down < n) {
                    dp[down][j] += dp[i][j];
                }

                if (right < n) {
                    dp[i][right] += dp[i][j];
                }
            }
        }
        print();
        System.out.println("---------");
        System.out.println(dp[n - 1][n - 1]);
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}



