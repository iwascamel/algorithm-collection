package 문제집.backjoon.모두의마블;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * date: 22.06.23
 */

public class Main {
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/모두의마블/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int max = pq.poll();
        int sum = 0;
        while(!pq.isEmpty()){
            sum += max + pq.poll();
        }
        System.out.println(sum);
    }
}
