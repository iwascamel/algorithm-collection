package 문제집.backjoon.풍선터트리기;

import java.io.*;
import java.util.*;

/**
 * 25.05.10
 * 양방향 큐를 이용해서 앞뒤로 순서를 왔다갔다 할 수 있느냐를 물어보는 문제
 * 양수의 경우 뽑는 자리(pollFirst())가 자동으로 세팅돼서 -1을 해주어야 하나, 음수의 경우 pollFirst()로 자리를 위치시켜주어야 하므로 +1을 해줄 필요가 없는 것이 포인트
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/풍선터트리기/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> queue = new ArrayDeque<>();

        for(int i=0;i<size;i++){
            queue.offer(
                    new Balloon(
                            i+1,
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        StringBuilder sb = new StringBuilder();
        Balloon target = queue.pollFirst();
        sb.append(target.order);
        sb.append(" ");

        int degree = calculateDegree(target.degree);

        while(!queue.isEmpty()){
            while(degree != 0){
                if(degree > 0){
                    Balloon poll = queue.pollFirst();
                    queue.addLast(poll);
                    degree--;
                }else{
                    Balloon poll = queue.pollLast();
                    queue.addFirst(poll);
                    degree++;
                }
            }
            Balloon balloon = queue.pollFirst();
            sb.append(balloon.order);
            sb.append(" ");
            degree = calculateDegree(balloon.degree);
        }
        System.out.println(sb);
    }

    static int calculateDegree(int degree){
        if(degree>0){
            return degree - 1;
        }else{
            return degree;
        }
    }

    static class Balloon{
        int order;
        int degree;

        public Balloon(
                int order,
                int degree
        ){
            this.order = order;
            this.degree = degree;
        }
    }
}
