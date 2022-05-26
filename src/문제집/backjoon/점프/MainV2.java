package 문제집.backjoon.점프;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.03.23
 */

public class MainV2 {
    static int N;
    static int[][] map;
    static long[][] dp;

    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static long result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/점프/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        dp = new long[N][N];

        dp[0][0] = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(dp[N-1][N-1]);
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int x, int y) {
        if(dp[x][y] == 0 || (x==N-1 && y==N-1)) return;

        int range = map[x][y];

        for(int d=0;d<2;d++){
            int nx = x + dx[d]*range;
            int ny = y + dy[d]*range;

            if(isOut(nx,ny)) continue;

            dp[nx][ny] += dp[x][y] ;

            dfs(nx,ny);
        }
    }

    static boolean isOut(int nx,int ny){
        return nx >= N || ny>=N;
    }
}
