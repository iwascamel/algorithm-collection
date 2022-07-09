package 문제집.backjoon.안전영역BJ2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 22.07.09
 */


public class Main {
    static int N;
    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/안전영역BJ2468/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        int mh = 0;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                mh = Math.max(mh,map[i][j]);
            }
        }

        int max = 1;
        for(int h=1;h<=100;h++){
            v = new boolean[N][N];
            int tv = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(v[i][j] || map[i][j] <= h) continue;
                    bfs(i,j,h);
                    tv++;
                }
            }
            max = Math.max(max,tv);
        }
        System.out.println(max);
    }

    private static void printV() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y,int h) {
        Queue<int[]> q = new LinkedList<>();
        v[x][y] = true;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] poll = q.poll();

            for(int d=0;d<4;d++){
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                if(isOut(nx,ny) || v[nx][ny] || map[nx][ny] <= h) continue;

                q.offer(new int[]{nx,ny});
                v[nx][ny] = true;
            }
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }
}
