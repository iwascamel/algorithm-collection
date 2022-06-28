package 문제집.backjoon.배열돌리기4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 22.06.28
 */

public class Main {
    static int N,M,K;
    static int[][] map;

    // 하 우 상 좌
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int[] temp;
    static Infos[] infos;
    static int min;

    static class Infos{
        int sx;
        int sy;
        int n;
        public Infos(int sx, int sy, int n) {
            this.sx = sx;
            this.sy = sy;
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/배열돌리기4/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

         infos = new Infos[K];

        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            int n = 2*s;
            int sx = r-s;
            int sy = c-s;

            infos[k] = new Infos(sx,sy,n);
        }

        min = Integer.MAX_VALUE;
        temp = new int[K];
        perm(0,0);
        System.out.println(min);
    }

    private static void perm(int cnt, int flag) {
        if(cnt==K){
            int[][] tempMap = new int[N][M];
            for(int i=0;i<N;i++){
                tempMap[i] = map[i].clone();
            }
            for(int t : temp){
                Infos info = infos[t];

                int sx = info.sx;
                int sy = info.sy;
                int n = info.n;

                recurse(sx,sy,n,tempMap);
            }

            for(int i=0;i<N;i++){
                int sum =0 ;
                for(int j=0;j<M;j++){
                    sum += tempMap[i][j];
                }
                min = Math.min(sum,min);
            }
            return ;
        }

        for(int i=0;i<K;i++){
            if((flag & 1 << i) != 0) continue;
            temp[cnt] = i;
            perm(cnt+1,flag | 1 << i);
        }
    }

    static void print(int[][] map){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void recurse(int sx, int sy, int n,int[][] map) {
        if(n<=0) return;

        int startValue = map[sx][sy];

        int nx = sx;
        int ny = sy;
        for(int d=0;d<4;d++){
            int range;
            if(d==3){
                range = n-1;
            }else{
                range = n;
            }
            while(range-->0){
                int nnx = nx + dx[d];
                int nny = ny + dy[d];
                
                map[nx][ny] = map[nnx][nny];
                nx = nnx;
                ny = nny;
            }
        }
        map[sx][sy+1] = startValue;
        
        recurse(sx+1, sy+1, n-2,map);
    }
}
