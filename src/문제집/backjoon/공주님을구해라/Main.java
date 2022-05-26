package 문제집.backjoon.공주님을구해라;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * date: 22.03.01
 * memo: 문제조건을 정확히 안 읽었다. T 등호 빼먹었었다.
 */

public class Main {

    static int N,M,T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int result;

    static class Move{
        int x;
        int y;
        int cnt;
        boolean key;

        public Move(int x, int y, int cnt, boolean key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/공주님을구해라/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        result = Integer.MAX_VALUE;
        map = new int[N][M];

        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }

        Queue<Move> queue = new LinkedList<>();

        queue.offer(new Move(0,0,0,false));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Move poll = queue.poll();

            if(poll.x == N-1 && poll.y == M-1 && poll.cnt <= T){
                result = Math.min(result,poll.cnt);
                continue;
            }

            for(int d=0;d<4;d++){
                int nx = poll.x + dx[d];
                int ny = poll.y + dy[d];

                if(isOut(nx,ny)) continue;

                if(poll.key && !visited[nx][ny][1]){
                    queue.offer(new Move(nx,ny,poll.cnt+1,true));
                    visited[nx][ny][1] = true;
                }else if(!poll.key && !visited[nx][ny][0]){
                    if(map[nx][ny] == 2){
                        queue.offer(new Move(nx,ny,poll.cnt+1,true));
                        visited[nx][ny][1] = true;
                    }else{
                        if(map[nx][ny]==1) continue;
                        queue.offer(new Move(nx,ny,poll.cnt+1,false));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? "Fail" : result);

    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny <0 || nx>=N || ny>=M;
    }
}
