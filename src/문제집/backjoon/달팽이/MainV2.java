package 문제집.backjoon.달팽이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 22.05.27
 */

public class MainV2 {
    static int N;
    static int findNum;
    static int[][] map;
    // 하 우 상 좌
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/달팽이/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int d = 0;

        int x = 0;
        int y = 0;

        for(int num=N*N;num>0;num--){
            map[x][y] = num;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isOut(nx,ny) || map[nx][ny] != 0){
                d = (d+1)%4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }
        print();
        System.out.println("------------");

        int time =1;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(findNum == map[i][j]){
                    int a = i+1;
                    int b = j+1;
                    System.out.println(a + " " + b);
                }
            }
        }
    }

    private static boolean isOut(int nx, int ny) {
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
