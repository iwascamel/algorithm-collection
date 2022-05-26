package 문제집.backjoon.요세푸스문제;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * date: 22.03.10
 */

public class Main {
    static int N,K;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/backjoon/요세푸스문제/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=N;i++) queue.offer(i);
        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            int k = K;
            while(k-->1){
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int n : list){
            sb.append(n);
            sb.append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}
