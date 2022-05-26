package 문제집.backjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

// 빈정원
public class MainV3Other {

    static int N, M, V, L, start;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Integer>[] graph;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/backjoon/DFS와BFS/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adjList[i]);
        }

//        Scanner sc = new Scanner(System.in);
//
//        N = sc.nextInt();
//        L = sc.nextInt();
//        start = sc.nextInt();
//
//        graph = new ArrayList[N+1];
//
//        for(int i=1;i<N+1;i++){
//            graph[i] = new ArrayList<Integer>();
//        }
//
//        for (int i = 0; i < L; i++) {
//            int from = sc.nextInt();
//            int to = sc.nextInt();
//
//            graph[from].add(to);
//            graph[to].add(from);
//        }
//        for(int i=1;i<N+1;i++){
//            Collections.sort(graph[i]);
//        }


        dfs2(V, new boolean[N + 1]);
        System.out.println();
        bfs2(new boolean[N + 1]);
    }

    static void bfs2(boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + " ");
            int size = adjList[current].size();
            for (int j = 0; j < size; j++) {
                int num = adjList[current].get(j);
                if (!visited[num]) {
                    queue.offer(num);
                    visited[num] = true;
                }
            }
        }
    }

    static void dfs2(int current, boolean[] visited) {
        System.out.print(current + " ");
        visited[current] = true;
        int size = adjList[current].size();
        for (int j = 0; j < size; j++) {
            int num = adjList[current].get(j);
            if (!visited[num]) {
                dfs2(num, visited);
            }
        }
    }

    private static void dfs(int cur, boolean[] v) {
        v[cur] = true;
        System.out.print(cur + " ");
        int len = adjList[cur].size();
        for (int i = 0; i < len; i++) {
            int nxt = adjList[cur].get(i);
            if (!v[nxt])
                dfs(adjList[cur].get(i), v);
        }
    }

    private static void bfs(boolean[] v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        v[V] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            int len = adjList[cur].size();
            for (int i = 0; i < len; i++) {
                int nxt = adjList[cur].get(i);
                if (!v[nxt]) {
                    q.add(nxt);
                    v[nxt] = true;
                }
            }
        }
    }

}
