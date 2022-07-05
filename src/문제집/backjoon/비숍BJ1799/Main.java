package 문제집.backjoon.비숍BJ1799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.07.05
 */

public class Main {
    static int N;
    static int[][] map;
    static int max;

    static int[] dx = {-1,1,1,-1};
    static int[] dy = {1,1,-1,-1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/비숍BJ1799/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);
        System.out.println(max);
    }
    private static void dfs(int x, int y, int cnt) {
        if(x == N-1 && y == N-1){
            max = Math.max(max,cnt);
            return ;
        }
        if(y==N){
            y=0;
            x++;
        }

        if(map[x][y] == 1){
            boolean flag = true;
            // 놓기
            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
    
                while(!isOut(nx, ny) && map[nx][ny] != 2){
                    nx += dx[d];
                    ny += dy[d];   
                }
                if(isOut(nx, ny)) continue;
                flag = false;
                break;
            }

            if(flag){
                map[x][y] = 2;
                dfs(x,y+1,cnt+1);
                map[x][y] = 1;
            }
            dfs(x,y+1,cnt);
        }else{
            dfs(x,y+1,cnt);
        }
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }
}
