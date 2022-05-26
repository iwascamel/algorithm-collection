package 문제집.backjoon.배열돌리기4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int direction;

    // 하 우 상 좌
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] spinInfo;

    static List<int[]> list; // 순열 정보 저장

    static int[] input;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/배열돌리기4/input.txt"));

        Scanner sc = new Scanner(System.in);

        list = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N + 1][M + 1];
        spinInfo = new int[K][3];

        input = new int[K];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 3; j++) {
                spinInfo[i][j] = sc.nextInt();
            }
        }

        int result=Integer.MAX_VALUE;

        setPermutation(0, new boolean[K], new int[K]);

        for(int[] arr : list){
            int[][] cloneMap = new int[N+1][M+1];
            for(int i=1;i<N+1;i++){
                System.arraycopy(map[i],0,cloneMap[i],0,M+1);
            }
            for(int i=0;i<arr.length;i++){
                spinMap(cloneMap,spinInfo[i]);
            }
            print(cloneMap);
            System.out.println("================");
            result = Math.min(result,getMinRowValueFromMap(cloneMap));
        }
        System.out.println(result);
    }

    static int getMinRowValueFromMap(int[][] arr){
        int minValue = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int temp=0;
            for(int j=1;j<arr[0].length;j++){
                temp = temp+ arr[i][j];
            }
            minValue = Math.min(minValue,temp);
        }
        return minValue;
    }

    // 알맞게 회전됨
    static void spinMap(int[][] arr, int[] spin) {

        int shell = (spin[2] * 2 + 1) / 2;

        for (int i = 0; i < shell; i++) {

            int startX = spin[0] - spin[2] + i;
            int startY = spin[1] - spin[2] + i;

            int endX = spin[0] + spin[2] - i;
            int endY = spin[1] + spin[2] - i;

            int temp = arr[startX][startY];

            int x = startX;
            int y = startY;

            direction = 0;

            while (direction < 4) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (isOut(nx, ny, startX, endX, startY, endY)) {
                    direction++;
                } else {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            map[startX][startY + 1] = temp;
        }

    }

    static boolean isOut(int nx, int ny, int startX, int endX, int startY, int endY) {
        return nx < startX || nx > endX || ny < startY || ny > endY;
    }

    private static void setPermutation(int count, boolean[] flag, int[] temp) {
        if (count == K) {
            int[] clone = temp.clone();
            list.add(clone);
        }

        for (int i = 0; i < K; i++) {
            if (flag[i]) continue;
            temp[count] = i;
            flag[i] = true;
            setPermutation(count + 1, flag, temp);
            flag[i] = false;
        }
    }

    static void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void print(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
