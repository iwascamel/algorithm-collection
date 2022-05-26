package 문제집.backjoon.오큰수;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * date: 22.04.19
 */

public class Main {
    static int N;
    static int[] res;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/backjoon/오큰수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> cStack = new Stack<>();
        res = new int[N];

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            stack.push(num);
        }
        int p = N-1;
        while(p>=0){
            int pop = stack.pop();

            if(cStack.isEmpty()){
                res[p] = -1;
                cStack.push(pop);
            }else{
                while(!cStack.isEmpty() && pop >= cStack.peek()){
                    cStack.pop();
                }
                if(cStack.isEmpty()){
                    res[p] = -1;
                }else{
                    res[p] = cStack.peek();
                }
            }
            cStack.push(pop);
            p--;
        }
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i : res){
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
