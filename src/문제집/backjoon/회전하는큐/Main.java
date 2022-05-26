package 문제집.backjoon.회전하는큐;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * date: 22.03.09
 */

public class Main {
    static int N,M;
    static int[] sequence;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/백준51제/자료구조/회전하는큐/input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        LinkedList<Integer> queue = new LinkedList<>();
        sequence = new int[M];

        for(int i=0;i<M;i++){
            sequence[i] = sc.nextInt();
        }

        for(int i=1;i<=N;i++){
            queue.offer(i);
        }

        int cnt=0;

        for(int seq : sequence){
            int index = queue.indexOf(seq);
            int size = queue.size();

            int straight = index;
            int reverse  = size - index;

            if(straight <= reverse){
                while(index-->0){
                    queue.offer(queue.pollFirst());
                    cnt++;
                }
            }else{
                while(reverse-->0){
                    queue.offerFirst(queue.pollLast());
                    cnt++;
                }
            }
            queue.pollFirst();
        }
        System.out.println(cnt);
    }
}
