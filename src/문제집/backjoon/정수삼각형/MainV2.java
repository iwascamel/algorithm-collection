package 문제집.backjoon.정수삼각형;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 22.07.12
 * data: https://olympiads.win.tue.nl/ioi/ioi94/contest/day1prb1/index.html
 */


/*
memo: 22.07.12
그리디로 풀었는데, 반례 존재

    left    right
   l1  l2  r1   r2

만약 left > right 여서 left 골랐는데, r1이 100000이고 left 10 right 8 l1 3 l2 4 이렇다면 right을 골라야 한다.
즉, 단순 재귀가 아니라 dp를 이용해서 풀어야 한다.

 */

public class MainV2 {
    static int N;
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/정수삼각형/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dp = new int[N][N];
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j=0;j<N;j++){
            dp[N-1][j] = arr[N-1][j];
        }

        int recurse = recurse(0, 0);
        System.out.println(recurse);
    }

    private static int recurse(int depth, int index) {
        if(depth == N-1){
            return dp[depth][index];
        }

        if(dp[depth][index] != 0){
            return dp[depth][index];
        }

        return dp[depth][index] = Math.max(recurse(depth+1,index),recurse(depth+1,index+1)) + arr[depth][index];
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
