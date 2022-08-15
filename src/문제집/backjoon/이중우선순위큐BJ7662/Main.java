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

public class Main {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/이중우선순위큐BJ7662/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            boolean isGetMin = true;
            StringTokenizer st;
            for(int i=0;i<N;i++){

                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

//                System.out.println("pq = " + pq);
//                System.out.println("isGetMin = " + isGetMin);
//                System.out.println("op = " + op);
//                System.out.println("num = " + num);
//                System.out.println("------------");

                if(op == 'I'){
                    pq.offer(num);
                }else{
                    // 최대값을 구하려고 할 때
                    if(num == 1){
                        // 최소값 설정이면
                        if(isGetMin){
                            if(!pq.isEmpty()){
                                PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
                                pq.forEach(temp::offer);
                                temp.poll();
                                pq = temp;
                                isGetMin = false;
                            }
                        }else{
                            if(!pq.isEmpty()){
                                pq.poll();
                            }
                        }
                    }else{
                        // 최소값을 구하려고 할 때
                        if(isGetMin){
                            if(!pq.isEmpty()){
                                pq.poll();
                            }
                        }else{
                            if(!pq.isEmpty()){
                                PriorityQueue<Integer> temp = new PriorityQueue<>();
                                pq.forEach(temp::offer);
                                temp.poll();
                                pq = temp;
                                isGetMin = true;
                            }
                        }
                    }
                }
            }
            if(pq.isEmpty()){
                System.out.println("EMPTY");
            }else{
                PriorityQueue<Integer> temp;
                if(isGetMin){
                    temp = new PriorityQueue<>(Collections.reverseOrder());
                }else{
                    temp = new PriorityQueue<>();
                }
                pq.forEach(temp::offer);

                if(isGetMin){
                    System.out.println(temp.poll() + " " + pq.poll());
                }else{
                    System.out.println(pq.poll() + " " + temp.poll());
                }
            }
        }
    }
}
