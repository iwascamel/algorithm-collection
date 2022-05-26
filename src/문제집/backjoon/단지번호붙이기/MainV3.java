package 문제집.backjoon.단지번호붙이기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainV3 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static int count;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/단지번호붙이기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        visit = new boolean[N][N];
        count = 1;

        for(int i=0;i<N;i++) {
            String input = sc.next();
            for(int j=0;j<N;j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }


        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] ==1 && !visit[i][j]) {
                    bfs(i,j);
                    count++;
                }
            }
        }
        print();

    }

    static void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        int cnt = 1;
        visit[x][y] = true;
        map[x][y] = 1;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for(int d=0;d<4;d++) {
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                if( isOut(nx,ny) || visit[nx][ny] || map[nx][ny] != 1 ) continue;

                map[nx][ny] = count;
                cnt++;
                visit[nx][ny] = true;
            }
        }
    }

    static boolean isOut(int x, int y) {
        return x < 0 || x >= map.length || y < 0 || y >= map.length;
    }

    static void print() {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map.length;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}