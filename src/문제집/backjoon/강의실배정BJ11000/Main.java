package 문제집.backjoon.강의실배정BJ11000;

/**
 * date: 22.07.12
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/강의실배정BJ11000/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }
        Comparator<int[]> comp = (o1, o2) -> {
            int s1 = o1[0];
            int s2 = o2[0];
            return Integer.compare(s1,s2);
        };

        Arrays.sort(arr,comp);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = 1 ;
        pq.offer(arr[0][1]);
        for(int i=1;i<N;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            while(!pq.isEmpty() && start >= pq.peek()){
                pq.poll();
            }
            pq.offer(end);
            max = Math.max(max,pq.size());
        }
        System.out.println(max);
    }

    private static void print() {
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
