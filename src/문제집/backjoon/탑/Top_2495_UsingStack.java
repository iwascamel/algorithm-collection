package 문제집.backjoon.탑;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top_2495_UsingStack {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/backjoon/탑/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input," ");

        Stack<int[]> stack = new Stack<>();


        for(int i=1;i<=N;i++){
            int IN = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[1] < IN){
                    stack.pop();
                }else{
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }
            if(stack.isEmpty()){
                System.out.print(0 + " ");
            }
            stack.push(new int[]{i,IN});
        }
    }
}
