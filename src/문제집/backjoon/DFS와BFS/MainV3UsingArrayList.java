package 문제집.backjoon.DFS와BFS;

import java.io.*;
import java.util.*;

public class MainV3UsingArrayList {

    static int N, L, start;

    static ArrayList<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/DFS와BFS/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        start = sc.nextInt();

        graph = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();
        }
        v = new boolean[N+1];

        for (int i = 0; i < L; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph[from].add(to);
            graph[to].add(from);
        }
        for(int i=1;i<N+1;i++){
            Collections.sort(graph[i]);
        }

        dfs(start,new boolean[N+1]);
        System.out.println();
        bfs(new boolean[N+1]);
    }

    static void bfs(boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + " ");
            int size= graph[current].size();
            for(int j=0;j<size;j++){
                int num = graph[current].get(j);
                if(!visited[num]){
                    queue.offer(num);
                    visited[num] = true;
                }
            }
        }
    }


    static void dfs(int current,boolean[] visited){
        System.out.print(current+ " ");
        visited[current] = true;
        int size = graph[current].size();
        // N+1개를 선언했지만,관계 없다. 헷갈리지 말자
        for(int j=0;j<size;j++){
            int num = graph[current].get(j);
            if(!visited[num]){
//                visited[j] = true;       <---- 이거 때문에 틀렸었다.
                dfs(num,visited);
            }
        }
    }
}
