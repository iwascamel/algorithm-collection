package 문제집.backjoon.연구소;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date : 22.01.29
 * 참조 풀이 : https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14502%EB%B2%88-%EC%97%B0%EA%B5%AC%EC%86%8C-%EC%9E%90%EB%B0%94Java
 *
 *
 */

public class MainV2 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;

    static int resultCount;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/연구소/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(resultCount);
    }

    private static void dfs(int cnt) {
        if(cnt == 3){
            int res = countVirus();
            resultCount = Math.max(res,resultCount);
            return ;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(cnt+1);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static int countVirus() {
        int[][] tempMap = new int[N][M];

        for(int i=0;i<N;i++){
            tempMap[i] = map[i].clone();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tempMap[i][j]==2){
                    fillDfs(tempMap,i,j);
                }
            }
        }

        return countZeroNum(tempMap);
    }

    private static void fillDfs(int[][] tempMap, int x, int y) {
        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isOut(nx,ny) || tempMap[nx][ny] != 0) continue;
            tempMap[nx][ny] = 2;
            fillDfs(tempMap,nx,ny);
        }
    }


    static int countZeroNum(int[][] tempMap) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) res++;
            }
        }
        return res;
    }

    static boolean isOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    private static void print(int[][] tmap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(tmap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
