package 문제집.backjoon.배열돌리기1;

import java.io.IOException;
import java.util.Scanner;


// 배열돌리기 3,4 경비원 풀기
public class Main {

    static int[][] map;

    static int direction = 0;


    private static int[] dx = {0, 1, 0, -1};//우상좌하
    private static int[] dy = {1, 0, -1, 0};
    static int N, M, R;

    static int shell;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        map = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        shell = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            spin();
        }

        print();
    }

    private static void spin() {
        for (int i = 1; i <= shell; i++) {
            int x = i;
            int y = i;

            int temp = map[x][y];

            direction = 0;

            while (direction < 4) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (isOut(nx, ny, i)) {
                    direction++;
                } else {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            map[i + 1][i] = temp;
        }
    }

    static boolean isOut(int nx, int ny, int out) {
        return nx + out > N + 1 || nx - out < 0 || ny + out > M + 1 || ny - out < 0;
    }

    static void print() {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void printAll() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
