package 문제집.backjoon.DFS와BFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class MainV2UsingArray {

    static int N, L, start;

    static int[][] graph;
    static boolean[] v;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/DFS와BFS/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        start = sc.nextInt();

        graph = new int[N+1][N+1];
        v = new boolean[N+1];

        for (int i = 0; i < L; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        dfs(start,new boolean[N+1]);
        System.out.println();
        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        v[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + " ");

            for(int j=1;j<N+1;j++){
                if(graph[current][j] == 1 && !v[j]){
                    queue.offer(j);
                    v[j] = true;
                }
            }

        }
    }

    static void dfs(int current,boolean[] visited){
        System.out.print(current+ " ");
        visited[current] = true;

        for(int j=1;j<N+1;j++){
            if(graph[current][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(j,visited);
            }
        }
    }
}
