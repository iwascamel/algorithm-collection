package 문제집.backjoon.배열돌리기3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainV2 {

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
        for(int i : order){
            switch (i){
                case 1:
                    orderOne();
                    break;
                case 2:
                    orderTwo();
                    break;
                case 3:
                    orderThree();
                    break;
                case 4:
                    orderFour();
                    break;
                case 5:
                    orderFive();
                    break;
                case 6:
                    orderSix();
                    break;
            }
        }
        print(map);
    }
    // 1. 상하 반전
    static void orderOne(){
        for(int i=0;i<map.length/2;i++){
            for(int j=0;j<map[0].length;j++){
                int temp = map[i][j];
                map[i][j] = map[map.length-1-i][j];
                map[map.length-1-i][j] = temp;
            }
        }
    }
    // 2. 좌우 반전
    static void orderTwo(){
        for(int j=0;j<map[0].length/2;j++){
            for(int i=0;i<map.length;i++){
                int temp = map[i][j];
                map[i][j] = map[i][map[0].length-1-j];
                map[i][map[0].length-1-j] = temp;
            }
        }
    }

    // 3. 90도 회전
    static void orderThree(){
        int[][] temp = new int[map[0].length][map.length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                temp[j][map.length-1-i] = map[i][j];
            }
        }
        map = temp;
    }

    // 4. -90도 회전
    static void orderFour(){
        int[][] temp = new int[map[0].length][map.length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                temp[map[0].length-1-j][i] = map[i][j];
            }
        }
        map = temp;
    }

    // 5. 1 -> 2  4방면 나누고
    //    4 <- 3
    static void orderFive(){

        int[][] temp = new int[map.length][map[0].length];

        int halfRow = map.length/2;
        int halfColumn = map[0].length/2;
        // 1 -> 2
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i][j+halfColumn] = map[i][j];
            }
        }
        // 2->3
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i+halfRow][j+halfColumn] = map[i][j+halfColumn];
            }
        }
        // 3->4
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i+halfRow][j] = map[i+halfRow][j+halfColumn];
            }
        }
        // 4->1
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i][j] = map[i+halfRow][j];
            }
        }
        map = temp;
    }

    // 6. 1 <- 4
    //    2 -> 3
    static void orderSix(){

        int[][] temp = new int[map.length][map[0].length];

        int halfRow = map.length/2;
        int halfColumn = map[0].length/2;
        // 1 -> 2
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i+halfRow][j] = map[i][j];
            }
        }
        // 2->3
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i+halfRow][j+halfColumn] = map[i+halfRow][j];
            }
        }
        // 3->4
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i][j+halfColumn] = map[i+halfRow][j+halfColumn];
            }
        }
        // 4->1
        for(int i=0;i<halfRow;i++){
            for(int j=0;j<halfColumn;j++){
                temp[i][j] = map[i][j+halfColumn];
            }
        }
        map = temp;
    }


    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
