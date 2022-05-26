package 문제집.backjoon.N번째큰수;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * date :22.03.11
 * 시간초과
 */

public class MainV2 {
    static int N;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/N번째큰수/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N*N;i++){
            pq.offer(sc.nextInt());
        }

        for(int i=0;i<N-1;i++){
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
