package 문제집.backjoon.사다리조작;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N,M,H;
    static int[][] map;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/사다리조작/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        map = new int[H+1][N+1];

        for(int i=0;i<M;i++){
            int row = sc.nextInt();
            int col = sc.nextInt();

            map[row][col] = col+1;
            map[row][col+1] = col;
        }

        for(int i=1;i<=3;i++){
            getComb(0,0,i);
        }


    }

    private static void getComb(int cnt, int start, int num) {
        if(cnt==num){

            return ;
        }


    }

    private static void print() {
        for(int i=0;i<H+1;i++){
            for(int j=0;j<N+1;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
