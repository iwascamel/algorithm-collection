package 문제집.backjoon.달팽이;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainV3 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, num, K;
    static int[][] map;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/달팽이/input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        int x=0, y=0, d = 0;
        int kx=0, ky=0;
        map[0][0] = N*N;
        StringBuilder sb = new StringBuilder();

        for(num = N*N-1; num > 0; num--) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(isOut(nx,ny) || map[nx][ny]!=0) {
                d = (d+1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            map[nx][ny] = num;
            if(num == K) {
                kx = nx+1;
                ky = ny+1;
            }
            x = nx; y = ny;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
        System.out.println(kx+" "+ky);

        sc.close();
    }

    static boolean isOut(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}