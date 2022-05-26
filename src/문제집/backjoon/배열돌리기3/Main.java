package 문제집.backjoon.배열돌리기3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int [][] map;
    static int N,M,R;
    static int[] order;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/배열돌리기3/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }
        order = new int[R];

        for(int i=0;i<R;i++){
            order[i] = sc.nextInt();
        }
        orderOne();
        print(map);
    }
    // 1. 상하 반전
    // 2차원 배열에서는 clone 쓰면 안됨 -> 얕은복사 일어남
    // 1차원 배열에서만 clone 깊은 복사 가능
    static void orderOne(){
        int [][] result = new int[N][M];

        // N이 짝수
        if(N%2==0){
            int downAreaFirstIndex = N/2;
            int[][] cloneUpArea = new int[N][M];
            for(int i=0;i<N;i++){
                System.arraycopy(map[i],0,cloneUpArea[i],0,M);
            }
            int[][] cloneDownArea = new int[N][M];
            for(int i=0;i<N;i++){
                System.arraycopy(map[i],0,cloneDownArea[i],0,M);
            }

            // 아래 -> 위 , 아래는 0으로 초기화
            for(int i=0;i<downAreaFirstIndex;i++){
                for(int j=0;j<M;j++){
                    cloneUpArea[i][j]=cloneUpArea[i+downAreaFirstIndex][j];
                }
            }
            for(int i=downAreaFirstIndex;i<N;i++){
                for(int j=0;j<M;j++){
                    cloneUpArea[i][j]=0;
                }
            }
            // 위 -> 아래 , 위는 0으로 초기화
            for(int i=0;i<downAreaFirstIndex;i++){
                for(int j=0;j<M;j++){
                    cloneDownArea[i+downAreaFirstIndex][j]=cloneDownArea[i][j];
                }
            }
            for(int i=0;i<downAreaFirstIndex;i++){
                for(int j=0;j<M;j++){
                    cloneDownArea[i][j]=0;
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    result[i][j] = cloneUpArea[i][j] + cloneDownArea[i][j];
                }
            }
        }
        for(int i=0;i<N;i++){
            System.arraycopy(result[i],0,map[i],0,M);
        }
    }

    static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
