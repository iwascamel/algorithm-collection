package 문제집.backjoon.영역구하기BJ2583;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * date: 22.06.23
 */

public class Main {
    static int N,M,K;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] v = new boolean[N][M]; 
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/영역구하기BJ2583/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine());

            int leftY = Integer.parseInt(st.nextToken())+1;
            int leftX = Integer.parseInt(st.nextToken())+1;

            leftY -= 1;
            leftX = N-leftX;

            int rightY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());

            rightY -= 1;
            rightX = N-rightX;

            for(int i=rightX;i<=leftX;i++){
                for(int j=leftY;j<=rightY;j++){
                    map[i][j] = 1;
                }
            }
        }
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    list.add(bfs(i,j));
                    cnt++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        list.forEach((e)->System.out.print(e + " "));
    }
    private static int bfs(int x,int y) {
        Queue<int[]> queue = new LinkedList<>();
        
        int sum = 0;
        queue.offer(new int[]{x,y});
        map[x][y] = 2;
        sum++;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int d=0;d<4;d++){
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                if(isOut(nx,ny) || map[nx][ny] != 0) continue;

                queue.offer(new int[]{nx,ny});
                map[nx][ny] = 2;
                sum++;
            }
        }
        
        return sum;
    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=M;
    }
    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
