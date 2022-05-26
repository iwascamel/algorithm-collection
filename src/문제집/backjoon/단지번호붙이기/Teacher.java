package 문제집.backjoon.단지번호붙이기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Teacher {

    static int[][] map;

    static int[] dx= {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        count = new int[N*N];

        for(int i=0;i<N;i++){
            char[] c = sc.next().toCharArray();
            for(int j=0;j<N;j++){
                map[i][j] = c[j]-'0';
            }
        }

        int cnt=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1){
                    cnt++;
                    count[cnt+1] = 1;
                    bfs(i,j,cnt+1);
                }
            }
        }
        print();
        System.out.println(Arrays.toString(count));
    }

    static void bfs(int x,int y,int group){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        map[x][y]=group;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int nx = poll[0];
            int ny = poll[1];

            if(isOut(nx,ny)) continue;

            if(map[nx][ny]==1){
                count[group]++;
                queue.offer(new int[]{nx,ny});
                map[nx][ny]=group;
            }
        }
    }

    private static void dfs(int x, int y,int groupNumber) {
        map[x][y] = groupNumber;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isOut(nx,ny)) continue;

            if(map[nx][ny]==1){
                count[groupNumber]++;
                dfs(nx,ny,groupNumber);
            }
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || nx>=map.length || ny<0 || ny>=map.length;
    }

    static void print(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
