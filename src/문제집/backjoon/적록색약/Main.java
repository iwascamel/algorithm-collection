package 문제집.backjoon.적록색약;

import java.io.*;

/**
 * date: 22.03.17
 */

public class Main {
    static char[][] map;
    static int[][] mark;
    static int[][] pMark;
    static int N;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/적록색약/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mark = new int[N][N];
        map = new char[N][N];
        pMark = new int[N][N];
        cnt = 1;

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = line.charAt(j);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(mark[i][j] == 0){
                    dfs(map[i][j],i,j);
                    cnt++;
                }
            }
        }
        int n1 = cnt-1;
        cnt=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(pMark[i][j] == 0){
                    pDfs(map[i][j],i,j);
                    cnt++;
                }
            }
        }
        int n2 = cnt-1;

        System.out.println(n1 + " "  + n2);
    }

    private static void print(int[][] mark) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(char c, int x, int y) {
        if(mark[x][y] != 0 || map[x][y] != c) return;

        mark[x][y] = cnt;

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isOut(nx,ny)) continue;

            dfs(c,nx,ny);
        }
    }

    private static void pDfs(char c, int x, int y) {
        if(pMark[x][y] != 0) return;

        if(c=='B' && map[x][y] !=c) return;
        if((c=='G' || c=='R') && map[x][y]=='B') return;

        pMark[x][y] = cnt;

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isOut(nx,ny)) continue;

            pDfs(c,nx,ny);
        }
    }

    static boolean isOut(int nx, int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }
}
