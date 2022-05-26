package 문제집.backjoon.연구소;

import java.io.*;
import java.util.StringTokenizer;

/**
 * date : 22.01.29
 * memo : 37%에서 틀림
 *
 * 참조 풀이 : https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14502%EB%B2%88-%EC%97%B0%EA%B5%AC%EC%86%8C-%EC%9E%90%EB%B0%94Java
 *
 *
 */

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/연구소/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int res = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if (map[a][b] != 0) continue;
                for (int c = 0; c < N; c++) {
                    for (int d = 0; d < M; d++) {
                        if (map[c][d] != 0) continue;
                        for (int e = 0; e < N; e++) {
                            for (int f = 0; f < M; f++) {
                                if (map[e][f] != 0) continue;
                                int[][] tempMap = new int[N][M];
                                for (int i = 0; i < N; i++) {
                                    tempMap[i] = map[i].clone();
                                }
                                tempMap[a][b] = 1;
                                tempMap[c][d] = 1;
                                tempMap[e][f] = 1;
                                for (int n = 0; n < N; n++) {
                                    for (int m = 0; m < M; m++) {
                                        if (tempMap[n][m] == 2) {
                                            dfs(tempMap, n, m);
                                        }
                                    }
                                }
                                res = Math.max(res, countZeroNum(tempMap));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int[][] tempMap, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isOut(nx, ny) || tempMap[nx][ny] != 0) continue;
            tempMap[nx][ny] = 2;
            dfs(tempMap, nx, ny);
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
