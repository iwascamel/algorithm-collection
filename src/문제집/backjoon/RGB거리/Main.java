package 문제집.backjoon.RGB거리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * date : 21.09.14
 * type : dp
 */

public class Main {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] cost;
    static int N;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/RGB거리/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        cost = new int[N][3];

        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                cost[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<N;i++){
            cost[i][Red] += Math.min(cost[i-1][Green],cost[i-1][Blue]);
            cost[i][Blue] += Math.min(cost[i-1][Red],cost[i-1][Green]);
            cost[i][Green] += Math.min(cost[i-1][Red],cost[i-1][Blue]);
        }
        System.out.println(Math.min(cost[N-1][Red],Math.min(cost[N-1][Blue],cost[N-1][Green])));
    }

    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }
}
