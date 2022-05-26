package 문제집.backjoon.녹색옷입은애가젤다지;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * date : 21.09.29
 * type : bfs + dp
 * 참조 link : https://velog.io/@pss407/%EB%B0%B1%EC%A4%804485-%EB%85%B9%EC%83%89-%EC%98%B7-%EC%9E%85%EC%9D%80-%EC%95%A0%EA%B0%80-%EC%A0%A4%EB%8B%A4%EC%A7%80
 * 문제 link : https://www.acmicpc.net/problem/4485
 * fail reason :
 * 1. 단순 dfs 라고 생각해서 4방 탐색했다.
 * 2. stackoverflow 발생하길래 뭐지? 했는데 방문 체크를 안해줬다
 * 3. 아 오른쪽 아래로만 내려가는구나! 하고 방향을 2개만 설정했다 -> 왼쪽 위쪽도 갈 수 있네? 음 뭐지?
 * 4. 왼쪽 위부터 오른쪽 아래까지 갈 수 있는 모든 경우의 수를 따져봐야 겠다라고 생각했다.
 * 5. 근데 그러면 방문 체크를 어떻게 해주지?
 * 6. link 를 보고 이 문제에 대한 dp 풀이방법에 대해 이해했다. ( 다익스트라적 접근 방법이기도 함 )
 */

public class Main {

    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] flag;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/녹색옷입은애가젤다지/input.txt"));

        Scanner sc = new Scanner(System.in);
        int number = 1;

        while (true) {
            int cnt = 0;
            N = sc.nextInt();
            if (N == 0) break;
            map = new int[N][N];
            dp = new int[N][N];

            for(int i=0;i<N;i++){
                Arrays.fill(dp[i],INF);
            }

            flag = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            bfs();
            System.out.println("Problem " + number++ + ": " + dp[N-1][N-1]);
        }

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        dp[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            for(int d=0;d<4;d++){
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(isOut(nx,ny)) continue;
                if(dp[nx][ny] > dp[x][y] + map[nx][ny]){
                    dp[nx][ny] = dp[x][y] + map[nx][ny];
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }

    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}
