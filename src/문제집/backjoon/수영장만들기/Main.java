package 문제집.backjoon.수영장만들기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 22.07.14
 */

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/수영장만들기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int cnt =0 ;
        for(int h=1;h<=9;h++){
            visited = new boolean[N][M];

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j] == h){
                        int res = bfs(i,j,h);
                        if(res!=-1){
                            cnt += res;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    static void printV(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }

    private static int bfs(int x, int y,int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        // temp queue
        Queue<int[]> tq = new LinkedList<>();
        tq.offer(new int[]{x,y});
        int cnt = 1;
        boolean flag = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int d=0;d<4;d++){
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                // 가장 자리에 가서 흘러내리거나, 주변의 값이 h보다 작아서 흘러내린다면
                if (isOut(nx, ny) || map[nx][ny] < h) {
                    flag = false;
                    // break 가 아니라 continue 를 걸어줘야 한다.
                    continue;
                }

                if(visited[nx][ny]) continue ;
                if(map[nx][ny] == h){
                    tq.offer(new int[]{nx,ny});
                    queue.offer(new int[]{nx,ny});
                    cnt++;
                    visited[nx][ny] = true;
                }
            }
        }

        if(flag){
            while(!tq.isEmpty()){
                int[] poll = tq.poll();
                int px = poll[0];
                int py = poll[1];

                map[px][py] += 1;
            }
            return cnt;
        }else{
            return -1;
        }
    }
}
