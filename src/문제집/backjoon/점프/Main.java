package 문제집.backjoon.점프;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date: 22.03.23
 */

public class Main {
    static int N;
    static int[][] map;

    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static long result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/점프/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        if(x == N-1 && y==N-1){
            result++;
            return ;
        }
        int range = map[x][y];

        for(int d=0;d<2;d++){
            int nx = x + dx[d]*range;
            int ny = y + dy[d]*range;

            if(isOut(nx,ny)) continue;

            dfs(nx,ny);
        }
    }

    static boolean isOut(int nx,int ny){
        return nx >= N || ny>=N;
    }
}
