package 문제집.backjoon.AC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * date: 22.05.31
 */

public class MainV2 {
    static int T;
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/AC/input2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        out: for(int t=0;t<T;t++){
            deque = new LinkedList<>();

            String rule = br.readLine();
            int N = Integer.parseInt(br.readLine());

            String s = br.readLine();

            for(int i=1;i<s.length(); i+=2){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    deque.offer(s.charAt(i) - '0');
                }
            }
            boolean dir = true;
            for(int i=0;i<rule.length();i++){
                char c = rule.charAt(i);
                if(c=='R'){
                    dir = !dir;
                }else{
                    if(deque.isEmpty()){
                        System.out.println("error");
                        continue out;
                    }else{
                        if(dir){
                            deque.poll();
                        }else{
                            deque.pollLast();
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(!deque.isEmpty()){
                if(dir){
                    sb.append(deque.poll());
                }else{
                    sb.append(deque.pollLast());
                }
                if(!deque.isEmpty()){
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
