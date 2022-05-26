package 문제집.backjoon.DFS와BFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MainUsingNodeFail {

    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", next=" + next +
                    '}';
        }
    }

    static int N, L, start;

    static Node[] adjList;
    static boolean[] v;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/DFS와BFS/input.txt"));

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        start = sc.nextInt();

        adjList = new Node[N+1];
        v = new boolean[N+1];

        for (int i = 0; i < L; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }

        dfs(start,new boolean[N+1]);
        System.out.println();
        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new PriorityQueue<>();

        queue.offer(start);
        v[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + " ");

            Node node = adjList[current];

            while (node != null) {
                if (!v[node.vertex]) {
                    queue.offer(node.vertex);
                    v[node.vertex] = true;
                }
                node = node.next;
            }
        }
    }

    static void dfs(int current,boolean[] visited){
        System.out.print(current+ " ");
        visited[current] = true;

        Node node = adjList[current];

        while(node!=null){
            if(!visited[node.vertex]){
                dfs(node.vertex,visited);
            }
            node=node.next;
        }
    }
}
