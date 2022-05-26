package 문제집.backjoon.벽부수고이동하기4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 22.04.07
 * memo : 그냥 bfs 돌리면 시간초과
 */

public class MainFail {
    static int N,M;
    static int[][] map;
    static int[][] countMap;
    static int count;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/벽부수고이동하기4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        countMap = new int[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] !=0){
                    count = 0;
                    map[i][j] = 0;
                    count(i,j);
                    map[i][j] = 1;
                    countMap[i][j] = count%10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(countMap[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void count(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];

        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        count++;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int x1 = poll[0];
            int y1 = poll[1];

            for(int d=0;d<4;d++){
                int nx = x1 + dx[d];
                int ny = y1 + dy[d];

                if(isOut(nx,ny) || visited[nx][ny] || map[nx][ny] == 1) continue;

                queue.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                count++;
            }
        }
    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }
}
