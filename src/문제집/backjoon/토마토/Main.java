package 문제집.backjoon.토마토;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date : 21.09.24
 * type : bfs
 */

public class Main {

    static int N;
    static int M;

    static int[][] map;
    static List<int[]> list;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("./src/backjoon/토마토/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList<>();

        // 반대
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    list.add(new int[]{i, j, 1});
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int[] a : list) {
            queue.offer(a);
        }

        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int nx = a[0];
            int ny = a[1];
            int num = a[2];

            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];

                if (isOut(x, y) || map[x][y] == -1 || map[x][y] > 0) continue;

                map[x][y] = num + 1;
                queue.offer(new int[]{x, y, num + 1});
            }
        }

        if(hasZero()){
            System.out.println(-1);
        }else{
            int max = getMax();
            System.out.println(max-1);
        }
    }

    private static int getMax() {
        int max = -10;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] > max) max= map[i][j];
            }
        }
        return max;
    }

    static boolean isOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= M || ny >= N;
    }

    private static boolean hasZero() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) return true;
            }
        }
        return false;
    }


    static void print() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
