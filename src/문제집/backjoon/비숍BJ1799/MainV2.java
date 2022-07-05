package 문제집.backjoon.비숍BJ1799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 22.07.05
 * dfs(++y) 조심하기 -> y+=1 해야함
 * 2^26 = 6800만
 *
 * 10이니까
 * 2^25 + 2^25 = 2^26
 */

public class MainV2 {
    static int N;
    static int[][] map;
    static int bMax;
    static int wMax;

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

        // black
        dfs(0,0,0,0);
        // white
        dfs(0,1,0,1);
        System.out.println("bMax = " + bMax);
        System.out.println("wMax = " + wMax);
        System.out.println(bMax+wMax);
    }
    private static void dfs(int x, int y, int cnt,int color) {
        if(x == N-1 && y >= N-1){
            if(color == 0 ){
                bMax = Math.max(bMax,cnt);
            }else{
                wMax = Math.max(wMax,cnt);
            }
            return ;
        }
        if(y>=N){
            if(color == 0){
                if(x%2==0){
                    y=0;
                }else{
                    y=1;
                }
            }else{
                if(x%2==0){
                    y=1;
                }else{
                    y=0;
                }
            }
            x+=1;
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
                dfs(x,y+2,cnt+1,color);
                map[x][y] = 1;
            }
        }
        dfs(x,y+2,cnt,color);
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
