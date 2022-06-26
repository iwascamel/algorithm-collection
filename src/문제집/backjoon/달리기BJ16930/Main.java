package 문제집.backjoon.달리기BJ16930;

import java.io.*;
import java.util.*;

/**
 * date: 22.06.26
 */

public class Main {
    static int N,M,K;
    static char[][] map;

    static int sx,sy,ex,ey;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int res = -1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/달리기BJ16930/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        
        sx = Integer.parseInt(st.nextToken())-1;
        sy = Integer.parseInt(st.nextToken())-1;
        ex = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;

        bfs();
        System.out.println(res);
    }
    private static void bfs() {
        
    }
    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny <0 || nx>=N || ny>=M;
    }
}
