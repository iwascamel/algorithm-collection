package 문제집.backjoon.최소값찾기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * date: 22.03.23
 */

public class Main {
    static int N;
    static int L;
    static int[] arr;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/최소값찾기/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<N+1;i++){
            arr[i] = sc.nextInt();
        }

        int[] resultArr = new int[N+1];

        for(int i=1;i<N+1;i++){
            if(i+1-L > 1){
              pq.remove(arr[i-L]);
            }
            pq.offer(arr[i]);

            resultArr[i] = pq.peek();
        }

        for(int i=1;i<N+1;i++){
            System.out.print(resultArr[i] + " ");
        }
    }
}
