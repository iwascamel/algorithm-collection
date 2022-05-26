package 문제집.backjoon.배열돌리기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://hidelookit.tistory.com/110
public class Solution {
    private static int N, M, R;
    private static int[][] map;

    // 방향값...
    // 1 1 값 <- 오른쪽 값으로 대입
    // 반시계 -> 시계방향으로 돌아야 한다.
    private static int[] dx = {0, 1, 0, -1};//우상좌하
    private static int[] dy = {1, 0, -1, 0};

    static int direction=0;

    static int areaNum;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N +1][M +1];

        for (int i = 1; i<= N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j<= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //총 돌려야 하는 네모 개수
        areaNum = Math.min(N, M)/2;

        for (int i = 0; i< R; i++) {
            circulate();
        }
        print();
    }//main

    // 돌린다
    private static void circulate() {
        for (int i = 1; i<= areaNum; i++) {
            //네모들의 왼쪽 맨위의 좌표는 1,1 || 2,2 || 3,3 || ...
            int x = i;
            int y = i;
            int temp = map[x][y];

            direction=0;

            while(direction<4){
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx < i || ny < i || nx > N + 1 -i || ny > M + 1 -i) {
                    direction++;
                } else {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            map[i+1][i] = temp;
        }
    }
    static void print(){
        for(int i=1;i<map.length;i++){
            for(int j=1;j<map[0].length;j++){
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