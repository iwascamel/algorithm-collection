package 문제집.backjoon.바이러스;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * date : 22.03.30
 */

public class Main {
    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/바이러스/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        int answer = 0;
        for(int i=2;i<N+1;i++){
            if(visited[i]) answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int target) {
        if(visited[target]) return;

        visited[target] = true;

        for(int connect : list[target]){
            if(visited[connect]) continue;
            dfs(connect);
        }
    }
}
