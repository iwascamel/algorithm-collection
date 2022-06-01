package 문제집.backjoon.AC;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * date: 22.05.31
 */

public class Main {
    static int T;
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/문제집/backjoon/AC/input.txt"));
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

            for(int i=0;i<rule.length();i++){
                char c = rule.charAt(i);
                int size = deque.size();
                if(c=='R'){
                    Stack<Integer> stack = new Stack<>();
                    while(size-->0){
                        stack.add(deque.poll());
                    }
                    while(!stack.isEmpty()) {
                        deque.offer(stack.pop());
                    }
                }else{
                    if(deque.isEmpty()){
                        System.out.println("error");
                        continue out;
                    }
                    deque.poll();
                }
            }
            System.out.println(deque);
        }
    }
}
