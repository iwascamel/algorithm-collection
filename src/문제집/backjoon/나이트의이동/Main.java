package 문제집.backjoon.나이트의이동;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * date : 22.03.30
 */

public class Main {
    static int T;
    static int N;
    static int[][] map;
    static boolean[][] checked;
    static int curX;
    static int curY;
    static int endX;
    static int endY;

    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/나이트의이동/input.txt"));

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int t=0;t<T;t++){
            N = sc.nextInt();
            map = new int[N][N];
            checked = new boolean[N][N];

            curX = sc.nextInt();
            curY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();

            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[]{curX,curY,0});
            int answer = 0;
            while(!queue.isEmpty()){
                int[] poll = queue.poll();

                int x = poll[0];
                int y=  poll[1];
                int cnt = poll[2];

                if(x==endX && y==endY){
                    answer = cnt;
                    break;
                }

                for(int d=0;d<8;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(isOut(nx,ny) || checked[nx][ny]) continue;

                    queue.offer(new int[]{nx,ny,cnt+1});
                    checked[nx][ny] = true;
                }
            }
            System.out.println(answer);
        }
    }
    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }
}
