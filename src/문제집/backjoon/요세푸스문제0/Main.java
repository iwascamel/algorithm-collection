package 문제집.backjoon.요세푸스문제0;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<N+1;i++){
            queue.offer(i);
        }
        int cnt=0;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            cnt++;
            if(cnt==K){
                list.add(poll);
                cnt=0;
            }else{
                queue.offer(poll);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        for(int i : list){
            sb.append(i);
            sb.append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(">");

        System.out.println(sb);
    }
}
