package 문제집.backjoon.달팽이;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * date: 22.05.27
 */

public class Main {
    static int N;
    static int findNum;
    static int[][] map;
    // 상 우 하 좌
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/달팽이/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int value = 1;
        int d = 0;
        int x = N/2;
        int y = N/2;

        int time =1;

        out:while(true){
            for(int i=0;i<2;i++){
                int t = time;
                while(t-->0){
                    map[x][y] = value++;
                    int nx = x+dx[d];
                    int ny = y+dy[d];

                    if(value == N*N){
                        map[nx][ny] = value;
                        break out;
                    }
                    x = nx;
                    y = ny;
                }
                d = (d+1)%4;
            }
            time++;
        }
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

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
