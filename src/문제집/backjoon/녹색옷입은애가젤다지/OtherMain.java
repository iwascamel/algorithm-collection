package 문제집.backjoon.녹색옷입은애가젤다지;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * link : https://youngest-programming.tistory.com/537
 */

public class OtherMain {
    private static int N;
    private static int[][] map;
    private static int[][] distances;
    private static int INF = Integer.MAX_VALUE;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/녹색옷입은애가젤다지/input.txt"));
        Scanner sc = new Scanner(System.in);
        int testCnt = 0;
        while (true) {
            N = sc.nextInt();
            if(N==0) return;
            map = new int[N][N];
            distances = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    distances[i][j] = INF;
                }
            }
            System.out.println("Problem " + (++testCnt) + ": " + bfs());
        }
    }

    static int bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, map[0][0]));
        distances[0][0] = map[0][0];
        while (!queue.isEmpty()) {
            print();
            System.out.println("===");
            Point point = queue.poll();
            int r = point.r;
            int c = point.c;
            for (int i = 0; i < 4; i++) {
                int r2 = r + dr[i];
                int c2 = c + dc[i];
                if (r2 >= 0 && c2 >= 0 && r2 < N && c2 < N && (distances[r2][c2] > distances[r][c] + map[r2][c2])) { // 해당 지점까지의 최소거리라면 갱신
                    distances[r2][c2] = distances[r][c] + map[r2][c2];
                    queue.add(new Point(r2, c2, distances[r2][c2]));
                }
            }
        }
        return distances[N - 1][N - 1];
    }
    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(distances[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Point implements Comparable<Point>{
        int r;
        int c;
        int cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return cost - o.cost;
        }
    }
}
