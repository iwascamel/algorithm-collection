package 문제집.backjoon.구슬찾기;

import java.util.ArrayList;
import java.util.Scanner;

/*
https://vanillacreamdonut.tistory.com/130
 */

public class MainV2 {

    static boolean[] visit;
    static int[][] dp = new int[100][2];
    static ArrayList<Integer>[] list;

    static void DFS(int current, int start) {

        visit[current] = true;

        for(int next : list[current])
            if(!visit[next]) {
                dp[start][0]++; //0 : 나보다 가벼운 것
                dp[next][1]++;//1 : 나보다 무거운 것
                DFS(next, start);
            }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        list = new ArrayList[100];
        int half = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int heavy = scan.nextInt();
            int light = scan.nextInt();

            list[heavy].add(light);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[100];
            //깊이우선탐색할때마다, 내려감
            DFS(i, i);
        }

        int result = 0;
        for (int i = 1; i <= n; i++)
            if (dp[i][0] >= half || dp[i][1] >= half)
                result++;

        System.out.println(result);
        scan.close();
    }
}