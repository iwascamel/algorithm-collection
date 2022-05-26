package 문제집.backjoon.테트로미노;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/구현/테트로미노/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
                countFuckYouShape(i,j);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int i, int j, int count, int cost) {
        if(count >=4){
            result = Math.max(cost,result);
            return ;
        }

        for(int d=0;d<4;d++){
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(isOut(nx,ny) || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx,ny,count+1,cost+map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }

    static void countFuckYouShape(int x, int y) {
        if (x < N - 2 && y < M - 1)
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);

        if (x < N - 2 && y > 0)
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);

        if (x < N - 1 && y < M - 2)
            result = Math.max(result, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);

        if (x > 0 && y < M - 2)
            result = Math.max(result, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
    }
}
