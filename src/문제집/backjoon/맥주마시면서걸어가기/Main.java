package 문제집.backjoon.맥주마시면서걸어가기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * date: 22.03.31
 */

public class Main {
    static int T;
    static int N;

    static Point start;
    static Point end;

    static Point[] stores;
    static boolean[] visited;

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/맥주마시면서걸어가기/input.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=0;t<T;t++){
            N = sc.nextInt();

            int startX = sc.nextInt();
            int startY = sc.nextInt();

            start = new Point(startX,startY);

            stores = new Point[N];
            visited = new boolean[N];

            for(int i=0;i<N;i++){
                int storeX = sc.nextInt();
                int storeY = sc.nextInt();

                stores[i] = new Point(storeX,storeY);
            }
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            end = new Point(endX,endY);

            Queue<Point> queue = new ArrayDeque<>();

            queue.offer(start);

            boolean flag = false;

            while (!queue.isEmpty()){
                Point poll = queue.poll();

                if(check(poll,end)){
                    flag = true;
                    break;
                }

                for(int i=0;i<N;i++){
                    if(visited[i]) continue;
                    if(check(stores[i],poll)){
                        visited[i] = true;
                        queue.offer(new Point(stores[i].x,stores[i].y));
                    }
                }
            }

            if(flag){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }
    static boolean check(Point p1, Point p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) <= 1000;
    }
}
