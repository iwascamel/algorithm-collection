package 문제집.backjoon.미로탐색;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 22.03.29
 * link : https://wiselog.tistory.com/163
 */

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/미로탐색/input.txt"));

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        checked = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        checked[0][0] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            if(x==N-1 && y==M-1){
                break;
            }

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isOut(nx,ny) || checked[nx][ny] || map[nx][ny] == 0) continue;

                queue.offer(new int[]{nx,ny});
                map[nx][ny] += map[x][y];
                checked[x][y] = true;
            }
        }

        System.out.println(map[N-1][M-1]);
    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }
}
