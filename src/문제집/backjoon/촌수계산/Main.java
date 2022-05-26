package 문제집.backjoon.촌수계산;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * date:22.03.31
 */

public class Main {
    static int N;
    static int start,end;
    static int M;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int answer=-1;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/촌수계산/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();

        M = sc.nextInt();
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        bfs(start);
        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            int target = poll[0];
            int cnt = poll[1];

            if(target == end){
                answer = cnt;
                break;
            }

            for(int n : list[target]){
                if(visited[n]) continue;
                queue.offer(new int[]{n,cnt+1});
                visited[n] = true;
            }
        }
    }
}
