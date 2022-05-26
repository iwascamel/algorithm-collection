package 문제집.backjoon.새로운게임2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N,K;

    // 우 좌 상 하
    // 입력값에서 -1 해줘야한다 입력값 = 1부터 시작
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int[][] colorMap;
    static Horse[] horses;
    static Deque<Horse>[][] horseMap;

    static class Horse{
        int x;
        int y;
        int index;
        int dir;

        public Horse(int x, int y, int index, int dir) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/구현/새로운게임2/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        colorMap = new int[N][N];
        horses = new Horse[K];
        horseMap = new LinkedList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                horseMap[i][j] = new LinkedList<>();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                colorMap[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<K;i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() -1 ;
            int dir = sc.nextInt() -1;

            horses[i] = new Horse(x,y,i,dir);
        }

        for(int i=0;i<K;i++){
            Horse h = horses[i];
            horseMap[h.x][h.y].offer(h);
        }

        for(int t=1;t<=1000;t++){
            if (endPoint(t)) return;

            for(int i=0;i<K;i++){
                Horse h = horses[i];
                int nx = h.x + dx[h.dir];
                int ny = h.y + dx[h.dir];

                if(isOut(nx,ny) || colorMap[nx][ny] == 2){
                    h.dir = changeDir(h.dir);
                    nx = h.x + dx[h.dir];
                    ny = h.y + dy[h.dir];
                }

                if(isOut(nx,ny) || colorMap[nx][ny] == 2){
                    
                }


            }
        }

        System.out.println(-1);

    }

    private static int changeDir(int dir) {
        if(dir==0) return 1;
        else if(dir==1) return 0;
        else if(dir==2) return 3;
        else if(dir==3) return 2;

        return -1;
    }

    private static boolean isOut(int nx, int ny) {
        return nx<0 || ny<0 || nx>=N || ny>=N;
    }

    private static boolean endPoint(int t) {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(horseMap[i][j].size() == K){
                    System.out.println(t);
                    return true;
                }
            }
        }
        return false;
    }
}
