package 문제집.backjoon.미세먼지안녕;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int N,M,T;
    static int[][] map;
    static boolean[][] mark;
    static int firstRow;
    static int secondRow;

    static int[] dx= {-1,1,0,0};
    static int[] dy ={0,0,-1,1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/미세먼지안녕/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        firstRow = 0;
        secondRow = 0;

        map = new int[N][M];
        mark = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] > 0 ) mark[i][j] = true;

                if(map[i][j] == -1){
                    if(firstRow == 0){
                        firstRow = i;
                    }else{
                        secondRow = i;
                    }
                }
            }
        }


        while(T>0){
            spread();
            moveUpArea();
            moveDownArea();
            T--;
        }
        print();
        calculate();

    }

    private static int calculate() {
        return -1;
    }

    private static void moveDownArea() {
    }

    private static void moveUpArea() {
    }

    private static void spread() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>=5 && mark[i][j]){
                    int cnt = 0;
                    int divideValue=0;

                    for(int d=0;d<4;d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(isOut(nx,ny) || map[nx][ny] == -1) continue;

                        cnt++;
                        divideValue = map[i][j]/5;
                        map[nx][ny] += divideValue;
                    }
                    map[i][j] -= divideValue*cnt;
                }
            }
        }
        marking();
    }

    static void marking(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] > 0) mark[i][j] = true;
            }
        }
    }

    static boolean isOut(int nx,int ny){
        return nx<0 || ny<0 || nx>= N || ny>= M;
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
