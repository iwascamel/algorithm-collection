package 문제집.backjoon.뱀;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * date: 22.03.11
 */

public class Main {
    static int N;
    static int K;
    static int L;
    static int[][] visited;
    static int[][] map;
    static int[][] dirs;

    static Point head;
    static Point tail;

    // 우 하 좌 상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Point{
        int x,y;
        int dir;

        public Point(int x, int y,int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/자료구조/뱀/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i],7);
        }
        map = new int[N][N];
        K = sc.nextInt();

        for(int i=0;i<K;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            map[x-1][y-1] = 9;
        }

        L = sc.nextInt();
        dirs = new int[L][2];

        sc.nextLine();

        for(int i=0;i<L;i++){
            String[] input = sc.nextLine().split(" ");
            int time = Integer.parseInt(input[0]);
            if(input[1].equals("D")){
                dirs[i][0] = time;
                dirs[i][1] = 1;
            }else if(input[1].equals("L")) {
                dirs[i][0] = time;
                dirs[i][1] = -1;
            }
        }

        head = new Point(0,0,0);
        tail = new Point(0,0,0);

        visited[0][0] = 0;
        int p = 0;
        int time = 0 ;
        while (true){
            print();
            System.out.println("====================");
            time++;
            printM();
            System.out.println("time = " + time);
            System.out.println("tail = " + tail);
            System.out.println("head = " + head);
            System.out.println("--------------------------------------------");
            int nx = head.x + dx[head.dir];
            int ny = head.y + dy[head.dir];

            if(isOut(nx,ny) || (visited[nx][ny] >= 0 && visited[nx][ny] <= 4 )) break;

            head.x = nx;
            head.y = ny;

            if(p<L && time == dirs[p][0]){
                int dir = head.dir + dirs[p][1];
                if(dir == -1){
                    head.dir = 3;
                }else if(dir == 4){
                    head.dir = 0;
                }else{
                    head.dir=dir;
                }
                p++;
            }
            visited[nx][ny] = head.dir;

            if( map[nx][ny] == 0){
                int tx=  tail.x;
                int ty = tail.y;
                tail.x = tail.x + dx[visited[tx][ty]];
                tail.y = tail.y + dy[visited[tx][ty]];
                visited[tx][ty]=7;
            }
        }
        System.out.println(time);


    }
    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(visited[i][j]+ " ");
            }
            System.out.println();
        }
    }
    static void printM(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }
}
