package 문제집.backjoon.이중우선순위큐BJ7662;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * date: 22.08.15
 * memo: timeout
 */

public class MainV2 {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/이중우선순위큐BJ7662/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            StringTokenizer st;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

//                System.out.println("maxPq = " + maxPq);
//                System.out.println("minPq = " + minPq);
//                System.out.println("op = " + op);
//                System.out.println("num = " + num);
//                System.out.println("----------");
                if(op == 'I'){
                    minPq.offer(num);
                    maxPq.offer(num);
                }else{
                    if(num == 1 && !maxPq.isEmpty()){
                        int poll = maxPq.poll();
                        minPq.remove(poll);
                    }else if(num == -1 && !minPq.isEmpty()){
                        int poll = minPq.poll();
                        maxPq.remove(poll);
                    }
                }
            }
            if(minPq.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(maxPq.poll() + " " + minPq.poll());
            }
        }
    }
}
